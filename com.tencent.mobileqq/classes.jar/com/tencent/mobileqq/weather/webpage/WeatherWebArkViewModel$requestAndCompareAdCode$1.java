package com.tencent.mobileqq.weather.webpage;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ark.ark;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.weather.WeatherServlet;
import com.tencent.mobileqq.weather.util.WeatherHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "onLocationFinish", "", "errCode", "", "info", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebArkViewModel$requestAndCompareAdCode$1
  extends LbsManagerServiceOnLocationChangeListener
{
  WeatherWebArkViewModel$requestAndCompareAdCode$1(String paramString1, AppActivity paramAppActivity, String paramString2, boolean paramBoolean)
  {
    super(paramBoolean, bool);
  }
  
  public void onLocationFinish(int paramInt, @Nullable SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {
      try
      {
        paramSosoLbsInfo = paramSosoLbsInfo.mLocation.cityCode;
        Intrinsics.checkExpressionValueIsNotNull(paramSosoLbsInfo, "info.mLocation.cityCode");
      }
      catch (Throwable paramSosoLbsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WeatherWebArkViewModel", 2, paramSosoLbsInfo, new Object[0]);
        }
      }
    } else {
      paramSosoLbsInfo = "";
    }
    if ((TextUtils.isEmpty((CharSequence)this.b)) && (TextUtils.isEmpty((CharSequence)paramSosoLbsInfo))) {
      this.a.a().postValue(new WebPageData(3, null, null, null, 0, 0, 62, null));
    }
    Object localObject = (CharSequence)paramSosoLbsInfo;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (WeatherHelper.a((Context)this.c)))
    {
      if ((this.c != null) && (!TextUtils.equals((CharSequence)localObject, (CharSequence)this.b)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("user location changed, report to weather server, new adcode:");
        ((StringBuilder)localObject).append(paramSosoLbsInfo);
        ((StringBuilder)localObject).append(", old adcode:");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("WeatherWebArkViewModel", 1, ((StringBuilder)localObject).toString());
        WeatherServlet.a(this.c, paramSosoLbsInfo, true);
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", 2);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("adcode", paramSosoLbsInfo);
      ((JSONObject)localObject).put("data", localJSONObject);
      try
      {
        ark.arkNotify("com.tencent.weather_v2", "receive_web_msg", ((JSONObject)localObject).toString(), "json");
      }
      catch (Throwable localThrowable)
      {
        QLog.i("WeatherWebArkViewModel", 1, "ark.arkNotify", localThrowable);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode ：");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", curAdCode: ");
    localStringBuilder.append(paramSosoLbsInfo);
    localStringBuilder.append(", originAdCode: ");
    localStringBuilder.append(this.b);
    QLog.i("WeatherWebArkViewModel", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebArkViewModel.requestAndCompareAdCode.1
 * JD-Core Version:    0.7.0.1
 */