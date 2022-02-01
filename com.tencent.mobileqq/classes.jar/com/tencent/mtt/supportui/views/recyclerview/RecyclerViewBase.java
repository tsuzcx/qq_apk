package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.tencent.mtt.supportui.utils.ViewCompatTool;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import com.tencent.mtt.supportui.utils.struct.Pools.Pool;
import com.tencent.mtt.supportui.utils.struct.Pools.SimplePool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RecyclerViewBase
  extends ViewGroup
{
  protected static final int AUTO_SCROLL_DELAY_DURATION = 800;
  public static final boolean DEBUG = false;
  public static final int DIRECTION_DOWN = 1;
  public static final int DIRECTION_UP = -1;
  static final boolean DISPATCH_TEMP_DETACH = false;
  static final boolean ENABLE_PREDICTIVE_ANIMATIONS = false;
  public static final int HORIZONTAL = 0;
  static final int INVALID_POINTER = -1;
  public static final int INVALID_TYPE = -1;
  public static final int LAYOUT_TYPE_GRID = 2;
  public static final int LAYOUT_TYPE_LIST = 1;
  public static final int LAYOUT_TYPE_WATERFALL = 3;
  static final int MAX_SCROLL_DURATION = 2000;
  public static final long NO_ID = -1L;
  public static final int NO_POSITION = -2147483648;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  static final String TAG = "RecyclerViewBase";
  private static final int TOUCH_DOWN_WHEN_SETTING_CHECK_INTERVAL = 50;
  public static final int TRAVERSAL_PURPOSE_ITEMCHANGE = 1991103;
  public static final int TRAVERSAL_PURPOSE_MODECHANGE = 1991102;
  public static final int VERTICAL = 1;
  static final Interpolator sQuinticInterpolator = new RecyclerViewBase.3();
  private IBlockTouchListener blockTouchListener;
  public boolean checkNotifyFooterOnRelease;
  public boolean filterCheckNotifyFooterAppeared = false;
  protected boolean forceBlockTouch;
  protected boolean isAutoScrolling = false;
  RecyclerViewBase.OnItemTouchListener mActiveOnItemTouchListener;
  public RecyclerViewBase.Adapter<RecyclerViewBase.ViewHolder> mAdapter;
  boolean mAdapterUpdateDuringMeasure;
  public boolean mAnimatingBlockTouch;
  int mAnimatingViewIndex = -1;
  int mAnimatingViewPos = -1;
  int mAnimatingViewPrevPos = -1;
  protected RecyclerViewBase.AutoScrollRunnable mAutoScrollRunnable;
  protected boolean mBlockScroll = false;
  private boolean mDisallowParentInterceptTouchEventWhenDrag = true;
  protected boolean mDownOverScrollEnabled;
  boolean mEatRequestLayout;
  private boolean mEnableRecyclerViewTouchListener = false;
  protected boolean mEnterCalled;
  protected int mEnterPos;
  protected boolean mExchangeFromBigger;
  protected boolean mExitCalled;
  protected int mExitPos;
  boolean mHasFixedSize;
  boolean mHasSuspentedItem;
  protected boolean mHorizontalCanScroll = true;
  boolean mInPreLayout = false;
  protected int mInitialTouchX;
  protected int mInitialTouchY;
  boolean mIsAttached;
  protected boolean mIsChangingMode = false;
  boolean mIsTouching;
  protected Runnable mItemAnimatorRunner = new RecyclerViewBase.2(this);
  final ArrayList<RecyclerViewBase.ItemDecoration> mItemDecorations = new ArrayList();
  protected boolean mItemsAddedOrRemoved = false;
  protected boolean mItemsChanged = false;
  protected int mLastTouchX;
  protected int mLastTouchY;
  public RecyclerViewBase.LayoutManager mLayout;
  boolean mLayoutRequestEaten;
  public int mLayoutType;
  final int mMaxFlingVelocity;
  final int mMinFlingVelocity;
  public int mNeedStopAtTitleIndex = -1;
  int mNumAnimatingViews = 0;
  final RecyclerViewBase.RecyclerViewDataObserver mObserver = new RecyclerViewBase.RecyclerViewDataObserver(this);
  public int mOffsetX = 0;
  public int mOffsetY = 0;
  final ArrayList<RecyclerViewBase.OnItemTouchListener> mOnItemTouchListeners = new ArrayList();
  final ArrayList<RecyclerViewBase.UpdateOp> mPendingLayoutUpdates = new ArrayList();
  RecyclerViewBase.SavedState mPendingSavedState;
  final ArrayList<RecyclerViewBase.UpdateOp> mPendingUpdates = new ArrayList();
  final boolean mPostUpdatesOnAnimation;
  protected boolean mPostedAnimatorRunner = false;
  protected RecyclerViewBase.Recycler mRecycler = new RecyclerViewBase.Recycler(this);
  RecyclerViewBase.OnScrollListener mScrollListener;
  protected int mScrollPointerId = -1;
  protected boolean mScrollRunnablePosted;
  protected int mScrollState = 0;
  private boolean mShouldPrebindItem = false;
  public final RecyclerViewBase.State mState = new RecyclerViewBase.State();
  boolean mStopAtTitle = false;
  final Rect mTempRect = new Rect();
  private Runnable mTouchDownWhenSettlingCheckRunnable = null;
  private boolean mTouchDownWhenSettlingFlag = false;
  private int mTouchEventState = 1;
  protected final int mTouchSlop;
  protected boolean mUpOverScrollEnabled;
  final Runnable mUpdateChildViewsRunnable = new RecyclerViewBase.1(this);
  Pools.Pool<RecyclerViewBase.UpdateOp> mUpdateOpPool = new Pools.SimplePool(30);
  boolean mUseRepeatableSuspensionMode = true;
  protected VelocityTracker mVelocityTracker;
  protected boolean mVerticalCanScroll = true;
  public final RecyclerViewBase.ViewFlinger mViewFlinger = new RecyclerViewBase.ViewFlinger(this);
  public boolean needNotifyFooter = false;
  public boolean optimizeHeaderRefresh = false;
  int[] tmpResult = new int[2];
  
  public RecyclerViewBase(Context paramContext)
  {
    super(paramContext);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    this.mPostUpdatesOnAnimation = bool;
    paramContext = ViewConfiguration.get(paramContext);
    this.mTouchSlop = paramContext.getScaledTouchSlop();
    this.mMinFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = paramContext.getScaledMaximumFlingVelocity();
    setWillNotDraw(false);
    setHasFixedSize(true);
    this.mAutoScrollRunnable = new RecyclerViewBase.AutoScrollRunnable(this);
    this.mTouchDownWhenSettlingCheckRunnable = new RecyclerViewBase.4(this);
  }
  
  private void disableHolderRecyclable(int paramInt)
  {
    Object localObject = findViewHolderForPosition(paramInt, true);
    if (localObject != null)
    {
      ((RecyclerViewBase.ViewHolder)localObject).setIsRecyclable(false);
      return;
    }
    localObject = this.mState;
    ((RecyclerViewBase.State)localObject).mDeletedInvisibleItemCountSincePreviousLayout += 1;
  }
  
  protected static RecyclerViewBase.ViewHolder getChildViewHolderInt(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mViewHolder;
  }
  
  void absorbGlows(int paramInt1, int paramInt2) {}
  
  public void addAnimatingView(View paramView)
  {
    addAnimatingView(paramView, false);
  }
  
  public void addAnimatingView(View paramView, boolean paramBoolean)
  {
    if (this.mNumAnimatingViews > 0)
    {
      i = this.mAnimatingViewIndex;
      while (i < getChildCount())
      {
        if (getChildAt(i) == paramView)
        {
          i = 1;
          break label43;
        }
        i += 1;
      }
    }
    int i = 0;
    label43:
    if (i == 0)
    {
      this.mNumAnimatingViews += 1;
      if (paramBoolean) {
        addViewInLayout(paramView, -1, paramView.getLayoutParams(), true);
      } else {
        addView(paramView);
      }
      this.mAnimatingViewIndex = (getChildCount() - this.mNumAnimatingViews);
    }
    this.mRecycler.unscrapView(getChildViewHolder(paramView));
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (!this.mLayout.onAddFocusables(this, paramArrayList, paramInt1, paramInt2)) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public void addItemDecoration(RecyclerViewBase.ItemDecoration paramItemDecoration)
  {
    addItemDecoration(paramItemDecoration, -1);
  }
  
  public void addItemDecoration(RecyclerViewBase.ItemDecoration paramItemDecoration, int paramInt)
  {
    if (this.mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    if (paramInt < 0) {
      this.mItemDecorations.add(paramItemDecoration);
    } else {
      this.mItemDecorations.add(paramInt, paramItemDecoration);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void addOnItemTouchListener(RecyclerViewBase.OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.add(paramOnItemTouchListener);
  }
  
  public void addOnItemTouchListenerToFront(RecyclerViewBase.OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.add(0, paramOnItemTouchListener);
  }
  
  protected void animateAppearance(RecyclerViewBase.ViewHolder paramViewHolder, Rect paramRect, int paramInt1, int paramInt2)
  {
    View localView = paramViewHolder.itemView;
    if ((paramRect != null) && (paramRect.left == paramInt1)) {
      paramInt1 = paramRect.top;
    }
    paramViewHolder.setIsRecyclable(false);
  }
  
  protected void animateDisappearance(RecyclerViewBase.ItemHolderInfo paramItemHolderInfo)
  {
    View localView = paramItemHolderInfo.holder.itemView;
    addAnimatingView(localView);
    int i = paramItemHolderInfo.left;
    int j = paramItemHolderInfo.top;
    int k = localView.getLeft();
    int m = localView.getTop();
    if ((i == k) && (j == m))
    {
      paramItemHolderInfo.holder.setIsRecyclable(false);
      return;
    }
    paramItemHolderInfo.holder.setIsRecyclable(false);
    localView.layout(k, m, localView.getWidth() + k, localView.getHeight() + m);
  }
  
  protected boolean canChangeOrder(int paramInt)
  {
    RecyclerViewBase.ViewHolder localViewHolder = findViewHolderForPosition(paramInt, true);
    if (localViewHolder != null) {
      return localViewHolder.canChangeOrder();
    }
    return false;
  }
  
  protected boolean canTranversal(int paramInt, RecyclerViewBase.ViewHolder paramViewHolder)
  {
    return true;
  }
  
  public void cancelTouch()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    releaseGlows(false, true);
    setScrollState(0);
  }
  
  protected boolean changeUpOverScrollEnableOnComputeDxDy(int paramInt1, int paramInt2, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    return paramBoolean3;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof RecyclerViewBase.LayoutParams)) && (this.mLayout.checkLayoutParams((RecyclerViewBase.LayoutParams)paramLayoutParams));
  }
  
  public void checkNotifyFooterAppearWithFewChild(int paramInt) {}
  
  protected void checkRefreshHeadOnFlingRun() {}
  
  protected boolean checkShouldCallScrollFinish(Scroller paramScroller, int paramInt)
  {
    return paramScroller.getCurrY() == paramInt;
  }
  
  protected boolean checkShouldConsumePendingUpdates()
  {
    return true;
  }
  
  protected boolean checkShouldInvalidateInScroll()
  {
    return true;
  }
  
  protected boolean checkShouldStopScroll()
  {
    return false;
  }
  
  void clearOldPositions()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(i));
      if (localViewHolder != null) {
        localViewHolder.clearOldPosition();
      }
      i += 1;
    }
    this.mRecycler.clearOldPositions();
  }
  
  int[] computeDxDy(int paramInt1, int paramInt2, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2)
  {
    int[] arrayOfInt = this.tmpResult;
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    int k = getSpringBackMaxDistance();
    boolean bool2 = this.mUpOverScrollEnabled;
    boolean bool1 = this.mDownOverScrollEnabled;
    bool2 = changeUpOverScrollEnableOnComputeDxDy(paramInt1, paramInt2, paramBoolean1, paramScroller, paramBoolean2, bool2);
    int i;
    int j;
    int m;
    if (paramInt1 != 0)
    {
      i = this.mOffsetX;
      if (i + paramInt1 < 0) {
        if (!bool2)
        {
          paramInt1 = -i;
          i = paramInt1;
          if (paramScroller == null) {
            break label379;
          }
          i = paramInt1;
        }
      }
      for (;;)
      {
        paramScroller.forceFinished(true);
        break label379;
        if ((i < 0) && (paramInt1 <= 0))
        {
          j = paramInt1 / 3;
          if ((j != 0) && (paramBoolean2)) {}
        }
        else
        {
          j = paramInt1;
        }
        paramInt1 = this.mOffsetX;
        i = j;
        if (paramInt1 + j > -k) {
          break label379;
        }
        i = j;
        if (!paramBoolean1) {
          break label379;
        }
        paramInt1 = -paramInt1 - k;
        i = paramInt1;
        if (paramScroller == null) {
          break label379;
        }
        i = paramInt1;
        continue;
        if (i + paramInt1 <= this.mState.mTotalHeight - getWidth()) {
          break;
        }
        if (!bool1)
        {
          if (this.mState.mTotalHeight <= getWidth()) {
            paramInt1 = 0;
          } else {
            paramInt1 = this.mState.mTotalHeight - getWidth() - this.mOffsetX;
          }
          i = paramInt1;
          if (paramScroller == null) {
            break label379;
          }
          i = paramInt1;
        }
        else
        {
          if ((this.mOffsetX > this.mState.mTotalHeight - getWidth()) && (paramInt1 >= 0))
          {
            j = paramInt1 / 3;
            if ((j != 0) && (paramBoolean2)) {}
          }
          else
          {
            j = paramInt1;
          }
          if (this.mState.mTotalHeight <= getWidth()) {
            paramInt1 = 0;
          } else {
            paramInt1 = this.mState.mTotalHeight - getWidth();
          }
          m = this.mOffsetX;
          i = j;
          if (m + j < paramInt1 + k) {
            break label379;
          }
          i = j;
          if (!paramBoolean1) {
            break label379;
          }
          paramInt1 = -m + paramInt1 + k;
          i = paramInt1;
          if (paramScroller == null) {
            break label379;
          }
          i = paramInt1;
        }
      }
    }
    else
    {
      i = paramInt1;
    }
    label379:
    if (paramInt2 != 0)
    {
      j = this.mOffsetY;
      if (j + paramInt2 <= 0)
      {
        if (!bool2)
        {
          paramInt1 = -j;
          if ((paramScroller != null) && (paramScroller.isFling())) {
            onFlingToTopEdge(paramScroller.getCurrVelocity(), paramInt2 + j);
          } else if (this.mIsTouching) {
            onScrollToTopEdge();
          }
          if (paramScroller != null) {
            paramScroller.forceFinished(true);
          }
        }
        else
        {
          if ((j < 0) && (paramInt2 <= 0))
          {
            j = paramInt2 / 3;
            if ((j != 0) && (paramBoolean2)) {}
          }
          else
          {
            j = paramInt2;
          }
          paramInt2 = this.mOffsetY;
          paramInt1 = j;
          if (paramInt2 + j <= -k)
          {
            paramInt1 = j;
            if (paramBoolean1)
            {
              paramInt2 = -paramInt2 - k;
              paramInt1 = paramInt2;
              if (paramScroller != null) {
                paramInt1 = paramInt2;
              }
            }
          }
        }
      }
      else {
        for (;;)
        {
          paramScroller.forceFinished(true);
          break label789;
          if (j + paramInt2 > this.mState.mTotalHeight - getHeight())
          {
            if (!bool1)
            {
              if (this.mState.mTotalHeight <= getHeight()) {
                paramInt2 = 0;
              } else {
                paramInt2 = this.mState.mTotalHeight - getHeight() - this.mOffsetY;
              }
              paramInt1 = paramInt2;
              if (paramScroller == null) {
                break label789;
              }
              paramInt1 = paramInt2;
            }
            else
            {
              if ((this.mOffsetY > this.mState.mTotalHeight - getHeight()) && (paramInt2 >= 0))
              {
                j = paramInt2 / 3;
                if ((j != 0) && (paramBoolean2)) {}
              }
              else
              {
                j = paramInt2;
              }
              if (this.mState.mTotalHeight <= getHeight()) {
                paramInt2 = 0;
              } else {
                paramInt2 = this.mState.mTotalHeight - getHeight();
              }
              m = this.mOffsetY;
              paramInt1 = j;
              if (m + j < paramInt2 + k) {
                break label789;
              }
              paramInt1 = j;
              if (!paramBoolean1) {
                break label789;
              }
              paramInt2 = -m + paramInt2 + k;
              paramInt1 = paramInt2;
              if (paramScroller == null) {
                break label789;
              }
              paramInt1 = paramInt2;
            }
          }
          else
          {
            if ((!this.mStopAtTitle) || (this.mNeedStopAtTitleIndex == -1)) {
              break;
            }
            paramInt1 = getStopPosition();
            j = this.mOffsetY;
            if (j + paramInt2 >= paramInt1) {
              break;
            }
            paramInt2 = paramInt1 - j;
            paramInt1 = paramInt2;
            if (paramScroller == null) {
              break label789;
            }
            paramInt1 = paramInt2;
          }
        }
      }
    }
    else
    {
      paramInt1 = paramInt2;
    }
    label789:
    arrayOfInt[0] = i;
    arrayOfInt[1] = paramInt1;
    return arrayOfInt;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    if (this.mLayout.canScrollHorizontally()) {
      return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }
    return 0;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    if (this.mLayout.canScrollHorizontally()) {
      return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }
    return 0;
  }
  
  protected int computeHorizontalScrollRange()
  {
    if (this.mLayout.canScrollHorizontally()) {
      return this.mLayout.computeHorizontalScrollRange(this.mState);
    }
    return 0;
  }
  
  protected int computeVerticalScrollExtent()
  {
    if (this.mLayout.canScrollVertically()) {
      return this.mLayout.computeVerticalScrollExtent(this.mState);
    }
    return 0;
  }
  
  protected int computeVerticalScrollOffset()
  {
    if (this.mLayout.canScrollVertically()) {
      return this.mLayout.computeVerticalScrollOffset(this.mState);
    }
    return 0;
  }
  
  protected int computeVerticalScrollRange()
  {
    if (this.mLayout.canScrollVertically()) {
      return this.mLayout.computeVerticalScrollRange(this.mState);
    }
    return 0;
  }
  
  protected void consumePendingUpdateOperations()
  {
    if (this.mPendingUpdates.size() > 0) {
      this.mUpdateChildViewsRunnable.run();
    }
  }
  
  public RecyclerViewBase.ViewHolder createViewHolder(View paramView, RecyclerViewBase paramRecyclerViewBase)
  {
    return null;
  }
  
  protected boolean dirtyInRange(int paramInt1, int paramInt2)
  {
    int j = getFirstVisibleItemPos();
    if (j == -1) {
      return true;
    }
    int i = paramInt1 - j;
    j = paramInt2 - j;
    if (i >= j) {
      paramInt1 = j;
    } else {
      paramInt1 = i;
    }
    paramInt2 = paramInt1;
    while (paramInt2 <= i + j - paramInt1)
    {
      RecyclerViewItem localRecyclerViewItem = (RecyclerViewItem)getChildAtInItem(paramInt2);
      if ((localRecyclerViewItem != null) && (localRecyclerViewItem.mHolder != null) && (localRecyclerViewItem.mHolder.mPosDirty)) {
        return true;
      }
      paramInt2 += 1;
    }
    return false;
  }
  
  protected void dispatchLayout()
  {
    if (this.mAdapter == null) {
      return;
    }
    eatRequestLayout();
    if ((this.mItemsAddedOrRemoved) || (this.mItemsChanged) || (this.mState.mStructureChanged)) {
      this.mAdapter.dataChanged();
    }
    boolean bool = isAnimateChangeSimple(false, false);
    this.mItemsChanged = false;
    this.mItemsAddedOrRemoved = false;
    this.mState.mCustomHeaderHeight = this.mAdapter.getCustomHeaderViewHeight();
    this.mState.mCustomFooterHeight = this.mAdapter.getCustomFooterViewHeight();
    this.mState.mCustomHeaderWidth = this.mAdapter.getCustomHeaderViewWidth();
    this.mState.mCustomFooterWidth = this.mAdapter.getCustomFooterViewWidth();
    Object localObject1 = this.mState;
    ((RecyclerViewBase.State)localObject1).mInPreLayout = false;
    ((RecyclerViewBase.State)localObject1).mItemCount = this.mAdapter.getItemCount();
    this.mState.mTotalHeight = this.mAdapter.getListTotalHeight();
    this.mState.mHeaderCount = this.mAdapter.getHeaderViewCount();
    this.mState.mFooterCount = this.mAdapter.getFooterViewCount();
    int j;
    int i;
    Object localObject2;
    if (bool)
    {
      this.mState.mPreLayoutHolderMap.clear();
      this.mState.mPostLayoutHolderMap.clear();
      j = getChildCountInItem();
      i = 0;
      while (i < j)
      {
        localObject1 = getChildViewHolderInt(getChildAtInItem(i));
        localObject2 = ((RecyclerViewBase.ViewHolder)localObject1).itemView;
        this.mState.mPreLayoutHolderMap.put(localObject1, new RecyclerViewBase.ItemHolderInfo((RecyclerViewBase.ViewHolder)localObject1, ((View)localObject2).getLeft(), ((View)localObject2).getTop(), ((View)localObject2).getRight(), ((View)localObject2).getBottom(), ((RecyclerViewBase.ViewHolder)localObject1).mPosition));
        i += 1;
      }
    }
    clearOldPositions();
    dispatchLayoutUpdates();
    this.mState.mItemCount = this.mAdapter.getItemCount();
    localObject1 = this.mState;
    ((RecyclerViewBase.State)localObject1).mHeaderCountInScreen = 0;
    ((RecyclerViewBase.State)localObject1).mFooterCountInScreen = 0;
    ((RecyclerViewBase.State)localObject1).mInPreLayout = false;
    this.mLayout.onLayoutChildren(this.mRecycler, (RecyclerViewBase.State)localObject1);
    this.mState.mStructureChanged = false;
    this.mPendingSavedState = null;
    bool = isAnimateChangeSimple(true, bool);
    if (bool)
    {
      j = getChildCountInItem();
      i = 0;
      while (i < j)
      {
        localObject1 = getChildViewHolderInt(getChildAtInItem(i));
        localObject2 = ((RecyclerViewBase.ViewHolder)localObject1).itemView;
        this.mState.mPostLayoutHolderMap.put(localObject1, new RecyclerViewBase.ItemHolderInfo((RecyclerViewBase.ViewHolder)localObject1, ((View)localObject2).getLeft(), ((View)localObject2).getTop(), ((View)localObject2).getRight(), ((View)localObject2).getBottom(), ((RecyclerViewBase.ViewHolder)localObject1).mPosition));
        i += 1;
      }
      i = this.mState.mPreLayoutHolderMap.size() - 1;
      while (i >= 0)
      {
        localObject1 = (RecyclerViewBase.ViewHolder)this.mState.mPreLayoutHolderMap.keyAt(i);
        if (!this.mState.mPostLayoutHolderMap.containsKey(localObject1))
        {
          localObject1 = (RecyclerViewBase.ItemHolderInfo)this.mState.mPreLayoutHolderMap.valueAt(i);
          this.mState.mPreLayoutHolderMap.removeAt(i);
          removeDetachedView(((RecyclerViewBase.ItemHolderInfo)localObject1).holder.itemView, false);
          this.mRecycler.unscrapView(((RecyclerViewBase.ItemHolderInfo)localObject1).holder);
          animateDisappearance((RecyclerViewBase.ItemHolderInfo)localObject1);
        }
        i -= 1;
      }
      i = this.mState.mPostLayoutHolderMap.size();
      if (i > 0)
      {
        i -= 1;
        while (i >= 0)
        {
          localObject1 = (RecyclerViewBase.ViewHolder)this.mState.mPostLayoutHolderMap.keyAt(i);
          localObject2 = (RecyclerViewBase.ItemHolderInfo)this.mState.mPostLayoutHolderMap.valueAt(i);
          if ((!this.mState.mPreLayoutHolderMap.isEmpty()) && (this.mState.mPreLayoutHolderMap.containsKey(localObject1))) {
            break label687;
          }
          this.mState.mPostLayoutHolderMap.removeAt(i);
          animateAppearance((RecyclerViewBase.ViewHolder)localObject1, null, ((RecyclerViewBase.ItemHolderInfo)localObject2).left, ((RecyclerViewBase.ItemHolderInfo)localObject2).top);
          label687:
          i -= 1;
        }
      }
      j = this.mState.mPostLayoutHolderMap.size();
      i = 0;
      while (i < j)
      {
        localObject1 = (RecyclerViewBase.ViewHolder)this.mState.mPostLayoutHolderMap.keyAt(i);
        localObject2 = (RecyclerViewBase.ItemHolderInfo)this.mState.mPostLayoutHolderMap.valueAt(i);
        handleLayoutHolder((RecyclerViewBase.ViewHolder)localObject1, (RecyclerViewBase.ItemHolderInfo)this.mState.mPreLayoutHolderMap.get(localObject1), (RecyclerViewBase.ItemHolderInfo)localObject2);
        i += 1;
      }
    }
    resumeRequestLayout(false);
    handleDispatchLayoutEnd();
    this.mLayout.removeAndRecycleScrapInt(this.mRecycler, true, true);
    localObject1 = this.mState;
    ((RecyclerViewBase.State)localObject1).mPreviousLayoutItemCount = ((RecyclerViewBase.State)localObject1).mItemCount;
    this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
    if (!this.mPostedAnimatorRunner) {
      setRecyclerViewTouchEnabled(true);
    }
    if ((bool) && (!this.mPostedAnimatorRunner)) {
      handleRangeItemsChangedWithNoAnimation();
    }
  }
  
  void dispatchLayoutUpdates()
  {
    int j = this.mPendingLayoutUpdates.size();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.UpdateOp localUpdateOp = (RecyclerViewBase.UpdateOp)this.mPendingLayoutUpdates.get(i);
      int k = localUpdateOp.cmd;
      if (k != 0)
      {
        if (k == 1) {
          this.mLayout.onItemsRemoved(this, localUpdateOp.positionStart, localUpdateOp.itemCount);
        }
      }
      else {
        this.mLayout.onItemsAdded(this, localUpdateOp.positionStart, localUpdateOp.itemCount);
      }
      recycleUpdateOp(localUpdateOp);
      i += 1;
    }
    this.mPendingLayoutUpdates.clear();
  }
  
  boolean dispatchOnItemTouch(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    RecyclerViewBase.OnItemTouchListener localOnItemTouchListener = this.mActiveOnItemTouchListener;
    if (localOnItemTouchListener != null) {
      if (i == 0)
      {
        this.mActiveOnItemTouchListener = null;
      }
      else
      {
        localOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.mActiveOnItemTouchListener = null;
        }
        return true;
      }
    }
    if (i != 0)
    {
      int j = this.mOnItemTouchListeners.size();
      i = 0;
      while (i < j)
      {
        localOnItemTouchListener = (RecyclerViewBase.OnItemTouchListener)this.mOnItemTouchListeners.get(i);
        if (localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent))
        {
          this.mActiveOnItemTouchListener = localOnItemTouchListener;
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  boolean dispatchOnItemTouchIntercept(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.mActiveOnItemTouchListener = null;
    }
    int k = this.mOnItemTouchListeners.size();
    int i = 0;
    while (i < k)
    {
      RecyclerViewBase.OnItemTouchListener localOnItemTouchListener = (RecyclerViewBase.OnItemTouchListener)this.mOnItemTouchListeners.get(i);
      if ((localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) && (j != 3))
      {
        this.mActiveOnItemTouchListener = localOnItemTouchListener;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerViewBase.ItemDecoration)this.mItemDecorations.get(i)).onDrawOver(paramCanvas, this);
      i += 1;
    }
  }
  
  protected void eatRequestLayout()
  {
    if (!this.mEatRequestLayout)
    {
      this.mEatRequestLayout = true;
      this.mLayoutRequestEaten = false;
    }
  }
  
  protected void enter(int paramInt)
  {
    this.mEnterPos = paramInt;
    boolean bool = true;
    this.mEnterCalled = true;
    if (this.mExitCalled)
    {
      int i = this.mEnterPos;
      int j = this.mExitPos;
      if (i != j)
      {
        paramInt = i;
        if (i > j) {
          paramInt = j;
        }
        i = this.mEnterPos;
        j = this.mExitPos;
        if (i + j - paramInt != j) {
          bool = false;
        }
        this.mExchangeFromBigger = bool;
        this.mEnterCalled = false;
        this.mExitCalled = false;
      }
    }
  }
  
  protected void exit(int paramInt)
  {
    this.mExitPos = paramInt;
    boolean bool = true;
    this.mExitCalled = true;
    if (this.mEnterCalled)
    {
      int i = this.mEnterPos;
      int j = this.mExitPos;
      if (i != j)
      {
        paramInt = i;
        if (i > j) {
          paramInt = j;
        }
        i = this.mEnterPos;
        j = this.mExitPos;
        if (i + j - paramInt != j) {
          bool = false;
        }
        this.mExchangeFromBigger = bool;
        this.mEnterCalled = false;
        this.mExitCalled = false;
      }
    }
  }
  
  public View findChildViewUnder(float paramFloat1, float paramFloat2)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= localView.getRight() + f1) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public int findNextSuspentedPos(int paramInt)
  {
    return -1;
  }
  
  int findPositionOffset(int paramInt)
  {
    int m = this.mPendingLayoutUpdates.size();
    int j = 0;
    int i;
    for (int k = 0; j < m; k = i)
    {
      RecyclerViewBase.UpdateOp localUpdateOp = (RecyclerViewBase.UpdateOp)this.mPendingLayoutUpdates.get(j);
      i = k;
      if (localUpdateOp.positionStart <= paramInt) {
        if (localUpdateOp.cmd == 1)
        {
          i = k - localUpdateOp.itemCount;
        }
        else
        {
          i = k;
          if (localUpdateOp.cmd == 0) {
            i = k + localUpdateOp.itemCount;
          }
        }
      }
      j += 1;
    }
    return paramInt + k;
  }
  
  public int findPrevSuspentedPos(int paramInt)
  {
    return -1;
  }
  
  public View findViewByPosition(int paramInt)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.findViewByPosition(paramInt);
    }
    return null;
  }
  
  public RecyclerViewBase.ViewHolder findViewHolderForItemId(long paramLong)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(i));
      if ((localViewHolder != null) && (localViewHolder.getItemId() == paramLong)) {
        return localViewHolder;
      }
      i += 1;
    }
    return this.mRecycler.findViewHolderForItemId(paramLong);
  }
  
  public RecyclerViewBase.ViewHolder findViewHolderForPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  RecyclerViewBase.ViewHolder findViewHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(i));
      if (localViewHolder != null) {
        if (paramBoolean)
        {
          if (localViewHolder.mPosition == paramInt) {
            return localViewHolder;
          }
        }
        else if (localViewHolder.getPosition() == paramInt) {
          return localViewHolder;
        }
      }
      i += 1;
    }
    return this.mRecycler.findViewHolderForPosition(paramInt);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (Math.abs(paramInt1) < this.mMinFlingVelocity) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (Math.abs(paramInt2) < this.mMinFlingVelocity) {
      paramInt1 = 0;
    }
    paramInt2 = this.mMaxFlingVelocity;
    paramInt2 = Math.max(-paramInt2, Math.min(i, paramInt2));
    i = this.mMaxFlingVelocity;
    paramInt1 = Math.max(-i, Math.min(paramInt1, i));
    if ((paramInt2 == 0) && (paramInt1 == 0)) {
      return false;
    }
    this.mViewFlinger.fling(paramInt2, paramInt1);
    return true;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    Object localObject = this.mLayout.onInterceptFocusSearch(paramView, paramInt);
    if (localObject != null) {
      return localObject;
    }
    View localView = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
    localObject = localView;
    if (localView == null)
    {
      localObject = localView;
      if (this.mAdapter != null)
      {
        eatRequestLayout();
        localObject = this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
        resumeRequestLayout(false);
      }
    }
    if (localObject != null) {
      return localObject;
    }
    return super.focusSearch(paramView, paramInt);
  }
  
  public void forceCancelTouch()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    setScrollState(0);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateDefaultLayoutParams();
    }
    throw new IllegalStateException("RecyclerView has no LayoutManager");
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateLayoutParams(getContext(), paramAttributeSet);
    }
    throw new IllegalStateException("RecyclerView has no LayoutManager");
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateLayoutParams(paramLayoutParams);
    }
    throw new IllegalStateException("RecyclerView has no LayoutManager");
  }
  
  public RecyclerViewBase.Adapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public View getAnimatingView(int paramInt1, int paramInt2)
  {
    if (this.mNumAnimatingViews > 0)
    {
      int i = this.mAnimatingViewIndex;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolder(localView);
        if ((localViewHolder != null) && (localViewHolder.getPosition() == paramInt1) && ((paramInt2 == -1) || (localViewHolder.getItemViewType() == paramInt2))) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  protected int getAutoScrollVelocity()
  {
    return 9;
  }
  
  public int getCachedTotalHeight()
  {
    return this.mState.mTotalHeight;
  }
  
  public ArrayList<RecyclerViewBase.ViewHolder> getCachedViews()
  {
    return this.mRecycler.mCachedViews;
  }
  
  public View getChildAtInItem(int paramInt)
  {
    if (paramInt < getChildCount()) {
      return super.getChildAt(paramInt + this.mState.mHeaderCountInScreen);
    }
    return null;
  }
  
  public int getChildCountInItem()
  {
    return super.getChildCount() - this.mState.mHeaderCountInScreen - this.mState.mFooterCountInScreen;
  }
  
  public long getChildItemId(View paramView)
  {
    RecyclerViewBase.Adapter localAdapter = this.mAdapter;
    long l2 = -1L;
    long l1 = l2;
    if (localAdapter != null)
    {
      if (!localAdapter.hasStableIds()) {
        return -1L;
      }
      paramView = getChildViewHolderInt(paramView);
      l1 = l2;
      if (paramView != null) {
        l1 = paramView.getItemId();
      }
    }
    return l1;
  }
  
  public int getChildPosition(View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getPosition();
    }
    return -2147483648;
  }
  
  public RecyclerViewBase.ViewHolder getChildViewHolder(View paramView)
  {
    Object localObject = paramView.getParent();
    if ((localObject != null) && (localObject != this))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("View ");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(" is not a direct child of ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return getChildViewHolderInt(paramView);
  }
  
  public int getFirstVisibleItemPos()
  {
    int i = 0;
    while (i < getChildCountInItem())
    {
      View localView = getChildAtInItem(i);
      if ((localView instanceof RecyclerViewItem)) {
        return ((RecyclerViewItem)localView).mHolder.mPosition;
      }
      i += 1;
    }
    return -1;
  }
  
  int getFirstVisibleItemPosWithHeader()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof RecyclerViewItem)) {
        return ((RecyclerViewItem)localView).mHolder.mPosition;
      }
      i += 1;
    }
    return 2147483647;
  }
  
  public int getHeightBefore(int paramInt)
  {
    return 0;
  }
  
  public Rect getItemDecorInsetsForChild(View paramView)
  {
    paramView = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    if (!paramView.mInsetsDirty) {
      return paramView.mDecorInsets;
    }
    Rect localRect = paramView.mDecorInsets;
    localRect.set(0, 0, 0, 0);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((RecyclerViewBase.ItemDecoration)this.mItemDecorations.get(i)).getItemOffsets(this.mTempRect, paramView.getViewPosition(), this);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    paramView.mInsetsDirty = false;
    return localRect;
  }
  
  public RecyclerViewBase.LayoutManager getLayoutManager()
  {
    return this.mLayout;
  }
  
  public int getOffsetY()
  {
    return this.mOffsetY;
  }
  
  public boolean getOverScrollEnabled()
  {
    return this.mUpOverScrollEnabled;
  }
  
  public RecyclerViewBase.RecycledViewPool getRecycledViewPool()
  {
    return this.mRecycler.getRecycledViewPool();
  }
  
  public RecyclerViewBase.Recycler getRecycler()
  {
    return this.mRecycler;
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  protected int getSpringBackMaxDistance()
  {
    return 120;
  }
  
  int getStopPosition()
  {
    int i = this.mAdapter.getHeaderViewCount();
    int j = 0;
    while (i > this.mNeedStopAtTitleIndex)
    {
      j += this.mAdapter.getHeaderViewHeight(i);
      i -= 1;
    }
    return j;
  }
  
  public int getTotalHeight()
  {
    return this.mState.mTotalHeight;
  }
  
  protected int getViewIndex(View paramView)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (getChildAt(i) == paramView) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected void handleCustomClickEvent(MotionEvent paramMotionEvent) {}
  
  protected void handleDispatchLayoutEnd() {}
  
  public void handleInTraversal(int paramInt1, int paramInt2, View paramView) {}
  
  protected void handleLayoutHolder(RecyclerViewBase.ViewHolder paramViewHolder, RecyclerViewBase.ItemHolderInfo paramItemHolderInfo1, RecyclerViewBase.ItemHolderInfo paramItemHolderInfo2)
  {
    if ((paramItemHolderInfo1 != null) && (paramItemHolderInfo2 != null) && ((paramItemHolderInfo1.left != paramItemHolderInfo2.left) || (paramItemHolderInfo1.top != paramItemHolderInfo2.top))) {
      paramViewHolder.setIsRecyclable(false);
    }
  }
  
  protected void handleOnLayoutChange() {}
  
  protected void handleOnTouchUpEventWhenStartFling(float paramFloat1, float paramFloat2) {}
  
  protected void handleRangeItemsChangedWithNoAnimation() {}
  
  protected void handleRefreshHeadOnFlingRunEnd() {}
  
  protected void handleViewRangeUpdate(RecyclerViewBase.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mAdapter.bindViewHolder(paramViewHolder, paramViewHolder.getPosition(), true, this.mLayoutType, this.mAdapter.getCardItemViewType(paramViewHolder.getPosition()));
    this.mItemsChanged = true;
  }
  
  public boolean hasFixedSize()
  {
    return this.mHasFixedSize;
  }
  
  public boolean hasNoItem()
  {
    RecyclerViewBase.Adapter localAdapter = this.mAdapter;
    return (localAdapter != null) && (localAdapter.getItemCount() == 0) && (this.mAdapter.getFooterViewCount() == 0) && (this.mAdapter.getHeaderViewCount() == 0);
  }
  
  public boolean hasSuspentedItem()
  {
    return this.mHasSuspentedItem;
  }
  
  protected void invalidateRefreshHeader() {}
  
  protected boolean isAnimateChangeSimple(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    return false;
  }
  
  public boolean isBlockScroll()
  {
    return this.mBlockScroll;
  }
  
  public boolean isInOverScrollArea()
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    boolean bool2 = false;
    boolean bool1 = false;
    if ((localLayoutManager != null) && (localLayoutManager.canScrollHorizontally()))
    {
      if ((this.mOffsetX > this.mState.mTotalHeight - getWidth()) || (this.mOffsetX < 0)) {
        bool1 = true;
      }
      return bool1;
    }
    if (this.mOffsetY <= this.mState.mTotalHeight - getHeight())
    {
      bool1 = bool2;
      if (this.mOffsetY >= 0) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean isRefreshing()
  {
    return false;
  }
  
  public boolean isRepeatableSuspensionMode()
  {
    return this.mUseRepeatableSuspensionMode;
  }
  
  public boolean isScrolling()
  {
    int i = this.mScrollState;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected boolean isTouchStopWhenFastFling()
  {
    return true;
  }
  
  protected boolean isTransformedTouchPointInView(float paramFloat1, float paramFloat2, RecyclerViewItem paramRecyclerViewItem, PointF paramPointF)
  {
    paramFloat1 = paramFloat1 - getScrollX() - paramRecyclerViewItem.getLeft();
    paramFloat2 = paramFloat2 - getScrollY() - paramRecyclerViewItem.getTop();
    boolean bool = paramRecyclerViewItem.isPointInView(paramFloat1, paramFloat2);
    if ((bool) && (paramPointF != null)) {
      paramPointF.set(paramFloat1, paramFloat2);
    }
    return bool;
  }
  
  void layoutAnimationViews()
  {
    int i = getChildCount();
    int j = this.mAnimatingViewIndex;
    if (j != -1)
    {
      this.mAnimatingViewIndex = Math.max(0, Math.min(i, j));
      View localView = getChildAt(this.mAnimatingViewIndex);
      if (localView != null)
      {
        RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
        if (localLayoutManager != null)
        {
          localLayoutManager.measureChildWithMargins(localView, 0, 0);
          this.mLayout.layoutDecorated(localView, 0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
        }
      }
    }
  }
  
  void markItemDecorInsetsDirty()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((RecyclerViewBase.LayoutParams)getChildAt(i).getLayoutParams()).mInsetsDirty = true;
      i += 1;
    }
  }
  
  protected void markKnownViewsInvalid()
  {
    int j = getChildCountInItem();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAtInItem(i));
      if (localViewHolder != null) {
        localViewHolder.addFlags(6);
      }
      i += 1;
    }
    this.mRecycler.markKnownViewsInvalid();
  }
  
  protected boolean needAdvancedStopDetachChildView()
  {
    return false;
  }
  
  public void notifyRecyclerViewTouchEvent(MotionEvent paramMotionEvent) {}
  
  public RecyclerViewBase.UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3)
  {
    RecyclerViewBase.UpdateOp localUpdateOp = (RecyclerViewBase.UpdateOp)this.mUpdateOpPool.acquire();
    if (localUpdateOp == null) {
      return new RecyclerViewBase.UpdateOp(paramInt1, paramInt2, paramInt3);
    }
    localUpdateOp.cmd = paramInt1;
    localUpdateOp.positionStart = paramInt2;
    localUpdateOp.itemCount = paramInt3;
    localUpdateOp.mRemovePositions = null;
    return localUpdateOp;
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).offsetLeftAndRight(paramInt);
      i += 1;
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).offsetTopAndBottom(paramInt);
      i += 1;
    }
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(i));
      if ((localViewHolder != null) && (localViewHolder.mPosition >= paramInt1))
      {
        localViewHolder.offsetPosition(paramInt2);
        this.mState.mStructureChanged = true;
      }
      i += 1;
    }
    this.mRecycler.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    requestLayout();
  }
  
  protected void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(i));
      if (localViewHolder != null)
      {
        if (localViewHolder.mPosition >= paramInt1 + paramInt2) {
          localViewHolder.offsetPosition(-paramInt2);
        }
        for (;;)
        {
          this.mState.mStructureChanged = true;
          break;
          if (localViewHolder.mPosition < paramInt1) {
            break;
          }
          localViewHolder.addFlags(8);
        }
      }
      i += 1;
    }
    this.mRecycler.offsetPositionRecordsForRemove(paramInt1, paramInt2);
    if (paramBoolean) {
      requestLayout();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mIsAttached = true;
    Object localObject = this.mLayout;
    if (localObject != null) {
      ((RecyclerViewBase.LayoutManager)localObject).onAttachedToWindow(this);
    }
    this.mPostedAnimatorRunner = false;
    localObject = this.mAdapter;
    if (localObject != null) {
      ((RecyclerViewBase.Adapter)localObject).onViewAttached();
    }
  }
  
  public void onChildAttachedToWindow(View paramView) {}
  
  public void onChildDetachedFromWindow(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mIsAttached = false;
    Object localObject = this.mLayout;
    if (localObject != null) {
      ((RecyclerViewBase.LayoutManager)localObject).onDetachedFromWindow(this);
    }
    removeCallbacks(this.mItemAnimatorRunner);
    localObject = this.mAdapter;
    if (localObject != null) {
      ((RecyclerViewBase.Adapter)localObject).onViewDetached();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      int j = this.mItemDecorations.size();
      int i = 0;
      while (i < j)
      {
        ((RecyclerViewBase.ItemDecoration)this.mItemDecorations.get(i)).onDraw(paramCanvas, this);
        i += 1;
      }
      return;
    }
    catch (IllegalArgumentException|RuntimeException paramCanvas) {}
  }
  
  protected void onFlingToTopEdge(float paramFloat, int paramInt) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mAnimatingBlockTouch) {
      return true;
    }
    if (shouldStopOnInterceptTouchEvent(paramMotionEvent, this.mState.mTotalHeight, this.mUpOverScrollEnabled)) {
      return true;
    }
    if (this.mScrollState != 1)
    {
      bool1 = dispatchOnItemTouchIntercept(paramMotionEvent);
      if ((bool1) && (paramMotionEvent.getAction() != 0))
      {
        cancelTouch();
        return true;
      }
      if (bool1)
      {
        i = 1;
        break label77;
      }
    }
    int i = 0;
    label77:
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 5)
          {
            if (k == 6) {
              onPointerUp(paramMotionEvent);
            }
          }
          else
          {
            this.mScrollPointerId = paramMotionEvent.getPointerId(j);
            i = (int)(paramMotionEvent.getX(j) + 0.5F);
            this.mLastTouchX = i;
            this.mInitialTouchX = i;
            i = (int)(paramMotionEvent.getY(j) + 0.5F);
            this.mLastTouchY = i;
            this.mInitialTouchY = i;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
          if (i < 0) {
            return false;
          }
          if (!this.mBlockScroll)
          {
            float f2 = paramMotionEvent.getX(i);
            float f1 = paramMotionEvent.getY(i);
            if (this.mScrollState != 1)
            {
              f2 -= this.mInitialTouchX;
              f1 -= this.mInitialTouchY;
              k = -1;
              int m;
              if ((bool1) && (Math.abs(f2) > this.mTouchSlop) && (Math.abs(f2) > Math.abs(f1)))
              {
                j = this.mInitialTouchX;
                m = this.mTouchSlop;
                if (f2 < 0.0F) {
                  i = -1;
                } else {
                  i = 1;
                }
                this.mLastTouchX = (j + m * i);
                i = 1;
              }
              else
              {
                i = 0;
              }
              j = i;
              if (bool2)
              {
                j = i;
                if (Math.abs(f1) > this.mTouchSlop)
                {
                  j = i;
                  if (Math.abs(f1) > Math.abs(f2))
                  {
                    j = this.mInitialTouchY;
                    m = this.mTouchSlop;
                    if (f1 < 0.0F) {
                      i = k;
                    } else {
                      i = 1;
                    }
                    this.mLastTouchY = (j + m * i);
                    j = 1;
                  }
                }
              }
              if ((j != 0) && (onStartScroll((int)Math.abs(f1))))
              {
                if (this.mDisallowParentInterceptTouchEventWhenDrag) {
                  getParent().requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
              }
            }
          }
        }
      }
      else {
        this.mVelocityTracker.clear();
      }
    }
    else
    {
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
      j = (int)(paramMotionEvent.getX() + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      j = (int)(paramMotionEvent.getY() + 0.5F);
      this.mLastTouchY = j;
      this.mInitialTouchY = j;
      if (i != 0) {
        return true;
      }
      if (this.mScrollState == 2)
      {
        bool1 = this.mDisallowParentInterceptTouchEventWhenDrag;
        setScrollState(1);
        resetStopAtTitle();
      }
    }
    return this.mScrollState == 1;
  }
  
  public void onItemsFill(int paramInt) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      RecyclerViewBase.Adapter localAdapter = this.mAdapter;
      if (localAdapter != null) {
        localAdapter.dataChanged();
      }
      handleOnLayoutChange();
    }
    eatRequestLayout();
    dispatchLayout();
    resumeRequestLayout(false);
    if ((paramBoolean) && (this.mIsChangingMode))
    {
      this.mIsChangingMode = false;
      this.mRecycler.recycleCachedViews();
    }
    this.mStopAtTitle = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mAdapterUpdateDuringMeasure)
    {
      eatRequestLayout();
      updateChildViews();
      this.mAdapterUpdateDuringMeasure = false;
      resumeRequestLayout(false);
    }
    RecyclerViewBase.Adapter localAdapter = this.mAdapter;
    if (localAdapter != null)
    {
      this.mState.mItemCount = localAdapter.getItemCount();
      this.mState.mHeaderCount = this.mAdapter.getHeaderViewCount();
      this.mState.mFooterCount = this.mAdapter.getFooterViewCount();
    }
    this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
  }
  
  void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mScrollPointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable != null) && ((paramParcelable instanceof BaseLayoutManager.SavedState)))
    {
      this.mPendingSavedState = ((RecyclerViewBase.SavedState)paramParcelable);
      super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
      if ((this.mLayout != null) && (this.mPendingSavedState.mLayoutState != null)) {
        this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    RecyclerViewBase.SavedState localSavedState = new RecyclerViewBase.SavedState(super.onSaveInstanceState());
    Object localObject = this.mPendingSavedState;
    if (localObject != null)
    {
      localSavedState.copyFrom((RecyclerViewBase.SavedState)localObject);
      return localSavedState;
    }
    localObject = this.mLayout;
    if (localObject != null) {
      localObject = ((RecyclerViewBase.LayoutManager)localObject).onSaveInstanceState();
    } else {
      localObject = null;
    }
    localSavedState.mLayoutState = ((Parcelable)localObject);
    return localSavedState;
  }
  
  protected void onScrollToTopEdge() {}
  
  public boolean onStartScroll(int paramInt)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k;
    if ((!this.mBlockScroll) && (this.mLayout.canScrollHorizontally())) {
      k = 1;
    } else {
      k = 0;
    }
    int j;
    if ((!this.mBlockScroll) && (this.mLayout.canScrollVertically())) {
      j = 1;
    } else {
      j = 0;
    }
    if (this.mAnimatingBlockTouch) {
      return true;
    }
    if (shouldStopOnTouchEvent(paramMotionEvent, this.mState.mTotalHeight, this.mUpOverScrollEnabled)) {
      return true;
    }
    if ((this.mScrollState != 1) && (dispatchOnItemTouch(paramMotionEvent)))
    {
      cancelTouch();
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int m = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 5)
            {
              if (m != 6) {
                break label932;
              }
              onPointerUp(paramMotionEvent);
              break label932;
            }
            this.mScrollPointerId = paramMotionEvent.getPointerId(i);
            j = (int)(paramMotionEvent.getX(i) + 0.5F);
            this.mLastTouchX = j;
            this.mInitialTouchX = j;
            i = (int)(paramMotionEvent.getY(i) + 0.5F);
            this.mLastTouchY = i;
            this.mInitialTouchY = i;
            break label932;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
          if (i < 0) {
            return false;
          }
          this.mTouchEventState = 2;
          this.mIsTouching = true;
          int i1 = (int)(paramMotionEvent.getX(i) + 0.5F);
          int i2 = (int)(paramMotionEvent.getY(i) + 0.5F);
          if (this.mScrollState != 1)
          {
            i = i1 - this.mInitialTouchX;
            int i3 = i2 - this.mInitialTouchY;
            int n = -1;
            int i4;
            if (k != 0)
            {
              i4 = Math.abs(i);
              m = this.mTouchSlop;
              if (i4 > m)
              {
                i4 = this.mInitialTouchX;
                if (i < 0) {
                  i = -1;
                } else {
                  i = 1;
                }
                this.mLastTouchX = (i4 + m * i);
                i = 1;
                break label396;
              }
            }
            i = 0;
            label396:
            m = i;
            if (j != 0)
            {
              int i5 = Math.abs(i3);
              i4 = this.mTouchSlop;
              m = i;
              if (i5 > i4)
              {
                m = this.mInitialTouchY;
                if (i3 < 0) {
                  i = n;
                } else {
                  i = 1;
                }
                this.mLastTouchY = (m + i4 * i);
                m = 1;
              }
            }
            if (m != 0)
            {
              if ((this.mDisallowParentInterceptTouchEventWhenDrag) && (getParent() != null)) {
                getParent().requestDisallowInterceptTouchEvent(true);
              }
              setScrollState(1);
            }
          }
          if (this.mScrollState == 1)
          {
            i = this.mLastTouchX;
            m = this.mLastTouchY;
            if (k != 0) {
              i = -(i1 - i);
            } else {
              i = 0;
            }
            if (j != 0) {
              j = -(i2 - m);
            } else {
              j = 0;
            }
            scrollByInternal(i, j);
            if ((this.needNotifyFooter) && (!this.checkNotifyFooterOnRelease) && ((!shouldPrebindItem()) || (this.mOffsetY + getHeight() >= getTotalHeight())))
            {
              this.needNotifyFooter = false;
              paramMotionEvent = this.mRecycler;
              if (paramMotionEvent != null) {
                paramMotionEvent.notifyLastFooterAppeared();
              }
            }
            onTouchMove(i1, i2);
          }
          this.mLastTouchX = i1;
          this.mLastTouchY = i2;
          break label932;
        }
      }
      this.mTouchEventState = 1;
      this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
      float f1;
      if (k != 0) {
        f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
      } else {
        f1 = 0.0F;
      }
      float f2;
      if (j != 0) {
        f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
      } else {
        f2 = 0.0F;
      }
      if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2)))
      {
        resetStopAtTitle();
        setScrollState(0);
        handleOnTouchUpEventWhenStartFling(f1, f2);
      }
      if ((this.mEnableRecyclerViewTouchListener) && (Math.abs(paramMotionEvent.getX() - this.mInitialTouchX) < this.mTouchSlop) && (Math.abs(paramMotionEvent.getY() - this.mInitialTouchY) < this.mTouchSlop) && (m == 1)) {
        notifyRecyclerViewTouchEvent(paramMotionEvent);
      }
      handleCustomClickEvent(paramMotionEvent);
      this.mVelocityTracker.clear();
      releaseGlows(true, true);
    }
    else
    {
      this.mTouchEventState = 0;
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.mLastTouchX = i;
      this.mInitialTouchX = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      if (!isTouchStopWhenFastFling())
      {
        removeCallbacks(this.mTouchDownWhenSettlingCheckRunnable);
        postDelayed(this.mTouchDownWhenSettlingCheckRunnable, 50L);
      }
      if (getAdapter() != null) {
        getAdapter().onSuddenStop();
      }
    }
    label932:
    this.mIsTouching = false;
    return true;
  }
  
  protected void onTouchMove(int paramInt1, int paramInt2) {}
  
  public void postAdapterUpdate(RecyclerViewBase.UpdateOp paramUpdateOp)
  {
    this.mPendingUpdates.add(paramUpdateOp);
    if (this.mPendingUpdates.size() == 1)
    {
      setRecyclerViewTouchEnabled(false);
      if ((this.mPostUpdatesOnAnimation) && (this.mHasFixedSize) && (this.mIsAttached))
      {
        ViewCompatTool.postOnAnimation(this, this.mUpdateChildViewsRunnable);
        return;
      }
      this.mAdapterUpdateDuringMeasure = true;
      requestLayout();
    }
  }
  
  protected void postAnimationRunner()
  {
    if ((!this.mPostedAnimatorRunner) && (this.mIsAttached))
    {
      ViewCompatTool.postOnAnimation(this, this.mItemAnimatorRunner);
      this.mPostedAnimatorRunner = true;
    }
  }
  
  protected boolean predictiveItemAnimationsEnabled()
  {
    return false;
  }
  
  void pullGlows(int paramInt1, int paramInt2) {}
  
  void recycleUpdateOp(RecyclerViewBase.UpdateOp paramUpdateOp)
  {
    this.mUpdateOpPool.release(paramUpdateOp);
  }
  
  protected void refreshCachedViews()
  {
    traversal(1991102);
  }
  
  protected void releaseGlows(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((this.mState.mCustomHeaderHeight != 0) || (this.mState.mCustomFooterHeight != 0) || (this.mOffsetY < 0) || (getHeight() > this.mState.mTotalHeight)) && (shouldStopReleaseGlows(paramBoolean1, paramBoolean2))) {
      return;
    }
    if (this.mLayout.canScrollHorizontally())
    {
      releaseGlowsForHorizontal();
      return;
    }
    releaseGlowsForVertical();
  }
  
  protected void releaseGlowsForHorizontal()
  {
    if ((this.mOffsetX >= this.mState.mCustomHeaderWidth) && (getWidth() <= this.mState.mTotalHeight))
    {
      if (this.mOffsetX > this.mState.mTotalHeight - getWidth()) {
        smoothScrollBy(this.mState.mTotalHeight - getWidth() - this.mOffsetX, 0);
      }
    }
    else {
      scrollToTop(null);
    }
  }
  
  protected void releaseGlowsForVertical()
  {
    int i = this.mState.mTotalHeight;
    if ((this.mOffsetY >= this.mState.mCustomHeaderHeight) && (getHeight() <= i))
    {
      if (this.mOffsetY > i - getHeight())
      {
        smoothScrollBy(0, i - getHeight() - this.mOffsetY);
        return;
      }
      if ((this.mOffsetY >= i - getHeight()) && (this.needNotifyFooter))
      {
        if ((shouldPrebindItem()) && (this.mOffsetY + getHeight() != i)) {
          return;
        }
        this.needNotifyFooter = false;
        this.checkNotifyFooterOnRelease = false;
        this.mRecycler.notifyLastFooterAppeared();
      }
    }
    else
    {
      scrollToTop(null);
    }
  }
  
  public void removeAnimatingView(View paramView)
  {
    removeAnimatingView(paramView, false);
  }
  
  public void removeAnimatingView(View paramView, boolean paramBoolean)
  {
    if (this.mNumAnimatingViews > 0)
    {
      int i = this.mAnimatingViewIndex;
      while (i < getChildCount())
      {
        if (getChildAt(i) == paramView)
        {
          if (paramBoolean)
          {
            removeViewInLayout(paramView);
          }
          else if ((getAdapter() != null) && (getAdapter().hasCustomRecycler()))
          {
            int j = this.mAnimatingViewPos;
            if ((j >= 0) && (j == this.mAnimatingViewPrevPos)) {}
          }
          else
          {
            removeViewAt(i);
          }
          this.mNumAnimatingViews -= 1;
          if (this.mNumAnimatingViews == 0) {
            this.mAnimatingViewIndex = -1;
          }
          if ((getAdapter() != null) && (getAdapter().hasCustomRecycler()))
          {
            i = this.mAnimatingViewPos;
            if ((i >= 0) && (i == this.mAnimatingViewPrevPos) && (!paramBoolean)) {
              return;
            }
          }
          this.mRecycler.recycleView(paramView);
          return;
        }
        i += 1;
      }
    }
  }
  
  void removeAnimatingViews()
  {
    int m = getChildCount();
    View[] arrayOfView = new View[m];
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      arrayOfView[i] = getChildAt(i);
      i += 1;
    }
    while (j < m)
    {
      removeAnimatingView(arrayOfView[j]);
      j += 1;
    }
  }
  
  public void removeItemDecoration(RecyclerViewBase.ItemDecoration paramItemDecoration)
  {
    this.mItemDecorations.remove(paramItemDecoration);
    if (this.mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void removeOnItemTouchListener(RecyclerViewBase.OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.remove(paramOnItemTouchListener);
    if (this.mActiveOnItemTouchListener == paramOnItemTouchListener) {
      this.mActiveOnItemTouchListener = null;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (paramView2 != null)
    {
      RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
      if ((localLayoutManager != null) && (!localLayoutManager.onRequestChildFocus(this, paramView1, paramView2)))
      {
        this.mTempRect.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
        offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
        offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
        requestChildRectangleOnScreen(paramView1, this.mTempRect, true);
      }
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.mLayout.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestLayout()
  {
    if (!this.mEatRequestLayout)
    {
      super.requestLayout();
      return;
    }
    this.mLayoutRequestEaten = true;
  }
  
  void resetStopAtTitle()
  {
    if (this.mNeedStopAtTitleIndex != -1)
    {
      boolean bool2 = this.mStopAtTitle;
      boolean bool1 = false;
      if (bool2)
      {
        if (this.mOffsetY != getStopPosition()) {}
      }
      else {
        for (;;)
        {
          this.mStopAtTitle = bool1;
          return;
          if (this.mOffsetY < getStopPosition()) {
            break;
          }
          if (getHeight() + getStopPosition() < this.mState.mTotalHeight) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  protected void resumeRequestLayout(boolean paramBoolean)
  {
    if (this.mEatRequestLayout)
    {
      if ((paramBoolean) && (this.mLayoutRequestEaten) && (this.mLayout != null) && (this.mAdapter != null)) {
        dispatchLayout();
      }
      this.mEatRequestLayout = false;
      this.mLayoutRequestEaten = false;
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null)
    {
      boolean bool1 = localLayoutManager.canScrollHorizontally();
      boolean bool2 = this.mLayout.canScrollVertically();
      if ((bool1) || (bool2))
      {
        if (!bool1) {
          paramInt1 = 0;
        }
        if (!bool2) {
          paramInt2 = 0;
        }
        scrollByInternal(paramInt1, paramInt2);
      }
      return;
    }
    throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
  }
  
  void scrollByInternal(int paramInt1, int paramInt2)
  {
    if (checkShouldConsumePendingUpdates()) {
      consumePendingUpdateOperations();
    }
    if (checkShouldStopScroll()) {
      return;
    }
    RecyclerViewBase.Adapter localAdapter = this.mAdapter;
    int j = 0;
    int i;
    if (localAdapter != null)
    {
      eatRequestLayout();
      if (paramInt1 != 0)
      {
        paramInt1 = computeDxDy(paramInt1, 0, false, null, true)[0];
        i = paramInt1 - this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
      }
      else
      {
        i = 0;
      }
      if (paramInt2 != 0)
      {
        paramInt2 = computeDxDy(0, paramInt2, false, null, true)[1];
        j = paramInt2 - this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
      }
      else
      {
        j = 0;
      }
      resumeRequestLayout(false);
    }
    else
    {
      i = 0;
    }
    if (!this.mItemDecorations.isEmpty()) {
      invalidate();
    }
    invalidateRefreshHeader();
    pullGlows(i, j);
    if ((this.mScrollListener != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.mScrollListener.onScrolled(paramInt1, paramInt2);
    }
    if (checkShouldInvalidateInScroll()) {
      invalidate();
    }
    pullGlows(i, j);
    if ((this.mScrollListener != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.mScrollListener.onScrolled(paramInt1, paramInt2);
    }
    awakenScrollBars();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
  }
  
  public void scrollToPosition(int paramInt)
  {
    stopScroll();
    this.mLayout.scrollToPosition(paramInt);
    RecyclerViewBase.OnScrollListener localOnScrollListener = this.mScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrolled((int)getX(), paramInt);
    }
  }
  
  public void scrollToPosition(int paramInt1, int paramInt2)
  {
    stopScroll();
    this.mLayout.scrollToPositionWithOffset(paramInt1, paramInt2);
    RecyclerViewBase.OnScrollListener localOnScrollListener = this.mScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrolled((int)getX(), paramInt1);
    }
  }
  
  public void scrollToPositionWithGravity(int paramInt1, int paramInt2, int paramInt3)
  {
    stopScroll();
    this.mLayout.scrollToPositionWidthGravity(paramInt1, paramInt2, paramInt3);
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.scrollToPositionWithOffset(paramInt1, paramInt2);
    }
  }
  
  public void scrollToTop(RecyclerViewBase.OnScrollFinishListener paramOnScrollFinishListener)
  {
    RecyclerViewBase.ViewFlinger localViewFlinger;
    int j;
    int i;
    if (this.mLayout.canScrollHorizontally())
    {
      smoothScrollBy(-this.mOffsetX + this.mState.mCustomHeaderWidth, 0, false, true);
      localViewFlinger = this.mViewFlinger;
      localViewFlinger.mScrollFinishListener = paramOnScrollFinishListener;
      j = -this.mOffsetX;
      i = this.mState.mCustomHeaderWidth;
      paramOnScrollFinishListener = localViewFlinger;
    }
    else
    {
      smoothScrollBy(0, -this.mOffsetY + this.mState.mCustomHeaderHeight, false, true);
      localViewFlinger = this.mViewFlinger;
      localViewFlinger.mScrollFinishListener = paramOnScrollFinishListener;
      j = -this.mOffsetY;
      i = this.mState.mCustomHeaderHeight;
      paramOnScrollFinishListener = localViewFlinger;
    }
    paramOnScrollFinishListener.mTargetPosition = (j + i);
  }
  
  public void scrollToTopAtOnce()
  {
    Object localObject = this.mAdapter;
    if (localObject == null) {
      return;
    }
    localObject = ((RecyclerViewBase.Adapter)localObject).getBeginPositionWithOffset(0);
    scrollToPosition(localObject[0], localObject[1]);
  }
  
  public void setAdapter(RecyclerViewBase.Adapter paramAdapter)
  {
    Object localObject = this.mAdapter;
    if (localObject != null) {
      ((RecyclerViewBase.Adapter)localObject).unregisterAdapterDataObserver(this.mObserver);
    }
    localObject = this.mLayout;
    if (localObject != null)
    {
      ((RecyclerViewBase.LayoutManager)localObject).removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler, true, true);
    }
    localObject = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null) {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
    }
    paramAdapter = this.mLayout;
    if (paramAdapter != null) {
      paramAdapter.onAdapterChanged((RecyclerViewBase.Adapter)localObject, this.mAdapter);
    }
    this.mRecycler.onAdapterChanged((RecyclerViewBase.Adapter)localObject, this.mAdapter);
    this.mState.mStructureChanged = true;
    markKnownViewsInvalid();
    requestLayout();
  }
  
  public void setBlockScroll(boolean paramBoolean)
  {
    this.mBlockScroll = paramBoolean;
  }
  
  public void setBlockTouchListener(IBlockTouchListener paramIBlockTouchListener)
  {
    this.blockTouchListener = paramIBlockTouchListener;
  }
  
  public void setCanScroll(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mHorizontalCanScroll = paramBoolean1;
    this.mVerticalCanScroll = paramBoolean2;
  }
  
  public void setChildrenEnabled(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      getChildAt(paramInt1).setEnabled(paramBoolean);
      paramInt1 += 1;
    }
  }
  
  public void setDisallowParentInterceptTouchEventWhenDrag(boolean paramBoolean)
  {
    this.mDisallowParentInterceptTouchEventWhenDrag = paramBoolean;
  }
  
  public void setEnableHorizontalDrag(boolean paramBoolean) {}
  
  public void setEnableRecyclerViewTouchEventListener(boolean paramBoolean)
  {
    this.mEnableRecyclerViewTouchListener = paramBoolean;
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.mHasFixedSize = paramBoolean;
  }
  
  public void setHasSuspentedItem(boolean paramBoolean)
  {
    this.mHasSuspentedItem = paramBoolean;
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    this.mRecycler.setViewCacheSize(paramInt);
  }
  
  public void setLayoutManager(RecyclerViewBase.LayoutManager paramLayoutManager)
  {
    this.mLayoutType = paramLayoutManager.getLayoutType();
    if (paramLayoutManager == this.mLayout) {
      return;
    }
    Object localObject = this.mAdapter;
    if (localObject != null) {
      ((RecyclerViewBase.Adapter)localObject).reset();
    }
    this.mRecycler.clear();
    removeAllViews();
    localObject = this.mLayout;
    if (localObject != null)
    {
      if (this.mIsAttached) {
        ((RecyclerViewBase.LayoutManager)localObject).onDetachedFromWindow(this);
      }
      this.mLayout.mRecyclerView = null;
    }
    this.mLayout = paramLayoutManager;
    if (paramLayoutManager != null) {
      if (paramLayoutManager.mRecyclerView == null)
      {
        paramLayoutManager.mRecyclerView = this;
        if (this.mIsAttached) {
          this.mLayout.onAttachedToWindow(this);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LayoutManager ");
        ((StringBuilder)localObject).append(paramLayoutManager);
        ((StringBuilder)localObject).append(" is already attached to a RecyclerView: ");
        ((StringBuilder)localObject).append(paramLayoutManager.mRecyclerView);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    requestLayout();
  }
  
  public void setOnScrollListener(RecyclerViewBase.OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.mUpOverScrollEnabled = paramBoolean;
    this.mDownOverScrollEnabled = paramBoolean;
  }
  
  public void setOverScrollEnabled(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mUpOverScrollEnabled = paramBoolean1;
    this.mDownOverScrollEnabled = paramBoolean2;
  }
  
  public void setPrebindItem(boolean paramBoolean)
  {
    this.mShouldPrebindItem = paramBoolean;
  }
  
  public void setRecycledViewPool(RecyclerViewBase.RecycledViewPool paramRecycledViewPool)
  {
    this.mRecycler.setRecycledViewPool(paramRecycledViewPool);
  }
  
  public void setRecyclerViewTouchEnabled(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.forceBlockTouch)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    this.mAnimatingBlockTouch = paramBoolean;
    IBlockTouchListener localIBlockTouchListener = this.blockTouchListener;
    if (localIBlockTouchListener != null) {
      localIBlockTouchListener.a(true ^ this.mAnimatingBlockTouch);
    }
  }
  
  public void setRepeatableSuspensionMode(boolean paramBoolean)
  {
    this.mUseRepeatableSuspensionMode = paramBoolean;
  }
  
  void setScrollState(int paramInt)
  {
    int i = this.mScrollState;
    if (paramInt == i) {
      return;
    }
    this.mScrollState = paramInt;
    if (paramInt != 2) {
      if ((!isTouchStopWhenFastFling()) && (i == 2) && (paramInt == 1)) {
        this.mTouchDownWhenSettlingFlag = true;
      } else {
        stopScroll();
      }
    }
    RecyclerViewBase.OnScrollListener localOnScrollListener = this.mScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(i, paramInt);
    }
  }
  
  public boolean shouldPrebindItem()
  {
    return this.mShouldPrebindItem;
  }
  
  protected boolean shouldStopOnInterceptTouchEvent(MotionEvent paramMotionEvent, int paramInt, boolean paramBoolean)
  {
    return false;
  }
  
  protected boolean shouldStopOnTouchEvent(MotionEvent paramMotionEvent, int paramInt, boolean paramBoolean)
  {
    return false;
  }
  
  protected boolean shouldStopReleaseGlows(boolean paramBoolean1, boolean paramBoolean2)
  {
    return false;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, true);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    smoothScrollBy(paramInt1, paramInt2, paramBoolean, false);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((paramInt1 != 0) || (paramInt2 != 0)) && ((!this.mState.mStructureChanged) || (paramBoolean2))) {
      this.mViewFlinger.smoothScrollBy(paramInt1, paramInt2, paramBoolean1);
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    this.mLayout.smoothScrollToPosition(this, this.mState, paramInt);
  }
  
  public void stopScroll()
  {
    this.mViewFlinger.stop();
    this.mLayout.stopSmoothScroller();
  }
  
  public void traversal(int paramInt)
  {
    int j = getChildCount();
    Object localObject;
    if ((paramInt != 1991102) && (j > 0))
    {
      i = 0;
      while (i < j)
      {
        localObject = getChildViewHolderInt(getChildAt(i));
        if ((localObject != null) && (canTranversal(paramInt, (RecyclerViewBase.ViewHolder)localObject))) {
          ((RecyclerViewBase.ViewHolder)localObject).inTraversals(paramInt);
        }
        i += 1;
      }
    }
    j = this.mRecycler.mAttachedScrap.size();
    int i = 0;
    while (i < j)
    {
      localObject = (RecyclerViewBase.ViewHolder)this.mRecycler.mAttachedScrap.get(i);
      if ((localObject != null) && (canTranversal(paramInt, (RecyclerViewBase.ViewHolder)localObject))) {
        ((RecyclerViewBase.ViewHolder)localObject).inTraversals(paramInt);
      }
      i += 1;
    }
    j = this.mRecycler.mCachedViews.size();
    i = 0;
    while (i < j)
    {
      localObject = (RecyclerViewBase.ViewHolder)this.mRecycler.mCachedViews.get(i);
      if ((localObject != null) && (canTranversal(paramInt, (RecyclerViewBase.ViewHolder)localObject))) {
        ((RecyclerViewBase.ViewHolder)localObject).inTraversals(paramInt);
      }
      i += 1;
    }
    j = this.mRecycler.mUnmodifiableAttachedScrap.size();
    i = 0;
    while (i < j)
    {
      localObject = (RecyclerViewBase.ViewHolder)this.mRecycler.mUnmodifiableAttachedScrap.get(i);
      if ((localObject != null) && (canTranversal(paramInt, (RecyclerViewBase.ViewHolder)localObject))) {
        ((RecyclerViewBase.ViewHolder)localObject).inTraversals(paramInt);
      }
      i += 1;
    }
    int k = getRecycledViewPool().mScrap.size();
    i = 0;
    while (i < k)
    {
      localObject = (ArrayList)getRecycledViewPool().mScrap.valueAt(i);
      if (localObject != null)
      {
        int m = ((ArrayList)localObject).size();
        j = 0;
        while (j < m)
        {
          RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)((ArrayList)localObject).get(j);
          if (localViewHolder != null) {
            localViewHolder.inTraversals(paramInt);
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  void updateChildViews()
  {
    int k = this.mPendingUpdates.size();
    int i = 0;
    while (i < k)
    {
      RecyclerViewBase.UpdateOp localUpdateOp = (RecyclerViewBase.UpdateOp)this.mPendingUpdates.get(i);
      int j = localUpdateOp.cmd;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2) {
            break label204;
          }
          viewRangeUpdate(localUpdateOp.positionStart, localUpdateOp.itemCount);
          break label204;
        }
        if (localUpdateOp.mRemovePositions != null)
        {
          Iterator localIterator = localUpdateOp.mRemovePositions.iterator();
          while (localIterator.hasNext())
          {
            Integer localInteger = (Integer)localIterator.next();
            disableHolderRecyclable(localInteger.intValue());
            offsetPositionRecordsForRemove(localInteger.intValue(), 1, false);
          }
          requestLayout();
        }
        else
        {
          j = 0;
          while (j < localUpdateOp.itemCount)
          {
            disableHolderRecyclable(localUpdateOp.positionStart + j);
            j += 1;
          }
          offsetPositionRecordsForRemove(localUpdateOp.positionStart, localUpdateOp.itemCount, true);
        }
      }
      else
      {
        offsetPositionRecordsForInsert(localUpdateOp.positionStart, localUpdateOp.itemCount);
      }
      this.mItemsAddedOrRemoved = true;
      label204:
      this.mPendingLayoutUpdates.add(localUpdateOp);
      i += 1;
    }
    this.mPendingUpdates.clear();
  }
  
  public int validateAnchorItemPosition(int paramInt)
  {
    RecyclerViewBase.Adapter localAdapter = this.mAdapter;
    if (localAdapter == null) {
      return paramInt;
    }
    int j = localAdapter.getHeaderViewCount();
    int i = this.mAdapter.getFooterViewCount();
    j = -j;
    if ((paramInt < 0) && (this.mAdapter.headerMayChange())) {
      return j;
    }
    if (paramInt < i + this.mAdapter.getItemCount())
    {
      if (paramInt <= j) {
        return j;
      }
      return paramInt;
    }
    return j;
  }
  
  protected void viewRangeUpdate(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int k = paramInt1 + paramInt2;
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(i));
      if (localViewHolder != null)
      {
        int m = localViewHolder.mPosition;
        if ((m >= paramInt1) && (m < k)) {
          handleViewRangeUpdate(localViewHolder, paramInt1, k, m, paramInt2);
        }
      }
      i += 1;
    }
    this.mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
 * JD-Core Version:    0.7.0.1
 */