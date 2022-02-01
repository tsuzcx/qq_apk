package com.tencent.mobileqq.kandian.base.ktx;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toByteArray", "", "Ljava/io/Serializable;", "toSerializable", "T", "([B)Ljava/lang/Object;", "kandian-api_release"}, k=2, mv={1, 1, 16})
public final class RIJSerializableKtxKt
{
  /* Error */
  @org.jetbrains.annotations.Nullable
  public static final <T> T a(@org.jetbrains.annotations.NotNull byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 34
    //   3: invokestatic 40	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore_1
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 7
    //   20: aload_1
    //   21: astore_2
    //   22: aload 4
    //   24: astore_3
    //   25: new 42	java/io/ObjectInputStream
    //   28: dup
    //   29: new 44	java/io/ByteArrayInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 48	java/io/ByteArrayInputStream:<init>	([B)V
    //   37: checkcast 50	java/io/InputStream
    //   40: invokespecial 53	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: checkcast 55	java/io/Closeable
    //   46: astore 9
    //   48: aload_1
    //   49: astore_2
    //   50: aload 4
    //   52: astore_3
    //   53: aconst_null
    //   54: checkcast 32	java/lang/Throwable
    //   57: astore 8
    //   59: aload 5
    //   61: astore_1
    //   62: aload 8
    //   64: astore 4
    //   66: aload 6
    //   68: astore_2
    //   69: aload 9
    //   71: checkcast 42	java/io/ObjectInputStream
    //   74: invokevirtual 59	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   77: astore_3
    //   78: aload_3
    //   79: astore_0
    //   80: aload 5
    //   82: astore_1
    //   83: aload 8
    //   85: astore 4
    //   87: aload 6
    //   89: astore_2
    //   90: aload_3
    //   91: instanceof 61
    //   94: ifne +5 -> 99
    //   97: aconst_null
    //   98: astore_0
    //   99: aload 5
    //   101: astore_1
    //   102: aload 8
    //   104: astore 4
    //   106: aload 6
    //   108: astore_2
    //   109: aload_0
    //   110: checkcast 61	java/util/ArrayList
    //   113: astore_3
    //   114: aload 7
    //   116: astore_0
    //   117: aload_3
    //   118: ifnull +21 -> 139
    //   121: aload 5
    //   123: astore_1
    //   124: aload 8
    //   126: astore 4
    //   128: aload 6
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast 63	java/util/List
    //   135: invokestatic 69	kotlin/collections/CollectionsKt:firstOrNull	(Ljava/util/List;)Ljava/lang/Object;
    //   138: astore_0
    //   139: aload_0
    //   140: astore_1
    //   141: aload 8
    //   143: astore 4
    //   145: aload_0
    //   146: astore_2
    //   147: getstatic 75	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   150: astore_3
    //   151: aload_0
    //   152: astore_2
    //   153: aload_0
    //   154: astore_3
    //   155: aload 9
    //   157: aload 8
    //   159: invokestatic 81	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   162: aload_0
    //   163: areturn
    //   164: astore_0
    //   165: goto +11 -> 176
    //   168: astore_0
    //   169: aload_2
    //   170: astore_1
    //   171: aload_0
    //   172: astore 4
    //   174: aload_0
    //   175: athrow
    //   176: aload_1
    //   177: astore_2
    //   178: aload_1
    //   179: astore_3
    //   180: aload 9
    //   182: aload 4
    //   184: invokestatic 81	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   187: aload_1
    //   188: astore_2
    //   189: aload_1
    //   190: astore_3
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: aload_2
    //   195: astore_0
    //   196: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +78 -> 277
    //   202: new 89	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   209: astore_0
    //   210: aload_0
    //   211: ldc 94
    //   213: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_0
    //   218: aload_1
    //   219: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 103
    //   225: iconst_2
    //   226: aload_0
    //   227: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_2
    //   234: areturn
    //   235: astore_1
    //   236: aload_3
    //   237: astore_0
    //   238: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +36 -> 277
    //   244: new 89	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   251: astore_0
    //   252: aload_0
    //   253: ldc 94
    //   255: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: ldc 103
    //   267: iconst_2
    //   268: aload_0
    //   269: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_3
    //   276: astore_0
    //   277: aload_0
    //   278: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramArrayOfByte	byte[]
    //   13	177	1	localObject1	Object
    //   193	26	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   235	26	1	localIOException	java.io.IOException
    //   21	213	2	localObject2	Object
    //   24	252	3	localObject3	Object
    //   15	168	4	localObject4	Object
    //   7	115	5	localObject5	Object
    //   10	119	6	localObject6	Object
    //   18	97	7	localObject7	Object
    //   57	101	8	localThrowable	java.lang.Throwable
    //   46	135	9	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   69	78	164	finally
    //   90	97	164	finally
    //   109	114	164	finally
    //   131	139	164	finally
    //   147	151	164	finally
    //   174	176	164	finally
    //   69	78	168	java/lang/Throwable
    //   90	97	168	java/lang/Throwable
    //   109	114	168	java/lang/Throwable
    //   131	139	168	java/lang/Throwable
    //   147	151	168	java/lang/Throwable
    //   25	48	193	java/lang/ClassNotFoundException
    //   53	59	193	java/lang/ClassNotFoundException
    //   155	162	193	java/lang/ClassNotFoundException
    //   180	187	193	java/lang/ClassNotFoundException
    //   191	193	193	java/lang/ClassNotFoundException
    //   25	48	235	java/io/IOException
    //   53	59	235	java/io/IOException
    //   155	162	235	java/io/IOException
    //   180	187	235	java/io/IOException
    //   191	193	235	java/io/IOException
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public static final byte[] a(@org.jetbrains.annotations.NotNull java.io.Serializable paramSerializable)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 119
    //   3: invokestatic 40	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: checkcast 121	[B
    //   10: astore_3
    //   11: aload_3
    //   12: astore_2
    //   13: new 123	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 124	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 7
    //   22: aload_3
    //   23: astore_2
    //   24: new 126	java/io/ObjectOutputStream
    //   27: dup
    //   28: aload 7
    //   30: checkcast 128	java/io/OutputStream
    //   33: invokespecial 131	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: checkcast 55	java/io/Closeable
    //   39: astore 6
    //   41: aload_3
    //   42: astore_2
    //   43: aconst_null
    //   44: checkcast 32	java/lang/Throwable
    //   47: astore 5
    //   49: aload 5
    //   51: astore 4
    //   53: aload_3
    //   54: astore_1
    //   55: aload_3
    //   56: astore_2
    //   57: aload 6
    //   59: checkcast 126	java/io/ObjectOutputStream
    //   62: astore 8
    //   64: aload 5
    //   66: astore 4
    //   68: aload_3
    //   69: astore_1
    //   70: aload_3
    //   71: astore_2
    //   72: aload 8
    //   74: iconst_1
    //   75: anewarray 133	java/io/Serializable
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: invokestatic 137	kotlin/collections/CollectionsKt:arrayListOf	([Ljava/lang/Object;)Ljava/util/ArrayList;
    //   85: invokevirtual 141	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   88: aload 5
    //   90: astore 4
    //   92: aload_3
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: aload 8
    //   98: invokevirtual 144	java/io/ObjectOutputStream:flush	()V
    //   101: aload 5
    //   103: astore 4
    //   105: aload_3
    //   106: astore_1
    //   107: aload_3
    //   108: astore_2
    //   109: aload 7
    //   111: invokevirtual 147	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   114: astore_0
    //   115: aload 5
    //   117: astore 4
    //   119: aload_0
    //   120: astore_1
    //   121: aload_0
    //   122: astore_2
    //   123: getstatic 75	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   126: astore_3
    //   127: aload_0
    //   128: astore_2
    //   129: aload 6
    //   131: aload 5
    //   133: invokestatic 81	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   136: aload_0
    //   137: areturn
    //   138: astore_0
    //   139: goto +11 -> 150
    //   142: astore_0
    //   143: aload_0
    //   144: astore 4
    //   146: aload_2
    //   147: astore_1
    //   148: aload_0
    //   149: athrow
    //   150: aload_1
    //   151: astore_2
    //   152: aload 6
    //   154: aload 4
    //   156: invokestatic 81	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   159: aload_1
    //   160: astore_2
    //   161: aload_0
    //   162: athrow
    //   163: astore_0
    //   164: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +34 -> 201
    //   170: new 89	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   177: astore_1
    //   178: aload_1
    //   179: ldc 149
    //   181: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_1
    //   186: aload_0
    //   187: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 103
    //   193: iconst_2
    //   194: aload_1
    //   195: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload_2
    //   202: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramSerializable	java.io.Serializable
    //   54	141	1	localObject1	Object
    //   12	190	2	localObject2	Object
    //   10	117	3	localObject3	Object
    //   51	104	4	localObject4	Object
    //   47	85	5	localThrowable	java.lang.Throwable
    //   39	114	6	localCloseable	java.io.Closeable
    //   20	90	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   62	35	8	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   57	64	138	finally
    //   72	88	138	finally
    //   96	101	138	finally
    //   109	115	138	finally
    //   123	127	138	finally
    //   148	150	138	finally
    //   57	64	142	java/lang/Throwable
    //   72	88	142	java/lang/Throwable
    //   96	101	142	java/lang/Throwable
    //   109	115	142	java/lang/Throwable
    //   123	127	142	java/lang/Throwable
    //   13	22	163	java/io/IOException
    //   24	41	163	java/io/IOException
    //   43	49	163	java/io/IOException
    //   129	136	163	java/io/IOException
    //   152	159	163	java/io/IOException
    //   161	163	163	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.RIJSerializableKtxKt
 * JD-Core Version:    0.7.0.1
 */