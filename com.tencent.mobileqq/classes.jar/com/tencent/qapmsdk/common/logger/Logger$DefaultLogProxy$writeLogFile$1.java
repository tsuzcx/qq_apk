package com.tencent.qapmsdk.common.logger;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
final class Logger$DefaultLogProxy$writeLogFile$1
  implements Runnable
{
  Logger$DefaultLogProxy$writeLogFile$1(Logger.DefaultLogProxy paramDefaultLogProxy) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   13: invokestatic 40	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getFlushing$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +7 -> 25
    //   21: aload 7
    //   23: monitorexit
    //   24: return
    //   25: invokestatic 46	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   28: astore 5
    //   30: aload 5
    //   32: ifnonnull +6 -> 38
    //   35: goto +52 -> 87
    //   38: aload 5
    //   40: invokevirtual 52	java/lang/String:hashCode	()I
    //   43: istore_1
    //   44: iload_1
    //   45: ldc 53
    //   47: if_icmpeq +23 -> 70
    //   50: iload_1
    //   51: ldc 54
    //   53: if_icmpeq +6 -> 59
    //   56: goto +31 -> 87
    //   59: aload 5
    //   61: ldc 56
    //   63: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: pop
    //   67: goto +20 -> 87
    //   70: aload 5
    //   72: ldc 62
    //   74: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: istore_2
    //   78: iload_2
    //   79: ifeq +8 -> 87
    //   82: iconst_1
    //   83: istore_1
    //   84: goto +36 -> 120
    //   87: iconst_0
    //   88: istore_1
    //   89: goto +31 -> 120
    //   92: astore 5
    //   94: aload 5
    //   96: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   99: astore 5
    //   101: aload 5
    //   103: ifnull +526 -> 629
    //   106: goto +3 -> 109
    //   109: ldc 67
    //   111: aload 5
    //   113: invokestatic 73	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: goto -30 -> 87
    //   120: iload_1
    //   121: ifne +27 -> 148
    //   124: aload_0
    //   125: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   128: invokestatic 77	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getWriterQueue$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)Ljava/util/concurrent/BlockingQueue;
    //   131: invokeinterface 82 1 0
    //   136: ldc 67
    //   138: ldc 84
    //   140: invokestatic 73	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   143: pop
    //   144: aload 7
    //   146: monitorexit
    //   147: return
    //   148: new 86	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   155: astore 5
    //   157: aload 5
    //   159: getstatic 93	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   162: invokevirtual 98	com/tencent/qapmsdk/common/util/FileUtil$Companion:getRootPath	()Ljava/lang/String;
    //   165: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 5
    //   171: ldc 104
    //   173: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: new 106	java/io/File
    //   180: dup
    //   181: aload 5
    //   183: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   189: astore 5
    //   191: aload 5
    //   193: invokevirtual 116	java/io/File:exists	()Z
    //   196: ifne +9 -> 205
    //   199: aload 5
    //   201: invokevirtual 119	java/io/File:mkdirs	()Z
    //   204: pop
    //   205: aload_0
    //   206: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   209: iconst_1
    //   210: invokestatic 123	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$setFlushing$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;Z)V
    //   213: aload_0
    //   214: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   217: invokestatic 77	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getWriterQueue$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)Ljava/util/concurrent/BlockingQueue;
    //   220: invokeinterface 127 1 0
    //   225: checkcast 48	java/lang/String
    //   228: astore 6
    //   230: aload 6
    //   232: ifnull +48 -> 280
    //   235: aload_0
    //   236: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   239: invokestatic 131	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getSb$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)Ljava/lang/StringBuffer;
    //   242: astore 8
    //   244: new 86	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   251: astore 9
    //   253: aload 9
    //   255: aload 6
    //   257: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 9
    //   263: ldc 133
    //   265: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 8
    //   271: aload 9
    //   273: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   279: pop
    //   280: aload 6
    //   282: ifnonnull -69 -> 213
    //   285: aload_0
    //   286: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   289: invokestatic 131	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getSb$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)Ljava/lang/StringBuffer;
    //   292: checkcast 140	java/lang/CharSequence
    //   295: invokeinterface 143 1 0
    //   300: ifle +336 -> 636
    //   303: iconst_1
    //   304: istore_1
    //   305: goto +3 -> 308
    //   308: iload_1
    //   309: ifeq +267 -> 576
    //   312: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   315: lstore_3
    //   316: lload_3
    //   317: aload_0
    //   318: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   321: invokestatic 153	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getLastTimeMillis$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)J
    //   324: lsub
    //   325: ldc 154
    //   327: i2l
    //   328: lcmp
    //   329: ifle +82 -> 411
    //   332: new 156	java/text/SimpleDateFormat
    //   335: dup
    //   336: ldc 158
    //   338: getstatic 164	java/util/Locale:US	Ljava/util/Locale;
    //   341: invokespecial 167	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   344: astore 6
    //   346: aload_0
    //   347: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   350: astore 8
    //   352: new 86	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   359: astore 9
    //   361: aload 9
    //   363: ldc 169
    //   365: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 9
    //   371: aload 6
    //   373: lload_3
    //   374: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   377: invokevirtual 179	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   380: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 9
    //   386: ldc 181
    //   388: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 8
    //   394: new 106	java/io/File
    //   397: dup
    //   398: aload 5
    //   400: aload 9
    //   402: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokespecial 184	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   408: invokestatic 188	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$setLogFile$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;Ljava/io/File;)V
    //   411: aload_0
    //   412: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   415: invokestatic 192	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getLogFile$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)Ljava/io/File;
    //   418: astore 5
    //   420: aload 5
    //   422: ifnull +146 -> 568
    //   425: aload 5
    //   427: invokevirtual 116	java/io/File:exists	()Z
    //   430: ifne +9 -> 439
    //   433: aload 5
    //   435: invokevirtual 195	java/io/File:createNewFile	()Z
    //   438: pop
    //   439: new 197	java/io/BufferedWriter
    //   442: dup
    //   443: new 199	java/io/FileWriter
    //   446: dup
    //   447: aload 5
    //   449: iconst_1
    //   450: invokespecial 202	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   453: checkcast 204	java/io/Writer
    //   456: invokespecial 207	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   459: checkcast 209	java/io/Closeable
    //   462: astore 8
    //   464: aconst_null
    //   465: checkcast 34	java/lang/Throwable
    //   468: astore 6
    //   470: aload 6
    //   472: astore 5
    //   474: aload 8
    //   476: checkcast 197	java/io/BufferedWriter
    //   479: astore 9
    //   481: aload 6
    //   483: astore 5
    //   485: aload 9
    //   487: aload_0
    //   488: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   491: invokestatic 131	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getSb$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)Ljava/lang/StringBuffer;
    //   494: invokevirtual 210	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   497: invokevirtual 213	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   500: aload 6
    //   502: astore 5
    //   504: aload 9
    //   506: invokevirtual 216	java/io/BufferedWriter:flush	()V
    //   509: aload 6
    //   511: astore 5
    //   513: getstatic 222	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   516: astore 9
    //   518: aload 8
    //   520: aload 6
    //   522: invokestatic 228	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   525: goto +43 -> 568
    //   528: astore 6
    //   530: goto +12 -> 542
    //   533: astore 6
    //   535: aload 6
    //   537: astore 5
    //   539: aload 6
    //   541: athrow
    //   542: aload 8
    //   544: aload 5
    //   546: invokestatic 228	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   549: aload 6
    //   551: athrow
    //   552: astore 5
    //   554: ldc 67
    //   556: getstatic 233	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   559: aload 5
    //   561: invokevirtual 237	com/tencent/qapmsdk/common/logger/Logger:getThrowableMessage	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   564: invokestatic 73	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   567: pop
    //   568: aload_0
    //   569: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   572: lload_3
    //   573: invokestatic 241	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$setLastTimeMillis$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;J)V
    //   576: aload_0
    //   577: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   580: invokestatic 131	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getSb$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)Ljava/lang/StringBuffer;
    //   583: iconst_0
    //   584: aload_0
    //   585: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   588: invokestatic 131	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$getSb$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;)Ljava/lang/StringBuffer;
    //   591: invokevirtual 242	java/lang/StringBuffer:length	()I
    //   594: invokevirtual 246	java/lang/StringBuffer:delete	(II)Ljava/lang/StringBuffer;
    //   597: pop
    //   598: aload_0
    //   599: getfield 26	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy$writeLogFile$1:this$0	Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;
    //   602: iconst_0
    //   603: invokestatic 123	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:access$setFlushing$p	(Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;Z)V
    //   606: getstatic 222	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   609: astore 5
    //   611: aload 7
    //   613: monitorexit
    //   614: return
    //   615: astore 5
    //   617: aload 7
    //   619: monitorexit
    //   620: goto +6 -> 626
    //   623: aload 5
    //   625: athrow
    //   626: goto -3 -> 623
    //   629: ldc 247
    //   631: astore 5
    //   633: goto -524 -> 109
    //   636: iconst_0
    //   637: istore_1
    //   638: goto -330 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	641	0	this	1
    //   43	595	1	i	int
    //   16	63	2	bool	boolean
    //   315	258	3	l	long
    //   28	43	5	str1	java.lang.String
    //   92	3	5	localException	java.lang.Exception
    //   99	446	5	localObject1	Object
    //   552	8	5	localThrowable1	java.lang.Throwable
    //   609	1	5	localUnit	kotlin.Unit
    //   615	9	5	localObject2	Object
    //   631	1	5	str2	java.lang.String
    //   228	293	6	localObject3	Object
    //   528	1	6	localObject4	Object
    //   533	17	6	localThrowable2	java.lang.Throwable
    //   4	614	7	localDefaultLogProxy	Logger.DefaultLogProxy
    //   242	301	8	localObject5	Object
    //   251	266	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   25	30	92	java/lang/Exception
    //   38	44	92	java/lang/Exception
    //   59	67	92	java/lang/Exception
    //   70	78	92	java/lang/Exception
    //   474	481	528	finally
    //   485	500	528	finally
    //   504	509	528	finally
    //   513	518	528	finally
    //   539	542	528	finally
    //   474	481	533	java/lang/Throwable
    //   485	500	533	java/lang/Throwable
    //   504	509	533	java/lang/Throwable
    //   513	518	533	java/lang/Throwable
    //   411	420	552	java/lang/Throwable
    //   425	439	552	java/lang/Throwable
    //   439	470	552	java/lang/Throwable
    //   518	525	552	java/lang/Throwable
    //   542	552	552	java/lang/Throwable
    //   9	17	615	finally
    //   25	30	615	finally
    //   38	44	615	finally
    //   59	67	615	finally
    //   70	78	615	finally
    //   94	101	615	finally
    //   109	117	615	finally
    //   124	144	615	finally
    //   148	205	615	finally
    //   205	213	615	finally
    //   213	230	615	finally
    //   235	280	615	finally
    //   285	303	615	finally
    //   312	411	615	finally
    //   411	420	615	finally
    //   425	439	615	finally
    //   439	470	615	finally
    //   518	525	615	finally
    //   542	552	615	finally
    //   554	568	615	finally
    //   568	576	615	finally
    //   576	611	615	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.Logger.DefaultLogProxy.writeLogFile.1
 * JD-Core Version:    0.7.0.1
 */