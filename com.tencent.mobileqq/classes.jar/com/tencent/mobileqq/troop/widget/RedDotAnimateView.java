package com.tencent.mobileqq.troop.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class RedDotAnimateView
  extends View
{
  Paint a;
  Paint b;
  int c;
  int d;
  float e;
  float f;
  int g = 76;
  int h = 255;
  ValueAnimator i;
  ValueAnimator j;
  ValueAnimator k;
  AnimatorSet l;
  
  public RedDotAnimateView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RedDotAnimateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  void a()
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setColor(Color.rgb(241, 54, 27));
    this.a.setStyle(Paint.Style.FILL);
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setColor(Color.rgb(241, 54, 27));
    this.b.setStyle(Paint.Style.FILL);
    this.k = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.3333333F, 1.9F), Keyframe.ofFloat(0.5F, 0.58F), Keyframe.ofFloat(0.6666667F, 1.25F), Keyframe.ofFloat(1.0F, 1.0F) }) });
    this.k.setDuration(1600L);
    this.k.setInterpolator(new AccelerateDecelerateInterpolator());
    this.k.addUpdateListener(new RedDotAnimateView.1(this));
    this.i = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1333333F, 0.0F), Keyframe.ofFloat(0.3333333F, 3.0F), Keyframe.ofFloat(0.5F, 1.4F), Keyframe.ofFloat(0.6666667F, 2.08F), Keyframe.ofFloat(1.0F, 2.08F) }) });
    this.i.setDuration(1600L);
    this.i.setInterpolator(new AccelerateDecelerateInterpolator());
    this.i.addUpdateListener(new RedDotAnimateView.2(this));
    this.j = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.3F), Keyframe.ofFloat(0.1333333F, 0.3F), Keyframe.ofFloat(0.3333333F, 0.3F), Keyframe.ofFloat(0.5F, 0.3F), Keyframe.ofFloat(0.6666667F, 0.3F), Keyframe.ofFloat(1.0F, 0.0F) }) });
    this.j.setDuration(1600L);
    this.j.setInterpolator(new LinearInterpolator());
    this.j.addUpdateListener(new RedDotAnimateView.3(this));
    this.l = new AnimatorSet();
    this.l.setDuration(1600L);
    this.l.playTogether(new Animator[] { this.k, this.i, this.j });
  }
  
  public void b()
  {
    this.l.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.d == 0) {
      this.d = getHeight();
    }
    if (this.c == 0) {
      this.c = getWidth();
    }
    this.a.setAlpha(this.h);
    paramCanvas.drawCircle(this.c / 2, this.d / 2, this.f, this.a);
    this.b.setAlpha(this.g);
    paramCanvas.drawCircle(this.c / 2, this.d / 2, this.e, this.b);
  }
  
  public void setStaticRedDot(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.g = 0;
    this.f = (this.c / 2);
    invalidate();
  }
  
  public void setVisibleAndZeroRadius()
  {
    this.e = 0.0F;
    this.f = 0.0F;
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotAnimateView
 * JD-Core Version:    0.7.0.1
 */