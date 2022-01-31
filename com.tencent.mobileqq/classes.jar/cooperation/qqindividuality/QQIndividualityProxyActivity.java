package cooperation.qqindividuality;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;

public class QQIndividualityProxyActivity
  extends PluginProxyActivity
{
  public static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class paramClass, Dialog paramDialog, int paramInt)
  {
    QQIndividualityPluginProxyService.a();
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = "qqindividuality_plugin.apk";
    localPluginParams.d = "个性化内容";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString1;
    localPluginParams.e = paramString2;
    localPluginParams.jdField_a_of_type_JavaLangClass = paramClass;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_b_of_type_Int = paramInt;
    localPluginParams.c = 30000;
    localPluginParams.f = null;
    localPluginParams.jdField_a_of_type_Boolean = false;
    IPluginManager.a(paramActivity, localPluginParams);
    if ((paramString2.equals("com.qqindividuality.activity.QQIndividualitySignatureActivity")) && ((paramActivity instanceof QQIndividualityBridgeActivity)) && (paramDialog != null)) {
      paramActivity.finish();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQIndividuality", 2, "QQIndividualityPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityProxyActivity
 * JD-Core Version:    0.7.0.1
 */