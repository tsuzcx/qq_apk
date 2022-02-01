package com.tencent.tkd.topicsdk.publisharticle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$initData$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$initData$1(Function0 paramFunction0)
  {
    super(0);
  }
  
  /* Error */
  public final void invoke()
  {
    // Byte code:
    //   0: getstatic 51	com/tencent/tkd/topicsdk/framework/StorageManager:a	Lcom/tencent/tkd/topicsdk/framework/StorageManager;
    //   3: astore_2
    //   4: new 53	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   11: astore_3
    //   12: aload_3
    //   13: ldc 57
    //   15: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_3
    //   20: getstatic 66	com/tencent/tkd/topicsdk/framework/Account:a	Lcom/tencent/tkd/topicsdk/framework/Account;
    //   23: invokevirtual 69	com/tencent/tkd/topicsdk/framework/Account:a	()Ljava/lang/String;
    //   26: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: aload_3
    //   32: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokevirtual 75	com/tencent/tkd/topicsdk/framework/StorageManager:a	(Ljava/lang/String;)[B
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +220 -> 260
    //   43: new 77	java/io/ObjectInputStream
    //   46: dup
    //   47: new 79	java/io/ByteArrayInputStream
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 82	java/io/ByteArrayInputStream:<init>	([B)V
    //   55: checkcast 84	java/io/InputStream
    //   58: invokespecial 87	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: checkcast 89	java/io/Closeable
    //   64: astore 6
    //   66: aconst_null
    //   67: astore_3
    //   68: aconst_null
    //   69: checkcast 45	java/lang/Throwable
    //   72: astore 4
    //   74: aload 4
    //   76: astore_2
    //   77: aload 6
    //   79: checkcast 77	java/io/ObjectInputStream
    //   82: invokevirtual 92	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   85: astore 5
    //   87: aload 4
    //   89: astore_2
    //   90: aload 5
    //   92: instanceof 94
    //   95: ifne +180 -> 275
    //   98: goto +3 -> 101
    //   101: aload 4
    //   103: astore_2
    //   104: aload_3
    //   105: checkcast 94	java/util/ArrayList
    //   108: astore_3
    //   109: aload_3
    //   110: ifnull +111 -> 221
    //   113: aload 4
    //   115: astore_2
    //   116: aload_3
    //   117: checkcast 96	java/lang/Iterable
    //   120: invokeinterface 100 1 0
    //   125: astore_3
    //   126: aload 4
    //   128: astore_2
    //   129: aload_3
    //   130: invokeinterface 106 1 0
    //   135: ifeq +79 -> 214
    //   138: aload 4
    //   140: astore_2
    //   141: aload_3
    //   142: invokeinterface 109 1 0
    //   147: checkcast 111	com/tencent/tkd/topicsdk/bean/PublishArticleInfo
    //   150: astore 5
    //   152: aload 4
    //   154: astore_2
    //   155: aload 5
    //   157: invokevirtual 114	com/tencent/tkd/topicsdk/bean/PublishArticleInfo:getPublishId	()Ljava/lang/String;
    //   160: ifnull -34 -> 126
    //   163: aload 4
    //   165: astore_2
    //   166: aload 5
    //   168: invokevirtual 114	com/tencent/tkd/topicsdk/bean/PublishArticleInfo:getPublishId	()Ljava/lang/String;
    //   171: checkcast 116	java/lang/CharSequence
    //   174: invokeinterface 120 1 0
    //   179: ifle +102 -> 281
    //   182: iconst_1
    //   183: istore_1
    //   184: goto +3 -> 187
    //   187: iload_1
    //   188: ifeq -62 -> 126
    //   191: aload 4
    //   193: astore_2
    //   194: aload 5
    //   196: iconst_0
    //   197: invokevirtual 124	com/tencent/tkd/topicsdk/bean/PublishArticleInfo:setPublishing	(Z)V
    //   200: aload 4
    //   202: astore_2
    //   203: getstatic 129	com/tencent/tkd/topicsdk/publisharticle/PublishManager:a	Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager;
    //   206: aload 5
    //   208: invokestatic 132	com/tencent/tkd/topicsdk/publisharticle/PublishManager:a	(Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager;Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V
    //   211: goto -85 -> 126
    //   214: aload 4
    //   216: astore_2
    //   217: getstatic 41	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   220: astore_3
    //   221: aload 6
    //   223: aload 4
    //   225: invokestatic 138	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   228: goto +32 -> 260
    //   231: astore_3
    //   232: goto +8 -> 240
    //   235: astore_3
    //   236: aload_3
    //   237: astore_2
    //   238: aload_3
    //   239: athrow
    //   240: aload 6
    //   242: aload_2
    //   243: invokestatic 138	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   246: aload_3
    //   247: athrow
    //   248: astore_2
    //   249: ldc 140
    //   251: ldc 142
    //   253: aload_2
    //   254: checkcast 45	java/lang/Throwable
    //   257: invokestatic 148	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: new 150	com/tencent/tkd/topicsdk/publisharticle/PublishManager$initData$1$2
    //   263: dup
    //   264: aload_0
    //   265: invokespecial 153	com/tencent/tkd/topicsdk/publisharticle/PublishManager$initData$1$2:<init>	(Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager$initData$1;)V
    //   268: checkcast 7	kotlin/jvm/functions/Function0
    //   271: invokestatic 157	com/tencent/tkd/topicsdk/framework/ThreadManagerKt:a	(Lkotlin/jvm/functions/Function0;)V
    //   274: return
    //   275: aload 5
    //   277: astore_3
    //   278: goto -177 -> 101
    //   281: iconst_0
    //   282: istore_1
    //   283: goto -96 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	1
    //   183	100	1	i	int
    //   3	240	2	localObject1	java.lang.Object
    //   248	6	2	localException	java.lang.Exception
    //   11	210	3	localObject2	java.lang.Object
    //   231	1	3	localObject3	java.lang.Object
    //   235	12	3	localThrowable1	java.lang.Throwable
    //   277	1	3	localObject4	java.lang.Object
    //   72	152	4	localThrowable2	java.lang.Throwable
    //   85	191	5	localObject5	java.lang.Object
    //   64	177	6	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   77	87	231	finally
    //   90	98	231	finally
    //   104	109	231	finally
    //   116	126	231	finally
    //   129	138	231	finally
    //   141	152	231	finally
    //   155	163	231	finally
    //   166	182	231	finally
    //   194	200	231	finally
    //   203	211	231	finally
    //   217	221	231	finally
    //   238	240	231	finally
    //   77	87	235	java/lang/Throwable
    //   90	98	235	java/lang/Throwable
    //   104	109	235	java/lang/Throwable
    //   116	126	235	java/lang/Throwable
    //   129	138	235	java/lang/Throwable
    //   141	152	235	java/lang/Throwable
    //   155	163	235	java/lang/Throwable
    //   166	182	235	java/lang/Throwable
    //   194	200	235	java/lang/Throwable
    //   203	211	235	java/lang/Throwable
    //   217	221	235	java/lang/Throwable
    //   0	39	248	java/lang/Exception
    //   43	66	248	java/lang/Exception
    //   68	74	248	java/lang/Exception
    //   221	228	248	java/lang/Exception
    //   240	248	248	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.initData.1
 * JD-Core Version:    0.7.0.1
 */