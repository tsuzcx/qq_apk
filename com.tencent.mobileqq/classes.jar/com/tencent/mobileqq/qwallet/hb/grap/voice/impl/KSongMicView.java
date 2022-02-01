package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KSongMicView
  extends View
{
  public boolean a = true;
  float b = 0.0F;
  private Paint c = new Paint(5);
  private RectF d = new RectF();
  private Rect e = new Rect();
  private float f = DisplayUtil.a(getContext(), 2.0F);
  private Handler g = new Handler(ThreadManager.getSubThreadLooper());
  private int h = 0;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private List<KSongMicView.CircleHolder> o = new ArrayList();
  private ValueAnimator p;
  private KSongMicView.StatusListener q;
  
  public KSongMicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = DisplayUtil.a(getContext(), 90.0F);
    this.j = i1;
    this.i = i1;
    this.k = DisplayUtil.a(getContext(), 28.0F);
    this.l = DisplayUtil.a(getContext(), 36.5F);
    this.m = DisplayUtil.a(getContext(), 12.0F);
    this.n = DisplayUtil.a(getContext(), 100.0F);
    ViewCompat.setImportantForAccessibility(this, 1);
    setContentDescription(HardCodeUtil.a(R.string.bl));
    setClickable(true);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2)
  {
    KSongMicView.CircleHolder localCircleHolder = new KSongMicView.CircleHolder(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt1, paramInt2);
    this.o.add(localCircleHolder);
  }
  
  private void c()
  {
    ValueAnimator localValueAnimator = this.p;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.p = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.p.setRepeatCount(-1);
    this.p.setRepeatMode(2);
    this.p.setDuration(400L);
    this.p.addUpdateListener(new KSongMicView.1(this));
    this.p.start();
  }
  
  public void a()
  {
    this.h = 3;
    this.o.clear();
    a(getShowWidth() * 0.93F, getShowHeight(), 0.8F, 0.1F, 1.0F, 1.05F, 1.0F, 0.95F, 0, 30);
    a(getShowWidth() * 1.03F, getShowHeight() * 0.975F, 0.5F, 0.1F, 1.0F, 0.95F, 1.0F, 0.95F, 0, -30);
    a(getShowWidth() * 1.03F, getShowHeight() * 1.1F, 0.1F, 0.5F, 1.0F, 0.95F, 1.0F, 0.95F, 0, 30);
    a(getShowWidth() * 1.07F, getShowHeight() * 1.02F, 0.1F, 0.8F, 1.0F, 0.9F, 1.0F, 0.95F, 0, 30);
    c();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.1F, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.1F, 1.0F }) });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.start();
  }
  
  public void b()
  {
    this.g.removeCallbacksAndMessages(null);
    this.h = 0;
    ValueAnimator localValueAnimator = this.p;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public int getShowHeight()
  {
    return this.j;
  }
  
  public int getShowWidth()
  {
    return this.i;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.g;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.p;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = this.h;
    float f2 = 1.0F;
    if (i1 == 3)
    {
      this.f = DisplayUtil.a(getContext(), 1.0F);
      localObject = this.o.iterator();
      while (((Iterator)localObject).hasNext())
      {
        KSongMicView.CircleHolder localCircleHolder = (KSongMicView.CircleHolder)((Iterator)localObject).next();
        paramCanvas.save();
        f1 = localCircleHolder.a;
        f2 = localCircleHolder.b;
        f1 = (getWidth() - f1) / 2.0F;
        f2 = (getHeight() - f2) / 2.0F;
        i1 = (int)(localCircleHolder.c * 255.0F);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setColor(-3405);
        this.c.setStrokeWidth(this.f);
        this.c.setAlpha(i1);
        RectF localRectF = this.d;
        float f3 = this.f;
        localRectF.set(f3 * 0.5F + f1, f3 * 0.5F + f2, getWidth() - this.f * 0.5F - f1, getHeight() - this.f * 0.5F - f2);
        paramCanvas.scale(localCircleHolder.d, localCircleHolder.e, getWidth() / 2, getHeight() / 2);
        paramCanvas.rotate(localCircleHolder.f, getWidth() / 2, getHeight() / 2);
        paramCanvas.drawOval(this.d, this.c);
        paramCanvas.restore();
      }
    }
    this.f = DisplayUtil.a(getContext(), 1.0F);
    paramCanvas.save();
    paramCanvas.translate((getWidth() - getShowWidth()) / 2, (getHeight() - getShowHeight()) / 2);
    i1 = this.h;
    if ((i1 != 0) && (i1 != 2)) {
      i1 = 127;
    } else {
      i1 = 255;
    }
    int i2 = this.h;
    float f1 = f2;
    if (i2 != 0) {
      if (i2 == 2) {
        f1 = f2;
      } else {
        f1 = 0.95F;
      }
    }
    paramCanvas.scale(f1, f1, getWidth() / 2, getHeight() / 2);
    this.c.setColor(16728412);
    this.d.set(0.0F, 0.0F, getShowWidth(), getShowHeight());
    this.c.setStyle(Paint.Style.FILL);
    this.c.setAlpha(i1);
    paramCanvas.drawOval(this.d, this.c);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(-3405);
    this.c.setStrokeWidth(this.f);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setAlpha(i1);
    Object localObject = this.d;
    f1 = this.f;
    ((RectF)localObject).set(f1 * 0.5F, f1 * 0.5F, getShowWidth() - this.f * 0.5F, getShowHeight() - this.f * 0.5F);
    paramCanvas.drawOval(this.d, this.c);
    i2 = this.h;
    if ((i2 == 0) || (i2 == 1))
    {
      localObject = getResources().getDrawable(R.drawable.ac);
      int i3 = getShowWidth();
      i2 = this.k;
      i3 = (i3 - i2) / 2;
      ((Drawable)localObject).setBounds(i3, i3, i2 + i3, this.l + i3);
      ((Drawable)localObject).setAlpha(i1);
      ((Drawable)localObject).draw(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    KSongMicView.StatusListener localStatusListener;
    if (i1 != 0)
    {
      if (((i1 == 1) || ((i1 != 2) && (i1 == 3))) && (this.h == 1))
      {
        float f1 = this.b;
        paramMotionEvent.getRawY();
        i1 = 0;
        if ((!QWalletTools.a(this, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) || (paramMotionEvent.getAction() == 3)) {
          i1 = 1;
        }
        if (i1 != 0)
        {
          localStatusListener = this.q;
          if (localStatusListener != null) {
            localStatusListener.s();
          }
          b();
        }
        else
        {
          this.g.removeCallbacksAndMessages(null);
          this.h = 2;
          invalidate();
          localStatusListener = this.q;
          if (localStatusListener != null) {
            localStatusListener.r();
          }
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    i1 = this.h;
    if (i1 == 3) {
      return true;
    }
    if (i1 == 0)
    {
      this.h = 1;
      invalidate();
      localStatusListener = this.q;
      if (localStatusListener != null) {
        localStatusListener.q();
      }
      this.b = paramMotionEvent.getRawY();
    }
    return true;
  }
  
  public void setStatusListener(KSongMicView.StatusListener paramStatusListener)
  {
    this.q = paramStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongMicView
 * JD-Core Version:    0.7.0.1
 */