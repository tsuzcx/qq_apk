package com.tencent.widget;

import android.view.View;
import android.widget.BaseExpandableListAdapter;

public abstract class PinnedHeaderExpandableListView$ExpandableListAdapter
  extends BaseExpandableListAdapter
{
  public abstract void configHeaderView(View paramView, int paramInt);
  
  public abstract int getHeaderViewLayoutResourceId();
  
  public boolean needHideBackgroundGroup()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */