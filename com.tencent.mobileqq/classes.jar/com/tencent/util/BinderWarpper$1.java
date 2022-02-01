package com.tencent.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BinderWarpper$1
  implements Parcelable.Creator<BinderWarpper>
{
  public BinderWarpper a(Parcel paramParcel)
  {
    return new BinderWarpper(paramParcel.readStrongBinder());
  }
  
  public BinderWarpper[] a(int paramInt)
  {
    return new BinderWarpper[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.BinderWarpper.1
 * JD-Core Version:    0.7.0.1
 */