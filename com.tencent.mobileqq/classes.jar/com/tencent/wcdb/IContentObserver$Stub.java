package com.tencent.wcdb;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IContentObserver$Stub
  extends Binder
  implements IContentObserver
{
  public IContentObserver$Stub()
  {
    attachInterface(this, "com.tencent.wcdb.IContentObserver");
  }
  
  public static IContentObserver a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.wcdb.IContentObserver");
    if ((localIInterface != null) && ((localIInterface instanceof IContentObserver))) {
      return (IContentObserver)localIInterface;
    }
    return new IContentObserver.Stub.Proxy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("com.tencent.wcdb.IContentObserver");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.wcdb.IContentObserver");
    boolean bool;
    if (paramParcel1.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    a(bool, paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.IContentObserver.Stub
 * JD-Core Version:    0.7.0.1
 */