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
  private boolean mIsCompatibleLeftPan = false;
  private boolean mIsHeaderVisiableInScreen = false;
  private MotionEvent mLastMoveEvent;
  private int mLastX = -1;
  private int mLastY = -1;
  public boolean mPullLoading;
  public boolean mPullRefreshing = false;
  private ArrayList<RefreshMoveOberver> mRefreshMoveObervers = new ArrayList();
  private Runnable mRunnable = new VRefreshViewGroup.1(this);
  private Scroller mScroller;
  private float mStartRawX = -1.0F;
  private float mStartRawY = -1.0F;
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
    IFooterCallBack localIFooterCallBack = this.mFooterCallBack;
    if (localIFooterCallBack == null) {
      return;
    }
    this.mPullLoading = false;
    localIFooterCallBack.show(true);
  }
  
  private void checkPullRefreshEnable()
  {
    IHeaderCallBack localIHeaderCallBack = this.mHeaderCallBack;
    if (localIHeaderCallBack == null) {
      return;
    }
    localIHeaderCallBack.show();
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
    IFooterCallBack localIFooterCallBack = this.mFooterCallBack;
    if (localIFooterCallBack != null) {
      this.mFootViewHeight = localIFooterCallBack.getFooterHeight();
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
  
  private boolean isDoingBottomSpringBack()
  {
    return (this.mContentView.isBottom()) && (this.mHolder.hasFooterPullUp()) && (this.mAllowFooterSliding);
  }
  
  private boolean isDoingTopSpringBack()
  {
    return (this.mContentView.isTop()) && (this.mHolder.hasHeaderPullDown()) && (this.mAllowHeaderSliding);
  }
  
  private boolean isHeaderComponentHeaderView()
  {
    IHeaderCallBack localIHeaderCallBack = this.mHeaderCallBack;
    return (localIHeaderCallBack != null) && (localIHeaderCallBack.getComponentType() == 2);
  }
  
  private void resetFooterHeight()
  {
    IFooterCallBack localIFooterCallBack = this.mFooterCallBack;
    if ((localIFooterCallBack != null) && (localIFooterCallBack.getRefreshStick())) {
      return;
    }
    int i = 0 - this.mHolder.mOffsetY;
    startScroll(i, computeScrollVerticalDuration(i, getHeight()));
  }
  
  private void resetHeaderHeight()
  {
    IHeaderCallBack localIHeaderCallBack = this.mHeaderCallBack;
    if ((localIHeaderCallBack != null) && ((localIHeaderCallBack.getRefreshStick()) || (this.mHeaderCallBack.getComponentType() == 2))) {
      return;
    }
    float f = this.mHolder.mOffsetY;
    if ((this.mPullRefreshing) && ((f <= this.mHeaderViewHeight) || (f == 0.0F))) {
      return;
    }
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
    if (!this.mHasSendDownEvent)
    {
      this.mHasSendCancelEvent = false;
      this.mHasSendDownEvent = true;
      this.isIntercepted = false;
      MotionEvent localMotionEvent = this.mLastMoveEvent;
      if (localMotionEvent == null) {
        return;
      }
      if ((this.mHeaderView != null) || (this.mFooterView != null)) {
        dispatchTouchEventSupper(MotionEvent.obtain(localMotionEvent.getDownTime(), localMotionEvent.getEventTime(), 0, localMotionEvent.getX(), localMotionEvent.getY(), localMotionEvent.getMetaState()));
      }
    }
  }
  
  private void updateFooterHeight(int paramInt)
  {
    if ((this.mHolder.mOffsetY < 0) && (this.mFooterView != null)) {
      if (-this.mHolder.mOffsetY > this.mFooterView.getHeight())
      {
        if (this.mState != VRefreshViewGroup.RefreshAndFooterViewState.STATE_RELEASE_TO_LOADMORE)
        {
          this.mFooterCallBack.onReleaseToLoadMore();
          this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_RELEASE_TO_LOADMORE;
        }
      }
      else if (this.mState != VRefreshViewGroup.RefreshAndFooterViewState.STATE_NORMAL)
      {
        this.mFooterCallBack.onStateReady();
        this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_NORMAL;
      }
    }
    moveView(paramInt);
  }
  
  private void updateHeaderHeight(int paramInt1, int paramInt2, int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0)
    {
      this.mHeaderCallBack.onStateRefreshing();
      startScroll(paramInt2, paramVarArgs[0]);
      return;
    }
    paramInt1 = paramInt2;
    if (this.mHolder.isOverHeader(paramInt2)) {
      paramInt1 = -this.mHolder.mOffsetY;
    }
    moveView(paramInt1);
    if (!this.mPullRefreshing) {
      if (this.mHolder.mOffsetY > this.mHeaderViewHeight)
      {
        if (this.mState != VRefreshViewGroup.RefreshAndFooterViewState.STATE_READY)
        {
          paramVarArgs = this.mHeaderCallBack;
          if (paramVarArgs != null)
          {
            paramVarArgs.onStateReady();
            this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_READY;
          }
        }
      }
      else if (this.mState != VRefreshViewGroup.RefreshAndFooterViewState.STATE_NORMAL)
      {
        paramVarArgs = this.mHeaderCallBack;
        if (paramVarArgs != null)
        {
          paramVarArgs.onStateNormal();
          this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_NORMAL;
        }
      }
    }
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
    if (i != 0)
    {
      Object localObject;
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label901;
          }
        }
        else
        {
          this.mLastMoveEvent = paramMotionEvent;
          i = (int)paramMotionEvent.getRawY();
          int j = (int)paramMotionEvent.getRawX();
          int k = i - this.mLastY;
          int m = j - this.mStartX;
          int n = this.mStartY;
          this.mLastY = i;
          this.mLastX = j;
          if (isHeaderComponentHeaderView()) {
            if ((this.mHolder.mOffsetY > 0) && (!this.mIsHeaderVisiableInScreen))
            {
              this.mIsHeaderVisiableInScreen = true;
              this.mHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
            }
            else if ((this.mIsHeaderVisiableInScreen) && (this.mHolder.mOffsetY <= 0))
            {
              this.mIsHeaderVisiableInScreen = false;
              this.mHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
            }
          }
          if ((!this.mStopingRefresh) && (isEnabled()))
          {
            if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(i - n) / Math.abs(m) < 1.3F)) {
              return super.dispatchTouchEvent(paramMotionEvent);
            }
            if (!this.isIntercepted) {
              if ((Math.abs(i - this.mInitialMotionY) >= this.mTouchSlop) && (!this.isGrandFatherVerticalPageSlider)) {
                this.isIntercepted = true;
              } else {
                return super.dispatchTouchEvent(paramMotionEvent);
              }
            }
            if (((k > 0) && (this.mHolder.mOffsetY <= this.mHeadMoveDistence)) || (k < 0))
            {
              j = (int)(k / this.OFFSET_RADIO);
              if ((!this.mPullLoading) && (this.mContentView.isTop()) && (((j > 0) && (!this.mHolder.hasFooterPullUp())) || ((j < 0) && (this.mHolder.hasHeaderPullDown()) && (this.mAllowHeaderSliding))))
              {
                sendCancelEvent();
                localObject = this.mRefreshMoveObervers.iterator();
                while (((Iterator)localObject).hasNext()) {
                  ((RefreshMoveOberver)((Iterator)localObject).next()).onRefreshMove(this.mHolder.mOffsetY);
                }
                if (!this.mAllowHeaderSliding) {
                  break label901;
                }
                updateHeaderHeight(i, j, new int[0]);
                return super.dispatchTouchEvent(paramMotionEvent);
              }
              if ((!this.mPullRefreshing) && (this.mContentView.isBottom()) && ((j < 0) || ((j > 0) && (this.mHolder.hasFooterPullUp()))))
              {
                sendCancelEvent();
                if (!this.mAllowFooterSliding) {
                  break label901;
                }
                localObject = this.mFooterCallBack;
                if (localObject != null) {
                  ((IFooterCallBack)localObject).onMove(this.mHolder.mOffsetY);
                }
                localObject = this.mRefreshMoveObervers.iterator();
                while (((Iterator)localObject).hasNext()) {
                  ((RefreshMoveOberver)((Iterator)localObject).next()).onRefreshMove(this.mHolder.mOffsetY);
                }
                updateFooterHeight(j);
                break label901;
              }
              if ((j != 0) && (((this.mContentView.isTop()) && (!this.mHolder.hasHeaderPullDown())) || ((this.mContentView.isBottom()) && (!this.mHolder.hasFooterPullUp()))))
              {
                if (Math.abs(j) <= 0) {
                  break label901;
                }
                sendDownEvent();
                break label901;
              }
              if (!this.mAllowHeaderSliding) {
                break label901;
              }
              localObject = this.mRefreshMoveObervers.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((RefreshMoveOberver)((Iterator)localObject).next()).onRefreshMove(this.mHolder.mOffsetY);
              }
            }
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          return super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      if ((this.mHolder.hasHeaderPullDown()) && (this.mContentView.isTop()))
      {
        if ((!this.mStopingRefresh) && (!this.mPullRefreshing) && (this.mHolder.mOffsetY > this.mHeaderViewHeight))
        {
          this.mPullRefreshing = true;
          localObject = this.mHeaderCallBack;
          if (localObject != null) {
            ((IHeaderCallBack)localObject).onStateRefreshing();
          }
          this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_REFRESHING;
        }
        resetHeaderHeight();
      }
      else if ((this.mHolder.hasFooterPullUp()) && (this.mContentView.isBottom()) && (!this.mStopingRefresh))
      {
        resetFooterHeight();
        if ((this.mHolder.mOffsetY < 0) && (Math.abs(this.mHolder.mOffsetY) > this.mFootViewHeight))
        {
          localObject = this.mFooterCallBack;
          if (localObject != null) {
            ((IFooterCallBack)localObject).onStateRefreshing();
          }
          this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_LOADING;
        }
      }
      this.mLastY = -1;
      this.mLastX = -1;
      this.mInitialMotionY = 0;
      this.isIntercepted = false;
    }
    else
    {
      this.mHasSendCancelEvent = false;
      this.mHasSendDownEvent = false;
      this.mLastY = ((int)paramMotionEvent.getRawY());
      this.mLastX = ((int)paramMotionEvent.getRawX());
      this.mStartY = ((int)paramMotionEvent.getRawY());
      this.mStartX = ((int)paramMotionEvent.getRawX());
      this.mInitialMotionY = this.mLastY;
    }
    label901:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTouchEventSupper(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void getHeaderHeight()
  {
    IHeaderCallBack localIHeaderCallBack = this.mHeaderCallBack;
    if (localIHeaderCallBack != null) {
      this.mHeaderViewHeight = localIHeaderCallBack.getHeaderHeight();
    }
  }
  
  public int getHeaderViewHeight()
  {
    if (this.mHeaderViewHeight == 0)
    {
      IHeaderCallBack localIHeaderCallBack = this.mHeaderCallBack;
      if (localIHeaderCallBack != null) {
        this.mHeaderViewHeight = localIHeaderCallBack.getHeaderHeight();
      }
    }
    return this.mHeaderViewHeight;
  }
  
  public int getHeaderViewWidth()
  {
    IHeaderCallBack localIHeaderCallBack = this.mHeaderCallBack;
    if (localIHeaderCallBack != null) {
      return localIHeaderCallBack.getHeaderWidth();
    }
    return 0;
  }
  
  public void moveView(int paramInt)
  {
    this.mHolder.move(paramInt);
    View localView = this.mHeaderView;
    if (localView != null) {
      localView.offsetTopAndBottom(paramInt);
    }
    this.mContentView.offsetTopAndBottom(paramInt);
    localView = this.mFooterView;
    if (localView != null) {
      localView.offsetTopAndBottom(paramInt);
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
    Object localObject;
    if ((!this.isJudge) && (this.mContentView.getContentViewProvider().getContentView() != null) && ((this.mContentView.getContentViewProvider().getContentView().getParent().getParent() instanceof VFrameLayout)))
    {
      localObject = (VFrameLayout)this.mContentView.getContentViewProvider().getContentView().getParent().getParent();
      if ((((VFrameLayout)localObject).getComponent() != null) && ((((VFrameLayout)localObject).getComponent().getParent() instanceof VPageSlider)) && (!((VPageSlider)((VFrameLayout)localObject).getComponent().getParent()).isPageSliderHorizontal())) {
        this.isGrandFatherVerticalPageSlider = true;
      }
    }
    this.isJudge = true;
    float f1;
    float f2;
    if (this.isGrandFatherVerticalPageSlider)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.downX = paramMotionEvent.getRawX();
        this.downY = paramMotionEvent.getRawY();
        this.isAtTop = this.mContentView.isTop();
        this.isAtBottom = this.mContentView.isBottom();
        this.scrollMode = 0;
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      else if ((paramMotionEvent.getAction() == 2) && (this.scrollMode == 0))
      {
        f1 = Math.abs(this.downX - paramMotionEvent.getRawX());
        f2 = Math.abs(this.downY - paramMotionEvent.getRawY());
        if ((f1 > f2) && (f1 > this.mTouchSlop1))
        {
          this.scrollMode = 1;
        }
        else if ((f2 > f1) && (f2 > this.mTouchSlop1))
        {
          this.scrollMode = 2;
          if ((this.downY < paramMotionEvent.getRawY()) && (this.isAtTop))
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            return true;
          }
          if ((this.isAtBottom) && (this.downY > paramMotionEvent.getRawY()))
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            return true;
          }
        }
      }
    }
    else if (this.mIsCompatibleLeftPan)
    {
      int i = paramMotionEvent.getAction();
      localObject = getParent();
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              break label553;
            }
          }
          else
          {
            f2 = paramMotionEvent.getRawY();
            f1 = paramMotionEvent.getRawX() - this.mStartRawX;
            f2 -= this.mStartRawY;
            if ((Math.abs(f2) > this.mTouchSlop) && (f1 < 0.0F))
            {
              if ((Math.abs(f1) / Math.abs(f2) < 0.5F) && (localObject != null))
              {
                ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
                break label553;
              }
              if (Math.abs(f1) / Math.abs(f2) > 0.75F) {
                return true;
              }
              if (localObject != null)
              {
                ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
                break label553;
              }
            }
            if (localObject == null) {
              break label553;
            }
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
            break label553;
          }
        }
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
        }
      }
      else
      {
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        this.mStartRawY = paramMotionEvent.getRawY();
        this.mStartRawX = paramMotionEvent.getRawX();
      }
    }
    label553:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      int m;
      int i;
      try
      {
        int j = getChildCount();
        paramInt1 = getPaddingTop() + this.mHolder.mOffsetY;
        paramInt2 = 0;
        paramInt3 = 0;
        Object localObject;
        if (paramInt2 < j)
        {
          View localView = getChildAt(paramInt2);
          localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
          paramInt4 = ((FrameLayout.LayoutParams)localObject).topMargin;
          m = ((FrameLayout.LayoutParams)localObject).bottomMargin;
          int k = ((FrameLayout.LayoutParams)localObject).leftMargin + getPaddingLeft();
          i = paramInt1 + paramInt4;
          int n = localView.getMeasuredWidth();
          paramInt1 = i;
          paramInt4 = paramInt3;
          if (localView.getVisibility() != 8) {
            if (paramInt2 == 0)
            {
              if (isAddContentAndFooterView())
              {
                paramInt1 = localView.getMeasuredHeight() - paramInt3;
                localView.layout(k, i, n + k, paramInt1 + i);
                break label357;
              }
              paramInt4 = localView.getMeasuredHeight() - this.mHeaderViewHeight;
              paramInt3 = this.mHeaderViewHeight;
              paramInt1 = i + paramInt4;
              localView.layout(k, i - paramInt3, n + k, paramInt1);
            }
            else
            {
              if (paramInt2 == 1)
              {
                if (isAddContentAndFooterView())
                {
                  localView.layout(k, i, n + k, localView.getMeasuredHeight() + i);
                  paramInt1 = localView.getMeasuredHeight();
                }
                else
                {
                  paramInt1 = localView.getMeasuredHeight() - paramInt3;
                  localView.layout(k, i, n + k, paramInt1 + i);
                  break label357;
                }
              }
              else
              {
                localView.layout(k, i, n + k, localView.getMeasuredHeight() + i);
                paramInt1 = localView.getMeasuredHeight();
              }
              paramInt1 = i + paramInt1;
              paramInt4 = paramInt3;
            }
          }
          paramInt2 += 1;
          paramInt3 = paramInt4;
        }
        else
        {
          StringBuilder localStringBuilder;
          return;
        }
      }
      catch (Exception localException)
      {
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onLayout error:");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e((String)localObject, localStringBuilder.toString());
      }
      label357:
      paramInt1 = i + (paramInt1 + m);
      paramInt4 = paramInt3;
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
    IHeaderCallBack localIHeaderCallBack;
    if (paramBoolean1)
    {
      if ((!this.mPullRefreshing) && (this.mHolder.mOffsetY == 0))
      {
        this.mIsHeaderVisiableInScreen = true;
        getHeaderHeight();
        updateHeaderHeight(0, this.mHeaderViewHeight, new int[] { 0 });
        localIHeaderCallBack = this.mHeaderCallBack;
        if (localIHeaderCallBack != null) {
          localIHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
        }
        this.mPullRefreshing = true;
      }
    }
    else if ((this.mIsHeaderVisiableInScreen) && (this.mHolder.mOffsetY > 0))
    {
      this.mIsHeaderVisiableInScreen = false;
      updateHeaderHeight(0, -this.mHolder.mOffsetY, new int[] { 0 });
      localIHeaderCallBack = this.mHeaderCallBack;
      if (localIHeaderCallBack != null) {
        localIHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
      }
    }
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
    if (paramContentViewProvider == null) {
      return;
    }
    if (indexOfChild(paramContentViewProvider.getContentView()) == -1)
    {
      addView(paramContentViewProvider.getContentView());
      this.mContentView.setContentViewProvider(paramContentViewProvider);
    }
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
    if (paramInt <= 0) {
      this.mHeadMoveDistence = (FlexConvertUtils.getScreenHeight() / 3);
    } else {
      this.mHeadMoveDistence = paramInt;
    }
    int i = this.mHeadMoveDistence;
    int j = this.mHeaderViewHeight;
    paramInt = i;
    if (i <= j) {
      paramInt = j + 1;
    }
    this.mHeadMoveDistence = paramInt;
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
  
  public void setIsCompatibleLeftPan(boolean paramBoolean)
  {
    this.mIsCompatibleLeftPan = paramBoolean;
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
    Object localObject;
    if (this.mHolder.mOffsetY >= 0)
    {
      localObject = this.mHeaderCallBack;
      if (localObject != null) {
        ((IHeaderCallBack)localObject).onFingerRelease();
      }
    }
    else
    {
      localObject = this.mFooterCallBack;
      if (localObject != null) {
        ((IFooterCallBack)localObject).onFingerRelease();
      }
    }
    this.mHandler.post(this.mRunnable);
  }
  
  public void stopLoadMore()
  {
    this.mState = VRefreshViewGroup.RefreshAndFooterViewState.STATE_FINISHED;
    IFooterCallBack localIFooterCallBack = this.mFooterCallBack;
    if (localIFooterCallBack != null) {
      localIFooterCallBack.onStateFinish(false);
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
    IHeaderCallBack localIHeaderCallBack;
    if ((paramBoolean) && (!this.mIsHeaderVisiableInScreen))
    {
      this.mIsHeaderVisiableInScreen = paramBoolean;
      getHeaderHeight();
      updateHeaderHeight(0, this.mHeaderViewHeight, new int[] { 0 });
      this.mContentView.scrollToTop(false);
      localIHeaderCallBack = this.mHeaderCallBack;
      if (localIHeaderCallBack != null) {
        localIHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
      }
    }
    else if ((!paramBoolean) && (this.mIsHeaderVisiableInScreen))
    {
      this.mIsHeaderVisiableInScreen = paramBoolean;
      updateHeaderHeight(0, -this.mHeaderViewHeight, new int[] { 0 });
      localIHeaderCallBack = this.mHeaderCallBack;
      if (localIHeaderCallBack != null) {
        localIHeaderCallBack.notifyVisiableChangeOnScreen(this.mIsHeaderVisiableInScreen);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.refresh.VRefreshViewGroup
 * JD-Core Version:    0.7.0.1
 */