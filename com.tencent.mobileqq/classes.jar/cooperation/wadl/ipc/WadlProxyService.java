package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bifn;
import bkkq;
import bkkz;
import bldt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bldt.b + "WadlProxyService";
  }
  
  public static void a(ServiceConnection paramServiceConnection)
  {
    bifn.c(jdField_a_of_type_JavaLangString, "bindWadlService proxy WadlRemoteService");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getRuntime();
    Intent localIntent = new Intent(localBaseApplicationImpl, WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    bkkz localbkkz = new bkkz(0);
    localbkkz.b = "qqwadl.apk";
    localbkkz.d = "qqwadl";
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localbkkz.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbkkz.e = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
      localbkkz.jdField_a_of_type_AndroidContentIntent = localIntent;
      localbkkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      bkkq.c(localBaseApplicationImpl, localbkkz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */