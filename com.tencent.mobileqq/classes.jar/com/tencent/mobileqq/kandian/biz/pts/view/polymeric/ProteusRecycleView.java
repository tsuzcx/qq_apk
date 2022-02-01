package com.tencent.mobileqq.kandian.biz.pts.view.polymeric;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProteusRecycleView
  extends RecyclerViewWithHeaderFooter
{
  private float a;
  private float b;
  private boolean c;
  private boolean d;
  private SideBarView e;
  private int f;
  private boolean g = false;
  private ProteusRecycleView.OnStateChangeListener h;
  private List<ProteusRecycleView.OnDispatchTouchEventListener> i;
  
  public ProteusRecycleView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a()
  {
    if (this.e != null)
    {
      setClipToPadding(false);
      this.e.a(new ProteusRecycleView.1(this));
    }
  }
  
  private void a(int paramInt)
  {
    SideBarView localSideBarView = this.e;
    if (localSideBarView != null)
    {
      localSideBarView.a(paramInt, localSideBarView.getCenterY());
      int j = (int)this.e.getCenterX();
      int k = this.f;
      paramInt = j;
      if (j >= k)
      {
        this.g = true;
        paramInt = k;
      }
      scrollBy(paramInt, 0);
      setPadding(0, 0, paramInt, 0);
    }
  }
  
  private void a(Context paramContext)
  {
    this.f = ((int)DisplayUtils.a(paramContext, 28.0F));
    setOverScrollMode(2);
  }
  
  private void b()
  {
    if (this.g)
    {
      this.g = false;
      ProteusRecycleView.OnStateChangeListener localOnStateChangeListener = this.h;
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.a();
      }
    }
  }
  
  public void a(ProteusRecycleView.OnDispatchTouchEventListener paramOnDispatchTouchEventListener)
  {
    if (this.i == null) {
      this.i = new ArrayList();
    }
    this.i.add(paramOnDispatchTouchEventListener);
  }
  
  public void b(ProteusRecycleView.OnDispatchTouchEventListener paramOnDispatchTouchEventListener)
  {
    List localList = this.i;
    if (localList != null) {
      localList.remove(paramOnDispatchTouchEventListener);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ProteusRecycleView.OnDispatchTouchEventListener)((Iterator)localObject).next()).a(paramMotionEvent);
      }
    }
    if (this.h == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int j = paramMotionEvent.getAction();
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if (j == 0)
    {
      this.a = f2;
      this.b = f1;
      this.c = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (j == 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dispatchTouchEvent:ACTION_MOVE. mIsPress=");
        ((StringBuilder)localObject).append(this.c);
        QLog.d("ProteusRecycleView", 2, ((StringBuilder)localObject).toString());
      }
      boolean bool;
      if (!this.d) {
        bool = canScrollHorizontally(1) ^ true;
      } else {
        bool = false;
      }
      f2 -= this.a;
      f1 -= this.b;
      if ((this.c) && (Math.abs(f1) * 5.0F > Math.abs(f2) * 4.0F) && (Math.abs(f1) > DisplayUtil.a(getContext(), 3.0F)))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        bool = false;
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dispatchTouchEvent:bottom");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" isCurShowSideBarView ");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(" dY:");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(" dX:");
        ((StringBuilder)localObject).append(f2);
        QLog.d("ProteusRecycleView", 2, ((StringBuilder)localObject).toString());
      }
      if ((bool) || (this.d))
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        this.d = true;
        a((int)-f2);
      }
    }
    else if ((j == 3) || (j == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dispatchTouchEvent:ACTION_CANCEL or UP. action=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" mIsPress=");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" isCurShowSideBarView:");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("ProteusRecycleView", 2, ((StringBuilder)localObject).toString());
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      this.c = false;
      if (this.d) {
        a();
      }
      this.d = false;
      if (f2 - this.a < -ViewUtils.dpToPx(15.0F)) {
        b();
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public SideBarView getSideBarView()
  {
    return this.e;
  }
  
  public void setOnStateChangeListener(ProteusRecycleView.OnStateChangeListener paramOnStateChangeListener)
  {
    this.h = paramOnStateChangeListener;
  }
  
  public void setSideBarView(SideBarView paramSideBarView)
  {
    this.e = paramSideBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView
 * JD-Core Version:    0.7.0.1
 */