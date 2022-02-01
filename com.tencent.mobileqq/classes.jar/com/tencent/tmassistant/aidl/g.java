package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g
  implements Parcelable.Creator<TMAssistantDownloadLogInfo>
{
  public TMAssistantDownloadLogInfo a(Parcel paramParcel)
  {
    return new TMAssistantDownloadLogInfo(paramParcel.readString(), paramParcel.readLong(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
  }
  
  public TMAssistantDownloadLogInfo[] a(int paramInt)
  {
    return new TMAssistantDownloadLogInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.aidl.g
 * JD-Core Version:    0.7.0.1
 */