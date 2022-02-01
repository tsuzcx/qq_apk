package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class InviteToGroupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<InviteToGroupInfo> CREATOR = new InviteToGroupInfo.1();
  public int a;
  public String a;
  public ArrayList<InviteToGroupInfo.UinInfo> a;
  public String b = "";
  public String c = "";
  
  public InviteToGroupInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  protected InviteToGroupInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(InviteToGroupInfo.UinInfo.CREATOR);
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InviteToGroupInfo{groupCode='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", invitedUinInfos=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append(", verifyType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", verifyToken='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.InviteToGroupInfo
 * JD-Core Version:    0.7.0.1
 */