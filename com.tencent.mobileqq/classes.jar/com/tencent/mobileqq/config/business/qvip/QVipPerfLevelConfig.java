package com.tencent.mobileqq.config.business.qvip;

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
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localQVipPerfLevelConfig.toString());
      }
      return localQVipPerfLevelConfig;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, "json parse error:" + paramString);
      }
    }
  }
  
  public String toString()
  {
    return "QVipPerfLevelConfig{use_apm=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipPerfLevelConfig
 * JD-Core Version:    0.7.0.1
 */