package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TMAssistantDownloadLogInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TMAssistantDownloadLogInfo> CREATOR = new g();
  public String logLevel;
  public String logMsg;
  public String logTag;
  public String logThrowableMsg;
  public long logTime;
  
  public TMAssistantDownloadLogInfo() {}
  
  public TMAssistantDownloadLogInfo(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    this.logLevel = paramString1;
    this.logTime = paramLong;
    this.logTag = paramString2;
    this.logMsg = paramString3;
    this.logThrowableMsg = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    String str = this.logLevel;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    paramParcel.writeLong(this.logTime);
    str = this.logTag;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    str = this.logMsg;
    if (str != null) {
      paramParcel.writeString(str);
    } else {
      paramParcel.writeString("");
    }
    str = this.logThrowableMsg;
    if (str != null)
    {
      paramParcel.writeString(str);
      return;
    }
    paramParcel.writeString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo
 * JD-Core Version:    0.7.0.1
 */