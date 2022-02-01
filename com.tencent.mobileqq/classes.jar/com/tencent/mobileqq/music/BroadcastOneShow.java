package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class BroadcastOneShow
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastOneShow> CREATOR = new BroadcastOneShow.1();
  public String a = "";
  public String b = "";
  public long c = 0L;
  public long d = 0L;
  public int e = 0;
  public String f = "";
  
  BroadcastOneShow() {}
  
  public BroadcastOneShow(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
  }
  
  public static BroadcastOneShow a(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow paramBroadcastOneShow)
  {
    BroadcastOneShow localBroadcastOneShow = new BroadcastOneShow();
    localBroadcastOneShow.a = paramBroadcastOneShow.bcShowId;
    localBroadcastOneShow.b = paramBroadcastOneShow.bcShowName;
    localBroadcastOneShow.c = paramBroadcastOneShow.startTime;
    localBroadcastOneShow.d = paramBroadcastOneShow.endTime;
    localBroadcastOneShow.e = paramBroadcastOneShow.singerId;
    localBroadcastOneShow.f = paramBroadcastOneShow.singerName;
    return localBroadcastOneShow;
  }
  
  public static BroadcastOneShow a(String paramString)
  {
    BroadcastOneShow localBroadcastOneShow = new BroadcastOneShow();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastOneShow.a = paramString.optString("bcShowId");
      localBroadcastOneShow.b = paramString.optString("bcShowName");
      localBroadcastOneShow.c = paramString.optLong("startTime");
      localBroadcastOneShow.d = paramString.optLong("endTime");
      localBroadcastOneShow.e = paramString.optInt("singerId");
      localBroadcastOneShow.f = paramString.optString("singerName");
      return localBroadcastOneShow;
    }
    catch (Exception paramString) {}
    return localBroadcastOneShow;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.BroadcastOneShow
 * JD-Core Version:    0.7.0.1
 */