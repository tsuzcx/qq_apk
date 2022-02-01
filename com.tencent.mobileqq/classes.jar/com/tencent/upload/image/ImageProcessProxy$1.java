package com.tencent.upload.image;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.upload.utils.UploadLog;

class ImageProcessProxy$1
  implements ServiceConnection
{
  ImageProcessProxy$1(ImageProcessProxy paramImageProcessProxy) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    UploadLog.d("ImageProcessProxy", "onServiceConnected");
    this.this$0.mService = new Messenger(paramIBinder);
    this.this$0.mBound = true;
    ??? = Message.obtain(null, 2);
    ???.replyTo = ImageProcessProxy.access$400(this.this$0);
    try
    {
      if (this.this$0.mService != null) {
        this.this$0.mService.send(???);
      }
    }
    catch (Exception ???)
    {
      UploadLog.w("ImageProcessProxy", "obtain pid", ???);
    }
    if (this.this$0.mProcessCallback != null) {
      this.this$0.mProcessCallback.onServiceConnected();
    }
    synchronized (ImageProcessProxy.access$500(this.this$0))
    {
      ImageProcessProxy.access$500(this.this$0).notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    UploadLog.d("ImageProcessProxy", "onServiceDisconnected");
    paramComponentName = this.this$0;
    paramComponentName.mBound = false;
    paramComponentName.mService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessProxy.1
 * JD-Core Version:    0.7.0.1
 */