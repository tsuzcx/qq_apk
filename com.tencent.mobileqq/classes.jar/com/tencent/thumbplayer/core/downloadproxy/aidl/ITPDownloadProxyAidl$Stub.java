package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ITPDownloadProxyAidl$Stub
  extends Binder
  implements ITPDownloadProxyAidl
{
  private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl";
  static final int TRANSACTION_getClipPlayUrl = 6;
  static final int TRANSACTION_getNativeInfo = 14;
  static final int TRANSACTION_getPlayErrorCodeStr = 7;
  static final int TRANSACTION_getPlayUrl = 5;
  static final int TRANSACTION_init = 1;
  static final int TRANSACTION_pauseDownload = 9;
  static final int TRANSACTION_pushEvent = 15;
  static final int TRANSACTION_resumeDownload = 10;
  static final int TRANSACTION_setBusinessDownloadStrategy = 18;
  static final int TRANSACTION_setClipInfo = 4;
  static final int TRANSACTION_setMaxStorageSizeMB = 17;
  static final int TRANSACTION_setPlayState = 16;
  static final int TRANSACTION_setUpdatePlayerInfoInterval = 19;
  static final int TRANSACTION_setUserData = 13;
  static final int TRANSACTION_startClipPlay = 3;
  static final int TRANSACTION_startPlay = 2;
  static final int TRANSACTION_startPreload = 11;
  static final int TRANSACTION_stopPlay = 8;
  static final int TRANSACTION_stopPreload = 12;
  
  public ITPDownloadProxyAidl$Stub()
  {
    attachInterface(this, "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
  }
  
  public static ITPDownloadProxyAidl asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
    if ((localIInterface != null) && ((localIInterface instanceof ITPDownloadProxyAidl))) {
      return (ITPDownloadProxyAidl)localIInterface;
    }
    return new ITPDownloadProxyAidl.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl.Stub
 * JD-Core Version:    0.7.0.1
 */