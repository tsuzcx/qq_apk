package cooperation.qqpim;

import android.content.Intent;
import blvy;
import blwh;
import bmdk;
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
      blwh localblwh = new blwh(1);
      localblwh.b = "qqpim_plugin.apk";
      localblwh.d = "QQ同步助手插件";
      localblwh.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localblwh.e = bmdk.k;
      localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
      blvy.c(paramQQAppInterface.getApp(), localblwh);
    } while (!QLog.isColorLevel());
    QLog.i(bmdk.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */