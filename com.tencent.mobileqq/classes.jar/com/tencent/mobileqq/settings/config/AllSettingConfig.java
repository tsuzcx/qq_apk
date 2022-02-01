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
    int i = 0;
    QLog.d("AllSettingConfig", 1, "parse, newConf = " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      int j = new JSONObject(paramString).optInt("useNewMode", 0);
      i = j;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
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
    return "TroopNotificationEntryConfig{useNewMode = " + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.config.AllSettingConfig
 * JD-Core Version:    0.7.0.1
 */