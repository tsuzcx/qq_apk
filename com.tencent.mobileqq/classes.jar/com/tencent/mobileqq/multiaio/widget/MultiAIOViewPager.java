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
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private MultiAIOViewPager.IdleListener jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager$IdleListener;
  private TouchEventConsumer jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTouchEventConsumer;
  private FPSCalculator jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator;
  private int d;
  private int e = -1;
  
  public MultiAIOViewPager(@NonNull Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public MultiAIOViewPager(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  private boolean g()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)))
      {
        int j = ((Integer)localObject).intValue();
        if ((localView.getScaleX() == 1.0F) && (j != a())) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new MultiAIOViewPager.1(this), new Handler(Looper.getMainLooper()));
    a(new MultiAIOViewPager.2(this));
  }
  
  public void b(float paramFloat)
  {
    this.c = ((int)(this.jdField_a_of_type_Int * paramFloat));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMaxVelocity() called with: mMaximumVelocity = [");
      localStringBuilder.append(this.c);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTouchEventConsumer;
      if (localObject != null) {
        ((TouchEventConsumer)localObject).b(this, paramMotionEvent);
      }
    }
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    paramCanvas = this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator;
    if (paramCanvas != null) {
      paramCanvas.b();
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void g()
  {
    FPSCalculator localFPSCalculator = this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator;
    if (localFPSCalculator != null) {
      localFPSCalculator.a();
    }
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    try
    {
      int i = super.getChildDrawingOrder(paramInt1, paramInt2);
      if ((i >= 0) && (i < paramInt1)) {
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("childCount = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", childDrawingOrder = ");
      localStringBuilder.append(i);
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
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager$IdleListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager$IdleListener.a(bool);
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
    int i = getChildCount();
    boolean bool2 = e();
    a();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.d;
    boolean bool1 = true;
    paramBoolean = bool2;
    if (paramInt1 != i) {
      paramBoolean = true;
    }
    if (!g()) {
      paramBoolean = bool1;
    }
    if (paramBoolean) {
      super.a(getScrollX());
    }
    this.d = i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
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
    this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator = new FPSCalculator();
    this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator.a(paramString);
  }
  
  public void setAnchorX(int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
  
  public void setIdleListener(MultiAIOViewPager.IdleListener paramIdleListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager$IdleListener = paramIdleListener;
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setTouchEventConsumer(TouchEventConsumer paramTouchEventConsumer)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTouchEventConsumer = paramTouchEventConsumer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager
 * JD-Core Version:    0.7.0.1
 */