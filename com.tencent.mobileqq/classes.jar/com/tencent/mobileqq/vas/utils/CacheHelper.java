package com.tencent.mobileqq.vas.utils;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/utils/CacheHelper;", "", "()V", "cacheLock", "Ljava/util/concurrent/locks/ReadWriteLock;", "objectCache", "Lcom/tencent/mobileqq/vas/utils/CacheHelper$ObjectCache;", "clearCache", "", "getObject", "T", "options", "Lcom/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions;", "(Lcom/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions;)Ljava/lang/Object;", "AbsOptions", "ObjectCache", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CacheHelper
{
  public static final CacheHelper a = new CacheHelper();
  private static final ReadWriteLock b = (ReadWriteLock)new ReentrantReadWriteLock();
  private static final CacheHelper.ObjectCache c = new CacheHelper.ObjectCache();
  
  /* Error */
  @kotlin.jvm.JvmStatic
  @org.jetbrains.annotations.NotNull
  public static final <T> T a(@org.jetbrains.annotations.NotNull CacheHelper.AbsOptions paramAbsOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 57
    //   3: invokestatic 63	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokevirtual 68	com/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions:c	()Ljava/lang/String;
    //   10: astore_2
    //   11: getstatic 47	com/tencent/mobileqq/vas/utils/CacheHelper:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   14: invokeinterface 72 1 0
    //   19: invokeinterface 77 1 0
    //   24: getstatic 52	com/tencent/mobileqq/vas/utils/CacheHelper:c	Lcom/tencent/mobileqq/vas/utils/CacheHelper$ObjectCache;
    //   27: aload_2
    //   28: invokevirtual 80	com/tencent/mobileqq/vas/utils/CacheHelper$ObjectCache:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +42 -> 75
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 83	com/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions:a	(Ljava/lang/Object;)Z
    //   41: istore_1
    //   42: iload_1
    //   43: ifeq +32 -> 75
    //   46: aload_3
    //   47: ifnull +18 -> 65
    //   50: getstatic 47	com/tencent/mobileqq/vas/utils/CacheHelper:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   53: invokeinterface 72 1 0
    //   58: invokeinterface 86 1 0
    //   63: aload_3
    //   64: areturn
    //   65: new 88	kotlin/TypeCastException
    //   68: dup
    //   69: ldc 90
    //   71: invokespecial 93	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: getstatic 47	com/tencent/mobileqq/vas/utils/CacheHelper:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   78: invokeinterface 72 1 0
    //   83: invokeinterface 86 1 0
    //   88: getstatic 47	com/tencent/mobileqq/vas/utils/CacheHelper:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   91: invokeinterface 96 1 0
    //   96: invokeinterface 77 1 0
    //   101: getstatic 52	com/tencent/mobileqq/vas/utils/CacheHelper:c	Lcom/tencent/mobileqq/vas/utils/CacheHelper$ObjectCache;
    //   104: aload_2
    //   105: invokevirtual 80	com/tencent/mobileqq/vas/utils/CacheHelper$ObjectCache:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   108: astore_3
    //   109: aload_3
    //   110: ifnull +42 -> 152
    //   113: aload_0
    //   114: aload_3
    //   115: invokevirtual 83	com/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions:a	(Ljava/lang/Object;)Z
    //   118: istore_1
    //   119: iload_1
    //   120: ifeq +32 -> 152
    //   123: aload_3
    //   124: ifnull +18 -> 142
    //   127: getstatic 47	com/tencent/mobileqq/vas/utils/CacheHelper:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   130: invokeinterface 96 1 0
    //   135: invokeinterface 86 1 0
    //   140: aload_3
    //   141: areturn
    //   142: new 88	kotlin/TypeCastException
    //   145: dup
    //   146: ldc 90
    //   148: invokespecial 93	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   151: athrow
    //   152: aload_0
    //   153: invokevirtual 99	com/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions:b	()Ljava/lang/Object;
    //   156: astore_0
    //   157: getstatic 52	com/tencent/mobileqq/vas/utils/CacheHelper:c	Lcom/tencent/mobileqq/vas/utils/CacheHelper$ObjectCache;
    //   160: aload_2
    //   161: aload_0
    //   162: invokevirtual 102	com/tencent/mobileqq/vas/utils/CacheHelper$ObjectCache:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   165: aload_0
    //   166: ifnull +18 -> 184
    //   169: getstatic 47	com/tencent/mobileqq/vas/utils/CacheHelper:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   172: invokeinterface 96 1 0
    //   177: invokeinterface 86 1 0
    //   182: aload_0
    //   183: areturn
    //   184: new 88	kotlin/TypeCastException
    //   187: dup
    //   188: ldc 90
    //   190: invokespecial 93	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   193: athrow
    //   194: astore_0
    //   195: getstatic 47	com/tencent/mobileqq/vas/utils/CacheHelper:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   198: invokeinterface 96 1 0
    //   203: invokeinterface 86 1 0
    //   208: aload_0
    //   209: athrow
    //   210: astore_0
    //   211: getstatic 47	com/tencent/mobileqq/vas/utils/CacheHelper:b	Ljava/util/concurrent/locks/ReadWriteLock;
    //   214: invokeinterface 72 1 0
    //   219: invokeinterface 86 1 0
    //   224: aload_0
    //   225: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramAbsOptions	CacheHelper.AbsOptions
    //   41	79	1	bool	boolean
    //   10	151	2	str	java.lang.String
    //   31	110	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   88	109	194	finally
    //   113	119	194	finally
    //   142	152	194	finally
    //   152	165	194	finally
    //   184	194	194	finally
    //   11	32	210	finally
    //   36	42	210	finally
    //   65	75	210	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.utils.CacheHelper
 * JD-Core Version:    0.7.0.1
 */