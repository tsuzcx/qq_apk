package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class LaunchParam$1
  implements Parcelable.Creator<LaunchParam>
{
  public LaunchParam createFromParcel(Parcel paramParcel)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    try
    {
      localLaunchParam.createFrom(paramParcel);
      return localLaunchParam;
    }
    catch (Throwable paramParcel)
    {
      QMLog.e("miniapp", "LaunchParam createFromParcel exception!", paramParcel);
    }
    return localLaunchParam;
  }
  
  public LaunchParam[] newArray(int paramInt)
  {
    return new LaunchParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.LaunchParam.1
 * JD-Core Version:    0.7.0.1
 */