package com.tencent.mobileqq.nearby;

public class ReportRecord
{
  public long a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTinyID:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",mPosition:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",mAlgotithmID:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",mEnterCount:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",mProfileCardDuration:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",mVisitPhotoCount:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",mOpflag:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append(Integer.toBinaryString(this.g));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ReportRecord
 * JD-Core Version:    0.7.0.1
 */