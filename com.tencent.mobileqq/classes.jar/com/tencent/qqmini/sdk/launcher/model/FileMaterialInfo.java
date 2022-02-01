package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FileMaterialInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FileMaterialInfo> CREATOR = new FileMaterialInfo.1();
  private final String mimeType;
  private final String name;
  private final String path;
  private final long size;
  private String tmpPath;
  
  private FileMaterialInfo(Parcel paramParcel)
  {
    this.mimeType = paramParcel.readString();
    this.name = paramParcel.readString();
    this.path = paramParcel.readString();
    this.size = paramParcel.readLong();
    this.tmpPath = paramParcel.readString();
  }
  
  public FileMaterialInfo(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.mimeType = paramString1;
    this.name = paramString2;
    this.path = paramString3;
    this.size = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMimeType()
  {
    return this.mimeType;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public String getTmpPath()
  {
    return this.tmpPath;
  }
  
  public void setTmpPath(String paramString)
  {
    this.tmpPath = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.path);
    paramParcel.writeLong(this.size);
    paramParcel.writeString(this.tmpPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo
 * JD-Core Version:    0.7.0.1
 */