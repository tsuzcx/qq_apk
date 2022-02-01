package cooperation.qqpim;

import Override;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import bmgk;
import bmgt;
import bmnu;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQPimPluginProxyActivity
  extends PluginProxyActivity
{
  public static void a(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(bmnu.l), bmnu.i, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    bmgt localbmgt = new bmgt(1);
    localbmgt.jdField_b_of_type_JavaLangString = "qqpim_plugin.apk";
    localbmgt.d = "QQ同步助手插件";
    localbmgt.jdField_a_of_type_JavaLangString = paramString1;
    localbmgt.e = paramString2;
    localbmgt.jdField_a_of_type_JavaLangClass = paramClass;
    localbmgt.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbmgt.jdField_b_of_type_Int = -1;
    localbmgt.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbmgt.c = 30000;
    localbmgt.f = null;
    localbmgt.jdField_b_of_type_Boolean = false;
    bmgk.a(paramActivity, localbmgt);
    if (QLog.isColorLevel()) {
      QLog.i(bmnu.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(bmnu.l), bmnu.j, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */