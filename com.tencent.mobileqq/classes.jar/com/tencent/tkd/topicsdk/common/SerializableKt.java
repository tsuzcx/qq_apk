package com.tencent.tkd.topicsdk.common;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toByteArray", "", "Ljava/io/Serializable;", "toSerializable", "T", "([B)Ljava/lang/Object;", "topicsdk-common_release"}, k=2, mv={1, 1, 16})
public final class SerializableKt
{
  /* Error */
  @org.jetbrains.annotations.Nullable
  public static final <T> T a(@org.jetbrains.annotations.NotNull byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 32
    //   3: invokestatic 38	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore_1
    //   14: aconst_null
    //   15: astore 7
    //   17: aload_1
    //   18: astore_2
    //   19: new 40	java/io/ObjectInputStream
    //   22: dup
    //   23: new 42	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 46	java/io/ByteArrayInputStream:<init>	([B)V
    //   31: checkcast 48	java/io/InputStream
    //   34: invokespecial 51	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: checkcast 53	java/io/Closeable
    //   40: astore 9
    //   42: aload_1
    //   43: astore_2
    //   44: aconst_null
    //   45: checkcast 30	java/lang/Throwable
    //   48: astore 4
    //   50: aload 5
    //   52: astore_1
    //   53: aload 4
    //   55: astore_3
    //   56: aload 6
    //   58: astore_2
    //   59: aload 9
    //   61: checkcast 40	java/io/ObjectInputStream
    //   64: invokevirtual 57	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   67: astore 8
    //   69: aload 8
    //   71: astore_0
    //   72: aload 5
    //   74: astore_1
    //   75: aload 4
    //   77: astore_3
    //   78: aload 6
    //   80: astore_2
    //   81: aload 8
    //   83: instanceof 59
    //   86: ifne +5 -> 91
    //   89: aconst_null
    //   90: astore_0
    //   91: aload 5
    //   93: astore_1
    //   94: aload 4
    //   96: astore_3
    //   97: aload 6
    //   99: astore_2
    //   100: aload_0
    //   101: checkcast 59	java/util/ArrayList
    //   104: astore 8
    //   106: aload 7
    //   108: astore_0
    //   109: aload 8
    //   111: ifnull +21 -> 132
    //   114: aload 5
    //   116: astore_1
    //   117: aload 4
    //   119: astore_3
    //   120: aload 6
    //   122: astore_2
    //   123: aload 8
    //   125: checkcast 61	java/util/List
    //   128: invokestatic 67	kotlin/collections/CollectionsKt:firstOrNull	(Ljava/util/List;)Ljava/lang/Object;
    //   131: astore_0
    //   132: aload_0
    //   133: astore_1
    //   134: aload 4
    //   136: astore_3
    //   137: aload_0
    //   138: astore_2
    //   139: getstatic 73	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   142: astore 5
    //   144: aload_0
    //   145: astore_2
    //   146: aload 9
    //   148: aload 4
    //   150: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   153: aload_0
    //   154: areturn
    //   155: astore_0
    //   156: goto +10 -> 166
    //   159: astore_0
    //   160: aload_2
    //   161: astore_1
    //   162: aload_0
    //   163: astore_3
    //   164: aload_0
    //   165: athrow
    //   166: aload_1
    //   167: astore_2
    //   168: aload 9
    //   170: aload_3
    //   171: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   174: aload_1
    //   175: astore_2
    //   176: aload_0
    //   177: athrow
    //   178: astore_0
    //   179: ldc 81
    //   181: ldc 83
    //   183: aload_0
    //   184: checkcast 30	java/lang/Throwable
    //   187: invokestatic 89	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   190: pop
    //   191: aload_2
    //   192: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramArrayOfByte	byte[]
    //   13	162	1	localObject1	Object
    //   18	174	2	localObject2	Object
    //   55	116	3	localObject3	Object
    //   48	101	4	localThrowable	java.lang.Throwable
    //   7	136	5	localUnit	kotlin.Unit
    //   10	111	6	localObject4	Object
    //   15	92	7	localObject5	Object
    //   67	57	8	localObject6	Object
    //   40	129	9	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   59	69	155	finally
    //   81	89	155	finally
    //   100	106	155	finally
    //   123	132	155	finally
    //   139	144	155	finally
    //   164	166	155	finally
    //   59	69	159	java/lang/Throwable
    //   81	89	159	java/lang/Throwable
    //   100	106	159	java/lang/Throwable
    //   123	132	159	java/lang/Throwable
    //   139	144	159	java/lang/Throwable
    //   19	42	178	java/lang/Exception
    //   44	50	178	java/lang/Exception
    //   146	153	178	java/lang/Exception
    //   168	174	178	java/lang/Exception
    //   176	178	178	java/lang/Exception
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public static final byte[] a(@org.jetbrains.annotations.NotNull java.io.Serializable paramSerializable)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 97
    //   3: invokestatic 38	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: checkcast 99	[B
    //   10: astore_3
    //   11: aload_3
    //   12: astore_2
    //   13: new 101	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 104	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 7
    //   22: aload_3
    //   23: astore_2
    //   24: new 106	java/io/ObjectOutputStream
    //   27: dup
    //   28: aload 7
    //   30: checkcast 108	java/io/OutputStream
    //   33: invokespecial 111	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: checkcast 53	java/io/Closeable
    //   39: astore 6
    //   41: aload_3
    //   42: astore_2
    //   43: aconst_null
    //   44: checkcast 30	java/lang/Throwable
    //   47: astore 5
    //   49: aload 5
    //   51: astore 4
    //   53: aload_3
    //   54: astore_1
    //   55: aload_3
    //   56: astore_2
    //   57: aload 6
    //   59: checkcast 106	java/io/ObjectOutputStream
    //   62: astore 8
    //   64: aload 5
    //   66: astore 4
    //   68: aload_3
    //   69: astore_1
    //   70: aload_3
    //   71: astore_2
    //   72: aload 8
    //   74: iconst_1
    //   75: anewarray 113	java/io/Serializable
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: invokestatic 117	kotlin/collections/CollectionsKt:arrayListOf	([Ljava/lang/Object;)Ljava/util/ArrayList;
    //   85: invokevirtual 121	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   88: aload 5
    //   90: astore 4
    //   92: aload_3
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: aload 8
    //   98: invokevirtual 124	java/io/ObjectOutputStream:flush	()V
    //   101: aload 5
    //   103: astore 4
    //   105: aload_3
    //   106: astore_1
    //   107: aload_3
    //   108: astore_2
    //   109: aload 7
    //   111: invokevirtual 127	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   114: astore_0
    //   115: aload 5
    //   117: astore 4
    //   119: aload_0
    //   120: astore_1
    //   121: aload_0
    //   122: astore_2
    //   123: getstatic 73	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   126: astore_3
    //   127: aload_0
    //   128: astore_2
    //   129: aload 6
    //   131: aload 5
    //   133: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
    //   156: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   159: aload_1
    //   160: astore_2
    //   161: aload_0
    //   162: athrow
    //   163: astore_0
    //   164: ldc 81
    //   166: ldc 129
    //   168: aload_0
    //   169: checkcast 30	java/lang/Throwable
    //   172: invokestatic 89	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   175: pop
    //   176: aload_2
    //   177: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramSerializable	java.io.Serializable
    //   54	106	1	localObject1	Object
    //   12	165	2	localObject2	Object
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
    //   13	22	163	java/lang/Exception
    //   24	41	163	java/lang/Exception
    //   43	49	163	java/lang/Exception
    //   129	136	163	java/lang/Exception
    //   152	159	163	java/lang/Exception
    //   161	163	163	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.SerializableKt
 * JD-Core Version:    0.7.0.1
 */