package com.tencent.mobileqq.search.activity;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.model.GroupTabModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.search.DynamicAssociationWord.SuggestUrlItem;

class UniteSearchActivity$1
  extends UniteSearchObserver
{
  UniteSearchActivity$1(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void handleAssociateResult(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<DynamicAssociationWord.SuggestUrlItem> paramList1, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (paramString.equals(this.a.f))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
      }
      paramSuggestUrlItem = new ArrayList();
      AssociateSearchWordsFragment.AssociateItem localAssociateItem1 = new AssociateSearchWordsFragment.AssociateItem();
      localAssociateItem1.jdField_a_of_type_Int = 1;
      paramList1 = new StringBuilder("");
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i;
        for (paramInt = 0; paramInt < paramList.size(); paramInt = i)
        {
          String str = ((AssociateSearchWordsFragment.AssociateItem)paramList.get(paramInt)).jdField_a_of_type_JavaLangString;
          AssociateSearchWordsFragment.AssociateItem localAssociateItem2 = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem2.jdField_a_of_type_JavaLangString = str;
          if ((this.a.jdField_c_of_type_Int != 25) && (this.a.jdField_c_of_type_Int != 26)) {
            localAssociateItem2.jdField_a_of_type_Int = 3;
          } else {
            localAssociateItem2.jdField_a_of_type_Int = 6;
          }
          i = paramInt + 1;
          localAssociateItem2.d = i;
          paramSuggestUrlItem.add(localAssociateItem2);
          if (paramInt != paramList.size() - 1)
          {
            if ((this.a.jdField_c_of_type_Int != 25) && (this.a.jdField_c_of_type_Int != 26))
            {
              paramSuggestUrlItem.add(localAssociateItem1);
            }
            else
            {
              boolean bool1 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
              boolean bool2 = ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null);
              if ((bool1) || (bool2)) {
                paramSuggestUrlItem.add(localAssociateItem1);
              }
            }
            paramList1.append(str);
            paramList1.append("::");
          }
          else
          {
            paramList1.append(str);
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramSuggestUrlItem);
      paramString = new StringBuilder();
      paramString.append(this.a.getCurrentAccountUin());
      paramString.append(System.currentTimeMillis());
      UniteSearchActivity.e = paramString.toString();
      paramString = new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.a.a()).ver2(UniteSearchReportController.a(this.a.jdField_c_of_type_Int)).ver3(UniteSearchActivity.jdField_d_of_type_JavaLangString).ver6(UniteSearchActivity.jdField_c_of_type_JavaLangString);
      paramList = new StringBuilder();
      paramList.append("{experiment_id:");
      paramList.append(UniteSearchReportController.b);
      paramList.append("}");
      UniteSearchReportController.a(null, paramString.ver7(paramList.toString()).session_id(UniteSearchActivity.e).ver4(paramList1.toString()));
    }
  }
  
  public void handleAssociateResultError(String paramString1, Integer paramInteger, String paramString2) {}
  
  public void handleSearchDiscoveryError(int paramInt1, String paramString, int paramInt2) {}
  
  public void handleSearchDiscoveryResult(List<SearchEntryDataModel> paramList, int paramInt)
  {
    if (paramInt != this.a.c()) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refreshDataModels(paramList, false);
    }
  }
  
  public void handleUniteSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2)) {
      return;
    }
    if (!this.a.f.equals(paramString1)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramInt, paramString3);
    this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void handleUniteSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<GroupTabModel> paramList, List<ISearchResultGroupModel> paramList1, int paramInt)
  {
    try
    {
      boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2);
      if (!bool) {
        return;
      }
      if ((this.a.f != null) && (this.a.f.equals(paramString1)))
      {
        if (!paramBoolean1)
        {
          this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
          paramString2 = SearchUtil.a(paramList1, paramBoolean1);
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
          return;
        }
        if (paramList == null)
        {
          handleUniteSearchError(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
          return;
        }
        if ((paramList.size() > 0) && ((((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131715668))) || ((((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaUtilList != null) && (((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaUtilList.size() == 0)))) {
          paramList.remove(0);
        }
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
        paramString2 = SearchUtil.a(paramList1, paramBoolean1);
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
        UniteSearchActivity.jdField_d_of_type_Boolean = true;
        return;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.1
 * JD-Core Version:    0.7.0.1
 */