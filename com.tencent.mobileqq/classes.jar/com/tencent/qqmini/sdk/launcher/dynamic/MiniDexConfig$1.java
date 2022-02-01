package com.tencent.qqmini.sdk.launcher.dynamic;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MiniDexConfig$1
  implements Parcelable.Creator<MiniDexConfig>
{
  public MiniDexConfig createFromParcel(Parcel paramParcel)
  {
    return new MiniDexConfig(paramParcel);
  }
  
  public MiniDexConfig[] newArray(int paramInt)
  {
    return new MiniDexConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniDexConfig.1
 * JD-Core Version:    0.7.0.1
 */