package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import biqn;
import biqw;
import bixt;
import biya;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static bixt jdField_a_of_type_Bixt;
  private static biya jdField_a_of_type_Biya;
  
  public static bixt a()
  {
    if (jdField_a_of_type_Bixt == null) {}
    try
    {
      if (jdField_a_of_type_Bixt == null) {
        jdField_a_of_type_Bixt = new bixt(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bixt;
    }
    finally {}
  }
  
  public static biya a()
  {
    if (jdField_a_of_type_Biya == null) {}
    try
    {
      if (jdField_a_of_type_Biya == null) {
        jdField_a_of_type_Biya = new biya(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Biya;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Biya != null)
    {
      jdField_a_of_type_Biya.b("qqindividuality_signature");
      jdField_a_of_type_Biya = null;
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
    biqw localbiqw = new biqw(0);
    localbiqw.b = "qqindividuality_plugin.apk";
    localbiqw.d = PluginInfo.m;
    localbiqw.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbiqw.e = paramString;
    localbiqw.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbiqw.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    biqn.c(paramAppRuntime.getApplication(), localbiqw);
  }
  
  public static boolean a()
  {
    bixt localbixt = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbixt.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbixt);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */