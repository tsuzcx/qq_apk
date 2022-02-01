package com.tencent.tbs.one.impl.e;

import android.content.Context;
import com.tencent.tbs.one.impl.a.a;
import java.io.File;

final class i$5
  extends a<e<File>>
{
  i$5(i parami, Context paramContext, String paramString1, String paramString2, File paramFile, int paramInt) {}
  
  /* Error */
  protected final void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 22	com/tencent/tbs/one/impl/e/i$5:b	Landroid/content/Context;
    //   9: aload_0
    //   10: getfield 24	com/tencent/tbs/one/impl/e/i$5:c	Ljava/lang/String;
    //   13: aload_0
    //   14: getfield 26	com/tencent/tbs/one/impl/e/i$5:d	Ljava/lang/String;
    //   17: invokestatic 44	com/tencent/tbs/one/impl/a/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   20: astore_2
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 28	com/tencent/tbs/one/impl/e/i$5:e	Ljava/io/File;
    //   26: aconst_null
    //   27: invokestatic 47	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/io/File;Ljava/io/File;)V
    //   30: aload_2
    //   31: invokestatic 50	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   34: aload_0
    //   35: getfield 28	com/tencent/tbs/one/impl/e/i$5:e	Ljava/io/File;
    //   38: aload_0
    //   39: getfield 28	com/tencent/tbs/one/impl/e/i$5:e	Ljava/io/File;
    //   42: invokestatic 55	com/tencent/tbs/one/impl/e/f:a	(Ljava/io/File;Ljava/io/File;)V
    //   45: aload_0
    //   46: getfield 28	com/tencent/tbs/one/impl/e/i$5:e	Ljava/io/File;
    //   49: aload_0
    //   50: getfield 30	com/tencent/tbs/one/impl/e/i$5:f	I
    //   53: invokestatic 58	com/tencent/tbs/one/impl/e/f:a	(Ljava/io/File;I)V
    //   56: aload_0
    //   57: getstatic 63	com/tencent/tbs/one/impl/e/e$a:c	Lcom/tencent/tbs/one/impl/e/e$a;
    //   60: aload_0
    //   61: getfield 28	com/tencent/tbs/one/impl/e/i$5:e	Ljava/io/File;
    //   64: invokestatic 68	com/tencent/tbs/one/impl/e/e:a	(Lcom/tencent/tbs/one/impl/e/e$a;Ljava/lang/Object;)Lcom/tencent/tbs/one/impl/e/e;
    //   67: invokevirtual 71	com/tencent/tbs/one/impl/e/i$5:a	(Ljava/lang/Object;)V
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual 75	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   77: aload_1
    //   78: invokevirtual 79	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   81: aload_1
    //   82: invokevirtual 83	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   85: invokevirtual 86	com/tencent/tbs/one/impl/e/i$5:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   88: return
    //   89: astore_1
    //   90: goto +111 -> 201
    //   93: astore_3
    //   94: goto +15 -> 109
    //   97: astore_3
    //   98: aload_1
    //   99: astore_2
    //   100: aload_3
    //   101: astore_1
    //   102: goto +99 -> 201
    //   105: astore_3
    //   106: aload 4
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: new 88	java/lang/StringBuilder
    //   114: dup
    //   115: ldc 90
    //   117: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: astore 4
    //   122: aload_2
    //   123: astore_1
    //   124: aload 4
    //   126: aload_0
    //   127: getfield 26	com/tencent/tbs/one/impl/e/i$5:d	Ljava/lang/String;
    //   130: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_2
    //   135: astore_1
    //   136: aload 4
    //   138: ldc 99
    //   140: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_2
    //   145: astore_1
    //   146: aload 4
    //   148: aload_0
    //   149: getfield 28	com/tencent/tbs/one/impl/e/i$5:e	Ljava/io/File;
    //   152: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_2
    //   160: astore_1
    //   161: aload 4
    //   163: ldc 106
    //   165: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_2
    //   170: astore_1
    //   171: aload 4
    //   173: aload_0
    //   174: getfield 24	com/tencent/tbs/one/impl/e/i$5:c	Ljava/lang/String;
    //   177: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_2
    //   182: astore_1
    //   183: aload_0
    //   184: sipush 313
    //   187: aload 4
    //   189: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aload_3
    //   193: invokevirtual 86	com/tencent/tbs/one/impl/e/i$5:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_2
    //   197: invokestatic 50	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   200: return
    //   201: aload_2
    //   202: invokestatic 50	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   205: aload_1
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	5
    //   4	1	1	localObject1	java.lang.Object
    //   71	11	1	localTBSOneException	com.tencent.tbs.one.TBSOneException
    //   89	10	1	localObject2	java.lang.Object
    //   101	105	1	localObject3	java.lang.Object
    //   20	182	2	localObject4	java.lang.Object
    //   93	1	3	localIOException1	java.io.IOException
    //   97	4	3	localObject5	java.lang.Object
    //   105	88	3	localIOException2	java.io.IOException
    //   1	187	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	56	71	com/tencent/tbs/one/TBSOneException
    //   21	30	89	finally
    //   21	30	93	java/io/IOException
    //   5	21	97	finally
    //   111	122	97	finally
    //   124	134	97	finally
    //   136	144	97	finally
    //   146	159	97	finally
    //   161	169	97	finally
    //   171	181	97	finally
    //   183	196	97	finally
    //   5	21	105	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.i.5
 * JD-Core Version:    0.7.0.1
 */