package com.tencent.mobileqq.search.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISearchConfigUtilFetcher
  extends QRouteApi
{
  public abstract String getSFtsSearchBarWording();
  
  public abstract boolean isSearchEnhanceEnable(String paramString);
  
  public abstract void setSFtsSearchBarWording(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher
 * JD-Core Version:    0.7.0.1
 */