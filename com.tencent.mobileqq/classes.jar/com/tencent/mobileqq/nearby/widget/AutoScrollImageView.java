package com.tencent.mobileqq.nearby.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class AutoScrollImageView
  extends ImageView
{
  private Bitmap a;
  private Rect b = new Rect();
  private Rect c = new Rect();
  private boolean d;
  private int e;
  private Paint f = new Paint();
  private ValueAnimator g;
  private int h;
  private int i = 14000;
  
  public AutoScrollImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoScrollImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoScrollImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error=");
      localStringBuilder.append(paramBitmap.toString());
      QLog.i("AutoScrollImageView", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  @TargetApi(21)
  private void a(Canvas paramCanvas)
  {
    if (this.g == null)
    {
      this.g = ValueAnimator.ofInt(new int[] { 0, this.a.getHeight() - getMeasuredHeight() });
      this.g.setDuration(this.i);
      this.g.setInterpolator(new LinearInterpolator());
      this.g.setRepeatCount(-1);
      this.g.setRepeatMode(2);
      this.g.addUpdateListener(new AutoScrollImageView.1(this));
      this.g.start();
    }
    if (this.e == 0)
    {
      b(paramCanvas);
      return;
    }
    int j = getMeasuredWidth();
    int k = getMeasuredHeight();
    float f1 = j;
    float f2 = k;
    RectF localRectF = new RectF(0.0F, 0.0F, f1, f2);
    if (Build.VERSION.SDK_INT >= 21) {
      j = paramCanvas.saveLayer(localRectF, null);
    } else {
      j = paramCanvas.saveLayer(localRectF, null, 31);
    }
    localRectF = new RectF(0.0F, 0.0F, f1, f2);
    k = this.e;
    paramCanvas.drawRoundRect(localRectF, k, k, this.f);
    this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    b(paramCanvas);
    this.f.setXfermode(null);
    paramCanvas.restoreToCount(j);
  }
  
  private void b(Canvas paramCanvas)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    Rect localRect = this.b;
    localRect.left = 0;
    localRect.right = ((Bitmap)localObject).getWidth();
    localObject = this.b;
    ((Rect)localObject).top = this.h;
    ((Rect)localObject).bottom = (((Rect)localObject).top + getMeasuredHeight());
    localObject = this.c;
    ((Rect)localObject).left = 0;
    ((Rect)localObject).right = getMeasuredWidth();
    localObject = this.c;
    ((Rect)localObject).top = 0;
    ((Rect)localObject).bottom = getMeasuredHeight();
    paramCanvas.drawBitmap(this.a, this.b, this.c, this.f);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.g;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.g.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d)
    {
      this.a = null;
      super.onDraw(paramCanvas);
      return;
    }
    if (this.a != null)
    {
      a(paramCanvas);
      return;
    }
    Object localObject = getDrawable();
    if ((localObject != null) && ((localObject instanceof BitmapDrawable)))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.a = a((Bitmap)localObject, getMeasuredWidth(), getMeasuredWidth() * ((Bitmap)localObject).getHeight() / ((Bitmap)localObject).getWidth());
      if (this.a != null)
      {
        a(paramCanvas);
        return;
      }
      super.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setAutoScroll(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt >= 0) {
      this.i = paramInt;
    }
  }
  
  public void setRadius(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AutoScrollImageView
 * JD-Core Version:    0.7.0.1
 */