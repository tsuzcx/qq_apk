import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class lju
  implements SoundPool.OnLoadCompleteListener
{
  lju(ljt paramljt, ljv paramljv) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    paramSoundPool = this.jdField_a_of_type_Ljt;
    paramSoundPool.c += 1;
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "loadMusic onLoadComplete,sampleId = " + paramInt1 + ",status = " + paramInt2 + ",loadedCount = " + this.jdField_a_of_type_Ljt.c + ",musicCount = " + this.jdField_a_of_type_Ljt.b);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_Ljt.a.add(Integer.valueOf(paramInt1));
    }
    if (this.jdField_a_of_type_Ljt.c == this.jdField_a_of_type_Ljt.b) {
      this.jdField_a_of_type_Ljv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lju
 * JD-Core Version:    0.7.0.1
 */