package cooperation.qqfav;

import android.content.Intent;
import blvy;
import blwh;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    blwh localblwh = new blwh(0);
    localblwh.b = "qqfav.apk";
    localblwh.d = "qqfav.apk";
    localblwh.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblwh.e = "com.qqfav.ipc.QfavPluginReceiver";
    localblwh.jdField_a_of_type_AndroidContentIntent = paramIntent;
    blvy.b(paramAppRuntime.getApplication(), localblwh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */