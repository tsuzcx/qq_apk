package com.tencent.mobileqq.search.model;

public class SearchMatchResult
{
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("source = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" editDistance = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" matchDegree = ");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.SearchMatchResult
 * JD-Core Version:    0.7.0.1
 */