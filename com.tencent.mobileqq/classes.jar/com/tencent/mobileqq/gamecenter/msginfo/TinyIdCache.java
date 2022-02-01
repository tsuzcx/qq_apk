package com.tencent.mobileqq.gamecenter.msginfo;

import android.util.Pair;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.persistence.Entity;
import java.util.concurrent.ConcurrentHashMap;

public class TinyIdCache
  extends FullCache
{
  private ConcurrentHashMap<String, Pair<String, String>> b;
  
  public void a()
  {
    this.cacheMap.clear();
    this.b.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msginfo.TinyIdCache
 * JD-Core Version:    0.7.0.1
 */