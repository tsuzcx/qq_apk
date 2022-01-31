import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;

public class kmt
  implements AsyncBack
{
  public kmt(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kmt
 * JD-Core Version:    0.7.0.1
 */