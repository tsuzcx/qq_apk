package com.tencent.widget;

import android.database.ContentObserver;
import android.os.Handler;

class XCursorAdapter$ChangeObserver
  extends ContentObserver
{
  public XCursorAdapter$ChangeObserver(XCursorAdapter paramXCursorAdapter)
  {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    this.this$0.onContentChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.XCursorAdapter.ChangeObserver
 * JD-Core Version:    0.7.0.1
 */