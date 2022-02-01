package com.tencent.mobileqq.vashealth.config;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/StepConfigBean;", "", "stepCounterMode", "", "stepCadence", "activeReportInterval", "passiveReportInterval", "maxRecordDays", "(IIIII)V", "getActiveReportInterval", "()I", "getMaxRecordDays", "getPassiveReportInterval", "getStepCadence", "getStepCounterMode", "Companion", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class StepConfigBean
{
  public static final StepConfigBean.Companion a;
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVashealthConfigStepConfigBean$Companion = new StepConfigBean.Companion(null);
  }
  
  public StepConfigBean()
  {
    this(0, 0, 0, 0, 0, 31, null);
  }
  
  public StepConfigBean(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.StepConfigBean
 * JD-Core Version:    0.7.0.1
 */