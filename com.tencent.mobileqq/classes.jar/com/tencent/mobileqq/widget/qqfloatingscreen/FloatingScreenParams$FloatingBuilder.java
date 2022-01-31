package com.tencent.mobileqq.widget.qqfloatingscreen;

public class FloatingScreenParams$FloatingBuilder
{
  private static final int INVALID_FLOATING_XY = -2147483648;
  private boolean canMove = true;
  private int floatingCenterX = -2147483648;
  private int floatingCenterY = -2147483648;
  private float ratio = 0.5625F;
  private int shapeType;
  
  public FloatingScreenParams build()
  {
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams(null);
    localFloatingScreenParams.setScreenRatio(this.ratio);
    localFloatingScreenParams.setShapeType(this.shapeType);
    FloatingScreenParams.access$100(localFloatingScreenParams, this.canMove);
    if (this.floatingCenterX != -2147483648) {
      localFloatingScreenParams.setFloatingCenterX(this.floatingCenterX);
    }
    if (this.floatingCenterY != -2147483648) {
      localFloatingScreenParams.setFloatingCenterY(this.floatingCenterY);
    }
    return localFloatingScreenParams;
  }
  
  public FloatingBuilder setCanMove(boolean paramBoolean)
  {
    this.canMove = paramBoolean;
    return this;
  }
  
  public FloatingBuilder setFloatingCenterX(int paramInt)
  {
    this.floatingCenterX = paramInt;
    return this;
  }
  
  public FloatingBuilder setFloatingCenterY(int paramInt)
  {
    this.floatingCenterY = paramInt;
    return this;
  }
  
  public FloatingBuilder setIsHorizontal(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2) {
      return setShapeType(i);
    }
  }
  
  public FloatingBuilder setRatio(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.ratio = paramFloat;
      return this;
    }
    this.ratio = 0.5625F;
    return this;
  }
  
  public FloatingBuilder setShapeType(int paramInt)
  {
    this.shapeType = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder
 * JD-Core Version:    0.7.0.1
 */