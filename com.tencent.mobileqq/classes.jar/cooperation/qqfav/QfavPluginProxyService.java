package cooperation.qqfav;

import android.content.Intent;
import android.content.ServiceConnection;
import bmgk;
import bmgt;
import bmlq;
import bmlx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import mqq.app.AppRuntime;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static bmlq jdField_a_of_type_Bmlq;
  private static bmlx jdField_a_of_type_Bmlx;
  
  public static bmlq a()
  {
    if (jdField_a_of_type_Bmlq == null) {}
    try
    {
      if (jdField_a_of_type_Bmlq == null) {
        jdField_a_of_type_Bmlq = new bmlq(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bmlq;
    }
    finally {}
  }
  
  public static bmlx a()
  {
    if (jdField_a_of_type_Bmlx == null) {}
    try
    {
      if (jdField_a_of_type_Bmlx == null) {
        jdField_a_of_type_Bmlx = new bmlx(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bmlx;
    }
    finally {}
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QfavPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = "qqfav.apk";
    localbmgt.d = "qqfav.apk";
    localbmgt.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbmgt.e = paramString;
    localbmgt.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbmgt.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bmgk.c(paramAppRuntime.getApplication(), localbmgt);
  }
  
  public static boolean a()
  {
    bmlq localbmlq = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbmlq.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbmlq);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */