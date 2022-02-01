package com.tencent.mobileqq.qqguildsdk.search.selector;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

class SearchEngine$2
  implements Comparator<Map.Entry<SearchEngine<T>.SearchMsg, List<T>>>
{
  SearchEngine$2(SearchEngine paramSearchEngine) {}
  
  public int a(Map.Entry<SearchEngine<T>.SearchMsg, List<T>> paramEntry1, Map.Entry<SearchEngine<T>.SearchMsg, List<T>> paramEntry2)
  {
    if (((SearchEngine.SearchMsg)paramEntry1.getKey()).a == ((SearchEngine.SearchMsg)paramEntry2.getKey()).a) {
      return 0;
    }
    if (((SearchEngine.SearchMsg)paramEntry1.getKey()).a > ((SearchEngine.SearchMsg)paramEntry2.getKey()).a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.SearchEngine.2
 * JD-Core Version:    0.7.0.1
 */