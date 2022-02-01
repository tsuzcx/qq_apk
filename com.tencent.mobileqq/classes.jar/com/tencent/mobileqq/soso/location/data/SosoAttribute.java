package com.tencent.mobileqq.soso.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class SosoAttribute
  implements Parcelable
{
  public static final Parcelable.Creator<SosoAttribute> CREATOR = new SosoAttribute.1();
  public String mImei;
  public String mImsi;
  public String mPhoneNum;
  public String mQQNum;
  public boolean roaming;
  
  protected SosoAttribute(Parcel paramParcel)
  {
    this.mImei = paramParcel.readString();
    this.mImsi = paramParcel.readString();
    this.mPhoneNum = paramParcel.readString();
    this.mQQNum = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.roaming = bool;
      return;
    }
  }
  
  public SosoAttribute(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.mImei = paramString1;
    this.mImsi = paramString2;
    this.mPhoneNum = paramString3;
    this.mQQNum = paramString4;
    this.roaming = paramBoolean;
  }
  
  public SosoAttribute clone()
  {
    return new SosoAttribute(this.mImei, this.mImsi, this.mPhoneNum, this.mQQNum, this.roaming);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mImei);
    paramParcel.writeString(this.mImsi);
    paramParcel.writeString(this.mPhoneNum);
    paramParcel.writeString(this.mQQNum);
    if (this.roaming) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.data.SosoAttribute
 * JD-Core Version:    0.7.0.1
 */