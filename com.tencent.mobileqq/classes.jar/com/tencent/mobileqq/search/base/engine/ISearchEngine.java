package com.tencent.mobileqq.search.base.engine;

import com.tencent.mobileqq.search.base.model.SearchRequest;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.engine.ISearchEngine
 * JD-Core Version:    0.7.0.1
 */