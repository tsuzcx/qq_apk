package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.qphone.base.util.QLog;

public class AverageSampler
{
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AverageSampler.OnSamplerTriggerListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler$OnSamplerTriggerListener;
  private String jdField_a_of_type_JavaLangString;
  private double jdField_b_of_type_Double = 0.0D;
  private int jdField_b_of_type_Int = 0;
  
  AverageSampler(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  void a()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
  }
  
  public void a(double paramDouble)
  {
    long l = System.currentTimeMillis();
    int i = this.jdField_b_of_type_Int;
    Object localObject;
    if (i < this.jdField_a_of_type_Int - 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][sampler] ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" sample. count: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(" value: ");
        ((StringBuilder)localObject).append(paramDouble);
        ((StringBuilder)localObject).append(" total: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Double);
        QLog.d("TimeSampler", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Double += paramDouble;
      this.jdField_b_of_type_Double = Math.max(this.jdField_b_of_type_Double, paramDouble);
      this.jdField_b_of_type_Int += 1;
    }
    else
    {
      this.jdField_a_of_type_Double += paramDouble;
      if (l - this.jdField_a_of_type_Long < 30L)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[status][sampler] ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" sample. batch mode count: ");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject).append(" value: ");
          ((StringBuilder)localObject).append(paramDouble);
          ((StringBuilder)localObject).append(" total: ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Double);
          QLog.d("TimeSampler", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_b_of_type_Double = Math.max(this.jdField_b_of_type_Double, paramDouble);
        this.jdField_b_of_type_Int += 1;
        return;
      }
      double d1 = this.jdField_a_of_type_Double;
      double d2 = i + 1;
      Double.isNaN(d2);
      d1 /= d2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][sampler] ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" sample. triggered count: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(" value: ");
        ((StringBuilder)localObject).append(paramDouble);
        ((StringBuilder)localObject).append(" total: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Double);
        ((StringBuilder)localObject).append(" ave: ");
        ((StringBuilder)localObject).append(d1);
        QLog.d("TimeSampler", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler$OnSamplerTriggerListener;
      if (localObject != null) {
        ((AverageSampler.OnSamplerTriggerListener)localObject).a(d1, this.jdField_b_of_type_Double);
      }
      a();
    }
    this.jdField_a_of_type_Long = l;
  }
  
  void a(AverageSampler.OnSamplerTriggerListener paramOnSamplerTriggerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler$OnSamplerTriggerListener = paramOnSamplerTriggerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.AverageSampler
 * JD-Core Version:    0.7.0.1
 */