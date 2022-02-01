package com.tencent.richframework.data.base;

import com.tencent.richframework.data.idata.IDataStore;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseDataStore<T>
  implements IDataStore<T>
{
  private ConcurrentHashMap<String, T> a = new ConcurrentHashMap();
  
  public int a()
  {
    return 0;
  }
  
  public void a(T paramT)
  {
    this.a.put(b(paramT), paramT);
  }
  
  public void a(String paramString) {}
  
  public void a(List<T> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramList.next());
    }
  }
  
  protected abstract String b(T paramT);
  
  public Map<String, T> b()
  {
    return this.a;
  }
  
  public void b(List<T> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      c(paramList.next());
    }
  }
  
  public void c()
  {
    this.a.clear();
  }
  
  public void c(T paramT)
  {
    this.a.remove(b(paramT));
  }
  
  public boolean d()
  {
    return false;
  }
  
  public String e()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.base.BaseDataStore
 * JD-Core Version:    0.7.0.1
 */