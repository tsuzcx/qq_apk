package com.tencent.mobileqq.pluginsdk;

import java.io.UnsupportedEncodingException;

public class PluginBaseInfoHelper$Base64Helper
{
  public static final int CRLF = 4;
  public static final int DEFAULT = 0;
  public static final int NO_CLOSE = 16;
  public static final int NO_PADDING = 1;
  public static final int NO_WRAP = 2;
  public static final int URL_SAFE = 8;
  
  public static byte[] decode(String paramString, int paramInt)
  {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    PluginBaseInfoHelper.Base64Helper.Decoder localDecoder = new PluginBaseInfoHelper.Base64Helper.Decoder(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (localDecoder.process(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      if (localDecoder.op == localDecoder.output.length) {
        return localDecoder.output;
      }
      paramArrayOfByte = new byte[localDecoder.op];
      System.arraycopy(localDecoder.output, 0, paramArrayOfByte, 0, localDecoder.op);
      return paramArrayOfByte;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    PluginBaseInfoHelper.Base64Helper.Encoder localEncoder = new PluginBaseInfoHelper.Base64Helper.Encoder(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    boolean bool = localEncoder.do_padding;
    int j = 2;
    int k;
    if (bool)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
    }
    else
    {
      k = paramInt2 % 3;
      paramInt3 = i;
      if (k != 0) {
        if (k != 1)
        {
          if (k != 2) {
            paramInt3 = i;
          } else {
            paramInt3 = i + 3;
          }
        }
        else {
          paramInt3 = i + 2;
        }
      }
    }
    i = paramInt3;
    if (localEncoder.do_newline)
    {
      i = paramInt3;
      if (paramInt2 > 0)
      {
        k = (paramInt2 - 1) / 57;
        if (localEncoder.do_cr) {
          i = j;
        } else {
          i = 1;
        }
        i = paramInt3 + (k + 1) * i;
      }
    }
    localEncoder.output = new byte[i];
    localEncoder.process(paramArrayOfByte, paramInt1, paramInt2, true);
    return localEncoder.output;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt1, paramInt2, paramInt3), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.Base64Helper
 * JD-Core Version:    0.7.0.1
 */