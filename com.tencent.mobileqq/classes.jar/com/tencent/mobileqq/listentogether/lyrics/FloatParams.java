package com.tencent.mobileqq.listentogether.lyrics;

import android.graphics.Paint.Align;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class FloatParams
{
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public int d = -1;
  public boolean e = true;
  public boolean f = false;
  public String g;
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public boolean k = true;
  public boolean l = false;
  public int m;
  public String n;
  public int o;
  public String p;
  public int q = 0;
  public int r;
  public int s;
  public Paint.Align t;
  public boolean u = false;
  
  public void a(int paramInt, String paramString)
  {
    this.m = paramInt;
    this.n = paramString;
  }
  
  public boolean a()
  {
    return (this.m == this.o) && (TextUtils.equals(this.n, this.p)) && (this.m != 0) && (this.n != null);
  }
  
  public boolean b(int paramInt, String paramString)
  {
    return (paramInt == this.m) && (TextUtils.equals(paramString, this.n)) && (paramInt != 0) && (paramString != null);
  }
  
  public void c(int paramInt, String paramString)
  {
    this.o = paramInt;
    this.p = paramString;
  }
  
  public boolean d(int paramInt, String paramString)
  {
    return (paramInt == this.o) && (TextUtils.equals(paramString, this.p)) && (paramInt != 0) && (paramString != null);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FloatParams[\niconCenterX:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\niconCenterY:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\nalignRight:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\nuserClosed:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\nalbumUrl:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\nshowIcon:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\nisForeground:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\ntmpGoneForSomePage:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\ncurrentListenType:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\ncurrentListenUin:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\ncurrentAIOType:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\ncurrentAIOUin:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\ntextNeedCenter:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\nshowIconValueChanged:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatParams
 * JD-Core Version:    0.7.0.1
 */