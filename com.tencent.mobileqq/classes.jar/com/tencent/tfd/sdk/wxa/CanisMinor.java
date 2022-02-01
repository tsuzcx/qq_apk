package com.tencent.tfd.sdk.wxa;

public class CanisMinor
{
  public String rd = "";
  
  public CanisMinor(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.rd = paramString;
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
    return this.rd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.CanisMinor
 * JD-Core Version:    0.7.0.1
 */