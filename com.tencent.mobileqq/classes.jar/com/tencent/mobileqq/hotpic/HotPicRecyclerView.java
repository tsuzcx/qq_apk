package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import asqn;
import asqo;
import asqp;
import assb;
import assc;
import com.tencent.qphone.base.util.QLog;

public class HotPicRecyclerView
  extends FooterRecyclerView
  implements assc
{
  public int a;
  public asqo a;
  asqp jdField_a_of_type_Asqp;
  public assb a;
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  boolean b = false;
  
  public HotPicRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HotPicRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_a_of_type_Assb = new assb(200, this);
    setOnScrollListener(new asqn(this));
  }
  
  public static void a(String paramString)
  {
    String str = "LogAutoScrollInfo ";
    if (paramString != null) {
      str = "LogAutoScrollInfo " + paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotPicRecyclerView", 2, str);
    }
  }
  
  public int a()
  {
    float f2 = 0.0F;
    Object localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    if (i >= 0) {
      return i;
    }
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstVisibleItemPositions((int[])localObject);
    int j = localObject[0];
    localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject);
    i = localObject[0];
    if (j == i) {
      return j;
    }
    localObject = findViewHolderForPosition(j);
    RecyclerView.ViewHolder localViewHolder = findViewHolderForPosition(i);
    if (localObject != null) {}
    for (float f1 = ((RecyclerView.ViewHolder)localObject).itemView.getBottom() / ((RecyclerView.ViewHolder)localObject).itemView.getHeight();; f1 = 0.0F)
    {
      if (localViewHolder != null) {
        f2 = (getHeight() - localViewHolder.itemView.getTop()) / localViewHolder.itemView.getHeight();
      }
      if (f1 < f2) {
        break;
      }
      return j;
    }
  }
  
  void a()
  {
    Object localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastCompletelyVisibleItemPositions((int[])localObject);
    int j = localObject[0];
    localObject = " nEndIndex = " + i;
    localObject = (String)localObject + " nCompletelyEndIndex = " + j;
    int[] arrayOfInt = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstVisibleItemPositions(arrayOfInt);
    i = arrayOfInt[0];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
    j = arrayOfInt[0];
    localObject = (String)localObject + " nStartIndex = " + i;
    localObject = (String)localObject + " nCompletelyStartIndex = " + j;
    if (QLog.isColorLevel()) {
      QLog.i("HotPicRecyclerView", 2, (String)localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a("ScrollItem Start nScollFromIndex is " + paramInt1 + " nScrollToIndex is " + paramInt2);
    a();
    Object localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastCompletelyVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    int[] arrayOfInt = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
    int j = arrayOfInt[0];
    if ((i == -1) && (j == -1)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      localObject = findViewHolderForPosition(paramInt2);
      if (localObject != null)
      {
        paramInt2 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
        a("StartY = " + paramInt1);
        a("EndY = " + paramInt2);
        paramInt2 -= paramInt1;
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = paramInt2 + 1;
        }
        smoothScrollBy(0, paramInt1);
        return;
        if ((paramInt1 < j) || ((paramInt1 > i) && (i >= 0)))
        {
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
          return;
        }
        localObject = findViewHolderForPosition(paramInt1);
        if (localObject != null) {
          paramInt1 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
        }
      }
      else
      {
        smoothScrollToPosition(paramInt2);
        return;
      }
      paramInt1 = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Asqo != null) && (HotPicPageView.b)) {
      this.jdField_a_of_type_Asqo.c();
    }
    this.jdField_a_of_type_Assb.a(false);
  }
  
  public boolean a(int paramInt)
  {
    a("CheckItemIsNeedToScroll Start nCheckIndex is " + paramInt);
    a();
    Object localObject = new int[1];
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
      if (((RecyclerView.ViewHolder)localObject).itemView == null) {
        break label145;
      }
    }
    label145:
    for (paramInt = ((RecyclerView.ViewHolder)localObject).itemView.getTop();; paramInt = 0)
    {
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      if ((paramInt >= j) && ((paramInt <= i) || (i < 0))) {
        break;
      }
      return true;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Asqp != null) {
      this.jdField_a_of_type_Asqp.g();
    }
    this.b = false;
  }
  
  public void c()
  {
    if (this.b) {}
    do
    {
      return;
      this.b = true;
    } while (this.jdField_a_of_type_Asqp == null);
    this.jdField_a_of_type_Asqp.f();
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
      if ((this.jdField_a_of_type_ArrayOfInt[0] == 0) && (this.jdField_a_of_type_Asqo != null)) {
        this.jdField_a_of_type_Asqo.d();
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
  
  public void setScrollStatusChengedListener(asqp paramasqp)
  {
    this.jdField_a_of_type_Asqp = paramasqp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicRecyclerView
 * JD-Core Version:    0.7.0.1
 */