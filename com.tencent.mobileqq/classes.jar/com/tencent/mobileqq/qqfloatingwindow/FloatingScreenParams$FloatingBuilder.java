package com.tencent.mobileqq.qqfloatingwindow;

public class FloatingScreenParams$FloatingBuilder
{
  private static final int INVALID_FLOATING_XY = -2147483648;
  private boolean canMove = true;
  private boolean canZoom = true;
  private int customHeight;
  private int customWidth;
  private int floatingCenterX = -2147483648;
  private int floatingCenterY = -2147483648;
  private float ratio = 0.5625F;
  private int shapeType;
  
  public FloatingScreenParams build()
  {
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams(null);
    localFloatingScreenParams.setScreenRatio(this.ratio);
    localFloatingScreenParams.setCustomSize(this.customWidth, this.customHeight);
    localFloatingScreenParams.setShapeType(this.shapeType);
    FloatingScreenParams.access$100(localFloatingScreenParams, this.canMove);
    FloatingScreenParams.access$200(localFloatingScreenParams, this.canZoom);
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
  
  public FloatingBuilder setCanZoom(boolean paramBoolean)
  {
    this.canZoom = paramBoolean;
    return this;
  }
  
  public FloatingBuilder setCustomSize(int paramInt1, int paramInt2)
  {
    this.customWidth = paramInt1;
    this.customHeight = paramInt2;
    return this;
  }
  
  public FloatingBuilder setFloatingCenter(int paramInt1, int paramInt2)
  {
    this.floatingCenterX = paramInt1;
    this.floatingCenterY = paramInt2;
    return this;
  }
  
  @Deprecated
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
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder
 * JD-Core Version:    0.7.0.1
 */