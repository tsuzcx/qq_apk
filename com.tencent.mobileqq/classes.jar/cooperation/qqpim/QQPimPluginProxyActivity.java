package cooperation.qqpim;

import Override;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import blvy;
import blwh;
import bmdk;
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
    a(paramActivity, localIntent, paramBundle.getString(bmdk.l), bmdk.i, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    blwh localblwh = new blwh(1);
    localblwh.jdField_b_of_type_JavaLangString = "qqpim_plugin.apk";
    localblwh.d = "QQ同步助手插件";
    localblwh.jdField_a_of_type_JavaLangString = paramString1;
    localblwh.e = paramString2;
    localblwh.jdField_a_of_type_JavaLangClass = paramClass;
    localblwh.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localblwh.jdField_b_of_type_Int = -1;
    localblwh.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localblwh.c = 30000;
    localblwh.f = null;
    localblwh.jdField_b_of_type_Boolean = false;
    blvy.a(paramActivity, localblwh);
    if (QLog.isColorLevel()) {
      QLog.i(bmdk.jdField_a_of_type_JavaLangString, 2, "QQPimPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(bmdk.l), bmdk.j, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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