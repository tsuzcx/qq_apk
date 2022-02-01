package com.tencent.mobileqq.onlinestatus.config;

import android.support.annotation.NonNull;

public class Category
{
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public double g;
  public int h;
  public int i;
  public int j;
  
  public Category() {}
  
  public Category(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, int paramInt7, int paramInt8)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.h = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramDouble;
    this.i = paramInt7;
    this.j = paramInt8;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Category{level=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", internal=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", poiCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", poiDistance=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", locDistance=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", locAccuracy=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", validRate=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", poiCacheSize=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("poiCacheValidDistance");
    localStringBuilder.append(this.j);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.Category
 * JD-Core Version:    0.7.0.1
 */