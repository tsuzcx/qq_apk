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
    UploadLog.d("ImageProcessProxy", "send MSG_COPY_AND_COMPRESS_IMAGE_REQUEST mBound = " + this.mBound + " flowId=" + paramInt1 + " originalFilePath = " + paramString1 + " md5 = " + paramString2 + " targetWidth = " + paramInt2 + " targetHeight = " + paramInt3 + " quality = " + paramInt4 + " autoRotate = " + paramBoolean1 + " compressToWebp = " + paramBoolean2);
    if (!this.mBound) {
      return false;
    }
    Message localMessage = Message.obtain(null, 1);
    localMessage.arg1 = paramInt1;
    localMessage.replyTo = this.mMessenger;
    paramString2 = FileUtils.getTempFilePath(this.mContext, paramString1, paramString2, paramInt1);
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    localMessage.getData().putParcelable("KEY_MSG_COMPRESS", new ImageProcessData(paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, null));
    try
    {
      if (this.mService != null)
      {
        this.mService.send(localMessage);
        return true;
      }
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
      UploadLog.d("ImageProcessProxy", "ImageProcessProxy finishTask flowId=" + paramInt);
      ImageCompressRecord localImageCompressRecord = (ImageCompressRecord)this.mRecordMap.get(paramInt);
      this.mRecordMap.remove(paramInt);
      this.mPendingRecords.remove(localImageCompressRecord);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static ImageProcessProxy getInstance()
  {
    if (sProxy == null) {}
    try
    {
      if (sProxy == null) {
        sProxy = new ImageProcessProxy();
      }
      return sProxy;
    }
    finally {}
  }
  
  /* Error */
  private void next()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 8
    //   4: new 107	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   11: ldc 225
    //   13: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 59	com/tencent/upload/image/ImageProcessProxy:mServiceBusy	Z
    //   20: invokevirtual 119	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: ldc 227
    //   25: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 116	com/tencent/upload/image/ImageProcessProxy:mBound	Z
    //   32: invokevirtual 119	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 148	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 59	com/tencent/upload/image/ImageProcessProxy:mServiceBusy	Z
    //   45: ifne +101 -> 146
    //   48: aload_0
    //   49: getfield 77	com/tencent/upload/image/ImageProcessProxy:mPendingRecords	Ljava/util/concurrent/LinkedBlockingQueue;
    //   52: invokevirtual 231	java/util/concurrent/LinkedBlockingQueue:peek	()Ljava/lang/Object;
    //   55: checkcast 214	com/tencent/upload/image/ImageCompressRecord
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +86 -> 146
    //   63: aload_0
    //   64: iconst_1
    //   65: putfield 59	com/tencent/upload/image/ImageProcessProxy:mServiceBusy	Z
    //   68: aload_0
    //   69: aload_1
    //   70: getfield 234	com/tencent/upload/image/ImageCompressRecord:flowId	I
    //   73: aload_1
    //   74: getfield 237	com/tencent/upload/image/ImageCompressRecord:path	Ljava/lang/String;
    //   77: aload_1
    //   78: getfield 240	com/tencent/upload/image/ImageCompressRecord:md5	Ljava/lang/String;
    //   81: aload_1
    //   82: getfield 244	com/tencent/upload/image/ImageCompressRecord:mSize	Lcom/tencent/upload/uinterface/IUploadConfig$UploadImageSize;
    //   85: getfield 249	com/tencent/upload/uinterface/IUploadConfig$UploadImageSize:width	I
    //   88: aload_1
    //   89: getfield 244	com/tencent/upload/image/ImageCompressRecord:mSize	Lcom/tencent/upload/uinterface/IUploadConfig$UploadImageSize;
    //   92: getfield 252	com/tencent/upload/uinterface/IUploadConfig$UploadImageSize:height	I
    //   95: aload_1
    //   96: getfield 244	com/tencent/upload/image/ImageCompressRecord:mSize	Lcom/tencent/upload/uinterface/IUploadConfig$UploadImageSize;
    //   99: getfield 255	com/tencent/upload/uinterface/IUploadConfig$UploadImageSize:quality	I
    //   102: aload_1
    //   103: getfield 258	com/tencent/upload/image/ImageCompressRecord:autoRotate	Z
    //   106: aload_1
    //   107: getfield 261	com/tencent/upload/image/ImageCompressRecord:compressToWebp	Z
    //   110: invokespecial 263	com/tencent/upload/image/ImageProcessProxy:asyncCopyAndCompressFile	(ILjava/lang/String;Ljava/lang/String;IIIZZ)Z
    //   113: ifeq +36 -> 149
    //   116: aload_0
    //   117: getfield 48	com/tencent/upload/image/ImageProcessProxy:mIncomingHandler	Lcom/tencent/upload/image/ImageProcessProxy$IncomingHandler;
    //   120: bipush 100
    //   122: invokestatic 154	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   125: astore_2
    //   126: aload_2
    //   127: aload_1
    //   128: getfield 234	com/tencent/upload/image/ImageCompressRecord:flowId	I
    //   131: putfield 157	android/os/Message:arg1	I
    //   134: aload_0
    //   135: getfield 48	com/tencent/upload/image/ImageProcessProxy:mIncomingHandler	Lcom/tencent/upload/image/ImageProcessProxy$IncomingHandler;
    //   138: aload_2
    //   139: ldc2_w 264
    //   142: invokevirtual 269	com/tencent/upload/image/ImageProcessProxy$IncomingHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   145: pop
    //   146: aload_0
    //   147: monitorexit
    //   148: return
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield 59	com/tencent/upload/image/ImageProcessProxy:mServiceBusy	Z
    //   154: goto -8 -> 146
    //   157: astore_1
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	ImageProcessProxy
    //   58	70	1	localImageCompressRecord	ImageCompressRecord
    //   157	4	1	localObject	Object
    //   125	14	2	localMessage	Message
    // Exception table:
    //   from	to	target	type
    //   2	59	157	finally
    //   63	146	157	finally
    //   149	154	157	finally
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
    UploadLog.d("ImageProcessProxy", "ImageProcessProxy cancel taskId=" + paramInt);
    ImageCompressRecord localImageCompressRecord = (ImageCompressRecord)this.mRecordMap.get(paramInt);
    if (localImageCompressRecord != null) {
      finishTask(localImageCompressRecord.flowId);
    }
    next();
  }
  
  /* Error */
  public void compressFile(ImageCompressRecord paramImageCompressRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 82	com/tencent/upload/image/ImageProcessProxy:mRecordMap	Landroid/util/SparseArray;
    //   6: aload_1
    //   7: getfield 234	com/tencent/upload/image/ImageCompressRecord:flowId	I
    //   10: invokevirtual 212	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   13: ifnonnull +31 -> 44
    //   16: aload_0
    //   17: getfield 77	com/tencent/upload/image/ImageProcessProxy:mPendingRecords	Ljava/util/concurrent/LinkedBlockingQueue;
    //   20: aload_1
    //   21: invokevirtual 288	java/util/concurrent/LinkedBlockingQueue:add	(Ljava/lang/Object;)Z
    //   24: pop
    //   25: aload_0
    //   26: getfield 82	com/tencent/upload/image/ImageProcessProxy:mRecordMap	Landroid/util/SparseArray;
    //   29: aload_1
    //   30: getfield 234	com/tencent/upload/image/ImageCompressRecord:flowId	I
    //   33: aload_1
    //   34: invokevirtual 292	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   37: aload_0
    //   38: invokespecial 97	com/tencent/upload/image/ImageProcessProxy:next	()V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: ldc 8
    //   46: new 107	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 294
    //   56: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: getfield 234	com/tencent/upload/image/ImageCompressRecord:flowId	I
    //   63: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 148	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: goto -35 -> 37
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ImageProcessProxy
    //   0	80	1	paramImageCompressRecord	ImageCompressRecord
    // Exception table:
    //   from	to	target	type
    //   2	37	75	finally
    //   37	41	75	finally
    //   44	72	75	finally
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
      UploadLog.v("ImageProcessProxy", "ImageProcessProxy end bindService mBound = " + this.mBound);
      return this.mBound;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessProxy
 * JD-Core Version:    0.7.0.1
 */