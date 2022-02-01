package com.tencent.mobileqq.richmedia.capture.util;

import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class DarkModeChecker
{
  public int a;
  private long jdField_a_of_type_Long;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[256];
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c = 125;
  
  public DarkModeChecker()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
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
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int % 8 == 0)
        {
          this.jdField_b_of_type_Int = (paramInt1 * paramInt2 * (100 - arrayOfInt[1]) / 100);
          this.c = arrayOfInt[2];
          Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
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
                arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
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
            i += this.jdField_a_of_type_ArrayOfInt[paramInt2];
            if (i >= this.jdField_b_of_type_Int)
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
            this.jdField_b_of_type_Long = 0L;
            l = this.jdField_a_of_type_Long;
            if (l == 0L)
            {
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              return;
            }
            if ((l > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 1500L))
            {
              this.jdField_a_of_type_Long = -1L;
              QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE on!");
              this.jdField_b_of_type_Long = 0L;
              paramDarkModeListener.e(true);
            }
          }
          else
          {
            if (this.jdField_a_of_type_Long > 0L) {
              this.jdField_a_of_type_Long = 0L;
            }
            l = this.jdField_b_of_type_Long;
            if (l == 0L)
            {
              this.jdField_b_of_type_Long = System.currentTimeMillis();
              return;
            }
            if ((l > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 2000L))
            {
              this.jdField_b_of_type_Long = -1L;
              QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE off!");
              this.jdField_a_of_type_Long = 0L;
              paramDarkModeListener.e(false);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker
 * JD-Core Version:    0.7.0.1
 */