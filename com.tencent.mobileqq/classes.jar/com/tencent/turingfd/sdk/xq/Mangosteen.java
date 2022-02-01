package com.tencent.turingfd.sdk.xq;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Mangosteen
  implements Parcelable
{
  public static final Parcelable.Creator<Mangosteen> a = new Mangosteen.do();
  public int b;
  public byte[] c;
  public int d;
  
  public Mangosteen(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.createByteArray();
    this.d = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeByteArray(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Mangosteen
 * JD-Core Version:    0.7.0.1
 */