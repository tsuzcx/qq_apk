package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import blvy;
import blwh;
import bmcx;
import bmde;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static bmcx jdField_a_of_type_Bmcx;
  private static bmde jdField_a_of_type_Bmde;
  
  public static bmcx a()
  {
    if (jdField_a_of_type_Bmcx == null) {}
    try
    {
      if (jdField_a_of_type_Bmcx == null) {
        jdField_a_of_type_Bmcx = new bmcx(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bmcx;
    }
    finally {}
  }
  
  public static bmde a()
  {
    if (jdField_a_of_type_Bmde == null) {}
    try
    {
      if (jdField_a_of_type_Bmde == null) {
        jdField_a_of_type_Bmde = new bmde(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bmde;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Bmde != null)
    {
      jdField_a_of_type_Bmde.b("qqindividuality_signature");
      jdField_a_of_type_Bmde = null;
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
    blwh localblwh = new blwh(0);
    localblwh.b = "qqindividuality_plugin.apk";
    localblwh.d = PluginInfo.m;
    localblwh.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblwh.e = paramString;
    localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    localblwh.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    blvy.c(paramAppRuntime.getApplication(), localblwh);
  }
  
  public static boolean a()
  {
    bmcx localbmcx = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbmcx.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbmcx);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */