package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

final class AIOVideoData$1
  implements Parcelable.Creator<RichMediaBaseData>
{
  public RichMediaBaseData a(Parcel paramParcel)
  {
    AIOVideoData localAIOVideoData = new AIOVideoData();
    localAIOVideoData.readFromParcel(paramParcel);
    return localAIOVideoData;
  }
  
  public RichMediaBaseData[] a(int paramInt)
  {
    return new RichMediaBaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOVideoData.1
 * JD-Core Version:    0.7.0.1
 */