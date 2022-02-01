package com.tencent.richmediabrowser.model.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

final class VideoData$1
  implements Parcelable.Creator<RichMediaBaseData>
{
  public RichMediaBaseData a(Parcel paramParcel)
  {
    VideoData localVideoData = new VideoData();
    localVideoData.readFromParcel(paramParcel);
    return localVideoData;
  }
  
  public RichMediaBaseData[] a(int paramInt)
  {
    return new RichMediaBaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.video.VideoData.1
 * JD-Core Version:    0.7.0.1
 */