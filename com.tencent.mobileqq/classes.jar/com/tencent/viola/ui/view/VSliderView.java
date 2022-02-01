package com.tencent.viola.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.viola.ui.adapter.VLoopAbleSliderAdapter;
import com.tencent.viola.ui.component.VSlider;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class VSliderView
  extends ViewPager
  implements IVView<VSlider>
{
  public static final String TAG = "VSliderView";
  private VLoopAbleSliderAdapter mAdapter;
  private VSliderView.AutoSidleTimer mAutoSidleTimer;
  public int mCurrentItemIndex = 0;
  private Boolean mIsAutoMode = Boolean.valueOf(true);
  private boolean mIsScrollable;
  private VSliderView.VSliderListener mListener;
  private ViewPager.OnPageChangeListener mPageChangeListener;
  private float mStartRawX = -1.0F;
  private float mStartRawY = -1.0F;
  private int mTimeInterval = 2000;
  protected int mTouchSlop;
  private WeakReference<VSlider> mWeakReference;
  
  public VSliderView(Context paramContext, VLoopAbleSliderAdapter paramVLoopAbleSliderAdapter)
  {
    super(paramContext);
    setAdapter(paramVLoopAbleSliderAdapter);
    if (paramVLoopAbleSliderAdapter != null)
    {
      this.mAdapter = paramVLoopAbleSliderAdapter;
      setOffscreenPageLimit(2);
    }
    if ((this.mIsAutoMode.booleanValue()) && (this.mAutoSidleTimer == null)) {
      this.mAutoSidleTimer = new VSliderView.AutoSidleTimer(this, this);
    }
    this.mPageChangeListener = new VSliderView.1(this);
    setOnPageChangeListener(this.mPageChangeListener);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void setCurrentItemInMode()
  {
    if (this.mIsAutoMode.booleanValue())
    {
      VLoopAbleSliderAdapter localVLoopAbleSliderAdapter = this.mAdapter;
      if ((localVLoopAbleSliderAdapter != null) && (this.mAutoSidleTimer != null) && (this.mIsScrollable))
      {
        this.mCurrentItemIndex += 1;
        if (this.mCurrentItemIndex == localVLoopAbleSliderAdapter.getCount()) {
          this.mCurrentItemIndex = 0;
        }
        setCurrentItem(this.mCurrentItemIndex);
        ViolaLogUtils.i("VSliderView", "定时器setItem");
      }
    }
  }
  
  public void bindComponent(VSlider paramVSlider)
  {
    this.mWeakReference = new WeakReference(paramVSlider);
  }
  
  public void destroy()
  {
    if (this.mPageChangeListener != null) {
      this.mPageChangeListener = null;
    }
    if (this.mAutoSidleTimer != null)
    {
      stopPlay();
      this.mAutoSidleTimer.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        startPlay();
      }
    }
    else {
      stopPlay();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public VSlider getComponent()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null) {
      return (VSlider)localWeakReference.get();
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mFirstLayout");
      localField.setAccessible(true);
      localField.set(this, Boolean.valueOf(false));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    startPlay();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mAutoSidleTimer != null)
    {
      stopPlay();
      this.mAutoSidleTimer.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mIsScrollable) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    ViewParent localViewParent = getParent();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label185;
          }
        }
        else
        {
          float f3 = paramMotionEvent.getRawY();
          float f1 = paramMotionEvent.getRawX();
          float f2 = this.mStartRawX;
          f3 -= this.mStartRawY;
          if ((Math.abs(f3) > this.mTouchSlop) && (Math.abs(f1 - f2) / Math.abs(f3) < 0.5F) && (localViewParent != null))
          {
            localViewParent.requestDisallowInterceptTouchEvent(false);
            break label185;
          }
          if (localViewParent == null) {
            break label185;
          }
          localViewParent.requestDisallowInterceptTouchEvent(true);
          break label185;
        }
      }
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
    }
    else
    {
      if (getParent() != null) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      this.mStartRawY = paramMotionEvent.getRawY();
      this.mStartRawX = paramMotionEvent.getRawX();
    }
    label185:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mIsScrollable) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsAutoMode(boolean paramBoolean)
  {
    this.mIsAutoMode = Boolean.valueOf(paramBoolean);
    startPlay();
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.mIsScrollable = paramBoolean;
  }
  
  public void setSliderListener(VSliderView.VSliderListener paramVSliderListener)
  {
    this.mListener = paramVSliderListener;
  }
  
  public void setStartIndexWithNoAnimate(int paramInt)
  {
    VLoopAbleSliderAdapter localVLoopAbleSliderAdapter = this.mAdapter;
    if (localVLoopAbleSliderAdapter == null) {
      return;
    }
    paramInt += localVLoopAbleSliderAdapter.getInitPosition();
    setCurrentItem(paramInt, false);
    this.mCurrentItemIndex = paramInt;
  }
  
  public void setStartItemIndex(int paramInt)
  {
    VLoopAbleSliderAdapter localVLoopAbleSliderAdapter = this.mAdapter;
    if (localVLoopAbleSliderAdapter == null) {
      return;
    }
    paramInt += localVLoopAbleSliderAdapter.getInitPosition();
    setCurrentItem(paramInt);
    this.mCurrentItemIndex = paramInt;
  }
  
  public void setTimeInterval(int paramInt)
  {
    this.mTimeInterval = paramInt;
  }
  
  public void startPlay()
  {
    if (this.mAdapter == null) {
      return;
    }
    if (this.mIsAutoMode.booleanValue())
    {
      VSliderView.AutoSidleTimer localAutoSidleTimer = this.mAutoSidleTimer;
      if (localAutoSidleTimer == null)
      {
        this.mAutoSidleTimer = new VSliderView.AutoSidleTimer(this, this);
        this.mAutoSidleTimer.startTimer(this.mTimeInterval);
        return;
      }
      localAutoSidleTimer.startTimer(this.mTimeInterval);
    }
  }
  
  public void stopPlay()
  {
    Object localObject = this.mAdapter;
    if (localObject != null)
    {
      if (((VLoopAbleSliderAdapter)localObject).getCount() <= 1) {
        return;
      }
      if (this.mIsAutoMode.booleanValue())
      {
        localObject = this.mAutoSidleTimer;
        if (localObject != null) {
          ((VSliderView.AutoSidleTimer)localObject).stopTimer();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSliderView
 * JD-Core Version:    0.7.0.1
 */