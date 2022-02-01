package com.tencent.mobileqq.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class HeadRequest$1
  implements Parcelable.Creator<HeadRequest>
{
  public HeadRequest a(Parcel paramParcel)
  {
    HeadRequest localHeadRequest = new HeadRequest();
    localHeadRequest.a(paramParcel);
    return localHeadRequest;
  }
  
  public HeadRequest[] a(int paramInt)
  {
    return new HeadRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.HeadRequest.1
 * JD-Core Version:    0.7.0.1
 */