package com.tencent.ttpic.model;

public class GenderRange
{
  public float max = 10.0F;
  public float min = -10.0F;
  public float value = -2.0F;
  
  public void clearStatus()
  {
    this.value = -2.0F;
  }
  
  public boolean isHit()
  {
    float f1 = this.min;
    float f2 = this.value;
    return (f1 <= f2) && (f2 < this.max);
  }
  
  public void setValue(float paramFloat)
  {
    float f = this.value;
    if (f >= 0.0F) {
      paramFloat = f;
    }
    this.value = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.GenderRange
 * JD-Core Version:    0.7.0.1
 */