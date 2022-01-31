package com.tencent.mobileqq.richmedia.capture.data;

import org.json.JSONObject;

public class TrackerStickerParam$MotionInfo
{
  public long frameTime;
  public boolean isLost = false;
  public float rotate = 0.0F;
  public float scale = 1.0F;
  public float x;
  public float y;
  
  public TrackerStickerParam$MotionInfo(JSONObject paramJSONObject)
  {
    try
    {
      this.isLost = paramJSONObject.getBoolean("isLost");
      this.frameTime = paramJSONObject.getLong("frameTime");
      this.x = ((float)paramJSONObject.getDouble("x"));
      this.y = ((float)paramJSONObject.getDouble("y"));
      this.scale = ((float)paramJSONObject.getDouble("scale"));
      this.rotate = ((float)paramJSONObject.getDouble("rotate"));
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public TrackerStickerParam$MotionInfo(boolean paramBoolean, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.isLost = paramBoolean;
    this.frameTime = paramLong;
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.scale = paramFloat3;
    this.rotate = paramFloat4;
  }
  
  public JSONObject convertToJSON()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isLost", this.isLost);
      localJSONObject.put("frameTime", this.frameTime);
      localJSONObject.put("x", this.x);
      localJSONObject.put("y", this.y);
      localJSONObject.put("scale", this.scale);
      localJSONObject.put("rotate", this.rotate);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo
 * JD-Core Version:    0.7.0.1
 */