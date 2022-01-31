package cooperation.qqindividuality;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import bimg;
import bimp;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;

public class QQIndividualityProxyActivity
  extends PluginProxyActivity
{
  public static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog, int paramInt)
  {
    QQIndividualityPluginProxyService.a();
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    bimp localbimp = new bimp(1);
    localbimp.jdField_b_of_type_JavaLangString = "qqindividuality_plugin.apk";
    localbimp.d = PluginInfo.m;
    localbimp.jdField_a_of_type_JavaLangString = paramString1;
    localbimp.e = paramString2;
    localbimp.jdField_a_of_type_JavaLangClass = paramClass;
    localbimp.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbimp.jdField_b_of_type_Int = paramInt;
    localbimp.c = 30000;
    localbimp.f = null;
    localbimp.jdField_b_of_type_Boolean = false;
    bimg.a(paramActivity, localbimp);
    if ((paramString2.equals("com.qqindividuality.activity.QQIndividualitySignatureActivity")) && ((paramActivity instanceof QQIndividualityBridgeActivity)) && (paramDialog != null)) {
      paramActivity.finish();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQIndividuality", 2, "QQIndividualityPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityProxyActivity
 * JD-Core Version:    0.7.0.1
 */