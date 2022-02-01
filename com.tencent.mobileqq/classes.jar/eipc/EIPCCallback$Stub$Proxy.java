package eipc;

import android.os.IBinder;
import android.os.Parcel;

class EIPCCallback$Stub$Proxy
  implements EIPCCallback
{
  private IBinder mRemote;
  
  EIPCCallback$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void callback(EIPCResult paramEIPCResult)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("eipc.EIPCCallback");
      if (paramEIPCResult != null)
      {
        localParcel1.writeInt(1);
        paramEIPCResult.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "eipc.EIPCCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCCallback.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */