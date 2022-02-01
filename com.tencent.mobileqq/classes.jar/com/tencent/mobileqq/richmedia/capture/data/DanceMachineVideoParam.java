package com.tencent.mobileqq.richmedia.capture.data;

public class DanceMachineVideoParam
  extends VideoBusinessParam
{
  public String a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public boolean g = false;
  public String h;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("danceScoreRate : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\ndanceScore : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\nptvCategory : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\nptvId : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" \nactivityType : ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\nactivityId : ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\noverPercent : ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\nuseSpecialShare : ");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.DanceMachineVideoParam
 * JD-Core Version:    0.7.0.1
 */