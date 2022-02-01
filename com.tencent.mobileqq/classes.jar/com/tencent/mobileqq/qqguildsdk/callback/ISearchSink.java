package com.tencent.mobileqq.qqguildsdk.callback;

import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import java.util.List;

public abstract interface ISearchSink<T>
{
  public abstract void onSearchResult(int paramInt, String paramString, List<ISearchResultModel<T>> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.callback.ISearchSink
 * JD-Core Version:    0.7.0.1
 */