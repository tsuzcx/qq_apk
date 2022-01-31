package com.tencent.mobileqq.dinifly.value;

public class ScaleXY
{
  private float scaleX;
  private float scaleY;
  
  public ScaleXY()
  {
    this(1.0F, 1.0F);
  }
  
  public ScaleXY(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
  }
  
  public boolean equals(float paramFloat1, float paramFloat2)
  {
    return (this.scaleX == paramFloat1) && (this.scaleY == paramFloat2);
  }
  
  public float getScaleX()
  {
    return this.scaleX;
  }
  
  public float getScaleY()
  {
    return this.scaleY;
  }
  
  public void set(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
  }
  
  public String toString()
  {
    return getScaleX() + "x" + getScaleY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.ScaleXY
 * JD-Core Version:    0.7.0.1
 */