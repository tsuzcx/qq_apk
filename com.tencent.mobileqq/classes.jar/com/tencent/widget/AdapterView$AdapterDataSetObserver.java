package com.tencent.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

public class AdapterView$AdapterDataSetObserver
  extends DataSetObserver
{
  private Parcelable mInstanceState = null;
  
  public AdapterView$AdapterDataSetObserver(AdapterView paramAdapterView) {}
  
  public void clearSavedState()
  {
    this.mInstanceState = null;
  }
  
  public void onChanged()
  {
    this.this$0.mDataChanged = true;
    this.this$0.mOldItemCount = this.this$0.mItemCount;
    this.this$0.mItemCount = this.this$0.getAdapter().getCount();
    if ((this.this$0.getAdapter().hasStableIds()) && (this.mInstanceState != null) && (this.this$0.mOldItemCount == 0) && (this.this$0.mItemCount > 0))
    {
      AdapterView.access$000(this.this$0, this.mInstanceState);
      this.mInstanceState = null;
    }
    for (;;)
    {
      this.this$0.checkFocus();
      this.this$0.requestLayout();
      return;
      this.this$0.rememberSyncState();
    }
  }
  
  public void onInvalidated()
  {
    this.this$0.mDataChanged = true;
    if (this.this$0.getAdapter().hasStableIds()) {
      this.mInstanceState = AdapterView.access$100(this.this$0);
    }
    this.this$0.mOldItemCount = this.this$0.mItemCount;
    this.this$0.mItemCount = 0;
    this.this$0.mSelectedPosition = -1;
    this.this$0.mSelectedRowId = -9223372036854775808L;
    this.this$0.mNextSelectedPosition = -1;
    this.this$0.mNextSelectedRowId = -9223372036854775808L;
    this.this$0.mNeedSync = false;
    this.this$0.checkFocus();
    this.this$0.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterView.AdapterDataSetObserver
 * JD-Core Version:    0.7.0.1
 */