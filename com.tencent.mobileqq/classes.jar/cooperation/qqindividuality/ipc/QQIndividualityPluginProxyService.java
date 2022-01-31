package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bfcz;
import bfdi;
import bfke;
import bfkl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static bfke jdField_a_of_type_Bfke;
  private static bfkl jdField_a_of_type_Bfkl;
  
  public static bfke a()
  {
    if (jdField_a_of_type_Bfke == null) {}
    try
    {
      if (jdField_a_of_type_Bfke == null) {
        jdField_a_of_type_Bfke = new bfke(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bfke;
    }
    finally {}
  }
  
  public static bfkl a()
  {
    if (jdField_a_of_type_Bfkl == null) {}
    try
    {
      if (jdField_a_of_type_Bfkl == null) {
        jdField_a_of_type_Bfkl = new bfkl(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bfkl;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Bfkl != null)
    {
      jdField_a_of_type_Bfkl.b("qqindividuality_signature");
      jdField_a_of_type_Bfkl = null;
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
    bfdi localbfdi = new bfdi(0);
    localbfdi.b = "qqindividuality_plugin.apk";
    localbfdi.d = PluginInfo.m;
    localbfdi.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbfdi.e = paramString;
    localbfdi.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbfdi.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bfcz.c(paramAppRuntime.getApplication(), localbfdi);
  }
  
  public static boolean a()
  {
    bfke localbfke = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbfke.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbfke);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */