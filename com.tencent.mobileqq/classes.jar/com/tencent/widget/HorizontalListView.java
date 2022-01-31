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
import beka;
import bekb;
import bekc;
import bekd;
import beke;
import bekf;
import belr;
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
  public static final int TAG_VIEW_TYPE = 2131624591;
  static final int TOUCH_MODE_DONE_WAITING = 2;
  static final int TOUCH_MODE_DOWN = 0;
  static final int TOUCH_MODE_FLING = 4;
  static final int TOUCH_MODE_OVERFLING = 6;
  static final int TOUCH_MODE_OVERSCROLL = 5;
  static final int TOUCH_MODE_REST = -1;
  static final int TOUCH_MODE_SCROLL = 3;
  static final int TOUCH_MODE_TAP = 1;
  public int MIN_SPACE = 50;
  protected boolean isFromRightToLeft;
  private int mActivePointerId = -1;
  protected ListAdapter mAdapter;
  private DataSetObserver mAdapterDataObserver;
  private ContextMenu.ContextMenuInfo mContextMenuInfo;
  protected int mCurrentScrollState = 4097;
  protected int mCurrentX;
  public int mCurrentlySelectedAdapterIndex;
  public boolean mDataChanged;
  private Runnable mDelayedLayout = new HorizontalListView.1(this);
  protected int mDisplayOffset;
  private Drawable mDivider;
  protected int mDividerWidth;
  private Runnable mFlingRunnable;
  private boolean mHasNotifiedRunningLowOnData;
  private int mHeight;
  private int mHeightMeasureSpec;
  private boolean mIsBeingDragged;
  private int mLastAccessibilityScrollEventFromIndex;
  private int mLastAccessibilityScrollEventToIndex;
  private float mLastMotionX;
  protected int mLeftViewAdapterIndex;
  protected int mMaxX = 2147483647;
  private int mMaximumVelocity;
  protected int mMinX;
  private int mMinimumVelocity;
  private int mMotionPosition;
  private int mMotionX;
  private int mMotionY;
  protected int mNextX;
  private bekb mOnItemScrollEventListener;
  private bekc mOnScrollLinstener;
  private bekd mOnScrollStateChangedListener;
  private HorizontalListView.CheckForLongPress mPendingCheckForLongPress;
  private Runnable mPendingCheckForTap;
  private HorizontalListView.PerformClick mPerformClick;
  Runnable mPositionScrollAfterLayout;
  HorizontalListView.PositionScroller mPositionScroller;
  private Rect mRect = new Rect();
  private beke mRecycleListener;
  private List<Queue<View>> mRemovedViewsCache = new ArrayList();
  private Integer mRestoreX;
  protected int mRightViewAdapterIndex;
  private bekf mRunningOutOfDataListener;
  private int mRunningOutOfDataThreshold;
  protected belr mScroller;
  protected boolean mStayDisplayOffsetZero;
  private Rect mTouchFrame;
  int mTouchMode = -1;
  private Runnable mTouchModeReset;
  protected int mTouchSlop;
  private boolean mTransTouchState2Parent;
  private VelocityTracker mVelocityTracker;
  private View mViewBeingTouched;
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
    if ((this.mRunningOutOfDataListener != null) && (this.mAdapter != null) && (this.mAdapter.getCount() - (this.mRightViewAdapterIndex + 1) < this.mRunningOutOfDataThreshold) && (!this.mHasNotifiedRunningLowOnData))
    {
      this.mHasNotifiedRunningLowOnData = true;
      this.mRunningOutOfDataListener.a();
    }
  }
  
  private void drawDivider(Canvas paramCanvas, Rect paramRect)
  {
    if (this.mDivider != null)
    {
      this.mDivider.setBounds(paramRect);
      this.mDivider.draw(paramCanvas);
    }
  }
  
  private void drawDividers(Canvas paramCanvas)
  {
    int j = getChildCount();
    Rect localRect = this.mRect;
    this.mRect.top = getPaddingTop();
    this.mRect.bottom = (this.mRect.top + getRenderHeight());
    int i = 0;
    while (i < j)
    {
      if ((i != j - 1) || (!isLastItemInAdapter(this.mRightViewAdapterIndex)))
      {
        View localView = getChildAt(i);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.mDividerWidth);
        if (localRect.left < getPaddingLeft()) {
          localRect.left = getPaddingLeft();
        }
        if (localRect.right > getWidth() - getPaddingRight()) {
          localRect.right = (getWidth() - getPaddingRight());
        }
        drawDivider(paramCanvas, localRect);
        if ((i == 0) && (localView.getLeft() > getPaddingLeft()))
        {
          localRect.left = getPaddingLeft();
          localRect.right = localView.getLeft();
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
    if (getChildCount() > 0)
    {
      int i = getScrollX();
      View localView1;
      if (this.isFromRightToLeft)
      {
        localView1 = getChildAt(getChildCount() - 1);
        if (!this.isFromRightToLeft) {
          break label97;
        }
      }
      label97:
      for (View localView2 = getChildAt(0);; localView2 = getChildAt(getChildCount() - 1))
      {
        if ((paramInt1 < localView1.getLeft() - i) || (paramInt2 < localView1.getTop()) || (paramInt1 >= localView2.getRight() - i) || (paramInt2 >= localView2.getBottom())) {
          break label112;
        }
        return true;
        localView1 = getChildAt(0);
        break;
      }
      label112:
      return false;
    }
    return false;
  }
  
  private void initOrResetVelocityTracker()
  {
    if (this.mVelocityTracker == null)
    {
      this.mVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.mVelocityTracker.clear();
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
      if ((paramView != null) && (isItemViewTypeValid(paramInt))) {
        paramView.setTag(2131624591, Integer.valueOf(paramInt));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        paramInt = -1;
      }
    }
  }
  
  private void measureChild(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams(paramView);
    int j = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i, j);
      return;
    }
  }
  
  private int measureWidthOfChildren(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.mAdapter;
    if (localObject == null) {
      paramInt1 = getPaddingLeft() + getPaddingRight();
    }
    int i;
    int k;
    label87:
    do
    {
      return paramInt1;
      int m = getPaddingLeft() + getPaddingRight();
      if ((this.mDividerWidth <= 0) || (this.mDivider == null)) {
        break;
      }
      i = this.mDividerWidth;
      paramInt4 = m;
      k = paramInt1;
      int j = paramInt2;
      if (paramInt2 == -1)
      {
        j = ((ListAdapter)localObject).getCount() - 1;
        k = paramInt1;
        paramInt4 = m;
      }
      if (k > j) {
        break label194;
      }
      localObject = obtainView(k);
      if (localObject == null) {
        break label170;
      }
      measureChild((View)localObject);
      paramInt1 = paramInt4;
      if (k > 0) {
        paramInt1 = paramInt4 + i;
      }
      paramInt2 = paramInt1 + ((View)localObject).getMeasuredWidth();
      recycleView(k, (View)localObject);
      paramInt1 = paramInt3;
    } while (paramInt2 > paramInt3);
    paramInt1 = paramInt2;
    for (;;)
    {
      k += 1;
      paramInt4 = paramInt1;
      break label87;
      i = 0;
      break;
      label170:
      paramInt1 = paramInt4;
      if (QLog.isColorLevel())
      {
        QLog.i("HorizontalListView", 2, "measureWidthOfChildren obtainView is null");
        paramInt1 = paramInt4;
      }
    }
    label194:
    return paramInt4;
  }
  
  private View obtainView(int paramInt)
  {
    View localView1 = getRecycledView(paramInt);
    setTag(2131301994, Boolean.valueOf(true));
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
    setTag(2131301994, Boolean.valueOf(paramBoolean));
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
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label83;
      }
    }
    label83:
    for (i = 1;; i = 0)
    {
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      this.mMotionX = ((int)paramMotionEvent.getX(i));
      this.mMotionY = ((int)paramMotionEvent.getY(i));
      return;
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
        if (this.mRecycleListener != null) {
          this.mRecycleListener.a(localView);
        }
        recycleView(i, localView);
      }
      i += 1;
    }
  }
  
  private void recycleVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
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
    if (paramInt1 * i < 0) {}
    while (paramInt2 == 0) {
      return paramInt1;
    }
    return (paramInt2 - Math.abs(i)) * paramInt1 / paramInt2 / 2;
  }
  
  private void scrollIfNeeded(float paramFloat, int paramInt)
  {
    int k = this.mMaxX;
    int m = this.mMinX;
    int i = getOverScrollMode();
    int i2;
    int n;
    int i1;
    int j;
    if ((i == 0) || ((i == 1) && (k > 0)))
    {
      i = 1;
      i2 = getScrollX() + this.mNextX;
      n = this.mNextX;
      i1 = i2 + paramInt;
      if (i2 >= m)
      {
        j = paramInt;
        if (i2 <= k) {}
      }
      else
      {
        j = reviseOverScrollByTouch(paramInt, k);
      }
      if ((i == 0) || ((i1 >= m) && (i1 <= k))) {
        break label204;
      }
      if (i1 >= m) {
        break label190;
      }
      paramInt = i1 - getScrollX() - m;
      label118:
      i = getWidth();
      j = this.MIN_SPACE;
      overScrollBy(paramInt, 0, getScrollX(), 0, 0, 0, i - j, 0, true);
      label149:
      if (i1 >= m) {
        break label231;
      }
      this.mNextX = m;
    }
    for (;;)
    {
      if (n != this.mNextX)
      {
        unpressTouchedView();
        requestLayout();
      }
      this.mLastMotionX = paramFloat;
      return;
      i = 0;
      break;
      label190:
      paramInt = i1 - getScrollX() - k;
      break label118;
      label204:
      if (i2 != n) {
        scrollTo(0, 0);
      }
      this.mNextX += j;
      break label149;
      label231:
      if (i1 > k) {
        this.mNextX = k;
      }
    }
  }
  
  private void setItemViewLayoutParams(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = generateDefaultLayoutParams();
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams1);
      return;
      localLayoutParams1 = localLayoutParams2;
      if (!checkLayoutParams(localLayoutParams2)) {
        localLayoutParams1 = generateLayoutParams(localLayoutParams2);
      }
    }
  }
  
  private void unpressTouchedView()
  {
    if (this.mViewBeingTouched != null)
    {
      this.mViewBeingTouched.setPressed(false);
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
    if (this.mViewBeingTouched != null) {
      this.mViewBeingTouched.setPressed(true);
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
    if (!this.mStayDisplayOffsetZero) {}
    int i;
    do
    {
      View localView;
      do
      {
        return false;
        if (!this.isFromRightToLeft) {
          if (Math.abs(this.mCurrentX - this.mMaxX) < this.mTouchSlop) {
            i = 1;
          }
        }
        while (i != 0)
        {
          i = this.mMaxX;
          this.mCurrentX = i;
          this.mNextX = i;
          invalidate();
          return false;
          i = 0;
          continue;
          if (Math.abs(this.mCurrentX - this.mMinX) < this.mTouchSlop) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (this.mTouchSlop + this.mDisplayOffset >= 0)
        {
          this.mNextX += this.mDisplayOffset;
          invalidate();
          return false;
        }
        localView = getChildAt(0);
      } while (localView == null);
      i = this.mNextX;
      int j = this.mDisplayOffset + i;
      int k = localView.getMeasuredWidth();
      i = j;
      if (this.mDisplayOffset <= -(k / 2 + 0.5D)) {
        i = j + k;
      }
    } while (!this.mScroller.a(this.mNextX + getScrollX(), 0, i, i, 0, 0));
    if (DEBUG) {
      log("checkScrollToChild", new Object[] { Integer.valueOf(this.mTouchMode), Integer.valueOf(i) });
    }
    invalidate();
    return true;
  }
  
  public void computeScroll()
  {
    if (this.mScroller.b())
    {
      i = getScrollX();
      int k = this.mNextX + i;
      int m = this.mScroller.a();
      int n = this.mNextX;
      if (DEBUG) {
        log("computeScroll", new Object[] { "MOVING", Integer.valueOf(k), Integer.valueOf(m) });
      }
      int i1;
      int i3;
      int j;
      if (k != m)
      {
        i1 = this.mMaxX;
        int i2 = this.mMinX;
        i = getOverScrollMode();
        if ((i == 0) || ((i == 1) && (i1 > 0)))
        {
          i = 1;
          if ((i == 0) || ((m >= i2) && (m <= i1))) {
            break label316;
          }
          i3 = getWidth() - this.MIN_SPACE;
          j = 0;
          if ((m >= i2) || (m >= -i3) || (m >= k)) {
            break label255;
          }
          i = 1;
          label168:
          if (i == 0) {
            break label289;
          }
          this.mScroller.a();
          this.mScroller.a(getScrollX() + this.mNextX, getScrollY(), this.mNextX, this.mNextX, 0, 0);
          label210:
          if (m >= i2) {
            break label344;
          }
          this.mNextX = i2;
        }
      }
      for (;;)
      {
        if (n != this.mNextX)
        {
          unpressTouchedView();
          requestLayout();
        }
        awakenScrollBars();
        postInvalidate();
        return;
        i = 0;
        break;
        label255:
        i = j;
        if (i1 == 2147483647) {
          break label168;
        }
        i = j;
        if (m <= i1 + i3) {
          break label168;
        }
        i = j;
        if (m <= k) {
          break label168;
        }
        i = 1;
        break label168;
        label289:
        overScrollBy(m - k, 0, getScrollX(), getScrollY(), 0, 0, i3, 0, false);
        break label210;
        label316:
        if (k != n) {
          scrollTo(0, 0);
        }
        this.mNextX += m - k;
        break label210;
        label344:
        if (m > i1)
        {
          this.mNextX = i1;
          continue;
          if (Math.abs(getScrollX()) < this.mTouchSlop)
          {
            this.mNextX = k;
            scrollTo(0, 0);
          }
          else
          {
            checkSpringback();
          }
        }
      }
    }
    int i = getScrollX();
    if ((this.mCurrentScrollState == 4099) || ((this.mCurrentScrollState == 4097) && (this.mMaxX == this.mNextX) && (i != 0))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((DEBUG) && (QLog.isDevelopLevel())) {
        log("computeScroll", new Object[] { "over", Integer.valueOf(this.mCurrentScrollState), Boolean.valueOf(bool) });
      }
      if (!bool) {
        break;
      }
      this.mTouchMode = -1;
      if (Math.abs(i) >= this.mTouchSlop) {
        break label526;
      }
      scrollTo(0, 0);
      setCurrentScrollState(4097);
      return;
    }
    label526:
    checkSpringback();
  }
  
  ContextMenu.ContextMenuInfo createContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
  }
  
  protected boolean determineBorderMaxX()
  {
    View localView;
    int i;
    int j;
    if (this.isFromRightToLeft)
    {
      if (isLastItemInAdapter(this.mLeftViewAdapterIndex))
      {
        localView = getLeftmostChild();
        if (localView != null)
        {
          i = this.mMinX;
          j = this.mCurrentX;
          this.mMinX = (localView.getLeft() - getPaddingLeft() + j);
          if (this.mMinX > 0) {
            this.mMinX = -2147483648;
          }
          if (this.mMinX == i) {}
        }
      }
    }
    else {
      do
      {
        return true;
        if (!isLastItemInAdapter(this.mRightViewAdapterIndex)) {
          break;
        }
        localView = getRightmostChild();
        if (localView == null) {
          break;
        }
        i = this.mMaxX;
        j = this.mCurrentX;
        this.mMaxX = (localView.getRight() - getPaddingLeft() + j - getRenderWidth());
        if (this.mMaxX < 0) {
          this.mMaxX = 0;
        }
      } while (this.mMaxX != i);
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
    int k = 0;
    int j = 0;
    if (this.isFromRightToLeft)
    {
      localView = getLeftmostChild();
      boolean bool;
      if (localView != null)
      {
        i = localView.getLeft();
        bool = false;
      }
      for (;;)
      {
        fillListLeft(i, paramInt, bool);
        localView = getRightmostChild();
        i = j;
        if (localView != null) {
          i = localView.getRight();
        }
        fillListRight(i, paramInt);
        return;
        bool = true;
        i = 0;
      }
    }
    View localView = getRightmostChild();
    if (localView != null) {}
    for (int i = localView.getRight();; i = 0)
    {
      fillListRight(i, paramInt);
      localView = getLeftmostChild();
      i = k;
      if (localView != null) {
        i = localView.getLeft();
      }
      fillListLeft(i, paramInt);
      return;
    }
  }
  
  protected void fillListLeft(int paramInt1, int paramInt2)
  {
    while ((paramInt1 + paramInt2 - this.mDividerWidth > 0) && (this.mLeftViewAdapterIndex >= 1))
    {
      this.mLeftViewAdapterIndex -= 1;
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
        int i;
        label83:
        int j;
        if (this.mLeftViewAdapterIndex == 0)
        {
          i = localView.getMeasuredWidth();
          i = paramInt1 - i;
          j = this.mDisplayOffset;
          if (i + paramInt2 != 0) {
            break label167;
          }
        }
        label167:
        for (paramInt1 = localView.getMeasuredWidth();; paramInt1 = this.mDividerWidth + localView.getMeasuredWidth())
        {
          this.mDisplayOffset = (j - paramInt1);
          paramInt1 = i;
          if (!DEBUG) {
            break;
          }
          log("fillListLeft", new Object[] { "mLeftViewAdapterIndex", Integer.valueOf(this.mLeftViewAdapterIndex) });
          paramInt1 = i;
          break;
          i = this.mDividerWidth + localView.getMeasuredWidth();
          break label83;
        }
      }
    }
  }
  
  protected void fillListLeft(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (((paramBoolean) || (paramInt1 + paramInt2 - this.mDividerWidth > 0)) && (this.mLeftViewAdapterIndex + 1 < this.mAdapter.getCount()))
    {
      this.mLeftViewAdapterIndex += 1;
      if (this.mRightViewAdapterIndex < 0) {
        this.mRightViewAdapterIndex = this.mLeftViewAdapterIndex;
      }
      View localView = this.mAdapter.getView(this.mLeftViewAdapterIndex, getRecycledView(this.mLeftViewAdapterIndex), this);
      addAndMeasureChild(localView, -1);
      if (this.mLeftViewAdapterIndex == 0) {}
      for (int i = getWidth() - localView.getMeasuredWidth();; i = -(localView.getMeasuredWidth() + i))
      {
        paramInt1 += i;
        paramBoolean = false;
        break;
        i = this.mDividerWidth;
      }
    }
  }
  
  protected void fillListRight(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    View localView;
    if (this.isFromRightToLeft)
    {
      if ((paramInt1 + paramInt2 + this.mDividerWidth < getWidth()) && (this.mRightViewAdapterIndex >= 1))
      {
        this.mRightViewAdapterIndex -= 1;
        localView = this.mAdapter.getView(this.mRightViewAdapterIndex, getRecycledView(this.mRightViewAdapterIndex), this);
        addAndMeasureChild(localView, 0);
        label82:
        int j;
        if (this.mRightViewAdapterIndex == 0)
        {
          i = 0;
          i = paramInt1 + (i + localView.getMeasuredWidth());
          j = this.mDisplayOffset;
          if (getWidth() - (i + paramInt2) != 0) {
            break label136;
          }
        }
        label136:
        for (paramInt1 = localView.getMeasuredWidth();; paramInt1 = this.mDividerWidth + localView.getMeasuredWidth())
        {
          this.mDisplayOffset = (j - paramInt1);
          paramInt1 = i;
          break;
          i = this.mDividerWidth;
          break label82;
        }
      }
    }
    else {
      while ((i + paramInt2 + this.mDividerWidth < getWidth()) && (this.mRightViewAdapterIndex + 1 < this.mAdapter.getCount()))
      {
        this.mRightViewAdapterIndex += 1;
        if (this.mLeftViewAdapterIndex < 0) {
          this.mLeftViewAdapterIndex = this.mRightViewAdapterIndex;
        }
        localView = obtainView(this.mRightViewAdapterIndex, false);
        if (localView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HorizontalListView", 2, "fillListRight obtainView is null");
          }
        }
        else
        {
          addAndMeasureChild(localView, -1);
          if (this.mRightViewAdapterIndex == 0) {}
          for (paramInt1 = 0;; paramInt1 = this.mDividerWidth)
          {
            paramInt1 = i + (paramInt1 + localView.getMeasuredWidth());
            determineIfLowOnData();
            i = paramInt1;
            if (!DEBUG) {
              break;
            }
            log("fillListRight", new Object[] { "mRightViewAdapterIndex", Integer.valueOf(this.mRightViewAdapterIndex) });
            i = paramInt1;
            break;
          }
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
          return i + getFirstVisiblePosition();
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
      this.mScroller.a(this.mNextX + getScrollX(), 0, getFlingVelocity(paramInt), 0, this.mMinX, this.mMaxX, 0, 0, Math.max(0, getWidth() / 2), 0);
      requestLayout();
    }
  }
  
  public ListAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public View getChild(int paramInt)
  {
    if ((paramInt >= this.mLeftViewAdapterIndex) && (paramInt <= this.mRightViewAdapterIndex)) {
      return getChildAt(paramInt - this.mLeftViewAdapterIndex);
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
    if (this.isFromRightToLeft) {
      return getChildAt(getChildCount() - 1);
    }
    return getChildAt(0);
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
    int i = -1;
    try
    {
      paramInt = this.mAdapter.getItemViewType(paramInt);
      if (isItemViewTypeValid(paramInt)) {
        return (View)((Queue)this.mRemovedViewsCache.get(paramInt)).poll();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        paramInt = i;
      }
    }
    return null;
  }
  
  protected View getRightmostChild()
  {
    if (this.isFromRightToLeft) {
      return getChildAt(0);
    }
    return getChildAt(getChildCount() - 1);
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
    this.mScroller = new belr(getContext());
    this.mScroller.a(getScrollerFriction());
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
    this.mAdapterDataObserver = new beka(this);
  }
  
  protected boolean isLastItemInAdapter(int paramInt)
  {
    return paramInt == this.mAdapter.getCount() - 1;
  }
  
  public void log(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    if ((DEBUG) && (QLog.isDevelopLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.setLength(0);
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mDisplayOffset = ").append(this.mDisplayOffset);
      localStringBuilder.append(", mMaxX = ").append(this.mMaxX);
      localStringBuilder.append(", mMinX = ").append(this.mMinX);
      localStringBuilder.append(", mCurrentX = ").append(this.mCurrentX);
      localStringBuilder.append(", mNextX = ").append(this.mNextX);
      localStringBuilder.append(", mScrollX = ").append(getScrollX());
      localStringBuilder.append(", mLeftViewAdapterIndex= ").append(this.mLeftViewAdapterIndex);
      localStringBuilder.append(", mRightViewAdapterIndex = ").append(this.mRightViewAdapterIndex);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int j = paramVarArgs.length;
        while (i < j)
        {
          paramString = paramVarArgs[i];
          localStringBuilder.append(",").append(paramString);
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
      if (this.mAdapter != null) {
        break label63;
      }
    }
    label63:
    for (int i = 0;; i = this.mAdapter.getCount())
    {
      if (getLastVisiblePosition() < i - 1) {
        paramAccessibilityNodeInfo.addAction(4096);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingDragged)) {
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool1;
      if (!this.mIsBeingDragged)
      {
        bool1 = bool2;
        if (!super.onInterceptTouchEvent(paramMotionEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      i = this.mActivePointerId;
      if (i != -1)
      {
        float f = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(i));
        if ((int)Math.abs(f - this.mLastMotionX) > this.mTouchSlop)
        {
          this.mIsBeingDragged = true;
          this.mLastMotionX = f;
          initVelocityTrackerIfNotExists();
          this.mVelocityTracker.addMovement(paramMotionEvent);
          ViewParent localViewParent = getParent();
          if (localViewParent != null)
          {
            localViewParent.requestDisallowInterceptTouchEvent(true);
            continue;
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
              if (!this.mScroller.a()) {}
              for (bool1 = true;; bool1 = false)
              {
                this.mIsBeingDragged = bool1;
                setCurrentScrollState(4097);
                break;
              }
              this.mIsBeingDragged = false;
              this.mActivePointerId = -1;
              recycleVelocityTracker();
              if (this.mScroller.a(getScrollX() + this.mNextX, getScrollY(), this.mNextX, this.mNextX, 0, 0))
              {
                this.mTouchMode = 6;
                setCurrentScrollState(4099);
                invalidate();
              }
              for (;;)
              {
                unpressTouchedView();
                break;
                this.mTouchMode = -1;
                setCurrentScrollState(4097);
              }
              onSecondaryPointerUp(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mAdapter == null) {}
    do
    {
      return;
      invalidate();
      int i;
      if (this.mDataChanged)
      {
        recycleBeforeRemoveAll();
        i = this.mCurrentX;
        initView(this.isFromRightToLeft);
        removeAllViewsInLayout();
        this.mNextX = i;
        this.mDataChanged = false;
        if (this.mPositionScrollAfterLayout != null)
        {
          post(this.mPositionScrollAfterLayout);
          this.mPositionScrollAfterLayout = null;
        }
      }
      if (this.mRestoreX != null)
      {
        this.mNextX = this.mRestoreX.intValue();
        this.mRestoreX = null;
      }
      if (this.mNextX < this.mMinX) {
        this.mNextX = this.mMinX;
      }
      for (;;)
      {
        reMeasureChilds();
        i = this.mCurrentX - this.mNextX;
        removeNonVisibleChildren(i);
        fillList(i);
        positionChildren(i);
        this.mCurrentX = this.mNextX;
        if (this.mOnScrollLinstener != null) {
          this.mOnScrollLinstener.a();
        }
        if (!determineBorderMaxX()) {
          break;
        }
        onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
        if (this.mNextX > this.mMaxX) {
          this.mNextX = this.mMaxX;
        }
      }
      View localView = getRightmostChild();
      if ((localView != null) && (localView.getRight() + this.mDividerWidth < getRenderWidth()) && (this.mRightViewAdapterIndex < this.mAdapter.getCount() - 1))
      {
        onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    } while (this.mScroller.a());
    ViewCompat.postOnAnimation(this, this.mDelayedLayout);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i;
    if (this.mAdapter == null)
    {
      i = 0;
      if ((i <= 0) || ((n != 0) && (n != -2147483648) && (m != 0))) {
        break label243;
      }
      View localView = obtainView(0);
      if (localView == null) {
        break label228;
      }
      measureChild(localView, paramInt1, paramInt2);
      paramInt1 = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
      recycleView(0, localView);
      label100:
      if ((n != 0) && (n != -2147483648)) {
        break label250;
      }
      paramInt2 = getPaddingTop() + getPaddingBottom() + i + getVerticalFadingEdgeLength() * 2;
      this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, n);
      label142:
      if (m != 0) {
        break label261;
      }
      paramInt1 = getPaddingLeft() + getPaddingRight() + paramInt1 + getVerticalScrollbarWidth();
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      if (((this.mWidth != 0) && (this.mWidth != paramInt1)) || ((this.mHeight != 0) && (this.mHeight != paramInt2))) {
        onSizeChange();
      }
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      return;
      i = this.mAdapter.getCount();
      break;
      label228:
      if (QLog.isColorLevel()) {
        QLog.i("HorizontalListView", 2, "onMeasure obtainView is null");
      }
      label243:
      i = 0;
      paramInt1 = 0;
      break label100;
      label250:
      this.mHeightMeasureSpec = paramInt2;
      paramInt2 = k;
      break label142;
      label261:
      paramInt1 = j;
      if (m == -2147483648) {
        paramInt1 = measureWidthOfChildren(0, -1, j, -1);
      }
    }
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
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    label107:
    int i;
    label403:
    label434:
    label753:
    label1270:
    label1277:
    do
    {
      do
      {
        Object localObject;
        int j;
        do
        {
          do
          {
            return true;
            if (getChildCount() == 0) {
              return false;
            }
            if (this.mTouchMode == 6)
            {
              this.mTouchMode = 5;
              this.mMotionX = ((int)paramMotionEvent.getX());
              this.mMotionY = ((int)paramMotionEvent.getY());
              if (this.mScroller.a()) {
                break label434;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              this.mIsBeingDragged = bool;
              if (bool)
              {
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
              if (!this.mScroller.a()) {
                this.mScroller.a();
              }
              this.mLastMotionX = paramMotionEvent.getX();
              this.mActivePointerId = paramMotionEvent.getPointerId(0);
              setCurrentScrollState(4097);
              if (!DEBUG) {
                break;
              }
              log("onTouchEvent", new Object[] { "DOWN", Boolean.valueOf(this.mIsBeingDragged) });
              return true;
              if (needTtransTouchStateToParen())
              {
                this.mTouchMode = 0;
                if (this.mPendingCheckForTap == null) {
                  this.mPendingCheckForTap = new HorizontalListView.CheckForTap(this);
                }
                postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                this.mMotionPosition = getFirstVisiblePosition();
                this.mMotionX = ((int)paramMotionEvent.getX());
                this.mMotionY = ((int)paramMotionEvent.getY());
                break label107;
              }
              j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
              i = j;
              if (!this.mDataChanged)
              {
                if ((this.mTouchMode == 4) || (j < 0) || (!getAdapter().isEnabled(j))) {
                  break label403;
                }
                this.mTouchMode = 0;
                if (this.mPendingCheckForTap == null) {
                  this.mPendingCheckForTap = new HorizontalListView.CheckForTap(this);
                }
                postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                i = j;
              }
              for (;;)
              {
                this.mMotionPosition = i;
                break;
                i = j;
                if (this.mTouchMode == 4)
                {
                  this.mTouchMode = 3;
                  i = findMotionColumn((int)paramMotionEvent.getX());
                }
              }
            }
            i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          } while (i == -1);
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
              if (j <= 0) {
                break;
              }
              i = j - this.mTouchSlop;
            }
          }
        } while (!this.mIsBeingDragged);
        switch (this.mTouchMode)
        {
        }
        for (;;)
        {
          setCurrentScrollState(4098);
          scrollIfNeeded(f1, i);
          return true;
          i = j + this.mTouchSlop;
          break;
          paramMotionEvent = getHandler();
          if (paramMotionEvent != null) {
            paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
          }
          if (this.mTouchModeReset != null) {
            removeCallbacks(this.mTouchModeReset);
          }
          unpressTouchedView();
          if (getScrollX() != 0)
          {
            this.mTouchMode = 5;
          }
          else
          {
            this.mTouchMode = 3;
            continue;
            if (getScrollX() != 0) {
              this.mTouchMode = 5;
            } else {
              this.mTouchMode = 3;
            }
          }
        }
        if ((this.mIsBeingDragged) || (Math.abs(getScrollX()) > this.mTouchSlop))
        {
          localObject = this.mVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
          if (Build.VERSION.SDK_INT >= 8)
          {
            f1 = ((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
            i = (int)f1;
            if (getChildCount() <= 0) {
              break label969;
            }
            if (Math.abs(i) <= this.mMinimumVelocity) {
              break label906;
            }
            fling(-i);
            this.mActivePointerId = -1;
            endDrag();
          }
        }
        else
        {
          switch (this.mTouchMode)
          {
          }
        }
        for (;;)
        {
          setPressed(false);
          invalidate();
          paramMotionEvent = getHandler();
          if (paramMotionEvent != null) {
            paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
          }
          if (!DEBUG) {
            break;
          }
          log("onTouchEvent", new Object[] { "UP", Integer.valueOf(this.mTouchMode) });
          return true;
          f1 = ((VelocityTracker)localObject).getXVelocity();
          break label753;
          if (this.mScroller.a(getScrollX() + this.mNextX, getScrollY(), this.mNextX, this.mNextX, 0, 0))
          {
            this.mTouchMode = 6;
            setCurrentScrollState(4099);
            invalidate();
            break label783;
          }
          setCurrentScrollState(4097);
          break label783;
          setCurrentScrollState(4097);
          break label783;
          j = this.mMotionPosition;
          localObject = getChildAt(j - getFirstVisiblePosition());
          f1 = paramMotionEvent.getX();
          HorizontalListView.PerformClick localPerformClick;
          if ((f1 > getPaddingLeft()) && (f1 < getWidth() - getPaddingRight()))
          {
            i = 1;
            if (this.mPerformClick == null) {
              this.mPerformClick = new HorizontalListView.PerformClick(this, null);
            }
            localPerformClick = this.mPerformClick;
            localPerformClick.a = j;
            localPerformClick.a();
            if ((localObject == null) || (((View)localObject).hasFocusable()) || (i == 0)) {
              break label1311;
            }
            if (this.mTouchMode != 0)
            {
              unpressTouchedView();
              if (this.mTouchModeReset != null) {
                removeCallbacks(this.mTouchModeReset);
              }
            }
            if ((this.mTouchMode != 0) && (this.mTouchMode != 1)) {
              break label1277;
            }
            Handler localHandler = getHandler();
            if (localHandler != null)
            {
              if (this.mTouchMode != 0) {
                break label1253;
              }
              paramMotionEvent = this.mPendingCheckForTap;
              localHandler.removeCallbacks(paramMotionEvent);
            }
            if ((this.mDataChanged) || (!this.mAdapter.isEnabled(j))) {
              break label1270;
            }
            this.mTouchMode = 1;
            if (!needTtransTouchStateToParen()) {
              break label1261;
            }
            updateTouchedView((View)getParent());
          }
          for (;;)
          {
            if (this.mTouchModeReset != null) {
              removeCallbacks(this.mTouchModeReset);
            }
            this.mTouchModeReset = new HorizontalListView.2(this, localPerformClick);
            postDelayed(this.mTouchModeReset, ViewConfiguration.getPressedStateDuration());
            return true;
            i = 0;
            break;
            paramMotionEvent = this.mPendingCheckForLongPress;
            break label1152;
            updateTouchedView((View)localObject);
          }
          this.mTouchMode = -1;
          return true;
          if ((!this.mDataChanged) && (this.mAdapter.isEnabled(j))) {
            localPerformClick.run();
          }
          for (;;)
          {
            this.mTouchMode = -1;
            break;
            localPerformClick.run();
          }
          this.mTouchMode = -1;
          continue;
          this.mTouchMode = -1;
        }
        unpressTouchedView();
        if ((this.mIsBeingDragged) && (getChildCount() > 0))
        {
          if (!this.mScroller.a(getScrollX() + this.mNextX, getScrollY(), this.mNextX, this.mNextX, 0, 0)) {
            break label1501;
          }
          this.mTouchMode = 6;
          setCurrentScrollState(4099);
          invalidate();
        }
        for (;;)
        {
          this.mActivePointerId = -1;
          endDrag();
          switch (this.mTouchMode)
          {
          default: 
            this.mTouchMode = -1;
            unpressTouchedView();
            paramMotionEvent = getHandler();
            if (paramMotionEvent != null) {
              paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
            }
            break;
          }
          if (!DEBUG) {
            break;
          }
          log("onTouchEvent", new Object[] { "CANCEL", Integer.valueOf(this.mTouchMode) });
          return true;
          setCurrentScrollState(4097);
        }
        i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.mLastMotionX = f1;
        this.mActivePointerId = paramMotionEvent.getPointerId(i);
        this.mMotionX = ((int)f1);
        this.mMotionY = ((int)f2);
        i = pointToPosition((int)f1, (int)f2);
      } while (i < 0);
      this.mMotionPosition = i;
      return true;
      onSecondaryPointerUp(paramMotionEvent);
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if ((i < paramMotionEvent.getPointerCount()) && (-1 != i)) {
        this.mLastMotionX = paramMotionEvent.getX(i);
      }
      i = pointToPosition(this.mMotionX, this.mMotionY);
    } while (i < 0);
    label783:
    label969:
    label1253:
    label1261:
    this.mMotionPosition = i;
    label906:
    label1311:
    label1501:
    return true;
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int k = getOverScrollMode();
    int i;
    int j;
    if (computeHorizontalScrollRange() > computeHorizontalScrollExtent())
    {
      i = 1;
      if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) {
        break label176;
      }
      j = 1;
      label34:
      if ((k != 0) && ((k != 1) || (i == 0))) {
        break label182;
      }
      i = 1;
      label53:
      if ((k != 0) && ((k != 1) || (j == 0))) {
        break label188;
      }
      j = 1;
      label72:
      paramInt3 += paramInt1;
      if (i == 0) {
        paramInt7 = 0;
      }
      paramInt4 += paramInt2;
      if (j == 0) {
        paramInt8 = 0;
      }
      i = -paramInt7;
      if (paramInt7 != 2147483647) {
        break label194;
      }
      paramInt1 = 2147483647;
      label113:
      paramInt5 = -paramInt8;
      if (paramInt8 != 2147483647) {
        break label203;
      }
      paramInt2 = 2147483647;
      label128:
      if (paramInt3 <= paramInt1) {
        break label212;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      label136:
      boolean bool = false;
      if (paramInt4 > paramInt2) {
        bool = true;
      }
      for (;;)
      {
        onOverScrolled(paramInt1, paramInt2, paramBoolean, bool);
        if ((paramBoolean) || (bool))
        {
          return true;
          i = 0;
          break;
          label176:
          j = 0;
          break label34;
          label182:
          i = 0;
          break label53;
          label188:
          j = 0;
          break label72;
          label194:
          paramInt1 = paramInt7 + paramInt5;
          break label113;
          label203:
          paramInt2 = paramInt8 + paramInt6;
          break label128;
          label212:
          if (paramInt3 >= i) {
            break label251;
          }
          paramBoolean = true;
          paramInt1 = i;
          break label136;
          if (paramInt4 >= paramInt5) {
            break label245;
          }
          bool = true;
          paramInt2 = paramInt5;
          continue;
        }
        return false;
        label245:
        paramInt2 = paramInt4;
      }
      label251:
      paramBoolean = false;
      paramInt1 = paramInt3;
    }
  }
  
  @TargetApi(16)
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    if (this.mAdapter == null) {}
    for (int i = 0;; i = this.mAdapter.getCount()) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    int j;
    if ((isEnabled()) && (getLastVisiblePosition() < i - 1))
    {
      paramInt = getWidth();
      i = getPaddingLeft();
      j = getPaddingRight();
      scrollIfNeeded(this.mLastMotionX, paramInt - i - j);
      return true;
    }
    return false;
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
  
  boolean performLongPress(View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemLongClickListener localOnItemLongClickListener = getOnItemLongClickListener();
    if (localOnItemLongClickListener != null) {}
    for (boolean bool1 = localOnItemLongClickListener.onItemLongClick(this, paramView, paramInt, paramLong);; bool1 = false)
    {
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
    int k = 0;
    int j = 0;
    int m = getChildCount();
    if (m > 0)
    {
      if (DEBUG) {
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
    try
    {
      Object localObject = paramView.getTag(2131624591);
      if ((localObject instanceof Integer))
      {
        i = ((Integer)localObject).intValue();
        j = i;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          if (!isItemViewTypeValid(i)) {
            j = this.mAdapter.getItemViewType(paramInt);
          }
          if (isItemViewTypeValid(j))
          {
            ((Queue)this.mRemovedViewsCache.get(j)).offer(paramView);
            if (this.mRecycleListener != null) {
              this.mRecycleListener.b(paramView);
            }
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          int j;
          continue;
        }
        localThrowable1 = localThrowable1;
        int i = -1;
        localThrowable1.printStackTrace();
        j = i;
        continue;
        i = -1;
      }
    }
  }
  
  protected void removeNonVisibleChildren(int paramInt)
  {
    int j;
    int i;
    if (this.isFromRightToLeft)
    {
      localView = getRightmostChild();
      if ((localView != null) && (localView.getLeft() + paramInt >= getWidth()))
      {
        j = this.mDisplayOffset;
        if (isLastItemInAdapter(this.mRightViewAdapterIndex)) {}
        for (i = localView.getMeasuredWidth();; i = this.mDividerWidth + localView.getMeasuredWidth())
        {
          this.mDisplayOffset = (i + j);
          recycleView(this.mRightViewAdapterIndex, localView);
          removeViewInLayout(localView);
          this.mRightViewAdapterIndex += 1;
          localView = getRightmostChild();
          break;
        }
      }
      for (localView = getLeftmostChild(); (localView != null) && (localView.getRight() + paramInt <= 0); localView = getLeftmostChild())
      {
        recycleView(this.mLeftViewAdapterIndex, localView);
        removeViewInLayout(localView);
        this.mLeftViewAdapterIndex -= 1;
      }
    }
    View localView = getLeftmostChild();
    if ((localView != null) && (localView.getRight() + paramInt <= 0))
    {
      j = this.mDisplayOffset;
      if (isLastItemInAdapter(this.mLeftViewAdapterIndex)) {}
      for (i = localView.getMeasuredWidth();; i = this.mDividerWidth + localView.getMeasuredWidth())
      {
        this.mDisplayOffset = (i + j);
        recycleView(this.mLeftViewAdapterIndex, localView);
        removeViewInLayout(localView);
        if (this.mOnItemScrollEventListener != null) {
          this.mOnItemScrollEventListener.a(this.mLeftViewAdapterIndex, true);
        }
        this.mLeftViewAdapterIndex += 1;
        localView = getLeftmostChild();
        break;
      }
    }
    for (localView = getRightmostChild(); (localView != null) && (localView.getLeft() + paramInt >= getWidth()); localView = getRightmostChild())
    {
      recycleView(this.mRightViewAdapterIndex, localView);
      removeViewInLayout(localView);
      if (this.mOnItemScrollEventListener != null) {
        this.mOnItemScrollEventListener.a(this.mRightViewAdapterIndex, false);
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
  
  public void reset(boolean paramBoolean)
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
    int i = this.mNextX + paramInt;
    if (i < 0) {
      return -1;
    }
    if (i > this.mMaxX) {
      return 1;
    }
    this.mScroller.a(this.mNextX, 0, paramInt, 0, 20);
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
    if (this.mAdapter != null) {}
    try
    {
      this.mAdapter.unregisterDataSetObserver(this.mAdapterDataObserver);
      if (paramListAdapter != null)
      {
        this.mHasNotifiedRunningLowOnData = false;
        this.mAdapter = paramListAdapter;
        this.mAdapter.registerDataSetObserver(this.mAdapterDataObserver);
      }
      if (this.mAdapter != null) {
        initializeRecycledViewCache(this.mAdapter.getViewTypeCount());
      }
      reset(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void setCurrentScrollState(int paramInt)
  {
    int i = paramInt;
    if (this.mStayDisplayOffsetZero)
    {
      i = paramInt;
      if (this.mCurrentScrollState != paramInt)
      {
        i = paramInt;
        if (paramInt == 4097) {
          switch (this.mCurrentScrollState)
          {
          default: 
            i = paramInt;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.mCurrentScrollState != i) && (this.mOnScrollStateChangedListener != null)) {
        this.mOnScrollStateChangedListener.onScrollStateChanged(i);
      }
      this.mCurrentScrollState = i;
      return;
      i = paramInt;
      if (checkScrollToChild())
      {
        paramInt = 4099;
        i = paramInt;
        if (DEBUG)
        {
          log("setCurrentScrollState", new Object[] { "SCROLL_STATE_TOUCH_SCROLL" });
          i = paramInt;
          continue;
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
    }
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
  
  public void setOnItemScollEventListener(bekb parambekb)
  {
    this.mOnItemScrollEventListener = parambekb;
  }
  
  public void setOnScrollListener(bekc parambekc)
  {
    this.mOnScrollLinstener = parambekc;
  }
  
  public void setOnScrollStateChangedListener(bekd parambekd)
  {
    this.mOnScrollStateChangedListener = parambekd;
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(paramInt);
    }
  }
  
  public void setRecycleListener(beke parambeke)
  {
    this.mRecycleListener = parambeke;
  }
  
  public void setRestoreX(int paramInt)
  {
    this.mRestoreX = Integer.valueOf(paramInt);
  }
  
  public void setRunningOutOfDataListener(bekf parambekf, int paramInt)
  {
    this.mRunningOutOfDataListener = parambekf;
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
    if (this.mScroller.a())
    {
      i = getScrollX();
      i = this.mNextX + i;
    }
    this.mScroller.a(i, 0, -paramInt1, 0, paramInt2);
    this.mLastMotionX = 0.0F;
    recycleVelocityTracker();
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new HorizontalListView.PositionScroller(this);
    }
    this.mPositionScroller.a(paramInt);
  }
  
  public void smoothScrollToPosition(int paramInt1, int paramInt2)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new HorizontalListView.PositionScroller(this);
    }
    this.mPositionScroller.a(paramInt1, paramInt2);
  }
  
  public void smoothScrollToPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new HorizontalListView.PositionScroller(this);
    }
    this.mPositionScroller.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void smoothScrollToPositionFromLeftOrRight(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new HorizontalListView.PositionScroller(this);
    }
    this.mPositionScroller.b(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */