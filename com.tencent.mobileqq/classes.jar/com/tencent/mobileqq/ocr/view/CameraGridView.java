package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class CameraGridView
  extends View
{
  private int jdField_a_of_type_Int = 2;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private int b = 2;
  private int c;
  private int d;
  
  public CameraGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CameraGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(DisplayUtil.a(getContext(), 0.5F));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.c;
    int j = this.jdField_a_of_type_Int;
    int k = 1;
    int n = i / (j + 1);
    int m = this.d / (this.b + 1);
    i = 1;
    float f;
    for (;;)
    {
      j = k;
      if (i > this.jdField_a_of_type_Int) {
        break;
      }
      f = n * i;
      paramCanvas.drawLine(f, 0.0F, f, this.d, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
    while (j <= this.b)
    {
      f = m * j;
      paramCanvas.drawLine(0.0F, f, this.c, f, this.jdField_a_of_type_AndroidGraphicsPaint);
      j += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = paramInt1;
    this.d = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CameraGridView
 * JD-Core Version:    0.7.0.1
 */