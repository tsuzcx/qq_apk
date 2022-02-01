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
    //   7: astore_2
    //   8: new 51	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_2
    //   13: checkcast 53	java/io/OutputStream
    //   16: invokespecial 56	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: checkcast 58	java/io/Closeable
    //   22: astore_3
    //   23: aconst_null
    //   24: checkcast 46	java/lang/Throwable
    //   27: astore_1
    //   28: aload_3
    //   29: checkcast 51	java/io/ObjectOutputStream
    //   32: astore 4
    //   34: getstatic 64	com/tencent/tkd/topicsdk/publisharticle/PublishManager:a	Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager;
    //   37: invokestatic 67	com/tencent/tkd/topicsdk/publisharticle/PublishManager:a	(Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager;)Ljava/util/ArrayList;
    //   40: checkcast 69	java/lang/Iterable
    //   43: astore 6
    //   45: new 71	java/util/ArrayList
    //   48: dup
    //   49: aload 6
    //   51: bipush 10
    //   53: invokestatic 77	kotlin/collections/CollectionsKt:collectionSizeOrDefault	(Ljava/lang/Iterable;I)I
    //   56: invokespecial 78	java/util/ArrayList:<init>	(I)V
    //   59: checkcast 80	java/util/Collection
    //   62: astore 5
    //   64: aload 6
    //   66: invokeinterface 84 1 0
    //   71: astore 6
    //   73: aload 6
    //   75: invokeinterface 90 1 0
    //   80: ifeq +51 -> 131
    //   83: aload 5
    //   85: aload 6
    //   87: invokeinterface 93 1 0
    //   92: checkcast 95	com/tencent/tkd/topicsdk/publisharticle/PublishManager$PublishTask
    //   95: invokevirtual 98	com/tencent/tkd/topicsdk/publisharticle/PublishManager$PublishTask:a	()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;
    //   98: invokeinterface 102 2 0
    //   103: pop
    //   104: goto -31 -> 73
    //   107: astore_1
    //   108: aload_1
    //   109: athrow
    //   110: astore_2
    //   111: aload_3
    //   112: aload_1
    //   113: invokestatic 108	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: aload_2
    //   117: athrow
    //   118: astore_1
    //   119: ldc 110
    //   121: ldc 112
    //   123: aload_1
    //   124: checkcast 46	java/lang/Throwable
    //   127: invokestatic 118	com/tencent/tkd/topicsdk/framework/TLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: return
    //   131: aload 4
    //   133: new 71	java/util/ArrayList
    //   136: dup
    //   137: aload 5
    //   139: checkcast 120	java/util/List
    //   142: checkcast 80	java/util/Collection
    //   145: invokespecial 123	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   148: invokevirtual 127	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   151: aload 4
    //   153: invokevirtual 130	java/io/ObjectOutputStream:flush	()V
    //   156: getstatic 135	com/tencent/tkd/topicsdk/framework/StorageManager:a	Lcom/tencent/tkd/topicsdk/framework/StorageManager;
    //   159: new 137	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   166: ldc 140
    //   168: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: getstatic 149	com/tencent/tkd/topicsdk/framework/Account:a	Lcom/tencent/tkd/topicsdk/framework/Account;
    //   174: invokevirtual 152	com/tencent/tkd/topicsdk/framework/Account:a	()Ljava/lang/String;
    //   177: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: aload_2
    //   184: invokevirtual 159	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   187: invokevirtual 162	com/tencent/tkd/topicsdk/framework/StorageManager:a	(Ljava/lang/String;[B)V
    //   190: getstatic 42	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   193: astore_2
    //   194: aload_3
    //   195: aload_1
    //   196: invokestatic 108	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   199: return
    //   200: astore_2
    //   201: goto -90 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	1
    //   27	1	1	localThrowable1	java.lang.Throwable
    //   107	6	1	localThrowable2	java.lang.Throwable
    //   118	78	1	localException	java.lang.Exception
    //   7	6	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   110	74	2	localObject1	java.lang.Object
    //   193	1	2	localUnit	Unit
    //   200	1	2	localObject2	java.lang.Object
    //   22	173	3	localCloseable	java.io.Closeable
    //   32	120	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   62	76	5	localCollection	java.util.Collection
    //   43	43	6	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   28	73	107	java/lang/Throwable
    //   73	104	107	java/lang/Throwable
    //   131	194	107	java/lang/Throwable
    //   108	110	110	finally
    //   0	28	118	java/lang/Exception
    //   111	118	118	java/lang/Exception
    //   194	199	118	java/lang/Exception
    //   28	73	200	finally
    //   73	104	200	finally
    //   131	194	200	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.saveData.1
 * JD-Core Version:    0.7.0.1
 */