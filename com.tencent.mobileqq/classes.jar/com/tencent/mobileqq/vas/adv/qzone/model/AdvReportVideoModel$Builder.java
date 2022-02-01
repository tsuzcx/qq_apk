package com.tencent.mobileqq.vas.adv.qzone.model;

public class AdvReportVideoModel$Builder
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public int c = 0;
  
  public AdvReportVideoModel$Builder()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public AdvReportVideoModel a()
  {
    return new AdvReportVideoModel(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_Int);
  }
  
  public Builder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.model.AdvReportVideoModel.Builder
 * JD-Core Version:    0.7.0.1
 */