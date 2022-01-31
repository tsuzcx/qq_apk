package dov.com.qq.im.story.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import bbkx;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import vzo;

public class AnimationQIMCircleProgress
  extends QIMCircleProgress
{
  private RectF b;
  private boolean d;
  Paint jdField_e_of_type_AndroidGraphicsPaint;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float = 1.0F;
  private boolean jdField_f_of_type_Boolean = true;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public AnimationQIMCircleProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationQIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    super.a();
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    setBackgroundResource(2130843627);
    this.o = bbkx.a(30.0F);
    this.p = bbkx.a(6.0F);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_e_of_type_Boolean) {
      setBackgroundResource(2130837639);
    }
    for (;;)
    {
      super.a(paramInt);
      return;
      if ((paramInt != 1) && (this.d)) {
        setBackgroundDrawable(null);
      } else {
        setBackgroundResource(2130843627);
      }
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    if (!this.d)
    {
      if (this.jdField_b_of_type_Int == 3)
      {
        b(paramCanvas);
        return;
      }
      c(paramCanvas);
      return;
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      c(paramCanvas);
      return;
    }
    if (this.jdField_b_of_type_Int == 3) {
      b(paramCanvas);
    }
    d(paramCanvas);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (this.jdField_e_of_type_Boolean)
    {
      setBackgroundResource(2130837639);
      setCenterCircleColor(getResources().getColor(2131166155));
    }
    for (;;)
    {
      invalidate();
      return;
      setBackgroundResource(2130843627);
      setCenterCircleColor(-1);
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    int i = (getWidth() - this.o) / 2;
    int j = (getHeight() - this.o) / 2;
    this.jdField_b_of_type_AndroidGraphicsRectF.set(i, j, i + this.o, j + this.o);
    paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.p, this.p, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void c(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.n * this.a, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void d(Canvas paramCanvas)
  {
    int i = vzo.a(getContext(), 3.0F);
    Color.parseColor("#33000000");
    float f1 = this.i / 2;
    float f2 = this.i / 2;
    float f3 = this.i / 2 - i / 2;
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(i);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawCircle(f1, f2, f3, this.jdField_e_of_type_AndroidGraphicsPaint);
  }
  
  public void setCenterView()
  {
    super.setCenterView();
    this.m = bbkx.a(3.0F);
    this.n = (bbkx.a(53.0F) / 2);
  }
  
  public void setDrawCenterCircle(boolean paramBoolean)
  {
    if (this.jdField_f_of_type_Boolean != paramBoolean)
    {
      this.jdField_f_of_type_Boolean = paramBoolean;
      invalidate();
    }
  }
  
  public void setIldeStyle(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (this.d) {
      setBackgroundDrawable(null);
    }
    for (;;)
    {
      invalidate();
      return;
      setBackgroundResource(2130843627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.view.AnimationQIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */