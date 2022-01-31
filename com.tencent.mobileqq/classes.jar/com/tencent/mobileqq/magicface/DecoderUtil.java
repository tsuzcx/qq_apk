package com.tencent.mobileqq.magicface;

import com.tencent.qphone.base.util.QLog;

public class DecoderUtil
{
  public static boolean IS_LOAD_SUCESS;
  
  static
  {
    try
    {
      System.loadLibrary("magicfaceDec");
      IS_LOAD_SUCESS = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      do
      {
        IS_LOAD_SUCESS = false;
      } while (!QLog.isColorLevel());
      QLog.e("DecoderUtil", 2, "Fail to load libmagicfaceDec.so.");
    }
  }
  
  public native int createAlphaDecoder();
  
  public native int createVideoDecoder();
  
  public native int decodeAlphaDecoder(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int decodeAlphaDecoderReturnYUV(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int decodeVideoDecoder(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int decodeVideoDecoderReturnYUV(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int getHeightAlphaDecoder();
  
  public native int getHeightVideoDecoder();
  
  public native int getWidthAlphaDecoder();
  
  public native int getWidthVideoDecoder();
  
  public native int releaseAlphaDecoder();
  
  public native int releaseVideoDecoder();
  
  public void testfunc1(byte[] paramArrayOfByte, long paramLong) {}
  
  public void testfunc2(byte paramByte, long paramLong) {}
  
  public void testfunc3() {}
  
  public void testfunc4(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.DecoderUtil
 * JD-Core Version:    0.7.0.1
 */