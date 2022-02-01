package com.tencent.mtt.hippy.views.refresh;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class RefreshWrapper
  extends HippyViewGroup
{
  int mBounceTime = 300;
  View mContentView;
  private long mLastScrollEventTimeStamp = -1L;
  RefreshWrapperItemView mRefreshWrapperItemView;
  protected boolean mScrollEventEnable = true;
  protected int mScrollEventThrottle = 400;
  float mStartDownY = -1.0F;
  float mStartTransY = 0.0F;
  float mStartX = 0.0F;
  float mStartY = 0.0F;
  RefreshWrapper.RefreshState mState = RefreshWrapper.RefreshState.Init;
  float mTansY = -1.0F;
  
  public RefreshWrapper(Context paramContext)
  {
    super(paramContext);
  }
  
  private HippyMap generateScrollEvent(float paramFloat)
  {
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushDouble("x", PixelUtil.px2dp(0.0F));
    localHippyMap1.pushDouble("y", PixelUtil.px2dp(paramFloat));
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushMap("contentOffset", localHippyMap1);
    return localHippyMap2;
  }
  
  public void addView(View paramView, int paramInt)
  {
    if ((paramView instanceof RefreshWrapperItemView)) {
      this.mRefreshWrapperItemView = ((RefreshWrapperItemView)paramView);
    }
    for (;;)
    {
      super.addView(paramView, paramInt);
      return;
      this.mContentView = paramView;
    }
  }
  
  void bounceToHead(float paramFloat)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mContentView, "TranslationY", new float[] { this.mContentView.getTranslationY(), paramFloat });
    localObjectAnimator1.setDuration(this.mBounceTime);
    localObjectAnimator1.setInterpolator(new AccelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mRefreshWrapperItemView, "TranslationY", new float[] { this.mRefreshWrapperItemView.getTranslationY(), paramFloat });
    localObjectAnimator2.setInterpolator(new AccelerateInterpolator());
    localObjectAnimator2.setDuration(this.mBounceTime);
    localObjectAnimator1.start();
    localObjectAnimator2.start();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getRawY();
    float f1 = paramMotionEvent.getRawX();
    if ((this.mContentView != null) && (this.mRefreshWrapperItemView != null)) {}
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return super.dispatchTouchEvent(paramMotionEvent);
                this.mStartY = paramMotionEvent.getRawY();
                this.mStartX = paramMotionEvent.getRawX();
                this.mStartTransY = this.mRefreshWrapperItemView.getTranslationY();
              }
              if (f2 - this.mStartY <= 0.0F) {
                break;
              }
            } while (getCompactScrollY() != 0.0F);
            if (this.mStartDownY == -1.0F) {
              this.mStartDownY = f2;
            }
            while (Math.abs(f1 - this.mStartX) < Math.abs(f2 - this.mStartY))
            {
              return true;
              this.mTansY = ((f2 - this.mStartDownY) / 3.0F);
              setSTranslationY(this.mTansY + this.mStartTransY);
              sendOnScrollEvent(-this.mTansY);
            }
          } while (this.mState != RefreshWrapper.RefreshState.Loading);
          f2 -= this.mStartY;
        } while (this.mRefreshWrapperItemView.getTranslationY() <= 0.0F);
        setSTranslationY(this.mStartTransY + f2);
      } while (Math.abs(f1 - this.mStartX) >= Math.abs(f2));
      return true;
    }
    if (this.mState == RefreshWrapper.RefreshState.Init) {
      if ((this.mTansY < this.mRefreshWrapperItemView.getHeight()) && (this.mRefreshWrapperItemView.getTranslationY() > 0.0F))
      {
        bounceToHead(0.0F);
        if (Math.abs(f1 - this.mStartX) < Math.abs(f2 - this.mStartY)) {
          sendCancelEvent(paramMotionEvent);
        }
      }
    }
    for (;;)
    {
      this.mStartDownY = -1.0F;
      break;
      if (this.mTansY > this.mRefreshWrapperItemView.getHeight())
      {
        startRefresh();
        if (Math.abs(f1 - this.mStartX) < Math.abs(f2 - this.mStartY))
        {
          sendCancelEvent(paramMotionEvent);
          continue;
          if ((this.mState == RefreshWrapper.RefreshState.Loading) && (this.mRefreshWrapperItemView.getTranslationY() > this.mRefreshWrapperItemView.getHeight()))
          {
            startRefresh();
            if (Math.abs(f1 - this.mStartX) < Math.abs(f2 - this.mStartY)) {
              sendCancelEvent(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  float getCompactScrollY()
  {
    if ((this.mContentView instanceof HippyListView)) {
      return ((HippyListView)this.mContentView).getOffsetY();
    }
    return this.mContentView.getScrollY();
  }
  
  public void refreshComplected()
  {
    bounceToHead(0.0F);
    this.mState = RefreshWrapper.RefreshState.Init;
  }
  
  public void sendCancelEvent(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    this.mContentView.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void sendOnScrollEvent(float paramFloat)
  {
    long l;
    if (this.mScrollEventEnable)
    {
      l = System.currentTimeMillis();
      if (l - this.mLastScrollEventTimeStamp >= this.mScrollEventThrottle) {}
    }
    else
    {
      return;
    }
    new HippyViewEvent("onScroll").send(this, generateScrollEvent(paramFloat));
    this.mLastScrollEventTimeStamp = l;
  }
  
  public void setOnScrollEventEnable(boolean paramBoolean)
  {
    this.mScrollEventEnable = paramBoolean;
  }
  
  void setSTranslationY(float paramFloat)
  {
    Object localObject;
    float f;
    if (this.mRefreshWrapperItemView != null)
    {
      localObject = this.mRefreshWrapperItemView;
      if (paramFloat > 0.0F)
      {
        f = paramFloat;
        ((RefreshWrapperItemView)localObject).setTranslationY(f);
      }
    }
    else if (this.mContentView != null)
    {
      localObject = this.mContentView;
      if (paramFloat <= 0.0F) {
        break label54;
      }
    }
    for (;;)
    {
      ((View)localObject).setTranslationY(paramFloat);
      return;
      f = 0.0F;
      break;
      label54:
      paramFloat = 0.0F;
    }
  }
  
  public void setScrollEventThrottle(int paramInt)
  {
    this.mScrollEventThrottle = paramInt;
  }
  
  public void setTime(int paramInt)
  {
    this.mBounceTime = paramInt;
  }
  
  public void startRefresh()
  {
    this.mTansY = -1.0F;
    bounceToHead(this.mRefreshWrapperItemView.getHeight());
    this.mState = RefreshWrapper.RefreshState.Loading;
    new HippyViewEvent("onRefresh").send(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.refresh.RefreshWrapper
 * JD-Core Version:    0.7.0.1
 */