package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.base.util.VADHelper;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
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
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ISearchResultModel localISearchResultModel = (ISearchResultModel)paramList.next();
      if (!SearchUtils.b(localISearchResultModel)) {
        localArrayList.add(localISearchResultModel);
      }
    }
    return new GroupSearchModelLocalContact(localArrayList, paramString, GroupSearchEngine.d(this.a));
  }
  
  public List<ISearchResultGroupModel> a(SearchRequest paramSearchRequest)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(paramSearchRequest);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramSearchRequest.b == null) {
        paramSearchRequest.b = new Bundle();
      }
      paramSearchRequest.b.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("contact search result count:");
          localStringBuilder.append(((ISearchResultGroupModel)localList.get(1)).b().size());
          QLog.d("GroupSearchEngine", 4, localStringBuilder.toString());
        }
        paramSearchRequest.b.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((ISearchResultGroupModel)localList.get(1)).b().size());
        return localList;
      }
    }
    else
    {
      paramSearchRequest.b.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
    return localList;
  }
  
  protected ISearchResultGroupModel b(List<ISearchResultModel> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ISearchResultModel localISearchResultModel = (ISearchResultModel)paramList.next();
        if ((!SearchUtils.a(localISearchResultModel)) && (!SearchUtils.b(localISearchResultModel))) {
          localArrayList.add(localISearchResultModel);
        }
      }
      if (localArrayList.size() == 0) {
        return null;
      }
      return new GroupSearchModelLocalContact(localArrayList, paramString, GroupSearchEngine.d(this.a));
    }
    return null;
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
      if ((SearchUtils.a(localISearchResultModel)) && (!SearchUtils.b(localISearchResultModel))) {
        localArrayList.add(localISearchResultModel);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new GroupSearchModelLocalTroop(localArrayList, paramString, GroupSearchEngine.d(this.a));
  }
  
  protected ISearchResultGroupModel d(List<ISearchResultModel> paramList, String paramString)
  {
    paramString = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ISearchResultModel localISearchResultModel = (ISearchResultModel)paramList.next();
      if (SearchUtils.b(localISearchResultModel)) {
        paramString.add(localISearchResultModel);
      }
    }
    if (paramString.size() == 0) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.8
 * JD-Core Version:    0.7.0.1
 */