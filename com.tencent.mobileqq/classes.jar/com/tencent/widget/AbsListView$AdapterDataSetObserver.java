package com.tencent.widget;

import android.widget.ListAdapter;

class AbsListView$AdapterDataSetObserver
  extends AdapterView<ListAdapter>.AdapterDataSetObserver
{
  AbsListView$AdapterDataSetObserver(AbsListView paramAbsListView)
  {
    super(paramAbsListView);
  }
  
  public void onChanged()
  {
    super.onChanged();
    if (this.this$0.mFastScroller != null) {
      this.this$0.mFastScroller.onSectionsChanged();
    }
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    if (this.this$0.mFastScroller != null) {
      this.this$0.mFastScroller.onSectionsChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.AdapterDataSetObserver
 * JD-Core Version:    0.7.0.1
 */