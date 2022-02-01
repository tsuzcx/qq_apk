package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import bkkq;
import bkkz;
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
    bkkz localbkkz = new bkkz(0);
    localbkkz.b = QlinkPluginProxyActivity.a();
    localbkkz.d = PluginInfo.c;
    localbkkz.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbkkz.e = "com.tencent.qlink.service.QlinkService";
    localbkkz.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbkkz.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    bkkq.c(paramAppRuntime.getApplication(), localbkkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */