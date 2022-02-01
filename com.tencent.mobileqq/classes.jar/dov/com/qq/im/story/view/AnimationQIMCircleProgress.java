package dov.com.qq.im.story.view;

import afur;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import bgtn;
import bnzg;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import zlx;

public class AnimationQIMCircleProgress
  extends QIMCircleProgress
{
  private bnzg a;
  private RectF b;
  private boolean d;
  Paint jdField_e_of_type_AndroidGraphicsPaint;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private float jdField_g_of_type_Float = 1.0F;
  private boolean jdField_g_of_type_Boolean = true;
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
    setBackgroundResource(2130844456);
    this.o = bgtn.a(30.0F);
    this.p = bgtn.a(6.0F);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public void a(int paramInt)
  {
    if ((this.f) && (this.jdField_a_of_type_Bnzg != null)) {
      setBackgroundResource(this.jdField_a_of_type_Bnzg.c);
    }
    for (;;)
    {
      super.a(paramInt);
      return;
      if (this.jdField_e_of_type_Boolean) {
        setBackgroundResource(2130837921);
      } else if ((paramInt != 1) && (this.d)) {
        setBackgroundDrawable(null);
      } else {
        setBackgroundResource(2130844456);
      }
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (!this.jdField_g_of_type_Boolean) {
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
      setBackgroundResource(2130837921);
      setCenterCircleColor(getResources().getColor(2131166275));
    }
    for (;;)
    {
      invalidate();
      return;
      setBackgroundResource(2130844456);
      setCenterCircleColor(-1);
    }
  }
  
  public void a(boolean paramBoolean, @NonNull bnzg parambnzg)
  {
    this.f = paramBoolean;
    this.jdField_a_of_type_Bnzg = parambnzg;
    if (this.f)
    {
      setBackgroundResource(this.jdField_a_of_type_Bnzg.c);
      setCenterCircleColor(0);
      setProgressOffset(afur.a(1.8F, getResources()));
      setProgressColor(this.jdField_a_of_type_Bnzg.d);
    }
    for (;;)
    {
      invalidate();
      return;
      setBackgroundResource(2130844456);
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
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.n * this.jdField_a_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void d(Canvas paramCanvas)
  {
    int i = zlx.a(getContext(), 3.0F);
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
    this.m = bgtn.a(3.0F);
    this.n = (bgtn.a(53.0F) / 2);
  }
  
  public void setDrawCenterCircle(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_Boolean != paramBoolean)
    {
      this.jdField_g_of_type_Boolean = paramBoolean;
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
      setBackgroundResource(2130844456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.story.view.AnimationQIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */