package com.tencent.open.component.cache.database;

import android.content.Context;
import java.util.HashMap;

public class DbCacheService
{
  protected static DbCacheService a;
  protected Context a;
  protected DbCacheManager.OnCloseListener a;
  protected final HashMap<String, DbCacheManager> a;
  
  protected DbCacheService(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager$OnCloseListener = new DbCacheService.1(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static DbCacheService a(Context paramContext)
  {
    DbCacheService localDbCacheService = jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService;
    if (localDbCacheService != null) {
      return localDbCacheService;
    }
    try
    {
      if (jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService == null) {
        jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService = new DbCacheService(paramContext);
      }
      paramContext = jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService;
      return paramContext;
    }
    finally {}
  }
  
  public DbCacheManager a(Class<? extends DbCacheData> paramClass, long paramLong, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        if (paramString != null)
        {
          Object localObject = DbCacheManager.a(paramLong, paramString);
          DbCacheManager localDbCacheManager = (DbCacheManager)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          localObject = localDbCacheManager;
          if (localDbCacheManager == null)
          {
            localObject = new DbCacheManager(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
            ((DbCacheManager)localObject).a(this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager$OnCloseListener);
            this.jdField_a_of_type_JavaUtilHashMap.put(((DbCacheManager)localObject).a(), localObject);
          }
          return localObject;
        }
        throw new RuntimeException("invalid table name");
      }
      throw new RuntimeException("call initiate(Context context) before this");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheService
 * JD-Core Version:    0.7.0.1
 */