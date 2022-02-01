package com.tencent.turingfd.sdk.ams.ga;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Perseus
  implements Parcelable
{
  public static final Parcelable.Creator<Perseus> CREATOR = new Pegasus();
  public int xe;
  public byte[] ye;
  public int ze;
  
  public Perseus() {}
  
  public Perseus(Parcel paramParcel)
  {
    this.xe = paramParcel.readInt();
    this.ye = paramParcel.createByteArray();
    this.ze = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.xe);
    paramParcel.writeByteArray(this.ye);
    paramParcel.writeInt(this.ze);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Perseus
 * JD-Core Version:    0.7.0.1
 */