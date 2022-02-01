package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SubPkgInfo$1
  implements Parcelable.Creator<SubPkgInfo>
{
  public SubPkgInfo createFromParcel(Parcel paramParcel)
  {
    SubPkgInfo localSubPkgInfo = new SubPkgInfo();
    localSubPkgInfo.subPkgName = paramParcel.readString();
    localSubPkgInfo.downloadUrl = paramParcel.readString();
    localSubPkgInfo.independent = paramParcel.readInt();
    localSubPkgInfo.fileSize = paramParcel.readInt();
    return localSubPkgInfo;
  }
  
  public SubPkgInfo[] newArray(int paramInt)
  {
    return new SubPkgInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.SubPkgInfo.1
 * JD-Core Version:    0.7.0.1
 */