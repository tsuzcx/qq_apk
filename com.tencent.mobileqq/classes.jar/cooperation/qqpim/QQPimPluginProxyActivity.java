package cooperation.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import bimg;
import bimp;
import bitz;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class QQPimPluginProxyActivity
  extends PluginProxyActivity
{
  public static void a(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(bitz.l), bitz.i, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    bimp localbimp = new bimp(1);
    localbimp.jdField_b_of_type_JavaLangString = "qqpim_plugin.apk";
    localbimp.d = "QQ同步助手插件";
    localbimp.jdField_a_of_type_JavaLangString = paramString1;
    localbimp.e = paramString2;
    localbimp.jdField_a_of_type_JavaLangClass = paramClass;
    localbimp.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbimp.jdField_b_of_type_Int = -1;
    localbimp.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbimp.c = 30000;
    localbimp.f = null;
    localbimp.jdField_b_of_type_Boolean = false;
    bimg.a(paramActivity, localbimp);
    if (QLog.isColorLevel()) {
      QLog.i(bitz.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(bitz.l), bitz.j, QQPimPluginProxyActivity.class, paramDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */