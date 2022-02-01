package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import bmgk;
import bmgt;
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
    bmgt localbmgt = new bmgt(0);
    localbmgt.b = QlinkPluginProxyActivity.a();
    localbmgt.d = PluginInfo.c;
    localbmgt.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbmgt.e = "com.tencent.qlink.service.QlinkService";
    localbmgt.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbmgt.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    bmgk.c(paramAppRuntime.getApplication(), localbmgt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */