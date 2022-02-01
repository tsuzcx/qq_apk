package com.tencent.mobileqq.intervideo.lite_now_biz.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AudioControlEvent$AudioControlParam
  implements Parcelable
{
  public static final Parcelable.Creator<AudioControlParam> CREATOR = new AudioControlEvent.AudioControlParam.1();
  public long a;
  public long b;
  public int c;
  public int d;
  
  public AudioControlEvent$AudioControlParam() {}
  
  protected AudioControlEvent$AudioControlParam(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioControlParam{uid=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tinyid=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioControlEvent.AudioControlParam
 * JD-Core Version:    0.7.0.1
 */