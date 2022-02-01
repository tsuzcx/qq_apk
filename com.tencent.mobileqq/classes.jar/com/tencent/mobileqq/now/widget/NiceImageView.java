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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.NiceImageView, 0, 0);
    paramInt = m;
    if (paramInt < paramContext.getIndexCount())
    {
      m = paramContext.getIndex(paramInt);
      if (m == 10) {
        this.jdField_b_of_type_Boolean = paramContext.getBoolean(m, this.jdField_b_of_type_Boolean);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (m == 9) {
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
      }
    }
    paramContext.recycle();
    this.jdField_a_of_type_ArrayOfFloat = new float[8];
    this.jdField_b_of_type_ArrayOfFloat = new float[8];
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    if (Build.VERSION.SDK_INT <= 27) {
      this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
    for (;;)
    {
      c();
      d();
      return;
      this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
      this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    }
  }
  
  private int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_Int / 2.0F, this.jdField_a_of_type_Int / 2.0F, this.k - this.jdField_a_of_type_Int / 2.0F, this.l - this.jdField_a_of_type_Int / 2.0F);
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
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int > 0) {
        a(paramCanvas, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float - this.jdField_a_of_type_Int / 2.0F);
      }
      if (this.c > 0) {
        a(paramCanvas, this.c, this.d, this.jdField_a_of_type_Float - this.jdField_a_of_type_Int - this.c / 2.0F);
      }
    }
    while (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    a(paramCanvas, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat);
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
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.k / 2.0F - this.jdField_a_of_type_Float, this.l / 2.0F - this.jdField_a_of_type_Float, this.k / 2.0F + this.jdField_a_of_type_Float, this.l / 2.0F + this.jdField_a_of_type_Float);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.k, this.l);
    } while (!this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidGraphicsRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
  }
  
  private void c()
  {
    int m = 0;
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (this.e <= 0) {
        break;
      }
      while (m < this.jdField_a_of_type_ArrayOfFloat.length)
      {
        this.jdField_a_of_type_ArrayOfFloat[m] = this.e;
        this.jdField_b_of_type_ArrayOfFloat[m] = (this.e - this.jdField_a_of_type_Int / 2.0F);
        m += 1;
      }
    }
    float[] arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    float[] arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    float f1 = this.f;
    arrayOfFloat2[1] = f1;
    arrayOfFloat1[0] = f1;
    arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    f1 = this.g;
    arrayOfFloat2[3] = f1;
    arrayOfFloat1[2] = f1;
    arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    f1 = this.i;
    arrayOfFloat2[5] = f1;
    arrayOfFloat1[4] = f1;
    arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    f1 = this.h;
    arrayOfFloat2[7] = f1;
    arrayOfFloat1[6] = f1;
    arrayOfFloat1 = this.jdField_b_of_type_ArrayOfFloat;
    arrayOfFloat2 = this.jdField_b_of_type_ArrayOfFloat;
    f1 = this.f - this.jdField_a_of_type_Int / 2.0F;
    arrayOfFloat2[1] = f1;
    arrayOfFloat1[0] = f1;
    arrayOfFloat1 = this.jdField_b_of_type_ArrayOfFloat;
    arrayOfFloat2 = this.jdField_b_of_type_ArrayOfFloat;
    f1 = this.g - this.jdField_a_of_type_Int / 2.0F;
    arrayOfFloat2[3] = f1;
    arrayOfFloat1[2] = f1;
    arrayOfFloat1 = this.jdField_b_of_type_ArrayOfFloat;
    arrayOfFloat2 = this.jdField_b_of_type_ArrayOfFloat;
    f1 = this.i - this.jdField_a_of_type_Int / 2.0F;
    arrayOfFloat2[5] = f1;
    arrayOfFloat1[4] = f1;
    arrayOfFloat1 = this.jdField_b_of_type_ArrayOfFloat;
    arrayOfFloat2 = this.jdField_b_of_type_ArrayOfFloat;
    f1 = this.h - this.jdField_a_of_type_Int / 2.0F;
    arrayOfFloat2[7] = f1;
    arrayOfFloat1[6] = f1;
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
    if (!this.jdField_b_of_type_Boolean) {
      paramCanvas.scale((this.k - this.jdField_a_of_type_Int * 2 - this.c * 2) * 1.0F / this.k, (this.l - this.jdField_a_of_type_Int * 2 - this.c * 2) * 1.0F / this.l, this.k / 2.0F, this.l / 2.0F);
    }
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.k / 2.0F, this.l / 2.0F, this.jdField_a_of_type_Float, Path.Direction.CCW);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
      if (Build.VERSION.SDK_INT > 27) {
        break label265;
      }
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      if (this.j != 0)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      paramCanvas.restore();
      a(paramCanvas);
      return;
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CCW);
      break;
      label265:
      this.jdField_b_of_type_AndroidGraphicsPath.addRect(this.jdField_a_of_type_AndroidGraphicsRectF, Path.Direction.CCW);
      this.jdField_b_of_type_AndroidGraphicsPath.op(this.jdField_a_of_type_AndroidGraphicsPath, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.NiceImageView
 * JD-Core Version:    0.7.0.1
 */