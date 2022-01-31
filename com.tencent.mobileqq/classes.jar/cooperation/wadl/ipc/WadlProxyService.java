package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.open.wadl.WLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    WLog.b("WadlProxyService", "bindWadlService proxy WadlRemoteService");
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qqwadl.apk";
    localPluginParams.d = "qqwadl";
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams.e = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    IPluginManager.b(paramAppRuntime.getApplication(), localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */