package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Map;

final class CommExtInfo$1
  implements Parcelable.Creator<CommExtInfo>
{
  public CommExtInfo createFromParcel(Parcel paramParcel)
  {
    CommExtInfo localCommExtInfo = new CommExtInfo();
    localCommExtInfo.mapInfo = paramParcel.readHashMap(Map.class.getClassLoader());
    localCommExtInfo.attachInfo = paramParcel.readString();
    return localCommExtInfo;
  }
  
  public CommExtInfo[] newArray(int paramInt)
  {
    return new CommExtInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.CommExtInfo.1
 * JD-Core Version:    0.7.0.1
 */