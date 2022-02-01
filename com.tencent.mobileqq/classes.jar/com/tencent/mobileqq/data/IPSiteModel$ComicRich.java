package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import arwo;

public class IPSiteModel$ComicRich
  implements Parcelable
{
  public static final Parcelable.Creator<ComicRich> CREATOR = new arwo();
  public String extCover;
  public String extName;
  public String extTitle;
  public String extUrl;
  
  public IPSiteModel$ComicRich() {}
  
  public IPSiteModel$ComicRich(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.extCover = paramString1;
    this.extName = paramString2;
    this.extTitle = paramString3;
    this.extUrl = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ComicRich{extCover='" + this.extCover + '\'' + ", extName='" + this.extName + '\'' + ", extTitle='" + this.extTitle + '\'' + ", extUrl='" + this.extUrl + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.extCover);
    paramParcel.writeString(this.extName);
    paramParcel.writeString(this.extTitle);
    paramParcel.writeString(this.extUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.ComicRich
 * JD-Core Version:    0.7.0.1
 */