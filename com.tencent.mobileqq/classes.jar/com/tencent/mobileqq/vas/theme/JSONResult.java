package com.tencent.mobileqq.vas.theme;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONResult
{
  public int a;
  public String b;
  private JSONObject c;
  
  public JSONResult(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", this.a);
      localJSONObject.put("message", this.b);
      localJSONObject.put("data", this.c);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.JSONResult
 * JD-Core Version:    0.7.0.1
 */