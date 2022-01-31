package com.tencent.widget;

import android.database.DataSetObserver;

public class ExpandableListConnector$MyDataSetObserver
  extends DataSetObserver
{
  protected ExpandableListConnector$MyDataSetObserver(ExpandableListConnector paramExpandableListConnector) {}
  
  public void onChanged()
  {
    ExpandableListConnector.a(this.a, true, true);
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    ExpandableListConnector.a(this.a, true, true);
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector.MyDataSetObserver
 * JD-Core Version:    0.7.0.1
 */