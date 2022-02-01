package com.tencent.mobileqq.nearby.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class NearbyProcessInterface$Stub
  extends Binder
  implements NearbyProcessInterface
{
  public NearbyProcessInterface$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
  }
  
  public static NearbyProcessInterface a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
    if ((localIInterface != null) && ((localIInterface instanceof NearbyProcessInterface))) {
      return (NearbyProcessInterface)localIInterface;
    }
    return new NearbyProcessInterface.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Message)Message.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((Message)localObject1);
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
    paramParcel1.enforceInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (BasicTypeDataParcel)BasicTypeDataParcel.CREATOR.createFromParcel(paramParcel1);
    }
    paramParcel1 = a((BasicTypeDataParcel)localObject1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface.Stub
 * JD-Core Version:    0.7.0.1
 */