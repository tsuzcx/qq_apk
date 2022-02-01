package com.tencent.tbs.one.impl.e;

import android.content.Context;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.common.d;
import java.io.File;

final class i$4
  extends a<e<d>>
{
  i$4(i parami, Context paramContext, String paramString, File paramFile) {}
  
  /* Error */
  protected final void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_1
    //   6: aload_0
    //   7: getfield 19	com/tencent/tbs/one/impl/e/i$4:b	Landroid/content/Context;
    //   10: aload_0
    //   11: getfield 21	com/tencent/tbs/one/impl/e/i$4:c	Ljava/lang/String;
    //   14: ldc 34
    //   16: invokestatic 39	com/tencent/tbs/one/impl/a/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore 4
    //   21: aload 4
    //   23: astore_1
    //   24: aload 4
    //   26: astore_2
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: ldc 41
    //   34: aload_0
    //   35: getfield 23	com/tencent/tbs/one/impl/e/i$4:d	Ljava/io/File;
    //   38: invokestatic 44	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/lang/String;Ljava/io/File;)Ljava/lang/String;
    //   41: invokestatic 49	com/tencent/tbs/one/impl/common/d:a	(Ljava/lang/String;)Lcom/tencent/tbs/one/impl/common/d;
    //   44: astore 5
    //   46: aload 4
    //   48: invokestatic 52	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   51: aload_0
    //   52: getstatic 57	com/tencent/tbs/one/impl/e/e$a:c	Lcom/tencent/tbs/one/impl/e/e$a;
    //   55: aload 5
    //   57: invokestatic 62	com/tencent/tbs/one/impl/e/e:a	(Lcom/tencent/tbs/one/impl/e/e$a;Ljava/lang/Object;)Lcom/tencent/tbs/one/impl/e/e;
    //   60: invokevirtual 65	com/tencent/tbs/one/impl/e/i$4:a	(Ljava/lang/Object;)V
    //   63: return
    //   64: astore_2
    //   65: goto +98 -> 163
    //   68: astore_3
    //   69: aload_2
    //   70: astore_1
    //   71: aload_0
    //   72: aload_3
    //   73: invokevirtual 69	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   76: aload_3
    //   77: invokevirtual 73	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   80: aload_3
    //   81: invokevirtual 77	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   84: invokevirtual 80	com/tencent/tbs/one/impl/e/i$4:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_2
    //   88: invokestatic 52	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   91: return
    //   92: astore_2
    //   93: aload_3
    //   94: astore_1
    //   95: new 82	java/lang/StringBuilder
    //   98: dup
    //   99: ldc 84
    //   101: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: astore 4
    //   106: aload_3
    //   107: astore_1
    //   108: aload 4
    //   110: aload_0
    //   111: getfield 21	com/tencent/tbs/one/impl/e/i$4:c	Ljava/lang/String;
    //   114: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_3
    //   119: astore_1
    //   120: aload 4
    //   122: ldc 93
    //   124: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_3
    //   129: astore_1
    //   130: aload 4
    //   132: aload_0
    //   133: getfield 23	com/tencent/tbs/one/impl/e/i$4:d	Ljava/io/File;
    //   136: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   139: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_3
    //   144: astore_1
    //   145: aload_0
    //   146: sipush 303
    //   149: aload 4
    //   151: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload_2
    //   155: invokevirtual 80	com/tencent/tbs/one/impl/e/i$4:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_3
    //   159: invokestatic 52	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   162: return
    //   163: aload_1
    //   164: invokestatic 52	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   167: aload_2
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	4
    //   5	159	1	localObject1	java.lang.Object
    //   1	26	2	localObject2	java.lang.Object
    //   64	24	2	localCloseable	java.io.Closeable
    //   92	76	2	localIOException	java.io.IOException
    //   3	27	3	localObject3	java.lang.Object
    //   68	91	3	localTBSOneException	com.tencent.tbs.one.TBSOneException
    //   19	131	4	localObject4	java.lang.Object
    //   44	12	5	locald	d
    // Exception table:
    //   from	to	target	type
    //   6	21	64	finally
    //   30	46	64	finally
    //   71	87	64	finally
    //   95	106	64	finally
    //   108	118	64	finally
    //   120	128	64	finally
    //   130	143	64	finally
    //   145	158	64	finally
    //   6	21	68	com/tencent/tbs/one/TBSOneException
    //   30	46	68	com/tencent/tbs/one/TBSOneException
    //   6	21	92	java/io/IOException
    //   30	46	92	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.i.4
 * JD-Core Version:    0.7.0.1
 */