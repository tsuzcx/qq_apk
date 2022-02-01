package dov.com.qq.im.ae.camera.ui.capture;

import aavz;
import aaxa;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import ayxi;
import bnlc;
import bnll;
import bnzb;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class VideoStoryCapturePart$9$1
  implements Runnable
{
  public VideoStoryCapturePart$9$1(bnll parambnll, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 0) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= 0))
      {
        bnzb.d("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = aaxa.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      long l = ((Long)aavz.a().a("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, (int)l, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      bnlc.a(this.jdField_a_of_type_Bnll.a, bnlc.a(this.jdField_a_of_type_Bnll.a) + localObject.length);
      if (bnlc.a(this.jdField_a_of_type_Bnll.a) > bnlc.b(this.jdField_a_of_type_Bnll.a))
      {
        bnlc.a(this.jdField_a_of_type_Bnll.a, bnlc.a(this.jdField_a_of_type_Bnll.a) - localObject.length);
        ayxi.a("Q.videostory", "Q.videostory.capture", "onCapture", "size to larger");
        localByteArrayOutputStream.close();
        bnlc.a(this.jdField_a_of_type_Bnll.a).setCaptureRequest(null);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Object localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
    this.jdField_a_of_type_Bnll.a.a.add(localObject);
    localException.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.9.1
 * JD-Core Version:    0.7.0.1
 */