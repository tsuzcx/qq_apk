package cooperation.qqfav;

import android.content.Intent;
import android.content.ServiceConnection;
import blvy;
import blwh;
import bmbf;
import bmbm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import mqq.app.AppRuntime;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static bmbf jdField_a_of_type_Bmbf;
  private static bmbm jdField_a_of_type_Bmbm;
  
  public static bmbf a()
  {
    if (jdField_a_of_type_Bmbf == null) {}
    try
    {
      if (jdField_a_of_type_Bmbf == null) {
        jdField_a_of_type_Bmbf = new bmbf(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bmbf;
    }
    finally {}
  }
  
  public static bmbm a()
  {
    if (jdField_a_of_type_Bmbm == null) {}
    try
    {
      if (jdField_a_of_type_Bmbm == null) {
        jdField_a_of_type_Bmbm = new bmbm(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bmbm;
    }
    finally {}
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QfavPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    blwh localblwh = new blwh(0);
    localblwh.b = "qqfav.apk";
    localblwh.d = "qqfav.apk";
    localblwh.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblwh.e = paramString;
    localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    localblwh.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    blvy.c(paramAppRuntime.getApplication(), localblwh);
  }
  
  public static boolean a()
  {
    bmbf localbmbf = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbmbf.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbmbf);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */