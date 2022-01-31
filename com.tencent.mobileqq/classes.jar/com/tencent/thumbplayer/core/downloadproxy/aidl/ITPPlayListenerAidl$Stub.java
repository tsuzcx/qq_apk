package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ITPPlayListenerAidl$Stub
  extends Binder
  implements ITPPlayListenerAidl
{
  private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl";
  static final int TRANSACTION_getAdvRemainTime = 13;
  static final int TRANSACTION_getCurrentPlayClipNo = 12;
  static final int TRANSACTION_getCurrentPosition = 11;
  static final int TRANSACTION_getPlayInfo = 14;
  static final int TRANSACTION_getPlayerBufferLength = 10;
  static final int TRANSACTION_onDownloadCdnUrlExpired = 7;
  static final int TRANSACTION_onDownloadCdnUrlInfoUpdate = 6;
  static final int TRANSACTION_onDownloadCdnUrlUpdate = 5;
  static final int TRANSACTION_onDownloadError = 3;
  static final int TRANSACTION_onDownloadFinish = 2;
  static final int TRANSACTION_onDownloadProgressUpdate = 1;
  static final int TRANSACTION_onDownloadProtocolUpdate = 9;
  static final int TRANSACTION_onDownloadStatusUpdate = 8;
  static final int TRANSACTION_onPlayCallback = 4;
  
  public ITPPlayListenerAidl$Stub()
  {
    attachInterface(this, "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
  }
  
  public static ITPPlayListenerAidl asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
    if ((localIInterface != null) && ((localIInterface instanceof ITPPlayListenerAidl))) {
      return (ITPPlayListenerAidl)localIInterface;
    }
    return new ITPPlayListenerAidl.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    long l;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      onDownloadProgressUpdate(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      onDownloadFinish();
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      onDownloadError(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      paramInt1 = onPlayCallback(paramParcel1.readInt(), paramParcel1.readArrayList(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      onDownloadCdnUrlUpdate(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      onDownloadCdnUrlInfoUpdate(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      onDownloadCdnUrlExpired(paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      onDownloadStatusUpdate(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      onDownloadProtocolUpdate(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      l = getPlayerBufferLength();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      l = getCurrentPosition();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      paramInt1 = getCurrentPlayClipNo();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      l = getAdvRemainTime();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
    paramParcel1 = getPlayInfo(paramParcel1.readString());
    paramParcel2.writeNoException();
    paramParcel2.writeString(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl.Stub
 * JD-Core Version:    0.7.0.1
 */