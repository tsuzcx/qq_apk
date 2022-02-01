package com.tencent.mobileqq.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.PopupWindowWithMask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchWordHistoryEntryModel$2$1
  implements View.OnClickListener
{
  SearchWordHistoryEntryModel$2$1(SearchWordHistoryEntryModel.2 param2, PopupWindowWithMask paramPopupWindowWithMask) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2.1
 * JD-Core Version:    0.7.0.1
 */