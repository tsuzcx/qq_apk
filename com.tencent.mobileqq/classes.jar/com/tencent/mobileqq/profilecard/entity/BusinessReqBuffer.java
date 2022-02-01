package com.tencent.mobileqq.profilecard.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BusinessReqBuffer
  implements Parcelable
{
  public static final Parcelable.Creator<BusinessReqBuffer> CREATOR = new BusinessReqBuffer.1();
  private byte[] buffer;
  private int businessType;
  
  public BusinessReqBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    this.businessType = paramInt;
    this.buffer = paramArrayOfByte;
  }
  
  protected BusinessReqBuffer(Parcel paramParcel)
  {
    this.businessType = paramParcel.readInt();
    paramParcel.readByteArray(this.buffer);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getBuffer()
  {
    return this.buffer;
  }
  
  public int getBusinessType()
  {
    return this.businessType;
  }
  
  public void setBuffer(byte[] paramArrayOfByte)
  {
    this.buffer = paramArrayOfByte;
  }
  
  public void setBusinessType(int paramInt)
  {
    this.businessType = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.businessType);
    paramParcel.writeByteArray(this.buffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer
 * JD-Core Version:    0.7.0.1
 */