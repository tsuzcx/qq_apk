package com.tencent.viola.ui.dom.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

public abstract class BorderCorner
{
  static final float SWEEP_ANGLE = 45.0F;
  private boolean hasInnerCorner = false;
  private boolean hasOuterCorner = false;
  protected float mAngleBisector;
  private RectF mBorderBox;
  private float mCornerRadius = 0.0F;
  private float mOvalBottom;
  private float mOvalLeft;
  private float mOvalRight;
  private float mOvalTop;
  private float mPostBorderWidth = 0.0F;
  private float mPreBorderWidth = 0.0F;
  private float mRoundCornerEndX;
  private float mRoundCornerEndY;
  private float mRoundCornerStartX;
  private float mRoundCornerStartY;
  
  public final void drawRoundedCorner(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint, float paramFloat)
  {
    if (hasOuterCorner())
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramCanvas.drawArc(this.mOvalLeft, this.mOvalTop, this.mOvalRight, this.mOvalBottom, paramFloat, 45.0F, false, paramPaint);
        return;
      }
      paramCanvas.drawArc(new RectF(this.mOvalLeft, this.mOvalTop, this.mOvalRight, this.mOvalBottom), paramFloat, 45.0F, false, paramPaint);
      return;
    }
    paramCanvas.drawLine(getRoundCornerStartX(), getRoundCornerStartY(), getRoundCornerEndX(), getRoundCornerEndY(), paramPaint);
  }
  
  protected final float getAngleBisectorDegree()
  {
    return this.mAngleBisector;
  }
  
  protected final RectF getBorderBox()
  {
    return this.mBorderBox;
  }
  
  protected final float getOuterCornerRadius()
  {
    return this.mCornerRadius;
  }
  
  protected final float getPostBorderWidth()
  {
    return this.mPostBorderWidth;
  }
  
  protected final float getPreBorderWidth()
  {
    return this.mPreBorderWidth;
  }
  
  public final float getRoundCornerEndX()
  {
    return this.mRoundCornerEndX;
  }
  
  public final float getRoundCornerEndY()
  {
    return this.mRoundCornerEndY;
  }
  
  public final float getRoundCornerStartX()
  {
    return this.mRoundCornerStartX;
  }
  
  public final float getRoundCornerStartY()
  {
    return this.mRoundCornerStartY;
  }
  
  boolean hasInnerCorner()
  {
    return this.hasInnerCorner;
  }
  
  boolean hasOuterCorner()
  {
    return this.hasOuterCorner;
  }
  
  protected abstract void prepareOval();
  
  protected abstract void prepareRoundCorner();
  
  final void set(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull RectF paramRectF, float paramFloat4)
  {
    boolean bool2 = true;
    int i;
    if ((!FloatUtils.floatsEqual(this.mCornerRadius, paramFloat1)) || (!FloatUtils.floatsEqual(this.mPreBorderWidth, paramFloat2)) || (!FloatUtils.floatsEqual(this.mPostBorderWidth, paramFloat3)) || (!FloatUtils.floatsEqual(this.mAngleBisector, paramFloat4)) || ((this.mBorderBox != null) && (this.mBorderBox.equals(paramRectF))))
    {
      i = 1;
      if (i != 0)
      {
        this.mCornerRadius = paramFloat1;
        this.mPreBorderWidth = paramFloat2;
        this.mPostBorderWidth = paramFloat3;
        this.mBorderBox = paramRectF;
        this.mAngleBisector = paramFloat4;
        if ((this.mCornerRadius <= 0.0F) || (FloatUtils.floatsEqual(0.0F, this.mCornerRadius))) {
          break label212;
        }
        bool1 = true;
        label125:
        this.hasOuterCorner = bool1;
        if ((!this.hasOuterCorner) || (getPreBorderWidth() < 0.0F) || (getPostBorderWidth() < 0.0F) || (getOuterCornerRadius() <= getPreBorderWidth()) || (getOuterCornerRadius() <= getPostBorderWidth())) {
          break label218;
        }
      }
    }
    label212:
    label218:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hasInnerCorner = bool1;
      if (this.hasOuterCorner) {
        prepareOval();
      }
      prepareRoundCorner();
      return;
      i = 0;
      break;
      bool1 = false;
      break label125;
    }
  }
  
  final void setOvalBottom(float paramFloat)
  {
    this.mOvalBottom = paramFloat;
  }
  
  final void setOvalLeft(float paramFloat)
  {
    this.mOvalLeft = paramFloat;
  }
  
  final void setOvalRight(float paramFloat)
  {
    this.mOvalRight = paramFloat;
  }
  
  final void setOvalTop(float paramFloat)
  {
    this.mOvalTop = paramFloat;
  }
  
  final void setRoundCornerEndX(float paramFloat)
  {
    this.mRoundCornerEndX = paramFloat;
  }
  
  final void setRoundCornerEndY(float paramFloat)
  {
    this.mRoundCornerEndY = paramFloat;
  }
  
  final void setRoundCornerStartX(float paramFloat)
  {
    this.mRoundCornerStartX = paramFloat;
  }
  
  final void setRoundCornerStartY(float paramFloat)
  {
    this.mRoundCornerStartY = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.BorderCorner
 * JD-Core Version:    0.7.0.1
 */