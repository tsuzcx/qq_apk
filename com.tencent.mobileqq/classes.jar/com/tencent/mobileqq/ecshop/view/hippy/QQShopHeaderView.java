package com.tencent.mobileqq.ecshop.view.hippy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

public class QQShopHeaderView
  extends HorizontalScrollView
  implements HippyViewBase
{
  private int a = 0;
  private VelocityTracker b;
  private int c;
  private int d;
  private int e;
  private int f;
  private QQShopHeaderView.OnPageChangeListener g;
  
  public QQShopHeaderView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QQShopHeaderView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131627833, this);
    this.b = VelocityTracker.obtain();
    this.c = ViewConfiguration.get(paramContext).getScaledMinimumFlingVelocity();
    this.d = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
    setHorizontalScrollBarEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
  }
  
  private void b(int paramInt)
  {
    try
    {
      int j = getScrollX();
      i = j / this.f;
      j %= this.f;
      if (paramInt < 0)
      {
        paramInt = i;
        if (j > this.f / 4) {
          break label75;
        }
      }
      else
      {
        paramInt = i;
        if (j <= this.f * 3 / 4) {}
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        continue;
        label75:
        paramInt = i + 1;
      }
    }
    a(paramInt);
    return;
    a(this.a);
  }
  
  private void c(int paramInt)
  {
    if (paramInt < 0)
    {
      a(this.a + 1);
      return;
    }
    a(this.a - 1);
  }
  
  public void a()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void a(int paramInt)
  {
    try
    {
      int i = Math.min(((ViewGroup)getChildAt(0)).getChildCount(), Math.max(0, paramInt));
      paramInt = i;
    }
    catch (Exception localException)
    {
      QLog.e("QQShopHeaderView", 1, localException, new Object[0]);
    }
    smoothScrollTo(this.f * paramInt, 0);
    QQShopHeaderView.OnPageChangeListener localOnPageChangeListener = this.g;
    if ((localOnPageChangeListener != null) && (this.a != paramInt))
    {
      localOnPageChangeListener.a(paramInt);
      this.a = paramInt;
    }
  }
  
  public void a(int paramInt, QQShopHeaderView.OnPageChangeListener paramOnPageChangeListener)
  {
    this.f = paramInt;
    this.g = paramOnPageChangeListener;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.e = ((int)paramMotionEvent.getX());
      this.b.clear();
      this.b.addMovement(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.b.addMovement(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.b.computeCurrentVelocity(1000, this.d);
      int i = (int)this.b.getXVelocity();
      this.b.clear();
      int j = (int)paramMotionEvent.getX() - this.e;
      if (Math.abs(i) > this.c)
      {
        c(j);
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("flying scroll fingerDx = ");
        paramMotionEvent.append(j);
        QLog.d("QQShopHeaderView", 1, paramMotionEvent.toString());
        return true;
      }
      if (j != 0)
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("default scroll fingerDx = ");
        paramMotionEvent.append(j);
        QLog.d("QQShopHeaderView", 1, paramMotionEvent.toString());
        b(j);
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.hippy.QQShopHeaderView
 * JD-Core Version:    0.7.0.1
 */