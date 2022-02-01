package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__FileReadWriteKt
  extends FilesKt__FilePathComponentsKt
{
  /* Error */
  public static final void appendBytes(@NotNull File paramFile, @NotNull byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 76
    //   3: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 83
    //   9: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new 85	java/io/FileOutputStream
    //   15: dup
    //   16: aload_0
    //   17: iconst_1
    //   18: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   21: checkcast 90	java/io/Closeable
    //   24: astore_3
    //   25: aconst_null
    //   26: checkcast 74	java/lang/Throwable
    //   29: astore_2
    //   30: aload_2
    //   31: astore_0
    //   32: aload_3
    //   33: checkcast 85	java/io/FileOutputStream
    //   36: aload_1
    //   37: invokevirtual 94	java/io/FileOutputStream:write	([B)V
    //   40: aload_2
    //   41: astore_0
    //   42: getstatic 100	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   45: astore_1
    //   46: aload_3
    //   47: aload_2
    //   48: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   51: return
    //   52: astore_1
    //   53: goto +8 -> 61
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: aload_1
    //   60: athrow
    //   61: aload_3
    //   62: aload_0
    //   63: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramFile	File
    //   0	68	1	paramArrayOfByte	byte[]
    //   29	19	2	localThrowable	java.lang.Throwable
    //   24	38	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   32	40	52	finally
    //   42	46	52	finally
    //   59	61	52	finally
    //   32	40	56	java/lang/Throwable
    //   42	46	56	java/lang/Throwable
  }
  
  public static final void appendText(@NotNull File paramFile, @NotNull String paramString, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$appendText");
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    paramString = paramString.getBytes(paramCharset);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    FilesKt.appendBytes(paramFile, paramString);
  }
  
  @InlineOnly
  private static final BufferedReader bufferedReader(@NotNull File paramFile, Charset paramCharset, int paramInt)
  {
    paramFile = (Reader)new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset);
    if ((paramFile instanceof BufferedReader)) {
      return (BufferedReader)paramFile;
    }
    return new BufferedReader(paramFile, paramInt);
  }
  
  @InlineOnly
  private static final BufferedWriter bufferedWriter(@NotNull File paramFile, Charset paramCharset, int paramInt)
  {
    paramFile = (Writer)new OutputStreamWriter((OutputStream)new FileOutputStream(paramFile), paramCharset);
    if ((paramFile instanceof BufferedWriter)) {
      return (BufferedWriter)paramFile;
    }
    return new BufferedWriter(paramFile, paramInt);
  }
  
  /* Error */
  public static final void forEachBlock(@NotNull File paramFile, int paramInt, @NotNull Function2<? super byte[], ? super Integer, Unit> paramFunction2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 180
    //   3: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 181
    //   9: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: iload_1
    //   13: sipush 512
    //   16: invokestatic 187	kotlin/ranges/RangesKt:coerceAtLeast	(II)I
    //   19: newarray byte
    //   21: astore 5
    //   23: new 141	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: checkcast 90	java/io/Closeable
    //   34: astore 4
    //   36: aconst_null
    //   37: checkcast 74	java/lang/Throwable
    //   40: astore_3
    //   41: aload_3
    //   42: astore_0
    //   43: aload 4
    //   45: checkcast 141	java/io/FileInputStream
    //   48: astore 6
    //   50: aload_3
    //   51: astore_0
    //   52: aload 6
    //   54: aload 5
    //   56: invokevirtual 191	java/io/FileInputStream:read	([B)I
    //   59: istore_1
    //   60: iload_1
    //   61: ifgt +16 -> 77
    //   64: aload_3
    //   65: astore_0
    //   66: getstatic 100	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   69: astore_2
    //   70: aload 4
    //   72: aload_3
    //   73: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   76: return
    //   77: aload_3
    //   78: astore_0
    //   79: aload_2
    //   80: aload 5
    //   82: iload_1
    //   83: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: invokeinterface 203 3 0
    //   91: pop
    //   92: goto -42 -> 50
    //   95: astore_2
    //   96: goto +8 -> 104
    //   99: astore_2
    //   100: aload_2
    //   101: astore_0
    //   102: aload_2
    //   103: athrow
    //   104: aload 4
    //   106: aload_0
    //   107: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   110: goto +5 -> 115
    //   113: aload_2
    //   114: athrow
    //   115: goto -2 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramFile	File
    //   0	118	1	paramInt	int
    //   0	118	2	paramFunction2	Function2<? super byte[], ? super Integer, Unit>
    //   40	38	3	localThrowable	java.lang.Throwable
    //   34	71	4	localCloseable	java.io.Closeable
    //   21	60	5	arrayOfByte	byte[]
    //   48	5	6	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   43	50	95	finally
    //   52	60	95	finally
    //   66	70	95	finally
    //   79	92	95	finally
    //   102	104	95	finally
    //   43	50	99	java/lang/Throwable
    //   52	60	99	java/lang/Throwable
    //   66	70	99	java/lang/Throwable
    //   79	92	99	java/lang/Throwable
  }
  
  public static final void forEachBlock(@NotNull File paramFile, @NotNull Function2<? super byte[], ? super Integer, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$forEachBlock");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    FilesKt.forEachBlock(paramFile, 4096, paramFunction2);
  }
  
  public static final void forEachLine(@NotNull File paramFile, @NotNull Charset paramCharset, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$forEachLine");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    TextStreamsKt.forEachLine((Reader)new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset)), paramFunction1);
  }
  
  @InlineOnly
  private static final FileInputStream inputStream(@NotNull File paramFile)
  {
    return new FileInputStream(paramFile);
  }
  
  @InlineOnly
  private static final FileOutputStream outputStream(@NotNull File paramFile)
  {
    return new FileOutputStream(paramFile);
  }
  
  @InlineOnly
  private static final PrintWriter printWriter(@NotNull File paramFile, Charset paramCharset)
  {
    paramFile = (Writer)new OutputStreamWriter((OutputStream)new FileOutputStream(paramFile), paramCharset);
    if ((paramFile instanceof BufferedWriter)) {
      paramFile = (BufferedWriter)paramFile;
    } else {
      paramFile = new BufferedWriter(paramFile, 8192);
    }
    return new PrintWriter((Writer)paramFile);
  }
  
  /* Error */
  @NotNull
  public static final byte[] readBytes(@NotNull File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 238
    //   3: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: new 141	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: checkcast 90	java/io/Closeable
    //   17: astore 9
    //   19: aconst_null
    //   20: checkcast 74	java/lang/Throwable
    //   23: astore 7
    //   25: aload 7
    //   27: astore 6
    //   29: aload 9
    //   31: checkcast 141	java/io/FileInputStream
    //   34: astore 11
    //   36: aload 7
    //   38: astore 6
    //   40: aload_0
    //   41: invokevirtual 244	java/io/File:length	()J
    //   44: lstore 4
    //   46: lload 4
    //   48: ldc 245
    //   50: i2l
    //   51: lcmp
    //   52: ifgt +302 -> 354
    //   55: lload 4
    //   57: l2i
    //   58: istore_2
    //   59: aload 7
    //   61: astore 6
    //   63: iload_2
    //   64: newarray byte
    //   66: astore 8
    //   68: iconst_0
    //   69: istore_1
    //   70: iload_2
    //   71: ifle +35 -> 106
    //   74: aload 7
    //   76: astore 6
    //   78: aload 11
    //   80: aload 8
    //   82: iload_1
    //   83: iload_2
    //   84: invokevirtual 248	java/io/FileInputStream:read	([BII)I
    //   87: istore_3
    //   88: iload_3
    //   89: ifge +6 -> 95
    //   92: goto +14 -> 106
    //   95: iload_2
    //   96: iload_3
    //   97: isub
    //   98: istore_2
    //   99: iload_1
    //   100: iload_3
    //   101: iadd
    //   102: istore_1
    //   103: goto -33 -> 70
    //   106: iload_2
    //   107: ifle +28 -> 135
    //   110: aload 7
    //   112: astore 6
    //   114: aload 8
    //   116: iload_1
    //   117: invokestatic 254	java/util/Arrays:copyOf	([BI)[B
    //   120: astore_0
    //   121: aload 7
    //   123: astore 6
    //   125: aload_0
    //   126: ldc_w 256
    //   129: invokestatic 123	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   132: goto +143 -> 275
    //   135: aload 7
    //   137: astore 6
    //   139: aload 11
    //   141: invokevirtual 259	java/io/FileInputStream:read	()I
    //   144: istore_1
    //   145: iload_1
    //   146: iconst_m1
    //   147: if_icmpne +9 -> 156
    //   150: aload 8
    //   152: astore_0
    //   153: goto +122 -> 275
    //   156: aload 7
    //   158: astore 6
    //   160: new 261	kotlin/io/ExposingBufferByteArrayOutputStream
    //   163: dup
    //   164: sipush 8193
    //   167: invokespecial 264	kotlin/io/ExposingBufferByteArrayOutputStream:<init>	(I)V
    //   170: astore 10
    //   172: aload 7
    //   174: astore 6
    //   176: aload 10
    //   178: iload_1
    //   179: invokevirtual 266	kotlin/io/ExposingBufferByteArrayOutputStream:write	(I)V
    //   182: aload 7
    //   184: astore 6
    //   186: aload 11
    //   188: checkcast 146	java/io/InputStream
    //   191: aload 10
    //   193: checkcast 165	java/io/OutputStream
    //   196: iconst_0
    //   197: iconst_2
    //   198: aconst_null
    //   199: invokestatic 272	kotlin/io/ByteStreamsKt:copyTo$default	(Ljava/io/InputStream;Ljava/io/OutputStream;IILjava/lang/Object;)J
    //   202: pop2
    //   203: aload 7
    //   205: astore 6
    //   207: aload 8
    //   209: arraylength
    //   210: aload 10
    //   212: invokevirtual 275	kotlin/io/ExposingBufferByteArrayOutputStream:size	()I
    //   215: iadd
    //   216: istore_1
    //   217: iload_1
    //   218: iflt +66 -> 284
    //   221: aload 7
    //   223: astore 6
    //   225: aload 10
    //   227: invokevirtual 279	kotlin/io/ExposingBufferByteArrayOutputStream:getBuffer	()[B
    //   230: astore_0
    //   231: aload 7
    //   233: astore 6
    //   235: aload 8
    //   237: iload_1
    //   238: invokestatic 254	java/util/Arrays:copyOf	([BI)[B
    //   241: astore 11
    //   243: aload 7
    //   245: astore 6
    //   247: aload 11
    //   249: ldc_w 256
    //   252: invokestatic 123	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   255: aload 7
    //   257: astore 6
    //   259: aload_0
    //   260: aload 11
    //   262: aload 8
    //   264: arraylength
    //   265: iconst_0
    //   266: aload 10
    //   268: invokevirtual 275	kotlin/io/ExposingBufferByteArrayOutputStream:size	()I
    //   271: invokestatic 285	kotlin/collections/ArraysKt:copyInto	([B[BIII)[B
    //   274: astore_0
    //   275: aload 9
    //   277: aload 7
    //   279: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   282: aload_0
    //   283: areturn
    //   284: aload 7
    //   286: astore 6
    //   288: new 287	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   295: astore 8
    //   297: aload 7
    //   299: astore 6
    //   301: aload 8
    //   303: ldc_w 290
    //   306: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 7
    //   312: astore 6
    //   314: aload 8
    //   316: aload_0
    //   317: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 7
    //   323: astore 6
    //   325: aload 8
    //   327: ldc_w 299
    //   330: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 7
    //   336: astore 6
    //   338: new 301	java/lang/OutOfMemoryError
    //   341: dup
    //   342: aload 8
    //   344: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokespecial 308	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   350: checkcast 74	java/lang/Throwable
    //   353: athrow
    //   354: aload 7
    //   356: astore 6
    //   358: new 287	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   365: astore 8
    //   367: aload 7
    //   369: astore 6
    //   371: aload 8
    //   373: ldc_w 290
    //   376: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload 7
    //   382: astore 6
    //   384: aload 8
    //   386: aload_0
    //   387: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 7
    //   393: astore 6
    //   395: aload 8
    //   397: ldc_w 310
    //   400: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 7
    //   406: astore 6
    //   408: aload 8
    //   410: lload 4
    //   412: invokevirtual 313	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 7
    //   418: astore 6
    //   420: aload 8
    //   422: ldc_w 315
    //   425: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 7
    //   431: astore 6
    //   433: new 301	java/lang/OutOfMemoryError
    //   436: dup
    //   437: aload 8
    //   439: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokespecial 308	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   445: checkcast 74	java/lang/Throwable
    //   448: athrow
    //   449: astore_0
    //   450: goto +9 -> 459
    //   453: astore_0
    //   454: aload_0
    //   455: astore 6
    //   457: aload_0
    //   458: athrow
    //   459: aload 9
    //   461: aload 6
    //   463: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   466: goto +5 -> 471
    //   469: aload_0
    //   470: athrow
    //   471: goto -2 -> 469
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	paramFile	File
    //   69	169	1	i	int
    //   58	49	2	j	int
    //   87	15	3	k	int
    //   44	367	4	l	long
    //   27	435	6	localObject1	java.lang.Object
    //   23	407	7	localThrowable	java.lang.Throwable
    //   66	372	8	localObject2	java.lang.Object
    //   17	443	9	localCloseable	java.io.Closeable
    //   170	97	10	localExposingBufferByteArrayOutputStream	ExposingBufferByteArrayOutputStream
    //   34	227	11	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   29	36	449	finally
    //   40	46	449	finally
    //   63	68	449	finally
    //   78	88	449	finally
    //   114	121	449	finally
    //   125	132	449	finally
    //   139	145	449	finally
    //   160	172	449	finally
    //   176	182	449	finally
    //   186	203	449	finally
    //   207	217	449	finally
    //   225	231	449	finally
    //   235	243	449	finally
    //   247	255	449	finally
    //   259	275	449	finally
    //   288	297	449	finally
    //   301	310	449	finally
    //   314	321	449	finally
    //   325	334	449	finally
    //   338	354	449	finally
    //   358	367	449	finally
    //   371	380	449	finally
    //   384	391	449	finally
    //   395	404	449	finally
    //   408	416	449	finally
    //   420	429	449	finally
    //   433	449	449	finally
    //   457	459	449	finally
    //   29	36	453	java/lang/Throwable
    //   40	46	453	java/lang/Throwable
    //   63	68	453	java/lang/Throwable
    //   78	88	453	java/lang/Throwable
    //   114	121	453	java/lang/Throwable
    //   125	132	453	java/lang/Throwable
    //   139	145	453	java/lang/Throwable
    //   160	172	453	java/lang/Throwable
    //   176	182	453	java/lang/Throwable
    //   186	203	453	java/lang/Throwable
    //   207	217	453	java/lang/Throwable
    //   225	231	453	java/lang/Throwable
    //   235	243	453	java/lang/Throwable
    //   247	255	453	java/lang/Throwable
    //   259	275	453	java/lang/Throwable
    //   288	297	453	java/lang/Throwable
    //   301	310	453	java/lang/Throwable
    //   314	321	453	java/lang/Throwable
    //   325	334	453	java/lang/Throwable
    //   338	354	453	java/lang/Throwable
    //   358	367	453	java/lang/Throwable
    //   371	380	453	java/lang/Throwable
    //   384	391	453	java/lang/Throwable
    //   395	404	453	java/lang/Throwable
    //   408	416	453	java/lang/Throwable
    //   420	429	453	java/lang/Throwable
    //   433	449	453	java/lang/Throwable
  }
  
  @NotNull
  public static final List<String> readLines(@NotNull File paramFile, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$readLines");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    ArrayList localArrayList = new ArrayList();
    FilesKt.forEachLine(paramFile, paramCharset, (Function1)new FilesKt__FileReadWriteKt.readLines.1(localArrayList));
    return (List)localArrayList;
  }
  
  /* Error */
  @NotNull
  public static final String readText(@NotNull File paramFile, @NotNull Charset paramCharset)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 338
    //   4: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_1
    //   8: ldc 112
    //   10: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 139	java/io/InputStreamReader
    //   16: dup
    //   17: new 141	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: checkcast 146	java/io/InputStream
    //   28: aload_1
    //   29: invokespecial 149	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   32: checkcast 90	java/io/Closeable
    //   35: astore_2
    //   36: aconst_null
    //   37: checkcast 74	java/lang/Throwable
    //   40: astore_1
    //   41: aload_1
    //   42: astore_0
    //   43: aload_2
    //   44: checkcast 139	java/io/InputStreamReader
    //   47: checkcast 151	java/io/Reader
    //   50: invokestatic 341	kotlin/io/TextStreamsKt:readText	(Ljava/io/Reader;)Ljava/lang/String;
    //   53: astore_3
    //   54: aload_2
    //   55: aload_1
    //   56: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   59: aload_3
    //   60: areturn
    //   61: astore_1
    //   62: goto +8 -> 70
    //   65: astore_1
    //   66: aload_1
    //   67: astore_0
    //   68: aload_1
    //   69: athrow
    //   70: aload_2
    //   71: aload_0
    //   72: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramFile	File
    //   0	77	1	paramCharset	Charset
    //   35	36	2	localCloseable	java.io.Closeable
    //   53	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   43	54	61	finally
    //   68	70	61	finally
    //   43	54	65	java/lang/Throwable
  }
  
  @InlineOnly
  private static final InputStreamReader reader(@NotNull File paramFile, Charset paramCharset)
  {
    return new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset);
  }
  
  /* Error */
  public static final <T> T useLines(@NotNull File paramFile, @NotNull Charset paramCharset, @NotNull Function1<? super kotlin.sequences.Sequence<String>, ? extends T> paramFunction1)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 350
    //   4: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_1
    //   8: ldc 112
    //   10: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_2
    //   14: ldc_w 351
    //   17: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: new 139	java/io/InputStreamReader
    //   23: dup
    //   24: new 141	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: checkcast 146	java/io/InputStream
    //   35: aload_1
    //   36: invokespecial 149	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   39: checkcast 151	java/io/Reader
    //   42: astore_0
    //   43: aload_0
    //   44: instanceof 153
    //   47: ifeq +11 -> 58
    //   50: aload_0
    //   51: checkcast 153	java/io/BufferedReader
    //   54: astore_0
    //   55: goto +15 -> 70
    //   58: new 153	java/io/BufferedReader
    //   61: dup
    //   62: aload_0
    //   63: sipush 8192
    //   66: invokespecial 156	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   69: astore_0
    //   70: aload_0
    //   71: checkcast 90	java/io/Closeable
    //   74: astore_3
    //   75: aconst_null
    //   76: checkcast 74	java/lang/Throwable
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: aload_3
    //   84: checkcast 153	java/io/BufferedReader
    //   87: invokestatic 355	kotlin/io/TextStreamsKt:lineSequence	(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;
    //   90: invokeinterface 358 2 0
    //   95: astore_2
    //   96: iconst_1
    //   97: invokestatic 363	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   100: iconst_1
    //   101: iconst_1
    //   102: iconst_0
    //   103: invokestatic 369	kotlin/internal/PlatformImplementationsKt:apiVersionIsAtLeast	(III)Z
    //   106: ifeq +11 -> 117
    //   109: aload_3
    //   110: aload_1
    //   111: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   114: goto +9 -> 123
    //   117: aload_3
    //   118: invokeinterface 372 1 0
    //   123: iconst_1
    //   124: invokestatic 375	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   127: aload_2
    //   128: areturn
    //   129: astore_1
    //   130: goto +8 -> 138
    //   133: astore_1
    //   134: aload_1
    //   135: astore_0
    //   136: aload_1
    //   137: athrow
    //   138: iconst_1
    //   139: invokestatic 363	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   142: iconst_1
    //   143: iconst_1
    //   144: iconst_0
    //   145: invokestatic 369	kotlin/internal/PlatformImplementationsKt:apiVersionIsAtLeast	(III)Z
    //   148: ifne +25 -> 173
    //   151: aload_0
    //   152: ifnonnull +12 -> 164
    //   155: aload_3
    //   156: invokeinterface 372 1 0
    //   161: goto +17 -> 178
    //   164: aload_3
    //   165: invokeinterface 372 1 0
    //   170: goto +8 -> 178
    //   173: aload_3
    //   174: aload_0
    //   175: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   178: iconst_1
    //   179: invokestatic 375	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   182: aload_1
    //   183: athrow
    //   184: astore_0
    //   185: goto -7 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramFile	File
    //   0	188	1	paramCharset	Charset
    //   0	188	2	paramFunction1	Function1<? super kotlin.sequences.Sequence<String>, ? extends T>
    //   74	100	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   82	96	129	finally
    //   136	138	129	finally
    //   82	96	133	java/lang/Throwable
    //   164	170	184	java/lang/Throwable
  }
  
  /* Error */
  public static final void writeBytes(@NotNull File paramFile, @NotNull byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 380
    //   4: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_1
    //   8: ldc 83
    //   10: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 85	java/io/FileOutputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 163	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: checkcast 90	java/io/Closeable
    //   24: astore_3
    //   25: aconst_null
    //   26: checkcast 74	java/lang/Throwable
    //   29: astore_2
    //   30: aload_2
    //   31: astore_0
    //   32: aload_3
    //   33: checkcast 85	java/io/FileOutputStream
    //   36: aload_1
    //   37: invokevirtual 94	java/io/FileOutputStream:write	([B)V
    //   40: aload_2
    //   41: astore_0
    //   42: getstatic 100	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   45: astore_1
    //   46: aload_3
    //   47: aload_2
    //   48: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   51: return
    //   52: astore_1
    //   53: goto +8 -> 61
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: aload_1
    //   60: athrow
    //   61: aload_3
    //   62: aload_0
    //   63: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramFile	File
    //   0	68	1	paramArrayOfByte	byte[]
    //   29	19	2	localThrowable	java.lang.Throwable
    //   24	38	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   32	40	52	finally
    //   42	46	52	finally
    //   59	61	52	finally
    //   32	40	56	java/lang/Throwable
    //   42	46	56	java/lang/Throwable
  }
  
  public static final void writeText(@NotNull File paramFile, @NotNull String paramString, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$writeText");
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    paramString = paramString.getBytes(paramCharset);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    FilesKt.writeBytes(paramFile, paramString);
  }
  
  @InlineOnly
  private static final OutputStreamWriter writer(@NotNull File paramFile, Charset paramCharset)
  {
    return new OutputStreamWriter((OutputStream)new FileOutputStream(paramFile), paramCharset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.io.FilesKt__FileReadWriteKt
 * JD-Core Version:    0.7.0.1
 */