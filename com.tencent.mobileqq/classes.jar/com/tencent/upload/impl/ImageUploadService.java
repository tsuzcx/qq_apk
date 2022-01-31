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
    UploadLog.d("ImageUploadService", "compressUploadTask[flowId: " + paramInt + ", path: " + paramString1 + ", md5: " + paramString2 + ", targetSize: " + paramUploadImageSize + ", autoRotate: " + paramBoolean1 + ", compressToWebp: " + paramBoolean2 + "]");
    paramString1 = new ImageCompressRecord(paramInt, paramString1, paramString2, paramUploadImageSize, paramBoolean1, paramBoolean2);
    this.mCompressServiceProxy.compressFile(paramString1, this.mImageProcessorCallback);
    return true;
  }
  
  private boolean compressUploadTask(AbstractUploadTask paramAbstractUploadTask)
  {
    Object localObject = paramAbstractUploadTask.getFilePath();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!new File((String)localObject).exists()))
    {
      paramAbstractUploadTask.onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
      UploadLog.e("ImageUploadService", "upload error path invalid !");
      return false;
    }
    if (ImageCompressor.isGifPicture((String)localObject))
    {
      ImageCompressor.processGif(paramAbstractUploadTask);
      this.mTaskManager.sendAsync(paramAbstractUploadTask);
      return false;
    }
    boolean bool1;
    int i;
    if ((paramAbstractUploadTask instanceof ImageUploadTask))
    {
      bool1 = ((ImageUploadTask)paramAbstractUploadTask).autoRotate;
      i = ((ImageUploadTask)paramAbstractUploadTask).iUploadType;
    }
    for (;;)
    {
      IUploadConfig.UploadImageSize localUploadImageSize = ImageCompressor.getUploadImageSize(paramAbstractUploadTask, i);
      if (localUploadImageSize == null) {
        break;
      }
      paramAbstractUploadTask.md5 = FileUtils.getMd5ByFile_REAL(new File((String)localObject));
      localObject = paramAbstractUploadTask.getUploadTaskType();
      int j;
      if ((localObject != null) && (((TaskTypeConfig)localObject).uploadType == 0))
      {
        j = 1;
        localObject = UploadGlobalConfig.getConfig();
        if ((j == 0) || (!Utility.needCompress2Webp(((IUploadConfig)localObject).getCompressToWebpFlag(), i))) {
          break label221;
        }
      }
      label221:
      for (boolean bool2 = true;; bool2 = false)
      {
        if ((paramAbstractUploadTask instanceof ImageUploadTask)) {
          ((ImageUploadTask)paramAbstractUploadTask).compressStartTime = System.currentTimeMillis();
        }
        return compressUploadTask(paramAbstractUploadTask.flowId, paramAbstractUploadTask.getFilePath(), paramAbstractUploadTask.getMd5(), localUploadImageSize, bool1, bool2);
        j = 0;
        break;
      }
      i = 0;
      bool1 = false;
    }
  }
  
  private boolean driveNextBatch()
  {
    int i = 0;
    boolean bool = false;
    for (;;)
    {
      try
      {
        UploadLog.d("ImageUploadService", "driveNext -- ");
        int j = this.mReadyTasks.size();
        if (j <= 0) {
          return bool;
        }
        j = getBatchControlNumber();
        UploadLog.d("ImageUploadService", "ready:" + this.mReadyTasks.size() + " compressing:" + this.mCompressingTasks.size() + " batchMaxNum:" + j);
        ArrayList localArrayList = new ArrayList();
        if (this.mReadyTasks.size() >= j)
        {
          if (i < j)
          {
            localArrayList.add(this.mReadyTasks.get(i));
            i += 1;
            continue;
          }
        }
        else {
          localArrayList.addAll(this.mReadyTasks);
        }
        this.mReadyTasks.removeAll(localArrayList);
        i = sBatchIdGenerator.incrementAndGet();
        Iterator localIterator = localArrayList.iterator();
        if (localIterator.hasNext())
        {
          AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
          if (localAbstractUploadTask == null) {
            continue;
          }
          localAbstractUploadTask.setBatchId(i);
          continue;
        }
        localBatchControlTask = new BatchControlTask(localList, this.mTaskManager);
      }
      finally {}
      BatchControlTask localBatchControlTask;
      localBatchControlTask.setBatchId(i);
      this.mTaskManager.sendAsync(localBatchControlTask);
      UploadLog.d("ImageUploadService", "driveNext end -- send taskId:" + localBatchControlTask.getTaskId() + " batchId:" + i + " contain:" + localBatchControlTask.printAllTaskInBatchControl());
      bool = true;
    }
  }
  
  private void sendTask(AbstractUploadTask paramAbstractUploadTask)
  {
    if ((paramAbstractUploadTask instanceof ImageUploadTask))
    {
      UploadLog.w("ImageUploadService", "sendTask add task to queue: " + paramAbstractUploadTask.flowId);
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
    UploadLog.w("ImageUploadService", "cancel task flowId: " + paramAbstractUploadTask.flowId + ", path:" + paramAbstractUploadTask.uploadFilePath);
    if (this.mCompressingTasks.get(paramAbstractUploadTask.flowId) != null)
    {
      this.mCompressServiceProxy.cancel(paramAbstractUploadTask.flowId);
      this.mCompressingTasks.remove(paramAbstractUploadTask.flowId);
      UploadLog.w("ImageUploadService", "cancel task from compress queue! flowId:" + paramAbstractUploadTask.flowId + ", path:" + paramAbstractUploadTask.uploadFilePath);
      i = 1;
    }
    label250:
    for (;;)
    {
      if (i == 0) {
        this.mTaskManager.cancelTask(paramAbstractUploadTask);
      }
      driveNextBatch();
      return true;
      Iterator localIterator = this.mReadyTasks.iterator();
      AbstractUploadTask localAbstractUploadTask;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
      } while (localAbstractUploadTask.flowId != paramAbstractUploadTask.flowId);
      for (;;)
      {
        if (localAbstractUploadTask == null) {
          break label250;
        }
        this.mReadyTasks.remove(localAbstractUploadTask);
        UploadLog.w("ImageUploadService", "cancel task from ready queue! flowId:" + paramAbstractUploadTask.flowId + ", path:" + paramAbstractUploadTask.uploadFilePath);
        i = 1;
        break;
        localAbstractUploadTask = null;
      }
    }
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
    UploadLog.d("ImageUploadService", "kill compress process Pid:" + this.mCompressServicePid);
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
    int i;
    if ((paramAbstractUploadTask instanceof ImageUploadTask)) {
      if (((ImageUploadTask)paramAbstractUploadTask).iUploadType != 3)
      {
        i = 1;
        paramAbstractUploadTask.keepTmpFile(UploadGlobalConfig.needKeepImageTmpFile());
      }
    }
    for (;;)
    {
      SparseArray localSparseArray = this.mCompressingTasks;
      if (i != 0) {
        try
        {
          if (UploadConfiguration.isPictureNeedToCompress(paramAbstractUploadTask.getFilePath()))
          {
            if (compressUploadTask(paramAbstractUploadTask)) {
              this.mCompressingTasks.append(paramAbstractUploadTask.flowId, paramAbstractUploadTask);
            }
            return true;
          }
        }
        finally {}
      }
      sendTask(paramAbstractUploadTask);
      return true;
      i = 0;
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.impl.ImageUploadService
 * JD-Core Version:    0.7.0.1
 */