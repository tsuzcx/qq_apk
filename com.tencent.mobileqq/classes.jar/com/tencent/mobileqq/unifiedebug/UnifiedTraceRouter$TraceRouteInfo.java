package com.tencent.mobileqq.unifiedebug;

import org.json.JSONArray;
import org.json.JSONException;

public class UnifiedTraceRouter$TraceRouteInfo
{
  public int a;
  public String b;
  public String c;
  public float d;
  
  public UnifiedTraceRouter$TraceRouteInfo(UnifiedTraceRouter paramUnifiedTraceRouter, String paramString, float paramFloat)
  {
    this.c = paramString;
    this.d = paramFloat;
  }
  
  public JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(this.c);
      localJSONArray.put(this.d);
      return localJSONArray;
    }
    catch (JSONException localJSONException) {}
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter.TraceRouteInfo
 * JD-Core Version:    0.7.0.1
 */