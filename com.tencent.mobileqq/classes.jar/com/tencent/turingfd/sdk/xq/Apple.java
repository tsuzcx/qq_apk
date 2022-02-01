package com.tencent.turingfd.sdk.xq;

public class Apple
{
  public String fh = "";
  
  public Apple(String paramString)
  {
    this.fh = paramString;
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length < 4)) {
      return;
    }
    try
    {
      Integer.valueOf(paramString[0]).intValue();
      Long.valueOf(paramString[1]).longValue();
      Long.valueOf(paramString[2]).longValue();
      Integer.valueOf(paramString[3]).intValue();
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public String toString()
  {
    return this.fh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Apple
 * JD-Core Version:    0.7.0.1
 */