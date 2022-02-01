package com.tencent.tmassistantsdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TMAssistantCallYYBTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TMAssistantCallYYBTaskInfo> CREATOR = new a();
  public String mContentType;
  public long mReceiveDataLen;
  public String mSavePath;
  public int mState;
  public long mTotalDataLen;
  public String mUrl;
  
  public TMAssistantCallYYBTaskInfo(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo
 * JD-Core Version:    0.7.0.1
 */