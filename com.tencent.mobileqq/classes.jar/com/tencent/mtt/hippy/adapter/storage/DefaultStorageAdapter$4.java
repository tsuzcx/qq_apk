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
    //   116: astore_2
    //   117: aload_0
    //   118: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$4:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   121: aload_2
    //   122: invokevirtual 88	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   125: invokeinterface 45 2 0
    //   130: return
    //   131: astore_3
    //   132: aload_0
    //   133: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$4:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   136: aload_3
    //   137: invokevirtual 89	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: invokeinterface 45 2 0
    //   145: aload_2
    //   146: invokeinterface 81 1 0
    //   151: return
    //   152: astore_3
    //   153: aload_2
    //   154: invokeinterface 81 1 0
    //   159: aload_3
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	4
    //   94	2	1	bool	boolean
    //   12	88	2	localObject1	Object
    //   116	38	2	localThrowable	java.lang.Throwable
    //   36	74	3	localHippyArray	com.tencent.mtt.hippy.common.HippyArray
    //   131	6	3	localException	java.lang.Exception
    //   152	8	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	13	116	java/lang/Throwable
    //   17	28	116	java/lang/Throwable
    //   29	68	116	java/lang/Throwable
    //   99	115	116	java/lang/Throwable
    //   145	151	116	java/lang/Throwable
    //   153	161	116	java/lang/Throwable
    //   68	77	131	java/lang/Exception
    //   77	95	131	java/lang/Exception
    //   68	77	152	finally
    //   77	95	152	finally
    //   132	145	152	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.4
 * JD-Core Version:    0.7.0.1
 */