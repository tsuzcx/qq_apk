package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import aycb;
import aycc;
import java.util.ArrayList;
import mvk;

public class MetaballView
  extends View
{
  private float jdField_a_of_type_Float = 1.0F;
  private final int jdField_a_of_type_Int = 2;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private aycb jdField_a_of_type_Aycb;
  private aycc jdField_a_of_type_Aycc;
  private ArrayList<aycb> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private float jdField_b_of_type_Float = 10.0F;
  private int jdField_b_of_type_Int = 60;
  float[] jdField_b_of_type_ArrayOfFloat = new float[2];
  private final float jdField_c_of_type_Float = 0.3F;
  float[] jdField_c_of_type_ArrayOfFloat = new float[2];
  private float jdField_d_of_type_Float;
  float[] jdField_d_of_type_ArrayOfFloat = new float[2];
  private float jdField_e_of_type_Float;
  float[] jdField_e_of_type_ArrayOfFloat = new float[2];
  float[] f = new float[2];
  float[] g = new float[2];
  float[] h = new float[2];
  float[] i = new float[2];
  float[] j = new float[2];
  float[] k = new float[2];
  float[] l = new float[2];
  float[] m = new float[2];
  
  public MetaballView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MetaballView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
    a();
  }
  
  public MetaballView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private float a(float[] paramArrayOfFloat)
  {
    return (float)Math.sqrt(paramArrayOfFloat[0] * paramArrayOfFloat[0] + paramArrayOfFloat[1] * paramArrayOfFloat[1]);
  }
  
  private float a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat1[0] - paramArrayOfFloat2[0];
    float f2 = paramArrayOfFloat1[1] - paramArrayOfFloat2[1];
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void a()
  {
    this.jdField_b_of_type_Float = a();
    this.jdField_b_of_type_Int = b();
    float f1 = 1.3F * this.jdField_b_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16395392);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    aycb localaycb = new aycb(this, null);
    localaycb.jdField_a_of_type_ArrayOfFloat = new float[] { this.jdField_b_of_type_Float + this.jdField_b_of_type_Int, f1 };
    localaycb.jdField_a_of_type_Float = (this.jdField_b_of_type_Float / 4.0F * 3.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaycb);
    int n = 1;
    while (n < 2)
    {
      localaycb = new aycb(this, null);
      localaycb.jdField_a_of_type_ArrayOfFloat = new float[] { (this.jdField_b_of_type_Float * 2.0F + this.jdField_b_of_type_Int) * n, f1 };
      localaycb.jdField_a_of_type_Float = this.jdField_b_of_type_Float;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaycb);
      n += 1;
    }
    this.jdField_d_of_type_Float = ((this.jdField_b_of_type_Float * 2.0F + this.jdField_b_of_type_Int) * 2.0F - this.jdField_b_of_type_Float * 2.0F);
  }
  
  private void a(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = ((float)(Math.cos(paramFloat1) * paramFloat2));
    paramArrayOfFloat[1] = ((float)(Math.sin(paramFloat1) * paramFloat2));
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Object localObject = (aycb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
    aycb localaycb = (aycb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
    float f4 = a(((aycb)localObject).jdField_a_of_type_ArrayOfFloat, localaycb.jdField_a_of_type_ArrayOfFloat);
    float f3 = ((aycb)localObject).jdField_a_of_type_Float;
    float f1 = localaycb.jdField_a_of_type_Float;
    if (f4 > paramFloat3)
    {
      paramCanvas.drawCircle(localaycb.jdField_a_of_type_ArrayOfFloat[0], localaycb.jdField_a_of_type_ArrayOfFloat[1], f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      if ((f3 != 0.0F) && (f1 != 0.0F)) {
        break label147;
      }
    }
    label147:
    while ((f4 > paramFloat3) || (f4 <= Math.abs(f3 - f1)))
    {
      return;
      f1 *= (1.0F + 0.3F * (1.0F - f4 / paramFloat3));
      paramCanvas.drawCircle(localaycb.jdField_a_of_type_ArrayOfFloat[0], localaycb.jdField_a_of_type_ArrayOfFloat[1], f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      break;
    }
    float f2;
    if (f4 < f3 + f1) {
      f2 = (float)Math.acos((f3 * f3 + f4 * f4 - f1 * f1) / (2.0F * f3 * f4));
    }
    for (paramFloat3 = (float)Math.acos((f1 * f1 + f4 * f4 - f3 * f3) / (2.0F * f1 * f4));; paramFloat3 = 0.0F)
    {
      float f7 = (float)Math.atan2(localaycb.jdField_a_of_type_ArrayOfFloat[1] - localObject.jdField_a_of_type_ArrayOfFloat[1], localaycb.jdField_a_of_type_ArrayOfFloat[0] - localObject.jdField_a_of_type_ArrayOfFloat[0]);
      float f8 = (float)Math.acos((f3 - f1) / f4);
      float f5 = f7 + f2 + (f8 - f2) * paramFloat1;
      f2 = f7 - f2 - (f8 - f2) * paramFloat1;
      float f6 = (float)(f7 + 3.141592653589793D - paramFloat3 - (3.141592653589793D - paramFloat3 - f8) * paramFloat1);
      double d1 = f7;
      double d2 = paramFloat3;
      paramFloat3 = (float)((3.141592653589793D - paramFloat3 - f8) * paramFloat1 + (d1 - 3.141592653589793D + d2));
      a(f5, f3, this.jdField_a_of_type_ArrayOfFloat);
      a(f2, f3, this.jdField_b_of_type_ArrayOfFloat);
      a(f6, f1, this.jdField_c_of_type_ArrayOfFloat);
      a(paramFloat3, f1, this.jdField_d_of_type_ArrayOfFloat);
      this.jdField_e_of_type_ArrayOfFloat[0] = (this.jdField_a_of_type_ArrayOfFloat[0] + localObject.jdField_a_of_type_ArrayOfFloat[0]);
      this.jdField_e_of_type_ArrayOfFloat[1] = (this.jdField_a_of_type_ArrayOfFloat[1] + localObject.jdField_a_of_type_ArrayOfFloat[1]);
      this.f[0] = (this.jdField_b_of_type_ArrayOfFloat[0] + localObject.jdField_a_of_type_ArrayOfFloat[0]);
      float[] arrayOfFloat = this.f;
      f7 = this.jdField_b_of_type_ArrayOfFloat[1];
      arrayOfFloat[1] = (localObject.jdField_a_of_type_ArrayOfFloat[1] + f7);
      this.g[0] = (this.jdField_c_of_type_ArrayOfFloat[0] + localaycb.jdField_a_of_type_ArrayOfFloat[0]);
      this.g[1] = (this.jdField_c_of_type_ArrayOfFloat[1] + localaycb.jdField_a_of_type_ArrayOfFloat[1]);
      this.h[0] = (this.jdField_d_of_type_ArrayOfFloat[0] + localaycb.jdField_a_of_type_ArrayOfFloat[0]);
      localObject = this.h;
      f7 = this.jdField_d_of_type_ArrayOfFloat[1];
      localObject[1] = (localaycb.jdField_a_of_type_ArrayOfFloat[1] + f7);
      this.i[0] = (this.jdField_e_of_type_ArrayOfFloat[0] - this.g[0]);
      this.i[1] = (this.jdField_e_of_type_ArrayOfFloat[1] - this.g[1]);
      paramFloat1 = Math.min(paramFloat1 * paramFloat2, a(this.i) / (f3 + f1)) * Math.min(1.0F, f4 * 2.0F / (f3 + f1));
      paramFloat2 = f3 * paramFloat1;
      paramFloat1 *= f1;
      a(f5 - 1.570796F, paramFloat2, this.j);
      a(f6 + 1.570796F, paramFloat1, this.k);
      a(paramFloat3 - 1.570796F, paramFloat1, this.l);
      a(f2 + 1.570796F, paramFloat2, this.m);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_e_of_type_ArrayOfFloat[0], this.jdField_e_of_type_ArrayOfFloat[1]);
      this.jdField_a_of_type_AndroidGraphicsPath.cubicTo(this.jdField_e_of_type_ArrayOfFloat[0] + this.j[0], this.jdField_e_of_type_ArrayOfFloat[1] + this.j[1], this.g[0] + this.k[0], this.g[1] + this.k[1], this.g[0], this.g[1]);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.h[0], this.h[1]);
      this.jdField_a_of_type_AndroidGraphicsPath.cubicTo(this.h[0] + this.l[0], this.h[1] + this.l[1], this.f[0] + this.m[0], this.f[1] + this.m[1], this.f[0], this.f[1]);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_e_of_type_ArrayOfFloat[0], this.jdField_e_of_type_ArrayOfFloat[1]);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      f2 = 0.0F;
    }
  }
  
  private void b()
  {
    clearAnimation();
    postInvalidate();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Aycc = new aycc(this, null);
    this.jdField_a_of_type_Aycc.setDuration(1000L);
    this.jdField_a_of_type_Aycc.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_Aycc.setRepeatCount(-1);
    this.jdField_a_of_type_Aycc.setRepeatMode(2);
    startAnimation(this.jdField_a_of_type_Aycc);
  }
  
  protected int a()
  {
    return (int)mvk.a(getContext(), 10.0F);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {}
  
  protected int b()
  {
    return (int)mvk.a(getContext(), 20.0F);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (getVisibility() == 0) {
      c();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (getVisibility() == 0) {
      b();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int n = 1;
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_Aycb = ((aycb)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_Aycb.jdField_a_of_type_ArrayOfFloat[0] = (this.jdField_d_of_type_Float * this.jdField_e_of_type_Float + this.jdField_b_of_type_Float);
    paramCanvas.drawCircle(this.jdField_a_of_type_Aycb.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_Aycb.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_Aycb.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    while (n < i1)
    {
      a(paramCanvas, n, 0, 0.6F, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float * 2.0F);
      n += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(resolveSizeAndState((int)((this.jdField_b_of_type_Float * 2.0F + this.jdField_b_of_type_Int) * 2.0F), paramInt1, 0), resolveSizeAndState((int)(this.jdField_b_of_type_Float * 2.0F * 1.4F), paramInt2, 0));
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (getVisibility() == 0)) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      b();
      return;
    }
    c();
  }
  
  public void setPaintMode(int paramInt)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (paramInt == 0) {}
    for (Paint.Style localStyle = Paint.Style.STROKE;; localStyle = Paint.Style.FILL)
    {
      localPaint.setStyle(localStyle);
      invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.MetaballView
 * JD-Core Version:    0.7.0.1
 */