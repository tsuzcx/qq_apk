package com.tencent.mtt.hippy.adapter.storage;

class DefaultStorageAdapter$4
  implements Runnable
{
  DefaultStorageAdapter$4(DefaultStorageAdapter paramDefaultStorageAdapter, HippyStorageAdapter.Callback paramCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$4:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   4: invokestatic 31	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   7: invokeinterface 37 1 0
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +15 -> 29
    //   17: aload_0
    //   18: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$4:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   21: ldc 39
    //   23: invokeinterface 45 2 0
    //   28: return
    //   29: new 47	com/tencent/mtt/hippy/common/HippyArray
    //   32: dup
    //   33: invokespecial 48	com/tencent/mtt/hippy/common/HippyArray:<init>	()V
    //   36: astore_3
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 14	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$4:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   42: invokestatic 31	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   45: invokeinterface 52 1 0
    //   50: iconst_1
    //   51: anewarray 54	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc 56
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 62	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_2
    //   68: aload_2
    //   69: invokeinterface 68 1 0
    //   74: ifeq +25 -> 99
    //   77: aload_3
    //   78: aload_2
    //   79: iconst_0
    //   80: invokeinterface 72 2 0
    //   85: invokevirtual 75	com/tencent/mtt/hippy/common/HippyArray:pushString	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokeinterface 78 1 0
    //   94: istore_1
    //   95: iload_1
    //   96: ifne -19 -> 77
    //   99: aload_2
    //   100: invokeinterface 81 1 0
    //   105: aload_0
    //   106: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$4:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   109: aload_3
    //   110: invokeinterface 85 2 0
    //   115: return
    //   116: astore_3
    //   117: goto +24 -> 141
    //   120: astore_3
    //   121: aload_0
    //   122: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$4:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   125: aload_3
    //   126: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokeinterface 45 2 0
    //   134: aload_2
    //   135: invokeinterface 81 1 0
    //   140: return
    //   141: aload_2
    //   142: invokeinterface 81 1 0
    //   147: aload_3
    //   148: athrow
    //   149: astore_2
    //   150: aload_0
    //   151: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$4:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   154: aload_2
    //   155: invokevirtual 89	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   158: invokeinterface 45 2 0
    //   163: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	4
    //   94	2	1	bool	boolean
    //   12	130	2	localObject1	Object
    //   149	6	2	localThrowable	java.lang.Throwable
    //   36	74	3	localHippyArray	com.tencent.mtt.hippy.common.HippyArray
    //   116	1	3	localObject2	Object
    //   120	28	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   68	77	116	finally
    //   77	95	116	finally
    //   121	134	116	finally
    //   68	77	120	java/lang/Exception
    //   77	95	120	java/lang/Exception
    //   0	13	149	java/lang/Throwable
    //   17	28	149	java/lang/Throwable
    //   29	68	149	java/lang/Throwable
    //   99	115	149	java/lang/Throwable
    //   134	140	149	java/lang/Throwable
    //   141	149	149	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.4
 * JD-Core Version:    0.7.0.1
 */