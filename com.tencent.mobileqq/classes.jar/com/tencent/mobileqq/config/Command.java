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
    if (paramObject != null)
    {
      if (!(paramObject instanceof Command)) {
        return false;
      }
      if (toString().equals(paramObject.toString())) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.Command
 * JD-Core Version:    0.7.0.1
 */