package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bdot;
import bglh;
import bglq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static void a(ServiceConnection paramServiceConnection)
  {
    bdot.b("WadlProxyService", "bindWadlService proxy WadlRemoteService");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getRuntime();
    Intent localIntent = new Intent(localBaseApplicationImpl, WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    bglq localbglq = new bglq(0);
    localbglq.b = "qqwadl.apk";
    localbglq.d = "qqwadl";
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localbglq.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbglq.e = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
      localbglq.jdField_a_of_type_AndroidContentIntent = localIntent;
      localbglq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      bglh.c(localBaseApplicationImpl, localbglq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */