package com.tencent.viola.ui.view.refresh;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.viola.ui.component.VDiv;
import com.tencent.viola.ui.component.VPageSlider;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.VFrameLayout;
import com.tencent.viola.ui.view.refresh.listener.IFooterCallBack;
import com.tencent.viola.ui.view.refresh.listener.IHeaderCallBack;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class VRefreshViewGroup
  extends FrameLayout
{
  private static final int MODE_HORIZONTAL = 1;
  private static final int MODE_IDLE = 0;
  private static final int MODE_VERTICAL = 2;
  public static String TAG = "VRefreshViewGroup";
  private float OFFSET_RADIO = 2.8F;
  private float downX;
  private float downY;
  private boolean isAtBottom = true;
  private boolean isAtTop = true;
  private boolean isGrandFatherVerticalPageSlider = false;
  private boolean isIntercepted = false;
  private boolean isJudge = false;
  private boolean mAllowFooterSliding = false;
  private boolean mAllowHeaderSliding = false;
  private VRefreshContentView mContentView;
  private int mFootViewHeight;
  private IFooterCallBack mFooterCallBack;
  private View mFooterView;
  private Handler mHandler;
  private boolean mHasAddLayoutParams = false;
  private boolean mHasSendCancelEvent = false;
  private boolean mHasSendDownEvent = false;
  private int mHeadMoveDistence;
  private IHeaderCallBack mHeaderCallBack;
  private View mHeaderView;
  private int mHeaderViewHeight;
  private VRefreshViewGroup.RefreshAndFooterHolder mHolder;
  private int mInitialMotionY;
  private boolean mIsHeaderVisiableInScreen = false;
  private MotionEvent mLastMoveEvent;
  private int mLastX = -1;
  private int mLastY = -1;
  public boolean mPullLoading;
  public boolean mPullRefreshing = false;
  private ArrayList<RefreshMoveOberver> mRefreshMoveObervers = new ArrayList();
  private Runnable mRunnable = new VRefreshViewGroup.1(this);
  private Scroller mScroller;
  private int mStartX = -1;
  private int mStartY = -1;
  private VRefreshViewGroup.RefreshAndFooterViewState mState = null;
  private boolean mStopingRefresh = false;
  private final CopyOnWriteArrayList<VRefreshViewGroup.TouchLifeCycle> mTouchLifeCycles = new CopyOnWriteArrayList();
  private int mTouchSlop;
  private int mTouchSlop1 = 4;
  private int scrollMode;
  
  public VRefreshViewGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VRefreshViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClickable(true);
    setLongClickable(true);
    this.mHandler = new Handler();
    this.mContentView = new VRefreshContentView();
    this.mHolder = new VRefreshViewGroup.RefreshAndFooterHolder(this);
    this.mScroller = new Scroller(getContext(), new LinearInterpolator());
    initWithContext();
  }
  
  private void checkPullLoadEnable()
  {
    if (this.mFooterCallBack == null) {
      return;
    }
    this.mPullLoading = false;
    this.mFooterCallBack.show(true);
  }
  
  private void checkPullRefreshEnable()
  {
    if (this.mHeaderCallBack == null) {
      return;
    }
    this.mHeaderCallBack.show();
  }
  
  private void dealAddFooterView()
  {
    this.mFooterCallBack = ((IFooterCallBack)this.mFooterView);
    checkPullLoadEnable();
  }
  
  private void dealAddHeaderView()
  {
    this.mHeaderCallBack = ((IHeaderCallBack)this.mHeaderView);
    checkPullRefreshEnable();
  }
  
  private void getFooterHeight()
  {
    if (this.mFooterCallBack != null) {
      this.mFootViewHeight = this.mFooterCallBack.getFooterHeight();
    }
  }
  
  private void initWithContext()
  {
    setHeadMoveLargestDistence(this.mHeadMoveDistence);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private boolean isAddContentAndFooterView()
  {
    return (this.mContentView != null) && (this.mFooterView != null) && (this.mHeaderView == null);
  }
  
  private boolean isHeaderComponentHeaderView()
  {
    return (this.mHeaderCallBack != null) && (this.mHeaderCallBack.getComponentType() == 2);
  }
  
  private void resetFooterHeight()
  {
    if ((this.mFooterCallBack != null) && (this.mFooterCallBack.getRefreshStick())) {
      return;
    }
    int i = 0 - this.mHolder.mOffsetY;
    startScroll(i, computeScrollVerticalDuration(i, getHeight()));
  }
  
  private void resetHeaderHeight()
  {
    if ((this.mHeaderCallBack != null) && ((this.mHeaderCallBack.getRefreshStick()) || (this.mHeaderCallBack.getComponentType() == 2))) {}
    float f;
    do
    {
      return;
      f = this.mHolder.mOffsetY;
    } while ((this.mPullRefreshing) && ((f <= this.mHeaderViewHeight) || (f == 0.0F)));
    if (this.mPullRefreshing)
    {
      i = this.mHeaderViewHeight - this.mHolder.mOffsetY;
      startScroll(i, computeScrollVerticalDuration(i, getHeight()));
      return;
    }
    int i = 0 - this.mHolder.mOffsetY;
    startScroll(i, computeScrollVerticalDuration(i, getHeight()));
  }
  
  private void sendCancelEvent()
  {
    if (!this.mHasSendCancelEvent)
    {
      this.mHasSendCancelEvent = true;
      this.mHasSendDownEvent = false;
      MotionEvent localMotionEvent = this.mLastMoveEvent;
      dispatchTouchEventSupper(MotionEvent.obtain(localMotionEvent.getDownTime(), localMotionEvent.getEventTime() + ViewConfiguration.getLongPressTimeout(), 3, localMotionEvent.getX(), localMotionEvent.getY(), localMotionEvent.getMetaState()));
    }
  }
  
  private void sendDownEvent()
  {
    MotionEvent localMotionEvent;
    if (!this.mHasSendDownEvent)
    {
      this.mHasSendCancelEvent = false;
      this.mHasSendDownEvent = true;
      this.isIntercepted = false;
      localMotionEvent = this.mLastMoveEvent;
      if (localMotionEvent != null) {
        break label32;
      }
    }
    label32:
    while ((this.mHeaderView == null) && (this.mFooterView == null)) {
      return;
    }
    dispatchTouchEventSupper(MotionEvent.obtain(localMotionEvent.getDownTime(), localMotionEvent.getEventTime(), 0, localMotionEvent.getX(), localMotionEvent.getY(), localMotionEvent.getMetaState()));
  }
  
  private void updateFooterHeight(int paramInt)
  {
    if ((this.mHolder.mOffsetY < 0) && (this.mFooterView != null))
    {
      if (-this.mHolder.mOffsetY <= this.mFooterView.getHeight()) {
        break label67;
      }
      if (this.mState != VRefreshViewGroup.RefreshAndFooterViewState.STATE_RELEASE_TO_LOADMORE)
      {
        this.mFooterCallBack.onReleaseToLoadMore();
        this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_RELEASE_TO_LOADMORE;
      }
    }
    for (;;)
    {
      moveView(paramInt);
      return;
      label67:
      if (this.mState != VRefreshViewGroup.RefreshAndFooterViewState.STATE_NORMAL)
      {
        this.mFooterCallBack.onStateReady();
        this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_NORMAL;
      }
    }
  }
  
  private void updateHeaderHeight(int paramInt1, int paramInt2, int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label38;
      }
      this.mHeaderCallBack.onStateRefreshing();
      startScroll(paramInt2, paramVarArgs[0]);
    }
    label38:
    label120:
    do
    {
      do
      {
        do
        {
          return;
          paramInt1 = 0;
          break;
          paramInt1 = paramInt2;
          if (this.mHolder.isOverHeader(paramInt2)) {
            paramInt1 = -this.mHolder.mOffsetY;
          }
          moveView(paramInt1);
        } while (this.mPullRefreshing);
        if (this.mHolder.mOffsetY <= this.mHeaderViewHeight) {
          break label120;
        }
      } while ((this.mState == VRefreshViewGroup.RefreshAndFooterViewState.STATE_READY) || (this.mHeaderCallBack == null));
      this.mHeaderCallBack.onStateReady();
      this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_READY;
      return;
    } while ((this.mState == VRefreshViewGroup.RefreshAndFooterViewState.STATE_NORMAL) || (this.mHeaderCallBack == null));
    this.mHeaderCallBack.onStateNormal();
    this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_NORMAL;
  }
  
  private void updateTouchAction(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.mTouchLifeCycles.iterator();
    while (localIterator.hasNext())
    {
      VRefreshViewGroup.TouchLifeCycle localTouchLifeCycle = (VRefreshViewGroup.TouchLifeCycle)localIterator.next();
      if (localTouchLifeCycle != null) {
        localTouchLifeCycle.onTouch(paramMotionEvent);
      }
    }
  }
  
  public void add(RefreshMoveOberver paramRefreshMoveOberver)
  {
    this.mRefreshMoveObervers.add(paramRefreshMoveOberver);
  }
  
  public void addInFirst(RefreshMoveOberver paramRefreshMoveOberver)
  {
    this.mRefreshMoveObervers.add(0, paramRefreshMoveOberver);
  }
  
  public void addTouchLifeCycle(VRefreshViewGroup.TouchLifeCycle paramTouchLifeCycle)
  {
    this.mTouchLifeCycles.add(paramTouchLifeCycle);
  }
  
  public int computeScrollVerticalDuration(int paramInt1, int paramInt2)
  {
    float f = Math.abs(paramInt1);
    int i = paramInt2;
    if (paramInt2 == 0) {
      i = 1;
    }
    paramInt2 = (int)((f / i + 1.0F) * 200.0F);
    if (paramInt1 == 0) {
      return 0;
    }
    return Math.min(paramInt2, 500);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    updateTouchAction(paramMotionEvent);
    switch (i)
    {
    default: 
    case 0: 
    case 2: 
      label214:
      label493:
      do
      {
        for (;;)
        {
          return super.dispatchTouchEvent(paramMotionEvent);
          this.mHasSendCancelEvent = false;
          this.mHasSendDownEvent = false;
          this.mLastY = ((int)paramMotionEvent.getRawY());
          this.mLastX = ((int)paramMotionEvent.getRawX());
          this.mStartY = ((int)paramMotionEvent.getRawY());
          this.mStartX = ((int)paramMotionEvent.getRawX());
          this.mInitialMotionY = this.mLastY;
          continue;
          this.mLastMoveEvent = paramMotionEvent;
          i = (int)paramMotionEvent.getRawY();
          int j = (int)paramMotionEvent.getRawX();
          int k = i - this.mLastY;
          int m = j - this.mStartX;
          int n = this.mStartY;
          this.mLastY = i;
          this.mLastX = j;
          if (isHeaderComponentHeaderView())
          {
            if ((this.mHolder.mOffsetY <= 0) || (this.mIsHeaderVisiableInScreen)) {
              break label214;
            }
            this.mIsHeaderVisiableInScreen = true;
            this.mHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
          }
          while ((this.mStopingRefresh) || (!isEnabled()))
          {
            return super.dispatchTouchEvent(paramMotionEvent);
            if ((this.mIsHeaderVisiableInScreen) && (this.mHolder.mOffsetY <= 0))
            {
              this.mIsHeaderVisiableInScreen = false;
              this.mHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
            }
          }
          if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(i - n) / Math.abs(m) < 1.3F)) {
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          if (!this.isIntercepted)
          {
            if ((Math.abs(i - this.mInitialMotionY) >= this.mTouchSlop) && (!this.isGrandFatherVerticalPageSlider)) {
              this.isIntercepted = true;
            }
          }
          else
          {
            if (((k <= 0) || (this.mHolder.mOffsetY > this.mHeadMoveDistence)) && (k >= 0)) {
              break label465;
            }
            j = (int)(k / this.OFFSET_RADIO);
            if ((this.mPullLoading) || (!this.mContentView.isTop()) || (((j <= 0) || (this.mHolder.hasFooterPullUp())) && ((j >= 0) || (!this.mHolder.hasHeaderPullDown()) || (!this.mAllowHeaderSliding)))) {
              break label493;
            }
            sendCancelEvent();
            localIterator = this.mRefreshMoveObervers.iterator();
          }
          while (localIterator.hasNext())
          {
            ((RefreshMoveOberver)localIterator.next()).onRefreshMove(this.mHolder.mOffsetY);
            continue;
            return super.dispatchTouchEvent(paramMotionEvent);
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          if (this.mAllowHeaderSliding)
          {
            updateHeaderHeight(i, j, new int[0]);
            return super.dispatchTouchEvent(paramMotionEvent);
            if ((!this.mPullRefreshing) && (this.mContentView.isBottom()) && ((j < 0) || ((j > 0) && (this.mHolder.hasFooterPullUp()))))
            {
              sendCancelEvent();
              if (this.mAllowFooterSliding)
              {
                if (this.mFooterCallBack != null) {
                  this.mFooterCallBack.onMove(this.mHolder.mOffsetY);
                }
                updateFooterHeight(j);
              }
            }
            else
            {
              if ((j == 0) || (((!this.mContentView.isTop()) || (this.mHolder.hasHeaderPullDown())) && ((!this.mContentView.isBottom()) || (this.mHolder.hasFooterPullUp())))) {
                break;
              }
              if (Math.abs(j) > 0) {
                sendDownEvent();
              }
            }
          }
        }
      } while (!this.mAllowHeaderSliding);
      label465:
      Iterator localIterator = this.mRefreshMoveObervers.iterator();
      while (localIterator.hasNext()) {
        ((RefreshMoveOberver)localIterator.next()).onRefreshMove(this.mHolder.mOffsetY);
      }
    }
    if ((this.mHolder.hasHeaderPullDown()) && (this.mContentView.isTop()))
    {
      if ((!this.mStopingRefresh) && (!this.mPullRefreshing) && (this.mHolder.mOffsetY > this.mHeaderViewHeight))
      {
        this.mPullRefreshing = true;
        if (this.mHeaderCallBack != null) {
          this.mHeaderCallBack.onStateRefreshing();
        }
        this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_REFRESHING;
      }
      resetHeaderHeight();
    }
    for (;;)
    {
      this.mLastY = -1;
      this.mLastX = -1;
      this.mInitialMotionY = 0;
      this.isIntercepted = false;
      break;
      if ((this.mHolder.hasFooterPullUp()) && (this.mContentView.isBottom()) && (!this.mStopingRefresh))
      {
        resetFooterHeight();
        if ((this.mHolder.mOffsetY < 0) && (Math.abs(this.mHolder.mOffsetY) > this.mFootViewHeight))
        {
          if (this.mFooterCallBack != null) {
            this.mFooterCallBack.onStateRefreshing();
          }
          this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_LOADING;
        }
      }
    }
  }
  
  public boolean dispatchTouchEventSupper(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void getHeaderHeight()
  {
    if (this.mHeaderCallBack != null) {
      this.mHeaderViewHeight = this.mHeaderCallBack.getHeaderHeight();
    }
  }
  
  public int getHeaderViewHeight()
  {
    if ((this.mHeaderViewHeight == 0) && (this.mHeaderCallBack != null)) {
      this.mHeaderViewHeight = this.mHeaderCallBack.getHeaderHeight();
    }
    return this.mHeaderViewHeight;
  }
  
  public void moveView(int paramInt)
  {
    this.mHolder.move(paramInt);
    if (this.mHeaderView != null) {
      this.mHeaderView.offsetTopAndBottom(paramInt);
    }
    this.mContentView.offsetTopAndBottom(paramInt);
    if (this.mFooterView != null) {
      this.mFooterView.offsetTopAndBottom(paramInt);
    }
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  public void onDestroy()
  {
    this.mRefreshMoveObervers.clear();
    this.mHandler.removeCallbacks(this.mRunnable);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.isJudge) && (this.mContentView.getContentViewProvider().getContentView() != null) && ((this.mContentView.getContentViewProvider().getContentView().getParent().getParent() instanceof VFrameLayout)))
    {
      VFrameLayout localVFrameLayout = (VFrameLayout)this.mContentView.getContentViewProvider().getContentView().getParent().getParent();
      if ((localVFrameLayout.getComponent() != null) && ((localVFrameLayout.getComponent().getParent() instanceof VPageSlider)) && (!((VPageSlider)localVFrameLayout.getComponent().getParent()).isPageSliderHorizontal())) {
        this.isGrandFatherVerticalPageSlider = true;
      }
    }
    this.isJudge = true;
    if (this.isGrandFatherVerticalPageSlider)
    {
      if (paramMotionEvent.getAction() != 0) {
        break label195;
      }
      this.downX = paramMotionEvent.getRawX();
      this.downY = paramMotionEvent.getRawY();
      this.isAtTop = this.mContentView.isTop();
      this.isAtBottom = this.mContentView.isBottom();
      this.scrollMode = 0;
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    label195:
    do
    {
      float f1;
      float f2;
      do
      {
        for (;;)
        {
          return super.onInterceptTouchEvent(paramMotionEvent);
          if ((paramMotionEvent.getAction() == 2) && (this.scrollMode == 0))
          {
            f1 = Math.abs(this.downX - paramMotionEvent.getRawX());
            f2 = Math.abs(this.downY - paramMotionEvent.getRawY());
            if ((f1 <= f2) || (f1 <= this.mTouchSlop1)) {
              break;
            }
            this.scrollMode = 1;
          }
        }
      } while ((f2 <= f1) || (f2 <= this.mTouchSlop1));
      this.scrollMode = 2;
      if ((this.downY < paramMotionEvent.getRawY()) && (this.isAtTop))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        return true;
      }
    } while ((!this.isAtBottom) || (this.downY <= paramMotionEvent.getRawY()));
    getParent().requestDisallowInterceptTouchEvent(false);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      try
      {
        paramInt4 = getChildCount();
        paramInt2 = getPaddingTop() + this.mHolder.mOffsetY;
        paramInt1 = 0;
        paramInt3 = 0;
        if (paramInt3 < paramInt4)
        {
          View localView = getChildAt(paramInt3);
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
          int k = localLayoutParams.topMargin;
          int i = localLayoutParams.bottomMargin;
          int j = localLayoutParams.leftMargin;
          j = getPaddingLeft() + j;
          paramInt2 += k;
          k = localView.getMeasuredWidth();
          if (localView.getVisibility() == 8) {
            break label338;
          }
          int m;
          if (paramInt3 == 0)
          {
            if (isAddContentAndFooterView())
            {
              m = localView.getMeasuredHeight() - paramInt1;
              localView.layout(j, paramInt2, k + j, m + paramInt2);
              paramInt2 = m + i + paramInt2;
            }
            else
            {
              paramInt1 = localView.getMeasuredHeight() - this.mHeaderViewHeight;
              localView.layout(j, paramInt2 - this.mHeaderViewHeight, k + j, paramInt2 + paramInt1);
              paramInt2 += paramInt1;
            }
          }
          else if (paramInt3 == 1)
          {
            if (isAddContentAndFooterView())
            {
              localView.layout(j, paramInt2, k + j, localView.getMeasuredHeight() + paramInt2);
              paramInt2 = localView.getMeasuredHeight() + paramInt2;
            }
            else
            {
              m = localView.getMeasuredHeight() - paramInt1;
              localView.layout(j, paramInt2, k + j, m + paramInt2);
              paramInt2 = m + i + paramInt2;
            }
          }
          else
          {
            localView.layout(j, paramInt2, k + j, localView.getMeasuredHeight() + paramInt2);
            i = localView.getMeasuredHeight();
            paramInt2 = i + paramInt2;
          }
        }
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e(TAG, "onLayout error:" + localException.getMessage());
      }
      return;
      label338:
      paramInt3 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int k = getChildCount();
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < k)
    {
      View localView = getChildAt(paramInt1);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      localView.measure(View.MeasureSpec.makeMeasureSpec(i - localLayoutParams.leftMargin - localLayoutParams.rightMargin - m - n, 1073741824), getChildMeasureSpec(paramInt2, i1 + i2 + localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
      paramInt1 += 1;
    }
    setMeasuredDimension(i, j);
    getHeaderHeight();
    getFooterHeight();
  }
  
  public void remove(RefreshMoveOberver paramRefreshMoveOberver)
  {
    if (this.mRefreshMoveObervers.contains(paramRefreshMoveOberver)) {
      this.mRefreshMoveObervers.remove(paramRefreshMoveOberver);
    }
  }
  
  public void scrollerToTop(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mContentView.scrollToTop(paramBoolean2);
    if (paramBoolean1) {
      if ((!this.mPullRefreshing) && (this.mHolder.mOffsetY == 0))
      {
        this.mIsHeaderVisiableInScreen = true;
        getHeaderHeight();
        updateHeaderHeight(0, this.mHeaderViewHeight, new int[] { 0 });
        if (this.mHeaderCallBack != null) {
          this.mHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
        }
        this.mPullRefreshing = true;
      }
    }
    do
    {
      do
      {
        return;
      } while ((!this.mIsHeaderVisiableInScreen) || (this.mHolder.mOffsetY <= 0));
      this.mIsHeaderVisiableInScreen = false;
      updateHeaderHeight(0, -this.mHolder.mOffsetY, new int[] { 0 });
    } while (this.mHeaderCallBack == null);
    this.mHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
  }
  
  public void setAllowFooterSliding(boolean paramBoolean)
  {
    this.mAllowFooterSliding = paramBoolean;
  }
  
  public void setAllowHeaderSliding(boolean paramBoolean)
  {
    this.mAllowHeaderSliding = paramBoolean;
  }
  
  public void setContentViewProvider(VRefreshContentView.ContentViewProvider paramContentViewProvider)
  {
    if (paramContentViewProvider == null) {}
    while (indexOfChild(paramContentViewProvider.getContentView()) != -1) {
      return;
    }
    addView(paramContentViewProvider.getContentView());
    this.mContentView.setContentViewProvider(paramContentViewProvider);
  }
  
  public void setFooterView(View paramView)
  {
    addView(paramView);
    this.mFooterView = paramView;
    dealAddFooterView();
    this.mAllowFooterSliding = true;
  }
  
  public void setHeadMoveLargestDistence(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.mHeadMoveDistence = (FlexConvertUtils.getScreenHeight() / 3);
      if (this.mHeadMoveDistence > this.mHeaderViewHeight) {
        break label45;
      }
    }
    label45:
    for (paramInt = this.mHeaderViewHeight + 1;; paramInt = this.mHeadMoveDistence)
    {
      this.mHeadMoveDistence = paramInt;
      return;
      this.mHeadMoveDistence = paramInt;
      break;
    }
  }
  
  public void setHeaderView(View paramView)
  {
    this.mHeaderView = paramView;
    addView(this.mHeaderView);
    dealAddHeaderView();
    this.mAllowHeaderSliding = true;
    if (isHeaderComponentHeaderView())
    {
      this.OFFSET_RADIO = 1.0F;
      this.mHeadMoveDistence = this.mHeaderCallBack.getHeaderHeight();
    }
  }
  
  public void setViewGroupLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!this.mHasAddLayoutParams)
    {
      setLayoutParams(paramLayoutParams);
      this.mHasAddLayoutParams = true;
    }
  }
  
  public void startScroll(int paramInt1, int paramInt2)
  {
    this.mScroller.startScroll(0, this.mHolder.mOffsetY, 0, paramInt1, paramInt2);
    if (this.mHolder.mOffsetY >= 0) {
      if (this.mHeaderCallBack != null) {
        this.mHeaderCallBack.onFingerRelease();
      }
    }
    for (;;)
    {
      this.mHandler.post(this.mRunnable);
      return;
      if (this.mFooterCallBack != null) {
        this.mFooterCallBack.onFingerRelease();
      }
    }
  }
  
  public void stopLoadMore()
  {
    this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_FINISHED;
    if (this.mFooterCallBack != null) {
      this.mFooterCallBack.onStateFinish(false);
    }
  }
  
  public void stopRefresh()
  {
    stopRefresh(true);
  }
  
  public void stopRefresh(boolean paramBoolean)
  {
    if (this.mPullRefreshing)
    {
      this.mStopingRefresh = true;
      this.mHeaderCallBack.onStateFinish(paramBoolean);
      this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_COMPLETE;
      this.mPullRefreshing = false;
      if (this.mStopingRefresh) {
        resetHeaderHeight();
      }
    }
  }
  
  public void updateRefreshShow(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.mIsHeaderVisiableInScreen))
    {
      this.mIsHeaderVisiableInScreen = paramBoolean;
      getHeaderHeight();
      updateHeaderHeight(0, this.mHeaderViewHeight, new int[] { 0 });
      this.mContentView.scrollToTop(false);
      if (this.mHeaderCallBack != null) {
        this.mHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramBoolean) || (!this.mIsHeaderVisiableInScreen));
      this.mIsHeaderVisiableInScreen = paramBoolean;
      updateHeaderHeight(0, -this.mHeaderViewHeight, new int[] { 0 });
    } while (this.mHeaderCallBack == null);
    this.mHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.refresh.VRefreshViewGroup
 * JD-Core Version:    0.7.0.1
 */