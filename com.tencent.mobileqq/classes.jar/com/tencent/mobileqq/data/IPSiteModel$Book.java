package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import arwm;

public class IPSiteModel$Book
  implements Parcelable
{
  public static final Parcelable.Creator<Book> CREATOR = new arwm();
  public String authorName;
  public String cover;
  public String desc;
  public String id;
  public String jumpUrl;
  public String name;
  public String recommDesc;
  
  public IPSiteModel$Book() {}
  
  public IPSiteModel$Book(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.cover = paramString1;
    this.desc = paramString2;
    this.id = paramString3;
    this.jumpUrl = paramString4;
    this.name = paramString5;
    this.recommDesc = paramString6;
    this.authorName = paramString7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "Book{cover='" + this.cover + '\'' + ", desc='" + this.desc + '\'' + ", id='" + this.id + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + ", name='" + this.name + '\'' + ", recommDesc='" + this.recommDesc + '\'' + ", authorName='" + this.authorName + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cover);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.recommDesc);
    paramParcel.writeString(this.authorName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Book
 * JD-Core Version:    0.7.0.1
 */