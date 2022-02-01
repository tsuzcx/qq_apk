package com.tencent.mobileqq.weather.hippy;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@HippyNativeModule(name="QQWeatherModule")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/hippy/QQWeatherModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "context", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "PERMISSIONS", "", "", "[Ljava/lang/String;", "getLatestAdCode", "", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "getWeatherArkModels", "requestLocationPermission", "setNavigationStyle", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class QQWeatherModule
  extends QQBaseModule
{
  public static final QQWeatherModule.Companion Companion = new QQWeatherModule.Companion(null);
  @NotNull
  public static final String NAME = "QQWeatherModule";
  private static final String TAG = "QQWeatherNativeModule";
  private final String[] PERMISSIONS = { "android.permission.ACCESS_FINE_LOCATION" };
  
  public QQWeatherModule(@NotNull HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="getLatestAdCode")
  public final void getLatestAdCode(@NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    QLog.d("QQWeatherNativeModule", 1, "hippy call getLatestAdCode");
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation((LbsManagerServiceOnLocationChangeListener)new QQWeatherModule.getLatestAdCode.1(this, paramPromise, "qq_weather", false));
  }
  
  @HippyMethod(name="getWeatherArkModels")
  public final void getWeatherArkModels(@NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    QLog.d("QQWeatherNativeModule", 1, "hippy call requestArkData");
    try
    {
      Object localObject = ((IMessageFacade)getAppInterface().getRuntimeService(IMessageFacade.class, "")).getLastMessage("2658655094", 1008);
      QRouteApi localQRouteApi = QRoute.api(IEcshopMessageApi.class);
      Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IEcshopMessageApi::class.java)");
      localObject = new JSONObject(((IEcshopMessageApi)localQRouteApi).getArkMsgMetaList(((Message)localObject).lastMsg)).getJSONObject("weather").getJSONObject("waterfall_ark").getJSONObject("meta").getJSONObject("qq_weather");
      ((JSONObject)localObject).remove("forecast_list");
      ((JSONObject)localObject).remove("hourinfo_list");
      if (TextUtils.isEmpty((CharSequence)((JSONObject)localObject).toString()))
      {
        localObject = "{}";
      }
      else
      {
        localObject = ((JSONObject)localObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "jsonObject.toString()");
      }
      paramPromise.resolve(localObject);
      return;
    }
    catch (Exception localException)
    {
      paramPromise.reject(localException);
      QLog.e("QQWeatherNativeModule", 1, (Throwable)localException, new Object[0]);
    }
  }
  
  @HippyMethod(name="requestLocationPermission")
  public final void requestLocationPermission(@NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    Object localObject = new BusinessConfig("biz_src_weather", "drawer_weather");
    localObject = QQPermissionFactory.a(getActivity(), (BusinessConfig)localObject);
    if (localObject != null) {
      ((QQPermission)localObject).a(this.PERMISSIONS, 2, (QQPermission.BasePermissionsListener)new QQWeatherModule.requestLocationPermission.1(paramPromise));
    }
  }
  
  @HippyMethod(name="setNavigationStyle")
  public final void setNavigationStyle(@Nullable HippyMap paramHippyMap)
  {
    QLog.d("QQWeatherNativeModule", 1, "hippy call setNavigationStyle");
    QBaseFragment localQBaseFragment = getFragment();
    if (((localQBaseFragment instanceof WeatherMainHippyFragment)) && (paramHippyMap != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTitle ");
      localStringBuilder.append(paramHippyMap);
      QLog.d("QQWeatherNativeModule", 1, localStringBuilder.toString());
      ((WeatherMainHippyFragment)localQBaseFragment).a(paramHippyMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.hippy.QQWeatherModule
 * JD-Core Version:    0.7.0.1
 */