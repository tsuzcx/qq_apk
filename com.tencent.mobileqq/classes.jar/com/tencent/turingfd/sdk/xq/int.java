package com.tencent.turingfd.sdk.xq;

public class int
{
  public int code;
  public long k;
  public String value;
  
  public int(String paramString, int paramInt)
  {
    this.value = paramString;
    this.code = paramInt;
    this.k = (System.currentTimeMillis() + 86400000L);
  }
  
  public String toString()
  {
    return "ValueData{value='" + this.value + '\'' + ", code=" + this.code + ", expired=" + this.k + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.int
 * JD-Core Version:    0.7.0.1
 */