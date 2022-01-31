package com.tencent.viola.ui.view.list;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter.VH;
import com.tencent.viola.ui.component.VCell;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectCell;
import com.tencent.viola.ui.dom.DomObjectCell.ComponentState;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.dom.style.StyleSpace;
import com.tencent.viola.ui.view.IVView;
import com.tencent.viola.ui.view.overscroll.OverScrollHelper.OverScrollListener;
import com.tencent.viola.ui.view.refresh.RefreshMoveOberver;
import com.tencent.viola.ui.view.refresh.VRefreshContentView.ContentViewProvider;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class VRecyclerView
  extends RecyclerViewCompat
  implements IVView<VRecyclerList>, PagerSnapHelper.PagerEventListener, OverScrollHelper.OverScrollListener, VRefreshContentView.ContentViewProvider<VRecyclerView>
{
  private static final String TAG = "VRecyclerView";
  private int flingVelocityIncrease = 0;
  private int mContentOffsetX = 0;
  private int mContentOffsetY = 0;
  private VRecyclerView.OnGestureListener mGestureListener;
  private boolean mIsFlying = false;
  private boolean mIsListScroll = false;
  private boolean mIsLoadingMore = false;
  private int mLastContentOffsetX = 0;
  private int mLastContentOffsetY = 0;
  private int mOffsetScrollerXByMotion = 0;
  private int mOffsetScrollerYByMotion = 0;
  private PagerSnapHelper mPagerSnapHelper;
  private int mPreloadDistance = 200;
  private RefreshMoveOberver mRefreshMoveOberver;
  private int mRefreshOffset = 0;
  private int mScrollDy = 1;
  private VRecyclerView.ScrollListener mScrollListener;
  private int mScrollMinOffset = 5;
  private int mStartX = 0;
  private int mStartY = 0;
  protected int mTouchSlop;
  private WeakReference<VRecyclerList> mWeakReference;
  private int pagerGravity = 0;
  private int snapOffset = 0;
  private float snapSpeedFactor = 25.0F;
  
  public VRecyclerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private int findLastCompletelyVisibleItemPositions()
  {
    int j = 0;
    Object localObject = getLayoutManager();
    if ((localObject instanceof LinearLayoutManager))
    {
      j = ((LinearLayoutManager)localObject).findLastCompletelyVisibleItemPosition();
      return j;
    }
    StaggeredGridLayoutManager localStaggeredGridLayoutManager;
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)localObject;
      localObject = new int[localStaggeredGridLayoutManager.getSpanCount()];
    }
    label121:
    for (;;)
    {
      try
      {
        localStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions((int[])localObject);
        if (localObject.length <= 0) {
          break;
        }
        int i = localObject[0];
        int m = localObject.length;
        int k = 0;
        j = i;
        if (k >= m) {
          break;
        }
        j = localObject[k];
        if (j <= i) {
          break label121;
        }
        i = j;
        k += 1;
        continue;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.d("VRecyclerView", localException.getMessage());
        continue;
      }
      return -1;
    }
  }
  
  private void fireDomObjectCell(DomObjectCell paramDomObjectCell, String paramString1, String paramString2)
  {
    if ((paramDomObjectCell.isComponentRegisterEvent(paramString1, paramString2)) && (getComponent() != null) && (getComponent().getInstance() != null)) {
      paramDomObjectCell.fireEvent(getComponent().getInstance().getInstanceId(), paramString1, paramString2);
    }
  }
  
  private void init()
  {
    this.mScrollListener = new VRecyclerView.ScrollListener(this, null);
    addOnScrollListener(this.mScrollListener);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.mRefreshMoveOberver = new VRecyclerView.1(this);
  }
  
  private boolean isFlying()
  {
    return this.mIsFlying;
  }
  
  private boolean isHorizontal()
  {
    return (getComponent() != null) && (getComponent().mOrientation == 0);
  }
  
  private boolean isScrollDown()
  {
    return this.mScrollDy > 0;
  }
  
  private boolean isVertical()
  {
    boolean bool2 = true;
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    boolean bool1;
    if ((localLayoutManager instanceof LinearLayoutManager)) {
      if (((LinearLayoutManager)localLayoutManager).getOrientation() == 1) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
        bool1 = bool2;
      } while (!(localLayoutManager instanceof StaggeredGridLayoutManager));
      bool1 = bool2;
    } while (((StaggeredGridLayoutManager)localLayoutManager).getOrientation() == 1);
    return false;
  }
  
  private void judgeNeedFireEventWhenIdelOrCreate(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      if ((isFlying()) && (!isHorizontal()) && (getComponent() != null)) {
        while (i < getChildCount())
        {
          traverseDomObjectCell(getFirstVisibleItemPosition() + i, getChildAt(i).getY(), paramBoolean, false);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VRecyclerView", "judgeNeedFireEventWhenIdelOrCreate error:" + localException.getMessage());
    }
  }
  
  private void setupPagerSnaper()
  {
    String str;
    if (getComponent().getDomObject().getAttributes().containsKey("stickyType"))
    {
      str = (String)getComponent().getDomObject().getAttributes().get("stickyType");
      if (!"none".equals(str))
      {
        if (getComponent().getDomObject().getAttributes().containsKey("stickyOffset")) {
          this.snapOffset = ((int)FlexConvertUtils.converPxByViewportToRealPx(getComponent().getDomObject().getAttributes().get("stickyOffset"), 750));
        }
        if (!getComponent().getDomObject().getAttributes().containsKey("stickyRebound")) {
          break label416;
        }
      }
    }
    label416:
    for (boolean bool = ((Boolean)getComponent().getDomObject().getAttributes().get("stickyRebound")).booleanValue();; bool = true)
    {
      int i;
      if ("top".equals(str))
      {
        i = 1;
        this.pagerGravity = i;
        this.mPagerSnapHelper = new PagerSnapHelper(this.pagerGravity);
        this.mPagerSnapHelper.setSnapOffset(this.snapOffset);
        this.mPagerSnapHelper.setEventListener(this);
        this.mPagerSnapHelper.attachToRecyclerView(this);
        if (bool) {
          this.mPagerSnapHelper.setReboundFooterCount(1);
        }
        if (Build.VERSION.SDK_INT >= 23) {
          this.mPagerSnapHelper.setQuickPageChanged(true);
        }
        if (getComponent().getDomObject().getAttributes().containsKey("stickySpeed")) {
          if (!(getComponent().getDomObject().getAttributes().get("stickySpeed") instanceof Double)) {
            break label340;
          }
        }
      }
      label340:
      for (this.snapSpeedFactor = Float.valueOf(getComponent().getDomObject().getAttributes().get("stickySpeed").toString()).floatValue();; this.snapSpeedFactor = ((Integer)getComponent().getDomObject().getAttributes().get("stickySpeed")).intValue())
      {
        this.flingVelocityIncrease = ((int)this.snapSpeedFactor);
        if (getMinFlingVelocity() <= 10000) {
          break label370;
        }
        this.flingVelocityIncrease = 0;
        this.mPagerSnapHelper.setSnapOnFling(false);
        this.mPagerSnapHelper.setSnapOnIdle(false);
        return;
        i = 0;
        break;
      }
      label370:
      if (getMinFlingVelocity() <= 0)
      {
        this.flingVelocityIncrease = 0;
        this.mPagerSnapHelper.setSnapOnFling(true);
        this.mPagerSnapHelper.setSnapOnIdle(true);
        return;
      }
      this.mPagerSnapHelper.setSnapOnIdle(false);
      this.mPagerSnapHelper.setSnapOnFling(true);
      return;
    }
  }
  
  private void tryDetectLoadMore()
  {
    int i = getComponent().getContentHeight();
    int j = getHeight();
    if ((i > j) && (this.mIsListScroll) && (i - (j + -this.mContentOffsetY) <= this.mPreloadDistance) && (!this.mIsLoadingMore) && (this.mGestureListener != null))
    {
      this.mIsLoadingMore = true;
      this.mGestureListener.onLoadMore(this, this.mOffsetScrollerXByMotion, this.mOffsetScrollerYByMotion);
      ViolaLogUtils.d("VRecyclerView", "hit load more in tryDetectLoadMore");
    }
  }
  
  public void bindComponent(VRecyclerList paramVRecyclerList)
  {
    this.mWeakReference = new WeakReference(paramVRecyclerList);
  }
  
  public void calAndSetContentOffset(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    int m = getFirstVisibleItemPosition();
    if ((m == 0) && (this.mRefreshOffset != 0))
    {
      if (paramBoolean)
      {
        this.mContentOffsetY = this.mRefreshOffset;
        return;
      }
      this.mContentOffsetX = this.mRefreshOffset;
      return;
    }
    Object localObject = (VRecyclerViewAdapter)getAdapter();
    int i = ((VRecyclerViewAdapter)localObject).getItemCount();
    if (findLastCompletelyVisibleItemPositions() == i - 1)
    {
      if (paramBoolean)
      {
        this.mContentOffsetY = ((int)(this.mContentOffsetY + paramFloat2));
        return;
      }
      this.mContentOffsetX = ((int)(this.mContentOffsetX + paramFloat1));
      return;
    }
    int j = 0;
    i = 0;
    if (j < m)
    {
      DomObject localDomObject = ((VRecyclerViewAdapter)localObject).getItem(j);
      int k = i;
      if (localDomObject != null)
      {
        paramFloat2 = i;
        if (!paramBoolean) {
          break label161;
        }
      }
      label161:
      for (paramFloat1 = localDomObject.getLayoutHeight();; paramFloat1 = localDomObject.getLayoutWidth())
      {
        k = (int)(paramFloat2 - paramFloat1);
        j += 1;
        i = k;
        break;
      }
    }
    localObject = getChildAt(0);
    j = i;
    if (localObject != null) {
      if (!paramBoolean) {
        break label215;
      }
    }
    label215:
    for (j = ((View)localObject).getTop();; j = ((View)localObject).getLeft())
    {
      j = i + j;
      if (!paramBoolean) {
        break;
      }
      this.mContentOffsetY = j;
      return;
    }
    this.mContentOffsetX = j;
  }
  
  public boolean canChildPullDown()
  {
    return (ViewCompat.canScrollVertically(this, -1)) || (getScrollY() > 0);
  }
  
  public boolean canChildPullUp()
  {
    return ViewCompat.canScrollVertically(this, 1);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    int j;
    int i;
    if (this.mGestureListener != null)
    {
      VRecyclerView.OnGestureListener localOnGestureListener = this.mGestureListener;
      if (isVertical())
      {
        j = this.mContentOffsetY;
        if (canChildPullDown()) {
          break label98;
        }
        i = 1;
        label40:
        localOnGestureListener.onDispatchTouchEvent(j, paramMotionEvent, i);
      }
    }
    else
    {
      switch (k & 0xFF)
      {
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      j = this.mContentOffsetX;
      break;
      label98:
      if (!canChildPullUp())
      {
        i = 2;
        break label40;
      }
      i = 0;
      break label40;
      this.mStartY = ((int)paramMotionEvent.getY());
      this.mStartX = ((int)paramMotionEvent.getX());
      if (this.mGestureListener != null) {
        this.mGestureListener.onTouchDown(this, 0, this.mContentOffsetY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
      }
      if (isHorizontal())
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        continue;
        this.mOffsetScrollerYByMotion = ((int)(paramMotionEvent.getY() - this.mStartY));
        this.mOffsetScrollerXByMotion = ((int)(paramMotionEvent.getX() - this.mStartX));
        this.mIsListScroll = true;
        if ((isHorizontal()) && (Math.abs(this.mOffsetScrollerYByMotion) > this.mTouchSlop) && (Math.abs(this.mOffsetScrollerXByMotion) / Math.abs(this.mOffsetScrollerYByMotion) < 0.5F) && (getParent() != null))
        {
          getParent().requestDisallowInterceptTouchEvent(false);
          continue;
          this.mOffsetScrollerYByMotion = ((int)(paramMotionEvent.getY() - this.mStartY));
          this.mOffsetScrollerXByMotion = ((int)(paramMotionEvent.getX() - this.mStartX));
          if (this.mGestureListener != null) {
            this.mGestureListener.onTouchUp(this, 0, this.mContentOffsetY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
          }
        }
      }
    }
  }
  
  public VRecyclerList getComponent()
  {
    return (VRecyclerList)this.mWeakReference.get();
  }
  
  public int getContentOffsetX()
  {
    return this.mContentOffsetX;
  }
  
  public int getContentOffsetY()
  {
    return this.mContentOffsetY;
  }
  
  public VRecyclerView getContentView()
  {
    return this;
  }
  
  public int getFirstVisibleItemPosition()
  {
    try
    {
      Object localObject = getLayoutManager();
      if ((localObject instanceof LinearLayoutManager)) {
        return ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      }
      if ((localObject instanceof StaggeredGridLayoutManager))
      {
        localObject = ((StaggeredGridLayoutManager)localObject).findFirstVisibleItemPositions(null);
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = localObject[0];
          return i;
        }
      }
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VRecyclerView", "getFirstVisibleItemPosition error = " + localException.getMessage());
    }
    return -1;
  }
  
  public int getLastVisibleItemPosition()
  {
    Object localObject = getLayoutManager();
    if ((localObject instanceof LinearLayoutManager)) {
      return ((LinearLayoutManager)localObject).findLastVisibleItemPosition();
    }
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      localObject = ((StaggeredGridLayoutManager)localObject).findLastVisibleItemPositions(null);
      if ((localObject != null) && (localObject.length > 0)) {
        return localObject[0];
      }
    }
    return -1;
  }
  
  public int getMinFlingVelocity()
  {
    if (getLayoutManager().canScrollVertically()) {
      return super.getMinFlingVelocity() + this.flingVelocityIncrease;
    }
    return super.getMinFlingVelocity() + this.flingVelocityIncrease;
  }
  
  public RefreshMoveOberver getRefreshMoveOberver()
  {
    return this.mRefreshMoveOberver;
  }
  
  public int getSnapOffset()
  {
    if (this.mPagerSnapHelper != null) {
      return this.mPagerSnapHelper.getSnapOffset();
    }
    return 0;
  }
  
  public void loadMoreFinish(Boolean paramBoolean)
  {
    this.mIsLoadingMore = paramBoolean.booleanValue();
  }
  
  public void onFooterRebound() {}
  
  public void onHeaderRebounded()
  {
    this.mScrollListener.onScrollStateChanged(this, 0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mPagerSnapHelper != null) && (this.mPagerSnapHelper.isSnapping())) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onOverScroll(float paramFloat)
  {
    if (paramFloat > 0.0F) {}
    for (;;)
    {
      if (this.mGestureListener != null) {
        this.mGestureListener.onScroll(this, (int)paramFloat, 0, 0, 0);
      }
      return;
      if (paramFloat < 0.0F) {
        paramFloat += this.mContentOffsetX;
      } else {
        paramFloat = this.mContentOffsetX;
      }
    }
  }
  
  public void onPagerChanged(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && (this.mGestureListener != null)) {
      if (((VRecyclerViewAdapter.VH)paramViewHolder).mVCell == null) {
        break label47;
      }
    }
    label47:
    for (String str = ((VRecyclerViewAdapter.VH)paramViewHolder).mVCell.getRef();; str = "")
    {
      this.mGestureListener.onStickItemChange(paramViewHolder.getLayoutPosition(), str);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mPagerSnapHelper != null) && (this.mPagerSnapHelper.isSnapping())) {
      return true;
    }
    if (paramMotionEvent.getAction() == 2) {
      this.mIsListScroll = true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void performOnScroll(int paramInt1, int paramInt2)
  {
    int k = 0;
    boolean bool = isVertical();
    calAndSetContentOffset(bool, paramInt1, paramInt2);
    int i;
    label60:
    Object localObject;
    label81:
    int j;
    if (bool)
    {
      i = this.mContentOffsetY - this.mLastContentOffsetY;
      if (Math.abs(i) >= this.mScrollMinOffset)
      {
        if (!bool) {
          break label673;
        }
        this.mLastContentOffsetY = this.mContentOffsetY;
        if (this.mGestureListener != null)
        {
          localObject = this.mGestureListener;
          if (!bool) {
            break label684;
          }
          i = 0;
          if (!bool) {
            break label693;
          }
          j = this.mContentOffsetY;
          label92:
          ((VRecyclerView.OnGestureListener)localObject).onScroll(this, i, j, paramInt1, paramInt2);
        }
      }
      if ((this.mGestureListener != null) && (getAdapter() != null))
      {
        localObject = this.mGestureListener;
        if (!bool) {
          break label699;
        }
        paramInt2 = this.mContentOffsetY;
        label136:
        i = getFirstVisibleItemPosition();
        j = getChildCount();
        int m = getAdapter().getItemCount();
        if (canChildPullDown()) {
          break label707;
        }
        paramInt1 = 1;
        label166:
        ((VRecyclerView.OnGestureListener)localObject).onScroll(paramInt2, i, j, m, paramInt1);
      }
    }
    label673:
    label684:
    label693:
    label699:
    label707:
    label966:
    for (;;)
    {
      Map.Entry localEntry;
      float f1;
      float f2;
      DomObjectCell.ComponentState localComponentState;
      try
      {
        if ((getComponent() != null) && (!isHorizontal()))
        {
          paramInt1 = k;
          if (paramInt1 < getChildCount())
          {
            if (!(((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + paramInt1) instanceof DomObjectCell)) {
              break label966;
            }
            localObject = (DomObjectCell)((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + paramInt1);
            if ((localObject == null) || (!((DomObjectCell)localObject).isRegisterDidAppear())) {
              break label966;
            }
            View localView = getChildAt(paramInt1);
            Iterator localIterator = ((DomObjectCell)localObject).getRegisterDidAppearComponentDyStartMap().entrySet().iterator();
            if (!localIterator.hasNext()) {
              break label966;
            }
            localEntry = (Map.Entry)localIterator.next();
            f1 = localView.getY();
            f2 = ((Float)localEntry.getValue()).floatValue();
            float f3 = ((DomObjectCell)localObject).getPadding().get(1);
            f1 = this.mRefreshOffset + (f2 + f1 + f3) - ((Float)((DomObjectCell)localObject).getRegisterDidAppearComponentDyStartOffsetMap().get(localEntry.getKey())).floatValue() - ((Float)((DomObjectCell)localObject).getRegisterDidAppearComponentDyEndOffsetMap().get(localEntry.getKey())).floatValue();
            f2 = localView.getY();
            f3 = ((Float)((DomObjectCell)localObject).getRegisterDidAppearComponentDyEndMap().get(localEntry.getKey())).floatValue();
            float f4 = ((DomObjectCell)localObject).getPadding().get(1);
            f2 = this.mRefreshOffset + (f3 + f2 + f4) - ((Float)((DomObjectCell)localObject).getRegisterDidAppearComponentDyStartOffsetMap().get(localEntry.getKey())).floatValue() - ((Float)((DomObjectCell)localObject).getRegisterDidAppearComponentDyEndOffsetMap().get(localEntry.getKey())).floatValue();
            localComponentState = ((DomObjectCell)localObject).getComponentState((String)localEntry.getKey());
            if (!localComponentState.equals(DomObjectCell.ComponentState.DIDDISAPPEAR)) {
              break label724;
            }
            if (((f2 <= 0.0F) || (f1 >= 0.0F) || ((isScrollDown()) && (this.mRefreshOffset == 0))) && ((f1 >= getHeight()) || (f2 <= getHeight()) || ((!isScrollDown()) && (this.mRefreshOffset == 0)))) {
              continue;
            }
            fireDomObjectCell((DomObjectCell)localObject, "willAppear", (String)localEntry.getKey());
            ((DomObjectCell)localObject).setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.WILLAPPEAR);
            continue;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VRecyclerView", "do component appear error:" + localException.getMessage());
      }
      i = this.mContentOffsetX - this.mLastContentOffsetX;
      break;
      this.mLastContentOffsetX = this.mContentOffsetX;
      break label60;
      i = this.mContentOffsetX;
      break label81;
      j = 0;
      break label92;
      paramInt2 = this.mContentOffsetX;
      break label136;
      if (!canChildPullUp())
      {
        paramInt1 = 2;
        break label166;
      }
      paramInt1 = 0;
      break label166;
      label724:
      if (localComponentState.equals(DomObjectCell.ComponentState.DIDAPPEAR))
      {
        if ((f2 <= 0.0F) || (f1 >= getHeight() - 1))
        {
          fireDomObjectCell(localException, "didDisappear", (String)localEntry.getKey());
          localException.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
        }
      }
      else if (localComponentState.equals(DomObjectCell.ComponentState.WILLAPPEAR)) {
        if (((f1 >= 0.0F) && (f2 <= getHeight())) || ((f1 <= 0.0F) && (f2 > getHeight())))
        {
          fireDomObjectCell(localException, "didAppear", (String)localEntry.getKey());
          localException.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDAPPEAR);
        }
        else if (((f2 <= 0.0F) && ((isScrollDown()) || (this.mRefreshOffset != 0))) || ((f1 >= getHeight() - 1) && ((!isScrollDown()) || (this.mRefreshOffset != 0))))
        {
          fireDomObjectCell(localException, "didDisappear", (String)localEntry.getKey());
          localException.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
          continue;
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void scrollToTop(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      smoothScrollToPosition(0);
      return;
    }
    scrollToPosition(0);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    RecyclerView.Adapter localAdapter = getAdapter();
    super.setAdapter(paramAdapter);
    if ((localAdapter != getAdapter()) && (getAdapter() != null) && (getLayoutManager() != null)) {
      setupPagerSnaper();
    }
  }
  
  public void setGestureListener(VRecyclerView.OnGestureListener paramOnGestureListener)
  {
    this.mGestureListener = paramOnGestureListener;
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    super.setLayoutManager(paramLayoutManager);
    if ((localLayoutManager != getLayoutManager()) && (getLayoutManager() != null) && (getAdapter() != null)) {
      setupPagerSnaper();
    }
  }
  
  public void setPreloadDistance(int paramInt)
  {
    this.mPreloadDistance = paramInt;
  }
  
  public void setScrollMinOffset(int paramInt)
  {
    this.mScrollMinOffset = paramInt;
  }
  
  public void traverseDomObjectCell(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((((VRecyclerViewAdapter)getAdapter()).getItem(paramInt) instanceof DomObjectCell))
    {
      DomObjectCell localDomObjectCell = (DomObjectCell)((VRecyclerViewAdapter)getAdapter()).getItem(paramInt);
      if ((localDomObjectCell != null) && (localDomObjectCell.isRegisterDidAppear()))
      {
        Iterator localIterator = localDomObjectCell.getRegisterDidAppearComponentDyStartMap().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          float f1 = ((Float)localEntry.getValue()).floatValue();
          float f2 = localDomObjectCell.getPadding().get(1);
          f1 = this.mRefreshOffset + (f1 + paramFloat + f2) - ((Float)localDomObjectCell.getRegisterDidAppearComponentDyStartOffsetMap().get(localEntry.getKey())).floatValue() - ((Float)localDomObjectCell.getRegisterDidAppearComponentDyEndOffsetMap().get(localEntry.getKey())).floatValue();
          f2 = ((Float)localDomObjectCell.getRegisterDidAppearComponentDyEndMap().get(localEntry.getKey())).floatValue();
          float f3 = localDomObjectCell.getPadding().get(1);
          f2 = this.mRefreshOffset + (f2 + paramFloat + f3) - ((Float)localDomObjectCell.getRegisterDidAppearComponentDyStartOffsetMap().get(localEntry.getKey())).floatValue() - ((Float)localDomObjectCell.getRegisterDidAppearComponentDyEndOffsetMap().get(localEntry.getKey())).floatValue();
          DomObjectCell.ComponentState localComponentState = localDomObjectCell.getComponentState((String)localEntry.getKey());
          if ((!paramBoolean2) || (localComponentState.equals(DomObjectCell.ComponentState.DIDDISAPPEAR))) {
            if ((f2 <= 0.0F) || ((f1 >= getHeight() - 1) && (!paramBoolean1)))
            {
              if (localComponentState.equals(DomObjectCell.ComponentState.WILLAPPEAR))
              {
                fireDomObjectCell(localDomObjectCell, "didAppear", (String)localEntry.getKey());
                fireDomObjectCell(localDomObjectCell, "didDisappear", (String)localEntry.getKey());
                localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
              }
              else if (localComponentState.equals(DomObjectCell.ComponentState.DIDAPPEAR))
              {
                fireDomObjectCell(localDomObjectCell, "didDisappear", (String)localEntry.getKey());
                localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
              }
            }
            else if (((f1 >= 0.0F) && (f2 <= getHeight())) || ((f1 <= 0.0F) && (f2 > getHeight())))
            {
              if (localComponentState.equals(DomObjectCell.ComponentState.DIDDISAPPEAR))
              {
                fireDomObjectCell(localDomObjectCell, "willAppear", (String)localEntry.getKey());
                fireDomObjectCell(localDomObjectCell, "didAppear", (String)localEntry.getKey());
                localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDAPPEAR);
              }
              else if (localComponentState.equals(DomObjectCell.ComponentState.WILLAPPEAR))
              {
                fireDomObjectCell(localDomObjectCell, "didAppear", (String)localEntry.getKey());
                localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDAPPEAR);
              }
            }
            else if (((f2 > 0.0F) && (f1 < 0.0F) && ((!isScrollDown()) || (paramBoolean1))) || ((f1 < getHeight()) && (f2 > getHeight()) && ((isScrollDown()) || (paramBoolean1)))) {
              if (localComponentState.equals(DomObjectCell.ComponentState.DIDAPPEAR))
              {
                fireDomObjectCell(localDomObjectCell, "didDisappear", (String)localEntry.getKey());
                fireDomObjectCell(localDomObjectCell, "willAppear", (String)localEntry.getKey());
                localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.WILLAPPEAR);
              }
              else if (localComponentState.equals(DomObjectCell.ComponentState.DIDDISAPPEAR))
              {
                localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.WILLAPPEAR);
                fireDomObjectCell(localDomObjectCell, "willAppear", (String)localEntry.getKey());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.VRecyclerView
 * JD-Core Version:    0.7.0.1
 */