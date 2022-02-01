package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import bhtq;

public class PanoramaBallView
  extends View
{
  public static final int a;
  public static final int b = bhtq.b(32.0F);
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int c = jdField_a_of_type_Int;
  private int d = b;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k = 360;
  
  static
  {
    jdField_a_of_type_Int = bhtq.b(32.0F);
  }
  
  public PanoramaBallView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PanoramaBallView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private int a(int paramInt)
  {
    int m = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (m == 1073741824) {}
    for (;;)
    {
      this.c = paramInt;
      return paramInt;
      if (m == -2147483648) {
        paramInt = Math.min(paramInt, this.c);
      } else {
        paramInt = this.c;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.e = paramContext.getResources().getColor(2131165356);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.c / 2, this.c / 2, this.c / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private int b(int paramInt)
  {
    int m = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (m == 1073741824) {}
    for (;;)
    {
      this.d = paramInt;
      return paramInt;
      if (m == -2147483648) {
        paramInt = Math.min(paramInt, this.d);
      } else {
        paramInt = this.d;
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    paramCanvas.drawArc(new RectF(this.f - this.g, this.f - this.g, this.f + this.g, this.f + this.g), -90 - this.k / 2, this.k, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    Path localPath = new Path();
    int m = (this.f - this.g) / 2;
    int n = m / 2;
    localPath.moveTo(this.f, this.f - this.g - m);
    localPath.lineTo(this.f - n, this.f - this.g);
    localPath.lineTo(this.f + n, this.f - this.g);
    localPath.close();
    paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void c(Canvas paramCanvas)
  {
    int m = (this.f - this.g) / 2;
    RectF localRectF = new RectF(this.f - this.g + m, this.f - this.g + m, this.f + this.g - m, this.f + this.g - m);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    float f3 = -90.0F - this.jdField_a_of_type_Float / 2.0F + this.h;
    float f2 = f3;
    if (this.k != 360)
    {
      f1 = f3;
      if (f3 < -90 - this.k / 2) {
        f1 = -90 - this.k / 2;
      }
      f2 = f1;
      if (this.jdField_a_of_type_Float + f1 <= this.k / 2 - 90) {}
    }
    for (float f1 = this.k / 2 - 90 - this.jdField_a_of_type_Float;; f1 = f2)
    {
      paramCanvas.drawArc(localRectF, f1, this.jdField_a_of_type_Float, true, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public int a()
  {
    return this.h;
  }
  
  public int b()
  {
    return this.i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.f = (this.c / 2);
    this.g = (this.f - this.c / 6);
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), b(paramInt2));
  }
  
  public void setDegreeChange(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.k = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    if (this.j == 2) {}
    for (paramFloat = (paramFloat - 0.122F) / 0.878F;; paramFloat = (paramFloat - 0.35F) / 1.15F)
    {
      this.jdField_a_of_type_Float = (paramFloat * 75.0F + 45.0F);
      postInvalidate();
      return;
    }
  }
  
  public void setModeType(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaBallView
 * JD-Core Version:    0.7.0.1
 */