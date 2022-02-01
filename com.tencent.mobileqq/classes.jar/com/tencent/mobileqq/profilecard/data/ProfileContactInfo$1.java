package com.tencent.mobileqq.profilecard.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ProfileContactInfo$1
  implements Parcelable.Creator<ProfileContactInfo>
{
  public ProfileContactInfo createFromParcel(Parcel paramParcel)
  {
    ProfileContactInfo localProfileContactInfo = new ProfileContactInfo(null);
    localProfileContactInfo.phoneName = paramParcel.readString();
    localProfileContactInfo.phoneNumber = paramParcel.readString();
    localProfileContactInfo.phoneNationalCode = paramParcel.readString();
    return localProfileContactInfo;
  }
  
  public ProfileContactInfo[] newArray(int paramInt)
  {
    return new ProfileContactInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.data.ProfileContactInfo.1
 * JD-Core Version:    0.7.0.1
 */