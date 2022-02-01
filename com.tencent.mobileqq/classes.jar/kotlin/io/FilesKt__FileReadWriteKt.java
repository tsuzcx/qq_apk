package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
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
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/io/FilesKt")
public class FilesKt__FileReadWriteKt
  extends FilesKt__FilePathComponentsKt
{
  public static final void appendBytes(@NotNull File paramFile, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$appendBytes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    Closeable localCloseable = (Closeable)new FileOutputStream(paramFile, true);
    Throwable localThrowable = (Throwable)null;
    paramFile = localThrowable;
    try
    {
      ((FileOutputStream)localCloseable).write(paramArrayOfByte);
      paramFile = localThrowable;
      paramArrayOfByte = Unit.INSTANCE;
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramFile = paramArrayOfByte;
      throw paramArrayOfByte;
    }
    finally
    {
      CloseableKt.closeFinally(localCloseable, paramFile);
    }
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
    //   96: aload_2
    //   97: astore_0
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: aload 4
    //   103: aload_0
    //   104: invokestatic 106	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramFile	File
    //   0	109	1	paramInt	int
    //   0	109	2	paramFunction2	Function2<? super byte[], ? super Integer, Unit>
    //   40	38	3	localThrowable	Throwable
    //   34	68	4	localCloseable	Closeable
    //   21	60	5	arrayOfByte	byte[]
    //   48	5	6	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   43	50	95	java/lang/Throwable
    //   52	60	95	java/lang/Throwable
    //   66	70	95	java/lang/Throwable
    //   79	92	95	java/lang/Throwable
    //   43	50	100	finally
    //   52	60	100	finally
    //   66	70	100	finally
    //   79	92	100	finally
    //   98	100	100	finally
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
    if ((paramFile instanceof BufferedWriter)) {}
    for (paramFile = (BufferedWriter)paramFile;; paramFile = new BufferedWriter(paramFile, 8192)) {
      return new PrintWriter((Writer)paramFile);
    }
  }
  
  @NotNull
  public static final byte[] readBytes(@NotNull File paramFile)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$readBytes");
    Closeable localCloseable = (Closeable)new FileInputStream(paramFile);
    Throwable localThrowable = (Throwable)null;
    Object localObject1 = localThrowable;
    Object localObject2;
    long l;
    try
    {
      localObject2 = (FileInputStream)localCloseable;
      localObject1 = localThrowable;
      l = paramFile.length();
      if (l > 2147483647)
      {
        localObject1 = localThrowable;
        throw ((Throwable)new OutOfMemoryError("File " + paramFile + " is too big (" + l + " bytes) to fit in memory."));
      }
    }
    catch (Throwable paramFile)
    {
      localObject1 = paramFile;
      throw paramFile;
    }
    finally
    {
      CloseableKt.closeFinally(localCloseable, (Throwable)localObject1);
    }
    int j = (int)l;
    localObject1 = localThrowable;
    byte[] arrayOfByte = new byte[j];
    int k;
    if (j > 0)
    {
      localObject1 = localThrowable;
      k = ((FileInputStream)localObject2).read(arrayOfByte, i, j);
      if (k >= 0) {}
    }
    else
    {
      if (j <= 0) {
        break label205;
      }
      localObject1 = localThrowable;
      paramFile = Arrays.copyOf(arrayOfByte, i);
      localObject1 = localThrowable;
      Intrinsics.checkExpressionValueIsNotNull(paramFile, "java.util.Arrays.copyOf(this, newSize)");
    }
    for (;;)
    {
      CloseableKt.closeFinally(localCloseable, localThrowable);
      return paramFile;
      j -= k;
      i += k;
      break;
      label205:
      localObject1 = localThrowable;
      i = ((FileInputStream)localObject2).read();
      if (i == -1)
      {
        paramFile = arrayOfByte;
      }
      else
      {
        localObject1 = localThrowable;
        ExposingBufferByteArrayOutputStream localExposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream(8193);
        localObject1 = localThrowable;
        localExposingBufferByteArrayOutputStream.write(i);
        localObject1 = localThrowable;
        ByteStreamsKt.copyTo$default((InputStream)localObject2, (OutputStream)localExposingBufferByteArrayOutputStream, 0, 2, null);
        localObject1 = localThrowable;
        i = arrayOfByte.length + localExposingBufferByteArrayOutputStream.size();
        if (i < 0)
        {
          localObject1 = localThrowable;
          throw ((Throwable)new OutOfMemoryError("File " + paramFile + " is too big to fit in memory."));
        }
        localObject1 = localThrowable;
        paramFile = localExposingBufferByteArrayOutputStream.getBuffer();
        localObject1 = localThrowable;
        localObject2 = Arrays.copyOf(arrayOfByte, i);
        localObject1 = localThrowable;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.util.Arrays.copyOf(this, newSize)");
        localObject1 = localThrowable;
        paramFile = ArraysKt.copyInto(paramFile, (byte[])localObject2, arrayOfByte.length, 0, localExposingBufferByteArrayOutputStream.size());
      }
    }
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
  
  @NotNull
  public static final String readText(@NotNull File paramFile, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$readText");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    Closeable localCloseable = (Closeable)new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset);
    paramCharset = (Throwable)null;
    paramFile = paramCharset;
    try
    {
      String str = TextStreamsKt.readText((Reader)localCloseable);
      return str;
    }
    catch (Throwable paramCharset)
    {
      paramFile = paramCharset;
      throw paramCharset;
    }
    finally
    {
      CloseableKt.closeFinally(localCloseable, paramFile);
    }
  }
  
  @InlineOnly
  private static final InputStreamReader reader(@NotNull File paramFile, Charset paramCharset)
  {
    return new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset);
  }
  
  public static final <T> T useLines(@NotNull File paramFile, @NotNull Charset paramCharset, @NotNull Function1<? super Sequence<String>, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$useLines");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    paramFile = (Reader)new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset);
    if ((paramFile instanceof BufferedReader)) {
      paramFile = (BufferedReader)paramFile;
    }
    Closeable localCloseable;
    for (;;)
    {
      localCloseable = (Closeable)paramFile;
      paramCharset = (Throwable)null;
      paramFile = paramCharset;
      try
      {
        paramFunction1 = paramFunction1.invoke(TextStreamsKt.lineSequence((BufferedReader)localCloseable));
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
          CloseableKt.closeFinally(localCloseable, paramCharset);
        }
        for (;;)
        {
          InlineMarker.finallyEnd(1);
          return paramFunction1;
          paramFile = new BufferedReader(paramFile, 8192);
          break;
          localCloseable.close();
        }
        CloseableKt.closeFinally(localCloseable, paramFile);
      }
      catch (Throwable paramCharset)
      {
        paramFile = paramCharset;
        throw paramCharset;
      }
      finally
      {
        InlineMarker.finallyStart(1);
        if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {}
      }
    }
    for (;;)
    {
      InlineMarker.finallyEnd(1);
      throw paramCharset;
      if (paramFile == null) {
        localCloseable.close();
      } else {
        try
        {
          localCloseable.close();
        }
        catch (Throwable paramFile) {}
      }
    }
  }
  
  public static final void writeBytes(@NotNull File paramFile, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$writeBytes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    Closeable localCloseable = (Closeable)new FileOutputStream(paramFile);
    Throwable localThrowable = (Throwable)null;
    paramFile = localThrowable;
    try
    {
      ((FileOutputStream)localCloseable).write(paramArrayOfByte);
      paramFile = localThrowable;
      paramArrayOfByte = Unit.INSTANCE;
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramFile = paramArrayOfByte;
      throw paramArrayOfByte;
    }
    finally
    {
      CloseableKt.closeFinally(localCloseable, paramFile);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.io.FilesKt__FileReadWriteKt
 * JD-Core Version:    0.7.0.1
 */