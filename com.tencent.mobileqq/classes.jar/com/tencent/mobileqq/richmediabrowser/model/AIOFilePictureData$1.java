package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

final class AIOFilePictureData$1
  implements Parcelable.Creator<RichMediaBaseData>
{
  public RichMediaBaseData a(Parcel paramParcel)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.readFromParcel(paramParcel);
    return localAIOFilePictureData;
  }
  
  public RichMediaBaseData[] a(int paramInt)
  {
    return new RichMediaBaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData.1
 * JD-Core Version:    0.7.0.1
 */