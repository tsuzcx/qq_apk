package com.tencent.mobileqq.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DeepCleanConfigProcessor$DeepCleanConfigBean
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static DeepCleanConfigBean a(String paramString)
  {
    DeepCleanConfigBean localDeepCleanConfigBean = new DeepCleanConfigBean();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("deep_clean_switch")) {
        localDeepCleanConfigBean.jdField_a_of_type_Int = localJSONObject.optInt("deep_clean_switch");
      }
      if (localJSONObject.has("already_installed_tip")) {
        localDeepCleanConfigBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("already_installed_tip");
      }
      if (localJSONObject.has("first_not_installed_tip")) {
        localDeepCleanConfigBean.b = localJSONObject.optString("first_not_installed_tip");
      }
      if (localJSONObject.has("second_not_installed_tip")) {
        localDeepCleanConfigBean.c = localJSONObject.optString("second_not_installed_tip");
      }
      if (localJSONObject.has("third_not_installed_tip")) {
        localDeepCleanConfigBean.d = localJSONObject.optString("third_not_installed_tip");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeepCleanConfigProcessor", 2, "parse DeepCleanConfigBean: " + paramString);
    }
    return localDeepCleanConfigBean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.DeepCleanConfigProcessor.DeepCleanConfigBean
 * JD-Core Version:    0.7.0.1
 */