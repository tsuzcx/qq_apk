package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import cooperation.qzone.util.QZLog;

public class UnderlineTextView
  extends TextView
{
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  
  public UnderlineTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public UnderlineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UnderlineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.UnderlineTextView, paramInt, 0);
    paramInt = paramContext.getColor(0, -65536);
    this.jdField_a_of_type_Float = paramContext.getDimension(1, f * 2.0F);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getLineCount();
    Object localObject = getLayout();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          int k = getLineBounds(i, this.jdField_a_of_type_AndroidGraphicsRect);
          int m = ((Layout)localObject).getLineStart(i);
          int n = ((Layout)localObject).getLineEnd(i);
          float f1 = ((Layout)localObject).getPrimaryHorizontal(m);
          float f2 = ((Layout)localObject).getPrimaryHorizontal(m + 1);
          float f3 = ((Layout)localObject).getPrimaryHorizontal(n - 1);
          float f4 = getPaddingLeft();
          float f5 = k;
          paramCanvas.drawLine(f1 + f4, this.jdField_a_of_type_Float + f5 + 15.0F, f3 + (f2 - f1) + getPaddingLeft(), f5 + this.jdField_a_of_type_Float + 15.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
          i += 1;
        }
        catch (Exception paramCanvas)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramCanvas);
          QZLog.e("UnderlineTextView", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void setUnderLineColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setUnderlineWidth(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UnderlineTextView
 * JD-Core Version:    0.7.0.1
 */