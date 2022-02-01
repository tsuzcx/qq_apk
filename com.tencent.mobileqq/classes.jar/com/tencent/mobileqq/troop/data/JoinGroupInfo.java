package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class JoinGroupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<JoinGroupInfo> CREATOR = new JoinGroupInfo.1();
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public byte[] f;
  public String g;
  public int h;
  public String i;
  
  public JoinGroupInfo() {}
  
  protected JoinGroupInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.createByteArray();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JoinGroupInfo{groupCode='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reason='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", statOption='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authKey='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authSig='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", newMemberMsg=");
    localStringBuilder.append(Arrays.toString(this.f));
    localStringBuilder.append(", picUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", verifyType=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", verifyToken='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeByteArray(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.JoinGroupInfo
 * JD-Core Version:    0.7.0.1
 */