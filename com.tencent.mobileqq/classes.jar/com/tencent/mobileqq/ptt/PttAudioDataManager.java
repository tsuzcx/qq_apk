package com.tencent.mobileqq.ptt;

import android.os.SystemClock;

public class PttAudioDataManager
  implements IPttAudioDataManager
{
  public long a = 0L;
  protected int[] b = { 0, 500, 700, 1000, 1500, 2100, 2800, 3500, 4200, 4800, 5000 };
  
  public int a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.b;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt < arrayOfInt[i]) {
        return i;
      }
      i += 1;
    }
    return 1;
  }
  
  public boolean a()
  {
    return a(SystemClock.uptimeMillis());
  }
  
  protected boolean a(long paramLong)
  {
    long l = this.a;
    if (l == 0L) {
      this.a = paramLong;
    } else if (paramLong - l < 75L) {
      return false;
    }
    this.a = paramLong;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttAudioDataManager
 * JD-Core Version:    0.7.0.1
 */