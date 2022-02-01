package com.tencent.qqpimsecure.wificore.api.connect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WifiConfig$Psk
  implements Parcelable
{
  public static final Parcelable.Creator<Psk> CREATOR = new WifiConfig.Psk.1();
  protected boolean eP = false;
  public int eQ = 0;
  protected String eR;
  public int eS = 0;
  public int eT = 0;
  
  public WifiConfig$Psk(Parcel paramParcel)
  {
    this.eR = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.eP = bool;
      this.eQ = paramParcel.readInt();
      this.eS = paramParcel.readInt();
      this.eT = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public WifiConfig$Psk(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.eR = paramString;
    this.eP = paramBoolean;
    this.eS = paramInt1;
    this.eT = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Psk))) {}
    do
    {
      return false;
      paramObject = (Psk)paramObject;
    } while ((paramObject.eP != this.eP) || (paramObject.eR.compareTo(this.eR) != 0));
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.eR);
    if (this.eP) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.eQ);
      paramParcel.writeInt(this.eS);
      paramParcel.writeInt(this.eT);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.WifiConfig.Psk
 * JD-Core Version:    0.7.0.1
 */