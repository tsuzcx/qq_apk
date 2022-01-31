package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import bgkq;
import bgkz;
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
    bgkz localbgkz = new bgkz(0);
    localbgkz.b = QlinkPluginProxyActivity.a();
    localbgkz.d = PluginInfo.c;
    localbgkz.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbgkz.e = "com.tencent.qlink.service.QlinkService";
    localbgkz.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbgkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    bgkq.c(paramAppRuntime.getApplication(), localbgkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */