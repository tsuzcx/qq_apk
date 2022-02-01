package cooperation.ilive.lite.service;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.activity.ActivityLifeCycleService;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.QQLiveJumpUtil;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class IliveActivityLifeCycleService
  implements ActivityLifeCycleService, IQQGiftEngineAnimationListener
{
  private Context a;
  private IQQGiftAnimationEngine b;
  
  private void c()
  {
    BusinessConfig localBusinessConfig = BusinessManager.a.b();
    if (localBusinessConfig != null) {
      localBusinessConfig.m.put("has_preload", "1");
    }
  }
  
  private void d()
  {
    IQQGiftSDK localIQQGiftSDK = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001);
    if (localIQQGiftSDK == null)
    {
      QLog.e("IliveActivityLifeCycleS", 1, "giftSDK == null.");
      return;
    }
    if (this.b == null)
    {
      if (!localIQQGiftSDK.a()) {
        localIQQGiftSDK.a(MobileQQ.sMobileQQ.waitAppRuntime(null), QQGiftSDKConfig.a().a(10001).a("2ba343368f5483089089ae290adf298f").a());
      }
      this.b = localIQQGiftSDK.e().a(this.a);
      this.b.a();
      this.b.a(this);
    }
  }
  
  private void e()
  {
    IQQGiftAnimationEngine localIQQGiftAnimationEngine = this.b;
    if (localIQQGiftAnimationEngine != null)
    {
      localIQQGiftAnimationEngine.b(this);
      this.b.c();
      this.b = null;
    }
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public IQQGiftAnimationEngine b()
  {
    return this.b;
  }
  
  public void clearEventOutput() {}
  
  public void onActivityCreated(Activity paramActivity)
  {
    this.a = paramActivity;
    QQLiveJumpUtil.a();
    QQLiveJumpUtil.b();
    c();
    QLog.i("IliveActivityLifeCycleS", 1, "onActivityCreated");
    IliveLiteMonitorUtil.a("live_enter_tick_time", "activity_create");
    d();
  }
  
  public void onActivityDestroyed()
  {
    QLog.i("IliveActivityLifeCycleS", 1, "onActivityDestroyed");
    e();
    if (!QQLiveJumpUtil.e())
    {
      QLog.i("IliveActivityLifeCycleS", 1, "isInRoom sdk not destroy");
      QQLiveJumpUtil.c();
      QQLiveJumpUtil.d();
    }
  }
  
  public void onActivityPaused()
  {
    QLog.i("IliveActivityLifeCycleS", 1, "onActivityPaused");
  }
  
  public void onActivityResumed()
  {
    QLog.i("IliveActivityLifeCycleS", 1, "onActivityResumed");
    IliveLiteMonitorUtil.c("live_activity_launch");
    IliveLiteMonitorUtil.a("live_enter_tick_time", "activity_resume");
  }
  
  public void onActivityStarted()
  {
    QLog.i("IliveActivityLifeCycleS", 1, "onActivityStarted");
    IliveLiteEventCenter.a().a("ACTION_ACTIVITY_START", null);
  }
  
  public void onActivityStopped()
  {
    QLog.i("IliveActivityLifeCycleS", 1, "onActivityStopped");
    IliveLiteEventCenter.a().a("ACTION_ACTIVITY_STOP", null);
  }
  
  public void onAnimationEnd(GiftAnimData paramGiftAnimData) {}
  
  public void onAnimationStart(GiftAnimData paramGiftAnimData) {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void onFinish()
  {
    Object localObject = LiteLiveSDKFactory.a().b();
    if ((localObject != null) && (((BusinessConfig)localObject).a.equals("1037"))) {
      localObject = (String)((BusinessConfig)localObject).m.get("closejump");
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityDestroy , url = ");
    localStringBuilder.append((String)localObject);
    QLog.e("IliveActivityLifeCycleS", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ((ILiveDelivery)RemoteProxy.getProxy(LiveDelivery.class)).openSchema((String)localObject);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveActivityLifeCycleService
 * JD-Core Version:    0.7.0.1
 */