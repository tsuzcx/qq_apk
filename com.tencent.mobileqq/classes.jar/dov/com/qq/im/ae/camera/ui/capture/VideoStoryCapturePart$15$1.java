package dov.com.qq.im.ae.camera.ui.capture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import awen;
import bkrq;
import bkrx;
import blfg;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.util.List;
import yvt;

public class VideoStoryCapturePart$15$1
  implements Runnable
{
  public VideoStoryCapturePart$15$1(bkrx parambkrx, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 0) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= 0))
      {
        blfg.d("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      yvt.a(this.jdField_a_of_type_AndroidGraphicsBitmap).compress(Bitmap.CompressFormat.JPEG, 30, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      bkrq.a(this.jdField_a_of_type_Bkrx.a, bkrq.a(this.jdField_a_of_type_Bkrx.a) + localObject.length);
      if (bkrq.a(this.jdField_a_of_type_Bkrx.a) > bkrq.b(this.jdField_a_of_type_Bkrx.a))
      {
        bkrq.a(this.jdField_a_of_type_Bkrx.a, bkrq.a(this.jdField_a_of_type_Bkrx.a) - localObject.length);
        awen.a("Q.videostory", "Q.videostory.capture", "onCapture", "size to larger");
        localByteArrayOutputStream.close();
        bkrq.a(this.jdField_a_of_type_Bkrx.a).setCaptureRequest(null);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Object localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
    this.jdField_a_of_type_Bkrx.a.a.add(localObject);
    localException.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.15.1
 * JD-Core Version:    0.7.0.1
 */