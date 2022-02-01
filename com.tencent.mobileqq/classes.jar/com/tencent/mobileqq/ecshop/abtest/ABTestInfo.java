package com.tencent.mobileqq.ecshop.abtest;

import android.text.TextUtils;
import org.json.JSONObject;

public class ABTestInfo
{
  public String a;
  public JSONObject b;
  public String c;
  public String d;
  public String e;
  
  public static ABTestInfo a(JSONObject paramJSONObject)
  {
    ABTestInfo localABTestInfo = new ABTestInfo();
    localABTestInfo.a = paramJSONObject.optString("sGrayPolicyId");
    localABTestInfo.b = paramJSONObject.optJSONObject("params");
    localABTestInfo.c = paramJSONObject.optString("sGroupKey");
    localABTestInfo.d = paramJSONObject.optString("sStrategyType");
    localABTestInfo.e = paramJSONObject.optString("sExpKey");
    return localABTestInfo;
  }
  
  public String a()
  {
    JSONObject localJSONObject = this.b;
    if (localJSONObject != null) {
      return localJSONObject.toString();
    }
    return "";
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject = this.b;
    if (localObject != null) {
      paramString1 = ((JSONObject)localObject).optString(paramString1);
    } else {
      paramString1 = null;
    }
    localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      localObject = paramString2;
    }
    return localObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ABTestInfo{sGrayPolicyId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", params=");
    localStringBuilder.append(a());
    localStringBuilder.append(", sGroupKey=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", sStrategyType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", sExpKey=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.abtest.ABTestInfo
 * JD-Core Version:    0.7.0.1
 */