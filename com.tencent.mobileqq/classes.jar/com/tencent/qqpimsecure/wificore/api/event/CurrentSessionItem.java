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
  public boolean eY;
  public boolean eZ;
  public String ey = "";
  public boolean fa;
  
  public CurrentSessionItem()
  {
    this.eY = false;
    this.eZ = false;
    this.fa = false;
  }
  
  private CurrentSessionItem(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.eY = false;
    this.eZ = false;
    this.fa = false;
    this.eU = paramParcel.readLong();
    this.ey = paramParcel.readString();
    this.eV = paramParcel.readInt();
    this.eW = paramParcel.readInt();
    this.eX = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.eY = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.eZ = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.fa = bool1;
  }
  
  public static final String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      String str = "NOTAVILABLE";
      switch (paramInt2)
      {
      default: 
        return "NOTAVILABLE";
      case 12: 
        return "VERIFYING_POOR_LINK";
      case 11: 
        return "CAPTIVE_PORTAL_CHECK";
      case 10: 
        return "BLOCKED";
      case 9: 
        return "FAILED";
      case 8: 
        return "DISCONNECTED";
      case 7: 
        return "DISCONNECTING";
      case 6: 
        return "SUSPENDED";
      case 5: 
        return "CONNECTED";
      case 4: 
        return "OBTAINING_IPADDR";
      case 3: 
        return "AUTHENTICATING";
      case 2: 
        return "CONNECTING";
      case 1: 
        return "SCANNING";
      case 0: 
        str = "IDLE";
      }
      return str;
    }
    switch (paramInt2)
    {
    default: 
      return "CONNECTED_DETAIL_STAT.unknow";
    case 4101: 
      return "CONNECTED_DETAIL_STAT.CHECKED_NEED_APPROVE";
    case 4100: 
      return "CONNECTED_DETAIL_STAT.CHECKED_AVILABLE";
    case 4099: 
      return "CONNECTED_DETAIL_STAT.CHECKED_NOT_AVILABLE";
    case 4098: 
      return "CONNECTED_DETAIL_STAT.CHECKING";
    case 4097: 
      return "CONNECTED_DETAIL_STAT.AVILABLE";
    }
    return "CONNECTED_DETAIL_STAT.NOTAVILABLE";
  }
  
  public static String o(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "unavilable";
          }
          return "DISCONNECTED";
        }
        return "FAIL";
      }
      return "CONNECTED";
    }
    return "CONNECTING";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof CurrentSessionItem)) {
        return false;
      }
      paramObject = (CurrentSessionItem)paramObject;
      bool1 = bool2;
      if (TextUtils.equals(this.ey, paramObject.ey))
      {
        bool1 = bool2;
        if (this.eV == paramObject.eV)
        {
          bool1 = bool2;
          if (this.eW == paramObject.eW)
          {
            bool1 = bool2;
            if (this.eX == paramObject.eX) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem
 * JD-Core Version:    0.7.0.1
 */