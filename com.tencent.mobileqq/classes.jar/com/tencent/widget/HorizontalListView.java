package com.tencent.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListView
  extends AdapterView<ListAdapter>
{
  private static final String BUNDLE_ID_CURRENT_X = "BUNDLE_ID_CURRENT_X";
  private static final String BUNDLE_ID_PARENT_STATE = "BUNDLE_ID_PARENT_STATE";
  public static final boolean DEBUG = false;
  protected static final int INSERT_AT_END_OF_LIST = -1;
  protected static final int INSERT_AT_START_OF_LIST = 0;
  private static final int INVALID_POINTER = -1;
  public static final String TAG = "HorizontalListView";
  public static final int TAG_VIEW_TYPE = 2131886912;
  static final int TOUCH_MODE_DONE_WAITING = 2;
  static final int TOUCH_MODE_DOWN = 0;
  static final int TOUCH_MODE_FLING = 4;
  static final int TOUCH_MODE_OVERFLING = 6;
  static final int TOUCH_MODE_OVERSCROLL = 5;
  static final int TOUCH_MODE_REST = -1;
  static final int TOUCH_MODE_SCROLL = 3;
  static final int TOUCH_MODE_TAP = 1;
  public int MIN_SPACE = 50;
  protected boolean isFromRightToLeft = false;
  private int mActivePointerId = -1;
  protected ListAdapter mAdapter;
  private DataSetObserver mAdapterDataObserver;
  private ContextMenu.ContextMenuInfo mContextMenuInfo = null;
  protected int mCurrentScrollState = 4097;
  protected int mCurrentX;
  protected int mCurrentlySelectedAdapterIndex;
  protected boolean mDataChanged = false;
  private Runnable mDelayedLayout = new HorizontalListView.1(this);
  protected int mDisplayOffset;
  private Drawable mDivider = null;
  protected int mDividerWidth = 0;
  private Runnable mFlingRunnable;
  private boolean mHasNotifiedRunningLowOnData = false;
  private int mHeight;
  private int mHeightMeasureSpec;
  private boolean mIsBeingDragged = false;
  private int mLastAccessibilityScrollEventFromIndex;
  private int mLastAccessibilityScrollEventToIndex;
  private float mLastMotionX;
  protected int mLeftViewAdapterIndex;
  protected int mMaxX = 2147483647;
  private int mMaximumVelocity;
  protected int mMinX = 0;
  private int mMinimumVelocity;
  private int mMotionPosition;
  private int mMotionX;
  private int mMotionY;
  protected int mNextX;
  private HorizontalListView.OnItemScrollEventListener mOnItemScrollEventListener = null;
  private HorizontalListView.OnScrollLinstener mOnScrollLinstener = null;
  private HorizontalListView.OnScrollStateChangedListener mOnScrollStateChangedListener = null;
  private HorizontalListView.CheckForLongPress mPendingCheckForLongPress;
  private Runnable mPendingCheckForTap;
  private HorizontalListView.PerformClick mPerformClick;
  Runnable mPositionScrollAfterLayout;
  HorizontalListView.PositionScroller mPositionScroller;
  private Rect mRect = new Rect();
  private HorizontalListView.RecycleListener mRecycleListener;
  private List<Queue<View>> mRemovedViewsCache = new ArrayList();
  private Integer mRestoreX = null;
  protected int mRightViewAdapterIndex;
  private HorizontalListView.RunningOutOfDataListener mRunningOutOfDataListener = null;
  private int mRunningOutOfDataThreshold = 0;
  protected OverScroller mScroller;
  protected boolean mStayDisplayOffsetZero = false;
  private Rect mTouchFrame;
  int mTouchMode = -1;
  private Runnable mTouchModeReset;
  protected int mTouchSlop;
  private boolean mTransTouchState2Parent = false;
  private VelocityTracker mVelocityTracker;
  private View mViewBeingTouched = null;
  private int mWidth;
  
  public HorizontalListView(Context paramContext)
  {
    this(paramContext, null, false);
  }
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(0);
    }
    initView(paramBoolean);
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  public HorizontalListView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private void checkSpringback()
  {
    if (DEBUG) {
      log("checkSpringback", new Object[] { Integer.valueOf(this.mTouchMode) });
    }
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new HorizontalListView.3(this);
    }
    removeCallbacks(this.mFlingRunnable);
    getHandler().post(this.mFlingRunnable);
  }
  
  private void determineIfLowOnData()
  {
    if (this.mRunningOutOfDataListener != null)
    {
      ListAdapter localListAdapter = this.mAdapter;
      if ((localListAdapter != null) && (localListAdapter.getCount() - (this.mRightViewAdapterIndex + 1) < this.mRunningOutOfDataThreshold) && (!this.mHasNotifiedRunningLowOnData))
      {
        this.mHasNotifiedRunningLowOnData = true;
        this.mRunningOutOfDataListener.onRunningOutOfData();
      }
    }
  }
  
  private void drawDivider(Canvas paramCanvas, Rect paramRect)
  {
    Drawable localDrawable = this.mDivider;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramRect);
      this.mDivider.draw(paramCanvas);
    }
  }
  
  private void drawDividers(Canvas paramCanvas)
  {
    int j = getChildCount();
    Rect localRect = this.mRect;
    localRect.top = getPaddingTop();
    Object localObject = this.mRect;
    ((Rect)localObject).bottom = (((Rect)localObject).top + getRenderHeight());
    int i = 0;
    while (i < j)
    {
      if ((i != j - 1) || (!isLastItemInAdapter(this.mRightViewAdapterIndex)))
      {
        localObject = getChildAt(i);
        localRect.left = ((View)localObject).getRight();
        localRect.right = (((View)localObject).getRight() + this.mDividerWidth);
        if (localRect.left < getPaddingLeft()) {
          localRect.left = getPaddingLeft();
        }
        if (localRect.right > getWidth() - getPaddingRight()) {
          localRect.right = (getWidth() - getPaddingRight());
        }
        drawDivider(paramCanvas, localRect);
        if ((i == 0) && (((View)localObject).getLeft() > getPaddingLeft()))
        {
          localRect.left = getPaddingLeft();
          localRect.right = ((View)localObject).getLeft();
          drawDivider(paramCanvas, localRect);
        }
      }
      i += 1;
    }
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    recycleVelocityTracker();
  }
  
  private ViewGroup.LayoutParams getLayoutParams(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-2, -1);
    }
    return paramView;
  }
  
  private int getRenderHeight()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private int getRenderWidth()
  {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private boolean inChild(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      i = getScrollX();
      View localView1;
      if (this.isFromRightToLeft) {
        localView1 = getChildAt(getChildCount() - 1);
      } else {
        localView1 = getChildAt(0);
      }
      View localView2;
      if (this.isFromRightToLeft) {
        localView2 = getChildAt(0);
      } else {
        localView2 = getChildAt(getChildCount() - 1);
      }
      bool1 = bool2;
      if (paramInt1 >= localView1.getLeft() - i)
      {
        bool1 = bool2;
        if (paramInt2 >= localView1.getTop())
        {
          bool1 = bool2;
          if (paramInt1 < localView2.getRight() - i)
          {
            bool1 = bool2;
            if (paramInt2 < localView2.getBottom()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void initOrResetVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker == null)
    {
      this.mVelocityTracker = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.clear();
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void initializeRecycledViewCache(int paramInt)
  {
    this.mRemovedViewsCache.clear();
    int i = 0;
    while (i < paramInt)
    {
      this.mRemovedViewsCache.add(new LinkedList());
      i += 1;
    }
  }
  
  private boolean isItemViewTypeValid(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.mRemovedViewsCache.size());
  }
  
  private void markViewType(View paramView, int paramInt)
  {
    try
    {
      paramInt = this.mAdapter.getItemViewType(paramInt);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      paramInt = -1;
    }
    if ((paramView != null) && (isItemViewTypeValid(paramInt))) {
      paramView.setTag(TAG_VIEW_TYPE, Integer.valueOf(paramInt));
    }
  }
  
  private void measureChild(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams(paramView);
    int j = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    int i;
    if (localLayoutParams.width > 0) {
      i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i, j);
  }
  
  private int measureWidthOfChildren(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.mAdapter;
    if (localObject == null) {
      return getPaddingLeft() + getPaddingRight();
    }
    int m = getPaddingLeft() + getPaddingRight();
    int i = this.mDividerWidth;
    if ((i <= 0) || (this.mDivider == null)) {
      i = 0;
    }
    paramInt4 = m;
    int k = paramInt1;
    int j = paramInt2;
    if (paramInt2 == -1)
    {
      j = ((ListAdapter)localObject).getCount() - 1;
      k = paramInt1;
    }
    for (paramInt4 = m; k <= j; paramInt4 = paramInt1)
    {
      localObject = obtainView(k);
      if (localObject != null)
      {
        measureChild((View)localObject);
        paramInt1 = paramInt4;
        if (k > 0) {
          paramInt1 = paramInt4 + i;
        }
        paramInt2 = paramInt1 + ((View)localObject).getMeasuredWidth();
        recycleView(k, (View)localObject);
        paramInt1 = paramInt2;
        if (paramInt2 > paramInt3) {
          return paramInt3;
        }
      }
      else
      {
        paramInt1 = paramInt4;
        if (QLog.isColorLevel())
        {
          QLog.i("HorizontalListView", 2, "measureWidthOfChildren obtainView is null");
          paramInt1 = paramInt4;
        }
      }
      k += 1;
    }
    return paramInt4;
  }
  
  private View obtainView(int paramInt)
  {
    View localView1 = getRecycledView(paramInt);
    setTag(2131435140, Boolean.valueOf(true));
    View localView2 = this.mAdapter.getView(paramInt, localView1, this);
    markViewType(localView2, paramInt);
    if ((localView1 != null) && (localView2 != localView1)) {
      recycleView(paramInt, localView1);
    }
    if (localView2 != null) {
      setItemViewLayoutParams(localView2, paramInt);
    }
    return localView2;
  }
  
  private View obtainView(int paramInt, boolean paramBoolean)
  {
    View localView1 = getRecycledView(paramInt);
    setTag(2131435140, Boolean.valueOf(paramBoolean));
    View localView2 = this.mAdapter.getView(paramInt, localView1, this);
    markViewType(localView2, paramInt);
    if ((localView1 != null) && (localView2 != localView1)) {
      recycleView(paramInt, localView1);
    }
    if (localView2 != null) {
      setItemViewLayoutParams(localView2, paramInt);
    }
    return localView2;
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.clear();
      }
      this.mMotionX = ((int)paramMotionEvent.getX(i));
      this.mMotionY = ((int)paramMotionEvent.getY(i));
    }
  }
  
  private void onSizeChange()
  {
    setLayoutDirection(this.isFromRightToLeft);
  }
  
  private void reMeasureChilds()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      measureChild(getChildAt(i));
      i += 1;
    }
  }
  
  private void recycleBeforeRemoveAll()
  {
    int i = getFirstVisiblePosition();
    int j = getLastVisiblePosition();
    while ((i >= 0) && (i <= j))
    {
      View localView = getChild(i);
      if (localView != null)
      {
        HorizontalListView.RecycleListener localRecycleListener = this.mRecycleListener;
        if (localRecycleListener != null) {
          localRecycleListener.onRecycle(localView);
        }
        recycleView(i, localView);
      }
      i += 1;
    }
  }
  
  private void recycleVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private int reviseOverScrollByTouch(int paramInt1, int paramInt2)
  {
    int j = getScrollX();
    int i = j;
    if (getScrollX() > 0)
    {
      i = j;
      if (getScrollX() > paramInt2) {
        i = getScrollX() - paramInt2;
      }
    }
    paramInt2 = getWidth();
    if (paramInt1 * i < 0) {
      return paramInt1;
    }
    if (paramInt2 == 0) {
      return paramInt1;
    }
    return (paramInt2 - Math.abs(i)) * paramInt1 / paramInt2 / 2;
  }
  
  private void scrollIfNeeded(float paramFloat, int paramInt)
  {
    int k = this.mMaxX;
    int m = this.mMinX;
    int n = getOverScrollMode();
    int j = 1;
    int i = j;
    if (n != 0) {
      if ((n == 1) && (k > 0)) {
        i = j;
      } else {
        i = 0;
      }
    }
    j = getScrollX();
    n = this.mNextX;
    int i2 = j + n;
    int i1 = i2 + paramInt;
    if (i2 >= m)
    {
      j = paramInt;
      if (i2 <= k) {}
    }
    else
    {
      j = reviseOverScrollByTouch(paramInt, k);
    }
    if ((i != 0) && ((i1 < m) || (i1 > k)))
    {
      if (i1 < m) {
        paramInt = i1 - getScrollX() - m;
      } else {
        paramInt = i1 - getScrollX() - k;
      }
      i = getWidth();
      j = this.MIN_SPACE;
      overScrollBy(paramInt, 0, getScrollX(), 0, 0, 0, i - j, 0, true);
    }
    else
    {
      if (i2 != n) {
        scrollTo(0, 0);
      }
      this.mNextX += j;
    }
    if (i1 < m) {
      this.mNextX = m;
    } else if (i1 > k) {
      this.mNextX = k;
    }
    if (n != this.mNextX)
    {
      unpressTouchedView();
      requestLayout();
    }
    this.mLastMotionX = paramFloat;
  }
  
  private void setItemViewLayoutParams(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = generateDefaultLayoutParams();
    }
    else
    {
      localLayoutParams1 = localLayoutParams2;
      if (!checkLayoutParams(localLayoutParams2)) {
        localLayoutParams1 = generateLayoutParams(localLayoutParams2);
      }
    }
    paramView.setLayoutParams(localLayoutParams1);
  }
  
  private void unpressTouchedView()
  {
    View localView = this.mViewBeingTouched;
    if (localView != null)
    {
      localView.setPressed(false);
      this.mViewBeingTouched = null;
    }
    setPressed(false);
  }
  
  private void updateTouchedView(View paramView)
  {
    if (this.mViewBeingTouched != paramView)
    {
      unpressTouchedView();
      this.mViewBeingTouched = paramView;
    }
    paramView = this.mViewBeingTouched;
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  protected void addAndMeasureChild(View paramView, int paramInt)
  {
    addViewInLayout(paramView, paramInt, getLayoutParams(paramView), true);
    measureChild(paramView);
  }
  
  protected boolean checkScrollToChild()
  {
    boolean bool1 = this.mStayDisplayOffsetZero;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (!this.isFromRightToLeft ? Math.abs(this.mCurrentX - this.mMaxX) < this.mTouchSlop : Math.abs(this.mCurrentX - this.mMinX) < this.mTouchSlop) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = this.mMaxX;
      this.mCurrentX = i;
      this.mNextX = i;
      invalidate();
      return false;
    }
    int i = this.mTouchSlop;
    int j = this.mDisplayOffset;
    if (i + j >= 0)
    {
      this.mNextX += j;
      invalidate();
      return false;
    }
    Object localObject = getChildAt(0);
    bool1 = bool2;
    if (localObject != null)
    {
      j = this.mNextX + this.mDisplayOffset;
      int k = ((View)localObject).getMeasuredWidth();
      double d1 = this.mDisplayOffset;
      double d2 = k / 2;
      Double.isNaN(d2);
      i = j;
      if (d1 <= -(d2 + 0.5D)) {
        i = j + k;
      }
      localObject = this.mScroller;
      j = this.mNextX;
      bool1 = bool2;
      if (((OverScroller)localObject).springBack(getScrollX() + j, 0, i, i, 0, 0))
      {
        if (DEBUG) {
          log("checkScrollToChild", new Object[] { Integer.valueOf(this.mTouchMode), Integer.valueOf(i) });
        }
        invalidate();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void computeScroll()
  {
    boolean bool = this.mScroller.computeScrollOffset();
    int j = 1;
    if (bool)
    {
      int i2 = getScrollX() + this.mNextX;
      int k = this.mScroller.getCurrX();
      int m = this.mNextX;
      if (DEBUG) {
        log("computeScroll", new Object[] { "MOVING", Integer.valueOf(i2), Integer.valueOf(k) });
      }
      if (i2 != k)
      {
        int n = this.mMaxX;
        int i1 = this.mMinX;
        i = getOverScrollMode();
        if ((i != 0) && ((i != 1) || (n <= 0))) {
          i = 0;
        } else {
          i = 1;
        }
        if ((i != 0) && ((k < i1) || (k > n)))
        {
          int i3 = getWidth() - this.MIN_SPACE;
          if ((k < i1) && (k < -i3) && (k < i2)) {
            i = j;
          } else if ((n != 2147483647) && (k > n + i3) && (k > i2)) {
            i = j;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            this.mScroller.abortAnimation();
            OverScroller localOverScroller = this.mScroller;
            i = getScrollX();
            j = this.mNextX;
            i2 = getScrollY();
            i3 = this.mNextX;
            localOverScroller.springBack(j + i, i2, i3, i3, 0, 0);
          }
          else
          {
            overScrollBy(k - i2, 0, getScrollX(), getScrollY(), 0, 0, i3, 0, false);
          }
        }
        else
        {
          if (i2 != m) {
            scrollTo(0, 0);
          }
          this.mNextX += k - i2;
        }
        if (k < i1) {
          this.mNextX = i1;
        } else if (k > n) {
          this.mNextX = n;
        }
      }
      else if (Math.abs(getScrollX()) < this.mTouchSlop)
      {
        this.mNextX = i2;
        scrollTo(0, 0);
      }
      else
      {
        checkSpringback();
      }
      if (m != this.mNextX)
      {
        unpressTouchedView();
        requestLayout();
      }
      awakenScrollBars();
      postInvalidate();
      return;
    }
    int i = getScrollX();
    j = this.mCurrentScrollState;
    if ((j != 4099) && ((j != 4097) || (this.mMaxX != this.mNextX) || (i == 0))) {
      bool = false;
    } else {
      bool = true;
    }
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      log("computeScroll", new Object[] { "over", Integer.valueOf(this.mCurrentScrollState), Boolean.valueOf(bool) });
    }
    if (bool)
    {
      this.mTouchMode = -1;
      if (Math.abs(i) < this.mTouchSlop)
      {
        scrollTo(0, 0);
        setCurrentScrollState(4097);
        return;
      }
      checkSpringback();
    }
  }
  
  ContextMenu.ContextMenuInfo createContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
  }
  
  protected boolean determineBorderMaxX()
  {
    View localView;
    int i;
    if (this.isFromRightToLeft)
    {
      if (isLastItemInAdapter(this.mLeftViewAdapterIndex))
      {
        localView = getLeftmostChild();
        if (localView != null)
        {
          i = this.mMinX;
          this.mMinX = (this.mCurrentX + (localView.getLeft() - getPaddingLeft()));
          if (this.mMinX > 0) {
            this.mMinX = -2147483648;
          }
          if (this.mMinX != i) {
            return true;
          }
        }
      }
    }
    else if (isLastItemInAdapter(this.mRightViewAdapterIndex))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i = this.mMaxX;
        this.mMaxX = (this.mCurrentX + (localView.getRight() - getPaddingLeft()) - getRenderWidth());
        if (this.mMaxX < 0) {
          this.mMaxX = 0;
        }
        if (this.mMaxX != i) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  protected void fillList(int paramInt)
  {
    boolean bool = this.isFromRightToLeft;
    int k = 0;
    int j = 0;
    if (bool)
    {
      localView = getLeftmostChild();
      if (localView != null)
      {
        i = localView.getLeft();
        bool = false;
      }
      else
      {
        i = 0;
        bool = true;
      }
      fillListLeft(i, paramInt, bool);
      localView = getRightmostChild();
      i = j;
      if (localView != null) {
        i = localView.getRight();
      }
      fillListRight(i, paramInt);
      return;
    }
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    } else {
      i = 0;
    }
    fillListRight(i, paramInt);
    localView = getLeftmostChild();
    int i = k;
    if (localView != null) {
      i = localView.getLeft();
    }
    fillListLeft(i, paramInt);
  }
  
  protected void fillListLeft(int paramInt1, int paramInt2)
  {
    while (paramInt1 + paramInt2 - this.mDividerWidth > 0)
    {
      int i = this.mLeftViewAdapterIndex;
      if (i < 1) {
        break;
      }
      this.mLeftViewAdapterIndex = (i - 1);
      View localView = obtainView(this.mLeftViewAdapterIndex, false);
      if (localView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HorizontalListView", 2, "fillListLeft obtainView is null");
        }
      }
      else
      {
        addAndMeasureChild(localView, 0);
        if (this.mLeftViewAdapterIndex == 0) {
          i = localView.getMeasuredWidth();
        } else {
          i = this.mDividerWidth + localView.getMeasuredWidth();
        }
        i = paramInt1 - i;
        int j = this.mDisplayOffset;
        if (i + paramInt2 == 0)
        {
          paramInt1 = localView.getMeasuredWidth();
        }
        else
        {
          paramInt1 = this.mDividerWidth;
          paramInt1 = localView.getMeasuredWidth() + paramInt1;
        }
        this.mDisplayOffset = (j - paramInt1);
        paramInt1 = i;
        if (DEBUG)
        {
          log("fillListLeft", new Object[] { "mLeftViewAdapterIndex", Integer.valueOf(this.mLeftViewAdapterIndex) });
          paramInt1 = i;
        }
      }
    }
  }
  
  protected void fillListLeft(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (((paramBoolean) || (paramInt1 + paramInt2 - this.mDividerWidth > 0)) && (this.mLeftViewAdapterIndex + 1 < this.mAdapter.getCount()))
    {
      this.mLeftViewAdapterIndex += 1;
      if (this.mRightViewAdapterIndex < 0) {
        this.mRightViewAdapterIndex = this.mLeftViewAdapterIndex;
      }
      Object localObject = this.mAdapter;
      int i = this.mLeftViewAdapterIndex;
      localObject = ((ListAdapter)localObject).getView(i, getRecycledView(i), this);
      addAndMeasureChild((View)localObject, -1);
      if (this.mLeftViewAdapterIndex == 0) {
        i = getWidth() - ((View)localObject).getMeasuredWidth();
      } else {
        i = -(this.mDividerWidth + ((View)localObject).getMeasuredWidth());
      }
      paramInt1 += i;
      paramBoolean = false;
    }
  }
  
  protected void fillListRight(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    Object localObject;
    if (this.isFromRightToLeft) {
      while (paramInt1 + paramInt2 + this.mDividerWidth < getWidth())
      {
        i = this.mRightViewAdapterIndex;
        if (i < 1) {
          break;
        }
        this.mRightViewAdapterIndex = (i - 1);
        localObject = this.mAdapter;
        i = this.mRightViewAdapterIndex;
        localObject = ((ListAdapter)localObject).getView(i, getRecycledView(i), this);
        addAndMeasureChild((View)localObject, 0);
        if (this.mRightViewAdapterIndex == 0) {
          i = 0;
        } else {
          i = this.mDividerWidth;
        }
        i = paramInt1 + (i + ((View)localObject).getMeasuredWidth());
        int j = this.mDisplayOffset;
        if (getWidth() - (i + paramInt2) == 0)
        {
          paramInt1 = ((View)localObject).getMeasuredWidth();
        }
        else
        {
          paramInt1 = this.mDividerWidth;
          paramInt1 = ((View)localObject).getMeasuredWidth() + paramInt1;
        }
        this.mDisplayOffset = (j - paramInt1);
        paramInt1 = i;
      }
    }
    while ((i + paramInt2 + this.mDividerWidth < getWidth()) && (this.mRightViewAdapterIndex + 1 < this.mAdapter.getCount()))
    {
      this.mRightViewAdapterIndex += 1;
      if (this.mLeftViewAdapterIndex < 0) {
        this.mLeftViewAdapterIndex = this.mRightViewAdapterIndex;
      }
      localObject = obtainView(this.mRightViewAdapterIndex, false);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HorizontalListView", 2, "fillListRight obtainView is null");
        }
      }
      else
      {
        addAndMeasureChild((View)localObject, -1);
        if (this.mRightViewAdapterIndex == 0) {
          paramInt1 = 0;
        } else {
          paramInt1 = this.mDividerWidth;
        }
        paramInt1 = i + (paramInt1 + ((View)localObject).getMeasuredWidth());
        determineIfLowOnData();
        i = paramInt1;
        if (DEBUG)
        {
          log("fillListRight", new Object[] { "mRightViewAdapterIndex", Integer.valueOf(this.mRightViewAdapterIndex) });
          i = paramInt1;
        }
      }
    }
  }
  
  int findMotionColumn(int paramInt)
  {
    int i = getChildCount();
    if (i > 0)
    {
      i -= 1;
      while (i >= 0)
      {
        if (paramInt >= getChildAt(i).getLeft()) {
          return getFirstVisiblePosition() + i;
        }
        i -= 1;
      }
    }
    return -1;
  }
  
  public void fling(int paramInt)
  {
    this.mTouchMode = 6;
    setCurrentScrollState(4099);
    if (getChildCount() > 0)
    {
      OverScroller localOverScroller = this.mScroller;
      int i = this.mNextX;
      localOverScroller.fling(getScrollX() + i, 0, getFlingVelocity(paramInt), 0, this.mMinX, this.mMaxX, 0, 0, Math.max(0, getWidth() / 2), 0);
      requestLayout();
    }
  }
  
  public ListAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public View getChild(int paramInt)
  {
    int i = this.mLeftViewAdapterIndex;
    if ((paramInt >= i) && (paramInt <= this.mRightViewAdapterIndex)) {
      return getChildAt(paramInt - i);
    }
    return null;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.mContextMenuInfo;
  }
  
  public int getCurrentX()
  {
    return this.mCurrentX;
  }
  
  public int getFirstVisiblePosition()
  {
    if (this.isFromRightToLeft) {
      return this.mRightViewAdapterIndex;
    }
    return this.mLeftViewAdapterIndex;
  }
  
  protected int getFlingVelocity(int paramInt)
  {
    return paramInt;
  }
  
  public int getLastVisiblePosition()
  {
    if (this.isFromRightToLeft) {
      return this.mLeftViewAdapterIndex;
    }
    return this.mRightViewAdapterIndex;
  }
  
  protected View getLeftmostChild()
  {
    int i;
    if (this.isFromRightToLeft) {
      i = getChildCount() - 1;
    } else {
      i = 0;
    }
    return getChildAt(i);
  }
  
  @TargetApi(9)
  public int getOverScrollMode()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.getOverScrollMode();
    }
    return 0;
  }
  
  protected View getRecycledView(int paramInt)
  {
    try
    {
      paramInt = this.mAdapter.getItemViewType(paramInt);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      paramInt = -1;
    }
    if (isItemViewTypeValid(paramInt)) {
      return (View)((Queue)this.mRemovedViewsCache.get(paramInt)).poll();
    }
    return null;
  }
  
  protected View getRightmostChild()
  {
    int i;
    if (this.isFromRightToLeft) {
      i = 0;
    } else {
      i = getChildCount() - 1;
    }
    return getChildAt(i);
  }
  
  protected float getScrollerFriction()
  {
    return 0.005F;
  }
  
  public View getSelectedView()
  {
    return getChild(this.mCurrentlySelectedAdapterIndex);
  }
  
  @TargetApi(9)
  protected void initView()
  {
    initView(false);
  }
  
  @TargetApi(9)
  protected void initView(boolean paramBoolean)
  {
    this.mScroller = new OverScroller(getContext());
    this.mScroller.setFriction(getScrollerFriction());
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    setLayoutDirection(paramBoolean);
    this.mCurrentX = 0;
    this.mNextX = this.mCurrentX;
    this.mLeftViewAdapterIndex = -1;
    this.mRightViewAdapterIndex = -1;
    this.mDisplayOffset = 0;
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    this.mTouchMode = -1;
    setCurrentScrollState(4097);
    this.mAdapterDataObserver = new HorizontalListView.HorizontalAdapterDataObserver(this);
  }
  
  protected boolean isLastItemInAdapter(int paramInt)
  {
    return paramInt == this.mAdapter.getCount() - 1;
  }
  
  public void log(String paramString, Object... paramVarArgs)
  {
    if ((DEBUG) && (QLog.isDevelopLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      int i = 0;
      localStringBuilder.setLength(0);
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mDisplayOffset = ");
      localStringBuilder.append(this.mDisplayOffset);
      localStringBuilder.append(", mMaxX = ");
      localStringBuilder.append(this.mMaxX);
      localStringBuilder.append(", mMinX = ");
      localStringBuilder.append(this.mMinX);
      localStringBuilder.append(", mCurrentX = ");
      localStringBuilder.append(this.mCurrentX);
      localStringBuilder.append(", mNextX = ");
      localStringBuilder.append(this.mNextX);
      localStringBuilder.append(", mScrollX = ");
      localStringBuilder.append(getScrollX());
      localStringBuilder.append(", mLeftViewAdapterIndex= ");
      localStringBuilder.append(this.mLeftViewAdapterIndex);
      localStringBuilder.append(", mRightViewAdapterIndex = ");
      localStringBuilder.append(this.mRightViewAdapterIndex);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int j = paramVarArgs.length;
        while (i < j)
        {
          paramString = paramVarArgs[i];
          localStringBuilder.append(",");
          localStringBuilder.append(paramString);
          i += 1;
        }
      }
      QLog.i("HorizontalListView", 4, localStringBuilder.toString());
    }
  }
  
  public boolean needTtransTouchStateToParen()
  {
    return (this.mTransTouchState2Parent) && ((getParent() instanceof View));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      drawDividers(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  @TargetApi(16)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(AbsListView.class.getName());
    if (isEnabled())
    {
      if (getFirstVisiblePosition() > 0) {
        paramAccessibilityNodeInfo.addAction(8192);
      }
      ListAdapter localListAdapter = this.mAdapter;
      int i;
      if (localListAdapter == null) {
        i = 0;
      } else {
        i = localListAdapter.getCount();
      }
      if (getLastVisiblePosition() < i - 1) {
        paramAccessibilityNodeInfo.addAction(4096);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = true;
    if ((i == 2) && (this.mIsBeingDragged)) {
      return true;
    }
    i &= 0xFF;
    float f;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 6) {
              break label330;
            }
            onSecondaryPointerUp(paramMotionEvent);
            break label330;
          }
        }
        else
        {
          i = this.mActivePointerId;
          if (i == -1) {
            break label330;
          }
          f = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(i));
          if ((int)Math.abs(f - this.mLastMotionX) <= this.mTouchSlop) {
            break label330;
          }
          this.mIsBeingDragged = true;
          this.mLastMotionX = f;
          initVelocityTrackerIfNotExists();
          this.mVelocityTracker.addMovement(paramMotionEvent);
          localObject = getParent();
          if (localObject == null) {
            break label330;
          }
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          break label330;
        }
      }
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      recycleVelocityTracker();
      Object localObject = this.mScroller;
      i = getScrollX();
      int j = this.mNextX;
      int k = getScrollY();
      int m = this.mNextX;
      if (((OverScroller)localObject).springBack(i + j, k, m, m, 0, 0))
      {
        this.mTouchMode = 6;
        setCurrentScrollState(4099);
        invalidate();
      }
      else
      {
        this.mTouchMode = -1;
        setCurrentScrollState(4097);
      }
      unpressTouchedView();
    }
    else
    {
      f = paramMotionEvent.getX();
      if (!inChild((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
      }
      else
      {
        this.mLastMotionX = f;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mIsBeingDragged = (this.mScroller.isFinished() ^ true);
        setCurrentScrollState(4097);
      }
    }
    label330:
    if (!this.mIsBeingDragged)
    {
      if (super.onInterceptTouchEvent(paramMotionEvent)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mAdapter == null) {
      return;
    }
    invalidate();
    if (this.mDataChanged)
    {
      recycleBeforeRemoveAll();
      i = this.mCurrentX;
      initView(this.isFromRightToLeft);
      removeAllViewsInLayout();
      this.mNextX = i;
      this.mDataChanged = false;
      localObject = this.mPositionScrollAfterLayout;
      if (localObject != null)
      {
        post((Runnable)localObject);
        this.mPositionScrollAfterLayout = null;
      }
    }
    Object localObject = this.mRestoreX;
    if (localObject != null)
    {
      this.mNextX = ((Integer)localObject).intValue();
      this.mRestoreX = null;
    }
    int i = this.mNextX;
    int j = this.mMinX;
    if (i < j)
    {
      this.mNextX = j;
    }
    else
    {
      j = this.mMaxX;
      if (i > j) {
        this.mNextX = j;
      }
    }
    reMeasureChilds();
    i = this.mCurrentX - this.mNextX;
    removeNonVisibleChildren(i);
    fillList(i);
    positionChildren(i);
    this.mCurrentX = this.mNextX;
    localObject = this.mOnScrollLinstener;
    if (localObject != null) {
      ((HorizontalListView.OnScrollLinstener)localObject).onScroll();
    }
    if (determineBorderMaxX())
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    localObject = getRightmostChild();
    if ((localObject != null) && (((View)localObject).getRight() + this.mDividerWidth < getRenderWidth()) && (this.mRightViewAdapterIndex < this.mAdapter.getCount() - 1))
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if (!this.mScroller.isFinished()) {
      ViewCompat.postOnAnimation(this, this.mDelayedLayout);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    Object localObject = this.mAdapter;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ListAdapter)localObject).getCount();
    }
    if ((i > 0) && ((n == 0) || (n == -2147483648) || (m == 0)))
    {
      localObject = obtainView(0);
      if (localObject != null)
      {
        measureChild((View)localObject, paramInt1, paramInt2);
        paramInt1 = ((View)localObject).getMeasuredWidth();
        i = ((View)localObject).getMeasuredHeight();
        recycleView(0, (View)localObject);
        break label137;
      }
      if (QLog.isColorLevel()) {
        QLog.i("HorizontalListView", 2, "onMeasure obtainView is null");
      }
    }
    paramInt1 = 0;
    int i = 0;
    label137:
    if ((n != 0) && (n != -2147483648))
    {
      this.mHeightMeasureSpec = paramInt2;
      paramInt2 = k;
    }
    else
    {
      paramInt2 = getPaddingTop();
      k = getPaddingBottom();
      paramInt2 = getVerticalFadingEdgeLength() * 2 + (paramInt2 + k + i);
      this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, n);
    }
    if (m == 0)
    {
      paramInt1 = getPaddingLeft() + getPaddingRight() + paramInt1 + getVerticalScrollbarWidth();
    }
    else
    {
      paramInt1 = j;
      if (m == -2147483648) {
        paramInt1 = measureWidthOfChildren(0, -1, j, -1);
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
    i = this.mWidth;
    if ((i == 0) || (i == paramInt1))
    {
      i = this.mHeight;
      if ((i == 0) || (i == paramInt2)) {}
    }
    else
    {
      onSizeChange();
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
    awakenScrollBars();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.mRestoreX = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.mCurrentX);
    return localBundle;
  }
  
  @TargetApi(8)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    initVelocityTrackerIfNotExists();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction() & 0xFF;
    int j;
    Object localObject;
    if (i != 0)
    {
      float f1;
      int k;
      int m;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i != 6) {
                return true;
              }
              onSecondaryPointerUp(paramMotionEvent);
              i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
              if ((i < paramMotionEvent.getPointerCount()) && (-1 != i)) {
                this.mLastMotionX = paramMotionEvent.getX(i);
              }
              i = pointToPosition(this.mMotionX, this.mMotionY);
              if (i >= 0)
              {
                this.mMotionPosition = i;
                return true;
              }
            }
            else
            {
              i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
              f1 = paramMotionEvent.getX(i);
              float f2 = paramMotionEvent.getY(i);
              this.mLastMotionX = f1;
              this.mActivePointerId = paramMotionEvent.getPointerId(i);
              i = (int)f1;
              this.mMotionX = i;
              j = (int)f2;
              this.mMotionY = j;
              i = pointToPosition(i, j);
              if (i >= 0)
              {
                this.mMotionPosition = i;
                return true;
              }
            }
          }
          else
          {
            unpressTouchedView();
            if ((this.mIsBeingDragged) && (getChildCount() > 0))
            {
              paramMotionEvent = this.mScroller;
              i = getScrollX();
              j = this.mNextX;
              k = getScrollY();
              m = this.mNextX;
              if (paramMotionEvent.springBack(i + j, k, m, m, 0, 0))
              {
                this.mTouchMode = 6;
                setCurrentScrollState(4099);
                invalidate();
              }
              else
              {
                setCurrentScrollState(4097);
              }
              this.mActivePointerId = -1;
              endDrag();
            }
            i = this.mTouchMode;
            if ((i != 5) && (i != 6))
            {
              this.mTouchMode = -1;
              unpressTouchedView();
              paramMotionEvent = getHandler();
              if (paramMotionEvent != null) {
                paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
              }
            }
            if (DEBUG)
            {
              log("onTouchEvent", new Object[] { "CANCEL", Integer.valueOf(this.mTouchMode) });
              return true;
            }
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i == -1) {
            return true;
          }
          f1 = paramMotionEvent.getX(i);
          j = (int)(this.mLastMotionX - f1);
          i = j;
          if (!this.mIsBeingDragged)
          {
            i = j;
            if (Math.abs(j) > this.mTouchSlop)
            {
              paramMotionEvent = getParent();
              if (paramMotionEvent != null) {
                paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              }
              this.mIsBeingDragged = true;
              if (j > 0) {
                i = j - this.mTouchSlop;
              } else {
                i = j + this.mTouchSlop;
              }
            }
          }
          if (this.mIsBeingDragged)
          {
            j = this.mTouchMode;
            if ((j != 0) && (j != 1) && (j != 2))
            {
              if ((j == 3) || (j == 5)) {
                if (getScrollX() != 0) {
                  this.mTouchMode = 5;
                } else {
                  this.mTouchMode = 3;
                }
              }
            }
            else
            {
              paramMotionEvent = getHandler();
              if (paramMotionEvent != null) {
                paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
              }
              paramMotionEvent = this.mTouchModeReset;
              if (paramMotionEvent != null) {
                removeCallbacks(paramMotionEvent);
              }
              unpressTouchedView();
              if (getScrollX() != 0) {
                this.mTouchMode = 5;
              } else {
                this.mTouchMode = 3;
              }
            }
            setCurrentScrollState(4098);
            scrollIfNeeded(f1, i);
            return true;
          }
        }
      }
      else
      {
        if ((this.mIsBeingDragged) || (Math.abs(getScrollX()) > this.mTouchSlop))
        {
          localObject = this.mVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
          if (Build.VERSION.SDK_INT >= 8) {
            f1 = ((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
          } else {
            f1 = ((VelocityTracker)localObject).getXVelocity();
          }
          i = (int)f1;
          if (getChildCount() > 0)
          {
            if (Math.abs(i) > this.mMinimumVelocity)
            {
              fling(-i);
            }
            else
            {
              localObject = this.mScroller;
              i = getScrollX();
              j = this.mNextX;
              k = getScrollY();
              m = this.mNextX;
              if (((OverScroller)localObject).springBack(i + j, k, m, m, 0, 0))
              {
                this.mTouchMode = 6;
                setCurrentScrollState(4099);
                invalidate();
              }
              else
              {
                setCurrentScrollState(4097);
              }
            }
          }
          else {
            setCurrentScrollState(4097);
          }
          this.mActivePointerId = -1;
          endDrag();
        }
        i = this.mTouchMode;
        if ((i != 0) && (i != 1) && (i != 2))
        {
          if (i != 3)
          {
            if (i == 5) {
              this.mTouchMode = -1;
            }
          }
          else {
            this.mTouchMode = -1;
          }
        }
        else
        {
          j = this.mMotionPosition;
          localObject = getChildAt(j - getFirstVisiblePosition());
          f1 = paramMotionEvent.getX();
          if ((f1 > getPaddingLeft()) && (f1 < getWidth() - getPaddingRight())) {
            i = 1;
          } else {
            i = 0;
          }
          if (this.mPerformClick == null) {
            this.mPerformClick = new HorizontalListView.PerformClick(this, null);
          }
          HorizontalListView.PerformClick localPerformClick = this.mPerformClick;
          localPerformClick.mClickMotionPosition = j;
          localPerformClick.rememberWindowAttachCount();
          if ((localObject != null) && (!((View)localObject).hasFocusable()) && (i != 0))
          {
            if (this.mTouchMode != 0)
            {
              unpressTouchedView();
              paramMotionEvent = this.mTouchModeReset;
              if (paramMotionEvent != null) {
                removeCallbacks(paramMotionEvent);
              }
            }
            i = this.mTouchMode;
            if ((i != 0) && (i != 1))
            {
              if ((!this.mDataChanged) && (this.mAdapter.isEnabled(j))) {
                localPerformClick.run();
              }
            }
            else
            {
              Handler localHandler = getHandler();
              if (localHandler != null)
              {
                if (this.mTouchMode == 0) {
                  paramMotionEvent = this.mPendingCheckForTap;
                } else {
                  paramMotionEvent = this.mPendingCheckForLongPress;
                }
                localHandler.removeCallbacks(paramMotionEvent);
              }
              if ((!this.mDataChanged) && (this.mAdapter.isEnabled(j)))
              {
                this.mTouchMode = 1;
                if (needTtransTouchStateToParen()) {
                  updateTouchedView((View)getParent());
                } else {
                  updateTouchedView((View)localObject);
                }
                paramMotionEvent = this.mTouchModeReset;
                if (paramMotionEvent != null) {
                  removeCallbacks(paramMotionEvent);
                }
                this.mTouchModeReset = new HorizontalListView.2(this, localPerformClick);
                postDelayed(this.mTouchModeReset, ViewConfiguration.getPressedStateDuration());
                return true;
              }
              this.mTouchMode = -1;
              return true;
            }
          }
          else
          {
            localPerformClick.run();
          }
          this.mTouchMode = -1;
        }
        setPressed(false);
        invalidate();
        paramMotionEvent = getHandler();
        if (paramMotionEvent != null) {
          paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
        }
        if (DEBUG)
        {
          log("onTouchEvent", new Object[] { "UP", Integer.valueOf(this.mTouchMode) });
          return true;
        }
      }
    }
    else
    {
      if (getChildCount() == 0) {
        return false;
      }
      if (this.mTouchMode == 6)
      {
        this.mTouchMode = 5;
        this.mMotionX = ((int)paramMotionEvent.getX());
        this.mMotionY = ((int)paramMotionEvent.getY());
      }
      else
      {
        if (needTtransTouchStateToParen())
        {
          this.mTouchMode = 0;
          if (this.mPendingCheckForTap == null) {
            this.mPendingCheckForTap = new HorizontalListView.CheckForTap(this);
          }
          postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
          this.mMotionPosition = getFirstVisiblePosition();
        }
        else
        {
          j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
          i = j;
          if (!this.mDataChanged) {
            if ((this.mTouchMode != 4) && (j >= 0) && (getAdapter().isEnabled(j)))
            {
              this.mTouchMode = 0;
              if (this.mPendingCheckForTap == null) {
                this.mPendingCheckForTap = new HorizontalListView.CheckForTap(this);
              }
              postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
              i = j;
            }
            else
            {
              i = j;
              if (this.mTouchMode == 4)
              {
                this.mTouchMode = 3;
                i = findMotionColumn((int)paramMotionEvent.getX());
              }
            }
          }
          this.mMotionPosition = i;
        }
        this.mMotionX = ((int)paramMotionEvent.getX());
        this.mMotionY = ((int)paramMotionEvent.getY());
      }
      boolean bool = this.mScroller.isFinished() ^ true;
      this.mIsBeingDragged = bool;
      if (bool)
      {
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
      }
      if (!this.mScroller.isFinished()) {
        this.mScroller.abortAnimation();
      }
      this.mLastMotionX = paramMotionEvent.getX();
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      setCurrentScrollState(4097);
      if (DEBUG) {
        log("onTouchEvent", new Object[] { "DOWN", Boolean.valueOf(this.mIsBeingDragged) });
      }
    }
    return true;
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int k = getOverScrollMode();
    int i = computeHorizontalScrollRange();
    int j = computeHorizontalScrollExtent();
    boolean bool2 = false;
    if (i > j) {
      i = 1;
    } else {
      i = 0;
    }
    if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
      j = 1;
    } else {
      j = 0;
    }
    if ((k != 0) && ((k != 1) || (i == 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((k != 0) && ((k != 1) || (j == 0))) {
      j = 0;
    } else {
      j = 1;
    }
    paramInt3 += paramInt1;
    if (i == 0) {
      paramInt7 = 0;
    }
    paramInt4 += paramInt2;
    if (j == 0) {
      paramInt8 = 0;
    }
    i = -paramInt7;
    paramInt2 = 2147483647;
    if (paramInt7 == 2147483647) {
      paramInt1 = 2147483647;
    } else {
      paramInt1 = paramInt7 + paramInt5;
    }
    paramInt5 = -paramInt8;
    if (paramInt8 != 2147483647) {
      paramInt2 = paramInt8 + paramInt6;
    }
    if (paramInt3 > paramInt1) {}
    for (;;)
    {
      paramBoolean = true;
      break label215;
      if (paramInt3 >= i) {
        break;
      }
      paramInt1 = i;
    }
    paramInt1 = paramInt3;
    paramBoolean = false;
    label215:
    if (paramInt4 > paramInt2) {}
    for (;;)
    {
      bool1 = true;
      break label246;
      if (paramInt4 >= paramInt5) {
        break;
      }
      paramInt2 = paramInt5;
    }
    paramInt2 = paramInt4;
    boolean bool1 = false;
    label246:
    onOverScrolled(paramInt1, paramInt2, paramBoolean, bool1);
    if (!paramBoolean)
    {
      paramBoolean = bool2;
      if (!bool1) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  @TargetApi(16)
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    paramBundle = this.mAdapter;
    int i;
    if (paramBundle == null) {
      i = 0;
    } else {
      i = paramBundle.getCount();
    }
    int j;
    if (paramInt != 4096)
    {
      if (paramInt != 8192) {
        return false;
      }
      if ((isEnabled()) && (getFirstVisiblePosition() > 0))
      {
        paramInt = getWidth();
        i = getPaddingLeft();
        j = getPaddingRight();
        scrollIfNeeded(this.mLastMotionX, -(paramInt - i - j));
        return true;
      }
      return false;
    }
    if ((isEnabled()) && (getLastVisiblePosition() < i - 1))
    {
      paramInt = getWidth();
      i = getPaddingLeft();
      j = getPaddingRight();
      scrollIfNeeded(this.mLastMotionX, paramInt - i - j);
      return true;
    }
    return false;
  }
  
  boolean performLongPress(View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemLongClickListener localOnItemLongClickListener = getOnItemLongClickListener();
    boolean bool1;
    if (localOnItemLongClickListener != null) {
      bool1 = localOnItemLongClickListener.onItemLongClick(this, paramView, paramInt, paramLong);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      this.mContextMenuInfo = createContextMenuInfo(paramView, paramInt, paramLong);
      bool2 = super.showContextMenuForChild(this);
    }
    if (bool2) {
      performHapticFeedback(0);
    }
    return bool2;
  }
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.mTouchFrame;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.mTouchFrame = new Rect();
      localObject1 = this.mTouchFrame;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = getChildAt(i);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return getFirstVisiblePosition() + i;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  protected void positionChildren(int paramInt)
  {
    int m = getChildCount();
    if (m > 0)
    {
      boolean bool = DEBUG;
      int k = 0;
      int j = 0;
      if (bool) {
        log("positionChildren", new Object[] { Integer.valueOf(this.mDisplayOffset), Integer.valueOf(paramInt), Integer.valueOf(this.mDisplayOffset + paramInt) });
      }
      View localView;
      if (this.isFromRightToLeft)
      {
        this.mDisplayOffset -= paramInt;
        i = getWidth() - this.mDisplayOffset;
        paramInt = j;
        while (paramInt < m)
        {
          localView = getChildAt(paramInt);
          j = getPaddingRight() + i;
          k = localView.getMeasuredWidth();
          int n = getPaddingTop();
          localView.layout(j - k, n, j, localView.getMeasuredHeight() + n);
          i -= localView.getMeasuredWidth() + this.mDividerWidth;
          paramInt += 1;
        }
      }
      if (this.mLeftViewAdapterIndex == 0) {
        this.mMinX = (this.mDisplayOffset + this.mCurrentX);
      }
      this.mDisplayOffset += paramInt;
      int i = this.mDisplayOffset;
      paramInt = k;
      while (paramInt < m)
      {
        localView = getChildAt(paramInt);
        j = getPaddingLeft() + i;
        k = getPaddingTop();
        localView.layout(j, k, localView.getMeasuredWidth() + j, localView.getMeasuredHeight() + k);
        i += localView.getMeasuredWidth() + this.mDividerWidth;
        paramInt += 1;
      }
    }
  }
  
  protected void recycleView(int paramInt, View paramView)
  {
    int k = -1;
    int j = k;
    try
    {
      Object localObject = paramView.getTag(TAG_VIEW_TYPE);
      int i = k;
      j = k;
      if ((localObject instanceof Integer))
      {
        j = k;
        i = ((Integer)localObject).intValue();
      }
      j = i;
      k = i;
      if (!isItemViewTypeValid(i))
      {
        j = i;
        k = this.mAdapter.getItemViewType(paramInt);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      k = j;
    }
    if (isItemViewTypeValid(k))
    {
      ((Queue)this.mRemovedViewsCache.get(k)).offer(paramView);
      HorizontalListView.RecycleListener localRecycleListener = this.mRecycleListener;
      if (localRecycleListener != null) {
        localRecycleListener.onViewRecycled(paramView);
      }
    }
  }
  
  protected void removeNonVisibleChildren(int paramInt)
  {
    int j;
    int i;
    if (this.isFromRightToLeft)
    {
      for (localObject = getRightmostChild(); (localObject != null) && (((View)localObject).getLeft() + paramInt >= getWidth()); localObject = getRightmostChild())
      {
        j = this.mDisplayOffset;
        if (isLastItemInAdapter(this.mRightViewAdapterIndex)) {
          i = ((View)localObject).getMeasuredWidth();
        } else {
          i = this.mDividerWidth + ((View)localObject).getMeasuredWidth();
        }
        this.mDisplayOffset = (j + i);
        recycleView(this.mRightViewAdapterIndex, (View)localObject);
        removeViewInLayout((View)localObject);
        this.mRightViewAdapterIndex += 1;
      }
      for (localObject = getLeftmostChild(); (localObject != null) && (((View)localObject).getRight() + paramInt <= 0); localObject = getLeftmostChild())
      {
        recycleView(this.mLeftViewAdapterIndex, (View)localObject);
        removeViewInLayout((View)localObject);
        this.mLeftViewAdapterIndex -= 1;
      }
    }
    for (Object localObject = getLeftmostChild(); (localObject != null) && (((View)localObject).getRight() + paramInt <= 0); localObject = getLeftmostChild())
    {
      j = this.mDisplayOffset;
      if (isLastItemInAdapter(this.mLeftViewAdapterIndex)) {
        i = ((View)localObject).getMeasuredWidth();
      } else {
        i = this.mDividerWidth + ((View)localObject).getMeasuredWidth();
      }
      this.mDisplayOffset = (j + i);
      recycleView(this.mLeftViewAdapterIndex, (View)localObject);
      removeViewInLayout((View)localObject);
      localObject = this.mOnItemScrollEventListener;
      if (localObject != null) {
        ((HorizontalListView.OnItemScrollEventListener)localObject).onItemScrollNonVisible(this.mLeftViewAdapterIndex, true);
      }
      this.mLeftViewAdapterIndex += 1;
    }
    for (localObject = getRightmostChild(); (localObject != null) && (((View)localObject).getLeft() + paramInt >= getWidth()); localObject = getRightmostChild())
    {
      recycleView(this.mRightViewAdapterIndex, (View)localObject);
      removeViewInLayout((View)localObject);
      localObject = this.mOnItemScrollEventListener;
      if (localObject != null) {
        ((HorizontalListView.OnItemScrollEventListener)localObject).onItemScrollNonVisible(this.mRightViewAdapterIndex, false);
      }
      this.mRightViewAdapterIndex -= 1;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      recycleVelocityTracker();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean) {
      recycleBeforeRemoveAll();
    }
    initView(this.isFromRightToLeft);
    removeAllViewsInLayout();
    requestLayout();
  }
  
  public void resetCurrentX(int paramInt)
  {
    this.mCurrentX = paramInt;
  }
  
  public int scrollBy2(int paramInt)
  {
    int i = this.mNextX;
    int j = i + paramInt;
    if (j < 0) {
      return -1;
    }
    if (j > this.mMaxX) {
      return 1;
    }
    this.mScroller.startScroll(i, 0, paramInt, 0, 20);
    setCurrentScrollState(4098);
    requestLayout();
    return 0;
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (paramInt == 4096)
    {
      int i = getFirstVisiblePosition();
      int j = getLastVisiblePosition();
      if ((this.mLastAccessibilityScrollEventFromIndex == i) && (this.mLastAccessibilityScrollEventToIndex == j)) {
        return;
      }
      this.mLastAccessibilityScrollEventFromIndex = i;
      this.mLastAccessibilityScrollEventToIndex = j;
    }
    super.sendAccessibilityEvent(paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ListAdapter localListAdapter = this.mAdapter;
    if (localListAdapter != null) {
      try
      {
        localListAdapter.unregisterDataSetObserver(this.mAdapterDataObserver);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if (paramListAdapter != null)
    {
      this.mHasNotifiedRunningLowOnData = false;
      this.mAdapter = paramListAdapter;
      this.mAdapter.registerDataSetObserver(this.mAdapterDataObserver);
    }
    paramListAdapter = this.mAdapter;
    if (paramListAdapter != null) {
      initializeRecycledViewCache(paramListAdapter.getViewTypeCount());
    }
    reset(false);
  }
  
  protected void setCurrentScrollState(int paramInt)
  {
    int i = paramInt;
    if (this.mStayDisplayOffsetZero)
    {
      int j = this.mCurrentScrollState;
      i = paramInt;
      if (j != paramInt)
      {
        i = paramInt;
        if (paramInt == 4097) {
          if (j != 4098)
          {
            if (j != 4099)
            {
              i = paramInt;
            }
            else
            {
              i = paramInt;
              if (checkScrollToChild())
              {
                i = paramInt;
                if (DEBUG)
                {
                  log("setCurrentScrollState", new Object[] { "SCROLL_STATE_FLING" });
                  i = paramInt;
                }
              }
            }
          }
          else
          {
            i = paramInt;
            if (checkScrollToChild())
            {
              if (DEBUG) {
                log("setCurrentScrollState", new Object[] { "SCROLL_STATE_TOUCH_SCROLL" });
              }
              i = 4099;
            }
          }
        }
      }
    }
    if (this.mCurrentScrollState != i)
    {
      HorizontalListView.OnScrollStateChangedListener localOnScrollStateChangedListener = this.mOnScrollStateChangedListener;
      if (localOnScrollStateChangedListener != null) {
        localOnScrollStateChangedListener.onScrollStateChanged(i);
      }
    }
    this.mCurrentScrollState = i;
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    this.mDivider = paramDrawable;
    if (paramDrawable != null)
    {
      setDividerWidth(paramDrawable.getIntrinsicWidth());
      return;
    }
    setDividerWidth(0);
  }
  
  public void setDividerWidth(int paramInt)
  {
    this.mDividerWidth = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setLayoutDirection(boolean paramBoolean)
  {
    this.isFromRightToLeft = paramBoolean;
    if (paramBoolean)
    {
      this.mMaxX = 0;
      this.mMinX = -2147483648;
      return;
    }
    this.mMaxX = 2147483647;
    this.mMinX = 0;
  }
  
  public void setOnItemScollEventListener(HorizontalListView.OnItemScrollEventListener paramOnItemScrollEventListener)
  {
    this.mOnItemScrollEventListener = paramOnItemScrollEventListener;
  }
  
  public void setOnScrollListener(HorizontalListView.OnScrollLinstener paramOnScrollLinstener)
  {
    this.mOnScrollLinstener = paramOnScrollLinstener;
  }
  
  public void setOnScrollStateChangedListener(HorizontalListView.OnScrollStateChangedListener paramOnScrollStateChangedListener)
  {
    this.mOnScrollStateChangedListener = paramOnScrollStateChangedListener;
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(paramInt);
    }
  }
  
  public void setRecycleListener(HorizontalListView.RecycleListener paramRecycleListener)
  {
    this.mRecycleListener = paramRecycleListener;
  }
  
  public void setRestoreX(int paramInt)
  {
    this.mRestoreX = Integer.valueOf(paramInt);
  }
  
  public void setRunningOutOfDataListener(HorizontalListView.RunningOutOfDataListener paramRunningOutOfDataListener, int paramInt)
  {
    this.mRunningOutOfDataListener = paramRunningOutOfDataListener;
    this.mRunningOutOfDataThreshold = paramInt;
  }
  
  public void setSelection(int paramInt)
  {
    this.mCurrentlySelectedAdapterIndex = paramInt;
  }
  
  public void setStayDisplayOffsetZero(boolean paramBoolean)
  {
    this.mStayDisplayOffsetZero = paramBoolean;
  }
  
  public void setTransTouchStateToParent(boolean paramBoolean)
  {
    this.mTransTouchState2Parent = paramBoolean;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    this.mTouchMode = 4;
    setCurrentScrollState(4099);
    int i = this.mCurrentX;
    if (this.mScroller.isFinished()) {
      i = getScrollX() + this.mNextX;
    }
    this.mScroller.startScroll(i, 0, -paramInt1, 0, paramInt2);
    this.mLastMotionX = 0.0F;
    recycleVelocityTracker();
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new HorizontalListView.PositionScroller(this);
    }
    this.mPositionScroller.start(paramInt);
  }
  
  public void smoothScrollToPosition(int paramInt1, int paramInt2)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new HorizontalListView.PositionScroller(this);
    }
    this.mPositionScroller.start(paramInt1, paramInt2);
  }
  
  public void smoothScrollToPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new HorizontalListView.PositionScroller(this);
    }
    this.mPositionScroller.start(paramInt1, paramInt2, paramInt3);
  }
  
  public void smoothScrollToPositionFromLeftOrRight(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new HorizontalListView.PositionScroller(this);
    }
    this.mPositionScroller.startWithOffset(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */