package com.tencent.mobileqq.hotpic;

import android.os.SystemClock;

public class ScrollVelometer
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ScrollVelometer.SpeedListener jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer$SpeedListener;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c = 100;
  
  public ScrollVelometer(int paramInt, ScrollVelometer.SpeedListener paramSpeedListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer$SpeedListener = paramSpeedListener;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.b += paramInt;
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return;
    }
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long > this.c)
    {
      ScrollVelometer.SpeedListener localSpeedListener = this.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer$SpeedListener;
      boolean bool;
      if (this.b > this.jdField_a_of_type_Int) {
        bool = true;
      } else {
        bool = false;
      }
      localSpeedListener.a(bool);
      this.jdField_a_of_type_Long = 0L;
      this.b = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.ScrollVelometer
 * JD-Core Version:    0.7.0.1
 */