package com.tencent.mobileqq.settings.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class AllSettingConfig
{
  private int a = 0;
  
  public static AllSettingConfig a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parse, newConf = ");
    localStringBuilder.append(paramString);
    QLog.d("AllSettingConfig", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = 0;
    try
    {
      int j = new JSONObject(paramString).optInt("useNewMode", 0);
      i = j;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    paramString = new AllSettingConfig();
    paramString.a = i;
    return paramString;
  }
  
  public int a()
  {
    return this.a;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopNotificationEntryConfig{useNewMode = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.config.AllSettingConfig
 * JD-Core Version:    0.7.0.1
 */