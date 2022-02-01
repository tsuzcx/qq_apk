import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class rnq
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  rnq(rnl paramrnl) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    rns localrns = (rns)rnl.a(this.a).get(Integer.valueOf(paramInt));
    if (localrns != null) {}
    try
    {
      localrns.jdField_b_of_type_Long = rng.a(paramBitmap, true);
      localrns.jdField_b_of_type_Int = rng.a(localrns.a, localrns.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(rnl.a(), 2, "onExtractFrame frameIndex = " + paramInt + ", localHash = " + localrns.jdField_b_of_type_Long + ", hashDiff = " + localrns.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(rnl.a(), 2, "VideoExtractFrameHash.dctImageHash ERROR e = " + paramBitmap.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnq
 * JD-Core Version:    0.7.0.1
 */