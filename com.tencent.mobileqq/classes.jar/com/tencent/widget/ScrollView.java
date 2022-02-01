package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import blbm;
import bldq;
import blfb;
import blfc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ScrollView
  extends FrameLayout
{
  static final int ANIMATED_SCROLL_GAP = 250;
  public static boolean DEBUG = false;
  private static final int INVALID_POINTER = -1;
  static final float MAX_SCROLL_FACTOR = 0.5F;
  private static final int[] SCROLLVIEW = getStyleableValues("ScrollView");
  private static final int SCROLLVIEW_FILLVIEWPORT = getStyleableValue("ScrollView_fillViewport");
  public static final int SCROLL_FLAG_DEFAULT = 0;
  public static final int SCROLL_FLAG_DISABLE_SCROLL_TOP = 1;
  private int mActivePointerId = -1;
  private View mChildToScrollTo;
  private Drawable mContentBackgroundDrawable;
  int mCurScrollState = 0;
  private boolean mEdgeEffectEnabled;
  private blbm mEdgeGlowBottom;
  private blbm mEdgeGlowTop;
  @ViewDebug.ExportedProperty(category="layout")
  private boolean mFillViewport;
  private Object mFlingStrictSpan;
  private Drawable mForeground;
  private boolean mIsBeingDragged;
  private boolean mIsLayoutDirty = true;
  boolean mLastIsFromCompute;
  private float mLastMotionY;
  private long mLastScroll;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private Drawable mOverScrollHeaderShadow;
  private int mOverScrollMode;
  protected int mOverflingDistance;
  protected int mOverscrollDistance;
  blfb mScrollChangeCompatListener;
  public int mScrollFlag = 0;
  blfc mScrollListener;
  private Object mScrollStrictSpan;
  public bldq mScroller;
  private boolean mSmoothScrollingEnabled = true;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public ScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842880);
  }
  
  public ScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initScrollView();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, SCROLLVIEW, paramInt, 0);
    setFillViewport(paramContext.getBoolean(SCROLLVIEW_FILLVIEWPORT, false));
    paramContext.recycle();
    setEdgeEffectEnabled(false);
  }
  
  private boolean canScroll()
  {
    boolean bool2 = false;
    View localView = getChildAt(0);
    boolean bool1 = bool2;
    if (localView != null)
    {
      int i = localView.getHeight();
      bool1 = bool2;
      if (getHeight() < i + this.mPaddingTop + this.mPaddingBottom) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0)) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (paramInt2 + paramInt1 <= paramInt3);
    return paramInt3 - paramInt2;
  }
  
  private void doScrollY(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.mSmoothScrollingEnabled) {
        smoothScrollBy(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    recycleVelocityTracker();
    if (this.mEdgeGlowTop != null)
    {
      this.mEdgeGlowTop.b();
      this.mEdgeGlowBottom.b();
    }
    if (this.mScrollStrictSpan != null) {
      finishSpan(this.mScrollStrictSpan);
    }
    if (this.mScroller.a())
    {
      updateScrollState(0);
      return;
    }
    updateScrollState(2);
  }
  
  @TargetApi(9)
  private Object enterCriticalSpan(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (DEBUG) {
      localObject1 = localObject2;
    }
    try
    {
      if (VersionUtils.isGingerBread()) {
        localObject1 = StrictMode.class.getMethod("enterCriticalSpan", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      }
      return localObject1;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private View findFocusableViewInBounds(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    Object localObject2 = null;
    int i = 0;
    int n = localArrayList.size();
    int k = 0;
    Object localObject1;
    int m;
    int i1;
    int j;
    if (k < n)
    {
      localObject1 = (View)localArrayList.get(k);
      m = ((View)localObject1).getTop();
      i1 = ((View)localObject1).getBottom();
      if ((paramInt1 >= i1) || (m >= paramInt2)) {
        break label192;
      }
      if ((paramInt1 < m) && (i1 < paramInt2))
      {
        j = 1;
        label87:
        if (localObject2 != null) {
          break label115;
        }
        i = j;
      }
    }
    for (;;)
    {
      k += 1;
      localObject2 = localObject1;
      break;
      j = 0;
      break label87;
      label115:
      if (((paramBoolean) && (m < localObject2.getTop())) || ((!paramBoolean) && (i1 > localObject2.getBottom()))) {}
      for (m = 1;; m = 0)
      {
        if (i == 0) {
          break label170;
        }
        if ((j == 0) || (m == 0)) {
          break label192;
        }
        break;
      }
      label170:
      if (j != 0)
      {
        i = 1;
      }
      else if (m != 0)
      {
        continue;
        return localObject2;
      }
      else
      {
        label192:
        localObject1 = localObject2;
      }
    }
  }
  
  private View findFocusableViewInMyBounds(boolean paramBoolean, int paramInt, View paramView)
  {
    int j = getVerticalFadingEdgeLength() / 2;
    int i = paramInt + j;
    paramInt = getHeight() + paramInt - j;
    if ((paramView != null) && (paramView.getTop() < paramInt) && (paramView.getBottom() > i)) {
      return paramView;
    }
    return findFocusableViewInBounds(paramBoolean, i, paramInt);
  }
  
  @TargetApi(9)
  private Object finishSpan(Object paramObject)
  {
    if (DEBUG) {}
    try
    {
      paramObject.getClass().getMethod("finish", new Class[0]).invoke(paramObject, new Object[0]);
      label29:
      return null;
    }
    catch (Exception paramObject)
    {
      break label29;
    }
  }
  
  private int getScrollRange()
  {
    int i = 0;
    if (getChildCount() > 0) {
      i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - this.mPaddingBottom - this.mPaddingTop));
    }
    return i;
  }
  
  protected static int getStyleableValue(String paramString)
  {
    try
    {
      int i = Class.forName("com.android.internal.R$styleable").getField(paramString).getInt(null);
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  protected static int[] getStyleableValues(String paramString)
  {
    try
    {
      paramString = (int[])Class.forName("com.android.internal.R$styleable").getField(paramString).get(null);
      return paramString;
    }
    catch (Exception paramString) {}
    return new int[0];
  }
  
  private boolean inChild(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getChildCount() > 0)
    {
      int i = this.mScrollY;
      View localView = getChildAt(0);
      bool1 = bool2;
      if (paramInt2 >= localView.getTop() - i)
      {
        bool1 = bool2;
        if (paramInt2 < localView.getBottom() - i)
        {
          bool1 = bool2;
          if (paramInt1 >= localView.getLeft())
          {
            bool1 = bool2;
            if (paramInt1 < localView.getRight()) {
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
    if (this.mVelocityTracker == null)
    {
      this.mVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.mVelocityTracker.clear();
  }
  
  private void initScrollView()
  {
    this.mScroller = new bldq(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    int i = (int)(getResources().getDisplayMetrics().density * 0.0F + 0.5F);
    this.mOverflingDistance = i;
    this.mOverscrollDistance = i;
    setOverScrollMode(2);
    this.mScroller.a(0.005F);
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private boolean isOffScreen(View paramView)
  {
    boolean bool = false;
    if (!isWithinDeltaOfScreen(paramView, 0, getHeight())) {
      bool = true;
    }
    return bool;
  }
  
  private boolean isViewDescendantOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    if (((paramView1 instanceof ViewGroup)) && (isViewDescendantOf((View)paramView1, paramView2))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean isWithinDeltaOfScreen(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    return (this.mTempRect.bottom + paramInt1 >= getScrollY()) && (this.mTempRect.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label63;
      }
    }
    label63:
    for (i = 1;; i = 0)
    {
      this.mLastMotionY = paramMotionEvent.getY(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      return;
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
    int j = this.mScrollY;
    int i = j;
    if (this.mScrollY > 0)
    {
      i = j;
      if (this.mScrollY > paramInt2) {
        i = this.mScrollY - paramInt2;
      }
    }
    if (paramInt1 * i < 0) {
      return paramInt1;
    }
    return (getHeight() - Math.abs(i)) * paramInt1 / getHeight() / 2;
  }
  
  private boolean scrollAndFocus(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    int j = getHeight();
    int i = getScrollY();
    j = i + j;
    if (paramInt1 == 33) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFocusableViewInBounds(bool1, paramInt2, paramInt3);
      Object localObject = localView;
      if (localView == null) {
        localObject = this;
      }
      if ((paramInt2 < i) || (paramInt3 > j)) {
        break;
      }
      bool1 = bool2;
      if (localObject != findFocus()) {
        ((View)localObject).requestFocus(paramInt1);
      }
      return bool1;
    }
    if (bool1) {
      paramInt2 -= i;
    }
    for (;;)
    {
      doScrollY(paramInt2);
      bool1 = true;
      break;
      paramInt2 = paramInt3 - j;
    }
  }
  
  private void scrollToChild(View paramView)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  private boolean scrollToChildRect(Rect paramRect, boolean paramBoolean)
  {
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean) {
          break;
        }
        scrollBy(0, i);
      }
      return bool;
    }
    smoothScrollBy(0, i);
    return bool;
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int j = getMaxScrollAmount();
    if ((localView2 != null) && (isWithinDeltaOfScreen(localView2, j, getHeight())))
    {
      localView2.getDrawingRect(this.mTempRect);
      offsetDescendantRectToMyCoords(localView2, this.mTempRect);
      doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()) && (isOffScreen(localView1)))
      {
        paramInt = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(paramInt);
      }
      return true;
    }
    int i;
    if ((paramInt == 33) && (getScrollY() < j)) {
      i = getScrollY();
    }
    while (i == 0)
    {
      return false;
      i = j;
      if (paramInt == 130)
      {
        i = j;
        if (getChildCount() > 0)
        {
          int k = getChildAt(0).getBottom();
          int m = getScrollY() + getHeight() - this.mPaddingBottom;
          i = j;
          if (k - m < j) {
            i = k - m;
          }
        }
      }
    }
    if (paramInt == 130) {}
    for (;;)
    {
      doScrollY(i);
      break;
      i = -i;
    }
  }
  
  public void computeScroll()
  {
    if (this.mScroller.b())
    {
      int j = this.mScrollX;
      int k = this.mScrollY;
      int m = this.mScroller.a();
      int n = this.mScroller.b();
      int i1;
      int i;
      if ((j != m) || (k != n))
      {
        i1 = getScrollRange();
        i = getOverScrollMode();
        if ((i != 0) && ((i != 1) || (i1 <= 0))) {
          break label172;
        }
        i = 1;
        if ((n >= 0) && (n <= i1)) {
          break label177;
        }
        overScrollBy(m - j, n - k, j, k, 0, i1, 0, this.mOverflingDistance, false);
        label113:
        onScrollChanged(this.mScrollX, this.mScrollY, j, k);
        if (i != 0)
        {
          if ((this.mEdgeGlowTop == null) || (n >= 0) || (k < 0)) {
            break label188;
          }
          this.mEdgeGlowTop.a((int)this.mScroller.a());
        }
      }
      for (;;)
      {
        awakenScrollBars();
        postInvalidate();
        return;
        label172:
        i = 0;
        break;
        label177:
        scrollTo(m, n);
        break label113;
        label188:
        if ((this.mEdgeGlowTop != null) && (n > i1) && (k <= i1)) {
          this.mEdgeGlowBottom.a((int)this.mScroller.a());
        }
      }
    }
    if (this.mFlingStrictSpan != null) {
      finishSpan(this.mFlingStrictSpan);
    }
    updateScrollState(0, true);
  }
  
  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int m = getHeight();
    int i = getScrollY();
    int k = i + m;
    int n = getVerticalFadingEdgeLength();
    int j = i;
    if (paramRect.top > 0) {
      j = i + n;
    }
    i = k;
    if (paramRect.bottom < getChildAt(0).getHeight()) {
      i = k - n;
    }
    if ((paramRect.bottom > i) && (paramRect.top > j)) {
      if (paramRect.height() > m)
      {
        j = paramRect.top - j + 0;
        i = Math.min(j, getChildAt(0).getBottom() - i);
      }
    }
    for (;;)
    {
      return i;
      j = paramRect.bottom - i + 0;
      break;
      if ((paramRect.top < j) && (paramRect.bottom < i))
      {
        if (paramRect.height() > m) {}
        for (i = 0 - (i - paramRect.bottom);; i = 0 - (j - paramRect.top))
        {
          i = Math.max(i, -getScrollY());
          break;
        }
      }
      i = 0;
    }
  }
  
  protected int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  protected int computeVerticalScrollRange()
  {
    int j = getChildCount();
    int i = getHeight() - this.mPaddingBottom - this.mPaddingTop;
    if (j == 0) {}
    int k;
    int m;
    do
    {
      return i;
      j = getChildAt(0).getBottom();
      k = this.mScrollY;
      m = Math.max(0, j - i);
      if (k < 0) {
        return j - k;
      }
      i = j;
    } while (k <= m);
    return j + (k - m);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Drawable localDrawable;
    int k;
    int i;
    int j;
    if (this.mContentBackgroundDrawable != null)
    {
      localDrawable = this.mContentBackgroundDrawable;
      k = this.mScrollX;
      i = this.mScrollY;
      j = getWidth();
      localDrawable.setBounds(0, 0, getWidth(), getHeight());
      if ((k | i) != 0) {
        break label63;
      }
      localDrawable.draw(paramCanvas);
    }
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      return;
      label63:
      if (i < 0)
      {
        paramCanvas.translate(k, 0.0F);
        localDrawable.draw(paramCanvas);
        paramCanvas.translate(-k, 0.0F);
        localDrawable = this.mOverScrollHeaderShadow;
        if (localDrawable != null)
        {
          k = localDrawable.getIntrinsicHeight();
          if (k < -i) {
            localDrawable.setBounds(new Rect(0, -k, j, 0));
          }
          for (;;)
          {
            localDrawable.draw(paramCanvas);
            break;
            localDrawable.setBounds(new Rect(0, i, j, 0));
          }
        }
      }
      else
      {
        paramCanvas.translate(k, i);
        localDrawable.draw(paramCanvas);
        paramCanvas.translate(-k, -i);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.mEdgeGlowTop != null)
    {
      int i = this.mScrollY;
      int j;
      int k;
      int m;
      if (!this.mEdgeGlowTop.a())
      {
        j = paramCanvas.save();
        k = getWidth();
        m = this.mPaddingLeft;
        int n = this.mPaddingRight;
        paramCanvas.translate(this.mPaddingLeft, Math.min(0, i));
        this.mEdgeGlowTop.a(k - m - n, getHeight());
        if (this.mEdgeGlowTop.a(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(j);
      }
      if (!this.mEdgeGlowBottom.a())
      {
        j = paramCanvas.save();
        k = getWidth() - this.mPaddingLeft - this.mPaddingRight;
        m = getHeight();
        paramCanvas.translate(-k + this.mPaddingLeft, Math.max(getScrollRange(), i) + m);
        paramCanvas.rotate(180.0F, k, 0.0F);
        this.mEdgeGlowBottom.a(k, m);
        if (this.mEdgeGlowBottom.a(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = 33;
    boolean bool2 = false;
    this.mTempRect.setEmpty();
    boolean bool1;
    if (!canScroll())
    {
      bool1 = bool2;
      if (isFocused())
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 4)
        {
          View localView = findFocus();
          paramKeyEvent = localView;
          if (localView == this) {
            paramKeyEvent = null;
          }
          paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
          if ((paramKeyEvent == null) || (paramKeyEvent == this) || (!paramKeyEvent.requestFocus(130))) {
            break label93;
          }
          bool1 = true;
        }
      }
    }
    label93:
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      bool1 = bool2;
    } while (paramKeyEvent.getAction() != 0);
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    case 19: 
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(33);
      }
      return fullScroll(33);
    case 20: 
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(130);
      }
      return fullScroll(130);
    }
    if (paramKeyEvent.isShiftPressed()) {}
    for (;;)
    {
      pageScroll(i);
      return false;
      i = 130;
    }
  }
  
  public void fling(int paramInt)
  {
    if (getChildCount() > 0)
    {
      int i = getHeight() - this.mPaddingBottom - this.mPaddingTop;
      int j = getChildAt(0).getHeight();
      this.mScroller.a(this.mScrollX, this.mScrollY, 0, paramInt, 0, 0, 0, Math.max(0, j - i), 0, i / 4);
      if ((paramInt <= 0) || (this.mFlingStrictSpan == null)) {
        this.mFlingStrictSpan = enterCriticalSpan("ScrollView-fling");
      }
      invalidate();
    }
  }
  
  public boolean fullScroll(int paramInt)
  {
    if (paramInt == 130) {}
    for (int i = 1;; i = 0)
    {
      int j = getHeight();
      this.mTempRect.top = 0;
      this.mTempRect.bottom = j;
      if (i != 0)
      {
        i = getChildCount();
        if (i > 0)
        {
          View localView = getChildAt(i - 1);
          this.mTempRect.bottom = (localView.getBottom() + this.mPaddingBottom);
          this.mTempRect.top = (this.mTempRect.bottom - j);
        }
      }
      return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom);
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(0.5F * (this.mBottom - this.mTop));
  }
  
  public int getOverScrollMode()
  {
    return this.mOverScrollMode;
  }
  
  public bldq getOverScroller()
  {
    return this.mScroller;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  @TargetApi(11)
  protected void invalidateParentIfNeeded()
  {
    if ((VersionUtils.isHoneycomb()) && (isHardwareAccelerated()) && ((this.mParent instanceof View))) {
      ((View)this.mParent).invalidate();
    }
  }
  
  public boolean isFillViewport()
  {
    return this.mFillViewport;
  }
  
  public boolean isScrollFinished()
  {
    if (this.mScroller != null) {
      return this.mScroller.a();
    }
    return true;
  }
  
  public boolean isSmoothScrollingEnabled()
  {
    return this.mSmoothScrollingEnabled;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight, localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt1 = getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = localMarginLayoutParams.topMargin;
    paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.bottomMargin + paramInt2, 0));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mScrollStrictSpan != null) {
      finishSpan(this.mScrollStrictSpan);
    }
    if (this.mFlingStrictSpan != null) {
      finishSpan(this.mFlingStrictSpan);
    }
  }
  
  @TargetApi(12)
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.onGenericMotionEvent(paramMotionEvent);
      if (!this.mIsBeingDragged)
      {
        float f = paramMotionEvent.getAxisValue(9);
        if (f != 0.0F)
        {
          int i = (int)(f * getVerticalScrollFactor());
          int j = getScrollRange();
          int m = this.mScrollY;
          int k = m - i;
          if (k < 0) {
            i = 0;
          }
          while (i != m)
          {
            super.scrollTo(this.mScrollX, i);
            return true;
            i = j;
            if (k <= j) {
              i = k;
            }
          }
        }
      }
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getScrollRange() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityEvent.setScrollable(bool);
      paramAccessibilityEvent.setScrollX(this.mScrollX);
      paramAccessibilityEvent.setScrollY(this.mScrollY);
      return;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (getScrollRange() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityNodeInfo.setScrollable(bool);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingDragged)) {
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      i = this.mActivePointerId;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        float f1 = 0.0F;
        try
        {
          float f2 = paramMotionEvent.getY(i);
          f1 = f2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if ((int)Math.abs(f1 - this.mLastMotionY) > this.mTouchSlop)
        {
          this.mIsBeingDragged = true;
          this.mLastMotionY = f1;
          initVelocityTrackerIfNotExists();
          this.mVelocityTracker.addMovement(paramMotionEvent);
          if (this.mScrollStrictSpan == null) {
            this.mScrollStrictSpan = enterCriticalSpan("ScrollView-scroll");
          }
          paramMotionEvent = getParent();
          if (paramMotionEvent != null)
          {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            continue;
            f1 = paramMotionEvent.getY();
            if (!inChild((int)paramMotionEvent.getX(), (int)f1))
            {
              this.mIsBeingDragged = false;
              recycleVelocityTracker();
            }
            else
            {
              this.mLastMotionY = f1;
              this.mActivePointerId = paramMotionEvent.getPointerId(0);
              initOrResetVelocityTracker();
              this.mVelocityTracker.addMovement(paramMotionEvent);
              if (!this.mScroller.a()) {
                bool = true;
              }
              this.mIsBeingDragged = bool;
              if ((this.mIsBeingDragged) && (this.mScrollStrictSpan == null))
              {
                this.mScrollStrictSpan = enterCriticalSpan("ScrollView-scroll");
                continue;
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                recycleVelocityTracker();
                if (this.mScroller.a(this.mScrollX, this.mScrollY, 0, 0, 0, getScrollRange()))
                {
                  invalidate();
                  continue;
                  onSecondaryPointerUp(paramMotionEvent);
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mIsLayoutDirty = false;
    if ((this.mChildToScrollTo != null) && (isViewDescendantOf(this.mChildToScrollTo, this))) {
      scrollToChild(this.mChildToScrollTo);
    }
    this.mChildToScrollTo = null;
    scrollTo(this.mScrollX, this.mScrollY);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.mFillViewport) {}
    View localView;
    do
    {
      do
      {
        return;
      } while ((View.MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
      localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
    } while (localView.getMeasuredHeight() >= paramInt2);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight, localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - this.mPaddingTop - this.mPaddingBottom, 1073741824));
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
    awakenScrollBars();
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    if (paramInt == 2) {
      i = 130;
    }
    for (;;)
    {
      if (paramRect == null) {}
      try
      {
        localView1 = FocusFinder.getInstance().findNextFocus(this, null, i);
      }
      catch (Exception localException)
      {
        View localView1;
        localException.printStackTrace();
        localView2 = null;
      }
      localView1 = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i);
      View localView2;
      while (localView2 != null)
      {
        if (isOffScreen(localView2)) {
          return false;
        }
        return localView2.requestFocus(i, paramRect);
      }
      return false;
      i = paramInt;
      if (paramInt == 1) {
        i = 33;
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mScrollChangeCompatListener != null) {
      this.mScrollChangeCompatListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView)) {}
    while (!isWithinDeltaOfScreen(localView, 0, paramInt4)) {
      return;
    }
    localView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(localView, this.mTempRect);
    doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
  }
  
  @TargetApi(8)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    initVelocityTrackerIfNotExists();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i;
    float f;
    int j;
    label267:
    int m;
    int n;
    int k;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 4: 
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          bool = true;
          do
          {
            return bool;
          } while (getChildCount() == 0);
          if (!this.mScroller.a()) {}
          for (bool = true;; bool = false)
          {
            this.mIsBeingDragged = bool;
            if (bool)
            {
              ViewParent localViewParent = getParent();
              if (localViewParent != null) {
                localViewParent.requestDisallowInterceptTouchEvent(true);
              }
            }
            if (!this.mScroller.a())
            {
              this.mScroller.a();
              if (this.mFlingStrictSpan != null) {
                finishSpan(this.mFlingStrictSpan);
              }
            }
            this.mLastMotionY = paramMotionEvent.getY();
            this.mActivePointerId = paramMotionEvent.getPointerId(0);
            break;
          }
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        } while (i == -1);
        f = paramMotionEvent.getY(i);
        j = (int)(this.mLastMotionY - f);
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
      this.mLastMotionY = f;
      m = this.mScrollX;
      n = this.mScrollY;
      k = getScrollRange();
      j = getOverScrollMode();
      if ((j == 0) || ((j == 1) && (k > 0)))
      {
        j = 1;
        label322:
        if ((this.mScrollY >= 0) && (this.mScrollY <= k)) {
          break label843;
        }
        i = reviseOverScrollByTouch(i, k);
      }
      break;
    }
    label387:
    label524:
    label843:
    for (;;)
    {
      int i1 = this.mScrollY + i;
      if ((i1 < 0) || (i1 > k))
      {
        overScrollBy(0, i, 0, this.mScrollY, 0, k, 0, this.mOverscrollDistance, true);
        onScrollChanged(this.mScrollX, this.mScrollY, m, n);
        updateScrollState(1);
        if ((j == 0) || (this.mEdgeGlowTop == null)) {
          break;
        }
        j = n + i;
        if (j >= 0) {
          break label524;
        }
        this.mEdgeGlowTop.a(i / getHeight());
        if (!this.mEdgeGlowBottom.a()) {
          this.mEdgeGlowBottom.b();
        }
      }
      while ((this.mEdgeGlowTop != null) && ((!this.mEdgeGlowTop.a()) || (!this.mEdgeGlowBottom.a())))
      {
        invalidate();
        break;
        i = j + this.mTouchSlop;
        break label267;
        j = 0;
        break label322;
        scrollTo(0, i1);
        break label387;
        if (j > k)
        {
          this.mEdgeGlowBottom.a(i / getHeight());
          if (!this.mEdgeGlowTop.a()) {
            this.mEdgeGlowTop.b();
          }
        }
      }
      if (!this.mIsBeingDragged) {
        break;
      }
      paramMotionEvent = this.mVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
      if (VersionUtils.isrFroyo())
      {
        f = paramMotionEvent.getYVelocity(this.mActivePointerId);
        label605:
        i = (int)f;
        if (getChildCount() > 0)
        {
          if (Math.abs(i) <= this.mMinimumVelocity) {
            break label652;
          }
          fling(-i);
        }
      }
      for (;;)
      {
        this.mActivePointerId = -1;
        endDrag();
        break;
        f = paramMotionEvent.getYVelocity();
        break label605;
        if (this.mScroller.a(this.mScrollX, this.mScrollY, 0, 0, 0, getScrollRange())) {
          invalidate();
        }
      }
      if ((!this.mIsBeingDragged) || (getChildCount() <= 0)) {
        break;
      }
      if (this.mScroller.a(this.mScrollX, this.mScrollY, 0, 0, 0, this.mOverscrollDistance)) {
        invalidate();
      }
      this.mActivePointerId = -1;
      endDrag();
      break;
      i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
      this.mLastMotionY = paramMotionEvent.getY(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      break;
      onSecondaryPointerUp(paramMotionEvent);
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if ((i < paramMotionEvent.getPointerCount()) && (-1 != i))
      {
        this.mLastMotionY = paramMotionEvent.getY(i);
        break;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ScrollView", 4, String.format("Pointer Index %d out of range!", new Object[] { Integer.valueOf(i) }));
      break;
    }
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int k = this.mOverScrollMode;
    int i;
    int j;
    if (computeHorizontalScrollRange() > computeHorizontalScrollExtent())
    {
      i = 1;
      if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) {
        break label188;
      }
      j = 1;
      label34:
      if ((k != 0) && ((k != 1) || (i == 0))) {
        break label194;
      }
      i = 1;
      label53:
      if ((k != 0) && ((k != 1) || (j == 0))) {
        break label200;
      }
      j = 1;
      label72:
      k = paramInt3 + paramInt1;
      if (i == 0) {
        paramInt7 = 0;
      }
      paramInt4 += paramInt2;
      if (j == 0) {
        paramInt8 = 0;
      }
      i = -paramInt7;
      if (paramInt7 != 2147483647) {
        break label206;
      }
      paramInt1 = 2147483647;
      label116:
      paramInt3 = -paramInt8;
      if (paramInt8 != 2147483647) {
        break label215;
      }
      paramInt2 = 2147483647;
      label132:
      if (this.mScrollFlag == 1) {
        paramInt3 = 0;
      }
      if (k <= paramInt1) {
        break label224;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      label151:
      boolean bool;
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
          label188:
          j = 0;
          break label34;
          label194:
          i = 0;
          break label53;
          label200:
          j = 0;
          break label72;
          label206:
          paramInt1 = paramInt7 + paramInt5;
          break label116;
          label215:
          paramInt2 = paramInt8 + paramInt6;
          break label132;
          label224:
          if (k >= i) {
            break label265;
          }
          paramBoolean = true;
          paramInt1 = i;
          break label151;
          if (paramInt4 >= paramInt3) {
            break label256;
          }
          bool = true;
          paramInt2 = paramInt3;
          continue;
        }
        return false;
        label256:
        bool = false;
        paramInt2 = paramInt4;
      }
      label265:
      paramBoolean = false;
      paramInt1 = k;
    }
  }
  
  public boolean pageScroll(int paramInt)
  {
    int i;
    int j;
    if (paramInt == 130)
    {
      i = 1;
      j = getHeight();
      if (i == 0) {
        break label121;
      }
      this.mTempRect.top = (getScrollY() + j);
      i = getChildCount();
      if (i > 0)
      {
        View localView = getChildAt(i - 1);
        if (this.mTempRect.top + j > localView.getBottom()) {
          this.mTempRect.top = (localView.getBottom() - j);
        }
      }
    }
    for (;;)
    {
      this.mTempRect.bottom = (this.mTempRect.top + j);
      return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom);
      i = 0;
      break;
      label121:
      this.mTempRect.top = (getScrollY() - j);
      if (this.mTempRect.top < 0) {
        this.mTempRect.top = 0;
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.mIsLayoutDirty) {
      scrollToChild(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.mChildToScrollTo = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    return scrollToChildRect(paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      recycleVelocityTracker();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.mIsLayoutDirty = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = clamp(paramInt1, getWidth() - this.mPaddingRight - this.mPaddingLeft, localView.getWidth());
      paramInt2 = clamp(paramInt2, getHeight() - this.mPaddingBottom - this.mPaddingTop, localView.getHeight());
      if ((paramInt1 != this.mScrollX) || (paramInt2 != this.mScrollY)) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.mContentBackgroundDrawable = null;
      this.mOverScrollHeaderShadow = null;
      return;
    }
    this.mContentBackgroundDrawable = paramDrawable;
    this.mOverScrollHeaderShadow = getResources().getDrawable(2130840603);
  }
  
  public void setEdgeEffectEnabled(boolean paramBoolean)
  {
    Context localContext;
    if (this.mEdgeEffectEnabled != paramBoolean)
    {
      if (!paramBoolean) {
        break label62;
      }
      if ((this.mOverScrollMode != 2) && (this.mEdgeGlowTop == null))
      {
        localContext = getContext();
        this.mEdgeGlowTop = new blbm(localContext);
      }
    }
    for (this.mEdgeGlowBottom = new blbm(localContext);; this.mEdgeGlowBottom = null)
    {
      this.mEdgeEffectEnabled = paramBoolean;
      return;
      label62:
      this.mEdgeGlowTop = null;
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.mFillViewport)
    {
      this.mFillViewport = paramBoolean;
      requestLayout();
    }
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    if (this.mForeground != paramDrawable)
    {
      if (this.mForeground != null)
      {
        this.mForeground.setCallback(null);
        unscheduleDrawable(this.mForeground);
      }
      this.mForeground = paramDrawable;
      if (paramDrawable == null) {
        break label75;
      }
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      return;
      label75:
      setWillNotDraw(true);
    }
  }
  
  public void setOnScrollChangeListenerCompat(blfb paramblfb)
  {
    this.mScrollChangeCompatListener = paramblfb;
  }
  
  public void setOnScrollStateChangedListener(blfc paramblfc)
  {
    this.mScrollListener = paramblfc;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("Invalid overscroll mode " + paramInt);
    }
    Context localContext;
    if (paramInt != 2) {
      if ((this.mEdgeGlowTop == null) && (this.mEdgeEffectEnabled)) {
        localContext = getContext();
      }
    }
    try
    {
      this.mEdgeGlowTop = new blbm(localContext);
      this.mEdgeGlowBottom = new blbm(localContext);
      label90:
      this.mOverflingDistance = 2147483647;
      this.mOverscrollDistance = 2147483647;
      for (;;)
      {
        this.mOverScrollMode = paramInt;
        return;
        this.mEdgeGlowTop = null;
        this.mEdgeGlowBottom = null;
      }
    }
    catch (Throwable localThrowable)
    {
      break label90;
    }
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollingEnabled = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250L)
    {
      paramInt1 = getHeight();
      int i = this.mPaddingBottom;
      int j = this.mPaddingTop;
      i = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i - j));
      paramInt1 = this.mScrollY;
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, i));
      this.mScroller.a(this.mScrollX, paramInt1, 0, paramInt2 - paramInt1);
      invalidate();
    }
    for (;;)
    {
      this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.mScroller.a())
      {
        this.mScroller.a();
        if (this.mFlingStrictSpan != null) {
          finishSpan(this.mFlingStrictSpan);
        }
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  public final void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1 - this.mScrollX, paramInt2 - this.mScrollY);
  }
  
  public void updateScrollState(int paramInt)
  {
    updateScrollState(paramInt, false);
  }
  
  public void updateScrollState(int paramInt, boolean paramBoolean)
  {
    if ((this.mCurScrollState == paramInt) && (this.mLastIsFromCompute == paramBoolean)) {}
    do
    {
      return;
      this.mLastIsFromCompute = paramBoolean;
      this.mCurScrollState = paramInt;
    } while (this.mScrollListener == null);
    this.mScrollListener.a(this, this.mCurScrollState, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.ScrollView
 * JD-Core Version:    0.7.0.1
 */