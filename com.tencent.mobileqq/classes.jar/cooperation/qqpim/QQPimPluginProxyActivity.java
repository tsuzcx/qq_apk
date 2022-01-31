package cooperation.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import biqn;
import biqw;
import biyg;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class QQPimPluginProxyActivity
  extends PluginProxyActivity
{
  public static void a(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(biyg.l), biyg.i, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    biqw localbiqw = new biqw(1);
    localbiqw.jdField_b_of_type_JavaLangString = "qqpim_plugin.apk";
    localbiqw.d = "QQ同步助手插件";
    localbiqw.jdField_a_of_type_JavaLangString = paramString1;
    localbiqw.e = paramString2;
    localbiqw.jdField_a_of_type_JavaLangClass = paramClass;
    localbiqw.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbiqw.jdField_b_of_type_Int = -1;
    localbiqw.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbiqw.c = 30000;
    localbiqw.f = null;
    localbiqw.jdField_b_of_type_Boolean = false;
    biqn.a(paramActivity, localbiqw);
    if (QLog.isColorLevel()) {
      QLog.i(biyg.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(biyg.l), biyg.j, QQPimPluginProxyActivity.class, paramDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */