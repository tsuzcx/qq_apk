package com.tencent.mobileqq.profilecard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ProfileContactInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ProfileContactInfo> CREATOR = new ProfileContactInfo.1();
  public String phoneName;
  public String phoneNationalCode;
  public String phoneNumber;
  
  private ProfileContactInfo() {}
  
  public ProfileContactInfo(String paramString1, String paramString2, String paramString3)
  {
    this.phoneName = paramString1;
    this.phoneNumber = paramString2;
    this.phoneNationalCode = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.phoneName);
    paramParcel.writeString(this.phoneNumber);
    paramParcel.writeString(this.phoneNationalCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.data.ProfileContactInfo
 * JD-Core Version:    0.7.0.1
 */