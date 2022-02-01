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
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ldc 32
    //   6: invokestatic 38	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: new 40	java/io/ObjectInputStream
    //   12: dup
    //   13: new 42	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 46	java/io/ByteArrayInputStream:<init>	([B)V
    //   21: checkcast 48	java/io/InputStream
    //   24: invokespecial 51	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: checkcast 53	java/io/Closeable
    //   30: astore 5
    //   32: aconst_null
    //   33: checkcast 30	java/lang/Throwable
    //   36: astore_3
    //   37: aload 5
    //   39: checkcast 40	java/io/ObjectInputStream
    //   42: invokevirtual 57	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: instanceof 59
    //   52: ifne +5 -> 57
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_0
    //   58: checkcast 59	java/util/ArrayList
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull +28 -> 91
    //   66: aload_0
    //   67: checkcast 61	java/util/List
    //   70: invokestatic 67	kotlin/collections/CollectionsKt:firstOrNull	(Ljava/util/List;)Ljava/lang/Object;
    //   73: astore_0
    //   74: aload_3
    //   75: astore_1
    //   76: aload_0
    //   77: astore_2
    //   78: getstatic 73	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   81: astore 4
    //   83: aload 5
    //   85: aload_3
    //   86: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   89: aload_0
    //   90: areturn
    //   91: aconst_null
    //   92: astore_0
    //   93: goto -19 -> 74
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_0
    //   99: aload_3
    //   100: astore_1
    //   101: aload_0
    //   102: astore_2
    //   103: aload_3
    //   104: athrow
    //   105: astore_3
    //   106: aload_2
    //   107: astore_0
    //   108: aload_3
    //   109: astore_2
    //   110: aload 5
    //   112: aload_1
    //   113: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: aload_2
    //   117: athrow
    //   118: astore_2
    //   119: aload_0
    //   120: astore_1
    //   121: aload_2
    //   122: astore_0
    //   123: ldc 81
    //   125: ldc 83
    //   127: aload_0
    //   128: checkcast 30	java/lang/Throwable
    //   131: invokestatic 89	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   134: pop
    //   135: aload_1
    //   136: areturn
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_1
    //   140: goto -17 -> 123
    //   143: astore_2
    //   144: aload_0
    //   145: astore_1
    //   146: aload_2
    //   147: astore_0
    //   148: goto -25 -> 123
    //   151: astore_2
    //   152: aload_3
    //   153: astore_1
    //   154: aload 4
    //   156: astore_0
    //   157: goto -47 -> 110
    //   160: astore_3
    //   161: goto -62 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramArrayOfByte	byte[]
    //   45	109	1	localObject1	Object
    //   77	40	2	localObject2	Object
    //   118	4	2	localException1	java.lang.Exception
    //   143	4	2	localException2	java.lang.Exception
    //   151	1	2	localObject3	Object
    //   36	50	3	localThrowable1	java.lang.Throwable
    //   96	8	3	localThrowable2	java.lang.Throwable
    //   105	48	3	localObject4	Object
    //   160	1	3	localThrowable3	java.lang.Throwable
    //   1	154	4	localUnit	kotlin.Unit
    //   30	81	5	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   37	46	96	java/lang/Throwable
    //   48	55	96	java/lang/Throwable
    //   57	62	96	java/lang/Throwable
    //   66	74	96	java/lang/Throwable
    //   78	83	105	finally
    //   103	105	105	finally
    //   110	118	118	java/lang/Exception
    //   9	37	137	java/lang/Exception
    //   83	89	143	java/lang/Exception
    //   37	46	151	finally
    //   48	55	151	finally
    //   57	62	151	finally
    //   66	74	151	finally
    //   78	83	160	java/lang/Throwable
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
    //   12: astore_1
    //   13: new 101	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 104	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 6
    //   22: aload_3
    //   23: astore_1
    //   24: new 106	java/io/ObjectOutputStream
    //   27: dup
    //   28: aload 6
    //   30: checkcast 108	java/io/OutputStream
    //   33: invokespecial 111	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: checkcast 53	java/io/Closeable
    //   39: astore 5
    //   41: aload_3
    //   42: astore_1
    //   43: aconst_null
    //   44: checkcast 30	java/lang/Throwable
    //   47: astore 4
    //   49: aload_3
    //   50: astore_1
    //   51: aload_3
    //   52: astore_2
    //   53: aload 5
    //   55: checkcast 106	java/io/ObjectOutputStream
    //   58: astore 7
    //   60: aload_3
    //   61: astore_1
    //   62: aload_3
    //   63: astore_2
    //   64: aload 7
    //   66: iconst_1
    //   67: anewarray 113	java/io/Serializable
    //   70: dup
    //   71: iconst_0
    //   72: aload_0
    //   73: aastore
    //   74: invokestatic 117	kotlin/collections/CollectionsKt:arrayListOf	([Ljava/lang/Object;)Ljava/util/ArrayList;
    //   77: invokevirtual 121	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   80: aload_3
    //   81: astore_1
    //   82: aload_3
    //   83: astore_2
    //   84: aload 7
    //   86: invokevirtual 124	java/io/ObjectOutputStream:flush	()V
    //   89: aload_3
    //   90: astore_1
    //   91: aload_3
    //   92: astore_2
    //   93: aload 6
    //   95: invokevirtual 127	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   98: astore_0
    //   99: aload_0
    //   100: astore_1
    //   101: aload_0
    //   102: astore_2
    //   103: getstatic 73	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   106: astore_3
    //   107: aload_0
    //   108: astore_1
    //   109: aload 5
    //   111: aload 4
    //   113: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: aload_0
    //   117: areturn
    //   118: astore_2
    //   119: aload_1
    //   120: astore_0
    //   121: aload_2
    //   122: athrow
    //   123: astore_1
    //   124: aload 5
    //   126: aload_2
    //   127: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   130: aload_1
    //   131: athrow
    //   132: astore_2
    //   133: aload_0
    //   134: astore_1
    //   135: aload_2
    //   136: astore_0
    //   137: ldc 81
    //   139: ldc 129
    //   141: aload_0
    //   142: checkcast 30	java/lang/Throwable
    //   145: invokestatic 89	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   148: pop
    //   149: aload_1
    //   150: areturn
    //   151: astore_0
    //   152: goto -15 -> 137
    //   155: astore_1
    //   156: aload_2
    //   157: astore_0
    //   158: aload 4
    //   160: astore_2
    //   161: goto -37 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramSerializable	java.io.Serializable
    //   12	108	1	localObject1	Object
    //   123	8	1	localObject2	Object
    //   134	16	1	localSerializable	java.io.Serializable
    //   155	1	1	localObject3	Object
    //   52	51	2	localObject4	Object
    //   118	9	2	localThrowable1	java.lang.Throwable
    //   132	25	2	localException	java.lang.Exception
    //   160	1	2	localThrowable2	java.lang.Throwable
    //   10	97	3	localObject5	Object
    //   47	112	4	localThrowable3	java.lang.Throwable
    //   39	86	5	localCloseable	java.io.Closeable
    //   20	74	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   58	27	7	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   53	60	118	java/lang/Throwable
    //   64	80	118	java/lang/Throwable
    //   84	89	118	java/lang/Throwable
    //   93	99	118	java/lang/Throwable
    //   103	107	118	java/lang/Throwable
    //   121	123	123	finally
    //   124	132	132	java/lang/Exception
    //   13	22	151	java/lang/Exception
    //   24	41	151	java/lang/Exception
    //   43	49	151	java/lang/Exception
    //   109	116	151	java/lang/Exception
    //   53	60	155	finally
    //   64	80	155	finally
    //   84	89	155	finally
    //   93	99	155	finally
    //   103	107	155	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.SerializableKt
 * JD-Core Version:    0.7.0.1
 */