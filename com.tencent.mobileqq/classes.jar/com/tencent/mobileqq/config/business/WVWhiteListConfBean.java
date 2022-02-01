package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class WVWhiteListConfBean
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public WVWhiteListConfBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
  }
  
  public static WVWhiteListConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      WVWhiteListConfBean localWVWhiteListConfBean = new WVWhiteListConfBean();
      paramString = new JSONObject(paramString);
      Object localObject = paramString.optJSONArray("whiteList");
      if (localObject != null) {
        localWVWhiteListConfBean.jdField_a_of_type_JavaLangString = ((JSONArray)localObject).toString();
      }
      localObject = paramString.optJSONObject("jumpLimit");
      if (localObject != null) {
        localWVWhiteListConfBean.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).toString();
      }
      localObject = paramString.optJSONArray("whiteListv2");
      if (localObject != null) {
        localWVWhiteListConfBean.c = ((JSONArray)localObject).toString();
      }
      int i = paramString.optInt("aio_pre_safecheck", -1);
      if (i != -1) {
        localWVWhiteListConfBean.jdField_a_of_type_Int = i;
      }
      localObject = paramString.optJSONArray("kbWhiteList");
      if (localObject != null) {
        localWVWhiteListConfBean.d = ((JSONArray)localObject).toString();
      }
      i = paramString.optInt("force_https_enable", -1);
      if (i != -1) {
        localWVWhiteListConfBean.jdField_b_of_type_Int = i;
      }
      localObject = paramString.optJSONArray("force_https_whitelist");
      if (localObject != null) {
        localWVWhiteListConfBean.e = ((JSONArray)localObject).toString();
      }
      paramString = paramString.optJSONArray("force_https_blacklist");
      if (paramString != null) {
        localWVWhiteListConfBean.f = paramString.toString();
      }
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localWVWhiteListConfBean.toString());
      QLog.d("ConfBean", 2, paramString.toString());
      return localWVWhiteListConfBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("whitelistStr:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" limit:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" whiteListV2:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" aioPreCheckSwitch:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" kbWhiteList:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" forceHttpsEnable:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" forceHttpsWhitelist:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" forceHttpsBlacklist:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVWhiteListConfBean
 * JD-Core Version:    0.7.0.1
 */