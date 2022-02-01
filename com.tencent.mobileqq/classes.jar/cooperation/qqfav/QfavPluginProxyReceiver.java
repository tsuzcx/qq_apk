package cooperation.qqfav;

import android.content.Intent;
import bkkq;
import bkkz;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    bkkz localbkkz = new bkkz(0);
    localbkkz.b = "qqfav.apk";
    localbkkz.d = "qqfav.apk";
    localbkkz.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbkkz.e = "com.qqfav.ipc.QfavPluginReceiver";
    localbkkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
    bkkq.b(paramAppRuntime.getApplication(), localbkkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */