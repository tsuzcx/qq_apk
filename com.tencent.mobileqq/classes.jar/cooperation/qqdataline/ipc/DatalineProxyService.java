package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import blvy;
import blwh;
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
    blwh localblwh = new blwh(0);
    localblwh.b = "qqdataline.apk";
    localblwh.d = PluginInfo.d;
    localblwh.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblwh.e = "com.qqdataline.ipc.QQDatalineService";
    localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    localblwh.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    blvy.c(paramAppRuntime.getApplication(), localblwh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */