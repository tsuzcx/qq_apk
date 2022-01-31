package com.tencent.qphone.base.remote;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FromServiceMsg$1
  implements Parcelable.Creator
{
  public FromServiceMsg createFromParcel(Parcel paramParcel)
  {
    return new FromServiceMsg(paramParcel);
  }
  
  public FromServiceMsg[] newArray(int paramInt)
  {
    return new FromServiceMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.FromServiceMsg.1
 * JD-Core Version:    0.7.0.1
 */