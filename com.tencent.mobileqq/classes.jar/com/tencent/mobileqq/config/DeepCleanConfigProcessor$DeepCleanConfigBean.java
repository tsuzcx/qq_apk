package com.tencent.mobileqq.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DeepCleanConfigProcessor$DeepCleanConfigBean
{
  private int a = 0;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  public static DeepCleanConfigBean a(String paramString)
  {
    DeepCleanConfigBean localDeepCleanConfigBean = new DeepCleanConfigBean();
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("deep_clean_switch")) {
          localDeepCleanConfigBean.a = localJSONObject.optInt("deep_clean_switch");
        }
        if (localJSONObject.has("already_installed_tip")) {
          localDeepCleanConfigBean.b = localJSONObject.optString("already_installed_tip");
        }
        if (localJSONObject.has("first_not_installed_tip")) {
          localDeepCleanConfigBean.c = localJSONObject.optString("first_not_installed_tip");
        }
        if (localJSONObject.has("second_not_installed_tip")) {
          localDeepCleanConfigBean.d = localJSONObject.optString("second_not_installed_tip");
        }
        if (localJSONObject.has("third_not_installed_tip")) {
          localDeepCleanConfigBean.e = localJSONObject.optString("third_not_installed_tip");
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse DeepCleanConfigBean: ");
        localStringBuilder.append(paramString);
        QLog.i("DeepCleanConfigProcessor", 2, localStringBuilder.toString());
      }
    }
    return localDeepCleanConfigBean;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.DeepCleanConfigProcessor.DeepCleanConfigBean
 * JD-Core Version:    0.7.0.1
 */