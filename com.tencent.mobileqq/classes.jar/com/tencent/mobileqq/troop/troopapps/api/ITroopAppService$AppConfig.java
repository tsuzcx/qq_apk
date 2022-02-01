package com.tencent.mobileqq.troop.troopapps.api;

import org.json.JSONException;
import org.json.JSONObject;

public class ITroopAppService$AppConfig
{
  public static AppConfig[] a;
  public String a;
  
  static
  {
    jdField_a_of_type_ArrayOfComTencentMobileqqTroopTroopappsApiITroopAppService$AppConfig = new AppConfig[] { new AppConfig("BulkChatMessageConfig") };
  }
  
  public ITroopAppService$AppConfig(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final JSONObject a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (JSONException paramString)
    {
      label12:
      break label12;
    }
    paramString = new JSONObject();
    return a(paramString);
  }
  
  public JSONObject a(JSONObject paramJSONObject)
  {
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.ITroopAppService.AppConfig
 * JD-Core Version:    0.7.0.1
 */