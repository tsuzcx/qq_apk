import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class qll
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  qll(qlg paramqlg) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    qln localqln = (qln)qlg.a(this.a).get(Integer.valueOf(paramInt));
    if (localqln != null) {}
    try
    {
      localqln.jdField_b_of_type_Long = qlb.a(paramBitmap, true);
      localqln.jdField_b_of_type_Int = qlb.a(localqln.a, localqln.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(qlg.a(), 2, "onExtractFrame frameIndex = " + paramInt + ", localHash = " + localqln.jdField_b_of_type_Long + ", hashDiff = " + localqln.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(qlg.a(), 2, "VideoExtractFrameHash.dctImageHash ERROR e = " + paramBitmap.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qll
 * JD-Core Version:    0.7.0.1
 */