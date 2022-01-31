package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bdoe;
import bgkq;
import bgkz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static void a(ServiceConnection paramServiceConnection)
  {
    bdoe.b("WadlProxyService", "bindWadlService proxy WadlRemoteService");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getRuntime();
    Intent localIntent = new Intent(localBaseApplicationImpl, WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    bgkz localbgkz = new bgkz(0);
    localbgkz.b = "qqwadl.apk";
    localbgkz.d = "qqwadl";
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localbgkz.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbgkz.e = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
      localbgkz.jdField_a_of_type_AndroidContentIntent = localIntent;
      localbgkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      bgkq.c(localBaseApplicationImpl, localbgkz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */