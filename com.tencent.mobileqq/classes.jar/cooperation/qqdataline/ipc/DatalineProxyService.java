package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import blfh;
import blfq;
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
    blfq localblfq = new blfq(0);
    localblfq.b = "qqdataline.apk";
    localblfq.d = PluginInfo.d;
    localblfq.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblfq.e = "com.qqdataline.ipc.QQDatalineService";
    localblfq.jdField_a_of_type_AndroidContentIntent = localIntent;
    localblfq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    blfh.c(paramAppRuntime.getApplication(), localblfq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */