package com.tencent.widget;

import android.database.DataSetObserver;

class XCursorAdapter$MyDataSetObserver
  extends DataSetObserver
{
  public void onChanged()
  {
    this.a.a = true;
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.a = false;
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.XCursorAdapter.MyDataSetObserver
 * JD-Core Version:    0.7.0.1
 */