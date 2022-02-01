package com.tencent.mobileqq.troop.activity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MediaPreviewInfo$1
  implements Parcelable.Creator<MediaPreviewInfo>
{
  public MediaPreviewInfo a(Parcel paramParcel)
  {
    MediaPreviewInfo localMediaPreviewInfo = new MediaPreviewInfo();
    localMediaPreviewInfo.a = paramParcel.readInt();
    localMediaPreviewInfo.b = paramParcel.readString();
    localMediaPreviewInfo.c = paramParcel.readString();
    localMediaPreviewInfo.d = paramParcel.readString();
    return localMediaPreviewInfo;
  }
  
  public MediaPreviewInfo[] a(int paramInt)
  {
    return new MediaPreviewInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewInfo.1
 * JD-Core Version:    0.7.0.1
 */