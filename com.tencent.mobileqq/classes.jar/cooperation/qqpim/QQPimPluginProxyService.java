package cooperation.qqpim;

import android.content.Intent;
import bgkq;
import bgkz;
import bgsj;
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
      bgkz localbgkz = new bgkz(1);
      localbgkz.b = "qqpim_plugin.apk";
      localbgkz.d = "QQ同步助手插件";
      localbgkz.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localbgkz.e = bgsj.k;
      localbgkz.jdField_a_of_type_AndroidContentIntent = localIntent;
      bgkq.c(paramQQAppInterface.getApp(), localbgkz);
    } while (!QLog.isColorLevel());
    QLog.i(bgsj.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */