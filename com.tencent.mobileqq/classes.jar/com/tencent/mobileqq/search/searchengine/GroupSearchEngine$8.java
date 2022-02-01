package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GroupSearchEngine$8
  extends GroupSearchEngine.SearchEngineEntity
{
  GroupSearchEngine$8(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt);
  }
  
  public ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new GroupSearchModelLocalContact(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<ISearchResultGroupModel> a(SearchRequest paramSearchRequest)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(paramSearchRequest);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramSearchRequest.a == null) {
        paramSearchRequest.a = new Bundle();
      }
      paramSearchRequest.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((ISearchResultGroupModel)localList.get(1)).a().size());
        }
        paramSearchRequest.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((ISearchResultGroupModel)localList.get(1)).a().size());
      }
      return localList;
    }
    paramSearchRequest.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected ISearchResultGroupModel b(List<ISearchResultModel> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ISearchResultModel localISearchResultModel = (ISearchResultModel)paramList.next();
      if (!SearchUtils.a(localISearchResultModel)) {
        localArrayList.add(localISearchResultModel);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new GroupSearchModelLocalContact(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected ISearchResultGroupModel c(List<ISearchResultModel> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ISearchResultModel localISearchResultModel = (ISearchResultModel)paramList.next();
      if (SearchUtils.a(localISearchResultModel)) {
        localArrayList.add(localISearchResultModel);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new GroupSearchModelLocalTroop(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.8
 * JD-Core Version:    0.7.0.1
 */