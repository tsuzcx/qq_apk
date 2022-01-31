package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import bfcz;
import bfdi;
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
    bfdi localbfdi = new bfdi(0);
    localbfdi.b = QlinkPluginProxyActivity.a();
    localbfdi.d = PluginInfo.c;
    localbfdi.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbfdi.e = "com.tencent.qlink.service.QlinkService";
    localbfdi.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbfdi.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    bfcz.c(paramAppRuntime.getApplication(), localbfdi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */