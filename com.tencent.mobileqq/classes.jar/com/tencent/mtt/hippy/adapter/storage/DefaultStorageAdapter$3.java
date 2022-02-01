package com.tencent.mtt.hippy.adapter.storage;

import com.tencent.mtt.hippy.common.HippyArray;

class DefaultStorageAdapter$3
  implements Runnable
{
  DefaultStorageAdapter$3(DefaultStorageAdapter paramDefaultStorageAdapter, HippyStorageAdapter.Callback paramCallback, HippyArray paramHippyArray) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$3:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   4: invokestatic 33	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   7: invokeinterface 39 1 0
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +15 -> 29
    //   17: aload_0
    //   18: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$3:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   21: ldc 41
    //   23: invokeinterface 47 2 0
    //   28: return
    //   29: aload_3
    //   30: invokevirtual 52	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   33: iconst_0
    //   34: istore_1
    //   35: iload_1
    //   36: aload_0
    //   37: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$3:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   40: invokevirtual 58	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   43: if_icmpge +58 -> 101
    //   46: aload_0
    //   47: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$3:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   50: invokevirtual 58	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   53: iload_1
    //   54: isub
    //   55: sipush 999
    //   58: invokestatic 64	java/lang/Math:min	(II)I
    //   61: istore_2
    //   62: aload_3
    //   63: aload_0
    //   64: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$3:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   67: invokestatic 33	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   70: invokeinterface 68 1 0
    //   75: iload_2
    //   76: invokestatic 72	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:buildKeySelection	(I)Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$3:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   83: iload_1
    //   84: iload_2
    //   85: invokestatic 76	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:buildKeySelectionArgs	(Lcom/tencent/mtt/hippy/common/HippyArray;II)[Ljava/lang/String;
    //   88: invokevirtual 80	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   91: pop
    //   92: iload_1
    //   93: sipush 999
    //   96: iadd
    //   97: istore_1
    //   98: goto -63 -> 35
    //   101: aload_3
    //   102: invokevirtual 83	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   105: aload_0
    //   106: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$3:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   109: aconst_null
    //   110: invokeinterface 87 2 0
    //   115: aload_3
    //   116: invokevirtual 90	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   119: return
    //   120: astore 4
    //   122: goto +22 -> 144
    //   125: astore 4
    //   127: aload_0
    //   128: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$3:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   131: aload 4
    //   133: invokevirtual 93	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   136: invokeinterface 47 2 0
    //   141: goto -26 -> 115
    //   144: aload_3
    //   145: invokevirtual 90	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   148: aload 4
    //   150: athrow
    //   151: astore_3
    //   152: aload_0
    //   153: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$3:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   156: aload_3
    //   157: invokevirtual 93	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   160: invokeinterface 47 2 0
    //   165: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	3
    //   34	64	1	i	int
    //   61	24	2	j	int
    //   12	133	3	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   151	6	3	localThrowable1	java.lang.Throwable
    //   120	1	4	localObject	Object
    //   125	24	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   29	33	120	finally
    //   35	92	120	finally
    //   101	115	120	finally
    //   127	141	120	finally
    //   29	33	125	java/lang/Throwable
    //   35	92	125	java/lang/Throwable
    //   101	115	125	java/lang/Throwable
    //   0	13	151	java/lang/Throwable
    //   17	28	151	java/lang/Throwable
    //   115	119	151	java/lang/Throwable
    //   144	151	151	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.3
 * JD-Core Version:    0.7.0.1
 */