package dov.com.qq.im.ae.camera.core;

import android.graphics.Bitmap;
import axqw;
import bdhb;
import bdhj;
import bksf;
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
    bdhb.c(str);
    File localFile = new File(str);
    try
    {
      bdhj.a(this.a, localFile);
      bdhj.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      AECameraGLSurfaceView.a(this.this$0, new axqw(0, 0, str, null, AECameraGLSurfaceView.a(this.this$0)));
      this.a.recycle();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        AECameraGLSurfaceView.a(this.this$0, new axqw(0, -1, str, null, AECameraGLSurfaceView.a(this.this$0)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.7
 * JD-Core Version:    0.7.0.1
 */