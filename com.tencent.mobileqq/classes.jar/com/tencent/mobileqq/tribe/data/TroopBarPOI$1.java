package com.tencent.mobileqq.tribe.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TroopBarPOI$1
  implements Parcelable.Creator<TroopBarPOI>
{
  public TroopBarPOI a(Parcel paramParcel)
  {
    return new TroopBarPOI(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString());
  }
  
  public TroopBarPOI[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.data.TroopBarPOI.1
 * JD-Core Version:    0.7.0.1
 */