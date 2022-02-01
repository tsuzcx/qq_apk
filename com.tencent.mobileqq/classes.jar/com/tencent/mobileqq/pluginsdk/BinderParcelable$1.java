package com.tencent.mobileqq.pluginsdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BinderParcelable$1
  implements Parcelable.Creator<BinderParcelable>
{
  public BinderParcelable createFromParcel(Parcel paramParcel)
  {
    return new BinderParcelable(paramParcel);
  }
  
  public BinderParcelable[] newArray(int paramInt)
  {
    return new BinderParcelable[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.BinderParcelable.1
 * JD-Core Version:    0.7.0.1
 */