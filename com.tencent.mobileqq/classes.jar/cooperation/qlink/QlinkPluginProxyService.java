package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import blvy;
import blwh;
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
    blwh localblwh = new blwh(0);
    localblwh.b = QlinkPluginProxyActivity.a();
    localblwh.d = PluginInfo.c;
    localblwh.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localblwh.e = "com.tencent.qlink.service.QlinkService";
    localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    localblwh.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    blvy.c(paramAppRuntime.getApplication(), localblwh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */