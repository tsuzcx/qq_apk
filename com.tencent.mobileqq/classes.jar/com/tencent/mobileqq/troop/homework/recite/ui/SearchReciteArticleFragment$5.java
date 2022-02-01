package com.tencent.mobileqq.troop.homework.recite.ui;

import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SearchReciteArticleFragment$5
  implements ActionSheet.OnButtonClickListener
{
  SearchReciteArticleFragment$5(SearchReciteArticleFragment paramSearchReciteArticleFragment, ActionSheet paramActionSheet, SearchReciteArticleFragment.SearchArticle paramSearchArticle, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchArticle.jdField_a_of_type_Int == 2) {
      i = paramInt + 1;
    }
    switch (i)
    {
    default: 
      return;
    case 0: 
      SelectReciteParagraphFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchArticle.c, SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment));
      TroopReportor.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, "0", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchArticle.jdField_a_of_type_Int) });
      return;
    }
    TroopReportor.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, "1", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchArticle.jdField_a_of_type_Int) });
    TroopReportor.a("Grp_edu", "Grp_recite", "Clk_Success", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchArticle.jdField_a_of_type_Int) });
    try
    {
      SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment, HWReciteInfo.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchArticle.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchArticle.c, null));
      SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.5
 * JD-Core Version:    0.7.0.1
 */