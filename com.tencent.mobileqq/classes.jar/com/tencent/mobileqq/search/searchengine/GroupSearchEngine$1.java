package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

final class GroupSearchEngine$1
  implements Comparator<GroupSearchEngine.SearchEngineEntity>
{
  public int a(GroupSearchEngine.SearchEngineEntity paramSearchEngineEntity1, GroupSearchEngine.SearchEngineEntity paramSearchEngineEntity2)
  {
    Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(paramSearchEngineEntity2.f);
    paramSearchEngineEntity2 = Integer.valueOf(0);
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = paramSearchEngineEntity2;
    }
    localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(paramSearchEngineEntity1.f);
    paramSearchEngineEntity1 = localInteger;
    if (localInteger == null) {
      paramSearchEngineEntity1 = paramSearchEngineEntity2;
    }
    return Integer.signum(((Integer)localObject).intValue() - paramSearchEngineEntity1.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */