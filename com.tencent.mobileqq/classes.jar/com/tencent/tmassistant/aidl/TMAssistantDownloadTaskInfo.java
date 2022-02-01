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
    String str = this.mUrl;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    str = this.mSavePath;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    paramParcel.writeInt(this.mState);
    paramParcel.writeLong(this.mReceiveDataLen);
    paramParcel.writeLong(this.mTotalDataLen);
    paramParcel.writeString(this.mContentType);
    paramParcel.writeLong(this.mAppId);
    str = this.mTaskPackageName;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    str = this.mTaskVersionCode;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    str = this.mIconUrl;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    str = this.mAppName;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    paramParcel.writeLong(this.mStartTime);
    paramParcel.writeLong(this.mEndTime);
    str = this.mVia;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    str = this.mChannelid;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    paramParcel.writeInt(this.showNotification);
    paramParcel.writeByte((byte)this.isAutoInstallBySDK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */