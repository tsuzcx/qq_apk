package com.tencent.open.component.cache;

import android.content.Context;
import com.tencent.open.component.cache.database.DbCacheService;

public class CacheManager
{
  protected static DbCacheService a;
  
  public static DbCacheService a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    a = DbCacheService.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.component.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */