package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import blfh;
import blfq;
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
    blfq localblfq = new blfq(0);
    localblfq.b = QlinkPluginProxyActivity.a();
    localblfq.d = PluginInfo.c;
    localblfq.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblfq.e = "com.tencent.qlink.service.QlinkService";
    localblfq.jdField_a_of_type_AndroidContentIntent = localIntent;
    localblfq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    blfh.c(paramAppRuntime.getApplication(), localblfq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */