package com.tencent.mobileqq.qcircle.api.helper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.interfaces.QCircleHookPluginIntentCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;

public class HostUIHelper
{
  public static final String KEY_IS_AUTO_CLOSE_HOST = "key_is_auto_close_host";
  private static final String TAG = "HostUIHelper";
  private static java.lang.ref.WeakReference<Context> mHostContext;
  private static CopyOnWriteArrayList<HostUIHelper.HostEnvironmentLifeCycle> mListeners = new CopyOnWriteArrayList();
  private static java.lang.ref.WeakReference<Context> mShadowTopContext;
  private static ViewGroup mTransTouchTransEventViewGroup;
  private static HostUIHelper sInstance;
  private final Context mHostApplicationContext;
  private int mHostTabHeight;
  private QCircleHookPluginIntentCallBack mQCircleHookPluginIntentCallBack;
  
  private HostUIHelper(Context paramContext)
  {
    this.mHostApplicationContext = paramContext;
  }
  
  private static void clearHostContext()
  {
    QLog.d("HostUIHelper", 1, new Object[] { "clearHostContext... mCurrentContext:", Integer.valueOf(((Context)mHostContext.get()).hashCode()) });
    getLifeCycleListeners().clear();
    mHostContext = null;
  }
  
  public static boolean closeHostEnvironment()
  {
    java.lang.ref.WeakReference localWeakReference = mHostContext;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((Activity)mHostContext.get()).finish();
      ((Activity)mHostContext.get()).overridePendingTransition(0, 0);
      clearHostContext();
      return true;
    }
    return false;
  }
  
  public static void closeTopShadowActivity()
  {
    java.lang.ref.WeakReference localWeakReference = mShadowTopContext;
    if ((localWeakReference != null) && (isContextShadowActivity((Context)localWeakReference.get())))
    {
      ((Activity)mShadowTopContext.get()).finish();
      mShadowTopContext = null;
    }
  }
  
  public static HostUIHelper getInstance()
  {
    if (sInstance == null) {
      init();
    }
    return sInstance;
  }
  
  private static CopyOnWriteArrayList<HostUIHelper.HostEnvironmentLifeCycle> getLifeCycleListeners()
  {
    if (mListeners == null) {
      mListeners = new CopyOnWriteArrayList();
    }
    return mListeners;
  }
  
  public static Context getShadowTopContext()
  {
    java.lang.ref.WeakReference localWeakReference = mShadowTopContext;
    if (localWeakReference != null) {
      return (Context)localWeakReference.get();
    }
    return null;
  }
  
  public static void init()
  {
    sInstance = new HostUIHelper(MobileQQ.sMobileQQ);
    MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(new HostUIHelper.1());
  }
  
  public static boolean isContextShadowActivity(Context paramContext)
  {
    return ((paramContext instanceof Activity)) && (((Activity)paramContext).getComponentName().getClassName().startsWith("com.tencent.biz.qcircleshadow.local.activity"));
  }
  
  private static boolean isHostEnvironment(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if ((paramContext instanceof QPublicTransFragmentActivity)) {
        if (!((Activity)paramContext).getIntent().getStringExtra("public_fragment_class").equals(((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQCircleHostTransFragmentClass().getCanonicalName()))
        {
          boolean bool3 = ((Activity)paramContext).getIntent().getStringExtra("public_fragment_class").equals(((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQCircleHostTransLoginOutFragmentClass().getCanonicalName());
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static void openHostEnvironment(HostUIHelper.HostEnvironmentLifeCycle paramHostEnvironmentLifeCycle)
  {
    openHostEnvironment(paramHostEnvironmentLifeCycle, null);
  }
  
  public static void openHostEnvironment(HostUIHelper.HostEnvironmentLifeCycle paramHostEnvironmentLifeCycle, Intent paramIntent)
  {
    if (paramHostEnvironmentLifeCycle == null) {
      return;
    }
    if (!getLifeCycleListeners().contains(paramHostEnvironmentLifeCycle)) {
      getLifeCycleListeners().add(paramHostEnvironmentLifeCycle);
    }
    java.lang.ref.WeakReference localWeakReference = mHostContext;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      paramIntent = mHostContext;
      if ((paramIntent != null) && (paramIntent.get() != null))
      {
        paramHostEnvironmentLifeCycle.onEnvironmentCreated((Context)mHostContext.get());
        paramHostEnvironmentLifeCycle.onEnvironmentStarted((Context)mHostContext.get());
        paramHostEnvironmentLifeCycle.onEnvironmentResume((Context)mHostContext.get());
      }
    }
    else
    {
      paramHostEnvironmentLifeCycle = paramIntent;
      if (paramIntent == null) {
        paramHostEnvironmentLifeCycle = new Intent();
      }
      paramHostEnvironmentLifeCycle.addFlags(268435456);
      paramHostEnvironmentLifeCycle.setClass(MobileQQ.getContext(), QPublicTransFragmentActivity.class);
      paramHostEnvironmentLifeCycle.putExtra("public_fragment_class", ((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQCircleHostTransFragmentClass().getCanonicalName());
      paramHostEnvironmentLifeCycle.putExtra("public_fragment_window_feature", 1);
      MobileQQ.getContext().startActivity(paramHostEnvironmentLifeCycle);
    }
  }
  
  public static void openLoginOutEnvironment(HostUIHelper.HostEnvironmentLifeCycle paramHostEnvironmentLifeCycle, Intent paramIntent)
  {
    if (paramHostEnvironmentLifeCycle == null) {
      return;
    }
    if (!getLifeCycleListeners().contains(paramHostEnvironmentLifeCycle)) {
      getLifeCycleListeners().add(paramHostEnvironmentLifeCycle);
    }
    java.lang.ref.WeakReference localWeakReference = mHostContext;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      paramIntent = mHostContext;
      if ((paramIntent != null) && (paramIntent.get() != null))
      {
        paramHostEnvironmentLifeCycle.onEnvironmentCreated((Context)mHostContext.get());
        paramHostEnvironmentLifeCycle.onEnvironmentStarted((Context)mHostContext.get());
        paramHostEnvironmentLifeCycle.onEnvironmentResume((Context)mHostContext.get());
      }
    }
    else
    {
      paramHostEnvironmentLifeCycle = paramIntent;
      if (paramIntent == null) {
        paramHostEnvironmentLifeCycle = new Intent();
      }
      paramHostEnvironmentLifeCycle.addFlags(268435456);
      paramHostEnvironmentLifeCycle.setClass(MobileQQ.getContext(), QPublicTransFragmentActivity.class);
      paramHostEnvironmentLifeCycle.putExtra("public_fragment_class", ((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQCircleHostTransLoginOutFragmentClass().getCanonicalName());
      paramHostEnvironmentLifeCycle.putExtra("public_fragment_window_feature", 1);
      MobileQQ.getContext().startActivity(paramHostEnvironmentLifeCycle);
    }
  }
  
  private static void registerDaTongReport(Activity paramActivity)
  {
    VideoReport.addToDetectionWhitelist(paramActivity);
    VideoReport.setPageId(paramActivity, ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).getQCircleDaTongBasePageId());
    VideoReport.setPageParams(paramActivity, ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).buildPageParams("HostUIHelper"));
    QLog.i("HostUIHelper", 1, "reportDaTongRegister  subPage: HostUIHelper");
  }
  
  public static void setTransEventViewGroup(ViewGroup paramViewGroup)
  {
    mTransTouchTransEventViewGroup = paramViewGroup;
  }
  
  public Context getHostApplicationContext()
  {
    return this.mHostApplicationContext;
  }
  
  public int getHostLayoutId(String paramString)
  {
    return this.mHostApplicationContext.getResources().getIdentifier(paramString, "layout", this.mHostApplicationContext.getPackageName());
  }
  
  public int getHostResourceId(String paramString1, String paramString2)
  {
    return this.mHostApplicationContext.getResources().getIdentifier(paramString2, paramString1, this.mHostApplicationContext.getPackageName());
  }
  
  public int getHostString(String paramString)
  {
    return this.mHostApplicationContext.getResources().getIdentifier(paramString, "string", this.mHostApplicationContext.getPackageName());
  }
  
  public int getHostTabHeight()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getHostTabHeight:");
    localStringBuilder.append(this.mHostTabHeight);
    QLog.d("HostUIHelper", 1, localStringBuilder.toString());
    return this.mHostTabHeight;
  }
  
  public Context getHostTopActivityContext()
  {
    if (MobileQQ.sMobileQQ.getResumeActivity() != null) {
      return (Context)MobileQQ.sMobileQQ.getResumeActivity().get();
    }
    return null;
  }
  
  public View getHostView(String paramString)
  {
    return LayoutInflater.from(this.mHostApplicationContext).inflate(getHostLayoutId(paramString), null, false);
  }
  
  public QCircleHookPluginIntentCallBack getQCircleHookPluginIntentCallBack()
  {
    return this.mQCircleHookPluginIntentCallBack;
  }
  
  @Deprecated
  public boolean isDenyNotAsk()
  {
    if (QBaseActivity.sTopActivity != null)
    {
      boolean bool = QBaseActivity.sTopActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION") ^ true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qcircle tab isDenyNotAsk:");
      localStringBuilder.append(bool);
      QLog.d("HostUIHelper", 1, localStringBuilder.toString());
      return bool;
    }
    return false;
  }
  
  public void jumpSystemSettingPage()
  {
    QLog.d("HostUIHelper", 1, "qcircle tab jumpSystemSettingPage");
    if (QBaseActivity.sTopActivity != null)
    {
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", QBaseActivity.sTopActivity.getPackageName(), null));
      QBaseActivity.sTopActivity.startActivity(localIntent);
    }
  }
  
  @Deprecated
  public void requestPermissions(Object paramObject)
  {
    if (QBaseActivity.sTopActivity != null)
    {
      QLog.d("HostUIHelper", 1, "qcircle tab requestPermissions");
      QBaseActivity.sTopActivity.requestPermissions(paramObject, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public void setHostTABHeight(int paramInt)
  {
    this.mHostTabHeight = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHostTABHeight:");
    localStringBuilder.append(paramInt);
    QLog.d("HostUIHelper", 1, localStringBuilder.toString());
  }
  
  public void setPluginIntentHook(QCircleHookPluginIntentCallBack paramQCircleHookPluginIntentCallBack)
  {
    this.mQCircleHookPluginIntentCallBack = paramQCircleHookPluginIntentCallBack;
  }
  
  public boolean transTouchEventToTargetViewGroup(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup = mTransTouchTransEventViewGroup;
    if (localViewGroup != null)
    {
      localViewGroup.dispatchTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.HostUIHelper
 * JD-Core Version:    0.7.0.1
 */