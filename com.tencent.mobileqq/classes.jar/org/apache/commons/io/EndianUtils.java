package org.apache.commons.io;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;

public class EndianUtils
{
  private static int read(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    if (-1 != i) {
      return i;
    }
    throw new EOFException("Unexpected EOF reached");
  }
  
  public static double readSwappedDouble(InputStream paramInputStream)
  {
    return Double.longBitsToDouble(readSwappedLong(paramInputStream));
  }
  
  public static double readSwappedDouble(byte[] paramArrayOfByte, int paramInt)
  {
    return Double.longBitsToDouble(readSwappedLong(paramArrayOfByte, paramInt));
  }
  
  public static float readSwappedFloat(InputStream paramInputStream)
  {
    return Float.intBitsToFloat(readSwappedInteger(paramInputStream));
  }
  
  public static float readSwappedFloat(byte[] paramArrayOfByte, int paramInt)
  {
    return Float.intBitsToFloat(readSwappedInteger(paramArrayOfByte, paramInt));
  }
  
  public static int readSwappedInteger(InputStream paramInputStream)
  {
    return ((read(paramInputStream) & 0xFF) << 0) + ((read(paramInputStream) & 0xFF) << 8) + ((read(paramInputStream) & 0xFF) << 16) + ((read(paramInputStream) & 0xFF) << 24);
  }
  
  public static int readSwappedInteger(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24);
  }
  
  public static long readSwappedLong(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[i] = ((byte)read(paramInputStream));
      i += 1;
    }
    return readSwappedLong(arrayOfByte, 0);
  }
  
  public static long readSwappedLong(byte[] paramArrayOfByte, int paramInt)
  {
    long l = readSwappedInteger(paramArrayOfByte, paramInt);
    return (readSwappedInteger(paramArrayOfByte, paramInt + 4) << 32) + (l & 0xFFFFFFFF);
  }
  
  public static short readSwappedShort(InputStream paramInputStream)
  {
    return (short)(((read(paramInputStream) & 0xFF) << 0) + ((read(paramInputStream) & 0xFF) << 8));
  }
  
  public static short readSwappedShort(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8));
  }
  
  public static long readSwappedUnsignedInteger(InputStream paramInputStream)
  {
    int i = read(paramInputStream);
    int j = read(paramInputStream);
    int k = read(paramInputStream);
    int m = read(paramInputStream);
    long l = ((i & 0xFF) << 0) + ((j & 0xFF) << 8) + ((k & 0xFF) << 16);
    return ((m & 0xFF) << 24) + (l & 0xFFFFFFFF);
  }
  
  public static long readSwappedUnsignedInteger(byte[] paramArrayOfByte, int paramInt)
  {
    long l = ((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16);
    return ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24) + (l & 0xFFFFFFFF);
  }
  
  public static int readSwappedUnsignedShort(InputStream paramInputStream)
  {
    return ((read(paramInputStream) & 0xFF) << 0) + ((read(paramInputStream) & 0xFF) << 8);
  }
  
  public static int readSwappedUnsignedShort(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8);
  }
  
  public static double swapDouble(double paramDouble)
  {
    return Double.longBitsToDouble(swapLong(Double.doubleToLongBits(paramDouble)));
  }
  
  public static float swapFloat(float paramFloat)
  {
    return Float.intBitsToFloat(swapInteger(Float.floatToIntBits(paramFloat)));
  }
  
  public static int swapInteger(int paramInt)
  {
    return ((paramInt >> 0 & 0xFF) << 24) + ((paramInt >> 8 & 0xFF) << 16) + ((paramInt >> 16 & 0xFF) << 8) + ((paramInt >> 24 & 0xFF) << 0);
  }
  
  public static long swapLong(long paramLong)
  {
    return ((paramLong >> 0 & 0xFF) << 56) + ((paramLong >> 8 & 0xFF) << 48) + ((paramLong >> 16 & 0xFF) << 40) + ((paramLong >> 24 & 0xFF) << 32) + ((paramLong >> 32 & 0xFF) << 24) + ((paramLong >> 40 & 0xFF) << 16) + ((paramLong >> 48 & 0xFF) << 8) + ((paramLong >> 56 & 0xFF) << 0);
  }
  
  public static short swapShort(short paramShort)
  {
    return (short)(((paramShort >> 0 & 0xFF) << 8) + ((paramShort >> 8 & 0xFF) << 0));
  }
  
  public static void writeSwappedDouble(OutputStream paramOutputStream, double paramDouble)
  {
    writeSwappedLong(paramOutputStream, Double.doubleToLongBits(paramDouble));
  }
  
  public static void writeSwappedDouble(byte[] paramArrayOfByte, int paramInt, double paramDouble)
  {
    writeSwappedLong(paramArrayOfByte, paramInt, Double.doubleToLongBits(paramDouble));
  }
  
  public static void writeSwappedFloat(OutputStream paramOutputStream, float paramFloat)
  {
    writeSwappedInteger(paramOutputStream, Float.floatToIntBits(paramFloat));
  }
  
  public static void writeSwappedFloat(byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    writeSwappedInteger(paramArrayOfByte, paramInt, Float.floatToIntBits(paramFloat));
  }
  
  public static void writeSwappedInteger(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write((byte)(paramInt >> 0 & 0xFF));
    paramOutputStream.write((byte)(paramInt >> 8 & 0xFF));
    paramOutputStream.write((byte)(paramInt >> 16 & 0xFF));
    paramOutputStream.write((byte)(paramInt >> 24 & 0xFF));
  }
  
  public static void writeSwappedInteger(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 0 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 >> 24 & 0xFF));
  }
  
  public static void writeSwappedLong(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((byte)(int)(paramLong >> 0 & 0xFF));
    paramOutputStream.write((byte)(int)(paramLong >> 8 & 0xFF));
    paramOutputStream.write((byte)(int)(paramLong >> 16 & 0xFF));
    paramOutputStream.write((byte)(int)(paramLong >> 24 & 0xFF));
    paramOutputStream.write((byte)(int)(paramLong >> 32 & 0xFF));
    paramOutputStream.write((byte)(int)(paramLong >> 40 & 0xFF));
    paramOutputStream.write((byte)(int)(paramLong >> 48 & 0xFF));
    paramOutputStream.write((byte)(int)(paramLong >> 56 & 0xFF));
  }
  
  public static void writeSwappedLong(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong >> 0 & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 16 & 0xFF));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 24 & 0xFF));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >> 32 & 0xFF));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >> 40 & 0xFF));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >> 48 & 0xFF));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(paramLong >> 56 & 0xFF));
  }
  
  public static void writeSwappedShort(OutputStream paramOutputStream, short paramShort)
  {
    paramOutputStream.write((byte)(paramShort >> 0 & 0xFF));
    paramOutputStream.write((byte)(paramShort >> 8 & 0xFF));
  }
  
  public static void writeSwappedShort(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    paramArrayOfByte[(paramInt + 0)] = ((byte)(paramShort >> 0 & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort >> 8 & 0xFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.EndianUtils
 * JD-Core Version:    0.7.0.1
 */