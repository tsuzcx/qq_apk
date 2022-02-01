package com.tencent.qqmini.sdk.launcher.model;

import org.json.JSONException;
import org.json.JSONObject;

public class TouchInfo
{
  private long duration;
  private int endX;
  private int endY;
  private int startX;
  private int startY;
  
  public TouchInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.startX = paramInt1;
    this.startY = paramInt2;
    this.endX = paramInt3;
    this.endY = paramInt4;
    this.duration = paramLong;
  }
  
  public String toJsonStr()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tsx", this.startX);
      localJSONObject.put("tsy", this.startY);
      localJSONObject.put("tex", this.endX);
      localJSONObject.put("tey", this.endY);
      localJSONObject.put("td", this.duration);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.TouchInfo
 * JD-Core Version:    0.7.0.1
 */