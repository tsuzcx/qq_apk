package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bkkq;
import bkkz;
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
    bkkz localbkkz = new bkkz(0);
    localbkkz.b = "qqdataline.apk";
    localbkkz.d = PluginInfo.d;
    localbkkz.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbkkz.e = "com.qqdataline.ipc.QQDatalineService";
    localbkkz.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbkkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bkkq.c(paramAppRuntime.getApplication(), localbkkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */