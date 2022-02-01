package com.tencent.mtt.supportui.views.recyclerview;

public class ScrollInterpolator
{
  private float mMinStep = 1.5F;
  private float mPhysicsTimeStep = 0.008333334F;
  private float mSpringDampening = 15.0F;
  private float mSpringTightness = 7.0F;
  private float mVelocity = 2500.0F;
  
  private float Spring(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, float paramFloat3)
  {
    float f2 = paramInt1 - paramInt2;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = -f2;
    }
    return f1 * -paramFloat2 - paramFloat3 * paramFloat1;
  }
  
  public int getStep(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    float f1 = Spring(this.mVelocity, paramInt1, paramInt3, this.mSpringTightness, this.mSpringDampening);
    float f2 = this.mVelocity;
    this.mVelocity = (f1 * this.mPhysicsTimeStep + f2);
    f2 = this.mVelocity / 50.0F;
    f1 = f2;
    if (f2 < this.mMinStep) {
      f1 = this.mMinStep;
    }
    return (int)f1;
  }
  
  public void initVelocity(int paramInt)
  {
    this.mVelocity = (Math.abs(paramInt) * 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.ScrollInterpolator
 * JD-Core Version:    0.7.0.1
 */