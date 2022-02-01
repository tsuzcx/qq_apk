package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"arrayRangeEquals", "", "a", "", "aOffset", "", "b", "bOffset", "byteCount", "checkOffsetAndCount", "", "size", "", "offset", "minOf", "and", "", "other", "reverseBytes", "", "shl", "shr", "toHexString", "", "okio"}, k=2, mv={1, 1, 16})
@JvmName(name="-Util")
public final class -Util
{
  public static final int and(byte paramByte, int paramInt)
  {
    return paramByte & paramInt;
  }
  
  public static final long and(byte paramByte, long paramLong)
  {
    return paramLong & paramByte;
  }
  
  public static final long and(int paramInt, long paramLong)
  {
    return paramLong & paramInt;
  }
  
  public static final boolean arrayRangeEquals(@NotNull byte[] paramArrayOfByte1, int paramInt1, @NotNull byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "a");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "b");
    int i = 0;
    while (i < paramInt3)
    {
      if (paramArrayOfByte1[(i + paramInt1)] != paramArrayOfByte2[(i + paramInt2)]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" offset=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" byteCount=");
    localStringBuilder.append(paramLong3);
    throw ((Throwable)new ArrayIndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public static final long minOf(int paramInt, long paramLong)
  {
    return Math.min(paramInt, paramLong);
  }
  
  public static final long minOf(long paramLong, int paramInt)
  {
    return Math.min(paramLong, paramInt);
  }
  
  public static final int reverseBytes(int paramInt)
  {
    return (paramInt & 0xFF) << 24 | (0xFF000000 & paramInt) >>> 24 | (0xFF0000 & paramInt) >>> 8 | (0xFF00 & paramInt) << 8;
  }
  
  public static final long reverseBytes(long paramLong)
  {
    return (paramLong & 0xFF) << 56 | (0x0 & paramLong) >>> 56 | (0x0 & paramLong) >>> 40 | (0x0 & paramLong) >>> 24 | (0x0 & paramLong) >>> 8 | (0xFF000000 & paramLong) << 8 | (0xFF0000 & paramLong) << 24 | (0xFF00 & paramLong) << 40;
  }
  
  public static final short reverseBytes(short paramShort)
  {
    paramShort &= 0xFFFF;
    return (short)((paramShort & 0xFF) << 8 | (0xFF00 & paramShort) >>> 8);
  }
  
  public static final int shl(byte paramByte, int paramInt)
  {
    return paramByte << paramInt;
  }
  
  public static final int shr(byte paramByte, int paramInt)
  {
    return paramByte >> paramInt;
  }
  
  @NotNull
  public static final String toHexString(byte paramByte)
  {
    return new String(new char[] { okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramByte >> 4 & 0xF)], okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramByte & 0xF)] });
  }
  
  @NotNull
  public static final String toHexString(int paramInt)
  {
    if (paramInt == 0) {
      return "0";
    }
    char[] arrayOfChar = new char[8];
    int i = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramInt >> 28 & 0xF)];
    int j = 0;
    arrayOfChar[0] = i;
    arrayOfChar[1] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramInt >> 24 & 0xF)];
    arrayOfChar[2] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramInt >> 20 & 0xF)];
    arrayOfChar[3] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramInt >> 16 & 0xF)];
    arrayOfChar[4] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramInt >> 12 & 0xF)];
    arrayOfChar[5] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramInt >> 8 & 0xF)];
    arrayOfChar[6] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramInt >> 4 & 0xF)];
    arrayOfChar[7] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[(paramInt & 0xF)];
    paramInt = j;
    while ((paramInt < arrayOfChar.length) && (arrayOfChar[paramInt] == '0')) {
      paramInt += 1;
    }
    return new String(arrayOfChar, paramInt, arrayOfChar.length - paramInt);
  }
  
  @NotNull
  public static final String toHexString(long paramLong)
  {
    if (paramLong == 0L) {
      return "0";
    }
    char[] arrayOfChar = new char[16];
    int i = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 60 & 0xF))];
    int j = 0;
    arrayOfChar[0] = i;
    arrayOfChar[1] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 56 & 0xF))];
    arrayOfChar[2] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 52 & 0xF))];
    arrayOfChar[3] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 48 & 0xF))];
    arrayOfChar[4] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 44 & 0xF))];
    arrayOfChar[5] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 40 & 0xF))];
    arrayOfChar[6] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 36 & 0xF))];
    arrayOfChar[7] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 32 & 0xF))];
    arrayOfChar[8] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 28 & 0xF))];
    arrayOfChar[9] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 24 & 0xF))];
    arrayOfChar[10] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 20 & 0xF))];
    arrayOfChar[11] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 16 & 0xF))];
    arrayOfChar[12] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 12 & 0xF))];
    arrayOfChar[13] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 8 & 0xF))];
    arrayOfChar[14] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong >> 4 & 0xF))];
    arrayOfChar[15] = okio.internal.ByteStringKt.getHEX_DIGIT_CHARS()[((int)(paramLong & 0xF))];
    while ((j < arrayOfChar.length) && (arrayOfChar[j] == '0')) {
      j += 1;
    }
    return new String(arrayOfChar, j, arrayOfChar.length - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-Util
 * JD-Core Version:    0.7.0.1
 */