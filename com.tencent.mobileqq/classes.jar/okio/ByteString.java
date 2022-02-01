package okio;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k=1, mv={1, 1, 16})
public class ByteString
  implements Serializable, Comparable<ByteString>
{
  public static final ByteString.Companion Companion = new ByteString.Companion(null);
  @JvmField
  @NotNull
  public static final ByteString EMPTY = new ByteString(new byte[0]);
  private static final long serialVersionUID = 1L;
  @NotNull
  private final byte[] data;
  private transient int hashCode;
  @Nullable
  private transient String utf8;
  
  public ByteString(@NotNull byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  @JvmStatic
  @Nullable
  public static final ByteString decodeBase64(@NotNull String paramString)
  {
    return Companion.decodeBase64(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final ByteString decodeHex(@NotNull String paramString)
  {
    return Companion.decodeHex(paramString);
  }
  
  @JvmStatic
  @JvmName(name="encodeString")
  @NotNull
  public static final ByteString encodeString(@NotNull String paramString, @NotNull Charset paramCharset)
  {
    return Companion.encodeString(paramString, paramCharset);
  }
  
  @JvmStatic
  @NotNull
  public static final ByteString encodeUtf8(@NotNull String paramString)
  {
    return Companion.encodeUtf8(paramString);
  }
  
  @JvmStatic
  @JvmName(name="of")
  @NotNull
  public static final ByteString of(@NotNull ByteBuffer paramByteBuffer)
  {
    return Companion.of(paramByteBuffer);
  }
  
  @JvmStatic
  @NotNull
  public static final ByteString of(@NotNull byte... paramVarArgs)
  {
    return Companion.of(paramVarArgs);
  }
  
  @JvmStatic
  @JvmName(name="of")
  @NotNull
  public static final ByteString of(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return Companion.of(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @JvmStatic
  @JvmName(name="read")
  @NotNull
  public static final ByteString read(@NotNull InputStream paramInputStream, int paramInt)
  {
    return Companion.read(paramInputStream, paramInt);
  }
  
  private final void readObject(ObjectInputStream paramObjectInputStream)
  {
    int i = paramObjectInputStream.readInt();
    paramObjectInputStream = Companion.read((InputStream)paramObjectInputStream, i);
    Field localField = ByteString.class.getDeclaredField("data");
    Intrinsics.checkExpressionValueIsNotNull(localField, "field");
    localField.setAccessible(true);
    localField.set(this, paramObjectInputStream.data);
  }
  
  private final void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(this.data.length);
    paramObjectOutputStream.write(this.data);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to operator function", replaceWith=@ReplaceWith(expression="this[index]", imports={}))
  @JvmName(name="-deprecated_getByte")
  public final byte -deprecated_getByte(int paramInt)
  {
    return getByte(paramInt);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
  @JvmName(name="-deprecated_size")
  public final int -deprecated_size()
  {
    return size();
  }
  
  @NotNull
  public ByteBuffer asByteBuffer()
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    Intrinsics.checkExpressionValueIsNotNull(localByteBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
    return localByteBuffer;
  }
  
  @NotNull
  public String base64()
  {
    return -Base64.encodeBase64$default(getData$okio(), null, 1, null);
  }
  
  @NotNull
  public String base64Url()
  {
    return -Base64.encodeBase64(getData$okio(), -Base64.getBASE64_URL_SAFE());
  }
  
  public int compareTo(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    int j = size();
    int k = paramByteString.size();
    int m = Math.min(j, k);
    int i = 0;
    while (i < m)
    {
      int n = getByte(i) & 0xFF;
      int i1 = paramByteString.getByte(i) & 0xFF;
      if (n == i1)
      {
        i += 1;
      }
      else
      {
        if (n >= i1) {
          break label95;
        }
        return -1;
      }
    }
    if (j == k) {
      return 0;
    }
    if (j < k) {
      return -1;
    }
    label95:
    return 1;
  }
  
  @NotNull
  public ByteString digest$okio(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "algorithm");
    paramString = MessageDigest.getInstance(paramString).digest(this.data);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "MessageDigest.getInstance(algorithm).digest(data)");
    return new ByteString(paramString);
  }
  
  public final boolean endsWith(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "suffix");
    return rangeEquals(size() - paramByteString.size(), paramByteString, 0, paramByteString.size());
  }
  
  public final boolean endsWith(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "suffix");
    return rangeEquals(size() - paramArrayOfByte.length, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ByteString))
    {
      paramObject = (ByteString)paramObject;
      if ((paramObject.size() == getData$okio().length) && (paramObject.rangeEquals(0, getData$okio(), 0, getData$okio().length))) {
        return true;
      }
    }
    return false;
  }
  
  @JvmName(name="getByte")
  public final byte getByte(int paramInt)
  {
    return internalGet$okio(paramInt);
  }
  
  @NotNull
  public final byte[] getData$okio()
  {
    return this.data;
  }
  
  public final int getHashCode$okio()
  {
    return this.hashCode;
  }
  
  public int getSize$okio()
  {
    return getData$okio().length;
  }
  
  @Nullable
  public final String getUtf8$okio()
  {
    return this.utf8;
  }
  
  public int hashCode()
  {
    int i = getHashCode$okio();
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(getData$okio());
    setHashCode$okio(i);
    return i;
  }
  
  @NotNull
  public String hex()
  {
    char[] arrayOfChar = new char[getData$okio().length * 2];
    byte[] arrayOfByte = getData$okio();
    int k = arrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = ByteStringKt.getHEX_DIGIT_CHARS()[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = ByteStringKt.getHEX_DIGIT_CHARS()[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  @NotNull
  public ByteString hmac$okio(@NotNull String paramString, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "algorithm");
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init((Key)new SecretKeySpec(paramByteString.toByteArray(), paramString));
      paramString = localMac.doFinal(this.data);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "mac.doFinal(data)");
      paramString = new ByteString(paramString);
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      throw ((Throwable)new IllegalArgumentException((Throwable)paramString));
    }
  }
  
  @NotNull
  public ByteString hmacSha1(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac$okio("HmacSHA1", paramByteString);
  }
  
  @NotNull
  public ByteString hmacSha256(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac$okio("HmacSHA256", paramByteString);
  }
  
  @NotNull
  public ByteString hmacSha512(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac$okio("HmacSHA512", paramByteString);
  }
  
  @JvmOverloads
  public final int indexOf(@NotNull ByteString paramByteString)
  {
    return indexOf$default(this, paramByteString, 0, 2, null);
  }
  
  @JvmOverloads
  public final int indexOf(@NotNull ByteString paramByteString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    return indexOf(paramByteString.internalArray$okio(), paramInt);
  }
  
  @JvmOverloads
  public int indexOf(@NotNull byte[] paramArrayOfByte)
  {
    return indexOf$default(this, paramArrayOfByte, 0, 2, null);
  }
  
  @JvmOverloads
  public int indexOf(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    int i = getData$okio().length - paramArrayOfByte.length;
    paramInt = Math.max(paramInt, 0);
    if (paramInt <= i) {
      for (;;)
      {
        if (-Util.arrayRangeEquals(getData$okio(), paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
          return paramInt;
        }
        if (paramInt == i) {
          break;
        }
        paramInt += 1;
      }
    }
    return -1;
  }
  
  @NotNull
  public byte[] internalArray$okio()
  {
    return getData$okio();
  }
  
  public byte internalGet$okio(int paramInt)
  {
    return getData$okio()[paramInt];
  }
  
  @JvmOverloads
  public final int lastIndexOf(@NotNull ByteString paramByteString)
  {
    return lastIndexOf$default(this, paramByteString, 0, 2, null);
  }
  
  @JvmOverloads
  public final int lastIndexOf(@NotNull ByteString paramByteString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    return lastIndexOf(paramByteString.internalArray$okio(), paramInt);
  }
  
  @JvmOverloads
  public int lastIndexOf(@NotNull byte[] paramArrayOfByte)
  {
    return lastIndexOf$default(this, paramArrayOfByte, 0, 2, null);
  }
  
  @JvmOverloads
  public int lastIndexOf(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    paramInt = Math.min(paramInt, getData$okio().length - paramArrayOfByte.length);
    while (paramInt >= 0)
    {
      if (-Util.arrayRangeEquals(getData$okio(), paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  @NotNull
  public ByteString md5()
  {
    return digest$okio("MD5");
  }
  
  public boolean rangeEquals(int paramInt1, @NotNull ByteString paramByteString, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    return paramByteString.rangeEquals(paramInt2, getData$okio(), paramInt1, paramInt3);
  }
  
  public boolean rangeEquals(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    return (paramInt1 >= 0) && (paramInt1 <= getData$okio().length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (-Util.arrayRangeEquals(getData$okio(), paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public final void setHashCode$okio(int paramInt)
  {
    this.hashCode = paramInt;
  }
  
  public final void setUtf8$okio(@Nullable String paramString)
  {
    this.utf8 = paramString;
  }
  
  @NotNull
  public ByteString sha1()
  {
    return digest$okio("SHA-1");
  }
  
  @NotNull
  public ByteString sha256()
  {
    return digest$okio("SHA-256");
  }
  
  @NotNull
  public ByteString sha512()
  {
    return digest$okio("SHA-512");
  }
  
  @JvmName(name="size")
  public final int size()
  {
    return getSize$okio();
  }
  
  public final boolean startsWith(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "prefix");
    return rangeEquals(0, paramByteString, 0, paramByteString.size());
  }
  
  public final boolean startsWith(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "prefix");
    return rangeEquals(0, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @NotNull
  public String string(@NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    return new String(this.data, paramCharset);
  }
  
  @JvmOverloads
  @NotNull
  public ByteString substring()
  {
    return substring$default(this, 0, 0, 3, null);
  }
  
  @JvmOverloads
  @NotNull
  public ByteString substring(int paramInt)
  {
    return substring$default(this, paramInt, 0, 2, null);
  }
  
  @JvmOverloads
  @NotNull
  public ByteString substring(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 <= getData$okio().length) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 - paramInt1 >= 0) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if ((paramInt1 == 0) && (paramInt2 == getData$okio().length)) {
            return this;
          }
          return new ByteString(ArraysKt.copyOfRange(getData$okio(), paramInt1, paramInt2));
        }
        throw ((Throwable)new IllegalArgumentException("endIndex < beginIndex".toString()));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("endIndex > length(");
      localStringBuilder.append(getData$okio().length);
      localStringBuilder.append(')');
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
    }
    throw ((Throwable)new IllegalArgumentException("beginIndex < 0".toString()));
  }
  
  @NotNull
  public ByteString toAsciiLowercase()
  {
    int i = 0;
    while (i < getData$okio().length)
    {
      int n = getData$okio()[i];
      int k = (byte)65;
      if (n >= k)
      {
        int m = (byte)90;
        if (n <= m)
        {
          byte[] arrayOfByte = getData$okio();
          arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
          Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
          int j = i + 1;
          arrayOfByte[i] = ((byte)(n + 32));
          i = j;
          while (i < arrayOfByte.length)
          {
            j = arrayOfByte[i];
            if ((j >= k) && (j <= m)) {
              arrayOfByte[i] = ((byte)(j + 32));
            }
            i += 1;
          }
          return new ByteString(arrayOfByte);
        }
      }
      i += 1;
    }
    return this;
  }
  
  @NotNull
  public ByteString toAsciiUppercase()
  {
    int i = 0;
    while (i < getData$okio().length)
    {
      int n = getData$okio()[i];
      int k = (byte)97;
      if (n >= k)
      {
        int m = (byte)122;
        if (n <= m)
        {
          byte[] arrayOfByte = getData$okio();
          arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
          Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
          int j = i + 1;
          arrayOfByte[i] = ((byte)(n - 32));
          i = j;
          while (i < arrayOfByte.length)
          {
            j = arrayOfByte[i];
            if ((j >= k) && (j <= m)) {
              arrayOfByte[i] = ((byte)(j - 32));
            }
            i += 1;
          }
          return new ByteString(arrayOfByte);
        }
      }
      i += 1;
    }
    return this;
  }
  
  @NotNull
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = getData$okio();
    arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return arrayOfByte;
  }
  
  @NotNull
  public String toString()
  {
    int i = getData$okio().length;
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return "[size=0]";
    }
    i = ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
    Object localObject1;
    if (i == -1)
    {
      if (getData$okio().length <= 64)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[hex=");
        ((StringBuilder)localObject1).append(hex());
        ((StringBuilder)localObject1).append(']');
        return ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[size=");
      ((StringBuilder)localObject2).append(getData$okio().length);
      ((StringBuilder)localObject2).append(" hex=");
      if (64 <= getData$okio().length) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (64 == getData$okio().length) {
          localObject1 = this;
        } else {
          localObject1 = new ByteString(ArraysKt.copyOfRange(getData$okio(), 0, 64));
        }
        ((StringBuilder)localObject2).append(((ByteString)localObject1).hex());
        ((StringBuilder)localObject2).append("…]");
        return ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("endIndex > length(");
      ((StringBuilder)localObject1).append(getData$okio().length);
      ((StringBuilder)localObject1).append(')');
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString().toString()));
    }
    Object localObject2 = utf8();
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String)localObject1, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
      if (i < ((String)localObject2).length())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[size=");
        ((StringBuilder)localObject2).append(getData$okio().length);
        ((StringBuilder)localObject2).append(" text=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("…]");
        return ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[text=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(']');
      return ((StringBuilder)localObject2).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @NotNull
  public String utf8()
  {
    String str2 = getUtf8$okio();
    String str1 = str2;
    if (str2 == null)
    {
      str1 = -Platform.toUtf8String(internalArray$okio());
      setUtf8$okio(str1);
    }
    return str1;
  }
  
  public void write(@NotNull OutputStream paramOutputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "out");
    paramOutputStream.write(this.data);
  }
  
  public void write$okio(@NotNull Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "buffer");
    ByteStringKt.commonWrite(this, paramBuffer, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.ByteString
 * JD-Core Version:    0.7.0.1
 */