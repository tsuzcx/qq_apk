package dov.com.qq.im.ae.camera.core;

import android.graphics.Bitmap;
import avuo;
import bbdx;
import bbef;
import bijq;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.io.IOException;

class AECameraGLSurfaceView$7
  implements Runnable
{
  AECameraGLSurfaceView$7(AECameraGLSurfaceView paramAECameraGLSurfaceView, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = AECameraGLSurfaceView.a(this.this$0).a + "/" + System.currentTimeMillis() + ".jpg";
    bbdx.c(str);
    File localFile = new File(str);
    try
    {
      bbef.a(this.a, localFile);
      bbef.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      AECameraGLSurfaceView.a(this.this$0, new avuo(0, 0, str, null, AECameraGLSurfaceView.a(this.this$0)));
      this.a.recycle();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        AECameraGLSurfaceView.a(this.this$0, new avuo(0, -1, str, null, AECameraGLSurfaceView.a(this.this$0)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.7
 * JD-Core Version:    0.7.0.1
 */