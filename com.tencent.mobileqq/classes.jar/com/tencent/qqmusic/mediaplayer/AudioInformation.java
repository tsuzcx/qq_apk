package com.tencent.qqmusic.mediaplayer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AudioInformation
  implements Parcelable
{
  public static final int CBR = 1;
  public static final int CORRECT = 1;
  public static final Parcelable.Creator<AudioInformation> CREATOR = new AudioInformation.1();
  public static final int INCORRECT = 2;
  public static final int VBR_VBRI = 3;
  public static final int VBR_XING = 2;
  private int bitDept = 0;
  private int bitrate;
  private int channels;
  private long duration = 0L;
  private int durationIsCorrect = 2;
  private int isCbr = 0;
  private int mAudioTypeValue;
  private long mPlaySample = 0L;
  private long sampleRate;
  
  public AudioInformation() {}
  
  public AudioInformation(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean durationIsCorrect()
  {
    return this.durationIsCorrect == 1;
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return AudioFormat.getAudioType(this.mAudioTypeValue);
  }
  
  public int getBitDepth()
  {
    return this.bitDept;
  }
  
  public int getBitrate()
  {
    return this.bitrate;
  }
  
  public int getChannels()
  {
    return this.channels;
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public long getPlaySample()
  {
    if (this.mPlaySample == 0L) {
      this.mPlaySample = this.sampleRate;
    }
    return this.mPlaySample;
  }
  
  public long getSampleRate()
  {
    return this.sampleRate;
  }
  
  public int getVbrType()
  {
    return this.isCbr;
  }
  
  public boolean isCbr()
  {
    return this.isCbr == 1;
  }
  
  public boolean isVbr()
  {
    int i = this.isCbr;
    return (i == 2) || (i == 3);
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.sampleRate = paramParcel.readLong();
    this.channels = paramParcel.readInt();
    this.duration = paramParcel.readLong();
    this.bitrate = paramParcel.readInt();
    this.bitDept = paramParcel.readInt();
    this.mAudioTypeValue = paramParcel.readInt();
    this.mPlaySample = paramParcel.readLong();
    this.isCbr = paramParcel.readInt();
    this.durationIsCorrect = paramParcel.readInt();
  }
  
  public void setAudioType(AudioFormat.AudioType paramAudioType)
  {
    this.mAudioTypeValue = paramAudioType.getValue();
  }
  
  public void setBitDept(int paramInt)
  {
    this.bitDept = paramInt;
    if (paramInt >= 3) {
      this.bitDept = 3;
    }
  }
  
  public void setBitrate(int paramInt)
  {
    this.bitrate = paramInt;
  }
  
  public void setCbr(int paramInt)
  {
    this.isCbr = paramInt;
  }
  
  public void setChannels(int paramInt)
  {
    this.channels = paramInt;
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setPlaySample(long paramLong)
  {
    this.mPlaySample = paramLong;
  }
  
  public void setSampleRate(long paramLong)
  {
    this.sampleRate = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ sampleRate = ");
    localStringBuilder.append(this.sampleRate);
    localStringBuilder.append(",channels = ");
    localStringBuilder.append(this.channels);
    localStringBuilder.append(",bitrate = ");
    localStringBuilder.append(this.bitrate);
    localStringBuilder.append(",bitDept = ");
    localStringBuilder.append(this.bitDept);
    localStringBuilder.append(",isCbr = ");
    localStringBuilder.append(this.isCbr);
    localStringBuilder.append(",durationIsCorrect = ");
    localStringBuilder.append(this.durationIsCorrect);
    localStringBuilder.append(",duration = ");
    localStringBuilder.append(this.duration);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.sampleRate);
    paramParcel.writeInt(this.channels);
    paramParcel.writeLong(this.duration);
    paramParcel.writeInt(this.bitrate);
    paramParcel.writeInt(this.bitDept);
    paramParcel.writeInt(this.mAudioTypeValue);
    paramParcel.writeLong(this.mPlaySample);
    paramParcel.writeInt(this.isCbr);
    paramParcel.writeInt(this.durationIsCorrect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioInformation
 * JD-Core Version:    0.7.0.1
 */