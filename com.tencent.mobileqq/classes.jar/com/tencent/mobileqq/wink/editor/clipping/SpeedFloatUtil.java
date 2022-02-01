package com.tencent.mobileqq.wink.editor.clipping;

import java.util.HashMap;
import java.util.Map;

public class SpeedFloatUtil
{
  private static final Map<Float, String> a = new HashMap();
  
  static
  {
    a.put(Float.valueOf(0.5F), "0.5");
    a.put(Float.valueOf(0.75F), "0.75");
    a.put(Float.valueOf(1.0F), "1.0");
    a.put(Float.valueOf(1.5F), "1.5");
    a.put(Float.valueOf(2.0F), "2.0");
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.SpeedFloatUtil
 * JD-Core Version:    0.7.0.1
 */