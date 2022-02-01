package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import org.json.JSONException;
import org.json.JSONObject;

public class TextInfo
  extends EditItemInfoBase
{
  public String a;
  public int b;
  public boolean c = false;
  public boolean d = false;
  
  public TextInfo(String paramString)
  {
    this.a = paramString;
    this.h = new JSONObject();
    try
    {
      this.h.put("type", "str");
      this.h.put("text", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public TextInfo(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public int a()
  {
    return this.a.length();
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
    try
    {
      this.h.put("text", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.h = paramJSONObject;
    this.a = paramJSONObject.optString("text");
    this.b = this.a.length();
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo
 * JD-Core Version:    0.7.0.1
 */