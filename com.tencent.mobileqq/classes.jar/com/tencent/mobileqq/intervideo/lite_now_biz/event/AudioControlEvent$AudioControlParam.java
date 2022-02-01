package com.tencent.mobileqq.intervideo.lite_now_biz.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AudioControlEvent$AudioControlParam
  implements Parcelable
{
  public static final Parcelable.Creator<AudioControlParam> CREATOR = new AudioControlEvent.AudioControlParam.1();
  public int a;
  public long a;
  public int b;
  public long b;
  
  public AudioControlEvent$AudioControlParam() {}
  
  protected AudioControlEvent$AudioControlParam(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "AudioControlParam{uid=" + this.jdField_a_of_type_Long + ", tinyid=" + this.jdField_b_of_type_Long + ", status=" + this.jdField_a_of_type_Int + ", type=" + this.jdField_b_of_type_Int + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioControlEvent.AudioControlParam
 * JD-Core Version:    0.7.0.1
 */