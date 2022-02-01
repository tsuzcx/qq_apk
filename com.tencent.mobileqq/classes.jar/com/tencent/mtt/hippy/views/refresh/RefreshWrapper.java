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
    } else {
      this.mContentView = paramView;
    }
    super.addView(paramView, paramInt);
  }
  
  void bounceToHead(float paramFloat)
  {
    Object localObject1 = this.mContentView;
    if ((localObject1 != null) && (this.mRefreshWrapperItemView != null))
    {
      localObject1 = ObjectAnimator.ofFloat(localObject1, "TranslationY", new float[] { ((View)localObject1).getTranslationY(), paramFloat });
      ((Animator)localObject1).setDuration(this.mBounceTime);
      ((Animator)localObject1).setInterpolator(new AccelerateInterpolator());
      Object localObject2 = this.mRefreshWrapperItemView;
      localObject2 = ObjectAnimator.ofFloat(localObject2, "TranslationY", new float[] { ((RefreshWrapperItemView)localObject2).getTranslationY(), paramFloat });
      ((Animator)localObject2).setInterpolator(new AccelerateInterpolator());
      ((Animator)localObject2).setDuration(this.mBounceTime);
      ((Animator)localObject1).start();
      ((Animator)localObject2).start();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getRawY();
    float f1 = paramMotionEvent.getRawX();
    if ((this.mContentView != null) && (this.mRefreshWrapperItemView != null))
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            if (f2 - this.mStartY > 0.0F)
            {
              if (getCompactScrollY() == 0.0F)
              {
                float f3 = this.mStartDownY;
                if (f3 == -1.0F)
                {
                  this.mStartDownY = f2;
                }
                else
                {
                  this.mTansY = ((f2 - f3) / 3.0F);
                  setSTranslationY(this.mTansY + this.mStartTransY);
                  sendOnScrollEvent(-this.mTansY);
                }
                if (Math.abs(f1 - this.mStartX) < Math.abs(f2 - this.mStartY)) {
                  return true;
                }
              }
            }
            else if (this.mState == RefreshWrapper.RefreshState.Loading)
            {
              f2 -= this.mStartY;
              if (this.mRefreshWrapperItemView.getTranslationY() > 0.0F)
              {
                setSTranslationY(this.mStartTransY + f2);
                if (Math.abs(f1 - this.mStartX) < Math.abs(f2)) {
                  return true;
                }
              }
            }
          }
        }
        else
        {
          if (this.mState == RefreshWrapper.RefreshState.Init)
          {
            if ((this.mTansY < this.mRefreshWrapperItemView.getHeight()) && (this.mRefreshWrapperItemView.getTranslationY() > 0.0F))
            {
              bounceToHead(0.0F);
              if (Math.abs(f1 - this.mStartX) >= Math.abs(f2 - this.mStartY)) {
                break label380;
              }
            }
            else
            {
              if (this.mTansY <= this.mRefreshWrapperItemView.getHeight()) {
                break label380;
              }
              startRefresh();
              if (Math.abs(f1 - this.mStartX) >= Math.abs(f2 - this.mStartY)) {
                break label380;
              }
            }
          }
          else
          {
            if ((this.mState != RefreshWrapper.RefreshState.Loading) || (this.mRefreshWrapperItemView.getTranslationY() <= this.mRefreshWrapperItemView.getHeight())) {
              break label380;
            }
            startRefresh();
            if (Math.abs(f1 - this.mStartX) >= Math.abs(f2 - this.mStartY)) {
              break label380;
            }
          }
          sendCancelEvent(paramMotionEvent);
          label380:
          this.mStartDownY = -1.0F;
        }
      }
      else
      {
        this.mStartY = paramMotionEvent.getRawY();
        this.mStartX = paramMotionEvent.getRawX();
        this.mStartTransY = this.mRefreshWrapperItemView.getTranslationY();
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  float getCompactScrollY()
  {
    View localView = this.mContentView;
    if ((localView instanceof HippyListView)) {}
    for (int i = ((HippyListView)localView).getOffsetY();; i = localView.getScrollY()) {
      return i;
    }
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
    if (this.mScrollEventEnable)
    {
      long l = System.currentTimeMillis();
      if (l - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle) {
        return;
      }
      new HippyViewEvent("onScroll").send(this, generateScrollEvent(paramFloat));
      this.mLastScrollEventTimeStamp = l;
    }
  }
  
  public void setOnScrollEventEnable(boolean paramBoolean)
  {
    this.mScrollEventEnable = paramBoolean;
  }
  
  void setSTranslationY(float paramFloat)
  {
    Object localObject = this.mRefreshWrapperItemView;
    if (localObject != null)
    {
      float f;
      if (paramFloat > 0.0F) {
        f = paramFloat;
      } else {
        f = 0.0F;
      }
      ((RefreshWrapperItemView)localObject).setTranslationY(f);
    }
    localObject = this.mContentView;
    if (localObject != null)
    {
      if (paramFloat <= 0.0F) {
        paramFloat = 0.0F;
      }
      ((View)localObject).setTranslationY(paramFloat);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.refresh.RefreshWrapper
 * JD-Core Version:    0.7.0.1
 */