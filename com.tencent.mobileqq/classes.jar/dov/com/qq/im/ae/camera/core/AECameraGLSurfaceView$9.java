package dov.com.qq.im.ae.camera.core;

import android.graphics.Bitmap;
import bheg;
import bnax;
import bnay;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

class AECameraGLSurfaceView$9
  implements Runnable
{
  AECameraGLSurfaceView$9(AECameraGLSurfaceView paramAECameraGLSurfaceView, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = AECameraGLSurfaceView.access$700(this.this$0).a + "/" + System.currentTimeMillis() + ".jpg";
    FileUtils.createFileIfNotExits(str);
    File localFile = new File(str);
    try
    {
      bheg.a(this.val$photo, localFile);
      bheg.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      AECameraGLSurfaceView.access$900(this.this$0, new bnay(0, 0, str, null, AECameraGLSurfaceView.access$800(this.this$0)));
      this.val$photo.recycle();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        AECameraGLSurfaceView.access$900(this.this$0, new bnay(0, -1, str, null, AECameraGLSurfaceView.access$800(this.this$0)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.9
 * JD-Core Version:    0.7.0.1
 */