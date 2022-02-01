package com.tencent.mobileqq.flashshow.api.hybird;

import org.json.JSONObject;

public class FSJsPlugin$SafeJsonObject
  extends JSONObject
{
  public FSJsPlugin$SafeJsonObject(FSJsPlugin paramFSJsPlugin, String paramString)
  {
    super(paramString);
  }
  
  public int getInt(String paramString)
  {
    if (!has(paramString)) {
      return 0;
    }
    return super.getInt(paramString);
  }
  
  public String getString(String paramString)
  {
    if (!has(paramString)) {
      return "";
    }
    return super.getString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.hybird.FSJsPlugin.SafeJsonObject
 * JD-Core Version:    0.7.0.1
 */