package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

final class AIOFileVideoData$1
  implements Parcelable.Creator<RichMediaBaseData>
{
  public RichMediaBaseData a(Parcel paramParcel)
  {
    AIOFileVideoData localAIOFileVideoData = new AIOFileVideoData();
    localAIOFileVideoData.readFromParcel(paramParcel);
    return localAIOFileVideoData;
  }
  
  public RichMediaBaseData[] a(int paramInt)
  {
    return new RichMediaBaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData.1
 * JD-Core Version:    0.7.0.1
 */