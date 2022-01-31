package com.tencent.mobileqq.profile.view;

import agef;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class ShimmerLinearLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int c;
  private int d;
  private int e;
  
  public ShimmerLinearLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ShimmerLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShimmerLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
  }
  
  private ValueAnimator a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      if (!paramBoolean) {
        return this.jdField_a_of_type_AndroidAnimationValueAnimator;
      }
      QLog.i("ShimmerLinearLayout", 1, "getShimmerAnimation animator remove");
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    int j = getWidth();
    int m = getHeight();
    int k;
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      m = 0;
      j = 0;
      k = 0;
      i = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F + this.jdField_b_of_type_Int / this.c });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.c + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new agef(this, i, j, k, m));
      return this.jdField_a_of_type_AndroidAnimationValueAnimator;
      i = -this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      m = 0;
      k = 0;
      continue;
      k = -this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      j = 0;
      i = 0;
    }
  }
  
  private Bitmap a()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(getWidth(), getHeight(), true);
    }
    return this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!paramBoolean) {}
      System.gc();
      return a(paramInt1, paramInt2, false);
    }
    catch (Exception localException)
    {
      QLog.d("ShimmerLinearLayout", 1, localException.getMessage());
    }
    return localObject;
    return null;
  }
  
  private void a(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() != getWidth()) {
      localBitmap = b();
    }
    paramCanvas.clipRect(this.d, this.e, this.d + localBitmap.getWidth(), this.e + localBitmap.getHeight());
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawBitmap(localBitmap, this.d, this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private boolean a(Canvas paramCanvas)
  {
    Bitmap localBitmap = a();
    if ((localBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return false;
    }
    super.dispatchDraw(paramCanvas);
    a(new Canvas(localBitmap));
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    return true;
  }
  
  private Bitmap b()
  {
    int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    int k = getWidth() * j / i;
    Bitmap localBitmap = a(getWidth(), k, true);
    if (localBitmap != null)
    {
      new Canvas(localBitmap).drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, new Rect(0, 0, i, j), new Rect(0, 0, getWidth(), k), null);
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
      this.jdField_a_of_type_AndroidAnimationValueAnimator = a(true);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShimmerLinearLayout", 2, "startShimmer mMaskBitmap = null");
      }
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = a(false);
    if (!this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.d == paramInt1) && (this.e == paramInt2)) {
      return;
    }
    this.d = paramInt1;
    this.e = paramInt2;
    invalidate();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShimmerLinearLayout", 2, "stopShimmer mMaskBitmap = null");
      }
      return;
    }
    Bitmap localBitmap = a();
    if (localBitmap != null) {
      new Canvas(localBitmap).drawColor(0, PorterDuff.Mode.CLEAR);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = a(false);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      QLog.i("ShimmerLinearLayout", 1, "ShimmerLinearLayout.onDestroy");
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_Boolean) || (getWidth() <= 0) || (getHeight() <= 0))
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    a(paramCanvas);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QLog.i("ShimmerLinearLayout", 1, "ShimmerLinearLayout.onDetachedFromWindow()");
    c();
  }
  
  public void setMask(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ShimmerLinearLayout
 * JD-Core Version:    0.7.0.1
 */