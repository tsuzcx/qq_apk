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
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class MovingView
  extends View
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  Handler jdField_a_of_type_AndroidOsHandler = new MovingView.1(this, Looper.getMainLooper());
  Scroller jdField_a_of_type_AndroidWidgetScroller;
  MovingView.MatrixParams jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams;
  Random jdField_a_of_type_JavaUtilRandom;
  boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  MovingView.MatrixParams jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  int f;
  int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l = 0;
  
  public MovingView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private Point a(int paramInt1, int paramInt2)
  {
    int m = this.jdField_a_of_type_JavaUtilRandom.nextInt(3);
    int n = this.g;
    Point localPoint;
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n == 3) {
            if (m == 0)
            {
              this.g = 1;
              localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
              localPoint.x = paramInt1;
              localPoint.y = 0;
            }
            else if (m == 1)
            {
              this.g = 0;
              localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
              localPoint.x = paramInt1;
              localPoint.y = paramInt2;
            }
            else if (m == 2)
            {
              this.g = 2;
              localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
              localPoint.x = 0;
              localPoint.y = paramInt2;
            }
          }
        }
        else if (m == 0)
        {
          this.g = 3;
          localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
          localPoint.x = 0;
          localPoint.y = (-paramInt2);
        }
        else if (m == 1)
        {
          this.g = 1;
          localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
          localPoint.x = paramInt1;
          localPoint.y = (-paramInt2);
        }
        else if (m == 2)
        {
          this.g = 0;
          localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
          localPoint.x = paramInt1;
          localPoint.y = 0;
        }
      }
      else if (m == 0)
      {
        this.g = 0;
        localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
        localPoint.x = 0;
        localPoint.y = paramInt2;
      }
      else if (m == 1)
      {
        this.g = 2;
        localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
        localPoint.x = (-paramInt1);
        localPoint.y = paramInt2;
      }
      else if (m == 2)
      {
        this.g = 3;
        localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
        localPoint.x = (-paramInt1);
        localPoint.y = 0;
      }
    }
    else if (m == 0)
    {
      this.g = 2;
      localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
      localPoint.x = (-paramInt1);
      localPoint.y = 0;
    }
    else if (m == 1)
    {
      this.g = 3;
      localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
      localPoint.x = (-paramInt1);
      localPoint.y = (-paramInt2);
    }
    else if (m == 2)
    {
      this.g = 1;
      localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
      localPoint.x = 0;
      localPoint.y = (-paramInt2);
    }
    return this.jdField_a_of_type_AndroidGraphicsPoint;
  }
  
  private void a(Bitmap paramBitmap, MovingView.MatrixParams paramMatrixParams)
  {
    float f3 = paramBitmap.getWidth();
    float f4 = paramBitmap.getHeight();
    float f1 = this.jdField_a_of_type_Float;
    float f5 = f1 / f3;
    float f2 = this.jdField_b_of_type_Float;
    float f6 = f2 / f4;
    if (f5 > f6) {
      f2 = f4 * f5;
    } else {
      f1 = f3 * f6;
    }
    paramMatrixParams.jdField_a_of_type_Float = (f1 / f3);
    paramMatrixParams.jdField_b_of_type_Float = (f2 / f4);
    paramMatrixParams.c = ((this.jdField_a_of_type_Float - f1) / 2.0F);
    paramMatrixParams.d = ((this.jdField_b_of_type_Float - f2) / 2.0F);
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
    if (paramInt1 <= 0) {
      paramInt1 = -paramInt1;
    }
    if (paramInt2 <= 0) {
      paramInt2 = -paramInt2;
    }
    if (paramInt1 <= paramInt2) {
      paramInt1 = paramInt2;
    }
    return (int)(paramInt1 * 54.700001F);
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "startTranslate");
    }
    int m = this.g;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m == 3)
          {
            this.jdField_a_of_type_Int = (-this.e);
            this.jdField_b_of_type_Int = (-this.f);
          }
        }
        else
        {
          this.jdField_a_of_type_Int = (-this.e);
          this.jdField_b_of_type_Int = 0;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Int = (-this.f);
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
    }
    Point localPoint = a(this.e, this.f);
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, localPoint.x, localPoint.y, a(localPoint.x, localPoint.y));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if (localBitmap == paramBitmap)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      else
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
        this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          if (this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams == null) {
            this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams = new MovingView.MatrixParams(this);
          }
          this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_a_of_type_Float;
          this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float;
          this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.c = this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.c;
          this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.d = this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.d;
        }
        if (this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams == null) {
          this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams = new MovingView.MatrixParams(this);
        }
        a(paramBitmap, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams);
      }
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
    super.onDraw(paramCanvas);
    int i1 = getVisibility();
    int n = 0;
    int m = 0;
    if (i1 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, getVisibility() != View.VISIBLE");
      }
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      return;
    }
    i1 = this.h;
    if (i1 != 0)
    {
      if ((i1 == 1) && (this.jdField_a_of_type_Long >= 0L))
      {
        float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.k;
        if (f1 >= 1.0D) {
          m = 1;
        }
        n = this.i;
        this.l = ((int)(n + (this.j - n) * f1));
      }
      else
      {
        m = 1;
      }
    }
    else
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.h = 1;
      m = n;
    }
    if (m != 0)
    {
      this.h = 2;
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.c + this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.d + this.jdField_b_of_type_Int);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, bitmap = null 1");
      }
      paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
      return;
    }
    m = this.l;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      boolean bool = this.jdField_c_of_type_Boolean;
      if (bool) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255 - m);
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_a_of_type_Float, this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.c + this.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.d + this.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (bool) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
      }
    }
    if (m > 0) {
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(m);
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.c + this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.d + this.jdField_b_of_type_Int);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("MovingView", 2, "onDraw, bitmap = null 2");
        }
        paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
      }
    }
    invalidate();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0)
    {
      b();
    }
    else if (paramInt == 0)
    {
      Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if (localBitmap != null) {
        a(localBitmap);
      } else if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "setVisibility, bitmap = null");
      }
    }
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.MovingView
 * JD-Core Version:    0.7.0.1
 */