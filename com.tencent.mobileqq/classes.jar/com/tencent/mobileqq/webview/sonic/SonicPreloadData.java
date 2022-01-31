package com.tencent.mobileqq.webview.sonic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SonicPreloadData
  implements Parcelable
{
  public static final Parcelable.Creator<SonicPreloadData> CREATOR = new SonicPreloadData.1();
  public boolean accountRelated;
  public int id;
  public int noCacheFilePreloadType;
  public long templateChangeTime;
  public String url;
  
  public SonicPreloadData(int paramInt1, String paramString, boolean paramBoolean, long paramLong, int paramInt2)
  {
    this.id = paramInt1;
    this.url = paramString;
    this.accountRelated = paramBoolean;
    this.templateChangeTime = paramLong;
    this.noCacheFilePreloadType = paramInt2;
  }
  
  public SonicPreloadData(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.url = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.accountRelated = bool;
      this.templateChangeTime = paramParcel.readLong();
      this.noCacheFilePreloadType = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "SonicPreloadData{id='" + this.id + '\'' + "url='" + this.url + '\'' + ", accountRelated='" + this.accountRelated + '\'' + ", templateChangeTime='" + this.templateChangeTime + '\'' + ", noCacheFilePreloadType='" + this.noCacheFilePreloadType + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.url);
    if (this.accountRelated) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.templateChangeTime);
      paramParcel.writeInt(this.noCacheFilePreloadType);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicPreloadData
 * JD-Core Version:    0.7.0.1
 */