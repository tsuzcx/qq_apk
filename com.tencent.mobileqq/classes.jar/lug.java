import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class lug
  implements SoundPool.OnLoadCompleteListener
{
  lug(luf paramluf, luh paramluh) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    paramSoundPool = this.jdField_a_of_type_Luf;
    paramSoundPool.c += 1;
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "loadMusic onLoadComplete,sampleId = " + paramInt1 + ",status = " + paramInt2 + ",loadedCount = " + this.jdField_a_of_type_Luf.c + ",musicCount = " + this.jdField_a_of_type_Luf.b);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_Luf.a.add(Integer.valueOf(paramInt1));
    }
    if (this.jdField_a_of_type_Luf.c == this.jdField_a_of_type_Luf.b) {
      this.jdField_a_of_type_Luh.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lug
 * JD-Core Version:    0.7.0.1
 */