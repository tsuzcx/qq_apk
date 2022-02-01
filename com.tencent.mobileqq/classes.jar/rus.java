import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class rus
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  rus(run paramrun) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    ruu localruu = (ruu)run.a(this.a).get(Integer.valueOf(paramInt));
    if (localruu != null) {}
    try
    {
      localruu.jdField_b_of_type_Long = rui.a(paramBitmap, true);
      localruu.jdField_b_of_type_Int = rui.a(localruu.a, localruu.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(run.a(), 2, "onExtractFrame frameIndex = " + paramInt + ", localHash = " + localruu.jdField_b_of_type_Long + ", hashDiff = " + localruu.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(run.a(), 2, "VideoExtractFrameHash.dctImageHash ERROR e = " + paramBitmap.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rus
 * JD-Core Version:    0.7.0.1
 */