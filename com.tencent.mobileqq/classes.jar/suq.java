import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class suq
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private suq(sup paramsup) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON appstatus=" + sup.a(this.jdField_a_of_type_Sup));
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
              QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF appstatus = " + sup.a(this.jdField_a_of_type_Sup));
            }
          } while (sup.a(this.jdField_a_of_type_Sup) != 2);
          this.jdField_a_of_type_Sup.a();
          this.jdField_a_of_type_Sup.c();
          return;
        } while (!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_USER_PRESENT app status=" + sup.a(this.jdField_a_of_type_Sup));
        }
      } while ((sup.a(this.jdField_a_of_type_Sup) != 2) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)));
      paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramContext == null);
    this.jdField_a_of_type_Sup.a(paramContext, NetConnInfoCenter.getServerTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     suq
 * JD-Core Version:    0.7.0.1
 */