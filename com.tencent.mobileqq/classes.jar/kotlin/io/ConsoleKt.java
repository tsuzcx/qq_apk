package kotlin.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"BUFFER_SIZE", "", "LINE_SEPARATOR_MAX_LENGTH", "decoder", "Ljava/nio/charset/CharsetDecoder;", "getDecoder", "()Ljava/nio/charset/CharsetDecoder;", "decoder$delegate", "Lkotlin/Lazy;", "print", "", "message", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "inputStream", "Ljava/io/InputStream;", "endsWithLineSeparator", "Ljava/nio/CharBuffer;", "flipBack", "Ljava/nio/Buffer;", "offloadPrefixTo", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tryDecode", "byteBuffer", "Ljava/nio/ByteBuffer;", "charBuffer", "isEndOfStream", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="ConsoleKt")
public final class ConsoleKt
{
  private static final int BUFFER_SIZE = 32;
  private static final int LINE_SEPARATOR_MAX_LENGTH = 2;
  private static final Lazy decoder$delegate = LazyKt.lazy((Function0)ConsoleKt.decoder.2.INSTANCE);
  
  private static final boolean endsWithLineSeparator(@NotNull CharBuffer paramCharBuffer)
  {
    int i = paramCharBuffer.position();
    return (i > 0) && (paramCharBuffer.get(i - 1) == '\n');
  }
  
  private static final void flipBack(@NotNull Buffer paramBuffer)
  {
    paramBuffer.position(paramBuffer.limit());
    paramBuffer.limit(paramBuffer.capacity());
  }
  
  private static final CharsetDecoder getDecoder()
  {
    return (CharsetDecoder)decoder$delegate.getValue();
  }
  
  private static final void offloadPrefixTo(@NotNull CharBuffer paramCharBuffer, StringBuilder paramStringBuilder)
  {
    paramCharBuffer.flip();
    int j = paramCharBuffer.limit();
    int i = 0;
    while (i < j - 1)
    {
      paramStringBuilder.append(paramCharBuffer.get());
      i += 1;
    }
    paramCharBuffer.compact();
  }
  
  @InlineOnly
  private static final void print(byte paramByte)
  {
    System.out.print(Byte.valueOf(paramByte));
  }
  
  @InlineOnly
  private static final void print(char paramChar)
  {
    System.out.print(paramChar);
  }
  
  @InlineOnly
  private static final void print(double paramDouble)
  {
    System.out.print(paramDouble);
  }
  
  @InlineOnly
  private static final void print(float paramFloat)
  {
    System.out.print(paramFloat);
  }
  
  @InlineOnly
  private static final void print(int paramInt)
  {
    System.out.print(paramInt);
  }
  
  @InlineOnly
  private static final void print(long paramLong)
  {
    System.out.print(paramLong);
  }
  
  @InlineOnly
  private static final void print(Object paramObject)
  {
    System.out.print(paramObject);
  }
  
  @InlineOnly
  private static final void print(short paramShort)
  {
    System.out.print(Short.valueOf(paramShort));
  }
  
  @InlineOnly
  private static final void print(boolean paramBoolean)
  {
    System.out.print(paramBoolean);
  }
  
  @InlineOnly
  private static final void print(char[] paramArrayOfChar)
  {
    System.out.print(paramArrayOfChar);
  }
  
  @InlineOnly
  private static final void println()
  {
    System.out.println();
  }
  
  @InlineOnly
  private static final void println(byte paramByte)
  {
    System.out.println(Byte.valueOf(paramByte));
  }
  
  @InlineOnly
  private static final void println(char paramChar)
  {
    System.out.println(paramChar);
  }
  
  @InlineOnly
  private static final void println(double paramDouble)
  {
    System.out.println(paramDouble);
  }
  
  @InlineOnly
  private static final void println(float paramFloat)
  {
    System.out.println(paramFloat);
  }
  
  @InlineOnly
  private static final void println(int paramInt)
  {
    System.out.println(paramInt);
  }
  
  @InlineOnly
  private static final void println(long paramLong)
  {
    System.out.println(paramLong);
  }
  
  @InlineOnly
  private static final void println(Object paramObject)
  {
    System.out.println(paramObject);
  }
  
  @InlineOnly
  private static final void println(short paramShort)
  {
    System.out.println(Short.valueOf(paramShort));
  }
  
  @InlineOnly
  private static final void println(boolean paramBoolean)
  {
    System.out.println(paramBoolean);
  }
  
  @InlineOnly
  private static final void println(char[] paramArrayOfChar)
  {
    System.out.println(paramArrayOfChar);
  }
  
  @Nullable
  public static final String readLine()
  {
    InputStream localInputStream = System.in;
    Intrinsics.checkExpressionValueIsNotNull(localInputStream, "System.`in`");
    return readLine(localInputStream, getDecoder());
  }
  
  @Nullable
  public static final String readLine(@NotNull InputStream paramInputStream, @NotNull CharsetDecoder paramCharsetDecoder)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "inputStream");
    Intrinsics.checkParameterIsNotNull(paramCharsetDecoder, "decoder");
    float f1 = paramCharsetDecoder.maxCharsPerByte();
    float f2 = 1;
    int j = 0;
    int i;
    if (f1 <= f2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(32);
      CharBuffer localCharBuffer = CharBuffer.allocate(4);
      StringBuilder localStringBuilder = new StringBuilder();
      int k = paramInputStream.read();
      i = k;
      if (k == -1) {
        return null;
      }
      do
      {
        localByteBuffer.put((byte)i);
        Intrinsics.checkExpressionValueIsNotNull(localByteBuffer, "byteBuffer");
        Intrinsics.checkExpressionValueIsNotNull(localCharBuffer, "charBuffer");
        if (tryDecode(paramCharsetDecoder, localByteBuffer, localCharBuffer, false))
        {
          if (endsWithLineSeparator(localCharBuffer)) {
            break;
          }
          if (localCharBuffer.remaining() < 2) {
            offloadPrefixTo(localCharBuffer, localStringBuilder);
          }
        }
        k = paramInputStream.read();
        i = k;
      } while (k != -1);
      tryDecode(paramCharsetDecoder, localByteBuffer, localCharBuffer, true);
      paramCharsetDecoder.reset();
      k = localCharBuffer.position();
      i = k;
      if (k > 0)
      {
        i = k;
        if (localCharBuffer.get(k - 1) == '\n')
        {
          k -= 1;
          i = k;
          if (k > 0)
          {
            i = k;
            if (localCharBuffer.get(k - 1) == '\r') {
              i = k - 1;
            }
          }
        }
      }
      localCharBuffer.flip();
      while (j < i)
      {
        localStringBuilder.append(localCharBuffer.get());
        j += 1;
      }
      return localStringBuilder.toString();
    }
    paramInputStream = (Throwable)new IllegalArgumentException("Encodings with multiple chars per byte are not supported".toString());
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  private static final boolean tryDecode(@NotNull CharsetDecoder paramCharsetDecoder, ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer, boolean paramBoolean)
  {
    int i = paramCharBuffer.position();
    paramByteBuffer.flip();
    paramCharsetDecoder = paramCharsetDecoder.decode(paramByteBuffer, paramCharBuffer, paramBoolean);
    if (paramCharsetDecoder.isError()) {
      paramCharsetDecoder.throwException();
    }
    if (paramCharBuffer.position() > i) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      paramByteBuffer.clear();
      return paramBoolean;
    }
    flipBack((Buffer)paramByteBuffer);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.ConsoleKt
 * JD-Core Version:    0.7.0.1
 */