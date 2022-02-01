import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class rwu
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  rwu(rwp paramrwp) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    rww localrww = (rww)rwp.a(this.a).get(Integer.valueOf(paramInt));
    if (localrww != null) {}
    try
    {
      localrww.jdField_b_of_type_Long = rwk.a(paramBitmap, true);
      localrww.jdField_b_of_type_Int = rwk.a(localrww.a, localrww.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(rwp.a(), 2, "onExtractFrame frameIndex = " + paramInt + ", localHash = " + localrww.jdField_b_of_type_Long + ", hashDiff = " + localrww.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(rwp.a(), 2, "VideoExtractFrameHash.dctImageHash ERROR e = " + paramBitmap.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwu
 * JD-Core Version:    0.7.0.1
 */