package com.tencent.qqmini.sdk.launcher.model;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.MiniSDK;

public class ShareData
  implements Parcelable
{
  public static final Parcelable.Creator<ShareData> CREATOR = new ShareData.1();
  protected static final String TAG = "ShareData";
  public boolean isLocalPic;
  protected MiniAppInfo miniAppInfo;
  public boolean needShareCallback;
  public boolean shareInMiniProcess;
  public int shareItemId;
  public String sharePicPath;
  public int shareSource;
  public int shareTarget;
  public String summary;
  public String targetUrl;
  public String title;
  
  protected ShareData() {}
  
  public ShareData(Parcel paramParcel)
  {
    this.shareSource = paramParcel.readInt();
    this.shareTarget = paramParcel.readInt();
    this.shareItemId = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.summary = paramParcel.readString();
    this.sharePicPath = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.isLocalPic = bool1;
    this.targetUrl = paramParcel.readString();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.needShareCallback = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.shareInMiniProcess = bool1;
    this.miniAppInfo = ((MiniAppInfo)paramParcel.readParcelable(MiniAppInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMiniAppIconUrl()
  {
    return this.miniAppInfo.iconUrl;
  }
  
  public String getMiniAppId()
  {
    return this.miniAppInfo.appId;
  }
  
  public String getMiniAppName()
  {
    return this.miniAppInfo.name;
  }
  
  public void notifyShareResult(Context paramContext, int paramInt)
  {
    notifyShareResult(paramContext, paramInt, false);
  }
  
  public void notifyShareResult(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if ((this.needShareCallback) || (paramBoolean))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_share_result", paramInt);
      MiniSDK.notifyShareResult(paramContext, this.miniAppInfo, localBundle);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ShareData
 * JD-Core Version:    0.7.0.1
 */