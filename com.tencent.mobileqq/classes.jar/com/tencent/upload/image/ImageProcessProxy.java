package com.tencent.upload.image;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.a;
import com.tencent.upload.common.b;
import java.util.concurrent.LinkedBlockingQueue;

public class ImageProcessProxy
{
  private static volatile ImageProcessProxy k;
  protected static final int sfWaitBindTime = 10000;
  ImageCompressorCallback a;
  Messenger b = null;
  volatile boolean c;
  private Context d = a.a();
  private byte[] e = new byte[0];
  private final a f = new a();
  private final Messenger g = new Messenger(this.f);
  private volatile boolean h = false;
  private final LinkedBlockingQueue<ImageCompressTask> i = new LinkedBlockingQueue();
  private final SparseArray<ImageCompressTask> j = new SparseArray();
  private final ServiceConnection l = new ServiceConnection()
  {
    /* Error */
    public void onServiceConnected(ComponentName arg1, android.os.IBinder paramAnonymousIBinder)
    {
      // Byte code:
      //   0: ldc 24
      //   2: ldc 25
      //   4: invokestatic 31	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   7: aload_0
      //   8: getfield 14	com/tencent/upload/image/ImageProcessProxy$1:a	Lcom/tencent/upload/image/ImageProcessProxy;
      //   11: new 33	android/os/Messenger
      //   14: dup
      //   15: aload_2
      //   16: invokespecial 36	android/os/Messenger:<init>	(Landroid/os/IBinder;)V
      //   19: putfield 39	com/tencent/upload/image/ImageProcessProxy:b	Landroid/os/Messenger;
      //   22: aload_0
      //   23: getfield 14	com/tencent/upload/image/ImageProcessProxy$1:a	Lcom/tencent/upload/image/ImageProcessProxy;
      //   26: iconst_1
      //   27: putfield 43	com/tencent/upload/image/ImageProcessProxy:c	Z
      //   30: aconst_null
      //   31: iconst_2
      //   32: invokestatic 49	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
      //   35: astore_1
      //   36: aload_1
      //   37: aload_0
      //   38: getfield 14	com/tencent/upload/image/ImageProcessProxy$1:a	Lcom/tencent/upload/image/ImageProcessProxy;
      //   41: invokestatic 52	com/tencent/upload/image/ImageProcessProxy:c	(Lcom/tencent/upload/image/ImageProcessProxy;)Landroid/os/Messenger;
      //   44: putfield 55	android/os/Message:replyTo	Landroid/os/Messenger;
      //   47: aload_0
      //   48: getfield 14	com/tencent/upload/image/ImageProcessProxy$1:a	Lcom/tencent/upload/image/ImageProcessProxy;
      //   51: getfield 39	com/tencent/upload/image/ImageProcessProxy:b	Landroid/os/Messenger;
      //   54: ifnull +14 -> 68
      //   57: aload_0
      //   58: getfield 14	com/tencent/upload/image/ImageProcessProxy$1:a	Lcom/tencent/upload/image/ImageProcessProxy;
      //   61: getfield 39	com/tencent/upload/image/ImageProcessProxy:b	Landroid/os/Messenger;
      //   64: aload_1
      //   65: invokevirtual 59	android/os/Messenger:send	(Landroid/os/Message;)V
      //   68: aload_0
      //   69: getfield 14	com/tencent/upload/image/ImageProcessProxy$1:a	Lcom/tencent/upload/image/ImageProcessProxy;
      //   72: getfield 62	com/tencent/upload/image/ImageProcessProxy:a	Lcom/tencent/upload/image/ImageProcessProxy$ImageCompressorCallback;
      //   75: ifnull +15 -> 90
      //   78: aload_0
      //   79: getfield 14	com/tencent/upload/image/ImageProcessProxy$1:a	Lcom/tencent/upload/image/ImageProcessProxy;
      //   82: getfield 62	com/tencent/upload/image/ImageProcessProxy:a	Lcom/tencent/upload/image/ImageProcessProxy$ImageCompressorCallback;
      //   85: invokeinterface 66 1 0
      //   90: aload_0
      //   91: getfield 14	com/tencent/upload/image/ImageProcessProxy$1:a	Lcom/tencent/upload/image/ImageProcessProxy;
      //   94: invokestatic 70	com/tencent/upload/image/ImageProcessProxy:d	(Lcom/tencent/upload/image/ImageProcessProxy;)[B
      //   97: astore_1
      //   98: aload_1
      //   99: monitorenter
      //   100: aload_0
      //   101: getfield 14	com/tencent/upload/image/ImageProcessProxy$1:a	Lcom/tencent/upload/image/ImageProcessProxy;
      //   104: invokestatic 70	com/tencent/upload/image/ImageProcessProxy:d	(Lcom/tencent/upload/image/ImageProcessProxy;)[B
      //   107: invokevirtual 73	java/lang/Object:notify	()V
      //   110: aload_1
      //   111: monitorexit
      //   112: return
      //   113: astore_1
      //   114: ldc 24
      //   116: ldc 75
      //   118: aload_1
      //   119: invokestatic 78	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   122: goto -54 -> 68
      //   125: astore_2
      //   126: aload_1
      //   127: monitorexit
      //   128: aload_2
      //   129: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	130	0	this	1
      //   0	130	2	paramAnonymousIBinder	android.os.IBinder
      // Exception table:
      //   from	to	target	type
      //   47	68	113	java/lang/Exception
      //   100	112	125	finally
      //   126	128	125	finally
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      b.b("ImageProcessProxy", "onServiceDisconnected");
      ImageProcessProxy.this.c = false;
      ImageProcessProxy.this.b = null;
    }
  };
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 84
    //   4: new 86	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   11: ldc 89
    //   13: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 60	com/tencent/upload/image/ImageProcessProxy:h	Z
    //   20: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 105	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 60	com/tencent/upload/image/ImageProcessProxy:h	Z
    //   33: ifne +101 -> 134
    //   36: aload_0
    //   37: getfield 75	com/tencent/upload/image/ImageProcessProxy:i	Ljava/util/concurrent/LinkedBlockingQueue;
    //   40: invokevirtual 109	java/util/concurrent/LinkedBlockingQueue:peek	()Ljava/lang/Object;
    //   43: checkcast 111	com/tencent/upload/image/ImageCompressTask
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +86 -> 134
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 60	com/tencent/upload/image/ImageProcessProxy:h	Z
    //   56: aload_0
    //   57: aload_1
    //   58: getfield 113	com/tencent/upload/image/ImageCompressTask:d	I
    //   61: aload_1
    //   62: getfield 116	com/tencent/upload/image/ImageCompressTask:e	Ljava/lang/String;
    //   65: aload_1
    //   66: getfield 118	com/tencent/upload/image/ImageCompressTask:f	Ljava/lang/String;
    //   69: aload_1
    //   70: getfield 121	com/tencent/upload/image/ImageCompressTask:a	Lcom/tencent/upload/uinterface/IUploadConfig$UploadImageSize;
    //   73: getfield 126	com/tencent/upload/uinterface/IUploadConfig$UploadImageSize:width	I
    //   76: aload_1
    //   77: getfield 121	com/tencent/upload/image/ImageCompressTask:a	Lcom/tencent/upload/uinterface/IUploadConfig$UploadImageSize;
    //   80: getfield 129	com/tencent/upload/uinterface/IUploadConfig$UploadImageSize:height	I
    //   83: aload_1
    //   84: getfield 121	com/tencent/upload/image/ImageCompressTask:a	Lcom/tencent/upload/uinterface/IUploadConfig$UploadImageSize;
    //   87: getfield 132	com/tencent/upload/uinterface/IUploadConfig$UploadImageSize:quality	I
    //   90: aload_1
    //   91: getfield 134	com/tencent/upload/image/ImageCompressTask:b	Z
    //   94: aload_1
    //   95: getfield 136	com/tencent/upload/image/ImageCompressTask:c	Z
    //   98: invokespecial 139	com/tencent/upload/image/ImageProcessProxy:a	(ILjava/lang/String;Ljava/lang/String;IIIZZ)Z
    //   101: ifeq +36 -> 137
    //   104: aload_0
    //   105: getfield 49	com/tencent/upload/image/ImageProcessProxy:f	Lcom/tencent/upload/image/ImageProcessProxy$a;
    //   108: bipush 100
    //   110: invokestatic 145	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   113: astore_2
    //   114: aload_2
    //   115: aload_1
    //   116: getfield 113	com/tencent/upload/image/ImageCompressTask:d	I
    //   119: putfield 148	android/os/Message:arg1	I
    //   122: aload_0
    //   123: getfield 49	com/tencent/upload/image/ImageProcessProxy:f	Lcom/tencent/upload/image/ImageProcessProxy$a;
    //   126: aload_2
    //   127: ldc2_w 149
    //   130: invokevirtual 154	com/tencent/upload/image/ImageProcessProxy$a:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   133: pop
    //   134: aload_0
    //   135: monitorexit
    //   136: return
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 60	com/tencent/upload/image/ImageProcessProxy:h	Z
    //   142: goto -8 -> 134
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	ImageProcessProxy
    //   46	70	1	localImageCompressTask	ImageCompressTask
    //   145	4	1	localObject	Object
    //   113	14	2	localMessage	Message
    // Exception table:
    //   from	to	target	type
    //   2	47	145	finally
    //   51	134	145	finally
    //   137	142	145	finally
  }
  
  private void a(int paramInt)
  {
    try
    {
      b.b("ImageProcessProxy", "ImageProcessProxy finishTask flowId=" + paramInt);
      ImageCompressTask localImageCompressTask = (ImageCompressTask)this.j.get(paramInt);
      this.j.remove(paramInt);
      this.i.remove(localImageCompressTask);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    b.b("ImageProcessProxy", "send MSG_COPY_AND_COMPRESS_IMAGE_REQUEST mBound = " + this.c + " flowId=" + paramInt1 + " originalFilePath = " + paramString1 + " md5 = " + paramString2 + " targetWidth = " + paramInt2 + " targetHeight = " + paramInt3 + " quality = " + paramInt4 + " autoRotate = " + paramBoolean1 + " compressToWebp = " + paramBoolean2);
    if (!this.c) {
      return false;
    }
    Message localMessage = Message.obtain(null, 1);
    localMessage.arg1 = paramInt1;
    localMessage.replyTo = this.g;
    paramString2 = FileUtils.getTempFilePath(this.d, paramString1, paramString2, paramInt1);
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    localMessage.getData().putParcelable("KEY_MSG_COMPRESS", new ImageProcessData(paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, null));
    try
    {
      if (this.b != null)
      {
        this.b.send(localMessage);
        return true;
      }
    }
    catch (Exception paramString1)
    {
      b.b("ImageProcessProxy", "ImageCompressor", paramString1);
    }
    return false;
  }
  
  private void b()
  {
    b.b("ImageProcessProxy", "release");
    if (!this.c) {
      return;
    }
    this.c = false;
    this.i.clear();
    this.j.clear();
    this.d.unbindService(this.l);
  }
  
  public static void close()
  {
    b.b("ImageProcessProxy", "close");
    if (k != null) {
      k.b();
    }
  }
  
  public static ImageProcessProxy getInstance()
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new ImageProcessProxy();
      }
      return k;
    }
    finally {}
  }
  
  public void cancel(int paramInt)
  {
    b.b("ImageProcessProxy", "ImageProcessProxy cancel taskId=" + paramInt);
    ImageCompressTask localImageCompressTask = (ImageCompressTask)this.j.get(paramInt);
    if (localImageCompressTask != null) {
      a(localImageCompressTask.d);
    }
    a();
  }
  
  /* Error */
  public void compressFile(ImageCompressTask paramImageCompressTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/upload/image/ImageProcessProxy:j	Landroid/util/SparseArray;
    //   6: aload_1
    //   7: getfield 113	com/tencent/upload/image/ImageCompressTask:d	I
    //   10: invokevirtual 164	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   13: ifnonnull +31 -> 44
    //   16: aload_0
    //   17: getfield 75	com/tencent/upload/image/ImageProcessProxy:i	Ljava/util/concurrent/LinkedBlockingQueue;
    //   20: aload_1
    //   21: invokevirtual 269	java/util/concurrent/LinkedBlockingQueue:add	(Ljava/lang/Object;)Z
    //   24: pop
    //   25: aload_0
    //   26: getfield 80	com/tencent/upload/image/ImageProcessProxy:j	Landroid/util/SparseArray;
    //   29: aload_1
    //   30: getfield 113	com/tencent/upload/image/ImageCompressTask:d	I
    //   33: aload_1
    //   34: invokevirtual 273	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   37: aload_0
    //   38: invokespecial 250	com/tencent/upload/image/ImageProcessProxy:a	()V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: ldc 84
    //   46: new 86	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 275
    //   56: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: getfield 113	com/tencent/upload/image/ImageCompressTask:d	I
    //   63: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 105	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: goto -35 -> 37
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ImageProcessProxy
    //   0	80	1	paramImageCompressTask	ImageCompressTask
    // Exception table:
    //   from	to	target	type
    //   2	37	75	finally
    //   37	41	75	finally
    //   44	72	75	finally
  }
  
  public void compressFile(ImageCompressTask paramImageCompressTask, ImageCompressorCallback paramImageCompressorCallback)
  {
    if (!this.c) {
      initService();
    }
    this.a = paramImageCompressorCallback;
    compressFile(paramImageCompressTask);
  }
  
  public boolean initService()
  {
    if (this.c) {
      return true;
    }
    b.a("ImageProcessProxy", "ImageProcessProxy start bindService");
    synchronized (this.e)
    {
      Intent localIntent = new Intent(this.d, ImageProcessService.class);
      this.d.bindService(localIntent, this.l, 1);
    }
    try
    {
      this.e.wait(10000L);
      label63:
      b.a("ImageProcessProxy", "ImageProcessProxy end bindService mBound = " + this.c);
      return this.c;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label63;
    }
  }
  
  public static abstract interface ImageCompressorCallback
  {
    public abstract void onCompressFinish(int paramInt, String paramString1, String paramString2);
    
    public abstract void onPidObtained(int paramInt);
    
    public abstract void onServiceConnected();
  }
  
  @SuppressLint({"HandlerLeak"})
  private class a
    extends Handler
  {
    public a()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      String str1 = null;
      String str2;
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
      case 101: 
        b.a("ImageProcessProxy", "receive MSG_COPY_AND_COMPRESS_IMAGE_REQUEST response flowId=" + paramMessage.arg1);
        paramMessage.getData().setClassLoader(ImageProcessData.class.getClassLoader());
        localObject = paramMessage.getData().getParcelable("KEY_MSG_COMPRESS");
        if ((localObject instanceof ImageProcessData))
        {
          ImageProcessData localImageProcessData = (ImageProcessData)localObject;
          str2 = localImageProcessData.originalFilePath;
          localObject = str2;
          if (!TextUtils.isEmpty(localImageProcessData.msg))
          {
            b.b("ImageProcessProxy", localImageProcessData.msg);
            str1 = localImageProcessData.msg;
          }
        }
        break;
      }
      for (Object localObject = str2;; localObject = null)
      {
        int i = paramMessage.arg1;
        if ((ImageCompressTask)ImageProcessProxy.a(ImageProcessProxy.this).get(i) != null)
        {
          removeMessages(100);
          ImageProcessProxy.a(ImageProcessProxy.this, paramMessage.arg1);
          ImageProcessProxy.a(ImageProcessProxy.this, false);
          if (ImageProcessProxy.this.a != null) {
            ImageProcessProxy.this.a.onCompressFinish(i, (String)localObject, str1);
          }
          ImageProcessProxy.b(ImageProcessProxy.this);
          return;
        }
        b.a("ImageProcessProxy", "removed task flowId: " + i);
        return;
        b.a("ImageProcessProxy", "receive MSG_OBTAIN_PID_RESPONSE pid:" + paramMessage.arg1);
        if (ImageProcessProxy.this.a == null) {
          break;
        }
        ImageProcessProxy.this.a.onPidObtained(paramMessage.arg1);
        return;
        b.a("ImageProcessProxy", "MSG_PROCESS_TIMEOUT");
        i = paramMessage.arg1;
        paramMessage = (ImageCompressTask)ImageProcessProxy.a(ImageProcessProxy.this).get(i);
        if (paramMessage != null)
        {
          b.b("ImageProcessProxy", "timeout flowId:" + i + " path:" + paramMessage.e);
          ImageProcessProxy.a(ImageProcessProxy.this, i);
          if (ImageProcessProxy.this.a != null) {
            ImageProcessProxy.this.a.onCompressFinish(i, paramMessage.e, "original path");
          }
        }
        for (;;)
        {
          ImageProcessProxy.a(ImageProcessProxy.this, false);
          ImageProcessProxy.b(ImageProcessProxy.this);
          return;
          b.a("ImageProcessProxy", "removed time out task flowId: " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessProxy
 * JD-Core Version:    0.7.0.1
 */