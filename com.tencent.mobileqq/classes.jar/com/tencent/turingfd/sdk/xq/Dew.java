package com.tencent.turingfd.sdk.xq;

public class Dew
{
  public String a = "";
  public boolean b;
  public long c;
  public long d;
  
  public Dew(String paramString)
  {
    boolean bool = false;
    this.b = false;
    this.c = 0L;
    this.d = 0L;
    if (paramString == null) {
      return;
    }
    this.a = paramString;
    paramString = paramString.split(":");
    if (paramString != null) {
      if (paramString.length < 4) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Integer.valueOf(paramString[0]).intValue();
        this.c = Long.valueOf(paramString[1]).longValue();
        this.d = Long.valueOf(paramString[2]).longValue();
        if (Integer.valueOf(paramString[3]).intValue() == 0) {
          this.b = bool;
        }
      }
      finally
      {
        return;
      }
      bool = true;
    }
  }
  
  public static Dew a()
  {
    return new Dew("");
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Dew
 * JD-Core Version:    0.7.0.1
 */