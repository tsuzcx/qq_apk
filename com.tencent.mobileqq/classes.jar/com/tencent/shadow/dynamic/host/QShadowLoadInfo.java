package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QShadowLoadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QShadowLoadInfo> CREATOR = new QShadowLoadInfo.1();
  public final long appCreateTime;
  public final long bindServiceTime;
  public final boolean isHotLaunch;
  public final long loadLoaderTime;
  public final long loadPluginTime;
  public final long loadRuntimeTime;
  
  public QShadowLoadInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    this.loadRuntimeTime = paramLong1;
    this.loadLoaderTime = paramLong2;
    this.loadPluginTime = paramLong3;
    this.bindServiceTime = paramLong4;
    this.appCreateTime = paramLong5;
    this.isHotLaunch = paramBoolean;
  }
  
  protected QShadowLoadInfo(Parcel paramParcel)
  {
    this.loadRuntimeTime = paramParcel.readLong();
    this.loadLoaderTime = paramParcel.readLong();
    this.loadPluginTime = paramParcel.readLong();
    this.bindServiceTime = paramParcel.readLong();
    this.appCreateTime = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.isHotLaunch = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QShadowLoadInfo{loadRuntimeTime=");
    localStringBuilder.append(this.loadRuntimeTime);
    localStringBuilder.append(", loadLoaderTime=");
    localStringBuilder.append(this.loadLoaderTime);
    localStringBuilder.append(", loadPluginTime=");
    localStringBuilder.append(this.loadPluginTime);
    localStringBuilder.append(", bindServiceTime=");
    localStringBuilder.append(this.bindServiceTime);
    localStringBuilder.append(", appCreateTime=");
    localStringBuilder.append(this.appCreateTime);
    localStringBuilder.append(", isHotLaunch=");
    localStringBuilder.append(this.isHotLaunch);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.QShadowLoadInfo
 * JD-Core Version:    0.7.0.1
 */