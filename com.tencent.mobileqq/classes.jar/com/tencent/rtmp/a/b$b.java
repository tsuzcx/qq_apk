package com.tencent.rtmp.a;

import java.lang.ref.WeakReference;

class b$b
  implements Runnable
{
  private WeakReference<b> a;
  private String b;
  private String c;
  
  public b$b(b paramb, String paramString1, String paramString2)
  {
    this.a = new WeakReference(paramb);
    this.b = paramString1;
    this.c = paramString2;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/rtmp/a/b$b:a	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 36	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 38	com/tencent/rtmp/a/b
    //   10: astore 5
    //   12: aload_0
    //   13: getfield 24	com/tencent/rtmp/a/b$b:a	Ljava/lang/ref/WeakReference;
    //   16: ifnull +174 -> 190
    //   19: aload 5
    //   21: ifnull +169 -> 190
    //   24: aconst_null
    //   25: astore_2
    //   26: aconst_null
    //   27: astore_3
    //   28: aload 5
    //   30: aload_0
    //   31: getfield 28	com/tencent/rtmp/a/b$b:c	Ljava/lang/String;
    //   34: invokestatic 41	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 28	com/tencent/rtmp/a/b$b:c	Ljava/lang/String;
    //   49: ldc 43
    //   51: invokevirtual 49	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   54: istore_1
    //   55: iload_1
    //   56: iconst_m1
    //   57: if_icmpeq +86 -> 143
    //   60: iload_1
    //   61: iconst_1
    //   62: iadd
    //   63: istore_1
    //   64: aload 4
    //   66: astore_3
    //   67: aload 4
    //   69: astore_2
    //   70: iload_1
    //   71: aload_0
    //   72: getfield 28	com/tencent/rtmp/a/b$b:c	Ljava/lang/String;
    //   75: invokevirtual 53	java/lang/String:length	()I
    //   78: if_icmpge +65 -> 143
    //   81: aload 4
    //   83: astore_3
    //   84: aload 4
    //   86: astore_2
    //   87: aload_0
    //   88: getfield 28	com/tencent/rtmp/a/b$b:c	Ljava/lang/String;
    //   91: iload_1
    //   92: aload_0
    //   93: getfield 28	com/tencent/rtmp/a/b$b:c	Ljava/lang/String;
    //   96: invokevirtual 53	java/lang/String:length	()I
    //   99: invokevirtual 57	java/lang/String:substring	(II)Ljava/lang/String;
    //   102: astore 6
    //   104: aload 4
    //   106: astore_3
    //   107: aload 4
    //   109: astore_2
    //   110: aload 5
    //   112: invokestatic 60	com/tencent/rtmp/a/b:b	(Lcom/tencent/rtmp/a/b;)Ljava/util/Map;
    //   115: ifnull +28 -> 143
    //   118: aload 4
    //   120: astore_3
    //   121: aload 4
    //   123: astore_2
    //   124: aload 5
    //   126: invokestatic 60	com/tencent/rtmp/a/b:b	(Lcom/tencent/rtmp/a/b;)Ljava/util/Map;
    //   129: aload 6
    //   131: aload 4
    //   133: iconst_1
    //   134: invokestatic 66	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   137: invokeinterface 72 3 0
    //   142: pop
    //   143: aload 4
    //   145: ifnull +45 -> 190
    //   148: aload 4
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 77	java/io/InputStream:close	()V
    //   155: return
    //   156: astore_2
    //   157: goto +23 -> 180
    //   160: astore 4
    //   162: aload_2
    //   163: astore_3
    //   164: ldc 79
    //   166: ldc 81
    //   168: aload 4
    //   170: invokestatic 87	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_2
    //   174: ifnull +16 -> 190
    //   177: goto -26 -> 151
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 77	java/io/InputStream:close	()V
    //   188: aload_2
    //   189: athrow
    //   190: return
    //   191: astore_2
    //   192: return
    //   193: astore_3
    //   194: goto -6 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	b
    //   54	38	1	i	int
    //   25	127	2	localObject1	Object
    //   156	33	2	localObject2	Object
    //   191	1	2	localIOException1	java.io.IOException
    //   27	158	3	localObject3	Object
    //   193	1	3	localIOException2	java.io.IOException
    //   37	112	4	localInputStream	java.io.InputStream
    //   160	9	4	localIOException3	java.io.IOException
    //   10	115	5	localb	b
    //   102	28	6	str	String
    // Exception table:
    //   from	to	target	type
    //   28	39	156	finally
    //   45	55	156	finally
    //   70	81	156	finally
    //   87	104	156	finally
    //   110	118	156	finally
    //   124	143	156	finally
    //   164	173	156	finally
    //   28	39	160	java/io/IOException
    //   45	55	160	java/io/IOException
    //   70	81	160	java/io/IOException
    //   87	104	160	java/io/IOException
    //   110	118	160	java/io/IOException
    //   124	143	160	java/io/IOException
    //   151	155	191	java/io/IOException
    //   184	188	193	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.a.b.b
 * JD-Core Version:    0.7.0.1
 */