package cooperation.qqpim;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class QQPimPluginProxyService
  extends PluginProxyService
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApp(), QQPimPluginProxyService.class);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.b = "qqpim_plugin.apk";
    localPluginParams.e = "QQ同步助手插件";
    localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    localPluginParams.f = QQPimDefineList.k;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.c(paramQQAppInterface.getApp(), localPluginParams);
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */