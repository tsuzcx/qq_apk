package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bmgk;
import bmgt;
import bmnh;
import bmno;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static bmnh jdField_a_of_type_Bmnh;
  private static bmno jdField_a_of_type_Bmno;
  
  public static bmnh a()
  {
    if (jdField_a_of_type_Bmnh == null) {}
    try
    {
      if (jdField_a_of_type_Bmnh == null) {
        jdField_a_of_type_Bmnh = new bmnh(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bmnh;
    }
    finally {}
  }
  
  public static bmno a()
  {
    if (jdField_a_of_type_Bmno == null) {}
    try
    {
      if (jdField_a_of_type_Bmno == null) {
        jdField_a_of_type_Bmno = new bmno(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bmno;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Bmno != null)
    {
      jdField_a_of_type_Bmno.b("qqindividuality_signature");
      jdField_a_of_type_Bmno = null;
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
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = "qqindividuality_plugin.apk";
    localbmgt.d = PluginInfo.m;
    localbmgt.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbmgt.e = paramString;
    localbmgt.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbmgt.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bmgk.c(paramAppRuntime.getApplication(), localbmgt);
  }
  
  public static boolean a()
  {
    bmnh localbmnh = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbmnh.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbmnh);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */