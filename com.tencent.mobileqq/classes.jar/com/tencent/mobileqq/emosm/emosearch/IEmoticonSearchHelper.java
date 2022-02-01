package com.tencent.mobileqq.emosm.emosearch;

import android.view.View;

public abstract interface IEmoticonSearchHelper
{
  public abstract String getSearchWord();
  
  public abstract void onHide(boolean paramBoolean);
  
  public abstract void onShow();
  
  public abstract void reportItemExposed();
  
  public abstract void resetEmoticonSearch();
  
  public abstract void setEmptyView(View paramView);
  
  public abstract void setLoadingStatus(int paramInt);
  
  public abstract void setSearchWords(String paramString);
  
  public abstract void startSearch(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.IEmoticonSearchHelper
 * JD-Core Version:    0.7.0.1
 */