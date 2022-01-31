import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class rcy
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private rcy(rcx paramrcx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON appstatus=" + rcx.a(this.jdField_a_of_type_Rcx));
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
              QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF appstatus = " + rcx.a(this.jdField_a_of_type_Rcx));
            }
          } while (rcx.a(this.jdField_a_of_type_Rcx) != 2);
          this.jdField_a_of_type_Rcx.a();
          this.jdField_a_of_type_Rcx.c();
          return;
        } while (!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_USER_PRESENT app status=" + rcx.a(this.jdField_a_of_type_Rcx));
        }
      } while ((rcx.a(this.jdField_a_of_type_Rcx) != 2) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)));
      paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramContext == null);
    this.jdField_a_of_type_Rcx.a(paramContext, NetConnInfoCenter.getServerTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rcy
 * JD-Core Version:    0.7.0.1
 */