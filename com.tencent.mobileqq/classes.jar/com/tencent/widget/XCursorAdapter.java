package com.tencent.widget;

import android.database.Cursor;
import android.widget.Filterable;

public abstract class XCursorAdapter
  extends XBaseAdapter
  implements Filterable, CursorFilter.CursorFilterClient
{
  protected Cursor a;
  protected boolean a;
  protected boolean b;
  
  protected void a()
  {
    if ((this.b) && (this.jdField_a_of_type_AndroidDatabaseCursor != null) && (!this.jdField_a_of_type_AndroidDatabaseCursor.isClosed())) {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidDatabaseCursor.requery();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.XCursorAdapter
 * JD-Core Version:    0.7.0.1
 */