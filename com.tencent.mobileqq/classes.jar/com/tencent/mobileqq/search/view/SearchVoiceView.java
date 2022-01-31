package com.tencent.mobileqq.search.view;

import ahiv;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class SearchVoiceView
  extends View
{
  public static int b;
  public static int c;
  private int A = -11993345;
  private int B = 30;
  private int C = 200;
  private int D = 6;
  private int E;
  private int F;
  private float jdField_a_of_type_Float;
  public final int a;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private SweepGradient jdField_a_of_type_AndroidGraphicsSweepGradient;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new ahiv(this));
  private SearchVoiceView.OnStateEndListener jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView$OnStateEndListener;
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_c_of_type_Float;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private float jdField_d_of_type_Float;
  public int d;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private float e;
  public int e;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 0;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int = 2098045951;
  private float jdField_h_of_type_Float = 5.0F;
  private int jdField_h_of_type_Int = 2097217526;
  private float jdField_i_of_type_Float = 2.0F;
  private int jdField_i_of_type_Int;
  private float jdField_j_of_type_Float;
  private int jdField_j_of_type_Int;
  private float jdField_k_of_type_Float;
  private int jdField_k_of_type_Int;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v = 2;
  private int w = 255;
  private int x = -11021825;
  private int y = -15559179;
  private int z = -1610638853;
  
  public SearchVoiceView(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_Int = 140;
  }
  
  public SearchVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 140;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SearchVoiceView);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(0);
    int i1 = TypedValue.complexToDimensionPixelSize(140, paramContext.getResources().getDisplayMetrics());
    this.jdField_j_of_type_Int = paramAttributeSet.getDimensionPixelSize(1, i1);
    this.jdField_i_of_type_Int = paramAttributeSet.getDimensionPixelSize(2, i1);
    paramAttributeSet.recycle();
    b();
  }
  
  private void a(Canvas paramCanvas)
  {
    c();
    d();
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_d_of_type_AndroidGraphicsPaint.setAlpha(this.w);
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.E, this.F, this.jdField_d_of_type_AndroidGraphicsPaint);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAlpha(255);
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_g_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_h_of_type_Int);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    jdField_b_of_type_Int = (int)(this.jdField_a_of_type_Float * 3.0F + 0.5D);
    int i1 = this.jdField_j_of_type_Int * 2 / 50;
    jdField_c_of_type_Int = i1;
    this.t = i1;
    this.m = (this.jdField_j_of_type_Int / 4);
    this.n = (this.jdField_j_of_type_Int / 2);
    this.o = (this.jdField_j_of_type_Int * 3 / 4);
    this.p = (this.jdField_j_of_type_Int * 5 / 4);
    this.q = (this.jdField_j_of_type_Int * 3 / 2);
    this.r = (this.jdField_j_of_type_Int * 7 / 4);
    this.s = (this.jdField_j_of_type_Int * 2);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof SkinnableBitmapDrawable)) {}
    for (this.jdField_a_of_type_AndroidGraphicsBitmap = ((SkinnableBitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();; this.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap())
    {
      this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
      this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(this.jdField_j_of_type_Int / 2, this.jdField_i_of_type_Int / 2, this.y, this.x);
      this.E = (this.jdField_j_of_type_Int / 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2);
      this.F = (this.jdField_i_of_type_Int / 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
      this.jdField_b_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = this.jdField_i_of_type_Int;
      this.jdField_b_of_type_AndroidGraphicsRectF.right = this.jdField_j_of_type_Int;
      this.jdField_b_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.left = this.D;
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_i_of_type_Int - this.D);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_j_of_type_Int - this.D);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = this.D;
      a();
      return;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    int i1 = paramCanvas.saveLayer(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_AndroidGraphicsPaint, 4);
    paramCanvas.drawColor(-1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.y);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.D);
    this.jdField_c_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
    paramCanvas.drawCircle(this.jdField_j_of_type_Int / 2, this.jdField_j_of_type_Int / 2, this.jdField_j_of_type_Int / 2 - this.D, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsPaint.setShader(null);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
    paramCanvas.drawCircle(this.jdField_j_of_type_Int / 2, this.jdField_j_of_type_Int / 2, this.jdField_j_of_type_Int / 2 - this.D * 3 / 2, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsPaint.setXfermode(null);
    paramCanvas.restoreToCount(i1);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_k_of_type_Int, this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_k_of_type_Int + this.m, this.jdField_e_of_type_Int - this.jdField_d_of_type_Int * 2, this.jdField_k_of_type_Int + this.n, this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_k_of_type_Int + this.o, this.jdField_e_of_type_Int + this.jdField_d_of_type_Int * 2, this.jdField_k_of_type_Int + this.jdField_j_of_type_Int, this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_k_of_type_Int + this.p, this.jdField_e_of_type_Int - this.jdField_d_of_type_Int * 2, this.jdField_k_of_type_Int + this.q, this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_k_of_type_Int + this.r, this.jdField_e_of_type_Int + this.jdField_d_of_type_Int * 2, this.jdField_k_of_type_Int + this.s, this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_k_of_type_Int + this.s, this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_k_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = paramCanvas.saveLayer(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_AndroidGraphicsPaint, 4);
    paramCanvas.drawColor(-1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.y);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.D);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_Float, this.jdField_e_of_type_Float, false, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.z);
    if (this.jdField_f_of_type_Float >= 0.0F) {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Float, this.jdField_f_of_type_Float, false, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.A);
    if (this.jdField_g_of_type_Float >= 0.0F) {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_Float, this.jdField_g_of_type_Float, false, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
    paramCanvas.drawCircle(this.jdField_j_of_type_Int / 2, this.jdField_j_of_type_Int / 2, this.jdField_j_of_type_Int / 2 - this.D * 3 / 2 + 2, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsPaint.setXfermode(null);
    paramCanvas.restoreToCount(i1);
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidGraphicsPath.reset();
    this.jdField_b_of_type_AndroidGraphicsPath.moveTo(this.l, this.jdField_e_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.l + this.m, this.jdField_e_of_type_Int - this.jdField_d_of_type_Int * 2, this.l + this.n, this.jdField_e_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.l + this.o, this.jdField_e_of_type_Int + this.jdField_d_of_type_Int * 2, this.l + this.jdField_j_of_type_Int, this.jdField_e_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.l + this.p, this.jdField_e_of_type_Int - this.jdField_d_of_type_Int * 2, this.l + this.q, this.jdField_e_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.l + this.r, this.jdField_e_of_type_Int + this.jdField_d_of_type_Int * 2, this.l + this.s, this.jdField_e_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.l + this.s, this.jdField_i_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.l, this.jdField_i_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPath.close();
  }
  
  public void a()
  {
    this.jdField_d_of_type_Int = jdField_b_of_type_Int;
    this.t = jdField_c_of_type_Int;
    this.jdField_e_of_type_Int = this.jdField_i_of_type_Int;
    this.l = (this.jdField_j_of_type_Int * -2 / 4);
    this.jdField_k_of_type_Int = (-this.jdField_j_of_type_Int);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 270.0F;
    this.jdField_f_of_type_Float = 20.0F;
    this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float - this.jdField_f_of_type_Float);
    this.jdField_d_of_type_Float = (this.jdField_c_of_type_Float - this.jdField_f_of_type_Float);
    this.jdField_g_of_type_Float = 20.0F;
    float f1 = this.C / this.B;
    this.jdField_i_of_type_Float = (this.jdField_e_of_type_Float / f1);
    this.jdField_h_of_type_Float = this.jdField_i_of_type_Float;
    this.jdField_j_of_type_Float = (this.jdField_f_of_type_Float / f1 * 1.25F);
    this.jdField_k_of_type_Float = (this.jdField_g_of_type_Float / f1 * 1.25F);
    this.u = (this.jdField_i_of_type_Int * 3 / 5);
    this.w = 255;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a(5);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(-1);
    switch (this.jdField_f_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 1: 
      a(paramCanvas);
      a(paramCanvas, false);
      b(paramCanvas);
      return;
    case 2: 
      a(paramCanvas);
      a(paramCanvas, false);
      c(paramCanvas);
      return;
    case 3: 
      a(paramCanvas, false);
      c(paramCanvas);
      return;
    case 4: 
      a(paramCanvas, false);
      c(paramCanvas);
      return;
    }
    paramCanvas.drawColor(-1);
  }
  
  public void setAmplitude(float paramFloat)
  {
    if (this.jdField_f_of_type_Int < 1) {}
    for (;;)
    {
      return;
      float f1 = paramFloat;
      if (paramFloat > 0.0F) {
        f1 = 0.0F;
      }
      if (f1 < -45.0F)
      {
        this.u = ((int)(this.jdField_i_of_type_Int * 0.65F));
        this.jdField_d_of_type_Int = jdField_b_of_type_Int;
      }
      while (QLog.isDevelopLevel())
      {
        QLog.i("SearchVoiceView", 2, " setAmplitude " + f1 + " mWaterHeight = " + this.u + " mWaveHeightOffset = " + this.v + " mMoveOffset = " + this.t + " amplitude = " + this.jdField_d_of_type_Int);
        return;
        if ((f1 >= -45.0F) && (f1 < -5.0F))
        {
          paramFloat = (45.0F + f1) / 40.0F;
          this.u = ((int)(this.jdField_i_of_type_Int * (0.65D - paramFloat * 0.15D)));
          if (this.jdField_e_of_type_Int < (int)(this.jdField_i_of_type_Int * 0.65F)) {
            this.jdField_d_of_type_Int = ((int)(jdField_b_of_type_Int * (paramFloat * 2.0F + 1.0F)));
          }
          this.t = ((int)((paramFloat + 1.0F) * jdField_c_of_type_Int));
        }
        else
        {
          paramFloat = (5.0F + f1) / 5.0F;
          this.u = ((int)(this.jdField_i_of_type_Int * (0.5D - 4.0F * paramFloat / 10.0F)));
          if (this.jdField_e_of_type_Int < (int)(this.jdField_i_of_type_Int * 0.65F)) {
            this.jdField_d_of_type_Int = ((int)(jdField_b_of_type_Int * (2.0F + paramFloat)));
          }
          this.t = ((int)((paramFloat + 2.0F) * jdField_c_of_type_Int));
        }
      }
    }
  }
  
  public void setOnStateEndListener(SearchVoiceView.OnStateEndListener paramOnStateEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView$OnStateEndListener = paramOnStateEndListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchVoiceView
 * JD-Core Version:    0.7.0.1
 */