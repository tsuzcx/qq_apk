import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.av.redpacket.SoundPoolHelper;
import com.tencent.av.redpacket.SoundPoolHelper.OnLoadFinishListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

public class jlw
  implements SoundPool.OnLoadCompleteListener
{
  public jlw(SoundPoolHelper paramSoundPoolHelper, SoundPoolHelper.OnLoadFinishListener paramOnLoadFinishListener) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    paramSoundPool = this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper;
    paramSoundPool.c += 1;
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "loadMusic onLoadComplete,sampleId = " + paramInt1 + ",status = " + paramInt2 + ",loadedCount = " + this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.c + ",musicCount = " + this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.b);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.a.add(Integer.valueOf(paramInt1));
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.c == this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.b) {
      this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper$OnLoadFinishListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jlw
 * JD-Core Version:    0.7.0.1
 */