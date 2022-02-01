package com.tencent.richframework.data.idata;

import java.util.List;
import java.util.Map;

public abstract interface IDataStore<T>
{
  public abstract void a(T paramT);
  
  public abstract void a(String paramString);
  
  public abstract void a(List<T> paramList);
  
  public abstract Map<String, T> b();
  
  public abstract void b(List<T> paramList);
  
  public abstract void c();
  
  public abstract boolean d();
  
  public abstract String e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.idata.IDataStore
 * JD-Core Version:    0.7.0.1
 */