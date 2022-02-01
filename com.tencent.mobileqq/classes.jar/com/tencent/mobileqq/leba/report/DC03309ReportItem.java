package com.tencent.mobileqq.leba.report;

public class DC03309ReportItem
  extends EXBaseReportItem
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  
  public DC03309ReportItem()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("|");
    localStringBuilder.append(this.i);
    localStringBuilder.append("|");
    localStringBuilder.append(this.j);
    localStringBuilder.append("|");
    localStringBuilder.append(this.k);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("|");
    if (paramInt == 0)
    {
      localStringBuilder.append("${count_unknown}");
      localStringBuilder.append("|");
    }
    else
    {
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("|");
    }
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(64);
    localStringBuffer.append(this.jdField_b_of_type_Long);
    localStringBuffer.append("|");
    localStringBuffer.append(this.i);
    localStringBuffer.append("|");
    localStringBuffer.append(this.j);
    localStringBuffer.append("|");
    localStringBuffer.append(this.k);
    localStringBuffer.append("|");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append(this.jdField_c_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append(this.jdField_a_of_type_Long);
    localStringBuffer.append("|");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append("|");
    localStringBuffer.append(this.jdField_b_of_type_JavaLangString);
    localStringBuffer.append("|");
    localStringBuffer.append(this.jdField_c_of_type_JavaLangString);
    localStringBuffer.append("|");
    localStringBuffer.append(this.d);
    localStringBuffer.append("|");
    localStringBuffer.append(this.e);
    localStringBuffer.append("|");
    localStringBuffer.append(this.f);
    localStringBuffer.append("|");
    localStringBuffer.append(this.g);
    localStringBuffer.append("|");
    localStringBuffer.append(this.h);
    localStringBuffer.append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.report.DC03309ReportItem
 * JD-Core Version:    0.7.0.1
 */