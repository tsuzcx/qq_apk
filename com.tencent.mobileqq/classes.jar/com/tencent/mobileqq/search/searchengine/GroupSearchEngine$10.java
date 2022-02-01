package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.util.VADHelper;
import com.tencent.mobileqq.search.business.contact.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GroupSearchEngine$10
  extends GroupSearchEngine.SearchEngineEntity
{
  GroupSearchEngine$10(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt1, int paramInt2)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt1);
  }
  
  public ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString)
  {
    return new GroupSearchModelLocalContactApproximate(paramList, paramString, this.a);
  }
  
  public List<ISearchResultGroupModel> a(SearchRequest paramSearchRequest)
  {
    if (!GroupSearchEngine.h(this.b)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(paramSearchRequest);
    VADHelper.b("voice_search_approximate_cost");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.10
 * JD-Core Version:    0.7.0.1
 */