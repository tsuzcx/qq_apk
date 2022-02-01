package com.tencent.mobileqq.search.base.engine;

import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.model.IModel;
import java.util.List;

public abstract interface ISearchListener<M extends IModel>
{
  public abstract void a(List<M> paramList);
  
  public abstract void a(List<M> paramList, int paramInt);
  
  public abstract void a(List<M> paramList, SearchRespData paramSearchRespData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.engine.ISearchListener
 * JD-Core Version:    0.7.0.1
 */