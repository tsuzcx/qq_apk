package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;

public class DisableSlideHorizontalListView
  extends HorizontalListView
{
  private float a;
  private float b;
  private boolean c;
  private DisableSlideHorizontalListView.OnOverScrollListener d;
  private DisableSlideHorizontalListView.OnViewWindowChangedListener e;
  private BezierSideBarView f;
  private int g;
  
  public DisableSlideHorizontalListView(Context paramContext)
  {
    super(paramContext);
    this.g = ((int)DisplayUtils.a(paramContext, 18.0F));
  }
  
  public DisableSlideHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = ((int)DisplayUtils.a(paramContext, 18.0F));
  }
  
  private void a()
  {
    BezierSideBarView localBezierSideBarView = this.f;
    if (localBezierSideBarView != null) {
      localBezierSideBarView.a();
    }
  }
  
  private void a(int paramInt)
  {
    if (this.f != null)
    {
      int i = getMeasuredHeight() / 2;
      int j = AIOUtils.b(18.0F, getResources());
      this.f.a(paramInt, i - j);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    StringBuilder localStringBuilder;
    if (i == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dispatchTouchEvent:ACTION_DOWN. mIsPress=");
        localStringBuilder.append(this.c);
        QLog.d("DisableSlideHorizontalListView", 2, localStringBuilder.toString());
      }
      this.a = f1;
      this.b = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.c = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dispatchTouchEvent:ACTION_MOVE. mIsPress=");
        localStringBuilder.append(this.c);
        QLog.d("DisableSlideHorizontalListView", 2, localStringBuilder.toString());
      }
      float f2 = this.a;
      f3 -= this.b;
      if ((this.c) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.a(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      a(getScrollX() - this.g);
    }
    else if ((i == 3) || (i == 1))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dispatchTouchEvent:ACTION_CANCEL or UP. action=");
        localStringBuilder.append(i);
        localStringBuilder.append(" mIsPress=");
        localStringBuilder.append(this.c);
        QLog.d("DisableSlideHorizontalListView", 2, localStringBuilder.toString());
      }
      this.c = false;
      if ((this.d != null) && (i == 1) && (getScrollX() > this.g)) {
        this.d.a();
      }
      a();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    DisableSlideHorizontalListView.OnViewWindowChangedListener localOnViewWindowChangedListener = this.e;
    if (localOnViewWindowChangedListener != null) {
      localOnViewWindowChangedListener.b();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    DisableSlideHorizontalListView.OnViewWindowChangedListener localOnViewWindowChangedListener = this.e;
    if (localOnViewWindowChangedListener != null) {
      localOnViewWindowChangedListener.c();
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (paramInt1 <= 2)
    {
      a();
      return;
    }
    a(paramInt1 - this.g);
  }
  
  public void setOnOverScrollListener(DisableSlideHorizontalListView.OnOverScrollListener paramOnOverScrollListener)
  {
    this.d = paramOnOverScrollListener;
  }
  
  public void setOnViewWindowChangedListener(DisableSlideHorizontalListView.OnViewWindowChangedListener paramOnViewWindowChangedListener)
  {
    this.e = paramOnViewWindowChangedListener;
  }
  
  public void setSideBarView(BezierSideBarView paramBezierSideBarView)
  {
    this.f = paramBezierSideBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView
 * JD-Core Version:    0.7.0.1
 */