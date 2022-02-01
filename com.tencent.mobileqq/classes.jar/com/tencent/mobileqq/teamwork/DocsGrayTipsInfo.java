package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class DocsGrayTipsInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DocsGrayTipsInfo> CREATOR = new DocsGrayTipsInfo.1();
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
      String str = TeamWorkConstants.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get height light area exception = ");
      localStringBuilder.append(localException.toString());
      QLog.e(str, 1, localStringBuilder.toString());
    }
    return arrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DocsGrayTipsInfo | uin =");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" , url=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" , type = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" , optType = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" , authTips =");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" , highlightText =");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" , setflag =");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" , setPolicy =");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" , setOnly =");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" , sucResult =");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" , failResult =");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" , netFailResult =");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" , policy = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" , privilege = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(" , member_num= ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(" , remainTime=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" , setTime= ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" , bNeedSetTime =");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" , tipType =");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" , tipUrl =");
    localStringBuilder.append(this.t);
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.DocsGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */