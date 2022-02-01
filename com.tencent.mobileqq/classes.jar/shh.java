import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class shh
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  shh(shc paramshc) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    shj localshj = (shj)shc.a(this.a).get(Integer.valueOf(paramInt));
    if (localshj != null) {}
    try
    {
      localshj.jdField_b_of_type_Long = sgx.a(paramBitmap, true);
      localshj.jdField_b_of_type_Int = sgx.a(localshj.a, localshj.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(shc.a(), 2, "onExtractFrame frameIndex = " + paramInt + ", localHash = " + localshj.jdField_b_of_type_Long + ", hashDiff = " + localshj.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(shc.a(), 2, "VideoExtractFrameHash.dctImageHash ERROR e = " + paramBitmap.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shh
 * JD-Core Version:    0.7.0.1
 */