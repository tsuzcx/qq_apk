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
  private static FavoritesRemoteCommand jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand;
  private static QfavRemoteProxyForQQ jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ;
  
  public static FavoritesRemoteCommand a()
  {
    if (jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand == null) {
      try
      {
        if (jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand == null) {
          jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand = new FavoritesRemoteCommand(BaseApplicationImpl.getApplication().getRuntime());
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand;
  }
  
  public static QfavRemoteProxyForQQ a()
  {
    if (jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ == null) {
      try
      {
        if (jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ == null) {
          jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ = new QfavRemoteProxyForQQ(BaseApplicationImpl.getApplication().getRuntime());
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ;
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QfavPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qqfav.apk";
    localPluginParams.e = "qqfav.apk";
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams.f = paramString;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    IPluginManager.c(paramAppRuntime.getApplication(), localPluginParams);
  }
  
  public static boolean a()
  {
    FavoritesRemoteCommand localFavoritesRemoteCommand = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localFavoritesRemoteCommand.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localFavoritesRemoteCommand);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */