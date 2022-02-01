package com.tencent.mobileqq.kandian.biz.ugc.selectmember.search;

import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectMemberHybridSearchEngine
  implements ISearchEngine<ISearchResultModel>, ISearchListener<ISearchResultModel>
{
  private List<ISearchEngine> a = new ArrayList();
  private List<ISearchResultModel> b = new ArrayList();
  private ISearchListener<ISearchResultModel> c;
  
  SelectMemberHybridSearchEngine(List<ISearchEngine> paramList)
  {
    if (paramList != null) {
      this.a.addAll(paramList);
    }
  }
  
  public List<ISearchResultModel> a(SearchRequest paramSearchRequest)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((ISearchEngine)localIterator.next()).a(paramSearchRequest));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ISearchEngine)localIterator.next()).a();
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<ISearchResultModel> paramISearchListener)
  {
    this.b.clear();
    this.c = paramISearchListener;
    paramISearchListener = this.a.iterator();
    while (paramISearchListener.hasNext()) {
      ((ISearchEngine)paramISearchListener.next()).a(paramSearchRequest, this);
    }
  }
  
  public void a(List<ISearchResultModel> paramList)
  {
    ISearchListener localISearchListener = this.c;
    if (localISearchListener != null) {
      localISearchListener.a(paramList);
    }
  }
  
  public void a(List<ISearchResultModel> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    paramList = this.c;
    if (paramList != null) {
      paramList.a(this.b, paramInt);
    }
  }
  
  public void a(List<ISearchResultModel> paramList, SearchRespData paramSearchRespData)
  {
    a(paramList, paramSearchRespData.b);
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ISearchEngine)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ISearchEngine)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ISearchEngine)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ISearchEngine)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.SelectMemberHybridSearchEngine
 * JD-Core Version:    0.7.0.1
 */