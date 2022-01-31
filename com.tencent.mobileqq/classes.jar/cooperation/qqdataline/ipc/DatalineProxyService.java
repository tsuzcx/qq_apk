package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bimg;
import bimp;
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
    bimp localbimp = new bimp(0);
    localbimp.b = "qqdataline.apk";
    localbimp.d = PluginInfo.d;
    localbimp.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbimp.e = "com.qqdataline.ipc.QQDatalineService";
    localbimp.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbimp.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bimg.c(paramAppRuntime.getApplication(), localbimp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */