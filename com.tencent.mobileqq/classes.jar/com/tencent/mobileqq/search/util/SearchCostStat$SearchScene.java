package com.tencent.mobileqq.search.util;

import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.app.MobileQQ;

class SearchCostStat$SearchScene
{
  public long a;
  public String a;
  public final LinkedList<SearchCostStat.SearchStep> a;
  public final LinkedList<SearchCostStat.SearchParam> b = new LinkedList();
  
  private SearchCostStat$SearchScene()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  public SearchCostStat.SearchSceneRecord a()
  {
    SimpleAccount localSimpleAccount = null;
    SearchCostStat.SearchSceneRecord localSearchSceneRecord = new SearchCostStat.SearchSceneRecord(null);
    boolean bool;
    if ((this.jdField_a_of_type_Long & 0x4) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    localSearchSceneRecord.jdField_a_of_type_Boolean = bool;
    Object localObject1 = localSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject1).append("keyword=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    localObject1 = localSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject1).append(",keyEvents=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
    if (localSearchSceneRecord.jdField_a_of_type_Boolean) {
      localSearchSceneRecord.jdField_a_of_type_JavaUtilHashMap.put("keyEvents", String.valueOf(this.jdField_a_of_type_Long));
    }
    localObject1 = this.b.iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SearchCostStat.SearchParam)((Iterator)localObject1).next();
      localObject3 = localSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject3).append(",");
      ((StringBuilder)localObject3).append(((SearchCostStat.SearchParam)localObject2).jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject3).append("=");
      ((StringBuilder)localObject3).append(((SearchCostStat.SearchParam)localObject2).b);
      if (localSearchSceneRecord.jdField_a_of_type_Boolean) {
        localSearchSceneRecord.jdField_a_of_type_JavaUtilHashMap.put(((SearchCostStat.SearchParam)localObject2).jdField_a_of_type_JavaLangString, ((SearchCostStat.SearchParam)localObject2).b);
      }
    }
    localSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder.append(",allStep=[");
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    long l3 = 0L;
    for (long l2 = l3; ((Iterator)localObject1).hasNext(); l2 = l1)
    {
      localObject2 = (SearchCostStat.SearchStep)((Iterator)localObject1).next();
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((SearchCostStat.SearchStep)localObject2).jdField_a_of_type_Long;
      }
      if (l3 != 0L)
      {
        l2 = ((SearchCostStat.SearchStep)localObject2).jdField_a_of_type_Long - l3;
        localObject3 = localSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder;
        ((StringBuilder)localObject3).append("-");
        ((StringBuilder)localObject3).append(l2);
        ((StringBuilder)localObject3).append("->");
      }
      else
      {
        l2 = 0L;
      }
      l3 = ((SearchCostStat.SearchStep)localObject2).jdField_a_of_type_Long;
      localSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder.append(((SearchCostStat.SearchStep)localObject2).jdField_a_of_type_JavaLangString);
      if ((localSearchSceneRecord.jdField_a_of_type_Boolean) && (((SearchCostStat.SearchStep)localObject2).jdField_a_of_type_Boolean))
      {
        localObject3 = localSearchSceneRecord.jdField_a_of_type_JavaUtilHashMap;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((SearchCostStat.SearchStep)localObject2).jdField_a_of_type_JavaLangString);
        localStringBuilder.append("Cost");
        ((HashMap)localObject3).put(localStringBuilder.toString(), String.valueOf(l2));
      }
    }
    long l1 = l3 - l2;
    localObject1 = localSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject1).append("],startTime=");
    ((StringBuilder)localObject1).append(l2);
    localObject1 = localSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject1).append(",consumeTime=");
    ((StringBuilder)localObject1).append(l1);
    if (localSearchSceneRecord.jdField_a_of_type_Boolean)
    {
      localSearchSceneRecord.jdField_a_of_type_JavaUtilHashMap.put("detail", localSearchSceneRecord.jdField_a_of_type_JavaLangStringBuilder.toString());
      localSearchSceneRecord.jdField_a_of_type_JavaUtilHashMap.put("totalCost", String.valueOf(l1));
      if (MobileQQ.sMobileQQ != null) {
        localSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      }
      if (localSimpleAccount != null) {
        localSearchSceneRecord.jdField_a_of_type_JavaUtilHashMap.put("searchUin", localSimpleAccount.getUin());
      }
    }
    return localSearchSceneRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchCostStat.SearchScene
 * JD-Core Version:    0.7.0.1
 */