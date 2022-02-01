package com.tencent.mobileqq.guild.data;

public class QQGuildWrapData<T>
{
  private T a;
  private String b;
  
  public QQGuildWrapData(T paramT, String paramString)
  {
    this.a = paramT;
    this.b = paramString;
  }
  
  public T a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.data.QQGuildWrapData
 * JD-Core Version:    0.7.0.1
 */