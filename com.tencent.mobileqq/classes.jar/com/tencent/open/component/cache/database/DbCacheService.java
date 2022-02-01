package com.tencent.open.component.cache.database;

import android.content.Context;
import java.lang.Class<+Lcom.tencent.open.component.cache.database.DbCacheData;>;
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
    if (jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService != null) {
      return jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService;
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
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        throw new RuntimeException("call initiate(Context context) before this");
      }
    }
    if (paramString == null) {
      throw new RuntimeException("invalid table name");
    }
    Object localObject = DbCacheManager.a(paramLong, paramString);
    localObject = (DbCacheManager)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null)
    {
      paramClass = new DbCacheManager(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager$OnCloseListener);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends DbCacheData>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheService
 * JD-Core Version:    0.7.0.1
 */