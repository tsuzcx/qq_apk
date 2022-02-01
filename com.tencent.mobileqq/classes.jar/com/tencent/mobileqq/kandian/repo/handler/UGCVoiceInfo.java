package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class UGCVoiceInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<UGCVoiceInfo> CREATOR = new UGCVoiceInfo.1();
  public int duration;
  public int fileSize;
  public boolean isPlaying = false;
  public String voiceUrl;
  
  public UGCVoiceInfo() {}
  
  protected UGCVoiceInfo(Parcel paramParcel)
  {
    this.voiceUrl = paramParcel.readString();
    this.duration = paramParcel.readInt();
    this.fileSize = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.voiceUrl);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.fileSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.UGCVoiceInfo
 * JD-Core Version:    0.7.0.1
 */