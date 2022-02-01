package eipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class EIPCChannel$Stub
  extends Binder
  implements EIPCChannel
{
  private static final String DESCRIPTOR = "eipc.EIPCChannel";
  static final int TRANSACTION_async = 2;
  static final int TRANSACTION_callback = 6;
  static final int TRANSACTION_getProcName = 3;
  static final int TRANSACTION_setClient = 4;
  static final int TRANSACTION_setStubBinder = 5;
  static final int TRANSACTION_sync = 1;
  
  public EIPCChannel$Stub()
  {
    attachInterface(this, "eipc.EIPCChannel");
  }
  
  public static EIPCChannel asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("eipc.EIPCChannel");
    if ((localIInterface != null) && ((localIInterface instanceof EIPCChannel))) {
      return (EIPCChannel)localIInterface;
    }
    return new EIPCChannel.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1598968902)
    {
      Object localObject = null;
      String str1 = null;
      String str2 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 6: 
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        paramInt1 = paramParcel1.readInt();
        localObject = str2;
        if (paramParcel1.readInt() != 0) {
          localObject = (EIPCResult)EIPCResult.CREATOR.createFromParcel(paramParcel1);
        }
        callback(paramInt1, (EIPCResult)localObject);
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        paramParcel1 = setStubBinder(paramParcel1.readInt(), paramParcel1.readStrongBinder());
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        paramInt1 = setClient(paramParcel1.readString(), paramParcel1.readInt(), asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        paramParcel1 = getProcName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = async(str1, str2, (Bundle)localObject, paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      }
      paramParcel1.enforceInterface("eipc.EIPCChannel");
      str2 = paramParcel1.readString();
      String str3 = paramParcel1.readString();
      localObject = str1;
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = sync(str2, str3, (Bundle)localObject, paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    paramParcel2.writeString("eipc.EIPCChannel");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCChannel.Stub
 * JD-Core Version:    0.7.0.1
 */