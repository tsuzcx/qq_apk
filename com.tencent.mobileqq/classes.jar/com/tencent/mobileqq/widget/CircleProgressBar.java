package com.tencent.mobileqq.widget;

import aksv;
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

public class CircleProgressBar
  extends View
{
  public float a;
  public int a;
  public long a;
  aksv a;
  public Paint a;
  public RectF a;
  public TextPaint a;
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
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_Aksv = new aksv(this);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleProgressBar);
    this.jdField_a_of_type_Int = paramContext.getColor(0, Color.parseColor("#999999"));
    this.jdField_b_of_type_Int = paramContext.getColor(1, Color.parseColor("#12b7f5"));
    this.jdField_c_of_type_Int = paramContext.getColor(2, Color.parseColor("#000000"));
    this.jdField_a_of_type_Float = paramContext.getDimension(3, 25.0F);
    this.jdField_b_of_type_Float = paramContext.getDimension(4, 200.0F);
    this.jdField_c_of_type_Float = paramContext.getDimension(5, 250.0F);
    this.jdField_d_of_type_Float = paramContext.getInteger(6, 60);
    this.jdField_e_of_type_Float = paramContext.getDimension(7, 40.0F);
    this.jdField_f_of_type_Float = paramContext.getDimension(8, 200.0F);
    this.jdField_g_of_type_Float = paramContext.getDimension(9, 200.0F);
    this.jdField_h_of_type_Float = paramContext.getDimension(10, 200.0F);
    this.jdField_d_of_type_Int = paramContext.getColor(11, Color.parseColor("#999999"));
    this.jdField_e_of_type_Int = paramContext.getColor(12, Color.parseColor("#999999"));
    this.jdField_f_of_type_Int = paramContext.getColor(13, Color.parseColor("#999999"));
    this.jdField_g_of_type_Int = paramContext.getColor(14, Color.parseColor("#999999"));
    paramContext.recycle();
    this.jdField_i_of_type_Float = ((this.jdField_c_of_type_Float - this.jdField_b_of_type_Float) / 2.0F);
    this.n = (this.jdField_b_of_type_Float / 2.0F + this.jdField_i_of_type_Float / 2.0F);
    this.jdField_j_of_type_Float = ((this.jdField_f_of_type_Float - this.jdField_b_of_type_Float) / 2.0F);
    this.jdField_k_of_type_Float = ((this.jdField_g_of_type_Float - this.jdField_b_of_type_Float) / 2.0F);
    this.l = ((this.jdField_h_of_type_Float - this.jdField_b_of_type_Float) / 2.0F);
    this.m = this.jdField_i_of_type_Float;
    this.o = (this.jdField_b_of_type_Float / 2.0F + this.jdField_j_of_type_Float / 2.0F);
    this.p = (this.jdField_b_of_type_Float / 2.0F + this.jdField_k_of_type_Float / 2.0F);
    this.q = (this.jdField_b_of_type_Float / 2.0F + this.l / 2.0F);
  }
  
  private double a(float paramFloat)
  {
    return paramFloat / 360.0F * 2.0F * 3.141592653589793D;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    postInvalidate();
    this.jdField_a_of_type_Aksv.sendEmptyMessageDelayed(10000, 50L);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aksv.removeMessages(10000);
    postInvalidate();
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_j_of_type_Int = (getWidth() / 2);
    this.jdField_k_of_type_Int = (getHeight() / 2);
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
        this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_j_of_type_Int - this.n);
        this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_k_of_type_Int - this.n);
        this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_j_of_type_Int + this.n);
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_k_of_type_Int + this.n);
        localObject = new LinearGradient((float)(this.jdField_j_of_type_Int + this.n * Math.sin(a(this.jdField_i_of_type_Int + 90))), (float)(this.jdField_k_of_type_Int - this.n * Math.cos(a(this.jdField_i_of_type_Int + 90))), (float)(this.jdField_j_of_type_Int + this.n * Math.sin(a(this.jdField_i_of_type_Int + 90 + this.jdField_d_of_type_Float))), (float)(this.jdField_k_of_type_Int - this.n * Math.cos(a(this.jdField_i_of_type_Int + 90 + this.jdField_d_of_type_Float))), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Shader.TileMode.MIRROR);
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
      f1 = this.jdField_k_of_type_Int - (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F;
      f2 = this.jdField_k_of_type_Int;
      f3 = (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f4 - f5 + f6, f1, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float / 2.0F);
      f4 = this.jdField_j_of_type_Int + this.jdField_e_of_type_Float;
      paramCanvas.drawText("%", f4, f1, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float / 4.0F);
      paramCanvas.drawText("已扫描", f4, f2 + f3 - (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()), this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.reset();
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_g_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
    paramCanvas.drawCircle(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.n, this.jdField_a_of_type_AndroidGraphicsPaint);
    float f4 = (float)(this.jdField_a_of_type_Long + this.jdField_b_of_type_Long + this.jdField_c_of_type_Long + this.jdField_d_of_type_Long);
    float f2 = 360.0F * (float)this.jdField_a_of_type_Long / f4;
    float f1 = f2;
    if (f2 > 0.0F)
    {
      f1 = f2;
      if (f2 < this.r) {
        f1 = this.r;
      }
    }
    Object localObject = new RectF();
    ((RectF)localObject).left = (this.jdField_j_of_type_Int - this.o);
    ((RectF)localObject).top = (this.jdField_k_of_type_Int - this.o);
    ((RectF)localObject).right = (this.jdField_j_of_type_Int + this.o);
    ((RectF)localObject).bottom = (this.jdField_k_of_type_Int + this.o);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_j_of_type_Float);
    paramCanvas.drawArc((RectF)localObject, -90.0F, f1, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    float f3 = 360.0F * (float)this.jdField_b_of_type_Long / f4;
    f2 = f3;
    if (f3 > 0.0F)
    {
      f2 = f3;
      if (f3 < this.r) {
        f2 = this.r;
      }
    }
    ((RectF)localObject).left = (this.jdField_j_of_type_Int - this.p);
    ((RectF)localObject).top = (this.jdField_k_of_type_Int - this.p);
    ((RectF)localObject).right = (this.jdField_j_of_type_Int + this.p);
    ((RectF)localObject).bottom = (this.jdField_k_of_type_Int + this.p);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_k_of_type_Float);
    paramCanvas.drawArc((RectF)localObject, -90.0F + f1, f2, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    f3 = 360.0F * (float)this.jdField_c_of_type_Long / f4;
    if ((f3 > 0.0F) && (f3 < this.r)) {
      f3 = this.r;
    }
    for (;;)
    {
      ((RectF)localObject).left = (this.jdField_j_of_type_Int - this.q);
      ((RectF)localObject).top = (this.jdField_k_of_type_Int - this.q);
      ((RectF)localObject).right = (this.jdField_j_of_type_Int + this.q);
      ((RectF)localObject).bottom = (this.jdField_k_of_type_Int + this.q);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.l);
      paramCanvas.drawArc((RectF)localObject, -90.0F + f1 + f2, f3, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
      localObject = "" + (this.jdField_a_of_type_Long + this.jdField_b_of_type_Long + this.jdField_c_of_type_Long) * 100L / (this.jdField_a_of_type_Long + this.jdField_b_of_type_Long + this.jdField_c_of_type_Long + this.jdField_d_of_type_Long);
      f4 = this.jdField_j_of_type_Int;
      f5 = this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject);
      f6 = this.jdField_e_of_type_Float;
      f1 = this.jdField_k_of_type_Int - (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F;
      f2 = this.jdField_k_of_type_Int;
      f3 = (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F;
      paramCanvas.drawText((String)localObject, f4 - f5 + f6, f1, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float / 2.0F);
      f4 = this.jdField_j_of_type_Int + this.jdField_e_of_type_Float;
      paramCanvas.drawText("%", f4, f1, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float / 4.0F);
      paramCanvas.drawText("已用", f4, f2 + f3 - (this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()), this.jdField_a_of_type_AndroidTextTextPaint);
      break;
    }
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
    if (paramInt < 100) {
      this.jdField_a_of_type_JavaLangString = ("" + paramInt);
    }
    for (;;)
    {
      postInvalidate();
      return;
      this.jdField_a_of_type_JavaLangString = "100";
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgressBar
 * JD-Core Version:    0.7.0.1
 */