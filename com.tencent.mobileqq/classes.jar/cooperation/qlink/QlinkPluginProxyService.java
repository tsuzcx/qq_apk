package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import bglh;
import bglq;
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
    bglq localbglq = new bglq(0);
    localbglq.b = QlinkPluginProxyActivity.a();
    localbglq.d = PluginInfo.c;
    localbglq.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbglq.e = "com.tencent.qlink.service.QlinkService";
    localbglq.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbglq.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    bglh.c(paramAppRuntime.getApplication(), localbglq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */