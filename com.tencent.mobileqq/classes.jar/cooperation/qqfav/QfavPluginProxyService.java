package cooperation.qqfav;

import android.content.Intent;
import android.content.ServiceConnection;
import blfh;
import blfq;
import blkn;
import blku;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import mqq.app.AppRuntime;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static blkn jdField_a_of_type_Blkn;
  private static blku jdField_a_of_type_Blku;
  
  public static blkn a()
  {
    if (jdField_a_of_type_Blkn == null) {}
    try
    {
      if (jdField_a_of_type_Blkn == null) {
        jdField_a_of_type_Blkn = new blkn(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Blkn;
    }
    finally {}
  }
  
  public static blku a()
  {
    if (jdField_a_of_type_Blku == null) {}
    try
    {
      if (jdField_a_of_type_Blku == null) {
        jdField_a_of_type_Blku = new blku(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Blku;
    }
    finally {}
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QfavPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    blfq localblfq = new blfq(0);
    localblfq.b = "qqfav.apk";
    localblfq.d = "qqfav.apk";
    localblfq.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblfq.e = paramString;
    localblfq.jdField_a_of_type_AndroidContentIntent = localIntent;
    localblfq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    blfh.c(paramAppRuntime.getApplication(), localblfq);
  }
  
  public static boolean a()
  {
    blkn localblkn = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localblkn.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localblkn);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */