package com.tencent.mtt.hippy.adapter.storage;

import com.tencent.mtt.hippy.common.HippyArray;

class DefaultStorageAdapter$1
  implements Runnable
{
  DefaultStorageAdapter$1(DefaultStorageAdapter paramDefaultStorageAdapter, HippyStorageAdapter.Callback paramCallback, HippyArray paramHippyArray) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   4: invokestatic 33	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   7: invokeinterface 39 1 0
    //   12: astore 6
    //   14: aload 6
    //   16: ifnonnull +15 -> 31
    //   19: aload_0
    //   20: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   23: ldc 41
    //   25: invokeinterface 47 2 0
    //   30: return
    //   31: iconst_0
    //   32: istore_3
    //   33: new 49	java/util/HashSet
    //   36: dup
    //   37: invokespecial 50	java/util/HashSet:<init>	()V
    //   40: astore 7
    //   42: new 52	java/util/HashMap
    //   45: dup
    //   46: invokespecial 53	java/util/HashMap:<init>	()V
    //   49: astore 8
    //   51: new 55	java/util/ArrayList
    //   54: dup
    //   55: invokespecial 56	java/util/ArrayList:<init>	()V
    //   58: astore 9
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_1
    //   63: aload_0
    //   64: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   67: invokevirtual 62	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   70: if_icmpge +350 -> 420
    //   73: aload_0
    //   74: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   77: invokevirtual 62	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   80: iload_1
    //   81: isub
    //   82: sipush 999
    //   85: invokestatic 68	java/lang/Math:min	(II)I
    //   88: istore 4
    //   90: aload_0
    //   91: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   94: invokestatic 33	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   97: invokeinterface 72 1 0
    //   102: astore 10
    //   104: iload 4
    //   106: invokestatic 76	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:buildKeySelection	(I)Ljava/lang/String;
    //   109: astore 11
    //   111: aload_0
    //   112: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   115: iload_1
    //   116: iload 4
    //   118: invokestatic 80	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:buildKeySelectionArgs	(Lcom/tencent/mtt/hippy/common/HippyArray;II)[Ljava/lang/String;
    //   121: astore 12
    //   123: aload 6
    //   125: aload 10
    //   127: iconst_2
    //   128: anewarray 82	java/lang/String
    //   131: dup
    //   132: iconst_0
    //   133: ldc 84
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: ldc 86
    //   140: aastore
    //   141: aload 11
    //   143: aload 12
    //   145: aconst_null
    //   146: aconst_null
    //   147: aconst_null
    //   148: invokevirtual 92	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   151: astore 10
    //   153: aload 7
    //   155: invokevirtual 95	java/util/HashSet:clear	()V
    //   158: aload 10
    //   160: invokeinterface 100 1 0
    //   165: aload_0
    //   166: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   169: invokevirtual 62	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   172: if_icmpeq +34 -> 206
    //   175: iload_1
    //   176: istore_2
    //   177: iload_2
    //   178: iload_1
    //   179: iload 4
    //   181: iadd
    //   182: if_icmpge +24 -> 206
    //   185: aload 7
    //   187: aload_0
    //   188: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   191: iload_2
    //   192: invokevirtual 103	com/tencent/mtt/hippy/common/HippyArray:getString	(I)Ljava/lang/String;
    //   195: invokevirtual 107	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   198: pop
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: istore_2
    //   203: goto -26 -> 177
    //   206: aload 10
    //   208: invokeinterface 111 1 0
    //   213: ifeq +79 -> 292
    //   216: new 113	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue
    //   219: dup
    //   220: invokespecial 114	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:<init>	()V
    //   223: astore 11
    //   225: aload 11
    //   227: aload 10
    //   229: iconst_0
    //   230: invokeinterface 115 2 0
    //   235: putfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   238: aload 11
    //   240: aload 10
    //   242: iconst_1
    //   243: invokeinterface 115 2 0
    //   248: putfield 120	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:value	Ljava/lang/String;
    //   251: aload 8
    //   253: aload 11
    //   255: getfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   258: aload 11
    //   260: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   263: pop
    //   264: aload 7
    //   266: aload 11
    //   268: getfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   271: invokevirtual 127	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   274: pop
    //   275: aload 10
    //   277: invokeinterface 130 1 0
    //   282: istore 5
    //   284: iload 5
    //   286: ifne -70 -> 216
    //   289: goto +3 -> 292
    //   292: aload 10
    //   294: invokeinterface 133 1 0
    //   299: aload 7
    //   301: invokevirtual 137	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   304: astore 10
    //   306: aload 10
    //   308: invokeinterface 142 1 0
    //   313: ifeq +54 -> 367
    //   316: aload 10
    //   318: invokeinterface 146 1 0
    //   323: checkcast 82	java/lang/String
    //   326: astore 11
    //   328: new 113	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue
    //   331: dup
    //   332: invokespecial 114	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:<init>	()V
    //   335: astore 12
    //   337: aload 12
    //   339: aload 11
    //   341: putfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   344: aload 12
    //   346: ldc 148
    //   348: putfield 120	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:value	Ljava/lang/String;
    //   351: aload 8
    //   353: aload 12
    //   355: getfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   358: aload 12
    //   360: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: goto -58 -> 306
    //   367: aload 7
    //   369: invokevirtual 95	java/util/HashSet:clear	()V
    //   372: iload_1
    //   373: sipush 999
    //   376: iadd
    //   377: istore_1
    //   378: goto -316 -> 62
    //   381: astore 6
    //   383: goto +27 -> 410
    //   386: astore 6
    //   388: aload_0
    //   389: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   392: aload 6
    //   394: invokevirtual 151	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   397: invokeinterface 47 2 0
    //   402: aload 10
    //   404: invokeinterface 133 1 0
    //   409: return
    //   410: aload 10
    //   412: invokeinterface 133 1 0
    //   417: aload 6
    //   419: athrow
    //   420: aload_0
    //   421: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   424: invokevirtual 62	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   427: istore_2
    //   428: iload_3
    //   429: istore_1
    //   430: iload_1
    //   431: iload_2
    //   432: if_icmpge +29 -> 461
    //   435: aload 9
    //   437: aload 8
    //   439: aload_0
    //   440: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   443: iload_1
    //   444: invokevirtual 103	com/tencent/mtt/hippy/common/HippyArray:getString	(I)Ljava/lang/String;
    //   447: invokevirtual 155	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   450: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   453: pop
    //   454: iload_1
    //   455: iconst_1
    //   456: iadd
    //   457: istore_1
    //   458: goto -28 -> 430
    //   461: aload 8
    //   463: invokevirtual 157	java/util/HashMap:clear	()V
    //   466: aload_0
    //   467: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   470: aload 9
    //   472: invokeinterface 161 2 0
    //   477: return
    //   478: astore 6
    //   480: aload_0
    //   481: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   484: aload 6
    //   486: invokevirtual 151	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   489: invokeinterface 47 2 0
    //   494: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	this	1
    //   61	397	1	i	int
    //   176	257	2	j	int
    //   32	397	3	k	int
    //   88	94	4	m	int
    //   282	3	5	bool	boolean
    //   12	112	6	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   381	1	6	localObject1	Object
    //   386	32	6	localThrowable1	java.lang.Throwable
    //   478	7	6	localThrowable2	java.lang.Throwable
    //   40	328	7	localHashSet	java.util.HashSet
    //   49	413	8	localHashMap	java.util.HashMap
    //   58	413	9	localArrayList	java.util.ArrayList
    //   102	309	10	localObject2	Object
    //   109	231	11	localObject3	Object
    //   121	238	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   158	175	381	finally
    //   185	199	381	finally
    //   206	216	381	finally
    //   216	284	381	finally
    //   388	402	381	finally
    //   158	175	386	java/lang/Throwable
    //   185	199	386	java/lang/Throwable
    //   206	216	386	java/lang/Throwable
    //   216	284	386	java/lang/Throwable
    //   0	14	478	java/lang/Throwable
    //   19	30	478	java/lang/Throwable
    //   33	60	478	java/lang/Throwable
    //   62	158	478	java/lang/Throwable
    //   292	306	478	java/lang/Throwable
    //   306	364	478	java/lang/Throwable
    //   367	372	478	java/lang/Throwable
    //   402	409	478	java/lang/Throwable
    //   410	420	478	java/lang/Throwable
    //   420	428	478	java/lang/Throwable
    //   435	454	478	java/lang/Throwable
    //   461	477	478	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.1
 * JD-Core Version:    0.7.0.1
 */