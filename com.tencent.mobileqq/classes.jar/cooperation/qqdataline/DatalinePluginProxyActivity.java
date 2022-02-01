package cooperation.qqdataline;

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
import biau;
import blfh;
import blfq;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  
  public static void a(Activity paramActivity, String paramString1, Intent paramIntent, String paramString2, int paramInt, biau parambiau)
  {
    paramIntent.putExtra("userQqResources", 2);
    blfq localblfq = new blfq(0);
    localblfq.jdField_b_of_type_JavaLangString = "qqdataline.apk";
    localblfq.d = PluginInfo.d;
    localblfq.jdField_a_of_type_JavaLangString = paramString1;
    localblfq.e = paramString2;
    localblfq.jdField_a_of_type_JavaLangClass = a(paramIntent, paramString2);
    localblfq.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localblfq.jdField_b_of_type_Int = paramInt;
    localblfq.jdField_a_of_type_AndroidAppDialog = parambiau;
    localblfq.c = 10000;
    localblfq.f = null;
    blfh.a(paramActivity, localblfq);
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public String getPluginID()
  {
    return "qqdataline.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label65;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件Activity启动] ");
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("qqdataline", 1, localStringBuffer.toString());
      return;
      label65:
      paramBundle = getIntent().getExtras();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqdataline.DatalinePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */