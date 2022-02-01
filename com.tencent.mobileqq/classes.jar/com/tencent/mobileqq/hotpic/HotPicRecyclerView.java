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
  public static boolean e = false;
  int b = 0;
  int[] c = new int[3];
  boolean d = false;
  HotPicRecyclerView.PullAndFastScrollListener f;
  ScrollVelometer g = new ScrollVelometer(200, this);
  HotPicRecyclerView.ScrollStatusChengedListener h;
  boolean i = false;
  
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
  
  void a()
  {
    Object localObject1 = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject1);
    int j = localObject1[0];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastCompletelyVisibleItemPositions((int[])localObject1);
    int k = localObject1[0];
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" nEndIndex = ");
    ((StringBuilder)localObject1).append(j);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" nCompletelyEndIndex = ");
    ((StringBuilder)localObject2).append(k);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstVisibleItemPositions((int[])localObject2);
    j = localObject2[0];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions((int[])localObject2);
    k = localObject2[0];
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" nStartIndex = ");
    ((StringBuilder)localObject2).append(j);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" nCompletelyStartIndex = ");
    ((StringBuilder)localObject2).append(k);
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
    int j = localObject[0];
    int[] arrayOfInt = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
    int k = arrayOfInt[0];
    if ((j == -1) && (k == -1)) {}
    do
    {
      paramInt1 = 0;
      break;
      if ((paramInt1 < k) || ((paramInt1 > j) && (j >= 0))) {
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
    if (paramInt2 < k)
    {
      smoothScrollToPosition(paramInt2);
      return;
    }
    if ((paramInt2 > j) && (j >= 0))
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
    if ((paramBoolean) && (this.f != null) && (HotPicPageView.z)) {
      this.f.c();
    }
    this.g.a(false);
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
    int j = localObject[0];
    localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions((int[])localObject);
    int k = localObject[0];
    if ((j == -1) && (k == -1))
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
    if (paramInt >= k) {
      return (paramInt > j) && (j >= 0);
    }
    return true;
  }
  
  public void b()
  {
    HotPicRecyclerView.ScrollStatusChengedListener localScrollStatusChengedListener = this.h;
    if (localScrollStatusChengedListener != null) {
      localScrollStatusChengedListener.g();
    }
    this.i = false;
  }
  
  public void c()
  {
    if (this.i) {
      return;
    }
    this.i = true;
    HotPicRecyclerView.ScrollStatusChengedListener localScrollStatusChengedListener = this.h;
    if (localScrollStatusChengedListener != null) {
      localScrollStatusChengedListener.f();
    }
  }
  
  public int d()
  {
    Object localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions((int[])localObject);
    int j = localObject[0];
    if (j >= 0) {
      return j;
    }
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstVisibleItemPositions((int[])localObject);
    j = localObject[0];
    localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject);
    int k = localObject[0];
    if (j == k) {
      return j;
    }
    localObject = findViewHolderForPosition(j);
    RecyclerView.ViewHolder localViewHolder = findViewHolderForPosition(k);
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
      return j;
    }
    return k;
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
    HotPicPageView.z = true;
    if (paramMotionEvent.getAction() == 1)
    {
      ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions(this.c);
      if (this.c[0] == 0)
      {
        HotPicRecyclerView.PullAndFastScrollListener localPullAndFastScrollListener = this.f;
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
    this.h = paramScrollStatusChengedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicRecyclerView
 * JD-Core Version:    0.7.0.1
 */