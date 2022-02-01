package com.tencent.mobileqq.weather.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherHippyApi;
import com.tencent.mobileqq.weather.hippy.QQWeatherApiProvider;
import com.tencent.mobileqq.weather.webpage.WeatherWebPageHelper;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/api/impl/WeatherHippyApiImpl;", "Lcom/tencent/mobileqq/weather/api/IWeatherHippyApi;", "()V", "canPreloadHippy", "", "createHippyProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "hasNewMessage", "hasUnReadMsg", "isWeatherModule", "moduleName", "", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherHippyApiImpl
  implements IWeatherHippyApi
{
  public static final WeatherHippyApiImpl.Companion Companion = new WeatherHippyApiImpl.Companion(null);
  private static final String TAG = "WeatherHippyApiImpl";
  
  private final boolean hasUnReadMsg()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((AppRuntime)localObject).getRuntimeService(IConversationFacade.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "appRuntime.getRuntimeSer…va, ProcessConstant.MAIN)");
      bool1 = bool2;
      if (((IConversationFacade)localObject).getUnreadCount("2658655094", 1008) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean canPreloadHippy()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool2 = false;
    if (localObject != null)
    {
      IPublicAccountUtil localIPublicAccountUtil = (IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class);
      if (localObject != null)
      {
        boolean bool3 = localIPublicAccountUtil.isFollowUin((AppInterface)localObject, "2658655094");
        boolean bool4 = hasUnReadMsg();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("canPreloadHippy enable=true isFollowPA=");
          ((StringBuilder)localObject).append(bool3);
          ((StringBuilder)localObject).append(" hasUnReadMsg=");
          ((StringBuilder)localObject).append(bool4);
          QLog.d("WeatherHippyApiImpl", 2, ((StringBuilder)localObject).toString());
        }
        boolean bool1 = bool2;
        if (bool4)
        {
          bool1 = bool2;
          if (bool3)
          {
            bool1 = bool2;
            if (WeatherWebPageHelper.a(false)) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
    }
    return false;
  }
  
  @NotNull
  public HippyAPIProvider createHippyProvider()
  {
    return (HippyAPIProvider)new QQWeatherApiProvider();
  }
  
  public boolean hasNewMessage()
  {
    boolean bool = hasUnReadMsg();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNewMessage hasNewMsg=");
      localStringBuilder.append(bool);
      QLog.d("WeatherHippyApiImpl", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean isWeatherModule(@Nullable String paramString)
  {
    return TextUtils.equals((CharSequence)paramString, (CharSequence)"qqWeather");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.api.impl.WeatherHippyApiImpl
 * JD-Core Version:    0.7.0.1
 */