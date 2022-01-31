package com.tencent.mobileqq.receipt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import axgz;

public class ReceiptMessageReadMemberListFragment$MemberInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MemberInfo> CREATOR = new axgz();
  public long a;
  public String a;
  public String b;
  
  public ReceiptMessageReadMemberListFragment$MemberInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
  }
  
  ReceiptMessageReadMemberListFragment$MemberInfo(String paramString1, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo
 * JD-Core Version:    0.7.0.1
 */