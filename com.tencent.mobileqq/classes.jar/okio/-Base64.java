package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"BASE64", "", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, k=2, mv={1, 1, 16})
@JvmName(name="-Base64")
public final class -Base64
{
  @NotNull
  private static final byte[] BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
  @NotNull
  private static final byte[] BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
  
  @Nullable
  public static final byte[] decodeBase64ToArray(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$decodeBase64ToArray");
    int k = paramString.length();
    while (k > 0)
    {
      i = paramString.charAt(k - 1);
      if ((i != 61) && (i != 10) && (i != 13) && (i != 32) && (i != 9)) {
        break;
      }
      k -= 1;
    }
    byte[] arrayOfByte = new byte[(int)(k * 6L / 8L)];
    int m = 0;
    int i1 = 0;
    int n = 0;
    int i3;
    for (int j = 0; m < k; j = i3)
    {
      int i4 = paramString.charAt(m);
      if ((65 <= i4) && (90 >= i4))
      {
        i = i4 - 65;
      }
      else if ((97 <= i4) && (122 >= i4))
      {
        i = i4 - 71;
      }
      else if ((48 <= i4) && (57 >= i4))
      {
        i = i4 + 4;
      }
      else if ((i4 != 43) && (i4 != 45))
      {
        if ((i4 != 47) && (i4 != 95))
        {
          i = i1;
          i2 = n;
          i3 = j;
          if (i4 == 10) {
            break label375;
          }
          i = i1;
          i2 = n;
          i3 = j;
          if (i4 == 13) {
            break label375;
          }
          i = i1;
          i2 = n;
          i3 = j;
          if (i4 == 32) {
            break label375;
          }
          if (i4 == 9)
          {
            i = i1;
            i2 = n;
            i3 = j;
            break label375;
          }
          return null;
        }
        i = 63;
      }
      else
      {
        i = 62;
      }
      n = n << 6 | i;
      i1 += 1;
      i = i1;
      int i2 = n;
      i3 = j;
      if (i1 % 4 == 0)
      {
        i = j + 1;
        arrayOfByte[j] = ((byte)(n >> 16));
        j = i + 1;
        arrayOfByte[i] = ((byte)(n >> 8));
        arrayOfByte[j] = ((byte)n);
        i3 = j + 1;
        i2 = n;
        i = i1;
      }
      label375:
      m += 1;
      i1 = i;
      n = i2;
    }
    int i = i1 % 4;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          i = n << 6;
          k = j + 1;
          arrayOfByte[j] = ((byte)(i >> 16));
          j = k + 1;
          arrayOfByte[k] = ((byte)(i >> 8));
        }
      }
      else
      {
        arrayOfByte[j] = ((byte)(n << 12 >> 16));
        j += 1;
      }
      if (j == arrayOfByte.length) {
        return arrayOfByte;
      }
      paramString = Arrays.copyOf(arrayOfByte, j);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "java.util.Arrays.copyOf(this, newSize)");
      return paramString;
    }
    return null;
  }
  
  @NotNull
  public static final String encodeBase64(@NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$encodeBase64");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "map");
    byte[] arrayOfByte = new byte[(paramArrayOfByte1.length + 2) / 3 * 4];
    int m = paramArrayOfByte1.length - paramArrayOfByte1.length % 3;
    int k = 0;
    int j = 0;
    int n;
    while (k < m)
    {
      n = k + 1;
      int i1 = paramArrayOfByte1[k];
      k = n + 1;
      int i2 = paramArrayOfByte1[n];
      n = paramArrayOfByte1[k];
      int i3 = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((i1 & 0xFF) >> 2)];
      j = i3 + 1;
      arrayOfByte[i3] = paramArrayOfByte2[((i1 & 0x3) << 4 | (i2 & 0xFF) >> 4)];
      i1 = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((i2 & 0xF) << 2 | (n & 0xFF) >> 6)];
      j = i1 + 1;
      arrayOfByte[i1] = paramArrayOfByte2[(n & 0x3F)];
      k += 1;
    }
    m = paramArrayOfByte1.length - m;
    if (m != 1)
    {
      if (m == 2)
      {
        m = paramArrayOfByte1[k];
        k = paramArrayOfByte1[(k + 1)];
        n = j + 1;
        arrayOfByte[j] = paramArrayOfByte2[((m & 0xFF) >> 2)];
        j = n + 1;
        arrayOfByte[n] = paramArrayOfByte2[((m & 0x3) << 4 | (k & 0xFF) >> 4)];
        arrayOfByte[j] = paramArrayOfByte2[((k & 0xF) << 2)];
        arrayOfByte[(j + 1)] = ((byte)61);
      }
    }
    else
    {
      k = paramArrayOfByte1[k];
      m = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((k & 0xFF) >> 2)];
      j = m + 1;
      arrayOfByte[m] = paramArrayOfByte2[((k & 0x3) << 4)];
      int i = (byte)61;
      arrayOfByte[j] = i;
      arrayOfByte[(j + 1)] = i;
    }
    return -Platform.toUtf8String(arrayOfByte);
  }
  
  @NotNull
  public static final byte[] getBASE64()
  {
    return BASE64;
  }
  
  @NotNull
  public static final byte[] getBASE64_URL_SAFE()
  {
    return BASE64_URL_SAFE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-Base64
 * JD-Core Version:    0.7.0.1
 */