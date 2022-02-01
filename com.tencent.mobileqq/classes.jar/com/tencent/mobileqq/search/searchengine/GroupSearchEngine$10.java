package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.VADHelper;
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
    return new GroupSearchModelLocalContactApproximate(paramList, paramString, this.jdField_a_of_type_Int);
  }
  
  public List<ISearchResultGroupModel> a(SearchRequest paramSearchRequest)
  {
    if (!GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(paramSearchRequest);
    VADHelper.b("voice_search_approximate_cost");
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
    }
    for (;;)
    {
      return localList;
      paramSearchRequest.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.10
 * JD-Core Version:    0.7.0.1
 */