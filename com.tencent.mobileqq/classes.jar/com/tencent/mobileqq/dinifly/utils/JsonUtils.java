package com.tencent.mobileqq.dinifly.utils;

import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils
{
  public static PointF pointFromJsonArray(JSONArray paramJSONArray, float paramFloat)
  {
    if (paramJSONArray.length() < 2) {
      throw new IllegalArgumentException("Unable to parse point for " + paramJSONArray);
    }
    return new PointF((float)paramJSONArray.optDouble(0, 1.0D) * paramFloat, (float)paramJSONArray.optDouble(1, 1.0D) * paramFloat);
  }
  
  public static PointF pointFromJsonObject(JSONObject paramJSONObject, float paramFloat)
  {
    return new PointF(valueFromObject(paramJSONObject.opt("x")) * paramFloat, valueFromObject(paramJSONObject.opt("y")) * paramFloat);
  }
  
  public static float valueFromObject(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return ((Float)paramObject).floatValue();
    }
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    if ((paramObject instanceof Double)) {
      return (float)((Double)paramObject).doubleValue();
    }
    if ((paramObject instanceof JSONArray)) {
      return (float)((JSONArray)paramObject).optDouble(0);
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.JsonUtils
 * JD-Core Version:    0.7.0.1
 */