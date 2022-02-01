package com.tencent.mtt.supportui.views.recyclerview;

import android.database.Observable;
import java.util.ArrayList;

class RecyclerViewBase$AdapterDataObservable
  extends Observable<RecyclerViewBase.AdapterDataObserver>
{
  public boolean hasObservers()
  {
    return this.mObservers.isEmpty() ^ true;
  }
  
  public void notifyChanged()
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerViewBase.AdapterDataObserver)this.mObservers.get(i)).onChanged();
      i -= 1;
    }
  }
  
  public void notifyItemRangeChanged(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerViewBase.AdapterDataObserver)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public void notifyItemRangeInserted(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerViewBase.AdapterDataObserver)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerViewBase.AdapterDataObserver)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public void notifyItemsRemoved(ArrayList<Integer> paramArrayList)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerViewBase.AdapterDataObserver)this.mObservers.get(i)).onItemsRemoved(paramArrayList);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AdapterDataObservable
 * JD-Core Version:    0.7.0.1
 */