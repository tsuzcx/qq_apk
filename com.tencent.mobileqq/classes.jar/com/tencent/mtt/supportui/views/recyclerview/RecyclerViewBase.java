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
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      this.mPostUpdatesOnAnimation = bool;
      paramContext = ViewConfiguration.get(paramContext);
      this.mTouchSlop = paramContext.getScaledTouchSlop();
      this.mMinFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = paramContext.getScaledMaximumFlingVelocity();
      setWillNotDraw(false);
      setHasFixedSize(true);
      this.mAutoScrollRunnable = new RecyclerViewBase.AutoScrollRunnable(this);
      this.mTouchDownWhenSettlingCheckRunnable = new RecyclerViewBase.4(this);
      return;
    }
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
      if (i < getChildCount()) {
        if (getChildAt(i) != paramView) {}
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.mNumAnimatingViews += 1;
        if (!paramBoolean) {
          break label94;
        }
        addViewInLayout(paramView, -1, paramView.getLayoutParams(), true);
      }
      for (;;)
      {
        this.mAnimatingViewIndex = (getChildCount() - this.mNumAnimatingViews);
        this.mRecycler.unscrapView(getChildViewHolder(paramView));
        return;
        i += 1;
        break;
        label94:
        addView(paramView);
      }
    }
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
    }
    for (;;)
    {
      markItemDecorInsetsDirty();
      requestLayout();
      return;
      this.mItemDecorations.add(paramInt, paramItemDecoration);
    }
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
    if ((paramRect != null) && ((paramRect.left != paramInt1) || (paramRect.top != paramInt2)))
    {
      paramViewHolder.setIsRecyclable(false);
      return;
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
    if ((i != k) || (j != m))
    {
      paramItemHolderInfo.holder.setIsRecyclable(false);
      localView.layout(k, m, localView.getWidth() + k, localView.getHeight() + m);
      return;
    }
    paramItemHolderInfo.holder.setIsRecyclable(false);
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
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
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
    boolean bool1 = this.mUpOverScrollEnabled;
    bool1 = this.mDownOverScrollEnabled;
    boolean bool2 = changeUpOverScrollEnableOnComputeDxDy(paramInt1, paramInt2, paramBoolean1, paramScroller, paramBoolean2, this.mUpOverScrollEnabled);
    int i = paramInt1;
    if (paramInt1 != 0)
    {
      if (this.mOffsetX + paramInt1 >= 0) {
        break label279;
      }
      if (bool2) {
        break label183;
      }
      paramInt1 = -this.mOffsetX;
      i = paramInt1;
      if (paramScroller != null)
      {
        paramScroller.forceFinished(true);
        i = paramInt1;
      }
    }
    paramInt1 = paramInt2;
    int j;
    if (paramInt2 != 0)
    {
      if (this.mOffsetY + paramInt2 > 0) {
        break label614;
      }
      if (bool2) {
        break label522;
      }
      paramInt1 = this.mOffsetY;
      j = -this.mOffsetY;
      if ((paramScroller == null) || (!paramScroller.isFling())) {
        break label508;
      }
      onFlingToTopEdge(paramScroller.getCurrVelocity(), paramInt1 + paramInt2);
      label152:
      paramInt1 = j;
      if (paramScroller != null)
      {
        paramScroller.forceFinished(true);
        paramInt1 = j;
      }
    }
    for (;;)
    {
      arrayOfInt[0] = i;
      arrayOfInt[1] = paramInt1;
      return arrayOfInt;
      label183:
      j = paramInt1;
      if (this.mOffsetX < 0)
      {
        if (paramInt1 <= 0) {
          break label254;
        }
        j = paramInt1;
      }
      for (;;)
      {
        i = j;
        if (this.mOffsetX + j > -k) {
          break;
        }
        i = j;
        if (!paramBoolean1) {
          break;
        }
        paramInt1 = -this.mOffsetX - k;
        i = paramInt1;
        if (paramScroller == null) {
          break;
        }
        paramScroller.forceFinished(true);
        i = paramInt1;
        break;
        label254:
        j = paramInt1;
        if (paramInt1 / 3 != 0)
        {
          j = paramInt1;
          if (paramBoolean2) {
            j = paramInt1 / 3;
          }
        }
      }
      label279:
      i = paramInt1;
      if (this.mOffsetX + paramInt1 <= this.mState.mTotalHeight - getWidth()) {
        break;
      }
      if (!bool1)
      {
        if (this.mState.mTotalHeight <= getWidth()) {}
        for (paramInt1 = 0;; paramInt1 = this.mState.mTotalHeight - getWidth() - this.mOffsetX)
        {
          i = paramInt1;
          if (paramScroller == null) {
            break;
          }
          paramScroller.forceFinished(true);
          i = paramInt1;
          break;
        }
      }
      j = paramInt1;
      if (this.mOffsetX > this.mState.mTotalHeight - getWidth())
      {
        if (paramInt1 < 0) {
          j = paramInt1;
        }
      }
      else {
        label394:
        if (this.mState.mTotalHeight > getWidth()) {
          break label492;
        }
      }
      label492:
      for (paramInt1 = 0;; paramInt1 = this.mState.mTotalHeight - getWidth())
      {
        i = j;
        if (this.mOffsetX + j < paramInt1 + k) {
          break;
        }
        i = j;
        if (!paramBoolean1) {
          break;
        }
        paramInt1 = paramInt1 + -this.mOffsetX + k;
        i = paramInt1;
        if (paramScroller == null) {
          break;
        }
        paramScroller.forceFinished(true);
        i = paramInt1;
        break;
        j = paramInt1;
        if (paramInt1 / 3 == 0) {
          break label394;
        }
        j = paramInt1;
        if (!paramBoolean2) {
          break label394;
        }
        j = paramInt1 / 3;
        break label394;
      }
      label508:
      if (!this.mIsTouching) {
        break label152;
      }
      onScrollToTopEdge();
      break label152;
      label522:
      j = paramInt2;
      if (this.mOffsetY < 0)
      {
        if (paramInt2 <= 0) {
          break label589;
        }
        j = paramInt2;
      }
      for (;;)
      {
        paramInt1 = j;
        if (this.mOffsetY + j > -k) {
          break;
        }
        paramInt1 = j;
        if (!paramBoolean1) {
          break;
        }
        paramInt2 = -this.mOffsetY - k;
        paramInt1 = paramInt2;
        if (paramScroller == null) {
          break;
        }
        paramScroller.forceFinished(true);
        paramInt1 = paramInt2;
        break;
        label589:
        j = paramInt2;
        if (paramInt2 / 3 != 0)
        {
          j = paramInt2;
          if (paramBoolean2) {
            j = paramInt2 / 3;
          }
        }
      }
      label614:
      if (this.mOffsetY + paramInt2 > this.mState.mTotalHeight - getHeight())
      {
        if (!bool1)
        {
          if (this.mState.mTotalHeight <= getHeight()) {}
          for (paramInt2 = 0;; paramInt2 = this.mState.mTotalHeight - getHeight() - this.mOffsetY)
          {
            paramInt1 = paramInt2;
            if (paramScroller == null) {
              break;
            }
            paramScroller.forceFinished(true);
            paramInt1 = paramInt2;
            break;
          }
        }
        j = paramInt2;
        if (this.mOffsetY > this.mState.mTotalHeight - getHeight())
        {
          if (paramInt2 < 0) {
            j = paramInt2;
          }
        }
        else {
          if (this.mState.mTotalHeight > getHeight()) {
            break label818;
          }
        }
        for (paramInt2 = 0;; paramInt2 = this.mState.mTotalHeight - getHeight())
        {
          paramInt1 = j;
          if (this.mOffsetY + j < paramInt2 + k) {
            break;
          }
          paramInt1 = j;
          if (!paramBoolean1) {
            break;
          }
          paramInt2 = paramInt2 + -this.mOffsetY + k;
          paramInt1 = paramInt2;
          if (paramScroller == null) {
            break;
          }
          paramScroller.forceFinished(true);
          paramInt1 = paramInt2;
          break;
          j = paramInt2;
          if (paramInt2 / 3 == 0) {
            break label724;
          }
          j = paramInt2;
          if (!paramBoolean2) {
            break label724;
          }
          j = paramInt2 / 3;
          break label724;
        }
      }
      label724:
      paramInt1 = paramInt2;
      label818:
      if (this.mStopAtTitle)
      {
        paramInt1 = paramInt2;
        if (this.mNeedStopAtTitleIndex != -1)
        {
          j = getStopPosition();
          paramInt1 = paramInt2;
          if (this.mOffsetY + paramInt2 < j)
          {
            paramInt2 = j - this.mOffsetY;
            paramInt1 = paramInt2;
            if (paramScroller != null)
            {
              paramScroller.forceFinished(true);
              paramInt1 = paramInt2;
            }
          }
        }
      }
    }
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
    if (i >= j)
    {
      paramInt1 = j;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      if (paramInt2 > j + i - paramInt1) {
        break label94;
      }
      RecyclerViewItem localRecyclerViewItem = (RecyclerViewItem)getChildAtInItem(paramInt2);
      if ((localRecyclerViewItem != null) && (localRecyclerViewItem.mHolder != null) && (localRecyclerViewItem.mHolder.mPosDirty))
      {
        return true;
        paramInt1 = i;
        break;
      }
      paramInt2 += 1;
    }
    label94:
    return false;
  }
  
  public void dispatchLayout()
  {
    if (this.mAdapter == null) {}
    boolean bool;
    label707:
    do
    {
      return;
      eatRequestLayout();
      if ((this.mItemsAddedOrRemoved) || (this.mItemsChanged) || (this.mState.mStructureChanged)) {
        this.mAdapter.dataChanged();
      }
      bool = isAnimateChangeSimple(false, false);
      this.mItemsChanged = false;
      this.mItemsAddedOrRemoved = false;
      this.mState.mCustomHeaderHeight = this.mAdapter.getCustomHeaderViewHeight();
      this.mState.mCustomFooterHeight = this.mAdapter.getCustomFooterViewHeight();
      this.mState.mCustomHeaderWidth = this.mAdapter.getCustomHeaderViewWidth();
      this.mState.mCustomFooterWidth = this.mAdapter.getCustomFooterViewWidth();
      this.mState.mInPreLayout = false;
      this.mState.mItemCount = this.mAdapter.getItemCount();
      this.mState.mTotalHeight = this.mAdapter.getListTotalHeight();
      this.mState.mHeaderCount = this.mAdapter.getHeaderViewCount();
      this.mState.mFooterCount = this.mAdapter.getFooterViewCount();
      int j;
      int i;
      Object localObject1;
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
      this.mState.mHeaderCountInScreen = 0;
      this.mState.mFooterCountInScreen = 0;
      this.mState.mInPreLayout = false;
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
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
          if (i >= 0)
          {
            localObject2 = (RecyclerViewBase.ViewHolder)this.mState.mPostLayoutHolderMap.keyAt(i);
            localObject1 = (RecyclerViewBase.ItemHolderInfo)this.mState.mPostLayoutHolderMap.valueAt(i);
            if ((this.mState.mPreLayoutHolderMap.isEmpty()) || (!this.mState.mPreLayoutHolderMap.containsKey(localObject2)))
            {
              this.mState.mPostLayoutHolderMap.removeAt(i);
              if (0 == 0) {
                break label707;
              }
              localObject1 = ((RecyclerViewBase.ViewHolder)localObject2).itemView;
              throw new NullPointerException();
            }
            for (;;)
            {
              animateAppearance((RecyclerViewBase.ViewHolder)localObject2, null, ((RecyclerViewBase.ItemHolderInfo)localObject1).left, ((RecyclerViewBase.ItemHolderInfo)localObject1).top);
              i -= 1;
              break;
            }
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
      this.mState.mPreviousLayoutItemCount = this.mState.mItemCount;
      this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
      if (!this.mPostedAnimatorRunner) {
        setRecyclerViewTouchEnabled(true);
      }
    } while ((!bool) || (this.mPostedAnimatorRunner));
    handleRangeItemsChangedWithNoAnimation();
  }
  
  void dispatchLayoutUpdates()
  {
    int j = this.mPendingLayoutUpdates.size();
    int i = 0;
    if (i < j)
    {
      RecyclerViewBase.UpdateOp localUpdateOp = (RecyclerViewBase.UpdateOp)this.mPendingLayoutUpdates.get(i);
      switch (localUpdateOp.cmd)
      {
      }
      for (;;)
      {
        recycleUpdateOp(localUpdateOp);
        i += 1;
        break;
        this.mLayout.onItemsAdded(this, localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        this.mLayout.onItemsRemoved(this, localUpdateOp.positionStart, localUpdateOp.itemCount);
      }
    }
    this.mPendingLayoutUpdates.clear();
  }
  
  boolean dispatchOnItemTouch(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j;
    if (this.mActiveOnItemTouchListener != null)
    {
      if (i == 0) {
        this.mActiveOnItemTouchListener = null;
      }
    }
    else
    {
      if (i == 0) {
        break label108;
      }
      j = this.mOnItemTouchListeners.size();
      i = 0;
    }
    while (i < j)
    {
      RecyclerViewBase.OnItemTouchListener localOnItemTouchListener = (RecyclerViewBase.OnItemTouchListener)this.mOnItemTouchListeners.get(i);
      if (localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent))
      {
        this.mActiveOnItemTouchListener = localOnItemTouchListener;
        return true;
        this.mActiveOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.mActiveOnItemTouchListener = null;
        }
        return true;
      }
      i += 1;
    }
    label108:
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
    this.mEnterCalled = true;
    if ((this.mExitCalled) && (this.mEnterPos != this.mExitPos))
    {
      if (this.mEnterPos <= this.mExitPos) {
        break label80;
      }
      paramInt = this.mExitPos;
      if (this.mEnterPos + this.mExitPos - paramInt != this.mExitPos) {
        break label88;
      }
    }
    label80:
    label88:
    for (boolean bool = true;; bool = false)
    {
      this.mExchangeFromBigger = bool;
      this.mEnterCalled = false;
      this.mExitCalled = false;
      return;
      paramInt = this.mEnterPos;
      break;
    }
  }
  
  protected void exit(int paramInt)
  {
    this.mExitPos = paramInt;
    this.mExitCalled = true;
    if ((this.mEnterCalled) && (this.mEnterPos != this.mExitPos))
    {
      if (this.mEnterPos <= this.mExitPos) {
        break label80;
      }
      paramInt = this.mExitPos;
      if (this.mEnterPos + this.mExitPos - paramInt != this.mExitPos) {
        break label88;
      }
    }
    label80:
    label88:
    for (boolean bool = true;; bool = false)
    {
      this.mExchangeFromBigger = bool;
      this.mEnterCalled = false;
      this.mExitCalled = false;
      return;
      paramInt = this.mEnterPos;
      break;
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
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
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
    int k = this.mPendingLayoutUpdates.size();
    int j = 0;
    int i = 0;
    RecyclerViewBase.UpdateOp localUpdateOp;
    if (j < k)
    {
      localUpdateOp = (RecyclerViewBase.UpdateOp)this.mPendingLayoutUpdates.get(j);
      if (localUpdateOp.positionStart > paramInt) {
        break label88;
      }
      if (localUpdateOp.cmd == 1) {
        i -= localUpdateOp.itemCount;
      }
    }
    label88:
    for (;;)
    {
      j += 1;
      break;
      if (localUpdateOp.cmd == 0)
      {
        i = localUpdateOp.itemCount + i;
        continue;
        return paramInt + i;
      }
    }
  }
  
  public int findPrevSuspentedPos(int paramInt)
  {
    return -1;
  }
  
  public View findViewByPosition(int paramInt)
  {
    if (this.mLayout != null) {
      return this.mLayout.findViewByPosition(paramInt);
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
          if (localViewHolder.mPosition != paramInt) {}
        }
        else {
          while (localViewHolder.getPosition() == paramInt) {
            return localViewHolder;
          }
        }
      }
      i += 1;
    }
    return this.mRecycler.findViewHolderForPosition(paramInt);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    int i = paramInt1;
    if (Math.abs(paramInt1) < this.mMinFlingVelocity) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (Math.abs(paramInt2) < this.mMinFlingVelocity) {
      paramInt1 = 0;
    }
    paramInt2 = Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity));
    paramInt1 = Math.max(-this.mMaxFlingVelocity, Math.min(paramInt1, this.mMaxFlingVelocity));
    if ((paramInt2 != 0) || (paramInt1 != 0))
    {
      this.mViewFlinger.fling(paramInt2, paramInt1);
      bool = true;
    }
    return bool;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    Object localObject2 = this.mLayout.onInterceptFocusSearch(paramView, paramInt);
    if (localObject2 != null) {}
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.mAdapter != null)
        {
          eatRequestLayout();
          localObject1 = this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
          resumeRequestLayout(false);
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return super.focusSearch(paramView, paramInt);
  }
  
  public void forceCancelTouch()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    setScrollState(0);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.mLayout.generateDefaultLayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.mLayout.generateLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.mLayout.generateLayoutParams(paramLayoutParams);
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
      return super.getChildAt(this.mState.mHeaderCountInScreen + paramInt);
    }
    return null;
  }
  
  public int getChildCountInItem()
  {
    return super.getChildCount() - this.mState.mHeaderCountInScreen - this.mState.mFooterCountInScreen;
  }
  
  public long getChildItemId(View paramView)
  {
    if ((this.mAdapter == null) || (!this.mAdapter.hasStableIds())) {}
    do
    {
      return -1L;
      paramView = getChildViewHolderInt(paramView);
    } while (paramView == null);
    return paramView.getItemId();
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
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
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
    int j = 0;
    int i = this.mAdapter.getHeaderViewCount();
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
    return (this.mAdapter != null) && (this.mAdapter.getItemCount() == 0) && (this.mAdapter.getFooterViewCount() == 0) && (this.mAdapter.getHeaderViewCount() == 0);
  }
  
  public boolean hasSuspentedItem()
  {
    return this.mHasSuspentedItem;
  }
  
  protected void invalidateRefreshHeader() {}
  
  protected boolean isAnimateChangeSimple(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    while (!paramBoolean2) {
      return false;
    }
    return false;
  }
  
  public boolean isBlockScroll()
  {
    return this.mBlockScroll;
  }
  
  public boolean isInOverScrollArea()
  {
    boolean bool = false;
    if ((this.mLayout != null) && (this.mLayout.canScrollHorizontally())) {
      if ((this.mOffsetX > this.mState.mTotalHeight - getWidth()) || (this.mOffsetX < 0)) {
        bool = true;
      }
    }
    while ((this.mOffsetY <= this.mState.mTotalHeight - getHeight()) && (this.mOffsetY >= 0)) {
      return bool;
    }
    return true;
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
    return (this.mScrollState == 1) || (this.mScrollState == 2);
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
    if (this.mAnimatingViewIndex != -1)
    {
      this.mAnimatingViewIndex = Math.max(0, Math.min(i, this.mAnimatingViewIndex));
      View localView = getChildAt(this.mAnimatingViewIndex);
      if ((localView != null) && (this.mLayout != null))
      {
        this.mLayout.measureChildWithMargins(localView, 0, 0);
        this.mLayout.layoutDecorated(localView, 0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
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
    if (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(i));
      if (localViewHolder != null)
      {
        if (localViewHolder.mPosition < paramInt1 + paramInt2) {
          break label67;
        }
        localViewHolder.offsetPosition(-paramInt2);
        this.mState.mStructureChanged = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label67:
        if (localViewHolder.mPosition >= paramInt1)
        {
          localViewHolder.addFlags(8);
          this.mState.mStructureChanged = true;
        }
      }
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
    if (this.mLayout != null) {
      this.mLayout.onAttachedToWindow(this);
    }
    this.mPostedAnimatorRunner = false;
    if (this.mAdapter != null) {
      this.mAdapter.onViewAttached();
    }
  }
  
  public void onChildAttachedToWindow(View paramView) {}
  
  public void onChildDetachedFromWindow(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mIsAttached = false;
    if (this.mLayout != null) {
      this.mLayout.onDetachedFromWindow(this);
    }
    removeCallbacks(this.mItemAnimatorRunner);
    if (this.mAdapter != null) {
      this.mAdapter.onViewDetached();
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
    catch (RuntimeException paramCanvas)
    {
      return;
    }
    catch (IllegalArgumentException paramCanvas) {}
  }
  
  protected void onFlingToTopEdge(float paramFloat, int paramInt) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = -1;
    if (this.mAnimatingBlockTouch) {}
    while (shouldStopOnInterceptTouchEvent(paramMotionEvent, this.mState.mTotalHeight, this.mUpOverScrollEnabled)) {
      return true;
    }
    boolean bool1;
    if (this.mScrollState != 1)
    {
      bool1 = dispatchOnItemTouchIntercept(paramMotionEvent);
      if ((bool1) && (paramMotionEvent.getAction() != 0))
      {
        cancelTouch();
        return true;
      }
      if (!bool1) {}
    }
    for (int i = 1;; i = 0)
    {
      bool1 = this.mLayout.canScrollHorizontally();
      boolean bool2 = this.mLayout.canScrollVertically();
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      int m = paramMotionEvent.getActionMasked();
      int j = paramMotionEvent.getActionIndex();
      label168:
      float f2;
      float f1;
      switch (m)
      {
      case 3: 
      case 4: 
      default: 
      case 0: 
      case 5: 
      case 2: 
        for (;;)
        {
          if (this.mScrollState != 1)
          {
            return false;
            this.mScrollPointerId = paramMotionEvent.getPointerId(0);
            j = (int)(paramMotionEvent.getX() + 0.5F);
            this.mLastTouchX = j;
            this.mInitialTouchX = j;
            j = (int)(paramMotionEvent.getY() + 0.5F);
            this.mLastTouchY = j;
            this.mInitialTouchY = j;
            if (i != 0) {
              break;
            }
            if (this.mScrollState == 2)
            {
              if (this.mDisallowParentInterceptTouchEventWhenDrag) {}
              setScrollState(1);
              resetStopAtTitle();
              continue;
              this.mScrollPointerId = paramMotionEvent.getPointerId(j);
              i = (int)(paramMotionEvent.getX(j) + 0.5F);
              this.mLastTouchX = i;
              this.mInitialTouchX = i;
              i = (int)(paramMotionEvent.getY(j) + 0.5F);
              this.mLastTouchY = i;
              this.mInitialTouchY = i;
              continue;
              i = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
              if (i < 0) {
                return false;
              }
              if (!this.mBlockScroll)
              {
                f2 = paramMotionEvent.getX(i);
                f1 = paramMotionEvent.getY(i);
                if (this.mScrollState != 1)
                {
                  f2 -= this.mInitialTouchX;
                  f1 -= this.mInitialTouchY;
                  if ((!bool1) || (Math.abs(f2) <= this.mTouchSlop) || (Math.abs(f2) <= Math.abs(f1))) {
                    break label607;
                  }
                  j = this.mInitialTouchX;
                  m = this.mTouchSlop;
                  if (f2 < 0.0F)
                  {
                    i = -1;
                    label441:
                    this.mLastTouchX = (i * m + j);
                  }
                }
              }
            }
          }
        }
      }
      label583:
      label607:
      for (i = 1;; i = 0)
      {
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
              if (f1 >= 0.0F) {
                break label583;
              }
            }
          }
        }
        for (i = k;; i = 1)
        {
          this.mLastTouchY = (j + i * m);
          j = 1;
          if ((j == 0) || (!onStartScroll((int)Math.abs(f1)))) {
            break;
          }
          if (this.mDisallowParentInterceptTouchEventWhenDrag) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
          setScrollState(1);
          break;
          i = 1;
          break label441;
        }
        onPointerUp(paramMotionEvent);
        break label168;
        this.mVelocityTracker.clear();
        break label168;
        break;
      }
    }
  }
  
  public void onItemsFill(int paramInt) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      if (this.mAdapter != null) {
        this.mAdapter.dataChanged();
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
    if (this.mAdapter != null)
    {
      this.mState.mItemCount = this.mAdapter.getItemCount();
      this.mState.mHeaderCount = this.mAdapter.getHeaderViewCount();
      this.mState.mFooterCount = this.mAdapter.getFooterViewCount();
    }
    this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
  }
  
  void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mScrollPointerId) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      return;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.mPendingSavedState = ((RecyclerViewBase.SavedState)paramParcelable);
    super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
    if ((this.mLayout != null) && (this.mPendingSavedState.mLayoutState != null)) {
      this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    RecyclerViewBase.SavedState localSavedState = new RecyclerViewBase.SavedState(super.onSaveInstanceState());
    if (this.mPendingSavedState != null)
    {
      localSavedState.copyFrom(this.mPendingSavedState);
      return localSavedState;
    }
    if (this.mLayout != null)
    {
      localSavedState.mLayoutState = this.mLayout.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.mLayoutState = null;
    return localSavedState;
  }
  
  protected void onScrollToTopEdge() {}
  
  public boolean onStartScroll(int paramInt)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = -1;
    int k;
    int j;
    if ((!this.mBlockScroll) && (this.mLayout.canScrollHorizontally()))
    {
      k = 1;
      if ((this.mBlockScroll) || (!this.mLayout.canScrollVertically())) {
        break label58;
      }
      j = 1;
      label43:
      if (!this.mAnimatingBlockTouch) {
        break label64;
      }
    }
    label58:
    label64:
    while (shouldStopOnTouchEvent(paramMotionEvent, this.mState.mTotalHeight, this.mUpOverScrollEnabled))
    {
      return true;
      k = 0;
      break;
      j = 0;
      break label43;
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
    int i1;
    int i2;
    int i3;
    int i4;
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      for (;;)
      {
        this.mIsTouching = false;
        return true;
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
        if (getAdapter() != null)
        {
          getAdapter().onSuddenStop();
          continue;
          this.mScrollPointerId = paramMotionEvent.getPointerId(i);
          j = (int)(paramMotionEvent.getX(i) + 0.5F);
          this.mLastTouchX = j;
          this.mInitialTouchX = j;
          i = (int)(paramMotionEvent.getY(i) + 0.5F);
          this.mLastTouchY = i;
          this.mInitialTouchY = i;
        }
      }
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
      if (i < 0) {
        return false;
      }
      this.mTouchEventState = 2;
      this.mIsTouching = true;
      i1 = (int)(paramMotionEvent.getX(i) + 0.5F);
      i2 = (int)(paramMotionEvent.getY(i) + 0.5F);
      if (this.mScrollState != 1)
      {
        i = i1 - this.mInitialTouchX;
        i3 = i2 - this.mInitialTouchY;
        if ((k == 0) || (Math.abs(i) <= this.mTouchSlop)) {
          break label937;
        }
        m = this.mInitialTouchX;
        i4 = this.mTouchSlop;
        if (i >= 0) {
          break label718;
        }
        i = -1;
        label475:
        this.mLastTouchX = (i * i4 + m);
      }
      break;
    }
    label536:
    label932:
    label937:
    for (i = 1;; i = 0)
    {
      m = i;
      if (j != 0)
      {
        m = i;
        if (Math.abs(i3) > this.mTouchSlop)
        {
          m = this.mInitialTouchY;
          i4 = this.mTouchSlop;
          if (i3 >= 0) {
            break label724;
          }
          i = n;
          this.mLastTouchY = (m + i * i4);
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
      if (this.mScrollState == 1)
      {
        i = this.mLastTouchX;
        m = this.mLastTouchY;
        if (k == 0) {
          break label730;
        }
        i = -(i1 - i);
        label618:
        if (j == 0) {
          break label736;
        }
      }
      label718:
      label724:
      label730:
      label736:
      for (j = -(i2 - m);; j = 0)
      {
        scrollByInternal(i, j);
        if ((this.needNotifyFooter) && (!this.checkNotifyFooterOnRelease) && ((!shouldPrebindItem()) || (this.mOffsetY + getHeight() >= getTotalHeight())))
        {
          this.needNotifyFooter = false;
          if (this.mRecycler != null) {
            this.mRecycler.notifyLastFooterAppeared();
          }
        }
        onTouchMove(i1, i2);
        this.mLastTouchX = i1;
        this.mLastTouchY = i2;
        break;
        i = 1;
        break label475;
        i = 1;
        break label536;
        i = 0;
        break label618;
      }
      onPointerUp(paramMotionEvent);
      break;
      this.mTouchEventState = 1;
      this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
      float f1;
      if (k != 0)
      {
        f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
        if (j == 0) {
          break label932;
        }
      }
      for (float f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);; f2 = 0.0F)
      {
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
        break;
        f1 = 0.0F;
        break label788;
      }
    }
  }
  
  protected void onTouchMove(int paramInt1, int paramInt2) {}
  
  public void postAdapterUpdate(RecyclerViewBase.UpdateOp paramUpdateOp)
  {
    this.mPendingUpdates.add(paramUpdateOp);
    if (this.mPendingUpdates.size() == 1)
    {
      setRecyclerViewTouchEnabled(false);
      if ((this.mPostUpdatesOnAnimation) && (this.mHasFixedSize) && (this.mIsAttached)) {
        ViewCompatTool.postOnAnimation(this, this.mUpdateChildViewsRunnable);
      }
    }
    else
    {
      return;
    }
    this.mAdapterUpdateDuringMeasure = true;
    requestLayout();
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
  
  void pullGlows(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {}
  }
  
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
    if (shouldStopReleaseGlows(paramBoolean1, paramBoolean2)) {
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
    if ((this.mOffsetX < this.mState.mCustomHeaderWidth) || (getWidth() > this.mState.mTotalHeight)) {
      scrollToTop(null);
    }
    while (this.mOffsetX <= this.mState.mTotalHeight - getWidth()) {
      return;
    }
    smoothScrollBy(this.mState.mTotalHeight - getWidth() - this.mOffsetX, 0);
  }
  
  protected void releaseGlowsForVertical()
  {
    int i = this.mState.mTotalHeight;
    if ((this.mOffsetY < this.mState.mCustomHeaderHeight) || (getHeight() > i)) {
      scrollToTop(null);
    }
    do
    {
      return;
      if (this.mOffsetY > i - getHeight())
      {
        smoothScrollBy(0, i - getHeight() - this.mOffsetY);
        return;
      }
    } while ((this.mOffsetY < i - getHeight()) || (!this.needNotifyFooter) || ((shouldPrebindItem()) && (this.mOffsetY + getHeight() != i)));
    this.needNotifyFooter = false;
    this.checkNotifyFooterOnRelease = false;
    this.mRecycler.notifyLastFooterAppeared();
  }
  
  public void removeAnimatingView(View paramView)
  {
    removeAnimatingView(paramView, false);
  }
  
  public void removeAnimatingView(View paramView, boolean paramBoolean)
  {
    int i;
    if (this.mNumAnimatingViews > 0) {
      i = this.mAnimatingViewIndex;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        if (getChildAt(i) != paramView) {
          break label152;
        }
        if (!paramBoolean) {
          break label100;
        }
        removeViewInLayout(paramView);
      }
      for (;;)
      {
        this.mNumAnimatingViews -= 1;
        if (this.mNumAnimatingViews == 0) {
          this.mAnimatingViewIndex = -1;
        }
        if ((getAdapter() == null) || (!getAdapter().hasCustomRecycler()) || (this.mAnimatingViewPos < 0) || (this.mAnimatingViewPos != this.mAnimatingViewPrevPos) || (paramBoolean)) {
          break;
        }
        return;
        label100:
        if ((getAdapter() == null) || (!getAdapter().hasCustomRecycler()) || (this.mAnimatingViewPos < 0) || (this.mAnimatingViewPos != this.mAnimatingViewPrevPos)) {
          removeViewAt(i);
        }
      }
      this.mRecycler.recycleView(paramView);
      return;
      label152:
      i += 1;
    }
  }
  
  void removeAnimatingViews()
  {
    int k = 0;
    int m = getChildCount();
    View[] arrayOfView = new View[m];
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
    if ((paramView2 != null) && (this.mLayout != null) && (!this.mLayout.onRequestChildFocus(this, paramView1, paramView2)))
    {
      this.mTempRect.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
      offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
      requestChildRectangleOnScreen(paramView1, this.mTempRect, true);
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
    boolean bool = false;
    if (this.mNeedStopAtTitleIndex != -1)
    {
      if (!this.mStopAtTitle) {
        break label34;
      }
      if (this.mOffsetY == getStopPosition()) {
        this.mStopAtTitle = false;
      }
    }
    label34:
    while (this.mOffsetY < getStopPosition()) {
      return;
    }
    if (getHeight() + getStopPosition() < this.mState.mTotalHeight) {
      bool = true;
    }
    this.mStopAtTitle = bool;
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
    if (this.mLayout == null) {
      throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        break label60;
      }
      if (!bool2) {
        break label65;
      }
    }
    for (;;)
    {
      scrollByInternal(paramInt1, paramInt2);
      return;
      label60:
      paramInt1 = 0;
      break;
      label65:
      paramInt2 = 0;
    }
  }
  
  void scrollByInternal(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (checkShouldConsumePendingUpdates()) {
      consumePendingUpdateOperations();
    }
    if (checkShouldStopScroll()) {
      return;
    }
    label67:
    int j;
    if (this.mAdapter != null)
    {
      eatRequestLayout();
      if (paramInt1 != 0)
      {
        paramInt1 = computeDxDy(paramInt1, 0, false, null, true)[0];
        i = paramInt1 - this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
        if (paramInt2 != 0)
        {
          paramInt2 = computeDxDy(0, paramInt2, false, null, true)[1];
          j = paramInt2 - this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
          label103:
          resumeRequestLayout(false);
        }
      }
    }
    for (;;)
    {
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
      if (awakenScrollBars()) {
        break;
      }
      return;
      j = 0;
      break label103;
      i = 0;
      break label67;
      j = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
  }
  
  public void scrollToPosition(int paramInt)
  {
    stopScroll();
    this.mLayout.scrollToPosition(paramInt);
    if (this.mScrollListener != null) {
      this.mScrollListener.onScrolled((int)getX(), paramInt);
    }
  }
  
  public void scrollToPosition(int paramInt1, int paramInt2)
  {
    stopScroll();
    this.mLayout.scrollToPositionWithOffset(paramInt1, paramInt2);
    if (this.mScrollListener != null) {
      this.mScrollListener.onScrolled((int)getX(), paramInt1);
    }
  }
  
  public void scrollToPositionWithGravity(int paramInt1, int paramInt2, int paramInt3)
  {
    stopScroll();
    this.mLayout.scrollToPositionWidthGravity(paramInt1, paramInt2, paramInt3);
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    if (this.mLayout != null) {
      this.mLayout.scrollToPositionWithOffset(paramInt1, paramInt2);
    }
  }
  
  public void scrollToTop(RecyclerViewBase.OnScrollFinishListener paramOnScrollFinishListener)
  {
    if (this.mLayout.canScrollHorizontally())
    {
      smoothScrollBy(-this.mOffsetX + this.mState.mCustomHeaderWidth, 0, false, true);
      this.mViewFlinger.mScrollFinishListener = paramOnScrollFinishListener;
      this.mViewFlinger.mTargetPosition = (-this.mOffsetX + this.mState.mCustomHeaderWidth);
      return;
    }
    smoothScrollBy(0, -this.mOffsetY + this.mState.mCustomHeaderHeight, false, true);
    this.mViewFlinger.mScrollFinishListener = paramOnScrollFinishListener;
    this.mViewFlinger.mTargetPosition = (-this.mOffsetY + this.mState.mCustomHeaderHeight);
  }
  
  public void scrollToTopAtOnce()
  {
    if (this.mAdapter == null) {
      return;
    }
    int[] arrayOfInt = this.mAdapter.getBeginPositionWithOffset(0);
    scrollToPosition(arrayOfInt[0], arrayOfInt[1]);
  }
  
  public void setAdapter(RecyclerViewBase.Adapter paramAdapter)
  {
    if (this.mAdapter != null) {
      this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
    }
    if (this.mLayout != null)
    {
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler, true, true);
    }
    RecyclerViewBase.Adapter localAdapter = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null) {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
    }
    if (this.mLayout != null) {
      this.mLayout.onAdapterChanged(localAdapter, this.mAdapter);
    }
    this.mRecycler.onAdapterChanged(localAdapter, this.mAdapter);
    this.mState.mStructureChanged = true;
    markKnownViewsInvalid();
    requestLayout();
  }
  
  public void setBlockScroll(boolean paramBoolean)
  {
    this.mBlockScroll = paramBoolean;
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
    if (this.mAdapter != null) {
      this.mAdapter.reset();
    }
    this.mRecycler.clear();
    removeAllViews();
    if (this.mLayout != null)
    {
      if (this.mIsAttached) {
        this.mLayout.onDetachedFromWindow(this);
      }
      this.mLayout.mRecyclerView = null;
    }
    this.mLayout = paramLayoutManager;
    if (paramLayoutManager != null)
    {
      if (paramLayoutManager.mRecyclerView != null) {
        throw new IllegalArgumentException("LayoutManager " + paramLayoutManager + " is already attached to a RecyclerView: " + paramLayoutManager.mRecyclerView);
      }
      paramLayoutManager.mRecyclerView = this;
      if (this.mIsAttached) {
        this.mLayout.onAttachedToWindow(this);
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
    if ((!paramBoolean) || (this.forceBlockTouch)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mAnimatingBlockTouch = paramBoolean;
      return;
    }
  }
  
  public void setRepeatableSuspensionMode(boolean paramBoolean)
  {
    this.mUseRepeatableSuspensionMode = paramBoolean;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {}
    for (;;)
    {
      return;
      int i = this.mScrollState;
      this.mScrollState = paramInt;
      if (paramInt != 2)
      {
        if ((isTouchStopWhenFastFling()) || (i != 2) || (paramInt != 1)) {
          break label65;
        }
        this.mTouchDownWhenSettlingFlag = true;
      }
      while (this.mScrollListener != null)
      {
        this.mScrollListener.onScrollStateChanged(i, paramInt);
        return;
        label65:
        stopScroll();
      }
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
    if (i < k)
    {
      RecyclerViewBase.UpdateOp localUpdateOp = (RecyclerViewBase.UpdateOp)this.mPendingUpdates.get(i);
      switch (localUpdateOp.cmd)
      {
      }
      for (;;)
      {
        this.mPendingLayoutUpdates.add(localUpdateOp);
        i += 1;
        break;
        offsetPositionRecordsForInsert(localUpdateOp.positionStart, localUpdateOp.itemCount);
        this.mItemsAddedOrRemoved = true;
        continue;
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
        for (;;)
        {
          this.mItemsAddedOrRemoved = true;
          break;
          int j = 0;
          while (j < localUpdateOp.itemCount)
          {
            disableHolderRecyclable(localUpdateOp.positionStart + j);
            j += 1;
          }
          offsetPositionRecordsForRemove(localUpdateOp.positionStart, localUpdateOp.itemCount, true);
        }
        viewRangeUpdate(localUpdateOp.positionStart, localUpdateOp.itemCount);
      }
    }
    this.mPendingUpdates.clear();
  }
  
  public int validateAnchorItemPosition(int paramInt)
  {
    if (this.mAdapter == null) {}
    int j;
    int i;
    do
    {
      return paramInt;
      j = this.mAdapter.getHeaderViewCount();
      i = this.mAdapter.getFooterViewCount();
      j = -j;
      if ((paramInt < 0) && (this.mAdapter.headerMayChange())) {
        return j;
      }
    } while ((paramInt < i + this.mAdapter.getItemCount()) && (paramInt > j));
    return j;
  }
  
  protected void viewRangeUpdate(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int k = paramInt1 + paramInt2;
    int i = 0;
    if (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = getChildViewHolderInt(getChildAt(i));
      if (localViewHolder == null) {}
      for (;;)
      {
        i += 1;
        break;
        int m = localViewHolder.mPosition;
        if ((m >= paramInt1) && (m < k)) {
          handleViewRangeUpdate(localViewHolder, paramInt1, k, m, paramInt2);
        }
      }
    }
    this.mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
 * JD-Core Version:    0.7.0.1
 */