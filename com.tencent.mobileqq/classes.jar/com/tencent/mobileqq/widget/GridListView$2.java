package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView.OnItemClickListener;

class GridListView$2
  implements View.OnClickListener
{
  GridListView$2(GridListView paramGridListView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131427368)).intValue();
    this.a.e.onItemClick(this.a, paramView, i, 0L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView.2
 * JD-Core Version:    0.7.0.1
 */