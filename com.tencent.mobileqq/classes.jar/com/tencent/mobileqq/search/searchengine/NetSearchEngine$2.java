package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class NetSearchEngine$2
  implements ISearchListener
{
  NetSearchEngine$2(NetSearchEngine paramNetSearchEngine, List paramList) {}
  
  public void a(List paramList) {}
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    SearchUtils.a();
    NetSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine).a.countDown();
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    a(paramList, paramSearchRespData.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */