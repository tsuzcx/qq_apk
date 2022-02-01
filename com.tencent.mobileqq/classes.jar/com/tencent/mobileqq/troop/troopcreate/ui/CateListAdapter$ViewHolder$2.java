package com.tencent.mobileqq.troop.troopcreate.ui;

import android.widget.ListView;

class CateListAdapter$ViewHolder$2
  implements SubCateListView.OnToggleSubListListener
{
  CateListAdapter$ViewHolder$2(CateListAdapter.ViewHolder paramViewHolder) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt > 0)) {
      this.a.a.e.c.smoothScrollBy(paramInt, 200);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.CateListAdapter.ViewHolder.2
 * JD-Core Version:    0.7.0.1
 */