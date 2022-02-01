package com.tencent.mobileqq.vastrash.uec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.statistics.IPageLifecycleCallback;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;

public class UECPageStayTimeReport
  implements IPageLifecycleCallback
{
  private HashMap<Integer, UECPageStayTimeReport.ReportItem> a = new HashMap();
  
  private UECPageStayTimeReport.ReportItem a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    UECPageStayTimeReport.ReportItem localReportItem;
    if ((this.a.containsKey(Integer.valueOf(paramObject.hashCode()))) && (this.a.get(Integer.valueOf(paramObject.hashCode())) != null)) {
      localReportItem = (UECPageStayTimeReport.ReportItem)this.a.get(Integer.valueOf(paramObject.hashCode()));
    } else {
      localReportItem = new UECPageStayTimeReport.ReportItem();
    }
    this.a.put(Integer.valueOf(paramObject.hashCode()), localReportItem);
    return localReportItem;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("."))
      {
        str = paramString;
        if (!paramString.endsWith(".")) {
          str = paramString.substring(paramString.lastIndexOf('.') + 1, paramString.length());
        }
      }
    }
    return str;
  }
  
  private void a(UECPageStayTimeReport.ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      return;
    }
    UECPageStayReportManager.a(paramReportItem);
  }
  
  private UECPageStayTimeReport.ReportItem b(Object paramObject)
  {
    Object localObject2 = null;
    if (paramObject == null) {
      return null;
    }
    Object localObject1 = localObject2;
    if (this.a.containsKey(Integer.valueOf(paramObject.hashCode())))
    {
      localObject1 = localObject2;
      if (this.a.get(Integer.valueOf(paramObject.hashCode())) != null) {
        localObject1 = (UECPageStayTimeReport.ReportItem)this.a.get(Integer.valueOf(paramObject.hashCode()));
      }
    }
    c(paramObject);
    return localObject1;
  }
  
  private String b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return "null";
    }
    if (QQBrowserActivity.class.isInstance(paramActivity)) {
      return b(a(paramActivity));
    }
    if (d(paramActivity))
    {
      paramActivity = (MiniAppInfo)paramActivity.getIntent().getParcelableExtra("KEY_APPINFO");
      if (paramActivity != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramActivity.appId);
        localStringBuilder.append("_");
        localStringBuilder.append(paramActivity.name);
        return localStringBuilder.toString();
      }
    }
    else if (AudienceRoomActivity.class.isInstance(paramActivity))
    {
      paramActivity = LiteLiveSDKFactory.a().b();
      if (paramActivity != null) {
        return paramActivity.a;
      }
    }
    return "";
  }
  
  private String b(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "null";
    }
    int i = paramString.indexOf("?");
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  private String c(Activity paramActivity)
  {
    if (paramActivity == null) {
      return "null";
    }
    String str = paramActivity.getClass().getSimpleName();
    if ((paramActivity instanceof PluginProxyActivity))
    {
      paramActivity = a(((PluginProxyActivity)paramActivity).getPluginActivity());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(paramActivity);
      return localStringBuilder.toString();
    }
    if (d(paramActivity)) {
      return "MiniAppPage";
    }
    return str;
  }
  
  private void c(Object paramObject)
  {
    if (paramObject != null) {
      this.a.remove(Integer.valueOf(paramObject.hashCode()));
    }
  }
  
  private boolean d(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    try
    {
      boolean bool = Class.forName("com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity").isInstance(paramActivity);
      return bool;
    }
    catch (ClassNotFoundException paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return false;
  }
  
  protected String a(Activity paramActivity)
  {
    Intent localIntent = paramActivity.getIntent();
    String str = localIntent.getStringExtra("url");
    paramActivity = str;
    if (str == null)
    {
      str = localIntent.getStringExtra("key_params_qq");
      paramActivity = str;
      if (str == null) {
        paramActivity = "null";
      }
    }
    return paramActivity;
  }
  
  public void a(String paramString, Activity paramActivity, boolean paramBoolean, Object paramObject)
  {
    if (!(paramObject instanceof Frame)) {
      return;
    }
    paramActivity = c(paramActivity);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramActivity);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramActivity = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      if (paramBoolean) {
        paramString = "onFrameHidden";
      } else {
        paramString = "onFrameShow";
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(" frameKey = ");
      localStringBuilder.append(paramActivity);
      QLog.i("UECPageStayTimeReport", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      paramString = b(paramObject);
    } else {
      paramString = a(paramObject);
    }
    if (paramString == null) {
      return;
    }
    if (paramBoolean)
    {
      paramString.c();
      a(paramString);
      return;
    }
    paramString.a = paramActivity;
    paramString.a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    String str1 = c(paramActivity);
    String str2 = b(paramActivity);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPaused :  activityKey = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" activitySpecialKey = ");
      localStringBuilder.append(str2);
      QLog.e("UECPageStayTimeReport", 2, localStringBuilder.toString());
    }
    paramActivity = b(paramActivity);
    if (paramActivity != null)
    {
      paramActivity.c();
      a(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    String str1 = c(paramActivity);
    String str2 = b(paramActivity);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResumed :  activityKey = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" activitySpecialKey = ");
      localStringBuilder.append(str2);
      QLog.e("UECPageStayTimeReport", 2, localStringBuilder.toString());
    }
    paramActivity = a(paramActivity);
    paramActivity.a = str1;
    paramActivity.b = str2;
    paramActivity.a();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayTimeReport
 * JD-Core Version:    0.7.0.1
 */