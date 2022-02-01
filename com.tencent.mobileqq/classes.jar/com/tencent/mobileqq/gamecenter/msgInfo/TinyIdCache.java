package com.tencent.mobileqq.gamecenter.msgInfo;

import android.util.Pair;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.persistence.Entity;
import java.util.concurrent.ConcurrentHashMap;

public class TinyIdCache
  extends FullCache
{
  private ConcurrentHashMap<String, Pair<String, String>> a;
  
  public void a()
  {
    this.cacheMap.clear();
    this.a.clear();
  }
  
  protected void destroy()
  {
    a();
  }
  
  protected String getKey(Entity paramEntity)
  {
    return ((UinToTinyId)paramEntity).tinyId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msgInfo.TinyIdCache
 * JD-Core Version:    0.7.0.1
 */