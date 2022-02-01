package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.ByteIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="ByteStreamsKt")
public final class ByteStreamsKt
{
  @InlineOnly
  private static final BufferedInputStream buffered(@NotNull InputStream paramInputStream, int paramInt)
  {
    if ((paramInputStream instanceof BufferedInputStream)) {
      return (BufferedInputStream)paramInputStream;
    }
    return new BufferedInputStream(paramInputStream, paramInt);
  }
  
  @InlineOnly
  private static final BufferedOutputStream buffered(@NotNull OutputStream paramOutputStream, int paramInt)
  {
    if ((paramOutputStream instanceof BufferedOutputStream)) {
      return (BufferedOutputStream)paramOutputStream;
    }
    return new BufferedOutputStream(paramOutputStream, paramInt);
  }
  
  @InlineOnly
  private static final BufferedReader bufferedReader(@NotNull InputStream paramInputStream, Charset paramCharset)
  {
    paramInputStream = (Reader)new InputStreamReader(paramInputStream, paramCharset);
    if ((paramInputStream instanceof BufferedReader)) {
      return (BufferedReader)paramInputStream;
    }
    return new BufferedReader(paramInputStream, 8192);
  }
  
  @InlineOnly
  private static final BufferedWriter bufferedWriter(@NotNull OutputStream paramOutputStream, Charset paramCharset)
  {
    paramOutputStream = (Writer)new OutputStreamWriter(paramOutputStream, paramCharset);
    if ((paramOutputStream instanceof BufferedWriter)) {
      return (BufferedWriter)paramOutputStream;
    }
    return new BufferedWriter(paramOutputStream, 8192);
  }
  
  @InlineOnly
  private static final ByteArrayInputStream byteInputStream(@NotNull String paramString, Charset paramCharset)
  {
    if (paramString != null)
    {
      paramString = paramString.getBytes(paramCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      return new ByteArrayInputStream(paramString);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final long copyTo(@NotNull InputStream paramInputStream, @NotNull OutputStream paramOutputStream, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "$this$copyTo");
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "out");
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = paramInputStream.read(arrayOfByte);
    long l = 0L;
    while (paramInt >= 0)
    {
      paramOutputStream.write(arrayOfByte, 0, paramInt);
      l += paramInt;
      paramInt = paramInputStream.read(arrayOfByte);
    }
    return l;
  }
  
  @InlineOnly
  private static final ByteArrayInputStream inputStream(@NotNull byte[] paramArrayOfByte)
  {
    return new ByteArrayInputStream(paramArrayOfByte);
  }
  
  @InlineOnly
  private static final ByteArrayInputStream inputStream(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @NotNull
  public static final ByteIterator iterator(@NotNull BufferedInputStream paramBufferedInputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedInputStream, "$this$iterator");
    return (ByteIterator)new ByteStreamsKt.iterator.1(paramBufferedInputStream);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] readBytes(@NotNull InputStream paramInputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "$this$readBytes");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, paramInputStream.available()));
    copyTo$default(paramInputStream, (OutputStream)localByteArrayOutputStream, 0, 2, null);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    Intrinsics.checkExpressionValueIsNotNull(paramInputStream, "buffer.toByteArray()");
    return paramInputStream;
  }
  
  @Deprecated(message="Use readBytes() overload without estimatedSize parameter", replaceWith=@ReplaceWith(expression="readBytes()", imports={}))
  @NotNull
  public static final byte[] readBytes(@NotNull InputStream paramInputStream, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "$this$readBytes");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(Math.max(paramInt, paramInputStream.available()));
    copyTo$default(paramInputStream, (OutputStream)localByteArrayOutputStream, 0, 2, null);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    Intrinsics.checkExpressionValueIsNotNull(paramInputStream, "buffer.toByteArray()");
    return paramInputStream;
  }
  
  @InlineOnly
  private static final InputStreamReader reader(@NotNull InputStream paramInputStream, Charset paramCharset)
  {
    return new InputStreamReader(paramInputStream, paramCharset);
  }
  
  @InlineOnly
  private static final OutputStreamWriter writer(@NotNull OutputStream paramOutputStream, Charset paramCharset)
  {
    return new OutputStreamWriter(paramOutputStream, paramCharset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.io.ByteStreamsKt
 * JD-Core Version:    0.7.0.1
 */