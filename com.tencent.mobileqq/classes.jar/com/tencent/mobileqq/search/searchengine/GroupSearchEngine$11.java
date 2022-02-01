package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

class GroupSearchEngine$11
  extends GroupSearchEngine.SearchEngineEntity
{
  GroupSearchEngine$11(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt1, int paramInt2)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt1);
  }
  
  public ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString)
  {
    return new GroupSearchModelFunction(paramList, paramString, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.11
 * JD-Core Version:    0.7.0.1
 */