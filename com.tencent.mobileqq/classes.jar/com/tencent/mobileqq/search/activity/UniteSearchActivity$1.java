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
    if (paramString.equals(this.a.p))
    {
      if (this.a.z == null) {
        this.a.z = new AssociateSearchWordsFragment();
      }
      paramSuggestUrlItem = new ArrayList();
      AssociateSearchWordsFragment.AssociateItem localAssociateItem1 = new AssociateSearchWordsFragment.AssociateItem();
      localAssociateItem1.a = 1;
      paramList1 = new StringBuilder("");
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i;
        for (paramInt = 0; paramInt < paramList.size(); paramInt = i)
        {
          String str = ((AssociateSearchWordsFragment.AssociateItem)paramList.get(paramInt)).b;
          AssociateSearchWordsFragment.AssociateItem localAssociateItem2 = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem2.b = str;
          if ((this.a.e != 25) && (this.a.e != 26)) {
            localAssociateItem2.a = 3;
          } else {
            localAssociateItem2.a = 6;
          }
          i = paramInt + 1;
          localAssociateItem2.i = i;
          paramSuggestUrlItem.add(localAssociateItem2);
          if (paramInt != paramList.size() - 1)
          {
            if ((this.a.e != 25) && (this.a.e != 26))
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
      this.a.z.a(true);
      this.a.z.a(paramString);
      this.a.z.a(paramSuggestUrlItem);
      paramString = new StringBuilder();
      paramString.append(this.a.getCurrentAccountUin());
      paramString.append(System.currentTimeMillis());
      UniteSearchActivity.k = paramString.toString();
      paramString = new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.a.h()).ver2(UniteSearchReportController.a(this.a.e)).ver3(UniteSearchActivity.j).ver6(UniteSearchActivity.i);
      paramList = new StringBuilder();
      paramList.append("{experiment_id:");
      paramList.append(UniteSearchReportController.b);
      paramList.append("}");
      UniteSearchReportController.a(null, paramString.ver7(paramList.toString()).session_id(UniteSearchActivity.k).ver4(paramList1.toString()));
    }
  }
  
  public void handleAssociateResultError(String paramString1, Integer paramInteger, String paramString2) {}
  
  public void handleSearchDiscoveryError(int paramInt1, String paramString, int paramInt2) {}
  
  public void handleSearchDiscoveryResult(List<SearchEntryDataModel> paramList, int paramInt)
  {
    if (paramInt != this.a.s()) {
      return;
    }
    if (this.a.y != null) {
      this.a.y.refreshDataModels(paramList, false);
    }
  }
  
  public void handleUniteSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (!this.a.x.h.equals(paramString2)) {
      return;
    }
    if (!this.a.p.equals(paramString1)) {
      return;
    }
    this.a.x.a(paramString1, paramInt, paramString3);
    this.a.Q.setVisibility(0);
  }
  
  public void handleUniteSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<GroupTabModel> paramList, List<ISearchResultGroupModel> paramList1, int paramInt)
  {
    try
    {
      boolean bool = this.a.x.h.equals(paramString2);
      if (!bool) {
        return;
      }
      if ((this.a.p != null) && (this.a.p.equals(paramString1)))
      {
        if (!paramBoolean1)
        {
          this.a.A = paramArrayOfByte;
          this.a.x.a(paramArrayOfByte);
          paramString2 = SearchUtil.a(paramList1, paramBoolean1);
          this.a.x.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
          return;
        }
        if (paramList == null)
        {
          handleUniteSearchError(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
          return;
        }
        if ((paramList.size() > 0) && ((((GroupTabModel)paramList.get(0)).a.equals(HardCodeUtil.a(2131913136))) || ((((GroupTabModel)paramList.get(0)).b != null) && (((GroupTabModel)paramList.get(0)).b.size() == 0)))) {
          paramList.remove(0);
        }
        this.a.Q.setVisibility(0);
        this.a.A = paramArrayOfByte;
        this.a.x.a(paramArrayOfByte);
        paramString2 = SearchUtil.a(paramList1, paramBoolean1);
        this.a.x.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
        UniteSearchActivity.I = true;
        return;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.1
 * JD-Core Version:    0.7.0.1
 */