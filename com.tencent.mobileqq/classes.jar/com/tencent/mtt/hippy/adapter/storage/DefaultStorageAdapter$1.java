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
    //   12: astore 5
    //   14: aload 5
    //   16: ifnonnull +15 -> 31
    //   19: aload_0
    //   20: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   23: ldc 41
    //   25: invokeinterface 47 2 0
    //   30: return
    //   31: new 49	java/util/HashSet
    //   34: dup
    //   35: invokespecial 50	java/util/HashSet:<init>	()V
    //   38: astore 6
    //   40: new 52	java/util/HashMap
    //   43: dup
    //   44: invokespecial 53	java/util/HashMap:<init>	()V
    //   47: astore 7
    //   49: new 55	java/util/ArrayList
    //   52: dup
    //   53: invokespecial 56	java/util/ArrayList:<init>	()V
    //   56: astore 8
    //   58: iconst_0
    //   59: istore_1
    //   60: iload_1
    //   61: aload_0
    //   62: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   65: invokevirtual 62	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   68: if_icmpge +357 -> 425
    //   71: aload_0
    //   72: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   75: invokevirtual 62	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   78: iload_1
    //   79: isub
    //   80: sipush 999
    //   83: invokestatic 68	java/lang/Math:min	(II)I
    //   86: istore_3
    //   87: aload_0
    //   88: getfield 16	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:this$0	Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;
    //   91: invokestatic 33	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:access$000	(Lcom/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter;)Lcom/tencent/mtt/hippy/adapter/storage/IHippySQLiteHelper;
    //   94: invokeinterface 72 1 0
    //   99: astore 9
    //   101: iload_3
    //   102: invokestatic 76	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:buildKeySelection	(I)Ljava/lang/String;
    //   105: astore 10
    //   107: aload_0
    //   108: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   111: iload_1
    //   112: iload_3
    //   113: invokestatic 80	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter:buildKeySelectionArgs	(Lcom/tencent/mtt/hippy/common/HippyArray;II)[Ljava/lang/String;
    //   116: astore 11
    //   118: aload 5
    //   120: aload 9
    //   122: iconst_2
    //   123: anewarray 82	java/lang/String
    //   126: dup
    //   127: iconst_0
    //   128: ldc 84
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: ldc 86
    //   135: aastore
    //   136: aload 10
    //   138: aload 11
    //   140: aconst_null
    //   141: aconst_null
    //   142: aconst_null
    //   143: invokevirtual 92	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   146: astore 9
    //   148: aload 6
    //   150: invokevirtual 95	java/util/HashSet:clear	()V
    //   153: aload 9
    //   155: invokeinterface 100 1 0
    //   160: aload_0
    //   161: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   164: invokevirtual 62	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   167: if_icmpeq +33 -> 200
    //   170: iload_1
    //   171: istore_2
    //   172: iload_2
    //   173: iload_1
    //   174: iload_3
    //   175: iadd
    //   176: if_icmpge +24 -> 200
    //   179: aload 6
    //   181: aload_0
    //   182: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   185: iload_2
    //   186: invokevirtual 103	com/tencent/mtt/hippy/common/HippyArray:getString	(I)Ljava/lang/String;
    //   189: invokevirtual 107	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   192: pop
    //   193: iload_2
    //   194: iconst_1
    //   195: iadd
    //   196: istore_2
    //   197: goto -25 -> 172
    //   200: aload 9
    //   202: invokeinterface 111 1 0
    //   207: ifeq +76 -> 283
    //   210: new 113	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue
    //   213: dup
    //   214: invokespecial 114	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:<init>	()V
    //   217: astore 10
    //   219: aload 10
    //   221: aload 9
    //   223: iconst_0
    //   224: invokeinterface 115 2 0
    //   229: putfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   232: aload 10
    //   234: aload 9
    //   236: iconst_1
    //   237: invokeinterface 115 2 0
    //   242: putfield 120	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:value	Ljava/lang/String;
    //   245: aload 7
    //   247: aload 10
    //   249: getfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   252: aload 10
    //   254: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: pop
    //   258: aload 6
    //   260: aload 10
    //   262: getfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   265: invokevirtual 127	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   268: pop
    //   269: aload 9
    //   271: invokeinterface 130 1 0
    //   276: istore 4
    //   278: iload 4
    //   280: ifne -70 -> 210
    //   283: aload 9
    //   285: invokeinterface 133 1 0
    //   290: aload 6
    //   292: invokevirtual 137	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   295: astore 9
    //   297: aload 9
    //   299: invokeinterface 142 1 0
    //   304: ifeq +107 -> 411
    //   307: aload 9
    //   309: invokeinterface 146 1 0
    //   314: checkcast 82	java/lang/String
    //   317: astore 10
    //   319: new 113	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue
    //   322: dup
    //   323: invokespecial 114	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:<init>	()V
    //   326: astore 11
    //   328: aload 11
    //   330: aload 10
    //   332: putfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   335: aload 11
    //   337: ldc 148
    //   339: putfield 120	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:value	Ljava/lang/String;
    //   342: aload 7
    //   344: aload 11
    //   346: getfield 118	com/tencent/mtt/hippy/adapter/storage/HippyStorageKeyValue:key	Ljava/lang/String;
    //   349: aload 11
    //   351: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   354: pop
    //   355: goto -58 -> 297
    //   358: astore 5
    //   360: aload_0
    //   361: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   364: aload 5
    //   366: invokevirtual 151	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   369: invokeinterface 47 2 0
    //   374: return
    //   375: astore 5
    //   377: aload_0
    //   378: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   381: aload 5
    //   383: invokevirtual 151	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   386: invokeinterface 47 2 0
    //   391: aload 9
    //   393: invokeinterface 133 1 0
    //   398: return
    //   399: astore 5
    //   401: aload 9
    //   403: invokeinterface 133 1 0
    //   408: aload 5
    //   410: athrow
    //   411: aload 6
    //   413: invokevirtual 95	java/util/HashSet:clear	()V
    //   416: iload_1
    //   417: sipush 999
    //   420: iadd
    //   421: istore_1
    //   422: goto -362 -> 60
    //   425: aload_0
    //   426: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   429: invokevirtual 62	com/tencent/mtt/hippy/common/HippyArray:size	()I
    //   432: istore_2
    //   433: iconst_0
    //   434: istore_1
    //   435: iload_1
    //   436: iload_2
    //   437: if_icmpge +29 -> 466
    //   440: aload 8
    //   442: aload 7
    //   444: aload_0
    //   445: getfield 20	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$keys	Lcom/tencent/mtt/hippy/common/HippyArray;
    //   448: iload_1
    //   449: invokevirtual 103	com/tencent/mtt/hippy/common/HippyArray:getString	(I)Ljava/lang/String;
    //   452: invokevirtual 155	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   455: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   458: pop
    //   459: iload_1
    //   460: iconst_1
    //   461: iadd
    //   462: istore_1
    //   463: goto -28 -> 435
    //   466: aload 7
    //   468: invokevirtual 157	java/util/HashMap:clear	()V
    //   471: aload_0
    //   472: getfield 18	com/tencent/mtt/hippy/adapter/storage/DefaultStorageAdapter$1:val$callback	Lcom/tencent/mtt/hippy/adapter/storage/HippyStorageAdapter$Callback;
    //   475: aload 8
    //   477: invokeinterface 161 2 0
    //   482: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	1
    //   59	404	1	i	int
    //   171	267	2	j	int
    //   86	90	3	k	int
    //   276	3	4	bool	boolean
    //   12	107	5	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   358	7	5	localThrowable1	java.lang.Throwable
    //   375	7	5	localThrowable2	java.lang.Throwable
    //   399	10	5	localObject1	Object
    //   38	374	6	localHashSet	java.util.HashSet
    //   47	420	7	localHashMap	java.util.HashMap
    //   56	420	8	localArrayList	java.util.ArrayList
    //   99	303	9	localObject2	Object
    //   105	226	10	localObject3	Object
    //   116	234	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	14	358	java/lang/Throwable
    //   19	30	358	java/lang/Throwable
    //   31	58	358	java/lang/Throwable
    //   60	153	358	java/lang/Throwable
    //   283	297	358	java/lang/Throwable
    //   297	355	358	java/lang/Throwable
    //   391	398	358	java/lang/Throwable
    //   401	411	358	java/lang/Throwable
    //   411	416	358	java/lang/Throwable
    //   425	433	358	java/lang/Throwable
    //   440	459	358	java/lang/Throwable
    //   466	482	358	java/lang/Throwable
    //   153	170	375	java/lang/Throwable
    //   179	193	375	java/lang/Throwable
    //   200	210	375	java/lang/Throwable
    //   210	278	375	java/lang/Throwable
    //   153	170	399	finally
    //   179	193	399	finally
    //   200	210	399	finally
    //   210	278	399	finally
    //   377	391	399	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.1
 * JD-Core Version:    0.7.0.1
 */