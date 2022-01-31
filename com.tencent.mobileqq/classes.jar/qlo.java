import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class qlo
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  qlo(qlj paramqlj) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    qlq localqlq = (qlq)qlj.a(this.a).get(Integer.valueOf(paramInt));
    if (localqlq != null) {}
    try
    {
      localqlq.jdField_b_of_type_Long = qle.a(paramBitmap, true);
      localqlq.jdField_b_of_type_Int = qle.a(localqlq.a, localqlq.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(qlj.a(), 2, "onExtractFrame frameIndex = " + paramInt + ", localHash = " + localqlq.jdField_b_of_type_Long + ", hashDiff = " + localqlq.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(qlj.a(), 2, "VideoExtractFrameHash.dctImageHash ERROR e = " + paramBitmap.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlo
 * JD-Core Version:    0.7.0.1
 */