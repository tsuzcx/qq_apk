package com.tencent.upload.image;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.tencent.upload.utils.UploadLog;

class ImageProcessProxy$1
  implements ServiceConnection
{
  ImageProcessProxy$1(ImageProcessProxy paramImageProcessProxy) {}
  
  /* Error */
  public void onServiceConnected(ComponentName arg1, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: ldc 22
    //   2: ldc 23
    //   4: invokestatic 29	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 12	com/tencent/upload/image/ImageProcessProxy$1:this$0	Lcom/tencent/upload/image/ImageProcessProxy;
    //   11: new 31	android/os/Messenger
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 34	android/os/Messenger:<init>	(Landroid/os/IBinder;)V
    //   19: putfield 40	com/tencent/upload/image/ImageProcessProxy:mService	Landroid/os/Messenger;
    //   22: aload_0
    //   23: getfield 12	com/tencent/upload/image/ImageProcessProxy$1:this$0	Lcom/tencent/upload/image/ImageProcessProxy;
    //   26: iconst_1
    //   27: putfield 44	com/tencent/upload/image/ImageProcessProxy:mBound	Z
    //   30: aconst_null
    //   31: iconst_2
    //   32: invokestatic 50	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   35: astore_1
    //   36: aload_1
    //   37: aload_0
    //   38: getfield 12	com/tencent/upload/image/ImageProcessProxy$1:this$0	Lcom/tencent/upload/image/ImageProcessProxy;
    //   41: invokestatic 54	com/tencent/upload/image/ImageProcessProxy:access$400	(Lcom/tencent/upload/image/ImageProcessProxy;)Landroid/os/Messenger;
    //   44: putfield 57	android/os/Message:replyTo	Landroid/os/Messenger;
    //   47: aload_0
    //   48: getfield 12	com/tencent/upload/image/ImageProcessProxy$1:this$0	Lcom/tencent/upload/image/ImageProcessProxy;
    //   51: getfield 40	com/tencent/upload/image/ImageProcessProxy:mService	Landroid/os/Messenger;
    //   54: ifnull +14 -> 68
    //   57: aload_0
    //   58: getfield 12	com/tencent/upload/image/ImageProcessProxy$1:this$0	Lcom/tencent/upload/image/ImageProcessProxy;
    //   61: getfield 40	com/tencent/upload/image/ImageProcessProxy:mService	Landroid/os/Messenger;
    //   64: aload_1
    //   65: invokevirtual 61	android/os/Messenger:send	(Landroid/os/Message;)V
    //   68: aload_0
    //   69: getfield 12	com/tencent/upload/image/ImageProcessProxy$1:this$0	Lcom/tencent/upload/image/ImageProcessProxy;
    //   72: getfield 65	com/tencent/upload/image/ImageProcessProxy:mProcessCallback	Lcom/tencent/upload/image/ImageProcessProxy$ImageCompressorCallback;
    //   75: ifnull +15 -> 90
    //   78: aload_0
    //   79: getfield 12	com/tencent/upload/image/ImageProcessProxy$1:this$0	Lcom/tencent/upload/image/ImageProcessProxy;
    //   82: getfield 65	com/tencent/upload/image/ImageProcessProxy:mProcessCallback	Lcom/tencent/upload/image/ImageProcessProxy$ImageCompressorCallback;
    //   85: invokeinterface 69 1 0
    //   90: aload_0
    //   91: getfield 12	com/tencent/upload/image/ImageProcessProxy$1:this$0	Lcom/tencent/upload/image/ImageProcessProxy;
    //   94: invokestatic 73	com/tencent/upload/image/ImageProcessProxy:access$500	(Lcom/tencent/upload/image/ImageProcessProxy;)[B
    //   97: astore_1
    //   98: aload_1
    //   99: monitorenter
    //   100: aload_0
    //   101: getfield 12	com/tencent/upload/image/ImageProcessProxy$1:this$0	Lcom/tencent/upload/image/ImageProcessProxy;
    //   104: invokestatic 73	com/tencent/upload/image/ImageProcessProxy:access$500	(Lcom/tencent/upload/image/ImageProcessProxy;)[B
    //   107: invokevirtual 76	java/lang/Object:notify	()V
    //   110: aload_1
    //   111: monitorexit
    //   112: return
    //   113: astore_1
    //   114: ldc 22
    //   116: ldc 78
    //   118: aload_1
    //   119: invokestatic 82	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: goto -54 -> 68
    //   125: astore_2
    //   126: aload_1
    //   127: monitorexit
    //   128: aload_2
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	1
    //   0	130	2	paramIBinder	android.os.IBinder
    // Exception table:
    //   from	to	target	type
    //   47	68	113	java/lang/Exception
    //   100	112	125	finally
    //   126	128	125	finally
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    UploadLog.d("ImageProcessProxy", "onServiceDisconnected");
    this.this$0.mBound = false;
    this.this$0.mService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessProxy.1
 * JD-Core Version:    0.7.0.1
 */