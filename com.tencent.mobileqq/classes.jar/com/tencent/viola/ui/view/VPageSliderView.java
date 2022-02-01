package com.tencent.viola.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.adapter.VSliderAdapter;
import com.tencent.viola.ui.component.VPage;
import com.tencent.viola.ui.component.VPage.PAGEVIEWSTATE;
import com.tencent.viola.ui.component.VPageSlider;
import com.tencent.viola.ui.view.verticalPageSlider.GestureDetectorCompat;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class VPageSliderView
  extends ViewPager
  implements IVView<VPageSlider>
{
  private static final int MIN_FLING_VELOCITY = 400;
  private static final float RATIO = 0.5F;
  private static final float SCROLL_WIDTH = 10.0F;
  private static final float SWIPE_X_MIN_THRESHOLD = 450.0F;
  public static final String TAG = "VSliderViewPager";
  private ViewConfiguration configuration;
  private List<VPageSliderView.VPagerSliderScrollListener> listeners = null;
  private VSliderAdapter mAdapter;
  private boolean mBouncesEnable = true;
  private int mCurrentItemIndex = 0;
  private int mCurrentPosition = 0;
  private String mFlexDirection = "horizontal";
  private GestureDetectorCompat mGestureDetector;
  private boolean mHandleDefault = true;
  private boolean mHasWillAppearFire = false;
  private boolean mHasWillDisappearFire = false;
  private boolean mInterruptEnable = false;
  private int mLastPositionOffsetPixels = 0;
  private VSliderView.VSliderListener mListener;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private ViewPager.OnPageChangeListener mPageChangeListener;
  private float mPreX = 0.0F;
  private Rect mRect = new Rect();
  private Boolean mScrollEnable = Boolean.valueOf(true);
  float mStartDragX = 0.0F;
  private int mStartItemIndex = 0;
  private float mStartRawX = -1.0F;
  private float mStartRawY = -1.0F;
  float mStartX = 0.0F;
  protected int mTouchSlop;
  private VelocityTracker mVelocityTracker = null;
  private WeakReference<VPageSlider> mWeakReference;
  
  public VPageSliderView(Context paramContext, VSliderAdapter paramVSliderAdapter, String paramString)
  {
    super(paramContext);
    setAdapter(paramVSliderAdapter);
    this.mFlexDirection = paramString;
    if (paramVSliderAdapter != null)
    {
      setOffscreenPageLimit(paramVSliderAdapter.getCount());
      this.mAdapter = paramVSliderAdapter;
    }
    setCurrentItem(this.mCurrentItemIndex);
    this.mPageChangeListener = new VPageSliderView.1(this);
    setOnPageChangeListener(this.mPageChangeListener);
    paramVSliderAdapter = ViewConfiguration.get(getContext());
    this.mTouchSlop = paramVSliderAdapter.getScaledTouchSlop();
    this.mMinimumVelocity = ((int)(paramContext.getResources().getDisplayMetrics().density * 400.0F));
    this.mMaximumVelocity = paramVSliderAdapter.getScaledMaximumFlingVelocity();
    initVerticalPage(paramContext);
  }
  
  private void changePageState(int paramInt, VPage.PAGEVIEWSTATE paramPAGEVIEWSTATE)
  {
    changeCurrentPageState(getComponent(), paramInt, paramPAGEVIEWSTATE);
  }
  
  private void fireOverScrollEvent(float paramFloat)
  {
    if (getComponent() != null) {
      getComponent().overScrollFireEvent(paramFloat);
    }
  }
  
  private void initVerticalPage(Context paramContext)
  {
    if (this.mFlexDirection.equals("vertical"))
    {
      setPageTransformer(true, new VPageSliderView.VerticalPageTransformer(this, null));
      setOverScrollMode(2);
      this.mGestureDetector = new GestureDetectorCompat(paramContext, new VPageSliderView.YScrollDetector(this));
    }
    if (shouldOptimizingExperience()) {}
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      paramContext = new PageSliderScroller(paramContext);
      paramContext.setDuration(300);
      localField.set(this, paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      ViolaLogUtils.e("VSliderViewPager", "initVerticalPage error :" + paramContext.getMessage());
    }
  }
  
  private void onTouchActionUp()
  {
    if (!this.mRect.isEmpty())
    {
      recoveryPosition();
      fireOverScrollEvent(0.0F);
    }
  }
  
  private void recoveryPosition()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(getLeft(), this.mRect.left, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(300L);
    startAnimation(localTranslateAnimation);
    layout(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
    this.mRect.setEmpty();
    this.mHandleDefault = true;
  }
  
  private boolean shouldOptimizingExperience()
  {
    return (this.mFlexDirection == "vertical") && (Build.VERSION.SDK_INT >= 28);
  }
  
  private MotionEvent swapXY(MotionEvent paramMotionEvent)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    paramMotionEvent.setLocation(paramMotionEvent.getY() / f2 * f1, paramMotionEvent.getX() / f1 * f2);
    return paramMotionEvent;
  }
  
  private void whetherConditionIsRight(float paramFloat)
  {
    if (this.mRect.isEmpty()) {
      this.mRect.set(getLeft(), getTop(), getRight(), getBottom());
    }
    this.mHandleDefault = false;
    if ((this.mInterruptEnable) && ((getParent() instanceof ViewGroup)))
    {
      ((ViewGroup)getParent()).requestDisallowInterceptTouchEvent(false);
      return;
    }
    layout(getLeft() + (int)(paramFloat * 0.5F), getTop(), getRight() + (int)(paramFloat * 0.5F), getBottom());
  }
  
  public void addScrollListener(VPageSliderView.VPagerSliderScrollListener paramVPagerSliderScrollListener)
  {
    if (paramVPagerSliderScrollListener == null) {
      return;
    }
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    this.listeners.add(paramVPagerSliderScrollListener);
  }
  
  public void bindComponent(VPageSlider paramVPageSlider)
  {
    this.mWeakReference = new WeakReference(paramVPageSlider);
    if ((getComponent() != null) && (getComponent().getInstance() != null) && (!TextUtils.isEmpty(getComponent().getInstance().getUrl()))) {
      this.mInterruptEnable = getComponent().getInstance().getUrl().contains("v_fromswitch=1");
    }
  }
  
  public void changeCurrentPageState(VPageSlider paramVPageSlider, int paramInt, VPage.PAGEVIEWSTATE paramPAGEVIEWSTATE)
  {
    if (((paramVPageSlider.getChild(paramInt) instanceof VPage)) && (((VPage)paramVPageSlider.getChild(paramInt)).getCurrentPageState() != paramPAGEVIEWSTATE))
    {
      ((VPage)paramVPageSlider.getChild(paramInt)).setCurrentPageState(paramPAGEVIEWSTATE);
      ViolaLogUtils.d("VSliderViewPager", "page状态转换测试 state:" + paramPAGEVIEWSTATE.name() + ",position:" + paramInt);
    }
  }
  
  public void changeTwoPage(int paramInt1, int paramInt2)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.changeItemByPosition(paramInt1, paramInt2);
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  public void destroy()
  {
    if (this.mPageChangeListener != null) {
      this.mPageChangeListener = null;
    }
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public VPageSlider getComponent()
  {
    if (this.mWeakReference != null) {
      return (VPageSlider)this.mWeakReference.get();
    }
    return null;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mFirstLayout");
      localField.setAccessible(true);
      localField.set(this, Boolean.valueOf(false));
      getAdapter().notifyDataSetChanged();
      setCurrentItem(getCurrentItem());
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VSliderViewPager", "onAttachedToWindow error :" + localException.getMessage());
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      ViewParent localViewParent;
      try
      {
        if (!this.mScrollEnable.booleanValue()) {
          return false;
        }
        if (this.mFlexDirection.equals("vertical"))
        {
          super.onInterceptTouchEvent(swapXY(paramMotionEvent));
          if ((shouldOptimizingExperience()) && (paramMotionEvent.getAction() == 0)) {
            this.mStartX = paramMotionEvent.getX();
          }
          swapXY(paramMotionEvent);
          return this.mGestureDetector.onTouchEvent(paramMotionEvent);
        }
        if (!this.mBouncesEnable) {
          return super.onInterceptTouchEvent(paramMotionEvent);
        }
        int i = paramMotionEvent.getAction();
        localViewParent = getParent();
        switch (i)
        {
        case 0: 
          return super.onInterceptTouchEvent(paramMotionEvent);
        }
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        ViolaLogUtils.e("VSliderViewPager", "onInterceptTouchEvent IllegalArgumentException error:" + paramMotionEvent.getMessage());
        return false;
      }
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
      this.mPreX = paramMotionEvent.getX();
      this.mCurrentPosition = getCurrentItem();
      this.mStartRawY = paramMotionEvent.getRawY();
      this.mStartRawX = paramMotionEvent.getRawX();
      continue;
      float f2 = paramMotionEvent.getRawY();
      float f1 = paramMotionEvent.getRawX() - this.mStartRawX;
      f2 -= this.mStartRawY;
      if (Math.abs(f2) > this.mTouchSlop)
      {
        if ((Math.abs(f1) / Math.abs(f2) < 0.5F) && (localViewParent != null))
        {
          localViewParent.requestDisallowInterceptTouchEvent(false);
          continue;
        }
        if (Math.abs(f1) / Math.abs(f2) > 0.75F) {
          return true;
        }
        if (localViewParent != null)
        {
          localViewParent.requestDisallowInterceptTouchEvent(false);
          continue;
        }
      }
      if (localViewParent != null)
      {
        localViewParent.requestDisallowInterceptTouchEvent(true);
        continue;
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (!this.mScrollEnable.booleanValue()) {
        return false;
      }
      if (this.mFlexDirection.equals("vertical"))
      {
        if (shouldOptimizingExperience())
        {
          if (getAdapter() == null) {
            break label955;
          }
          if ((getCurrentItem() >= 0) || (getCurrentItem() < getAdapter().getCount()))
          {
            if (this.mVelocityTracker == null) {
              this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(paramMotionEvent);
            swapXY(paramMotionEvent);
          }
        }
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        case 2: 
        case 1: 
          for (;;)
          {
            swapXY(paramMotionEvent);
            return super.onTouchEvent(swapXY(paramMotionEvent));
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            this.mStartDragX = paramMotionEvent.getX();
            if ((this.mStartX < this.mStartDragX) && ((this.mStartDragX - this.mStartX > 450.0F) || (this.mVelocityTracker.getYVelocity() > this.mMinimumVelocity)) && (getCurrentItem() > 0))
            {
              setCurrentItem(getCurrentItem() - 1, true);
              return true;
            }
            if ((this.mStartX > this.mStartDragX) && ((this.mStartX - this.mStartDragX > 450.0F) || (this.mVelocityTracker.getYVelocity() < -this.mMinimumVelocity)) && (getCurrentItem() < getAdapter().getCount() - 1))
            {
              this.mStartDragX = 0.0F;
              setCurrentItem(getCurrentItem() + 1, true);
              return true;
              this.mStartDragX = 0.0F;
            }
          }
          return super.onTouchEvent(swapXY(paramMotionEvent));
        }
      }
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      ViolaLogUtils.e("VSliderViewPager", "onTouchEvent IllegalArgumentException error:" + paramMotionEvent.getMessage());
      return false;
    }
    if (!this.mBouncesEnable) {
      return super.onTouchEvent(paramMotionEvent);
    }
    ViewParent localViewParent = getParent();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
      onTouchActionUp();
      continue;
      float f3 = (int)paramMotionEvent.getRawY();
      float f1 = (int)paramMotionEvent.getRawX();
      float f2 = this.mStartRawX;
      f3 -= this.mStartRawY;
      if ((Math.abs(f3) > this.mTouchSlop) && (Math.abs(f1 - f2) / Math.abs(f3) < 0.5F) && (this.mHandleDefault) && (localViewParent != null))
      {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
      else
      {
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(true);
        }
        if (getAdapter().getCount() == 1)
        {
          f1 = paramMotionEvent.getX();
          f2 = f1 - this.mPreX;
          this.mPreX = f1;
          if (f2 > 10.0F)
          {
            whetherConditionIsRight(f2);
            label563:
            fireOverScrollEvent(getLeft() + f2 * 0.5F);
          }
        }
        while (!this.mHandleDefault)
        {
          return true;
          if (f2 < -10.0F)
          {
            whetherConditionIsRight(f2);
            break label563;
          }
          if ((this.mHandleDefault) || (getLeft() + (int)(f2 * 0.5F) == this.mRect.left)) {
            break label563;
          }
          layout(getLeft() + (int)(f2 * 0.5F), getTop(), getRight() + (int)(f2 * 0.5F), getBottom());
          break label563;
          if ((this.mCurrentPosition == 0) || (this.mCurrentPosition == getAdapter().getCount() - 1))
          {
            f1 = paramMotionEvent.getX();
            f2 = f1 - this.mPreX;
            this.mPreX = f1;
            if (this.mCurrentPosition == 0)
            {
              if ((f2 > 10.0F) && (this.mLastPositionOffsetPixels == 0))
              {
                whetherConditionIsRight(f2);
              }
              else if ((!this.mHandleDefault) && (getLeft() + (int)(f2 * 0.5F) >= this.mRect.left))
              {
                int i = getLeft();
                int j = (int)(f2 * 0.5F);
                int k = getTop();
                int m = getRight();
                layout(i + j, k, (int)(f2 * 0.5F) + m, getBottom());
              }
            }
            else
            {
              if ((f2 < -10.0F) && (this.mLastPositionOffsetPixels == 0)) {
                whetherConditionIsRight(f2);
              }
              for (;;)
              {
                fireOverScrollEvent(-(getLeft() + f2 * 0.5F));
                break;
                if ((!this.mHandleDefault) && (getRight() + (int)(f2 * 0.5F) <= this.mRect.right)) {
                  layout(getLeft() + (int)(f2 * 0.5F), getTop(), getRight() + (int)(f2 * 0.5F), getBottom());
                }
              }
            }
          }
          else
          {
            this.mHandleDefault = true;
          }
        }
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(true);
        }
        this.mStartRawY = ((int)paramMotionEvent.getRawY());
        this.mStartRawX = ((int)paramMotionEvent.getRawX());
        continue;
        label955:
        return false;
        break;
      }
    }
  }
  
  public void refreshData()
  {
    try
    {
      if (this.mAdapter != null)
      {
        this.mAdapter.setAdapterData(getComponent().mChildren);
        this.mAdapter.notifyDataSetChanged();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void removeScrollListener(VPageSliderView.VPagerSliderScrollListener paramVPagerSliderScrollListener)
  {
    if (paramVPagerSliderScrollListener == null) {
      return;
    }
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    this.listeners.remove(paramVPagerSliderScrollListener);
  }
  
  public void setBouncesEnable(Boolean paramBoolean)
  {
    this.mBouncesEnable = paramBoolean.booleanValue();
  }
  
  public void setInterruptEnable(Boolean paramBoolean)
  {
    this.mInterruptEnable = paramBoolean.booleanValue();
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.mScrollEnable = Boolean.valueOf(paramBoolean);
  }
  
  public void setSliderListener(VSliderView.VSliderListener paramVSliderListener)
  {
    this.mListener = paramVSliderListener;
  }
  
  public void setStartItemIndex(Boolean paramBoolean, int paramInt)
  {
    this.mStartItemIndex = paramInt;
    setCurrentItem(this.mStartItemIndex, paramBoolean.booleanValue());
    this.mCurrentItemIndex = getCurrentItem();
  }
  
  public void toLastIndex(boolean paramBoolean)
  {
    if (this.mCurrentItemIndex - 1 >= 0)
    {
      setCurrentItem(this.mCurrentItemIndex - 1, paramBoolean);
      this.mCurrentItemIndex = getCurrentItem();
    }
  }
  
  public void toNextIndex(boolean paramBoolean)
  {
    if (this.mCurrentItemIndex + 1 < getComponent().getChildCount())
    {
      setCurrentItem(this.mCurrentItemIndex + 1, paramBoolean);
      this.mCurrentItemIndex = getCurrentItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VPageSliderView
 * JD-Core Version:    0.7.0.1
 */