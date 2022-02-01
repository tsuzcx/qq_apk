package com.tencent.mobileqq.weather.hippy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.weather.util.WeatherHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/weather/hippy/QQWeatherModule$getLatestAdCode$1", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "onLocationFinish", "", "errCode", "", "info", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class QQWeatherModule$getLatestAdCode$1
  extends LbsManagerServiceOnLocationChangeListener
{
  QQWeatherModule$getLatestAdCode$1(Promise paramPromise, String paramString, boolean paramBoolean)
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
          QLog.e("QQWeatherNativeModule", 2, paramSosoLbsInfo, new Object[0]);
        }
        this.b.reject(paramSosoLbsInfo);
      }
    } else {
      paramSosoLbsInfo = "";
    }
    CharSequence localCharSequence = (CharSequence)paramSosoLbsInfo;
    if (TextUtils.isEmpty(localCharSequence))
    {
      if (QQWeatherModule.access$getActivity(this.a) != null) {
        QQToast.makeText((Context)QQWeatherModule.access$getActivity(this.a), (CharSequence)HardCodeUtil.a(2131917994), 0).show();
      }
      this.b.resolve(paramSosoLbsInfo);
      return;
    }
    if ((!TextUtils.isEmpty(localCharSequence)) && (WeatherHelper.a((Context)QQWeatherModule.access$getActivity(this.a)))) {
      try
      {
        this.b.resolve(paramSosoLbsInfo);
      }
      catch (Throwable localThrowable)
      {
        QLog.i("QQWeatherNativeModule", 1, "ark.arkNotify", localThrowable);
        this.b.reject(localThrowable);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode ：");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", curAdCode: ");
    localStringBuilder.append(paramSosoLbsInfo);
    QLog.i("QQWeatherNativeModule", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.hippy.QQWeatherModule.getLatestAdCode.1
 * JD-Core Version:    0.7.0.1
 */