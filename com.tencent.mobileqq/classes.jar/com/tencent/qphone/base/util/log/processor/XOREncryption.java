package com.tencent.qphone.base.util.log.processor;

import android.annotation.TargetApi;
import android.util.Log;
import com.tencent.qphone.base.util.log.encrypt.XorKey;
import java.nio.charset.Charset;

public class XOREncryption
  implements IByteProcessor
{
  private static final String TAG = "XOREncryption";
  public static final Charset charset = Charset.forName("UTF-8");
  private static byte[] keyBytes;
  private static String xorKey;
  private final boolean enable;
  private int keyIndex = 0;
  
  static
  {
    try
    {
      xorKey = XorKey.genRandomKey();
      keyBytes = xorKey.getBytes(charset);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("XOREncryption", "init error. ", localThrowable);
    }
  }
  
  public XOREncryption(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public static String getXorKey()
  {
    return xorKey;
  }
  
  @TargetApi(19)
  public ProcessByteData handleData(ProcessByteData paramProcessByteData)
  {
    if (this.enable)
    {
      int i = paramProcessByteData.offset;
      while (i < paramProcessByteData.offset + paramProcessByteData.length)
      {
        if (this.keyIndex == keyBytes.length) {
          this.keyIndex = 0;
        }
        byte[] arrayOfByte1 = paramProcessByteData.bytes;
        int j = paramProcessByteData.bytes[i];
        byte[] arrayOfByte2 = keyBytes;
        int k = this.keyIndex;
        this.keyIndex = (k + 1);
        arrayOfByte1[i] = ((byte)(j ^ arrayOfByte2[k]));
        i += 1;
      }
    }
    return paramProcessByteData;
  }
  
  public void reset()
  {
    this.keyIndex = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.processor.XOREncryption
 * JD-Core Version:    0.7.0.1
 */