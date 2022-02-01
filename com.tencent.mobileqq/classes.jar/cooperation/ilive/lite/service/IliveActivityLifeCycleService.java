package cooperation.ilive.lite.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.activity.ActivityLifeCycleService;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import java.util.HashMap;

public class IliveActivityLifeCycleService
  implements ActivityLifeCycleService
{
  private Context a;
  
  private void a()
  {
    BusinessConfig localBusinessConfig = BusinessManager.a.a();
    if (localBusinessConfig != null) {
      localBusinessConfig.jdField_a_of_type_JavaUtilHashMap.put("has_preload", "1");
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity.finish();
    a();
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public void clearEventOutput() {}
  
  public void onActivityCreated(Activity paramActivity)
  {
    this.a = paramActivity;
    if ((paramActivity != null) && (paramActivity.getIntent() != null))
    {
      Bundle localBundle = paramActivity.getIntent().getBundleExtra("biz_ext_data");
      if (localBundle == null) {
        a(paramActivity);
      }
      if (!"1".equals(localBundle.getString("enter_room")))
      {
        QLog.e("IliveActivityLifeCycleS", 1, "onActivityCreated preload = 1 , finish");
        a(paramActivity);
      }
    }
    else
    {
      a(paramActivity);
    }
    a();
    QLog.i("IliveActivityLifeCycleS", 1, "onActivityCreated");
    IliveLiteMonitorUtil.a("live_enter_tick_time", "activity_create");
  }
  
  public void onActivityDestroyed()
  {
    QLog.i("IliveActivityLifeCycleS", 1, "onActivityDestroyed");
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
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void onFinish()
  {
    Object localObject = LiteLiveSDKFactory.a().a();
    if ((localObject != null) && (((BusinessConfig)localObject).jdField_a_of_type_JavaLangString.equals("1037"))) {
      localObject = (String)((BusinessConfig)localObject).jdField_a_of_type_JavaUtilHashMap.get("closejump");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveActivityLifeCycleService
 * JD-Core Version:    0.7.0.1
 */