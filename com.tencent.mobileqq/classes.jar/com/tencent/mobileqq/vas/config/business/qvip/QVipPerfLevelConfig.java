package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QVipPerfLevelConfig
{
  private int a = 1;
  
  @NonNull
  public static QVipPerfLevelConfig a()
  {
    return new QVipPerfLevelConfig();
  }
  
  @NonNull
  public static QVipPerfLevelConfig a(@Nullable String paramString)
  {
    QVipPerfLevelConfig localQVipPerfLevelConfig = new QVipPerfLevelConfig();
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localQVipPerfLevelConfig.a = new JSONObject(paramString).getInt("use_apm");
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("json parse error:");
      localStringBuilder.append(paramString);
      QLog.e("QVIP.SDK.ConfigProcessor", 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(" : ");
      paramString.append(localQVipPerfLevelConfig.toString());
      QLog.e("QVIP.SDK.ConfigProcessor", 1, paramString.toString());
    }
    return localQVipPerfLevelConfig;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QVipPerfLevelConfig{use_apm=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipPerfLevelConfig
 * JD-Core Version:    0.7.0.1
 */