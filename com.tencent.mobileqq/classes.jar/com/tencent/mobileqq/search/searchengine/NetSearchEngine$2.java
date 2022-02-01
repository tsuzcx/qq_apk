package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRespData;
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
      this.a.addAll(paramList);
    }
    SearchUtils.c();
    NetSearchEngine.c(this.b).a.countDown();
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    a(paramList, paramSearchRespData.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */