package com.tencent.mobileqq.mini.sdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.module.base.QDLog;

final class BaseLibInfo$1
  implements Parcelable.Creator<BaseLibInfo>
{
  public BaseLibInfo createFromParcel(Parcel paramParcel)
  {
    BaseLibInfo localBaseLibInfo = new BaseLibInfo();
    try
    {
      paramParcel = new BaseLibInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt());
      return paramParcel;
    }
    catch (Throwable paramParcel)
    {
      QDLog.e("miniapp", "BaseLibInfo createFromParcel exception!", paramParcel);
    }
    return localBaseLibInfo;
  }
  
  public BaseLibInfo[] newArray(int paramInt)
  {
    return new BaseLibInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.BaseLibInfo.1
 * JD-Core Version:    0.7.0.1
 */