import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class nek
{
  public nek(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.TAG, 1, "CheckPermission user denied = ");
    }
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "false", "{result: -10, msg: 'no permission to record'}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.TAG, 1, "CheckPermission user grant = ");
    }
    SensorAPIJavaScript.a(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nek
 * JD-Core Version:    0.7.0.1
 */