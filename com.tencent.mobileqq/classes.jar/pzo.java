import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class pzo
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  pzo(pzj parampzj) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    pzq localpzq = (pzq)pzj.a(this.a).get(Integer.valueOf(paramInt));
    if (localpzq != null) {}
    try
    {
      localpzq.jdField_b_of_type_Long = pze.a(paramBitmap, true);
      localpzq.jdField_b_of_type_Int = pze.a(localpzq.a, localpzq.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(pzj.a(), 2, "onExtractFrame frameIndex = " + paramInt + ", localHash = " + localpzq.jdField_b_of_type_Long + ", hashDiff = " + localpzq.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(pzj.a(), 2, "VideoExtractFrameHash.dctImageHash ERROR e = " + paramBitmap.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzo
 * JD-Core Version:    0.7.0.1
 */