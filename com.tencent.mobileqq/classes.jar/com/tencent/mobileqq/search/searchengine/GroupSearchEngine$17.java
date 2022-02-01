package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

class GroupSearchEngine$17
  extends GroupSearchEngine.SearchEngineEntity
{
  GroupSearchEngine$17(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt);
  }
  
  public ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString)
  {
    return new FTSGroupSearchModelMessage(paramList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.17
 * JD-Core Version:    0.7.0.1
 */