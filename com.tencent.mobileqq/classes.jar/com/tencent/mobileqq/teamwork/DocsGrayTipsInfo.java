package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aydp;
import ayeb;
import com.tencent.qphone.base.util.QLog;

public class DocsGrayTipsInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DocsGrayTipsInfo> CREATOR = new aydp();
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  
  public DocsGrayTipsInfo() {}
  
  public DocsGrayTipsInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    this.s = paramParcel.readString();
    this.t = paramParcel.readString();
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    try
    {
      String[] arrayOfString = this.f.split("-");
      arrayOfInt[0] = Integer.valueOf(arrayOfString[0]).intValue();
      arrayOfInt[1] = Integer.valueOf(arrayOfString[1]).intValue();
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      QLog.e(ayeb.i, 1, "get height light area exception = " + localException.toString());
    }
    return arrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DocsGrayTipsInfo | uin =" + this.a + " , url=" + this.b + " , type = " + this.c + " , optType = " + this.d + " , authTips =" + this.e + " , highlightText =" + this.f + " , setflag =" + this.g + " , setPolicy =" + this.h + " , setOnly =" + this.i + " , sucResult =" + this.j + " , failResult =" + this.k + " , netFailResult =" + this.l + " , policy = " + this.m + " , privilege = " + this.n + " , member_num= " + this.o + " , remainTime=" + this.p + " , setTime= " + this.q + " , bNeedSetTime =" + this.r + " , tipType =" + this.s + " , tipUrl =" + this.t;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.DocsGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */