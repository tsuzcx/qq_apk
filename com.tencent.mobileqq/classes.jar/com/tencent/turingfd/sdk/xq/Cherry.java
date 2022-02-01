package com.tencent.turingfd.sdk.xq;

public class Cherry
{
  public String Zh = "";
  
  public Cherry(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.Zh = paramString;
    paramString = paramString.split(":");
    if (paramString != null) {
      if (paramString.length < 4) {
        return;
      }
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
    return this.Zh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cherry
 * JD-Core Version:    0.7.0.1
 */