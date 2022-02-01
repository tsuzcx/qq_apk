package com.tencent.mobileqq.now.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.R.styleable;

public class NiceImageView
  extends ImageView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int = -1;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private int c;
  private int d = -1;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public NiceImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NiceImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NiceImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int[] arrayOfInt = R.styleable.NiceImageView;
    paramInt = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, 0, 0);
    while (paramInt < paramContext.getIndexCount())
    {
      int m = paramContext.getIndex(paramInt);
      if (m == 10) {
        this.jdField_b_of_type_Boolean = paramContext.getBoolean(m, this.jdField_b_of_type_Boolean);
      } else if (m == 9) {
        this.jdField_a_of_type_Boolean = paramContext.getBoolean(m, this.jdField_a_of_type_Boolean);
      } else if (m == 1) {
        this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(m, this.jdField_a_of_type_Int);
      } else if (m == 0) {
        this.jdField_b_of_type_Int = paramContext.getColor(m, this.jdField_b_of_type_Int);
      } else if (m == 8) {
        this.c = paramContext.getDimensionPixelSize(m, this.c);
      } else if (m == 7) {
        this.d = paramContext.getColor(m, this.d);
      } else if (m == 4) {
        this.e = paramContext.getDimensionPixelSize(m, this.e);
      } else if (m == 5) {
        this.f = paramContext.getDimensionPixelSize(m, this.f);
      } else if (m == 6) {
        this.g = paramContext.getDimensionPixelSize(m, this.g);
      } else if (m == 2) {
        this.h = paramContext.getDimensionPixelSize(m, this.h);
      } else if (m == 3) {
        this.i = paramContext.getDimensionPixelSize(m, this.i);
      } else if (m == 11) {
        this.j = paramContext.getColor(m, this.j);
      }
      paramInt += 1;
    }
    paramContext.recycle();
    this.jdField_a_of_type_ArrayOfFloat = new float[8];
    this.jdField_b_of_type_ArrayOfFloat = new float[8];
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
      this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    }
    c();
    d();
  }
  
  private int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      int m = this.jdField_a_of_type_Int;
      localRectF.set(m / 2.0F, m / 2.0F, this.k - m / 2.0F, this.l - m / 2.0F);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  private void a(Canvas paramCanvas)
  {
    int m;
    if (this.jdField_a_of_type_Boolean)
    {
      m = this.jdField_a_of_type_Int;
      if (m > 0) {
        a(paramCanvas, m, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float - m / 2.0F);
      }
      m = this.c;
      if (m > 0) {
        a(paramCanvas, m, this.d, this.jdField_a_of_type_Float - this.jdField_a_of_type_Int - m / 2.0F);
      }
    }
    else
    {
      m = this.jdField_a_of_type_Int;
      if (m > 0) {
        a(paramCanvas, m, this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat);
      }
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat)
  {
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.k / 2.0F, this.l / 2.0F, paramFloat, Path.Direction.CCW);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, RectF paramRectF, float[] paramArrayOfFloat)
  {
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(paramRectF, paramArrayOfFloat, Path.Direction.CCW);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.e = 0;
    }
    c();
    a();
    invalidate();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Float = (Math.min(this.k, this.l) / 2.0F);
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      int m = this.k;
      float f1 = m / 2.0F;
      float f2 = this.jdField_a_of_type_Float;
      int n = this.l;
      localRectF.set(f1 - f2, n / 2.0F - f2, m / 2.0F + f2, n / 2.0F + f2);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.k, this.l);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int n = this.e;
    int m = 0;
    if (n > 0) {
      for (;;)
      {
        arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
        if (m >= arrayOfFloat.length) {
          break;
        }
        n = this.e;
        arrayOfFloat[m] = n;
        this.jdField_b_of_type_ArrayOfFloat[m] = (n - this.jdField_a_of_type_Int / 2.0F);
        m += 1;
      }
    }
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    int i2 = this.f;
    float f1 = i2;
    arrayOfFloat[1] = f1;
    arrayOfFloat[0] = f1;
    m = this.g;
    f1 = m;
    arrayOfFloat[3] = f1;
    arrayOfFloat[2] = f1;
    n = this.i;
    f1 = n;
    arrayOfFloat[5] = f1;
    arrayOfFloat[4] = f1;
    int i1 = this.h;
    f1 = i1;
    arrayOfFloat[7] = f1;
    arrayOfFloat[6] = f1;
    arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    f1 = i2;
    i2 = this.jdField_a_of_type_Int;
    f1 -= i2 / 2.0F;
    arrayOfFloat[1] = f1;
    arrayOfFloat[0] = f1;
    f1 = m - i2 / 2.0F;
    arrayOfFloat[3] = f1;
    arrayOfFloat[2] = f1;
    f1 = n - i2 / 2.0F;
    arrayOfFloat[5] = f1;
    arrayOfFloat[4] = f1;
    f1 = i1 - i2 / 2.0F;
    arrayOfFloat[7] = f1;
    arrayOfFloat[6] = f1;
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.c = 0;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(this.jdField_a_of_type_AndroidGraphicsRectF, null, 31);
    if (!this.jdField_b_of_type_Boolean)
    {
      m = this.k;
      int n = this.jdField_a_of_type_Int;
      int i1 = this.c;
      float f1 = (m - n * 2 - i1 * 2) * 1.0F / m;
      int i2 = this.l;
      paramCanvas.scale(f1, (i2 - n * 2 - i1 * 2) * 1.0F / i2, m / 2.0F, i2 / 2.0F);
    }
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.k / 2.0F, this.l / 2.0F, this.jdField_a_of_type_Float, Path.Direction.CCW);
    } else {
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CCW);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
    if (Build.VERSION.SDK_INT <= 27)
    {
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    else
    {
      this.jdField_b_of_type_AndroidGraphicsPath.addRect(this.jdField_a_of_type_AndroidGraphicsRectF, Path.Direction.CCW);
      this.jdField_b_of_type_AndroidGraphicsPath.op(this.jdField_a_of_type_AndroidGraphicsPath, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    int m = this.j;
    if (m != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(m);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restore();
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.k = paramInt1;
    this.l = paramInt2;
    a();
    b();
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_AndroidContentContext, paramInt);
    a(false);
  }
  
  public void setCornerBottomLeftRadius(int paramInt)
  {
    this.h = a(this.jdField_a_of_type_AndroidContentContext, paramInt);
    a(true);
  }
  
  public void setCornerBottomRightRadius(int paramInt)
  {
    this.i = a(this.jdField_a_of_type_AndroidContentContext, paramInt);
    a(true);
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.e = a(this.jdField_a_of_type_AndroidContentContext, paramInt);
    a(false);
  }
  
  public void setCornerTopLeftRadius(int paramInt)
  {
    this.f = a(this.jdField_a_of_type_AndroidContentContext, paramInt);
    a(true);
  }
  
  public void setCornerTopRightRadius(int paramInt)
  {
    this.g = a(this.jdField_a_of_type_AndroidContentContext, paramInt);
    a(true);
  }
  
  public void setInnerBorderColor(@ColorInt int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setInnerBorderWidth(int paramInt)
  {
    this.c = a(this.jdField_a_of_type_AndroidContentContext, paramInt);
    d();
    invalidate();
  }
  
  public void setMaskColor(@ColorInt int paramInt)
  {
    this.j = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.NiceImageView
 * JD-Core Version:    0.7.0.1
 */