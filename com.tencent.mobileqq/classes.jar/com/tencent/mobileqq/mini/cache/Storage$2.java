package com.tencent.mobileqq.mini.cache;

class Storage$2
  implements Runnable
{
  Storage$2(Storage paramStorage, String paramString1, String paramString2, Storage.StorageCallback paramStorageCallback, String paramString3) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/mini/cache/Storage$2:val$data	Ljava/lang/String;
    //   4: aload_0
    //   5: getfield 22	com/tencent/mobileqq/mini/cache/Storage$2:val$type	Ljava/lang/String;
    //   8: invokestatic 41	com/tencent/mobileqq/mini/cache/Util:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +34 -> 47
    //   16: aload_1
    //   17: invokevirtual 47	java/lang/String:length	()I
    //   20: ldc 48
    //   22: if_icmple +25 -> 47
    //   25: aload_0
    //   26: getfield 24	com/tencent/mobileqq/mini/cache/Storage$2:val$callback	Lcom/tencent/mobileqq/mini/cache/Storage$StorageCallback;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +15 -> 46
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 26	com/tencent/mobileqq/mini/cache/Storage$2:val$key	Ljava/lang/String;
    //   39: ldc 50
    //   41: invokeinterface 56 3 0
    //   46: return
    //   47: aload_0
    //   48: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   51: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   54: ifnull +398 -> 452
    //   57: aload_1
    //   58: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifne +212 -> 273
    //   64: aload_0
    //   65: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   68: invokevirtual 72	com/tencent/mobileqq/mini/cache/Storage:getCurrentSize	()J
    //   71: ldc2_w 73
    //   74: lmul
    //   75: aload_1
    //   76: invokevirtual 47	java/lang/String:length	()I
    //   79: i2l
    //   80: ladd
    //   81: ldc2_w 75
    //   84: lcmp
    //   85: ifle +73 -> 158
    //   88: ldc 78
    //   90: iconst_1
    //   91: ldc 80
    //   93: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_0
    //   97: getfield 24	com/tencent/mobileqq/mini/cache/Storage$2:val$callback	Lcom/tencent/mobileqq/mini/cache/Storage$StorageCallback;
    //   100: ifnull +18 -> 118
    //   103: aload_0
    //   104: getfield 24	com/tencent/mobileqq/mini/cache/Storage$2:val$callback	Lcom/tencent/mobileqq/mini/cache/Storage$StorageCallback;
    //   107: aload_0
    //   108: getfield 26	com/tencent/mobileqq/mini/cache/Storage$2:val$key	Ljava/lang/String;
    //   111: ldc 80
    //   113: invokeinterface 56 3 0
    //   118: aload_0
    //   119: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   122: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   125: ifnull +32 -> 157
    //   128: aload_0
    //   129: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   132: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   135: invokevirtual 92	com/tencent/mobileqq/mini/cache/DiskLruCache:isClosed	()Z
    //   138: ifne +19 -> 157
    //   141: aload_0
    //   142: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   145: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   148: invokevirtual 95	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   151: return
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   157: return
    //   158: aload_0
    //   159: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   162: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   165: invokevirtual 92	com/tencent/mobileqq/mini/cache/DiskLruCache:isClosed	()Z
    //   168: ifeq +10 -> 178
    //   171: aload_0
    //   172: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   175: invokestatic 102	com/tencent/mobileqq/mini/cache/Storage:access$100	(Lcom/tencent/mobileqq/mini/cache/Storage;)V
    //   178: aload_0
    //   179: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   182: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   185: aload_0
    //   186: getfield 26	com/tencent/mobileqq/mini/cache/Storage$2:val$key	Ljava/lang/String;
    //   189: invokevirtual 106	com/tencent/mobileqq/mini/cache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache$Editor;
    //   192: astore_2
    //   193: aload_2
    //   194: ifnull +13 -> 207
    //   197: aload_2
    //   198: iconst_0
    //   199: aload_1
    //   200: invokevirtual 112	com/tencent/mobileqq/mini/cache/DiskLruCache$Editor:set	(ILjava/lang/String;)V
    //   203: aload_2
    //   204: invokevirtual 115	com/tencent/mobileqq/mini/cache/DiskLruCache$Editor:commit	()V
    //   207: aload_0
    //   208: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   211: invokestatic 119	com/tencent/mobileqq/mini/cache/Storage:access$200	(Lcom/tencent/mobileqq/mini/cache/Storage;)Landroid/support/v4/util/LruCache;
    //   214: ifnull +59 -> 273
    //   217: aload_0
    //   218: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   221: invokestatic 119	com/tencent/mobileqq/mini/cache/Storage:access$200	(Lcom/tencent/mobileqq/mini/cache/Storage;)Landroid/support/v4/util/LruCache;
    //   224: aload_0
    //   225: getfield 26	com/tencent/mobileqq/mini/cache/Storage$2:val$key	Ljava/lang/String;
    //   228: aload_1
    //   229: invokevirtual 125	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   232: pop
    //   233: invokestatic 129	com/tencent/mobileqq/mini/cache/Storage:access$300	()Ljava/util/concurrent/ConcurrentHashMap;
    //   236: astore_1
    //   237: aload_1
    //   238: monitorenter
    //   239: aload_0
    //   240: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   243: invokestatic 119	com/tencent/mobileqq/mini/cache/Storage:access$200	(Lcom/tencent/mobileqq/mini/cache/Storage;)Landroid/support/v4/util/LruCache;
    //   246: ldc 130
    //   248: invokestatic 129	com/tencent/mobileqq/mini/cache/Storage:access$300	()Ljava/util/concurrent/ConcurrentHashMap;
    //   251: invokevirtual 136	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   254: invokeinterface 141 1 0
    //   259: idiv
    //   260: invokevirtual 145	android/support/v4/util/LruCache:trimToSize	(I)V
    //   263: aload_1
    //   264: monitorexit
    //   265: goto +8 -> 273
    //   268: astore_2
    //   269: aload_1
    //   270: monitorexit
    //   271: aload_2
    //   272: athrow
    //   273: aload_0
    //   274: getfield 24	com/tencent/mobileqq/mini/cache/Storage$2:val$callback	Lcom/tencent/mobileqq/mini/cache/Storage$StorageCallback;
    //   277: ifnull +18 -> 295
    //   280: aload_0
    //   281: getfield 24	com/tencent/mobileqq/mini/cache/Storage$2:val$callback	Lcom/tencent/mobileqq/mini/cache/Storage$StorageCallback;
    //   284: aload_0
    //   285: getfield 26	com/tencent/mobileqq/mini/cache/Storage$2:val$key	Ljava/lang/String;
    //   288: ldc 147
    //   290: invokeinterface 150 3 0
    //   295: aload_0
    //   296: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   299: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   302: ifnull +179 -> 481
    //   305: aload_0
    //   306: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   309: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   312: invokevirtual 92	com/tencent/mobileqq/mini/cache/DiskLruCache:isClosed	()Z
    //   315: ifne +166 -> 481
    //   318: aload_0
    //   319: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   322: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   325: invokevirtual 95	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   328: return
    //   329: astore_1
    //   330: aload_1
    //   331: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   334: return
    //   335: astore_1
    //   336: goto +73 -> 409
    //   339: astore_1
    //   340: aload_0
    //   341: getfield 24	com/tencent/mobileqq/mini/cache/Storage$2:val$callback	Lcom/tencent/mobileqq/mini/cache/Storage$StorageCallback;
    //   344: ifnull +20 -> 364
    //   347: aload_0
    //   348: getfield 24	com/tencent/mobileqq/mini/cache/Storage$2:val$callback	Lcom/tencent/mobileqq/mini/cache/Storage$StorageCallback;
    //   351: aload_0
    //   352: getfield 26	com/tencent/mobileqq/mini/cache/Storage$2:val$key	Ljava/lang/String;
    //   355: aload_1
    //   356: invokevirtual 154	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   359: invokeinterface 56 3 0
    //   364: ldc 78
    //   366: iconst_1
    //   367: aload_1
    //   368: iconst_0
    //   369: anewarray 4	java/lang/Object
    //   372: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   375: aload_0
    //   376: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   379: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   382: ifnull +99 -> 481
    //   385: aload_0
    //   386: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   389: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   392: invokevirtual 92	com/tencent/mobileqq/mini/cache/DiskLruCache:isClosed	()Z
    //   395: ifne +86 -> 481
    //   398: aload_0
    //   399: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   402: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   405: invokevirtual 95	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   408: return
    //   409: aload_0
    //   410: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   413: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   416: ifnull +34 -> 450
    //   419: aload_0
    //   420: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   423: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   426: invokevirtual 92	com/tencent/mobileqq/mini/cache/DiskLruCache:isClosed	()Z
    //   429: ifne +21 -> 450
    //   432: aload_0
    //   433: getfield 18	com/tencent/mobileqq/mini/cache/Storage$2:this$0	Lcom/tencent/mobileqq/mini/cache/Storage;
    //   436: invokestatic 62	com/tencent/mobileqq/mini/cache/Storage:access$000	(Lcom/tencent/mobileqq/mini/cache/Storage;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   439: invokevirtual 95	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   442: goto +8 -> 450
    //   445: astore_2
    //   446: aload_2
    //   447: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   450: aload_1
    //   451: athrow
    //   452: ldc 159
    //   454: iconst_1
    //   455: ldc 161
    //   457: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: aload_0
    //   461: getfield 24	com/tencent/mobileqq/mini/cache/Storage$2:val$callback	Lcom/tencent/mobileqq/mini/cache/Storage$StorageCallback;
    //   464: astore_1
    //   465: aload_1
    //   466: ifnull +15 -> 481
    //   469: aload_1
    //   470: aload_0
    //   471: getfield 26	com/tencent/mobileqq/mini/cache/Storage$2:val$key	Ljava/lang/String;
    //   474: ldc 163
    //   476: invokeinterface 56 3 0
    //   481: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	2
    //   11	65	1	localObject1	Object
    //   152	77	1	localIOException1	java.io.IOException
    //   329	2	1	localIOException2	java.io.IOException
    //   335	1	1	localObject2	Object
    //   339	112	1	localThrowable	java.lang.Throwable
    //   464	6	1	localStorageCallback	Storage.StorageCallback
    //   192	12	2	localEditor	DiskLruCache.Editor
    //   268	4	2	localObject3	Object
    //   445	2	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   141	151	152	java/io/IOException
    //   239	265	268	finally
    //   269	271	268	finally
    //   318	328	329	java/io/IOException
    //   398	408	329	java/io/IOException
    //   57	118	335	finally
    //   158	178	335	finally
    //   178	193	335	finally
    //   197	207	335	finally
    //   207	239	335	finally
    //   271	273	335	finally
    //   273	295	335	finally
    //   340	364	335	finally
    //   364	375	335	finally
    //   57	118	339	java/lang/Throwable
    //   158	178	339	java/lang/Throwable
    //   178	193	339	java/lang/Throwable
    //   197	207	339	java/lang/Throwable
    //   207	239	339	java/lang/Throwable
    //   271	273	339	java/lang/Throwable
    //   273	295	339	java/lang/Throwable
    //   432	442	445	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.Storage.2
 * JD-Core Version:    0.7.0.1
 */