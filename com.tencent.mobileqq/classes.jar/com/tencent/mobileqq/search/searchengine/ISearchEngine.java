package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.model.IModel;
import java.util.List;

public abstract interface ISearchEngine<T extends IModel>
{
  public abstract List<T> a(SearchRequest paramSearchRequest);
  
  public abstract void a();
  
  public abstract void a(SearchRequest paramSearchRequest, ISearchListener<T> paramISearchListener);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ISearchEngine
 * JD-Core Version:    0.7.0.1
 */