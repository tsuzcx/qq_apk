package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class DatalineProxyService
  extends PluginProxyService
{
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), DatalineProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "qqdataline.apk";
    localPluginParams.g = PluginInfo.d;
    localPluginParams.c = paramAppRuntime.getAccount();
    localPluginParams.h = "com.qqdataline.ipc.QQDatalineService";
    localPluginParams.j = localIntent;
    localPluginParams.o = paramServiceConnection;
    IPluginManager.c(paramAppRuntime.getApplication(), localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */