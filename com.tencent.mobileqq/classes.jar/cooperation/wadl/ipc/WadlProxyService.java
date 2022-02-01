package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bize;
import blfh;
import blfq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static void a(ServiceConnection paramServiceConnection)
  {
    bize.c("WadlProxyService", "bindWadlService proxy WadlRemoteService");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getRuntime();
    Intent localIntent = new Intent(localBaseApplicationImpl, WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    blfq localblfq = new blfq(0);
    localblfq.b = "qqwadl.apk";
    localblfq.d = "qqwadl";
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localblfq.jdField_a_of_type_JavaLangString = ((String)localObject);
      localblfq.e = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
      localblfq.jdField_a_of_type_AndroidContentIntent = localIntent;
      localblfq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      blfh.c(localBaseApplicationImpl, localblfq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */