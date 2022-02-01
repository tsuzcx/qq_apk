package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.model.IModel;
import java.util.List;

public abstract interface ISearchListener<M extends IModel>
{
  public abstract void a(List<M> paramList);
  
  public abstract void a(List<M> paramList, int paramInt);
  
  public abstract void a(List<M> paramList, SearchRespData paramSearchRespData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ISearchListener
 * JD-Core Version:    0.7.0.1
 */