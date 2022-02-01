package com.tencent.mobileqq.weather.webpage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WeatherWebArkViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "webPageData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/weather/webpage/WebPageData;", "getWebPageData", "()Landroidx/lifecycle/MutableLiveData;", "isNeedReqPermissions", "", "activity", "Lmqq/app/AppActivity;", "onArkLoadState", "", "state", "", "onArkMsgToClient", "params", "", "onArkMsgToWeb", "requestAdCode", "originAdCode", "requestAndCompareAdCode", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebArkViewModel
  extends ViewModel
{
  public static final WeatherWebArkViewModel.Companion a;
  @NotNull
  private final MutableLiveData<WebPageData> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebArkViewModel$Companion = new WeatherWebArkViewModel.Companion(null);
  }
  
  public WeatherWebArkViewModel()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  @NotNull
  public final MutableLiveData<WebPageData> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public final void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onArkLoadComplete  state: ");
      localStringBuilder.append(paramInt);
      QLog.d("WeatherWebArkViewModel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(new WebPageData(2, null, null, null, paramInt, 0, 46, null));
  }
  
  public final void a(@Nullable String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onArkMsgToWeb  params: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WeatherWebArkViewModel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString != null)
    {
      int i;
      try
      {
        localObject = new JSONObject(paramString);
        if (((JSONObject)localObject).optInt("type") == 1) {
          i = ((JSONObject)localObject).optJSONObject("data").optInt("height");
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onArkMsgToClient params: ");
        localStringBuilder.append(paramString);
        QLog.d("WeatherWebArkViewModel", 1, localStringBuilder.toString(), localThrowable);
        i = 0;
      }
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(new WebPageData(0, "receive_ark_msg", paramString, null, 0, i, 24, null));
    }
  }
  
  public final void a(@Nullable AppActivity paramAppActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originAdCode");
    if ((paramAppActivity != null) && (a(paramAppActivity)))
    {
      paramAppActivity.requestPermissions(new WeatherWebArkViewModel.requestAdCode.1(this, paramAppActivity, paramString), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    b(paramAppActivity, paramString);
  }
  
  public final boolean a(@Nullable AppActivity paramAppActivity)
  {
    if (paramAppActivity == null)
    {
      QLog.i("WeatherWebArkViewModel", 1, "activity == null");
      return false;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      QLog.i("WeatherWebArkViewModel", 1, "isNeedReqPermissions lass than Build.VERSION_CODES.M");
      return false;
    }
    if (paramAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
    {
      QLog.i("WeatherWebArkViewModel", 1, "isNeedReqPermissions PERMISSION_GRANTED");
      return false;
    }
    paramAppActivity = paramAppActivity.getSharedPreferences("cmgame_sp", 0);
    Intrinsics.checkExpressionValueIsNotNull(paramAppActivity, "activity.getSharedPrefer…ME, Context.MODE_PRIVATE)");
    long l1 = paramAppActivity.getLong("sp_key_weather_web_ark_request_permission", 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    if (Math.abs(l2 - l1) < 86400)
    {
      QLog.i("WeatherWebArkViewModel", 1, "isNeedReqPermissions  but has requested in 24 h");
      return false;
    }
    paramAppActivity.edit().putLong("sp_key_weather_web_ark_request_permission", l2).apply();
    QLog.i("WeatherWebArkViewModel", 1, "isNeedReqPermissions true");
    return true;
  }
  
  public final void b(@Nullable String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onArkMsgToClient  params: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("WeatherWebArkViewModel", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString != null) {
      try
      {
        localObject1 = new JSONObject(paramString);
        int i = ((JSONObject)localObject1).optInt("type");
        if (i == 1)
        {
          localObject1 = ((JSONObject)localObject1).optJSONObject("data").optString("bg_url");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "bgUrl");
            ((MutableLiveData)localObject2).postValue(new WebPageData(1, null, null, (String)localObject1, 0, 0, 54, null));
          }
        }
        else if (i == 2)
        {
          this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(new WebPageData(4, null, null, null, 0, 0, 62, null));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onArkMsgToClient params: ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.d("WeatherWebArkViewModel", 1, ((StringBuilder)localObject2).toString(), localThrowable);
      }
    }
  }
  
  public final void b(@Nullable AppActivity paramAppActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originAdCode");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestAndCompareAdCode originAdCode: ");
    localStringBuilder.append(paramString);
    QLog.i("WeatherWebArkViewModel", 1, localStringBuilder.toString());
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation((LbsManagerServiceOnLocationChangeListener)new WeatherWebArkViewModel.requestAndCompareAdCode.1(this, paramString, paramAppActivity, "qq_weather", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebArkViewModel
 * JD-Core Version:    0.7.0.1
 */