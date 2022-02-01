package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMoreItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.ArrayList;
import java.util.List;

class GroupSearchEngine$5
  extends GroupSearchEngine.SearchEngineEntity
{
  GroupSearchEngine$5(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
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
    if (paramSearchRequest.b == null) {
      paramSearchRequest.b = new Bundle();
    }
    ArrayList localArrayList = new ArrayList();
    a(new GroupSearchModelMoreItem(paramSearchRequest.a, GroupSearchEngine.d(this.a)), localArrayList);
    SearchStatisticsConstants.b(0);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.5
 * JD-Core Version:    0.7.0.1
 */