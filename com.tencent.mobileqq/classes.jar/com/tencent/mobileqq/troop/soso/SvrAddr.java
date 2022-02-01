package com.tencent.mobileqq.troop.soso;

import android.support.annotation.NonNull;

public class SvrAddr
  implements ISvrAddr
{
  public String a = "";
  public int b;
  public boolean c;
  
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  @NonNull
  public String toString()
  {
    if (this.a == null) {
      this.a = "";
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.soso.SvrAddr
 * JD-Core Version:    0.7.0.1
 */