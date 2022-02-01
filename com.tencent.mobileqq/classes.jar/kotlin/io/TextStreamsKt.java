package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="TextStreamsKt")
public final class TextStreamsKt
{
  @InlineOnly
  private static final BufferedReader buffered(@NotNull Reader paramReader, int paramInt)
  {
    if ((paramReader instanceof BufferedReader)) {
      return (BufferedReader)paramReader;
    }
    return new BufferedReader(paramReader, paramInt);
  }
  
  @InlineOnly
  private static final BufferedWriter buffered(@NotNull Writer paramWriter, int paramInt)
  {
    if ((paramWriter instanceof BufferedWriter)) {
      return (BufferedWriter)paramWriter;
    }
    return new BufferedWriter(paramWriter, paramInt);
  }
  
  public static final long copyTo(@NotNull Reader paramReader, @NotNull Writer paramWriter, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramReader, "$this$copyTo");
    Intrinsics.checkParameterIsNotNull(paramWriter, "out");
    char[] arrayOfChar = new char[paramInt];
    paramInt = paramReader.read(arrayOfChar);
    long l = 0L;
    while (paramInt >= 0)
    {
      paramWriter.write(arrayOfChar, 0, paramInt);
      l += paramInt;
      paramInt = paramReader.read(arrayOfChar);
    }
    return l;
  }
  
  /* Error */
  public static final void forEachLine(@NotNull Reader paramReader, @NotNull Function1<? super String, kotlin.Unit> paramFunction1)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 99
    //   3: invokestatic 77	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 100
    //   9: invokestatic 77	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: instanceof 52
    //   16: ifeq +11 -> 27
    //   19: aload_0
    //   20: checkcast 52	java/io/BufferedReader
    //   23: astore_0
    //   24: goto +15 -> 39
    //   27: new 52	java/io/BufferedReader
    //   30: dup
    //   31: aload_0
    //   32: sipush 8192
    //   35: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   38: astore_0
    //   39: aload_0
    //   40: checkcast 102	java/io/Closeable
    //   43: astore_3
    //   44: aconst_null
    //   45: checkcast 97	java/lang/Throwable
    //   48: astore_2
    //   49: aload_2
    //   50: astore_0
    //   51: aload_3
    //   52: checkcast 52	java/io/BufferedReader
    //   55: invokestatic 105	kotlin/io/TextStreamsKt:lineSequence	(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;
    //   58: invokeinterface 111 1 0
    //   63: astore 4
    //   65: aload_2
    //   66: astore_0
    //   67: aload 4
    //   69: invokeinterface 117 1 0
    //   74: ifeq +22 -> 96
    //   77: aload_2
    //   78: astore_0
    //   79: aload_1
    //   80: aload 4
    //   82: invokeinterface 121 1 0
    //   87: invokeinterface 127 2 0
    //   92: pop
    //   93: goto -28 -> 65
    //   96: aload_2
    //   97: astore_0
    //   98: getstatic 133	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   101: astore_1
    //   102: aload_3
    //   103: aload_2
    //   104: invokestatic 139	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   107: return
    //   108: astore_1
    //   109: goto +8 -> 117
    //   112: astore_1
    //   113: aload_1
    //   114: astore_0
    //   115: aload_1
    //   116: athrow
    //   117: aload_3
    //   118: aload_0
    //   119: invokestatic 139	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   122: goto +5 -> 127
    //   125: aload_1
    //   126: athrow
    //   127: goto -2 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramReader	Reader
    //   0	130	1	paramFunction1	Function1<? super String, kotlin.Unit>
    //   48	56	2	localThrowable	java.lang.Throwable
    //   43	75	3	localCloseable	java.io.Closeable
    //   63	18	4	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   51	65	108	finally
    //   67	77	108	finally
    //   79	93	108	finally
    //   98	102	108	finally
    //   115	117	108	finally
    //   51	65	112	java/lang/Throwable
    //   67	77	112	java/lang/Throwable
    //   79	93	112	java/lang/Throwable
    //   98	102	112	java/lang/Throwable
  }
  
  @NotNull
  public static final Sequence<String> lineSequence(@NotNull BufferedReader paramBufferedReader)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedReader, "$this$lineSequence");
    return SequencesKt.constrainOnce((Sequence)new LinesSequence(paramBufferedReader));
  }
  
  /* Error */
  @NotNull
  public static final byte[] readBytes(@NotNull URL paramURL)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 158
    //   3: invokestatic 77	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokevirtual 164	java/net/URL:openStream	()Ljava/io/InputStream;
    //   10: checkcast 102	java/io/Closeable
    //   13: astore_2
    //   14: aconst_null
    //   15: checkcast 97	java/lang/Throwable
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: aload_2
    //   22: checkcast 166	java/io/InputStream
    //   25: astore_3
    //   26: aload_1
    //   27: astore_0
    //   28: aload_3
    //   29: ldc 168
    //   31: invokestatic 171	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   34: aload_1
    //   35: astore_0
    //   36: aload_3
    //   37: invokestatic 176	kotlin/io/ByteStreamsKt:readBytes	(Ljava/io/InputStream;)[B
    //   40: astore_3
    //   41: aload_2
    //   42: aload_1
    //   43: invokestatic 139	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   46: aload_3
    //   47: areturn
    //   48: astore_1
    //   49: goto +8 -> 57
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: aload_1
    //   56: athrow
    //   57: aload_2
    //   58: aload_0
    //   59: invokestatic 139	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramURL	URL
    //   18	25	1	localThrowable1	java.lang.Throwable
    //   48	1	1	localObject1	Object
    //   52	11	1	localThrowable2	java.lang.Throwable
    //   13	45	2	localCloseable	java.io.Closeable
    //   25	22	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	26	48	finally
    //   28	34	48	finally
    //   36	41	48	finally
    //   55	57	48	finally
    //   21	26	52	java/lang/Throwable
    //   28	34	52	java/lang/Throwable
    //   36	41	52	java/lang/Throwable
  }
  
  @NotNull
  public static final List<String> readLines(@NotNull Reader paramReader)
  {
    Intrinsics.checkParameterIsNotNull(paramReader, "$this$readLines");
    ArrayList localArrayList = new ArrayList();
    forEachLine(paramReader, (Function1)new TextStreamsKt.readLines.1(localArrayList));
    return (List)localArrayList;
  }
  
  @NotNull
  public static final String readText(@NotNull Reader paramReader)
  {
    Intrinsics.checkParameterIsNotNull(paramReader, "$this$readText");
    StringWriter localStringWriter = new StringWriter();
    copyTo$default(paramReader, (Writer)localStringWriter, 0, 2, null);
    paramReader = localStringWriter.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramReader, "buffer.toString()");
    return paramReader;
  }
  
  @InlineOnly
  private static final String readText(@NotNull URL paramURL, Charset paramCharset)
  {
    return new String(readBytes(paramURL), paramCharset);
  }
  
  @InlineOnly
  private static final StringReader reader(@NotNull String paramString)
  {
    return new StringReader(paramString);
  }
  
  /* Error */
  public static final <T> T useLines(@NotNull Reader paramReader, @NotNull Function1<? super Sequence<String>, ? extends T> paramFunction1)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 231
    //   3: invokestatic 77	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 232
    //   9: invokestatic 77	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: instanceof 52
    //   16: ifeq +11 -> 27
    //   19: aload_0
    //   20: checkcast 52	java/io/BufferedReader
    //   23: astore_0
    //   24: goto +15 -> 39
    //   27: new 52	java/io/BufferedReader
    //   30: dup
    //   31: aload_0
    //   32: sipush 8192
    //   35: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   38: astore_0
    //   39: aload_0
    //   40: checkcast 102	java/io/Closeable
    //   43: astore_3
    //   44: aconst_null
    //   45: checkcast 97	java/lang/Throwable
    //   48: astore_2
    //   49: aload_2
    //   50: astore_0
    //   51: aload_1
    //   52: aload_3
    //   53: checkcast 52	java/io/BufferedReader
    //   56: invokestatic 105	kotlin/io/TextStreamsKt:lineSequence	(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;
    //   59: invokeinterface 127 2 0
    //   64: astore_1
    //   65: iconst_1
    //   66: invokestatic 238	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   69: iconst_1
    //   70: iconst_1
    //   71: iconst_0
    //   72: invokestatic 244	kotlin/internal/PlatformImplementationsKt:apiVersionIsAtLeast	(III)Z
    //   75: ifeq +11 -> 86
    //   78: aload_3
    //   79: aload_2
    //   80: invokestatic 139	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   83: goto +9 -> 92
    //   86: aload_3
    //   87: invokeinterface 247 1 0
    //   92: iconst_1
    //   93: invokestatic 250	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_1
    //   99: goto +8 -> 107
    //   102: astore_1
    //   103: aload_1
    //   104: astore_0
    //   105: aload_1
    //   106: athrow
    //   107: iconst_1
    //   108: invokestatic 238	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   111: iconst_1
    //   112: iconst_1
    //   113: iconst_0
    //   114: invokestatic 244	kotlin/internal/PlatformImplementationsKt:apiVersionIsAtLeast	(III)Z
    //   117: ifne +25 -> 142
    //   120: aload_0
    //   121: ifnonnull +12 -> 133
    //   124: aload_3
    //   125: invokeinterface 247 1 0
    //   130: goto +17 -> 147
    //   133: aload_3
    //   134: invokeinterface 247 1 0
    //   139: goto +8 -> 147
    //   142: aload_3
    //   143: aload_0
    //   144: invokestatic 139	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   147: iconst_1
    //   148: invokestatic 250	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   151: aload_1
    //   152: athrow
    //   153: astore_0
    //   154: goto -7 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramReader	Reader
    //   0	157	1	paramFunction1	Function1<? super Sequence<String>, ? extends T>
    //   48	32	2	localThrowable	java.lang.Throwable
    //   43	100	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   51	65	98	finally
    //   105	107	98	finally
    //   51	65	102	java/lang/Throwable
    //   133	139	153	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.TextStreamsKt
 * JD-Core Version:    0.7.0.1
 */