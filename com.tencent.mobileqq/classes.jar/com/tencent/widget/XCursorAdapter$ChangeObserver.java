package com.tencent.widget;

import android.database.ContentObserver;

class XCursorAdapter$ChangeObserver
  extends ContentObserver
{
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.XCursorAdapter.ChangeObserver
 * JD-Core Version:    0.7.0.1
 */