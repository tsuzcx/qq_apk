package com.tencent.mobileqq.pushnotice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ThirdPushNotifyManager$PushNotificationData
  implements Parcelable
{
  public static final Parcelable.Creator<PushNotificationData> CREATOR = new ThirdPushNotifyManager.PushNotificationData.1();
  private int a;
  private int b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public ThirdPushNotifyManager$PushNotificationData(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  protected ThirdPushNotifyManager$PushNotificationData(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.ThirdPushNotifyManager.PushNotificationData
 * JD-Core Version:    0.7.0.1
 */