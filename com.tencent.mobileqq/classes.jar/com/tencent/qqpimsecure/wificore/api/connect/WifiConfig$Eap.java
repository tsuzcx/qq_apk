package com.tencent.qqpimsecure.wificore.api.connect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WifiConfig$Eap
  implements Parcelable
{
  public static final Parcelable.Creator<WifiConfig.Psk> CREATOR = new WifiConfig.Eap.1();
  protected String eN;
  protected String eO;
  protected boolean eP;
  public int eQ;
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Eap))) {}
    do
    {
      return false;
      paramObject = (Eap)paramObject;
    } while ((paramObject.eP != this.eP) || (paramObject.eN.compareTo(this.eN) != 0) || (paramObject.eO.compareTo(this.eO) != 0));
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.eN);
    paramParcel.writeString(this.eO);
    if (this.eP) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.eQ);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.WifiConfig.Eap
 * JD-Core Version:    0.7.0.1
 */