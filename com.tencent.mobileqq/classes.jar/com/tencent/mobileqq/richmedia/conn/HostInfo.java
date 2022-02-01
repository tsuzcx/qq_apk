package com.tencent.mobileqq.richmedia.conn;

public class HostInfo
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e;
  
  public HostInfo(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public HostInfo a()
  {
    return (HostInfo)super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(":");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" failCount:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.HostInfo
 * JD-Core Version:    0.7.0.1
 */