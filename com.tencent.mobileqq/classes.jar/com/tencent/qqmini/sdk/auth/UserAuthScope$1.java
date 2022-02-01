package com.tencent.qqmini.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UserAuthScope$1
  implements Parcelable.Creator<UserAuthScope>
{
  public UserAuthScope createFromParcel(Parcel paramParcel)
  {
    return new UserAuthScope(paramParcel);
  }
  
  public UserAuthScope[] newArray(int paramInt)
  {
    return new UserAuthScope[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.UserAuthScope.1
 * JD-Core Version:    0.7.0.1
 */