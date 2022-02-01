package cooperation.qqfav;

import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qqfav.apk";
    localPluginParams.e = "qqfav.apk";
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams.f = "com.qqfav.ipc.QfavPluginReceiver";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    IPluginManager.b(paramAppRuntime.getApplication(), localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */