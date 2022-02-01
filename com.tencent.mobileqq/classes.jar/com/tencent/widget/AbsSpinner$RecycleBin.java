package com.tencent.widget;

import android.util.SparseArray;
import android.view.View;

class AbsSpinner$RecycleBin
{
  private final SparseArray<View> mScrapHeap = new SparseArray();
  
  AbsSpinner$RecycleBin(AbsSpinner paramAbsSpinner) {}
  
  void clear()
  {
    SparseArray localSparseArray = this.mScrapHeap;
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localSparseArray.valueAt(i);
      if (localView != null) {
        AbsSpinner.access$100(this.this$0, localView, true);
      }
      i += 1;
    }
    localSparseArray.clear();
  }
  
  void clearByTag()
  {
    SparseArray localSparseArray = this.mScrapHeap;
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localSparseArray.valueAt(i);
      boolean bool;
      if ((localView != null) && ((localView.getTag(2131433935) instanceof Boolean))) {
        bool = ((Boolean)localView.getTag(2131433935)).booleanValue();
      } else {
        bool = true;
      }
      if ((localView != null) && (bool)) {
        AbsSpinner.access$200(this.this$0, localView, true);
      }
      i += 1;
    }
    localSparseArray.clear();
  }
  
  View get(int paramInt)
  {
    View localView = (View)this.mScrapHeap.get(paramInt);
    if (localView != null) {
      this.mScrapHeap.delete(paramInt);
    }
    return localView;
  }
  
  public void put(int paramInt, View paramView)
  {
    this.mScrapHeap.put(paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AbsSpinner.RecycleBin
 * JD-Core Version:    0.7.0.1
 */