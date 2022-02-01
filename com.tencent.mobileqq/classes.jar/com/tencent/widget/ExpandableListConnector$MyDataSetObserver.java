package com.tencent.widget;

import android.database.DataSetObserver;

public class ExpandableListConnector$MyDataSetObserver
  extends DataSetObserver
{
  protected ExpandableListConnector$MyDataSetObserver(ExpandableListConnector paramExpandableListConnector) {}
  
  public void onChanged()
  {
    ExpandableListConnector.access$000(this.this$0, true, true);
    this.this$0.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    ExpandableListConnector.access$000(this.this$0, true, true);
    this.this$0.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector.MyDataSetObserver
 * JD-Core Version:    0.7.0.1
 */