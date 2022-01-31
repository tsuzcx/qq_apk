package dov.com.qq.im.ae.camera.core;

import android.os.Build.VERSION;
import com.tencent.ttpic.util.SensorUtil2;

class AECameraGLSurfaceView$2
  implements Runnable
{
  AECameraGLSurfaceView$2(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void run()
  {
    if (!AECameraGLSurfaceView.d()) {
      AECameraGLSurfaceView.e();
    }
    try
    {
      AECameraGLSurfaceView.a(this.this$0, new SensorUtil2());
      if (Build.VERSION.SDK_INT < 29) {
        AECameraGLSurfaceView.b(this.this$0);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */