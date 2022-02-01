package com.tencent.open.sdk.data;

import android.os.Parcel;

public abstract class AbsSdkJumpInfo
{
  private BasicSdkJumpInfo a;
  
  public AbsSdkJumpInfo(Parcel paramParcel)
  {
    this.a = ((BasicSdkJumpInfo)paramParcel.readParcelable(BasicSdkJumpInfo.class.getClassLoader()));
  }
  
  public AbsSdkJumpInfo(BasicSdkJumpInfo paramBasicSdkJumpInfo)
  {
    this.a = paramBasicSdkJumpInfo;
  }
  
  public BasicSdkJumpInfo a()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.sdk.data.AbsSdkJumpInfo
 * JD-Core Version:    0.7.0.1
 */