package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerView
  extends RecyclerViewBase
  implements ScrollChecker.IScrollCheck, RecyclerViewBase.OnScrollListener
{
  public List<RecyclerView.OnListScrollListener> mListScrollListeners = null;
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
      this.mListScrollListeners = new ArrayList();
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
    if (this.mRecyclerViewAdapter != null) {
      return this.mRecyclerViewAdapter.getHeightBefore(paramInt);
    }
    return 0;
  }
  
  public boolean horizontalCanScroll(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mLayout != null)
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
  
  public void onConfigurationChanged(Configuration paramConfiguration)
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
    switch (paramInt2)
    {
    }
    do
    {
      for (;;)
      {
        return;
        Iterator localIterator;
        if (paramInt1 == 2)
        {
          onScrollFlingEnded();
          if (this.mListScrollListeners != null)
          {
            localIterator = this.mListScrollListeners.iterator();
            while (localIterator.hasNext()) {
              ((RecyclerView.OnListScrollListener)localIterator.next()).onScrollEnd();
            }
          }
        }
        else if (paramInt1 == 1)
        {
          onScrollDragEnded();
          if (this.mListScrollListeners != null)
          {
            localIterator = this.mListScrollListeners.iterator();
            while (localIterator.hasNext()) {
              ((RecyclerView.OnListScrollListener)localIterator.next()).onDragEnd();
            }
            continue;
            if (paramInt1 == 1)
            {
              onScrollDragEnded();
              onScrollFlingStarted();
              if (this.mListScrollListeners != null)
              {
                localIterator = this.mListScrollListeners.iterator();
                while (localIterator.hasNext()) {
                  ((RecyclerView.OnListScrollListener)localIterator.next()).onStartFling();
                }
                continue;
                if (paramInt1 != 0) {
                  break;
                }
                onScrollDragStarted();
                if (this.mListScrollListeners != null)
                {
                  localIterator = this.mListScrollListeners.iterator();
                  while (localIterator.hasNext()) {
                    ((RecyclerView.OnListScrollListener)localIterator.next()).onStartDrag();
                  }
                }
              }
            }
          }
        }
      }
    } while (paramInt1 != 2);
    onScrollFlingEnded();
    onScrollDragStarted();
  }
  
  public void onScrolled(int paramInt1, int paramInt2)
  {
    if ((this.mListScrollListeners == null) || (this.mListScrollListeners.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mListScrollListeners.iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.OnListScrollListener)localIterator.next()).onScroll(paramInt1, paramInt2);
      }
    }
  }
  
  public void removeOnListScrollListener(RecyclerView.OnListScrollListener paramOnListScrollListener)
  {
    if ((this.mListScrollListeners != null) && (this.mListScrollListeners.contains(paramOnListScrollListener))) {
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mLayout != null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerView
 * JD-Core Version:    0.7.0.1
 */