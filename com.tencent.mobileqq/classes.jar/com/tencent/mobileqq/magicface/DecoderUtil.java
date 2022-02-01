package com.tencent.mobileqq.magicface;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DecoderUtil
{
  public static boolean IS_LOAD_SUCESS = false;
  private static String nativeLibraryPath = "";
  
  static
  {
    try
    {
      System.loadLibrary("magicfaceDec");
      IS_LOAD_SUCESS = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label12:
      break label12;
    }
    IS_LOAD_SUCESS = false;
    if (QLog.isColorLevel()) {
      QLog.e("DecoderUtil", 2, "Fail to load libmagicfaceDec.so.");
    }
  }
  
  public DecoderUtil()
  {
    if (new File(nativeLibraryPath).exists()) {
      return;
    }
    Object localObject = new CountDownLatch(1);
    ((ISoLoaderService)QRoute.api(ISoLoaderService.class)).load("TcVpxDec_old", new DecoderUtil.1(this, (CountDownLatch)localObject));
    try
    {
      ((CountDownLatch)localObject).await(3000L, TimeUnit.MILLISECONDS);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nativeLibraryDir[");
        ((StringBuilder)localObject).append(nativeLibraryPath);
        ((StringBuilder)localObject).append("]");
        QLog.i("DecoderUtil", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      QLog.e("DecoderUtil", 1, localInterruptedException, new Object[0]);
    }
  }
  
  public int createAlphaDecoder()
  {
    if (TextUtils.isEmpty(nativeLibraryPath)) {
      return createAlphaDecoder("none");
    }
    return createAlphaDecoder(nativeLibraryPath);
  }
  
  public native int createAlphaDecoder(String paramString);
  
  public int createVideoDecoder()
  {
    if (TextUtils.isEmpty(nativeLibraryPath)) {
      return createVideoDecoder("none");
    }
    return createVideoDecoder(nativeLibraryPath);
  }
  
  public native int createVideoDecoder(String paramString);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.DecoderUtil
 * JD-Core Version:    0.7.0.1
 */