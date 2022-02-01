package com.tencent.qqmusic.mediaplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AudioInformation$1
  implements Parcelable.Creator<AudioInformation>
{
  public AudioInformation createFromParcel(Parcel paramParcel)
  {
    return new AudioInformation(paramParcel);
  }
  
  public AudioInformation[] newArray(int paramInt)
  {
    return new AudioInformation[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioInformation.1
 * JD-Core Version:    0.7.0.1
 */