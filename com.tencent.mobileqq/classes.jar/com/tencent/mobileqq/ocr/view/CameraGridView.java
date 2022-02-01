package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;

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
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(AIOUtils.a(0.5F, getResources()));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int k = 1;
    super.onDraw(paramCanvas);
    int n = this.c / (this.jdField_a_of_type_Int + 1);
    int m = this.d / (this.b + 1);
    int i = 1;
    int j;
    for (;;)
    {
      j = k;
      if (i > this.jdField_a_of_type_Int) {
        break;
      }
      paramCanvas.drawLine(n * i, 0.0F, n * i, this.d, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
    while (j <= this.b)
    {
      paramCanvas.drawLine(0.0F, m * j, this.c, m * j, this.jdField_a_of_type_AndroidGraphicsPaint);
      j += 1;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = paramInt1;
    this.d = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CameraGridView
 * JD-Core Version:    0.7.0.1
 */