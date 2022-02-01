package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.-Base64;
import okio.-Platform;
import okio.-Util;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "offset", "otherOffset", "byteCount", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "", "buffer", "Lokio/Buffer;", "okio"}, k=2, mv={1, 1, 16})
public final class ByteStringKt
{
  @NotNull
  private static final char[] HEX_DIGIT_CHARS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static final int codePointIndexToCharIndex(byte[] paramArrayOfByte, int paramInt)
  {
    int i3 = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < i3)
    {
      int i4 = paramArrayOfByte[i];
      int i1 = 1;
      int n = 1;
      int i2 = 1;
      int m;
      if (i4 >= 0)
      {
        m = k + 1;
        if (k == paramInt) {
          return j;
        }
        if ((i4 != 10) && (i4 != 13))
        {
          if (((i4 >= 0) && (31 >= i4)) || ((127 <= i4) && (159 >= i4))) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0) {}
        }
        else
        {
          if (i4 != 65533) {
            break label117;
          }
        }
        return -1;
        label117:
        if (i4 < 65536) {
          k = 1;
        } else {
          k = 2;
        }
        i += 1;
        j += k;
        for (k = m; (i < i3) && (paramArrayOfByte[i] >= 0); k = m)
        {
          n = paramArrayOfByte[i];
          m = k + 1;
          if (k == paramInt) {
            return j;
          }
          if ((n != 10) && (n != 13))
          {
            if (((n >= 0) && (31 >= n)) || ((127 <= n) && (159 >= n))) {
              k = 1;
            } else {
              k = 0;
            }
            if (k != 0) {}
          }
          else
          {
            if (n != 65533) {
              break label244;
            }
          }
          return -1;
          label244:
          if (n < 65536) {
            k = 1;
          } else {
            k = 2;
          }
          j += k;
          i += 1;
        }
      }
      else
      {
        if (i4 >> 5 == -2)
        {
          m = i + 1;
          if (i3 <= m)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          n = paramArrayOfByte[i];
          i1 = paramArrayOfByte[m];
          if ((i1 & 0xC0) == 128) {
            m = 1;
          } else {
            m = 0;
          }
          if (m == 0)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          n = i1 ^ 0xF80 ^ n << 6;
          if (n < 128)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          m = k + 1;
          if (k == paramInt) {
            return j;
          }
          if ((n != 10) && (n != 13))
          {
            if (((n >= 0) && (31 >= n)) || ((127 <= n) && (159 >= n))) {
              k = 1;
            } else {
              k = 0;
            }
            if (k != 0) {}
          }
          else
          {
            if (n != 65533) {
              break label470;
            }
          }
          return -1;
          label470:
          if (n < 65536) {
            k = i2;
          } else {
            k = 2;
          }
          j += k;
          i += 2;
          k = m;
        }
        for (;;)
        {
          break;
          if (i4 >> 4 == -2)
          {
            i4 = i + 2;
            if (i3 <= i4)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            n = paramArrayOfByte[i];
            i2 = paramArrayOfByte[(i + 1)];
            if ((i2 & 0xC0) == 128) {
              m = 1;
            } else {
              m = 0;
            }
            if (m == 0)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            i4 = paramArrayOfByte[i4];
            if ((i4 & 0xC0) == 128) {
              m = 1;
            } else {
              m = 0;
            }
            if (m == 0)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            n = i4 ^ 0xFFFE1F80 ^ i2 << 6 ^ n << 12;
            if (n < 2048)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            if ((55296 <= n) && (57343 >= n))
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            m = k + 1;
            if (k == paramInt) {
              return j;
            }
            if ((n != 10) && (n != 13))
            {
              if (((n >= 0) && (31 >= n)) || ((127 <= n) && (159 >= n))) {
                k = 1;
              } else {
                k = 0;
              }
              if (k != 0) {}
            }
            else
            {
              if (n != 65533) {
                break label769;
              }
            }
            return -1;
            label769:
            if (n < 65536) {
              k = i1;
            } else {
              k = 2;
            }
            j += k;
            i += 3;
            k = m;
          }
          else
          {
            if (i4 >> 3 != -2) {
              break label1166;
            }
            int i5 = i + 3;
            if (i3 <= i5)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            i1 = paramArrayOfByte[i];
            i2 = paramArrayOfByte[(i + 1)];
            if ((i2 & 0xC0) == 128) {
              m = 1;
            } else {
              m = 0;
            }
            if (m == 0)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            i4 = paramArrayOfByte[(i + 2)];
            if ((i4 & 0xC0) == 128) {
              m = 1;
            } else {
              m = 0;
            }
            if (m == 0)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            i5 = paramArrayOfByte[i5];
            if ((i5 & 0xC0) == 128) {
              m = 1;
            } else {
              m = 0;
            }
            if (m == 0)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            i1 = i5 ^ 0x381F80 ^ i4 << 6 ^ i2 << 12 ^ i1 << 18;
            if (i1 > 1114111)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            if ((55296 <= i1) && (57343 >= i1))
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            if (i1 < 65536)
            {
              if (k == paramInt) {
                return j;
              }
              return -1;
            }
            m = k + 1;
            if (k == paramInt) {
              return j;
            }
            if ((i1 != 10) && (i1 != 13))
            {
              if (((i1 >= 0) && (31 >= i1)) || ((127 <= i1) && (159 >= i1))) {
                k = 1;
              } else {
                k = 0;
              }
              if (k != 0) {}
            }
            else
            {
              if (i1 != 65533) {
                break label1133;
              }
            }
            return -1;
            label1133:
            if (i1 < 65536) {
              k = n;
            } else {
              k = 2;
            }
            j += k;
            i += 4;
            k = m;
          }
        }
        label1166:
        if (k == paramInt) {
          return j;
        }
        return -1;
      }
    }
    return j;
  }
  
  @NotNull
  public static final String commonBase64(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonBase64");
    return -Base64.encodeBase64$default(paramByteString.getData$okio(), null, 1, null);
  }
  
  @NotNull
  public static final String commonBase64Url(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonBase64Url");
    return -Base64.encodeBase64(paramByteString.getData$okio(), -Base64.getBASE64_URL_SAFE());
  }
  
  public static final int commonCompareTo(@NotNull ByteString paramByteString1, @NotNull ByteString paramByteString2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString1, "$this$commonCompareTo");
    Intrinsics.checkParameterIsNotNull(paramByteString2, "other");
    int j = paramByteString1.size();
    int k = paramByteString2.size();
    int m = Math.min(j, k);
    int i = 0;
    while (i < m)
    {
      int n = paramByteString1.getByte(i) & 0xFF;
      int i1 = paramByteString2.getByte(i) & 0xFF;
      if (n == i1)
      {
        i += 1;
      }
      else
      {
        if (n < i1) {
          return -1;
        }
        return 1;
      }
    }
    if (j == k) {
      return 0;
    }
    if (j < k) {
      return -1;
    }
    return 1;
  }
  
  @Nullable
  public static final ByteString commonDecodeBase64(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$commonDecodeBase64");
    paramString = -Base64.decodeBase64ToArray(paramString);
    if (paramString != null) {
      return new ByteString(paramString);
    }
    return null;
  }
  
  @NotNull
  public static final ByteString commonDecodeHex(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$commonDecodeHex");
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
        localObject[i] = ((byte)((access$decodeHexDigit(paramString.charAt(j)) << 4) + access$decodeHexDigit(paramString.charAt(j + 1))));
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
  
  @NotNull
  public static final ByteString commonEncodeUtf8(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$commonEncodeUtf8");
    ByteString localByteString = new ByteString(-Platform.asUtf8ToByteArray(paramString));
    localByteString.setUtf8$okio(paramString);
    return localByteString;
  }
  
  public static final boolean commonEndsWith(@NotNull ByteString paramByteString1, @NotNull ByteString paramByteString2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString1, "$this$commonEndsWith");
    Intrinsics.checkParameterIsNotNull(paramByteString2, "suffix");
    return paramByteString1.rangeEquals(paramByteString1.size() - paramByteString2.size(), paramByteString2, 0, paramByteString2.size());
  }
  
  public static final boolean commonEndsWith(@NotNull ByteString paramByteString, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonEndsWith");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "suffix");
    return paramByteString.rangeEquals(paramByteString.size() - paramArrayOfByte.length, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final boolean commonEquals(@NotNull ByteString paramByteString, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonEquals");
    if (paramObject == paramByteString) {
      return true;
    }
    if ((paramObject instanceof ByteString))
    {
      paramObject = (ByteString)paramObject;
      if ((paramObject.size() == paramByteString.getData$okio().length) && (paramObject.rangeEquals(0, paramByteString.getData$okio(), 0, paramByteString.getData$okio().length))) {
        return true;
      }
    }
    return false;
  }
  
  public static final byte commonGetByte(@NotNull ByteString paramByteString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonGetByte");
    return paramByteString.getData$okio()[paramInt];
  }
  
  public static final int commonGetSize(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonGetSize");
    return paramByteString.getData$okio().length;
  }
  
  public static final int commonHashCode(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonHashCode");
    int i = paramByteString.getHashCode$okio();
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(paramByteString.getData$okio());
    paramByteString.setHashCode$okio(i);
    return i;
  }
  
  @NotNull
  public static final String commonHex(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonHex");
    char[] arrayOfChar = new char[paramByteString.getData$okio().length * 2];
    paramByteString = paramByteString.getData$okio();
    int k = paramByteString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramByteString[i];
      int n = j + 1;
      arrayOfChar[j] = getHEX_DIGIT_CHARS()[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = getHEX_DIGIT_CHARS()[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static final int commonIndexOf(@NotNull ByteString paramByteString, @NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonIndexOf");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    int i = paramByteString.getData$okio().length - paramArrayOfByte.length;
    paramInt = Math.max(paramInt, 0);
    if (paramInt <= i) {
      for (;;)
      {
        if (-Util.arrayRangeEquals(paramByteString.getData$okio(), paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
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
  public static final byte[] commonInternalArray(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonInternalArray");
    return paramByteString.getData$okio();
  }
  
  public static final int commonLastIndexOf(@NotNull ByteString paramByteString1, @NotNull ByteString paramByteString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString1, "$this$commonLastIndexOf");
    Intrinsics.checkParameterIsNotNull(paramByteString2, "other");
    return paramByteString1.lastIndexOf(paramByteString2.internalArray$okio(), paramInt);
  }
  
  public static final int commonLastIndexOf(@NotNull ByteString paramByteString, @NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonLastIndexOf");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    paramInt = Math.min(paramInt, paramByteString.getData$okio().length - paramArrayOfByte.length);
    while (paramInt >= 0)
    {
      if (-Util.arrayRangeEquals(paramByteString.getData$okio(), paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  @NotNull
  public static final ByteString commonOf(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return new ByteString(paramArrayOfByte);
  }
  
  public static final boolean commonRangeEquals(@NotNull ByteString paramByteString1, int paramInt1, @NotNull ByteString paramByteString2, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString1, "$this$commonRangeEquals");
    Intrinsics.checkParameterIsNotNull(paramByteString2, "other");
    return paramByteString2.rangeEquals(paramInt2, paramByteString1.getData$okio(), paramInt1, paramInt3);
  }
  
  public static final boolean commonRangeEquals(@NotNull ByteString paramByteString, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonRangeEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    return (paramInt1 >= 0) && (paramInt1 <= paramByteString.getData$okio().length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (-Util.arrayRangeEquals(paramByteString.getData$okio(), paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public static final boolean commonStartsWith(@NotNull ByteString paramByteString1, @NotNull ByteString paramByteString2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString1, "$this$commonStartsWith");
    Intrinsics.checkParameterIsNotNull(paramByteString2, "prefix");
    return paramByteString1.rangeEquals(0, paramByteString2, 0, paramByteString2.size());
  }
  
  public static final boolean commonStartsWith(@NotNull ByteString paramByteString, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonStartsWith");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "prefix");
    return paramByteString.rangeEquals(0, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @NotNull
  public static final ByteString commonSubstring(@NotNull ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonSubstring");
    int j = 1;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 <= paramByteString.getData$okio().length) {
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
          if ((paramInt1 == 0) && (paramInt2 == paramByteString.getData$okio().length)) {
            return paramByteString;
          }
          return new ByteString(ArraysKt.copyOfRange(paramByteString.getData$okio(), paramInt1, paramInt2));
        }
        throw ((Throwable)new IllegalArgumentException("endIndex < beginIndex".toString()));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("endIndex > length(");
      localStringBuilder.append(paramByteString.getData$okio().length);
      localStringBuilder.append(')');
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
    }
    throw ((Throwable)new IllegalArgumentException("beginIndex < 0".toString()));
  }
  
  @NotNull
  public static final ByteString commonToAsciiLowercase(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonToAsciiLowercase");
    int i = 0;
    while (i < paramByteString.getData$okio().length)
    {
      int n = paramByteString.getData$okio()[i];
      int k = (byte)65;
      if (n >= k)
      {
        int m = (byte)90;
        if (n <= m)
        {
          paramByteString = paramByteString.getData$okio();
          paramByteString = Arrays.copyOf(paramByteString, paramByteString.length);
          Intrinsics.checkExpressionValueIsNotNull(paramByteString, "java.util.Arrays.copyOf(this, size)");
          int j = i + 1;
          paramByteString[i] = ((byte)(n + 32));
          i = j;
          while (i < paramByteString.length)
          {
            j = paramByteString[i];
            if ((j >= k) && (j <= m)) {
              paramByteString[i] = ((byte)(j + 32));
            }
            i += 1;
          }
          return new ByteString(paramByteString);
        }
      }
      i += 1;
    }
    return paramByteString;
  }
  
  @NotNull
  public static final ByteString commonToAsciiUppercase(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonToAsciiUppercase");
    int i = 0;
    while (i < paramByteString.getData$okio().length)
    {
      int n = paramByteString.getData$okio()[i];
      int k = (byte)97;
      if (n >= k)
      {
        int m = (byte)122;
        if (n <= m)
        {
          paramByteString = paramByteString.getData$okio();
          paramByteString = Arrays.copyOf(paramByteString, paramByteString.length);
          Intrinsics.checkExpressionValueIsNotNull(paramByteString, "java.util.Arrays.copyOf(this, size)");
          int j = i + 1;
          paramByteString[i] = ((byte)(n - 32));
          i = j;
          while (i < paramByteString.length)
          {
            j = paramByteString[i];
            if ((j >= k) && (j <= m)) {
              paramByteString[i] = ((byte)(j - 32));
            }
            i += 1;
          }
          return new ByteString(paramByteString);
        }
      }
      i += 1;
    }
    return paramByteString;
  }
  
  @NotNull
  public static final byte[] commonToByteArray(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonToByteArray");
    paramByteString = paramByteString.getData$okio();
    paramByteString = Arrays.copyOf(paramByteString, paramByteString.length);
    Intrinsics.checkExpressionValueIsNotNull(paramByteString, "java.util.Arrays.copyOf(this, size)");
    return paramByteString;
  }
  
  @NotNull
  public static final ByteString commonToByteString(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$commonToByteString");
    -Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    return new ByteString(ArraysKt.copyOfRange(paramArrayOfByte, paramInt1, paramInt2 + paramInt1));
  }
  
  @NotNull
  public static final String commonToString(@NotNull ByteString paramByteString)
  {
    Object localObject1 = paramByteString;
    Intrinsics.checkParameterIsNotNull(localObject1, "$this$commonToString");
    int i = paramByteString.getData$okio().length;
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return "[size=0]";
    }
    i = access$codePointIndexToCharIndex(paramByteString.getData$okio(), 64);
    if (i == -1)
    {
      if (paramByteString.getData$okio().length <= 64)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[hex=");
        ((StringBuilder)localObject1).append(paramByteString.hex());
        ((StringBuilder)localObject1).append(']');
        return ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[size=");
      ((StringBuilder)localObject2).append(paramByteString.getData$okio().length);
      ((StringBuilder)localObject2).append(" hex=");
      if (64 <= paramByteString.getData$okio().length) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (64 != paramByteString.getData$okio().length) {
          localObject1 = new ByteString(ArraysKt.copyOfRange(paramByteString.getData$okio(), 0, 64));
        }
        ((StringBuilder)localObject2).append(((ByteString)localObject1).hex());
        ((StringBuilder)localObject2).append("…]");
        return ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("endIndex > length(");
      ((StringBuilder)localObject1).append(paramByteString.getData$okio().length);
      ((StringBuilder)localObject1).append(')');
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString().toString()));
    }
    Object localObject2 = paramByteString.utf8();
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String)localObject1, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
      if (i < ((String)localObject2).length())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[size=");
        ((StringBuilder)localObject2).append(paramByteString.getData$okio().length);
        ((StringBuilder)localObject2).append(" text=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("…]");
        return ((StringBuilder)localObject2).toString();
      }
      paramByteString = new StringBuilder();
      paramByteString.append("[text=");
      paramByteString.append((String)localObject1);
      paramByteString.append(']');
      return paramByteString.toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @NotNull
  public static final String commonUtf8(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonUtf8");
    String str2 = paramByteString.getUtf8$okio();
    String str1 = str2;
    if (str2 == null)
    {
      str1 = -Platform.toUtf8String(paramByteString.internalArray$okio());
      paramByteString.setUtf8$okio(str1);
    }
    return str1;
  }
  
  public static final void commonWrite(@NotNull ByteString paramByteString, @NotNull Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramBuffer, "buffer");
    paramBuffer.write(paramByteString.getData$okio(), paramInt1, paramInt2);
  }
  
  private static final int decodeHexDigit(char paramChar)
  {
    if (('0' <= paramChar) && ('9' >= paramChar)) {
      return paramChar - '0';
    }
    char c = 'a';
    if (('a' <= paramChar) && ('f' >= paramChar)) {}
    do
    {
      return paramChar - c + 10;
      c = 'A';
    } while (('A' <= paramChar) && ('F' >= paramChar));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected hex digit: ");
    ((StringBuilder)localObject).append(paramChar);
    localObject = (Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @NotNull
  public static final char[] getHEX_DIGIT_CHARS()
  {
    return HEX_DIGIT_CHARS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.internal.ByteStringKt
 * JD-Core Version:    0.7.0.1
 */