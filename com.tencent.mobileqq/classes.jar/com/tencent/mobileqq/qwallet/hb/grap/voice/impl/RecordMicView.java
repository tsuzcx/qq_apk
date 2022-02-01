package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
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
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordMicView
  extends View
{
  public boolean a = true;
  float b = 0.0F;
  private int c = 10000;
  private Paint d = new Paint(5);
  private RectF e = new RectF();
  private float f = DisplayUtil.a(getContext(), 2.0F);
  private Handler g = new Handler(ThreadManager.getSubThreadLooper());
  private int h = 0;
  private int i;
  private int j;
  private int k;
  private List<RecordMicView.CircleHolder> l = new ArrayList();
  private ValueAnimator m;
  private RecordMicView.StatusListener n;
  
  public RecordMicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = DisplayUtil.a(getContext(), 120.0F);
    this.j = i1;
    this.i = i1;
    this.k = DisplayUtil.a(getContext(), 33.0F);
    ViewCompat.setImportantForAccessibility(this, 1);
    setContentDescription(HardCodeUtil.a(R.string.ca));
    setClickable(true);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2)
  {
    RecordMicView.CircleHolder localCircleHolder = new RecordMicView.CircleHolder(DisplayUtil.a(getContext(), paramFloat1), DisplayUtil.a(getContext(), paramFloat2), paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt1, paramInt2);
    this.l.add(localCircleHolder);
  }
  
  private void d()
  {
    ValueAnimator localValueAnimator = this.m;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.m = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.m.setRepeatCount(-1);
    this.m.setRepeatMode(2);
    this.m.setDuration(400L);
    this.m.addUpdateListener(new RecordMicView.1(this));
    this.m.start();
  }
  
  public void a()
  {
    this.h = 2;
    this.l.clear();
    a(112.0F, 120.0F, 0.8F, 0.1F, 1.0F, 1.05F, 1.0F, 0.95F, 0, 30);
    a(124.0F, 117.0F, 0.5F, 0.1F, 1.0F, 0.95F, 1.0F, 0.95F, 0, -30);
    a(124.0F, 132.0F, 0.1F, 0.5F, 1.0F, 0.95F, 1.0F, 0.95F, 0, 30);
    a(128.0F, 122.0F, 0.1F, 0.8F, 1.0F, 0.9F, 1.0F, 0.95F, 0, 30);
    d();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.1F, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.1F, 1.0F }) });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.start();
  }
  
  public void b()
  {
    this.g.removeCallbacksAndMessages(null);
    this.g.postDelayed(new RecordMicView.2(this), this.c);
  }
  
  public void c()
  {
    this.g.removeCallbacksAndMessages(null);
    this.h = 0;
    ValueAnimator localValueAnimator = this.m;
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
    localObject = this.m;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = this.h;
    int i1 = 127;
    float f1 = 1.0F;
    if (i2 == 2)
    {
      this.f = DisplayUtil.a(getContext(), 1.0F);
      localObject = this.l.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecordMicView.CircleHolder localCircleHolder = (RecordMicView.CircleHolder)((Iterator)localObject).next();
        paramCanvas.save();
        f1 = localCircleHolder.a;
        float f2 = localCircleHolder.b;
        f1 = (getWidth() - f1) / 2.0F;
        f2 = (getHeight() - f2) / 2.0F;
        i1 = (int)(localCircleHolder.c * 255.0F);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(-3405);
        this.d.setStrokeWidth(this.f);
        this.d.setAlpha(i1);
        RectF localRectF = this.e;
        float f3 = this.f;
        localRectF.set(f3 * 0.5F + f1, f3 * 0.5F + f2, getWidth() - this.f * 0.5F - f1, getHeight() - this.f * 0.5F - f2);
        paramCanvas.scale(localCircleHolder.d, localCircleHolder.e, getWidth() / 2, getHeight() / 2);
        paramCanvas.rotate(localCircleHolder.f, getWidth() / 2, getHeight() / 2);
        paramCanvas.drawOval(this.e, this.d);
        paramCanvas.restore();
      }
      paramCanvas.save();
      paramCanvas.translate((getWidth() - getShowWidth()) / 2, (getHeight() - getShowHeight()) / 2);
      localObject = getResources().getDrawable(R.drawable.ag);
      ((Drawable)localObject).setBounds(0, 0, getShowWidth(), getShowHeight());
      ((Drawable)localObject).setAlpha(127);
      ((Drawable)localObject).draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    this.f = DisplayUtil.a(getContext(), 2.0F);
    paramCanvas.save();
    paramCanvas.translate((getWidth() - getShowWidth()) / 2, (getHeight() - getShowHeight()) / 2);
    if (this.h == 0) {
      i1 = 255;
    }
    if (this.h != 0) {
      f1 = 0.95F;
    }
    paramCanvas.scale(f1, f1, getWidth() / 2, getHeight() / 2);
    this.d.setColor(16728412);
    this.e.set(0.0F, 0.0F, getShowWidth(), getShowHeight());
    this.d.setStyle(Paint.Style.FILL);
    this.d.setAlpha(i1);
    paramCanvas.drawOval(this.e, this.d);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setColor(-3405);
    this.d.setStrokeWidth(this.f);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setAlpha(i1);
    Object localObject = this.e;
    f1 = this.f;
    ((RectF)localObject).set(f1 * 0.5F, f1 * 0.5F, getShowWidth() - this.f * 0.5F, getShowHeight() - this.f * 0.5F);
    paramCanvas.drawOval(this.e, this.d);
    localObject = getResources().getDrawable(R.drawable.ag);
    ((Drawable)localObject).setBounds(0, 0, getShowWidth(), getShowHeight());
    ((Drawable)localObject).setAlpha(i1);
    ((Drawable)localObject).draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    RecordMicView.StatusListener localStatusListener;
    if (i1 != 0)
    {
      if (((i1 == 1) || ((i1 != 2) && (i1 == 3))) && (this.h == 1))
      {
        float f1 = this.b;
        float f2 = paramMotionEvent.getRawY();
        i1 = 0;
        if (f1 - f2 > this.k) {
          i1 = 1;
        }
        if (i1 != 0)
        {
          localStatusListener = this.n;
          if (localStatusListener != null) {
            localStatusListener.g();
          }
          c();
        }
        else
        {
          this.g.removeCallbacksAndMessages(null);
          if (this.a) {
            a();
          } else {
            c();
          }
          localStatusListener = this.n;
          if (localStatusListener != null) {
            localStatusListener.e();
          }
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    i1 = this.h;
    if (i1 == 2) {
      return true;
    }
    if (i1 == 0)
    {
      this.h = 1;
      invalidate();
      b();
      localStatusListener = this.n;
      if (localStatusListener != null) {
        localStatusListener.d();
      }
      this.b = paramMotionEvent.getRawY();
    }
    return true;
  }
  
  public void setRecordTime(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setStatusListener(RecordMicView.StatusListener paramStatusListener)
  {
    this.n = paramStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.RecordMicView
 * JD-Core Version:    0.7.0.1
 */