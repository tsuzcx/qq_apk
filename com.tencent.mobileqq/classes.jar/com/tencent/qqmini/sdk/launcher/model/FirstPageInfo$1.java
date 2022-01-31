package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FirstPageInfo$1
  implements Parcelable.Creator<FirstPageInfo>
{
  public FirstPageInfo createFromParcel(Parcel paramParcel)
  {
    FirstPageInfo localFirstPageInfo = new FirstPageInfo();
    localFirstPageInfo.pagePath = paramParcel.readString();
    localFirstPageInfo.subPkgName = paramParcel.readString();
    return localFirstPageInfo;
  }
  
  public FirstPageInfo[] newArray(int paramInt)
  {
    return new FirstPageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.FirstPageInfo.1
 * JD-Core Version:    0.7.0.1
 */