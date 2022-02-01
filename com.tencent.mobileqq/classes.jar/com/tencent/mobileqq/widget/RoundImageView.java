package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class RoundImageView
  extends ImageView
{
  private static final String TAG = "RoundImageView";
  float mRadius = 0.0F;
  RectF mTempRectF = new RectF();
  Path path = new Path();
  boolean qwNoBottomRadius = false;
  boolean qwNoRightRadius = false;
  Rect rect1 = new Rect();
  Rect rect2 = new Rect();
  
  public RoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAttrs(paramContext, paramAttributeSet, paramInt);
  }
  
  private void clipPathSafe(Canvas paramCanvas)
  {
    try
    {
      paramCanvas.clipPath(this.path);
      return;
    }
    catch (Exception paramCanvas)
    {
      QLog.e("RoundImageView", 1, "clipPathSafe exception", paramCanvas);
    }
  }
  
  private void initAttrs(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QwRoundView, paramInt, 0);
    try
    {
      this.mRadius = ((int)paramContext.getDimension(1, 0.0F));
      this.qwNoBottomRadius = paramContext.getBoolean(0, false);
      return;
    }
    catch (Exception paramAttributeSet)
    {
      QLog.e("RoundImageView", 1, "initAttrs exception", paramAttributeSet);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    for (;;)
    {
      try
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if (this.mRadius <= 0.0F) {
          break label241;
        }
        if (this.qwNoRightRadius)
        {
          this.mTempRectF.set(0.0F, 0.0F, i + this.mRadius, j);
          this.path.addRoundRect(this.mTempRectF, this.mRadius, this.mRadius, Path.Direction.CW);
          clipPathSafe(paramCanvas);
          localObject = getDrawable();
          if (localObject == null) {
            break label241;
          }
          if ((localObject instanceof SkinnableBitmapDrawable))
          {
            localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
            if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
              break label241;
            }
            this.rect1.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            this.rect2.set(0, 0, i, j);
            paramCanvas.drawBitmap((Bitmap)localObject, this.rect1, this.rect2, null);
          }
        }
        else
        {
          localObject = this.mTempRectF;
          float f2 = i;
          float f3 = j;
          if (this.qwNoBottomRadius) {
            f1 = this.mRadius;
          }
          ((RectF)localObject).set(0.0F, 0.0F, f2, f1 + f3);
          continue;
        }
        if (!(localObject instanceof BitmapDrawable)) {
          break label247;
        }
      }
      catch (Exception paramCanvas)
      {
        QLog.e("RoundImageView", 1, "onDraw exception", paramCanvas);
        return;
      }
      Object localObject = ((BitmapDrawable)localObject).getBitmap();
      continue;
      label241:
      super.onDraw(paramCanvas);
      return;
      label247:
      localObject = null;
    }
  }
  
  public void setRadiusWithoutRight(int paramInt)
  {
    this.mRadius = paramInt;
    this.qwNoRightRadius = true;
  }
  
  public void setmRadius(int paramInt, boolean paramBoolean)
  {
    this.mRadius = paramInt;
    this.qwNoBottomRadius = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundImageView
 * JD-Core Version:    0.7.0.1
 */