package com.tencent.open.component.cache.database;

import akqi;
import akqj;
import android.content.Context;
import java.util.HashMap;

public class DbCacheService
{
  protected static DbCacheService a;
  protected akqi a;
  protected Context a;
  protected final HashMap a;
  
  protected DbCacheService(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Akqi = new akqj(this);
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
  
  public DbCacheManager a(Class paramClass, long paramLong, String paramString)
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
      paramClass.a(this.jdField_a_of_type_Akqi);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheService
 * JD-Core Version:    0.7.0.1
 */