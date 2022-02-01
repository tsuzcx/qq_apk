package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class XFrameLayout
  extends FrameLayout
{
  public static final int MODE_ALL = 1;
  public static final int MODE_BOTTOM = 5;
  public static final int MODE_LEFT = 2;
  public static final int MODE_NONE = 0;
  public static final int MODE_RIGHT = 4;
  public static final int MODE_TOP = 3;
  private int mLastRadius;
  private int mLastRoundMode;
  private int mMaxHeight = -1;
  private int mRadius;
  private int mRoundMode = 0;
  private Path mRoundPath = new Path();
  
  public XFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public XFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mRoundPath.setFillType(Path.FillType.EVEN_ODD);
  }
  
  private void checkPathChanged()
  {
    if ((this.mLastRadius == this.mRadius) && (this.mLastRoundMode == this.mRoundMode)) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.mLastRadius = this.mRadius;
    this.mRoundPath.reset();
    int k = this.mRoundMode;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            if (k != 5) {
              return;
            }
            localPath = this.mRoundPath;
            localRectF = new RectF(0.0F, 0.0F, i, j);
            i = this.mRadius;
            f1 = i;
            f2 = i;
            f3 = i;
            f4 = i;
            localDirection = Path.Direction.CW;
            localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f2, f3, f4 }, localDirection);
            return;
          }
          localPath = this.mRoundPath;
          localRectF = new RectF(0.0F, 0.0F, i, j);
          i = this.mRadius;
          f1 = i;
          f2 = i;
          f3 = i;
          f4 = i;
          localDirection = Path.Direction.CW;
          localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, f1, f2, f3, f4, 0.0F, 0.0F }, localDirection);
          return;
        }
        localPath = this.mRoundPath;
        localRectF = new RectF(0.0F, 0.0F, i, j);
        i = this.mRadius;
        f1 = i;
        f2 = i;
        f3 = i;
        f4 = i;
        localDirection = Path.Direction.CW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
        return;
      }
      localPath = this.mRoundPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      i = this.mRadius;
      float f1 = i;
      float f2 = i;
      float f3 = i;
      float f4 = i;
      Path.Direction localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, f4 }, localDirection);
      return;
    }
    Path localPath = this.mRoundPath;
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    i = this.mRadius;
    localPath.addRoundRect(localRectF, i, i, Path.Direction.CW);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.mRoundMode != 0) && (Build.VERSION.SDK_INT >= 21))
    {
      int i = paramCanvas.save();
      checkPathChanged();
      paramCanvas.clipPath(this.mRoundPath);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mMaxHeight > 0)
    {
      int j = View.MeasureSpec.getMode(paramInt2);
      int k = View.MeasureSpec.getSize(paramInt2);
      int m = this.mMaxHeight;
      i = paramInt2;
      if (k > m)
      {
        i = paramInt2;
        if (j != 0) {
          i = View.MeasureSpec.makeMeasureSpec(m, j);
        }
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void setCornerRadiusAndMode(int paramInt1, int paramInt2)
  {
    this.mRadius = paramInt1;
    this.mRoundMode = paramInt2;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
    if (this.mMaxHeight < getMeasuredHeight()) {
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XFrameLayout
 * JD-Core Version:    0.7.0.1
 */