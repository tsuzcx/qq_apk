package com.tencent.mobileqq.kandian.biz.ugc.selectmember.search;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FollowingSearchEngine
  implements ISearchEngine<ISearchResultModel>
{
  private List<FollowingSearchResultModel> a = new ArrayList();
  
  public List<ISearchResultModel> a(SearchRequest paramSearchRequest)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      FollowingSearchResultModel localFollowingSearchResultModel = (FollowingSearchResultModel)localIterator.next();
      if (localFollowingSearchResultModel.a(paramSearchRequest.a)) {
        localArrayList.add(localFollowingSearchResultModel);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = ReadInJoyLogicEngine.a().c().iterator();
    while (localIterator.hasNext())
    {
      FollowingMember localFollowingMember = (FollowingMember)localIterator.next();
      this.a.add(new FollowingSearchResultModel(localFollowingMember));
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<ISearchResultModel> paramISearchListener)
  {
    paramISearchListener.a(a(paramSearchRequest), 1);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.FollowingSearchEngine
 * JD-Core Version:    0.7.0.1
 */