package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class SearchCostStat
{
  private static SearchCostStat.SearchScene jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static void a()
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene != null)
        {
          Object localObject1 = new SearchCostStat.SearchStep(null);
          ((SearchCostStat.SearchStep)localObject1).jdField_a_of_type_JavaLangString = "End";
          ((SearchCostStat.SearchStep)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
          ((SearchCostStat.SearchStep)localObject1).jdField_a_of_type_Boolean = true;
          jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene.jdField_a_of_type_JavaUtilLinkedList.add(localObject1);
          localObject1 = jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene.a();
          jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene = null;
          a((SearchCostStat.SearchSceneRecord)localObject1);
          return;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public static void a(int paramInt)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene != null)
      {
        SearchCostStat.SearchScene localSearchScene = jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene;
        localSearchScene.jdField_a_of_type_Long |= paramInt;
      }
      return;
    }
  }
  
  private static void a(SearchCostStat.SearchSceneRecord paramSearchSceneRecord)
  {
    if (paramSearchSceneRecord == null) {
      return;
    }
    Object localObject = paramSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject).append(",needReport=");
    ((StringBuilder)localObject).append(paramSearchSceneRecord.jdField_a_of_type_Boolean);
    QLog.i("SearchCostStat", 1, paramSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder.toString());
    if (paramSearchSceneRecord.jdField_a_of_type_Boolean)
    {
      if (Utils.b()) {
        localObject = "qq_search_vip_cost";
      } else {
        localObject = "qq_search_cost";
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject, true, 0L, 0L, paramSearchSceneRecord.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(paramString);
    a(localStringBuilder.toString(), false);
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene != null)
        {
          localSearchSceneRecord = jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene.a();
          jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene = new SearchCostStat.SearchScene(null);
          jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene.jdField_a_of_type_JavaLangString = paramString;
          paramString = new SearchCostStat.SearchParam(null);
          paramString.jdField_a_of_type_JavaLangString = "from";
          paramString.b = String.valueOf(paramInt);
          jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene.b.add(paramString);
          paramString = new SearchCostStat.SearchParam(null);
          paramString.jdField_a_of_type_JavaLangString = "isActivityFirstTime";
          paramString.b = String.valueOf(paramBoolean);
          jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene.b.add(paramString);
          paramString = new SearchCostStat.SearchStep(null);
          paramString.jdField_a_of_type_JavaLangString = "Start";
          paramString.jdField_a_of_type_Long = System.currentTimeMillis();
          jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene.jdField_a_of_type_JavaUtilLinkedList.add(paramString);
          a(localSearchSceneRecord);
          return;
        }
      }
      SearchCostStat.SearchSceneRecord localSearchSceneRecord = null;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene != null)
      {
        SearchCostStat.SearchParam localSearchParam = new SearchCostStat.SearchParam(null);
        localSearchParam.jdField_a_of_type_JavaLangString = paramString1;
        localSearchParam.b = paramString2;
        jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene.b.add(localSearchParam);
      }
      return;
    }
  }
  
  private static void a(String paramString, boolean paramBoolean)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene != null)
      {
        SearchCostStat.SearchStep localSearchStep = new SearchCostStat.SearchStep(null);
        localSearchStep.jdField_a_of_type_JavaLangString = paramString;
        localSearchStep.jdField_a_of_type_Long = System.currentTimeMillis();
        localSearchStep.jdField_a_of_type_Boolean = paramBoolean;
        jdField_a_of_type_ComTencentMobileqqSearchUtilSearchCostStat$SearchScene.jdField_a_of_type_JavaUtilLinkedList.add(localSearchStep);
      }
      return;
    }
  }
  
  public static void b(String paramString)
  {
    a(paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchCostStat
 * JD-Core Version:    0.7.0.1
 */