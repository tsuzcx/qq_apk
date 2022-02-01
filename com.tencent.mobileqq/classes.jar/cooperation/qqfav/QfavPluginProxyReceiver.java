package cooperation.qqfav;

import android.content.Intent;
import blfh;
import blfq;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    blfq localblfq = new blfq(0);
    localblfq.b = "qqfav.apk";
    localblfq.d = "qqfav.apk";
    localblfq.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblfq.e = "com.qqfav.ipc.QfavPluginReceiver";
    localblfq.jdField_a_of_type_AndroidContentIntent = paramIntent;
    blfh.b(paramAppRuntime.getApplication(), localblfq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */