package com.tencent.mobileqq.comment;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class DanmuItemBean$1
  implements Parcelable.Creator<DanmuItemBean>
{
  public DanmuItemBean a(Parcel paramParcel)
  {
    DanmuItemBean localDanmuItemBean = new DanmuItemBean();
    localDanmuItemBean.a = paramParcel.readLong();
    localDanmuItemBean.b = paramParcel.readLong();
    localDanmuItemBean.f = paramParcel.readLong();
    localDanmuItemBean.c = paramParcel.readLong();
    localDanmuItemBean.d = paramParcel.readString();
    localDanmuItemBean.e = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localDanmuItemBean.g = bool;
    localDanmuItemBean.h = paramParcel.readString();
    localDanmuItemBean.i = paramParcel.readInt();
    return localDanmuItemBean;
  }
  
  public DanmuItemBean[] a(int paramInt)
  {
    return new DanmuItemBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuItemBean.1
 * JD-Core Version:    0.7.0.1
 */