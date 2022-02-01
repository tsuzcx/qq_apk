package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import bhfg;
import bipw;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.util.Arrays;

public class MessageProgressView
  extends View
{
  private float A;
  private float B;
  private float C;
  public float a;
  private int jdField_a_of_type_Int;
  public long a;
  public Resources a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public Path a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  public Drawable a;
  AccelerateDecelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator;
  public bipw a;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  public float b;
  private int jdField_b_of_type_Int = -1;
  public long b;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  public Drawable b;
  public final String b;
  private boolean jdField_b_of_type_Boolean = true;
  public float c;
  public long c;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private Path jdField_c_of_type_AndroidGraphicsPath;
  private RectF jdField_c_of_type_AndroidGraphicsRectF;
  public String c;
  public float d;
  public int d;
  public long d;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private RectF jdField_d_of_type_AndroidGraphicsRectF;
  public float e;
  public int e;
  public long e;
  private Paint e;
  public float f;
  public int f;
  private float g;
  public int g;
  private float h = 8.0F;
  private float i;
  private float j = 5.0F;
  private float k = 4.0F;
  private float l = 10.0F;
  private float m = 10.0F;
  private float n = 16.0F;
  private float o = 1.0F;
  private float p = 14.0F;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private float v;
  private float w;
  private float x;
  private float y;
  private float z = -1.0F;
  
  public MessageProgressView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaLangString = "MessageProgressView";
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_g_of_type_Float = 14.0F;
    this.jdField_c_of_type_Float = Math.abs(this.i - this.m);
    this.jdField_b_of_type_Long = 534L;
    this.jdField_c_of_type_Long = 400L;
    this.jdField_d_of_type_Long = 767L;
    this.jdField_f_of_type_Int = 2130706432;
    this.jdField_e_of_type_Long = 667L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_f_of_type_Float = 23.0F;
    c();
  }
  
  public MessageProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_JavaLangString = "MessageProgressView";
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_g_of_type_Float = 14.0F;
    this.jdField_c_of_type_Float = Math.abs(this.i - this.m);
    this.jdField_b_of_type_Long = 534L;
    this.jdField_c_of_type_Long = 400L;
    this.jdField_d_of_type_Long = 767L;
    this.jdField_f_of_type_Int = 2130706432;
    this.jdField_e_of_type_Long = 667L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_f_of_type_Float = 23.0F;
    c();
  }
  
  public MessageProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_JavaLangString = "MessageProgressView";
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_g_of_type_Float = 14.0F;
    this.jdField_c_of_type_Float = Math.abs(this.i - this.m);
    this.jdField_b_of_type_Long = 534L;
    this.jdField_c_of_type_Long = 400L;
    this.jdField_d_of_type_Long = 767L;
    this.jdField_f_of_type_Int = 2130706432;
    this.jdField_e_of_type_Long = 667L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_f_of_type_Float = 23.0F;
    c();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat3 < paramFloat1) || (paramFloat3 > paramFloat2)) {}
    for (;;)
    {
      return paramFloat3;
      paramFloat2 -= paramFloat1;
      try
      {
        float f1 = new BigDecimal((paramFloat3 - paramFloat1) / paramFloat2).setScale(3, 4).floatValue();
        f1 = this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator.getInterpolation(f1);
        if ((f1 >= 0.0F) && (f1 <= 1.0F)) {
          return paramFloat2 * f1 + paramFloat1;
        }
      }
      catch (Exception localException) {}
    }
    return paramFloat3;
  }
  
  private int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(Canvas paramCanvas, Path paramPath1, Path paramPath2)
  {
    if (this.jdField_e_of_type_Int < 100)
    {
      this.jdField_e_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_e_of_type_AndroidGraphicsPaint);
      return;
    }
    float f1 = (float)Math.sqrt(getWidth() * getWidth() + getHeight() * getHeight());
    float f2 = (float)this.jdField_a_of_type_Long / (float)this.jdField_b_of_type_Long * f1;
    this.q = a(0.0F, f1, f2);
    this.jdField_c_of_type_AndroidGraphicsPath.reset();
    this.jdField_c_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f2, Path.Direction.CW);
    this.jdField_c_of_type_AndroidGraphicsPath.close();
    int i1 = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    paramCanvas.clipPath(this.jdField_c_of_type_AndroidGraphicsPath, Region.Op.DIFFERENCE);
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_e_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i1);
  }
  
  private void h(Canvas paramCanvas)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i1, i2);
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      this.jdField_b_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      this.jdField_b_of_type_AndroidGraphicsPath.close();
      a(paramCanvas, this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_c_of_type_AndroidGraphicsPath);
      return;
    }
    Resources localResources = this.jdField_a_of_type_AndroidContentResResources;
    label113:
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i1 - this.jdField_d_of_type_Float, i2);
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      f1 = a(this.j, localResources);
      if (!this.jdField_a_of_type_Boolean) {
        break label350;
      }
      this.jdField_b_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      f2 = i1 - a(this.jdField_g_of_type_Float, localResources);
      f3 = a(this.h, localResources);
      this.jdField_b_of_type_AndroidGraphicsPath.moveTo(f2, f3);
      f2 = i1;
      f3 = this.i;
      f4 = i1 - a(this.k, localResources);
      float f5 = a(this.l, localResources);
      this.jdField_b_of_type_AndroidGraphicsPath.quadTo(f4, f5, f2 - f3, f1);
      f1 = i1 - a(this.m, localResources);
      f2 = a(this.n, localResources);
      f3 = i1 - a(this.o, localResources);
      f4 = a(this.p, localResources);
      this.jdField_b_of_type_AndroidGraphicsPath.quadTo(f3, f4, f1, f2);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsPath.close();
      break;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_d_of_type_Float, 0.0F, i1, i2);
      break label113;
      label350:
      this.jdField_b_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CCW);
      f2 = a(this.jdField_g_of_type_Float, localResources);
      f3 = a(this.h, localResources);
      this.jdField_b_of_type_AndroidGraphicsPath.moveTo(f2, f3);
      f2 = this.i;
      f3 = a(this.k, localResources);
      f4 = a(this.l, localResources);
      this.jdField_b_of_type_AndroidGraphicsPath.quadTo(f3, f4, f2, f1);
      f1 = a(this.m, localResources);
      f2 = a(this.n, localResources);
      f3 = a(this.o, localResources);
      f4 = a(this.p, localResources);
      this.jdField_b_of_type_AndroidGraphicsPath.quadTo(f3, f4, f1, f2);
    }
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_e_of_type_Int < 0) {}
    while (this.jdField_e_of_type_Int >= 100) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_Float - this.r, this.jdField_b_of_type_Float - this.r, this.jdField_a_of_type_Float + this.r, this.jdField_b_of_type_Float + this.r);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    Paint.FontMetrics localFontMetrics = this.jdField_b_of_type_AndroidGraphicsPaint.getFontMetrics();
    float f1 = localFontMetrics.top;
    float f2 = localFontMetrics.bottom;
    int i1 = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.centerY() - f1 / 2.0F - f2 / 2.0F);
    paramCanvas.drawText(this.jdField_e_of_type_Int + "%", this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), i1, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void a(Canvas paramCanvas, float paramFloat)
  {
    if (this.jdField_e_of_type_Int < 0) {
      super.draw(paramCanvas);
    }
    while (this.jdField_e_of_type_Int >= 100) {
      return;
    }
    float f1 = (this.t + this.s) / 2.0F;
    float f2 = this.r + f1;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
    this.jdField_d_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_Float - f2, this.jdField_b_of_type_Float - f2, this.jdField_a_of_type_Float + f2, f2 + this.jdField_b_of_type_Float);
    paramCanvas.drawArc(this.jdField_d_of_type_AndroidGraphicsRectF, -90.0F, paramFloat * 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void a(Canvas paramCanvas, String paramString)
  {
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_Float - this.r, this.jdField_b_of_type_Float - this.r, this.jdField_a_of_type_Float + this.r, this.jdField_b_of_type_Float + this.r);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(a(10.0F, getResources()));
    Paint.FontMetrics localFontMetrics = this.jdField_b_of_type_AndroidGraphicsPaint.getFontMetrics();
    float f1 = localFontMetrics.top;
    float f2 = localFontMetrics.bottom;
    int i1 = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.centerY() - f1 / 2.0F - f2 / 2.0F);
    paramCanvas.drawText(paramString, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), i1, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void a(String paramString)
  {
    paramString = bhfg.a().a(paramString);
    if (paramString != null) {
      paramString.a(this);
    }
  }
  
  public boolean a(String paramString)
  {
    return bhfg.a().a(paramString) != null;
  }
  
  protected void b(Canvas paramCanvas)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if ((i1 <= 0) || (i2 <= 0)) {
      super.draw(paramCanvas);
    }
    while (this.jdField_e_of_type_Int < 0) {
      return;
    }
    h(paramCanvas);
  }
  
  public void b(String paramString)
  {
    bhfg.a().a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MessageProgressView", 2, " stopAnim  key=" + paramString);
    }
  }
  
  @TargetApi(11)
  public void c()
  {
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    this.r = a(22.0F, getResources());
    this.t = a(2.5F, getResources());
    this.s = a(5.0F, getResources());
    this.u = a(5.0F, getResources());
    this.v = a(2.5F, getResources());
    this.jdField_a_of_type_Int = a(16.0F, getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_ArrayOfFloat = new float[8];
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_d_of_type_Float = a(this.jdField_c_of_type_Float, getResources());
    this.jdField_e_of_type_Float = a(70.0F, getResources());
    setLayerType(1, null);
  }
  
  protected void c(Canvas paramCanvas)
  {
    if (this.jdField_e_of_type_Int < 0) {}
    while (this.jdField_e_of_type_Int >= 100) {
      return;
    }
    this.y = ((float)this.jdField_a_of_type_Long / (float)this.jdField_e_of_type_Long * (this.u - this.v) + this.v);
    this.x = ((float)this.jdField_a_of_type_Long / (float)this.jdField_e_of_type_Long * (this.s - this.t) + this.t);
    float f1 = a(this.v, this.u, this.y);
    float f2 = a(this.t, this.s, this.x);
    float f3 = this.r;
    this.w = (f2 / 2.0F + f3);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
    try
    {
      BlurMaskFilter localBlurMaskFilter = new BlurMaskFilter(f1, BlurMaskFilter.Blur.SOLID);
      if (localBlurMaskFilter != null) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(localBlurMaskFilter);
      }
      paramCanvas.drawCircle(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.w, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageProgressView", 2, "create BlurMaskFilter exp:" + localException.getMessage());
        }
        Object localObject = null;
      }
    }
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Float = (getWidth() / 2.0F - this.jdField_d_of_type_Float / 2.0F);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Float = (getHeight() / 2);
      if (Math.min(getWidth(), getHeight()) < this.jdField_e_of_type_Float)
      {
        this.r = a(10.0F, getResources());
        this.t = a(1.25F, getResources());
        this.s = a(2.5F, getResources());
        this.u = a(4.0F, getResources());
        this.v = a(2.0F, getResources());
        this.jdField_a_of_type_Int = a(9.0F, getResources());
        if (this.z > 0.0F) {
          this.r = this.z;
        }
      }
      return;
      this.jdField_a_of_type_Float = (getWidth() / 2.0F + this.jdField_d_of_type_Float / 2.0F);
      continue;
      this.jdField_a_of_type_Float = (getWidth() / 2);
    }
  }
  
  protected void d(Canvas paramCanvas)
  {
    if ((this.jdField_e_of_type_Int == 100) && (this.jdField_g_of_type_Int == 1) && (this.jdField_a_of_type_Long >= this.jdField_c_of_type_Long) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      this.A = (((float)this.jdField_a_of_type_Long - (float)this.jdField_c_of_type_Long) / (float)(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long) * 360.0F);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.s);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_Float - this.r, this.jdField_b_of_type_Float - this.r, this.jdField_a_of_type_Float + this.r, this.jdField_b_of_type_Float + this.r);
      paramCanvas.drawArc(this.jdField_c_of_type_AndroidGraphicsRectF, -90.0F, -this.A, false, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void e(Canvas paramCanvas)
  {
    if (this.jdField_e_of_type_Int == 100)
    {
      if (this.jdField_g_of_type_Int == 1)
      {
        float f1 = this.r * 2.0F / 3.0F;
        float f2 = (float)Math.sqrt(5.0F * f1 * f1 / 4.0F);
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Float - f1 / 2.0F + 5.0F, this.jdField_b_of_type_Float - f2 / 2.0F);
        Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        float f3 = this.jdField_a_of_type_Float;
        float f4 = f1 / 2.0F;
        float f5 = this.jdField_b_of_type_Float;
        localPath.lineTo(f3 - f4 + 5.0F, f2 / 2.0F + f5);
        localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        f2 = this.jdField_a_of_type_Float;
        localPath.lineTo(f1 / 2.0F + f2 + 5.0F, this.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsPath.close();
        if ((this.jdField_a_of_type_Long >= this.jdField_c_of_type_Long) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
        {
          this.B = ((1.0F - ((float)this.jdField_a_of_type_Long - (float)this.jdField_c_of_type_Long) / (float)(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long)) * this.jdField_f_of_type_Float);
          this.C = (((float)this.jdField_a_of_type_Long - (float)this.jdField_c_of_type_Long) / (float)(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long) * 1.0F);
          paramCanvas.save();
          paramCanvas.rotate(this.B, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
          paramCanvas.scale(this.C, this.C, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_d_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
        }
      }
      if (this.jdField_a_of_type_Long >= this.jdField_d_of_type_Long)
      {
        if (this.jdField_g_of_type_Int != 1) {
          break label321;
        }
        setDrawStatus(2);
      }
    }
    label321:
    while (this.jdField_g_of_type_Int != 2) {
      return;
    }
    setDrawStatus(3);
    setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void f(Canvas paramCanvas)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.s);
    this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_Float - this.r, this.jdField_b_of_type_Float - this.r, this.jdField_a_of_type_Float + this.r, this.jdField_b_of_type_Float + this.r);
    paramCanvas.drawArc(this.jdField_c_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.jdField_c_of_type_AndroidGraphicsPaint);
    float f1 = this.r * 2.0F / 3.0F;
    float f2 = (float)Math.sqrt(5.0F * f1 * f1 / 4.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Float - f1 / 2.0F + 5.0F, this.jdField_b_of_type_Float - f2 / 2.0F);
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f3 = this.jdField_a_of_type_Float;
    float f4 = f1 / 2.0F;
    float f5 = this.jdField_b_of_type_Float;
    localPath.lineTo(f3 - f4 + 5.0F, f2 / 2.0F + f5);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    f2 = this.jdField_a_of_type_Float;
    localPath.lineTo(f1 / 2.0F + f2 + 5.0F, this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_d_of_type_AndroidGraphicsPaint);
  }
  
  public void g(Canvas paramCanvas)
  {
    int i1;
    float f1;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, i1, i1);
      if (!this.jdField_b_of_type_Boolean) {
        break label114;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label94;
      }
      f1 = (getWidth() - i1) / 2.0F - this.jdField_d_of_type_Float / 2.0F;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.offset((int)f1, (getHeight() - i1) / 2);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      label94:
      f1 = (getWidth() - i1) / 2.0F + this.jdField_d_of_type_Float / 2.0F;
      continue;
      label114:
      f1 = (getWidth() - i1) / 2.0F;
    }
  }
  
  @TargetApi(11)
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_d_of_type_Int == 1)
    {
      d();
      b(paramCanvas);
      c(paramCanvas);
      if (this.jdField_c_of_type_JavaLangString != null)
      {
        a(paramCanvas, this.jdField_c_of_type_JavaLangString);
        d(paramCanvas);
        e(paramCanvas);
      }
    }
    do
    {
      return;
      a(paramCanvas);
      break;
      if (this.jdField_d_of_type_Int == 2)
      {
        d();
        f(paramCanvas);
        return;
      }
    } while (this.jdField_d_of_type_Int != 3);
    d();
    g(paramCanvas);
  }
  
  public void setAnimProgress(int paramInt, String paramString)
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_e_of_type_Int = paramInt;
    MessageProgressView.RefreshProgressRunnable localRefreshProgressRunnable;
    if (this.jdField_d_of_type_Int == 1)
    {
      localRefreshProgressRunnable = bhfg.a().a(paramString);
      if (localRefreshProgressRunnable != null) {
        break label96;
      }
      localRefreshProgressRunnable = new MessageProgressView.RefreshProgressRunnable(this, paramString);
      bhfg.a().a(paramString, localRefreshProgressRunnable);
      ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
      if (QLog.isColorLevel()) {
        QLog.d("MessageProgressView", 2, " setAnimProgress new AnimRunnable key=" + paramString + " progress=" + paramInt);
      }
    }
    return;
    label96:
    localRefreshProgressRunnable.a(this);
  }
  
  public void setAnimProgress(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_Int = 0;
    MessageProgressView.RefreshProgressRunnable localRefreshProgressRunnable;
    if (this.jdField_d_of_type_Int == 1)
    {
      localRefreshProgressRunnable = bhfg.a().a(paramString2);
      if (localRefreshProgressRunnable != null) {
        break label96;
      }
      localRefreshProgressRunnable = new MessageProgressView.RefreshProgressRunnable(this, paramString2);
      bhfg.a().a(paramString2, localRefreshProgressRunnable);
      ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
      if (QLog.isColorLevel()) {
        QLog.d("MessageProgressView", 2, " setAnimProgress new AnimRunnable key=" + paramString2 + " progress=" + paramString1);
      }
    }
    return;
    label96:
    localRefreshProgressRunnable.a(this);
  }
  
  public void setAnimRunnableListener(bipw parambipw)
  {
    this.jdField_a_of_type_Bipw = parambipw;
  }
  
  public void setBreathingCircleRadius(float paramFloat)
  {
    this.z = a(paramFloat, getResources());
  }
  
  public void setCornerDirection(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setCustomSize(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.r = a(15.0F, getResources());
    this.t = a(2.0F, getResources());
    this.s = a(4.0F, getResources());
    this.u = a(5.0F, getResources());
    this.v = a(2.5F, getResources());
    this.jdField_a_of_type_Int = a(13.0F, getResources());
  }
  
  public void setDisplayInTextView(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setDrawFinishDefault(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_g_of_type_Int = 1;
      return;
    }
    this.jdField_g_of_type_Int = 0;
  }
  
  public void setDrawFinishDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.jdField_g_of_type_Int = 2;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      return;
    }
    this.jdField_g_of_type_Int = 0;
  }
  
  public void setDrawFinishResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.jdField_g_of_type_Int = 2;
      }
    }
    else
    {
      return;
    }
    this.jdField_g_of_type_Int = 0;
  }
  
  public void setDrawStatus(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (paramInt != 1) {
      invalidate();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    invalidate();
  }
  
  public void setImageResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setProgressBackgroudColor(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setRadius(float paramFloat, boolean paramBoolean)
  {
    float f1 = paramFloat;
    if (paramBoolean) {
      f1 = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    }
    if (this.jdField_a_of_type_ArrayOfFloat != null) {
      Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, f1);
    }
  }
  
  public void setSharpCornerCor(float[] paramArrayOfFloat)
  {
    this.jdField_g_of_type_Float = paramArrayOfFloat[0];
    this.h = paramArrayOfFloat[1];
    this.i = paramArrayOfFloat[2];
    this.j = paramArrayOfFloat[3];
    this.k = paramArrayOfFloat[4];
    this.l = paramArrayOfFloat[5];
    this.m = paramArrayOfFloat[6];
    this.n = paramArrayOfFloat[7];
    this.o = paramArrayOfFloat[8];
    this.p = paramArrayOfFloat[9];
    this.jdField_c_of_type_Float = Math.abs(this.i - this.m);
    this.jdField_d_of_type_Float = a(this.jdField_c_of_type_Float, getResources());
  }
  
  public void setShowCorner(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MessageProgressView
 * JD-Core Version:    0.7.0.1
 */