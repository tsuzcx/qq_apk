package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class CaptureOperateTouchLayout
  extends FrameLayout
{
  public static int a = 200;
  private static int b = -1;
  private MqqHandler c;
  private ImageView d;
  private TextView e;
  private VideoMeasureScaleView f;
  private TextView g;
  private long h;
  private int i;
  private int j;
  private float k;
  private int l;
  private int m;
  private float n;
  private boolean o;
  private Scroller p;
  private CaptureOperateTouchLayout.OnCaptureOperateCallback q;
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    int i1 = b;
    this.k = i1;
    this.l = i1;
    this.m = i1;
    this.o = false;
    this.p = new Scroller(BaseApplication.getContext());
    this.q = null;
  }
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = b;
    this.k = i1;
    this.l = i1;
    this.m = i1;
    this.o = false;
    this.p = new Scroller(BaseApplication.getContext());
    this.q = null;
    b();
  }
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = b;
    this.k = paramInt;
    this.l = paramInt;
    this.m = paramInt;
    this.o = false;
    this.p = new Scroller(BaseApplication.getContext());
    this.q = null;
    b();
  }
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * this.j);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i1 = getWidth();
    int i2 = this.d.getWidth();
    a(paramInt / (i1 - i2), paramBoolean);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1;
    if ((paramMotionEvent.getRawX() >= this.d.getX()) && (paramMotionEvent.getRawX() <= this.d.getX() + this.d.getWidth())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return;
    }
    a((int)(paramMotionEvent.getRawX() - this.d.getWidth() / 3), false);
  }
  
  private int b(float paramFloat, boolean paramBoolean)
  {
    return (int)Math.min(Math.max(0, c(paramFloat, paramBoolean)), this.h);
  }
  
  private void b()
  {
    this.c = ThreadManager.getUIHandler();
  }
  
  private int c(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      float f1 = this.k;
      float f2 = this.m;
      return (int)(this.l + (paramFloat - f1) * f2);
    }
    return (int)(paramFloat * (float)this.h) / 1000 * 1000;
  }
  
  private void c()
  {
    CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = this.q;
    if (localOnCaptureOperateCallback != null) {
      localOnCaptureOperateCallback.a(getVideoSeekPosition());
    }
  }
  
  private float getMaxLength()
  {
    return ((View)this.d.getParent()).getRight() - this.d.getWidth();
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    float f1 = (getWidth() - this.d.getWidth()) * paramFloat;
    this.n = paramFloat;
    this.i = b(paramFloat, paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onIndicatorChange percent:");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(" progressX:");
      localStringBuilder.append(f1);
      localStringBuilder.append(" duration:");
      localStringBuilder.append(this.h);
      localStringBuilder.append(" videoSeekPosition:");
      localStringBuilder.append(this.i);
      localStringBuilder.append(" longPressStartVideoSeekPercent:");
      localStringBuilder.append(this.k);
      QLog.d("CaptureOperateTouchLayout", 2, localStringBuilder.toString());
    }
    int i1 = (this.d.getWidth() - this.e.getWidth()) / 2;
    this.d.setX(f1);
    this.e.setX(f1 + i1);
    this.e.setText(ReadInJoyDisplayUtils.a(this.i / 1000));
    c();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.p.computeScrollOffset())
    {
      a(this.p.getCurrX() / getMaxLength(), this.o);
      invalidate();
    }
  }
  
  public float getCurrentProgress()
  {
    return this.n;
  }
  
  public float getVideoSeekPercent()
  {
    return (float)(getVideoSeekPosition() / this.h);
  }
  
  public int getVideoSeekPosition()
  {
    return this.i;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getAction() == 0) {
      a(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setDuration(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void setOnCaptureOperateCallback(CaptureOperateTouchLayout.OnCaptureOperateCallback paramOnCaptureOperateCallback)
  {
    this.q = paramOnCaptureOperateCallback;
  }
  
  public void setup(ImageView paramImageView, TextView paramTextView1, TextView paramTextView2, VideoMeasureScaleView paramVideoMeasureScaleView, int paramInt)
  {
    this.d = paramImageView;
    this.e = paramTextView1;
    this.g = paramTextView2;
    this.f = paramVideoMeasureScaleView;
    this.j = paramInt;
    this.m = (paramInt * a);
    paramImageView.setOnTouchListener(new CaptureOperateTouchLayout.IndicatorTouchListener(this, new CaptureOperateTouchLayout.1(this, paramTextView2, paramVideoMeasureScaleView, paramImageView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout
 * JD-Core Version:    0.7.0.1
 */