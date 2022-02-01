package com.tencent.mtt.hippy.adapter.storage;

import java.util.List;

class DefaultStorageAdapter$2
  implements Runnable
{
  DefaultStorageAdapter$2(DefaultStorageAdapter paramDefaultStorageAdapter, HippyStorageAdapter.Callback paramCallback, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   4: invokestatic 33	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   7: invokeinterface 39 1 0
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +15 -> 29
    //   17: aload_0
    //   18: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   21: ldc 41
    //   23: invokeinterface 47 2 0
    //   28: return
    //   29: aload_1
    //   30: new 49	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   37: ldc 52
    //   39: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   46: invokestatic 33	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   49: invokeinterface 60 1 0
    //   54: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 62
    //   59: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 71	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual 74	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   73: aload_0
    //   74: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:val$keyValues	Ljava/util/List;
    //   77: invokeinterface 80 1 0
    //   82: astore_3
    //   83: aload_3
    //   84: invokeinterface 86 1 0
    //   89: ifeq +79 -> 168
    //   92: aload_3
    //   93: invokeinterface 90 1 0
    //   98: checkcast 92	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue
    //   101: astore 4
    //   103: aload_2
    //   104: invokevirtual 97	android/database/sqlite/SQLiteStatement:clearBindings	()V
    //   107: aload_2
    //   108: iconst_1
    //   109: aload 4
    //   111: getfield 101	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   114: invokevirtual 105	android/database/sqlite/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   117: aload_2
    //   118: iconst_2
    //   119: aload 4
    //   121: getfield 108	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:value	Ljava/lang/String;
    //   124: invokevirtual 105	android/database/sqlite/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   127: aload_2
    //   128: invokevirtual 111	android/database/sqlite/SQLiteStatement:execute	()V
    //   131: goto -48 -> 83
    //   134: astore_2
    //   135: aload_0
    //   136: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   139: aload_2
    //   140: invokevirtual 114	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   143: invokeinterface 47 2 0
    //   148: aload_1
    //   149: invokevirtual 117	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   152: return
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   158: aload_1
    //   159: invokevirtual 114	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   162: invokeinterface 47 2 0
    //   167: return
    //   168: aload_1
    //   169: invokevirtual 120	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   172: aload_0
    //   173: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   176: aconst_null
    //   177: invokeinterface 124 2 0
    //   182: aload_1
    //   183: invokevirtual 117	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   186: return
    //   187: astore_2
    //   188: aload_1
    //   189: invokevirtual 117	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   192: aload_2
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	2
    //   12	137	1	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   153	36	1	localThrowable1	java.lang.Throwable
    //   68	60	2	localSQLiteStatement	android.database.sqlite.SQLiteStatement
    //   134	6	2	localThrowable2	java.lang.Throwable
    //   187	6	2	localObject	Object
    //   82	11	3	localIterator	java.util.Iterator
    //   101	19	4	localHippyStorageKeyValue	HippyStorageKeyValue
    // Exception table:
    //   from	to	target	type
    //   69	83	134	java/lang/Throwable
    //   83	131	134	java/lang/Throwable
    //   168	182	134	java/lang/Throwable
    //   0	13	153	java/lang/Throwable
    //   17	28	153	java/lang/Throwable
    //   29	69	153	java/lang/Throwable
    //   148	152	153	java/lang/Throwable
    //   182	186	153	java/lang/Throwable
    //   188	194	153	java/lang/Throwable
    //   69	83	187	finally
    //   83	131	187	finally
    //   135	148	187	finally
    //   168	182	187	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.2
 * JD-Core Version:    0.7.0.1
 */