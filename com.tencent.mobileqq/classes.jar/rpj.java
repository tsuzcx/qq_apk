import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class rpj
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private rpj(rpi paramrpi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON appstatus=" + rpi.a(this.jdField_a_of_type_Rpi));
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF appstatus = " + rpi.a(this.jdField_a_of_type_Rpi));
            }
          } while (rpi.a(this.jdField_a_of_type_Rpi) != 2);
          this.jdField_a_of_type_Rpi.a();
          this.jdField_a_of_type_Rpi.c();
          return;
        } while (!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_USER_PRESENT app status=" + rpi.a(this.jdField_a_of_type_Rpi));
        }
      } while ((rpi.a(this.jdField_a_of_type_Rpi) != 2) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)));
      paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramContext == null);
    this.jdField_a_of_type_Rpi.a(paramContext, NetConnInfoCenter.getServerTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpj
 * JD-Core Version:    0.7.0.1
 */