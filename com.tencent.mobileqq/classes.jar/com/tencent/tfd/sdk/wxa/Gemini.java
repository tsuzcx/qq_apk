package com.tencent.tfd.sdk.wxa;

public class Gemini
{
  public String Gd;
  public int Oc;
  
  public Gemini(String paramString, int paramInt)
  {
    this.Gd = paramString;
    this.Oc = paramInt;
  }
  
  public static Gemini g(int paramInt)
  {
    return new Gemini("", paramInt);
  }
  
  public int getErrorCode()
  {
    return this.Oc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Gemini
 * JD-Core Version:    0.7.0.1
 */