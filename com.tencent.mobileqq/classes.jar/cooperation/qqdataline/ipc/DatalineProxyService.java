package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bfcz;
import bfdi;
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
    bfdi localbfdi = new bfdi(0);
    localbfdi.b = "qqdataline.apk";
    localbfdi.d = PluginInfo.d;
    localbfdi.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbfdi.e = "com.qqdataline.ipc.QQDatalineService";
    localbfdi.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbfdi.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bfcz.c(paramAppRuntime.getApplication(), localbfdi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */