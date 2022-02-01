package com.tencent.mobileqq.kandian.repo.ugc.srtutils;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class ReadInJoySrtHandler
{
  public static int a = 1;
  private static ReadInJoySrtHandler jdField_a_of_type_ComTencentMobileqqKandianRepoUgcSrtutilsReadInJoySrtHandler;
  private SparseArray<ReadInJoySrtHandler.IRuleManager> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private ReadInJoySrtHandler.IRuleManager a(int paramInt)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager2 = (ReadInJoySrtHandler.IRuleManager)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    ReadInJoySrtHandler.IRuleManager localIRuleManager1 = localIRuleManager2;
    if (localIRuleManager2 == null)
    {
      localIRuleManager1 = SRTFactory.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localIRuleManager1);
    }
    return localIRuleManager1;
  }
  
  public static ReadInJoySrtHandler a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqKandianRepoUgcSrtutilsReadInJoySrtHandler == null) {
        jdField_a_of_type_ComTencentMobileqqKandianRepoUgcSrtutilsReadInJoySrtHandler = new ReadInJoySrtHandler();
      }
      ReadInJoySrtHandler localReadInJoySrtHandler = jdField_a_of_type_ComTencentMobileqqKandianRepoUgcSrtutilsReadInJoySrtHandler;
      return localReadInJoySrtHandler;
    }
    finally {}
  }
  
  public String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager = a(paramInt);
    if (localIRuleManager == null) {
      return "";
    }
    return localIRuleManager.a(paramAbsBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager = a(paramInt);
    if (localIRuleManager == null) {
      return;
    }
    localIRuleManager.a(paramAbsBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager = a(paramInt);
    if (localIRuleManager == null) {
      return;
    }
    localIRuleManager.a(paramObject);
  }
  
  public boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager = a(paramInt);
    if (localIRuleManager == null) {
      return false;
    }
    return localIRuleManager.a(paramAbsBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.srtutils.ReadInJoySrtHandler
 * JD-Core Version:    0.7.0.1
 */