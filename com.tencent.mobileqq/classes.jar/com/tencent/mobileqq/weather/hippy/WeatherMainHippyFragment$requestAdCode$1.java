package com.tencent.mobileqq.weather.hippy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.weather.util.WeatherHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/weather/hippy/WeatherMainHippyFragment$requestAdCode$1", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "onLocationFinish", "", "errCode", "", "info", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherMainHippyFragment$requestAdCode$1
  extends LbsManagerServiceOnLocationChangeListener
{
  WeatherMainHippyFragment$requestAdCode$1(String paramString, boolean paramBoolean)
  {
    super(paramBoolean, bool);
  }
  
  public void onLocationFinish(int paramInt, @Nullable SosoLbsInfo paramSosoLbsInfo)
  {
    HippyMap localHippyMap = new HippyMap();
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {
      try
      {
        paramSosoLbsInfo = paramSosoLbsInfo.mLocation.cityCode;
        Intrinsics.checkExpressionValueIsNotNull(paramSosoLbsInfo, "info.mLocation.cityCode");
      }
      catch (Throwable paramSosoLbsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WeatherMainHippyFragment", 2, paramSosoLbsInfo, new Object[0]);
        }
      }
    } else {
      paramSosoLbsInfo = "";
    }
    Object localObject = (CharSequence)paramSosoLbsInfo;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (this.a.getActivity() != null) {
        QQToast.makeText((Context)this.a.getActivity(), (CharSequence)HardCodeUtil.a(2131917994), 0).show();
      }
      localHippyMap.pushString("adCode", paramSosoLbsInfo);
      this.a.sendHippyNativeEvent("updateAdCode", localHippyMap);
      return;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (WeatherHelper.a((Context)this.a.getActivity()))) {
      try
      {
        localHippyMap.pushString("adCode", paramSosoLbsInfo);
        this.a.sendHippyNativeEvent("updateAdCode", localHippyMap);
      }
      catch (Throwable localThrowable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send adcode to hippy failed, errCode ：");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", exception : ");
        ((StringBuilder)localObject).append(localThrowable);
        QLog.e("WeatherMainHippyFragment", 1, ((StringBuilder)localObject).toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode ：");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", curAdCode: ");
    localStringBuilder.append(paramSosoLbsInfo);
    QLog.i("WeatherMainHippyFragment", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.hippy.WeatherMainHippyFragment.requestAdCode.1
 * JD-Core Version:    0.7.0.1
 */