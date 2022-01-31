import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class ras
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  ras(ran paramran) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    rau localrau = (rau)ran.a(this.a).get(Integer.valueOf(paramInt));
    if (localrau != null) {}
    try
    {
      localrau.jdField_b_of_type_Long = rai.a(paramBitmap, true);
      localrau.jdField_b_of_type_Int = rai.a(localrau.a, localrau.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(ran.a(), 2, "onExtractFrame frameIndex = " + paramInt + ", localHash = " + localrau.jdField_b_of_type_Long + ", hashDiff = " + localrau.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ran.a(), 2, "VideoExtractFrameHash.dctImageHash ERROR e = " + paramBitmap.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ras
 * JD-Core Version:    0.7.0.1
 */