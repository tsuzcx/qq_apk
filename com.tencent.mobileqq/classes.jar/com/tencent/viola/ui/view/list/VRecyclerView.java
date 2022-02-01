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
  private int mRefreshOffsetX = 0;
  private int mRefreshOffsetY = 0;
  private int mScrollDistance = 0;
  private VRecyclerView.ScrollListener mScrollListener;
  private int mScrollMinOffset = 0;
  private int mSnaperReboundOffset = 0;
  private int mStartX = 0;
  private int mStartY = 0;
  protected int mTouchSlop;
  private WeakReference<VRecyclerList> mWeakReference;
  private int pagerGravity = 0;
  private int snapOffset = 0;
  private float snapSpeedFactor = 25.0F;
  private VRecyclerView.VerticalOverScrollEventListener verticalOverScrollEventListener;
  
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
  
  private void callComponentAppear()
  {
    label669:
    for (;;)
    {
      int i;
      View localView;
      Map.Entry localEntry;
      float f2;
      DomObjectCell.ComponentState localComponentState;
      try
      {
        if (getComponent() != null)
        {
          i = 0;
          if (i < getChildCount())
          {
            if (!(((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + i) instanceof DomObjectCell)) {
              break label669;
            }
            DomObjectCell localDomObjectCell = (DomObjectCell)((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + i);
            if ((localDomObjectCell == null) || (!localDomObjectCell.isRegisterDidAppear())) {
              break label669;
            }
            localView = getChildAt(i);
            Iterator localIterator = getRelativeIterator(localDomObjectCell);
            if (!localIterator.hasNext()) {
              break label669;
            }
            localEntry = (Map.Entry)localIterator.next();
            if (!isHorizontal()) {
              break label302;
            }
            f1 = localView.getX();
            f1 = getRelativeStart(f1, localDomObjectCell, localEntry);
            f2 = getRelativeEnd(localDomObjectCell, localEntry, f1);
            localComponentState = localDomObjectCell.getComponentState((String)localEntry.getKey());
            if (!localComponentState.equals(DomObjectCell.ComponentState.DIDDISAPPEAR)) {
              break label311;
            }
            if (((f2 <= 0.0F) || (f1 >= 0.0F) || ((isScrollDown()) && (getRelativeOffset() == 0))) && ((f1 >= getRelativeWidthOrHeight()) || (f2 <= getRelativeWidthOrHeight()) || ((!isScrollDown()) && (getRelativeOffset() == 0)))) {
              continue;
            }
            fireDomObjectCell(localDomObjectCell, "willAppear", (String)localEntry.getKey());
            localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.WILLAPPEAR);
            continue;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VRecyclerView", "do component appear error:" + localException.getMessage());
      }
      label302:
      float f1 = localView.getY();
      continue;
      label311:
      if (localComponentState.equals(DomObjectCell.ComponentState.DIDAPPEAR))
      {
        if ((f2 <= 0.0F) || (f1 >= getRelativeWidthOrHeight() - 1))
        {
          fireDomObjectCell(localException, "didDisappear", (String)localEntry.getKey());
          localException.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
          if ((localException.getTouchUpComptState((String)localEntry.getKey()) == null) || (DomObjectCell.ComponentState.WILLAPPEAR.equals(localException.getTouchUpComptState((String)localEntry.getKey())))) {
            localException.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
          }
        }
      }
      else if (localComponentState.equals(DomObjectCell.ComponentState.WILLAPPEAR)) {
        if (((f1 >= 0.0F) && (f2 <= getRelativeWidthOrHeight())) || ((f1 <= 0.0F) && (f2 > getRelativeWidthOrHeight())))
        {
          fireDomObjectCell(localException, "didAppear", (String)localEntry.getKey());
          localException.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDAPPEAR);
        }
        else if (((f2 <= 0.0F) && ((isScrollDown()) || (getRelativeOffset() != 0))) || ((f1 >= getRelativeWidthOrHeight() - 1) && ((!isScrollDown()) || (getRelativeOffset() != 0))))
        {
          fireDomObjectCell(localException, "didDisappear", (String)localEntry.getKey());
          localException.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
          if ((localException.getTouchUpComptState((String)localEntry.getKey()) == null) || (DomObjectCell.ComponentState.WILLAPPEAR.equals(localException.getTouchUpComptState((String)localEntry.getKey()))))
          {
            localException.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
            continue;
            i += 1;
          }
        }
      }
    }
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
  
  private float getRelativeEnd(DomObjectCell paramDomObjectCell, Map.Entry<String, Float> paramEntry, float paramFloat)
  {
    if (isHorizontal())
    {
      f = ((Float)paramEntry.getValue()).floatValue();
      return ((Float)paramDomObjectCell.getReDidAppearComptDxEndMap().get(paramEntry.getKey())).floatValue() + (paramFloat - f);
    }
    float f = ((Float)paramEntry.getValue()).floatValue();
    return ((Float)paramDomObjectCell.getReDidAppearComptDyEndMap().get(paramEntry.getKey())).floatValue() + (paramFloat - f);
  }
  
  private Iterator getRelativeIterator(DomObjectCell paramDomObjectCell)
  {
    if (isHorizontal()) {
      return paramDomObjectCell.getReDidAppearComptDxStartMap().entrySet().iterator();
    }
    return paramDomObjectCell.getReDidAppearComptDyStartMap().entrySet().iterator();
  }
  
  private int getRelativeOffset()
  {
    if (isHorizontal()) {
      return this.mRefreshOffsetX;
    }
    return this.mRefreshOffsetY;
  }
  
  private float getRelativeStart(float paramFloat, DomObjectCell paramDomObjectCell, Map.Entry<String, Float> paramEntry)
  {
    if (isHorizontal())
    {
      f1 = ((Float)paramEntry.getValue()).floatValue();
      f2 = paramDomObjectCell.getPadding().get(0);
      return this.mRefreshOffsetX + (f1 + paramFloat + f2) - ((Float)paramDomObjectCell.getReDidAppearComptDxStartOffsetMap().get(paramEntry.getKey())).floatValue() - ((Float)paramDomObjectCell.getReDidAppearComptDxEndOffsetMap().get(paramEntry.getKey())).floatValue();
    }
    float f1 = ((Float)paramEntry.getValue()).floatValue();
    float f2 = paramDomObjectCell.getPadding().get(1);
    return this.mRefreshOffsetY + (f1 + paramFloat + f2) - ((Float)paramDomObjectCell.getReDidAppearComptDyStartOffsetMap().get(paramEntry.getKey())).floatValue() - ((Float)paramDomObjectCell.getReDidAppearComptDyEndOffsetMap().get(paramEntry.getKey())).floatValue();
  }
  
  private int getRelativeWidthOrHeight()
  {
    if (isHorizontal()) {
      return getWidth();
    }
    return getHeight();
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
  
  private boolean isOutSideList(float paramFloat1, float paramFloat2)
  {
    return ((isScrollDown()) && (paramFloat1 > getRelativeWidthOrHeight())) || ((!isScrollDown()) && (paramFloat2 < 0.0F));
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
    try
    {
      if ((isFlying()) && (getComponent() != null))
      {
        int i = 0;
        if (i < getChildCount())
        {
          int j = getFirstVisibleItemPosition();
          if (isHorizontal()) {}
          for (float f = getChildAt(i).getX();; f = getChildAt(i).getY())
          {
            traverseDomObjectCell(i + j, f, paramBoolean, false);
            i += 1;
            break;
          }
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
    boolean bool2 = true;
    Object localObject;
    if (getComponent().getDomObject().getAttributes().containsKey("stickyType"))
    {
      localObject = (String)getComponent().getDomObject().getAttributes().get("stickyType");
      if (!"none".equals(localObject))
      {
        if (getComponent().getDomObject().getAttributes().containsKey("stickyOffset")) {
          this.snapOffset = ((int)FlexConvertUtils.converPxByViewportToRealPx(getComponent().getDomObject().getAttributes().get("stickyOffset"), 750));
        }
        if (!getComponent().getDomObject().getAttributes().containsKey("stickyRebound")) {
          break label603;
        }
      }
    }
    label401:
    label548:
    label598:
    label603:
    for (boolean bool1 = ((Boolean)getComponent().getDomObject().getAttributes().get("stickyRebound")).booleanValue();; bool1 = true)
    {
      int i;
      if ("top".equals(localObject))
      {
        i = 1;
        this.pagerGravity = i;
        this.mPagerSnapHelper = new PagerSnapHelper(this.pagerGravity);
        this.mPagerSnapHelper.setSnapOffset(this.snapOffset);
        this.mPagerSnapHelper.setHorizontalReverseLayout(getComponent().isReverse());
        this.mPagerSnapHelper.setEventListener(this);
        this.mPagerSnapHelper.attachToRecyclerView(this);
        if (bool1) {
          this.mPagerSnapHelper.setReboundFooterCount(1);
        }
        if (Build.VERSION.SDK_INT >= 23) {
          this.mPagerSnapHelper.setQuickPageChanged(true);
        }
        if (getComponent().getDomObject().getAttributes().containsKey("stickyItemSpeed")) {
          this.mPagerSnapHelper.setSnapSpeedFactor(((Integer)getComponent().getDomObject().getAttributes().get("stickyItemSpeed")).intValue());
        }
        if (getComponent().getDomObject().getAttributes().containsKey("stickySpeed"))
        {
          if (!(getComponent().getDomObject().getAttributes().get("stickySpeed") instanceof Double)) {
            break label518;
          }
          this.snapSpeedFactor = Float.valueOf(getComponent().getDomObject().getAttributes().get("stickySpeed").toString()).floatValue();
          label361:
          this.flingVelocityIncrease = ((int)this.snapSpeedFactor);
          if (getMinFlingVelocity() <= 10000) {
            break label548;
          }
          this.flingVelocityIncrease = 0;
          this.mPagerSnapHelper.setSnapOnFling(false);
          this.mPagerSnapHelper.setSnapOnIdle(false);
        }
        if (getComponent().getDomObject().getAttributes().containsKey("stickySlowRebound"))
        {
          i = ((Integer)getComponent().getDomObject().getAttributes().get("stickySlowRebound")).intValue();
          localObject = this.mPagerSnapHelper;
          if (i != 1) {
            break label598;
          }
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        ((PagerSnapHelper)localObject).setSnapOnIdle(bool1);
        if (getComponent().getDomObject().getAttributes().containsKey("stickLastPosition"))
        {
          bool1 = ((Boolean)getComponent().getDomObject().getAttributes().get("stickLastPosition")).booleanValue();
          this.mPagerSnapHelper.setStickLastPosition(bool1);
        }
        return;
        i = 0;
        break;
        this.snapSpeedFactor = ((Integer)getComponent().getDomObject().getAttributes().get("stickySpeed")).intValue();
        break label361;
        if (getMinFlingVelocity() <= 0)
        {
          this.flingVelocityIncrease = 0;
          this.mPagerSnapHelper.setSnapOnFling(true);
          this.mPagerSnapHelper.setSnapOnIdle(true);
          break label401;
        }
        this.mPagerSnapHelper.setSnapOnIdle(false);
        this.mPagerSnapHelper.setSnapOnFling(true);
        break label401;
      }
    }
  }
  
  private boolean shouldCallDidAppear(float paramFloat1, float paramFloat2)
  {
    return ((isScrollDown()) && (paramFloat1 < 0.0F) && (paramFloat2 > 0.0F)) || ((!isScrollDown()) && (paramFloat1 < getRelativeWidthOrHeight()) && (paramFloat2 > getRelativeWidthOrHeight()));
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
    if (getComponent() != null) {}
    for (boolean bool = getComponent().isReverse();; bool = false)
    {
      if (!bool) {}
      int m;
      for (;;)
      {
        m = getFirstVisibleItemPosition();
        if ((m != 0) || (getRelativeOffset() == 0)) {
          break label67;
        }
        if (!paramBoolean) {
          break;
        }
        this.mContentOffsetY = this.mRefreshOffsetY;
        return;
        paramFloat1 = -paramFloat1;
      }
      this.mContentOffsetX = this.mRefreshOffsetX;
      return;
      label67:
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
            break label188;
          }
          paramFloat1 = localDomObject.getLayoutHeight();
        }
        for (;;)
        {
          k = (int)(paramFloat2 - paramFloat1);
          j += 1;
          i = k;
          break;
          label188:
          if (!bool) {
            paramFloat1 = localDomObject.getLayoutWidth();
          } else {
            paramFloat1 = -localDomObject.getLayoutWidth();
          }
        }
      }
      localObject = getChildAt(0);
      if (localObject != null) {
        if (paramBoolean)
        {
          j = ((View)localObject).getTop();
          i = j + i;
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          this.mContentOffsetY = i;
          return;
          j = ((View)localObject).getLeft();
          break;
        }
        if (!bool) {}
        for (;;)
        {
          this.mContentOffsetX = i;
          return;
          i = -i;
        }
      }
    }
  }
  
  public void calculateItemPreState()
  {
    if (getComponent() != null)
    {
      int i = 0;
      DomObjectCell localDomObjectCell;
      while (i < ((VRecyclerViewAdapter)getAdapter()).getItemCount())
      {
        if ((((VRecyclerViewAdapter)getAdapter()).getItem(i) instanceof DomObjectCell))
        {
          localDomObjectCell = (DomObjectCell)((VRecyclerViewAdapter)getAdapter()).getItem(i);
          if ((localDomObjectCell != null) && (localDomObjectCell.isRegisterDidAppear()))
          {
            localDomObjectCell.clearComptStateWhenTouchDown();
            localDomObjectCell.setTouchDirection(isScrollDown());
          }
        }
        i += 1;
      }
      i = 0;
      while (i < getChildCount())
      {
        if ((((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + i) instanceof DomObjectCell))
        {
          localDomObjectCell = (DomObjectCell)((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + i);
          if ((localDomObjectCell != null) && (localDomObjectCell.isRegisterDidAppear()))
          {
            View localView = getChildAt(i);
            Iterator localIterator = getRelativeIterator(localDomObjectCell);
            while (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              if (isHorizontal()) {}
              float f2;
              for (float f1 = localView.getX();; f1 = localView.getY())
              {
                f1 = getRelativeStart(f1, localDomObjectCell, localEntry);
                f2 = getRelativeEnd(localDomObjectCell, localEntry, f1);
                if (!DomObjectCell.ComponentState.WILLAPPEAR.equals(localDomObjectCell.getComponentState((String)localEntry.getKey()))) {
                  break label310;
                }
                if (!shouldCallDidAppear(f1, f2)) {
                  break label289;
                }
                localDomObjectCell.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
                break;
              }
              label289:
              localDomObjectCell.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDAPPEAR);
              continue;
              label310:
              if (DomObjectCell.ComponentState.DIDDISAPPEAR.equals(localDomObjectCell.getComponentState((String)localEntry.getKey())))
              {
                if (((isScrollDown()) && (f2 < 0.0F)) || ((!isScrollDown()) && (f1 > getRelativeWidthOrHeight()))) {
                  localDomObjectCell.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
                } else {
                  localDomObjectCell.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.WILLAPPEAR);
                }
              }
              else {
                localDomObjectCell.setTouchUpComptState((String)localEntry.getKey(), localDomObjectCell.getComponentState((String)localEntry.getKey()));
              }
            }
          }
        }
        i += 1;
      }
    }
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
          calculateItemPreState();
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
    if ((localObject instanceof StaggeredGridLayoutManager)) {
      try
      {
        localObject = ((StaggeredGridLayoutManager)localObject).findLastVisibleItemPositions(null);
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = localObject[0];
          return i;
        }
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VRecyclerView", "getLastVisibleItemPosition error = " + localException.getMessage());
        return -1;
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
  
  public boolean isScrollDown()
  {
    if (this.mSnaperReboundOffset == 0) {
      if (!isHorizontal()) {
        if (this.mOffsetScrollerYByMotion >= 0) {}
      }
    }
    while (this.mSnaperReboundOffset > 0)
    {
      do
      {
        return true;
        return false;
      } while (this.mOffsetScrollerXByMotion < 0);
      return false;
    }
    return false;
  }
  
  public void juegeIfNeedCalculate(int paramInt)
  {
    if (this.mScrollDistance * paramInt >= 0) {}
    for (;;)
    {
      this.mScrollDistance = paramInt;
      return;
      calculateItemPreState();
    }
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
    if (getComponent() != null) {}
    for (boolean bool = getComponent().isReverse();; bool = false)
    {
      if (bool) {
        paramFloat = -paramFloat;
      }
      for (;;)
      {
        float f;
        if (paramFloat > 0.0F) {
          f = paramFloat;
        }
        for (;;)
        {
          if (this.mGestureListener != null) {
            this.mGestureListener.onScroll(this, (int)f, 0, 0, 0, true);
          }
          this.mRefreshOffsetX = ((int)paramFloat);
          callComponentAppear();
          return;
          if (paramFloat < 0.0F) {
            f = this.mContentOffsetX + paramFloat;
          } else {
            f = this.mContentOffsetX;
          }
        }
      }
    }
  }
  
  public void onPagerChanged(RecyclerView.ViewHolder paramViewHolder)
  {
    this.mSnaperReboundOffset = 0;
    if ((paramViewHolder != null) && (this.mGestureListener != null)) {
      if (((VRecyclerViewAdapter.VH)paramViewHolder).mVCell == null) {
        break label56;
      }
    }
    label56:
    for (String str = ((VRecyclerViewAdapter.VH)paramViewHolder).mVCell.getRef();; str = "")
    {
      this.mGestureListener.onStickItemChange(paramViewHolder.getLayoutPosition(), str);
      calculateItemPreState();
      return;
    }
  }
  
  public void onPagerRebound(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      this.mSnaperReboundOffset = paramInt1;
    }
    for (;;)
    {
      calculateItemPreState();
      return;
      if (paramInt2 != 0) {
        this.mSnaperReboundOffset = paramInt2;
      }
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
    boolean bool = isVertical();
    calAndSetContentOffset(bool, paramInt1, paramInt2);
    int i;
    label60:
    VRecyclerView.OnGestureListener localOnGestureListener;
    label80:
    int j;
    label91:
    int k;
    if (bool)
    {
      i = this.mContentOffsetY - this.mLastContentOffsetY;
      if (Math.abs(i) >= this.mScrollMinOffset)
      {
        juegeIfNeedCalculate(i);
        if (!bool) {
          break label196;
        }
        this.mLastContentOffsetY = this.mContentOffsetY;
        if (this.mGestureListener != null)
        {
          localOnGestureListener = this.mGestureListener;
          if (!bool) {
            break label207;
          }
          i = 0;
          if (!bool) {
            break label215;
          }
          j = this.mContentOffsetY;
          localOnGestureListener.onScroll(this, i, j, paramInt1, paramInt2, false);
        }
      }
      if ((this.mGestureListener != null) && (getAdapter() != null))
      {
        localOnGestureListener = this.mGestureListener;
        if (!bool) {
          break label221;
        }
        paramInt2 = this.mContentOffsetY;
        label135:
        i = getFirstVisibleItemPosition();
        j = getChildCount();
        k = getAdapter().getItemCount();
        if (canChildPullDown()) {
          break label229;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      localOnGestureListener.onScroll(paramInt2, i, j, k, paramInt1);
      callComponentAppear();
      return;
      i = this.mContentOffsetX - this.mLastContentOffsetX;
      break;
      label196:
      this.mLastContentOffsetX = this.mContentOffsetX;
      break label60;
      label207:
      i = this.mContentOffsetX;
      break label80;
      label215:
      j = 0;
      break label91;
      label221:
      paramInt2 = this.mContentOffsetX;
      break label135;
      label229:
      if (!canChildPullUp()) {
        paramInt1 = 2;
      } else {
        paramInt1 = 0;
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
  
  public void setVerticalOverScrollEventListener(VRecyclerView.VerticalOverScrollEventListener paramVerticalOverScrollEventListener)
  {
    this.verticalOverScrollEventListener = paramVerticalOverScrollEventListener;
  }
  
  public void snapToTargetPosition(int paramInt)
  {
    if (this.mPagerSnapHelper != null) {
      this.mPagerSnapHelper.snapToTargetPosition(paramInt);
    }
  }
  
  public void traverseDomObjectCell(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((((VRecyclerViewAdapter)getAdapter()).getItem(paramInt) instanceof DomObjectCell))
    {
      DomObjectCell localDomObjectCell = (DomObjectCell)((VRecyclerViewAdapter)getAdapter()).getItem(paramInt);
      if ((localDomObjectCell != null) && (localDomObjectCell.isRegisterDidAppear()))
      {
        Iterator localIterator = getRelativeIterator(localDomObjectCell);
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          float f1 = getRelativeStart(paramFloat, localDomObjectCell, localEntry);
          float f2 = getRelativeEnd(localDomObjectCell, localEntry, f1);
          DomObjectCell.ComponentState localComponentState = localDomObjectCell.getComponentState((String)localEntry.getKey());
          if ((!paramBoolean2) || (localComponentState.equals(DomObjectCell.ComponentState.DIDDISAPPEAR))) {
            if ((f2 <= 0.0F) || ((f1 >= getRelativeWidthOrHeight() - 1) && (!paramBoolean1)))
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
            else if (((f1 >= 0.0F) && (f2 <= getRelativeWidthOrHeight())) || ((f1 <= 0.0F) && (f2 > getRelativeWidthOrHeight())))
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
            else if (((f2 > 0.0F) && (f1 < 0.0F) && ((!isScrollDown()) || (paramBoolean1))) || ((f1 < getRelativeWidthOrHeight()) && (f2 > getRelativeWidthOrHeight()) && ((isScrollDown()) || (paramBoolean1))))
            {
              if (localComponentState.equals(DomObjectCell.ComponentState.DIDDISAPPEAR))
              {
                localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.WILLAPPEAR);
                fireDomObjectCell(localDomObjectCell, "willAppear", (String)localEntry.getKey());
              }
            }
            else if ((shouldCallDidAppear(f1, f2)) && (localDomObjectCell.getTouchUpComptState((String)localEntry.getKey()) == null)) {
              if (localComponentState.equals(DomObjectCell.ComponentState.WILLAPPEAR))
              {
                fireDomObjectCell(localDomObjectCell, "didAppear", (String)localEntry.getKey());
                localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDAPPEAR);
              }
              else if (localComponentState.equals(DomObjectCell.ComponentState.DIDDISAPPEAR))
              {
                fireDomObjectCell(localDomObjectCell, "willAppear", (String)localEntry.getKey());
                fireDomObjectCell(localDomObjectCell, "didAppear", (String)localEntry.getKey());
                localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDAPPEAR);
              }
            }
          }
        }
      }
    }
  }
  
  public void traverseDomObjectCell(int paramInt, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isHorizontal()) {}
    for (float f = paramView.getX();; f = paramView.getY())
    {
      traverseDomObjectCell(paramInt, f, paramBoolean1, paramBoolean2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.VRecyclerView
 * JD-Core Version:    0.7.0.1
 */