package com.tencent.mobileqq.redtouch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

final class RedAppInfo$1
  implements Parcelable.Creator<RedAppInfo>
{
  public RedAppInfo a(Parcel paramParcel)
  {
    RedAppInfo localRedAppInfo = new RedAppInfo();
    RedAppInfo.a(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.b(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.c(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.a(localRedAppInfo, paramParcel.readString());
    RedAppInfo.b(localRedAppInfo, paramParcel.readString());
    RedAppInfo.d(localRedAppInfo, paramParcel.readInt());
    localRedAppInfo.a = new ArrayList();
    paramParcel.readList(localRedAppInfo.a, null);
    RedAppInfo.e(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.f(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.c(localRedAppInfo, paramParcel.readString());
    RedAppInfo.g(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.h(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.i(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.j(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.a(localRedAppInfo, (RedDisplayInfo)paramParcel.readParcelable(getClass().getClassLoader()));
    RedAppInfo.k(localRedAppInfo, paramParcel.readInt());
    return localRedAppInfo;
  }
  
  public RedAppInfo[] a(int paramInt)
  {
    return new RedAppInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedAppInfo.1
 * JD-Core Version:    0.7.0.1
 */