package com.tencent.mobileqq.ptt;

import android.os.SystemClock;

public class PttAudioDataManager
{
  public long a;
  protected int[] a;
  
  public PttAudioDataManager()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 500, 700, 1000, 1500, 2100, 2800, 3500, 4200, 4800, 5000 };
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (paramInt < this.jdField_a_of_type_ArrayOfInt[i]) {
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
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
    while (paramLong - this.jdField_a_of_type_Long >= 75L)
    {
      this.jdField_a_of_type_Long = paramLong;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttAudioDataManager
 * JD-Core Version:    0.7.0.1
 */