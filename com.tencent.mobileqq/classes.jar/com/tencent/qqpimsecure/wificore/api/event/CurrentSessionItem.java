package com.tencent.qqpimsecure.wificore.api.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class CurrentSessionItem
  implements Parcelable
{
  public static final Parcelable.Creator<CurrentSessionItem> CREATOR = new CurrentSessionItem.1();
  public long eU = -1L;
  public int eV = -1;
  public int eW = -1;
  public int eX = -1;
  public boolean eY = false;
  public boolean eZ = false;
  public String ey = "";
  public boolean fa = false;
  
  public CurrentSessionItem() {}
  
  private CurrentSessionItem(Parcel paramParcel)
  {
    this.eU = paramParcel.readLong();
    this.ey = paramParcel.readString();
    this.eV = paramParcel.readInt();
    this.eW = paramParcel.readInt();
    this.eX = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.eY = bool1;
      if (paramParcel.readInt() != 1) {
        break label140;
      }
      bool1 = true;
      label114:
      this.eZ = bool1;
      if (paramParcel.readInt() != 1) {
        break label145;
      }
    }
    label140:
    label145:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.fa = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label114;
    }
  }
  
  public static final String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      switch (paramInt2)
      {
      default: 
        return "NOTAVILABLE";
      case -1: 
        return "NOTAVILABLE";
      case 3: 
        return "AUTHENTICATING";
      case 4: 
        return "OBTAINING_IPADDR";
      case 11: 
        return "CAPTIVE_PORTAL_CHECK";
      case 12: 
        return "VERIFYING_POOR_LINK";
      case 0: 
        return "IDLE";
      case 1: 
        return "SCANNING";
      case 2: 
        return "CONNECTING";
      case 5: 
        return "CONNECTED";
      case 8: 
        return "DISCONNECTED";
      case 7: 
        return "DISCONNECTING";
      case 9: 
        return "FAILED";
      case 10: 
        return "BLOCKED";
      }
      return "SUSPENDED";
    }
    switch (paramInt2)
    {
    default: 
      return "CONNECTED_DETAIL_STAT.unknow";
    case 4097: 
      return "CONNECTED_DETAIL_STAT.AVILABLE";
    case 4096: 
      return "CONNECTED_DETAIL_STAT.NOTAVILABLE";
    case 4098: 
      return "CONNECTED_DETAIL_STAT.CHECKING";
    case 4100: 
      return "CONNECTED_DETAIL_STAT.CHECKED_AVILABLE";
    case 4101: 
      return "CONNECTED_DETAIL_STAT.CHECKED_NEED_APPROVE";
    }
    return "CONNECTED_DETAIL_STAT.CHECKED_NOT_AVILABLE";
  }
  
  public static String o(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return "unavilable";
    case 1: 
      return "CONNECTED";
    case 0: 
      return "CONNECTING";
    case 4: 
      return "DISCONNECTED";
    }
    return "FAIL";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof CurrentSessionItem))) {}
    do
    {
      return false;
      paramObject = (CurrentSessionItem)paramObject;
    } while ((!TextUtils.equals(this.ey, paramObject.ey)) || (this.eV != paramObject.eV) || (this.eW != paramObject.eW) || (this.eX != paramObject.eX));
    return true;
  }
  
  public boolean isConnected()
  {
    return this.eW == 1;
  }
  
  public CurrentSessionItem l()
  {
    CurrentSessionItem localCurrentSessionItem = new CurrentSessionItem();
    localCurrentSessionItem.eU = this.eU;
    localCurrentSessionItem.ey = this.ey;
    localCurrentSessionItem.eV = this.eV;
    localCurrentSessionItem.eW = this.eW;
    localCurrentSessionItem.eX = this.eX;
    localCurrentSessionItem.eY = this.eY;
    localCurrentSessionItem.eZ = this.eZ;
    localCurrentSessionItem.fa = this.fa;
    return localCurrentSessionItem;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CurrentSessionItem ");
    localStringBuilder.append(" mSeqNum:");
    localStringBuilder.append(this.eU);
    localStringBuilder.append(" mName:");
    localStringBuilder.append(this.ey);
    localStringBuilder.append(" mSecurityType:");
    localStringBuilder.append(this.eV);
    localStringBuilder.append(" mConnectByWifiManager:");
    localStringBuilder.append(this.eY);
    localStringBuilder.append(" mCurrentStat:");
    localStringBuilder.append(o(this.eW));
    localStringBuilder.append(" mCurrentDetailStat:");
    localStringBuilder.append(a(this.eW, this.eX));
    localStringBuilder.append(" mIsTimeOut:");
    localStringBuilder.append(this.eZ);
    localStringBuilder.append(" mIsNewConfigConnecting:");
    localStringBuilder.append(this.fa);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.eU);
    String str;
    if (this.ey != null)
    {
      str = this.ey;
      paramParcel.writeString(str);
      paramParcel.writeInt(this.eV);
      paramParcel.writeInt(this.eW);
      paramParcel.writeInt(this.eX);
      if (!this.eY) {
        break label103;
      }
      paramInt = 1;
      label62:
      paramParcel.writeInt(paramInt);
      if (!this.eZ) {
        break label108;
      }
      paramInt = 1;
      label76:
      paramParcel.writeInt(paramInt);
      if (!this.fa) {
        break label113;
      }
    }
    label103:
    label108:
    label113:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      str = "";
      break;
      paramInt = 0;
      break label62;
      paramInt = 0;
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem
 * JD-Core Version:    0.7.0.1
 */