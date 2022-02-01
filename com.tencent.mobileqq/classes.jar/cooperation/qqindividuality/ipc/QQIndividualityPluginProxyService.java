package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bkkq;
import bkkz;
import bkro;
import bkrv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static bkro jdField_a_of_type_Bkro;
  private static bkrv jdField_a_of_type_Bkrv;
  
  public static bkro a()
  {
    if (jdField_a_of_type_Bkro == null) {}
    try
    {
      if (jdField_a_of_type_Bkro == null) {
        jdField_a_of_type_Bkro = new bkro(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bkro;
    }
    finally {}
  }
  
  public static bkrv a()
  {
    if (jdField_a_of_type_Bkrv == null) {}
    try
    {
      if (jdField_a_of_type_Bkrv == null) {
        jdField_a_of_type_Bkrv = new bkrv(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bkrv;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Bkrv != null)
    {
      jdField_a_of_type_Bkrv.b("qqindividuality_signature");
      jdField_a_of_type_Bkrv = null;
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
    bkkz localbkkz = new bkkz(0);
    localbkkz.b = "qqindividuality_plugin.apk";
    localbkkz.d = PluginInfo.m;
    localbkkz.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbkkz.e = paramString;
    localbkkz.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbkkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bkkq.c(paramAppRuntime.getApplication(), localbkkz);
  }
  
  public static boolean a()
  {
    bkro localbkro = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbkro.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbkro);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */