package com.tencent.mobileqq.vas.config.business.qvip;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Info{nonVIP='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", VIP='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", SVIP='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig.Info
 * JD-Core Version:    0.7.0.1
 */