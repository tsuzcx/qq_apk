package cooperation.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class QQPimPluginProxyActivity
  extends PluginProxyActivity
{
  public static void a(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(QQPimDefineList.l), QQPimDefineList.i, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = "qqpim_plugin.apk";
    localPluginParams.d = "QQ同步助手插件";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString1;
    localPluginParams.e = paramString2;
    localPluginParams.jdField_a_of_type_JavaLangClass = paramClass;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_b_of_type_Int = -1;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localPluginParams.c = 30000;
    localPluginParams.f = null;
    localPluginParams.jdField_a_of_type_Boolean = false;
    IPluginManager.a(paramActivity, localPluginParams);
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(QQPimDefineList.l), QQPimDefineList.j, QQPimPluginProxyActivity.class, paramDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */