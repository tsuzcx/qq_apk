package com.tencent.ttpic.baseutils.zip;

import com.tencent.ttpic.baseutils.log.LogUtils;

public class Lz4Utils
{
  public static final int MAX_OUTPUT_LENGTH = 307200;
  
  static
  {
    try
    {
      System.loadLibrary("pitu_tools");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogUtils.e(localUnsatisfiedLinkError);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      LogUtils.e(localRuntimeException);
      return;
    }
    catch (Exception localException)
    {
      LogUtils.e(localException);
    }
  }
  
  public static native byte[] compress(byte[] paramArrayOfByte, int paramInt);
  
  public static native byte[] compressHigh(byte[] paramArrayOfByte, int paramInt);
  
  public static native byte[] decompress(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.zip.Lz4Utils
 * JD-Core Version:    0.7.0.1
 */