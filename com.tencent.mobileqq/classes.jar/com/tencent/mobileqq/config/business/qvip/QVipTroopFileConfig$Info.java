package com.tencent.mobileqq.config.business.qvip;

import org.json.JSONObject;

class QVipTroopFileConfig$Info
{
  String a = "";
  String b = "";
  String c = "";
  
  static Info a(JSONObject paramJSONObject)
  {
    Info localInfo = new Info();
    localInfo.a = paramJSONObject.optString("nonVIP", localInfo.a);
    localInfo.b = paramJSONObject.optString("VIP", localInfo.b);
    localInfo.c = paramJSONObject.optString("SVIP", localInfo.c);
    return localInfo;
  }
  
  String a(String paramString)
  {
    if ("normal".equals(paramString)) {
      return this.a;
    }
    if ("vip".equals(paramString)) {
      return this.b;
    }
    return this.c;
  }
  
  public String toString()
  {
    return "Info{nonVIP='" + this.a + '\'' + ", VIP='" + this.b + '\'' + ", SVIP='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipTroopFileConfig.Info
 * JD-Core Version:    0.7.0.1
 */