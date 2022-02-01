package com.tencent.mobileqq.search.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssociateSearchWordsFragment$SearchAssociatedWordAdapter$1
  implements View.OnClickListener
{
  AssociateSearchWordsFragment$SearchAssociatedWordAdapter$1(AssociateSearchWordsFragment.SearchAssociatedWordAdapter paramSearchAssociatedWordAdapter, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment$SearchAssociatedWordAdapter.a.getBaseActivity();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment$SearchAssociatedWordAdapter.a.getBaseActivity() instanceof AssociateSearchWordsFragment.AssociateWordClickCallback;
    AssociateSearchWordsFragment.AssociateWordClickCallback localAssociateWordClickCallback = null;
    if (bool)
    {
      localAssociateWordClickCallback = (AssociateSearchWordsFragment.AssociateWordClickCallback)localObject;
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new ReportModelDC02528().module("all_search").action("clk_frame_up").ver1(this.jdField_a_of_type_JavaLangString).ver2("kandian").ver3(UniteSearchActivity.d).ver4(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment$SearchAssociatedWordAdapter.a.jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int / 2 + 1);
      localStringBuilder.append("");
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject).ver5(localStringBuilder.toString()).ver6(UniteSearchActivity.c).session_id(UniteSearchActivity.e));
    }
    else if (AssociateSearchWordsFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment$SearchAssociatedWordAdapter.a) != null)
    {
      localAssociateWordClickCallback = AssociateSearchWordsFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment$SearchAssociatedWordAdapter.a);
    }
    if (localAssociateWordClickCallback != null) {
      localAssociateWordClickCallback.c(this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.SearchAssociatedWordAdapter.1
 * JD-Core Version:    0.7.0.1
 */