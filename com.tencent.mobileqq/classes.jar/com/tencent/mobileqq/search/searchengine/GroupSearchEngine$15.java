package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import cooperation.qqfav.globalsearch.GroupSearchModelFavorite;
import java.util.List;

class GroupSearchEngine$15
  extends GroupSearchEngine.SearchEngineEntity
{
  GroupSearchEngine$15(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt);
  }
  
  public ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString)
  {
    return new GroupSearchModelFavorite(paramList, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.15
 * JD-Core Version:    0.7.0.1
 */