package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.ArrayList;
import java.util.List;

class GroupSearchEngine$7
  extends GroupSearchEngine.SearchEngineEntity
{
  GroupSearchEngine$7(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt);
  }
  
  public ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString)
  {
    return null;
  }
  
  public List<ISearchResultGroupModel> a(SearchRequest paramSearchRequest)
  {
    this.d = 0L;
    this.e = -1;
    paramSearchRequest.b.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    paramSearchRequest.b.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    paramSearchRequest = this.c.a(paramSearchRequest);
    if (paramSearchRequest != null) {
      localArrayList.addAll(paramSearchRequest);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.7
 * JD-Core Version:    0.7.0.1
 */