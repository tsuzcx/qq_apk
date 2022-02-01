package com.tencent.mobileqq.olympic;

public class OlympicDPC
{
  public String a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public int f = 0;
  public int g = 3;
  public int h = 1000;
  public int i = 1;
  public int j = 1;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("allUseInSimple_2=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", bgUseInSimple_2=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", cfgUse_argb8888=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", networkControl=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", dailyRetryTimes=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", countRetryTimes=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", entranceControl=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", autoPreDownload=");
    localStringBuilder.append(this.j);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicDPC
 * JD-Core Version:    0.7.0.1
 */