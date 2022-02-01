package com.tencent.mobileqq.tribe.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TroopBarMyBar$1
  implements Parcelable.Creator<TroopBarMyBar>
{
  public TroopBarMyBar a(Parcel paramParcel)
  {
    return new TroopBarMyBar(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString());
  }
  
  public TroopBarMyBar[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.data.TroopBarMyBar.1
 * JD-Core Version:    0.7.0.1
 */