package com.tencent.widget;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class ExpandableListView$ExpandableListContextMenuInfo
  implements ContextMenu.ContextMenuInfo
{
  public long id;
  public long packedPosition;
  public View targetView;
  
  public ExpandableListView$ExpandableListContextMenuInfo(View paramView, long paramLong1, long paramLong2)
  {
    this.targetView = paramView;
    this.packedPosition = paramLong1;
    this.id = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ExpandableListView.ExpandableListContextMenuInfo
 * JD-Core Version:    0.7.0.1
 */