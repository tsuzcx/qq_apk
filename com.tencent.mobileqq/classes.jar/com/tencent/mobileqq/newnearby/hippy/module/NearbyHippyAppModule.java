package com.tencent.mobileqq.newnearby.hippy.module;

import com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

@HippyNativeModule(name="NearbyHippyAppModule")
public class NearbyHippyAppModule
  extends HippyNativeModuleBase
{
  private static final String TAG = "NearbyHippyAppModule";
  
  public NearbyHippyAppModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="exitNearby")
  public void exitNearby(HippyMap paramHippyMap, Promise paramPromise)
  {
    QLog.d("NearbyHippyAppModule", 2, "exitNearby");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).exitNearby();
  }
  
  @HippyMethod(name="openAppSetting")
  public void openAppSetting(HippyMap paramHippyMap, Promise paramPromise)
  {
    QLog.d("NearbyHippyAppModule", 2, "openAppSetting");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).openAppSetting();
  }
  
  @HippyMethod(name="openMqqUrl")
  public void openMqqUrl(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramPromise = new StringBuilder();
    paramPromise.append("openMqqUrl readableMap=");
    paramPromise.append(paramHippyMap.toJSONObject().toString());
    QLog.d("NearbyHippyAppModule", 2, paramPromise.toString());
    paramHippyMap = paramHippyMap.getString("url");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).openMqqUrl(paramHippyMap);
  }
  
  @HippyMethod(name="requestLBS")
  public void requestLBS(HippyMap paramHippyMap, Promise paramPromise)
  {
    QLog.d("NearbyHippyAppModule", 2, "requestLBS");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).requestLBS(paramPromise);
  }
  
  @HippyMethod(name="selectAndUploadPicture")
  public void selectAndUploadPicture(HippyMap paramHippyMap, Promise paramPromise)
  {
    QLog.d("NearbyHippyAppModule", 2, "selectAndUploadPicture");
    int i = paramHippyMap.getInt("type");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).selectAndUploadPicture(i, paramPromise);
  }
  
  @HippyMethod(name="uploadProfilePicture")
  public void uploadProfilePicture(HippyMap paramHippyMap, Promise paramPromise)
  {
    QLog.d("NearbyHippyAppModule", 2, "uploadProfilePicture");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).uploadProfilePicture(paramPromise);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.module.NearbyHippyAppModule
 * JD-Core Version:    0.7.0.1
 */