package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import blgh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class WaveView
  extends ImageView
{
  public static int a;
  public static int b;
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new blgh(this));
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  public int c;
  public int d;
  public int e;
  private int f = -1249807;
  private int g = -1249807;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  
  public WaveView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(102);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.g);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(38);
    this.i = getResources().getDisplayMetrics().widthPixels;
    this.h = getResources().getDimensionPixelSize(2131298267);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    jdField_a_of_type_Int = (int)(this.jdField_a_of_type_Float * 4.0F + 0.5D);
    this.c = jdField_a_of_type_Int;
    this.d = (jdField_a_of_type_Int * 3);
    this.e = (this.d - this.c);
    int i1 = this.i / 125;
    jdField_b_of_type_Int = i1;
    this.s = i1;
    this.k = 0;
    this.j = (-this.i);
    this.l = (this.i / 4);
    this.m = (this.i / 2);
    this.n = (this.i * 3 / 4);
    this.o = (this.i * 5 / 4);
    this.p = (this.i * 3 / 2);
    this.q = (this.i * 7 / 4);
    this.r = (this.i * 2);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.j, this.d);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.j + this.l, this.d - this.c * 2, this.j + this.m, this.d);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.j + this.n, this.d + this.c * 2, this.j + this.i, this.d);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.j + this.o, this.d - this.c * 2, this.j + this.p, this.d);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.j + this.q, this.d + this.c * 2, this.j + this.r, this.d);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.j + this.r, this.h);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.j, this.h);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidGraphicsPath.reset();
    this.jdField_b_of_type_AndroidGraphicsPath.moveTo(this.k, this.e);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.k + this.l, this.e - this.c * 2, this.k + this.m, this.e);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.k + this.n, this.e + this.c * 2, this.k + this.i, this.e);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.k + this.o, this.e - this.c * 2, this.k + this.p, this.e);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.k + this.q, this.e + this.c * 2, this.k + this.r, this.e);
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.k + this.r, this.h);
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.k, this.h);
    this.jdField_b_of_type_AndroidGraphicsPath.close();
  }
  
  private void d()
  {
    if (!VersionUtils.isHoneycomb()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
  }
  
  private void e()
  {
    if (!VersionUtils.isHoneycomb()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d();
    if (QLog.isColorLevel()) {
      QLog.i("WaveView", 2, "WaveVie onAttachedToWindow.");
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e();
    if (QLog.isColorLevel()) {
      QLog.i("WaveView", 2, "WaveView onDetachedFromWindow.");
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b();
    c();
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.WaveView
 * JD-Core Version:    0.7.0.1
 */