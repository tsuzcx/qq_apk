package cooperation.qqfav;

import android.content.Intent;
import android.content.ServiceConnection;
import bkkq;
import bkkz;
import bkpx;
import bkqe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import mqq.app.AppRuntime;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static bkpx jdField_a_of_type_Bkpx;
  private static bkqe jdField_a_of_type_Bkqe;
  
  public static bkpx a()
  {
    if (jdField_a_of_type_Bkpx == null) {}
    try
    {
      if (jdField_a_of_type_Bkpx == null) {
        jdField_a_of_type_Bkpx = new bkpx(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bkpx;
    }
    finally {}
  }
  
  public static bkqe a()
  {
    if (jdField_a_of_type_Bkqe == null) {}
    try
    {
      if (jdField_a_of_type_Bkqe == null) {
        jdField_a_of_type_Bkqe = new bkqe(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Bkqe;
    }
    finally {}
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QfavPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    bkkz localbkkz = new bkkz(0);
    localbkkz.b = "qqfav.apk";
    localbkkz.d = "qqfav.apk";
    localbkkz.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbkkz.e = paramString;
    localbkkz.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbkkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    bkkq.c(paramAppRuntime.getApplication(), localbkkz);
  }
  
  public static boolean a()
  {
    bkpx localbkpx = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localbkpx.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localbkpx);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */