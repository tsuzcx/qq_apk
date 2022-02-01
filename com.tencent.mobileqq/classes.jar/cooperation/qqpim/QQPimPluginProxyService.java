package cooperation.qqpim;

import android.content.Intent;
import bmgk;
import bmgt;
import bmnu;
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
      bmgt localbmgt = new bmgt(1);
      localbmgt.b = "qqpim_plugin.apk";
      localbmgt.d = "QQ同步助手插件";
      localbmgt.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localbmgt.e = bmnu.k;
      localbmgt.jdField_a_of_type_AndroidContentIntent = localIntent;
      bmgk.c(paramQQAppInterface.getApp(), localbmgt);
    } while (!QLog.isColorLevel());
    QLog.i(bmnu.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */