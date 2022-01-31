package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bimg;
import bimp;
import bitm;
import bitt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static bitm jdField_a_of_type_Bitm;
  private static bitt jdField_a_of_type_Bitt;
  
  public static bitm a()
  {
    if (jdField_a_of_type_Bitm == null) {}
    try
    {
      if (jdField_a_of_type_Bitm == null) {
        jdField_a_of_type_Bitm = new bitm(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bitm;
    }
    finally {}
  }
  
  public static bitt a()
  {
    if (jdField_a_of_type_Bitt == null) {}
    try
    {
      if (jdField_a_of_type_Bitt == null) {
        jdField_a_of_type_Bitt = new bitt(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bitt;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Bitt != null)
    {
      jdField_a_of_type_Bitt.b("qqindividuality_signature");
      jdField_a_of_type_Bitt = null;
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
    bimp localbimp = new bimp(0);
    localbimp.b = "qqindividuality_plugin.apk";
    localbimp.d = PluginInfo.m;
    localbimp.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbimp.e = paramString;
    localbimp.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbimp.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bimg.c(paramAppRuntime.getApplication(), localbimp);
  }
  
  public static boolean a()
  {
    bitm localbitm = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbitm.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbitm);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */