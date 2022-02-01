package com.tencent.tkd.topicsdk.publisharticle.publish;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$initDataFromLocal$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$initDataFromLocal$1(Function0 paramFunction0)
  {
    super(0);
  }
  
  /* Error */
  public final void invoke()
  {
    // Byte code:
    //   0: getstatic 51	com/tencent/tkd/topicsdk/framework/StorageManager:b	Lcom/tencent/tkd/topicsdk/framework/StorageManager;
    //   3: getstatic 57	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager:a	Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager;
    //   6: invokestatic 60	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager:a	(Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager;)Ljava/lang/String;
    //   9: invokevirtual 63	com/tencent/tkd/topicsdk/framework/StorageManager:a	(Ljava/lang/String;)[B
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +210 -> 224
    //   17: new 65	java/io/ObjectInputStream
    //   20: dup
    //   21: new 67	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 70	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: checkcast 72	java/io/InputStream
    //   32: invokespecial 75	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: checkcast 77	java/io/Closeable
    //   38: astore 6
    //   40: aconst_null
    //   41: astore_3
    //   42: aconst_null
    //   43: checkcast 45	java/lang/Throwable
    //   46: astore 4
    //   48: aload 4
    //   50: astore_2
    //   51: aload 6
    //   53: checkcast 65	java/io/ObjectInputStream
    //   56: invokevirtual 80	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   59: astore 5
    //   61: aload 4
    //   63: astore_2
    //   64: aload 5
    //   66: instanceof 82
    //   69: ifne +170 -> 239
    //   72: goto +3 -> 75
    //   75: aload 4
    //   77: astore_2
    //   78: aload_3
    //   79: checkcast 82	java/util/ArrayList
    //   82: astore_3
    //   83: aload_3
    //   84: ifnull +101 -> 185
    //   87: aload 4
    //   89: astore_2
    //   90: aload_3
    //   91: checkcast 84	java/lang/Iterable
    //   94: invokeinterface 88 1 0
    //   99: astore_3
    //   100: aload 4
    //   102: astore_2
    //   103: aload_3
    //   104: invokeinterface 94 1 0
    //   109: ifeq +69 -> 178
    //   112: aload 4
    //   114: astore_2
    //   115: aload_3
    //   116: invokeinterface 97 1 0
    //   121: checkcast 99	com/tencent/tkd/topicsdk/bean/PublishArticleInfo
    //   124: astore 5
    //   126: aload 4
    //   128: astore_2
    //   129: aload 5
    //   131: invokevirtual 103	com/tencent/tkd/topicsdk/bean/PublishArticleInfo:getPublishId	()Ljava/lang/String;
    //   134: checkcast 105	java/lang/CharSequence
    //   137: invokeinterface 109 1 0
    //   142: ifle +103 -> 245
    //   145: iconst_1
    //   146: istore_1
    //   147: goto +3 -> 150
    //   150: iload_1
    //   151: ifeq -51 -> 100
    //   154: aload 4
    //   156: astore_2
    //   157: aload 5
    //   159: iconst_0
    //   160: invokevirtual 113	com/tencent/tkd/topicsdk/bean/PublishArticleInfo:setPublishing	(Z)V
    //   163: aload 4
    //   165: astore_2
    //   166: getstatic 57	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager:a	Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager;
    //   169: aload 5
    //   171: invokestatic 116	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager:a	(Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager;Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$PublishTask;
    //   174: pop
    //   175: goto -75 -> 100
    //   178: aload 4
    //   180: astore_2
    //   181: getstatic 41	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   184: astore_3
    //   185: aload 6
    //   187: aload 4
    //   189: invokestatic 122	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   192: goto +32 -> 224
    //   195: astore_3
    //   196: goto +8 -> 204
    //   199: astore_3
    //   200: aload_3
    //   201: astore_2
    //   202: aload_3
    //   203: athrow
    //   204: aload 6
    //   206: aload_2
    //   207: invokestatic 122	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   210: aload_3
    //   211: athrow
    //   212: astore_2
    //   213: ldc 124
    //   215: ldc 126
    //   217: aload_2
    //   218: checkcast 45	java/lang/Throwable
    //   221: invokestatic 131	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: new 133	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$initDataFromLocal$1$2
    //   227: dup
    //   228: aload_0
    //   229: invokespecial 136	com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$initDataFromLocal$1$2:<init>	(Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$initDataFromLocal$1;)V
    //   232: checkcast 7	kotlin/jvm/functions/Function0
    //   235: invokestatic 140	com/tencent/tkd/topicsdk/framework/ThreadManagerKt:a	(Lkotlin/jvm/functions/Function0;)V
    //   238: return
    //   239: aload 5
    //   241: astore_3
    //   242: goto -167 -> 75
    //   245: iconst_0
    //   246: istore_1
    //   247: goto -97 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	1
    //   146	101	1	i	int
    //   12	195	2	localObject1	java.lang.Object
    //   212	6	2	localException	java.lang.Exception
    //   41	144	3	localObject2	java.lang.Object
    //   195	1	3	localObject3	java.lang.Object
    //   199	12	3	localThrowable1	java.lang.Throwable
    //   241	1	3	localObject4	java.lang.Object
    //   46	142	4	localThrowable2	java.lang.Throwable
    //   59	181	5	localObject5	java.lang.Object
    //   38	167	6	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   51	61	195	finally
    //   64	72	195	finally
    //   78	83	195	finally
    //   90	100	195	finally
    //   103	112	195	finally
    //   115	126	195	finally
    //   129	145	195	finally
    //   157	163	195	finally
    //   166	175	195	finally
    //   181	185	195	finally
    //   202	204	195	finally
    //   51	61	199	java/lang/Throwable
    //   64	72	199	java/lang/Throwable
    //   78	83	199	java/lang/Throwable
    //   90	100	199	java/lang/Throwable
    //   103	112	199	java/lang/Throwable
    //   115	126	199	java/lang/Throwable
    //   129	145	199	java/lang/Throwable
    //   157	163	199	java/lang/Throwable
    //   166	175	199	java/lang/Throwable
    //   181	185	199	java/lang/Throwable
    //   0	13	212	java/lang/Exception
    //   17	40	212	java/lang/Exception
    //   42	48	212	java/lang/Exception
    //   185	192	212	java/lang/Exception
    //   204	212	212	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.initDataFromLocal.1
 * JD-Core Version:    0.7.0.1
 */