package com.tencent.qqlive.module.videoreport.page;

import java.util.Map;
import java.util.WeakHashMap;

public class PageContextManager
{
  private final Map<Object, PageContext> mContextMap = new WeakHashMap();
  
  public static PageContextManager getInstance()
  {
    return PageContextManager.InstanceHolder.INSTANCE;
  }
  
  public void clear()
  {
    this.mContextMap.clear();
  }
  
  public PageContext get(Object paramObject)
  {
    return (PageContext)this.mContextMap.get(paramObject);
  }
  
  public void set(Object paramObject, PageContext paramPageContext)
  {
    this.mContextMap.put(paramObject, paramPageContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageContextManager
 * JD-Core Version:    0.7.0.1
 */