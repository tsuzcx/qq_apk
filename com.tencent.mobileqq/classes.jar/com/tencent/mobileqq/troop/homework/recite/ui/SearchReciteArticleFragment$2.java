package com.tencent.mobileqq.troop.homework.recite.ui;

import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.util.TroopReportor;

class SearchReciteArticleFragment$2
  implements SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter.OnItemClickListener
{
  SearchReciteArticleFragment$2(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter.a(paramInt);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramView);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramView.length());
    TroopReportor.a("Grp_edu", "Grp_recite", "Recommend_Clk", 0, 0, new String[] { this.a.jdField_a_of_type_JavaLangString, paramView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.2
 * JD-Core Version:    0.7.0.1
 */