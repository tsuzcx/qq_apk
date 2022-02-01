package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelMoreItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
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
    this.jdField_a_of_type_Long = 0L;
    this.b = -1;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      paramSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    ArrayList localArrayList = new ArrayList();
    paramSearchRequest = new GroupSearchModelMoreItem(paramSearchRequest.jdField_a_of_type_JavaLangString, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
    localArrayList.add(new GroupSearchModeTitle(paramSearchRequest));
    localArrayList.add(paramSearchRequest);
    SearchStatisticsConstants.a(0);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.5
 * JD-Core Version:    0.7.0.1
 */