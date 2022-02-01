package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;

public class ImageAlphaSwitchView
  extends View
{
  public Transformation a = new Transformation();
  ValueAnimation<Float> b = null;
  float c = 0.0F;
  int d;
  int e;
  public Bitmap f;
  public Bitmap g;
  Paint h = new Paint();
  int i = 3;
  private Rect j = new Rect();
  
  public ImageAlphaSwitchView(Context paramContext)
  {
    super(paramContext);
    this.h.setAntiAlias(true);
  }
  
  public ImageAlphaSwitchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h.setAntiAlias(true);
  }
  
  private void a()
  {
    ValueAnimation localValueAnimation1 = new ValueAnimation(Float.valueOf(0.0F), Float.valueOf(255.0F), new ImageAlphaSwitchView.1(this));
    ValueAnimation localValueAnimation2 = this.b;
    if (localValueAnimation2 != null) {
      localValueAnimation2.cancel();
    }
    this.b = localValueAnimation1;
    localValueAnimation1.setDuration(500L);
    localValueAnimation1.start();
    invalidate();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.f == null)
    {
      this.f = paramBitmap;
      this.g = null;
      this.c = 0.0F;
      invalidate();
      return;
    }
    this.g = paramBitmap;
    a();
  }
  
  public Bitmap getNowImage()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.d = getWidth();
    this.e = getHeight();
    Bitmap localBitmap = this.g;
    boolean bool = false;
    int n;
    int i2;
    int m;
    int i1;
    int k;
    if (localBitmap != null)
    {
      n = localBitmap.getWidth();
      i2 = this.g.getHeight();
      m = this.e;
      i1 = m * n / i2;
      k = this.d;
      if (i1 > k)
      {
        n = i2 * k / n;
        i2 = (m - n) / 2;
        i1 = k;
        m = n;
        n = i2;
      }
      else
      {
        n = 0;
      }
      k = this.i;
      if (k == 3) {}
      do
      {
        k = 0;
        break;
        if (k == 17)
        {
          k = (this.d - i1) / 2;
          break;
        }
      } while (k != 5);
      k = this.d - i1;
      this.h.setAlpha((int)this.c);
      this.j.set(k, n, i1 + k, m);
      paramCanvas.drawBitmap(this.g, null, this.j, this.h);
    }
    localBitmap = this.f;
    if (localBitmap != null)
    {
      n = localBitmap.getWidth();
      i2 = this.f.getHeight();
      m = this.e;
      i1 = m * n / i2;
      k = this.d;
      if (i1 > k)
      {
        n = i2 * k / n;
        i2 = (m - n) / 2;
        i1 = k;
        m = n;
        n = i2;
      }
      else
      {
        n = 0;
      }
      k = this.i;
      if (k == 3) {}
      do
      {
        k = 0;
        break;
        if (k == 17)
        {
          k = (this.d - i1) / 2;
          break;
        }
      } while (k != 5);
      k = this.d - i1;
      this.h.setAlpha(255 - (int)this.c);
      this.j.set(k, n, i1 + k, m);
      paramCanvas.drawBitmap(this.f, null, this.j, this.h);
    }
    paramCanvas = this.b;
    if (paramCanvas != null) {
      bool = paramCanvas.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.a);
    }
    if (bool) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setGravity(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    ValueAnimation localValueAnimation = this.b;
    if (localValueAnimation != null) {
      localValueAnimation.cancel();
    }
    this.f = paramBitmap;
    this.g = null;
    this.c = 0.0F;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageAlphaSwitchView
 * JD-Core Version:    0.7.0.1
 */