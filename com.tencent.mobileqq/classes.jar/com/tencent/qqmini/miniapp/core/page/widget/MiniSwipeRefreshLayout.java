package com.tencent.qqmini.miniapp.core.page.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

public class MiniSwipeRefreshLayout
  extends SwipeRefreshLayout
{
  public static final String TAG = "MiniSwipeRefreshLayout";
  private float density;
  boolean ismove = false;
  private float mInitialDownX;
  private float mInitialDownY;
  private int mTouchSlop;
  
  public MiniSwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MiniSwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.density = DisplayUtil.getDensity(getContext());
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        float f1 = Math.abs(paramMotionEvent.getX() - this.mInitialDownX);
        float f2 = Math.abs(paramMotionEvent.getY() - this.mInitialDownY);
        if (f2 < this.mTouchSlop) {
          return false;
        }
        if (f1 > f2) {
          return false;
        }
      }
    }
    else
    {
      this.mInitialDownX = paramMotionEvent.getX();
      this.mInitialDownY = paramMotionEvent.getY();
      this.ismove = false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setTouchSlop(int paramInt)
  {
    this.mTouchSlop = ((int)(paramInt * this.density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniSwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */