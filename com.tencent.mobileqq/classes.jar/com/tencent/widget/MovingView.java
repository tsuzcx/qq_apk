package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import bkmg;
import bkmh;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class MovingView
  extends View
{
  private float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  public Handler a;
  public Scroller a;
  bkmh jdField_a_of_type_Bkmh;
  Random jdField_a_of_type_JavaUtilRandom;
  public boolean a;
  private float jdField_b_of_type_Float;
  public int b;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  bkmh jdField_b_of_type_Bkmh;
  public boolean b;
  public int c;
  private boolean c;
  public int d;
  int e;
  int f;
  int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public MovingView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new bkmg(this, Looper.getMainLooper());
    c();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new bkmg(this, Looper.getMainLooper());
    c();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidOsHandler = new bkmg(this, Looper.getMainLooper());
    c();
  }
  
  private Point a(int paramInt1, int paramInt2)
  {
    int m = this.jdField_a_of_type_JavaUtilRandom.nextInt(3);
    switch (this.g)
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidGraphicsPoint;
      if (m == 0)
      {
        this.g = 2;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
        this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
      }
      else if (m == 1)
      {
        this.g = 3;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
        this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
      }
      else if (m == 2)
      {
        this.g = 1;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
        this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
        continue;
        if (m == 0)
        {
          this.g = 0;
          this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
          this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
        }
        else if (m == 1)
        {
          this.g = 2;
          this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
          this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
        }
        else if (m == 2)
        {
          this.g = 3;
          this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
          this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
          continue;
          if (m == 0)
          {
            this.g = 3;
            this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
            this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
          }
          else if (m == 1)
          {
            this.g = 1;
            this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
            this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
          }
          else if (m == 2)
          {
            this.g = 0;
            this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
            this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
            continue;
            if (m == 0)
            {
              this.g = 1;
              this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
              this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
            }
            else if (m == 1)
            {
              this.g = 0;
              this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
              this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
            }
            else if (m == 2)
            {
              this.g = 2;
              this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
              this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
            }
          }
        }
      }
    }
  }
  
  private void a(Bitmap paramBitmap, bkmh parambkmh)
  {
    float f3 = paramBitmap.getWidth();
    float f4 = paramBitmap.getHeight();
    float f1 = this.jdField_a_of_type_Float / f3;
    float f2 = this.jdField_b_of_type_Float / f4;
    if (f1 > f2) {
      f2 = this.jdField_a_of_type_Float;
    }
    for (f1 *= f4;; f1 = this.jdField_b_of_type_Float)
    {
      parambkmh.jdField_a_of_type_Float = (f2 / f3);
      parambkmh.jdField_b_of_type_Float = (f1 / f4);
      parambkmh.c = ((this.jdField_a_of_type_Float - f2) / 2.0F);
      parambkmh.d = ((this.jdField_b_of_type_Float - f1) / 2.0F);
      return;
      f2 *= f3;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext(), new LinearInterpolator());
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.g = 0;
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.h = 2;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        break label26;
      }
      label8:
      if (paramInt1 <= paramInt2) {
        break label32;
      }
    }
    for (;;)
    {
      return (int)(paramInt1 * 54.700001F);
      paramInt1 = -paramInt1;
      break;
      label26:
      paramInt2 = -paramInt2;
      break label8;
      label32:
      paramInt1 = paramInt2;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "startTranslate");
    }
    switch (this.g)
    {
    }
    for (;;)
    {
      Point localPoint = a(this.e, this.f);
      this.jdField_c_of_type_Int = 0;
      this.d = 0;
      this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, localPoint.x, localPoint.y, a(localPoint.x, localPoint.y));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = (-this.f);
      continue;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      continue;
      this.jdField_a_of_type_Int = (-this.e);
      this.jdField_b_of_type_Int = (-this.f);
      continue;
      this.jdField_a_of_type_Int = (-this.e);
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == paramBitmap) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      for (;;)
      {
        this.k = 1000;
        this.i = 0;
        this.j = 255;
        this.l = 0;
        this.jdField_c_of_type_Boolean = true;
        this.h = 0;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.jdField_a_of_type_Boolean = false;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
          }
        }
        invalidate();
        return;
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
        this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          if (this.jdField_b_of_type_Bkmh == null) {
            this.jdField_b_of_type_Bkmh = new bkmh(this);
          }
          this.jdField_b_of_type_Bkmh.jdField_a_of_type_Float = this.jdField_a_of_type_Bkmh.jdField_a_of_type_Float;
          this.jdField_b_of_type_Bkmh.jdField_b_of_type_Float = this.jdField_a_of_type_Bkmh.jdField_b_of_type_Float;
          this.jdField_b_of_type_Bkmh.c = this.jdField_a_of_type_Bkmh.c;
          this.jdField_b_of_type_Bkmh.d = this.jdField_a_of_type_Bkmh.d;
        }
        if (this.jdField_a_of_type_Bkmh == null) {
          this.jdField_a_of_type_Bkmh = new bkmh(this);
        }
        a(paramBitmap, this.jdField_a_of_type_Bkmh);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "startTranslate, bitmap = null");
    }
    clearAnimation();
    postInvalidate();
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "stopTranslate()");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int n = 1;
    int m = 1;
    super.onDraw(paramCanvas);
    if (getVisibility() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, getVisibility() != View.VISIBLE");
      }
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      return;
    }
    switch (this.h)
    {
    }
    while (m != 0)
    {
      this.h = 2;
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_Bkmh.jdField_a_of_type_Float, this.jdField_a_of_type_Bkmh.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_Bkmh.c + this.jdField_a_of_type_Int, this.jdField_a_of_type_Bkmh.d + this.jdField_b_of_type_Int);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        this.h = 1;
        m = 0;
        continue;
        if (this.jdField_a_of_type_Long >= 0L)
        {
          float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.k;
          if (f1 >= 1.0D) {}
          for (m = n;; m = 0)
          {
            this.l = ((int)(this.i + f1 * (this.j - this.i)));
            break;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("MovingView", 2, "onDraw, bitmap = null 1");
        }
        paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
        return;
      }
    }
    m = this.l;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      boolean bool = this.jdField_c_of_type_Boolean;
      if (bool) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255 - m);
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_b_of_type_Bkmh.jdField_a_of_type_Float, this.jdField_b_of_type_Bkmh.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_b_of_type_Bkmh.c + this.jdField_a_of_type_Int, this.jdField_b_of_type_Bkmh.d + this.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (bool) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
      }
    }
    if (m > 0)
    {
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label520;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(m);
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_Bkmh.jdField_a_of_type_Float, this.jdField_a_of_type_Bkmh.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_Bkmh.c + this.jdField_a_of_type_Int, this.jdField_a_of_type_Bkmh.d + this.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    }
    for (;;)
    {
      invalidate();
      return;
      label520:
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, bitmap = null 2");
      }
      paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      b();
    }
    for (;;)
    {
      postInvalidate();
      return;
      if (paramInt == 0) {
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
          a(this.jdField_b_of_type_AndroidGraphicsBitmap);
        } else if (QLog.isColorLevel()) {
          QLog.i("MovingView", 2, "setVisibility, bitmap = null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.MovingView
 * JD-Core Version:    0.7.0.1
 */