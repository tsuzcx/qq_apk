package com.tencent.mobileqq.writetogether.data;

import androidx.annotation.NonNull;

public class UserEditInfo
{
  public String a;
  public String b;
  public int c;
  public int d;
  public boolean e;
  public int f = -1;
  public int g;
  public boolean h;
  public float i;
  public boolean j;
  
  public UserEditInfo() {}
  
  public UserEditInfo(UserEditInfo paramUserEditInfo)
  {
    this.a = paramUserEditInfo.a;
    this.b = paramUserEditInfo.b;
    this.c = paramUserEditInfo.c;
    this.d = paramUserEditInfo.d;
    this.e = paramUserEditInfo.e;
    this.f = paramUserEditInfo.f;
    this.g = paramUserEditInfo.g;
    this.h = paramUserEditInfo.h;
    this.i = paramUserEditInfo.i;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.UserEditInfo
 * JD-Core Version:    0.7.0.1
 */