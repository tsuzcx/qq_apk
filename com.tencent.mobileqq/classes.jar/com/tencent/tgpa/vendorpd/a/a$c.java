package com.tencent.tgpa.vendorpd.a;

import org.json.JSONException;
import org.json.JSONObject;

class a$c
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("index")) {
      return false;
    }
    if (!paramJSONObject.has("action")) {
      return false;
    }
    if (!paramJSONObject.has("offset")) {
      return false;
    }
    if (!paramJSONObject.has("size")) {
      return false;
    }
    if (!paramJSONObject.has("content")) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_Int = paramJSONObject.getInt("index");
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("action");
      this.jdField_a_of_type_Long = paramJSONObject.getLong("offset");
      this.jdField_b_of_type_Int = paramJSONObject.getInt("size");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("content");
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.a.c
 * JD-Core Version:    0.7.0.1
 */