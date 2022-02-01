package com.tencent.mobileqq.troop.homework.recite.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SearchReciteArticleFragment$FlowLayoutKeywordsListAdapter$ViewHolder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  protected SearchReciteArticleFragment$FlowLayoutKeywordsListAdapter$ViewHolder(SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter paramFlowLayoutKeywordsListAdapter) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter.a.a(paramView, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */