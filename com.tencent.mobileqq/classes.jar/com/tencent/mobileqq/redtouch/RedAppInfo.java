package com.tencent.mobileqq.redtouch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class RedAppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RedAppInfo> CREATOR = new RedAppInfo.1();
  ArrayList<String> a;
  private int b;
  private int c;
  private int d;
  private String e;
  private String f;
  private int g;
  private int h;
  private int i;
  private String j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private RedDisplayInfo p;
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(RedDisplayInfo paramRedDisplayInfo)
  {
    this.p = paramRedDisplayInfo;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public void d(int paramInt)
  {
    this.g = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public void e(int paramInt)
  {
    this.h = paramInt;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public void f(int paramInt)
  {
    this.i = paramInt;
  }
  
  public List<String> g()
  {
    return this.a;
  }
  
  public void g(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public void h(int paramInt)
  {
    this.l = paramInt;
  }
  
  public int i()
  {
    return this.i;
  }
  
  public void i(int paramInt)
  {
    this.m = paramInt;
  }
  
  public String j()
  {
    return this.j;
  }
  
  public void j(int paramInt)
  {
    this.n = paramInt;
  }
  
  public int k()
  {
    return this.k;
  }
  
  public void k(int paramInt)
  {
    this.o = paramInt;
  }
  
  public int l()
  {
    return this.l;
  }
  
  public int m()
  {
    return this.m;
  }
  
  public int n()
  {
    return this.n;
  }
  
  public RedDisplayInfo o()
  {
    return this.p;
  }
  
  public int p()
  {
    return this.o;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeList(this.a);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeParcelable(this.p, paramInt);
    paramParcel.writeInt(this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedAppInfo
 * JD-Core Version:    0.7.0.1
 */