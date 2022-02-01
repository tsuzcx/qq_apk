package com.tencent.mobileqq.olympic;

public class OlympicDPC
{
  public int a = 0;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e = 1;
  
  public OlympicDPC()
  {
    this.jdField_b_of_type_Int = 3;
    this.jdField_c_of_type_Int = 1000;
    this.jdField_d_of_type_Int = 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("allUseInSimple_2=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", bgUseInSimple_2=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", cfgUse_argb8888=");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(", networkControl=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", dailyRetryTimes=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", countRetryTimes=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", entranceControl=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", autoPreDownload=");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicDPC
 * JD-Core Version:    0.7.0.1
 */