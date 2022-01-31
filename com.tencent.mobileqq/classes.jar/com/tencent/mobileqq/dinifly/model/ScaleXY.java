package com.tencent.mobileqq.dinifly.model;

import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue.Factory;
import org.json.JSONArray;

public class ScaleXY
{
  private final float scaleX;
  private final float scaleY;
  
  public ScaleXY()
  {
    this(1.0F, 1.0F);
  }
  
  public ScaleXY(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
  }
  
  public float getScaleX()
  {
    return this.scaleX;
  }
  
  public float getScaleY()
  {
    return this.scaleY;
  }
  
  public String toString()
  {
    return getScaleX() + "x" + getScaleY();
  }
  
  public static class Factory
    implements AnimatableValue.Factory<ScaleXY>
  {
    public static final Factory INSTANCE = new Factory();
    
    public ScaleXY valueFromObject(Object paramObject, float paramFloat)
    {
      paramObject = (JSONArray)paramObject;
      return new ScaleXY((float)paramObject.optDouble(0, 1.0D) / 100.0F * paramFloat, (float)paramObject.optDouble(1, 1.0D) / 100.0F * paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.ScaleXY
 * JD-Core Version:    0.7.0.1
 */