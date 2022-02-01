package dov.com.qq.im.ae.camera.ui.capture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import ayde;
import blqw;
import blrf;
import bmbx;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.util.List;
import zxo;

public class VideoStoryCapturePart$9$1
  implements Runnable
{
  public VideoStoryCapturePart$9$1(blrf paramblrf, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 0) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= 0))
      {
        bmbx.d("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = zxo.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      long l = ((Long)VSConfigManager.getInstance().getValue("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, (int)l, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      blqw.a(this.jdField_a_of_type_Blrf.a, blqw.a(this.jdField_a_of_type_Blrf.a) + localObject.length);
      if (blqw.a(this.jdField_a_of_type_Blrf.a) > blqw.b(this.jdField_a_of_type_Blrf.a))
      {
        blqw.a(this.jdField_a_of_type_Blrf.a, blqw.a(this.jdField_a_of_type_Blrf.a) - localObject.length);
        ayde.a("Q.videostory", "Q.videostory.capture", "onExtract", "size to larger");
        localByteArrayOutputStream.close();
        blqw.a(this.jdField_a_of_type_Blrf.a).setCaptureRequest(null);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Object localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
    this.jdField_a_of_type_Blrf.a.a.add(localObject);
    localException.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.9.1
 * JD-Core Version:    0.7.0.1
 */