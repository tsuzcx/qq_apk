package com.tencent.widget;

import android.database.DataSetObserver;

class XCursorAdapter$MyDataSetObserver
  extends DataSetObserver
{
  private XCursorAdapter$MyDataSetObserver(XCursorAdapter paramXCursorAdapter) {}
  
  public void onChanged()
  {
    XCursorAdapter localXCursorAdapter = this.this$0;
    localXCursorAdapter.mDataValid = true;
    localXCursorAdapter.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    XCursorAdapter localXCursorAdapter = this.this$0;
    localXCursorAdapter.mDataValid = false;
    localXCursorAdapter.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XCursorAdapter.MyDataSetObserver
 * JD-Core Version:    0.7.0.1
 */