package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bfrz;
import biqn;
import biqw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static void a(ServiceConnection paramServiceConnection)
  {
    bfrz.c("WadlProxyService", "bindWadlService proxy WadlRemoteService");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getRuntime();
    Intent localIntent = new Intent(localBaseApplicationImpl, WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    biqw localbiqw = new biqw(0);
    localbiqw.b = "qqwadl.apk";
    localbiqw.d = "qqwadl";
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localbiqw.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbiqw.e = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
      localbiqw.jdField_a_of_type_AndroidContentIntent = localIntent;
      localbiqw.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      biqn.c(localBaseApplicationImpl, localbiqw);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */