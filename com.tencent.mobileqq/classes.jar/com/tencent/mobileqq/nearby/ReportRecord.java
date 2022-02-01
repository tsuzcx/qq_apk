package com.tencent.mobileqq.nearby;

public class ReportRecord
{
  public int a;
  public long a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTinyID:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",mPosition:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",mAlgotithmID:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",mEnterCount:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",mProfileCardDuration:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",mVisitPhotoCount:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",mOpflag:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append(Integer.toBinaryString(this.f));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ReportRecord
 * JD-Core Version:    0.7.0.1
 */