package com.tencent.qqperf;

import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

class UnifiedMonitor$FamilyConfig
{
  float jdField_a_of_type_Float = 0.001F;
  int jdField_a_of_type_Int = 100;
  long jdField_a_of_type_Long = 0L;
  volatile UnifiedMonitor.StackGetterJob jdField_a_of_type_ComTencentQqperfUnifiedMonitor$StackGetterJob;
  volatile String jdField_a_of_type_JavaLangString = null;
  AbstractUnifiedMonitor.ThreadMonitorCallback jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.1F;
  int jdField_b_of_type_Int = 10;
  volatile long jdField_b_of_type_Long = 0L;
  volatile boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 500;
  boolean jdField_d_of_type_Boolean = false;
  int e = 5;
  int f = 300;
  int g = 0;
  int h = 0;
  int i = 0;
  
  UnifiedMonitor$FamilyConfig() {}
  
  UnifiedMonitor$FamilyConfig(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Int = paramInt3;
    this.i = paramInt4;
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(int paramInt)
  {
    if ((UnifiedMonitor.c()) && (paramInt != 9) && (this.jdField_a_of_type_Float > 0.0F))
    {
      this.jdField_a_of_type_Float = 1.0F;
      this.jdField_b_of_type_Float = 1.0F;
      this.jdField_b_of_type_Int = 2147483647;
    }
    if (Math.random() <= this.jdField_a_of_type_Float) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.UnifiedMonitor.FamilyConfig
 * JD-Core Version:    0.7.0.1
 */