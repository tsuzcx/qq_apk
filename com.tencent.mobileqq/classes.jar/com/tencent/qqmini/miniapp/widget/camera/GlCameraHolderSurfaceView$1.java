package com.tencent.qqmini.miniapp.widget.camera;

import android.hardware.Camera.Size;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.concurrent.atomic.AtomicReference;

class GlCameraHolderSurfaceView$1
  implements Runnable
{
  GlCameraHolderSurfaceView$1(GlCameraHolderSurfaceView paramGlCameraHolderSurfaceView, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Log.d("GlCameraHolderSurfaceVi", "run: execute");
    Object localObject = new byte[this.val$data.length];
    int i = 0;
    while (i < this.this$0.cameraSize.height)
    {
      j = 0;
      while (j < this.this$0.cameraSize.width)
      {
        localObject[(this.this$0.cameraSize.height * j + this.this$0.cameraSize.height - i - 1)] = this.val$data[(this.this$0.cameraSize.width * i + j)];
        j += 1;
      }
      i += 1;
    }
    i = this.this$0.cameraSize.height;
    int j = this.this$0.cameraSize.width;
    try
    {
      ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localChannelProxy != null)
      {
        localObject = localChannelProxy.decodeQR((byte[])localObject, i, j, 0, 0, i, j);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.this$0.onCodeRead((String)localObject);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("GlCameraHolderSurfaceVi", "decode error", localException);
      }
    }
    GlCameraHolderSurfaceView.access$000(this.this$0).set(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.GlCameraHolderSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */