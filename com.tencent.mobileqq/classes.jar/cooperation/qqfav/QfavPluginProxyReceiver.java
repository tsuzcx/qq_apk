package cooperation.qqfav;

import android.content.Intent;
import bimg;
import bimp;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    bimp localbimp = new bimp(0);
    localbimp.b = "qqfav.apk";
    localbimp.d = "qqfav.apk";
    localbimp.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbimp.e = "com.qqfav.ipc.QfavPluginReceiver";
    localbimp.jdField_a_of_type_AndroidContentIntent = paramIntent;
    bimg.b(paramAppRuntime.getApplication(), localbimp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */