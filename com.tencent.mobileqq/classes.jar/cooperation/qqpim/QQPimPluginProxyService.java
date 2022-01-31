package cooperation.qqpim;

import android.content.Intent;
import biqn;
import biqw;
import biyg;
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
      biqw localbiqw = new biqw(1);
      localbiqw.b = "qqpim_plugin.apk";
      localbiqw.d = "QQ同步助手插件";
      localbiqw.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localbiqw.e = biyg.k;
      localbiqw.jdField_a_of_type_AndroidContentIntent = localIntent;
      biqn.c(paramQQAppInterface.getApp(), localbiqw);
    } while (!QLog.isColorLevel());
    QLog.i(biyg.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */