package com.tencent.widget;

import android.view.View;

public abstract interface SwipPinnedHeaderExpandableListView$SwipListListener
{
  public abstract void hideMenuPop();
  
  public abstract void interceptTouchEvent(boolean paramBoolean);
  
  public abstract boolean supportSwip(View paramView);
  
  public abstract void updateCurShowRightView(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
 * JD-Core Version:    0.7.0.1
 */