package com.tencent.mobileqq.search.activity;

import android.view.View;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.RichSearchModelNode;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.model.GroupSearchModelRichNode;
import com.tencent.mobileqq.search.model.GroupTabModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.rich.RichMetaData;
import com.tencent.mobileqq.search.rich.RichNodeFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pb.unify.search.UnifySearchAssociationWord.SuggestUrlItem;

class UniteSearchActivity$2
  extends UnifySearchObserver
{
  UniteSearchActivity$2(UniteSearchActivity paramUniteSearchActivity) {}
  
  private void a(RichSearchModelNode paramRichSearchModelNode)
  {
    if (paramRichSearchModelNode == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("patchRichExtraData, source:");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" from:");
      ((StringBuilder)localObject).append(this.a.jdField_c_of_type_Int);
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, ((StringBuilder)localObject).toString());
    }
    int j = this.a.jdField_a_of_type_Int;
    int i = j;
    if (this.a.jdField_a_of_type_Int == 0)
    {
      i = this.a.jdField_c_of_type_Int;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 21) {
            i = j;
          } else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(this.a.app, false, null);
    Object localObject = RichMetaData.a(i, paramRichSearchModelNode.c(), paramRichSearchModelNode.g, bool);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("patchRichExtraData, extraData:");
      localStringBuilder.append((String)localObject);
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, localStringBuilder.toString());
    }
    paramRichSearchModelNode.b((String)localObject);
  }
  
  private void a(List<ISearchResultGroupModel> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        paramList = (ISearchResultGroupModel)localIterator1.next();
        if ((paramList != null) && (paramList.a() != null) && (paramList.a().equals(VSConfigManager.c)))
        {
          paramList = paramList.a();
          if (paramList != null)
          {
            Iterator localIterator2 = paramList.iterator();
            while (localIterator2.hasNext())
            {
              paramList = (ISearchResultModel)localIterator2.next();
              if ((paramList != null) && ((paramList instanceof NetSearchTemplateBaseItem)))
              {
                paramList = (NetSearchTemplateBaseItem)paramList;
                QQAppInterface localQQAppInterface = this.a.app;
                if (paramList.a() != null) {
                  paramList = paramList.a();
                } else {
                  paramList = "";
                }
                ReportController.b(localQQAppInterface, "dc00898", "", paramList, "auth_search", "exp", 0, 0, "", "", "", "");
              }
            }
          }
        }
      }
    }
  }
  
  private void b(RichSearchModelNode paramRichSearchModelNode)
  {
    if (paramRichSearchModelNode == null) {
      return;
    }
    int i = paramRichSearchModelNode.g();
    if (paramRichSearchModelNode.c())
    {
      UniteSearchReportController.a(this.a.app, this.a.jdField_a_of_type_Int, this.a.jdField_c_of_type_Int, "0X8009D2C", i, 0, paramRichSearchModelNode.g);
      return;
    }
    UniteSearchReportController.a(this.a.app, this.a.jdField_a_of_type_Int, this.a.jdField_c_of_type_Int, "0X8009D40", i, 0, paramRichSearchModelNode.g);
  }
  
  private void b(List<ISearchResultGroupModel> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (ISearchResultGroupModel)paramList.next();
      if ((((ISearchResultGroupModel)localObject1).a() != null) && (((ISearchResultGroupModel)localObject1).a().size() != 0))
      {
        Object localObject2 = ((ISearchResultGroupModel)localObject1).a().iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ISearchResultModel)((Iterator)localObject2).next();
          if ((localObject3 instanceof ISearchResultPositionModel)) {
            ((ISearchResultPositionModel)localObject3).c(this.a.jdField_a_of_type_Int);
          }
        }
        if ((localObject1 instanceof GroupSearchModelRichNode))
        {
          localObject1 = ((ISearchResultGroupModel)localObject1).a().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ISearchResultModel)((Iterator)localObject1).next();
            if ((localObject2 instanceof RichSearchModelNode))
            {
              localObject2 = (RichSearchModelNode)localObject2;
              int i = ((RichSearchModelNode)localObject2).f();
              if (!RichNodeFactory.a().a(i))
              {
                ((Iterator)localObject1).remove();
                if (QLog.isColorLevel())
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("handleUniteSearchResult, remove rich node:");
                  ((StringBuilder)localObject3).append(i);
                  QLog.d("Q.uniteSearch.UniteSearchActivity", 2, ((StringBuilder)localObject3).toString());
                }
              }
              a((RichSearchModelNode)localObject2);
              b((RichSearchModelNode)localObject2);
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2) {}
  
  public void a(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<UnifySearchAssociationWord.SuggestUrlItem> paramList1, UnifySearchAssociationWord.SuggestUrlItem paramSuggestUrlItem)
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
      paramString = new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.a.a()).ver2(UniteSearchReportController.a(this.a.jdField_c_of_type_Int)).ver4(localStringBuilder.toString());
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
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2)) {
      return;
    }
    if (!this.a.f.equals(paramString1)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramInt, paramString3);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("handleUniteSearchError resultCode=");
      paramString2.append(paramInt);
      paramString2.append(" key=");
      paramString2.append(paramString1);
      QLog.i("Q.uniteSearch.UniteSearchActivity", 2, paramString2.toString());
    }
    this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<GroupTabModel> paramList, List<ISearchResultGroupModel> paramList1, int paramInt)
  {
    try
    {
      boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2);
      if (!bool) {
        return;
      }
      if ((this.a.f != null) && (this.a.f.equals(paramString1)))
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleUniteSearchResult, keyword = ");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(", isFirstReq = ");
          localStringBuilder.append(paramBoolean1);
          localStringBuilder.append(", reqTime = ");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(", cookie = ");
          localStringBuilder.append(paramArrayOfByte);
          localStringBuilder.append(", isEnd = ");
          localStringBuilder.append(paramBoolean2);
          localStringBuilder.append(", tabList = ");
          localStringBuilder.append(paramList);
          localStringBuilder.append(", result = ");
          localStringBuilder.append(paramList1);
          localStringBuilder.append(" subId =");
          localStringBuilder.append(paramInt);
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, localStringBuilder.toString());
        }
        b(paramList1);
        if (!paramBoolean1)
        {
          this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
          paramString2 = SearchUtil.a(paramList1, paramBoolean1);
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
          return;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleUniteSearchResult isEnd=");
          localStringBuilder.append(paramBoolean2);
          localStringBuilder.append(" key=");
          localStringBuilder.append(paramString1);
          QLog.i("Q.uniteSearch.UniteSearchActivity", 2, localStringBuilder.toString());
        }
        if (paramList == null)
        {
          a(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
          return;
        }
        if ((paramList.size() > 0) && ((((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131715669))) || ((((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaUtilList != null) && (((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaUtilList.size() == 0)))) {
          paramList.remove(0);
        }
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
        paramString2 = SearchUtil.a(paramList1, paramBoolean1);
        a(paramList1);
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
        UniteSearchActivity.d = true;
        return;
      }
      return;
    }
    finally {}
  }
  
  public void a(List<SearchEntryDataModel> paramList, int paramInt)
  {
    if (paramInt != this.a.c()) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refreshDataModels(paramList, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.2
 * JD-Core Version:    0.7.0.1
 */