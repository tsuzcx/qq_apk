import android.text.TextUtils;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;

public class nbv
  implements myy
{
  public nbv(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("forceUpdate", 2, "loaded code:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.notifyCacheReady(paramInt);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nbv
 * JD-Core Version:    0.7.0.1
 */