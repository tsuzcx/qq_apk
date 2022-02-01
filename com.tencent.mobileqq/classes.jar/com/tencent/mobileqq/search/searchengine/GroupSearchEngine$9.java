package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

class GroupSearchEngine$9
  extends GroupSearchEngine.SearchEngineEntity
{
  GroupSearchEngine$9(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt1, int paramInt2)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt1);
  }
  
  protected ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString)
  {
    return new GroupSearchModelMiniProgram(paramList, paramString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.9
 * JD-Core Version:    0.7.0.1
 */