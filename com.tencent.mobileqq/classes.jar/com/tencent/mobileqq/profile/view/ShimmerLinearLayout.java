package com.tencent.mobileqq.profile.view;

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
import android.util.Log;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class ShimmerLinearLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_a_of_type_Boolean = false;
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
    try
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        if (!paramBoolean)
        {
          localObject1 = this.jdField_a_of_type_AndroidAnimationValueAnimator;
          return localObject1;
        }
        QLog.i("ShimmerLinearLayout", 1, "getShimmerAnimation animator remove");
        this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getShimmerAnimation recreate = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("call stack = ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(new Throwable()));
      QLog.i("ShimmerLinearLayout", 1, ((StringBuilder)localObject1).toString());
      j = getWidth();
      i = getHeight();
      k = this.jdField_a_of_type_Int;
      if (k != 0)
      {
        if (k != 1)
        {
          i = 0;
          j = 0;
          break label286;
        }
        k = -this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        j = i;
        i = 0;
        m = 0;
      }
      else
      {
        i = -this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int i;
        for (;;)
        {
          throw localObject2;
        }
        label286:
        int k = 0;
        int n = 0;
        int m = j;
        int j = n;
      }
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, this.jdField_b_of_type_Int / this.c + 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.c + this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ShimmerLinearLayout.UpdateListener(this, i, k, m, j, null));
    localObject1 = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    return localObject1;
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
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (Exception localException)
    {
      QLog.d("ShimmerLinearLayout", 1, localException.getMessage());
      return null;
      if (paramBoolean)
      {
        System.gc();
        return a(paramInt1, paramInt2, false);
      }
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label24:
      break label24;
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap2 == null) {
      return;
    }
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2.getWidth() != getWidth()) {
      localBitmap1 = b();
    }
    int i = this.d;
    paramCanvas.clipRect(i, this.e, localBitmap1.getWidth() + i, this.e + localBitmap1.getHeight());
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawBitmap(localBitmap1, this.d, this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private boolean a(Canvas paramCanvas)
  {
    Bitmap localBitmap = a();
    if ((localBitmap != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      super.dispatchDraw(paramCanvas);
      a(new Canvas(localBitmap));
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
      return true;
    }
    return false;
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
  
  void a(int paramInt1, int paramInt2)
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
    if ((this.jdField_a_of_type_Boolean) && (getWidth() > 0) && (getHeight() > 0))
    {
      a(paramCanvas);
      return;
    }
    super.dispatchDraw(paramCanvas);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ShimmerLinearLayout
 * JD-Core Version:    0.7.0.1
 */