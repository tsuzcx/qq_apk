package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class HotPicRecyclerView
  extends FooterRecyclerView
  implements ScrollVelometer.SpeedListener
{
  public static boolean b = false;
  int jdField_a_of_type_Int = 0;
  HotPicRecyclerView.PullAndFastScrollListener jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$PullAndFastScrollListener;
  HotPicRecyclerView.ScrollStatusChengedListener jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$ScrollStatusChengedListener;
  ScrollVelometer jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer = new ScrollVelometer(200, this);
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[3];
  boolean c = false;
  
  public HotPicRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HotPicRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnScrollListener(new HotPicRecyclerView.1(this));
  }
  
  public static void a(String paramString)
  {
    Object localObject = "LogAutoScrollInfo ";
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LogAutoScrollInfo ");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotPicRecyclerView", 2, (String)localObject);
    }
  }
  
  public int a()
  {
    Object localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    if (i >= 0) {
      return i;
    }
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstVisibleItemPositions((int[])localObject);
    i = localObject[0];
    localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject);
    int j = localObject[0];
    if (i == j) {
      return i;
    }
    localObject = findViewHolderForPosition(i);
    RecyclerView.ViewHolder localViewHolder = findViewHolderForPosition(j);
    float f2 = 0.0F;
    float f1;
    if (localObject != null) {
      f1 = ((RecyclerView.ViewHolder)localObject).itemView.getBottom() / ((RecyclerView.ViewHolder)localObject).itemView.getHeight();
    } else {
      f1 = 0.0F;
    }
    if (localViewHolder != null) {
      f2 = (getHeight() - localViewHolder.itemView.getTop()) / localViewHolder.itemView.getHeight();
    }
    if (f1 >= f2) {
      return i;
    }
    return j;
  }
  
  void a()
  {
    Object localObject1 = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject1);
    int i = localObject1[0];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastCompletelyVisibleItemPositions((int[])localObject1);
    int j = localObject1[0];
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" nEndIndex = ");
    ((StringBuilder)localObject1).append(i);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" nCompletelyEndIndex = ");
    ((StringBuilder)localObject2).append(j);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstVisibleItemPositions((int[])localObject2);
    i = localObject2[0];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions((int[])localObject2);
    j = localObject2[0];
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" nStartIndex = ");
    ((StringBuilder)localObject2).append(i);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" nCompletelyStartIndex = ");
    ((StringBuilder)localObject2).append(j);
    localObject1 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel()) {
      QLog.i("HotPicRecyclerView", 2, (String)localObject1);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ScrollItem Start nScollFromIndex is ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" nScrollToIndex is ");
    ((StringBuilder)localObject).append(paramInt2);
    a(((StringBuilder)localObject).toString());
    a();
    localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastCompletelyVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    int[] arrayOfInt = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
    int j = arrayOfInt[0];
    if ((i == -1) && (j == -1)) {}
    do
    {
      paramInt1 = 0;
      break;
      if ((paramInt1 < j) || ((paramInt1 > i) && (i >= 0))) {
        break label265;
      }
      localObject = findViewHolderForPosition(paramInt1);
    } while (localObject == null);
    paramInt1 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
    localObject = findViewHolderForPosition(paramInt2);
    if (localObject != null)
    {
      paramInt2 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("StartY = ");
      ((StringBuilder)localObject).append(paramInt1);
      a(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EndY = ");
      ((StringBuilder)localObject).append(paramInt2);
      a(((StringBuilder)localObject).toString());
      paramInt2 -= paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = paramInt2 + 1;
      }
      smoothScrollBy(0, paramInt1);
      return;
    }
    smoothScrollToPosition(paramInt2);
    return;
    label265:
    if (paramInt2 < j)
    {
      smoothScrollToPosition(paramInt2);
      return;
    }
    if ((paramInt2 > i) && (i >= 0))
    {
      ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject);
      paramInt1 = localObject[0];
      if (paramInt2 == paramInt1)
      {
        localObject = findViewHolderForPosition(paramInt1);
        if (localObject != null)
        {
          paramInt2 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
          paramInt1 = paramInt2;
          if (paramInt2 == 0) {
            paramInt1 = paramInt2 + 1;
          }
          smoothScrollBy(0, paramInt1);
          return;
        }
        smoothScrollToPosition(paramInt2);
        return;
      }
      if (paramInt2 == paramInt1 + 1)
      {
        localObject = findViewHolderForPosition(paramInt1);
        if (localObject != null)
        {
          paramInt2 = ((RecyclerView.ViewHolder)localObject).itemView.getBottom();
          paramInt1 = paramInt2;
          if (paramInt2 == 0) {
            paramInt1 = paramInt2 + 1;
          }
          smoothScrollBy(0, paramInt1);
          return;
        }
        smoothScrollToPosition(paramInt2);
        return;
      }
      smoothScrollToPosition(paramInt2);
      return;
    }
    localObject = findViewHolderForPosition(paramInt2);
    if (localObject != null)
    {
      paramInt2 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = paramInt2 + 1;
      }
      smoothScrollBy(0, paramInt1);
      return;
    }
    smoothScrollToPosition(paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$PullAndFastScrollListener != null) && (HotPicPageView.b)) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$PullAndFastScrollListener.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer.a(false);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CheckItemIsNeedToScroll Start nCheckIndex is ");
    ((StringBuilder)localObject).append(paramInt);
    a(((StringBuilder)localObject).toString());
    a();
    localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastCompletelyVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions((int[])localObject);
    int j = localObject[0];
    if ((i == -1) && (j == -1))
    {
      localObject = findViewHolderForPosition(paramInt);
      if (localObject == null) {
        return false;
      }
      if (((RecyclerView.ViewHolder)localObject).itemView != null) {
        paramInt = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
      } else {
        paramInt = 0;
      }
      return paramInt != 0;
    }
    if (paramInt >= j) {
      return (paramInt > i) && (i >= 0);
    }
    return true;
  }
  
  public void b()
  {
    HotPicRecyclerView.ScrollStatusChengedListener localScrollStatusChengedListener = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$ScrollStatusChengedListener;
    if (localScrollStatusChengedListener != null) {
      localScrollStatusChengedListener.g();
    }
    this.c = false;
  }
  
  public void c()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    HotPicRecyclerView.ScrollStatusChengedListener localScrollStatusChengedListener = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$ScrollStatusChengedListener;
    if (localScrollStatusChengedListener != null) {
      localScrollStatusChengedListener.f();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    HotPicPageView.b = true;
    if (paramMotionEvent.getAction() == 1)
    {
      ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions(this.jdField_a_of_type_ArrayOfInt);
      if (this.jdField_a_of_type_ArrayOfInt[0] == 0)
      {
        HotPicRecyclerView.PullAndFastScrollListener localPullAndFastScrollListener = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$PullAndFastScrollListener;
        if (localPullAndFastScrollListener != null) {
          localPullAndFastScrollListener.d();
        }
      }
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public void setScrollStatusChengedListener(HotPicRecyclerView.ScrollStatusChengedListener paramScrollStatusChengedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$ScrollStatusChengedListener = paramScrollStatusChengedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicRecyclerView
 * JD-Core Version:    0.7.0.1
 */