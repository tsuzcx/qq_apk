package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;
import java.util.ArrayList;

public abstract class RecyclerViewBase$Adapter<VH extends RecyclerViewBase.ViewHolder>
{
  public static final int LOCATION_BOTTOM = 3;
  public static final int LOCATION_LEFT = 0;
  public static final int LOCATION_RIGHT = 2;
  public static final int LOCATION_TOP = 1;
  protected boolean mDataChanged = true;
  boolean mHasStableIds = false;
  final RecyclerViewBase.AdapterDataObservable mObservable = new RecyclerViewBase.AdapterDataObservable();
  protected boolean mSuspentionDataChanged = false;
  
  public final void bindViewHolder(VH paramVH, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    paramVH.mPosition = paramInt1;
    if (hasStableIds()) {
      paramVH.mItemId = getItemId(paramInt1);
    }
    if (paramBoolean) {
      onBindViewHolder(paramVH, paramInt1, paramInt2, paramInt3);
    }
    paramVH.setFlags(1, 7);
  }
  
  public int calcPreloadThresholdWithItemNumber()
  {
    return 0;
  }
  
  public final VH createSuspendViewHolderWithPos(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2)
  {
    paramRecyclerViewBase = onCreateSuspendViewHolderWithPos(paramRecyclerViewBase, paramInt1, paramInt2);
    if (paramRecyclerViewBase == null) {
      return null;
    }
    paramRecyclerViewBase.mItemViewType = paramInt2;
    return paramRecyclerViewBase;
  }
  
  public final VH createViewHolder(RecyclerViewBase paramRecyclerViewBase, int paramInt)
  {
    paramRecyclerViewBase = onCreateViewHolder(paramRecyclerViewBase, paramInt);
    if (paramRecyclerViewBase == null) {
      return null;
    }
    paramRecyclerViewBase.mItemViewType = paramInt;
    return paramRecyclerViewBase;
  }
  
  public final VH createViewHolderWithPos(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2)
  {
    paramRecyclerViewBase = onCreateViewHolderWithPos(paramRecyclerViewBase, paramInt1, paramInt2);
    if (paramRecyclerViewBase == null) {
      return null;
    }
    paramRecyclerViewBase.mItemViewType = paramInt2;
    return paramRecyclerViewBase;
  }
  
  public void dataChanged()
  {
    this.mDataChanged = true;
    this.mSuspentionDataChanged = true;
  }
  
  public boolean doDeleteItem()
  {
    return true;
  }
  
  public RecyclerViewBase.ViewHolder findBestHolderForPosition(int paramInt, RecyclerViewBase.Recycler paramRecycler)
  {
    return null;
  }
  
  public int findNextSuspentedPos(int paramInt)
  {
    return -1;
  }
  
  public int findPrevSuspentedPos(int paramInt)
  {
    return -1;
  }
  
  public RecyclerViewBase.ViewHolder findSuspendHolderForPosition(int paramInt, RecyclerViewBase.Recycler paramRecycler)
  {
    return null;
  }
  
  public abstract int[] getBeginPositionWithOffset(int paramInt);
  
  public int getCardItemViewType(int paramInt)
  {
    return 0;
  }
  
  public abstract int getCustomFooterViewHeight();
  
  public abstract int getCustomFooterViewWidth();
  
  public abstract int getCustomHeaderViewHeight();
  
  public abstract int getCustomHeaderViewWidth();
  
  public int getDefaultFooterHeight()
  {
    return 0;
  }
  
  public abstract View getFooterView(int paramInt);
  
  public abstract int getFooterViewCount();
  
  public abstract int getFooterViewHeight(int paramInt);
  
  public abstract boolean getFooterViewInBottomMode();
  
  public abstract View getHeaderView(int paramInt);
  
  public abstract int getHeaderViewCount();
  
  public abstract int getHeaderViewHeight(int paramInt);
  
  public abstract int getHeightBefore(int paramInt);
  
  public abstract int getItemCount();
  
  public long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public abstract int getItemMaigin(int paramInt1, int paramInt2);
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public int getListTotalHeight()
  {
    int m = 1;
    int i = 0;
    int j = 0;
    int n;
    if (getHeaderViewCount() > 0)
    {
      n = getHeaderViewCount();
      k = 1;
      for (;;)
      {
        i = j;
        if (k > n) {
          break;
        }
        i = getHeaderViewHeight(k);
        k += 1;
        j = i + j;
      }
    }
    int k = i;
    if (getFooterViewCount() > 0)
    {
      n = getFooterViewCount();
      j = m;
      for (;;)
      {
        k = i;
        if (j > n) {
          break;
        }
        k = getFooterViewHeight(j);
        j += 1;
        i = k + i;
      }
    }
    return k + getTotalHeight();
  }
  
  public int getPreloadThresholdInItemNumber()
  {
    return 0;
  }
  
  public int getPreloadThresholdInPixels()
  {
    return 0;
  }
  
  public abstract int getTotalHeight();
  
  public String getViewHolderReUseKey(int paramInt)
  {
    return null;
  }
  
  public boolean hasCustomRecycler()
  {
    return false;
  }
  
  public final boolean hasObservers()
  {
    return this.mObservable.hasObservers();
  }
  
  public final boolean hasStableIds()
  {
    return this.mHasStableIds;
  }
  
  public boolean headerMayChange()
  {
    return false;
  }
  
  public boolean isDividerItem(int paramInt)
  {
    return false;
  }
  
  public boolean isSuspentedItem(int paramInt)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    this.mObservable.notifyChanged();
  }
  
  public void notifyEndReached() {}
  
  public void notifyItemChanged(int paramInt)
  {
    this.mObservable.notifyItemRangeChanged(paramInt, 1);
  }
  
  public void notifyItemInserted(int paramInt)
  {
    this.mObservable.notifyItemRangeInserted(paramInt, 1);
  }
  
  public void notifyItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2);
  }
  
  public void notifyItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
  
  public void notifyItemRemoved(int paramInt)
  {
    this.mObservable.notifyItemRangeRemoved(paramInt, 1);
  }
  
  public void notifyItemsRemoved(ArrayList<Integer> paramArrayList)
  {
    this.mObservable.notifyItemsRemoved(paramArrayList);
  }
  
  public void notifyLastFooterAppeared() {}
  
  public boolean notifyOrderChanged(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public abstract void onBindViewHolder(VH paramVH, int paramInt1, int paramInt2, int paramInt3);
  
  public VH onCreateSuspendViewHolderWithPos(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public abstract VH onCreateViewHolder(RecyclerViewBase paramRecyclerViewBase, int paramInt);
  
  public VH onCreateViewHolderWithPos(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public void onItemDeleted(int paramInt) {}
  
  public void onItemsFill(int paramInt) {}
  
  public void onPreload() {}
  
  public void onSuddenStop() {}
  
  protected void onViewAbandon(VH paramVH) {}
  
  protected void onViewAttached() {}
  
  public void onViewAttachedToWindow(VH paramVH) {}
  
  protected void onViewDetached() {}
  
  public void onViewDetachedFromWindow(VH paramVH) {}
  
  protected void onViewRecycled(VH paramVH) {}
  
  public void registerAdapterDataObserver(RecyclerViewBase.AdapterDataObserver paramAdapterDataObserver)
  {
    this.mObservable.registerObserver(paramAdapterDataObserver);
  }
  
  public void reset() {}
  
  public void setHasStableIds(boolean paramBoolean)
  {
    if (hasObservers()) {
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    this.mHasStableIds = paramBoolean;
  }
  
  public void startRefreshData() {}
  
  public void unregisterAdapterDataObserver(RecyclerViewBase.AdapterDataObserver paramAdapterDataObserver)
  {
    this.mObservable.unregisterObserver(paramAdapterDataObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
 * JD-Core Version:    0.7.0.1
 */