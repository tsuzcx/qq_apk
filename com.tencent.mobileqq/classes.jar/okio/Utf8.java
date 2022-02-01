package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k=2, mv={1, 1, 16})
@JvmName(name="Utf8")
public final class Utf8
{
  public static final int HIGH_SURROGATE_HEADER = 55232;
  public static final int LOG_SURROGATE_HEADER = 56320;
  public static final int MASK_2BYTES = 3968;
  public static final int MASK_3BYTES = -123008;
  public static final int MASK_4BYTES = 3678080;
  public static final byte REPLACEMENT_BYTE = 63;
  public static final char REPLACEMENT_CHARACTER = '�';
  public static final int REPLACEMENT_CODE_POINT = 65533;
  
  public static final boolean isIsoControl(int paramInt)
  {
    return ((paramInt >= 0) && (31 >= paramInt)) || ((127 <= paramInt) && (159 >= paramInt));
  }
  
  public static final boolean isUtf8Continuation(byte paramByte)
  {
    return (paramByte & 0xC0) == 128;
  }
  
  public static final int process2Utf8Bytes(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$process2Utf8Bytes");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    int i = paramInt1 + 1;
    Integer localInteger = Integer.valueOf(65533);
    if (paramInt2 <= i)
    {
      paramFunction1.invoke(localInteger);
      return 1;
    }
    paramInt2 = paramArrayOfByte[paramInt1];
    i = paramArrayOfByte[i];
    if ((i & 0xC0) == 128) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 1;
    }
    paramInt1 = i ^ 0xF80 ^ paramInt2 << 6;
    if (paramInt1 < 128) {
      paramFunction1.invoke(localInteger);
    } else {
      paramFunction1.invoke(Integer.valueOf(paramInt1));
    }
    return 2;
  }
  
  public static final int process3Utf8Bytes(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$process3Utf8Bytes");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    int k = paramInt1 + 2;
    int i = 0;
    int j = 0;
    Integer localInteger = Integer.valueOf(65533);
    if (paramInt2 <= k)
    {
      paramFunction1.invoke(localInteger);
      i = paramInt1 + 1;
      if (paramInt2 > i)
      {
        paramInt1 = j;
        if ((paramArrayOfByte[i] & 0xC0) == 128) {
          paramInt1 = 1;
        }
        if (paramInt1 == 0) {
          return 1;
        }
        return 2;
      }
      return 1;
    }
    paramInt2 = paramArrayOfByte[paramInt1];
    j = paramArrayOfByte[(paramInt1 + 1)];
    if ((j & 0xC0) == 128) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 1;
    }
    k = paramArrayOfByte[k];
    paramInt1 = i;
    if ((k & 0xC0) == 128) {
      paramInt1 = 1;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 2;
    }
    paramInt1 = k ^ 0xFFFE1F80 ^ j << 6 ^ paramInt2 << 12;
    if (paramInt1 < 2048) {
      paramFunction1.invoke(localInteger);
    } else if ((55296 <= paramInt1) && (57343 >= paramInt1)) {
      paramFunction1.invoke(localInteger);
    } else {
      paramFunction1.invoke(Integer.valueOf(paramInt1));
    }
    return 3;
  }
  
  public static final int process4Utf8Bytes(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$process4Utf8Bytes");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    int m = paramInt1 + 3;
    int i = 0;
    int j = 0;
    Integer localInteger = Integer.valueOf(65533);
    if (paramInt2 <= m)
    {
      paramFunction1.invoke(localInteger);
      i = paramInt1 + 1;
      if (paramInt2 > i)
      {
        if ((paramArrayOfByte[i] & 0xC0) == 128) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          return 1;
        }
        i = paramInt1 + 2;
        if (paramInt2 > i)
        {
          paramInt1 = j;
          if ((paramArrayOfByte[i] & 0xC0) == 128) {
            paramInt1 = 1;
          }
          if (paramInt1 == 0) {
            return 2;
          }
          return 3;
        }
        return 2;
      }
      return 1;
    }
    j = paramArrayOfByte[paramInt1];
    int k = paramArrayOfByte[(paramInt1 + 1)];
    if ((k & 0xC0) == 128) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 1;
    }
    paramInt2 = paramArrayOfByte[(paramInt1 + 2)];
    if ((paramInt2 & 0xC0) == 128) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 2;
    }
    m = paramArrayOfByte[m];
    paramInt1 = i;
    if ((m & 0xC0) == 128) {
      paramInt1 = 1;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 3;
    }
    paramInt1 = m ^ 0x381F80 ^ paramInt2 << 6 ^ k << 12 ^ j << 18;
    if (paramInt1 > 1114111) {
      paramFunction1.invoke(localInteger);
    } else if ((55296 <= paramInt1) && (57343 >= paramInt1)) {
      paramFunction1.invoke(localInteger);
    } else if (paramInt1 < 65536) {
      paramFunction1.invoke(localInteger);
    } else {
      paramFunction1.invoke(Integer.valueOf(paramInt1));
    }
    return 4;
  }
  
  public static final void processUtf16Chars(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, @NotNull Function1<? super Character, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$processUtf16Chars");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    while (paramInt1 < paramInt2)
    {
      int i2 = paramArrayOfByte[paramInt1];
      if (i2 >= 0)
      {
        paramFunction1.invoke(Character.valueOf((char)i2));
        i = paramInt1 + 1;
        for (;;)
        {
          paramInt1 = i;
          if (i >= paramInt2) {
            break;
          }
          paramInt1 = i;
          if (paramArrayOfByte[i] < 0) {
            break;
          }
          paramFunction1.invoke(Character.valueOf((char)paramArrayOfByte[i]));
          i += 1;
        }
      }
      int i1 = 0;
      int m = 0;
      int n = 0;
      int j = 0;
      int i = 0;
      int k = 1;
      char c;
      if (i2 >> 5 == -2)
      {
        m = paramInt1 + 1;
        if (paramInt2 <= m) {}
        do
        {
          paramFunction1.invoke(Character.valueOf((char)65533));
          i = k;
          break;
          j = paramArrayOfByte[paramInt1];
          m = paramArrayOfByte[m];
          if ((m & 0xC0) == 128) {
            i = 1;
          }
        } while (i == 0);
        i = m ^ 0xF80 ^ j << 6;
        if (i < 128) {
          c = (char)65533;
        } else {
          c = (char)i;
        }
        paramFunction1.invoke(Character.valueOf(c));
        i = 2;
        paramInt1 += i;
      }
      else
      {
        k = 3;
        if (i2 >> 4 == -2)
        {
          n = paramInt1 + 2;
          if (paramInt2 <= n)
          {
            paramFunction1.invoke(Character.valueOf((char)65533));
            j = paramInt1 + 1;
            if (paramInt2 > j)
            {
              i = i1;
              if ((paramArrayOfByte[j] & 0xC0) == 128) {
                i = 1;
              }
              if (i == 0) {}
            }
          }
          for (;;)
          {
            i = 2;
            break label504;
            for (;;)
            {
              i = 1;
              break label504;
              j = paramArrayOfByte[paramInt1];
              k = paramArrayOfByte[(paramInt1 + 1)];
              if ((k & 0xC0) == 128) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0) {
                break;
              }
              paramFunction1.invoke(Character.valueOf((char)65533));
            }
            n = paramArrayOfByte[n];
            i = m;
            if ((n & 0xC0) == 128) {
              i = 1;
            }
            if (i != 0) {
              break;
            }
            paramFunction1.invoke(Character.valueOf((char)65533));
          }
          i = n ^ 0xFFFE1F80 ^ k << 6 ^ j << 12;
          if (i < 2048) {}
          for (c = (char)65533;; c = (char)i)
          {
            paramFunction1.invoke(Character.valueOf(c));
            break label501;
            if ((55296 <= i) && (57343 >= i)) {
              break;
            }
          }
          label501:
          i = 3;
          label504:
          paramInt1 += i;
        }
        else if (i2 >> 3 == -2)
        {
          i1 = paramInt1 + 3;
          if (paramInt2 <= i1)
          {
            paramFunction1.invoke(Character.valueOf(65533));
            i = paramInt1 + 1;
            if (paramInt2 > i)
            {
              if ((paramArrayOfByte[i] & 0xC0) == 128) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0)
              {
                i = paramInt1 + 2;
                if (paramInt2 > i)
                {
                  j = n;
                  if ((paramArrayOfByte[i] & 0xC0) == 128) {
                    j = 1;
                  }
                  i = k;
                  if (j != 0) {
                    break label915;
                  }
                }
              }
            }
          }
          for (;;)
          {
            i = 2;
            break label915;
            for (;;)
            {
              i = 1;
              break label915;
              m = paramArrayOfByte[paramInt1];
              n = paramArrayOfByte[(paramInt1 + 1)];
              if ((n & 0xC0) == 128) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0) {
                break;
              }
              paramFunction1.invoke(Character.valueOf(65533));
            }
            i2 = paramArrayOfByte[(paramInt1 + 2)];
            if ((i2 & 0xC0) == 128) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0) {
              break;
            }
            paramFunction1.invoke(Character.valueOf(65533));
          }
          i1 = paramArrayOfByte[i1];
          i = j;
          if ((i1 & 0xC0) == 128) {
            i = 1;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Character.valueOf(65533));
            i = k;
          }
          else
          {
            i = i1 ^ 0x381F80 ^ i2 << 6 ^ n << 12 ^ m << 18;
            if (i > 1114111) {}
            while (((55296 <= i) && (57343 >= i)) || (i < 65536) || (i == 65533))
            {
              paramFunction1.invoke(Character.valueOf(65533));
              break;
            }
            paramFunction1.invoke(Character.valueOf((char)((i >>> 10) + 55232)));
            paramFunction1.invoke(Character.valueOf((char)((i & 0x3FF) + 56320)));
            i = 4;
          }
          label915:
          paramInt1 += i;
        }
        else
        {
          paramFunction1.invoke(Character.valueOf(65533));
          paramInt1 += 1;
        }
      }
    }
  }
  
  public static final void processUtf8Bytes(@NotNull String paramString, int paramInt1, int paramInt2, @NotNull Function1<? super Byte, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$processUtf8Bytes");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    if (paramInt1 < paramInt2)
    {
      int i = paramString.charAt(paramInt1);
      if (i < 128)
      {
        paramFunction1.invoke(Byte.valueOf((byte)i));
        i = paramInt1 + 1;
        for (;;)
        {
          paramInt1 = i;
          if (i >= paramInt2) {
            break;
          }
          paramInt1 = i;
          if (paramString.charAt(i) >= '') {
            break;
          }
          paramFunction1.invoke(Byte.valueOf((byte)paramString.charAt(i)));
          i += 1;
        }
      }
      if (i < 2048)
      {
        paramFunction1.invoke(Byte.valueOf((byte)(i >> 6 | 0xC0)));
        paramFunction1.invoke(Byte.valueOf((byte)(i & 0x3F | 0x80)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if ((55296 <= i) && (57343 >= i))
        {
          if (i <= 56319)
          {
            int j = paramInt1 + 1;
            if (paramInt2 > j)
            {
              int k = paramString.charAt(j);
              if ((56320 <= k) && (57343 >= k))
              {
                i = (i << 10) + paramString.charAt(j) - 56613888;
                paramFunction1.invoke(Byte.valueOf((byte)(i >> 18 | 0xF0)));
                paramFunction1.invoke(Byte.valueOf((byte)(i >> 12 & 0x3F | 0x80)));
                paramFunction1.invoke(Byte.valueOf((byte)(i >> 6 & 0x3F | 0x80)));
                paramFunction1.invoke(Byte.valueOf((byte)(i & 0x3F | 0x80)));
                paramInt1 += 2;
                break;
              }
            }
          }
          paramFunction1.invoke(Byte.valueOf((byte)63));
          continue;
        }
        paramFunction1.invoke(Byte.valueOf((byte)(i >> 12 | 0xE0)));
        paramFunction1.invoke(Byte.valueOf((byte)(i >> 6 & 0x3F | 0x80)));
        paramFunction1.invoke(Byte.valueOf((byte)(i & 0x3F | 0x80)));
      }
    }
  }
  
  public static final void processUtf8CodePoints(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$processUtf8CodePoints");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    while (paramInt1 < paramInt2)
    {
      int i2 = paramArrayOfByte[paramInt1];
      if (i2 >= 0)
      {
        paramFunction1.invoke(Integer.valueOf(i2));
        i = paramInt1 + 1;
        for (;;)
        {
          paramInt1 = i;
          if (i >= paramInt2) {
            break;
          }
          paramInt1 = i;
          if (paramArrayOfByte[i] < 0) {
            break;
          }
          paramFunction1.invoke(Integer.valueOf(paramArrayOfByte[i]));
          i += 1;
        }
      }
      int i1 = 0;
      int m = 0;
      int n = 0;
      int j = 0;
      int i = 0;
      int k = 1;
      Integer localInteger;
      if (i2 >> 5 == -2)
      {
        m = paramInt1 + 1;
        if (paramInt2 <= m) {}
        do
        {
          paramFunction1.invoke(Integer.valueOf(65533));
          i = k;
          break;
          j = paramArrayOfByte[paramInt1];
          m = paramArrayOfByte[m];
          if ((m & 0xC0) == 128) {
            i = 1;
          }
        } while (i == 0);
        i = m ^ 0xF80 ^ j << 6;
        if (i < 128) {
          localInteger = Integer.valueOf(65533);
        } else {
          localInteger = Integer.valueOf(i);
        }
        paramFunction1.invoke(localInteger);
        i = 2;
        paramInt1 += i;
      }
      else
      {
        k = 3;
        if (i2 >> 4 == -2)
        {
          n = paramInt1 + 2;
          if (paramInt2 <= n)
          {
            paramFunction1.invoke(Integer.valueOf(65533));
            j = paramInt1 + 1;
            if (paramInt2 > j)
            {
              i = i1;
              if ((paramArrayOfByte[j] & 0xC0) == 128) {
                i = 1;
              }
              if (i == 0) {}
            }
          }
          for (;;)
          {
            i = 2;
            break label500;
            for (;;)
            {
              i = 1;
              break label500;
              j = paramArrayOfByte[paramInt1];
              k = paramArrayOfByte[(paramInt1 + 1)];
              if ((k & 0xC0) == 128) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0) {
                break;
              }
              paramFunction1.invoke(Integer.valueOf(65533));
            }
            n = paramArrayOfByte[n];
            i = m;
            if ((n & 0xC0) == 128) {
              i = 1;
            }
            if (i != 0) {
              break;
            }
            paramFunction1.invoke(Integer.valueOf(65533));
          }
          i = n ^ 0xFFFE1F80 ^ k << 6 ^ j << 12;
          if (i < 2048) {}
          for (localInteger = Integer.valueOf(65533);; localInteger = Integer.valueOf(i))
          {
            paramFunction1.invoke(localInteger);
            break label497;
            if ((55296 <= i) && (57343 >= i)) {
              break;
            }
          }
          label497:
          i = 3;
          label500:
          paramInt1 += i;
        }
        else if (i2 >> 3 == -2)
        {
          i1 = paramInt1 + 3;
          if (paramInt2 <= i1)
          {
            paramFunction1.invoke(Integer.valueOf(65533));
            i = paramInt1 + 1;
            if (paramInt2 > i)
            {
              if ((paramArrayOfByte[i] & 0xC0) == 128) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0)
              {
                i = paramInt1 + 2;
                if (paramInt2 > i)
                {
                  j = n;
                  if ((paramArrayOfByte[i] & 0xC0) == 128) {
                    j = 1;
                  }
                  i = k;
                  if (j != 0) {
                    break label879;
                  }
                }
              }
            }
          }
          for (;;)
          {
            i = 2;
            break label879;
            for (;;)
            {
              i = 1;
              break label879;
              m = paramArrayOfByte[paramInt1];
              n = paramArrayOfByte[(paramInt1 + 1)];
              if ((n & 0xC0) == 128) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0) {
                break;
              }
              paramFunction1.invoke(Integer.valueOf(65533));
            }
            i2 = paramArrayOfByte[(paramInt1 + 2)];
            if ((i2 & 0xC0) == 128) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0) {
              break;
            }
            paramFunction1.invoke(Integer.valueOf(65533));
          }
          i1 = paramArrayOfByte[i1];
          i = j;
          if ((i1 & 0xC0) == 128) {
            i = 1;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Integer.valueOf(65533));
            i = k;
          }
          else
          {
            i = i1 ^ 0x381F80 ^ i2 << 6 ^ n << 12 ^ m << 18;
            if (i > 1114111) {}
            for (localInteger = Integer.valueOf(65533);; localInteger = Integer.valueOf(i))
            {
              paramFunction1.invoke(localInteger);
              break label876;
              if (((55296 <= i) && (57343 >= i)) || (i < 65536)) {
                break;
              }
            }
            label876:
            i = 4;
          }
          label879:
          paramInt1 += i;
        }
        else
        {
          paramFunction1.invoke(Integer.valueOf(65533));
          paramInt1 += 1;
        }
      }
    }
  }
  
  @JvmName(name="size")
  @JvmOverloads
  public static final long size(@NotNull String paramString)
  {
    return size$default(paramString, 0, 0, 3, null);
  }
  
  @JvmName(name="size")
  @JvmOverloads
  public static final long size(@NotNull String paramString, int paramInt)
  {
    return size$default(paramString, paramInt, 0, 2, null);
  }
  
  @JvmName(name="size")
  @JvmOverloads
  public static final long size(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$utf8Size");
    int j = 1;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          long l = 0L;
          while (paramInt1 < paramInt2)
          {
            int k = paramString.charAt(paramInt1);
            if (k < 128)
            {
              l += 1L;
              label89:
              paramInt1 += 1;
            }
            else
            {
              if (k < 2048) {}
              for (i = 2;; i = 3)
              {
                l += i;
                break label89;
                if ((k >= 55296) && (k <= 57343))
                {
                  j = paramInt1 + 1;
                  if (j < paramInt2) {
                    i = paramString.charAt(j);
                  } else {
                    i = 0;
                  }
                  if ((k <= 56319) && (i >= 56320) && (i <= 57343))
                  {
                    l += 4;
                    paramInt1 += 2;
                    break;
                  }
                  l += 1L;
                  paramInt1 = j;
                  break;
                }
              }
            }
          }
          return l;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("endIndex > string.length: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" > ");
        localStringBuilder.append(paramString.length());
        throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
      }
      paramString = new StringBuilder();
      paramString.append("endIndex < beginIndex: ");
      paramString.append(paramInt2);
      paramString.append(" < ");
      paramString.append(paramInt1);
      throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
    }
    paramString = new StringBuilder();
    paramString.append("beginIndex < 0: ");
    paramString.append(paramInt1);
    paramString = (Throwable)new IllegalArgumentException(paramString.toString().toString());
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Utf8
 * JD-Core Version:    0.7.0.1
 */