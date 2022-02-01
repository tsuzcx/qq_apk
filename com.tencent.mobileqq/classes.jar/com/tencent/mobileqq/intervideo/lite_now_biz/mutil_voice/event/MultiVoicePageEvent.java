package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class MultiVoicePageEvent
  implements ModuleEventInterface
{
  public final int a;
  
  public MultiVoicePageEvent(@MultiVoicePageEvent.PageEvent int paramInt)
  {
    this.a = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.event.MultiVoicePageEvent
 * JD-Core Version:    0.7.0.1
 */