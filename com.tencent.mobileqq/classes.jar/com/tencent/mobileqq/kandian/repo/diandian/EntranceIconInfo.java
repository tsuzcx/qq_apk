package com.tencent.mobileqq.kandian.repo.diandian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class EntranceIconInfo
  implements Parcelable, IEntranceButtonDataSource
{
  public static final Parcelable.Creator<EntranceIconInfo> CREATOR = new EntranceIconInfo.1();
  public int a;
  public String b = "";
  public String c = "";
  public String d = "";
  public boolean e;
  public ExtraInfo f;
  public String g = "";
  public int h;
  
  public EntranceIconInfo()
  {
    this.h = 0;
  }
  
  public EntranceIconInfo(Parcel paramParcel)
  {
    boolean bool = false;
    this.h = 0;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.e = bool;
    this.f = ((ExtraInfo)paramParcel.readParcelable(ExtraInfo.class.getClassLoader()));
  }
  
  public static EntranceIconInfo a(int paramInt, String paramString)
  {
    EntranceIconInfo localEntranceIconInfo = new EntranceIconInfo();
    localEntranceIconInfo.a = paramInt;
    localEntranceIconInfo.d = paramString;
    return localEntranceIconInfo;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return TextUtils.isEmpty(this.b) ^ true;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return TextUtils.isEmpty(this.c) ^ true;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EntranceIconInfo {feedsType : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\nmsgIconUrl :");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\ndefaultIconUrl :");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\njumpSchema :");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\nextraInfo : ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeParcelable(this.f, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.diandian.EntranceIconInfo
 * JD-Core Version:    0.7.0.1
 */