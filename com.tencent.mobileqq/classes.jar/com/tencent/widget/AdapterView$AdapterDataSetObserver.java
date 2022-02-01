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
    AdapterView localAdapterView = this.this$0;
    localAdapterView.mDataChanged = true;
    localAdapterView.mOldItemCount = localAdapterView.mItemCount;
    localAdapterView = this.this$0;
    localAdapterView.mItemCount = localAdapterView.getAdapter().getCount();
    if ((this.this$0.getAdapter().hasStableIds()) && (this.mInstanceState != null) && (this.this$0.mOldItemCount == 0) && (this.this$0.mItemCount > 0))
    {
      AdapterView.access$000(this.this$0, this.mInstanceState);
      this.mInstanceState = null;
    }
    else
    {
      this.this$0.rememberSyncState();
    }
    this.this$0.checkFocus();
    this.this$0.requestLayout();
  }
  
  public void onInvalidated()
  {
    AdapterView localAdapterView = this.this$0;
    localAdapterView.mDataChanged = true;
    if (localAdapterView.getAdapter().hasStableIds()) {
      this.mInstanceState = AdapterView.access$100(this.this$0);
    }
    localAdapterView = this.this$0;
    localAdapterView.mOldItemCount = localAdapterView.mItemCount;
    localAdapterView = this.this$0;
    localAdapterView.mItemCount = 0;
    localAdapterView.mSelectedPosition = -1;
    localAdapterView.mSelectedRowId = -9223372036854775808L;
    localAdapterView.mNextSelectedPosition = -1;
    localAdapterView.mNextSelectedRowId = -9223372036854775808L;
    localAdapterView.mNeedSync = false;
    localAdapterView.checkFocus();
    this.this$0.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AdapterView.AdapterDataSetObserver
 * JD-Core Version:    0.7.0.1
 */