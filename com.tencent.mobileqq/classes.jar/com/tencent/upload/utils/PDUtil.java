package com.tencent.upload.utils;

public class PDUtil
{
  private static final String TAG = "PDUtil";
  
  public static int byte2int(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[3];
    int j = paramArrayOfByte[2];
    int k = paramArrayOfByte[1];
    return (paramArrayOfByte[0] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static boolean check(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 1);
    if (vtolh(arrayOfByte) != 4)
    {
      UploadLog.e("PDUtil", "0x04 decode error !");
      return false;
    }
    System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 1, arrayOfByte, 0, 1);
    if (vtolh(arrayOfByte) != 5)
    {
      UploadLog.e("PDUtil", "0x05 decode error !");
      return false;
    }
    return true;
  }
  
  public static PduHeader decodeHeader(byte[] paramArrayOfByte)
  {
    if (!check(paramArrayOfByte)) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte[PduHeader.length];
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, PduHeader.length);
      paramArrayOfByte = PduHeader.decode(arrayOfByte);
      return paramArrayOfByte;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label32:
      break label32;
    }
    UploadLog.e("PDUtil", "OutOfMemoryError !!!");
    return null;
  }
  
  public static byte[] decodeJce(byte[] paramArrayOfByte)
  {
    boolean bool = check(paramArrayOfByte);
    byte[] arrayOfByte2 = null;
    if (!bool) {
      return null;
    }
    byte[] arrayOfByte1 = arrayOfByte2;
    try
    {
      byte[] arrayOfByte3 = new byte[PduHeader.length];
      arrayOfByte1 = arrayOfByte2;
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte3, 0, PduHeader.length);
      arrayOfByte1 = arrayOfByte2;
      arrayOfByte2 = new byte[PduHeader.decode(arrayOfByte3).len - 25];
      arrayOfByte1 = arrayOfByte2;
      System.arraycopy(paramArrayOfByte, PduHeader.length + 1, arrayOfByte2, 0, arrayOfByte2.length);
      return arrayOfByte2;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label68:
      break label68;
    }
    UploadLog.e("PDUtil", "OutOfMemoryError !!!");
    return arrayOfByte1;
  }
  
  public static int decodePDU(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 1);
    if (vtolh(arrayOfByte) != 4)
    {
      UploadLog.e("PDUtil", "0x04 error !!!");
      printHexString("---------- decodePDU:", paramArrayOfByte);
      return -1;
    }
    try
    {
      arrayOfByte = new byte[PduHeader.length];
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, PduHeader.length);
      paramArrayOfByte = PduHeader.decode(arrayOfByte);
      return paramArrayOfByte.len;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label61:
      break label61;
    }
    UploadLog.e("PDUtil", "OutOfMemoryError !!!");
    return -1;
  }
  
  public static int decodeSeq(byte[] paramArrayOfByte)
  {
    if (!check(paramArrayOfByte)) {
      return -1;
    }
    try
    {
      byte[] arrayOfByte = new byte[PduHeader.length];
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, PduHeader.length);
      int i = PduHeader.decode(arrayOfByte).seq;
      return i;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label35:
      break label35;
    }
    UploadLog.e("PDUtil", "OutOfMemoryError !!!");
    return -1;
  }
  
  public static int decodeSize(byte[] paramArrayOfByte)
  {
    if (!check(paramArrayOfByte)) {
      return -1;
    }
    try
    {
      byte[] arrayOfByte = new byte[PduHeader.length];
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, PduHeader.length);
      int i = PduHeader.decode(arrayOfByte).len;
      return i;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label35:
      break label35;
    }
    UploadLog.e("PDUtil", "OutOfMemoryError !!!");
    return -1;
  }
  
  public static byte[] encode(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length + 25];
    try
    {
      byte[] arrayOfByte2 = new byte[1];
      arrayOfByte2[0] = 4;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 1);
      PduHeader localPduHeader = new PduHeader(paramInt1, paramInt2, paramArrayOfByte.length + 25);
      System.arraycopy(localPduHeader.getBuf(), 0, arrayOfByte1, 1, localPduHeader.getBuf().length);
      paramInt1 = localPduHeader.getBuf().length + 1;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, paramInt1, paramArrayOfByte.length);
      paramInt2 = paramArrayOfByte.length;
      arrayOfByte2[0] = 5;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt1 + paramInt2, 1);
      return arrayOfByte1;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label99:
      break label99;
    }
    UploadLog.e("PDUtil", "OutOfMemoryError !!!");
    return arrayOfByte1;
  }
  
  public static byte[] encode(int paramInt, byte[] paramArrayOfByte)
  {
    return encode(paramInt, 0, paramArrayOfByte);
  }
  
  public static void int2byte(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)paramInt1);
  }
  
  public static byte[] int2byte(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24), (byte)(paramInt >> 16), (byte)(paramInt >> 8), (byte)paramInt };
  }
  
  public static byte[] long2byte(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >> 56), (byte)(int)(paramLong >> 48), (byte)(int)(paramLong >> 40), (byte)(int)(paramLong >> 32), (byte)(int)(paramLong >> 24), (byte)(int)(paramLong >> 16), (byte)(int)(paramLong >> 8), (byte)(int)paramLong };
  }
  
  public static void printHexString(String paramString, byte[] paramArrayOfByte)
  {
    UploadLog.e("PDUtil", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      paramString = str;
      if (str.length() == 1)
      {
        paramString = new StringBuilder();
        paramString.append('0');
        paramString.append(str);
        paramString = paramString.toString();
      }
      localStringBuilder.append(paramString.toUpperCase());
      i += 1;
    }
    paramString = new StringBuilder();
    paramString.append("printHexString:");
    paramString.append(localStringBuilder.toString());
    UploadLog.e("PDUtil", paramString.toString());
  }
  
  public static byte[] short2byte(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 8), (byte)paramInt };
  }
  
  public static byte[] toLH(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 24 & 0xFF) };
  }
  
  public static int vtolh(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while ((i < paramArrayOfByte.length) && (i < 4))
    {
      j += (paramArrayOfByte[i] << i * 8);
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.utils.PDUtil
 * JD-Core Version:    0.7.0.1
 */