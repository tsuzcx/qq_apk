package com.tencent.mqp.app.sec;

import com.tencent.mobileqq.app.ThreadManager;

public class SecClientInfoTaskEx
  implements Runnable
{
  private static boolean c = false;
  private static String d;
  private int a = 1;
  private int b = 1;
  private long e = 1L;
  
  public SecClientInfoTaskEx(long paramLong, int paramInt1, int paramInt2)
  {
    this.e = paramLong;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private static byte[] b(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >>> 24) };
  }
  
  public void run()
  {
    ThreadManager.post(new SecClientInfoTaskEx.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.sec.SecClientInfoTaskEx
 * JD-Core Version:    0.7.0.1
 */