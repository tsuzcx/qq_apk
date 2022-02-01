package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bffh;
import java.util.ArrayList;

public class InviteToGroupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<InviteToGroupInfo> CREATOR = new bffh();
  public int a;
  public String a;
  public ArrayList<InviteToGroupInfo.UinInfo> a;
  public String b = "";
  public String c = "";
  
  public InviteToGroupInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public InviteToGroupInfo(Parcel paramParcel)
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
    return "InviteToGroupInfo{groupCode='" + this.jdField_a_of_type_JavaLangString + '\'' + ", msg='" + this.b + '\'' + ", invitedUinInfos=" + this.jdField_a_of_type_JavaUtilArrayList + ", verifyType=" + this.jdField_a_of_type_Int + ", verifyToken='" + this.c + '\'' + '}';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.InviteToGroupInfo
 * JD-Core Version:    0.7.0.1
 */