package com.tencent.richmediabrowser.model.pic;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

final class PictureData$1
  implements Parcelable.Creator<RichMediaBaseData>
{
  public RichMediaBaseData a(Parcel paramParcel)
  {
    PictureData localPictureData = new PictureData();
    localPictureData.readFromParcel(paramParcel);
    return localPictureData;
  }
  
  public RichMediaBaseData[] a(int paramInt)
  {
    return new RichMediaBaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.pic.PictureData.1
 * JD-Core Version:    0.7.0.1
 */