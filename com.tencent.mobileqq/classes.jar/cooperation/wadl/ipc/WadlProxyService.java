package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bkad;
import bmgk;
import bmgt;
import bnyp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bnyp.b + "WadlProxyService";
  }
  
  public static void a(ServiceConnection paramServiceConnection)
  {
    bkad.c(jdField_a_of_type_JavaLangString, "bindWadlService proxy WadlRemoteService");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getRuntime();
    Intent localIntent = new Intent(localBaseApplicationImpl, WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = "qqwadl.apk";
    localbmgt.d = "qqwadl";
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localbmgt.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbmgt.e = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
      localbmgt.jdField_a_of_type_AndroidContentIntent = localIntent;
      localbmgt.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      bmgk.c(localBaseApplicationImpl, localbmgt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */