package dov.com.qq.im.ae.camera.ui.capture;

import abac;
import abbd;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import azpw;
import bomp;
import bomy;
import bpam;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class VideoStoryCapturePart$9$1
  implements Runnable
{
  public VideoStoryCapturePart$9$1(bomy parambomy, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 0) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= 0))
      {
        bpam.d("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = abbd.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      long l = ((Long)abac.a().a("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, (int)l, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      bomp.a(this.jdField_a_of_type_Bomy.a, bomp.a(this.jdField_a_of_type_Bomy.a) + localObject.length);
      if (bomp.a(this.jdField_a_of_type_Bomy.a) > bomp.b(this.jdField_a_of_type_Bomy.a))
      {
        bomp.a(this.jdField_a_of_type_Bomy.a, bomp.a(this.jdField_a_of_type_Bomy.a) - localObject.length);
        azpw.a("Q.videostory", "Q.videostory.capture", "onCapture", "size to larger");
        localByteArrayOutputStream.close();
        bomp.a(this.jdField_a_of_type_Bomy.a).setCaptureRequest(null);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Object localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
    this.jdField_a_of_type_Bomy.a.a.add(localObject);
    localException.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.9.1
 * JD-Core Version:    0.7.0.1
 */