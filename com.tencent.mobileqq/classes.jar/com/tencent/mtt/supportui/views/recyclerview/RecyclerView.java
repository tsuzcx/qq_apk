package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class RecyclerView
  extends RecyclerViewBase
  implements ScrollChecker.IScrollCheck, RecyclerViewBase.OnScrollListener
{
  public CopyOnWriteArrayList<RecyclerView.OnListScrollListener> mListScrollListeners = null;
  public RecyclerAdapter mRecyclerViewAdapter;
  
  public RecyclerView(Context paramContext)
  {
    super(paramContext);
    setOverScrollEnabled(true);
    setVerticalScrollBarEnabled(true);
    setHorizontalScrollBarEnabled(false);
    setOnScrollListener(this);
    setAnimationCacheEnabled(false);
  }
  
  public void addOnListScrollListener(RecyclerView.OnListScrollListener paramOnListScrollListener)
  {
    if (this.mListScrollListeners == null) {
      this.mListScrollListeners = new CopyOnWriteArrayList();
    }
    if (!this.mListScrollListeners.contains(paramOnListScrollListener)) {
      this.mListScrollListeners.add(paramOnListScrollListener);
    }
  }
  
  protected boolean canTranversal(int paramInt, RecyclerViewBase.ViewHolder paramViewHolder)
  {
    return super.canTranversal(paramInt, paramViewHolder);
  }
  
  public void checkNotifyFooterAppearWithFewChild(int paramInt)
  {
    RecyclerViewBase.Adapter localAdapter = getAdapter();
    if ((localAdapter != null) && (this.mOffsetY + getHeight() >= localAdapter.getListTotalHeight() - localAdapter.getDefaultFooterHeight()))
    {
      View localView = getLayoutManager().getChildClosestToEndInScreen();
      if ((localView != null) && ((localView instanceof IRecyclerViewFooter))) {
        localAdapter.notifyLastFooterAppeared();
      }
    }
  }
  
  public View createFooterView(Context paramContext)
  {
    return null;
  }
  
  public RecyclerViewBase.ViewHolder createViewHolder(View paramView, RecyclerViewBase paramRecyclerViewBase)
  {
    return new RecyclerView.ViewHolderWrapper(paramView, paramRecyclerViewBase);
  }
  
  public RecyclerViewItem createViewItem()
  {
    return new RecyclerViewItem(getContext(), this);
  }
  
  public int findNextSuspentedPos(int paramInt)
  {
    return this.mAdapter.findNextSuspentedPos(paramInt);
  }
  
  public int findPrevSuspentedPos(int paramInt)
  {
    return this.mAdapter.findPrevSuspentedPos(paramInt);
  }
  
  public int getHeightBefore(int paramInt)
  {
    RecyclerAdapter localRecyclerAdapter = this.mRecyclerViewAdapter;
    if (localRecyclerAdapter != null) {
      return localRecyclerAdapter.getHeightBefore(paramInt);
    }
    return 0;
  }
  
  public boolean horizontalCanScroll(int paramInt)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localLayoutManager != null)
    {
      bool1 = bool2;
      if (this.mHorizontalCanScroll)
      {
        bool1 = bool2;
        if (this.mLayout.canScrollHorizontally()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected boolean needAdvancedStopDetachChildView()
  {
    return false;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    onOrientationChanged();
  }
  
  public void onItemsFill(int paramInt)
  {
    super.onItemsFill(paramInt);
    RecyclerViewBase.Adapter localAdapter = getAdapter();
    if (localAdapter != null) {
      localAdapter.onItemsFill(paramInt);
    }
  }
  
  public void onOrientationChanged() {}
  
  protected void onScrollDragEnded() {}
  
  protected void onScrollDragStarted() {}
  
  protected void onScrollFlingEnded() {}
  
  protected void onScrollFlingStarted() {}
  
  public void onScrollStateChanged(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return;
        }
        if (paramInt1 == 1)
        {
          onScrollDragEnded();
          onScrollFlingStarted();
          localObject = this.mListScrollListeners;
          if (localObject != null)
          {
            localObject = ((CopyOnWriteArrayList)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((RecyclerView.OnListScrollListener)((Iterator)localObject).next()).onStartFling();
            }
          }
        }
      }
      else if (paramInt1 == 0)
      {
        onScrollDragStarted();
        localObject = this.mListScrollListeners;
        if (localObject != null)
        {
          localObject = ((CopyOnWriteArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((RecyclerView.OnListScrollListener)((Iterator)localObject).next()).onStartDrag();
          }
        }
      }
      else if (paramInt1 == 2)
      {
        onScrollFlingEnded();
        onScrollDragStarted();
      }
    }
    else if (paramInt1 == 2)
    {
      onScrollFlingEnded();
      localObject = this.mListScrollListeners;
      if (localObject != null)
      {
        localObject = ((CopyOnWriteArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((RecyclerView.OnListScrollListener)((Iterator)localObject).next()).onScrollEnd();
        }
      }
    }
    else if (paramInt1 == 1)
    {
      onScrollDragEnded();
      localObject = this.mListScrollListeners;
      if (localObject != null)
      {
        localObject = ((CopyOnWriteArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((RecyclerView.OnListScrollListener)((Iterator)localObject).next()).onDragEnd();
        }
      }
    }
  }
  
  public void onScrolled(int paramInt1, int paramInt2)
  {
    Object localObject = this.mListScrollListeners;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return;
      }
      localObject = this.mListScrollListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RecyclerView.OnListScrollListener)((Iterator)localObject).next()).onScroll(paramInt1, paramInt2);
      }
    }
  }
  
  public void removeOnListScrollListener(RecyclerView.OnListScrollListener paramOnListScrollListener)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.mListScrollListeners;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.contains(paramOnListScrollListener))) {
      this.mListScrollListeners.remove(paramOnListScrollListener);
    }
  }
  
  public void reset()
  {
    scrollToPosition(0);
    this.mOffsetY = 0;
    this.mInitialTouchY = 0;
    this.mLastTouchY = 0;
    this.mScrollState = 0;
    this.mScrollPointerId = -1;
    this.mVelocityTracker = null;
  }
  
  public void setAdapter(RecyclerViewBase.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
    this.mRecyclerViewAdapter = ((RecyclerAdapter)paramAdapter);
  }
  
  public boolean verticalCanScroll(int paramInt)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = this.mLayout;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localLayoutManager != null)
    {
      bool1 = bool2;
      if (this.mVerticalCanScroll)
      {
        bool1 = bool2;
        if (this.mLayout.canScrollVertically()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerView
 * JD-Core Version:    0.7.0.1
 */