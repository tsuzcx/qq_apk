package dov.com.qq.im.AECamera.View;

import android.graphics.Bitmap;
import auuy;
import bace;
import bacm;
import bgxk;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.io.IOException;

class AECameraGLSurfaceView$6
  implements Runnable
{
  AECameraGLSurfaceView$6(AECameraGLSurfaceView paramAECameraGLSurfaceView, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = AECameraGLSurfaceView.a(this.this$0).a + "/" + System.currentTimeMillis() + ".jpg";
    bace.c(str);
    File localFile = new File(str);
    try
    {
      bacm.a(this.a, localFile);
      bacm.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      AECameraGLSurfaceView.a(this.this$0, new auuy(0, 0, str, null, AECameraGLSurfaceView.a(this.this$0)));
      this.a.recycle();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        AECameraGLSurfaceView.a(this.this$0, new auuy(0, -1, str, null, AECameraGLSurfaceView.a(this.this$0)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AECameraGLSurfaceView.6
 * JD-Core Version:    0.7.0.1
 */