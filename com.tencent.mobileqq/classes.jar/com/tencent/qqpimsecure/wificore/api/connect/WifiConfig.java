package com.tencent.qqpimsecure.wificore.api.connect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class WifiConfig
  implements Parcelable
{
  public static final Parcelable.Creator<WifiConfig> CREATOR = new WifiConfig.1();
  protected ArrayList<WifiConfig.Psk> eA;
  protected ArrayList<WifiConfig.Eap> eB;
  public boolean eC = false;
  public int eD = -1;
  public int eE = 0;
  public int eF = 0;
  public int eG = 0;
  public String eH = "";
  private int eI = -1;
  public int eJ = -1;
  public boolean eK = false;
  public int eL = -1;
  public int eM = -1;
  public int en = -1;
  public int eq = -1;
  public String ey = "";
  public int ez = -1;
  
  public WifiConfig() {}
  
  public WifiConfig(Parcel paramParcel)
  {
    this.ey = paramParcel.readString();
    this.eA = paramParcel.readArrayList(WifiConfig.Psk.class.getClassLoader());
    this.eB = paramParcel.readArrayList(WifiConfig.Eap.class.getClassLoader());
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.eC = bool;
      this.ez = paramParcel.readInt();
      this.eD = paramParcel.readInt();
      this.eE = paramParcel.readInt();
      this.eH = paramParcel.readString();
      this.eG = paramParcel.readInt();
      this.eF = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public WifiConfig.Psk a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    if (this.eA == null) {
      this.eA = new ArrayList();
    }
    paramString = new WifiConfig.Psk(paramString, paramBoolean, paramInt1, paramInt2);
    this.eA.add(paramString);
    return paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WifiConfig [mSsid=" + this.ey + ", mSecurity=" + this.ez + " mWifiType=" + this.eE + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ey);
    paramParcel.writeList(this.eA);
    paramParcel.writeList(this.eB);
    if (this.eC) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.ez);
      paramParcel.writeInt(this.eD);
      paramParcel.writeInt(this.eE);
      paramParcel.writeString(this.eH);
      paramParcel.writeInt(this.eG);
      paramParcel.writeInt(this.eF);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.WifiConfig
 * JD-Core Version:    0.7.0.1
 */