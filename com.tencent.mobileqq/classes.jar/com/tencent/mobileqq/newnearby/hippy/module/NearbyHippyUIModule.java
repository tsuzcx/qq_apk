package com.tencent.mobileqq.newnearby.hippy.module;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge;
import com.tencent.mobileqq.newnearby.util.PickBirthdayHelper;
import com.tencent.mobileqq.newnearby.util.PickLocationHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="NearbyHippyUIModule")
public class NearbyHippyUIModule
  extends HippyNativeModuleBase
{
  private static final String TAG = "NearbyHippyUIModule";
  
  public NearbyHippyUIModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="customizeTitleBar")
  public void customizeTitleBar(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("customizeTitleBar: ");
    ((StringBuilder)localObject).append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, ((StringBuilder)localObject).toString());
    localObject = paramHippyMap.optString("centerTitle", "");
    String str = paramHippyMap.optString("rightTitle", "");
    int i = paramHippyMap.optInt("titleTheme", 0);
    int j = paramHippyMap.optInt("leftClickEvent", 0);
    int k = paramHippyMap.optInt("rightClickEvent", 0);
    int m = paramHippyMap.optInt("key", -1);
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).customizeTitleBar((String)localObject, str, i, j, k, m, paramPromise);
  }
  
  @HippyMethod(name="hideBottomMask")
  public void hideBottomMask(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    paramPromise = new StringBuilder();
    paramPromise.append("hideTopMask: ");
    paramPromise.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).hideBottomMask();
  }
  
  @HippyMethod(name="hideNavigationBar")
  public void hideNavigationBar(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    paramPromise = new StringBuilder();
    paramPromise.append("hideNavigationBar: ");
    paramPromise.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).hideNavigationBar();
  }
  
  @HippyMethod(name="hideTopMask")
  public void hideTopMask(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    paramPromise = new StringBuilder();
    paramPromise.append("hideTopMask: ");
    paramPromise.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).hideTopMask();
  }
  
  @HippyMethod(name="nearbySafetyReport")
  public void nearbySafetyReport(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramPromise = new StringBuilder();
    paramPromise.append("nearbySafetyReport readableMap=");
    paramPromise.append(paramHippyMap.toJSONObject().toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    paramPromise = paramHippyMap.getString("tinyId");
    int i = paramHippyMap.getInt("scene");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).nearbySafetyReport(paramPromise, i);
  }
  
  @HippyMethod(name="openAIO")
  public void openAIO(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    paramPromise = new StringBuilder();
    paramPromise.append("openAIO: ");
    paramPromise.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    paramPromise = paramHippyMap.optString("tinyId");
    paramHippyMap = paramHippyMap.optString("name");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).openAio(paramPromise, paramHippyMap);
  }
  
  @HippyMethod(name="openHippy")
  public void openHippy(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramPromise = new StringBuilder();
    paramPromise.append("openHippy readableMap=");
    paramPromise.append(paramHippyMap.toJSONObject().toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    int i = paramHippyMap.getInt("animationType");
    paramHippyMap = paramHippyMap.getMap("initConfig").getString("url");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).openHippyByUrl(i, paramHippyMap);
  }
  
  @HippyMethod(name="openProfileCard")
  public void openProfileCard(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramPromise = new StringBuilder();
    paramPromise.append("openProfileCard readableMap=");
    paramPromise.append(paramHippyMap.toJSONObject().toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    try
    {
      paramPromise = new JSONObject();
      paramPromise.put("reportsource", paramHippyMap.getInt("reportsource"));
      paramPromise.put("from", paramHippyMap.getInt("from"));
      paramPromise.put("mode", paramHippyMap.getInt("mode"));
      paramPromise.put("source", paramHippyMap.getInt("source"));
      paramPromise.put("tinnyid", paramHippyMap.getString("tiny_id"));
      paramPromise.put("now_id", paramHippyMap.getString("now_id"));
      paramPromise.put("now_user_type", paramHippyMap.getInt("now_user_type"));
      paramHippyMap = paramPromise.toString();
      paramPromise = new StringBuilder();
      paramPromise.append("openProfileCard: ");
      paramPromise.append(paramHippyMap);
      QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
      ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).openProfileCard(paramHippyMap);
      return;
    }
    catch (JSONException paramHippyMap)
    {
      paramPromise = new StringBuilder();
      paramPromise.append("openProfileCard JSONException:");
      paramPromise.append(paramHippyMap.toString());
      QLog.e("NearbyHippyUIModule", 2, paramPromise.toString());
    }
  }
  
  @HippyMethod(name="preloadCitySelect")
  public void preloadCitySelect(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    QLog.d("NearbyHippyUIModule", 2, "preloadCitySelect");
    PickLocationHelper.a(paramHippyMap.optString("selectedCityCode"));
  }
  
  @HippyMethod(name="releaseCitySelect")
  public void releaseCitySelect(HippyMap paramHippyMap, Promise paramPromise)
  {
    QLog.d("NearbyHippyUIModule", 2, "releaseCitySelect");
    PickLocationHelper.a();
  }
  
  @HippyMethod(name="resetTitleBar")
  public void resetTitleBar(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    paramPromise = new StringBuilder();
    paramPromise.append("resetTitleBar: ");
    paramPromise.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    int i = paramHippyMap.optInt("titleTheme", 0);
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).resetTitleBar(i);
  }
  
  @HippyMethod(name="setVideoEnterVisibility")
  public void setVideoEnterVisibility(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    paramPromise = new StringBuilder();
    paramPromise.append("setVideoEnterVisibility: ");
    paramPromise.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    boolean bool = paramHippyMap.optBoolean("visible", false);
    paramHippyMap = paramHippyMap.optJSONArray("menu");
    if (paramHippyMap != null)
    {
      paramPromise = BaseApplicationImpl.getApplication().getRuntime();
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramPromise.getAccount(), "key_nearby_publish_menu", paramHippyMap.toString());
      if (QLog.isColorLevel())
      {
        paramPromise = new StringBuilder();
        paramPromise.append("menuItem=");
        paramPromise.append(paramHippyMap);
        QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
      }
    }
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).setVideoEnterVisibility(bool);
  }
  
  @HippyMethod(name="showBeginnerGuide")
  public void showBeginnerGuide(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toString();
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).showBeginnerGuide(paramHippyMap);
  }
  
  @HippyMethod(name="showBirthdaySelect")
  public void showBirthdaySelect(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showBirthdaySelect");
    localStringBuilder.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, localStringBuilder.toString());
    PickBirthdayHelper.a(paramPromise, paramHippyMap.optInt("year"), paramHippyMap.optInt("month"), paramHippyMap.optInt("day"));
  }
  
  @HippyMethod(name="showBottomMask")
  public void showBottomMask(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    paramPromise = new StringBuilder();
    paramPromise.append("showBottomMask: ");
    paramPromise.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).showBottomMask();
  }
  
  @HippyMethod(name="showCitySelect")
  public void showCitySelect(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showCitySelect");
    localStringBuilder.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, localStringBuilder.toString());
    PickLocationHelper.a(paramPromise, paramHippyMap.optString("selectedCityCode"));
  }
  
  @HippyMethod(name="showModifyBirthday")
  public void showModifyBirthday(HippyMap paramHippyMap, Promise paramPromise)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showModifyBirthday readableMap=");
    localStringBuilder.append(paramHippyMap.toJSONObject().toString());
    QLog.d("NearbyHippyUIModule", 2, localStringBuilder.toString());
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).openBirthdayEditActivity(paramPromise);
  }
  
  @HippyMethod(name="showNavigationBar")
  public void showNavigationBar(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    paramPromise = new StringBuilder();
    paramPromise.append("showNavigationBar: ");
    paramPromise.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).showNavigationBar();
  }
  
  @HippyMethod(name="showTopMask")
  public void showTopMask(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.toJSONObject();
    paramPromise = new StringBuilder();
    paramPromise.append("showTopMask: ");
    paramPromise.append(paramHippyMap.toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).showTopMask();
  }
  
  @HippyMethod(name="switchTab")
  public void switchTab(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramPromise = new StringBuilder();
    paramPromise.append("switchTab readableMap=");
    paramPromise.append(paramHippyMap.toJSONObject().toString());
    QLog.d("NearbyHippyUIModule", 2, paramPromise.toString());
    int i = paramHippyMap.getInt("index");
    paramHippyMap = paramHippyMap.getString("params");
    ((INearbyHippyBridge)QRoute.api(INearbyHippyBridge.class)).onTabChanged(i, paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.module.NearbyHippyUIModule
 * JD-Core Version:    0.7.0.1
 */