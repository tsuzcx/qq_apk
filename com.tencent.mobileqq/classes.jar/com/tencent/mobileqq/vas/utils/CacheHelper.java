package com.tencent.mobileqq.vas.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/utils/CacheHelper;", "", "()V", "cacheLock", "Ljava/util/concurrent/locks/ReadWriteLock;", "objectCache", "Lcom/tencent/mobileqq/vas/utils/CacheHelper$ObjectCache;", "clearCache", "", "getObject", "T", "options", "Lcom/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions;", "(Lcom/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions;)Ljava/lang/Object;", "AbsOptions", "ObjectCache", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CacheHelper
{
  private static final CacheHelper.ObjectCache jdField_a_of_type_ComTencentMobileqqVasUtilsCacheHelper$ObjectCache = new CacheHelper.ObjectCache();
  public static final CacheHelper a;
  private static final ReadWriteLock jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasUtilsCacheHelper = new CacheHelper();
    jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock = (ReadWriteLock)new ReentrantReadWriteLock();
  }
  
  @JvmStatic
  @NotNull
  public static final <T> T a(@NotNull CacheHelper.AbsOptions paramAbsOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsOptions, "options");
    String str = paramAbsOptions.b();
    Object localObject;
    try
    {
      jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().lock();
      localObject = jdField_a_of_type_ComTencentMobileqqVasUtilsCacheHelper$ObjectCache.a(str);
      if ((localObject == null) || (!paramAbsOptions.a(localObject))) {
        break label89;
      }
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type T");
      }
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
    }
    jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
    return localObject;
    label89:
    jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
    try
    {
      jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().lock();
      localObject = jdField_a_of_type_ComTencentMobileqqVasUtilsCacheHelper$ObjectCache.a(str);
      if ((localObject == null) || (!paramAbsOptions.a(localObject))) {
        break label180;
      }
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type T");
      }
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
    }
    jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
    return localObject;
    label180:
    paramAbsOptions = paramAbsOptions.a();
    jdField_a_of_type_ComTencentMobileqqVasUtilsCacheHelper$ObjectCache.a(str, paramAbsOptions);
    if (paramAbsOptions == null) {
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
    return paramAbsOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.utils.CacheHelper
 * JD-Core Version:    0.7.0.1
 */