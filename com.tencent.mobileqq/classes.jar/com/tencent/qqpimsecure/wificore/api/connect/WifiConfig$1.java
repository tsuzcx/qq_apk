package com.tencent.qqpimsecure.wificore.api.connect;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WifiConfig$1
  implements Parcelable.Creator<WifiConfig>
{
  public WifiConfig c(Parcel paramParcel)
  {
    return new WifiConfig(paramParcel);
  }
  
  public WifiConfig[] m(int paramInt)
  {
    return new WifiConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.WifiConfig.1
 * JD-Core Version:    0.7.0.1
 */