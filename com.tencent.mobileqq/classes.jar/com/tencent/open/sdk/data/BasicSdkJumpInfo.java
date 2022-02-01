package com.tencent.open.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class BasicSdkJumpInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BasicSdkJumpInfo> CREATOR = new BasicSdkJumpInfo.1();
  private long a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public BasicSdkJumpInfo(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.a = paramLong;
    this.b = a(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "unknown";
    }
    this.c = paramString1;
    this.d = a(paramString3);
    this.e = a(paramString4);
    this.f = a(paramString5);
    this.g = a(paramString6);
    this.h = "";
  }
  
  protected BasicSdkJumpInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public long a()
  {
    return this.a;
  }
  
  protected String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.sdk.data.BasicSdkJumpInfo
 * JD-Core Version:    0.7.0.1
 */