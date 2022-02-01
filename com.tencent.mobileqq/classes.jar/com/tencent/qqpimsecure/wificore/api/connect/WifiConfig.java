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
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.eC = bool;
    this.ez = paramParcel.readInt();
    this.eD = paramParcel.readInt();
    this.eE = paramParcel.readInt();
    this.eH = paramParcel.readString();
    this.eG = paramParcel.readInt();
    this.eF = paramParcel.readInt();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WifiConfig [mSsid=");
    localStringBuilder.append(this.ey);
    localStringBuilder.append(", mSecurity=");
    localStringBuilder.append(this.ez);
    localStringBuilder.append(" mWifiType=");
    localStringBuilder.append(this.eE);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.WifiConfig
 * JD-Core Version:    0.7.0.1
 */