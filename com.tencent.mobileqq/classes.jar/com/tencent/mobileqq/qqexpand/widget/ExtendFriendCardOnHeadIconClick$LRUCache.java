package com.tencent.mobileqq.qqexpand.widget;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class ExtendFriendCardOnHeadIconClick$LRUCache<K, V>
  extends LinkedHashMap<K, V>
{
  private int size;
  
  private ExtendFriendCardOnHeadIconClick$LRUCache(int paramInt)
  {
    super(paramInt, 0.75F, true);
    this.size = paramInt;
  }
  
  static void removeOutDatedData(String paramString)
  {
    ExtendFriendCardOnHeadIconClick.b.remove(paramString);
    ExtendFriendCardOnHeadIconClick.a.remove(paramString);
  }
  
  static boolean shouldRefreshData(String paramString)
  {
    boolean bool2 = ExtendFriendCardOnHeadIconClick.b.containsKey(paramString);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    long l = TimeUnit.SECONDS.toMillis(30L);
    if (System.currentTimeMillis() - ((Long)ExtendFriendCardOnHeadIconClick.b.get(paramString)).longValue() > l) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    if (size() > this.size)
    {
      ExtendFriendCardOnHeadIconClick.b.remove(paramEntry.getKey());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick.LRUCache
 * JD-Core Version:    0.7.0.1
 */