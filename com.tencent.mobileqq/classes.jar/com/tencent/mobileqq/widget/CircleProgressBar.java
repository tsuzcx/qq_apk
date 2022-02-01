package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.HardCodeUtil;

public class CircleProgressBar
  extends View
{
  public float a;
  public int a;
  public long a;
  public Paint a;
  public RectF a;
  public TextPaint a;
  CircleProgressBar.RefreshHandler a;
  public String a;
  public boolean a;
  public float b;
  public int b;
  public long b;
  public boolean b;
  public float c;
  public int c;
  public long c;
  public float d;
  public int d;
  public long d;
  public float e;
  public int e;
  public float f;
  public int f;
  public float g;
  public int g;
  public float h;
  public int h;
  public float i;
  public int i;
  public float j;
  public int j;
  public float k;
  public int k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p;
  public float q;
  public float r;
  
  public CircleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_JavaLangString = "10";
    this.jdField_h_of_type_Int = -90;
    this.jdField_i_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar$RefreshHandler = new CircleProgressBar.RefreshHandler(this);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleProgressBar);
    this.jdField_a_of_type_Int = paramContext.getColor(13, Color.parseColor("#999999"));
    this.jdField_b_of_type_Int = paramContext.getColor(10, Color.parseColor("#12b7f5"));
    this.jdField_c_of_type_Int = paramContext.getColor(7, Color.parseColor("#000000"));
    this.jdField_a_of_type_Float = paramContext.getDimension(8, 25.0F);
    this.jdField_b_of_type_Float = paramContext.getDimension(3, 200.0F);
    this.jdField_c_of_type_Float = paramContext.getDimension(6, 250.0F);
    this.jdField_d_of_type_Float = paramContext.getInteger(9, 60);
    this.jdField_e_of_type_Float = paramContext.getDimension(14, 40.0F);
    this.jdField_f_of_type_Float = paramContext.getDimension(12, 200.0F);
    this.jdField_g_of_type_Float = paramContext.getDimension(2, 200.0F);
    this.jdField_h_of_type_Float = paramContext.getDimension(5, 200.0F);
    this.jdField_d_of_type_Int = paramContext.getColor(11, Color.parseColor("#999999"));
    this.jdField_e_of_type_Int = paramContext.getColor(1, Color.parseColor("#999999"));
    this.jdField_f_of_type_Int = paramContext.getColor(4, Color.parseColor("#999999"));
    this.jdField_g_of_type_Int = paramContext.getColor(0, Color.parseColor("#999999"));
    paramContext.recycle();
    float f2 = this.jdField_c_of_type_Float;
    float f1 = this.jdField_b_of_type_Float;
    this.jdField_i_of_type_Float = ((f2 - f1) / 2.0F);
    f2 = f1 / 2.0F;
    float f3 = this.jdField_i_of_type_Float;
    this.n = (f2 + f3 / 2.0F);
    this.jdField_j_of_type_Float = ((this.jdField_f_of_type_Float - f1) / 2.0F);
    this.jdField_k_of_type_Float = ((this.jdField_g_of_type_Float - f1) / 2.0F);
    this.l = ((this.jdField_h_of_type_Float - f1) / 2.0F);
    this.m = f3;
    this.o = (f1 / 2.0F + this.jdField_j_of_type_Float / 2.0F);
    this.p = (f1 / 2.0F + this.jdField_k_of_type_Float / 2.0F);
    this.q = (f1 / 2.0F + this.l / 2.0F);
  }
  
  private double a(float paramFloat)
  {
    double d1 = paramFloat / 360.0F * 2.0F;
    Double.isNaN(d1);
    return d1 * 3.141592653589793D;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    postInvalidate();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar$RefreshHandler.sendEmptyMessageDelayed(10000, 50L);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar$RefreshHandler.removeMessages(10000);
    postInvalidate();
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_j_of_type_Int = (getWidth() / 2);
    this.jdField_k_of_type_Int = (getHeight() / 2);
    Object localObject;
    int i1;
    float f1;
    float f2;
    int i2;
    float f3;
    float f4;
    float f5;
    float f6;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_i_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      paramCanvas.drawCircle(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.n, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
        i1 = this.jdField_j_of_type_Int;
        f1 = i1;
        f2 = this.n;
        ((RectF)localObject).left = (f1 - f2);
        i2 = this.jdField_k_of_type_Int;
        ((RectF)localObject).top = (i2 - f2);
        ((RectF)localObject).right = (i1 + f2);
        ((RectF)localObject).bottom = (i2 + f2);
        double d1 = i1;
        double d2 = f2;
        double d3 = Math.sin(a(this.jdField_i_of_type_Int + 90));
        Double.isNaN(d2);
        Double.isNaN(d1);
        f1 = (float)(d1 + d2 * d3);
        d1 = this.jdField_k_of_type_Int;
        d2 = this.n;
        d3 = Math.cos(a(this.jdField_i_of_type_Int + 90));
        Double.isNaN(d2);
        Double.isNaN(d1);
        f2 = (float)(d1 - d2 * d3);
        d1 = this.jdField_j_of_type_Int;
        d2 = this.n;
        d3 = Math.sin(a(this.jdField_i_of_type_Int + 90 + this.jdField_d_of_type_Float));
        Double.isNaN(d2);
        Double.isNaN(d1);
        f3 = (float)(d1 + d2 * d3);
        d1 = this.jdField_k_of_type_Int;
        d2 = this.n;
        d3 = Math.cos(a(this.jdField_i_of_type_Int + 90 + this.jdField_d_of_type_Float));
        Double.isNaN(d2);
        Double.isNaN(d1);
        localObject = new LinearGradient(f1, f2, f3, (float)(d1 - d2 * d3), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Shader.TileMode.MIRROR);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
        paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_i_of_type_Int, this.jdField_d_of_type_Float, false, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
      f4 = this.jdField_j_of_type_Int;
      f5 = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString);
      f6 = this.jdField_e_of_type_Float;
      f3 = this.jdField_k_of_type_Int - (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F;
      f1 = this.jdField_k_of_type_Int;
      f2 = (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f4 - f5 + f6, f3, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float / 2.0F);
      f4 = this.jdField_j_of_type_Int + this.jdField_e_of_type_Float;
      paramCanvas.drawText("%", f4, f3, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float / 4.0F);
      f3 = this.jdField_a_of_type_AndroidTextTextPaint.descent();
      f5 = this.jdField_a_of_type_AndroidTextTextPaint.ascent();
      paramCanvas.drawText(HardCodeUtil.a(2131702112), f4, f1 + f2 - (f3 + f5), this.jdField_a_of_type_AndroidTextTextPaint);
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_g_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
      paramCanvas.drawCircle(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.n, this.jdField_a_of_type_AndroidGraphicsPaint);
      long l1 = this.jdField_a_of_type_Long;
      f4 = (float)(this.jdField_b_of_type_Long + l1 + this.jdField_c_of_type_Long + this.jdField_d_of_type_Long);
      f2 = (float)l1 * 360.0F / f4;
      if (f2 > 0.0F)
      {
        f1 = this.r;
        if (f2 < f1) {
          f2 = f1;
        }
      }
      localObject = new RectF();
      i1 = this.jdField_j_of_type_Int;
      f1 = i1;
      f3 = this.o;
      ((RectF)localObject).left = (f1 - f3);
      i2 = this.jdField_k_of_type_Int;
      ((RectF)localObject).top = (i2 - f3);
      ((RectF)localObject).right = (i1 + f3);
      ((RectF)localObject).bottom = (i2 + f3);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_j_of_type_Float);
      paramCanvas.drawArc((RectF)localObject, -90.0F, f2, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      f1 = (float)this.jdField_b_of_type_Long * 360.0F / f4;
      if (f1 > 0.0F)
      {
        f3 = this.r;
        if (f1 < f3) {
          f1 = f3;
        }
      }
      i1 = this.jdField_j_of_type_Int;
      f3 = i1;
      f5 = this.p;
      ((RectF)localObject).left = (f3 - f5);
      i2 = this.jdField_k_of_type_Int;
      ((RectF)localObject).top = (i2 - f5);
      ((RectF)localObject).right = (i1 + f5);
      ((RectF)localObject).bottom = (i2 + f5);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_k_of_type_Float);
      f5 = -90.0F + f2;
      paramCanvas.drawArc((RectF)localObject, f5, f1, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      f2 = (float)this.jdField_c_of_type_Long * 360.0F / f4;
      if (f2 > 0.0F)
      {
        f3 = this.r;
        if (f2 < f3) {
          f2 = f3;
        }
      }
      i1 = this.jdField_j_of_type_Int;
      f3 = i1;
      f4 = this.q;
      ((RectF)localObject).left = (f3 - f4);
      i2 = this.jdField_k_of_type_Int;
      ((RectF)localObject).top = (i2 - f4);
      ((RectF)localObject).right = (i1 + f4);
      ((RectF)localObject).bottom = (i2 + f4);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.l);
      paramCanvas.drawArc((RectF)localObject, f5 + f1, f2, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      l1 = this.jdField_a_of_type_Long;
      long l2 = this.jdField_b_of_type_Long;
      long l3 = this.jdField_c_of_type_Long;
      ((StringBuilder)localObject).append((l1 + l2 + l3) * 100L / (l1 + l2 + l3 + this.jdField_d_of_type_Long));
      localObject = ((StringBuilder)localObject).toString();
      f4 = this.jdField_j_of_type_Int;
      f5 = this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject);
      f6 = this.jdField_e_of_type_Float;
      f3 = this.jdField_k_of_type_Int - (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F;
      f1 = this.jdField_k_of_type_Int;
      f2 = (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F;
      paramCanvas.drawText((String)localObject, f4 - f5 + f6, f3, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float / 2.0F);
      f4 = this.jdField_j_of_type_Int + this.jdField_e_of_type_Float;
      paramCanvas.drawText("%", f4, f3, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float / 4.0F);
      f3 = this.jdField_a_of_type_AndroidTextTextPaint.descent();
      f5 = this.jdField_a_of_type_AndroidTextTextPaint.ascent();
      paramCanvas.drawText(HardCodeUtil.a(2131702113), f4, f1 + f2 - (f3 + f5), this.jdField_a_of_type_AndroidTextTextPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
  }
  
  public void setFinish(long paramLong1, long paramLong2, long paramLong3, long paramLong4, float paramFloat)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = paramLong3;
    this.jdField_d_of_type_Long = paramLong4;
    this.r = paramFloat;
    b();
    this.jdField_b_of_type_Boolean = true;
    postInvalidate();
  }
  
  public void setPercent(int paramInt)
  {
    if (paramInt < 100)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = "100";
      b();
    }
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgressBar
 * JD-Core Version:    0.7.0.1
 */