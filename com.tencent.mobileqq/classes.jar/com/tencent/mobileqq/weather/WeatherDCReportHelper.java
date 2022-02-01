package com.tencent.mobileqq.weather;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.weather.webpage.WeatherPreloadHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class WeatherDCReportHelper
{
  private static WeatherDCReportHelper a;
  
  public static WeatherDCReportHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WeatherDCReportHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    a(paramAppInterface, "new_folder_weather_expose");
  }
  
  public void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -5008))
    {
      WeatherPreloadHelper.a(1, "");
      a(paramAppInterface, "new_folder_weather_arrive");
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    a(paramAppInterface, paramString, null);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, Object paramObject)
  {
    if ((paramObject != null) && (!TextUtils.isEmpty(String.valueOf(paramObject))))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|");
      localStringBuilder.append(paramObject);
      paramObject = localStringBuilder.toString();
    }
    else
    {
      paramObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("|");
    localStringBuilder.append("QQWeather");
    localStringBuilder.append("|");
    localStringBuilder.append("QQWeather_native");
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append("android");
    localStringBuilder.append(paramObject);
    paramString = localStringBuilder.toString();
    DcReportUtil.a(paramAppInterface, "dc04698", paramString);
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("reportWeather : ");
      paramAppInterface.append(paramString);
      QLog.d("WeatherDCReportHelper", 2, paramAppInterface.toString());
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("|");
    localStringBuilder.append("QQWeather");
    localStringBuilder.append("|");
    localStringBuilder.append("QQWeather_native");
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      localStringBuilder.append("|");
      localStringBuilder.append(paramString);
      i += 1;
    }
    paramString = localStringBuilder.toString();
    DcReportUtil.a(paramAppRuntime, "dc04698", paramString);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("reportWeather : ");
      paramAppRuntime.append(paramString);
      QLog.d("WeatherDCReportHelper", 2, paramAppRuntime.toString());
    }
  }
  
  public void b(AppInterface paramAppInterface)
  {
    a(paramAppInterface, "new_folder_weather_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.WeatherDCReportHelper
 * JD-Core Version:    0.7.0.1
 */