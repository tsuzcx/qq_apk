package com.tencent.mobileqq.wink.pick;

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
  private boolean a = false;
  private Paint b = new Paint();
  private float[] c = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  @TargetApi(11)
  public RoundCorneredRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  @TargetApi(11)
  public RoundCorneredRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    Path localPath1 = new Path();
    localPath1.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom()), this.c, Path.Direction.CW);
    float f1 = i;
    float f2 = j;
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, f1, f2), null, 31);
    super.dispatchDraw(paramCanvas);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawPath(localPath1, this.b);
    }
    else
    {
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      Path localPath2 = new Path();
      localPath2.addRect(0.0F, 0.0F, f1, f2, Path.Direction.CW);
      localPath2.op(localPath1, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(localPath2, this.b);
    }
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a) && (isClickable()) && (isEnabled()))
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
    this.c = new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.RoundCorneredRelativeLayout
 * JD-Core Version:    0.7.0.1
 */