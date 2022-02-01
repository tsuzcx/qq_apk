package com.tencent.mobileqq.leba.report;

public abstract class EXBaseReportItem
{
  public int a = 0;
  public int b;
  public long b;
  public int c = 1;
  public String i = "";
  public String j = "";
  public String k = "";
  
  EXBaseReportItem()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
  }
  
  public abstract String a(int paramInt);
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.report.EXBaseReportItem
 * JD-Core Version:    0.7.0.1
 */