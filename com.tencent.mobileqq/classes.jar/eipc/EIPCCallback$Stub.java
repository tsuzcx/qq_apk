package eipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class EIPCCallback$Stub
  extends Binder
  implements EIPCCallback
{
  private static final String DESCRIPTOR = "eipc.EIPCCallback";
  static final int TRANSACTION_callback = 1;
  
  public EIPCCallback$Stub()
  {
    attachInterface(this, "eipc.EIPCCallback");
  }
  
  public static EIPCCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("eipc.EIPCCallback");
    if ((localIInterface != null) && ((localIInterface instanceof EIPCCallback))) {
      return (EIPCCallback)localIInterface;
    }
    return new EIPCCallback.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("eipc.EIPCCallback");
      return true;
    }
    paramParcel1.enforceInterface("eipc.EIPCCallback");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (EIPCResult)EIPCResult.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      callback(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCCallback.Stub
 * JD-Core Version:    0.7.0.1
 */