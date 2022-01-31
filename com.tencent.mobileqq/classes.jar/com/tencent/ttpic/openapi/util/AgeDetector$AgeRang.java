package com.tencent.ttpic.openapi.util;

public class AgeDetector$AgeRang
{
  int endAge;
  int starAge;
  
  public AgeDetector$AgeRang(int paramInt1, int paramInt2)
  {
    this.starAge = paramInt1;
    this.endAge = paramInt2;
  }
  
  public boolean isMatch(int paramInt)
  {
    return (paramInt >= this.starAge) && (paramInt <= this.endAge);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.AgeDetector.AgeRang
 * JD-Core Version:    0.7.0.1
 */