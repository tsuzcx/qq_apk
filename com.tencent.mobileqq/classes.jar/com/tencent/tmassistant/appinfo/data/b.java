package com.tencent.tmassistant.appinfo.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<AppDetailReqParam>
{
  public AppDetailReqParam a(Parcel paramParcel)
  {
    return new AppDetailReqParam(paramParcel);
  }
  
  public AppDetailReqParam[] a(int paramInt)
  {
    return new AppDetailReqParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.data.b
 * JD-Core Version:    0.7.0.1
 */