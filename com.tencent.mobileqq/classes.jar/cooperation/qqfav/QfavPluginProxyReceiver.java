package cooperation.qqfav;

import android.content.Intent;
import bfcz;
import bfdi;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    bfdi localbfdi = new bfdi(0);
    localbfdi.b = "qqfav.apk";
    localbfdi.d = "qqfav.apk";
    localbfdi.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbfdi.e = "com.qqfav.ipc.QfavPluginReceiver";
    localbfdi.jdField_a_of_type_AndroidContentIntent = paramIntent;
    bfcz.b(paramAppRuntime.getApplication(), localbfdi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */