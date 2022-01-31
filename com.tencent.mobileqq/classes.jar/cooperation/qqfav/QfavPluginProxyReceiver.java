package cooperation.qqfav;

import android.content.Intent;
import bglh;
import bglq;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    bglq localbglq = new bglq(0);
    localbglq.b = "qqfav.apk";
    localbglq.d = "qqfav.apk";
    localbglq.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbglq.e = "com.qqfav.ipc.QfavPluginReceiver";
    localbglq.jdField_a_of_type_AndroidContentIntent = paramIntent;
    bglh.b(paramAppRuntime.getApplication(), localbglq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */