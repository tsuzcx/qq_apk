package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bgkq;
import bgkz;
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
    bgkz localbgkz = new bgkz(0);
    localbgkz.b = "qqdataline.apk";
    localbgkz.d = PluginInfo.d;
    localbgkz.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbgkz.e = "com.qqdataline.ipc.QQDatalineService";
    localbgkz.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbgkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bgkq.c(paramAppRuntime.getApplication(), localbgkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */