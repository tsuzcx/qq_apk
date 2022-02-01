package com.tencent.mobileqq.intervideo.lite_now_biz.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class ChangeMicrophoneEvent
  implements ModuleEventInterface
{
  public final int a;
  
  public ChangeMicrophoneEvent(@ChangeMicrophoneEvent.Source int paramInt)
  {
    this.a = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.event.ChangeMicrophoneEvent
 * JD-Core Version:    0.7.0.1
 */