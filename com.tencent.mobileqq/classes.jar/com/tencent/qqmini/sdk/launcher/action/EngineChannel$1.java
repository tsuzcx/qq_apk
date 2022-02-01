package com.tencent.qqmini.sdk.launcher.action;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;

final class EngineChannel$1
  implements Parcelable.Creator<EngineChannel>
{
  public EngineChannel createFromParcel(Parcel paramParcel)
  {
    EngineChannel localEngineChannel = new EngineChannel((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel), null);
    localEngineChannel.setName(paramParcel.readString());
    return localEngineChannel;
  }
  
  public EngineChannel[] newArray(int paramInt)
  {
    return new EngineChannel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.EngineChannel.1
 * JD-Core Version:    0.7.0.1
 */