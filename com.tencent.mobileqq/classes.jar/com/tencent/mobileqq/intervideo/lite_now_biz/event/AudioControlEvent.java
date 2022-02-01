package com.tencent.mobileqq.intervideo.lite_now_biz.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.ilive.base.event.ModuleEventInterface;
import java.util.ArrayList;

@SuppressLint({"ParcelCreator"})
public class AudioControlEvent
  implements ModuleEventInterface
{
  public static final Parcelable.Creator<AudioControlEvent> CREATOR = new AudioControlEvent.1();
  public ArrayList<AudioControlEvent.AudioControlParam> a;
  public ArrayList<AudioControlEvent.AudioControlParam> b;
  public ArrayList<AudioControlEvent.AudioControlParam> c;
  
  public AudioControlEvent() {}
  
  protected AudioControlEvent(Parcel paramParcel)
  {
    this.a = paramParcel.createTypedArrayList(AudioControlEvent.AudioControlParam.CREATOR);
    this.b = paramParcel.createTypedArrayList(AudioControlEvent.AudioControlParam.CREATOR);
    this.c = paramParcel.createTypedArrayList(AudioControlEvent.AudioControlParam.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.a);
    paramParcel.writeTypedList(this.b);
    paramParcel.writeTypedList(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioControlEvent
 * JD-Core Version:    0.7.0.1
 */