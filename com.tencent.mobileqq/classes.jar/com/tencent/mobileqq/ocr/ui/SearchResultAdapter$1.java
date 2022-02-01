package com.tencent.mobileqq.ocr.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchResultAdapter$1
  implements View.OnClickListener
{
  SearchResultAdapter$1(SearchResultAdapter paramSearchResultAdapter) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.c != null) && ((paramView.getTag() instanceof SearchResultAdapter.ListItem)))
    {
      SearchResultAdapter.ListItem localListItem = (SearchResultAdapter.ListItem)paramView.getTag();
      this.a.c.a(localListItem);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */