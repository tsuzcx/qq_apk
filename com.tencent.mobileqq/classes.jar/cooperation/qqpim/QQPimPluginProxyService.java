package cooperation.qqpim;

import android.content.Intent;
import bimg;
import bimp;
import bitz;
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
      bimp localbimp = new bimp(1);
      localbimp.b = "qqpim_plugin.apk";
      localbimp.d = "QQ同步助手插件";
      localbimp.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localbimp.e = bitz.k;
      localbimp.jdField_a_of_type_AndroidContentIntent = localIntent;
      bimg.c(paramQQAppInterface.getApp(), localbimp);
    } while (!QLog.isColorLevel());
    QLog.i(bitz.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */