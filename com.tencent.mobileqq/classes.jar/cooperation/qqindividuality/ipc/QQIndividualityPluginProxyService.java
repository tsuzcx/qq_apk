package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static QQIndividualityRemoteProxy a;
  private static IndividualityRemoteCommand b;
  
  public static QQIndividualityRemoteProxy a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QQIndividualityRemoteProxy(BaseApplicationImpl.getApplication().getRuntime());
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    paramAppRuntime.getApplication().unbindService(paramServiceConnection);
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QQIndividualityPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "qqindividuality_plugin.apk";
    localPluginParams.g = PluginInfo.m;
    localPluginParams.c = paramAppRuntime.getAccount();
    localPluginParams.h = paramString;
    localPluginParams.j = localIntent;
    localPluginParams.o = paramServiceConnection;
    IPluginManager.c(paramAppRuntime.getApplication(), localPluginParams);
  }
  
  public static void b()
  {
    QQIndividualityRemoteProxy localQQIndividualityRemoteProxy = a;
    if (localQQIndividualityRemoteProxy != null)
    {
      localQQIndividualityRemoteProxy.b("qqindividuality_signature");
      a = null;
    }
  }
  
  public static IndividualityRemoteCommand c()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new IndividualityRemoteCommand(BaseApplicationImpl.getApplication().getRuntime());
        }
      }
      finally {}
    }
    return b;
  }
  
  public static boolean d()
  {
    IndividualityRemoteCommand localIndividualityRemoteCommand = c();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localIndividualityRemoteCommand.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localIndividualityRemoteCommand);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */