package dov.com.qq.im.ae.camera.ui.capture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import awiw;
import bkvx;
import bkwe;
import bljn;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.util.List;
import zai;

public class VideoStoryCapturePart$15$1
  implements Runnable
{
  public VideoStoryCapturePart$15$1(bkwe parambkwe, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 0) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= 0))
      {
        bljn.d("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      zai.a(this.jdField_a_of_type_AndroidGraphicsBitmap).compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      bkvx.a(this.jdField_a_of_type_Bkwe.a, bkvx.a(this.jdField_a_of_type_Bkwe.a) + localObject.length);
      if (bkvx.a(this.jdField_a_of_type_Bkwe.a) > bkvx.b(this.jdField_a_of_type_Bkwe.a))
      {
        bkvx.a(this.jdField_a_of_type_Bkwe.a, bkvx.a(this.jdField_a_of_type_Bkwe.a) - localObject.length);
        awiw.a("Q.videostory", "Q.videostory.capture", "onCapture", "size to larger");
        localByteArrayOutputStream.close();
        bkvx.a(this.jdField_a_of_type_Bkwe.a).setCaptureRequest(null);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Object localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
    this.jdField_a_of_type_Bkwe.a.a.add(localObject);
    localException.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.15.1
 * JD-Core Version:    0.7.0.1
 */