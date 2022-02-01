package com.tencent.turingfd.sdk.ams.ga;

public class Gemini
{
  public String Ud;
  public int cd;
  
  public Gemini(String paramString, int paramInt)
  {
    this.Ud = paramString;
    this.cd = paramInt;
  }
  
  public static Gemini g(int paramInt)
  {
    return new Gemini("", paramInt);
  }
  
  public int getErrorCode()
  {
    return this.cd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Gemini
 * JD-Core Version:    0.7.0.1
 */