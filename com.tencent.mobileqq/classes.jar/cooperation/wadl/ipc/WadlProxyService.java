package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bjqp;
import blvy;
import blwh;
import bmqk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bmqk.b + "WadlProxyService";
  }
  
  public static void a(ServiceConnection paramServiceConnection)
  {
    bjqp.c(jdField_a_of_type_JavaLangString, "bindWadlService proxy WadlRemoteService");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getRuntime();
    Intent localIntent = new Intent(localBaseApplicationImpl, WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    blwh localblwh = new blwh(0);
    localblwh.b = "qqwadl.apk";
    localblwh.d = "qqwadl";
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localblwh.jdField_a_of_type_JavaLangString = ((String)localObject);
      localblwh.e = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
      localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
      localblwh.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      blvy.c(localBaseApplicationImpl, localblwh);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */