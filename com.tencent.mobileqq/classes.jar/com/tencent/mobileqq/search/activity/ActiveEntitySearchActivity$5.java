package com.tencent.mobileqq.search.activity;

import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.search.DynamicAssociationWord.SuggestUrlItem;

class ActiveEntitySearchActivity$5
  extends UniteSearchObserver
{
  ActiveEntitySearchActivity$5(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void handleAssociateResult(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<DynamicAssociationWord.SuggestUrlItem> paramList1, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (QLog.isColorLevel())
    {
      paramSuggestUrlItem = new StringBuilder();
      paramSuggestUrlItem.append("handleSuggestUrlResult keyword=");
      paramSuggestUrlItem.append(paramString);
      paramSuggestUrlItem.append(" activity keyword=");
      paramSuggestUrlItem.append(this.a.jdField_a_of_type_JavaLangString);
      paramSuggestUrlItem.append(" size=");
      paramSuggestUrlItem.append(paramList1.size());
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, paramSuggestUrlItem.toString());
    }
    if (paramString.equals(this.a.jdField_a_of_type_JavaLangString))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
      }
      paramList1 = new ArrayList();
      paramSuggestUrlItem = new AssociateSearchWordsFragment.AssociateItem();
      paramSuggestUrlItem.jdField_a_of_type_Int = 1;
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i;
        for (paramInt = 0; paramInt < paramList.size(); paramInt = i)
        {
          String str = ((AssociateSearchWordsFragment.AssociateItem)paramList.get(paramInt)).jdField_a_of_type_JavaLangString;
          AssociateSearchWordsFragment.AssociateItem localAssociateItem = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem.jdField_a_of_type_JavaLangString = str;
          localAssociateItem.jdField_a_of_type_Int = 3;
          i = paramInt + 1;
          localAssociateItem.d = i;
          paramList1.add(localAssociateItem);
          if (paramInt != paramList.size() - 1)
          {
            paramList1.add(paramSuggestUrlItem);
            localStringBuilder.append(str);
            localStringBuilder.append("::");
          }
          else
          {
            localStringBuilder.append(str);
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramList1);
      paramString = new ReportModelDC02528().module("subweb_search").action("exp_thinkword_list").obj1(SearchUtils.a(this.a.jdField_a_of_type_ArrayOfLong)).ver1(this.a.a()).ver4(localStringBuilder.toString());
      paramList = new StringBuilder();
      paramList.append("{experiment_id:");
      paramList.append(UniteSearchReportController.b);
      paramList.append("}");
      UniteSearchReportController.a(null, paramString.ver7(paramList.toString()));
    }
  }
  
  public void handleAssociateResultError(String paramString1, Integer paramInteger, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAssociateResultError keyword=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("  resultCode=");
      localStringBuilder.append(paramInteger);
      localStringBuilder.append("  errorMsg=");
      localStringBuilder.append(paramString2);
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity.5
 * JD-Core Version:    0.7.0.1
 */