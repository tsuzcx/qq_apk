package com.tencent.mobileqq.vaswebviewplugin;

import org.json.JSONException;
import org.json.JSONObject;

public class EmojiJsPlugin$JSONWrapper
{
  JSONObject json;
  
  public EmojiJsPlugin$JSONWrapper(JSONObject paramJSONObject)
  {
    this.json = paramJSONObject;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = this.json;
    if ((localJSONObject != null) && (!localJSONObject.isNull(paramString))) {
      try
      {
        boolean bool = this.json.getBoolean(paramString);
        return bool;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return paramBoolean;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    JSONObject localJSONObject = this.json;
    if ((localJSONObject != null) && (!localJSONObject.isNull(paramString))) {
      try
      {
        int i = this.json.getInt(paramString);
        return i;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return paramInt;
  }
  
  public String getString(String paramString)
  {
    JSONObject localJSONObject = this.json;
    if ((localJSONObject != null) && (!localJSONObject.isNull(paramString))) {
      try
      {
        paramString = this.json.getString(paramString);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.JSONWrapper
 * JD-Core Version:    0.7.0.1
 */