package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import blfh;
import blfq;
import blme;
import blml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static blme jdField_a_of_type_Blme;
  private static blml jdField_a_of_type_Blml;
  
  public static blme a()
  {
    if (jdField_a_of_type_Blme == null) {}
    try
    {
      if (jdField_a_of_type_Blme == null) {
        jdField_a_of_type_Blme = new blme(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Blme;
    }
    finally {}
  }
  
  public static blml a()
  {
    if (jdField_a_of_type_Blml == null) {}
    try
    {
      if (jdField_a_of_type_Blml == null) {
        jdField_a_of_type_Blml = new blml(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Blml;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Blml != null)
    {
      jdField_a_of_type_Blml.b("qqindividuality_signature");
      jdField_a_of_type_Blml = null;
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
    blfq localblfq = new blfq(0);
    localblfq.b = "qqindividuality_plugin.apk";
    localblfq.d = PluginInfo.m;
    localblfq.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblfq.e = paramString;
    localblfq.jdField_a_of_type_AndroidContentIntent = localIntent;
    localblfq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    blfh.c(paramAppRuntime.getApplication(), localblfq);
  }
  
  public static boolean a()
  {
    blme localblme = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localblme.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localblme);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */