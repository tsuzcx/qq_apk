package cooperation.qqfav;

import android.content.Intent;
import biqn;
import biqw;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    biqw localbiqw = new biqw(0);
    localbiqw.b = "qqfav.apk";
    localbiqw.d = "qqfav.apk";
    localbiqw.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbiqw.e = "com.qqfav.ipc.QfavPluginReceiver";
    localbiqw.jdField_a_of_type_AndroidContentIntent = paramIntent;
    biqn.b(paramAppRuntime.getApplication(), localbiqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */