package com.tencent.mobileqq.vas.theme;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONResult
{
  public int a;
  public String a;
  private JSONObject a;
  
  public JSONResult(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", this.jdField_a_of_type_Int);
      localJSONObject.put("message", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("data", this.jdField_a_of_type_OrgJsonJSONObject);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.JSONResult
 * JD-Core Version:    0.7.0.1
 */