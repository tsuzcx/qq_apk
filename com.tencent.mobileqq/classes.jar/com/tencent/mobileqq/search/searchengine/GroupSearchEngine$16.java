package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

class GroupSearchEngine$16
  extends GroupSearchEngine.SearchEngineEntity
{
  GroupSearchEngine$16(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt1, int paramInt2)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt1);
  }
  
  public ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString)
  {
    return new GroupSearchModelFileEntity(paramList, paramString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.16
 * JD-Core Version:    0.7.0.1
 */