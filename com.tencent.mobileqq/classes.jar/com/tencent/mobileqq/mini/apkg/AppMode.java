package com.tencent.mobileqq.mini.apkg;

import NS_MINI_INTERFACE.INTERFACE.StAppMode;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.PBBoolField;

public class AppMode
  implements Parcelable
{
  public static final Parcelable.Creator<AppMode> CREATOR = new AppMode.1();
  public boolean authoritySilent;
  public boolean closeTopRightCapsule;
  public boolean disableAddToMyApp;
  public boolean disableAddToMyFavor;
  public boolean disableShareToAIO;
  public boolean disableShareToQZone;
  public boolean disableShareToWeChat;
  public boolean hideAppSearch;
  public boolean interMode;
  public boolean isAppStore;
  public boolean isInterLoading;
  public boolean isLimitedAccess;
  public boolean isPayForFriend;
  public boolean isWangKa;
  public boolean keepOffPullList;
  public boolean openNativeApi;
  public boolean reloadWithFirstPageChange;
  public boolean unlimitedApiRight;
  public boolean useAppInfoWhenNavigate;
  
  public static AppMode from(INTERFACE.StAppMode paramStAppMode)
  {
    AppMode localAppMode = new AppMode();
    if (paramStAppMode != null)
    {
      localAppMode.interMode = paramStAppMode.interMode.get();
      localAppMode.authoritySilent = paramStAppMode.authoritySilent.get();
      localAppMode.keepOffPullList = paramStAppMode.keepOffPullList.get();
      localAppMode.closeTopRightCapsule = paramStAppMode.closeTopRightCapsule.get();
      localAppMode.openNativeApi = paramStAppMode.openNativeApi.get();
      localAppMode.hideAppSearch = paramStAppMode.hideAppSearch.get();
      localAppMode.isAppStore = paramStAppMode.isAppStore.get();
      localAppMode.isWangKa = paramStAppMode.isWangKa.get();
      localAppMode.isInterLoading = paramStAppMode.interLoading.get();
      localAppMode.isLimitedAccess = paramStAppMode.isLimitedAccess.get();
      localAppMode.isPayForFriend = paramStAppMode.isPayForFriend.get();
      localAppMode.useAppInfoWhenNavigate = paramStAppMode.useAppInfoWhenNavigate.get();
      localAppMode.disableAddToMyApp = paramStAppMode.disableAddToMyApp.get();
      localAppMode.disableAddToMyFavor = paramStAppMode.disableAddToMyFavor.get();
      localAppMode.reloadWithFirstPageChange = paramStAppMode.reloadWithFirstPageChange.get();
      localAppMode.unlimitedApiRight = paramStAppMode.unlimitedApiRight.get();
      localAppMode.disableShareToAIO = paramStAppMode.disableShareToAIO.get();
      localAppMode.disableShareToQZone = paramStAppMode.disableShareToQZone.get();
      localAppMode.disableShareToWeChat = paramStAppMode.disableShareToWeChat.get();
    }
    return localAppMode;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.AppMode
 * JD-Core Version:    0.7.0.1
 */