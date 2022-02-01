package cooperation.qlink;

import Override;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import anzj;
import bjbs;
import bmgk;
import bmgt;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.PluginInfo;
import java.util.Iterator;
import java.util.List;

public class QlinkPluginProxyActivity
  extends PluginProxyActivity
{
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qlink_plugin.apk");
  }
  
  public static String a()
  {
    return "qlink_plugin.apk";
  }
  
  static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qlink_plugin_activity_name");
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, bjbs parambjbs)
  {
    paramIntent.putExtra("userQqResources", 2);
    bmgt localbmgt = new bmgt(0);
    localbmgt.jdField_b_of_type_JavaLangString = "qlink_plugin.apk";
    localbmgt.d = PluginInfo.c;
    localbmgt.jdField_a_of_type_JavaLangString = paramString;
    localbmgt.e = a(paramIntent);
    localbmgt.jdField_a_of_type_JavaLangClass = QlinkPluginProxyActivity.class;
    localbmgt.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbmgt.jdField_b_of_type_Int = paramInt;
    localbmgt.jdField_a_of_type_AndroidAppDialog = parambjbs;
    localbmgt.c = 10000;
    localbmgt.f = null;
    bmgk.a(paramActivity, localbmgt);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qlink_plugin_activity_name", paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:qlink".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public String getPluginID()
  {
    return "qlink_plugin.apk";
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label68;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer(anzj.a(2131708764));
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("QLinkLog", 1, localStringBuffer.toString());
      return;
      label68:
      paramBundle = getIntent().getExtras();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */