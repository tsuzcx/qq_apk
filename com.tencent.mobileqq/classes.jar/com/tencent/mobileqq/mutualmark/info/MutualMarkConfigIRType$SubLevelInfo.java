package com.tencent.mobileqq.mutualmark.info;

import com.tencent.mobileqq.utils.Base64Util;
import org.json.JSONObject;

public class MutualMarkConfigIRType$SubLevelInfo
{
  public String a;
  public String b;
  
  public static SubLevelInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    SubLevelInfo localSubLevelInfo = new SubLevelInfo();
    localSubLevelInfo.a = paramJSONObject.optString("name");
    localSubLevelInfo.b = new String(Base64Util.decode(paramJSONObject.optString("iconUrl"), 0));
    return localSubLevelInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("iconUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType.SubLevelInfo
 * JD-Core Version:    0.7.0.1
 */