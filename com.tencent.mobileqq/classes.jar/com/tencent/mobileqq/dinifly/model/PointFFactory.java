package com.tencent.mobileqq.dinifly.model;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue.Factory;
import com.tencent.mobileqq.dinifly.utils.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class PointFFactory
  implements AnimatableValue.Factory<PointF>
{
  public static final PointFFactory INSTANCE = new PointFFactory();
  
  public PointF valueFromObject(Object paramObject, float paramFloat)
  {
    if ((paramObject instanceof JSONArray)) {
      return JsonUtils.pointFromJsonArray((JSONArray)paramObject, paramFloat);
    }
    if ((paramObject instanceof JSONObject)) {
      return JsonUtils.pointFromJsonObject((JSONObject)paramObject, paramFloat);
    }
    throw new IllegalArgumentException("Unable to parse point from " + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.PointFFactory
 * JD-Core Version:    0.7.0.1
 */