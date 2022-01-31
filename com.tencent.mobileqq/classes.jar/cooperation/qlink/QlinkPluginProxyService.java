package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import bimg;
import bimp;
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
    bimp localbimp = new bimp(0);
    localbimp.b = QlinkPluginProxyActivity.a();
    localbimp.d = PluginInfo.c;
    localbimp.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localbimp.e = "com.tencent.qlink.service.QlinkService";
    localbimp.jdField_a_of_type_AndroidContentIntent = localIntent;
    localbimp.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    bimg.c(paramAppRuntime.getApplication(), localbimp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */