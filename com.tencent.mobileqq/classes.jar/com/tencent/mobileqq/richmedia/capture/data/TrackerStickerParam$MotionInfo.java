package com.tencent.mobileqq.richmedia.capture.data;

import org.json.JSONObject;

public class TrackerStickerParam$MotionInfo
{
  public float a;
  public long a;
  public boolean a;
  public float b;
  public float c = 1.0F;
  public float d = 0.0F;
  
  public TrackerStickerParam$MotionInfo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("isLost");
      this.jdField_a_of_type_Long = paramJSONObject.getLong("frameTime");
      this.jdField_a_of_type_Float = ((float)paramJSONObject.getDouble("x"));
      this.b = ((float)paramJSONObject.getDouble("y"));
      this.c = ((float)paramJSONObject.getDouble("scale"));
      this.d = ((float)paramJSONObject.getDouble("rotate"));
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public TrackerStickerParam$MotionInfo(boolean paramBoolean, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo
 * JD-Core Version:    0.7.0.1
 */