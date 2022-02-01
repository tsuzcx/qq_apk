package com.tencent.tkd.topicsdk.publisharticle.publish;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$saveDataToLocal$1
  extends Lambda
  implements Function0<Unit>
{
  public static final 1 INSTANCE = new 1();
  
  PublishManager$saveDataToLocal$1()
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
    //   40: getstatic 64	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager:a	Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager;
    //   43: invokestatic 68	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager:b	(Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager;)Ljava/util/ArrayList;
    //   46: checkcast 70	java/lang/Iterable
    //   49: astore 7
    //   51: aload_2
    //   52: astore_1
    //   53: new 72	java/util/ArrayList
    //   56: dup
    //   57: aload 7
    //   59: bipush 10
    //   61: invokestatic 78	kotlin/collections/CollectionsKt:collectionSizeOrDefault	(Ljava/lang/Iterable;I)I
    //   64: invokespecial 79	java/util/ArrayList:<init>	(I)V
    //   67: checkcast 81	java/util/Collection
    //   70: astore 6
    //   72: aload_2
    //   73: astore_1
    //   74: aload 7
    //   76: invokeinterface 85 1 0
    //   81: astore 7
    //   83: aload_2
    //   84: astore_1
    //   85: aload 7
    //   87: invokeinterface 91 1 0
    //   92: ifeq +29 -> 121
    //   95: aload_2
    //   96: astore_1
    //   97: aload 6
    //   99: aload 7
    //   101: invokeinterface 94 1 0
    //   106: checkcast 96	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$PublishTask
    //   109: invokevirtual 100	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$PublishTask:i	()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;
    //   112: invokeinterface 104 2 0
    //   117: pop
    //   118: goto -35 -> 83
    //   121: aload_2
    //   122: astore_1
    //   123: aload 5
    //   125: new 72	java/util/ArrayList
    //   128: dup
    //   129: aload 6
    //   131: checkcast 106	java/util/List
    //   134: checkcast 81	java/util/Collection
    //   137: invokespecial 109	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   140: invokevirtual 113	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   143: aload_2
    //   144: astore_1
    //   145: aload 5
    //   147: invokevirtual 116	java/io/ObjectOutputStream:flush	()V
    //   150: aload_2
    //   151: astore_1
    //   152: getstatic 42	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   155: astore 5
    //   157: aload_3
    //   158: aload_2
    //   159: invokestatic 122	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   162: getstatic 127	com/tencent/tkd/topicsdk/framework/StorageManager:b	Lcom/tencent/tkd/topicsdk/framework/StorageManager;
    //   165: getstatic 64	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager:a	Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager;
    //   168: invokestatic 130	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager:a	(Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager;)Ljava/lang/String;
    //   171: aload 4
    //   173: invokevirtual 134	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   176: invokevirtual 137	com/tencent/tkd/topicsdk/framework/StorageManager:a	(Ljava/lang/String;[B)V
    //   179: return
    //   180: astore_2
    //   181: goto +8 -> 189
    //   184: astore_2
    //   185: aload_2
    //   186: astore_1
    //   187: aload_2
    //   188: athrow
    //   189: aload_3
    //   190: aload_1
    //   191: invokestatic 122	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   194: aload_2
    //   195: athrow
    //   196: astore_1
    //   197: ldc 139
    //   199: ldc 141
    //   201: aload_1
    //   202: checkcast 46	java/lang/Throwable
    //   205: invokestatic 146	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	1
    //   31	160	1	localThrowable1	java.lang.Throwable
    //   196	6	1	localException	java.lang.Exception
    //   29	130	2	localThrowable2	java.lang.Throwable
    //   180	1	2	localObject1	java.lang.Object
    //   184	11	2	localThrowable3	java.lang.Throwable
    //   24	166	3	localCloseable	java.io.Closeable
    //   7	165	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   36	120	5	localObject2	java.lang.Object
    //   70	60	6	localCollection	java.util.Collection
    //   49	51	7	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   32	38	180	finally
    //   40	51	180	finally
    //   53	72	180	finally
    //   74	83	180	finally
    //   85	95	180	finally
    //   97	118	180	finally
    //   123	143	180	finally
    //   145	150	180	finally
    //   152	157	180	finally
    //   187	189	180	finally
    //   32	38	184	java/lang/Throwable
    //   40	51	184	java/lang/Throwable
    //   53	72	184	java/lang/Throwable
    //   74	83	184	java/lang/Throwable
    //   85	95	184	java/lang/Throwable
    //   97	118	184	java/lang/Throwable
    //   123	143	184	java/lang/Throwable
    //   145	150	184	java/lang/Throwable
    //   152	157	184	java/lang/Throwable
    //   0	30	196	java/lang/Exception
    //   157	179	196	java/lang/Exception
    //   189	196	196	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.saveDataToLocal.1
 * JD-Core Version:    0.7.0.1
 */