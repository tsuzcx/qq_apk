package com.tencent.mobileqq.guild.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ITRTCAudioRoom$TRTCVolumeInfo$1
  implements Parcelable.Creator<ITRTCAudioRoom.TRTCVolumeInfo>
{
  public ITRTCAudioRoom.TRTCVolumeInfo a(Parcel paramParcel)
  {
    ITRTCAudioRoom.TRTCVolumeInfo localTRTCVolumeInfo = new ITRTCAudioRoom.TRTCVolumeInfo();
    localTRTCVolumeInfo.a = paramParcel.readString();
    localTRTCVolumeInfo.b = paramParcel.readInt();
    return localTRTCVolumeInfo;
  }
  
  public ITRTCAudioRoom.TRTCVolumeInfo[] a(int paramInt)
  {
    return new ITRTCAudioRoom.TRTCVolumeInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.ITRTCAudioRoom.TRTCVolumeInfo.1
 * JD-Core Version:    0.7.0.1
 */