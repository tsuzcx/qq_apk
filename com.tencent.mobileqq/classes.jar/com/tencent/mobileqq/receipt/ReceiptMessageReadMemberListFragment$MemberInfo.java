package com.tencent.mobileqq.receipt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ReceiptMessageReadMemberListFragment$MemberInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MemberInfo> CREATOR = new ReceiptMessageReadMemberListFragment.MemberInfo.1();
  public String a;
  public String b;
  public long c;
  
  protected ReceiptMessageReadMemberListFragment$MemberInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
  }
  
  ReceiptMessageReadMemberListFragment$MemberInfo(String paramString1, String paramString2, long paramLong)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo
 * JD-Core Version:    0.7.0.1
 */