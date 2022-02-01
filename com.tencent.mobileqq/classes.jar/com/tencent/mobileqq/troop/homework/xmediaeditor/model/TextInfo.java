package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import org.json.JSONException;
import org.json.JSONObject;

public class TextInfo
  extends EditItemInfoBase
{
  public int a;
  public String a;
  public boolean a;
  public boolean c = false;
  
  public TextInfo(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("type", "str");
      this.jdField_a_of_type_OrgJsonJSONObject.put("text", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public TextInfo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = false;
    a(paramJSONObject);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaLangString.length();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("text");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaLangString.length();
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("text", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo
 * JD-Core Version:    0.7.0.1
 */