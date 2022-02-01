package com.tencent.mobileqq.onlinestatus.config;

import android.support.annotation.NonNull;

public class Category
{
  public double a;
  public int a;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public Category() {}
  
  public Category(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, int paramInt7, int paramInt8)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.f = paramInt2;
    this.b = paramInt3;
    this.c = paramInt4;
    this.d = paramInt5;
    this.e = paramInt6;
    this.jdField_a_of_type_Double = paramDouble;
    this.g = paramInt7;
    this.h = paramInt8;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Category{level=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", internal=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", poiCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", poiDistance=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", locDistance=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", locAccuracy=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", validRate=");
    localStringBuilder.append(this.jdField_a_of_type_Double);
    localStringBuilder.append(", poiCacheSize=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("poiCacheValidDistance");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.Category
 * JD-Core Version:    0.7.0.1
 */