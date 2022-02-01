package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bmgk;
import bmgt;
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
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = "qqdataline.apk";
    localbmgt.d = PluginInfo.d;
    localbmgt.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbmgt.e = "com.qqdataline.ipc.QQDatalineService";
    localbmgt.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbmgt.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bmgk.c(paramAppRuntime.getApplication(), localbmgt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */