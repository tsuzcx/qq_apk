package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;

public class ImageShakeAnimView
  extends View
{
  Bitmap a;
  int b = 0;
  int c = 0;
  float d = 1.0F;
  float e = 1.0F;
  int f = 0;
  int g = 0;
  Rect h = new Rect();
  boolean i = false;
  public Transformation j = new Transformation();
  ValueAnimation<Float> k = null;
  
  public ImageShakeAnimView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public ImageShakeAnimView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Integer paramInteger, boolean paramBoolean)
  {
    super(paramContext);
    a(paramInteger);
    this.b = paramInt1;
    this.c = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.i = paramBoolean;
  }
  
  public ImageShakeAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(null);
  }
  
  private void a(Integer paramInteger)
  {
    for (;;)
    {
      try
      {
        if (paramInteger.intValue() == 2130846861)
        {
          paramInteger = "hb_luckybag_name_path";
          this.a = PortalManager.a(paramInteger, true);
          return;
        }
      }
      catch (OutOfMemoryError paramInteger)
      {
        paramInteger.printStackTrace();
        return;
      }
      paramInteger = "hb_luckybag_ing_name_path";
    }
  }
  
  public void a()
  {
    float f1;
    if (this.i) {
      f1 = 720.0F;
    } else {
      f1 = 500.0F;
    }
    ValueAnimation localValueAnimation1 = new ValueAnimation(Float.valueOf(0.0F), Float.valueOf(f1), new ImageShakeAnimView.1(this));
    ValueAnimation localValueAnimation2 = this.k;
    if (localValueAnimation2 != null) {
      localValueAnimation2.cancel();
    }
    this.k = localValueAnimation1;
    long l;
    if (this.i) {
      l = 720L;
    } else {
      l = 500L;
    }
    localValueAnimation1.setDuration(l);
    localValueAnimation1.start();
    invalidate();
  }
  
  public boolean a(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.a;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    if (this.b == 0)
    {
      this.b = getWidth();
      this.c = getHeight();
    }
    paramCanvas.save();
    paramCanvas.translate(this.f, this.g);
    paramCanvas.scale(this.d, this.e, this.b / 2, 0.0F);
    localObject = this.h;
    int m = this.b;
    ((Rect)localObject).set(0, 0, m, this.a.getHeight() * m / this.a.getWidth());
    paramCanvas.drawBitmap(this.a, null, this.h, null);
    paramCanvas.restore();
    paramCanvas = this.k;
    if (paramCanvas != null) {
      bool = paramCanvas.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.j);
    }
    return bool;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (a(paramCanvas)) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.i)
    {
      this.b = getWidth();
      this.c = getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageShakeAnimView
 * JD-Core Version:    0.7.0.1
 */