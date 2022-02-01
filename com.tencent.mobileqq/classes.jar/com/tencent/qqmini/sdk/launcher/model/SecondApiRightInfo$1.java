package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SecondApiRightInfo$1
  implements Parcelable.Creator<SecondApiRightInfo>
{
  public SecondApiRightInfo createFromParcel(Parcel paramParcel)
  {
    SecondApiRightInfo localSecondApiRightInfo = new SecondApiRightInfo();
    localSecondApiRightInfo.apiName = paramParcel.readString();
    localSecondApiRightInfo.secondName = paramParcel.readString();
    localSecondApiRightInfo.right = paramParcel.readInt();
    return localSecondApiRightInfo;
  }
  
  public SecondApiRightInfo[] newArray(int paramInt)
  {
    return new SecondApiRightInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo.1
 * JD-Core Version:    0.7.0.1
 */