package cooperation.qqindividuality.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class IQQIndividualityRemoteProxyInterface$Stub$Proxy
  implements IQQIndividualityRemoteProxyInterface
{
  private IBinder a;
  
  IQQIndividualityRemoteProxyInterface$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
      localParcel1.writeInt(paramInt);
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */