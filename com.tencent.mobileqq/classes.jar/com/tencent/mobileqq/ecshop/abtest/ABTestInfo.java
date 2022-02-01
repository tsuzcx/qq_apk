package com.tencent.mobileqq.ecshop.abtest;

import android.text.TextUtils;
import org.json.JSONObject;

public class ABTestInfo
{
  public String a;
  public JSONObject a;
  public String b;
  public String c;
  public String d;
  
  public static ABTestInfo a(JSONObject paramJSONObject)
  {
    ABTestInfo localABTestInfo = new ABTestInfo();
    localABTestInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sGrayPolicyId");
    localABTestInfo.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject.optJSONObject("params");
    localABTestInfo.b = paramJSONObject.optString("sGroupKey");
    localABTestInfo.c = paramJSONObject.optString("sStrategyType");
    localABTestInfo.d = paramJSONObject.optString("sExpKey");
    return localABTestInfo;
  }
  
  public String a()
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localJSONObject != null) {
      return localJSONObject.toString();
    }
    return "";
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
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
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", params=");
    localStringBuilder.append(a());
    localStringBuilder.append(", sGroupKey=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", sStrategyType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", sExpKey=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.abtest.ABTestInfo
 * JD-Core Version:    0.7.0.1
 */