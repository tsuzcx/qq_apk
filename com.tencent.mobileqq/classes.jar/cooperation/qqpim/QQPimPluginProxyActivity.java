package cooperation.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import bglh;
import bglq;
import bgta;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class QQPimPluginProxyActivity
  extends PluginProxyActivity
{
  public static void a(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(bgta.l), bgta.i, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    bglq localbglq = new bglq(1);
    localbglq.jdField_b_of_type_JavaLangString = "qqpim_plugin.apk";
    localbglq.d = "QQ同步助手插件";
    localbglq.jdField_a_of_type_JavaLangString = paramString1;
    localbglq.e = paramString2;
    localbglq.jdField_a_of_type_JavaLangClass = paramClass;
    localbglq.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbglq.jdField_b_of_type_Int = -1;
    localbglq.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbglq.c = 30000;
    localbglq.f = null;
    localbglq.jdField_b_of_type_Boolean = false;
    bglh.a(paramActivity, localbglq);
    if (QLog.isColorLevel()) {
      QLog.i(bgta.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(bgta.l), bgta.j, QQPimPluginProxyActivity.class, paramDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */