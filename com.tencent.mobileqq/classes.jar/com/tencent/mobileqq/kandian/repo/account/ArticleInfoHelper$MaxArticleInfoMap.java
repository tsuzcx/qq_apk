package com.tencent.mobileqq.kandian.repo.account;

import java.util.Comparator;
import java.util.TreeMap;

public class ArticleInfoHelper$MaxArticleInfoMap<K, V>
  extends TreeMap<K, V>
{
  public final int maxCount;
  
  public ArticleInfoHelper$MaxArticleInfoMap(int paramInt, Comparator<? super K> paramComparator)
  {
    super(paramComparator);
    this.maxCount = paramInt;
  }
  
  public V put(K paramK, V paramV)
  {
    paramK = super.put(paramK, paramV);
    if (size() >= this.maxCount)
    {
      paramV = lastKey();
      if (paramV != null) {
        remove(paramV);
      }
    }
    return paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper.MaxArticleInfoMap
 * JD-Core Version:    0.7.0.1
 */