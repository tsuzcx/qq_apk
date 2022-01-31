package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import bfnq;
import bimg;
import bimp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static void a(ServiceConnection paramServiceConnection)
  {
    bfnq.c("WadlProxyService", "bindWadlService proxy WadlRemoteService");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getRuntime();
    Intent localIntent = new Intent(localBaseApplicationImpl, WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    bimp localbimp = new bimp(0);
    localbimp.b = "qqwadl.apk";
    localbimp.d = "qqwadl";
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localbimp.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbimp.e = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
      localbimp.jdField_a_of_type_AndroidContentIntent = localIntent;
      localbimp.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      bimg.c(localBaseApplicationImpl, localbimp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */