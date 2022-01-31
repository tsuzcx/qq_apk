package com.tencent.upload.image;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ImageProcessData$1
  implements Parcelable.Creator<ImageProcessData>
{
  public ImageProcessData createFromParcel(Parcel paramParcel)
  {
    return new ImageProcessData(paramParcel, null);
  }
  
  public ImageProcessData[] newArray(int paramInt)
  {
    return new ImageProcessData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessData.1
 * JD-Core Version:    0.7.0.1
 */