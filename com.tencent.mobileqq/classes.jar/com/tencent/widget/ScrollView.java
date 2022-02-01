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
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.util.ReflectionUtil;
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
  private View mChildToScrollTo = null;
  private Drawable mContentBackgroundDrawable;
  int mCurScrollState = 0;
  private boolean mEdgeEffectEnabled = false;
  private EdgeEffect mEdgeGlowBottom;
  private EdgeEffect mEdgeGlowTop;
  @ViewDebug.ExportedProperty(category="layout")
  private boolean mFillViewport;
  private Object mFlingStrictSpan = null;
  private Drawable mForeground;
  private boolean mIsBeingDragged = false;
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
  ScrollView.OnScrollChangeListenerCompat mScrollChangeCompatListener;
  public int mScrollFlag = 0;
  ScrollView.OnScrollStateChangedListener mScrollListener;
  private Object mScrollStrictSpan = null;
  public OverScroller mScroller;
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
      if (getHeight() < i + getPaddingTop() + getPaddingBottom()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < paramInt3) && (paramInt1 >= 0))
    {
      if (paramInt2 + paramInt1 > paramInt3) {
        return paramInt3 - paramInt2;
      }
      return paramInt1;
    }
    return 0;
  }
  
  private void doScrollY(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.mSmoothScrollingEnabled)
      {
        smoothScrollBy(0, paramInt);
        return;
      }
      scrollBy(0, paramInt);
    }
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    recycleVelocityTracker();
    Object localObject = this.mEdgeGlowTop;
    if (localObject != null)
    {
      ((EdgeEffect)localObject).onRelease();
      this.mEdgeGlowBottom.onRelease();
    }
    localObject = this.mScrollStrictSpan;
    if (localObject != null) {
      finishSpan(localObject);
    }
    if (this.mScroller.isFinished())
    {
      updateScrollState(0);
      return;
    }
    updateScrollState(2);
  }
  
  @TargetApi(9)
  private Object enterCriticalSpan(String paramString)
  {
    if (DEBUG) {}
    try
    {
      if (VersionUtils.c())
      {
        paramString = StrictMode.class.getMethod("enterCriticalSpan", new Class[] { String.class }).invoke(null, new Object[] { paramString });
        return paramString;
      }
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private View findFocusableViewInBounds(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    int i1 = localArrayList.size();
    Object localObject2 = null;
    int k = 0;
    int j;
    for (int m = 0; k < i1; m = j)
    {
      View localView = (View)localArrayList.get(k);
      int n = localView.getTop();
      int i2 = localView.getBottom();
      Object localObject1 = localObject2;
      j = m;
      if (paramInt1 < i2)
      {
        localObject1 = localObject2;
        j = m;
        if (n < paramInt2)
        {
          int i;
          if ((paramInt1 < n) && (i2 < paramInt2)) {
            i = 1;
          } else {
            i = 0;
          }
          if (localObject2 == null)
          {
            localObject1 = localView;
            j = i;
          }
          else
          {
            if (((paramBoolean) && (n < localObject2.getTop())) || ((!paramBoolean) && (i2 > localObject2.getBottom()))) {
              n = 1;
            } else {
              n = 0;
            }
            if (m != 0)
            {
              localObject1 = localObject2;
              j = m;
              if (i == 0) {
                break label232;
              }
              localObject1 = localObject2;
              j = m;
              if (n == 0) {
                break label232;
              }
            }
            else
            {
              if (i != 0)
              {
                localObject1 = localView;
                j = 1;
                break label232;
              }
              localObject1 = localObject2;
              j = m;
              if (n == 0) {
                break label232;
              }
            }
            localObject1 = localView;
            j = m;
          }
        }
      }
      label232:
      k += 1;
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  private View findFocusableViewInMyBounds(boolean paramBoolean, int paramInt, View paramView)
  {
    int j = getVerticalFadingEdgeLength() / 2;
    int i = paramInt + j;
    paramInt = paramInt + getHeight() - j;
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
    int j = getChildCount();
    int i = 0;
    if (j > 0) {
      i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
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
    catch (Exception paramString)
    {
      label17:
      break label17;
    }
    return -1;
  }
  
  protected static int[] getStyleableValues(String paramString)
  {
    try
    {
      paramString = (int[])Class.forName("com.android.internal.R$styleable").getField(paramString).get(null);
      return paramString;
    }
    catch (Exception paramString)
    {
      label23:
      break label23;
    }
    return new int[0];
  }
  
  private float getVerticalScrollFactorWrap()
  {
    Object localObject = ReflectionUtil.a(this, "android.view.View", "offsetChildrenTopAndBottom", null, new Object[0]);
    if ((localObject instanceof Float)) {
      return ((Float)localObject).floatValue();
    }
    return 0.0F;
  }
  
  private boolean inChild(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      i = getScrollY();
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
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker == null)
    {
      this.mVelocityTracker = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.clear();
  }
  
  private void initScrollView()
  {
    this.mScroller = new OverScroller(getContext());
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
    this.mScroller.setFriction(0.005F);
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private boolean isOffScreen(View paramView)
  {
    return isWithinDeltaOfScreen(paramView, 0, getHeight()) ^ true;
  }
  
  private boolean isViewDescendantOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (isViewDescendantOf((View)paramView1, paramView2));
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
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mLastMotionY = paramMotionEvent.getY(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      paramMotionEvent = this.mVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
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
    int j = getScrollY();
    int i = j;
    if (getScrollY() > 0)
    {
      i = j;
      if (getScrollY() > paramInt2) {
        i = getScrollY() - paramInt2;
      }
    }
    if (paramInt1 * i < 0) {
      return paramInt1;
    }
    return (getHeight() - Math.abs(i)) * paramInt1 / getHeight() / 2;
  }
  
  private boolean scrollAndFocus(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getHeight();
    int i = getScrollY();
    j += i;
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 33) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    View localView = findFocusableViewInBounds(bool1, paramInt2, paramInt3);
    Object localObject = localView;
    if (localView == null) {
      localObject = this;
    }
    if ((paramInt2 >= i) && (paramInt3 <= j))
    {
      bool1 = bool2;
    }
    else
    {
      if (bool1) {
        paramInt2 -= i;
      } else {
        paramInt2 = paramInt3 - j;
      }
      doScrollY(paramInt2);
      bool1 = true;
    }
    if (localObject != findFocus()) {
      ((View)localObject).requestFocus(paramInt1);
    }
    return bool1;
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
    boolean bool;
    if (i != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      if (paramBoolean)
      {
        scrollBy(0, i);
        return bool;
      }
      smoothScrollBy(0, i);
    }
    return bool;
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
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
    }
    else
    {
      int i;
      if ((paramInt == 33) && (getScrollY() < j))
      {
        i = getScrollY();
      }
      else
      {
        i = j;
        if (paramInt == 130)
        {
          i = j;
          if (getChildCount() > 0)
          {
            int k = getChildAt(0).getBottom() - (getScrollY() + getHeight() - getPaddingBottom());
            i = j;
            if (k < j) {
              i = k;
            }
          }
        }
      }
      if (i == 0) {
        return false;
      }
      if (paramInt != 130) {
        i = -i;
      }
      doScrollY(i);
    }
    if ((localView1 != null) && (localView1.isFocused()) && (isOffScreen(localView1)))
    {
      paramInt = getDescendantFocusability();
      setDescendantFocusability(131072);
      requestFocus();
      setDescendantFocusability(paramInt);
    }
    return true;
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      int j = getScrollX();
      int k = getScrollY();
      int m = this.mScroller.getCurrX();
      int n = this.mScroller.getCurrY();
      if ((j != m) || (k != n))
      {
        int i1 = getScrollRange();
        int i = getOverScrollMode();
        if ((i != 0) && ((i != 1) || (i1 <= 0))) {
          i = 0;
        } else {
          i = 1;
        }
        if ((n >= 0) && (n <= i1)) {
          scrollTo(m, n);
        } else {
          overScrollBy(m - j, n - k, j, k, 0, i1, 0, this.mOverflingDistance, false);
        }
        onScrollChanged(getScrollX(), getScrollY(), j, k);
        if (i != 0)
        {
          localObject = this.mEdgeGlowTop;
          if ((localObject != null) && (n < 0) && (k >= 0)) {
            ((EdgeEffect)localObject).onAbsorb((int)this.mScroller.getCurrVelocity());
          } else if ((this.mEdgeGlowTop != null) && (n > i1) && (k <= i1)) {
            this.mEdgeGlowBottom.onAbsorb((int)this.mScroller.getCurrVelocity());
          }
        }
      }
      awakenScrollBars();
      postInvalidate();
      return;
    }
    Object localObject = this.mFlingStrictSpan;
    if (localObject != null) {
      finishSpan(localObject);
    }
    updateScrollState(0, true);
  }
  
  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    int i = getChildCount();
    int m = 0;
    if (i == 0) {
      return 0;
    }
    int n = getHeight();
    i = getScrollY();
    int k = i + n;
    int i1 = getVerticalFadingEdgeLength();
    int j = i;
    if (paramRect.top > 0) {
      j = i + i1;
    }
    i = k;
    if (paramRect.bottom < getChildAt(0).getHeight()) {
      i = k - i1;
    }
    if ((paramRect.bottom > i) && (paramRect.top > j))
    {
      if (paramRect.height() > n) {
        j = paramRect.top - j;
      } else {
        j = paramRect.bottom - i;
      }
      return Math.min(j + 0, getChildAt(0).getBottom() - i);
    }
    k = m;
    if (paramRect.top < j)
    {
      k = m;
      if (paramRect.bottom < i)
      {
        if (paramRect.height() > n) {
          i = 0 - (i - paramRect.bottom);
        } else {
          i = 0 - (j - paramRect.top);
        }
        k = Math.max(i, -getScrollY());
      }
    }
    return k;
  }
  
  protected int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  protected int computeVerticalScrollRange()
  {
    int j = getChildCount();
    int i = getHeight() - getPaddingBottom() - getPaddingTop();
    if (j == 0) {
      return i;
    }
    j = getChildAt(0).getBottom();
    int k = getScrollY();
    int m = Math.max(0, j - i);
    if (k < 0) {
      return j - k;
    }
    i = j;
    if (k > m) {
      i = j + (k - m);
    }
    return i;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.mContentBackgroundDrawable;
    if (localDrawable != null)
    {
      int k = getScrollX();
      int i = getScrollY();
      int j = getWidth();
      localDrawable.setBounds(0, 0, getWidth(), getHeight());
      if ((k | i) == 0)
      {
        localDrawable.draw(paramCanvas);
      }
      else if (i < 0)
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
          } else {
            localDrawable.setBounds(new Rect(0, i, j, 0));
          }
          localDrawable.draw(paramCanvas);
        }
      }
      else
      {
        paramCanvas.translate(k, i);
        localDrawable.draw(paramCanvas);
        paramCanvas.translate(-k, -i);
      }
    }
    super.dispatchDraw(paramCanvas);
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
      int i = getScrollY();
      int j;
      int k;
      int m;
      if (!this.mEdgeGlowTop.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth();
        m = getPaddingLeft();
        int n = getPaddingRight();
        paramCanvas.translate(getPaddingLeft(), Math.min(0, i));
        this.mEdgeGlowTop.setSize(k - m - n, getHeight());
        if (this.mEdgeGlowTop.draw(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(j);
      }
      if (!this.mEdgeGlowBottom.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth() - getPaddingLeft() - getPaddingRight();
        m = getHeight();
        paramCanvas.translate(-k + getPaddingLeft(), Math.max(getScrollRange(), i) + m);
        paramCanvas.rotate(180.0F, k, 0.0F);
        this.mEdgeGlowBottom.setSize(k, m);
        if (this.mEdgeGlowBottom.draw(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    this.mTempRect.setEmpty();
    boolean bool3 = canScroll();
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 130;
    if (!bool3)
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
          bool1 = bool2;
          if (paramKeyEvent != null)
          {
            bool1 = bool2;
            if (paramKeyEvent != this)
            {
              bool1 = bool2;
              if (paramKeyEvent.requestFocus(130)) {
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
    if (paramKeyEvent.getAction() == 0)
    {
      int j = paramKeyEvent.getKeyCode();
      if (j != 19)
      {
        if (j != 20)
        {
          if (j != 62) {
            return false;
          }
          if (paramKeyEvent.isShiftPressed()) {
            i = 33;
          }
          pageScroll(i);
          return false;
        }
        if (!paramKeyEvent.isAltPressed()) {
          return arrowScroll(130);
        }
        return fullScroll(130);
      }
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(33);
      }
      bool1 = fullScroll(33);
    }
    return bool1;
  }
  
  public void fling(int paramInt)
  {
    if (getChildCount() > 0)
    {
      int i = getHeight() - getPaddingBottom() - getPaddingTop();
      int j = getChildAt(0).getHeight();
      this.mScroller.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, 0, Math.max(0, j - i), 0, i / 4);
      if (this.mFlingStrictSpan == null) {
        this.mFlingStrictSpan = enterCriticalSpan("ScrollView-fling");
      }
      invalidate();
    }
  }
  
  public boolean fullScroll(int paramInt)
  {
    int i;
    if (paramInt == 130) {
      i = 1;
    } else {
      i = 0;
    }
    int j = getHeight();
    Object localObject = this.mTempRect;
    ((Rect)localObject).top = 0;
    ((Rect)localObject).bottom = j;
    if (i != 0)
    {
      i = getChildCount();
      if (i > 0)
      {
        localObject = getChildAt(i - 1);
        this.mTempRect.bottom = (((View)localObject).getBottom() + getPaddingBottom());
        localObject = this.mTempRect;
        ((Rect)localObject).top = (((Rect)localObject).bottom - j);
      }
    }
    return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)((getBottom() - getTop()) * 0.5F);
  }
  
  public int getOverScrollMode()
  {
    return this.mOverScrollMode;
  }
  
  public OverScroller getOverScroller()
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
    Object localObject = QQViewCompatUtil.b(this);
    if ((isHardwareAccelerated()) && ((localObject instanceof View))) {
      ((View)localObject).invalidate();
    }
  }
  
  public boolean isFillViewport()
  {
    return this.mFillViewport;
  }
  
  public boolean isScrollFinished()
  {
    OverScroller localOverScroller = this.mScroller;
    if (localOverScroller != null) {
      return localOverScroller.isFinished();
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
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin, 0));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.mScrollStrictSpan;
    if (localObject != null) {
      finishSpan(localObject);
    }
    localObject = this.mFlingStrictSpan;
    if (localObject != null) {
      finishSpan(localObject);
    }
  }
  
  @TargetApi(12)
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() == 8) && (!this.mIsBeingDragged))
    {
      float f = paramMotionEvent.getAxisValue(9);
      if (f != 0.0F)
      {
        int j = (int)(f * getVerticalScrollFactorWrap());
        int i = getScrollRange();
        int k = getScrollY();
        j = k - j;
        if (j < 0) {
          i = 0;
        } else if (j <= i) {
          i = j;
        }
        if (i != k)
        {
          super.scrollTo(getScrollX(), i);
          return true;
        }
      }
    }
    return super.onGenericMotionEvent(paramMotionEvent);
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    boolean bool;
    if (getScrollRange() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramAccessibilityEvent.setScrollable(bool);
    paramAccessibilityEvent.setScrollX(getScrollX());
    paramAccessibilityEvent.setScrollY(getScrollY());
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    boolean bool;
    if (getScrollRange() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramAccessibilityNodeInfo.setScrollable(bool);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingDragged)) {
      return true;
    }
    i &= 0xFF;
    float f1;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 6) {
              break label331;
            }
            onSecondaryPointerUp(paramMotionEvent);
            break label331;
          }
        }
        else
        {
          i = this.mActivePointerId;
          if (i == -1) {
            break label331;
          }
          i = paramMotionEvent.findPointerIndex(i);
          f1 = 0.0F;
          try
          {
            float f2 = paramMotionEvent.getY(i);
            f1 = f2;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if ((int)Math.abs(f1 - this.mLastMotionY) <= this.mTouchSlop) {
            break label331;
          }
          this.mIsBeingDragged = true;
          this.mLastMotionY = f1;
          initVelocityTrackerIfNotExists();
          this.mVelocityTracker.addMovement(paramMotionEvent);
          if (this.mScrollStrictSpan == null) {
            this.mScrollStrictSpan = enterCriticalSpan("ScrollView-scroll");
          }
          paramMotionEvent = getParent();
          if (paramMotionEvent == null) {
            break label331;
          }
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          break label331;
        }
      }
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      recycleVelocityTracker();
      if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
        invalidate();
      }
    }
    else
    {
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
        this.mIsBeingDragged = (this.mScroller.isFinished() ^ true);
        if ((this.mIsBeingDragged) && (this.mScrollStrictSpan == null)) {
          this.mScrollStrictSpan = enterCriticalSpan("ScrollView-scroll");
        }
      }
    }
    label331:
    return this.mIsBeingDragged;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mIsLayoutDirty = false;
    View localView = this.mChildToScrollTo;
    if ((localView != null) && (isViewDescendantOf(localView, this))) {
      scrollToChild(this.mChildToScrollTo);
    }
    this.mChildToScrollTo = null;
    scrollTo(getScrollX(), getScrollY());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.mFillViewport) {
      return;
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      return;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
      if (localView.getMeasuredHeight() < paramInt2)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
      }
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
    awakenScrollBars();
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    if (paramInt == 2)
    {
      i = 130;
    }
    else
    {
      i = paramInt;
      if (paramInt == 1) {
        i = 33;
      }
    }
    Object localObject = null;
    if (paramRect == null) {}
    try
    {
      localView = FocusFinder.getInstance().findNextFocus(this, null, i);
      localObject = localView;
    }
    catch (Exception localException)
    {
      View localView;
      localException.printStackTrace();
    }
    localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i);
    localObject = localView;
    if (localObject == null) {
      return false;
    }
    if (isOffScreen(localObject)) {
      return false;
    }
    return localObject.requestFocus(i, paramRect);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ScrollView.OnScrollChangeListenerCompat localOnScrollChangeListenerCompat = this.mScrollChangeCompatListener;
    if (localOnScrollChangeListenerCompat != null) {
      localOnScrollChangeListenerCompat.onScrollChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if (localView != null)
    {
      if (this == localView) {
        return;
      }
      if (isWithinDeltaOfScreen(localView, 0, paramInt4))
      {
        localView.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(localView, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
      }
    }
  }
  
  @TargetApi(8)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    initVelocityTrackerIfNotExists();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      float f;
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
              if ((i < paramMotionEvent.getPointerCount()) && (-1 != i))
              {
                this.mLastMotionY = paramMotionEvent.getY(i);
                return true;
              }
              if (QLog.isDevelopLevel())
              {
                QLog.i("ScrollView", 4, String.format("Pointer Index %d out of range!", new Object[] { Integer.valueOf(i) }));
                return true;
              }
            }
            else
            {
              i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
              this.mLastMotionY = paramMotionEvent.getY(i);
              this.mActivePointerId = paramMotionEvent.getPointerId(i);
              return true;
            }
          }
          else if ((this.mIsBeingDragged) && (getChildCount() > 0))
          {
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, this.mOverscrollDistance)) {
              invalidate();
            }
            this.mActivePointerId = -1;
            endDrag();
            return true;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i == -1) {
            return true;
          }
          f = paramMotionEvent.getY(i);
          int j = (int)(this.mLastMotionY - f);
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
            this.mLastMotionY = f;
            int m = getScrollX();
            int n = getScrollY();
            int k = getScrollRange();
            j = getOverScrollMode();
            if ((j != 0) && ((j != 1) || (k <= 0))) {
              j = 0;
            } else {
              j = 1;
            }
            if ((getScrollY() >= 0) && (getScrollY() <= k)) {
              break label403;
            }
            i = reviseOverScrollByTouch(i, k);
            label403:
            int i1 = getScrollY() + i;
            if ((i1 >= 0) && (i1 <= k)) {
              scrollTo(0, i1);
            } else {
              overScrollBy(0, i, 0, getScrollY(), 0, k, 0, this.mOverscrollDistance, true);
            }
            onScrollChanged(getScrollX(), getScrollY(), m, n);
            updateScrollState(1);
            if (j != 0)
            {
              paramMotionEvent = this.mEdgeGlowTop;
              if (paramMotionEvent != null)
              {
                j = n + i;
                if (j < 0)
                {
                  paramMotionEvent.onPull(i / getHeight());
                  if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                  }
                }
                else if (j > k)
                {
                  this.mEdgeGlowBottom.onPull(i / getHeight());
                  if (!this.mEdgeGlowTop.isFinished()) {
                    this.mEdgeGlowTop.onRelease();
                  }
                }
                paramMotionEvent = this.mEdgeGlowTop;
                if ((paramMotionEvent != null) && ((!paramMotionEvent.isFinished()) || (!this.mEdgeGlowBottom.isFinished())))
                {
                  invalidate();
                  return true;
                }
              }
            }
          }
        }
      }
      else if (this.mIsBeingDragged)
      {
        paramMotionEvent = this.mVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
        if (VersionUtils.b()) {
          f = paramMotionEvent.getYVelocity(this.mActivePointerId);
        } else {
          f = paramMotionEvent.getYVelocity();
        }
        i = (int)f;
        if (getChildCount() > 0) {
          if (Math.abs(i) > this.mMinimumVelocity) {
            fling(-i);
          } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
            invalidate();
          }
        }
        this.mActivePointerId = -1;
        endDrag();
        return true;
      }
    }
    else
    {
      if (getChildCount() == 0) {
        return false;
      }
      boolean bool = this.mScroller.isFinished() ^ true;
      this.mIsBeingDragged = bool;
      Object localObject;
      if (bool)
      {
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
      }
      if (!this.mScroller.isFinished())
      {
        this.mScroller.abortAnimation();
        localObject = this.mFlingStrictSpan;
        if (localObject != null) {
          finishSpan(localObject);
        }
      }
      this.mLastMotionY = paramMotionEvent.getY();
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
    }
    return true;
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int k = this.mOverScrollMode;
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
    k = paramInt3 + paramInt1;
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
    paramInt3 = -paramInt8;
    if (paramInt8 != 2147483647) {
      paramInt2 = paramInt8 + paramInt6;
    }
    if (this.mScrollFlag == 1) {
      paramInt3 = 0;
    }
    if (k > paramInt1) {}
    for (;;)
    {
      paramBoolean = true;
      break label232;
      if (k >= i) {
        break;
      }
      paramInt1 = i;
    }
    paramInt1 = k;
    paramBoolean = false;
    label232:
    if (paramInt4 > paramInt2) {}
    for (;;)
    {
      bool1 = true;
      break label261;
      if (paramInt4 >= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    }
    paramInt2 = paramInt4;
    boolean bool1 = false;
    label261:
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
  
  public boolean pageScroll(int paramInt)
  {
    int i;
    if (paramInt == 130) {
      i = 1;
    } else {
      i = 0;
    }
    int j = getHeight();
    if (i != 0)
    {
      this.mTempRect.top = (getScrollY() + j);
      i = getChildCount();
      if (i > 0)
      {
        localObject = getChildAt(i - 1);
        if (this.mTempRect.top + j > ((View)localObject).getBottom()) {
          this.mTempRect.top = (((View)localObject).getBottom() - j);
        }
      }
    }
    else
    {
      this.mTempRect.top = (getScrollY() - j);
      if (this.mTempRect.top < 0) {
        this.mTempRect.top = 0;
      }
    }
    Object localObject = this.mTempRect;
    ((Rect)localObject).bottom = (((Rect)localObject).top + j);
    return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.mIsLayoutDirty) {
      scrollToChild(paramView2);
    } else {
      this.mChildToScrollTo = paramView2;
    }
    super.requestChildFocus(paramView1, paramView2);
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
      paramInt1 = clamp(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
      paramInt2 = clamp(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
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
    this.mOverScrollHeaderShadow = getResources().getDrawable(2130841382);
  }
  
  public void setEdgeEffectEnabled(boolean paramBoolean)
  {
    if (this.mEdgeEffectEnabled != paramBoolean)
    {
      if (paramBoolean)
      {
        if ((this.mOverScrollMode != 2) && (this.mEdgeGlowTop == null))
        {
          Context localContext = getContext();
          this.mEdgeGlowTop = new EdgeEffect(localContext);
          this.mEdgeGlowBottom = new EdgeEffect(localContext);
        }
      }
      else
      {
        this.mEdgeGlowTop = null;
        this.mEdgeGlowBottom = null;
      }
      this.mEdgeEffectEnabled = paramBoolean;
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
    Drawable localDrawable = this.mForeground;
    if (localDrawable != paramDrawable)
    {
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(this.mForeground);
      }
      this.mForeground = paramDrawable;
      if (paramDrawable != null)
      {
        setWillNotDraw(false);
        paramDrawable.setCallback(this);
        if (paramDrawable.isStateful()) {
          paramDrawable.setState(getDrawableState());
        }
      }
      else
      {
        setWillNotDraw(true);
      }
      requestLayout();
      invalidate();
    }
  }
  
  public void setOnScrollChangeListenerCompat(ScrollView.OnScrollChangeListenerCompat paramOnScrollChangeListenerCompat)
  {
    this.mScrollChangeCompatListener = paramOnScrollChangeListenerCompat;
  }
  
  public void setOnScrollStateChangedListener(ScrollView.OnScrollStateChangedListener paramOnScrollStateChangedListener)
  {
    this.mScrollListener = paramOnScrollStateChangedListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    Object localObject;
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid overscroll mode ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    if (paramInt != 2) {
      if ((this.mEdgeGlowTop == null) && (this.mEdgeEffectEnabled)) {
        localObject = getContext();
      }
    }
    try
    {
      this.mEdgeGlowTop = new EdgeEffect((Context)localObject);
      this.mEdgeGlowBottom = new EdgeEffect((Context)localObject);
      label99:
      this.mOverflingDistance = 2147483647;
      this.mOverscrollDistance = 2147483647;
      break label126;
      this.mEdgeGlowTop = null;
      this.mEdgeGlowBottom = null;
      label126:
      this.mOverScrollMode = paramInt;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label99;
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
      int i = getPaddingBottom();
      int j = getPaddingTop();
      i = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i - j));
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt2 + paramInt1, i));
      this.mScroller.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1);
      invalidate();
    }
    else
    {
      if (!this.mScroller.isFinished())
      {
        this.mScroller.abortAnimation();
        Object localObject = this.mFlingStrictSpan;
        if (localObject != null) {
          finishSpan(localObject);
        }
      }
      scrollBy(paramInt1, paramInt2);
    }
    this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
  }
  
  public final void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY());
  }
  
  public void updateScrollState(int paramInt)
  {
    updateScrollState(paramInt, false);
  }
  
  public void updateScrollState(int paramInt, boolean paramBoolean)
  {
    if ((this.mCurScrollState == paramInt) && (this.mLastIsFromCompute == paramBoolean)) {
      return;
    }
    this.mLastIsFromCompute = paramBoolean;
    this.mCurScrollState = paramInt;
    ScrollView.OnScrollStateChangedListener localOnScrollStateChangedListener = this.mScrollListener;
    if (localOnScrollStateChangedListener != null) {
      localOnScrollStateChangedListener.onScrollStateChanged(this, this.mCurScrollState, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ScrollView
 * JD-Core Version:    0.7.0.1
 */