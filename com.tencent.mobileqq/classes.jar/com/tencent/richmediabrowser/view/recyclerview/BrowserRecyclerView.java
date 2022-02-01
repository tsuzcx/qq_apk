package com.tencent.richmediabrowser.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;

public class BrowserRecyclerView
  extends RecyclerView
{
  private static final int FLING_MAX_VELOCITY = 600;
  private static final String TAG = "BrowserRecyclerView";
  private boolean isIntercept = false;
  public LinearLayoutManager linearLayoutManager;
  public PagerSnapHelper linearSnapHelper;
  private float mLastX;
  private float mLastY;
  private MainBrowserPresenter mMainBrowserPresenter;
  
  public BrowserRecyclerView(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  public BrowserRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public BrowserRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int solveVelocity(int paramInt)
  {
    if (paramInt > 0) {
      return Math.min(paramInt, 600);
    }
    return Math.max(paramInt, -600);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 1)
    {
      if (i == 5) {
        this.isIntercept = true;
      }
    }
    else {
      this.isIntercept = false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    return super.fling(solveVelocity(paramInt1), solveVelocity(paramInt2));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getActionMasked();
    MainBrowserPresenter localMainBrowserPresenter;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 5)
          {
            localMainBrowserPresenter = this.mMainBrowserPresenter;
            if (localMainBrowserPresenter != null) {
              localMainBrowserPresenter.requestDisallowInterceptDragEvent(true);
            }
            this.isIntercept = true;
          }
        }
        else
        {
          localMainBrowserPresenter = this.mMainBrowserPresenter;
          if (localMainBrowserPresenter != null) {
            localMainBrowserPresenter.requestDisallowInterceptDragEvent(true);
          }
          localMainBrowserPresenter = this.mMainBrowserPresenter;
          if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.isNeedDisallowInterceptEvent(paramMotionEvent)))
          {
            requestDisallowInterceptTouchEvent(true);
            return false;
          }
          float f3 = f1 - this.mLastX;
          float f4 = f2 - this.mLastY;
          if ((f4 > 0.0F) && (Math.abs(f4) / Math.abs(f3) >= 6.0F) && (Math.abs(f3) < 10.0F))
          {
            localMainBrowserPresenter = this.mMainBrowserPresenter;
            if (localMainBrowserPresenter != null) {
              localMainBrowserPresenter.requestDisallowInterceptDragEvent(false);
            }
          }
          this.mLastX = f1;
          this.mLastY = f2;
        }
      }
      else {
        this.isIntercept = false;
      }
    }
    else
    {
      localMainBrowserPresenter = this.mMainBrowserPresenter;
      if (localMainBrowserPresenter != null) {
        localMainBrowserPresenter.requestDisallowInterceptDragEvent(true);
      }
      this.mLastX = 0.0F;
      this.mLastY = 0.0F;
    }
    if (this.isIntercept) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setLinearLayoutManager(LinearLayoutManager paramLinearLayoutManager)
  {
    this.linearLayoutManager = paramLinearLayoutManager;
  }
  
  public void setMainBrowserPresenter(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mMainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  public void setPageSnapHelper(PagerSnapHelper paramPagerSnapHelper)
  {
    this.linearSnapHelper = paramPagerSnapHelper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView
 * JD-Core Version:    0.7.0.1
 */