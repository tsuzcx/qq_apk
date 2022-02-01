package com.tencent.tmdownloader.internal.notification;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NotifyParam
  implements Parcelable
{
  public static final Parcelable.Creator<NotifyParam> CREATOR = new f();
  public String content = "";
  public String nKey;
  public int notificationTypeId;
  public String title = "";
  public String url = "";
  
  public NotifyParam() {}
  
  public NotifyParam(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.title = paramParcel.readString();
    this.content = paramParcel.readString();
    this.nKey = paramParcel.readString();
    this.notificationTypeId = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.nKey);
    paramParcel.writeInt(this.notificationTypeId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.notification.NotifyParam
 * JD-Core Version:    0.7.0.1
 */