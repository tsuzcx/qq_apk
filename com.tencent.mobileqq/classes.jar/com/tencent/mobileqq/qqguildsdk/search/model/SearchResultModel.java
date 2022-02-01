package com.tencent.mobileqq.qqguildsdk.search.model;

import java.util.ArrayList;
import java.util.List;

public class SearchResultModel<T>
  implements ISearchResultModel
{
  protected String a;
  private List<T> b = new ArrayList();
  
  public SearchResultModel(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(List<T> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.b.addAll(paramList);
    }
  }
  
  public List<T> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.model.SearchResultModel
 * JD-Core Version:    0.7.0.1
 */