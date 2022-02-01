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
    a(paramActivity, localIntent, paramBundle.getString(QQPimDefineList.m), QQPimDefineList.j, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.d = "qqpim_plugin.apk";
    localPluginParams.g = "QQ同步助手插件";
    localPluginParams.c = paramString1;
    localPluginParams.h = paramString2;
    localPluginParams.i = paramClass;
    localPluginParams.j = paramIntent;
    localPluginParams.k = -1;
    localPluginParams.l = paramDialog;
    localPluginParams.r = 30000;
    localPluginParams.q = null;
    localPluginParams.p = false;
    IPluginManager.a(paramActivity, localPluginParams);
    if (QLog.isColorLevel())
    {
      paramActivity = QQPimDefineList.a;
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
    a(paramActivity, localIntent, paramBundle.getString(QQPimDefineList.m), QQPimDefineList.k, QQPimPluginProxyActivity.class, paramDialog);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */