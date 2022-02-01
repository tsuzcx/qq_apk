package com.tencent.mobileqq.weather.webpage;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WeatherWebPageHelper$asyncInitGdtDeviceInfo$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    WeatherWebPageHelper localWeatherWebPageHelper = WeatherWebPageHelper.a;
    Object localObject = ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).getDeviceInfoAsJson("a03996");
    if (localObject != null)
    {
      Charset localCharset = Charsets.UTF_8;
      if (localObject != null)
      {
        localObject = ((String)localObject).getBytes(localCharset);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
        localObject = Base64Util.encodeToString((byte[])localObject, 2);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    else
    {
      localObject = null;
    }
    WeatherWebPageHelper.a(localWeatherWebPageHelper, (String)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gdt device info for weather 2.0 updated:");
      ((StringBuilder)localObject).append(WeatherWebPageHelper.a(WeatherWebPageHelper.a));
      QLog.d("WeatherWebPageHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebPageHelper.asyncInitGdtDeviceInfo.1
 * JD-Core Version:    0.7.0.1
 */