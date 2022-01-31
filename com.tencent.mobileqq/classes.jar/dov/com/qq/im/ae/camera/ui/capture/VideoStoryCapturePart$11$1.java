package dov.com.qq.im.ae.camera.ui.capture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import aune;
import bimj;
import bimm;
import bizq;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import xhd;

public class VideoStoryCapturePart$11$1
  implements Runnable
{
  public VideoStoryCapturePart$11$1(bimm parambimm, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 0) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= 0))
      {
        bizq.d("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      xhd.a(this.jdField_a_of_type_AndroidGraphicsBitmap).compress(Bitmap.CompressFormat.JPEG, 30, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      bimj.a(this.jdField_a_of_type_Bimm.a, bimj.a(this.jdField_a_of_type_Bimm.a) + localObject.length);
      if (bimj.a(this.jdField_a_of_type_Bimm.a) > bimj.b(this.jdField_a_of_type_Bimm.a))
      {
        bimj.a(this.jdField_a_of_type_Bimm.a, bimj.a(this.jdField_a_of_type_Bimm.a) - localObject.length);
        aune.a("Q.videostory", "Q.videostory.capture", "onCapture", "size to larger");
        localByteArrayOutputStream.close();
        bimj.a(this.jdField_a_of_type_Bimm.a).setCaptureRequest(null);
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    Object localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
    this.jdField_a_of_type_Bimm.a.a.add(localObject);
    localIOException.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.11.1
 * JD-Core Version:    0.7.0.1
 */