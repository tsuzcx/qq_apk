package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bglh;
import bglq;
import bgsn;
import bgsu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static bgsn jdField_a_of_type_Bgsn;
  private static bgsu jdField_a_of_type_Bgsu;
  
  public static bgsn a()
  {
    if (jdField_a_of_type_Bgsn == null) {}
    try
    {
      if (jdField_a_of_type_Bgsn == null) {
        jdField_a_of_type_Bgsn = new bgsn(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bgsn;
    }
    finally {}
  }
  
  public static bgsu a()
  {
    if (jdField_a_of_type_Bgsu == null) {}
    try
    {
      if (jdField_a_of_type_Bgsu == null) {
        jdField_a_of_type_Bgsu = new bgsu(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bgsu;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Bgsu != null)
    {
      jdField_a_of_type_Bgsu.b("qqindividuality_signature");
      jdField_a_of_type_Bgsu = null;
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
    bglq localbglq = new bglq(0);
    localbglq.b = "qqindividuality_plugin.apk";
    localbglq.d = PluginInfo.m;
    localbglq.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbglq.e = paramString;
    localbglq.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbglq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bglh.c(paramAppRuntime.getApplication(), localbglq);
  }
  
  public static boolean a()
  {
    bgsn localbgsn = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbgsn.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbgsn);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */