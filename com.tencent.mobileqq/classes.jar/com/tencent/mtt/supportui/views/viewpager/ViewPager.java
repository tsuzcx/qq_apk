package com.tencent.mtt.supportui.views.viewpager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mtt.supportui.utils.ViewCompatTool;
import com.tencent.mtt.supportui.views.ScrollChecker;
import com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager
  extends ViewGroup
  implements ScrollChecker.IScrollCheck
{
  static final float BASELINE_FLING_VELOCITY = 2500.0F;
  static final int CLOSE_ENOUGH = 2;
  static final Comparator<ViewPager.ItemInfo> COMPARATOR = new ViewPager.1();
  static final boolean DEBUG = false;
  static final int DEFAULT_GUTTER_SIZE = 25;
  static final int DEFAULT_OFFSCREEN_PAGES = 1;
  static final int DRAW_ORDER_DEFAULT = 0;
  static final int DRAW_ORDER_FORWARD = 1;
  static final int DRAW_ORDER_REVERSE = 2;
  static final float FLING_VELOCITY_INFLUENCE = 0.4F;
  static final int GALLERY_SCROLL_DURING = 500;
  static final int INVALID_POINTER = -1;
  static final int INVALID_SCREEN = -1;
  static final int[] LAYOUT_ATTRS = { 16842931 };
  static final int MAX_SETTLE_DURATION = 600;
  static final int MIN_DISTANCE_FOR_FLING = 25;
  static final int MIN_FLING_VELOCITY = 400;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  static final int SNAP_VELOCITY = 600;
  static final String TAG = "ViewPager";
  static final Interpolator sInterpolator = new ViewPager.2();
  static final ViewPager.ViewPositionComparator sPositionComparator = new ViewPager.ViewPositionComparator();
  protected boolean checkTouchSlop = true;
  boolean ignoreCheck = false;
  int mActivePointerId = -1;
  ViewPagerAdapter mAdapter;
  ViewPager.OnAdapterChangeListener mAdapterChangeListener;
  private int mAutoScrollCustomDuration = -1;
  int mBottomPageBounds;
  private boolean mCacheEnabled = false;
  boolean mCallPageChangedOnFirstLayout = false;
  boolean mCalledSuper;
  private boolean mCanScroll = true;
  private ViewPager.IDragChecker mChecker;
  int mChildHeightMeasureSpec;
  int mChildWidthMeasureSpec;
  int mCloseEnough;
  private boolean mConsumeNextTouchDown;
  int mCurItem;
  public int mCurrentScreen;
  Interpolator mCustomInterplater = null;
  int mDecorChildCount;
  int mDefaultGutterSize;
  private boolean mDisallowInterceptWhenDrag = true;
  int mDrawingOrder;
  ArrayList<View> mDrawingOrderedChildren;
  private boolean mEnableCatching = true;
  final Runnable mEndScrollRunnable = new ViewPager.3(this);
  int mExpectedAdapterCount;
  long mFakeDragBeginTime;
  boolean mFakeDragging;
  private boolean mFirstDatasetChanged = true;
  boolean mFirstLayout = true;
  float mFirstOffset = -3.402824E+038F;
  protected int mFlingDistance;
  private boolean mFocusSearchEnabled = true;
  boolean mForceUnableToDrag = false;
  int mGutterSize;
  boolean mInLayout;
  float mInitialMotionX;
  float mInitialMotionY;
  ViewPager.OnPageChangeListener mInternalPageChangeListener;
  ViewPager.PagerInvalidateListener mInvalidateListener;
  boolean mIsBeingDragged;
  public boolean mIsUnableToDrag;
  private boolean mIsVertical = false;
  final ArrayList<ViewPager.ItemInfo> mItems = new ArrayList();
  protected float mLastMotionX;
  protected float mLastMotionY;
  float mLastOffset = 3.4028235E+38F;
  private boolean mLayoutNeeded;
  boolean mLeftDragOutSizeEnable = true;
  ViewPager.QBGalleryGlideBlankListener mLeftGlideBlankListener;
  Drawable mMarginDrawable;
  private float mMaxOffset = 3.4028235E+38F;
  private int mMaxPage = 2147483647;
  protected int mMaximumVelocity;
  private float mMinOffset = 1.4E-45F;
  private int mMinPage = -2147483648;
  protected int mMinimumVelocity;
  protected boolean mNeedRepopulate = false;
  int mNextScreen = -1;
  ViewPager.PagerObserver mObserver;
  int mOffscreenPageLimit = 1;
  ViewPager.OnPageChangeListener mOnPageChangeListener;
  ViewPager.OnPageReadyListener mOnPageReadyListener;
  private int mOri = 2147483647;
  int mPageCount;
  int mPageMargin;
  ViewPager.PageTransformer mPageTransformer;
  protected boolean mPopulatePending;
  private boolean mReLayoutOnAttachToWindow = true;
  Parcelable mRestoredAdapterState = null;
  ClassLoader mRestoredClassLoader = null;
  int mRestoredCurItem = -1;
  boolean mRightDragOutSizeEnable = true;
  ViewPager.QBGalleryGlideBlankListener mRightGlideBlankListener;
  boolean mScrollEnabled = true;
  protected int mScrollState = 0;
  boolean mScrollToNeedNotify;
  protected Scroller mScroller;
  boolean mScrollingCacheEnabled;
  private ViewPager.PageSelectedListener mSelectedListener;
  Method mSetChildrenDrawingOrderEnabled;
  final ViewPager.ItemInfo mTempItem = new ViewPager.ItemInfo();
  final Rect mTempRect = new Rect();
  int mTopPageBounds;
  protected int mTouchSlop;
  private boolean mTouching;
  boolean mUpdateScreenNextCall;
  VelocityTracker mVelocityTracker;
  
  public ViewPager(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, false);
    this.mCustomInterplater = paramInterpolator;
    initViewPager();
  }
  
  public ViewPager(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.mIsVertical = paramBoolean;
    initViewPager();
  }
  
  private int findNextPosition(boolean paramBoolean)
  {
    if (getWidth() == 0) {
      return 0;
    }
    if (paramBoolean) {
      return getScrollX() / getWidth() + 1;
    }
    return getScrollX() / getWidth();
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          if (isGallery()) {}
          ViewPager.ItemInfo localItemInfo;
          do
          {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
            break;
            localItemInfo = infoForChild(localView);
          } while ((localItemInfo != null) && (localItemInfo.position == this.mCurItem));
        }
        i += 1;
      }
    }
    if ((k != 262144) || (j == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      if (paramArrayList != null) {
        paramArrayList.add(this);
      }
    }
  }
  
  ViewPager.ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    ViewPager.ItemInfo localItemInfo = new ViewPager.ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    localItemInfo.sizeFactor = this.mAdapter.getPageSize(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.mItems.size()))
    {
      this.mItems.add(paramInt2, localItemInfo);
      return localItemInfo;
    }
    this.mItems.add(localItemInfo);
    return localItemInfo;
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        ViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (ViewPager.LayoutParams)localLayoutParams;
    paramLayoutParams.isDecor |= paramView instanceof ViewPager.Decor;
    if (this.mInLayout)
    {
      if ((paramLayoutParams != null) && (paramLayoutParams.isDecor)) {
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
      paramLayoutParams.needsMeasure = true;
      addViewInLayout(paramView, paramInt, localLayoutParams);
    }
    else
    {
      super.addView(paramView, paramInt, localLayoutParams);
    }
    boolean bool;
    if (paramView.getVisibility() != 8) {
      bool = this.mScrollingCacheEnabled;
    } else {
      bool = false;
    }
    paramView.setDrawingCacheEnabled(bool);
  }
  
  public boolean arrowScroll(int paramInt)
  {
    if (!this.mFocusSearchEnabled) {
      return true;
    }
    Object localObject2 = findFocus();
    boolean bool = false;
    Object localObject3 = null;
    Object localObject1;
    int i;
    if (localObject2 == this)
    {
      localObject1 = localObject3;
    }
    else
    {
      if (localObject2 != null)
      {
        for (localObject1 = ((View)localObject2).getParent(); (localObject1 instanceof ViewGroup); localObject1 = ((ViewParent)localObject1).getParent()) {
          if (localObject1 == this)
          {
            i = 1;
            break label79;
          }
        }
        i = 0;
        label79:
        if (i == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localObject2.getClass().getSimpleName());
          for (localObject2 = ((View)localObject2).getParent();; localObject2 = ((ViewParent)localObject2).getParent())
          {
            localObject1 = localObject3;
            if (!(localObject2 instanceof ViewGroup)) {
              break;
            }
            localStringBuilder.append(" => ");
            localStringBuilder.append(localObject2.getClass().getSimpleName());
          }
        }
      }
      localObject1 = localObject2;
    }
    localObject2 = FocusFinder.getInstance().findNextFocus(this, (View)localObject1, paramInt);
    int j;
    if ((localObject2 != null) && (localObject2 != localObject1)) {
      if (paramInt == 17)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject2).left;
        j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject1).left;
        if ((localObject1 != null) && (i >= j)) {
          bool = pageLeft();
        } else {
          bool = ((View)localObject2).requestFocus();
        }
      }
    }
    for (;;)
    {
      break label344;
      if (paramInt == 66)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject2).left;
        j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject1).left;
        if ((localObject1 == null) || (i > j)) {
          break;
        }
        bool = pageRight();
        continue;
        if ((paramInt != 17) && (paramInt != 1))
        {
          if ((paramInt == 66) || (paramInt == 2)) {
            bool = pageRight();
          }
        }
        else {
          bool = pageLeft();
        }
      }
    }
    label344:
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  public boolean beginFakeDrag()
  {
    if (this.mIsBeingDragged) {
      return false;
    }
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    Object localObject = this.mVelocityTracker;
    if (localObject == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    } else {
      ((VelocityTracker)localObject).clear();
    }
    long l = SystemClock.uptimeMillis();
    localObject = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
    this.mVelocityTracker.addMovement((MotionEvent)localObject);
    ((MotionEvent)localObject).recycle();
    this.mFakeDragBeginTime = l;
    return true;
  }
  
  void calculatePageOffsets(ViewPager.ItemInfo paramItemInfo1, int paramInt, ViewPager.ItemInfo paramItemInfo2)
  {
    int m = this.mAdapter.getCount();
    int i = getClientSize();
    float f2;
    if (i > 0) {
      f2 = this.mPageMargin / i;
    } else {
      f2 = 0.0F;
    }
    if (paramItemInfo2 != null)
    {
      i = paramItemInfo2.position;
      if (i < paramItemInfo1.position)
      {
        j = 0;
        for (f1 = paramItemInfo2.offset + paramItemInfo2.sizeFactor + f2;; f1 = f3 + (paramItemInfo2.sizeFactor + f2))
        {
          k = i + 1;
          if ((k > paramItemInfo1.position) || (j >= this.mItems.size())) {
            break;
          }
          for (;;)
          {
            paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j);
            i = k;
            f3 = f1;
            if (k <= paramItemInfo2.position) {
              break;
            }
            i = k;
            f3 = f1;
            if (j >= this.mItems.size() - 1) {
              break;
            }
            j += 1;
          }
          while (i < paramItemInfo2.position)
          {
            f3 += this.mAdapter.getPageSize(i) + f2;
            i += 1;
          }
          paramItemInfo2.offset = f3;
        }
      }
      if (i > paramItemInfo1.position)
      {
        j = this.mItems.size() - 1;
        f1 = paramItemInfo2.offset;
        i -= 1;
        while ((i >= paramItemInfo1.position) && (j >= 0))
        {
          for (;;)
          {
            paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j);
            k = i;
            f3 = f1;
            if (i >= paramItemInfo2.position) {
              break;
            }
            k = i;
            f3 = f1;
            if (j <= 0) {
              break;
            }
            j -= 1;
          }
          while (k > paramItemInfo2.position)
          {
            f3 -= this.mAdapter.getPageSize(k) + f2;
            k -= 1;
          }
          f1 = f3 - (paramItemInfo2.sizeFactor + f2);
          paramItemInfo2.offset = f1;
          i = k - 1;
        }
      }
    }
    int k = this.mItems.size();
    float f3 = paramItemInfo1.offset;
    i = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0) {
      f1 = paramItemInfo1.offset;
    } else {
      f1 = -3.402824E+038F;
    }
    this.mFirstOffset = f1;
    int j = paramItemInfo1.position;
    m -= 1;
    if (j == m) {
      f1 = paramItemInfo1.offset + paramItemInfo1.sizeFactor - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.mLastOffset = f1;
    j = paramInt - 1;
    float f1 = f3;
    while (j >= 0)
    {
      paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j);
      while (i > paramItemInfo2.position)
      {
        f1 -= this.mAdapter.getPageSize(i) + f2;
        i -= 1;
      }
      f1 -= paramItemInfo2.sizeFactor + f2;
      paramItemInfo2.offset = f1;
      if (paramItemInfo2.position == 0) {
        this.mFirstOffset = f1;
      }
      j -= 1;
      i -= 1;
    }
    f1 = paramItemInfo1.offset + paramItemInfo1.sizeFactor + f2;
    j = paramItemInfo1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramItemInfo1 = (ViewPager.ItemInfo)this.mItems.get(i);
      while (paramInt < paramItemInfo1.position)
      {
        f1 += this.mAdapter.getPageSize(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.position == m) {
        this.mLastOffset = (paramItemInfo1.sizeFactor + f1 - 1.0F);
      }
      paramItemInfo1.offset = f1;
      f1 += paramItemInfo1.sizeFactor + f2;
      i += 1;
      paramInt += 1;
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (!this.mScrollEnabled) {
      return false;
    }
    return horizontalCanScroll(paramInt);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    if (!this.mScrollEnabled) {
      return false;
    }
    return verticalCanScroll(paramInt);
  }
  
  public void cancelDrag()
  {
    this.ignoreCheck = false;
    endDrag();
    this.mScrollState = 0;
  }
  
  void changePage()
  {
    this.mCurrentScreen = Math.max(getLeftBoundPageIndex(), Math.min(this.mNextScreen, getRightBoundPageIndex()));
    this.mNextScreen = -1;
  }
  
  protected boolean checkChildCanScroll(int paramInt1, int paramInt2, int paramInt3)
  {
    return ScrollChecker.canScroll(this, false, this.mIsVertical, paramInt1, paramInt2, paramInt3);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  protected boolean checkStartDrag(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.mChecker;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkStartDrag,deltaX=");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append(",deltaY=");
      ((StringBuilder)localObject).append(paramFloat2);
      Log.d("PageScroller", ((StringBuilder)localObject).toString());
      boolean bool = this.mIsVertical;
      paramBoolean2 = true;
      paramBoolean1 = true;
      if (bool)
      {
        if ((this.checkTouchSlop) || (paramFloat2 <= paramFloat1))
        {
          if ((paramFloat2 > this.mTouchSlop) && (paramFloat2 > paramFloat1)) {
            return true;
          }
          paramBoolean1 = false;
        }
        return paramBoolean1;
      }
      if (!this.checkTouchSlop)
      {
        paramBoolean1 = paramBoolean2;
        if (paramFloat1 > paramFloat2) {}
      }
      else
      {
        if ((paramFloat1 > this.mTouchSlop) && (paramFloat1 > paramFloat2)) {
          return true;
        }
        paramBoolean1 = false;
      }
      return paramBoolean1;
    }
    return ((ViewPager.IDragChecker)localObject).checkStartDrag(paramFloat1, paramFloat2, this.mTouchSlop);
  }
  
  public Object childByPosition(int paramInt)
  {
    ViewPager.ItemInfo localItemInfo = infoForPosition(paramInt);
    if (localItemInfo != null) {
      return localItemInfo.object;
    }
    return null;
  }
  
  void completeScroll(boolean paramBoolean)
  {
    if (this.mScrollState == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      setScrollingCacheEnabled(false);
      this.mScroller.abortAnimation();
      j = getScrollX();
      k = getScrollY();
      int m = this.mScroller.getCurrX();
      int n = this.mScroller.getCurrY();
      if ((j != m) || (k != n)) {
        scrollTo(m, n);
      }
    }
    this.mPopulatePending = false;
    int k = 0;
    int j = i;
    int i = k;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(i);
      if (localItemInfo.scrolling)
      {
        localItemInfo.scrolling = false;
        j = 1;
      }
      i += 1;
    }
    if (j != 0)
    {
      if (paramBoolean)
      {
        ViewCompatTool.postOnAnimation(this, this.mEndScrollRunnable);
        return;
      }
      this.mEndScrollRunnable.run();
    }
  }
  
  public void computeScroll()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("computeScroll,mNextScreen=");
    localStringBuilder.append(this.mNextScreen);
    Log.d("ViewPager", localStringBuilder.toString());
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      Log.d("ViewPager", "computeScroll not finished");
      int i = getScrollX();
      int m = getScrollY();
      int j = this.mScroller.getCurrX();
      int k = this.mScroller.getCurrY();
      if ((i != j) || (m != k))
      {
        scrollTo(j, k);
        if (this.mIsVertical) {
          i = k;
        } else {
          i = j;
        }
        if ((!pageScrolled(i)) && (!isGallery()))
        {
          this.mScroller.abortAnimation();
          if (this.mIsVertical) {
            scrollTo(0, k);
          } else {
            scrollTo(j, 0);
          }
        }
      }
      ViewCompatTool.postInvalidateOnAnimation(this);
      return;
    }
    if (this.mNextScreen != -1)
    {
      changePage();
      if (this.mScrollState == 0) {
        notifyScrollStateChanged(0, 0);
      }
      Log.d("ViewPager", "computeScroll changePage");
      setScrollState(0);
      return;
    }
    if (this.mScrollToNeedNotify)
    {
      this.mScrollToNeedNotify = false;
      if (this.mScrollState == 0) {
        notifyScrollStateChanged(0, 0);
      }
    }
    completeScroll(true);
  }
  
  public void consumeNextTouchDown()
  {
    this.mConsumeNextTouchDown = true;
  }
  
  void dataSetChanged()
  {
    int i4 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i4;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i4)) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.mFirstDatasetChanged)
    {
      this.mFirstDatasetChanged = false;
      this.mCurItem = this.mAdapter.getInitialItemIndex();
    }
    int j = this.mCurItem;
    int m = i;
    int i = j;
    int k = 0;
    j = 0;
    Object localObject;
    while (k < this.mItems.size())
    {
      localObject = (ViewPager.ItemInfo)this.mItems.get(k);
      int i3 = this.mAdapter.getItemPosition(((ViewPager.ItemInfo)localObject).object);
      int n;
      if (i3 != -1)
      {
        n = m;
        if (i3 != ((ViewPager.ItemInfo)localObject).position) {}
      }
      else
      {
        n = m;
        if (this.mAdapter.refreshItem(this, ((ViewPager.ItemInfo)localObject).position, ((ViewPager.ItemInfo)localObject).object) > 0)
        {
          ((ViewPager.ItemInfo)localObject).sizeFactor = this.mAdapter.getPageSize(((ViewPager.ItemInfo)localObject).position);
          n = 1;
        }
      }
      int i1;
      int i2;
      if (i3 == -1)
      {
        i1 = k;
        i2 = j;
        m = n;
        n = i;
      }
      else
      {
        if (i3 == -2)
        {
          this.mItems.remove(k);
          n = k - 1;
          m = j;
          if (j == 0)
          {
            this.mAdapter.startUpdate(this, this.mCurItem);
            m = 1;
          }
          this.mAdapter.destroyItem(this, ((ViewPager.ItemInfo)localObject).position, ((ViewPager.ItemInfo)localObject).object);
          k = n;
          j = m;
          if (this.mCurItem == ((ViewPager.ItemInfo)localObject).position)
          {
            i = Math.max(0, Math.min(this.mCurItem, i4 - 1));
            j = m;
            k = n;
          }
        }
        for (;;)
        {
          m = 1;
          i1 = k;
          i2 = j;
          n = i;
          break;
          i1 = k;
          i2 = j;
          m = n;
          n = i;
          if (((ViewPager.ItemInfo)localObject).position == i3) {
            break;
          }
          if (((ViewPager.ItemInfo)localObject).position == this.mCurItem) {
            i = i3;
          }
          ((ViewPager.ItemInfo)localObject).position = i3;
        }
      }
      k = i1 + 1;
      j = i2;
      i = n;
    }
    if (j != 0) {
      this.mAdapter.finishUpdate(this);
    }
    Collections.sort(this.mItems, COMPARATOR);
    if (m != 0)
    {
      k = getChildCount();
      j = 0;
      while (j < k)
      {
        localObject = (ViewPager.LayoutParams)getChildAt(j).getLayoutParams();
        if (!((ViewPager.LayoutParams)localObject).isDecor) {
          ((ViewPager.LayoutParams)localObject).sizeFactor = 0.0F;
        }
        j += 1;
      }
      setCurrentItemInternal(i, false, true);
      requestLayout();
    }
  }
  
  int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 <= 0) {
        paramInt1 += 1;
      }
    }
    else
    {
      float f;
      if (paramInt1 >= this.mCurItem) {
        f = 0.4F;
      } else {
        f = 0.6F;
      }
      paramInt1 = (int)(paramInt1 + paramFloat + f);
    }
    paramInt2 = paramInt1;
    if (this.mItems.size() > 0)
    {
      paramInt2 = this.mMinPage;
      ViewPager.ItemInfo localItemInfo;
      if (paramInt2 == -2147483648) {
        localItemInfo = (ViewPager.ItemInfo)this.mItems.get(0);
      } else {
        localItemInfo = infoForPosition(paramInt2);
      }
      paramInt2 = this.mMaxPage;
      Object localObject;
      if (paramInt2 == 2147483647)
      {
        localObject = this.mItems;
        localObject = (ViewPager.ItemInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      }
      else
      {
        localObject = infoForPosition(paramInt2);
      }
      paramInt2 = Math.max(localItemInfo.position, Math.min(paramInt1, ((ViewPager.ItemInfo)localObject).position));
    }
    return paramInt2;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        ViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    double d = paramFloat - 0.5F;
    Double.isNaN(d);
    return (float)Math.sin((float)(d * 0.47123891676382D));
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  void dumpItemInfos()
  {
    if (this.mItems != null)
    {
      int i = 0;
      while (i < this.mItems.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("index ");
        localStringBuilder.append(i);
        localStringBuilder.append("--->");
        localStringBuilder.append(((ViewPager.ItemInfo)this.mItems.get(i)).toString());
        Log.d("ViewPager", localStringBuilder.toString());
        i += 1;
      }
    }
  }
  
  void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      int j;
      if (paramBoolean) {
        j = 2;
      } else {
        j = 0;
      }
      getChildAt(i).setLayerType(j, null);
      i += 1;
    }
  }
  
  void endDrag()
  {
    Log.d("ViewPager", "endDrag");
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    this.checkTouchSlop = true;
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public void endFakeDrag()
  {
    if (this.mFakeDragging)
    {
      Object localObject = this.mVelocityTracker;
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
      int i = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
      this.mPopulatePending = true;
      int j = getClientWidth();
      int k = getScrollX();
      localObject = infoForCurrentScrollPosition();
      setCurrentItemInternal(determineTargetPage(((ViewPager.ItemInfo)localObject).position, (k / j - ((ViewPager.ItemInfo)localObject).offset) / ((ViewPager.ItemInfo)localObject).sizeFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, 0, i);
      endDrag();
      this.mFakeDragging = false;
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      int i = paramKeyEvent.getKeyCode();
      if (i != 21)
      {
        if (i != 22)
        {
          if (i != 61) {
            break label74;
          }
          if (paramKeyEvent.hasNoModifiers())
          {
            i = 2;
          }
          else
          {
            if (!paramKeyEvent.hasModifiers(1)) {
              break label74;
            }
            return arrowScroll(1);
          }
        }
        else
        {
          i = 66;
        }
      }
      else {
        i = 17;
      }
      return arrowScroll(i);
    }
    label74:
    return false;
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (this.mFakeDragging)
    {
      this.mLastMotionX += paramFloat;
      float f2 = getScrollX() - paramFloat;
      float f3 = getClientWidth();
      paramFloat = this.mFirstOffset * f3;
      float f1 = this.mLastOffset * f3;
      Object localObject1 = (ViewPager.ItemInfo)this.mItems.get(0);
      Object localObject2 = this.mItems;
      localObject2 = (ViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
      if (((ViewPager.ItemInfo)localObject1).position != 0) {
        paramFloat = ((ViewPager.ItemInfo)localObject1).offset * f3;
      }
      if (((ViewPager.ItemInfo)localObject2).position != this.mAdapter.getCount() - 1) {
        f1 = ((ViewPager.ItemInfo)localObject2).offset * f3;
      }
      if (f2 >= paramFloat)
      {
        paramFloat = f2;
        if (f2 > f1) {
          paramFloat = f1;
        }
      }
      f1 = this.mLastMotionX;
      int i = (int)paramFloat;
      this.mLastMotionX = (f1 + (paramFloat - i));
      scrollTo(i, getScrollY());
      pageScrolled(i);
      long l = SystemClock.uptimeMillis();
      localObject1 = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
      this.mVelocityTracker.addMovement((MotionEvent)localObject1);
      ((MotionEvent)localObject1).recycle();
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public void forceLayout()
  {
    super.forceLayout();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public ViewPagerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    paramInt1 = i;
    if (i >= this.mDrawingOrderedChildren.size()) {
      paramInt1 = this.mDrawingOrderedChildren.size() - 1;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < 0) {
      paramInt2 = 0;
    }
    return ((ViewPager.LayoutParams)((View)this.mDrawingOrderedChildren.get(paramInt2)).getLayoutParams()).childIndex;
  }
  
  Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    localRect.left = paramView.getLeft();
    localRect.right = paramView.getRight();
    localRect.top = paramView.getTop();
    localRect.bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      localRect.left += paramRect.getLeft();
      localRect.right += paramRect.getRight();
      localRect.top += paramRect.getTop();
      localRect.bottom += paramRect.getBottom();
    }
    return localRect;
  }
  
  public int getClientHeight()
  {
    return getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  int getClientSize()
  {
    if (this.mIsVertical) {
      return getClientHeight();
    }
    return getClientWidth();
  }
  
  int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  public int getCurrentItem()
  {
    return this.mCurItem;
  }
  
  public Object getCurrentItemView()
  {
    ViewPager.ItemInfo localItemInfo = infoForPosition(this.mCurItem);
    if (localItemInfo != null) {
      return localItemInfo.object;
    }
    return null;
  }
  
  public int getCurrentPage()
  {
    if (isGallery()) {
      return this.mCurrentScreen;
    }
    return this.mCurItem;
  }
  
  protected int getGutterSize()
  {
    return this.mGutterSize;
  }
  
  public float getLastMotionX()
  {
    return this.mLastMotionX;
  }
  
  public float getLastMotionY()
  {
    return this.mLastMotionY;
  }
  
  protected int getLeftBoundPageIndex()
  {
    return 0;
  }
  
  protected int getLeftEdge()
  {
    return 0;
  }
  
  public int getNextScreen()
  {
    return this.mNextScreen;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageCount()
  {
    if (isGallery()) {
      return getChildCount();
    }
    ViewPagerAdapter localViewPagerAdapter = this.mAdapter;
    if (localViewPagerAdapter == null) {
      return 0;
    }
    return localViewPagerAdapter.getCount();
  }
  
  public int getPageMargin()
  {
    return this.mPageMargin;
  }
  
  public ViewPager.PageSelectedListener getPageSelectedListener()
  {
    return this.mSelectedListener;
  }
  
  protected int getRightBoundPageIndex()
  {
    return getPageCount() - 1;
  }
  
  protected float getRightEdge()
  {
    int i = getPageCount();
    View localView = getChildAt(i);
    if (localView != null) {}
    for (i = localView.getRight() - getWidth();; i = (i - 1) * getWidth()) {
      return i;
    }
  }
  
  public int getTotalLength()
  {
    int i = 0;
    int j = 0;
    while (i < this.mAdapter.getCount())
    {
      float f = j;
      if (this.mIsVertical) {
        j = getHeight();
      } else {
        j = getWidth();
      }
      j = (int)(f + j * this.mAdapter.getPageSize(i));
      i += 1;
    }
    return j;
  }
  
  public boolean horizontalCanScroll(int paramInt)
  {
    boolean bool2 = this.mCanScroll;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    int i;
    int j;
    if (isGallery())
    {
      if (this.mCurrentScreen == 0) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      if (this.mCurrentScreen != getPageCount() - 1) {}
    }
    for (;;)
    {
      int k = 1;
      j = i;
      i = k;
      break;
      do
      {
        i = 0;
        break;
        if (this.mCurItem == 0) {
          i = 1;
        } else {
          i = 0;
        }
        j = i;
      } while (this.mCurItem != getPageCount() - 1);
    }
    if ((paramInt < 0) && ((this.mLeftDragOutSizeEnable) || (j == 0))) {
      j = 1;
    } else {
      j = 0;
    }
    if ((paramInt > 0) && ((this.mRightDragOutSizeEnable) || (i == 0))) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((j != 0) || (paramInt != 0)) {
      bool1 = true;
    }
    return bool1;
  }
  
  ViewPager.ItemInfo infoForAnyChild(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break label34;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        break;
      }
      paramView = (View)localViewParent;
    }
    return null;
    label34:
    return infoForChild(paramView);
  }
  
  ViewPager.ItemInfo infoForChild(View paramView)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localItemInfo.object)) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  ViewPager.ItemInfo infoForCurrentScrollPosition()
  {
    int j = getClientSize();
    float f1;
    if (j > 0)
    {
      if (this.mIsVertical) {
        i = getScrollY();
      } else {
        i = getScrollX();
      }
      f1 = i / j;
    }
    else
    {
      f1 = 0.0F;
    }
    float f2;
    if (j > 0) {
      f2 = this.mPageMargin / j;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    int i = 0;
    j = 1;
    int k = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(i);
      int m = i;
      ViewPager.ItemInfo localItemInfo1 = localItemInfo2;
      if (j == 0)
      {
        int n = localItemInfo2.position;
        k += 1;
        m = i;
        localItemInfo1 = localItemInfo2;
        if (n != k)
        {
          localItemInfo1 = this.mTempItem;
          localItemInfo1.offset = (f3 + f4 + f2);
          localItemInfo1.position = k;
          localItemInfo1.sizeFactor = this.mAdapter.getPageSize(localItemInfo1.position);
          m = i - 1;
        }
      }
      f3 = localItemInfo1.offset;
      f4 = localItemInfo1.sizeFactor;
      if ((j == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (m == this.mItems.size() - 1) {
          return localItemInfo1;
        }
        k = localItemInfo1.position;
        f4 = localItemInfo1.sizeFactor;
        i = m + 1;
        j = 0;
        localObject = localItemInfo1;
      }
      else
      {
        return localItemInfo1;
      }
    }
    return localObject;
  }
  
  ViewPager.ItemInfo infoForPosition(int paramInt)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(i);
      if (localItemInfo.position == paramInt) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  protected void initViewPager()
  {
    setWillNotDraw(false);
    ViewCompatTool.setDefaultLayotuDirection(this);
    setDescendantFocusability(262144);
    Context localContext = getContext();
    Object localObject = this.mCustomInterplater;
    if (localObject != null) {
      this.mScroller = new Scroller(localContext, (Interpolator)localObject);
    } else {
      this.mScroller = new Scroller(localContext, sInterpolator);
    }
    localObject = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
    int i = (int)(25.0F * f);
    this.mFlingDistance = i;
    this.mCloseEnough = ((int)(f * 2.0F));
    this.mDefaultGutterSize = i;
    getViewTreeObserver().addOnPreDrawListener(new ViewPager.4(this));
  }
  
  public void invalidate()
  {
    super.invalidate();
    ViewPager.PagerInvalidateListener localPagerInvalidateListener = this.mInvalidateListener;
    if (localPagerInvalidateListener != null) {
      localPagerInvalidateListener.onInvalidate();
    }
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  public boolean isFirstLayout()
  {
    return this.mFirstLayout;
  }
  
  public boolean isGallery()
  {
    return this.mAdapter == null;
  }
  
  protected boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < getGutterSize()) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - getGutterSize()) && (paramFloat2 < 0.0F));
  }
  
  public boolean isIdle()
  {
    return this.mScrollState == 0;
  }
  
  public boolean isScrollEnabled()
  {
    return this.mScrollEnabled;
  }
  
  public boolean isSettling()
  {
    return this.mScrollState == 2;
  }
  
  protected void notifyScrollStateChanged(int paramInt1, int paramInt2)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.mOnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt1, paramInt2);
    }
    localOnPageChangeListener = this.mInternalPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt1, paramInt2);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mReLayoutOnAttachToWindow)
    {
      this.mFirstLayout = true;
      requestLayout();
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation != this.mOri) {
      this.mLayoutNeeded = true;
    }
    this.mOri = paramConfiguration.orientation;
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mEndScrollRunnable);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f1 = this.mPageMargin;
      float f5 = m;
      float f2 = f1 / f5;
      Object localObject = this.mItems;
      int j = 0;
      localObject = (ViewPager.ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((ViewPager.ItemInfo)localObject).offset;
      int n = this.mItems.size();
      int i = ((ViewPager.ItemInfo)localObject).position;
      int i1 = ((ViewPager.ItemInfo)this.mItems.get(n - 1)).position;
      while (i < i1)
      {
        while ((i > ((ViewPager.ItemInfo)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (ViewPager.ItemInfo)((ArrayList)localObject).get(j);
        }
        float f3;
        if (i == ((ViewPager.ItemInfo)localObject).position)
        {
          f3 = (((ViewPager.ItemInfo)localObject).offset + ((ViewPager.ItemInfo)localObject).sizeFactor) * f5;
          f1 = ((ViewPager.ItemInfo)localObject).offset + ((ViewPager.ItemInfo)localObject).sizeFactor + f2;
        }
        else
        {
          float f4 = this.mAdapter.getPageSize(i);
          f3 = f1 + (f4 + f2);
          f4 = (f1 + f4) * f5;
          f1 = f3;
          f3 = f4;
        }
        int i2 = this.mPageMargin;
        if (i2 + f3 > k)
        {
          this.mMarginDrawable.setBounds((int)f3, this.mTopPageBounds, (int)(i2 + f3 + 0.5F), this.mBottomPageBounds);
          this.mMarginDrawable.draw(paramCanvas);
        }
        if (f3 > k + m) {
          return;
        }
        i += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 0) && (this.mConsumeNextTouchDown))
    {
      this.mConsumeNextTouchDown = false;
      return true;
    }
    if ((i != 3) && (i != 1))
    {
      if (i != 0) {
        if ((!this.mIsUnableToDrag) && (!this.mForceUnableToDrag))
        {
          if (this.mIsBeingDragged) {
            return true;
          }
        }
        else
        {
          Log.d("ViewPager", "onInterceptTouchEvent,resutl false due to mIsUnableToDrag");
          return false;
        }
      }
      float f1;
      ViewParent localViewParent;
      if (i != 0)
      {
        if (i != 2)
        {
          if (i == 6) {
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
        else
        {
          i = this.mActivePointerId;
          if (i == -1)
          {
            Log.d("PageScroller", "INVALID_POINTER");
          }
          else
          {
            i = paramMotionEvent.findPointerIndex(i);
            if (i != -1)
            {
              float f2 = paramMotionEvent.getX(i);
              f1 = f2 - this.mLastMotionX;
              float f4 = Math.abs(f1);
              float f3 = paramMotionEvent.getY(i);
              float f5 = Math.abs(f3 - this.mInitialMotionY);
              float f6 = this.mLastMotionY;
              float f7 = f3 - f6;
              float f8 = this.mLastMotionX;
              boolean bool1;
              if (f1 < 0.0F) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              boolean bool2;
              if (f7 < 0.0F) {
                bool2 = true;
              } else {
                bool2 = false;
              }
              if (this.mIsVertical)
              {
                if ((!this.mScrollEnabled) || ((f7 != 0.0F) && (!isGutterDrag(this.mLastMotionY, f7)) && (!this.ignoreCheck) && (checkChildCanScroll((int)f1, (int)f2, (int)f3))))
                {
                  Log.v("ViewPager", "checkChildCanScroll failed,return false");
                  this.mLastMotionX = f2;
                  this.mLastMotionY = f3;
                  this.mIsUnableToDrag = true;
                  return false;
                }
              }
              else {
                if ((!this.mScrollEnabled) || ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f1)) && (!this.ignoreCheck) && (checkChildCanScroll((int)f1, (int)f2, (int)f3)))) {
                  break label657;
                }
              }
              if (checkStartDrag(f4, f5, f8, f6, bool1, bool2))
              {
                if (f1 < 0.0F) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                if (onStartDrag(bool1))
                {
                  this.mIsBeingDragged = true;
                  setScrollState(1);
                  if (this.mDisallowInterceptWhenDrag)
                  {
                    localViewParent = getParent();
                    if (localViewParent != null) {
                      localViewParent.requestDisallowInterceptTouchEvent(true);
                    }
                  }
                  if (this.mIsVertical)
                  {
                    if (this.checkTouchSlop)
                    {
                      if (f7 > 0.0F) {
                        f1 = this.mInitialMotionY + this.mTouchSlop;
                      } else {
                        f1 = this.mInitialMotionY - this.mTouchSlop;
                      }
                      this.mLastMotionY = f1;
                    }
                    this.mLastMotionX = f2;
                  }
                  else
                  {
                    if (this.checkTouchSlop)
                    {
                      if (f1 > 0.0F) {
                        f1 = this.mInitialMotionX + this.mTouchSlop;
                      } else {
                        f1 = this.mInitialMotionX - this.mTouchSlop;
                      }
                      this.mLastMotionX = f1;
                    }
                    this.mLastMotionY = f3;
                  }
                  setScrollingCacheEnabled(true);
                }
              }
              else
              {
                if ((!this.mIsVertical) && (f5 > this.mTouchSlop)) {}
                while ((this.mIsVertical) && (f4 > this.mTouchSlop))
                {
                  this.mIsUnableToDrag = true;
                  break;
                }
              }
              if (this.mIsBeingDragged)
              {
                if (this.mIsVertical) {
                  f1 = f3;
                } else {
                  f1 = f2;
                }
                if (performDrag(f1))
                {
                  ViewCompatTool.postInvalidateOnAnimation(this);
                  break label892;
                  label657:
                  Log.v("ViewPager", "checkChildCanScroll failed,return false");
                  this.mLastMotionX = f2;
                  this.mLastMotionY = f3;
                  this.mIsUnableToDrag = true;
                  return false;
                }
              }
            }
          }
        }
      }
      else
      {
        this.ignoreCheck = false;
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mScroller.computeScrollOffset();
        if ((this.mEnableCatching) && (this.mScrollState == 2) && (((!this.mIsVertical) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough)) || ((this.mIsVertical) && (this.mScroller.getFinalY() - this.mScroller.getCurrY() > this.mCloseEnough))))
        {
          this.mScroller.abortAnimation();
          if (this.mDisallowInterceptWhenDrag)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
          }
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          setScrollState(1);
        }
        else if (!isGallery())
        {
          completeScroll(false);
          this.mIsBeingDragged = false;
        }
      }
      label892:
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      return this.mIsBeingDragged;
    }
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    this.ignoreCheck = false;
    this.checkTouchSlop = true;
    this.mActivePointerId = -1;
    paramMotionEvent = this.mVelocityTracker;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.recycle();
      this.mVelocityTracker = null;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getChildCount();
    int i5 = paramInt3 - paramInt1;
    int i4 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i6 = getScrollX();
    int n = 0;
    int i1 = 0;
    View localView;
    int m;
    ViewPager.LayoutParams localLayoutParams;
    while (i1 < i3)
    {
      localView = getChildAt(i1);
      j = paramInt2;
      int i2 = i;
      k = paramInt1;
      m = paramInt4;
      paramInt3 = n;
      if (localView != null)
      {
        j = paramInt2;
        i2 = i;
        k = paramInt1;
        m = paramInt4;
        paramInt3 = n;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
          j = paramInt2;
          i2 = i;
          k = paramInt1;
          m = paramInt4;
          paramInt3 = n;
          if (localLayoutParams.isDecor)
          {
            paramInt3 = localLayoutParams.gravity & 0x7;
            k = localLayoutParams.gravity & 0x70;
            if (paramInt3 != 1)
            {
              if (paramInt3 != 3)
              {
                if (paramInt3 != 5)
                {
                  paramInt3 = paramInt2;
                  j = paramInt2;
                }
                else
                {
                  paramInt3 = i5 - i - localView.getMeasuredWidth();
                  i += localView.getMeasuredWidth();
                  j = paramInt2;
                }
              }
              else
              {
                j = localView.getMeasuredWidth();
                paramInt3 = paramInt2;
                j += paramInt2;
              }
            }
            else
            {
              paramInt3 = Math.max((i5 - localView.getMeasuredWidth()) / 2, paramInt2);
              j = paramInt2;
            }
            if (k != 16)
            {
              if (k != 48)
              {
                if (k == 80)
                {
                  i2 = i4 - paramInt4 - localView.getMeasuredHeight();
                  k = paramInt1;
                  m = paramInt4;
                  paramInt2 = i2;
                  if (!localLayoutParams.takeHeightspace) {
                    break label406;
                  }
                  m = paramInt4 + localView.getMeasuredHeight();
                  k = paramInt1;
                  paramInt2 = i2;
                  break label406;
                }
              }
              else if (localLayoutParams.takeHeightspace)
              {
                k = localView.getMeasuredHeight();
                paramInt2 = paramInt1;
                k += paramInt1;
                m = paramInt4;
                break label406;
              }
              paramInt2 = paramInt1;
              k = paramInt1;
              m = paramInt4;
            }
            else
            {
              paramInt2 = Math.max((i4 - localView.getMeasuredHeight()) / 2, paramInt1);
              m = paramInt4;
              k = paramInt1;
            }
            label406:
            paramInt1 = paramInt3 + i6;
            localView.layout(paramInt1, paramInt2, localView.getMeasuredWidth() + paramInt1, localView.getMeasuredHeight() + paramInt2);
            paramInt3 = n + 1;
            i2 = i;
          }
        }
      }
      i1 += 1;
      paramInt2 = j;
      i = i2;
      paramInt1 = k;
      paramInt4 = m;
      n = paramInt3;
    }
    if (this.mIsVertical) {
      paramInt3 = i4 - paramInt1 - paramInt4;
    } else {
      paramInt3 = i5 - paramInt2 - i;
    }
    if (this.mAdapter == null)
    {
      k = getChildCount();
      paramInt2 = 0;
      for (i = 0; paramInt2 < k; i = j)
      {
        localView = getChildAt(paramInt2);
        j = i;
        if (localView != null)
        {
          j = i;
          if (localView.getVisibility() != 8)
          {
            j = i;
            if (!((ViewPager.LayoutParams)localView.getLayoutParams()).isDecor)
            {
              j = i + paramInt3;
              localView.layout(i, paramInt1, j, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        paramInt2 += 1;
      }
    }
    int k = 0;
    int j = i3;
    while (k < j)
    {
      localView = getChildAt(k);
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.isDecor)
        {
          ViewPager.ItemInfo localItemInfo = infoForChild(localView);
          if (localItemInfo != null)
          {
            float f = paramInt3;
            m = (int)(localItemInfo.offset * f);
            if (this.mIsVertical) {
              m += paramInt1;
            } else {
              m += paramInt2;
            }
            if (localLayoutParams.needsMeasure)
            {
              localLayoutParams.needsMeasure = false;
              if (!this.mIsVertical)
              {
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f * localLayoutParams.sizeFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - paramInt1 - paramInt4, 1073741824));
              }
              else
              {
                i1 = View.MeasureSpec.makeMeasureSpec((int)(f * localLayoutParams.sizeFactor), 1073741824);
                localView.measure(View.MeasureSpec.makeMeasureSpec(i5 - paramInt2 - i, 1073741824), i1);
              }
            }
            if (this.mIsVertical) {
              localView.layout(paramInt2, m, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + m);
            } else {
              localView.layout(m, paramInt1, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
      }
      k += 1;
    }
    this.mTopPageBounds = paramInt1;
    this.mBottomPageBounds = (i4 - paramInt4);
    this.mDecorChildCount = n;
    this.mPageCount = (getChildCount() - this.mDecorChildCount);
    if ((this.mFirstLayout) || (this.mLayoutNeeded))
    {
      this.mLayoutNeeded = false;
      if (!isGallery()) {
        scrollToItem(this.mCurItem, false, 0, false);
      } else {
        scrollTo(getCurrentPage() * getWidth(), getScrollY());
      }
    }
    if (this.mUpdateScreenNextCall)
    {
      scrollTo(getCurrentPage() * getWidth(), getScrollY());
      this.mUpdateScreenNextCall = false;
    }
    this.mFirstLayout = false;
  }
  
  boolean onLeftGlideBlank()
  {
    ViewPager.QBGalleryGlideBlankListener localQBGalleryGlideBlankListener = this.mLeftGlideBlankListener;
    return (localQBGalleryGlideBlankListener != null) && (localQBGalleryGlideBlankListener.onGlideBlank(true));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = 0;
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredHeight();
    paramInt2 = getMeasuredWidth();
    if (this.mIsVertical) {
      paramInt1 /= 10;
    } else {
      paramInt1 = paramInt2 / 10;
    }
    this.mGutterSize = Math.min(paramInt1, this.mDefaultGutterSize);
    int j = paramInt2 - getPaddingLeft() - getPaddingRight();
    paramInt1 = getMeasuredHeight();
    paramInt2 = getPaddingTop();
    int i = getPaddingBottom();
    int i4 = getChildCount();
    paramInt2 = paramInt1 - paramInt2 - i;
    int k = 0;
    View localView;
    ViewPager.LayoutParams localLayoutParams;
    for (;;)
    {
      i = 1;
      int m = 1073741824;
      if (k >= i4) {
        break;
      }
      localView = getChildAt(k);
      paramInt1 = paramInt2;
      if (localView != null)
      {
        paramInt1 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
          paramInt1 = paramInt2;
          if (localLayoutParams != null)
          {
            paramInt1 = paramInt2;
            if (localLayoutParams.isDecor)
            {
              int i1 = localLayoutParams.gravity & 0x7;
              paramInt1 = localLayoutParams.gravity & 0x70;
              int n;
              if ((paramInt1 != 48) && (paramInt1 != 80)) {
                n = 0;
              } else {
                n = 1;
              }
              paramInt1 = i;
              if (i1 != 3) {
                if (i1 == 5) {
                  paramInt1 = i;
                } else {
                  paramInt1 = 0;
                }
              }
              i = -2147483648;
              if (n != 0)
              {
                paramInt1 = -2147483648;
                i = 1073741824;
              }
              else if (paramInt1 != 0)
              {
                paramInt1 = 1073741824;
              }
              else
              {
                paramInt1 = -2147483648;
              }
              int i2;
              if (localLayoutParams.width != -2)
              {
                if (localLayoutParams.width != -1) {
                  i = localLayoutParams.width;
                } else {
                  i = j;
                }
                i1 = 1073741824;
                i2 = i;
              }
              else
              {
                i2 = j;
                i1 = i;
              }
              if (localLayoutParams.height != -2)
              {
                paramInt1 = m;
                if (localLayoutParams.height != -1)
                {
                  i = localLayoutParams.height;
                  paramInt1 = m;
                  break label351;
                }
              }
              i = paramInt2;
              label351:
              localView.measure(View.MeasureSpec.makeMeasureSpec(i2, i1), View.MeasureSpec.makeMeasureSpec(i, paramInt1));
              paramInt1 = paramInt2;
              if (n != 0)
              {
                paramInt1 = paramInt2;
                if (localLayoutParams.takeHeightspace) {
                  paramInt1 = paramInt2 - localView.getMeasuredHeight();
                }
              }
            }
          }
        }
      }
      k += 1;
      paramInt2 = paramInt1;
    }
    this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
    this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.mInLayout = true;
    populate();
    this.mInLayout = false;
    k = getChildCount();
    paramInt1 = i3;
    while (paramInt1 < k)
    {
      localView = getChildAt(paramInt1);
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!localLayoutParams.isDecor))
        {
          if (isGallery()) {}
          for (i = this.mChildWidthMeasureSpec;; i = View.MeasureSpec.makeMeasureSpec((int)(j * localLayoutParams.sizeFactor), 1073741824))
          {
            localView.measure(i, this.mChildHeightMeasureSpec);
            break;
            if (this.mIsVertical)
            {
              i = View.MeasureSpec.makeMeasureSpec((int)(paramInt2 * localLayoutParams.sizeFactor), 1073741824);
              localView.measure(this.mChildWidthMeasureSpec, i);
              break;
            }
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onOverScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (this.mIsVertical ? ((paramInt4 == 0) && (paramInt2 < 0)) || ((paramInt4 == paramInt6) && (paramInt2 > 0)) : ((paramInt3 == 0) && (paramInt1 < 0)) || ((paramInt3 == paramInt5) && (paramInt1 > 0))) {
      onOverScrollSuccess();
    }
    return true;
  }
  
  public void onOverScrollSuccess()
  {
    this.mIsUnableToDrag = false;
    this.ignoreCheck = true;
  }
  
  public boolean onOverScrollWithNativeContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (((paramInt3 == 0) && (paramInt1 < 0)) || ((paramInt3 == paramInt5) && (paramInt1 > 0))) {
      this.mIsUnableToDrag = false;
    }
    return true;
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int j;
    int i;
    if (this.mDecorChildCount > 0)
    {
      int i4 = getScrollX();
      int i5 = getScrollY();
      j = getPaddingLeft();
      int k = getPaddingRight();
      i = getPaddingTop();
      getPaddingBottom();
      int i6 = getWidth();
      int i7 = getHeight();
      int i8 = getChildCount();
      int i2 = 0;
      while (i2 < i8)
      {
        localObject = getChildAt(i2);
        ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)((View)localObject).getLayoutParams();
        int m;
        int n;
        int i1;
        if (!localLayoutParams.isDecor)
        {
          m = j;
          n = i;
          i1 = k;
        }
        else
        {
          int i3;
          if (!this.mIsVertical)
          {
            m = localLayoutParams.gravity & 0x7;
            if (m != 1)
            {
              if (m != 3)
              {
                if (m != 5)
                {
                  m = j;
                }
                else
                {
                  m = i6 - k - ((View)localObject).getMeasuredWidth();
                  k += ((View)localObject).getMeasuredWidth();
                }
              }
              else
              {
                n = ((View)localObject).getWidth() + j;
                m = j;
                j = n;
              }
            }
            else {
              m = Math.max((i6 - ((View)localObject).getMeasuredWidth()) / 2, j);
            }
            i3 = m + i4 - ((View)localObject).getLeft();
            m = j;
            n = i;
            i1 = k;
            if (i3 == 0) {}
          }
          else
          {
            for (m = i3;; m = i3)
            {
              ((View)localObject).offsetLeftAndRight(m);
              m = j;
              n = i;
              i1 = k;
              break;
              m = localLayoutParams.gravity & 0x70;
              if (m != 16)
              {
                if (m != 48)
                {
                  if (m != 80)
                  {
                    m = i;
                  }
                  else
                  {
                    m = i7 - i - ((View)localObject).getMeasuredHeight();
                    ((View)localObject).getMeasuredHeight();
                  }
                }
                else
                {
                  n = ((View)localObject).getHeight() + i;
                  m = i;
                  i = n;
                }
              }
              else {
                m = Math.max((i7 - ((View)localObject).getMeasuredHeight()) / 2, i);
              }
              i3 = m + i5 - ((View)localObject).getTop();
              m = j;
              n = i;
              i1 = k;
              if (i3 == 0) {
                break;
              }
            }
          }
        }
        i2 += 1;
        j = m;
        i = n;
        k = i1;
      }
    }
    Object localObject = this.mOnPageChangeListener;
    if (localObject != null) {
      ((ViewPager.OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.mInternalPageChangeListener;
    if (localObject != null) {
      ((ViewPager.OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mPageTransformer != null)
    {
      if (!this.mIsVertical)
      {
        i = getScrollX();
        j = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          localObject = getChildAt(paramInt1);
          if (!((ViewPager.LayoutParams)((View)localObject).getLayoutParams()).isDecor)
          {
            if (this.mIsVertical)
            {
              paramFloat = ((View)localObject).getTop() - getScrollY();
              paramInt2 = getClientHeight();
            }
            else
            {
              paramFloat = ((View)localObject).getLeft() - i;
              paramInt2 = getClientWidth();
            }
            paramFloat /= paramInt2;
            this.mPageTransformer.transformPage((View)localObject, paramFloat);
          }
          paramInt1 += 1;
        }
      }
      paramInt2 = getScrollY();
      i = getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localObject = getChildAt(paramInt1);
        if (!((ViewPager.LayoutParams)((View)localObject).getLayoutParams()).isDecor)
        {
          paramFloat = (((View)localObject).getTop() - paramInt2) / getClientHeight();
          this.mPageTransformer.transformPage((View)localObject, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    this.mCalledSuper = true;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i = getChildCount();
    int k = -1;
    int j;
    if ((paramInt & 0x2) != 0)
    {
      k = i;
      i = 0;
      j = 1;
    }
    else
    {
      i -= 1;
      j = -1;
    }
    while (i != k)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        ViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i += j;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    ViewPagerAdapter localViewPagerAdapter = this.mAdapter;
    if (localViewPagerAdapter != null)
    {
      localViewPagerAdapter.restoreState(paramParcelable.adapterState, paramParcelable.loader);
      setCurrentItemInternal(paramParcelable.position, false, true);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.adapterState;
    this.mRestoredClassLoader = paramParcelable.loader;
  }
  
  boolean onRightGlideBlank()
  {
    ViewPager.QBGalleryGlideBlankListener localQBGalleryGlideBlankListener = this.mRightGlideBlankListener;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localQBGalleryGlideBlankListener != null)
    {
      bool1 = bool2;
      if (localQBGalleryGlideBlankListener.onGlideBlank(false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    ViewPagerAdapter localViewPagerAdapter = this.mAdapter;
    if (localViewPagerAdapter != null) {
      localSavedState.adapterState = localViewPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
    try
    {
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mLastMotionY = paramMotionEvent.getY(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      label55:
      paramMotionEvent = this.mVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
      return;
    }
    catch (Exception paramMotionEvent)
    {
      break label55;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      recomputeScrollPosition(paramInt1, paramInt3, 0, 0);
    }
  }
  
  protected boolean onStartDrag(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = -1) {
      return horizontalCanScroll(i);
    }
  }
  
  public void onTabPressed(int paramInt)
  {
    ViewPager.PageSelectedListener localPageSelectedListener = this.mSelectedListener;
    if (localPageSelectedListener != null) {
      localPageSelectedListener.onPageSelected(true, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mFakeDragging) {
      return true;
    }
    bool = this.mForceUnableToDrag;
    k = 0;
    if (bool) {
      return false;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 5)
            {
              if (i != 6)
              {
                i = k;
                break label1138;
              }
              onSecondaryPointerUp(paramMotionEvent);
            }
          }
        }
      }
    }
    try
    {
      this.mLastMotionX = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
      this.mLastMotionY = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId));
      i = k;
    }
    catch (Exception paramMotionEvent)
    {
      try
      {
        this.mLastMotionX = paramMotionEvent.getX(i);
        this.mLastMotionY = paramMotionEvent.getY(i);
        i = paramMotionEvent.getPointerId(i);
        this.mActivePointerId = i;
        i = k;
        break label1138;
        i = k;
        if (!this.mIsBeingDragged) {
          break label1138;
        }
        this.ignoreCheck = false;
        if (!isGallery()) {
          break label239;
        }
        upAction(0, paramMotionEvent);
        break label250;
        scrollToItem(this.mCurItem, true, 0, false);
        this.mActivePointerId = -1;
        endDrag();
        i = k;
        break label1138;
        if (this.mIsBeingDragged) {
          break label653;
        }
        i = this.mActivePointerId;
        if (i != -1) {
          break label302;
        }
        Log.d("PageScroller,onTouch", "INVALID_POINTER");
        i = k;
        break label1138;
        i = paramMotionEvent.findPointerIndex(i);
        if (i != -1) {
          break label323;
        }
        i = k;
      }
      catch (Exception paramMotionEvent)
      {
        try
        {
          f2 = paramMotionEvent.getX(i);
        }
        catch (Exception paramMotionEvent)
        {
          try
          {
            do
            {
              f1 = paramMotionEvent.getY(i);
              break label350;
              f1 = 0.0F;
              f3 = 0.0F;
              f2 = f1;
              f1 = f3;
              f3 = Math.abs(f2 - this.mLastMotionX);
              float f4 = Math.abs(f1 - this.mLastMotionY);
              if (this.mIsVertical)
              {
                if ((f4 <= this.mTouchSlop) || (f4 <= f3) || (!this.mScrollEnabled)) {
                  break label653;
                }
                if (f1 - this.mLastMotionY < 0.0F) {
                  bool = true;
                } else {
                  bool = false;
                }
                if (!onStartDrag(bool)) {
                  break label653;
                }
                this.mIsBeingDragged = true;
                f3 = this.mInitialMotionY;
                if (f1 - f3 > 0.0F) {
                  f1 = f3 + this.mTouchSlop;
                } else {
                  f1 = f3 - this.mTouchSlop;
                }
                this.mLastMotionY = f1;
                this.mLastMotionX = f2;
                setScrollState(1);
                if (!this.mDisallowInterceptWhenDrag) {
                  break label648;
                }
                localObject = getParent();
                if (localObject == null) {
                  break label648;
                }
              }
              else
              {
                if ((f3 <= this.mTouchSlop) || (f3 <= f4) || (!this.mScrollEnabled)) {
                  break label653;
                }
                if (f2 - this.mLastMotionX < 0.0F) {
                  bool = true;
                } else {
                  bool = false;
                }
                if (!onStartDrag(bool)) {
                  break label653;
                }
                this.mIsBeingDragged = true;
                f3 = this.mInitialMotionX;
                if (f2 - f3 > 0.0F) {
                  f2 = f3 + this.mTouchSlop;
                } else {
                  f2 = f3 - this.mTouchSlop;
                }
                this.mLastMotionX = f2;
                this.mLastMotionY = f1;
                setScrollState(1);
                if (!this.mDisallowInterceptWhenDrag) {
                  break label648;
                }
                localObject = getParent();
                if (localObject == null) {
                  break label648;
                }
              }
              ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
              setScrollingCacheEnabled(true);
              i = k;
              if (!this.mIsBeingDragged) {
                break;
              }
              i = this.mActivePointerId;
            } while (i == -1);
            i = paramMotionEvent.findPointerIndex(i);
            if (i != -1) {
              break label700;
            }
            i = k;
            break label1138;
            if (!this.mIsVertical) {
              break label724;
            }
            for (f1 = paramMotionEvent.getY(i);; f1 = paramMotionEvent.getX(i))
            {
              bool = performDrag(f1);
              break;
            }
          }
          catch (Exception paramMotionEvent)
          {
            try
            {
              if (!this.mIsUnableToDrag) {
                break label759;
              }
              paramMotionEvent = getParent();
              if (paramMotionEvent == null) {
                break label757;
              }
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              return false;
              i = bool | false;
              break label1138;
              i = k;
              if (!this.mIsBeingDragged) {
                break label1138;
              }
              localObject = this.mVelocityTracker;
              if (localObject == null) {
                break label840;
              }
              ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
              if (!this.mIsVertical) {
                break label823;
              }
              f1 = ((VelocityTracker)localObject).getYVelocity(this.mActivePointerId);
              break label833;
              f1 = ((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
              i = (int)f1;
              break label843;
              i = 0;
              if (!isGallery()) {
                break label860;
              }
              upAction(i, paramMotionEvent);
              break label1019;
              this.mPopulatePending = true;
              n = getClientSize();
              if (!this.mIsVertical) {
                break label887;
              }
              j = getScrollY();
              break label893;
              j = getScrollX();
              localObject = infoForCurrentScrollPosition();
              if (localObject == null) {
                break label1019;
              }
            }
            catch (Exception paramMotionEvent)
            {
              try
              {
                for (;;)
                {
                  int n;
                  int m = ((ViewPager.ItemInfo)localObject).position;
                  f1 = (j / n - ((ViewPager.ItemInfo)localObject).offset) / ((ViewPager.ItemInfo)localObject).sizeFactor;
                  int j = paramMotionEvent.findPointerIndex(this.mActivePointerId);
                  f2 = paramMotionEvent.getX(j);
                  float f3 = paramMotionEvent.getY(j);
                  if (this.mIsVertical) {
                    j = (int)(f3 - this.mInitialMotionY);
                  } else {
                    j = (int)(f2 - this.mInitialMotionX);
                  }
                  j = determineTargetPage(m, f1, i, j);
                  this.mTouching = true;
                  setCurrentItemInternal(j, true, true, 0, i);
                  this.mTouching = false;
                  Log.d("ViewPager", "ACTION_UP");
                  this.mActivePointerId = -1;
                  this.ignoreCheck = false;
                }
                if (!this.mEnableCatching) {
                  break label1093;
                }
                Object localObject = this.mScroller;
                if ((localObject == null) || (((Scroller)localObject).isFinished())) {
                  break label1093;
                }
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                setScrollState(1);
                this.ignoreCheck = false;
              }
              catch (ArrayIndexOutOfBoundsException|IllegalArgumentException paramMotionEvent)
              {
                try
                {
                  for (;;)
                  {
                    float f2;
                    float f1 = paramMotionEvent.getX();
                    this.mInitialMotionX = f1;
                    this.mLastMotionX = f1;
                    f1 = paramMotionEvent.getY();
                    this.mInitialMotionY = f1;
                    this.mLastMotionY = f1;
                    i = paramMotionEvent.getPointerId(0);
                    continue;
                    for (;;)
                    {
                      if (i != 0) {
                        ViewCompatTool.postInvalidateOnAnimation(this);
                      }
                      return true;
                      paramMotionEvent = paramMotionEvent;
                      i = k;
                    }
                    localException1 = localException1;
                    continue;
                    localException2 = localException2;
                    continue;
                    localException3 = localException3;
                    f1 = f2;
                    continue;
                    paramMotionEvent = paramMotionEvent;
                  }
                  paramMotionEvent = paramMotionEvent;
                }
                catch (Exception localException4)
                {
                  break label1128;
                }
              }
            }
          }
        }
      }
    }
    i = paramMotionEvent.getActionIndex();
  }
  
  boolean pageLeft()
  {
    int i = this.mCurItem;
    if (i > 0)
    {
      setCurrentItem(i - 1, true);
      return true;
    }
    return false;
  }
  
  boolean pageRight()
  {
    ViewPagerAdapter localViewPagerAdapter = this.mAdapter;
    if ((localViewPagerAdapter != null) && (this.mCurItem < localViewPagerAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    }
    return false;
  }
  
  protected boolean pageScrolled(int paramInt)
  {
    int i = getClientSize();
    int j = this.mPageMargin;
    Object localObject = this.mItems;
    if ((localObject != null) && (((ArrayList)localObject).size() == 0))
    {
      this.mCalledSuper = false;
      f1 = paramInt / i;
      paramInt = this.mCurrentScreen;
      f1 -= paramInt;
      onPageScrolled(paramInt, f1, (int)((j + i) * f1));
      if (this.mCalledSuper) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    localObject = infoForCurrentScrollPosition();
    float f2 = this.mPageMargin;
    float f1 = i;
    f2 /= f1;
    i = ((ViewPager.ItemInfo)localObject).position;
    f1 = (paramInt / f1 - ((ViewPager.ItemInfo)localObject).offset) / (((ViewPager.ItemInfo)localObject).sizeFactor + f2);
    this.mCalledSuper = false;
    onPageScrolled(i, f1, 0);
    if (this.mCalledSuper) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  protected boolean performDrag(float paramFloat)
  {
    boolean bool1 = this.mIsVertical;
    boolean bool3 = false;
    boolean bool2 = false;
    int j;
    int i;
    float f1;
    float f2;
    float f3;
    float f4;
    Object localObject1;
    if (!bool1)
    {
      float f6 = this.mLastMotionX - paramFloat;
      this.mLastMotionX = paramFloat;
      float f7 = getScrollX();
      float f5 = f7 + f6;
      j = getClientWidth();
      if (this.mAdapter == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        getLeftEdge();
      } else {
        paramFloat = this.mFirstOffset;
      }
      if (i != 0) {
        getRightEdge();
      } else {
        paramFloat = this.mLastOffset;
      }
      if (i == 0)
      {
        i = 0;
        f1 = 3.4028235E+38F;
        for (paramFloat = 1.4E-45F; i < this.mItems.size(); paramFloat = f4)
        {
          f2 = ((ViewPager.ItemInfo)this.mItems.get(i)).offset;
          f3 = f1;
          if (f2 < f1) {
            f3 = f2;
          }
          f4 = paramFloat;
          if (f2 > paramFloat) {
            f4 = f2;
          }
          i += 1;
          f1 = f3;
        }
        f4 = j;
        f2 = this.mMinOffset;
        if (f2 != 1.4E-45F) {
          f1 = f2;
        }
        f2 = f1 * f4;
        f3 = this.mMaxOffset;
        f1 = f3;
        if (f3 == 3.4028235E+38F) {
          f1 = paramFloat;
        }
        paramFloat = f4 * f1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this);
        ((StringBuilder)localObject1).append("performDrag,scrollX=");
        ((StringBuilder)localObject1).append(f7);
        ((StringBuilder)localObject1).append(",leftBounds=");
        ((StringBuilder)localObject1).append(f2);
        ((StringBuilder)localObject1).append(",rightBounds=");
        ((StringBuilder)localObject1).append(paramFloat);
        Log.d("ViewPager", ((StringBuilder)localObject1).toString());
        f1 = f2;
      }
      else
      {
        f1 = getLeftEdge();
        paramFloat = getRightEdge();
      }
      if (f5 < f1) {
        if ((!onLeftGlideBlank()) && (this.mLeftDragOutSizeEnable))
        {
          f2 = f5 - f6 + f6 / 4.0F;
          f1 -= j / 3;
          paramFloat = f2;
          if (f2 < f1)
          {
            bool1 = bool2;
            paramFloat = f1;
            break label541;
          }
        }
      }
      do
      {
        bool1 = true;
        break label541;
        localObject1 = getParent();
        if (localObject1 != null) {
          ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(false);
        }
        bool1 = bool2;
        paramFloat = f1;
        if (this.mLeftDragOutSizeEnable) {
          break label541;
        }
        this.mIsUnableToDrag = true;
        bool1 = bool2;
        paramFloat = f1;
        break label541;
        if (f5 <= paramFloat) {
          break label534;
        }
        if ((onRightGlideBlank()) || (!this.mRightDragOutSizeEnable)) {
          break;
        }
        f1 = f5 - f6 + f6 / 4.0F;
        f2 = j / 3 + paramFloat;
        paramFloat = f1;
      } while (f1 <= f2);
      bool1 = bool2;
      paramFloat = f2;
      break label541;
      localObject1 = getParent();
      if (localObject1 != null) {
        ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(false);
      }
      if (!this.mRightDragOutSizeEnable) {
        this.mIsUnableToDrag = true;
      }
      bool1 = bool2;
      break label541;
      label534:
      paramFloat = f5;
      bool1 = bool2;
      label541:
      f1 = this.mLastMotionX;
      i = (int)paramFloat;
      this.mLastMotionX = (f1 + (paramFloat - i));
      scrollTo(i, getScrollY());
    }
    for (;;)
    {
      pageScrolled(i);
      return bool1;
      f3 = this.mLastMotionY - paramFloat;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("performDrag,x=");
      ((StringBuilder)localObject1).append(paramFloat);
      ((StringBuilder)localObject1).append(",delta=");
      ((StringBuilder)localObject1).append(f3);
      ((StringBuilder)localObject1).append(",mLasty=");
      ((StringBuilder)localObject1).append(this.mLastMotionY);
      Log.d("ViewPager", ((StringBuilder)localObject1).toString());
      this.mLastMotionY = paramFloat;
      f2 = getScrollY() + f3;
      int k = getClientSize();
      f4 = k;
      paramFloat = this.mFirstOffset * f4;
      f1 = this.mLastOffset * f4;
      if (this.mItems.size() > 0)
      {
        localObject1 = (ViewPager.ItemInfo)this.mItems.get(0);
        Object localObject2 = this.mItems;
        localObject2 = (ViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
        if (((ViewPager.ItemInfo)localObject1).position != 0)
        {
          paramFloat = ((ViewPager.ItemInfo)localObject1).offset * f4;
          i = 0;
        }
        else
        {
          i = 1;
        }
        if (((ViewPager.ItemInfo)localObject2).position != this.mAdapter.getCount() - 1)
        {
          f1 = ((ViewPager.ItemInfo)localObject2).offset * f4;
          j = 0;
        }
        else
        {
          j = 1;
        }
      }
      else
      {
        j = 1;
        i = 1;
      }
      if ((f2 < paramFloat) && (i != 0)) {
        if ((!onLeftGlideBlank()) && (this.mLeftDragOutSizeEnable))
        {
          f1 = f2 - f3 + f3 / 4.0F;
          f2 = paramFloat - k / 3;
          paramFloat = f1;
          if (f1 >= f2) {}
        }
      }
      for (paramFloat = f2;; paramFloat = f1)
      {
        bool1 = bool3;
        break label1007;
        do
        {
          bool1 = true;
          break label1007;
          localObject1 = getParent();
          if (localObject1 != null) {
            ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(false);
          }
          bool1 = bool3;
          break label1007;
          bool1 = bool3;
          paramFloat = f2;
          if (f2 <= f1) {
            break label1007;
          }
          bool1 = bool3;
          paramFloat = f2;
          if (j == 0) {
            break label1007;
          }
          if ((onRightGlideBlank()) || (!this.mRightDragOutSizeEnable)) {
            break;
          }
          f2 = f2 - f3 + f3 / 4.0F;
          f1 = k / 3 + f1;
          paramFloat = f2;
        } while (f2 <= f1);
      }
      localObject1 = getParent();
      if (localObject1 != null) {
        ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(false);
      }
      paramFloat = f1;
      bool1 = bool3;
      label1007:
      f1 = this.mLastMotionY;
      i = (int)paramFloat;
      this.mLastMotionY = (f1 + (paramFloat - i));
      scrollTo(getScrollX(), i);
    }
  }
  
  void populate()
  {
    populate(this.mCurItem);
  }
  
  void populate(int paramInt)
  {
    populate(paramInt, false);
  }
  
  void populate(int paramInt, boolean paramBoolean)
  {
    int i = this.mCurItem;
    int m;
    if (i != paramInt)
    {
      if (i < paramInt) {
        i = 66;
      } else {
        i = 17;
      }
      localObject2 = infoForPosition(this.mCurItem);
      this.mCurItem = paramInt;
      m = i;
    }
    else
    {
      m = 2;
      localObject2 = null;
    }
    Object localObject1 = this.mAdapter;
    if (localObject1 == null)
    {
      sortChildDrawingOrder();
      return;
    }
    if (this.mPopulatePending)
    {
      sortChildDrawingOrder();
      return;
    }
    ((ViewPagerAdapter)localObject1).startUpdate(this, this.mCurItem);
    if ((this.mCacheEnabled) && (paramBoolean))
    {
      paramInt = 0;
      while (paramInt < this.mItems.size())
      {
        localObject1 = (ViewPager.ItemInfo)this.mItems.get(paramInt);
        this.mAdapter.destroyItem(this, ((ViewPager.ItemInfo)localObject1).position, ((ViewPager.ItemInfo)localObject1).object);
        paramInt += 1;
      }
      this.mItems.clear();
    }
    paramInt = this.mOffscreenPageLimit;
    int i4 = Math.max(0, this.mCurItem - paramInt);
    int i1 = this.mAdapter.getCount();
    int i2 = Math.min(i1 - 1, this.mCurItem + paramInt);
    if ((getWindowToken() != null) && (i1 != this.mExpectedAdapterCount)) {}
    try
    {
      localObject1 = getResources().getResourceName(getId());
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label240:
      Object localObject3;
      int j;
      int i3;
      float f3;
      int n;
      float f2;
      Object localObject4;
      float f1;
      int k;
      break label240;
    }
    localObject1 = Integer.toHexString(getId());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("The application's QBPagerAdapter changed the adapter's contents without calling QBPagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
    ((StringBuilder)localObject2).append(this.mExpectedAdapterCount);
    ((StringBuilder)localObject2).append(", found: ");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append(" Pager id: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" Pager class: ");
    ((StringBuilder)localObject2).append(getClass());
    ((StringBuilder)localObject2).append(" Problematic adapter: ");
    ((StringBuilder)localObject2).append(this.mAdapter.getClass());
    throw new IllegalStateException(((StringBuilder)localObject2).toString());
    paramInt = 0;
    while (paramInt < this.mItems.size())
    {
      localObject1 = (ViewPager.ItemInfo)this.mItems.get(paramInt);
      if (((ViewPager.ItemInfo)localObject1).position >= this.mCurItem)
      {
        if (((ViewPager.ItemInfo)localObject1).position != this.mCurItem) {
          break;
        }
        break label428;
      }
      paramInt += 1;
    }
    localObject1 = null;
    label428:
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = localObject1;
      if (i1 > 0) {
        localObject3 = addNewItem(this.mCurItem, paramInt);
      }
    }
    if (localObject3 != null)
    {
      j = paramInt - 1;
      if (j >= 0) {
        localObject1 = (ViewPager.ItemInfo)this.mItems.get(j);
      } else {
        localObject1 = null;
      }
      i3 = getClientSize();
      if (this.mIsVertical) {
        i = getPaddingTop();
      } else {
        i = getPaddingLeft();
      }
      if (i3 <= 0) {
        f3 = 0.0F;
      } else {
        f3 = 2.0F - ((ViewPager.ItemInfo)localObject3).sizeFactor + i / i3;
      }
      n = this.mCurItem - 1;
      f2 = 0.0F;
      localObject4 = localObject1;
      while (n >= 0)
      {
        if ((f2 >= f3) && (n < i4))
        {
          if (localObject4 == null) {
            break;
          }
          f1 = f2;
          k = j;
          localObject1 = localObject4;
          i = paramInt;
          if (n != localObject4.position) {
            break label809;
          }
          f1 = f2;
          k = j;
          localObject1 = localObject4;
          i = paramInt;
          if (localObject4.scrolling) {
            break label809;
          }
          this.mItems.remove(j);
          this.mAdapter.destroyItem(this, n, localObject4.object);
          j -= 1;
          paramInt -= 1;
          f1 = f2;
          k = j;
          i = paramInt;
          if (j < 0) {}
        }
        for (;;)
        {
          localObject1 = (ViewPager.ItemInfo)this.mItems.get(j);
          f1 = f2;
          k = j;
          i = paramInt;
          break;
          do
          {
            do
            {
              localObject1 = null;
              break label809;
              if ((localObject4 == null) || (n != localObject4.position)) {
                break;
              }
              f2 += localObject4.sizeFactor;
              j -= 1;
              f1 = f2;
              k = j;
              i = paramInt;
            } while (j < 0);
            break;
            f2 += addNewItem(n, j + 1).sizeFactor;
            paramInt += 1;
            f1 = f2;
            k = j;
            i = paramInt;
          } while (j < 0);
        }
        label809:
        n -= 1;
        f2 = f1;
        j = k;
        localObject4 = localObject1;
        paramInt = i;
      }
      f2 = ((ViewPager.ItemInfo)localObject3).sizeFactor;
      k = paramInt + 1;
      if (f2 < 2.0F)
      {
        if (k < this.mItems.size()) {
          localObject1 = (ViewPager.ItemInfo)this.mItems.get(k);
        } else {
          localObject1 = null;
        }
        if (this.mIsVertical) {
          i = getPaddingBottom();
        } else {
          i = getPaddingRight();
        }
        if (i3 <= 0) {
          f3 = 0.0F;
        } else {
          f3 = i / i3 + 2.0F;
        }
        j = this.mCurItem;
        localObject4 = localObject1;
        i = k;
        for (;;)
        {
          k = j + 1;
          if (k >= i1) {
            break;
          }
          if ((f2 >= f3) && (k > i2))
          {
            if (localObject4 == null) {
              break;
            }
            f1 = f2;
            j = i;
            localObject1 = localObject4;
            if (k != localObject4.position) {
              break label1215;
            }
            f1 = f2;
            j = i;
            localObject1 = localObject4;
            if (localObject4.scrolling) {
              break label1215;
            }
            this.mItems.remove(i);
            this.mAdapter.destroyItem(this, k, localObject4.object);
            f1 = f2;
            j = i;
            if (i >= this.mItems.size()) {}
          }
          for (;;)
          {
            localObject1 = (ViewPager.ItemInfo)this.mItems.get(i);
            f1 = f2;
            j = i;
            break;
            do
            {
              do
              {
                localObject1 = null;
                break label1215;
                if ((localObject4 == null) || (k != localObject4.position)) {
                  break;
                }
                f2 += localObject4.sizeFactor;
                i += 1;
                f1 = f2;
                j = i;
              } while (i >= this.mItems.size());
              break;
              if (localObject4 != null) {
                this.mAdapter.destroyItem(this, localObject4.position, localObject4.object);
              }
              localObject1 = addNewItem(k, i);
              i += 1;
              f2 += ((ViewPager.ItemInfo)localObject1).sizeFactor;
              f1 = f2;
              j = i;
            } while (i >= this.mItems.size());
          }
          label1215:
          f2 = f1;
          i = j;
          localObject4 = localObject1;
          j = k;
        }
      }
      calculatePageOffsets((ViewPager.ItemInfo)localObject3, paramInt, (ViewPager.ItemInfo)localObject2);
    }
    localObject2 = this.mAdapter;
    paramInt = this.mCurItem;
    if (localObject3 != null) {
      localObject1 = ((ViewPager.ItemInfo)localObject3).object;
    } else {
      localObject1 = null;
    }
    ((ViewPagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
    this.mAdapter.finishUpdate(this);
    i = getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      localObject2 = getChildAt(paramInt);
      localObject1 = (ViewPager.LayoutParams)((View)localObject2).getLayoutParams();
      ((ViewPager.LayoutParams)localObject1).childIndex = paramInt;
      localObject2 = infoForChild((View)localObject2);
      if (localObject2 != null)
      {
        ((ViewPager.LayoutParams)localObject1).sizeFactor = ((ViewPager.ItemInfo)localObject2).sizeFactor;
        ((ViewPager.LayoutParams)localObject1).position = ((ViewPager.ItemInfo)localObject2).position;
      }
      paramInt += 1;
    }
    sortChildDrawingOrder();
    if (hasFocus())
    {
      localObject1 = findFocus();
      if (localObject1 != null) {
        localObject1 = infoForAnyChild((View)localObject1);
      } else {
        localObject1 = null;
      }
      if ((localObject1 == null) || (((ViewPager.ItemInfo)localObject1).position != this.mCurItem))
      {
        paramInt = 0;
        while (paramInt < getChildCount())
        {
          localObject1 = getChildAt(paramInt);
          localObject2 = infoForChild((View)localObject1);
          if ((localObject2 != null) && (((ViewPager.ItemInfo)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(m))) {
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public int positionForChild(View paramView)
  {
    paramView = infoForChild(paramView);
    if (paramView != null) {
      return paramView.position;
    }
    return 0;
  }
  
  public void postInvalidate()
  {
    try
    {
      super.postInvalidate();
      if (this.mInvalidateListener != null) {
        this.mInvalidateListener.onPostInvalidate();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (isGallery()) {
      return;
    }
    ViewPager.ItemInfo localItemInfo;
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      paramInt2 = (int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3));
      scrollTo(paramInt2, getScrollY());
      if (!this.mScroller.isFinished())
      {
        paramInt3 = this.mScroller.getDuration();
        paramInt4 = this.mScroller.timePassed();
        localItemInfo = infoForPosition(this.mCurItem);
        if (localItemInfo != null) {
          this.mScroller.startScroll(paramInt2, 0, (int)(localItemInfo.offset * paramInt1), 0, paramInt3 - paramInt4);
        }
      }
    }
    else
    {
      localItemInfo = infoForPosition(this.mCurItem);
      float f;
      if (localItemInfo != null) {
        f = Math.min(localItemInfo.offset, this.mLastOffset);
      } else {
        f = 0.0F;
      }
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        completeScroll(false);
        scrollTo(paramInt1, getScrollY());
      }
    }
  }
  
  void removeNonDecorViews()
  {
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((ViewPager.LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if (isGallery())
    {
      int i = 0;
      while (i < getChildCount())
      {
        if (paramView1 == getChildAt(i))
        {
          if (i == this.mCurrentScreen) {
            break;
          }
          snapToScreen(i, 0, true);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = infoForPosition(paramInt1);
    int i;
    if (localObject != null) {
      i = (int)(getClientSize() * Math.max(this.mFirstOffset, Math.min(((ViewPager.ItemInfo)localObject).offset, this.mLastOffset)));
    } else {
      i = 0;
    }
    if (paramBoolean1)
    {
      if (this.mIsVertical) {
        smoothScrollTo(0, i, paramInt2, paramInt3);
      } else {
        smoothScrollTo(i, 0, paramInt2, paramInt3);
      }
      if (paramBoolean2)
      {
        localObject = this.mOnPageChangeListener;
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.mInternalPageChangeListener;
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
    }
    else
    {
      if (paramBoolean2)
      {
        localObject = this.mOnPageChangeListener;
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.mInternalPageChangeListener;
        if (localObject != null) {
          ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
        }
      }
      this.mScrollToNeedNotify = true;
      completeScroll(false);
      if (this.mIsVertical) {
        scrollTo(0, i);
      } else {
        scrollTo(i, 0);
      }
      pageScrolled(i);
    }
    localObject = this.mSelectedListener;
    if ((localObject != null) && (paramBoolean3)) {
      ((ViewPager.PageSelectedListener)localObject).onPageSelected(false, this.mCurItem);
    }
  }
  
  void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    scrollToItem(paramInt1, paramBoolean1, 0, paramInt2, paramBoolean2, this.mTouching);
  }
  
  public void setAdapter(ViewPagerAdapter paramViewPagerAdapter)
  {
    Object localObject = this.mAdapter;
    if (localObject != null)
    {
      ((ViewPagerAdapter)localObject).unregisterDataSetObserver(this.mObserver);
      this.mAdapter.startUpdate(this, this.mCurItem);
      int i = 0;
      while (i < this.mItems.size())
      {
        localObject = (ViewPager.ItemInfo)this.mItems.get(i);
        this.mAdapter.destroyItem(this, ((ViewPager.ItemInfo)localObject).position, ((ViewPager.ItemInfo)localObject).object);
        i += 1;
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    }
    localObject = this.mAdapter;
    this.mAdapter = paramViewPagerAdapter;
    this.mExpectedAdapterCount = 0;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new ViewPager.PagerObserver(this);
      }
      this.mAdapter.registerDataSetObserver(this.mObserver);
      this.mPopulatePending = false;
      boolean bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem >= 0)
      {
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
      }
      else if (!bool)
      {
        populate();
      }
      else
      {
        requestLayout();
      }
    }
    ViewPager.OnAdapterChangeListener localOnAdapterChangeListener = this.mAdapterChangeListener;
    if ((localOnAdapterChangeListener != null) && (localObject != paramViewPagerAdapter)) {
      localOnAdapterChangeListener.onAdapterChanged((ViewPagerAdapter)localObject, paramViewPagerAdapter);
    }
  }
  
  public void setAutoScrollCustomDuration(int paramInt)
  {
    this.mAutoScrollCustomDuration = paramInt;
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    this.mCacheEnabled = paramBoolean;
  }
  
  public void setCallPageChangedOnFirstLayout(boolean paramBoolean)
  {
    this.mCallPageChangedOnFirstLayout = paramBoolean;
  }
  
  public void setCanScroll(boolean paramBoolean)
  {
    this.mCanScroll = paramBoolean;
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, this.mFirstLayout ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  public void setCurrentItem(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt1, paramBoolean, false, paramInt2, 0);
  }
  
  protected void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    Object localObject = this.mAdapter;
    if ((localObject != null) && (((ViewPagerAdapter)localObject).getCount() > 0))
    {
      if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
      {
        setScrollingCacheEnabled(false);
        return;
      }
      if (paramInt1 < 0)
      {
        paramInt1 = 0;
      }
      else
      {
        i = paramInt1;
        if (paramInt1 >= this.mAdapter.getCount()) {
          i = this.mAdapter.getCount() - 1;
        }
        paramInt1 = i;
      }
      int i = this.mOffscreenPageLimit;
      int j = this.mCurItem;
      if ((paramInt1 > j + i) || (paramInt1 < j - i))
      {
        i = 0;
        while (i < this.mItems.size())
        {
          ((ViewPager.ItemInfo)this.mItems.get(i)).scrolling = true;
          i += 1;
        }
      }
      if (this.mCurItem != paramInt1) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      if (this.mFirstLayout)
      {
        this.mCurItem = paramInt1;
        if ((paramBoolean2) || (this.mCallPageChangedOnFirstLayout))
        {
          localObject = this.mOnPageChangeListener;
          if (localObject != null) {
            ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
          }
        }
        if ((paramBoolean2) || (this.mCallPageChangedOnFirstLayout))
        {
          localObject = this.mInternalPageChangeListener;
          if (localObject != null) {
            ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt1);
          }
        }
        requestLayout();
        return;
      }
      populate(paramInt1, true);
      scrollToItem(paramInt1, paramBoolean1, paramInt2, paramInt3, paramBoolean2, this.mTouching);
      return;
    }
    setScrollingCacheEnabled(false);
  }
  
  public void setCurrentPage(int paramInt)
  {
    if (this.mCurrentScreen != paramInt)
    {
      if (!this.mScroller.isFinished()) {
        this.mScroller.abortAnimation();
      }
      paramInt = Math.max(0, Math.min(paramInt, getPageCount() - 1));
      setScrollState(0);
      Object localObject = this.mOnPageChangeListener;
      if (localObject != null) {
        ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt);
      }
      this.mCurrentScreen = paramInt;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurrentPage,currScreen=");
      ((StringBuilder)localObject).append(this.mCurrentScreen);
      Log.d("TMYGALLERY", ((StringBuilder)localObject).toString());
      scrollTo(paramInt * getWidth(), getScrollY());
      invalidate();
    }
  }
  
  public void setDisallowInterceptWhenDrag(boolean paramBoolean)
  {
    this.mDisallowInterceptWhenDrag = paramBoolean;
  }
  
  public void setDragChecker(ViewPager.IDragChecker paramIDragChecker)
  {
    this.mChecker = paramIDragChecker;
  }
  
  public void setEnableCatching(boolean paramBoolean)
  {
    this.mEnableCatching = paramBoolean;
  }
  
  public void setEnableReLayoutOnAttachToWindow(boolean paramBoolean)
  {
    this.mReLayoutOnAttachToWindow = paramBoolean;
  }
  
  public void setFirstLayoutParameter(boolean paramBoolean)
  {
    this.mFirstLayout = paramBoolean;
  }
  
  public void setFirstOffsetBy(View paramView)
  {
    paramView = infoForChild(paramView);
    if (paramView != null)
    {
      this.mMinOffset = paramView.offset;
      this.mMinPage = paramView.position;
    }
  }
  
  public void setFocusSearchEnabled(boolean paramBoolean)
  {
    this.mFocusSearchEnabled = paramBoolean;
  }
  
  protected void setForceUnableToDrag(boolean paramBoolean)
  {
    this.mForceUnableToDrag = paramBoolean;
  }
  
  public ViewPager.OnPageChangeListener setInternalPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }
  
  public void setLastOffsetBy(View paramView)
  {
    paramView = infoForChild(paramView);
    if (paramView != null)
    {
      this.mMaxOffset = paramView.offset;
      this.mMaxPage = paramView.position;
    }
  }
  
  public void setLeftDragOutSizeEnabled(boolean paramBoolean)
  {
    this.mLeftDragOutSizeEnable = paramBoolean;
  }
  
  public void setLeftGlideBlankListener(ViewPager.QBGalleryGlideBlankListener paramQBGalleryGlideBlankListener)
  {
    this.mLeftGlideBlankListener = paramQBGalleryGlideBlankListener;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
  }
  
  public void setOnAdapterChangeListener(ViewPager.OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    this.mAdapterChangeListener = paramOnAdapterChangeListener;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setOnPageReadyListener(ViewPager.OnPageReadyListener paramOnPageReadyListener)
  {
    this.mOnPageReadyListener = paramOnPageReadyListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setPageSelectedListener(ViewPager.PageSelectedListener paramPageSelectedListener)
  {
    this.mSelectedListener = paramPageSelectedListener;
  }
  
  public void setPageTransformer(ViewPager.PageTransformer paramPageTransformer)
  {
    this.mPageTransformer = paramPageTransformer;
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    if (!isGallery())
    {
      int j = 1;
      boolean bool1;
      if (paramPageTransformer != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (this.mPageTransformer != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      int i;
      if (bool1 != bool2) {
        i = 1;
      } else {
        i = 0;
      }
      this.mPageTransformer = paramPageTransformer;
      setChildrenDrawingOrderEnabled(bool1);
      if (bool1)
      {
        if (paramBoolean) {
          j = 2;
        }
        this.mDrawingOrder = j;
      }
      else
      {
        this.mDrawingOrder = 0;
      }
      if (i != 0) {
        populate();
      }
    }
    else
    {
      this.mPageTransformer = paramPageTransformer;
    }
  }
  
  public void setPagerInvalidateListener(ViewPager.PagerInvalidateListener paramPagerInvalidateListener)
  {
    this.mInvalidateListener = paramPagerInvalidateListener;
  }
  
  public void setRightDragOutSizeEnabled(boolean paramBoolean)
  {
    this.mRightDragOutSizeEnable = paramBoolean;
  }
  
  public void setRightGlideBlankListener(ViewPager.QBGalleryGlideBlankListener paramQBGalleryGlideBlankListener)
  {
    this.mRightGlideBlankListener = paramQBGalleryGlideBlankListener;
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    this.mScrollEnabled = paramBoolean;
  }
  
  protected void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    ViewPager.PageTransformer localPageTransformer = this.mPageTransformer;
    if ((paramInt == 1) && (this.mNextScreen != -1) && (isGallery())) {
      this.mNextScreen = -1;
    }
    notifyScrollStateChanged(this.mScrollState, paramInt);
    if (paramInt == 0)
    {
      this.mMinOffset = 1.4E-45F;
      this.mMaxOffset = 3.4028235E+38F;
      this.mMinPage = -2147483648;
      this.mMaxPage = 2147483647;
    }
    this.mScrollState = paramInt;
  }
  
  protected void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean)
    {
      this.mScrollingCacheEnabled = paramBoolean;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() != 8)) {
          localView.setDrawingCacheEnabled(paramBoolean);
        }
        i += 1;
      }
    }
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((getChildCount() != 0) && (this.mAdapter != null))
    {
      int j = getScrollX();
      int k = getScrollY();
      int i = paramInt1 - j;
      paramInt2 -= k;
      if ((i == 0) && (paramInt2 == 0))
      {
        completeScroll(false);
        populate();
        setScrollState(0);
        return;
      }
      setScrollingCacheEnabled(true);
      setScrollState(2);
      paramInt1 = getClientSize();
      int m = paramInt1 / 2;
      float f2 = Math.abs(i);
      float f1 = paramInt1;
      float f3 = Math.min(1.0F, f2 * 1.0F / f1);
      f2 = m;
      f3 = distanceInfluenceForSnapDuration(f3);
      paramInt1 = paramInt3;
      if (paramInt3 <= 0) {
        if (!this.mTouching)
        {
          paramInt3 = this.mAutoScrollCustomDuration;
          paramInt1 = paramInt3;
          if (paramInt3 >= 0) {}
        }
        else
        {
          paramInt1 = Math.abs(paramInt4);
          if (paramInt1 > 0)
          {
            paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt1) * 1000.0F) * 4;
          }
          else
          {
            f2 = this.mAdapter.getPageSize(this.mCurItem);
            if (this.mIsVertical) {
              paramInt1 = paramInt2;
            } else {
              paramInt1 = i;
            }
            paramInt1 = (int)((Math.abs(paramInt1) / (f1 * f2 + this.mPageMargin) + 1.0F) * 100.0F);
          }
          paramInt1 = Math.min(paramInt1, 600);
        }
      }
      this.mScroller.startScroll(j, k, i, paramInt2, paramInt1);
      ViewCompatTool.postInvalidateOnAnimation(this);
      return;
    }
    setScrollingCacheEnabled(false);
  }
  
  public void snapToScreen(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    snapToScreen(paramInt1, paramInt2, paramBoolean, true);
  }
  
  public void snapToScreen(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      paramInt1 = Math.max(0, Math.min(paramInt1, getRightBoundPageIndex()));
      this.mNextScreen = paramInt1;
      Math.max(1, Math.abs(paramInt1 - this.mCurrentScreen));
      int i = getWidth() * paramInt1 - getScrollX();
      if (!this.mScroller.isFinished()) {
        this.mScroller.abortAnimation();
      }
      Math.abs(paramInt2);
      setScrollState(2);
      if (i == 0) {
        setScrollState(0);
      }
      this.mScroller.startScroll(getScrollX(), 0, i, 0, 500);
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.mOnPageChangeListener;
      if (localOnPageChangeListener != null) {
        localOnPageChangeListener.onPageSelected(paramInt1);
      }
      localOnPageChangeListener = this.mInternalPageChangeListener;
      if (localOnPageChangeListener != null) {
        localOnPageChangeListener.onPageSelected(paramInt1);
      }
      invalidate();
      return;
    }
    setCurrentPage(paramInt1);
  }
  
  void sortChildDrawingOrder()
  {
    if (this.mDrawingOrder != 0)
    {
      Object localObject = this.mDrawingOrderedChildren;
      if (localObject == null) {
        this.mDrawingOrderedChildren = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = getChildAt(i);
        this.mDrawingOrderedChildren.add(localObject);
        i += 1;
      }
      Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
    }
  }
  
  protected void stopScroller()
  {
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
  }
  
  void upAction(int paramInt, MotionEvent paramMotionEvent)
  {
    int i = getClientWidth();
    int k = getScrollX();
    if (i == 0) {
      return;
    }
    int j = paramMotionEvent.findPointerIndex(this.mActivePointerId);
    float f1 = this.mInitialMotionX;
    try
    {
      float f2 = paramMotionEvent.getX(j);
      f1 = f2;
    }
    catch (Exception paramMotionEvent)
    {
      label46:
      boolean bool;
      double d1;
      double d2;
      break label46;
    }
    if ((Math.abs((int)(f1 - this.mInitialMotionX)) > this.mFlingDistance) && (Math.abs(paramInt) > this.mMinimumVelocity))
    {
      if (paramInt < 0) {
        bool = true;
      } else {
        bool = false;
      }
      i = findNextPosition(bool);
    }
    else
    {
      j = k / i;
      d1 = k - j * i;
      d2 = i;
      Double.isNaN(d2);
      i = j;
      if (d1 > d2 * 0.5D) {
        i = j + 1;
      }
    }
    snapToScreen(Math.min(Math.max(i, getLeftBoundPageIndex()), getRightBoundPageIndex()), paramInt, true);
  }
  
  public void updateScreenNextCall()
  {
    this.mUpdateScreenNextCall = true;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mMarginDrawable);
  }
  
  public boolean verticalCanScroll(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.viewpager.ViewPager
 * JD-Core Version:    0.7.0.1
 */