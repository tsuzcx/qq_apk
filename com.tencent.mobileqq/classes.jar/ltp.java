import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class ltp
  implements SoundPool.OnLoadCompleteListener
{
  ltp(lto paramlto, ltq paramltq) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    paramSoundPool = this.jdField_a_of_type_Lto;
    paramSoundPool.c += 1;
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "loadMusic onLoadComplete,sampleId = " + paramInt1 + ",status = " + paramInt2 + ",loadedCount = " + this.jdField_a_of_type_Lto.c + ",musicCount = " + this.jdField_a_of_type_Lto.b);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_Lto.a.add(Integer.valueOf(paramInt1));
    }
    if (this.jdField_a_of_type_Lto.c == this.jdField_a_of_type_Lto.b) {
      this.jdField_a_of_type_Ltq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ltp
 * JD-Core Version:    0.7.0.1
 */