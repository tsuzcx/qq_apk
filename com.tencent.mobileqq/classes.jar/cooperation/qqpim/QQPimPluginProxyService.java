package cooperation.qqpim;

import android.content.Intent;
import bglh;
import bglq;
import bgta;
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
      bglq localbglq = new bglq(1);
      localbglq.b = "qqpim_plugin.apk";
      localbglq.d = "QQ同步助手插件";
      localbglq.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localbglq.e = bgta.k;
      localbglq.jdField_a_of_type_AndroidContentIntent = localIntent;
      bglh.c(paramQQAppInterface.getApp(), localbglq);
    } while (!QLog.isColorLevel());
    QLog.i(bgta.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */