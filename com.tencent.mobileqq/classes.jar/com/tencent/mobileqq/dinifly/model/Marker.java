package com.tencent.mobileqq.dinifly.model;

public class Marker
{
  private static String CARRIAGE_RETURN = "\r";
  public final float durationFrames;
  private final String name;
  public final float startFrame;
  
  public Marker(String paramString, float paramFloat1, float paramFloat2)
  {
    this.name = paramString;
    this.durationFrames = paramFloat2;
    this.startFrame = paramFloat1;
  }
  
  public boolean matchesName(String paramString)
  {
    if (this.name.equalsIgnoreCase(paramString)) {
      return true;
    }
    if (this.name.endsWith(CARRIAGE_RETURN))
    {
      String str = this.name;
      if (str.substring(0, str.length() - 1).equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.Marker
 * JD-Core Version:    0.7.0.1
 */