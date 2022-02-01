package com.tencent.qqlive.module.videoreport.storage.preference;

import android.util.Pair;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import java.util.List;

abstract interface ISpOperation
{
  public abstract void clearSp();
  
  public abstract <T> boolean containsObject(Class<T> paramClass, String paramString);
  
  public abstract <T> void deleteAllObjects(Class<T> paramClass);
  
  public abstract <T> void deleteObject(Class<T> paramClass, String paramString);
  
  public abstract <T> void deleteObjects(Class<T> paramClass, List<String> paramList);
  
  public abstract <T> List<Pair<String, T>> getAllObjects(Class<T> paramClass);
  
  public abstract <T> T getObject(Class<T> paramClass, String paramString);
  
  public abstract <T> List<Pair<String, T>> getObjects(Class<T> paramClass, Condition<T> paramCondition);
  
  public abstract <T> void insertObject(T paramT, String paramString);
  
  public abstract <T> void insertObjects(List<T> paramList, List<String> paramList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
 * JD-Core Version:    0.7.0.1
 */