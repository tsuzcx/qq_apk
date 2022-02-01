package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PpsStatus$1
  implements Parcelable.Creator<PpsStatus>
{
  public PpsStatus createFromParcel(Parcel paramParcel)
  {
    return new PpsStatus(paramParcel);
  }
  
  public PpsStatus[] newArray(int paramInt)
  {
    return new PpsStatus[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PpsStatus.1
 * JD-Core Version:    0.7.0.1
 */