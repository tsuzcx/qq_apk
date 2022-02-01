package com.tencent.mobileqq.pic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IPresendPicMgr$Stub
  extends Binder
  implements IPresendPicMgr
{
  public IPresendPicMgr$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.pic.IPresendPicMgr");
  }
  
  public static IPresendPicMgr a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
    if ((localIInterface != null) && ((localIInterface instanceof IPresendPicMgr))) {
      return (IPresendPicMgr)localIInterface;
    }
    return new IPresendPicMgr.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1598968902)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeIntArray(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeBooleanArray(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        paramInt1 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        a();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        a(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        a(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      boolean bool;
      if (paramParcel1.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      a(str1, str2, bool, paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel2.writeString("com.tencent.mobileqq.pic.IPresendPicMgr");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.IPresendPicMgr.Stub
 * JD-Core Version:    0.7.0.1
 */