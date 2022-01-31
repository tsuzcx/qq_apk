package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bgkq;
import bgkz;
import bgrw;
import bgsd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static bgrw jdField_a_of_type_Bgrw;
  private static bgsd jdField_a_of_type_Bgsd;
  
  public static bgrw a()
  {
    if (jdField_a_of_type_Bgrw == null) {}
    try
    {
      if (jdField_a_of_type_Bgrw == null) {
        jdField_a_of_type_Bgrw = new bgrw(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bgrw;
    }
    finally {}
  }
  
  public static bgsd a()
  {
    if (jdField_a_of_type_Bgsd == null) {}
    try
    {
      if (jdField_a_of_type_Bgsd == null) {
        jdField_a_of_type_Bgsd = new bgsd(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bgsd;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Bgsd != null)
    {
      jdField_a_of_type_Bgsd.b("qqindividuality_signature");
      jdField_a_of_type_Bgsd = null;
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
    bgkz localbgkz = new bgkz(0);
    localbgkz.b = "qqindividuality_plugin.apk";
    localbgkz.d = PluginInfo.m;
    localbgkz.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbgkz.e = paramString;
    localbgkz.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbgkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bgkq.c(paramAppRuntime.getApplication(), localbgkz);
  }
  
  public static boolean a()
  {
    bgrw localbgrw = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbgrw.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbgrw);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */