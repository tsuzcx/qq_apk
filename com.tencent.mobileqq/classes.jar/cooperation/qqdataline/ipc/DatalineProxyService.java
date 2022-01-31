package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import biqn;
import biqw;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class DatalineProxyService
  extends PluginProxyService
{
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), DatalineProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    biqw localbiqw = new biqw(0);
    localbiqw.b = "qqdataline.apk";
    localbiqw.d = PluginInfo.d;
    localbiqw.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbiqw.e = "com.qqdataline.ipc.QQDatalineService";
    localbiqw.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbiqw.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    biqn.c(paramAppRuntime.getApplication(), localbiqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */