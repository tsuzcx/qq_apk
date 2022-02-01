package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k=1, mv={1, 1, 16})
public final class ByteString$Companion
{
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.decodeBase64()", imports={"okio.ByteString.Companion.decodeBase64"}))
  @JvmName(name="-deprecated_decodeBase64")
  @Nullable
  public final ByteString -deprecated_decodeBase64(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return ((Companion)this).decodeBase64(paramString);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.decodeHex()", imports={"okio.ByteString.Companion.decodeHex"}))
  @JvmName(name="-deprecated_decodeHex")
  @NotNull
  public final ByteString -deprecated_decodeHex(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return ((Companion)this).decodeHex(paramString);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.encode(charset)", imports={"okio.ByteString.Companion.encode"}))
  @JvmName(name="-deprecated_encodeString")
  @NotNull
  public final ByteString -deprecated_encodeString(@NotNull String paramString, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    return ((Companion)this).encodeString(paramString, paramCharset);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.encodeUtf8()", imports={"okio.ByteString.Companion.encodeUtf8"}))
  @JvmName(name="-deprecated_encodeUtf8")
  @NotNull
  public final ByteString -deprecated_encodeUtf8(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return ((Companion)this).encodeUtf8(paramString);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="buffer.toByteString()", imports={"okio.ByteString.Companion.toByteString"}))
  @JvmName(name="-deprecated_of")
  @NotNull
  public final ByteString -deprecated_of(@NotNull ByteBuffer paramByteBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramByteBuffer, "buffer");
    return ((Companion)this).of(paramByteBuffer);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="array.toByteString(offset, byteCount)", imports={"okio.ByteString.Companion.toByteString"}))
  @JvmName(name="-deprecated_of")
  @NotNull
  public final ByteString -deprecated_of(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    return ((Companion)this).of(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="inputstream.readByteString(byteCount)", imports={"okio.ByteString.Companion.readByteString"}))
  @JvmName(name="-deprecated_read")
  @NotNull
  public final ByteString -deprecated_read(@NotNull InputStream paramInputStream, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "inputstream");
    return ((Companion)this).read(paramInputStream, paramInt);
  }
  
  @JvmStatic
  @Nullable
  public final ByteString decodeBase64(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$decodeBase64");
    paramString = -Base64.decodeBase64ToArray(paramString);
    if (paramString != null) {
      return new ByteString(paramString);
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public final ByteString decodeHex(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$decodeHex");
    int i = paramString.length();
    int j = 0;
    if (i % 2 == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = new byte[paramString.length() / 2];
      int k = localObject.length;
      i = j;
      while (i < k)
      {
        j = i * 2;
        localObject[i] = ((byte)((ByteStringKt.access$decodeHexDigit(paramString.charAt(j)) << 4) + ByteStringKt.access$decodeHexDigit(paramString.charAt(j + 1))));
        i += 1;
      }
      return new ByteString((byte[])localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected hex string: ");
    ((StringBuilder)localObject).append(paramString);
    paramString = (Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  @JvmStatic
  @JvmName(name="encodeString")
  @NotNull
  public final ByteString encodeString(@NotNull String paramString, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$encode");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    paramString = paramString.getBytes(paramCharset);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    return new ByteString(paramString);
  }
  
  @JvmStatic
  @NotNull
  public final ByteString encodeUtf8(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$encodeUtf8");
    ByteString localByteString = new ByteString(-Platform.asUtf8ToByteArray(paramString));
    localByteString.setUtf8$okio(paramString);
    return localByteString;
  }
  
  @JvmStatic
  @JvmName(name="of")
  @NotNull
  public final ByteString of(@NotNull ByteBuffer paramByteBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramByteBuffer, "$this$toByteString");
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    return new ByteString(arrayOfByte);
  }
  
  @JvmStatic
  @NotNull
  public final ByteString of(@NotNull byte... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "data");
    paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
    Intrinsics.checkExpressionValueIsNotNull(paramVarArgs, "java.util.Arrays.copyOf(this, size)");
    return new ByteString(paramVarArgs);
  }
  
  @JvmStatic
  @JvmName(name="of")
  @NotNull
  public final ByteString of(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toByteString");
    -Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    return new ByteString(ArraysKt.copyOfRange(paramArrayOfByte, paramInt1, paramInt2 + paramInt1));
  }
  
  @JvmStatic
  @JvmName(name="read")
  @NotNull
  public final ByteString read(@NotNull InputStream paramInputStream, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "$this$readByteString");
    int j = 0;
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      byte[] arrayOfByte = new byte[paramInt];
      i = j;
      while (i < paramInt)
      {
        j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j != -1) {
          i += j;
        } else {
          throw ((Throwable)new EOFException());
        }
      }
      return new ByteString(arrayOfByte);
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("byteCount < 0: ");
    paramInputStream.append(paramInt);
    paramInputStream = (Throwable)new IllegalArgumentException(paramInputStream.toString().toString());
    for (;;)
    {
      throw paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.ByteString.Companion
 * JD-Core Version:    0.7.0.1
 */