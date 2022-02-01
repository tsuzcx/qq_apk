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
    //   29: new 49	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: ldc 52
    //   40: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   49: invokestatic 33	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   52: invokeinterface 60 1 0
    //   57: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_2
    //   62: ldc 62
    //   64: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 71	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   76: astore_2
    //   77: aload_1
    //   78: invokevirtual 74	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   81: aload_0
    //   82: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:val$keyValues	Ljava/util/List;
    //   85: invokeinterface 80 1 0
    //   90: astore_3
    //   91: aload_3
    //   92: invokeinterface 86 1 0
    //   97: ifeq +45 -> 142
    //   100: aload_3
    //   101: invokeinterface 90 1 0
    //   106: checkcast 92	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue
    //   109: astore 4
    //   111: aload_2
    //   112: invokevirtual 97	android/database/sqlite/SQLiteStatement:clearBindings	()V
    //   115: aload_2
    //   116: iconst_1
    //   117: aload 4
    //   119: getfield 101	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   122: invokevirtual 105	android/database/sqlite/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   125: aload_2
    //   126: iconst_2
    //   127: aload 4
    //   129: getfield 108	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:value	Ljava/lang/String;
    //   132: invokevirtual 105	android/database/sqlite/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   135: aload_2
    //   136: invokevirtual 111	android/database/sqlite/SQLiteStatement:execute	()V
    //   139: goto -48 -> 91
    //   142: aload_1
    //   143: invokevirtual 114	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   146: aload_0
    //   147: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   150: aconst_null
    //   151: invokeinterface 118 2 0
    //   156: aload_1
    //   157: invokevirtual 121	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   160: return
    //   161: astore_2
    //   162: goto +20 -> 182
    //   165: astore_2
    //   166: aload_0
    //   167: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   170: aload_2
    //   171: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   174: invokeinterface 47 2 0
    //   179: goto -23 -> 156
    //   182: aload_1
    //   183: invokevirtual 121	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   186: aload_2
    //   187: athrow
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$2:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   193: aload_1
    //   194: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   197: invokeinterface 47 2 0
    //   202: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	2
    //   12	171	1	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   188	6	1	localThrowable1	java.lang.Throwable
    //   36	100	2	localObject1	Object
    //   161	1	2	localObject2	Object
    //   165	22	2	localThrowable2	java.lang.Throwable
    //   90	11	3	localIterator	java.util.Iterator
    //   109	19	4	localHippyStorageKeyValue	HippyStorageKeyValue
    // Exception table:
    //   from	to	target	type
    //   77	91	161	finally
    //   91	139	161	finally
    //   142	156	161	finally
    //   166	179	161	finally
    //   77	91	165	java/lang/Throwable
    //   91	139	165	java/lang/Throwable
    //   142	156	165	java/lang/Throwable
    //   0	13	188	java/lang/Throwable
    //   17	28	188	java/lang/Throwable
    //   29	77	188	java/lang/Throwable
    //   156	160	188	java/lang/Throwable
    //   182	188	188	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.2
 * JD-Core Version:    0.7.0.1
 */