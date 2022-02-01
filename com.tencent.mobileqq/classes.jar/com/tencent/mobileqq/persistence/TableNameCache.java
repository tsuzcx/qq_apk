package com.tencent.mobileqq.persistence;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TableNameCache
{
  public boolean isInit = false;
  private ConcurrentHashMap<String, Boolean> tbnCache = new ConcurrentHashMap();
  
  public void addToTableNameCache(String paramString)
  {
    this.tbnCache.put(paramString, Boolean.valueOf(true));
  }
  
  public void deleteFromTableCache(String paramString)
  {
    this.tbnCache.remove(paramString);
  }
  
  public String[] getAllTableNames()
  {
    Set localSet = this.tbnCache.keySet();
    String[] arrayOfString = new String[localSet.size()];
    localSet.toArray(arrayOfString);
    return arrayOfString;
  }
  
  public void initTableCache(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      this.tbnCache.put(str, Boolean.valueOf(true));
      i += 1;
    }
    this.isInit = true;
  }
  
  public boolean isContainsTableInCache(String paramString)
  {
    return this.tbnCache.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.TableNameCache
 * JD-Core Version:    0.7.0.1
 */