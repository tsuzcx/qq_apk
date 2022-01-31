package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TMAssistantDownloadTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TMAssistantDownloadTaskInfo> CREATOR = new h();
  public boolean isAutoInstallBySDK = false;
  public long mAppId = 0L;
  public String mAppName = "";
  public String mChannelid = "";
  public String mContentType;
  public long mEndTime = 0L;
  public String mIconUrl = "";
  public long mReceiveDataLen;
  public String mSavePath;
  public long mStartTime = 0L;
  public int mState;
  public String mTaskPackageName = "";
  public String mTaskVersionCode = "";
  public long mTotalDataLen;
  public String mUrl;
  public String mVia = "";
  public int showNotification = 0;
  
  public TMAssistantDownloadTaskInfo(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    this.mUrl = paramString1;
    this.mSavePath = paramString2;
    this.mState = paramInt;
    this.mReceiveDataLen = paramLong1;
    this.mTotalDataLen = paramLong2;
    this.mContentType = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mUrl != null)
    {
      paramParcel.writeString(this.mUrl);
      if (this.mSavePath == null) {
        break label209;
      }
      paramParcel.writeString(this.mSavePath);
      label30:
      paramParcel.writeInt(this.mState);
      paramParcel.writeLong(this.mReceiveDataLen);
      paramParcel.writeLong(this.mTotalDataLen);
      paramParcel.writeString(this.mContentType);
      paramParcel.writeLong(this.mAppId);
      if (this.mTaskPackageName == null) {
        break label218;
      }
      paramParcel.writeString(this.mTaskPackageName);
      label85:
      if (this.mTaskVersionCode == null) {
        break label227;
      }
      paramParcel.writeString(this.mTaskVersionCode);
      label100:
      if (this.mIconUrl == null) {
        break label236;
      }
      paramParcel.writeString(this.mIconUrl);
      label115:
      if (this.mAppName == null) {
        break label245;
      }
      paramParcel.writeString(this.mAppName);
      label130:
      paramParcel.writeLong(this.mStartTime);
      paramParcel.writeLong(this.mEndTime);
      if (this.mVia == null) {
        break label254;
      }
      paramParcel.writeString(this.mVia);
      label161:
      if (this.mChannelid == null) {
        break label263;
      }
      paramParcel.writeString(this.mChannelid);
      label176:
      paramParcel.writeInt(this.showNotification);
      if (!this.isAutoInstallBySDK) {
        break label272;
      }
    }
    label263:
    label272:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramParcel.writeString("");
      break;
      label209:
      paramParcel.writeString("");
      break label30;
      label218:
      paramParcel.writeString("");
      break label85;
      label227:
      paramParcel.writeString("");
      break label100;
      label236:
      paramParcel.writeString("");
      break label115;
      label245:
      paramParcel.writeString("");
      break label130;
      label254:
      paramParcel.writeString("");
      break label161;
      paramParcel.writeString("");
      break label176;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */