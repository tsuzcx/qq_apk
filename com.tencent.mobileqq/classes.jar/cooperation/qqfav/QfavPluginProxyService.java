package cooperation.qqfav;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.ipc.FavoritesRemoteCommand;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ;
import mqq.app.AppRuntime;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static QfavRemoteProxyForQQ a;
  private static FavoritesRemoteCommand b;
  
  public static QfavRemoteProxyForQQ a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QfavRemoteProxyForQQ(BaseApplicationImpl.getApplication().getRuntime());
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QfavPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "qqfav.apk";
    localPluginParams.g = "qqfav.apk";
    localPluginParams.c = paramAppRuntime.getAccount();
    localPluginParams.h = paramString;
    localPluginParams.j = localIntent;
    localPluginParams.o = paramServiceConnection;
    IPluginManager.c(paramAppRuntime.getApplication(), localPluginParams);
  }
  
  public static FavoritesRemoteCommand b()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new FavoritesRemoteCommand(BaseApplicationImpl.getApplication().getRuntime());
        }
      }
      finally {}
    }
    return b;
  }
  
  public static boolean c()
  {
    FavoritesRemoteCommand localFavoritesRemoteCommand = b();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localFavoritesRemoteCommand.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localFavoritesRemoteCommand);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */