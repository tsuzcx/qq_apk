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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ProteusRecycleView.OnStateChangeListener jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView$OnStateChangeListener;
  private SideBarView jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericSideBarView;
  private List<ProteusRecycleView.OnDispatchTouchEventListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = false;
  
  public ProteusRecycleView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericSideBarView != null)
    {
      setClipToPadding(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericSideBarView.a(new ProteusRecycleView.1(this));
    }
  }
  
  private void a(int paramInt)
  {
    SideBarView localSideBarView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericSideBarView;
    if (localSideBarView != null)
    {
      localSideBarView.a(paramInt, localSideBarView.d());
      int i = (int)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericSideBarView.a();
      int j = this.jdField_a_of_type_Int;
      paramInt = i;
      if (i >= j)
      {
        this.c = true;
        paramInt = j;
      }
      scrollBy(paramInt, 0);
      setPadding(0, 0, paramInt, 0);
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(paramContext, 28.0F));
    setOverScrollMode(2);
  }
  
  private void b()
  {
    if (this.c)
    {
      this.c = false;
      ProteusRecycleView.OnStateChangeListener localOnStateChangeListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView$OnStateChangeListener;
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.a();
      }
    }
  }
  
  public SideBarView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericSideBarView;
  }
  
  public void a(ProteusRecycleView.OnDispatchTouchEventListener paramOnDispatchTouchEventListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnDispatchTouchEventListener);
  }
  
  public void b(ProteusRecycleView.OnDispatchTouchEventListener paramOnDispatchTouchEventListener)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.remove(paramOnDispatchTouchEventListener);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ProteusRecycleView.OnDispatchTouchEventListener)((Iterator)localObject).next()).a(paramMotionEvent);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView$OnStateChangeListener == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = f2;
      this.jdField_b_of_type_Float = f1;
      this.jdField_a_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dispatchTouchEvent:ACTION_MOVE. mIsPress=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.d("ProteusRecycleView", 2, ((StringBuilder)localObject).toString());
      }
      boolean bool;
      if (!this.jdField_b_of_type_Boolean) {
        bool = canScrollHorizontally(1) ^ true;
      } else {
        bool = false;
      }
      f2 -= this.jdField_a_of_type_Float;
      f1 -= this.jdField_b_of_type_Float;
      if ((this.jdField_a_of_type_Boolean) && (Math.abs(f1) * 5.0F > Math.abs(f2) * 4.0F) && (Math.abs(f1) > DisplayUtil.a(getContext(), 3.0F)))
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
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        ((StringBuilder)localObject).append(" dY:");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(" dX:");
        ((StringBuilder)localObject).append(f2);
        QLog.d("ProteusRecycleView", 2, ((StringBuilder)localObject).toString());
      }
      if ((bool) || (this.jdField_b_of_type_Boolean))
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        this.jdField_b_of_type_Boolean = true;
        a((int)-f2);
      }
    }
    else if ((i == 3) || (i == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dispatchTouchEvent:ACTION_CANCEL or UP. action=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" mIsPress=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject).append(" isCurShowSideBarView:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        QLog.d("ProteusRecycleView", 2, ((StringBuilder)localObject).toString());
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        a();
      }
      this.jdField_b_of_type_Boolean = false;
      if (f2 - this.jdField_a_of_type_Float < -ViewUtils.b(15.0F)) {
        b();
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setOnStateChangeListener(ProteusRecycleView.OnStateChangeListener paramOnStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView$OnStateChangeListener = paramOnStateChangeListener;
  }
  
  public void setSideBarView(SideBarView paramSideBarView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericSideBarView = paramSideBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView
 * JD-Core Version:    0.7.0.1
 */