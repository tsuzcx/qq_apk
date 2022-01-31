package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import biqn;
import biqw;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class QlinkPluginProxyService
  extends PluginProxyService
{
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QlinkPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.putExtra("userQqResources", 2);
    biqw localbiqw = new biqw(0);
    localbiqw.b = QlinkPluginProxyActivity.a();
    localbiqw.d = PluginInfo.c;
    localbiqw.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbiqw.e = "com.tencent.qlink.service.QlinkService";
    localbiqw.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbiqw.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    biqn.c(paramAppRuntime.getApplication(), localbiqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */