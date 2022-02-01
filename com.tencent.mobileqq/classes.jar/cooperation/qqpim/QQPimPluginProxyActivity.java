package cooperation.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = "qqpim_plugin.apk";
    localPluginParams.e = "QQ同步助手插件";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString1;
    localPluginParams.f = paramString2;
    localPluginParams.jdField_a_of_type_JavaLangClass = paramClass;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.c = -1;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localPluginParams.d = 30000;
    localPluginParams.g = null;
    localPluginParams.jdField_b_of_type_Boolean = false;
    IPluginManager.a(paramActivity, localPluginParams);
    if (QLog.isColorLevel())
    {
      paramActivity = QQPimDefineList.jdField_a_of_type_JavaLangString;
      paramIntent = new StringBuilder();
      paramIntent.append("QQPimPluginProxyActivity.openPluginActivityForResult() ");
      paramIntent.append(paramString2);
      paramIntent.append(" IPluginManager.SUPPORT_NETWORKING ");
      paramIntent.append(true);
      QLog.i(paramActivity, 2, paramIntent.toString());
    }
    return true;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(QQPimDefineList.l), QQPimDefineList.j, QQPimPluginProxyActivity.class, paramDialog);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */