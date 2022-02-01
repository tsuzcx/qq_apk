package com.tencent.qqlive.module.videoreport.page;

import android.util.SparseArray;

public class PageContextManager
{
  private SparseArray<PageContext> mContextMap = new SparseArray();
  
  public static PageContextManager getInstance()
  {
    return PageContextManager.InstanceHolder.INSTANCE;
  }
  
  public void clear()
  {
    this.mContextMap.clear();
  }
  
  public PageContext get(int paramInt)
  {
    return (PageContext)this.mContextMap.get(paramInt);
  }
  
  public void remove(int paramInt)
  {
    this.mContextMap.remove(paramInt);
  }
  
  public void set(int paramInt, PageContext paramPageContext)
  {
    this.mContextMap.put(paramInt, paramPageContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageContextManager
 * JD-Core Version:    0.7.0.1
 */