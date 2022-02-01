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
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new WaveView.1(this));
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
    this.h = getResources().getDimensionPixelSize(2131298348);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    double d1 = this.jdField_a_of_type_Float * 4.0F;
    Double.isNaN(d1);
    jdField_a_of_type_Int = (int)(d1 + 0.5D);
    int i1 = jdField_a_of_type_Int;
    this.c = i1;
    this.d = (i1 * 3);
    this.e = (this.d - this.c);
    i1 = this.i;
    int i2 = i1 / 125;
    jdField_b_of_type_Int = i2;
    this.s = i2;
    this.k = 0;
    this.j = (-i1);
    this.l = (i1 / 4);
    this.m = (i1 / 2);
    this.n = (i1 * 3 / 4);
    this.o = (i1 * 5 / 4);
    this.p = (i1 * 3 / 2);
    this.q = (i1 * 7 / 4);
    this.r = (i1 * 2);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.j, this.d);
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    int i1 = this.j;
    float f1 = this.l + i1;
    int i2 = this.d;
    localPath.quadTo(f1, i2 - this.c * 2, i1 + this.m, i2);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    i1 = this.j;
    f1 = this.n + i1;
    i2 = this.d;
    localPath.quadTo(f1, this.c * 2 + i2, i1 + this.i, i2);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    i1 = this.j;
    f1 = this.o + i1;
    i2 = this.d;
    localPath.quadTo(f1, i2 - this.c * 2, i1 + this.p, i2);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    i1 = this.j;
    f1 = this.q + i1;
    i2 = this.d;
    localPath.quadTo(f1, this.c * 2 + i2, i1 + this.r, i2);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.j + this.r, this.h);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.j, this.h);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidGraphicsPath.reset();
    this.jdField_b_of_type_AndroidGraphicsPath.moveTo(this.k, this.e);
    Path localPath = this.jdField_b_of_type_AndroidGraphicsPath;
    int i1 = this.k;
    float f1 = this.l + i1;
    int i2 = this.e;
    localPath.quadTo(f1, i2 - this.c * 2, i1 + this.m, i2);
    localPath = this.jdField_b_of_type_AndroidGraphicsPath;
    i1 = this.k;
    f1 = this.n + i1;
    i2 = this.e;
    localPath.quadTo(f1, this.c * 2 + i2, i1 + this.i, i2);
    localPath = this.jdField_b_of_type_AndroidGraphicsPath;
    i1 = this.k;
    f1 = this.o + i1;
    i2 = this.e;
    localPath.quadTo(f1, i2 - this.c * 2, i1 + this.p, i2);
    localPath = this.jdField_b_of_type_AndroidGraphicsPath;
    i1 = this.k;
    f1 = this.q + i1;
    i2 = this.e;
    localPath.quadTo(f1, this.c * 2 + i2, i1 + this.r, i2);
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.k + this.r, this.h);
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.k, this.h);
    this.jdField_b_of_type_AndroidGraphicsPath.close();
  }
  
  private void d()
  {
    if (!VersionUtils.e()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
  }
  
  private void e()
  {
    if (!VersionUtils.e()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.WaveView
 * JD-Core Version:    0.7.0.1
 */