package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SelfInfoModule$BusinessCountInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("businessId", this.jdField_a_of_type_Int);
      localJSONObject.put("businessType", this.jdField_b_of_type_Int);
      localJSONObject.put("businessName", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("jumpUrl", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("businessIconUrl", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("fansCount", this.jdField_c_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.SelfInfoModule.BusinessCountInfo
 * JD-Core Version:    0.7.0.1
 */