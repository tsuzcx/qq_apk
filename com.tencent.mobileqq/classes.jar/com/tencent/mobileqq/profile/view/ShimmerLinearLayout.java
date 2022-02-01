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
  public Bitmap a;
  private ValueAnimator b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h = false;
  private Bitmap i;
  private Paint j = new Paint();
  
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
    this.j.setAntiAlias(true);
    this.j.setDither(true);
    this.j.setFilterBitmap(true);
    this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
  }
  
  private ValueAnimator a(boolean paramBoolean)
  {
    try
    {
      if (this.b != null)
      {
        if (!paramBoolean)
        {
          localObject1 = this.b;
          return localObject1;
        }
        QLog.i("ShimmerLinearLayout", 1, "getShimmerAnimation animator remove");
        this.b.removeAllUpdateListeners();
        this.b.cancel();
        this.b = null;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getShimmerAnimation recreate = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("call stack = ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(new Throwable()));
      QLog.i("ShimmerLinearLayout", 1, ((StringBuilder)localObject1).toString());
      m = getWidth();
      k = getHeight();
      n = this.c;
      if (n != 0)
      {
        if (n != 1)
        {
          k = 0;
          m = 0;
          break label286;
        }
        n = -this.a.getHeight();
        m = k;
        k = 0;
        i1 = 0;
      }
      else
      {
        k = -this.a.getWidth();
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int k;
        for (;;)
        {
          throw localObject2;
        }
        label286:
        int n = 0;
        int i2 = 0;
        int i1 = m;
        int m = i2;
      }
    }
    this.b = ValueAnimator.ofFloat(new float[] { 0.0F, this.d / this.e + 1.0F });
    this.b.setDuration(this.e + this.d);
    this.b.setRepeatMode(1);
    this.b.setRepeatCount(-1);
    this.b.addUpdateListener(new ShimmerLinearLayout.UpdateListener(this, k, n, i1, m, null));
    localObject1 = this.b;
    return localObject1;
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
  
  private boolean a(Canvas paramCanvas)
  {
    Bitmap localBitmap = d();
    if ((localBitmap != null) && (this.a != null))
    {
      super.dispatchDraw(paramCanvas);
      b(new Canvas(localBitmap));
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
      return true;
    }
    return false;
  }
  
  private void b(Canvas paramCanvas)
  {
    Bitmap localBitmap2 = this.a;
    if (localBitmap2 == null) {
      return;
    }
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2.getWidth() != getWidth()) {
      localBitmap1 = getMaskBitmap();
    }
    int k = this.f;
    paramCanvas.clipRect(k, this.g, localBitmap1.getWidth() + k, this.g + localBitmap1.getHeight());
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawBitmap(localBitmap1, this.f, this.g, this.j);
  }
  
  private Bitmap d()
  {
    if (this.i == null) {
      this.i = a(getWidth(), getHeight(), true);
    }
    return this.i;
  }
  
  private Bitmap getMaskBitmap()
  {
    int k = this.a.getWidth();
    int m = this.a.getHeight();
    int n = getWidth() * m / k;
    Bitmap localBitmap = a(getWidth(), n, true);
    if (localBitmap != null)
    {
      new Canvas(localBitmap).drawBitmap(this.a, new Rect(0, 0, k, m), new Rect(0, 0, getWidth(), n), null);
      this.a = localBitmap;
      this.b = a(true);
      this.b.start();
    }
    return this.a;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShimmerLinearLayout", 2, "startShimmer mMaskBitmap = null");
      }
      return;
    }
    this.b = a(false);
    if (!this.b.isRunning()) {
      this.b.start();
    }
    this.h = true;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if ((this.f == paramInt1) && (this.g == paramInt2)) {
      return;
    }
    this.f = paramInt1;
    this.g = paramInt2;
    invalidate();
  }
  
  public void b()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShimmerLinearLayout", 2, "stopShimmer mMaskBitmap = null");
      }
      return;
    }
    Bitmap localBitmap = d();
    if (localBitmap != null) {
      new Canvas(localBitmap).drawColor(0, PorterDuff.Mode.CLEAR);
    }
    this.b = a(false);
    this.b.cancel();
  }
  
  public void c()
  {
    if (this.b != null)
    {
      QLog.i("ShimmerLinearLayout", 1, "ShimmerLinearLayout.onDestroy");
      this.b.removeAllUpdateListeners();
      this.b.cancel();
    }
    this.b = null;
    this.h = false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.h) && (getWidth() > 0) && (getHeight() > 0))
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
    this.a = paramBitmap;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ShimmerLinearLayout
 * JD-Core Version:    0.7.0.1
 */