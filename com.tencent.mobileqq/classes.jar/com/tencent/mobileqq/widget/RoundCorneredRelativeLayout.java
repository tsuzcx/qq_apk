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
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
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
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    Path localPath1 = new Path();
    localPath1.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom()), this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, i, j), null, 31);
    super.dispatchDraw(paramCanvas);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawPath(localPath1, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      Path localPath2 = new Path();
      localPath2.addRect(0.0F, 0.0F, i, j, Path.Direction.CW);
      localPath2.op(localPath1, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(localPath2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!isClickable()) || (!isEnabled())) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      setAlpha(0.5F);
      continue;
      setAlpha(1.0F);
    }
  }
  
  public void setRadius(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundCorneredRelativeLayout
 * JD-Core Version:    0.7.0.1
 */