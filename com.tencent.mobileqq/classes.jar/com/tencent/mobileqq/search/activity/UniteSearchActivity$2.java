package com.tencent.mobileqq.search.activity;

import android.view.View;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.model.GroupSearchModelRichNode;
import com.tencent.mobileqq.search.model.GroupTabModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.RichSearchModelNode;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.rich.RichMetaData;
import com.tencent.mobileqq.search.rich.RichNodeFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "patchRichExtraData, source:" + this.a.jdField_a_of_type_Int + " from:" + this.a.jdField_c_of_type_Int);
    }
    int j = this.a.jdField_a_of_type_Int;
    int i = j;
    if (this.a.jdField_a_of_type_Int == 0) {
      switch (this.a.jdField_c_of_type_Int)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      boolean bool = ThemeUtil.isNowThemeIsNight(this.a.app, false, null);
      String str = RichMetaData.a(i, paramRichSearchModelNode.c(), paramRichSearchModelNode.g, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "patchRichExtraData, extraData:" + str);
      }
      paramRichSearchModelNode.b(str);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
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
            label76:
            QQAppInterface localQQAppInterface;
            while (localIterator2.hasNext())
            {
              paramList = (ISearchResultModel)localIterator2.next();
              if ((paramList != null) && ((paramList instanceof NetSearchTemplateBaseItem)))
              {
                paramList = (NetSearchTemplateBaseItem)paramList;
                localQQAppInterface = this.a.app;
                if (paramList.b() == null) {
                  break label159;
                }
              }
            }
            label159:
            for (paramList = paramList.b();; paramList = "")
            {
              ReportController.b(localQQAppInterface, "dc00898", "", paramList, "auth_search", "exp", 0, 0, "", "", "", "");
              break label76;
              break;
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
      label4:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label4;
      }
      Object localObject1 = (ISearchResultGroupModel)paramList.next();
      if ((((ISearchResultGroupModel)localObject1).a() == null) || (((ISearchResultGroupModel)localObject1).a().size() == 0)) {
        break;
      }
      Object localObject2 = ((ISearchResultGroupModel)localObject1).a().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ISearchResultModel localISearchResultModel = (ISearchResultModel)((Iterator)localObject2).next();
        if ((localISearchResultModel instanceof ISearchResultPositionModel)) {
          ((ISearchResultPositionModel)localISearchResultModel).b(this.a.jdField_a_of_type_Int);
        }
      }
      if (!(localObject1 instanceof GroupSearchModelRichNode)) {
        break;
      }
      localObject1 = ((ISearchResultGroupModel)localObject1).a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ISearchResultModel)((Iterator)localObject1).next();
        if ((localObject2 instanceof RichSearchModelNode))
        {
          int i = ((RichSearchModelNode)localObject2).f();
          if (!RichNodeFactory.a().a(i))
          {
            ((Iterator)localObject1).remove();
            if (QLog.isColorLevel()) {
              QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult, remove rich node:" + i);
            }
          }
          a((RichSearchModelNode)localObject2);
          b((RichSearchModelNode)localObject2);
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
        paramInt = 0;
        if (paramInt < paramList.size())
        {
          String str = ((AssociateSearchWordsFragment.AssociateItem)paramList.get(paramInt)).jdField_a_of_type_JavaLangString;
          AssociateSearchWordsFragment.AssociateItem localAssociateItem = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem.jdField_a_of_type_JavaLangString = str;
          localAssociateItem.jdField_a_of_type_Int = 3;
          localAssociateItem.d = (paramInt + 1);
          paramList1.add(localAssociateItem);
          if (paramInt != paramList.size() - 1)
          {
            paramList1.add(paramSuggestUrlItem);
            localStringBuilder.append(str).append("::");
          }
          for (;;)
          {
            paramInt += 1;
            break;
            localStringBuilder.append(str);
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramList1);
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.a.a()).ver2(UniteSearchReportController.a(this.a.jdField_c_of_type_Int)).ver4(localStringBuilder.toString()).ver7("{experiment_id:" + UniteSearchReportController.b + "}"));
    }
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleAssociateResultError keyword=" + paramString1 + "  resultCode=" + paramInteger + "  errorMsg=" + paramString2);
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2)) {}
    while (!this.a.f.equals(paramString1)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramInt, paramString3);
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchError resultCode=" + paramInt + " key=" + paramString1);
    }
    this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<GroupTabModel> paramList, List<ISearchResultGroupModel> paramList1, int paramInt)
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
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult, keyword = " + paramString1 + ", isFirstReq = " + paramBoolean1 + ", reqTime = " + paramString2 + ", cookie = " + paramArrayOfByte + ", isEnd = " + paramBoolean2 + ", tabList = " + paramList + ", result = " + paramList1 + " subId =" + paramInt);
        }
        b(paramList1);
        if (!paramBoolean1)
        {
          this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
          paramString2 = SearchUtil.a(paramList1, paramBoolean1);
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label265;
        }
      }
      finally {}
      QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult isEnd=" + paramBoolean2 + " key=" + paramString1);
      label265:
      if (paramList == null)
      {
        a(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
      }
      else
      {
        if ((paramList.size() > 0) && ((((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131715745))) || ((((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaUtilList != null) && (((GroupTabModel)paramList.get(0)).jdField_a_of_type_JavaUtilList.size() == 0)))) {
          paramList.remove(0);
        }
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
        paramString2 = SearchUtil.a(paramList1, paramBoolean1);
        a(paramList1);
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
        UniteSearchActivity.d = true;
      }
    }
  }
  
  public void a(List<SearchEntryDataModel> paramList, int paramInt)
  {
    if (paramInt != this.a.c()) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refreshDataModels(paramList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.2
 * JD-Core Version:    0.7.0.1
 */