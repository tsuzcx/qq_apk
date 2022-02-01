package dov.com.qq.im.ae.camera.ui.capture;

import aana;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import azjq;
import bnef;
import bneo;
import bnrh;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class VideoStoryCapturePart$9$1
  implements Runnable
{
  public VideoStoryCapturePart$9$1(bneo parambneo, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 0) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= 0))
      {
        bnrh.d("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = aana.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      long l = ((Long)VSConfigManager.getInstance().getValue("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, (int)l, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      bnef.a(this.jdField_a_of_type_Bneo.a, bnef.a(this.jdField_a_of_type_Bneo.a) + localObject.length);
      if (bnef.a(this.jdField_a_of_type_Bneo.a) > bnef.b(this.jdField_a_of_type_Bneo.a))
      {
        bnef.a(this.jdField_a_of_type_Bneo.a, bnef.a(this.jdField_a_of_type_Bneo.a) - localObject.length);
        azjq.a("Q.videostory", "Q.videostory.capture", "onExtract", "size to larger");
        localByteArrayOutputStream.close();
        bnef.a(this.jdField_a_of_type_Bneo.a).setCaptureRequest(null);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Object localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
    this.jdField_a_of_type_Bneo.a.a.add(localObject);
    localException.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.9.1
 * JD-Core Version:    0.7.0.1
 */