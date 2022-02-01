package com.tencent.mobileqq.onlinestatus;

import android.support.annotation.NonNull;

public class OnlineMusicStatus
{
  public boolean a;
  public String b = "";
  public String c = "";
  public int d;
  public String e = "";
  public int f;
  public int g;
  public boolean h;
  public int i;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicStatus[needConvert:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", , songId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", songName:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", songType:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", singerName:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", remainTime:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", sourceType:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", pauseFlag:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", duration:");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineMusicStatus
 * JD-Core Version:    0.7.0.1
 */