package cooperation.qqfav;

import android.content.Intent;
import bmgk;
import bmgt;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = "qqfav.apk";
    localbmgt.d = "qqfav.apk";
    localbmgt.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbmgt.e = "com.qqfav.ipc.QfavPluginReceiver";
    localbmgt.jdField_a_of_type_AndroidContentIntent = paramIntent;
    bmgk.b(paramAppRuntime.getApplication(), localbmgt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */