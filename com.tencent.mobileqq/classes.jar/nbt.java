import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;

public class nbt
  implements SoundPool.OnLoadCompleteListener
{
  public nbt(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SensorApi", 2, "play failure url=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nbt
 * JD-Core Version:    0.7.0.1
 */