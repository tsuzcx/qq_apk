package com.tencent.mobileqq.search.api.impl;

import com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher;
import com.tencent.mobileqq.search.util.SearchConfigUtils;

public class SearchConfigUtilFetcherImpl
  implements ISearchConfigUtilFetcher
{
  public String getSFtsSearchBarWording()
  {
    return SearchConfigUtils.a;
  }
  
  public boolean isSearchEnhanceEnable(String paramString)
  {
    return SearchConfigUtils.a(paramString);
  }
  
  public void setSFtsSearchBarWording(String paramString)
  {
    SearchConfigUtils.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.impl.SearchConfigUtilFetcherImpl
 * JD-Core Version:    0.7.0.1
 */