package com.tencent.tmassistant.appinfo.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppDetail
  implements Parcelable
{
  public static final Parcelable.Creator<AppDetail> CREATOR = new a();
  public String apkDownUrl;
  public long apkId;
  public String apkMd5;
  public long appId;
  public String appName;
  public String channelId;
  public long fileSize;
  public String iconUrl;
  public String packageName;
  public String signatureMd5;
  public int versionCode;
  
  public AppDetail() {}
  
  protected AppDetail(Parcel paramParcel)
  {
    this.appId = paramParcel.readLong();
    this.apkId = paramParcel.readLong();
    this.appName = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.packageName = paramParcel.readString();
    this.versionCode = paramParcel.readInt();
    this.signatureMd5 = paramParcel.readString();
    this.apkMd5 = paramParcel.readString();
    this.fileSize = paramParcel.readLong();
    this.apkDownUrl = paramParcel.readString();
    this.channelId = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append("\napkId=");
    localStringBuilder.append(this.apkId);
    localStringBuilder.append("\nappName=");
    localStringBuilder.append(this.appName);
    localStringBuilder.append("\niconUrl=");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append("\npackageName=");
    localStringBuilder.append(this.packageName);
    localStringBuilder.append("\nversionCode=");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append("\nsignatureMd5=");
    localStringBuilder.append(this.signatureMd5);
    localStringBuilder.append("\napkMd5=");
    localStringBuilder.append(this.apkMd5);
    localStringBuilder.append("\nfileSize=");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append("\napkDownUrl=");
    localStringBuilder.append(this.apkDownUrl);
    localStringBuilder.append("\nchannelId=");
    localStringBuilder.append(this.channelId);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.appId);
    paramParcel.writeLong(this.apkId);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.packageName);
    paramParcel.writeInt(this.versionCode);
    paramParcel.writeString(this.signatureMd5);
    paramParcel.writeString(this.apkMd5);
    paramParcel.writeLong(this.fileSize);
    paramParcel.writeString(this.apkDownUrl);
    paramParcel.writeString(this.channelId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.data.AppDetail
 * JD-Core Version:    0.7.0.1
 */