package com.tencent.mobileqq.intervideo.lite_now_biz.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class UiShowTipsEvent
  implements ModuleEventInterface
{
  public static final Parcelable.Creator<UiShowTipsEvent> CREATOR = new UiShowTipsEvent.1();
  
  protected UiShowTipsEvent(Parcel paramParcel) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.event.UiShowTipsEvent
 * JD-Core Version:    0.7.0.1
 */