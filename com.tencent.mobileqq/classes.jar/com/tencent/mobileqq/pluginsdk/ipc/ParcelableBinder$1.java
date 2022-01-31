package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ParcelableBinder$1
  implements Parcelable.Creator<ParcelableBinder>
{
  public ParcelableBinder createFromParcel(Parcel paramParcel)
  {
    return new ParcelableBinder(paramParcel, null);
  }
  
  public ParcelableBinder[] newArray(int paramInt)
  {
    return new ParcelableBinder[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.ParcelableBinder.1
 * JD-Core Version:    0.7.0.1
 */