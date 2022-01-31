package cooperation.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import bgkq;
import bgkz;
import bgsj;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class QQPimPluginProxyActivity
  extends PluginProxyActivity
{
  public static void a(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(bgsj.l), bgsj.i, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    bgkz localbgkz = new bgkz(1);
    localbgkz.jdField_b_of_type_JavaLangString = "qqpim_plugin.apk";
    localbgkz.d = "QQ同步助手插件";
    localbgkz.jdField_a_of_type_JavaLangString = paramString1;
    localbgkz.e = paramString2;
    localbgkz.jdField_a_of_type_JavaLangClass = paramClass;
    localbgkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbgkz.jdField_b_of_type_Int = -1;
    localbgkz.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbgkz.c = 30000;
    localbgkz.f = null;
    localbgkz.jdField_b_of_type_Boolean = false;
    bgkq.a(paramActivity, localbgkz);
    if (QLog.isColorLevel()) {
      QLog.i(bgsj.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(bgsj.l), bgsj.j, QQPimPluginProxyActivity.class, paramDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */