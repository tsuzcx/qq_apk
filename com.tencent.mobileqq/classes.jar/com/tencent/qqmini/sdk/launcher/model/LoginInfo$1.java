package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LoginInfo$1
  implements Parcelable.Creator<LoginInfo>
{
  public LoginInfo createFromParcel(Parcel paramParcel)
  {
    LoginInfo localLoginInfo = new LoginInfo();
    LoginInfo.access$002(localLoginInfo, paramParcel.readInt());
    LoginInfo.access$102(localLoginInfo, paramParcel.readString());
    LoginInfo.access$202(localLoginInfo, paramParcel.readString());
    LoginInfo.access$302(localLoginInfo, paramParcel.readString());
    LoginInfo.access$402(localLoginInfo, paramParcel.readString());
    LoginInfo.access$502(localLoginInfo, paramParcel.readString());
    LoginInfo.access$602(localLoginInfo, paramParcel.createByteArray());
    LoginInfo.access$702(localLoginInfo, paramParcel.readString());
    LoginInfo.access$802(localLoginInfo, paramParcel.readString());
    return localLoginInfo;
  }
  
  public LoginInfo[] newArray(int paramInt)
  {
    return new LoginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.LoginInfo.1
 * JD-Core Version:    0.7.0.1
 */