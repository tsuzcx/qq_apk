package com.tencent.mobileqq.vastrash.uec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.QFragment;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;
import com.tencent.mobileqq.activity.ChatFragment;
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
import org.jetbrains.annotations.NotNull;

public class UECPageStayTimeReport
  implements IPageLifecycleCallback
{
  private HashMap<Integer, UECPageStayTimeReport.ReportItem> a = new HashMap();
  
  private UECPageStayTimeReport.ReportItem a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((this.a.containsKey(Integer.valueOf(paramObject.hashCode()))) && (this.a.get(Integer.valueOf(paramObject.hashCode())) != null)) {}
    for (UECPageStayTimeReport.ReportItem localReportItem = (UECPageStayTimeReport.ReportItem)this.a.get(Integer.valueOf(paramObject.hashCode()));; localReportItem = new UECPageStayTimeReport.ReportItem())
    {
      this.a.put(Integer.valueOf(paramObject.hashCode()), localReportItem);
      return localReportItem;
    }
  }
  
  @NotNull
  private String a(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return "null";
    }
    if ((paramFragment instanceof BaseHippyFragment)) {
      return "Hippy_" + ((BaseHippyFragment)paramFragment).getModuleName();
    }
    if ((paramFragment instanceof ChatFragment)) {
      return "Chat_" + a((ChatFragment)paramFragment);
    }
    return "";
  }
  
  private String a(ChatFragment paramChatFragment)
  {
    if ((paramChatFragment == null) || (paramChatFragment.getActivity() == null) || (paramChatFragment.getActivity().getIntent() == null)) {
      return "null";
    }
    return paramChatFragment.getActivity().getIntent().getIntExtra("uintype", -1) + "";
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
  
  private void a(Object paramObject)
  {
    if (paramObject != null) {
      this.a.remove(Integer.valueOf(paramObject.hashCode()));
    }
  }
  
  private boolean a(Activity paramActivity)
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
    a(paramObject);
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
    if (a(paramActivity))
    {
      paramActivity = (MiniAppInfo)paramActivity.getIntent().getParcelableExtra("KEY_APPINFO");
      if (paramActivity != null) {
        return paramActivity.appId + "_" + paramActivity.name;
      }
    }
    else if (AudienceRoomActivity.class.isInstance(paramActivity))
    {
      paramActivity = LiteLiveSDKFactory.a().a();
      if (paramActivity != null) {
        return paramActivity.a;
      }
    }
    return "";
  }
  
  private String b(String paramString)
  {
    String str;
    if (StringUtil.a(paramString)) {
      str = "null";
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("?");
      str = paramString;
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  private String c(Activity paramActivity)
  {
    String str;
    if (paramActivity == null) {
      str = "null";
    }
    do
    {
      return str;
      str = paramActivity.getClass().getSimpleName();
      if ((paramActivity instanceof PluginProxyActivity))
      {
        paramActivity = a(((PluginProxyActivity)paramActivity).getPluginActivity());
        return str + "_" + paramActivity;
      }
    } while (!a(paramActivity));
    return "MiniAppPage";
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
    if (!(paramObject instanceof Frame)) {}
    label129:
    for (;;)
    {
      return;
      paramActivity = c(paramActivity);
      paramActivity = paramActivity + "_" + paramString;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramBoolean)
        {
          paramString = "onFrameHidden";
          QLog.i("UECPageStayTimeReport", 2, paramString + " frameKey = " + paramActivity);
        }
      }
      else
      {
        if (!paramBoolean) {
          break label121;
        }
      }
      label121:
      for (paramString = b(paramObject);; paramString = a(paramObject))
      {
        if (paramString == null) {
          break label129;
        }
        if (!paramBoolean) {
          break label131;
        }
        paramString.b();
        a(paramString);
        return;
        paramString = "onFrameShow";
        break;
      }
    }
    label131:
    paramString.a = paramActivity;
    paramString.a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    String str1 = c(paramActivity);
    String str2 = b(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.e("UECPageStayTimeReport", 2, "onActivityPaused :  activityKey = " + str1 + " activitySpecialKey = " + str2);
    }
    paramActivity = b(paramActivity);
    if (paramActivity != null)
    {
      paramActivity.b();
      a(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    String str1 = c(paramActivity);
    String str2 = b(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.e("UECPageStayTimeReport", 2, "onActivityResumed :  activityKey = " + str1 + " activitySpecialKey = " + str2);
    }
    paramActivity = a(paramActivity);
    paramActivity.a = str1;
    paramActivity.b = str2;
    paramActivity.a();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onFragmentHiddenChanged(Fragment paramFragment, boolean paramBoolean)
  {
    String str1;
    String str3;
    String str2;
    if (paramFragment != null)
    {
      str1 = c(paramFragment.getActivity());
      str3 = paramFragment.getClass().getSimpleName();
      str2 = a(paramFragment);
      str3 = str1 + "_" + str3;
      if ((paramBoolean) || (paramFragment.getUserVisibleHint())) {
        break label94;
      }
      QLog.e("UECPageStayTimeReport", 1, "Fragment status discontent , QfragmentKey = " + str3);
    }
    label202:
    label209:
    for (;;)
    {
      return;
      label94:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramBoolean)
        {
          str1 = "onFragmentHide";
          QLog.i("UECPageStayTimeReport", 2, str1 + " fragmentKey = " + str3 + " fragmentSpecialKey = " + str2 + " fragmentState = " + paramFragment.getUserVisibleHint());
        }
      }
      else
      {
        if (!paramBoolean) {
          break label202;
        }
      }
      for (paramFragment = b(paramFragment);; paramFragment = a(paramFragment))
      {
        if (paramFragment == null) {
          break label209;
        }
        if (!paramBoolean) {
          break label211;
        }
        paramFragment.b();
        a(paramFragment);
        return;
        str1 = "onFragmentShow";
        break;
      }
    }
    label211:
    paramFragment.a = str3;
    paramFragment.b = str2;
    paramFragment.a();
  }
  
  public void onFragmentHiddenChanged(QFragment paramQFragment, boolean paramBoolean)
  {
    String str1;
    String str2;
    if (paramQFragment != null)
    {
      str1 = c(paramQFragment.getActivity());
      str2 = paramQFragment.getClass().getSimpleName();
      str2 = str1 + "_" + str2;
      if ((paramBoolean) || (paramQFragment.getUserVisibleHint())) {
        break label87;
      }
      QLog.e("UECPageStayTimeReport", 1, "QFragment status discontent , QfragmentKey = " + str2);
    }
    label184:
    label191:
    for (;;)
    {
      return;
      label87:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramBoolean)
        {
          str1 = "onQFragmentHide";
          QLog.i("UECPageStayTimeReport", 2, str1 + " QfragmentKey = " + str2 + " QfragmentState = " + paramQFragment.getUserVisibleHint());
        }
      }
      else
      {
        if (!paramBoolean) {
          break label184;
        }
      }
      for (paramQFragment = b(paramQFragment);; paramQFragment = a(paramQFragment))
      {
        if (paramQFragment == null) {
          break label191;
        }
        if (!paramBoolean) {
          break label193;
        }
        paramQFragment.b();
        a(paramQFragment);
        return;
        str1 = "onQFragmentShow";
        break;
      }
    }
    label193:
    paramQFragment.a = str2;
    paramQFragment.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayTimeReport
 * JD-Core Version:    0.7.0.1
 */