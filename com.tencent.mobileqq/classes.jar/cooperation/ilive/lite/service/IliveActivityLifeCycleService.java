package cooperation.ilive.lite.service;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.activity.ActivityLifeCycleService;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class IliveActivityLifeCycleService
  implements ActivityLifeCycleService
{
  private Context a;
  
  public void clearEventOutput() {}
  
  public void onActivityCreated(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void onActivityDestroyed() {}
  
  public void onActivityPaused() {}
  
  public void onActivityResumed() {}
  
  public void onActivityStarted() {}
  
  public void onActivityStopped() {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void onFinish()
  {
    Object localObject = LiteLiveSDKFactory.a().a();
    if ((localObject != null) && (((BusinessConfig)localObject).jdField_a_of_type_JavaLangString.equals("1037"))) {}
    for (localObject = (String)((BusinessConfig)localObject).jdField_a_of_type_JavaUtilHashMap.get("closejump");; localObject = "")
    {
      QLog.e("IliveActivityLifeCycleS", 1, "onActivityDestroy , url = " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ((ILiveDelivery)RemoteProxy.getProxy(LiveDelivery.class)).openSchema((String)localObject);
      }
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveActivityLifeCycleService
 * JD-Core Version:    0.7.0.1
 */