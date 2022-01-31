package com.tencent.mobileqq.hotpic;

import android.os.SystemClock;

public class ScrollVelometer
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ScrollVelometer.SpeedListener jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer$SpeedListener;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  
  public ScrollVelometer(int paramInt, ScrollVelometer.SpeedListener paramSpeedListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer$SpeedListener = paramSpeedListener;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.b += paramInt;
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        return;
      }
    } while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long <= 100L);
    ScrollVelometer.SpeedListener localSpeedListener = this.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer$SpeedListener;
    if (this.b > this.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localSpeedListener.a(bool);
      this.jdField_a_of_type_Long = 0L;
      this.b = 0;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.ScrollVelometer
 * JD-Core Version:    0.7.0.1
 */