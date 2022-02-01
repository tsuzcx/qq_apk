package com.tencent.upload.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.image.ImageCompressRecord;
import com.tencent.upload.image.ImageProcessProxy;
import com.tencent.upload.image.ImageProcessProxy.ImageCompressorCallback;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.Utility;
import com.tencent.upload.uinterface.data.BatchControlTask;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.ThreadPool;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ImageUploadService
  extends BaseUploadService
{
  private static final String TAG = "ImageUploadService";
  private static final int WHAT_START_ASYNC_SEND = 1000;
  private static final AtomicInteger sBatchIdGenerator = new AtomicInteger(10000);
  private int mCompressServicePid = 0;
  private ImageProcessProxy mCompressServiceProxy;
  private SparseArray<AbstractUploadTask> mCompressingTasks;
  private Handler mHandler;
  ImageProcessProxy.ImageCompressorCallback mImageProcessorCallback = new ImageUploadService.2(this);
  private CopyOnWriteArrayList<AbstractUploadTask> mReadyTasks;
  
  public ImageUploadService(ThreadPool paramThreadPool)
  {
    super(paramThreadPool);
    this.mTaskManager = new UploadTaskManager(paramThreadPool, getParallelFileNumber());
    this.mCompressingTasks = new SparseArray();
    this.mReadyTasks = new CopyOnWriteArrayList();
    this.mCompressServiceProxy = ImageProcessProxy.getInstance();
    paramThreadPool = new HandlerThread("image-upload-service");
    paramThreadPool.start();
    this.mHandler = new Handler(paramThreadPool.getLooper());
  }
  
  private final boolean compressUploadTask(int paramInt, String paramString1, String paramString2, IUploadConfig.UploadImageSize paramUploadImageSize, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compressUploadTask[flowId: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", path: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", md5: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", targetSize: ");
    localStringBuilder.append(paramUploadImageSize);
    localStringBuilder.append(", autoRotate: ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", compressToWebp: ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("]");
    UploadLog.d("ImageUploadService", localStringBuilder.toString());
    paramString1 = new ImageCompressRecord(paramInt, paramString1, paramString2, paramUploadImageSize, paramBoolean1, paramBoolean2);
    this.mCompressServiceProxy.compressFile(paramString1, this.mImageProcessorCallback);
    return true;
  }
  
  private boolean compressUploadTask(AbstractUploadTask paramAbstractUploadTask)
  {
    Object localObject2 = paramAbstractUploadTask.getFilePath();
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject2);
    boolean bool2 = false;
    if ((!bool1) && (new File((String)localObject2).exists()))
    {
      if (ImageCompressor.isGifPicture((String)localObject2))
      {
        ImageCompressor.processGif(paramAbstractUploadTask);
        this.mTaskManager.sendAsync(paramAbstractUploadTask);
        return false;
      }
      boolean bool3 = paramAbstractUploadTask instanceof ImageUploadTask;
      int i;
      if (bool3)
      {
        localObject1 = (ImageUploadTask)paramAbstractUploadTask;
        bool1 = ((ImageUploadTask)localObject1).autoRotate;
        i = ((ImageUploadTask)localObject1).iUploadType;
      }
      else
      {
        i = 0;
        bool1 = false;
      }
      Object localObject1 = ImageCompressor.getUploadImageSize(paramAbstractUploadTask, i);
      if (localObject1 != null)
      {
        paramAbstractUploadTask.mTargetSize = ((IUploadConfig.UploadImageSize)localObject1);
        paramAbstractUploadTask.md5 = FileUtils.getMd5ByFile_REAL(new File((String)localObject2));
        localObject2 = paramAbstractUploadTask.getUploadTaskType();
        int j;
        if ((localObject2 != null) && (((TaskTypeConfig)localObject2).uploadType == 0)) {
          j = 1;
        } else {
          j = 0;
        }
        localObject2 = UploadGlobalConfig.getConfig();
        if ((j != 0) && (Utility.needCompress2Webp(((IUploadConfig)localObject2).getCompressToWebpFlag(), i))) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (bool3) {
          ((ImageUploadTask)paramAbstractUploadTask).compressStartTime = System.currentTimeMillis();
        }
        bool2 = compressUploadTask(paramAbstractUploadTask.flowId, paramAbstractUploadTask.getFilePath(), paramAbstractUploadTask.getMd5(), (IUploadConfig.UploadImageSize)localObject1, bool1, bool2);
      }
      return bool2;
    }
    paramAbstractUploadTask.onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
    UploadLog.e("ImageUploadService", "upload error path invalid !");
    return false;
  }
  
  private boolean driveNextBatch()
  {
    try
    {
      UploadLog.d("ImageUploadService", "driveNext -- ");
      int j = this.mReadyTasks.size();
      int i = 0;
      if (j <= 0) {
        return false;
      }
      j = getBatchControlNumber();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ready:");
      ((StringBuilder)localObject1).append(this.mReadyTasks.size());
      ((StringBuilder)localObject1).append(" compressing:");
      ((StringBuilder)localObject1).append(this.mCompressingTasks.size());
      ((StringBuilder)localObject1).append(" batchMaxNum:");
      ((StringBuilder)localObject1).append(j);
      UploadLog.d("ImageUploadService", ((StringBuilder)localObject1).toString());
      localObject1 = new ArrayList();
      if (this.mReadyTasks.size() >= j) {
        while (i < j)
        {
          ((List)localObject1).add(this.mReadyTasks.get(i));
          i += 1;
        }
      }
      ((List)localObject1).addAll(this.mReadyTasks);
      this.mReadyTasks.removeAll((Collection)localObject1);
      i = sBatchIdGenerator.incrementAndGet();
      Object localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)((Iterator)localObject3).next();
        if (localAbstractUploadTask != null) {
          localAbstractUploadTask.setBatchId(i);
        }
      }
      localObject1 = new BatchControlTask((List)localObject1, this.mTaskManager);
      ((BatchControlTask)localObject1).setBatchId(i);
      this.mTaskManager.sendAsync((AbstractUploadTask)localObject1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("driveNext end -- send taskId:");
      ((StringBuilder)localObject3).append(((BatchControlTask)localObject1).getTaskId());
      ((StringBuilder)localObject3).append(" batchId:");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(" contain:");
      ((StringBuilder)localObject3).append(((BatchControlTask)localObject1).printAllTaskInBatchControl());
      UploadLog.d("ImageUploadService", ((StringBuilder)localObject3).toString());
      return true;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void sendTask(AbstractUploadTask paramAbstractUploadTask)
  {
    if ((paramAbstractUploadTask instanceof ImageUploadTask))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendTask add task to queue: ");
      localStringBuilder.append(paramAbstractUploadTask.flowId);
      UploadLog.w("ImageUploadService", localStringBuilder.toString());
      this.mHandler.removeMessages(1000);
      this.mReadyTasks.add(paramAbstractUploadTask);
      paramAbstractUploadTask = Message.obtain(this.mHandler, new ImageUploadService.1(this));
      paramAbstractUploadTask.what = 1000;
      this.mHandler.sendMessageDelayed(paramAbstractUploadTask, 100L);
      return;
    }
    this.mTaskManager.sendAsync(paramAbstractUploadTask);
  }
  
  protected boolean cancel(AbstractUploadTask paramAbstractUploadTask)
  {
    int i = 0;
    if (paramAbstractUploadTask == null) {
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("cancel task flowId: ");
    ((StringBuilder)localObject1).append(paramAbstractUploadTask.flowId);
    ((StringBuilder)localObject1).append(", path:");
    ((StringBuilder)localObject1).append(paramAbstractUploadTask.uploadFilePath);
    UploadLog.w("ImageUploadService", ((StringBuilder)localObject1).toString());
    if (this.mCompressingTasks.get(paramAbstractUploadTask.flowId) != null)
    {
      this.mCompressServiceProxy.cancel(paramAbstractUploadTask.flowId);
      this.mCompressingTasks.remove(paramAbstractUploadTask.flowId);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cancel task from compress queue! flowId:");
      ((StringBuilder)localObject1).append(paramAbstractUploadTask.flowId);
      ((StringBuilder)localObject1).append(", path:");
      ((StringBuilder)localObject1).append(paramAbstractUploadTask.uploadFilePath);
      UploadLog.w("ImageUploadService", ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      i = 1;
      break;
      Object localObject2 = null;
      Iterator localIterator = this.mReadyTasks.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AbstractUploadTask)localIterator.next();
      } while (((AbstractUploadTask)localObject1).flowId != paramAbstractUploadTask.flowId);
      if (localObject1 == null) {
        break;
      }
      this.mReadyTasks.remove(localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cancel task from ready queue! flowId:");
      ((StringBuilder)localObject1).append(paramAbstractUploadTask.flowId);
      ((StringBuilder)localObject1).append(", path:");
      ((StringBuilder)localObject1).append(paramAbstractUploadTask.uploadFilePath);
      UploadLog.w("ImageUploadService", ((StringBuilder)localObject1).toString());
    }
    if (i == 0) {
      this.mTaskManager.cancelTask(paramAbstractUploadTask);
    }
    driveNextBatch();
    return true;
  }
  
  protected void cancelAllTasks()
  {
    this.mTaskManager.cancelAllTasks();
    this.mCompressingTasks.clear();
    this.mReadyTasks.clear();
  }
  
  protected void close()
  {
    this.mTaskManager.close();
    closeCompressProcess();
  }
  
  public void closeCompressProcess()
  {
    if (this.mCompressServicePid == 0) {
      return;
    }
    ImageProcessProxy.close();
    Process.killProcess(this.mCompressServicePid);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kill compress process Pid:");
    localStringBuilder.append(this.mCompressServicePid);
    UploadLog.d("ImageUploadService", localStringBuilder.toString());
    this.mCompressServicePid = 0;
  }
  
  protected boolean isUploadIdle()
  {
    return (this.mCompressingTasks.size() == 0) && (this.mTaskManager.getRemainTaskSize() == 0) && (this.mReadyTasks.size() == 0);
  }
  
  protected boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null)
    {
      UploadLog.e("ImageUploadService", "upload task == null !");
      return false;
    }
    paramAbstractUploadTask.onUploadProcessStart();
    boolean bool;
    if ((paramAbstractUploadTask instanceof ImageUploadTask))
    {
      if (((ImageUploadTask)paramAbstractUploadTask).iUploadType != 3) {
        bool = true;
      } else {
        bool = false;
      }
      paramAbstractUploadTask.keepTmpFile(UploadGlobalConfig.needKeepImageTmpFile());
    }
    else
    {
      bool = false;
    }
    SparseArray localSparseArray = this.mCompressingTasks;
    if (bool) {}
    try
    {
      if (UploadConfiguration.isPictureNeedToCompress(paramAbstractUploadTask.getFilePath()))
      {
        if (compressUploadTask(paramAbstractUploadTask))
        {
          paramAbstractUploadTask.needCompress = true;
          this.mCompressingTasks.append(paramAbstractUploadTask.flowId, paramAbstractUploadTask);
        }
        else
        {
          paramAbstractUploadTask.needCompress = false;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("upload task: ");
          localStringBuilder.append(paramAbstractUploadTask.flowId);
          localStringBuilder.append(" compressUploadTask == false");
          UploadLog.w("ImageUploadService", localStringBuilder.toString());
        }
        return true;
      }
      paramAbstractUploadTask.needCompress = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("upload task: ");
      localStringBuilder.append(paramAbstractUploadTask.flowId);
      localStringBuilder.append(" is not need compress | needCompress:");
      localStringBuilder.append(bool);
      UploadLog.w("ImageUploadService", localStringBuilder.toString());
      sendTask(paramAbstractUploadTask);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.impl.ImageUploadService
 * JD-Core Version:    0.7.0.1
 */