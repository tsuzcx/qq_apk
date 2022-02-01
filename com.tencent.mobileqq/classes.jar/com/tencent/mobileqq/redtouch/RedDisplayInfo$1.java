package com.tencent.mobileqq.redtouch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RedDisplayInfo$1
  implements Parcelable.Creator<RedDisplayInfo>
{
  public RedDisplayInfo a(Parcel paramParcel)
  {
    RedDisplayInfo localRedDisplayInfo = new RedDisplayInfo();
    localRedDisplayInfo.a = paramParcel.readArrayList(RedTypeInfo.class.getClassLoader());
    RedDisplayInfo.a(localRedDisplayInfo, (RedTypeInfo)paramParcel.readSerializable());
    return localRedDisplayInfo;
  }
  
  public RedDisplayInfo[] a(int paramInt)
  {
    return new RedDisplayInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedDisplayInfo.1
 * JD-Core Version:    0.7.0.1
 */