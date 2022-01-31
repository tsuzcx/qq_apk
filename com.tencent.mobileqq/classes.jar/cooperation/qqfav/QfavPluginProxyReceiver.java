package cooperation.qqfav;

import android.content.Intent;
import bgkq;
import bgkz;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    bgkz localbgkz = new bgkz(0);
    localbgkz.b = "qqfav.apk";
    localbgkz.d = "qqfav.apk";
    localbgkz.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbgkz.e = "com.qqfav.ipc.QfavPluginReceiver";
    localbgkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
    bgkq.b(paramAppRuntime.getApplication(), localbgkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */