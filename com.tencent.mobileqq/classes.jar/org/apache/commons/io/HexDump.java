package org.apache.commons.io;

import java.io.OutputStream;
import java.nio.charset.Charset;

public class HexDump
{
  public static final String EOL = System.getProperty("line.separator");
  private static final char[] _hexcodes = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final int[] _shifts = { 28, 24, 20, 16, 12, 8, 4, 0 };
  
  private static StringBuilder dump(StringBuilder paramStringBuilder, byte paramByte)
  {
    int i = 0;
    while (i < 2)
    {
      paramStringBuilder.append(_hexcodes[(paramByte >> _shifts[(i + 6)] & 0xF)]);
      i += 1;
    }
    return paramStringBuilder;
  }
  
  private static StringBuilder dump(StringBuilder paramStringBuilder, long paramLong)
  {
    int i = 0;
    while (i < 8)
    {
      paramStringBuilder.append(_hexcodes[((int)(paramLong >> _shifts[i]) & 0xF)]);
      i += 1;
    }
    return paramStringBuilder;
  }
  
  public static void dump(byte[] paramArrayOfByte, long paramLong, OutputStream paramOutputStream, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramArrayOfByte.length))
    {
      if (paramOutputStream != null)
      {
        paramLong += paramInt;
        StringBuilder localStringBuilder = new StringBuilder(74);
        while (paramInt < paramArrayOfByte.length)
        {
          int j = paramArrayOfByte.length - paramInt;
          int i = j;
          if (j > 16) {
            i = 16;
          }
          dump(localStringBuilder, paramLong).append(' ');
          j = 0;
          while (j < 16)
          {
            if (j < i) {
              dump(localStringBuilder, paramArrayOfByte[(j + paramInt)]);
            } else {
              localStringBuilder.append("  ");
            }
            localStringBuilder.append(' ');
            j += 1;
          }
          j = 0;
          while (j < i)
          {
            int k = j + paramInt;
            if ((paramArrayOfByte[k] >= 32) && (paramArrayOfByte[k] < 127)) {
              localStringBuilder.append((char)paramArrayOfByte[k]);
            } else {
              localStringBuilder.append('.');
            }
            j += 1;
          }
          localStringBuilder.append(EOL);
          paramOutputStream.write(localStringBuilder.toString().getBytes(Charset.defaultCharset()));
          paramOutputStream.flush();
          localStringBuilder.setLength(0);
          paramLong += i;
          paramInt += 16;
        }
        return;
      }
      throw new IllegalArgumentException("cannot write to nullstream");
    }
    paramOutputStream = new StringBuilder();
    paramOutputStream.append("illegal index: ");
    paramOutputStream.append(paramInt);
    paramOutputStream.append(" into array of length ");
    paramOutputStream.append(paramArrayOfByte.length);
    paramArrayOfByte = new ArrayIndexOutOfBoundsException(paramOutputStream.toString());
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.HexDump
 * JD-Core Version:    0.7.0.1
 */