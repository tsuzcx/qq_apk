package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.ArrayList;

public class TroopFileProxyActivity
  extends TroopBaseProxyActivity
{
  public static ArrayList<FileInfo> a = new ArrayList();
  public static String b = "key_qun_id";
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openTroopFileBrowserActivity:");
    localStringBuilder.append(paramInt);
    QLog.i("TroopFileBrowserActivity", 1, localStringBuilder.toString());
    a(paramActivity, paramIntent, null, "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", paramString, paramInt);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "troop_plugin.apk";
    localPluginParams.g = HardCodeUtil.a(2131912600);
    localPluginParams.c = paramString2;
    localPluginParams.h = paramString1;
    localPluginParams.i = TroopFileProxyActivity.class;
    localPluginParams.j = paramIntent;
    localPluginParams.l = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localPluginParams.k = paramInt;
    localPluginParams.r = 10000;
    localPluginParams.q = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    a(paramActivity, paramIntent, null, "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", paramString, 0);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, String paramString)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileUploadActivity", paramString, 0);
  }
  
  public static void c(Activity paramActivity, Intent paramIntent, String paramString)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileSearchByTypeActivity", paramString, 0);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return TroopFileProxyActivity.class;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.TroopFileProxyActivity
 * JD-Core Version:    0.7.0.1
 */