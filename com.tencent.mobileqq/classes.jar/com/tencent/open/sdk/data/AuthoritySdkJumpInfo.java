package com.tencent.open.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AuthoritySdkJumpInfo
  extends AbsSdkJumpInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AuthoritySdkJumpInfo> CREATOR = new AuthoritySdkJumpInfo.1();
  
  public AuthoritySdkJumpInfo(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public AuthoritySdkJumpInfo(BasicSdkJumpInfo paramBasicSdkJumpInfo)
  {
    super(paramBasicSdkJumpInfo);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.sdk.data.AuthoritySdkJumpInfo
 * JD-Core Version:    0.7.0.1
 */