package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bglh;
import bglq;
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
    bglq localbglq = new bglq(0);
    localbglq.b = "qqdataline.apk";
    localbglq.d = PluginInfo.d;
    localbglq.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbglq.e = "com.qqdataline.ipc.QQDatalineService";
    localbglq.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbglq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bglh.c(paramAppRuntime.getApplication(), localbglq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */