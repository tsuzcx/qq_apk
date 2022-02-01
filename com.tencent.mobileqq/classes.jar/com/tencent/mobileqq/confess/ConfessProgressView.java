package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ConfessProgressView
  extends View
{
  private float jdField_a_of_type_Float = 0.0F;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private float b;
  private float c;
  private float d;
  private float e;
  
  public ConfessProgressView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ConfessProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ConfessProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.argb(255, 252, 228, 80));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt1 >= paramInt2)) {
      this.jdField_a_of_type_Float = 0.0F;
    }
    for (;;)
    {
      invalidate();
      return;
      int i = 80 / (paramInt2 - 1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.argb(255, 252, 228 - i * (paramInt1 - 1), 80));
      float f1 = this.b / 15.0F;
      float f2 = this.b / 5.0F;
      if (paramInt1 == 1) {
        this.jdField_a_of_type_Float = f1;
      } else {
        this.jdField_a_of_type_Float = (f1 + (f2 - f1) / (paramInt2 - 2) * (paramInt1 - 1));
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.b / 2.0F + this.d, this.c / 2.0F * 1.08F + this.e, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setSize(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = paramFloat3;
    this.e = paramFloat4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessProgressView
 * JD-Core Version:    0.7.0.1
 */