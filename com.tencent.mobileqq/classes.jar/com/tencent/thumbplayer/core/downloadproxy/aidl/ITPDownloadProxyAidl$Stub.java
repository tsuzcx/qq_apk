package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ITPDownloadProxyAidl$Stub
  extends Binder
  implements ITPDownloadProxyAidl
{
  private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl";
  static final int TRANSACTION_getClipPlayUrl = 6;
  static final int TRANSACTION_getPlayErrorCodeStr = 7;
  static final int TRANSACTION_getPlayUrl = 5;
  static final int TRANSACTION_init = 1;
  static final int TRANSACTION_pauseDownload = 9;
  static final int TRANSACTION_pushEvent = 14;
  static final int TRANSACTION_resumeDownload = 10;
  static final int TRANSACTION_setBusinessDownloadStrategy = 17;
  static final int TRANSACTION_setClipInfo = 4;
  static final int TRANSACTION_setMaxStorageSizeMB = 16;
  static final int TRANSACTION_setPlayState = 15;
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
    String str1 = null;
    String str2 = null;
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      paramInt1 = init(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (TPDownloadParamAidl)TPDownloadParamAidl.CREATOR.createFromParcel(paramParcel1);
      }
      paramInt1 = startPlay(str1, (TPDownloadParamAidl)localObject, ITPPlayListenerAidl.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      paramInt1 = startClipPlay(paramParcel1.readString(), paramParcel1.readInt(), ITPPlayListenerAidl.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      str2 = paramParcel1.readString();
      localObject = str1;
      if (paramParcel1.readInt() != 0) {
        localObject = (TPDownloadParamAidl)TPDownloadParamAidl.CREATOR.createFromParcel(paramParcel1);
      }
      boolean bool = setClipInfo(paramInt1, paramInt2, str2, (TPDownloadParamAidl)localObject);
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      paramParcel1 = getPlayUrl(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      paramParcel1 = getClipPlayUrl(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      paramParcel1 = getPlayErrorCodeStr(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      stopPlay(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      paramInt1 = pauseDownload(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      paramInt1 = resumeDownload(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      str1 = paramParcel1.readString();
      localObject = str2;
      if (paramParcel1.readInt() != 0) {
        localObject = (TPDownloadParamAidl)TPDownloadParamAidl.CREATOR.createFromParcel(paramParcel1);
      }
      paramInt1 = startPreload(str1, (TPDownloadParamAidl)localObject, ITPPreLoadListenerAidl.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      stopPreload(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      setUserData(paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      pushEvent(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      setPlayState(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      setMaxStorageSizeMB(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
    setBusinessDownloadStrategy(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl.Stub
 * JD-Core Version:    0.7.0.1
 */