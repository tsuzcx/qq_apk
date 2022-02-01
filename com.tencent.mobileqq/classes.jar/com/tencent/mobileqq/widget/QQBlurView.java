package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.qphone.base.util.QLog;

@TargetApi(19)
public class QQBlurView
  extends View
{
  private QQBlur a = new QQBlur();
  private ViewTreeObserver.OnPreDrawListener b = new QQBlurView.1(this);
  private boolean c = true;
  private Drawable d;
  
  public QQBlurView(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public QQBlurView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  public QQBlurView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }
  
  private void f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString(), new Throwable());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    this.a.d();
  }
  
  public void a(float paramFloat)
  {
    this.a.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.a.a(paramDrawable);
  }
  
  public void a(View paramView)
  {
    this.a.a(paramView);
  }
  
  public void a(QQBlur.OnDrawBgListener paramOnDrawBgListener)
  {
    this.a.a(paramOnDrawBgListener);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause() called");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    this.a.c();
  }
  
  public void b(int paramInt)
  {
    this.a.c(paramInt);
  }
  
  public void b(View paramView)
  {
    this.a.b(paramView);
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy() called");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    getViewTreeObserver().removeOnPreDrawListener(this.b);
    this.a.e();
  }
  
  public void c(int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    getViewTreeObserver().removeOnPreDrawListener(this.b);
    getViewTreeObserver().addOnPreDrawListener(this.b);
    if (!this.a.a()) {
      this.a.b();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!e()) {
      super.dispatchDraw(paramCanvas);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!e())
    {
      super.draw(paramCanvas);
      return;
    }
    this.a.i();
  }
  
  public boolean e()
  {
    return this.a.h();
  }
  
  public String getStatusLog()
  {
    return this.a.g();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAttachedToWindow() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    getViewTreeObserver().removeOnPreDrawListener(this.b);
    getViewTreeObserver().addOnPreDrawListener(this.b);
    if (this.a != null) {
      a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetachedFromWindow() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    getViewTreeObserver().removeOnPreDrawListener(this.b);
    if (this.a != null) {
      b();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!e())
    {
      if (this.c)
      {
        setBackgroundDrawable(null);
        this.a.a(this, paramCanvas);
        super.onDraw(paramCanvas);
        return;
      }
      setBackgroundDrawable(this.d);
      super.onDraw(paramCanvas);
    }
  }
  
  public void setCalculateLocationListener(QQBlur.onCalculateLocationListener paramonCalculateLocationListener)
  {
    this.a.a(paramonCalculateLocationListener);
  }
  
  public void setDebugTag(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void setDirtyListener(QQBlur.BackgroundViewDirtyListener paramBackgroundViewDirtyListener)
  {
    this.a.a(paramBackgroundViewDirtyListener);
  }
  
  public void setDisableBlurDrawableRes(int paramInt)
  {
    this.d = getResources().getDrawable(paramInt);
  }
  
  public void setEnableBlur(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setInitBlurColorDrawable(ColorDrawable paramColorDrawable)
  {
    this.a.a(paramColorDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlurView
 * JD-Core Version:    0.7.0.1
 */