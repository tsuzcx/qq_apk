package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class QimMusicSeekView
  extends View
  implements View.OnTouchListener
{
  protected static final int a;
  protected static final int[] a;
  protected static int b;
  protected static int[] b;
  protected static int c;
  protected static int d;
  float a;
  protected Paint a;
  protected Rect a;
  protected QimMusicSeekView.SeekListener a;
  protected boolean a;
  protected Paint b;
  protected Paint c;
  protected Paint d;
  protected int e;
  protected Paint e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 18, 14, 9, 12, 14, 18 };
    jdField_a_of_type_Int = jdField_a_of_type_ArrayOfInt.length;
    jdField_b_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
  }
  
  public QimMusicSeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 0.0F;
    this.p = ((int)DisplayUtils.a(paramContext, 8.0F));
    this.n = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.o = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.r = ((int)DisplayUtils.a(paramContext, 3.0F));
    jdField_b_of_type_Int = (int)DisplayUtils.a(paramContext, 4.0F);
    jdField_d_of_type_Int = (int)DisplayUtils.a(paramContext, 50.0F);
    jdField_c_of_type_Int = (int)DisplayUtils.a(paramContext, 36.0F);
    int i1 = 0;
    while (i1 < jdField_a_of_type_Int)
    {
      jdField_b_of_type_ArrayOfInt[i1] = ((int)DisplayUtils.a(paramContext, jdField_a_of_type_ArrayOfInt[i1]));
      i1 += 1;
    }
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131493235));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131493442));
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131492904));
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131493242));
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_e_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    super.setOnTouchListener(this);
  }
  
  public void a(int paramInt)
  {
    this.i = ((int)(paramInt / 1000 * (jdField_b_of_type_Int + this.n) * 2.5F));
    setPlayedPosition(-1);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Paint paramPaint)
  {
    RectF localRectF = new RectF();
    localRectF.left = paramInt1;
    localRectF.top = paramInt2;
    localRectF.bottom = paramInt4;
    localRectF.right = paramInt3;
    paramCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, paramPaint);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    Rect localRect = new Rect();
    localRect.left = paramInt1;
    localRect.top = paramInt2;
    localRect.bottom = paramInt4;
    localRect.right = paramInt3;
    paramCanvas.drawRect(localRect, paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int i1 = 0;
    int i2;
    label112:
    int i3;
    label301:
    int i4;
    int i5;
    if (i1 < this.f)
    {
      i2 = this.k - this.i + (i1 + 1) * jdField_b_of_type_Int + this.n * i1;
      if ((i2 <= this.k + this.g) || (this.i != this.h - this.g)) {}
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left - this.p, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right + this.p, this.jdField_a_of_type_AndroidGraphicsRect.bottom, 10.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_d_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top + this.o, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.o, this.jdField_d_of_type_AndroidGraphicsPaint);
      this.jdField_d_of_type_AndroidGraphicsPaint.setXfermode(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      i2 = 0;
      i1 = -1;
      if (i2 < this.f)
      {
        i3 = this.k;
        i4 = this.i;
        i5 = jdField_b_of_type_Int;
        i5 = this.n * i2 + (i3 - i4 + (i2 + 1) * i5);
        if ((i5 <= this.k + this.g) || (this.i != this.h - this.g)) {
          break label491;
        }
      }
    }
    Paint localPaint;
    label491:
    do
    {
      if (QLog.isColorLevel()) {}
      return;
      if (i2 < 0) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (i2 > this.l) {
          break label112;
        }
        localPaint = this.jdField_c_of_type_AndroidGraphicsPaint;
        if ((this.jdField_a_of_type_Boolean) || (i2 <= this.jdField_a_of_type_AndroidGraphicsRect.left - this.n) || (i2 >= this.jdField_a_of_type_AndroidGraphicsRect.right))
        {
          i3 = jdField_b_of_type_ArrayOfInt[(i1 % jdField_a_of_type_Int)];
          i4 = (this.m - i3) / 2;
          a(paramCanvas, i2, i4, i2 + this.n, i4 + i3, 5.0F, localPaint);
        }
      }
      if (i5 < 0)
      {
        i2 += 1;
        break label301;
      }
    } while (i5 > this.l);
    if ((!this.jdField_a_of_type_Boolean) && (i5 > this.jdField_a_of_type_AndroidGraphicsRect.left - this.n) && (i5 < this.jdField_a_of_type_AndroidGraphicsRect.right))
    {
      i3 = this.n;
      if ((i5 >= this.jdField_a_of_type_AndroidGraphicsRect.left) || (this.n + i5 <= this.jdField_a_of_type_AndroidGraphicsRect.left)) {
        break label836;
      }
      i4 = this.jdField_a_of_type_AndroidGraphicsRect.left;
      i3 = this.n + i5;
    }
    for (;;)
    {
      if ((i5 < this.jdField_a_of_type_AndroidGraphicsRect.right) && (this.n + i5 > this.jdField_a_of_type_AndroidGraphicsRect.right)) {
        i3 = this.jdField_a_of_type_AndroidGraphicsRect.right;
      }
      for (;;)
      {
        if (i1 == -1) {
          i1 = i2;
        }
        for (;;)
        {
          if ((i2 >= i1) && (i2 < this.j + i1)) {}
          for (localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;; localPaint = this.jdField_a_of_type_AndroidGraphicsPaint)
          {
            i4 = jdField_b_of_type_ArrayOfInt[(i2 % jdField_a_of_type_Int)];
            int i6 = (this.m - i4) / 2;
            a(paramCanvas, i5, i6, i3, i6 + i4, 5.0F, localPaint);
            break;
          }
          if ((this.jdField_a_of_type_Boolean) && (i5 > this.jdField_a_of_type_AndroidGraphicsRect.left - this.n) && (i5 < this.jdField_a_of_type_AndroidGraphicsRect.right))
          {
            if (i1 == -1) {
              i1 = i2;
            }
            for (;;)
            {
              localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
              i3 = jdField_b_of_type_ArrayOfInt[(i2 % jdField_a_of_type_Int)];
              i4 = (this.m - i3) / 2;
              a(paramCanvas, i5, i4, i5 + this.n, i4 + i3, 5.0F, localPaint);
              break;
            }
          }
          break;
        }
        i5 = i4;
      }
      label836:
      i3 += i5;
      i4 = i5;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.l = super.getMeasuredWidth();
    this.m = (jdField_d_of_type_Int + super.getPaddingTop() + super.getPaddingBottom());
    setMeasuredDimension(this.l, this.m);
    this.k = ((this.l - this.g) / 2);
    paramInt1 = (this.m - jdField_d_of_type_Int) / 2;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.k, paramInt1, this.k + this.g, jdField_d_of_type_Int + paramInt1);
    if (this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView$SeekListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView$SeekListener.a(this.k, this.g);
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onMeasure() mViewWidth: " + this.l + ", mViewHeight = " + this.m + ", mVideoViewOffsetX = " + this.k + ", mMusicMaxWidth = " + this.h);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool1 = false;
      label35:
      float f1;
      do
      {
        return bool1;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        if (this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView$SeekListener == null) {
          break;
        }
        this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView$SeekListener.a(this.h, this.g, this.i);
        break;
        this.jdField_a_of_type_Boolean = true;
        f1 = paramMotionEvent.getX();
        bool1 = bool2;
      } while (Math.abs(f1 - this.jdField_a_of_type_Float) < 3.0F);
      float f2 = (this.jdField_a_of_type_Float - f1) / (jdField_b_of_type_Int + this.n);
      int i1 = Math.round(Math.abs(f2));
      if ((f2 > 0.0F) && (i1 >= 1)) {}
      for (this.i += (jdField_b_of_type_Int + this.n) * i1;; this.i -= (jdField_b_of_type_Int + this.n) * i1) {
        do
        {
          bool1 = bool2;
          if (i1 == 0) {
            break label35;
          }
          if (this.i <= 0) {
            this.i = 0;
          }
          if (this.i >= this.h - this.g) {
            this.i = (this.h - this.g);
          }
          super.invalidate();
          if (this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView$SeekListener != null) {
            this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView$SeekListener.b(this.h, this.g, this.i);
          }
          this.jdField_a_of_type_Float = f1;
          break;
        } while ((f2 >= 0.0F) || (i1 < 1));
      }
      this.jdField_a_of_type_Boolean = false;
      super.invalidate();
      if (this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView$SeekListener != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView$SeekListener.c(this.h, this.g, this.i);
      }
    }
  }
  
  public void setDurations(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = ((int)(paramInt1 * 2.5F));
    this.f = ((int)(paramInt2 * 2.5F));
    this.g = (jdField_b_of_type_Int * this.jdField_e_of_type_Int + (this.jdField_e_of_type_Int - 1) * this.n);
    this.h = (jdField_b_of_type_Int * this.f + (this.f - 1) * this.n);
  }
  
  public void setOnSeekListener(QimMusicSeekView.SeekListener paramSeekListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView$SeekListener = paramSeekListener;
  }
  
  public void setPlayedPosition(int paramInt)
  {
    this.j = paramInt;
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QimMusicSeekView
 * JD-Core Version:    0.7.0.1
 */