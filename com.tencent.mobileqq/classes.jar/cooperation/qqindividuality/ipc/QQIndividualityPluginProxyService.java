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
  private static IndividualityRemoteCommand jdField_a_of_type_CooperationQqindividualityIpcIndividualityRemoteCommand = null;
  private static QQIndividualityRemoteProxy jdField_a_of_type_CooperationQqindividualityIpcQQIndividualityRemoteProxy = null;
  
  public static IndividualityRemoteCommand a()
  {
    if (jdField_a_of_type_CooperationQqindividualityIpcIndividualityRemoteCommand == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqindividualityIpcIndividualityRemoteCommand == null) {
        jdField_a_of_type_CooperationQqindividualityIpcIndividualityRemoteCommand = new IndividualityRemoteCommand(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_CooperationQqindividualityIpcIndividualityRemoteCommand;
    }
    finally {}
  }
  
  public static QQIndividualityRemoteProxy a()
  {
    if (jdField_a_of_type_CooperationQqindividualityIpcQQIndividualityRemoteProxy == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqindividualityIpcQQIndividualityRemoteProxy == null) {
        jdField_a_of_type_CooperationQqindividualityIpcQQIndividualityRemoteProxy = new QQIndividualityRemoteProxy(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_CooperationQqindividualityIpcQQIndividualityRemoteProxy;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_CooperationQqindividualityIpcQQIndividualityRemoteProxy != null)
    {
      jdField_a_of_type_CooperationQqindividualityIpcQQIndividualityRemoteProxy.b("qqindividuality_signature");
      jdField_a_of_type_CooperationQqindividualityIpcQQIndividualityRemoteProxy = null;
    }
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
    localPluginParams.b = "qqindividuality_plugin.apk";
    localPluginParams.e = PluginInfo.m;
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams.f = paramString;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    IPluginManager.c(paramAppRuntime.getApplication(), localPluginParams);
  }
  
  public static boolean a()
  {
    IndividualityRemoteCommand localIndividualityRemoteCommand = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localIndividualityRemoteCommand.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localIndividualityRemoteCommand);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */