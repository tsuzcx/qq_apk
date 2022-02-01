package com.tencent.mobileqq.troop.troopapps.api;

import org.json.JSONException;
import org.json.JSONObject;

public class ITroopAppService$AppConfig
{
  public static AppConfig[] b = { new AppConfig("BulkChatMessageConfig") };
  public String a;
  
  public ITroopAppService$AppConfig(String paramString)
  {
    this.a = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.ITroopAppService.AppConfig
 * JD-Core Version:    0.7.0.1
 */