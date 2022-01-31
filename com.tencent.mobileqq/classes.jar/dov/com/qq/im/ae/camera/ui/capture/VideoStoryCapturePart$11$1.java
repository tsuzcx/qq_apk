package dov.com.qq.im.ae.camera.ui.capture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import aung;
import bina;
import bind;
import bjah;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import xha;

public class VideoStoryCapturePart$11$1
  implements Runnable
{
  public VideoStoryCapturePart$11$1(bind parambind, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 0) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= 0))
      {
        bjah.d("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      xha.a(this.jdField_a_of_type_AndroidGraphicsBitmap).compress(Bitmap.CompressFormat.JPEG, 30, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      bina.a(this.jdField_a_of_type_Bind.a, bina.a(this.jdField_a_of_type_Bind.a) + localObject.length);
      if (bina.a(this.jdField_a_of_type_Bind.a) > bina.b(this.jdField_a_of_type_Bind.a))
      {
        bina.a(this.jdField_a_of_type_Bind.a, bina.a(this.jdField_a_of_type_Bind.a) - localObject.length);
        aung.a("Q.videostory", "Q.videostory.capture", "onCapture", "size to larger");
        localByteArrayOutputStream.close();
        bina.a(this.jdField_a_of_type_Bind.a).setCaptureRequest(null);
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    Object localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
    this.jdField_a_of_type_Bind.a.a.add(localObject);
    localIOException.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.11.1
 * JD-Core Version:    0.7.0.1
 */