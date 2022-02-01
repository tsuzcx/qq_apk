package com.tencent.robolectric;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ProxyParcel$1
  implements Parcelable.Creator<String>
{
  public String a(Parcel paramParcel)
  {
    return paramParcel.readString();
  }
  
  public String[] a(int paramInt)
  {
    return new String[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.robolectric.ProxyParcel.1
 * JD-Core Version:    0.7.0.1
 */