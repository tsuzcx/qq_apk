package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FailedException$1
  implements Parcelable.Creator<FailedException>
{
  public FailedException createFromParcel(Parcel paramParcel)
  {
    return new FailedException(paramParcel);
  }
  
  public FailedException[] newArray(int paramInt)
  {
    return new FailedException[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.FailedException.1
 * JD-Core Version:    0.7.0.1
 */