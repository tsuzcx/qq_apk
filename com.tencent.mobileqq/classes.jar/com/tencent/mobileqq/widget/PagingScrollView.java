package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import benf;
import beng;
import benh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;

public class PagingScrollView
  extends ScrollView
{
  private boolean mCanScroll = true;
  protected GestureDetector mGestureDetector;
  public boolean mIsOnSpecialView = false;
  protected beng mScrollChangedListener;
  protected ArrayList<View> pagingViews;
  
  public PagingScrollView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PagingScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public void addPagingView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.pagingViews == null) {
      this.pagingViews = new ArrayList();
    }
    this.pagingViews.add(paramView);
    paramView.setOnTouchListener(new benf(this));
  }
  
  public void clearPagingViews()
  {
    if (this.pagingViews != null)
    {
      int i = 0;
      while (i < this.pagingViews.size())
      {
        ((View)this.pagingViews.get(i)).setOnTouchListener(null);
        i += 1;
      }
      this.pagingViews.clear();
    }
  }
  
  protected void init(Context paramContext)
  {
    if (Build.VERSION.SDK_INT > 8) {
      setOverScrollMode(0);
    }
    setFadingEdgeLength(0);
    this.mGestureDetector = new GestureDetector(paramContext, new benh(this));
  }
  
  protected boolean isOnView(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int j = arrayOfInt[1];
    int k = paramView.getHeight();
    int m = arrayOfInt[0];
    int n = arrayOfInt[0];
    int i1 = paramView.getWidth();
    return (paramFloat2 >= i) && (paramFloat2 < j + k) && (paramFloat1 > m) && (paramFloat1 < n + i1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i;
    if (j == 0) {
      if (this.pagingViews != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.pagingViews.size())
      {
        if (isOnView((View)this.pagingViews.get(i), f1, f2)) {
          this.mIsOnSpecialView = true;
        }
      }
      else
      {
        if (this.mIsOnSpecialView)
        {
          getParent().requestDisallowInterceptTouchEvent(true);
          if (QLog.isDevelopLevel()) {
            QLog.i("PageScrollView", 4, "P.ITE ACT_DOWNE onSpecialView");
          }
        }
        if ((this.mIsOnSpecialView) && ((j == 1) || (j == 3)))
        {
          this.mIsOnSpecialView = false;
          getParent().requestDisallowInterceptTouchEvent(false);
          this.mCanScroll = true;
          if (QLog.isDevelopLevel()) {
            QLog.i("PageScrollView", 4, "P.ITE ACT_UP or CANCEL");
          }
        }
        try
        {
          if (this.mIsOnSpecialView)
          {
            super.onInterceptTouchEvent(paramMotionEvent);
            return this.mGestureDetector.onTouchEvent(paramMotionEvent);
          }
          boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
          return bool;
        }
        catch (Exception paramMotionEvent)
        {
          paramMotionEvent.printStackTrace();
          return false;
        }
      }
      i += 1;
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mScrollChangedListener != null) {
      this.mScrollChangedListener.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsOnSpecialView)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 3))
      {
        this.mIsOnSpecialView = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        if (QLog.isDevelopLevel()) {
          QLog.i("PageScrollView", 4, "P.TE ACT_UP or CANCEL");
        }
      }
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void removePagingView(View paramView)
  {
    if (this.pagingViews != null)
    {
      int i = this.pagingViews.size() - 1;
      while (i >= 0)
      {
        if (this.pagingViews.get(i) == paramView)
        {
          ((View)this.pagingViews.get(i)).setOnTouchListener(null);
          this.pagingViews.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  public void setOnScrollChangedListener(beng parambeng)
  {
    this.mScrollChangedListener = parambeng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PagingScrollView
 * JD-Core Version:    0.7.0.1
 */