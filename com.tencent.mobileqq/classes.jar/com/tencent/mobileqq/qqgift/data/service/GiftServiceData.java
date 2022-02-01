package com.tencent.mobileqq.qqgift.data.service;

import java.util.Map;

public class GiftServiceData
{
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h = 1;
  public boolean i;
  public int j;
  public GiftServiceData.CornerIcon k;
  public GiftServiceData.FreeInfo l;
  public long m;
  public int n;
  public boolean o = false;
  public Map<String, String> p;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GiftServiceData{giftID=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", giftName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", price=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", giftType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", effectLevel=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", materialID=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", isSelected=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.data.service.GiftServiceData
 * JD-Core Version:    0.7.0.1
 */