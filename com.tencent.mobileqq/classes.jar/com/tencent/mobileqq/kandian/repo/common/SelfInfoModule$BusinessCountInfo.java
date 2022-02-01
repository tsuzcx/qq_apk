package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SelfInfoModule$BusinessCountInfo
{
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  public int f;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("businessId", this.a);
      localJSONObject.put("businessType", this.b);
      localJSONObject.put("businessName", this.c);
      localJSONObject.put("jumpUrl", this.d);
      localJSONObject.put("businessIconUrl", this.e);
      localJSONObject.put("fansCount", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toJson error. ");
      localStringBuilder.append(localJSONException);
      QLog.e("SelfInfoModule", 1, localStringBuilder.toString());
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.SelfInfoModule.BusinessCountInfo
 * JD-Core Version:    0.7.0.1
 */