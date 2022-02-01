package com.tencent.widget;

import android.database.DataSetObserver;
import android.widget.BaseAdapter;

public abstract class XBaseAdapter
  extends BaseAdapter
  implements XListAdapter
{
  private final XBaseAdapter.ListDataSetObservable mDataSetObservable = new XBaseAdapter.ListDataSetObservable(this);
  
  public void notifyDataSetChanged()
  {
    this.mDataSetObservable.notifyChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.mDataSetObservable.notifyInvalidated();
  }
  
  public void notifyRowDeleted(int paramInt1, int paramInt2)
  {
    this.mDataSetObservable.notifyRowDeleted(paramInt1, paramInt2);
  }
  
  public void notifyRowInserted(int paramInt1, int paramInt2)
  {
    this.mDataSetObservable.notifyRowInserted(paramInt1, paramInt2);
  }
  
  public void notifyRowUpdated(int paramInt1, int paramInt2)
  {
    this.mDataSetObservable.notifyRowUpdated(paramInt1, paramInt2);
  }
  
  public void notifyRowsDeleted(int... paramVarArgs)
  {
    this.mDataSetObservable.notifyRowDeleted(paramVarArgs);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.registerObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.XBaseAdapter
 * JD-Core Version:    0.7.0.1
 */