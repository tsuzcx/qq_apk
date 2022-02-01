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
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;

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
      paramList1 = new ArrayList();
      paramSuggestUrlItem = new AssociateSearchWordsFragment.AssociateItem();
      paramSuggestUrlItem.jdField_a_of_type_Int = 1;
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramInt = 0;
        if (paramInt < paramList.size())
        {
          String str = ((AssociateSearchWordsFragment.AssociateItem)paramList.get(paramInt)).jdField_a_of_type_JavaLangString;
          AssociateSearchWordsFragment.AssociateItem localAssociateItem = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem.jdField_a_of_type_JavaLangString = str;
          if ((this.a.jdField_c_of_type_Int == 25) || (this.a.jdField_c_of_type_Int == 26))
          {
            localAssociateItem.jdField_a_of_type_Int = 6;
            label160:
            localAssociateItem.d = (paramInt + 1);
            paramList1.add(localAssociateItem);
            if (paramInt == paramList.size() - 1) {
              break label300;
            }
            if ((this.a.jdField_c_of_type_Int != 25) && (this.a.jdField_c_of_type_Int != 26)) {
              break label287;
            }
            boolean bool1 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
            boolean bool2 = ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null);
            if ((bool1) || (bool2)) {
              paramList1.add(paramSuggestUrlItem);
            }
            label258:
            localStringBuilder.append(str).append("::");
          }
          for (;;)
          {
            paramInt += 1;
            break;
            localAssociateItem.jdField_a_of_type_Int = 3;
            break label160;
            label287:
            paramList1.add(paramSuggestUrlItem);
            break label258;
            label300:
            localStringBuilder.append(str);
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramList1);
      UniteSearchActivity.e = this.a.getCurrentAccountUin() + System.currentTimeMillis();
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.a.a()).ver2(UniteSearchReportController.a(this.a.jdField_c_of_type_Int)).ver3(UniteSearchActivity.jdField_d_of_type_JavaLangString).ver6(UniteSearchActivity.jdField_c_of_type_JavaLangString).ver7("{experiment_id:" + UniteSearchReportController.b + "}").session_id(UniteSearchActivity.e).ver4(localStringBuilder.toString()));
    }
  }
  
  public void handleAssociateResultError(String paramString1, Integer paramInteger, String paramString2) {}
  
  public void handleSearchDiscoveryError(int paramInt1, String paramString, int paramInt2) {}
  
  public void handleSearchDiscoveryResult(List<SearchEntryDataModel> paramList, int paramInt)
  {
    if (paramInt != this.a.c()) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refreshDataModels(paramList, false);
  }
  
  public void handleUniteSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2)) {}
    while (!this.a.f.equals(paramString1)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramInt, paramString3);
    this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void handleUniteSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<GroupTabModel> paramList, List<ISearchResultGroupModel> paramList1, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2);
        if (!bool) {
          return;
        }
        if ((this.a.f == null) || (!this.a.f.equals(paramString1))) {
          continue;
        }
        if (!paramBoolean1)
        {
          this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
          paramString2 = SearchUtil.a(paramList1, paramBoolean1);
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
          continue;
        }
        if (paramList != null) {
          break label127;
        }
      }
      finally {}
      handleUniteSearchError(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
      continue;
      label127:
      if ((paramList.size() > 0) && ((((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131715744))) || ((((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaUtilList != null) && (((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaUtilList.size() == 0)))) {
        paramList.remove(0);
      }
      this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
      paramString2 = SearchUtil.a(paramList1, paramBoolean1);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
      UniteSearchActivity.jdField_d_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.1
 * JD-Core Version:    0.7.0.1
 */