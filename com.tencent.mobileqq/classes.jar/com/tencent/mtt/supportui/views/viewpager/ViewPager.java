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
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          if (!isGallery()) {
            break label77;
          }
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        for (;;)
        {
          i += 1;
          break;
          label77:
          ViewPager.ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
      }
    }
    if (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  ViewPager.ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    ViewPager.ItemInfo localItemInfo = new ViewPager.ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    localItemInfo.sizeFactor = this.mAdapter.getPageSize(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size()))
    {
      this.mItems.add(localItemInfo);
      return localItemInfo;
    }
    this.mItems.add(paramInt2, localItemInfo);
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
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)paramLayoutParams;
      localLayoutParams.isDecor |= paramView instanceof ViewPager.Decor;
      if (this.mInLayout)
      {
        if ((localLayoutParams != null) && (localLayoutParams.isDecor)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.needsMeasure = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
      }
      while (paramView.getVisibility() != 8)
      {
        paramView.setDrawingCacheEnabled(this.mScrollingCacheEnabled);
        return;
        super.addView(paramView, paramInt, paramLayoutParams);
      }
      paramView.setDrawingCacheEnabled(false);
      return;
    }
  }
  
  public boolean arrowScroll(int paramInt)
  {
    boolean bool2;
    if (!this.mFocusSearchEnabled) {
      bool2 = true;
    }
    View localView;
    Object localObject;
    int j;
    boolean bool1;
    label102:
    do
    {
      return bool2;
      localView = findFocus();
      if (localView != this) {
        break;
      }
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label315;
      }
      if (paramInt != 17) {
        break label252;
      }
      i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
      j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
      if ((localObject == null) || (i < j)) {
        break label242;
      }
      bool1 = pageLeft();
      bool2 = bool1;
    } while (!bool1);
    playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    return bool1;
    if (localView != null)
    {
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label368;
      }
      if (localObject != this) {}
    }
    label315:
    label368:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        localObject = null;
        break;
        label242:
        bool1 = localView.requestFocus();
        break label102;
        label252:
        if (paramInt == 66)
        {
          i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
          j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
          if ((localObject != null) && (i <= j))
          {
            bool1 = pageRight();
            break label102;
          }
          bool1 = localView.requestFocus();
          break label102;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool1 = pageLeft();
            break label102;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool1 = pageRight();
            break label102;
          }
        }
        bool1 = false;
        break label102;
      }
      localObject = localView;
      break;
    }
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
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.mVelocityTracker.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.mFakeDragBeginTime = l;
      return true;
      this.mVelocityTracker.clear();
    }
  }
  
  void calculatePageOffsets(ViewPager.ItemInfo paramItemInfo1, int paramInt, ViewPager.ItemInfo paramItemInfo2)
  {
    int m = this.mAdapter.getCount();
    int i = getClientSize();
    float f2;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramItemInfo2 == null) {
        break label409;
      }
      i = paramItemInfo2.position;
      if (i < paramItemInfo1.position)
      {
        j = 0;
        f1 = paramItemInfo2.offset + paramItemInfo2.sizeFactor + f2;
        i += 1;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramItemInfo1.position) || (j >= this.mItems.size())) {
          break label409;
        }
        for (paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j);; paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramItemInfo2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramItemInfo2.position)
        {
          f3 += this.mAdapter.getPageSize(k) + f2;
          k += 1;
        }
        paramItemInfo2.offset = f3;
        f1 = f3 + (paramItemInfo2.sizeFactor + f2);
        i = k + 1;
      }
    }
    if (i > paramItemInfo1.position)
    {
      j = this.mItems.size() - 1;
      f1 = paramItemInfo2.offset;
      i -= 1;
      while ((i >= paramItemInfo1.position) && (j >= 0))
      {
        for (paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j);; paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j))
        {
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
    label409:
    int k = this.mItems.size();
    float f3 = paramItemInfo1.offset;
    i = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0)
    {
      f1 = paramItemInfo1.offset;
      this.mFirstOffset = f1;
      if (paramItemInfo1.position != m - 1) {
        break label550;
      }
      f1 = paramItemInfo1.offset + paramItemInfo1.sizeFactor - 1.0F;
      label475:
      this.mLastOffset = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label603;
      }
      paramItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(j);
      for (;;)
      {
        if (i > paramItemInfo2.position)
        {
          f1 -= this.mAdapter.getPageSize(i) + f2;
          i -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label550:
          f1 = 3.4028235E+38F;
          break label475;
        }
      }
      f1 -= paramItemInfo2.sizeFactor + f2;
      paramItemInfo2.offset = f1;
      if (paramItemInfo2.position == 0) {
        this.mFirstOffset = f1;
      }
      i -= 1;
      j -= 1;
    }
    label603:
    float f1 = paramItemInfo1.offset + paramItemInfo1.sizeFactor + f2;
    int j = paramItemInfo1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramItemInfo1 = (ViewPager.ItemInfo)this.mItems.get(i);
      while (paramInt < paramItemInfo1.position)
      {
        f1 = this.mAdapter.getPageSize(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramItemInfo1.position == m - 1) {
        this.mLastOffset = (paramItemInfo1.sizeFactor + f1 - 1.0F);
      }
      paramItemInfo1.offset = f1;
      f1 += paramItemInfo1.sizeFactor + f2;
      paramInt += 1;
      i += 1;
    }
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
    paramBoolean2 = false;
    if (this.mChecker == null)
    {
      Log.d("PageScroller", "checkStartDrag,deltaX=" + paramFloat1 + ",deltaY=" + paramFloat2);
      if (this.mIsVertical) {
        if ((this.checkTouchSlop) || (paramFloat2 <= paramFloat1))
        {
          paramBoolean1 = paramBoolean2;
          if (paramFloat2 > this.mTouchSlop)
          {
            paramBoolean1 = paramBoolean2;
            if (paramFloat2 <= paramFloat1) {}
          }
        }
        else
        {
          paramBoolean1 = true;
        }
      }
      do
      {
        do
        {
          return paramBoolean1;
          if ((!this.checkTouchSlop) && (paramFloat1 > paramFloat2)) {
            break;
          }
          paramBoolean1 = paramBoolean2;
        } while (paramFloat1 <= this.mTouchSlop);
        paramBoolean1 = paramBoolean2;
      } while (paramFloat1 <= paramFloat2);
      return true;
    }
    return this.mChecker.checkStartDrag(paramFloat1, paramFloat2, this.mTouchSlop);
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
    if (this.mScrollState == 2) {}
    int j;
    for (int i = 1;; i = 0)
    {
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
      j = i;
      i = k;
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
    }
    if (j != 0)
    {
      if (paramBoolean) {
        ViewCompatTool.postOnAnimation(this, this.mEndScrollRunnable);
      }
    }
    else {
      return;
    }
    this.mEndScrollRunnable.run();
  }
  
  public void computeScroll()
  {
    Log.d("ViewPager", "computeScroll,mNextScreen=" + this.mNextScreen);
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
        if (!this.mIsVertical) {
          break label151;
        }
        i = k;
        if ((!pageScrolled(i)) && (!isGallery()))
        {
          this.mScroller.abortAnimation();
          if (!this.mIsVertical) {
            break label156;
          }
          scrollTo(0, k);
        }
      }
      for (;;)
      {
        ViewCompatTool.postInvalidateOnAnimation(this);
        return;
        label151:
        i = j;
        break;
        label156:
        scrollTo(j, 0);
      }
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
    int i2 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i2;
    int i;
    int j;
    int k;
    int m;
    int n;
    label90:
    Object localObject;
    int i1;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i2))
    {
      i = 1;
      if (this.mFirstDatasetChanged)
      {
        this.mFirstDatasetChanged = false;
        this.mCurItem = this.mAdapter.getInitialItemIndex();
      }
      j = this.mCurItem;
      k = 0;
      m = 0;
      n = i;
      i = j;
      j = k;
      k = m;
      if (k >= this.mItems.size()) {
        break label387;
      }
      localObject = (ViewPager.ItemInfo)this.mItems.get(k);
      i1 = this.mAdapter.getItemPosition(((ViewPager.ItemInfo)localObject).object);
      if (i1 != -1)
      {
        m = n;
        if (i1 != ((ViewPager.ItemInfo)localObject).position) {}
      }
      else
      {
        m = n;
        if (this.mAdapter.refreshItem(this, ((ViewPager.ItemInfo)localObject).position, ((ViewPager.ItemInfo)localObject).object) > 0)
        {
          ((ViewPager.ItemInfo)localObject).sizeFactor = this.mAdapter.getPageSize(((ViewPager.ItemInfo)localObject).position);
          m = 1;
        }
      }
      if (i1 != -1) {
        break label241;
      }
      n = k;
      i1 = j;
      k = m;
      j = i;
      i = i1;
      m = n;
    }
    for (;;)
    {
      n = k;
      i1 = j;
      k = m + 1;
      j = i;
      i = i1;
      break label90;
      i = 0;
      break;
      label241:
      if (i1 == -2)
      {
        this.mItems.remove(k);
        m = k - 1;
        k = j;
        if (j == 0)
        {
          this.mAdapter.startUpdate(this, this.mCurItem);
          k = 1;
        }
        this.mAdapter.destroyItem(this, ((ViewPager.ItemInfo)localObject).position, ((ViewPager.ItemInfo)localObject).object);
        if (this.mCurItem == ((ViewPager.ItemInfo)localObject).position)
        {
          j = Math.max(0, Math.min(this.mCurItem, i2 - 1));
          i = k;
          k = 1;
        }
      }
      else
      {
        if (((ViewPager.ItemInfo)localObject).position != i1)
        {
          if (((ViewPager.ItemInfo)localObject).position == this.mCurItem) {
            i = i1;
          }
          ((ViewPager.ItemInfo)localObject).position = i1;
          n = i;
          i1 = 1;
          m = k;
          i = j;
          j = n;
          k = i1;
          continue;
          if (j != 0) {
            this.mAdapter.finishUpdate(this);
          }
          Collections.sort(this.mItems, COMPARATOR);
          if (n != 0)
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
          return;
        }
        n = i;
        i1 = m;
        m = k;
        i = j;
        j = n;
        k = i1;
        continue;
      }
      label387:
      j = i;
      n = 1;
      i = k;
      k = n;
    }
  }
  
  int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    ViewPager.ItemInfo localItemInfo1;
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity)) {
      if (paramInt2 > 0)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0)
        {
          if (this.mMinPage != -2147483648) {
            break label150;
          }
          localItemInfo1 = (ViewPager.ItemInfo)this.mItems.get(0);
          label61:
          if (this.mMaxPage != 2147483647) {
            break label163;
          }
        }
      }
    }
    label150:
    label163:
    for (ViewPager.ItemInfo localItemInfo2 = (ViewPager.ItemInfo)this.mItems.get(this.mItems.size() - 1);; localItemInfo2 = infoForPosition(this.mMaxPage))
    {
      paramInt2 = Math.max(localItemInfo1.position, Math.min(paramInt1, localItemInfo2.position));
      return paramInt2;
      paramInt1 += 1;
      break;
      if (paramInt1 >= this.mCurItem) {}
      for (float f = 0.4F;; f = 0.6F)
      {
        paramInt1 = (int)(f + (paramInt1 + paramFloat));
        break;
      }
      localItemInfo1 = infoForPosition(this.mMinPage);
      break label61;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        View localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          ViewPager.ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
            bool1 = true;
          }
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
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
        Log.d("ViewPager", "index " + i + "--->" + ((ViewPager.ItemInfo)this.mItems.get(i)).toString());
        i += 1;
      }
    }
  }
  
  void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    if (i < k)
    {
      if (paramBoolean) {}
      for (int j = 2;; j = 0)
      {
        getChildAt(i).setLayerType(j, null);
        i += 1;
        break;
      }
    }
  }
  
  void endDrag()
  {
    Log.d("ViewPager", "endDrag");
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    this.checkTouchSlop = true;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public void endFakeDrag()
  {
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
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
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      return false;
      return arrowScroll(17);
      return arrowScroll(66);
      if (paramKeyEvent.hasNoModifiers()) {
        return arrowScroll(2);
      }
    } while (!paramKeyEvent.hasModifiers(1));
    return arrowScroll(1);
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    this.mLastMotionX += paramFloat;
    float f2 = getScrollX() - paramFloat;
    int i = getClientWidth();
    paramFloat = i;
    float f4 = this.mFirstOffset;
    float f1 = i;
    float f3 = this.mLastOffset;
    Object localObject = (ViewPager.ItemInfo)this.mItems.get(0);
    ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(this.mItems.size() - 1);
    if (((ViewPager.ItemInfo)localObject).position != 0) {}
    for (paramFloat = ((ViewPager.ItemInfo)localObject).offset * i;; paramFloat *= f4)
    {
      if (localItemInfo.position != this.mAdapter.getCount() - 1) {}
      for (f1 = localItemInfo.offset * i;; f1 *= f3)
      {
        if (f2 < paramFloat) {}
        for (;;)
        {
          this.mLastMotionX += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          pageScrolled((int)paramFloat);
          long l = SystemClock.uptimeMillis();
          localObject = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
          this.mVelocityTracker.addMovement((MotionEvent)localObject);
          ((MotionEvent)localObject).recycle();
          return;
          if (f2 > f1) {
            paramFloat = f1;
          } else {
            paramFloat = f2;
          }
        }
      }
    }
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
    if (i >= this.mDrawingOrderedChildren.size()) {}
    for (paramInt1 = this.mDrawingOrderedChildren.size() - 1;; paramInt1 = i)
    {
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = 0;
      }
      return ((ViewPager.LayoutParams)((View)this.mDrawingOrderedChildren.get(paramInt2)).getLayoutParams()).childIndex;
    }
  }
  
  Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
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
    if (this.mAdapter == null) {
      return 0;
    }
    return this.mAdapter.getCount();
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
    if (localView != null) {
      return localView.getRight() - getWidth();
    }
    return (i - 1) * getWidth();
  }
  
  public int getTotalLength()
  {
    int i = 0;
    int j = 0;
    if (i < this.mAdapter.getCount())
    {
      float f2 = j;
      if (this.mIsVertical) {}
      for (float f1 = getHeight() * this.mAdapter.getPageSize(i);; f1 = getWidth() * this.mAdapter.getPageSize(i))
      {
        j = (int)(f1 + f2);
        i += 1;
        break;
      }
    }
    return j;
  }
  
  public boolean horizontalCanScroll(int paramInt)
  {
    if (!this.mCanScroll) {}
    label137:
    label142:
    label147:
    label150:
    for (;;)
    {
      return false;
      int i;
      int j;
      label40:
      int k;
      if (isGallery()) {
        if (this.mCurrentScreen == 0)
        {
          i = 1;
          if (this.mCurrentScreen != getPageCount() - 1) {
            break label95;
          }
          j = 1;
          k = i;
          i = j;
          if ((paramInt >= 0) || ((!this.mLeftDragOutSizeEnable) && (k != 0))) {
            break label142;
          }
          j = 1;
          label63:
          if ((paramInt <= 0) || ((!this.mRightDragOutSizeEnable) && (i != 0))) {
            break label147;
          }
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if ((j == 0) && (paramInt == 0)) {
          break label150;
        }
        return true;
        i = 0;
        break;
        label95:
        j = 0;
        break label40;
        if (this.mCurItem == 0)
        {
          i = 1;
          label109:
          if (this.mCurItem != getPageCount() - 1) {
            break label137;
          }
        }
        for (j = 1;; j = 0)
        {
          k = i;
          i = j;
          break;
          i = 0;
          break label109;
        }
        j = 0;
        break label63;
      }
    }
  }
  
  ViewPager.ItemInfo infoForAnyChild(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
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
    int i = getClientSize();
    float f1;
    float f2;
    label43:
    float f4;
    float f3;
    int k;
    int j;
    Object localObject1;
    label60:
    Object localObject2;
    ViewPager.ItemInfo localItemInfo;
    if (i > 0) {
      if (this.mIsVertical)
      {
        f1 = getScrollY() / i;
        if (i <= 0) {
          break label234;
        }
        f2 = this.mPageMargin / i;
        f4 = 0.0F;
        f3 = 0.0F;
        k = -1;
        i = 0;
        j = 1;
        localObject1 = null;
        localObject2 = localObject1;
        if (i < this.mItems.size())
        {
          localItemInfo = (ViewPager.ItemInfo)this.mItems.get(i);
          if ((j != 0) || (localItemInfo.position == k + 1)) {
            break label269;
          }
          localItemInfo = this.mTempItem;
          localItemInfo.offset = (f4 + f3 + f2);
          localItemInfo.position = (k + 1);
          localItemInfo.sizeFactor = this.mAdapter.getPageSize(localItemInfo.position);
          i -= 1;
        }
      }
    }
    label269:
    for (;;)
    {
      f3 = localItemInfo.offset;
      f4 = localItemInfo.sizeFactor;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i != this.mItems.size() - 1)) {
          break label239;
        }
        localObject2 = localItemInfo;
      }
      return localObject2;
      f1 = getScrollX() / i;
      break;
      f1 = 0.0F;
      break;
      label234:
      f2 = 0.0F;
      break label43;
      label239:
      k = localItemInfo.position;
      f4 = localItemInfo.sizeFactor;
      j = 0;
      i += 1;
      localObject1 = localItemInfo;
      break label60;
    }
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
    if (this.mCustomInterplater != null) {}
    for (this.mScroller = new Scroller(localContext, this.mCustomInterplater);; this.mScroller = new Scroller(localContext, sInterpolator))
    {
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
      float f = localContext.getResources().getDisplayMetrics().density;
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      this.mMinimumVelocity = ((int)(400.0F * f));
      this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
      this.mFlingDistance = ((int)(25.0F * f));
      this.mCloseEnough = ((int)(2.0F * f));
      this.mDefaultGutterSize = ((int)(f * 25.0F));
      getViewTreeObserver().addOnPreDrawListener(new ViewPager.4(this));
      return;
    }
  }
  
  public void invalidate()
  {
    super.invalidate();
    if (this.mInvalidateListener != null) {
      this.mInvalidateListener.onInvalidate();
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
  
  public boolean isSettling()
  {
    return this.mScrollState == 2;
  }
  
  protected void notifyScrollStateChanged(int paramInt1, int paramInt2)
  {
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt1, paramInt2);
    }
    if (this.mInternalPageChangeListener != null) {
      this.mInternalPageChangeListener.onPageScrollStateChanged(paramInt1, paramInt2);
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
    int k;
    int m;
    float f3;
    Object localObject;
    float f1;
    int n;
    int i;
    int i1;
    int j;
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      k = getScrollX();
      m = getWidth();
      f3 = this.mPageMargin / m;
      localObject = (ViewPager.ItemInfo)this.mItems.get(0);
      f1 = ((ViewPager.ItemInfo)localObject).offset;
      n = this.mItems.size();
      i = ((ViewPager.ItemInfo)localObject).position;
      i1 = ((ViewPager.ItemInfo)this.mItems.get(n - 1)).position;
      j = 0;
    }
    for (;;)
    {
      float f2;
      if (i < i1)
      {
        while ((i > ((ViewPager.ItemInfo)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (ViewPager.ItemInfo)((ArrayList)localObject).get(j);
        }
        if (i != ((ViewPager.ItemInfo)localObject).position) {
          break label271;
        }
        f2 = (((ViewPager.ItemInfo)localObject).offset + ((ViewPager.ItemInfo)localObject).sizeFactor) * m;
      }
      label271:
      float f4;
      for (f1 = ((ViewPager.ItemInfo)localObject).offset + ((ViewPager.ItemInfo)localObject).sizeFactor + f3;; f1 += f4 + f3)
      {
        if (this.mPageMargin + f2 > k)
        {
          this.mMarginDrawable.setBounds((int)f2, this.mTopPageBounds, (int)(this.mPageMargin + f2 + 0.5F), this.mBottomPageBounds);
          this.mMarginDrawable.draw(paramCanvas);
        }
        if (f2 <= k + m) {
          break;
        }
        return;
        f4 = this.mAdapter.getPageSize(i);
        f2 = (f1 + f4) * m;
      }
      i += 1;
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
    if ((i == 3) || (i == 1))
    {
      this.mIsBeingDragged = false;
      this.mIsUnableToDrag = false;
      this.ignoreCheck = false;
      this.checkTouchSlop = true;
      this.mActivePointerId = -1;
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      return false;
    }
    if (i != 0)
    {
      if ((this.mIsUnableToDrag) || (this.mForceUnableToDrag))
      {
        Log.d("ViewPager", "onInterceptTouchEvent,resutl false due to mIsUnableToDrag");
        return false;
      }
      if (this.mIsBeingDragged) {
        return true;
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      return this.mIsBeingDragged;
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
          float f1 = f2 - this.mLastMotionX;
          float f4 = Math.abs(f1);
          float f3 = paramMotionEvent.getY(i);
          float f5 = Math.abs(f3 - this.mInitialMotionY);
          float f6 = f3 - this.mLastMotionY;
          float f7 = this.mLastMotionX;
          float f8 = this.mLastMotionY;
          boolean bool1;
          if (f1 < 0.0F)
          {
            bool1 = true;
            if (f6 >= 0.0F) {
              break label398;
            }
          }
          label398:
          for (boolean bool2 = true;; bool2 = false)
          {
            if (!this.mIsVertical) {
              break label404;
            }
            if ((this.mScrollEnabled) && ((f6 == 0.0F) || (isGutterDrag(this.mLastMotionY, f6)) || (this.ignoreCheck) || (!checkChildCanScroll((int)f1, (int)f2, (int)f3)))) {
              break label477;
            }
            Log.v("ViewPager", "checkChildCanScroll failed,return false");
            this.mLastMotionX = f2;
            this.mLastMotionY = f3;
            this.mIsUnableToDrag = true;
            return false;
            bool1 = false;
            break;
          }
          label404:
          if ((!this.mScrollEnabled) || ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f1)) && (!this.ignoreCheck) && (checkChildCanScroll((int)f1, (int)f2, (int)f3))))
          {
            Log.v("ViewPager", "checkChildCanScroll failed,return false");
            this.mLastMotionX = f2;
            this.mLastMotionY = f3;
            this.mIsUnableToDrag = true;
            return false;
          }
          label477:
          label505:
          ViewParent localViewParent;
          if (checkStartDrag(f4, f5, f7, f8, bool1, bool2)) {
            if (f1 < 0.0F)
            {
              bool1 = true;
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
                if (!this.mIsVertical) {
                  break label649;
                }
                if (this.checkTouchSlop)
                {
                  if (f6 <= 0.0F) {
                    break label635;
                  }
                  f1 = this.mInitialMotionY + this.mTouchSlop;
                  label582:
                  this.mLastMotionY = f1;
                }
                this.mLastMotionX = f2;
                setScrollingCacheEnabled(true);
              }
              label597:
              if (!this.mIsBeingDragged) {
                continue;
              }
              if (!this.mIsVertical) {
                break label753;
              }
            }
          }
          label649:
          label687:
          label753:
          for (f1 = f3; performDrag(f1); f1 = f2)
          {
            ViewCompatTool.postInvalidateOnAnimation(this);
            break;
            bool1 = false;
            break label505;
            label635:
            f1 = this.mInitialMotionY - this.mTouchSlop;
            break label582;
            if (this.checkTouchSlop) {
              if (f1 <= 0.0F) {
                break label687;
              }
            }
            for (f1 = this.mInitialMotionX + this.mTouchSlop;; f1 = this.mInitialMotionX - this.mTouchSlop)
            {
              this.mLastMotionX = f1;
              this.mLastMotionY = f3;
              break;
            }
            if ((!this.mIsVertical) && (f5 > this.mTouchSlop))
            {
              this.mIsUnableToDrag = true;
              break label597;
            }
            if ((!this.mIsVertical) || (f4 <= this.mTouchSlop)) {
              break label597;
            }
            this.mIsUnableToDrag = true;
            break label597;
          }
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
            continue;
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = getChildCount();
    int i3 = paramInt3 - paramInt1;
    int i1 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i4 = getScrollX();
    int k = 0;
    int m = 0;
    View localView;
    ViewPager.LayoutParams localLayoutParams;
    int i;
    int n;
    int j;
    if (m < i2)
    {
      localView = getChildAt(m);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label1006;
      }
      localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.isDecor) {
        break label1006;
      }
      i = localLayoutParams.gravity;
      n = localLayoutParams.gravity;
      switch (i & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        j = paramInt2;
        i = paramInt2;
        label158:
        switch (n & 0x70)
        {
        default: 
          n = paramInt1;
          paramInt2 = paramInt3;
          paramInt3 = n;
          label206:
          j += i4;
          localView.layout(j, paramInt3, localView.getMeasuredWidth() + j, localView.getMeasuredHeight() + paramInt3);
          j = k + 1;
          paramInt3 = i;
          i = paramInt2;
          paramInt2 = paramInt4;
          paramInt4 = j;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      j = paramInt3;
      k = paramInt4;
      paramInt4 = paramInt2;
      paramInt3 = i;
      paramInt2 = j;
      break;
      i = localView.getMeasuredWidth() + paramInt2;
      j = paramInt2;
      break label158;
      j = Math.max((i3 - localView.getMeasuredWidth()) / 2, paramInt2);
      i = paramInt2;
      break label158;
      j = localView.getMeasuredWidth();
      i = localView.getMeasuredWidth();
      j = i3 - paramInt4 - j;
      paramInt4 += i;
      i = paramInt2;
      break label158;
      if (localLayoutParams.takeHeightspace)
      {
        n = localView.getMeasuredHeight() + paramInt1;
        paramInt2 = paramInt3;
        paramInt3 = paramInt1;
        paramInt1 = n;
        break label206;
        n = Math.max((i1 - localView.getMeasuredHeight()) / 2, paramInt1);
        paramInt2 = paramInt3;
        paramInt3 = n;
        break label206;
        paramInt2 = i1 - paramInt3 - localView.getMeasuredHeight();
        label672:
        label824:
        label955:
        if (localLayoutParams.takeHeightspace)
        {
          n = localView.getMeasuredHeight();
          n += paramInt3;
          paramInt3 = paramInt2;
          paramInt2 = n;
          break label206;
          if (this.mIsVertical)
          {
            i = i1 - paramInt1 - paramInt3;
            if (this.mAdapter != null) {
              break label579;
            }
            paramInt2 = 0;
            j = getChildCount();
            paramInt4 = 0;
            label491:
            if (paramInt4 >= j) {
              break label850;
            }
            localView = getChildAt(paramInt4);
            if ((localView == null) || (localView.getVisibility() == 8) || (((ViewPager.LayoutParams)localView.getLayoutParams()).isDecor)) {
              break label975;
            }
            localView.layout(paramInt2, paramInt1, paramInt2 + i, localView.getMeasuredHeight() + paramInt1);
            paramInt2 += i;
          }
          label579:
          label975:
          for (;;)
          {
            paramInt4 += 1;
            break label491;
            i = i3 - paramInt2 - paramInt4;
            break;
            j = 0;
            if (j < i2)
            {
              localView = getChildAt(j);
              float f;
              if ((localView != null) && (localView.getVisibility() != 8))
              {
                localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
                if (!localLayoutParams.isDecor)
                {
                  ViewPager.ItemInfo localItemInfo = infoForChild(localView);
                  if (localItemInfo != null)
                  {
                    f = i;
                    m = (int)(localItemInfo.offset * f);
                    if (!this.mIsVertical) {
                      break label770;
                    }
                    m += paramInt1;
                    if (localLayoutParams.needsMeasure)
                    {
                      localLayoutParams.needsMeasure = false;
                      if (this.mIsVertical) {
                        break label779;
                      }
                      f = i;
                      localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.sizeFactor * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i1 - paramInt1 - paramInt3, 1073741824));
                    }
                    label731:
                    if (!this.mIsVertical) {
                      break label824;
                    }
                    localView.layout(paramInt2, m, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + m);
                  }
                }
              }
              for (;;)
              {
                j += 1;
                break;
                m += paramInt2;
                break label672;
                f = i;
                n = View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.sizeFactor * f), 1073741824);
                localView.measure(View.MeasureSpec.makeMeasureSpec(i3 - paramInt2 - paramInt4, 1073741824), n);
                break label731;
                localView.layout(m, paramInt1, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + paramInt1);
              }
            }
            label850:
            this.mTopPageBounds = paramInt1;
            this.mBottomPageBounds = (i1 - paramInt3);
            this.mDecorChildCount = k;
            this.mPageCount = (getChildCount() - this.mDecorChildCount);
            if ((this.mFirstLayout) || (this.mLayoutNeeded))
            {
              this.mLayoutNeeded = false;
              if (isGallery()) {
                break label955;
              }
              scrollToItem(this.mCurItem, false, 0, false);
            }
            for (;;)
            {
              if (this.mUpdateScreenNextCall)
              {
                scrollTo(getCurrentPage() * getWidth(), getScrollY());
                this.mUpdateScreenNextCall = false;
              }
              this.mFirstLayout = false;
              return;
              scrollTo(getCurrentPage() * getWidth(), getScrollY());
            }
          }
        }
        label770:
        label779:
        n = paramInt3;
        paramInt3 = paramInt2;
        paramInt2 = n;
        break label206;
      }
      paramInt2 = paramInt1;
      n = paramInt3;
      paramInt3 = paramInt2;
      paramInt2 = n;
      break label206;
      label1006:
      j = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = k;
      i = paramInt3;
      paramInt3 = j;
    }
  }
  
  boolean onLeftGlideBlank()
  {
    return (this.mLeftGlideBlankListener != null) && (this.mLeftGlideBlankListener.onGlideBlank(true));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredHeight();
    paramInt2 = getMeasuredWidth();
    int j;
    int k;
    label85:
    View localView;
    ViewPager.LayoutParams localLayoutParams;
    int m;
    int i1;
    int i;
    label190:
    int n;
    if (this.mIsVertical)
    {
      paramInt1 /= 10;
      this.mGutterSize = Math.min(paramInt1, this.mDefaultGutterSize);
      j = paramInt2 - getPaddingLeft() - getPaddingRight();
      paramInt1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
      int i2 = getChildCount();
      k = 0;
      if (k >= i2) {
        break label366;
      }
      localView = getChildAt(k);
      paramInt2 = paramInt1;
      if (localView != null)
      {
        paramInt2 = paramInt1;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
          paramInt2 = paramInt1;
          if (localLayoutParams != null)
          {
            paramInt2 = paramInt1;
            if (localLayoutParams.isDecor)
            {
              paramInt2 = localLayoutParams.gravity & 0x7;
              m = localLayoutParams.gravity & 0x70;
              i1 = -2147483648;
              i = -2147483648;
              if ((m != 48) && (m != 80)) {
                break label335;
              }
              m = 1;
              if ((paramInt2 != 3) && (paramInt2 != 5)) {
                break label341;
              }
              n = 1;
              label203:
              if (m == 0) {
                break label347;
              }
              paramInt2 = 1073741824;
              label212:
              if (localLayoutParams.width == -2) {
                break label582;
              }
              n = 1073741824;
              if (localLayoutParams.width == -1) {
                break label576;
              }
              paramInt2 = localLayoutParams.width;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localLayoutParams.height != -2)
      {
        i1 = 1073741824;
        if (localLayoutParams.height != -1) {
          i = localLayoutParams.height;
        }
      }
      for (;;)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, n), View.MeasureSpec.makeMeasureSpec(i, i1));
        paramInt2 = paramInt1;
        if (m != 0)
        {
          paramInt2 = paramInt1;
          if (localLayoutParams.takeHeightspace) {
            paramInt2 = paramInt1 - localView.getMeasuredHeight();
          }
        }
        k += 1;
        paramInt1 = paramInt2;
        break label85;
        paramInt1 = paramInt2 / 10;
        break;
        label335:
        m = 0;
        break label190;
        label341:
        n = 0;
        break label203;
        label347:
        paramInt2 = i1;
        if (n == 0) {
          break label212;
        }
        i = 1073741824;
        paramInt2 = i1;
        break label212;
        label366:
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i = getChildCount();
        paramInt2 = 0;
        if (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if ((localView != null) && (localView.getVisibility() != 8))
          {
            localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.isDecor))
            {
              if (!isGallery()) {
                break label489;
              }
              localView.measure(this.mChildWidthMeasureSpec, this.mChildHeightMeasureSpec);
            }
          }
          for (;;)
          {
            paramInt2 += 1;
            break;
            label489:
            float f;
            if (this.mIsVertical)
            {
              f = paramInt1;
              k = View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.sizeFactor * f), 1073741824);
              localView.measure(this.mChildWidthMeasureSpec, k);
            }
            else
            {
              f = j;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.sizeFactor * f), 1073741824), this.mChildHeightMeasureSpec);
            }
          }
        }
        return;
        i = paramInt1;
        continue;
        i1 = i;
        i = paramInt1;
      }
      label576:
      paramInt2 = j;
      continue;
      label582:
      n = paramInt2;
      paramInt2 = j;
    }
  }
  
  public boolean onOverScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (this.mIsVertical) {
      if (((paramInt4 == 0) && (paramInt2 < 0)) || ((paramInt4 == paramInt6) && (paramInt2 > 0))) {
        onOverScrollSuccess();
      }
    }
    for (;;)
    {
      return true;
      if (((paramInt3 == 0) && (paramInt1 < 0)) || ((paramInt3 == paramInt5) && (paramInt1 > 0))) {
        onOverScrollSuccess();
      }
    }
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
    int i;
    View localView;
    if (this.mDecorChildCount > 0)
    {
      int i3 = getScrollX();
      int i4 = getScrollY();
      int j = getPaddingLeft();
      int m = getPaddingRight();
      i = getPaddingTop();
      int k = getPaddingBottom();
      int i5 = getWidth();
      int i6 = getHeight();
      int i7 = getChildCount();
      int i1 = 0;
      while (i1 < i7)
      {
        localView = getChildAt(i1);
        ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.isDecor)
        {
          i1 += 1;
        }
        else
        {
          int n;
          int i2;
          int i8;
          if (!this.mIsVertical)
          {
            switch (localLayoutParams.gravity & 0x7)
            {
            case 2: 
            case 4: 
            default: 
              n = j;
              i2 = m;
              m = j;
              j = i2;
            }
            for (;;)
            {
              n = n + i3 - localView.getLeft();
              if (n != 0) {
                localView.offsetLeftAndRight(n);
              }
              n = j;
              j = m;
              m = n;
              break;
              n = localView.getWidth();
              i2 = n + j;
              n = j;
              j = m;
              m = i2;
              continue;
              n = Math.max((i5 - localView.getMeasuredWidth()) / 2, j);
              i2 = j;
              j = m;
              m = i2;
              continue;
              n = i5 - m - localView.getMeasuredWidth();
              i8 = localView.getMeasuredWidth();
              i2 = j;
              j = m + i8;
              m = i2;
            }
          }
          switch (localLayoutParams.gravity & 0x70)
          {
          default: 
            n = i;
            i2 = k;
            k = i;
            i = i2;
          }
          for (;;)
          {
            n = n + i4 - localView.getTop();
            if (n != 0) {
              localView.offsetLeftAndRight(n);
            }
            n = i;
            i = k;
            k = n;
            break;
            n = localView.getHeight();
            i2 = n + i;
            n = i;
            i = k;
            k = i2;
            continue;
            n = Math.max((i6 - localView.getMeasuredHeight()) / 2, i);
            i2 = i;
            i = k;
            k = i2;
            continue;
            n = i6 - i - localView.getMeasuredHeight();
            i8 = localView.getMeasuredHeight();
            i2 = i;
            i = k + i8;
            k = i2;
          }
        }
      }
    }
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mInternalPageChangeListener != null) {
      this.mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mPageTransformer != null) {
      if (!this.mIsVertical)
      {
        paramInt2 = getScrollX();
        i = getChildCount();
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          localView = getChildAt(paramInt1);
          if (((ViewPager.LayoutParams)localView.getLayoutParams()).isDecor) {}
          for (;;)
          {
            paramInt1 += 1;
            break;
            if (this.mIsVertical)
            {
              paramFloat = (localView.getTop() - getScrollY()) / getClientHeight();
              this.mPageTransformer.transformPage(localView, paramFloat);
            }
            else
            {
              paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
              this.mPageTransformer.transformPage(localView, paramFloat);
            }
          }
        }
      }
      else
      {
        paramInt2 = getScrollY();
        i = getChildCount();
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          localView = getChildAt(paramInt1);
          if (((ViewPager.LayoutParams)localView.getLayoutParams()).isDecor) {}
          for (;;)
          {
            paramInt1 += 1;
            break;
            paramFloat = (localView.getTop() - paramInt2) / getClientHeight();
            this.mPageTransformer.transformPage(localView, paramFloat);
          }
        }
      }
    }
    this.mCalledSuper = true;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int k = -1;
    int j = getChildCount();
    int i;
    if ((paramInt & 0x2) != 0)
    {
      k = 1;
      i = 0;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        ViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = j - 1;
          j = -1;
          continue;
        }
      }
      i += k;
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
    if (this.mAdapter != null)
    {
      this.mAdapter.restoreState(paramParcelable.adapterState, paramParcelable.loader);
      setCurrentItemInternal(paramParcelable.position, false, true);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.adapterState;
    this.mRestoredClassLoader = paramParcelable.loader;
  }
  
  boolean onRightGlideBlank()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mRightGlideBlankListener != null)
    {
      bool1 = bool2;
      if (this.mRightGlideBlankListener.onGlideBlank(false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    if (this.mAdapter != null) {
      localSavedState.adapterState = this.mAdapter.saveState();
    }
    return localSavedState;
  }
  
  void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
    {
      if (i != 0) {
        break label65;
      }
      i = 1;
    }
    try
    {
      for (;;)
      {
        this.mLastMotionX = paramMotionEvent.getX(i);
        this.mLastMotionY = paramMotionEvent.getY(i);
        this.mActivePointerId = paramMotionEvent.getPointerId(i);
        label50:
        if (this.mVelocityTracker != null) {
          this.mVelocityTracker.clear();
        }
        return;
        label65:
        i = 0;
      }
    }
    catch (Exception paramMotionEvent)
    {
      break label50;
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
    return true;
  }
  
  public void onTabPressed(int paramInt)
  {
    if (this.mSelectedListener != null) {
      this.mSelectedListener.onPageSelected(true, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = 0;
    boolean bool2 = false;
    boolean bool1;
    if (this.mFakeDragging) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (this.mForceUnableToDrag) {
        continue;
      }
      if (paramMotionEvent.getAction() == 0)
      {
        bool1 = bool2;
        if (paramMotionEvent.getEdgeFlags() != 0) {
          continue;
        }
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      int i = k;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      default: 
        i = k;
      case 4: 
        if (i != 0) {
          ViewCompatTool.postInvalidateOnAnimation(this);
        }
        return true;
      case 0: 
        label128:
        if ((this.mEnableCatching) && (this.mScroller != null) && (!this.mScroller.isFinished()))
        {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          setScrollState(1);
        }
        this.ignoreCheck = false;
      }
      try
      {
        float f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        i = k;
        break label128;
        if (!this.mIsBeingDragged)
        {
          if (this.mActivePointerId == -1)
          {
            Log.d("PageScroller,onTouch", "INVALID_POINTER");
            i = k;
            break label128;
          }
          j = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          i = k;
          if (j == -1) {
            break label128;
          }
        }
        label503:
        label510:
        do
        {
          for (;;)
          {
            try
            {
              f1 = paramMotionEvent.getX(j);
            }
            catch (Exception localException1)
            {
              try
              {
                f3 = paramMotionEvent.getY(j);
                f2 = f1;
                f1 = f3;
                f3 = Math.abs(f2 - this.mLastMotionX);
                f4 = Math.abs(f1 - this.mLastMotionY);
                if (!this.mIsVertical) {
                  break label530;
                }
                if ((f4 > this.mTouchSlop) && (f4 > f3) && (this.mScrollEnabled))
                {
                  if (f1 - this.mLastMotionY >= 0.0F) {
                    break label510;
                  }
                  bool1 = true;
                  if (onStartDrag(bool1))
                  {
                    this.mIsBeingDragged = true;
                    if (f1 - this.mInitialMotionY <= 0.0F) {
                      break label516;
                    }
                    f1 = this.mInitialMotionY + this.mTouchSlop;
                    this.mLastMotionY = f1;
                    this.mLastMotionX = f2;
                    setScrollState(1);
                    if (this.mDisallowInterceptWhenDrag)
                    {
                      ViewParent localViewParent = getParent();
                      if (localViewParent != null) {
                        localViewParent.requestDisallowInterceptTouchEvent(true);
                      }
                    }
                    setScrollingCacheEnabled(true);
                  }
                }
                i = k;
                if (!this.mIsBeingDragged) {
                  break;
                }
                if (this.mActivePointerId != -1) {
                  break label675;
                }
                Log.d("PageScroller,onTouch", "INVALID_POINTER");
                i = k;
              }
              catch (Exception localException3)
              {
                float f3;
                float f2;
                float f4;
                Object localObject;
                break label503;
              }
              localException1 = localException1;
              f1 = 0.0F;
            }
            f2 = f1;
            f1 = 0.0F;
            continue;
            bool1 = false;
            continue;
            f1 = this.mInitialMotionY - this.mTouchSlop;
          }
        } while ((f3 <= this.mTouchSlop) || (f3 <= f4) || (!this.mScrollEnabled));
        label516:
        label530:
        if (f2 - this.mLastMotionX < 0.0F)
        {
          bool1 = true;
          label570:
          if (!onStartDrag(bool1)) {
            break label659;
          }
          this.mIsBeingDragged = true;
          if (f2 - this.mInitialMotionX <= 0.0F) {
            break label661;
          }
        }
        label659:
        label661:
        for (f2 = this.mInitialMotionX + this.mTouchSlop;; f2 = this.mInitialMotionX - this.mTouchSlop)
        {
          this.mLastMotionX = f2;
          this.mLastMotionY = f1;
          setScrollState(1);
          if (this.mDisallowInterceptWhenDrag)
          {
            localObject = getParent();
            if (localObject != null) {
              ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
            }
          }
          setScrollingCacheEnabled(true);
          break;
          bool1 = false;
          break label570;
          break;
        }
        label675:
        j = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        i = k;
        if (j == -1) {
          break label128;
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              if (!this.mIsVertical) {
                break label765;
              }
              bool1 = performDrag(paramMotionEvent.getY(j));
              i = bool1 | false;
              j = i;
              try
              {
                if (this.mIsUnableToDrag)
                {
                  paramMotionEvent = getParent();
                  bool1 = bool2;
                  if (paramMotionEvent == null) {
                    break;
                  }
                  paramMotionEvent.requestDisallowInterceptTouchEvent(true);
                  return false;
                }
              }
              catch (Exception paramMotionEvent)
              {
                j = i;
              }
            }
          }
          catch (Exception paramMotionEvent)
          {
            label765:
            j = 0;
            continue;
          }
          i = j;
          break label128;
          bool1 = performDrag(paramMotionEvent.getX(j));
          i = bool1 | false;
        }
        i = k;
        if (!this.mIsBeingDragged) {
          break label128;
        }
        localObject = this.mVelocityTracker;
        if (localObject != null)
        {
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
          if (this.mIsVertical)
          {
            i = (int)((VelocityTracker)localObject).getYVelocity(this.mActivePointerId);
            label840:
            if (!isGallery()) {
              break label899;
            }
            upAction(i, paramMotionEvent);
          }
          for (;;)
          {
            for (;;)
            {
              label854:
              Log.d("ViewPager", "ACTION_UP");
              this.mActivePointerId = -1;
              this.ignoreCheck = false;
              endDrag();
              i = k;
              break;
              i = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
              break label840;
              label899:
              this.mPopulatePending = true;
              int n = getClientSize();
              if (this.mIsVertical)
              {
                j = getScrollY();
                label923:
                localObject = infoForCurrentScrollPosition();
                if (localObject == null) {}
              }
              else
              {
                try
                {
                  int m = ((ViewPager.ItemInfo)localObject).position;
                  f1 = (j / n - ((ViewPager.ItemInfo)localObject).offset) / ((ViewPager.ItemInfo)localObject).sizeFactor;
                  j = paramMotionEvent.findPointerIndex(this.mActivePointerId);
                  f2 = paramMotionEvent.getX(j);
                  f3 = paramMotionEvent.getY(j);
                  if (this.mIsVertical)
                  {
                    j = (int)(f3 - this.mInitialMotionY);
                    j = determineTargetPage(m, f1, i, j);
                    this.mTouching = true;
                    setCurrentItemInternal(j, true, true, 0, i);
                    this.mTouching = false;
                  }
                }
                catch (ArrayIndexOutOfBoundsException paramMotionEvent)
                {
                  for (;;)
                  {
                    break label854;
                    j = getScrollX();
                    break label923;
                    f3 = this.mInitialMotionX;
                    j = (int)(f2 - f3);
                    continue;
                    i = k;
                    if (!this.mIsBeingDragged) {
                      break;
                    }
                    this.ignoreCheck = false;
                    if (isGallery()) {
                      upAction(0, paramMotionEvent);
                    }
                    for (;;)
                    {
                      this.mActivePointerId = -1;
                      endDrag();
                      i = k;
                      break;
                      scrollToItem(this.mCurItem, true, 0, false);
                    }
                    i = paramMotionEvent.getActionIndex();
                    try
                    {
                      for (;;)
                      {
                        this.mLastMotionX = paramMotionEvent.getX(i);
                        this.mLastMotionY = paramMotionEvent.getY(i);
                        label1154:
                        this.mActivePointerId = paramMotionEvent.getPointerId(i);
                        i = k;
                        break;
                        onSecondaryPointerUp(paramMotionEvent);
                        try
                        {
                          this.mLastMotionX = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
                          this.mLastMotionY = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId));
                          i = k;
                        }
                        catch (Exception paramMotionEvent)
                        {
                          i = k;
                        }
                      }
                    }
                    catch (Exception localException2)
                    {
                      break label1154;
                    }
                  }
                }
                catch (IllegalArgumentException paramMotionEvent) {}
              }
            }
          }
        }
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          int j;
          continue;
          i = 0;
        }
      }
    }
  }
  
  boolean pageLeft()
  {
    if (this.mCurItem > 0)
    {
      setCurrentItem(this.mCurItem - 1, true);
      return true;
    }
    return false;
  }
  
  boolean pageRight()
  {
    if ((this.mAdapter != null) && (this.mCurItem < this.mAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    }
    return false;
  }
  
  protected boolean pageScrolled(int paramInt)
  {
    boolean bool = false;
    int i = getClientSize();
    int j = this.mPageMargin;
    float f;
    if ((this.mItems != null) && (this.mItems.size() == 0))
    {
      this.mCalledSuper = false;
      f = paramInt / i - this.mCurrentScreen;
      paramInt = (int)((j + i) * f);
      onPageScrolled(this.mCurrentScreen, f, paramInt);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      ViewPager.ItemInfo localItemInfo = infoForCurrentScrollPosition();
      f = this.mPageMargin / i;
      j = localItemInfo.position;
      f = (paramInt / i - localItemInfo.offset) / (localItemInfo.sizeFactor + f);
      this.mCalledSuper = false;
      onPageScrolled(j, f, 0);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  protected boolean performDrag(float paramFloat)
  {
    boolean bool = false;
    float f5;
    float f4;
    int j;
    int i;
    label64:
    label74:
    float f1;
    float f2;
    float f3;
    if (!this.mIsVertical)
    {
      f5 = this.mLastMotionX - paramFloat;
      this.mLastMotionX = paramFloat;
      float f6 = getScrollX();
      f4 = f6 + f5;
      j = getClientWidth();
      if (this.mAdapter == null)
      {
        i = 1;
        if (i == 0) {
          break label158;
        }
        paramFloat = getLeftEdge();
        if (i == 0) {
          break label170;
        }
        getRightEdge();
      }
      for (;;)
      {
        if (i == 0)
        {
          f1 = 3.4028235E+38F;
          paramFloat = 1.4E-45F;
          i = 0;
          for (;;)
          {
            if (i < this.mItems.size())
            {
              f2 = ((ViewPager.ItemInfo)this.mItems.get(i)).offset;
              f3 = f1;
              if (f2 < f1) {
                f3 = f2;
              }
              f1 = paramFloat;
              if (f2 > paramFloat) {
                f1 = f2;
              }
              i += 1;
              paramFloat = f1;
              f1 = f3;
              continue;
              i = 0;
              break;
              label158:
              paramFloat = j;
              paramFloat = this.mFirstOffset;
              break label64;
              label170:
              paramFloat = j;
              paramFloat = this.mLastOffset;
              break label74;
            }
          }
          f2 = j;
          if (this.mMinOffset == 1.4E-45F)
          {
            f2 *= f1;
            f1 = j;
            if (this.mMaxOffset != 3.4028235E+38F) {
              break label370;
            }
            label214:
            f1 = paramFloat * f1;
            Log.d("ViewPager", this + "performDrag,scrollX=" + f6 + ",leftBounds=" + f2 + ",rightBounds=" + f1);
            paramFloat = f2;
            label271:
            if (f4 >= paramFloat) {
              break label437;
            }
            if ((onLeftGlideBlank()) || (!this.mLeftDragOutSizeEnable)) {
              break label400;
            }
            f1 = f4 - f5 + f5 / 4.0F;
            if (f1 >= paramFloat - j / 3) {
              break label392;
            }
            paramFloat -= j / 3;
            bool = false;
          }
        }
      }
    }
    for (;;)
    {
      this.mLastMotionX += paramFloat - (int)paramFloat;
      scrollTo((int)paramFloat, getScrollY());
      pageScrolled((int)paramFloat);
      return bool;
      f1 = this.mMinOffset;
      break;
      label370:
      paramFloat = this.mMaxOffset;
      break label214;
      paramFloat = getLeftEdge();
      f1 = getRightEdge();
      break label271;
      label392:
      bool = true;
      paramFloat = f1;
      continue;
      label400:
      Object localObject = getParent();
      if (localObject != null) {
        ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
      }
      if (!this.mLeftDragOutSizeEnable) {
        this.mIsUnableToDrag = true;
      }
      bool = false;
      continue;
      label437:
      if (f4 > f1)
      {
        if ((!onRightGlideBlank()) && (this.mRightDragOutSizeEnable))
        {
          paramFloat = f4 - f5 + f5 / 4.0F;
          if (paramFloat > j / 3 + f1)
          {
            paramFloat = j / 3 + f1;
            bool = false;
          }
          else
          {
            bool = true;
          }
        }
        else
        {
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
          }
          if (!this.mRightDragOutSizeEnable) {
            this.mIsUnableToDrag = true;
          }
          paramFloat = f1;
          bool = false;
          continue;
          f3 = this.mLastMotionY - paramFloat;
          Log.d("ViewPager", "performDrag,x=" + paramFloat + ",delta=" + f3 + ",mLasty=" + this.mLastMotionY);
          this.mLastMotionY = paramFloat;
          f2 = getScrollY() + f3;
          int m = getClientSize();
          paramFloat = m * this.mFirstOffset;
          f1 = m * this.mLastOffset;
          if (this.mItems.size() > 0)
          {
            localObject = (ViewPager.ItemInfo)this.mItems.get(0);
            ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(this.mItems.size() - 1);
            if (((ViewPager.ItemInfo)localObject).position != 0)
            {
              paramFloat = ((ViewPager.ItemInfo)localObject).offset * m;
              i = 0;
              if (localItemInfo.position != this.mAdapter.getCount() - 1)
              {
                f1 = localItemInfo.offset;
                f4 = m;
                int k = 0;
                f1 *= f4;
                j = i;
                i = k;
              }
            }
          }
          for (;;)
          {
            if ((f2 < paramFloat) && (j != 0)) {
              if ((!onLeftGlideBlank()) && (this.mLeftDragOutSizeEnable))
              {
                f1 = f2 - f3 + f3 / 4.0F;
                if (f1 < paramFloat - m / 3) {
                  paramFloat -= m / 3;
                }
              }
            }
            for (;;)
            {
              this.mLastMotionY += paramFloat - (int)paramFloat;
              scrollTo(getScrollX(), (int)paramFloat);
              pageScrolled((int)paramFloat);
              return bool;
              bool = true;
              paramFloat = f1;
              continue;
              localObject = getParent();
              if (localObject != null) {
                ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
              }
              continue;
              if ((f2 > f1) && (i != 0))
              {
                if ((!onRightGlideBlank()) && (this.mRightDragOutSizeEnable))
                {
                  paramFloat = f2 - f3 + f3 / 4.0F;
                  if (paramFloat > m / 3 + f1) {
                    paramFloat = m / 3 + f1;
                  } else {
                    bool = true;
                  }
                }
                else
                {
                  localObject = getParent();
                  if (localObject != null) {
                    ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
                  }
                  paramFloat = f1;
                }
              }
              else {
                paramFloat = f2;
              }
            }
            j = i;
            i = 1;
            continue;
            i = 1;
            break;
            i = 1;
            j = 1;
          }
        }
      }
      else
      {
        paramFloat = f4;
        bool = false;
      }
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
    int i;
    Object localObject3;
    if (this.mCurItem != paramInt) {
      if (this.mCurItem < paramInt)
      {
        i = 66;
        localObject3 = infoForPosition(this.mCurItem);
        this.mCurItem = paramInt;
      }
    }
    for (int j = i;; j = 2)
    {
      if (this.mAdapter == null)
      {
        sortChildDrawingOrder();
        return;
        i = 17;
        break;
      }
      if (this.mPopulatePending)
      {
        sortChildDrawingOrder();
        return;
      }
      this.mAdapter.startUpdate(this, this.mCurItem);
      Object localObject1;
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
      int i2 = Math.min(i1 - 1, paramInt + this.mCurItem);
      Object localObject2;
      if ((getWindowToken() != null) && (i1 != this.mExpectedAdapterCount)) {
        try
        {
          localObject1 = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's QBPagerAdapter changed the adapter's contents without calling QBPagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + i1 + " Pager id: " + (String)localObject1 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject2 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.mItems.size())
      {
        localObject2 = (ViewPager.ItemInfo)this.mItems.get(paramInt);
        if (((ViewPager.ItemInfo)localObject2).position >= this.mCurItem) {
          if (((ViewPager.ItemInfo)localObject2).position != this.mCurItem) {
            break label1402;
          }
        }
      }
      for (;;)
      {
        if ((localObject2 == null) && (i1 > 0)) {}
        for (Object localObject4 = addNewItem(this.mCurItem, paramInt);; localObject4 = localObject2)
        {
          int n;
          label417:
          int i3;
          label436:
          label444:
          float f3;
          int m;
          int k;
          Object localObject5;
          float f1;
          if (localObject4 != null)
          {
            n = paramInt - 1;
            if (n < 0) {
              break label730;
            }
            localObject2 = (ViewPager.ItemInfo)this.mItems.get(n);
            i3 = getClientSize();
            if (!this.mIsVertical) {
              break label736;
            }
            i = getPaddingTop();
            if (i3 > 0) {
              break label745;
            }
            f2 = 0.0F;
            i = this.mCurItem;
            f3 = 0.0F;
            m = i - 1;
            k = paramInt;
            localObject5 = localObject2;
            if (m >= 0)
            {
              if ((f3 < f2) || (m >= i4)) {
                break label901;
              }
              if (localObject5 != null) {
                break label767;
              }
            }
            f1 = ((ViewPager.ItemInfo)localObject4).sizeFactor;
            i = k + 1;
            if (f1 < 2.0F)
            {
              if (i >= this.mItems.size()) {
                break label1021;
              }
              localObject2 = (ViewPager.ItemInfo)this.mItems.get(i);
              label535:
              if (!this.mIsVertical) {
                break label1027;
              }
              paramInt = getPaddingBottom();
              label547:
              if (i3 > 0) {
                break label1035;
              }
            }
          }
          label901:
          label1035:
          for (float f2 = 0.0F;; f2 = paramInt / i3 + 2.0F)
          {
            m = this.mCurItem;
            paramInt = i;
            i = m + 1;
            label570:
            if (i < i1)
            {
              if ((f1 < f2) || (i <= i2)) {
                break label1129;
              }
              if (localObject2 != null) {
                break label1048;
              }
            }
            calculatePageOffsets((ViewPager.ItemInfo)localObject4, k, (ViewPager.ItemInfo)localObject3);
            localObject3 = this.mAdapter;
            paramInt = this.mCurItem;
            if (localObject4 == null) {
              break label1274;
            }
            localObject2 = ((ViewPager.ItemInfo)localObject4).object;
            label629:
            ((ViewPagerAdapter)localObject3).setPrimaryItem(this, paramInt, localObject2);
            this.mAdapter.finishUpdate(this);
            i = getChildCount();
            paramInt = 0;
            while (paramInt < i)
            {
              localObject3 = getChildAt(paramInt);
              localObject2 = (ViewPager.LayoutParams)((View)localObject3).getLayoutParams();
              ((ViewPager.LayoutParams)localObject2).childIndex = paramInt;
              localObject3 = infoForChild((View)localObject3);
              if (localObject3 != null)
              {
                ((ViewPager.LayoutParams)localObject2).sizeFactor = ((ViewPager.ItemInfo)localObject3).sizeFactor;
                ((ViewPager.LayoutParams)localObject2).position = ((ViewPager.ItemInfo)localObject3).position;
              }
              paramInt += 1;
            }
            paramInt += 1;
            break;
            label730:
            localObject2 = null;
            break label417;
            label736:
            i = getPaddingLeft();
            break label436;
            label745:
            f1 = ((ViewPager.ItemInfo)localObject4).sizeFactor;
            f2 = i / i3 + (2.0F - f1);
            break label444;
            label767:
            localObject2 = localObject5;
            paramInt = n;
            f1 = f3;
            i = k;
            if (m == localObject5.position)
            {
              localObject2 = localObject5;
              paramInt = n;
              f1 = f3;
              i = k;
              if (!localObject5.scrolling)
              {
                this.mItems.remove(n);
                this.mAdapter.destroyItem(this, m, localObject5.object);
                paramInt = n - 1;
                i = k - 1;
                if (paramInt < 0) {
                  break label892;
                }
                localObject2 = (ViewPager.ItemInfo)this.mItems.get(paramInt);
                f1 = f3;
              }
            }
            for (;;)
            {
              m -= 1;
              localObject5 = localObject2;
              n = paramInt;
              f3 = f1;
              k = i;
              break;
              label892:
              localObject2 = null;
              f1 = f3;
              continue;
              if ((localObject5 != null) && (m == localObject5.position))
              {
                f1 = f3 + localObject5.sizeFactor;
                paramInt = n - 1;
                if (paramInt >= 0)
                {
                  localObject2 = (ViewPager.ItemInfo)this.mItems.get(paramInt);
                  i = k;
                }
                else
                {
                  localObject2 = null;
                  i = k;
                }
              }
              else
              {
                f1 = f3 + addNewItem(m, n + 1).sizeFactor;
                i = k + 1;
                if (n >= 0)
                {
                  localObject2 = (ViewPager.ItemInfo)this.mItems.get(n);
                  paramInt = n;
                }
                else
                {
                  localObject2 = null;
                  paramInt = n;
                }
              }
            }
            label1021:
            localObject2 = null;
            break label535;
            paramInt = getPaddingRight();
            break label547;
          }
          label1027:
          label1048:
          if ((i == ((ViewPager.ItemInfo)localObject2).position) && (!((ViewPager.ItemInfo)localObject2).scrolling))
          {
            this.mItems.remove(paramInt);
            this.mAdapter.destroyItem(this, i, ((ViewPager.ItemInfo)localObject2).object);
            if (paramInt < this.mItems.size()) {
              localObject2 = (ViewPager.ItemInfo)this.mItems.get(paramInt);
            }
          }
          for (;;)
          {
            i += 1;
            break label570;
            localObject2 = null;
            continue;
            label1129:
            if ((localObject2 != null) && (i == ((ViewPager.ItemInfo)localObject2).position))
            {
              f3 = ((ViewPager.ItemInfo)localObject2).sizeFactor;
              paramInt += 1;
              if (paramInt < this.mItems.size()) {}
              for (localObject2 = (ViewPager.ItemInfo)this.mItems.get(paramInt);; localObject2 = null)
              {
                f1 += f3;
                break;
              }
            }
            if (localObject2 != null) {
              this.mAdapter.destroyItem(this, ((ViewPager.ItemInfo)localObject2).position, ((ViewPager.ItemInfo)localObject2).object);
            }
            localObject2 = addNewItem(i, paramInt);
            paramInt += 1;
            f3 = ((ViewPager.ItemInfo)localObject2).sizeFactor;
            if (paramInt < this.mItems.size()) {}
            for (localObject2 = (ViewPager.ItemInfo)this.mItems.get(paramInt);; localObject2 = null)
            {
              f1 += f3;
              break;
            }
            label1274:
            localObject2 = null;
            break label629;
            sortChildDrawingOrder();
            if (!hasFocus()) {
              break;
            }
            localObject2 = findFocus();
            if (localObject2 != null) {}
            for (localObject2 = infoForAnyChild((View)localObject2);; localObject2 = null)
            {
              if ((localObject2 != null) && (((ViewPager.ItemInfo)localObject2).position == this.mCurItem)) {
                break label1390;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1384;
                }
                localObject2 = getChildAt(paramInt);
                localObject3 = infoForChild((View)localObject2);
                if ((localObject3 != null) && (((ViewPager.ItemInfo)localObject3).position == this.mCurItem) && (((View)localObject2).requestFocus(j))) {
                  break;
                }
                paramInt += 1;
              }
              label1384:
              break;
            }
            label1390:
            break;
          }
        }
        label1402:
        localObject2 = null;
      }
      localObject3 = null;
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
    if (isGallery()) {}
    do
    {
      do
      {
        return;
        if ((paramInt2 <= 0) || (this.mItems.isEmpty())) {
          break;
        }
        int i = getPaddingLeft();
        int j = getPaddingRight();
        int k = getPaddingLeft();
        int m = getPaddingRight();
        f = getScrollX() / (paramInt2 - k - m + paramInt4);
        paramInt2 = (int)((paramInt1 - i - j + paramInt3) * f);
        scrollTo(paramInt2, getScrollY());
      } while (this.mScroller.isFinished());
      paramInt3 = this.mScroller.getDuration();
      paramInt4 = this.mScroller.timePassed();
      localItemInfo = infoForPosition(this.mCurItem);
    } while (localItemInfo == null);
    this.mScroller.startScroll(paramInt2, 0, (int)(localItemInfo.offset * paramInt1), 0, paramInt3 - paramInt4);
    return;
    ViewPager.ItemInfo localItemInfo = infoForPosition(this.mCurItem);
    if (localItemInfo != null) {}
    for (float f = Math.min(localItemInfo.offset, this.mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      completeScroll(false);
      scrollTo(paramInt1, getScrollY());
      return;
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
    int i;
    if (isGallery()) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        if (paramView1 != getChildAt(i)) {
          break label48;
        }
        if (i != this.mCurrentScreen) {
          snapToScreen(i, 0, true);
        }
      }
      return;
      label48:
      i += 1;
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    ViewPager.ItemInfo localItemInfo = infoForPosition(paramInt1);
    float f;
    if (localItemInfo != null) {
      f = getClientSize();
    }
    for (int i = (int)(Math.max(this.mFirstOffset, Math.min(localItemInfo.offset, this.mLastOffset)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        if (this.mIsVertical) {
          smoothScrollTo(0, i, paramInt2, paramInt3);
        }
        for (;;)
        {
          if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
            this.mOnPageChangeListener.onPageSelected(paramInt1);
          }
          if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
            this.mInternalPageChangeListener.onPageSelected(paramInt1);
          }
          if ((this.mSelectedListener != null) && (paramBoolean3)) {
            this.mSelectedListener.onPageSelected(false, this.mCurItem);
          }
          return;
          smoothScrollTo(i, 0, paramInt2, paramInt3);
        }
      }
      if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
        this.mOnPageChangeListener.onPageSelected(paramInt1);
      }
      if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
        this.mInternalPageChangeListener.onPageSelected(paramInt1);
      }
      this.mScrollToNeedNotify = true;
      completeScroll(false);
      if (this.mIsVertical) {
        scrollTo(0, i);
      }
      for (;;)
      {
        pageScrolled(i);
        break;
        scrollTo(i, 0);
      }
    }
  }
  
  void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    scrollToItem(paramInt1, paramBoolean1, 0, paramInt2, paramBoolean2, this.mTouching);
  }
  
  public void setAdapter(ViewPagerAdapter paramViewPagerAdapter)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
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
    Object localObject = this.mAdapter;
    this.mAdapter = paramViewPagerAdapter;
    this.mExpectedAdapterCount = 0;
    boolean bool;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new ViewPager.PagerObserver(this);
      }
      this.mAdapter.registerDataSetObserver(this.mObserver);
      this.mPopulatePending = false;
      bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem < 0) {
        break label263;
      }
      this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
      setCurrentItemInternal(this.mRestoredCurItem, false, true);
      this.mRestoredCurItem = -1;
      this.mRestoredAdapterState = null;
      this.mRestoredClassLoader = null;
    }
    for (;;)
    {
      if ((this.mAdapterChangeListener != null) && (localObject != paramViewPagerAdapter)) {
        this.mAdapterChangeListener.onAdapterChanged((ViewPagerAdapter)localObject, paramViewPagerAdapter);
      }
      return;
      label263:
      if (!bool) {
        populate();
      } else {
        requestLayout();
      }
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
    if (!this.mFirstLayout) {}
    for (boolean bool = true;; bool = false)
    {
      setCurrentItemInternal(paramInt, bool, false);
      return;
    }
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
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    label259:
    for (;;)
    {
      int i = this.mOffscreenPageLimit;
      if ((paramInt1 > this.mCurItem + i) || (paramInt1 < this.mCurItem - i))
      {
        i = 0;
        for (;;)
        {
          if (i < this.mItems.size())
          {
            ((ViewPager.ItemInfo)this.mItems.get(i)).scrolling = true;
            i += 1;
            continue;
            if (paramInt1 < this.mAdapter.getCount()) {
              break label259;
            }
            paramInt1 = this.mAdapter.getCount() - 1;
            break;
          }
        }
      }
      if (this.mCurItem != paramInt1) {}
      for (paramBoolean2 = true; this.mFirstLayout; paramBoolean2 = false)
      {
        this.mCurItem = paramInt1;
        if (((paramBoolean2) || (this.mCallPageChangedOnFirstLayout)) && (this.mOnPageChangeListener != null)) {
          this.mOnPageChangeListener.onPageSelected(paramInt1);
        }
        if (((paramBoolean2) || (this.mCallPageChangedOnFirstLayout)) && (this.mInternalPageChangeListener != null)) {
          this.mInternalPageChangeListener.onPageSelected(paramInt1);
        }
        requestLayout();
        return;
      }
      populate(paramInt1, true);
      scrollToItem(paramInt1, paramBoolean1, paramInt2, paramInt3, paramBoolean2, this.mTouching);
      return;
    }
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
      if (this.mOnPageChangeListener != null) {
        this.mOnPageChangeListener.onPageSelected(paramInt);
      }
      this.mCurrentScreen = paramInt;
      Log.d("TMYGALLERY", "setCurrentPage,currScreen=" + this.mCurrentScreen);
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
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
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
    int j = 1;
    if (!isGallery())
    {
      boolean bool1;
      boolean bool2;
      label27:
      int i;
      if (paramPageTransformer != null)
      {
        bool1 = true;
        if (this.mPageTransformer == null) {
          break label80;
        }
        bool2 = true;
        if (bool1 == bool2) {
          break label86;
        }
        i = 1;
        label36:
        this.mPageTransformer = paramPageTransformer;
        setChildrenDrawingOrderEnabled(bool1);
        if (!bool1) {
          break label91;
        }
        if (paramBoolean) {
          j = 2;
        }
      }
      label80:
      label86:
      label91:
      for (this.mDrawingOrder = j;; this.mDrawingOrder = 0)
      {
        if (i != 0) {
          populate();
        }
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label27;
        i = 0;
        break label36;
      }
    }
    this.mPageTransformer = paramPageTransformer;
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
    if ((this.mPageTransformer == null) || ((paramInt == 1) && (this.mNextScreen != -1) && (isGallery()))) {
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
    if ((getChildCount() == 0) || (this.mAdapter == null))
    {
      setScrollingCacheEnabled(false);
      return;
    }
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
    float f3 = Math.min(1.0F, Math.abs(i) * 1.0F / paramInt1);
    float f1 = m;
    float f2 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    if (paramInt3 <= 0) {
      if ((this.mTouching) || (this.mAutoScrollCustomDuration < 0))
      {
        paramInt3 = Math.abs(paramInt4);
        if (paramInt3 > 0)
        {
          paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;
          paramInt1 = Math.min(paramInt1, 600);
        }
      }
    }
    for (;;)
    {
      this.mScroller.startScroll(j, k, i, paramInt2, paramInt1);
      ViewCompatTool.postInvalidateOnAnimation(this);
      return;
      f1 = paramInt1;
      f2 = this.mAdapter.getPageSize(this.mCurItem);
      if (this.mIsVertical) {}
      for (paramInt1 = paramInt2;; paramInt1 = i)
      {
        paramInt1 = (int)((Math.abs(paramInt1) / (f2 * f1 + this.mPageMargin) + 1.0F) * 100.0F);
        break;
      }
      paramInt1 = this.mAutoScrollCustomDuration;
      continue;
      paramInt1 = paramInt3;
    }
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
      int j = Math.max(1, Math.abs(paramInt1 - this.mCurrentScreen));
      int i = getWidth() * paramInt1 - getScrollX();
      j = (j + 1) * 100;
      if (!this.mScroller.isFinished()) {
        this.mScroller.abortAnimation();
      }
      paramInt2 = Math.abs(paramInt2);
      if (paramInt2 > 0)
      {
        float f = j;
        paramInt2 = (int)(j / (paramInt2 / 2500.0F) * 0.4F + f);
      }
      for (;;)
      {
        setScrollState(2);
        if (i == 0) {
          setScrollState(0);
        }
        this.mScroller.startScroll(getScrollX(), 0, i, 0, 500);
        if (this.mOnPageChangeListener != null) {
          this.mOnPageChangeListener.onPageSelected(paramInt1);
        }
        if (this.mInternalPageChangeListener != null) {
          this.mInternalPageChangeListener.onPageSelected(paramInt1);
        }
        invalidate();
        return;
      }
    }
    setCurrentPage(paramInt1);
  }
  
  void sortChildDrawingOrder()
  {
    if (this.mDrawingOrder != 0)
    {
      if (this.mDrawingOrderedChildren == null) {
        this.mDrawingOrderedChildren = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.mDrawingOrderedChildren.add(localView);
          i += 1;
        }
        this.mDrawingOrderedChildren.clear();
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
    int j = getScrollX();
    if (i == 0) {
      return;
    }
    int k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
    float f1 = this.mInitialMotionX;
    try
    {
      float f2 = paramMotionEvent.getX(k);
      f1 = f2;
    }
    catch (Exception paramMotionEvent)
    {
      label44:
      boolean bool;
      break label44;
    }
    if ((Math.abs((int)(f1 - this.mInitialMotionX)) > this.mFlingDistance) && (Math.abs(paramInt) > this.mMinimumVelocity)) {
      if (paramInt < 0)
      {
        bool = true;
        i = findNextPosition(bool);
      }
    }
    for (;;)
    {
      snapToScreen(Math.min(Math.max(i, getLeftBoundPageIndex()), getRightBoundPageIndex()), paramInt, true);
      return;
      bool = false;
      break;
      if (j - j / i * i > i * 0.5D) {
        i = j / i + 1;
      } else {
        i = j / i;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.viewpager.ViewPager
 * JD-Core Version:    0.7.0.1
 */