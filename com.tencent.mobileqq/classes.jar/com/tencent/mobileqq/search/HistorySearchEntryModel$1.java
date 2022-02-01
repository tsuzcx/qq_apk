package com.tencent.mobileqq.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView.OnItemClickListener;

class HistorySearchEntryModel$1
  implements View.OnClickListener
{
  HistorySearchEntryModel$1(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    HistorySearchEntryModel.a(this.a).onItemClick(this.a.a, paramView, i, 0L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.1
 * JD-Core Version:    0.7.0.1
 */