package com.tencent.ttpic.openapi.model;

public class NumberRollItem
{
  public float bottom = 0.0F;
  public float continueTime = 0.0F;
  public float currentPosition = 0.0F;
  public float left = 0.0F;
  public float maxSpeed = 0.0F;
  public float right = 0.0F;
  public float speedUpTime = 0.0F;
  public float stopTime = 0.0F;
  public int targetNumber = 0;
  public float top = 0.0F;
  
  public void calculateCurrentPosition(float paramFloat)
  {
    float f1 = this.speedUpTime;
    if (paramFloat < f1)
    {
      this.currentPosition = (this.maxSpeed * paramFloat * paramFloat / f1 * 0.5F);
    }
    else
    {
      float f3 = this.continueTime;
      float f2;
      if (paramFloat < f1 + f3)
      {
        f2 = this.maxSpeed;
        this.currentPosition = (f1 * f2 * 0.5F + (paramFloat - f1) * f2);
      }
      else
      {
        float f4 = this.maxSpeed;
        f2 = f4 * this.stopTime * 0.5F;
        f1 = f1 * f4 * 0.5F + f3 * f4 + f2;
        f1 -= (int)f1;
        f3 = this.targetNumber / 10.0F;
        if (f3 >= f1) {
          f1 = f3 - f1;
        } else {
          f1 = f3 - f1 + 1.0F;
        }
        f3 = this.maxSpeed;
        f2 = (f2 + f1) * 2.0F / f3;
        f1 = this.stopTime;
        f2 -= f1;
        f4 = f1 - f2;
        float f5 = this.speedUpTime;
        float f6 = this.continueTime;
        if (paramFloat < f5 + f6 + f2)
        {
          this.currentPosition = (f5 * f3 * 0.5F + f6 * f3 + (paramFloat - f5 - f6) * f3);
        }
        else if (paramFloat < f5 + f6 + f1)
        {
          paramFloat = paramFloat - f5 - f6 - f2;
          this.currentPosition = (f5 * f3 * 0.5F + f6 * f3 + f2 * f3 + (f3 + (f4 - paramFloat) / f4 * f3) * paramFloat * 0.5F);
        }
        else
        {
          this.currentPosition = (f5 * f3 * 0.5F + f6 * f3 + f2 * f3 + f4 * f3 * 0.5F);
        }
      }
    }
    paramFloat = this.currentPosition;
    this.currentPosition = (paramFloat - (int)paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.NumberRollItem
 * JD-Core Version:    0.7.0.1
 */