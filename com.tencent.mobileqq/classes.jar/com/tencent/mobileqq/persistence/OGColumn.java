package com.tencent.mobileqq.persistence;

public class OGColumn
{
  public String defaultValue;
  public String name;
  public Class<?> type;
  
  public OGColumn() {}
  
  public OGColumn(Class<?> paramClass, String paramString1, String paramString2)
  {
    this.type = paramClass;
    this.name = paramString1;
    this.defaultValue = paramString2;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.OGColumn
 * JD-Core Version:    0.7.0.1
 */