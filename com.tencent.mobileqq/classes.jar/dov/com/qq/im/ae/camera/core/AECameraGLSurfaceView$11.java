package dov.com.qq.im.ae.camera.core;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import dov.com.qq.im.ae.camera.AECaptureParam;
import dov.com.qq.im.ae.camera.AEPhotoCaptureResult;
import java.io.File;
import java.io.IOException;

class AECameraGLSurfaceView$11
  implements Runnable
{
  AECameraGLSurfaceView$11(AECameraGLSurfaceView paramAECameraGLSurfaceView, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = AECameraGLSurfaceView.access$700(this.this$0).a + "/" + System.currentTimeMillis() + ".jpg";
    FileUtils.c(str);
    File localFile = new File(str);
    try
    {
      ImageUtil.a(this.val$photo, localFile);
      ImageUtil.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      AECameraGLSurfaceView.access$900(this.this$0, new AEPhotoCaptureResult(0, 0, str, null, AECameraGLSurfaceView.access$800(this.this$0)));
      this.val$photo.recycle();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        AECameraGLSurfaceView.access$900(this.this$0, new AEPhotoCaptureResult(0, -1, str, null, AECameraGLSurfaceView.access$800(this.this$0)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.11
 * JD-Core Version:    0.7.0.1
 */