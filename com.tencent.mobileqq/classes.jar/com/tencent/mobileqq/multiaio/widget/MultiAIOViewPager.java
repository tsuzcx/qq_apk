package com.tencent.mobileqq.multiaio.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.fps.FPSCalculator;

public class MultiAIOViewPager
  extends MultiAIOBaseViewPager
{
  private int f;
  private GestureDetector g;
  private View.OnClickListener h;
  private Paint i = new Paint(1);
  private int j = -1;
  private FPSCalculator k;
  private TouchEventConsumer l;
  private MultiAIOViewPager.IdleListener m;
  
  public MultiAIOViewPager(@NonNull Context paramContext)
  {
    super(paramContext);
    n();
  }
  
  public MultiAIOViewPager(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    n();
  }
  
  private void n()
  {
    this.g = new GestureDetector(getContext(), new MultiAIOViewPager.1(this), new Handler(Looper.getMainLooper()));
    a(new MultiAIOViewPager.2(this));
  }
  
  private boolean o()
  {
    int n = 0;
    while (n < getChildCount())
    {
      View localView = getChildAt(n);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)))
      {
        int i1 = ((Integer)localObject).intValue();
        if ((localView.getScaleX() == 1.0F) && (i1 != getCurrentItem())) {
          return false;
        }
      }
      n += 1;
    }
    return true;
  }
  
  public void c(float paramFloat)
  {
    this.e = ((int)(this.b * paramFloat));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMaxVelocity() called with: mMaximumVelocity = [");
      localStringBuilder.append(this.e);
      localStringBuilder.append("]");
      QLog.d("MultiAIOViewPager", 2, localStringBuilder.toString());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("], handled ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("MultiAIOViewPager", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = this.l;
      if (localObject != null) {
        ((TouchEventConsumer)localObject).b(this, paramMotionEvent);
      }
    }
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    paramCanvas = this.k;
    if (paramCanvas != null) {
      paramCanvas.b();
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    try
    {
      int n = super.getChildDrawingOrder(paramInt1, paramInt2);
      if ((n >= 0) && (n < paramInt1)) {
        return n;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("childCount = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", childDrawingOrder = ");
      localStringBuilder.append(n);
      localStringBuilder.append(", try fix it");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOViewPager", 1, "getChildDrawingOrder: ", localException);
      super.d();
    }
    return paramInt2;
  }
  
  public void m()
  {
    FPSCalculator localFPSCalculator = this.k;
    if (localFPSCalculator != null) {
      localFPSCalculator.a();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onInterceptTouchEvent() called with: ev = [");
        ((StringBuilder)localObject).append(paramMotionEvent);
        ((StringBuilder)localObject).append("], handled = ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("MultiAIOViewPager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.m != null) {
        this.m.a(bool);
      }
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Object localObject;
      paramMotionEvent = getContext();
      if ((paramMotionEvent instanceof Activity))
      {
        Activity localActivity = (Activity)paramMotionEvent;
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("onInterceptTouchEvent: Dispatching touch event activity.isFinish = ");
        paramMotionEvent.append(localActivity.isFinishing());
        localObject = paramMotionEvent.toString();
        paramMotionEvent = (MotionEvent)localObject;
        if (Build.VERSION.SDK_INT >= 17)
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append((String)localObject);
          paramMotionEvent.append(", isDestroyed = ");
          paramMotionEvent.append(localActivity.isDestroyed());
          paramMotionEvent = paramMotionEvent.toString();
        }
        QLog.e("MultiAIOViewPager", 1, paramMotionEvent, localIllegalArgumentException);
      }
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int n = getChildCount();
    boolean bool2 = j();
    getAdapter();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.f;
    boolean bool1 = true;
    paramBoolean = bool2;
    if (paramInt1 != n) {
      paramBoolean = true;
    }
    if (!o()) {
      paramBoolean = bool1;
    }
    if (paramBoolean) {
      super.c(getScrollX());
    }
    this.f = n;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.g.onTouchEvent(paramMotionEvent);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchEvent() called with: ev = [");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("], handled ");
      localStringBuilder.append(bool);
      QLog.d("MultiAIOViewPager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void setActTAG(String paramString)
  {
    this.k = new FPSCalculator();
    this.k.a(paramString);
  }
  
  public void setAnchorX(int paramInt)
  {
    this.j = paramInt;
    invalidate();
  }
  
  public void setIdleListener(MultiAIOViewPager.IdleListener paramIdleListener)
  {
    this.m = paramIdleListener;
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.h = paramOnClickListener;
  }
  
  public void setTouchEventConsumer(TouchEventConsumer paramTouchEventConsumer)
  {
    this.l = paramTouchEventConsumer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager
 * JD-Core Version:    0.7.0.1
 */