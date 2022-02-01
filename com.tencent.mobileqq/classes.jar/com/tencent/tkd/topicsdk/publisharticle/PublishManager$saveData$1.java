package com.tencent.tkd.topicsdk.publisharticle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$saveData$1
  extends Lambda
  implements Function0<Unit>
{
  public static final 1 INSTANCE = new 1();
  
  PublishManager$saveData$1()
  {
    super(0);
  }
  
  /* Error */
  public final void invoke()
  {
    // Byte code:
    //   0: new 48	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 49	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 51	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: checkcast 53	java/io/OutputStream
    //   18: invokespecial 56	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: checkcast 58	java/io/Closeable
    //   24: astore_3
    //   25: aconst_null
    //   26: checkcast 46	java/lang/Throwable
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_3
    //   33: checkcast 51	java/io/ObjectOutputStream
    //   36: astore 5
    //   38: aload_2
    //   39: astore_1
    //   40: getstatic 64	com/tencent/tkd/topicsdk/publisharticle/PublishManager:a	Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager;
    //   43: invokestatic 67	com/tencent/tkd/topicsdk/publisharticle/PublishManager:a	(Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager;)Ljava/util/ArrayList;
    //   46: checkcast 69	java/lang/Iterable
    //   49: astore 7
    //   51: aload_2
    //   52: astore_1
    //   53: new 71	java/util/ArrayList
    //   56: dup
    //   57: aload 7
    //   59: bipush 10
    //   61: invokestatic 77	kotlin/collections/CollectionsKt:collectionSizeOrDefault	(Ljava/lang/Iterable;I)I
    //   64: invokespecial 78	java/util/ArrayList:<init>	(I)V
    //   67: checkcast 80	java/util/Collection
    //   70: astore 6
    //   72: aload_2
    //   73: astore_1
    //   74: aload 7
    //   76: invokeinterface 84 1 0
    //   81: astore 7
    //   83: aload_2
    //   84: astore_1
    //   85: aload 7
    //   87: invokeinterface 90 1 0
    //   92: ifeq +29 -> 121
    //   95: aload_2
    //   96: astore_1
    //   97: aload 6
    //   99: aload 7
    //   101: invokeinterface 93 1 0
    //   106: checkcast 95	com/tencent/tkd/topicsdk/publisharticle/PublishManager$PublishTask
    //   109: invokevirtual 98	com/tencent/tkd/topicsdk/publisharticle/PublishManager$PublishTask:a	()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;
    //   112: invokeinterface 102 2 0
    //   117: pop
    //   118: goto -35 -> 83
    //   121: aload_2
    //   122: astore_1
    //   123: aload 5
    //   125: new 71	java/util/ArrayList
    //   128: dup
    //   129: aload 6
    //   131: checkcast 104	java/util/List
    //   134: checkcast 80	java/util/Collection
    //   137: invokespecial 107	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   140: invokevirtual 111	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   143: aload_2
    //   144: astore_1
    //   145: aload 5
    //   147: invokevirtual 114	java/io/ObjectOutputStream:flush	()V
    //   150: aload_2
    //   151: astore_1
    //   152: getstatic 119	com/tencent/tkd/topicsdk/framework/StorageManager:a	Lcom/tencent/tkd/topicsdk/framework/StorageManager;
    //   155: astore 5
    //   157: aload_2
    //   158: astore_1
    //   159: new 121	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   166: astore 6
    //   168: aload_2
    //   169: astore_1
    //   170: aload 6
    //   172: ldc 124
    //   174: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_2
    //   179: astore_1
    //   180: aload 6
    //   182: getstatic 133	com/tencent/tkd/topicsdk/framework/Account:a	Lcom/tencent/tkd/topicsdk/framework/Account;
    //   185: invokevirtual 136	com/tencent/tkd/topicsdk/framework/Account:a	()Ljava/lang/String;
    //   188: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_2
    //   193: astore_1
    //   194: aload 5
    //   196: aload 6
    //   198: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aload 4
    //   203: invokevirtual 143	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   206: invokevirtual 146	com/tencent/tkd/topicsdk/framework/StorageManager:a	(Ljava/lang/String;[B)V
    //   209: aload_2
    //   210: astore_1
    //   211: getstatic 42	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   214: astore 4
    //   216: aload_3
    //   217: aload_2
    //   218: invokestatic 152	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   221: return
    //   222: astore_2
    //   223: goto +8 -> 231
    //   226: astore_2
    //   227: aload_2
    //   228: astore_1
    //   229: aload_2
    //   230: athrow
    //   231: aload_3
    //   232: aload_1
    //   233: invokestatic 152	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   236: aload_2
    //   237: athrow
    //   238: astore_1
    //   239: ldc 154
    //   241: ldc 156
    //   243: aload_1
    //   244: checkcast 46	java/lang/Throwable
    //   247: invokestatic 162	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	1
    //   31	202	1	localThrowable1	java.lang.Throwable
    //   238	6	1	localException	java.lang.Exception
    //   29	189	2	localThrowable2	java.lang.Throwable
    //   222	1	2	localObject1	java.lang.Object
    //   226	11	2	localThrowable3	java.lang.Throwable
    //   24	208	3	localCloseable	java.io.Closeable
    //   7	208	4	localObject2	java.lang.Object
    //   36	159	5	localObject3	java.lang.Object
    //   70	127	6	localObject4	java.lang.Object
    //   49	51	7	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   32	38	222	finally
    //   40	51	222	finally
    //   53	72	222	finally
    //   74	83	222	finally
    //   85	95	222	finally
    //   97	118	222	finally
    //   123	143	222	finally
    //   145	150	222	finally
    //   152	157	222	finally
    //   159	168	222	finally
    //   170	178	222	finally
    //   180	192	222	finally
    //   194	209	222	finally
    //   211	216	222	finally
    //   229	231	222	finally
    //   32	38	226	java/lang/Throwable
    //   40	51	226	java/lang/Throwable
    //   53	72	226	java/lang/Throwable
    //   74	83	226	java/lang/Throwable
    //   85	95	226	java/lang/Throwable
    //   97	118	226	java/lang/Throwable
    //   123	143	226	java/lang/Throwable
    //   145	150	226	java/lang/Throwable
    //   152	157	226	java/lang/Throwable
    //   159	168	226	java/lang/Throwable
    //   170	178	226	java/lang/Throwable
    //   180	192	226	java/lang/Throwable
    //   194	209	226	java/lang/Throwable
    //   211	216	226	java/lang/Throwable
    //   0	30	238	java/lang/Exception
    //   216	221	238	java/lang/Exception
    //   231	238	238	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.saveData.1
 * JD-Core Version:    0.7.0.1
 */