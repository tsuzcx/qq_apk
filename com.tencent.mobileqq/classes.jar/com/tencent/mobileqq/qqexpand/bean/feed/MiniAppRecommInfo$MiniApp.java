package com.tencent.mobileqq.qqexpand.bean.feed;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class MiniAppRecommInfo$MiniApp
  implements Parcelable
{
  public static final Parcelable.Creator<MiniApp> CREATOR = new MiniAppRecommInfo.MiniApp.1();
  public String a;
  public String b;
  public String c;
  public byte[] d;
  public INTERFACE.StApiAppInfo e;
  public int f;
  
  public MiniAppRecommInfo$MiniApp() {}
  
  protected MiniAppRecommInfo$MiniApp(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0) {
      try
      {
        this.d = new byte[i];
        paramParcel.readByteArray(this.d);
        paramParcel = new INTERFACE.StApiAppInfo();
        paramParcel.mergeFrom(this.d);
        this.e = paramParcel;
        return;
      }
      catch (Throwable paramParcel)
      {
        QLog.e("MiniAppRecommInfo", 1, "", paramParcel);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    byte[] arrayOfByte = this.d;
    if (arrayOfByte != null) {
      paramInt = arrayOfByte.length;
    } else {
      paramInt = -1;
    }
    paramParcel.writeInt(paramInt);
    paramParcel.writeByteArray(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo.MiniApp
 * JD-Core Version:    0.7.0.1
 */