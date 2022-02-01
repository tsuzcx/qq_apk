package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.util.DisplayUtil;

public class VideoFeedsGuideView
  extends View
{
  public static final int[] a = { -1, 16777215 };
  public int b;
  public int c;
  private Bitmap d;
  private Rect e;
  private Paint f;
  private int g;
  private int h;
  private int i;
  private int j = 0;
  private int k;
  private int l = 0;
  private int m = 0;
  private VideoFeedsGuideView.AnimateHandler n;
  private VideoFeedsGuideView.AnimateListener o;
  private VideoFeedsGuideView.GuideViewMoveAnimateListener p;
  private AnimatorSet q;
  
  public VideoFeedsGuideView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i2 = View.MeasureSpec.getSize(paramInt);
    if (paramBoolean) {
      paramInt = this.b;
    } else {
      paramInt = this.c;
    }
    int i1 = i2;
    if (i2 < paramInt) {
      i1 = paramInt;
    }
    return i1;
  }
  
  private void a()
  {
    this.c = DisplayUtil.a(getContext(), 150.0F);
    this.b = DisplayUtil.a(getContext(), 180.0F);
    this.g = DisplayUtil.a(getContext(), 8.0F);
    this.i = DisplayUtil.a(getContext(), 70.0F);
    this.k = DisplayUtil.a(getContext(), 70.0F);
    this.h = this.i;
    this.f = new Paint();
    this.f.setStyle(Paint.Style.FILL);
    this.f.setAntiAlias(true);
    this.e = new Rect();
    this.d = BitmapFactory.decodeResource(getResources(), 2130844186);
    this.n = new VideoFeedsGuideView.AnimateHandler(this, null);
    this.o = new VideoFeedsGuideView.AnimateListener(this, null);
    this.p = new VideoFeedsGuideView.GuideViewMoveAnimateListener(this, null);
  }
  
  private void a(Canvas paramCanvas)
  {
    b(paramCanvas);
    c(paramCanvas);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.m == 1)
    {
      this.j = 0;
      this.i = this.h;
    }
    else
    {
      this.l = 0;
      this.k = this.h;
    }
    invalidate();
    if (paramBoolean) {
      this.n.sendEmptyMessageDelayed(0, 300L);
    }
  }
  
  private void b()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(200L);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.h });
    localValueAnimator.addUpdateListener(this.p);
    localValueAnimator.setDuration(500L);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localValueAnimator).after(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setStartDelay(400L);
    this.q = new AnimatorSet();
    this.q.play(localObjectAnimator).after(localAnimatorSet);
    this.q.addListener(this.o);
    this.q.start();
  }
  
  private void b(Canvas paramCanvas)
  {
    int i1 = getWidth() / 3;
    int i2 = getHeight() - this.i + 10;
    int i3 = this.g;
    int i4 = getHeight();
    LinearGradient localLinearGradient = new LinearGradient(0.0F, i2, 0.0F, i4, a, null, Shader.TileMode.CLAMP);
    this.f.setShader(localLinearGradient);
    this.e.set(i1, i2, i3 + i1, i4);
    paramCanvas.drawRect(this.e, this.f);
  }
  
  private void c(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.d, getWidth() / 3, getHeight() - this.j - this.h, this.f);
  }
  
  private void d(Canvas paramCanvas)
  {
    e(paramCanvas);
    f(paramCanvas);
  }
  
  private void e(Canvas paramCanvas)
  {
    int i1 = getWidth() * 5 / 6 - this.k + 10;
    int i2 = getHeight() - this.d.getHeight();
    int i3 = getWidth();
    int i4 = this.g;
    LinearGradient localLinearGradient = new LinearGradient(i1, 0.0F, i3, 0.0F, a, null, Shader.TileMode.CLAMP);
    this.f.setShader(localLinearGradient);
    this.e.set(i1, i2, i3, i4 + i2);
    paramCanvas.drawRect(this.e, this.f);
  }
  
  private void f(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.d, getWidth() * 5 / 6 - this.l - this.h, getHeight() - this.d.getHeight(), this.f);
  }
  
  public int getCurrentMode()
  {
    return this.m;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = this.m;
    if (i1 == 0) {
      return;
    }
    if (i1 == 1)
    {
      a(paramCanvas);
      return;
    }
    d(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1, true), a(paramInt2, false));
  }
  
  public void setCurrentMode(int paramInt)
  {
    this.m = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGuideView
 * JD-Core Version:    0.7.0.1
 */