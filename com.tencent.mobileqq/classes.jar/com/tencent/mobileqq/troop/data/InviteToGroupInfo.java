package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class InviteToGroupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<InviteToGroupInfo> CREATOR = new InviteToGroupInfo.1();
  public String a = "";
  public String b = "";
  public ArrayList<InviteToGroupInfo.UinInfo> c;
  public int d;
  public String e = "";
  
  public InviteToGroupInfo() {}
  
  protected InviteToGroupInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.createTypedArrayList(InviteToGroupInfo.UinInfo.CREATOR);
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InviteToGroupInfo{groupCode='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", invitedUinInfos=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", verifyType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", verifyToken='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeTypedList(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.InviteToGroupInfo
 * JD-Core Version:    0.7.0.1
 */