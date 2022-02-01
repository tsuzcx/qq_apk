package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Transformation;
import android.widget.Scroller;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqq.qqui.R.styleable;

public class VerticalGallery
  extends VerticalAbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  public static final int HORIZONTAL = 1;
  private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
  private static final String TAG = "Gallery";
  public static final int VERTICAL = 2;
  private int mAnimationDuration = 400;
  private AdapterView.AdapterContextMenuInfo mContextMenuInfo;
  private Runnable mDisableSuppressSelectionChangedRunnable = new VerticalGallery.1(this);
  private int mDownTouchPosition;
  private View mDownTouchView;
  private int mFirstChildOffset = 0;
  private VerticalGallery.FlingRunnable mFlingRunnable = new VerticalGallery.FlingRunnable(this);
  private GestureDetector mGestureDetector = new GestureDetector(paramContext, this);
  private int mGravity;
  private boolean mIsDisableScroll = false;
  private boolean mIsFirstScroll;
  private boolean mIsScrollCycle = false;
  private boolean mIsScrollCycleTemp = true;
  private boolean mIsSlotCenter = false;
  private int mLeftMost;
  private VerticalGallery.OnEndFlingListener mOnEndFlingListener = null;
  private VerticalGallery.OnEndMovementListener mOnEndMovementListener = null;
  private VerticalGallery.OnSelectViewDataUpdateListener mOnSelectViewDataUpdateListener = null;
  private int mOrientation = 1;
  private boolean mReceivedInvokeKeyDown;
  private int mRightMost;
  private int mScrollBarBottomMargin = 0;
  private int mScrollBarSize = 5;
  private boolean mScrolling = false;
  private View mSelectedChild;
  private boolean mShouldCallbackDuringFling = true;
  private boolean mShouldCallbackOnUnselectedItemClick = true;
  private boolean mShouldStopFling;
  private int mSpacing = 0;
  private boolean mSuppressSelectionChanged;
  private float mUnselectedAlpha;
  private float mVelocityRatio = 1.0F;
  
  public VerticalGallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131036373);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mGestureDetector.setIsLongpressEnabled(true);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fh, paramInt, 0);
    paramInt = paramAttributeSet.getInt(R.styleable.fi, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    paramInt = paramAttributeSet.getInt(R.styleable.fj, -1);
    if (paramInt > 0) {
      setAnimationDuration(paramInt);
    }
    setSpacing(paramAttributeSet.getDimensionPixelOffset(R.styleable.fk, 0));
    setUnselectedAlpha(paramAttributeSet.getFloat(R.styleable.fl, 0.5F));
    paramAttributeSet.recycle();
    setChildrenDrawingOrderEnabled(true);
    setStaticTransformationsEnabled(true);
    this.mScrollBarSize = ViewConfiguration.get(paramContext).getScaledScrollBarSize();
    if (isOrientationVertical())
    {
      this.mGravity = 1;
      return;
    }
    this.mGravity = 16;
  }
  
  private int calculateLeft(View paramView, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = getMeasuredWidth();
    } else {
      i = getWidth();
    }
    int j;
    if (paramBoolean) {
      j = paramView.getMeasuredWidth();
    } else {
      j = paramView.getWidth();
    }
    int k = this.mGravity;
    if (k != 1)
    {
      if (k != 3)
      {
        if (k != 5) {
          return 0;
        }
        return i - this.mSpinnerPadding.right - j;
      }
      return this.mSpinnerPadding.left;
    }
    k = this.mSpinnerPadding.right;
    int m = this.mSpinnerPadding.left;
    return this.mSpinnerPadding.left + (i - k - m - j) / 2;
  }
  
  private int calculateTop(View paramView, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = getMeasuredHeight();
    } else {
      i = getHeight();
    }
    int j;
    if (paramBoolean) {
      j = paramView.getMeasuredHeight();
    } else {
      j = paramView.getHeight();
    }
    int k = this.mGravity;
    if (k != 16)
    {
      if (k != 48)
      {
        if (k != 80) {
          return 0;
        }
        return i - this.mSpinnerPadding.bottom - j;
      }
      return this.mSpinnerPadding.top;
    }
    k = this.mSpinnerPadding.bottom;
    int m = this.mSpinnerPadding.top;
    return this.mSpinnerPadding.top + (i - k - m - j) / 2;
  }
  
  private void detachOffScreenChildren(boolean paramBoolean)
  {
    int i1 = getChildCount();
    int n = this.mFirstPosition;
    int m = 0;
    int k;
    int j;
    int i;
    View localView;
    if (paramBoolean)
    {
      k = getPaddingLeft();
      j = 0;
      i = 0;
      while (j < i1)
      {
        localView = getChildAt(j);
        if (localView.getRight() >= k) {
          break;
        }
        i += 1;
        this.mRecycler.put(n + j, localView);
        j += 1;
      }
      j = m;
      k = i;
      if (i == i1)
      {
        k = i - 1;
        j = m;
      }
    }
    else
    {
      int i2 = getWidth();
      int i3 = getPaddingRight();
      k = i1 - 1;
      j = 0;
      i = 0;
      while (k >= 0)
      {
        localView = getChildAt(k);
        if (localView.getLeft() <= i2 - i3) {
          break;
        }
        i += 1;
        this.mRecycler.put(n + k, localView);
        m = k - 1;
        j = k;
        k = m;
      }
      if (j == 0)
      {
        j += 1;
        k = i;
      }
      else
      {
        k = i;
      }
    }
    detachViewsFromParent(j, k);
    if (paramBoolean)
    {
      this.mFirstPosition += k;
      if (isScrollCycle()) {
        this.mFirstPosition %= this.mItemCount;
      }
    }
  }
  
  private void detachOffScreenChildrenVertical(boolean paramBoolean)
  {
    int i1 = getChildCount();
    int n = this.mFirstPosition;
    int m = 0;
    int k;
    int j;
    int i;
    View localView;
    if (paramBoolean)
    {
      k = getPaddingTop();
      j = 0;
      i = 0;
      while (j < i1)
      {
        localView = getChildAt(j);
        if (localView.getBottom() >= k) {
          break;
        }
        i += 1;
        this.mRecycler.put(n + j, localView);
        j += 1;
      }
      j = m;
      k = i;
      if (i == i1)
      {
        k = i - 1;
        j = m;
      }
    }
    else
    {
      int i2 = getHeight();
      int i3 = getPaddingBottom();
      k = i1 - 1;
      j = 0;
      i = 0;
      while (k >= 0)
      {
        localView = getChildAt(k);
        if (localView.getTop() <= i2 - i3) {
          break;
        }
        i += 1;
        this.mRecycler.put(n + k, localView);
        m = k - 1;
        j = k;
        k = m;
      }
      if (j == 0)
      {
        j += 1;
        k = i;
      }
      else
      {
        k = i;
      }
    }
    detachViewsFromParent(j, k);
    if (paramBoolean)
    {
      this.mFirstPosition += k;
      if (isScrollCycle()) {
        this.mFirstPosition %= this.mItemCount;
      }
    }
  }
  
  private boolean dispatchLongPress(View paramView, int paramInt, long paramLong)
  {
    boolean bool1;
    if (this.mOnItemLongClickListener != null) {
      bool1 = this.mOnItemLongClickListener.onItemLongClick(this, this.mDownTouchView, this.mDownTouchPosition, paramLong);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      this.mContextMenuInfo = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
      bool2 = super.showContextMenuForChild(this);
    }
    if (bool2) {
      performHapticFeedback(0);
    }
    return bool2;
  }
  
  private void dispatchPress(View paramView)
  {
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  private void fillToGalleryBottom()
  {
    if (isScrollCycle())
    {
      fillToGalleryBottomCycle();
      return;
    }
    int k = this.mSpacing;
    int m = getBottom();
    int n = getTop();
    int i1 = getPaddingRight();
    int i = getChildCount();
    int i2 = this.mItemCount;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.mFirstPosition + i;
      i = localView.getBottom() + k;
    }
    else
    {
      j = this.mItemCount - 1;
      this.mFirstPosition = j;
      i = getPaddingTop();
      this.mShouldStopFling = true;
    }
    while ((i < m - n - i1) && (j < i2))
    {
      i = makeAndAddViewVertical(j, j - this.mSelectedPosition, i, true).getBottom() + k;
      j += 1;
    }
  }
  
  private void fillToGalleryBottomCycle()
  {
    int k = this.mSpacing;
    int m = getBottom() - getTop() - getPaddingBottom();
    int i = getChildCount();
    int n = this.mItemCount;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.mFirstPosition + i;
      i = localView.getBottom() + k;
    }
    else
    {
      j = this.mItemCount - 1;
      this.mFirstPosition = j;
      i = getPaddingTop();
      this.mShouldStopFling = true;
    }
    while ((i < m) && (j < n))
    {
      i = makeAndAddViewVertical(j, j - this.mSelectedPosition, i, true).getBottom() + k;
      j += 1;
    }
    j %= n;
    while ((i <= m) && (getChildCount() < this.mItemCount))
    {
      i = makeAndAddViewVertical(j, j - this.mSelectedPosition, i, true).getBottom() + k;
      j += 1;
    }
  }
  
  private void fillToGalleryLeft()
  {
    if (isScrollCycle())
    {
      fillToGalleryLeftCycle();
      return;
    }
    int k = this.mSpacing;
    int m = getPaddingLeft();
    View localView = getChildAt(0);
    int j;
    int i;
    if (localView != null)
    {
      j = this.mFirstPosition - 1;
      i = localView.getLeft() - k;
    }
    else
    {
      i = getRight() - getLeft() - getPaddingRight();
      this.mShouldStopFling = true;
      j = 0;
    }
    while ((i > m) && (j >= 0))
    {
      localView = makeAndAddView(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getLeft() - k;
      j -= 1;
    }
  }
  
  private void fillToGalleryLeftCycle()
  {
    int k = this.mSpacing;
    int m = getPaddingLeft();
    View localView = getChildAt(0);
    int i;
    if (localView != null)
    {
      j = this.mFirstPosition - 1;
      i = localView.getLeft() - k;
    }
    else
    {
      i = getRight() - getLeft() - getPaddingRight();
      this.mShouldStopFling = true;
      j = 0;
    }
    while ((i > m) && (j >= 0))
    {
      localView = makeAndAddView(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getLeft() - k;
      j -= 1;
    }
    int j = this.mItemCount - 1;
    while ((i > m) && (getChildCount() < this.mItemCount))
    {
      localView = makeAndAddView(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getLeft() - k;
      j -= 1;
    }
  }
  
  private void fillToGalleryRight()
  {
    if (isScrollCycle())
    {
      fillToGalleryRightCycle();
      return;
    }
    int k = this.mSpacing;
    int m = getRight();
    int n = getLeft();
    int i1 = getPaddingRight();
    int i = getChildCount();
    int i2 = this.mItemCount;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.mFirstPosition + i;
      i = localView.getRight() + k;
    }
    else
    {
      j = this.mItemCount - 1;
      this.mFirstPosition = j;
      i = getPaddingLeft();
      this.mShouldStopFling = true;
    }
    while ((i < m - n - i1) && (j < i2))
    {
      i = makeAndAddView(j, j - this.mSelectedPosition, i, true).getRight() + k;
      j += 1;
    }
  }
  
  private void fillToGalleryRightCycle()
  {
    int k = this.mSpacing;
    int m = getRight() - getLeft() - getPaddingRight();
    int i = getChildCount();
    int n = this.mItemCount;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.mFirstPosition + i;
      i = localView.getRight() + k;
    }
    else
    {
      j = this.mItemCount - 1;
      this.mFirstPosition = j;
      i = getPaddingLeft();
      this.mShouldStopFling = true;
    }
    while ((i < m) && (j < n))
    {
      i = makeAndAddView(j, j - this.mSelectedPosition, i, true).getRight() + k;
      j += 1;
    }
    j %= n;
    while ((i <= m) && (getChildCount() < this.mItemCount))
    {
      i = makeAndAddView(j, j - this.mSelectedPosition, i, true).getRight() + k;
      j += 1;
    }
  }
  
  private void fillToGalleryTop()
  {
    if (isScrollCycle())
    {
      fillToGalleryTopCycle();
      return;
    }
    int k = this.mSpacing;
    int m = getPaddingTop();
    View localView = getChildAt(0);
    int j;
    int i;
    if (localView != null)
    {
      j = this.mFirstPosition - 1;
      i = localView.getTop() - k;
    }
    else
    {
      i = getBottom() - getTop() - getPaddingBottom();
      this.mShouldStopFling = true;
      j = 0;
    }
    while ((i > m) && (j >= 0))
    {
      localView = makeAndAddViewVertical(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getTop() - k;
      j -= 1;
    }
  }
  
  private void fillToGalleryTopCycle()
  {
    int k = this.mSpacing;
    int m = getPaddingTop();
    View localView = getChildAt(0);
    int i;
    if (localView != null)
    {
      j = this.mFirstPosition - 1;
      i = localView.getTop() - k;
    }
    else
    {
      i = getBottom() - getTop() - getPaddingBottom();
      this.mShouldStopFling = true;
      j = 0;
    }
    while ((i > m) && (j >= 0))
    {
      localView = makeAndAddViewVertical(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getTop() - k;
      j -= 1;
    }
    int j = this.mItemCount - 1;
    while ((i > m) && (getChildCount() < this.mItemCount))
    {
      localView = makeAndAddViewVertical(j, j - this.mSelectedPosition, i, false);
      this.mFirstPosition = j;
      i = localView.getTop() - k;
      j -= 1;
    }
  }
  
  private int getCenterOfView(View paramView)
  {
    int i;
    if (isOrientationVertical()) {
      i = paramView.getTop();
    }
    for (int j = paramView.getHeight() / 2;; j = paramView.getWidth() / 2)
    {
      return i + j;
      i = paramView.getLeft();
    }
  }
  
  private float getStopFlingPosition()
  {
    float f;
    if (isOrientationVertical()) {
      f = (getHeight() - getPaddingTop() - getPaddingBottom()) * onStopFlingPosRatio();
    }
    for (int i = getPaddingTop();; i = getPaddingLeft())
    {
      return f + i;
      f = (getWidth() - getPaddingLeft() - getPaddingRight()) * onStopFlingPosRatio();
    }
  }
  
  private boolean isOrientationVertical()
  {
    return this.mOrientation == 2;
  }
  
  private View makeAndAddView(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.mDataChanged)
    {
      localView = this.mRecycler.get(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getLeft();
        this.mRightMost = Math.max(this.mRightMost, localView.getMeasuredWidth() + paramInt1);
        this.mLeftMost = Math.min(this.mLeftMost, paramInt1);
        setUpChild(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.mAdapter.getView(paramInt1, null, this);
    setUpChild(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private View makeAndAddViewVertical(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.mDataChanged)
    {
      localView = this.mRecycler.get(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getTop();
        this.mRightMost = Math.max(this.mRightMost, localView.getMeasuredHeight() + paramInt1);
        this.mLeftMost = Math.min(this.mLeftMost, paramInt1);
        setUpChildVertical(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.mAdapter.getView(paramInt1, null, this);
    setUpChildVertical(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private void onFinishedMovement()
  {
    if (this.mSuppressSelectionChanged)
    {
      this.mSuppressSelectionChanged = false;
      super.selectionChanged();
    }
    invalidate();
    VerticalGallery.OnEndMovementListener localOnEndMovementListener = this.mOnEndMovementListener;
    if (localOnEndMovementListener != null) {
      localOnEndMovementListener.onEndMovement(this);
    }
  }
  
  private boolean performItemSelect(int paramInt)
  {
    if (paramInt != this.mSelectedPosition)
    {
      setSelectedPositionInt(paramInt);
      setNextSelectedPositionInt(paramInt);
      checkSelectionChanged();
      return true;
    }
    return false;
  }
  
  private void scrollIntoSlotsVertical()
  {
    View localView1;
    if (isSlotInCenter())
    {
      if (getChildCount() != 0)
      {
        localView1 = this.mSelectedChild;
        if (localView1 == null) {
          return;
        }
        i = getCenterOfView(localView1);
        i = getCenterOfGallery() - i;
        if (i != 0)
        {
          this.mFlingRunnable.startUsingDistance(i);
          return;
        }
        onFinishedMovement();
      }
      return;
    }
    if (getChildCount() == 0) {
      return;
    }
    int i = this.mFirstPosition;
    int j = 0;
    if (i == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getTop() >= 0)
      {
        j = getPaddingTop();
        i = localView1.getTop();
      }
      else
      {
        View localView2 = getChildAt(getChildCount() - 1);
        if (localView2.getBottom() - localView1.getTop() < getBottom() - getPaddingBottom()) {
          i = getPaddingLeft();
        }
        for (j = this.mFirstChildOffset;; j = localView2.getBottom())
        {
          i -= j;
          break;
          i = j;
          if (localView2.getBottom() >= getBottom() - getPaddingBottom()) {
            break;
          }
          i = getHeight() - getPaddingBottom();
        }
      }
    }
    else
    {
      i = j;
      if (this.mFirstPosition + getChildCount() != this.mItemCount) {
        break label255;
      }
      localView1 = getChildAt(getChildCount() - 1);
      i = j;
      if (localView1.getBottom() >= getBottom() - getPaddingBottom()) {
        break label255;
      }
      j = getHeight() - getPaddingBottom();
      i = localView1.getBottom();
    }
    i = j - i;
    label255:
    if (i != 0)
    {
      this.mFlingRunnable.startUsingDistance(i);
      return;
    }
    onFinishedMovement();
  }
  
  private boolean scrollToChild(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getCenterOfGallery();
      int i = getCenterOfView(localView);
      this.mFlingRunnable.startUsingDistance(paramInt - i);
      return true;
    }
    return false;
  }
  
  private void setSelectionToCenterChild()
  {
    View localView = this.mSelectedChild;
    if (localView == null) {
      return;
    }
    int i1 = getCenterOfGallery();
    if ((localView.getLeft() <= i1) && (localView.getRight() >= i1)) {
      return;
    }
    int k = 2147483647;
    int j = 0;
    int i = getChildCount() - 1;
    int m;
    for (;;)
    {
      m = j;
      if (i < 0) {
        break;
      }
      localView = getChildAt(i);
      if ((localView.getLeft() <= i1) && (localView.getRight() >= i1))
      {
        m = i;
        break;
      }
      int n = Math.min(Math.abs(localView.getLeft() - i1), Math.abs(localView.getRight() - i1));
      m = k;
      if (n < k)
      {
        j = i;
        m = n;
      }
      i -= 1;
      k = m;
    }
    j = this.mFirstPosition + m;
    i = j;
    if (isScrollCycle()) {
      i = j % this.mItemCount;
    }
    if (i != this.mSelectedPosition)
    {
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      checkSelectionChanged();
    }
  }
  
  private void setSelectionToCenterChildVertical()
  {
    View localView = this.mSelectedChild;
    if (localView == null) {
      return;
    }
    int i1 = getCenterOfGallery();
    if ((localView != null) && (localView.getTop() <= i1) && (localView.getBottom() >= i1)) {
      return;
    }
    int k = 2147483647;
    int j = 0;
    int i = getChildCount() - 1;
    int m;
    for (;;)
    {
      m = j;
      if (i < 0) {
        break;
      }
      localView = getChildAt(i);
      if ((localView.getTop() <= i1) && (localView.getBottom() >= i1))
      {
        m = i;
        break;
      }
      int n = Math.min(Math.abs(localView.getTop() - i1), Math.abs(localView.getBottom() - i1));
      m = k;
      if (n < k)
      {
        j = i;
        m = n;
      }
      i -= 1;
      k = m;
    }
    j = this.mFirstPosition + m;
    i = j;
    if (isScrollCycle()) {
      i = j % this.mItemCount;
    }
    if (i != this.mSelectedPosition)
    {
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      checkSelectionChanged();
    }
  }
  
  private void setUpChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    VerticalGallery.LayoutParams localLayoutParams2 = (VerticalGallery.LayoutParams)paramView.getLayoutParams();
    VerticalGallery.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = (VerticalGallery.LayoutParams)generateDefaultLayoutParams();
    }
    boolean bool = false;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 0;
    }
    addViewInLayout(paramView, i, localLayoutParams1);
    if (paramInt1 == 0) {
      bool = true;
    }
    paramView.setSelected(bool);
    paramInt1 = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, localLayoutParams1.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, localLayoutParams1.width), paramInt1);
    int i = calculateTop(paramView, true);
    int j = paramView.getMeasuredHeight();
    int k = paramView.getMeasuredWidth();
    if (paramBoolean)
    {
      paramInt1 = paramInt2 + k;
    }
    else
    {
      paramInt1 = paramInt2;
      paramInt2 -= k;
    }
    paramView.layout(paramInt2, i, paramInt1, j + i);
  }
  
  private void setUpChildVertical(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    VerticalGallery.LayoutParams localLayoutParams2 = (VerticalGallery.LayoutParams)paramView.getLayoutParams();
    VerticalGallery.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = (VerticalGallery.LayoutParams)generateDefaultLayoutParams();
    }
    boolean bool = false;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 0;
    }
    addViewInLayout(paramView, i, localLayoutParams1);
    if (paramInt1 == 0) {
      bool = true;
    }
    paramView.setSelected(bool);
    paramInt1 = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, localLayoutParams1.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, localLayoutParams1.width), paramInt1);
    int i = calculateLeft(paramView, true);
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    if (paramBoolean)
    {
      paramInt1 = paramInt2 + k;
    }
    else
    {
      paramInt1 = paramInt2;
      paramInt2 -= k;
    }
    paramView.layout(i, paramInt2, j + i, paramInt1);
  }
  
  private void updateSelectedItemMetadata()
  {
    View localView1 = this.mSelectedChild;
    int j = this.mSelectedPosition - this.mFirstPosition;
    int i = j;
    if (isScrollCycle())
    {
      i = j;
      if (this.mFirstPosition > this.mSelectedPosition) {
        i = this.mItemCount - this.mFirstPosition + this.mSelectedPosition;
      }
    }
    View localView2 = getChildAt(i);
    this.mSelectedChild = localView2;
    if (localView2 == null) {
      return;
    }
    localView2.setSelected(true);
    localView2.setFocusable(true);
    if (hasFocus()) {
      localView2.requestFocus();
    }
    VerticalGallery.OnSelectViewDataUpdateListener localOnSelectViewDataUpdateListener = this.mOnSelectViewDataUpdateListener;
    if (localOnSelectViewDataUpdateListener != null) {
      localOnSelectViewDataUpdateListener.onSelectDataUpdate(localView2, i);
    }
    if ((localView1 != null) && (localView1 != this.mSelectedChild)) {
      localView1.setSelected(false);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof VerticalGallery.LayoutParams;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    int m = getChildCount();
    int k = 0;
    if (m > 0)
    {
      int j = m * 100;
      View localView = getChildAt(0);
      int n = localView.getLeft();
      int i1 = localView.getWidth();
      int i = j;
      if (i1 > 0)
      {
        if (this.mFirstPosition == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          i = j;
          if (n > 0) {}
        }
        else
        {
          i = j + n * 100 / i1;
        }
      }
      localView = getChildAt(m - 1);
      n = localView.getRight();
      i1 = localView.getWidth();
      j = i;
      if (i1 > 0)
      {
        j = k;
        if (this.mFirstPosition + m == this.mItemCount) {
          j = 1;
        }
        if (j != 0)
        {
          j = i;
          if (n < getWidth()) {}
        }
        else
        {
          j = i - (n - getWidth()) * 100 / i1;
        }
      }
      return j;
    }
    return 0;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    if ((this.mFirstPosition >= 0) && (getChildCount() > 0))
    {
      View localView = getChildAt(0);
      int i = localView.getLeft();
      int j = localView.getWidth();
      if (j > 0) {
        return Math.max(this.mFirstPosition / 1 * 100 - i * 100 / j, 0);
      }
    }
    return this.mSelectedPosition;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return Math.max((this.mItemCount + 1 - 1) / 1 * 100, 0);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    View localView = this.mSelectedChild;
    if (localView != null) {
      localView.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  protected void dispatchUnpress()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).setPressed(false);
      i -= 1;
    }
    setPressed(false);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new VerticalGallery.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new VerticalGallery.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new VerticalGallery.LayoutParams(paramLayoutParams);
  }
  
  protected int getCenterOfGallery()
  {
    int i;
    if (isOrientationVertical()) {
      i = (getHeight() - getPaddingTop() - getPaddingBottom()) / 2;
    }
    for (int j = getPaddingTop();; j = getPaddingLeft())
    {
      return i + j;
      i = (getWidth() - getPaddingLeft() - getPaddingRight()) / 2;
    }
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = this.mSelectedPosition - this.mFirstPosition;
    if (i < 0) {
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i;
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= i) {
      paramInt1 = paramInt2 + 1;
    }
    return paramInt1;
  }
  
  int getChildHeight(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramTransformation.clear();
    float f;
    if (paramView == this.mSelectedChild) {
      f = 1.0F;
    } else {
      f = this.mUnselectedAlpha;
    }
    paramTransformation.setAlpha(f);
    return true;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.mContextMenuInfo;
  }
  
  public int getFirstPosition()
  {
    return this.mFirstPosition;
  }
  
  public int getItemIndexFromPoint(Point paramPoint)
  {
    int k = getChildCount();
    Rect localRect = new Rect();
    getDrawingRect(localRect);
    boolean bool = localRect.contains(paramPoint.x, paramPoint.y);
    int j = -1;
    if (bool)
    {
      i = 0;
      while (i < k)
      {
        getChildAt(i).getHitRect(localRect);
        if (localRect.contains(paramPoint.x, paramPoint.y)) {
          break label89;
        }
        i += 1;
      }
    }
    int i = -1;
    label89:
    if (i >= 0) {
      j = i + this.mFirstPosition;
    }
    return j;
  }
  
  int getLimitedMotionScrollAmount(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      i = this.mItemCount - 1;
    } else {
      i = 0;
    }
    View localView = getChildAt(i - this.mFirstPosition);
    if (localView == null) {
      return paramInt;
    }
    int i = getCenterOfView(localView);
    int j = getCenterOfGallery();
    if (paramBoolean)
    {
      if (i <= j) {
        return 0;
      }
    }
    else if (i >= j) {
      return 0;
    }
    i = j - i;
    if (paramBoolean) {
      return Math.max(i, paramInt);
    }
    return Math.min(i, paramInt);
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getSpacing()
  {
    return this.mSpacing;
  }
  
  public float getVelocityRatio()
  {
    return this.mVelocityRatio;
  }
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.invalidate(paramInt1, paramInt2 - (this.mScrollBarSize + this.mScrollBarBottomMargin), paramInt3, paramInt4);
  }
  
  public boolean isPointInChild(float paramFloat1, float paramFloat2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((paramFloat1 >= localView.getLeft()) && (paramFloat1 <= localView.getRight()) && (paramFloat2 >= localView.getTop()) && (paramFloat2 <= localView.getBottom())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isScrollCycle()
  {
    return (this.mIsScrollCycle) && (this.mIsScrollCycleTemp);
  }
  
  public boolean isScrolling()
  {
    return this.mScrolling;
  }
  
  public boolean isSlotInCenter()
  {
    return this.mIsSlotCenter;
  }
  
  void layout(int paramInt, boolean paramBoolean)
  {
    if (isOrientationVertical())
    {
      layoutVertical(paramInt, paramBoolean);
      return;
    }
    int i = this.mSpinnerPadding.left + this.mFirstChildOffset;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      resetList();
      return;
    }
    if (this.mNextSelectedPosition >= 0) {
      setSelectedPositionInt(this.mNextSelectedPosition);
    }
    recycleAllViews();
    detachAllViewsFromParent();
    paramBoolean = false;
    this.mRightMost = 0;
    this.mLeftMost = 0;
    this.mFirstPosition = this.mSelectedPosition;
    View localView = makeAndAddView(this.mFirstPosition, 0, 0, true);
    paramInt = this.mSpacing + i;
    if (isSlotInCenter()) {
      paramInt = i + (getRight() - getLeft() - this.mSpinnerPadding.left - this.mSpinnerPadding.right) / 2 - localView.getWidth() / 2;
    }
    localView.offsetLeftAndRight(paramInt);
    fillToGalleryRight();
    fillToGalleryLeft();
    this.mRecycler.clear();
    invalidate();
    this.mDataChanged = false;
    this.mNeedSync = false;
    setNextSelectedPositionInt(this.mSelectedPosition);
    updateSelectedItemMetadata();
    if (getChildCount() < this.mItemCount) {
      paramBoolean = true;
    }
    this.mIsScrollCycleTemp = paramBoolean;
  }
  
  void layoutVertical(int paramInt, boolean paramBoolean)
  {
    int i = this.mSpinnerPadding.top + this.mFirstChildOffset;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      resetList();
      return;
    }
    if (this.mNextSelectedPosition >= 0) {
      setSelectedPositionInt(this.mNextSelectedPosition);
    }
    recycleAllViews();
    detachAllViewsFromParent();
    paramBoolean = false;
    this.mRightMost = 0;
    this.mLeftMost = 0;
    this.mFirstPosition = this.mSelectedPosition;
    View localView = makeAndAddViewVertical(this.mFirstPosition, 0, 0, true);
    paramInt = this.mSpacing + i;
    if (isSlotInCenter()) {
      paramInt = i + (getBottom() - getTop() - this.mSpinnerPadding.top - this.mSpinnerPadding.bottom) / 2 - localView.getHeight() / 2;
    }
    localView.offsetTopAndBottom(paramInt);
    fillToGalleryBottom();
    fillToGalleryTop();
    this.mRecycler.clear();
    invalidate();
    this.mDataChanged = false;
    this.mNeedSync = false;
    setNextSelectedPositionInt(this.mSelectedPosition);
    updateSelectedItemMetadata();
    if (getChildCount() < this.mItemCount) {
      paramBoolean = true;
    }
    this.mIsScrollCycleTemp = paramBoolean;
  }
  
  boolean moveNext()
  {
    return (this.mItemCount > 0) && (this.mSelectedPosition < this.mItemCount - 1);
  }
  
  boolean movePrevious()
  {
    return (this.mItemCount > 0) && (this.mSelectedPosition > 0);
  }
  
  public void offsetChildrenLeftAndRight(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).offsetLeftAndRight(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).invalidate();
      }
      i -= 1;
    }
  }
  
  public void offsetChildrenTopAndBottom(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).offsetTopAndBottom(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).invalidate();
      }
      i -= 1;
    }
  }
  
  void onCancel()
  {
    onUp();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if ((1 == paramMotionEvent.getAction()) && (this.mDownTouchPosition >= 0))
    {
      if (!this.mShouldCallbackOnUnselectedItemClick) {
        int i = this.mSelectedPosition;
      }
      return true;
    }
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.mFlingRunnable.stop(false);
    this.mDownTouchPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    int i = this.mDownTouchPosition;
    if (i >= 0)
    {
      this.mDownTouchView = getChildAt(i - this.mFirstPosition);
      this.mDownTouchView.setPressed(true);
    }
    this.mIsFirstScroll = true;
    return true;
  }
  
  protected void onDrawHorizontalScrollBar(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = paramInt4 - this.mScrollBarBottomMargin;
    paramDrawable.setBounds(paramInt1, paramInt2 - this.mScrollBarSize, paramInt3, paramInt2);
    paramDrawable.draw(paramCanvas);
  }
  
  protected void onEndFling()
  {
    VerticalGallery.OnEndFlingListener localOnEndFlingListener = this.mOnEndFlingListener;
    if (localOnEndFlingListener != null) {
      localOnEndFlingListener.onEndFling(this);
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (shouldDisableScroll()) {
      return true;
    }
    if (!this.mShouldCallbackDuringFling)
    {
      removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
      if (!this.mSuppressSelectionChanged) {
        this.mSuppressSelectionChanged = true;
      }
    }
    if (isOrientationVertical())
    {
      paramFloat1 = getVelocityRatio();
      this.mFlingRunnable.startUsingVelocity((int)-(paramFloat2 * paramFloat1));
      return true;
    }
    paramFloat2 = getVelocityRatio();
    this.mFlingRunnable.startUsingVelocity((int)-(paramFloat1 * paramFloat2));
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean)
    {
      paramRect = this.mSelectedChild;
      if (paramRect != null) {
        paramRect.requestFocus(paramInt);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 66) {
      switch (paramInt)
      {
      default: 
        break;
      case 22: 
        if (moveNext()) {
          playSoundEffect(3);
        }
        return true;
      case 21: 
        if (movePrevious()) {
          playSoundEffect(1);
        }
        return true;
      }
    } else {
      this.mReceivedInvokeKeyDown = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 23) && (paramInt != 66)) {
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    if ((this.mReceivedInvokeKeyDown) && (this.mItemCount > 0))
    {
      dispatchPress(this.mSelectedChild);
      postDelayed(new VerticalGallery.2(this), ViewConfiguration.getPressedStateDuration());
      performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mAdapter.getItemId(this.mSelectedPosition));
    }
    this.mReceivedInvokeKeyDown = false;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = true;
    layout(0, false);
    this.mInLayout = false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.mDownTouchPosition < 0) {
      return;
    }
    performHapticFeedback(0);
    long l = getItemIdAtPosition(this.mDownTouchPosition);
    dispatchLongPress(this.mDownTouchView, this.mDownTouchPosition, l);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (shouldDisableScroll()) {
      return true;
    }
    this.mScrolling = true;
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.mShouldCallbackDuringFling)
    {
      if (this.mIsFirstScroll)
      {
        if (!this.mSuppressSelectionChanged) {
          this.mSuppressSelectionChanged = true;
        }
        postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250L);
      }
    }
    else if (this.mSuppressSelectionChanged) {
      this.mSuppressSelectionChanged = false;
    }
    if (isOrientationVertical()) {
      trackMotionScrollVertical((int)paramFloat2 * -1);
    } else {
      trackMotionScroll((int)paramFloat1 * -1);
    }
    this.mIsFirstScroll = false;
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.mDownTouchPosition >= 0)
    {
      if (isScrollCycle()) {
        this.mDownTouchPosition %= getCount();
      }
      if (isSlotInCenter()) {
        scrollToChild(this.mDownTouchPosition - this.mFirstPosition);
      }
      performItemSelect(this.mDownTouchPosition);
      if ((this.mShouldCallbackOnUnselectedItemClick) || (this.mDownTouchPosition == this.mSelectedPosition)) {
        performItemClick(this.mDownTouchView, this.mDownTouchPosition, this.mAdapter.getItemId(this.mDownTouchPosition));
      }
      return true;
    }
    return false;
  }
  
  protected float onStopFlingPosRatio()
  {
    return 0.0F;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.mGestureDetector.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i == 1)
    {
      onUp();
      return bool;
    }
    if (i == 3) {
      onCancel();
    }
    return bool;
  }
  
  protected void onUp()
  {
    if (VerticalGallery.FlingRunnable.access$200(this.mFlingRunnable).isFinished()) {
      scrollIntoSlots();
    }
    dispatchUnpress();
  }
  
  public int scrollGalleryItems(int paramInt)
  {
    VerticalGallery.FlingRunnable localFlingRunnable = this.mFlingRunnable;
    if (localFlingRunnable != null) {
      localFlingRunnable.startUsingDistance(paramInt * -1);
    }
    return paramInt * -1;
  }
  
  public int scrollGalleryItems(boolean paramBoolean)
  {
    int i = getChildCount();
    int k = 0;
    int j = 0;
    if (i == 0) {
      return 0;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = getChildAt(getChildCount() - 1);
      if (localObject != null) {
        i = ((View)localObject).getRight() - getRight() + getPaddingRight();
      } else {
        i = 0;
      }
      k = Math.max(i, 0);
      i = k;
      if (k == 0)
      {
        i = k;
        if (this.mFirstPosition + getChildCount() != this.mItemCount)
        {
          i = j;
          if (localObject != null) {
            i = ((View)localObject).getWidth();
          }
          i = k + i;
        }
      }
    }
    else
    {
      localObject = getChildAt(0);
      if (localObject != null) {
        i = ((View)localObject).getLeft() - getPaddingLeft();
      } else {
        i = 0;
      }
      j = Math.min(i, 0);
      i = j;
      if (j == 0)
      {
        i = j;
        if (this.mFirstPosition != 0)
        {
          i = k;
          if (localObject != null) {
            i = ((View)localObject).getWidth();
          }
          i = j - i;
        }
      }
    }
    if (i != 0)
    {
      localObject = this.mFlingRunnable;
      if (localObject != null) {
        ((VerticalGallery.FlingRunnable)localObject).startUsingDistance(i * -1);
      }
    }
    return i * -1;
  }
  
  public void scrollIntoSlots()
  {
    if (isOrientationVertical())
    {
      scrollIntoSlotsVertical();
      return;
    }
    View localView1;
    if (isSlotInCenter())
    {
      if (getChildCount() != 0)
      {
        localView1 = this.mSelectedChild;
        if (localView1 == null) {
          return;
        }
        i = getCenterOfView(localView1);
        i = getCenterOfGallery() - i;
        if (i != 0)
        {
          this.mFlingRunnable.startUsingDistance(i);
          return;
        }
        onFinishedMovement();
      }
      return;
    }
    if (getChildCount() == 0) {
      return;
    }
    int i = this.mFirstPosition;
    int j = 0;
    if (i == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getLeft() >= 0)
      {
        j = getPaddingLeft();
        i = localView1.getLeft();
      }
      else
      {
        View localView2 = getChildAt(getChildCount() - 1);
        if (localView2.getRight() - localView1.getLeft() < getRight() - getPaddingRight()) {
          i = getPaddingLeft();
        }
        for (j = this.mFirstChildOffset;; j = localView2.getRight())
        {
          i -= j;
          break;
          i = j;
          if (localView2.getRight() >= getRight() - getPaddingRight()) {
            break;
          }
          i = getWidth() - getPaddingRight();
        }
      }
    }
    else
    {
      i = j;
      if (this.mFirstPosition + getChildCount() != this.mItemCount) {
        break label267;
      }
      localView1 = getChildAt(getChildCount() - 1);
      i = j;
      if (localView1.getRight() >= getRight() - getPaddingRight()) {
        break label267;
      }
      j = getWidth() - getPaddingRight();
      i = localView1.getRight();
    }
    i = j - i;
    label267:
    if (i != 0)
    {
      this.mFlingRunnable.startUsingDistance(i);
      return;
    }
    onFinishedMovement();
  }
  
  protected void selectionChanged()
  {
    if (!this.mSuppressSelectionChanged) {
      super.selectionChanged();
    }
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.mAnimationDuration = paramInt;
  }
  
  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.mShouldCallbackDuringFling = paramBoolean;
  }
  
  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.mShouldCallbackOnUnselectedItemClick = paramBoolean;
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    this.mIsDisableScroll = paramBoolean;
  }
  
  public void setFirstChildOffset(int paramInt)
  {
    this.mFirstChildOffset = paramInt;
  }
  
  public void setFirstPosition(int paramInt)
  {
    this.mFirstPosition = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      this.mGravity = paramInt;
      requestLayout();
    }
  }
  
  public void setOnEndFlingListener(VerticalGallery.OnEndFlingListener paramOnEndFlingListener)
  {
    this.mOnEndFlingListener = paramOnEndFlingListener;
  }
  
  public void setOnEndMovementListener(VerticalGallery.OnEndMovementListener paramOnEndMovementListener)
  {
    this.mOnEndMovementListener = paramOnEndMovementListener;
  }
  
  public void setOnSelectViewDataUpdateListener(VerticalGallery.OnSelectViewDataUpdateListener paramOnSelectViewDataUpdateListener)
  {
    this.mOnSelectViewDataUpdateListener = paramOnSelectViewDataUpdateListener;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScrollBarBottomMargin(int paramInt)
  {
    this.mScrollBarBottomMargin = paramInt;
  }
  
  public void setScrollBarSize(int paramInt)
  {
    this.mScrollBarSize = paramInt;
  }
  
  public void setScrollCycle(boolean paramBoolean)
  {
    this.mIsScrollCycle = paramBoolean;
  }
  
  protected void setSelectedPositionInt(int paramInt)
  {
    super.setSelectedPositionInt(paramInt);
    updateSelectedItemMetadata();
  }
  
  public void setSlotInCenter(boolean paramBoolean)
  {
    this.mIsSlotCenter = paramBoolean;
  }
  
  public void setSpacing(int paramInt)
  {
    this.mSpacing = paramInt;
  }
  
  public void setUnselectedAlpha(float paramFloat)
  {
    this.mUnselectedAlpha = paramFloat;
  }
  
  public void setVelocityRatio(float paramFloat)
  {
    this.mVelocityRatio = paramFloat;
    paramFloat = this.mVelocityRatio;
    if (paramFloat < 0.5F)
    {
      this.mVelocityRatio = 0.5F;
      return;
    }
    if (paramFloat > 1.5F) {
      this.mVelocityRatio = 1.5F;
    }
  }
  
  protected boolean shouldDisableScroll()
  {
    if (this.mIsDisableScroll)
    {
      if (getChildCount() < this.mItemCount) {
        return false;
      }
      View localView = getChildAt(0);
      if ((localView != null) && (localView.getLeft() < getLeft())) {
        return false;
      }
      localView = getChildAt(getChildCount() - 1);
      return (localView == null) || (localView.getRight() <= getRight());
    }
    return false;
  }
  
  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.mSelectedPosition >= 0)) {
      return dispatchLongPress(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }
    return false;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i = getPositionForView(paramView);
    if (i < 0) {
      return false;
    }
    return dispatchLongPress(paramView, i, this.mAdapter.getItemId(i));
  }
  
  void trackMotionScroll(int paramInt)
  {
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (isSlotInCenter())
    {
      if (((!isScrollCycle()) || (getChildCount() >= this.mItemCount)) && (getLimitedMotionScrollAmount(bool, paramInt) != paramInt))
      {
        VerticalGallery.FlingRunnable.access$100(this.mFlingRunnable, false);
        onFinishedMovement();
      }
      offsetChildrenLeftAndRight(paramInt);
      detachOffScreenChildren(bool);
      if (bool) {
        fillToGalleryRight();
      } else {
        fillToGalleryLeft();
      }
      this.mRecycler.clear();
      setSelectionToCenterChild();
      invalidate();
      return;
    }
    Object localObject;
    if (bool)
    {
      localObject = getChildAt(getChildCount() - 1);
      i = paramInt;
      if (localObject == null) {
        break label221;
      }
      i = paramInt;
      if (((View)localObject).getRight() >= getStopFlingPosition()) {
        break label221;
      }
      localObject = this.mFlingRunnable;
      if (localObject != null) {
        ((VerticalGallery.FlingRunnable)localObject).stop(false);
      }
    }
    else
    {
      localObject = getChildAt(0);
      i = paramInt;
      if (localObject == null) {
        break label221;
      }
      i = paramInt;
      if (((View)localObject).getLeft() <= getWidth() - getStopFlingPosition()) {
        break label221;
      }
      localObject = this.mFlingRunnable;
      if (localObject != null) {
        ((VerticalGallery.FlingRunnable)localObject).stop(false);
      }
    }
    int i = 0;
    label221:
    offsetChildrenLeftAndRight(i);
    detachOffScreenChildren(bool);
    if (bool) {
      fillToGalleryRight();
    } else {
      fillToGalleryLeft();
    }
    this.mRecycler.clear();
    setSelectionToCenterChild();
    awakenScrollBars();
    invalidate();
  }
  
  void trackMotionScrollVertical(int paramInt)
  {
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (isSlotInCenter())
    {
      if (((!isScrollCycle()) || (getChildCount() >= this.mItemCount)) && (getLimitedMotionScrollAmount(bool, paramInt) != paramInt))
      {
        VerticalGallery.FlingRunnable.access$100(this.mFlingRunnable, false);
        onFinishedMovement();
      }
      offsetChildrenTopAndBottom(paramInt);
      detachOffScreenChildrenVertical(bool);
      if (bool) {
        fillToGalleryBottom();
      } else {
        fillToGalleryTop();
      }
      this.mRecycler.clear();
      setSelectionToCenterChildVertical();
      invalidate();
      return;
    }
    Object localObject;
    if (bool)
    {
      localObject = getChildAt(getChildCount() - 1);
      i = paramInt;
      if (localObject == null) {
        break label221;
      }
      i = paramInt;
      if (((View)localObject).getRight() >= getStopFlingPosition()) {
        break label221;
      }
      localObject = this.mFlingRunnable;
      if (localObject != null) {
        ((VerticalGallery.FlingRunnable)localObject).stop(false);
      }
    }
    else
    {
      localObject = getChildAt(0);
      i = paramInt;
      if (localObject == null) {
        break label221;
      }
      i = paramInt;
      if (((View)localObject).getLeft() <= getWidth() - getStopFlingPosition()) {
        break label221;
      }
      localObject = this.mFlingRunnable;
      if (localObject != null) {
        ((VerticalGallery.FlingRunnable)localObject).stop(false);
      }
    }
    int i = 0;
    label221:
    offsetChildrenTopAndBottom(i);
    detachOffScreenChildrenVertical(bool);
    if (bool) {
      fillToGalleryBottom();
    } else {
      fillToGalleryTop();
    }
    this.mRecycler.clear();
    setSelectionToCenterChild();
    awakenScrollBars();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.VerticalGallery
 * JD-Core Version:    0.7.0.1
 */