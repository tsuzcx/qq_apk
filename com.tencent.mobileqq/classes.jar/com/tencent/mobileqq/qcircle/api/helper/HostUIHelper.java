package com.tencent.mobileqq.qcircle.api.helper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleDTParamBuilder;
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
    if ((mHostContext != null) && (mHostContext.get() != null))
    {
      ((Activity)mHostContext.get()).finish();
      clearHostContext();
      return true;
    }
    return false;
  }
  
  public static void closeTopShadowActivity()
  {
    if ((mShadowTopContext != null) && (isContextShadowActivity((Context)mShadowTopContext.get())))
    {
      ((Activity)mShadowTopContext.get()).finish();
      mShadowTopContext = null;
    }
  }
  
  public static HostUIHelper getInstance()
  {
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
    if (mShadowTopContext != null) {
      return (Context)mShadowTopContext.get();
    }
    return null;
  }
  
  public static void init(Context paramContext)
  {
    sInstance = new HostUIHelper(paramContext);
    MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(new HostUIHelper.1());
  }
  
  public static boolean isContextShadowActivity(Context paramContext)
  {
    return ((paramContext instanceof Activity)) && (((Activity)paramContext).getComponentName().getClassName().startsWith("com.tencent.biz.qcircleshadow.local.activity"));
  }
  
  private static boolean isHostEnvironment(Context paramContext)
  {
    try
    {
      if ((paramContext instanceof QPublicTransFragmentActivity))
      {
        boolean bool = ((Activity)paramContext).getIntent().getStringExtra("public_fragment_class").equals(((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQCircleHostTransFragmentClass().getCanonicalName());
        if (bool) {
          return true;
        }
      }
      return false;
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
    if (paramHostEnvironmentLifeCycle == null) {}
    do
    {
      return;
      if (!getLifeCycleListeners().contains(paramHostEnvironmentLifeCycle)) {
        getLifeCycleListeners().add(paramHostEnvironmentLifeCycle);
      }
      if ((mHostContext == null) || (mHostContext.get() == null))
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
        return;
      }
    } while ((mHostContext == null) || (mHostContext.get() == null));
    paramHostEnvironmentLifeCycle.onEnvironmentCreated((Context)mHostContext.get());
    paramHostEnvironmentLifeCycle.onEnvironmentStarted((Context)mHostContext.get());
    paramHostEnvironmentLifeCycle.onEnvironmentResume((Context)mHostContext.get());
  }
  
  private static void registerDaTongReport(Activity paramActivity)
  {
    VideoReport.addToDetectionWhitelist(paramActivity);
    VideoReport.setPageId(paramActivity, "small_world_base");
    VideoReport.setPageParams(paramActivity, new QCircleDTParamBuilder().setPageSubclass("HostUIHelper").buildPageParams());
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
  
  public boolean transTouchEventToTargetViewGroup(MotionEvent paramMotionEvent)
  {
    if (mTransTouchTransEventViewGroup != null)
    {
      mTransTouchTransEventViewGroup.dispatchTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.HostUIHelper
 * JD-Core Version:    0.7.0.1
 */