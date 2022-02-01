package com.tencent.turingfd.sdk.ams.ga;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class Pegasus
  implements Parcelable.Creator<Perseus>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    return new Perseus(paramParcel);
  }
  
  public Object[] newArray(int paramInt)
  {
    return new Perseus[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Pegasus
 * JD-Core Version:    0.7.0.1
 */