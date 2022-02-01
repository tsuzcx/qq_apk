package com.tencent.mobileqq.richmedia.capture.util;

import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class DarkModeChecker
{
  public int a = 0;
  private int b;
  private int c = 125;
  private final int[] d = new int[256];
  private long e;
  private long f;
  
  public void a()
  {
    this.e = 0L;
    this.f = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeChecker", 2, "refreshTimer ");
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, DarkModeChecker.DarkModeListener paramDarkModeListener)
  {
    if (paramDarkModeListener != null)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      int[] arrayOfInt = ShortVideoUtils.getDarkModeDPCValues();
      if (arrayOfInt[0] == 1)
      {
        this.a += 1;
        if (this.a % 8 == 0)
        {
          this.b = (paramInt1 * paramInt2 * (100 - arrayOfInt[1]) / 100);
          this.c = arrayOfInt[2];
          Arrays.fill(this.d, 0);
          int i = 1;
          int j;
          for (;;)
          {
            j = 255;
            if (i >= paramInt2) {
              break;
            }
            j = 1;
            while (j < paramInt1)
            {
              int k = i * paramInt1 + j;
              if (k < paramArrayOfByte.length)
              {
                arrayOfInt = this.d;
                k = paramArrayOfByte[k] & 0xFF;
                arrayOfInt[k] += 64;
              }
              j += 8;
            }
            i += 8;
          }
          i = 0;
          paramInt1 = 255;
          for (paramInt2 = j; paramInt2 >= 51; paramInt2 = j)
          {
            i += this.d[paramInt2];
            if (i >= this.b)
            {
              paramInt1 = paramInt2;
              break;
            }
            j = paramInt2 - 1;
            paramInt1 = paramInt2;
          }
          long l;
          if (paramInt1 <= this.c)
          {
            QLog.w("DarkModeChecker", 1, "darkmode = true!");
            this.f = 0L;
            l = this.e;
            if (l == 0L)
            {
              this.e = System.currentTimeMillis();
              return;
            }
            if ((l > 0L) && (System.currentTimeMillis() - this.e >= 1500L))
            {
              this.e = -1L;
              QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE on!");
              this.f = 0L;
              paramDarkModeListener.f(true);
            }
          }
          else
          {
            if (this.e > 0L) {
              this.e = 0L;
            }
            l = this.f;
            if (l == 0L)
            {
              this.f = System.currentTimeMillis();
              return;
            }
            if ((l > 0L) && (System.currentTimeMillis() - this.f >= 2000L))
            {
              this.f = -1L;
              QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE off!");
              this.e = 0L;
              paramDarkModeListener.f(false);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker
 * JD-Core Version:    0.7.0.1
 */