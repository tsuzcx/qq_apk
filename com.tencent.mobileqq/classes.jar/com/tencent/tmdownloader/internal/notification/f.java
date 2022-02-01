package com.tencent.tmdownloader.internal.notification;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
  implements Parcelable.Creator<NotifyParam>
{
  public NotifyParam a(Parcel paramParcel)
  {
    return new NotifyParam(paramParcel);
  }
  
  public NotifyParam[] a(int paramInt)
  {
    return new NotifyParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.notification.f
 * JD-Core Version:    0.7.0.1
 */