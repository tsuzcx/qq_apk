package com.tencent.mobileqq.config;

public class Command
{
  private String a;
  
  public Command(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Command))) {}
    while (!toString().equals(paramObject.toString())) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.Command
 * JD-Core Version:    0.7.0.1
 */