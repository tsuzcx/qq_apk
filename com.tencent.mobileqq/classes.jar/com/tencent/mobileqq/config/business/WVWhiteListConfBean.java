package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class WVWhiteListConfBean
{
  public String a = "";
  public String b = "";
  public String c = "";
  public int d = 0;
  public String e = "";
  public int f = -1;
  public String g = "";
  public String h = "";
  
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
        localWVWhiteListConfBean.a = ((JSONArray)localObject).toString();
      }
      localObject = paramString.optJSONObject("jumpLimit");
      if (localObject != null) {
        localWVWhiteListConfBean.b = ((JSONObject)localObject).toString();
      }
      localObject = paramString.optJSONArray("whiteListv2");
      if (localObject != null) {
        localWVWhiteListConfBean.c = ((JSONArray)localObject).toString();
      }
      int i = paramString.optInt("aio_pre_safecheck", -1);
      if (i != -1) {
        localWVWhiteListConfBean.d = i;
      }
      localObject = paramString.optJSONArray("kbWhiteList");
      if (localObject != null) {
        localWVWhiteListConfBean.e = ((JSONArray)localObject).toString();
      }
      i = paramString.optInt("force_https_enable", -1);
      if (i != -1) {
        localWVWhiteListConfBean.f = i;
      }
      localObject = paramString.optJSONArray("force_https_whitelist");
      if (localObject != null) {
        localWVWhiteListConfBean.g = ((JSONArray)localObject).toString();
      }
      paramString = paramString.optJSONArray("force_https_blacklist");
      if (paramString != null) {
        localWVWhiteListConfBean.h = paramString.toString();
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(" limit:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" whiteListV2:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" aioPreCheckSwitch:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" kbWhiteList:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" forceHttpsEnable:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" forceHttpsWhitelist:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" forceHttpsBlacklist:");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVWhiteListConfBean
 * JD-Core Version:    0.7.0.1
 */