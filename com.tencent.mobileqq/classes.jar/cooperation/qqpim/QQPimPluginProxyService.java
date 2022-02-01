package cooperation.qqpim;

import android.content.Intent;
import blfh;
import blfq;
import blmr;
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
      blfq localblfq = new blfq(1);
      localblfq.b = "qqpim_plugin.apk";
      localblfq.d = "QQ同步助手插件";
      localblfq.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localblfq.e = blmr.k;
      localblfq.jdField_a_of_type_AndroidContentIntent = localIntent;
      blfh.c(paramQQAppInterface.getApp(), localblfq);
    } while (!QLog.isColorLevel());
    QLog.i(blmr.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */