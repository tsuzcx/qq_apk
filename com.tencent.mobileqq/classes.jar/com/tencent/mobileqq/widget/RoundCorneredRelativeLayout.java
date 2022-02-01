package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class RoundCorneredRelativeLayout
  extends RelativeLayout
{
  private static final float PRESS_ALPHA = 0.5F;
  private boolean mEnablePressEffect = false;
  private Paint mPaint = new Paint();
  private float[] mRadii = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  @TargetApi(11)
  public RoundCorneredRelativeLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  @TargetApi(11)
  public RoundCorneredRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    Path localPath1 = new Path();
    localPath1.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom()), this.mRadii, Path.Direction.CW);
    float f1 = i;
    float f2 = j;
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, f1, f2), null, 31);
    super.dispatchDraw(paramCanvas);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawPath(localPath1, this.mPaint);
    }
    else
    {
      this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      Path localPath2 = new Path();
      localPath2.addRect(0.0F, 0.0F, f1, f2, Path.Direction.CW);
      localPath2.op(localPath1, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(localPath2, this.mPaint);
    }
    paramCanvas.restore();
  }
  
  public void enablePressEffect(boolean paramBoolean)
  {
    this.mEnablePressEffect = paramBoolean;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mEnablePressEffect) && (isClickable()) && (isEnabled()))
    {
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2) {
            if (i != 3) {
              break label65;
            }
          }
        }
        else
        {
          setAlpha(1.0F);
          break label65;
        }
      }
      setAlpha(0.5F);
      label65:
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setRadius(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mRadii = new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundCorneredRelativeLayout
 * JD-Core Version:    0.7.0.1
 */