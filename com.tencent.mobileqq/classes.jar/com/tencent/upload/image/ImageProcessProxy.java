package com.tencent.upload.image;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.util.concurrent.LinkedBlockingQueue;

public class ImageProcessProxy
{
  private static final String TAG = "ImageProcessProxy";
  private static volatile ImageProcessProxy sProxy;
  protected static final int sfWaitBindTime = 10000;
  volatile boolean mBound;
  private final ServiceConnection mConnection = new ImageProcessProxy.1(this);
  private Context mContext = UploadGlobalConfig.getContext();
  private final ImageProcessProxy.IncomingHandler mIncomingHandler = new ImageProcessProxy.IncomingHandler(this);
  private byte[] mLock = new byte[0];
  private final Messenger mMessenger = new Messenger(this.mIncomingHandler);
  private final LinkedBlockingQueue<ImageCompressRecord> mPendingRecords = new LinkedBlockingQueue();
  ImageProcessProxy.ImageCompressorCallback mProcessCallback;
  private final SparseArray<ImageCompressRecord> mRecordMap = new SparseArray();
  Messenger mService = null;
  private volatile boolean mServiceBusy = false;
  
  private boolean asyncCopyAndCompressFile(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("send MSG_COPY_AND_COMPRESS_IMAGE_REQUEST mBound = ");
    ((StringBuilder)localObject).append(this.mBound);
    ((StringBuilder)localObject).append(" flowId=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" originalFilePath = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" md5 = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" targetWidth = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" targetHeight = ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(" quality = ");
    ((StringBuilder)localObject).append(paramInt4);
    ((StringBuilder)localObject).append(" autoRotate = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" compressToWebp = ");
    ((StringBuilder)localObject).append(paramBoolean2);
    UploadLog.d("ImageProcessProxy", ((StringBuilder)localObject).toString());
    if (!this.mBound) {
      return false;
    }
    localObject = Message.obtain(null, 1);
    ((Message)localObject).arg1 = paramInt1;
    ((Message)localObject).replyTo = this.mMessenger;
    paramString2 = FileUtils.getTempFilePath(this.mContext, paramString1, paramString2, paramInt1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("targetFile:");
    localStringBuilder.append(paramString2);
    UploadLog.d("ImageProcessProxy", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    ((Message)localObject).getData().putParcelable("KEY_MSG_COMPRESS", new ImageProcessData(paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, null));
    try
    {
      if (this.mService != null)
      {
        this.mService.send((Message)localObject);
        return true;
      }
      UploadLog.e("ImageProcessProxy", "mService == null");
    }
    catch (Exception paramString1)
    {
      UploadLog.w("ImageProcessProxy", "ImageCompressor", paramString1);
    }
    return false;
  }
  
  public static void close()
  {
    UploadLog.d("ImageProcessProxy", "close");
    if (sProxy != null) {
      sProxy.release();
    }
  }
  
  private void finishTask(int paramInt)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ImageProcessProxy finishTask flowId=");
      ((StringBuilder)localObject1).append(paramInt);
      UploadLog.d("ImageProcessProxy", ((StringBuilder)localObject1).toString());
      localObject1 = (ImageCompressRecord)this.mRecordMap.get(paramInt);
      this.mRecordMap.remove(paramInt);
      this.mPendingRecords.remove(localObject1);
      return;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static ImageProcessProxy getInstance()
  {
    if (sProxy == null) {
      try
      {
        if (sProxy == null) {
          sProxy = new ImageProcessProxy();
        }
      }
      finally {}
    }
    return sProxy;
  }
  
  private void next()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("next mServiceBusy = ");
      ((StringBuilder)localObject1).append(this.mServiceBusy);
      ((StringBuilder)localObject1).append(" mBound = ");
      ((StringBuilder)localObject1).append(this.mBound);
      UploadLog.d("ImageProcessProxy", ((StringBuilder)localObject1).toString());
      if (!this.mServiceBusy)
      {
        localObject1 = (ImageCompressRecord)this.mPendingRecords.peek();
        if (localObject1 != null)
        {
          this.mServiceBusy = true;
          if (asyncCopyAndCompressFile(((ImageCompressRecord)localObject1).flowId, ((ImageCompressRecord)localObject1).path, ((ImageCompressRecord)localObject1).md5, ((ImageCompressRecord)localObject1).mSize.width, ((ImageCompressRecord)localObject1).mSize.height, ((ImageCompressRecord)localObject1).mSize.quality, ((ImageCompressRecord)localObject1).autoRotate, ((ImageCompressRecord)localObject1).compressToWebp))
          {
            Message localMessage = Message.obtain(this.mIncomingHandler, 100);
            localMessage.arg1 = ((ImageCompressRecord)localObject1).flowId;
            this.mIncomingHandler.sendMessageDelayed(localMessage, 10000L);
          }
          else
          {
            this.mServiceBusy = false;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private void release()
  {
    UploadLog.d("ImageProcessProxy", "release");
    if (!this.mBound) {
      return;
    }
    this.mBound = false;
    this.mPendingRecords.clear();
    this.mRecordMap.clear();
    this.mContext.unbindService(this.mConnection);
  }
  
  public void cancel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ImageProcessProxy cancel taskId=");
    ((StringBuilder)localObject).append(paramInt);
    UploadLog.d("ImageProcessProxy", ((StringBuilder)localObject).toString());
    localObject = (ImageCompressRecord)this.mRecordMap.get(paramInt);
    if (localObject != null) {
      finishTask(((ImageCompressRecord)localObject).flowId);
    }
    next();
  }
  
  public void compressFile(ImageCompressRecord paramImageCompressRecord)
  {
    try
    {
      if (this.mRecordMap.get(paramImageCompressRecord.flowId) == null)
      {
        this.mPendingRecords.add(paramImageCompressRecord);
        this.mRecordMap.put(paramImageCompressRecord.flowId, paramImageCompressRecord);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mRecordMap has added task :");
        localStringBuilder.append(paramImageCompressRecord.flowId);
        UploadLog.d("ImageProcessProxy", localStringBuilder.toString());
      }
      next();
      return;
    }
    finally {}
  }
  
  public void compressFile(ImageCompressRecord paramImageCompressRecord, ImageProcessProxy.ImageCompressorCallback paramImageCompressorCallback)
  {
    if (!this.mBound) {
      initService();
    }
    this.mProcessCallback = paramImageCompressorCallback;
    compressFile(paramImageCompressRecord);
  }
  
  public boolean initService()
  {
    if (this.mBound) {
      return true;
    }
    UploadLog.v("ImageProcessProxy", "ImageProcessProxy start bindService");
    synchronized (this.mLock)
    {
      Intent localIntent = new Intent(this.mContext, ImageProcessService.class);
      this.mContext.bindService(localIntent, this.mConnection, 1);
    }
    try
    {
      this.mLock.wait(10000L);
      label63:
      ??? = new StringBuilder();
      ((StringBuilder)???).append("ImageProcessProxy end bindService mBound = ");
      ((StringBuilder)???).append(this.mBound);
      UploadLog.v("ImageProcessProxy", ((StringBuilder)???).toString());
      return this.mBound;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessProxy
 * JD-Core Version:    0.7.0.1
 */