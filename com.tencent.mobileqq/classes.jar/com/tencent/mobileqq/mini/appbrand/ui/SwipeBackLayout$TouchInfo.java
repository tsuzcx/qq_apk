package com.tencent.mobileqq.mini.appbrand.ui;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class SwipeBackLayout$TouchInfo
{
  private long duration;
  private int endX;
  private int endY;
  private int startX;
  private int startY;
  
  public SwipeBackLayout$TouchInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
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
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startX: ").append(this.startX).append(" startY: ").append(this.startY);
    localStringBuilder.append(" endX: ").append(this.endX).append(" endY: ").append(this.endY);
    localStringBuilder.append(" duration: ").append(this.duration);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.SwipeBackLayout.TouchInfo
 * JD-Core Version:    0.7.0.1
 */