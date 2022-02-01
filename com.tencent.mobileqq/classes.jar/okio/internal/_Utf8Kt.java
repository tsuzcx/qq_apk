package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k=2, mv={1, 1, 16})
public final class _Utf8Kt
{
  @NotNull
  public static final byte[] commonAsUtf8ToByteArray(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$commonAsUtf8ToByteArray");
    byte[] arrayOfByte = new byte[paramString.length() * 4];
    int k = paramString.length();
    int j = 0;
    while (j < k)
    {
      int m = paramString.charAt(j);
      if (m >= 128)
      {
        int n = paramString.length();
        m = j;
        k = j;
        while (k < n)
        {
          j = paramString.charAt(k);
          int i;
          if (j < 128)
          {
            i = (byte)j;
            j = m + 1;
            arrayOfByte[m] = i;
            k += 1;
            while ((k < n) && (paramString.charAt(k) < ''))
            {
              arrayOfByte[j] = ((byte)paramString.charAt(k));
              k += 1;
              j += 1;
            }
            m = j;
          }
          else
          {
            int i1;
            if (j < 2048)
            {
              i = (byte)(j >> 6 | 0xC0);
              i1 = m + 1;
              arrayOfByte[m] = i;
              i = (byte)(j & 0x3F | 0x80);
              j = i1 + 1;
              arrayOfByte[i1] = i;
            }
            for (;;)
            {
              k += 1;
              for (;;)
              {
                m = j;
                break;
                if ((55296 > j) || (57343 < j)) {
                  break label383;
                }
                if (j > 56319) {
                  break label368;
                }
                i1 = k + 1;
                if (n <= i1) {
                  break label368;
                }
                int i2 = paramString.charAt(i1);
                if ((56320 > i2) || (57343 < i2)) {
                  break label368;
                }
                j = (j << 10) + paramString.charAt(i1) - 56613888;
                i = (byte)(j >> 18 | 0xF0);
                i1 = m + 1;
                arrayOfByte[m] = i;
                i = (byte)(j >> 12 & 0x3F | 0x80);
                m = i1 + 1;
                arrayOfByte[i1] = i;
                i = (byte)(j >> 6 & 0x3F | 0x80);
                i1 = m + 1;
                arrayOfByte[m] = i;
                i = (byte)(j & 0x3F | 0x80);
                j = i1 + 1;
                arrayOfByte[i1] = i;
                k += 2;
              }
              label368:
              j = m + 1;
              arrayOfByte[m] = 63;
              continue;
              label383:
              i = (byte)(j >> 12 | 0xE0);
              i1 = m + 1;
              arrayOfByte[m] = i;
              i = (byte)(j >> 6 & 0x3F | 0x80);
              m = i1 + 1;
              arrayOfByte[i1] = i;
              i = (byte)(j & 0x3F | 0x80);
              j = m + 1;
              arrayOfByte[m] = i;
            }
          }
        }
        paramString = Arrays.copyOf(arrayOfByte, m);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "java.util.Arrays.copyOf(this, newSize)");
        return paramString;
      }
      arrayOfByte[j] = ((byte)m);
      j += 1;
    }
    paramString = Arrays.copyOf(arrayOfByte, paramString.length());
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.util.Arrays.copyOf(this, newSize)");
    return paramString;
  }
  
  @NotNull
  public static final String commonToUtf8String(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramInt1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$commonToUtf8String");
    if ((k >= 0) && (paramInt2 <= paramArrayOfByte.length) && (k <= paramInt2))
    {
      localObject = new char[paramInt2 - k];
      paramInt1 = 0;
      label296:
      label299:
      while (k < paramInt2)
      {
        int j = paramArrayOfByte[k];
        int i;
        int m;
        label173:
        label1101:
        if (j >= 0)
        {
          i = (char)j;
          j = paramInt1 + 1;
          localObject[paramInt1] = i;
          k += 1;
          paramInt1 = j;
          j = k;
          for (;;)
          {
            k = j;
            m = paramInt1;
            if (j >= paramInt2) {
              break;
            }
            k = j;
            m = paramInt1;
            if (paramArrayOfByte[j] < 0) {
              break;
            }
            localObject[paramInt1] = ((char)paramArrayOfByte[j]);
            j += 1;
            paramInt1 += 1;
          }
          paramInt1 = m;
        }
        else
        {
          int n;
          if (j >> 5 == -2)
          {
            j = k + 1;
            if (paramInt2 <= j)
            {
              i = (char)65533;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
            }
            for (paramInt1 = j;; paramInt1 = j)
            {
              j = 1;
              break label299;
              m = paramArrayOfByte[k];
              n = paramArrayOfByte[j];
              if ((n & 0xC0) == 128) {
                j = 1;
              } else {
                j = 0;
              }
              if (j != 0) {
                break;
              }
              i = (char)65533;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
            }
            j = n ^ 0xF80 ^ m << 6;
            if (j < 128)
            {
              i = (char)65533;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
              paramInt1 = j;
            }
            else
            {
              i = (char)j;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
              paramInt1 = j;
            }
          }
          int i1;
          for (j = 2;; j = 3)
          {
            k += j;
            m = paramInt1;
            break;
            i1 = 3;
            if (j >> 4 != -2) {
              break label621;
            }
            i1 = k + 2;
            if (paramInt2 <= i1)
            {
              i = (char)65533;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
              m = k + 1;
              paramInt1 = j;
              if (paramInt2 <= m) {
                break label173;
              }
              if ((paramArrayOfByte[m] & 0xC0) == 128) {
                m = 1;
              } else {
                m = 0;
              }
              paramInt1 = j;
              if (m != 0) {
                break label296;
              }
              paramInt1 = j;
              break label173;
            }
            m = paramArrayOfByte[k];
            n = paramArrayOfByte[(k + 1)];
            if ((n & 0xC0) == 128) {
              j = 1;
            } else {
              j = 0;
            }
            if (j == 0)
            {
              i = (char)65533;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
              paramInt1 = j;
              break label173;
            }
            i1 = paramArrayOfByte[i1];
            if ((i1 & 0xC0) == 128) {
              j = 1;
            } else {
              j = 0;
            }
            if (j == 0)
            {
              i = (char)65533;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
              paramInt1 = j;
              break label296;
            }
            j = i1 ^ 0xFFFE1F80 ^ n << 6 ^ m << 12;
            if (j < 2048)
            {
              i = (char)65533;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
              paramInt1 = j;
            }
            else if ((55296 <= j) && (57343 >= j))
            {
              i = (char)65533;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
              paramInt1 = j;
            }
            else
            {
              i = (char)j;
              j = paramInt1 + 1;
              localObject[paramInt1] = i;
              paramInt1 = j;
            }
          }
          label621:
          if (j >> 3 == -2)
          {
            int i3 = k + 3;
            if (paramInt2 <= i3)
            {
              m = paramInt1 + 1;
              localObject[paramInt1] = 65533;
              j = k + 1;
              paramInt1 = m;
              if (paramInt2 > j)
              {
                if ((paramArrayOfByte[j] & 0xC0) == 128) {
                  paramInt1 = 1;
                } else {
                  paramInt1 = 0;
                }
                if (paramInt1 == 0)
                {
                  paramInt1 = m;
                }
                else
                {
                  j = k + 2;
                  paramInt1 = m;
                  if (paramInt2 > j)
                  {
                    if ((paramArrayOfByte[j] & 0xC0) == 128) {
                      n = 1;
                    } else {
                      n = 0;
                    }
                    paramInt1 = m;
                    j = i1;
                    if (n != 0) {
                      break label1101;
                    }
                  }
                }
              }
            }
            int i2;
            for (paramInt1 = m;; paramInt1 = j)
            {
              j = 2;
              break label1101;
              for (;;)
              {
                j = 1;
                break label1101;
                m = paramArrayOfByte[k];
                n = paramArrayOfByte[(k + 1)];
                if ((n & 0xC0) == 128) {
                  j = 1;
                } else {
                  j = 0;
                }
                if (j != 0) {
                  break;
                }
                j = paramInt1 + 1;
                localObject[paramInt1] = 65533;
                paramInt1 = j;
              }
              i2 = paramArrayOfByte[(k + 2)];
              if ((i2 & 0xC0) == 128) {
                j = 1;
              } else {
                j = 0;
              }
              if (j != 0) {
                break;
              }
              j = paramInt1 + 1;
              localObject[paramInt1] = 65533;
            }
            i3 = paramArrayOfByte[i3];
            if ((i3 & 0xC0) == 128) {
              j = 1;
            } else {
              j = 0;
            }
            if (j == 0)
            {
              j = paramInt1 + 1;
              localObject[paramInt1] = 65533;
              paramInt1 = j;
              j = i1;
            }
            else
            {
              m = i3 ^ 0x381F80 ^ i2 << 6 ^ n << 12 ^ m << 18;
              if (m > 1114111)
              {
                j = paramInt1 + 1;
                localObject[paramInt1] = 65533;
                paramInt1 = j;
              }
              else if ((55296 <= m) && (57343 >= m))
              {
                j = paramInt1 + 1;
                localObject[paramInt1] = 65533;
                paramInt1 = j;
              }
              else if (m < 65536)
              {
                j = paramInt1 + 1;
                localObject[paramInt1] = 65533;
                paramInt1 = j;
              }
              else if (m != 65533)
              {
                i = (char)((m >>> 10) + 55232);
                j = paramInt1 + 1;
                localObject[paramInt1] = i;
                i = (char)((m & 0x3FF) + 56320);
                paramInt1 = j + 1;
                localObject[j] = i;
              }
              else
              {
                j = paramInt1 + 1;
                localObject[paramInt1] = 65533;
                paramInt1 = j;
              }
              j = 4;
            }
            k += j;
          }
          else
          {
            j = paramInt1 + 1;
            localObject[paramInt1] = 65533;
            k += 1;
            paramInt1 = j;
          }
        }
      }
      return new String((char[])localObject, 0, paramInt1);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size=");
    ((StringBuilder)localObject).append(paramArrayOfByte.length);
    ((StringBuilder)localObject).append(" beginIndex=");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(" endIndex=");
    ((StringBuilder)localObject).append(paramInt2);
    paramArrayOfByte = (Throwable)new ArrayIndexOutOfBoundsException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.internal._Utf8Kt
 * JD-Core Version:    0.7.0.1
 */