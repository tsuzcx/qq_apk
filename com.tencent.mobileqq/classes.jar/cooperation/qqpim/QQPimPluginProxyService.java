package cooperation.qqpim;

import android.content.Intent;
import bfcz;
import bfdi;
import bfkr;
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
      bfdi localbfdi = new bfdi(1);
      localbfdi.b = "qqpim_plugin.apk";
      localbfdi.d = "QQ同步助手插件";
      localbfdi.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localbfdi.e = bfkr.k;
      localbfdi.jdField_a_of_type_AndroidContentIntent = localIntent;
      bfcz.c(paramQQAppInterface.getApp(), localbfdi);
    } while (!QLog.isColorLevel());
    QLog.i(bfkr.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */