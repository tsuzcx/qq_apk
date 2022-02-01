package com.tencent.mobileqq.qqlive.data.trtc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TRTCVideoQualityParams
  implements Parcelable
{
  public static final Parcelable.Creator<TRTCVideoQualityParams> CREATOR = new TRTCVideoQualityParams.1();
  private boolean mEnableAdjustRes;
  private int mMinVideoBitRate;
  private int mVideoBitRate;
  private int mVideoFps;
  private int mVideoResolution;
  private int mVideoResolutionMode;
  
  protected TRTCVideoQualityParams()
  {
    this.mVideoResolutionMode = 1;
    this.mEnableAdjustRes = false;
  }
  
  protected TRTCVideoQualityParams(Parcel paramParcel)
  {
    boolean bool = true;
    this.mVideoResolutionMode = 1;
    this.mEnableAdjustRes = false;
    this.mVideoResolution = paramParcel.readInt();
    this.mVideoFps = paramParcel.readInt();
    this.mVideoBitRate = paramParcel.readInt();
    this.mMinVideoBitRate = paramParcel.readInt();
    this.mVideoResolutionMode = paramParcel.readInt();
    if (paramParcel.readByte() == 0) {
      bool = false;
    }
    this.mEnableAdjustRes = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getMinVideoBitRate()
  {
    return this.mMinVideoBitRate;
  }
  
  public int getVideoBitRate()
  {
    return this.mVideoBitRate;
  }
  
  public int getVideoFps()
  {
    return this.mVideoFps;
  }
  
  public int getVideoResolution()
  {
    return this.mVideoResolution;
  }
  
  public int getVideoResolutionMode()
  {
    return this.mVideoResolutionMode;
  }
  
  public boolean isEnableAdjustRes()
  {
    return this.mEnableAdjustRes;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TRTCVideoQualityParams{mVideoResolution=");
    localStringBuilder.append(this.mVideoResolution);
    localStringBuilder.append(", mVideoFps=");
    localStringBuilder.append(this.mVideoFps);
    localStringBuilder.append(", mVideoBitRate=");
    localStringBuilder.append(this.mVideoBitRate);
    localStringBuilder.append(", mMinVideoBitRate=");
    localStringBuilder.append(this.mMinVideoBitRate);
    localStringBuilder.append(", mVideoResolutionMode=");
    localStringBuilder.append(this.mVideoResolutionMode);
    localStringBuilder.append(", mEnableAdjustRes=");
    localStringBuilder.append(this.mEnableAdjustRes);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mVideoResolution);
    paramParcel.writeInt(this.mVideoFps);
    paramParcel.writeInt(this.mVideoBitRate);
    paramParcel.writeInt(this.mMinVideoBitRate);
    paramParcel.writeInt(this.mVideoResolutionMode);
    paramParcel.writeByte((byte)this.mEnableAdjustRes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams
 * JD-Core Version:    0.7.0.1
 */