package com.tencent.qqprotect.qsec;

public class ICloudAVEngine$ResultBundle
{
  public int a;
  public long a;
  public boolean a;
  public byte[] a;
  public int b;
  public int c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[type:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",cate:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",subcate:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",expire:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",act:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",iscache:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.ICloudAVEngine.ResultBundle
 * JD-Core Version:    0.7.0.1
 */