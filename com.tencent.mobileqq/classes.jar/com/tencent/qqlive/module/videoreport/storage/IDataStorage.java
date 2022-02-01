package com.tencent.qqlive.module.videoreport.storage;

import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import java.util.List;

public abstract interface IDataStorage
{
  public abstract void clear();
  
  public abstract <T> boolean contains(Class<T> paramClass, String paramString);
  
  public abstract <T> boolean contains(T paramT);
  
  public abstract <T> void delete(Class<T> paramClass, Condition<T> paramCondition);
  
  public abstract <T> void delete(Class<T> paramClass, String paramString);
  
  public abstract <T> void delete(Class<T> paramClass, List<String> paramList);
  
  public abstract <T> void delete(T paramT);
  
  public abstract <T> void delete(List<T> paramList);
  
  public abstract <T> void deleteAll(Class<T> paramClass);
  
  public abstract <T> T load(Class<T> paramClass, String paramString);
  
  public abstract <T> List<T> load(Class<T> paramClass, Condition<T> paramCondition);
  
  public abstract <T> List<T> load(Class<T> paramClass, List<String> paramList);
  
  public abstract <T> List<T> loadAll(Class<T> paramClass);
  
  public abstract <T> void storeOrUpdate(T paramT);
  
  public abstract <T> void storeOrUpdate(T paramT, String paramString);
  
  public abstract <T> void storeOrUpdate(List<T> paramList);
  
  public abstract <T> void storeOrUpdate(List<T> paramList, List<String> paramList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.IDataStorage
 * JD-Core Version:    0.7.0.1
 */