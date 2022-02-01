package cooperation.qqpim;

import android.content.Intent;
import bkkq;
import bkkz;
import bksb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;

public class QQPimPluginProxyService
  extends PluginProxyService
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      Intent localIntent = new Intent(paramQQAppInterface.getApp(), QQPimPluginProxyService.class);
      bkkz localbkkz = new bkkz(1);
      localbkkz.b = "qqpim_plugin.apk";
      localbkkz.d = "QQ同步助手插件";
      localbkkz.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localbkkz.e = bksb.k;
      localbkkz.jdField_a_of_type_AndroidContentIntent = localIntent;
      bkkq.c(paramQQAppInterface.getApp(), localbkkz);
    } while (!QLog.isColorLevel());
    QLog.i(bksb.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */