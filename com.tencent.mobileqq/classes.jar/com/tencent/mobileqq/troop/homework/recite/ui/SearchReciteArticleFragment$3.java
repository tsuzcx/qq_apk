package com.tencent.mobileqq.troop.homework.recite.ui;

import android.view.View;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class SearchReciteArticleFragment$3
  implements AdapterView.OnItemClickListener
{
  SearchReciteArticleFragment$3(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.getCount())
    {
      paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchResultListAdapter.a(paramInt);
      this.a.a(paramInt, paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.3
 * JD-Core Version:    0.7.0.1
 */