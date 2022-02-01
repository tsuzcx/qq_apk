package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ReSendCmd
  implements Parcelable
{
  public static final Parcelable.Creator<ReSendCmd> CREATOR = new ReSendCmd.1();
  public int a;
  int b;
  int c;
  public int d;
  public String e = "";
  int f;
  String g = "";
  List<String> h;
  int i = 0;
  
  public ReSendCmd() {}
  
  public ReSendCmd(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    if (this.h == null) {
      this.h = new ArrayList();
    }
    paramParcel.readStringList(this.h);
    this.i = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("urlSrcType : ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" | padUrl : ");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeStringList(this.h);
    paramParcel.writeInt(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.ReSendCmd
 * JD-Core Version:    0.7.0.1
 */