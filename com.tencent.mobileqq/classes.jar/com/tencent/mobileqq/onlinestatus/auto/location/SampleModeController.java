package com.tencent.mobileqq.onlinestatus.auto.location;

import android.support.annotation.NonNull;

class SampleModeController
{
  private int jdField_a_of_type_Int;
  private SampleModeController.OnSampleModeChangedListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController$OnSampleModeChangedListener;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c = 0;
  
  SampleModeController(int paramInt1, int paramInt2, @NonNull SampleModeController.OnSampleModeChangedListener paramOnSampleModeChangedListener)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController$OnSampleModeChangedListener = paramOnSampleModeChangedListener;
  }
  
  void a()
  {
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = this.jdField_a_of_type_Int;
    } else {
      i = this.b;
    }
    int j = this.c;
    this.c = (j + 1);
    if (j >= i - 1)
    {
      this.c = 0;
      this.jdField_a_of_type_Boolean ^= true;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController$OnSampleModeChangedListener.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  void b()
  {
    this.c = 0;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.SampleModeController
 * JD-Core Version:    0.7.0.1
 */