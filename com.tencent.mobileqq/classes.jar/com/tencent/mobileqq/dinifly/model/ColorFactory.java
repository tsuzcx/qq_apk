package com.tencent.mobileqq.dinifly.model;

import android.graphics.Color;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue.Factory;
import org.json.JSONArray;

public class ColorFactory
  implements AnimatableValue.Factory<Integer>
{
  public static final ColorFactory INSTANCE = new ColorFactory();
  
  public Integer valueFromObject(Object paramObject, float paramFloat)
  {
    paramObject = (JSONArray)paramObject;
    if (paramObject.length() == 4)
    {
      int j = 1;
      int i = 0;
      while (i < paramObject.length())
      {
        if (paramObject.optDouble(i) > 1.0D) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0) {}
      for (paramFloat = 255.0F;; paramFloat = 1.0F) {
        return Integer.valueOf(Color.argb((int)(paramObject.optDouble(3) * paramFloat), (int)(paramObject.optDouble(0) * paramFloat), (int)(paramObject.optDouble(1) * paramFloat), (int)(paramObject.optDouble(2) * paramFloat)));
      }
    }
    return Integer.valueOf(-16777216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.ColorFactory
 * JD-Core Version:    0.7.0.1
 */