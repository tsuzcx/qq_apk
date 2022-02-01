package com.tencent.open.component.cache.database;

import android.content.Context;
import java.util.HashMap;

public class DbCacheService
{
  protected static DbCacheService d;
  protected Context a;
  protected final HashMap<String, DbCacheManager> b = new HashMap();
  protected DbCacheManager.OnCloseListener c = new DbCacheService.1(this);
  
  protected DbCacheService(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public static DbCacheService a(Context paramContext)
  {
    DbCacheService localDbCacheService = d;
    if (localDbCacheService != null) {
      return localDbCacheService;
    }
    try
    {
      if (d == null) {
        d = new DbCacheService(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  public DbCacheManager a(Class<? extends DbCacheData> paramClass, long paramLong, String paramString)
  {
    synchronized (this.b)
    {
      if (this.a != null)
      {
        if (paramString != null)
        {
          Object localObject = DbCacheManager.a(paramLong, paramString);
          DbCacheManager localDbCacheManager = (DbCacheManager)this.b.get(localObject);
          localObject = localDbCacheManager;
          if (localDbCacheManager == null)
          {
            localObject = new DbCacheManager(this.a, paramClass, paramLong, paramString);
            ((DbCacheManager)localObject).a(this.c);
            this.b.put(((DbCacheManager)localObject).b(), localObject);
          }
          return localObject;
        }
        throw new RuntimeException("invalid table name");
      }
      throw new RuntimeException("call initiate(Context context) before this");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheService
 * JD-Core Version:    0.7.0.1
 */