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
    if (paramFloat < this.speedUpTime) {
      this.currentPosition = (this.maxSpeed * paramFloat * paramFloat / this.speedUpTime * 0.5F);
    }
    for (;;)
    {
      this.currentPosition -= (int)this.currentPosition;
      return;
      if (paramFloat < this.speedUpTime + this.continueTime)
      {
        this.currentPosition = (this.speedUpTime * this.maxSpeed * 0.5F + (paramFloat - this.speedUpTime) * this.maxSpeed);
      }
      else
      {
        float f2 = this.speedUpTime;
        float f3 = this.maxSpeed;
        float f4 = this.continueTime;
        float f5 = this.maxSpeed;
        float f1 = this.maxSpeed * this.stopTime * 0.5F;
        f2 = f2 * f3 * 0.5F + f4 * f5 + f1;
        f2 -= (int)f2;
        f3 = this.targetNumber / 10.0F;
        if (f3 >= f2) {}
        for (f1 = f3 - f2 + f1;; f1 = f3 - f2 + 1.0F + f1)
        {
          f1 = f1 * 2.0F / this.maxSpeed - this.stopTime;
          f2 = this.stopTime - f1;
          if (paramFloat >= this.speedUpTime + this.continueTime + f1) {
            break label267;
          }
          this.currentPosition = (this.speedUpTime * this.maxSpeed * 0.5F + this.continueTime * this.maxSpeed + (paramFloat - this.speedUpTime - this.continueTime) * this.maxSpeed);
          break;
        }
        label267:
        if (paramFloat < this.speedUpTime + this.continueTime + this.stopTime)
        {
          paramFloat = paramFloat - this.speedUpTime - this.continueTime - f1;
          f3 = this.speedUpTime;
          f4 = this.maxSpeed;
          f5 = this.continueTime;
          float f6 = this.maxSpeed;
          float f7 = this.maxSpeed;
          float f8 = this.maxSpeed;
          float f9 = this.maxSpeed;
          this.currentPosition = (f1 * f7 + (f3 * f4 * 0.5F + f5 * f6) + ((f2 - paramFloat) / f2 * f9 + f8) * paramFloat * 0.5F);
        }
        else
        {
          paramFloat = this.speedUpTime;
          f3 = this.maxSpeed;
          f4 = this.continueTime;
          f5 = this.maxSpeed;
          this.currentPosition = (f1 * this.maxSpeed + (paramFloat * f3 * 0.5F + f4 * f5) + f2 * this.maxSpeed * 0.5F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.NumberRollItem
 * JD-Core Version:    0.7.0.1
 */