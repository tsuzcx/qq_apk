package com.tencent.mobileqq.search.activity;

import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unify.search.UnifySearchAssociationWord.SuggestUrlItem;

class ActiveEntitySearchActivity$6
  extends UnifySearchObserver
{
  ActiveEntitySearchActivity$6(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void a(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<UnifySearchAssociationWord.SuggestUrlItem> paramList1, UnifySearchAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (QLog.isColorLevel())
    {
      paramSuggestUrlItem = new StringBuilder();
      paramSuggestUrlItem.append("handleSuggestUrlResult keyword=");
      paramSuggestUrlItem.append(paramString);
      paramSuggestUrlItem.append(" activity keyword=");
      paramSuggestUrlItem.append(this.a.o);
      paramSuggestUrlItem.append(" size=");
      paramSuggestUrlItem.append(paramList1.size());
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, paramSuggestUrlItem.toString());
    }
    if (paramString.equals(this.a.o))
    {
      if (this.a.h == null) {
        this.a.h = new AssociateSearchWordsFragment();
      }
      paramList1 = new ArrayList();
      paramSuggestUrlItem = new AssociateSearchWordsFragment.AssociateItem();
      paramSuggestUrlItem.a = 1;
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i;
        for (paramInt = 0; paramInt < paramList.size(); paramInt = i)
        {
          String str = ((AssociateSearchWordsFragment.AssociateItem)paramList.get(paramInt)).b;
          AssociateSearchWordsFragment.AssociateItem localAssociateItem = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem.b = str;
          localAssociateItem.a = 3;
          i = paramInt + 1;
          localAssociateItem.i = i;
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
      this.a.h.a(true);
      this.a.h.a(paramString);
      this.a.h.a(paramList1);
      paramString = new ReportModelDC02528().module("subweb_search").action("exp_thinkword_list").obj1(SearchUtils.a(this.a.n)).ver1(this.a.h()).ver4(localStringBuilder.toString());
      paramList = new StringBuilder();
      paramList.append("{experiment_id:");
      paramList.append(UniteSearchReportController.b);
      paramList.append("}");
      UniteSearchReportController.a(null, paramString.ver7(paramList.toString()));
    }
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity.6
 * JD-Core Version:    0.7.0.1
 */