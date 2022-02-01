package com.tencent.viola.ui.view.list;

import android.content.Context;
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
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectCell;
import com.tencent.viola.ui.dom.DomObjectCell.ComponentState;
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
    try
    {
      Object localObject;
      if (getComponent() != null)
      {
        int i = 0;
        while (i < getChildCount())
        {
          if ((((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + i) instanceof DomObjectCell))
          {
            DomObjectCell localDomObjectCell = (DomObjectCell)((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + i);
            if ((localDomObjectCell != null) && (localDomObjectCell.isRegisterDidAppear()))
            {
              localObject = getChildAt(i);
              Iterator localIterator = getRelativeIterator(localDomObjectCell);
              while (localIterator.hasNext())
              {
                Map.Entry localEntry = (Map.Entry)localIterator.next();
                if (isHorizontal()) {
                  f1 = ((View)localObject).getX();
                } else {
                  f1 = ((View)localObject).getY();
                }
                float f1 = getRelativeStart(f1, localDomObjectCell, localEntry);
                float f2 = getRelativeEnd(localDomObjectCell, localEntry, f1);
                DomObjectCell.ComponentState localComponentState = localDomObjectCell.getComponentState((String)localEntry.getKey());
                if (localComponentState.equals(DomObjectCell.ComponentState.DIDDISAPPEAR))
                {
                  if (((f2 > 0.0F) && (f1 < 0.0F) && ((!isScrollDown()) || (getRelativeOffset() != 0))) || ((f1 < getRelativeWidthOrHeight()) && (f2 > getRelativeWidthOrHeight()) && ((isScrollDown()) || (getRelativeOffset() != 0))))
                  {
                    fireDomObjectCell(localDomObjectCell, "willAppear", (String)localEntry.getKey());
                    localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.WILLAPPEAR);
                  }
                }
                else
                {
                  boolean bool = localComponentState.equals(DomObjectCell.ComponentState.DIDAPPEAR);
                  if (bool)
                  {
                    if ((f2 <= 0.0F) || (f1 >= getRelativeWidthOrHeight() - 1))
                    {
                      fireDomObjectCell(localDomObjectCell, "didDisappear", (String)localEntry.getKey());
                      localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
                      if ((localDomObjectCell.getTouchUpComptState((String)localEntry.getKey()) == null) || (DomObjectCell.ComponentState.WILLAPPEAR.equals(localDomObjectCell.getTouchUpComptState((String)localEntry.getKey())))) {
                        localDomObjectCell.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
                      }
                    }
                  }
                  else if (localComponentState.equals(DomObjectCell.ComponentState.WILLAPPEAR)) {
                    if (((f1 >= 0.0F) && (f2 <= getRelativeWidthOrHeight())) || ((f1 <= 0.0F) && (f2 > getRelativeWidthOrHeight())))
                    {
                      fireDomObjectCell(localDomObjectCell, "didAppear", (String)localEntry.getKey());
                      localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDAPPEAR);
                    }
                    else if (((f2 <= 0.0F) && ((isScrollDown()) || (getRelativeOffset() != 0))) || ((f1 >= getRelativeWidthOrHeight() - 1) && ((!isScrollDown()) || (getRelativeOffset() != 0))))
                    {
                      fireDomObjectCell(localDomObjectCell, "didDisappear", (String)localEntry.getKey());
                      localDomObjectCell.setComponentState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
                      if ((localDomObjectCell.getTouchUpComptState((String)localEntry.getKey()) == null) || (DomObjectCell.ComponentState.WILLAPPEAR.equals(localDomObjectCell.getTouchUpComptState((String)localEntry.getKey())))) {
                        localDomObjectCell.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
                      }
                    }
                  }
                }
              }
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("do component appear error:");
      ((StringBuilder)localObject).append(localException.getMessage());
      ViolaLogUtils.e("VRecyclerView", ((StringBuilder)localObject).toString());
    }
  }
  
  private int findLastCompletelyVisibleItemPositions()
  {
    Object localObject = getLayoutManager();
    if ((localObject instanceof LinearLayoutManager)) {
      return ((LinearLayoutManager)localObject).findLastCompletelyVisibleItemPosition();
    }
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)localObject;
      localObject = new int[localStaggeredGridLayoutManager.getSpanCount()];
      try
      {
        localStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions((int[])localObject);
      }
      catch (Exception localException)
      {
        ViolaLogUtils.d("VRecyclerView", localException.getMessage());
      }
      int j = localObject.length;
      int i = 0;
      if (j <= 0) {
        return 0;
      }
      j = localObject[0];
      int n = localObject.length;
      while (i < n)
      {
        int m = localObject[i];
        int k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
        j = k;
      }
      return j;
    }
    return -1;
  }
  
  private void fireDomObjectCell(DomObjectCell paramDomObjectCell, String paramString1, String paramString2)
  {
    if ((paramDomObjectCell.isComponentRegisterEvent(paramString1, paramString2)) && (getComponent() != null) && (getComponent().getInstance() != null)) {
      paramDomObjectCell.fireEvent(getComponent().getInstance().getInstanceId(), paramString1, paramString2);
    }
  }
  
  private float getRelativeEnd(DomObjectCell paramDomObjectCell, Map.Entry<String, Float> paramEntry, float paramFloat)
  {
    float f;
    if (isHorizontal()) {
      f = paramFloat - ((Float)paramEntry.getValue()).floatValue();
    }
    for (paramFloat = ((Float)paramDomObjectCell.getReDidAppearComptDxEndMap().get(paramEntry.getKey())).floatValue();; paramFloat = ((Float)paramDomObjectCell.getReDidAppearComptDyEndMap().get(paramEntry.getKey())).floatValue())
    {
      return f + paramFloat;
      f = paramFloat - ((Float)paramEntry.getValue()).floatValue();
    }
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
    if (isHorizontal()) {
      paramFloat = paramFloat + ((Float)paramEntry.getValue()).floatValue() + paramDomObjectCell.getPadding().get(0) + this.mRefreshOffsetX - ((Float)paramDomObjectCell.getReDidAppearComptDxStartOffsetMap().get(paramEntry.getKey())).floatValue();
    }
    for (float f = ((Float)paramDomObjectCell.getReDidAppearComptDxEndOffsetMap().get(paramEntry.getKey())).floatValue();; f = ((Float)paramDomObjectCell.getReDidAppearComptDyEndOffsetMap().get(paramEntry.getKey())).floatValue())
    {
      return paramFloat - f;
      paramFloat = paramFloat + ((Float)paramEntry.getValue()).floatValue() + paramDomObjectCell.getPadding().get(1) + this.mRefreshOffsetY - ((Float)paramDomObjectCell.getReDidAppearComptDyStartOffsetMap().get(paramEntry.getKey())).floatValue();
    }
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
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    boolean bool3 = localLayoutManager instanceof LinearLayoutManager;
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if (((LinearLayoutManager)localLayoutManager).getOrientation() == 1) {
        bool1 = true;
      }
      return bool1;
    }
    if ((localLayoutManager instanceof StaggeredGridLayoutManager))
    {
      bool1 = bool2;
      if (((StaggeredGridLayoutManager)localLayoutManager).getOrientation() == 1) {
        bool1 = true;
      }
      return bool1;
    }
    return true;
  }
  
  private void judgeNeedFireEventWhenIdelOrCreate(boolean paramBoolean)
  {
    try
    {
      if ((isFlying()) && (getComponent() != null))
      {
        int i = 0;
        while (i < getChildCount())
        {
          int j = getFirstVisibleItemPosition();
          float f;
          if (isHorizontal()) {
            f = getChildAt(i).getX();
          } else {
            f = getChildAt(i).getY();
          }
          traverseDomObjectCell(j + i, f, paramBoolean, false);
          i += 1;
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("judgeNeedFireEventWhenIdelOrCreate error:");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e("VRecyclerView", localStringBuilder.toString());
    }
  }
  
  private void setupPagerSnaper()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean shouldCallDidAppear(float paramFloat1, float paramFloat2)
  {
    return ((isScrollDown()) && (paramFloat1 < 0.0F) && (paramFloat2 > 0.0F)) || ((!isScrollDown()) && (paramFloat1 < getRelativeWidthOrHeight()) && (paramFloat2 > getRelativeWidthOrHeight()));
  }
  
  private void tryDetectLoadMore()
  {
    int i = getComponent().getContentHeight();
    int j = getHeight();
    if ((i > j) && (this.mIsListScroll) && (i - (-this.mContentOffsetY + j) <= this.mPreloadDistance) && (!this.mIsLoadingMore))
    {
      VRecyclerView.OnGestureListener localOnGestureListener = this.mGestureListener;
      if (localOnGestureListener != null)
      {
        this.mIsLoadingMore = true;
        localOnGestureListener.onLoadMore(this, this.mOffsetScrollerXByMotion, this.mOffsetScrollerYByMotion);
        ViolaLogUtils.d("VRecyclerView", "hit load more in tryDetectLoadMore");
      }
    }
  }
  
  public void bindComponent(VRecyclerList paramVRecyclerList)
  {
    this.mWeakReference = new WeakReference(paramVRecyclerList);
  }
  
  public void calAndSetContentOffset(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if (getComponent() != null) {
      bool = getComponent().isReverse();
    } else {
      bool = false;
    }
    if (bool) {
      paramFloat1 = -paramFloat1;
    }
    int m = getFirstVisibleItemPosition();
    if ((m == 0) && (getRelativeOffset() != 0))
    {
      if (paramBoolean)
      {
        this.mContentOffsetY = this.mRefreshOffsetY;
        return;
      }
      this.mContentOffsetX = this.mRefreshOffsetX;
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
    int k;
    for (i = 0; j < m; i = k)
    {
      DomObject localDomObject = ((VRecyclerViewAdapter)localObject).getItem(j);
      k = i;
      if (localDomObject != null)
      {
        paramFloat2 = i;
        if (paramBoolean) {
          paramFloat1 = localDomObject.getLayoutHeight();
        } else if (!bool) {
          paramFloat1 = localDomObject.getLayoutWidth();
        } else {
          paramFloat1 = -localDomObject.getLayoutWidth();
        }
        k = (int)(paramFloat2 - paramFloat1);
      }
      j += 1;
    }
    localObject = getChildAt(0);
    j = i;
    if (localObject != null)
    {
      if (paramBoolean) {
        j = ((View)localObject).getTop();
      } else {
        j = ((View)localObject).getLeft();
      }
      j = i + j;
    }
    if (paramBoolean)
    {
      this.mContentOffsetY = j;
      return;
    }
    if (bool) {
      j = -j;
    }
    this.mContentOffsetX = j;
  }
  
  public void calculateItemPreState()
  {
    if (getComponent() != null)
    {
      int k = 0;
      int i = 0;
      int j;
      DomObjectCell localDomObjectCell;
      for (;;)
      {
        j = k;
        if (i >= ((VRecyclerViewAdapter)getAdapter()).getItemCount()) {
          break;
        }
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
      while (j < getChildCount())
      {
        if ((((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + j) instanceof DomObjectCell))
        {
          localDomObjectCell = (DomObjectCell)((VRecyclerViewAdapter)getAdapter()).getItem(getFirstVisibleItemPosition() + j);
          if ((localDomObjectCell != null) && (localDomObjectCell.isRegisterDidAppear()))
          {
            View localView = getChildAt(j);
            Iterator localIterator = getRelativeIterator(localDomObjectCell);
            while (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              if (isHorizontal()) {
                f1 = localView.getX();
              } else {
                f1 = localView.getY();
              }
              float f1 = getRelativeStart(f1, localDomObjectCell, localEntry);
              float f2 = getRelativeEnd(localDomObjectCell, localEntry, f1);
              if (DomObjectCell.ComponentState.WILLAPPEAR.equals(localDomObjectCell.getComponentState((String)localEntry.getKey())))
              {
                if (shouldCallDidAppear(f1, f2)) {
                  localDomObjectCell.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDDISAPPEAR);
                } else {
                  localDomObjectCell.setTouchUpComptState((String)localEntry.getKey(), DomObjectCell.ComponentState.DIDAPPEAR);
                }
              }
              else if (DomObjectCell.ComponentState.DIDDISAPPEAR.equals(localDomObjectCell.getComponentState((String)localEntry.getKey())))
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
        j += 1;
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
    int k = paramMotionEvent.getAction() & 0xFF;
    VRecyclerView.OnGestureListener localOnGestureListener = this.mGestureListener;
    if (localOnGestureListener != null)
    {
      int j;
      if (isVertical()) {
        j = this.mContentOffsetY;
      } else {
        j = this.mContentOffsetX;
      }
      int i;
      if (!canChildPullDown()) {
        i = 1;
      } else if (!canChildPullUp()) {
        i = 2;
      } else {
        i = 0;
      }
      localOnGestureListener.onDispatchTouchEvent(j, paramMotionEvent, i);
    }
    if (k != 0)
    {
      if (k != 1)
      {
        if (k == 2)
        {
          this.mOffsetScrollerYByMotion = ((int)(paramMotionEvent.getY() - this.mStartY));
          this.mOffsetScrollerXByMotion = ((int)(paramMotionEvent.getX() - this.mStartX));
          this.mIsListScroll = true;
          if ((isHorizontal()) && (Math.abs(this.mOffsetScrollerYByMotion) > this.mTouchSlop) && (Math.abs(this.mOffsetScrollerXByMotion) / Math.abs(this.mOffsetScrollerYByMotion) < 0.5F) && (getParent() != null)) {
            getParent().requestDisallowInterceptTouchEvent(false);
          }
        }
      }
      else
      {
        this.mOffsetScrollerYByMotion = ((int)(paramMotionEvent.getY() - this.mStartY));
        this.mOffsetScrollerXByMotion = ((int)(paramMotionEvent.getX() - this.mStartX));
        localOnGestureListener = this.mGestureListener;
        if (localOnGestureListener != null) {
          localOnGestureListener.onTouchUp(this, 0, this.mContentOffsetY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        }
        calculateItemPreState();
      }
    }
    else
    {
      this.mStartY = ((int)paramMotionEvent.getY());
      this.mStartX = ((int)paramMotionEvent.getX());
      localOnGestureListener = this.mGestureListener;
      if (localOnGestureListener != null) {
        localOnGestureListener.onTouchDown(this, 0, this.mContentOffsetY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
      }
      if (isHorizontal()) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
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
  
  public int getCurrentSnapPosition()
  {
    PagerSnapHelper localPagerSnapHelper = this.mPagerSnapHelper;
    if (localPagerSnapHelper != null) {
      return localPagerSnapHelper.getCurrentPosition();
    }
    return -1;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFirstVisibleItemPosition error = ");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e("VRecyclerView", localStringBuilder.toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLastVisibleItemPosition error = ");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e("VRecyclerView", localStringBuilder.toString());
      }
    }
    return -1;
  }
  
  public int getMinFlingVelocity()
  {
    if (getLayoutManager().canScrollVertically()) {
      return super.getMinFlingVelocity();
    }
    return super.getMinFlingVelocity();
  }
  
  public RefreshMoveOberver getRefreshMoveOberver()
  {
    return this.mRefreshMoveOberver;
  }
  
  public int getSnapOffset()
  {
    PagerSnapHelper localPagerSnapHelper = this.mPagerSnapHelper;
    if (localPagerSnapHelper != null) {
      return localPagerSnapHelper.getSnapOffset();
    }
    return 0;
  }
  
  public boolean isScrollDown()
  {
    int i = this.mSnaperReboundOffset;
    if (i == 0)
    {
      if (!isHorizontal()) {
        return this.mOffsetScrollerYByMotion < 0;
      }
      return this.mOffsetScrollerXByMotion < 0;
    }
    return i > 0;
  }
  
  public void juegeIfNeedCalculate(int paramInt)
  {
    if (this.mScrollDistance * paramInt < 0) {
      calculateItemPreState();
    }
    this.mScrollDistance = paramInt;
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
    PagerSnapHelper localPagerSnapHelper = this.mPagerSnapHelper;
    if ((localPagerSnapHelper != null) && (localPagerSnapHelper.isSnapping())) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onOverScroll(float paramFloat)
  {
    boolean bool;
    if (getComponent() != null) {
      bool = getComponent().isReverse();
    } else {
      bool = false;
    }
    float f = paramFloat;
    if (bool) {
      f = -paramFloat;
    }
    if (f > 0.0F) {
      paramFloat = f;
    } else if (f < 0.0F) {
      paramFloat = this.mContentOffsetX + f;
    } else {
      paramFloat = this.mContentOffsetX;
    }
    VRecyclerView.OnGestureListener localOnGestureListener = this.mGestureListener;
    if (localOnGestureListener != null) {
      localOnGestureListener.onScroll(this, (int)paramFloat, 0, 0, 0, true);
    }
    this.mRefreshOffsetX = ((int)f);
    callComponentAppear();
  }
  
  public void onPagerChanged(RecyclerView.ViewHolder paramViewHolder)
  {
    this.mSnaperReboundOffset = 0;
    if ((paramViewHolder != null) && (this.mGestureListener != null))
    {
      Object localObject = (VRecyclerViewAdapter.VH)paramViewHolder;
      if (((VRecyclerViewAdapter.VH)localObject).mVCell != null) {
        localObject = ((VRecyclerViewAdapter.VH)localObject).mVCell.getRef();
      } else {
        localObject = "";
      }
      this.mGestureListener.onStickItemChange(paramViewHolder.getLayoutPosition(), (String)localObject);
    }
    calculateItemPreState();
  }
  
  public void onPagerRebound(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      this.mSnaperReboundOffset = paramInt1;
    } else if (paramInt2 != 0) {
      this.mSnaperReboundOffset = paramInt2;
    }
    calculateItemPreState();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    PagerSnapHelper localPagerSnapHelper = this.mPagerSnapHelper;
    if ((localPagerSnapHelper != null) && (localPagerSnapHelper.isSnapping())) {
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
    int j;
    if (bool)
    {
      i = this.mContentOffsetY;
      j = this.mLastContentOffsetY;
    }
    else
    {
      i = this.mContentOffsetX;
      j = this.mLastContentOffsetX;
    }
    i -= j;
    VRecyclerView.OnGestureListener localOnGestureListener;
    if (Math.abs(i) >= this.mScrollMinOffset)
    {
      juegeIfNeedCalculate(i);
      if (bool) {
        this.mLastContentOffsetY = this.mContentOffsetY;
      } else {
        this.mLastContentOffsetX = this.mContentOffsetX;
      }
      localOnGestureListener = this.mGestureListener;
      if (localOnGestureListener != null)
      {
        if (bool) {
          i = 0;
        } else {
          i = this.mContentOffsetX;
        }
        if (bool) {
          j = this.mContentOffsetY;
        } else {
          j = 0;
        }
        localOnGestureListener.onScroll(this, i, j, paramInt1, paramInt2, false);
      }
    }
    if ((this.mGestureListener != null) && (getAdapter() != null))
    {
      localOnGestureListener = this.mGestureListener;
      if (bool) {
        paramInt2 = this.mContentOffsetY;
      } else {
        paramInt2 = this.mContentOffsetX;
      }
      i = getFirstVisibleItemPosition();
      j = getChildCount();
      int k = getAdapter().getItemCount();
      if (!canChildPullDown()) {
        paramInt1 = 1;
      } else if (!canChildPullUp()) {
        paramInt1 = 2;
      } else {
        paramInt1 = 0;
      }
      localOnGestureListener.onScroll(paramInt2, i, j, k, paramInt1);
    }
    callComponentAppear();
  }
  
  public void requestPagerChanged()
  {
    PagerSnapHelper localPagerSnapHelper = this.mPagerSnapHelper;
    if (localPagerSnapHelper != null) {
      localPagerSnapHelper.requestLayoutChanged();
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    super.scrollBy(paramInt1, paramInt2);
    PagerSnapHelper localPagerSnapHelper = this.mPagerSnapHelper;
    if (localPagerSnapHelper != null) {
      localPagerSnapHelper.requestLayoutChanged();
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    super.scrollToPosition(paramInt);
    PagerSnapHelper localPagerSnapHelper = this.mPagerSnapHelper;
    if (localPagerSnapHelper != null) {
      localPagerSnapHelper.requestLayoutChanged();
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
  
  public void setPlaceHeaderCount(int paramInt)
  {
    PagerSnapHelper localPagerSnapHelper = this.mPagerSnapHelper;
    if (localPagerSnapHelper != null) {
      localPagerSnapHelper.setPlaceHeaderCount(paramInt);
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
    PagerSnapHelper localPagerSnapHelper = this.mPagerSnapHelper;
    if (localPagerSnapHelper != null) {
      localPagerSnapHelper.snapToTargetPosition(paramInt);
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
            if ((f2 > 0.0F) && ((f1 < getRelativeWidthOrHeight() - 1) || (paramBoolean1)))
            {
              if (((f1 >= 0.0F) && (f2 <= getRelativeWidthOrHeight())) || ((f1 <= 0.0F) && (f2 > getRelativeWidthOrHeight())))
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
            else if (localComponentState.equals(DomObjectCell.ComponentState.WILLAPPEAR))
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
        }
      }
    }
  }
  
  public void traverseDomObjectCell(int paramInt, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f;
    if (isHorizontal()) {
      f = paramView.getX();
    } else {
      f = paramView.getY();
    }
    traverseDomObjectCell(paramInt, f, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.VRecyclerView
 * JD-Core Version:    0.7.0.1
 */