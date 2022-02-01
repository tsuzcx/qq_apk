package cooperation.qqdataline;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import java.util.Iterator;
import java.util.List;

public class DatalinePluginProxyActivity
  extends PluginProxyActivity
{
  private static Class<? extends PluginProxyActivity> a(Intent paramIntent, String paramString)
  {
    if ((paramString != null) && (paramString.equals("com.qqdataline.activity.LiteWifiphotoActivity"))) {
      paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
    }
    if ((paramIntent.getFlags() & 0x20000000) != 0) {
      return DatalinePluginProxyActivity.SingleTop.class;
    }
    return DatalinePluginProxyActivity.class;
  }
  
  public static void a(Activity paramActivity, String paramString1, Intent paramIntent, String paramString2, int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "qqdataline.apk";
    localPluginParams.g = PluginInfo.d;
    localPluginParams.c = paramString1;
    localPluginParams.h = paramString2;
    localPluginParams.i = a(paramIntent, paramString2);
    localPluginParams.j = paramIntent;
    localPluginParams.k = paramInt;
    localPluginParams.l = paramQQProgressDialog;
    localPluginParams.r = 10000;
    localPluginParams.q = null;
    IPluginManager.a(paramActivity, localPluginParams);
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
      if ("com.tencent.mobileqq:dataline".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return "qqdataline.apk";
  }
  
  protected Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    if (paramString.equals("com.qqdataline.activity.LiteWifiphotoActivity")) {
      return DatalinePluginProxyActivity.SingleTop.class;
    }
    return super.getProxyActivity(paramString);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo))
    {
      if (paramBundle == null) {
        paramBundle = getIntent().getExtras();
      }
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件Activity启动] ");
      localStringBuffer.append(paramBundle);
      localStringBuffer.append(" ");
      localStringBuffer.append(this.mCreateErrorInfo);
      QLog.e("qqdataline", 1, localStringBuffer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.DatalinePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */