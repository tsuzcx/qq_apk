package cooperation.qqindividuality.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IQQIndividualityRemoteProxyInterface$Stub
  extends Binder
  implements IQQIndividualityRemoteProxyInterface
{
  public IQQIndividualityRemoteProxyInterface$Stub()
  {
    attachInterface(this, "cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
  }
  
  public static IQQIndividualityRemoteProxyInterface a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
    if ((localIInterface != null) && ((localIInterface instanceof IQQIndividualityRemoteProxyInterface))) {
      return (IQQIndividualityRemoteProxyInterface)localIInterface;
    }
    return new IQQIndividualityRemoteProxyInterface.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
    paramInt1 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    a(paramInt1, paramParcel1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface.Stub
 * JD-Core Version:    0.7.0.1
 */