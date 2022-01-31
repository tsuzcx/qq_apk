import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class lwn
  implements SoundPool.OnLoadCompleteListener
{
  lwn(lwm paramlwm, lwo paramlwo) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    paramSoundPool = this.jdField_a_of_type_Lwm;
    paramSoundPool.c += 1;
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "loadMusic onLoadComplete,sampleId = " + paramInt1 + ",status = " + paramInt2 + ",loadedCount = " + this.jdField_a_of_type_Lwm.c + ",musicCount = " + this.jdField_a_of_type_Lwm.b);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_Lwm.a.add(Integer.valueOf(paramInt1));
    }
    if (this.jdField_a_of_type_Lwm.c == this.jdField_a_of_type_Lwm.b) {
      this.jdField_a_of_type_Lwo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lwn
 * JD-Core Version:    0.7.0.1
 */